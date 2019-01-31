/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.service;

import fr.utbm.core.Client;
import groovy.util.ResourceException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import groovy.util.GroovyScriptEngine;

/**
 *
 * @author m-alwan
 */
public class ClientService {

    public void insertClientService(Client c) {
        System.out.println("Calling script from Java");
        try {
             Class scriptClass = new GroovyScriptEngine("D:\\UTBM\\2EME_ANNE_2017_2018\\LO54\\Data\\Projects\\project1\\src\\main\\java\\fr\\utbm\\repository").loadScriptByName("InsertClient.groovy");
            Object scriptInstance = scriptClass.newInstance();
            scriptClass.getDeclaredMethod("insertClient", Client.class).invoke(scriptInstance, c);

        } catch (ResourceException | groovy.util.ScriptException | IOException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
