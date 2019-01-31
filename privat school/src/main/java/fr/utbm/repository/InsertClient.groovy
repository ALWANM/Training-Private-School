/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.utbm.repository

import fr.utbm.core.Client
import fr.utbm.core.CourseSession
import fr.utbm.service.CourseSessionService
import org.hibernate.cfg.AnnotationConfiguration

def  insertClient(Client c) {
    try{ 
        Client cc=new Client(c)
        println("save success:)")
        CourseSessionService cs=new CourseSessionService()
        CourseSession sc=cs.getCourseSessionFromIdService(1)
        sf = new AnnotationConfiguration().configure().buildSessionFactory()
        sess = sf.openSession()
        tx = sess.beginTransaction()
        sess.save cc
        tx.commit()
        sess.close()
        sf.close()
    }catch(Exception e){
        println("sessiion exception")
    }
    
}

