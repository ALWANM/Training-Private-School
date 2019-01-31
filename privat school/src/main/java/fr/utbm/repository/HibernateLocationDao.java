/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.core.CourseSession;
import fr.utbm.core.Location;
import java.util.ArrayList;
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
public class HibernateLocationDao {

    private Session session;
    private Transaction transaction;

    public List<Location> getAllLocation() {
        List<Location> location = new ArrayList<Location>();
        try {
            session = new AnnotationConfiguration()
                    .configure().buildSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Location");
            location = query.list();
            transaction.commit();
            session.close();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return location;
    }
}
