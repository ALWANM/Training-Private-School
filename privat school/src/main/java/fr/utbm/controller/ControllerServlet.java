/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.controller;

import fr.utbm.core.CourseSession;
import fr.utbm.core.Location;
import fr.utbm.service.CourseSessionService;
import fr.utbm.service.LocationService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author m-alwan
 */
@WebServlet(
        name = "Servlet",
        description = "A sample annotated servlet",
        urlPatterns = {"/controller"}
)
public class ControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            CourseSessionService coursesessionservice = new CourseSessionService();
            LocationService locationservice = new LocationService();
            List<CourseSession> courseSession = coursesessionservice.getAllCourseSessionService();
            request.setAttribute("model", courseSession);
            List<Location> location = locationservice.getAllLocationService();
            request.setAttribute("location", location);
            request.getRequestDispatcher("WEB-INF/jsp/VueSession.jsp").
                    forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("WEB-INF/jsp/ShowError.jsp").
                    forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseSessionService coursesessionservice = new CourseSessionService();
        LocationService locationservice = new LocationService();
        List<CourseSession> courseSession = new ArrayList<>();
        List<Location> location = new ArrayList<>();
        if (request.getParameter("btnSearchTitle") != null) {
            try {
                String title = request.getParameter("courseTitle");
                if (!title.isEmpty()) {
                    courseSession = coursesessionservice.getAllCourseSessionFromTitleService(title);
                    request.setAttribute("model", courseSession);
                    location = locationservice.getAllLocationService();
                    request.setAttribute("location", location);
                    request.getRequestDispatcher("WEB-INF/jsp/VueSession.jsp").
                            forward(request, response);
                } else {

                    processRequest(request, response);
                }
            } catch (IOException | ServletException e) {
                request.getRequestDispatcher("WEB-INF/jsp/ShowError.jsp").
                        forward(request, response);
            }

        }
        if (request.getParameter("btnSearchStartDate") != null) {
            try {
                String date1 = request.getParameter("startDate");
                if (!date1.isEmpty()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    Date date = simpleDateFormat.parse(date1);
                    courseSession = coursesessionservice.getAllCourseSessionFromDateStartService(date);
                    request.setAttribute("model", courseSession);
                    location = locationservice.getAllLocationService();
                    request.setAttribute("location", location);
                    request.getRequestDispatcher("WEB-INF/jsp/VueSession.jsp").
                            forward(request, response);
                } else {
                    processRequest(request, response);
                }
            } catch (IOException | ParseException | ServletException e) {
                request.getRequestDispatcher("WEB-INF/jsp/ShowError.jsp").
                        forward(request, response);
            }
        }
        if (request.getParameter("btnSearchEndDate") != null) {
            try {
                String date1 = request.getParameter("endDate");
                if (!date1.isEmpty()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    Date date = simpleDateFormat.parse(date1);
                    courseSession = coursesessionservice.getAllCourseSessionFromDateStartService(date);
                    request.setAttribute("model", courseSession);
                    location = locationservice.getAllLocationService();
                    request.setAttribute("location", location);
                    request.getRequestDispatcher("WEB-INF/jsp/VueSession.jsp").
                            forward(request, response);
                } else {
                    processRequest(request, response);
                }
            } catch (IOException | ParseException | ServletException e) {
                request.getRequestDispatcher("WEB-INF/jsp/ShowError.jsp").
                        forward(request, response);
            }

        }
        if (request.getParameter("btnSearchCity") != null) {
            try {
                String city = request.getParameter("City");
                request.setAttribute("TextValue", city);
                courseSession = coursesessionservice.getAllCourseSessionFromLocationService(city);
                request.setAttribute("model", courseSession);
                location = locationservice.getAllLocationService();
                request.setAttribute("location", location);
                request.getRequestDispatcher("WEB-INF/jsp/VueSession.jsp").
                        forward(request, response);
            } catch (IOException | ServletException e) {
                request.getRequestDispatcher("WEB-INF/jsp/ShowError.jsp").
                        forward(request, response);
            }
        }
        processRequest(request, response);

    }

}
