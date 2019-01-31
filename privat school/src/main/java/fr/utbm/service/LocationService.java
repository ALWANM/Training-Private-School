/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.service;

import fr.utbm.core.Location;
import fr.utbm.repository.HibernateLocationDao;
import java.util.List;

/**
 *
 * @author m-alwan
 */
public class LocationService {
    public List<Location> getAllLocationService(){
        HibernateLocationDao hbldao=new HibernateLocationDao();
        return hbldao.getAllLocation();
    }
}
