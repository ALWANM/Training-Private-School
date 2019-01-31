/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.service;

import fr.utbm.core.CourseSession;
import fr.utbm.repository.HibernateCourseSessionDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author m-alwan
 */
public class CourseSessionService {

    public List<CourseSession> getAllCourseSessionService() {
        HibernateCourseSessionDao hbcsdao = new HibernateCourseSessionDao();
        return hbcsdao.getAllCourseSession();
    }

    public List<CourseSession> getAllCourseSessionFromTitleService(String title) {
        HibernateCourseSessionDao hbcsdao = new HibernateCourseSessionDao();
        return hbcsdao.getAllCourseSessionFromTitle(title);
    }

    public List<CourseSession> getAllCourseSessionFromDateStartService(Date date) {
        HibernateCourseSessionDao hbcsdao = new HibernateCourseSessionDao();
        return hbcsdao.getAllCourseSessionFromStartDate(date);
    }

    public List<CourseSession> getAllCourseSessionFromEndDateService(Date date) {
        HibernateCourseSessionDao hbcsdao = new HibernateCourseSessionDao();
        return hbcsdao.getAllCourseSessionFromEndDate(date);
    }

    public List<CourseSession> getAllCourseSessionFromLocationService(String city) {
        HibernateCourseSessionDao hbcsdao = new HibernateCourseSessionDao();
        return hbcsdao.getAllCourseSessionFromLocation(city);
    }
    public CourseSession getCourseSessionFromIdService(int id) {
       HibernateCourseSessionDao hbcsdao = new HibernateCourseSessionDao();
        return hbcsdao.getCourseSessionFromId(id); 
    }
    
}
