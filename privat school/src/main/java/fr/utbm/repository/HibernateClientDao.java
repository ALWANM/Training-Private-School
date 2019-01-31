/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.core.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author m-alwan
 */
public class HibernateClientDao {

    private Session session;
    private Transaction transaction;

    public void insertClient(Client c) {
//
//        try {
//            session = new AnnotationConfiguration()
//                    .configure().buildSessionFactory().openSession();
//            transaction = session.beginTransaction();
//            session.save(c);
//            transaction.commit();
//            session.close();
//
//        } catch (HibernateException ex) {
//            System.out.println("fr.utbm.repository.HibernateDao.getCourseSessionFromId()");
//        }

    }
}
