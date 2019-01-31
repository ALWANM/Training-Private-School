/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.service;

import fr.utbm.core.Course;
import fr.utbm.repository.HibernateCourseDao;
import java.util.List;

/**
 *
 * @author m-alwan
 */
public class CourseService {
    public List<Course> getAllCourseFromCodeService(String code) {
        HibernateCourseDao hbcdao=new HibernateCourseDao();
        return hbcdao.getAllCourseFromCode(code);
    }
}
