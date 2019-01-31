/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.core.Course;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author m-alwan
 */
public class HibernateCourseDao {

    private Session session;
    private Transaction transaction;

    public List<Course> getAllCourseFromCode(String code) {
        List<Course> course = new ArrayList<Course>();
        try {
            session = new AnnotationConfiguration()
                    .configure().buildSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Course cs where cs.code=:searchTitle");
            query.setParameter("searchTitle", code);
            course = query.list();
            transaction.commit();
            session.close();

        } catch (HibernateException ex) {
            System.out.println("coursesession" + ex.getMessage());
        }
        return course;

    }

}
