/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.core.CourseSession;
import fr.utbm.core.Location;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author m-alwan
 */
public class HibernateCourseSessionDao {

    private Session session;
    private Transaction transaction;

    public List<CourseSession> getAllCourseSession() {
        List<CourseSession> coursesession = new ArrayList<CourseSession>();
        try {
            session = new AnnotationConfiguration()
                    .configure().buildSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM CourseSession");
            coursesession = query.list();
            Iterator<CourseSession> it = coursesession.iterator();
            while (it.hasNext()) {
                CourseSession cs = it.next();
                Hibernate.initialize(cs.getLocation());
                Hibernate.initialize(cs.getCourse());
            }
            transaction.commit();
            session.close();

        } catch (HibernateException ex) {
            System.out.println("coursesession" + ex.getMessage());

        }
        return coursesession;

    }

    public List<CourseSession> getAllCourseSessionFromStartDate(Date date) {
        List<CourseSession> coursesession = new ArrayList<CourseSession>();
        try {
            session = new AnnotationConfiguration()
                    .configure().buildSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM CourseSession where startDate>=:searchDate  ORDER BY startDate");
            query.setParameter("searchDate", date);
            coursesession = query.list();
            Iterator<CourseSession> it = coursesession.iterator();
            while (it.hasNext()) {
                CourseSession cs = it.next();
                Hibernate.initialize(cs.getLocation());
                Hibernate.initialize(cs.getCourse());
            }
            transaction.commit();
            session.close();

        } catch (HibernateException ex) {
            System.out.println("coursesession" + ex.getMessage());

        }
        return coursesession;

    }

    public List<CourseSession> getAllCourseSessionFromEndDate(Date date) {
        List<CourseSession> coursesession = new ArrayList<CourseSession>();
        try {
            session = new AnnotationConfiguration()
                    .configure().buildSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM CourseSession where startDate<=:searchDate  ORDER BY startDate");
            query.setParameter("searchDate", date);
            coursesession = query.list();
            Iterator<CourseSession> it = coursesession.iterator();
            while (it.hasNext()) {
                CourseSession cs = it.next();
                Hibernate.initialize(cs.getLocation());
                Hibernate.initialize(cs.getCourse());
            }
            transaction.commit();
            session.close();

        } catch (HibernateException ex) {
            System.out.println("coursesession" + ex.getMessage());
        }
        return coursesession;
    }

    public List<CourseSession> getAllCourseSessionFromLocation(String city) {
        List<CourseSession> coursesession = new ArrayList<CourseSession>();
        try {
            session = new AnnotationConfiguration()
                    .configure().buildSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM CourseSession cs WHERE cs.location.city=:searchcity");
            query.setParameter("searchcity", city);
            coursesession = query.list();
            Iterator<CourseSession> it = coursesession.iterator();
            while (it.hasNext()) {
                CourseSession cs = it.next();
                Hibernate.initialize(cs.getLocation());
                Hibernate.initialize(cs.getCourse());
            }
            transaction.commit();
            session.close();

        } catch (HibernateException ex) {
            System.out.println("coursesession" + ex.getMessage());
        }
        return coursesession;
    }

    public List<CourseSession> getAllCourseSessionFromTitle(String title) {
        List<CourseSession> coursesession = new ArrayList<CourseSession>();
        try {
            session = new AnnotationConfiguration()
                    .configure().buildSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM CourseSession cs where cs.course.title Like :searchTitle");
            query.setParameter("searchTitle", "%" + title + "%");
            coursesession = query.list();
            Iterator<CourseSession> it = coursesession.iterator();
            while (it.hasNext()) {
                CourseSession cs = it.next();
                Hibernate.initialize(cs.getLocation());
                Hibernate.initialize(cs.getCourse());
            }
            transaction.commit();
            session.close();

        } catch (HibernateException ex) {
            System.out.println("coursesession" + ex.getMessage());
        }
        return coursesession;

    }

    public CourseSession getCourseSessionFromId(int id) {
        CourseSession cs = new CourseSession();
        try {
            session = new AnnotationConfiguration()
                    .configure().buildSessionFactory().openSession();
            transaction = session.beginTransaction();
            cs = (CourseSession) session.get(CourseSession.class, id);
            Hibernate.initialize(cs.getLocation());
            Hibernate.initialize(cs.getCourse());
            transaction.commit();
            session.close();
        } catch (HibernateException ex) {
            System.out.println("fr.utbm.repository.HibernateDao.getCourseSessionFromId()");
        }
        return cs;
    }
}
