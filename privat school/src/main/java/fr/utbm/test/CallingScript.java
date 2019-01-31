/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.test;

import fr.utbm.core.Client;
import fr.utbm.core.CourseSession;
import fr.utbm.service.ClientService;
import fr.utbm.service.CourseSessionService;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import java.io.File;
import java.io.IOException;
import org.codehaus.groovy.control.CompilationFailedException;

/**
 *
 * @author m-alwan
 */
public class CallingScript {

    static void runWithGroovyShell() throws Exception {
        new GroovyShell().parse(new File("InsertClient.groovy")).invokeMethod("insertClient", null);
    }

    public static void main(String[] args) throws CompilationFailedException, NoSuchMethodException {
        System.out.println("Calling script from Java");
        try {//
            // Declaring a class to conform to a java interface class would get rid of
            // a lot of the reflection here
            CourseSessionService cs = new CourseSessionService();
            CourseSession sc = cs.getCourseSessionFromIdService(1);
            Client c;
            c = new Client("marwan", "alwan", "6 rue de madrid", "0605908782", "marwanalwan@gmail.com", sc);
            Class scriptClass = new GroovyScriptEngine("./src/main/java/fr/utbm/service/").loadScriptByName("InsertClientService.groovy");
            Object scriptInstance = scriptClass.newInstance();
            ClientService cse = new ClientService();
            cse.insertClientService(c);
        } catch (ResourceException | groovy.util.ScriptException | IOException | IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException ex) {
            System.out.println(ex.getCause());
        }
    }
}
