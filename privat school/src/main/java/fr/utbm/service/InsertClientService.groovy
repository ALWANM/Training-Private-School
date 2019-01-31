/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.utbm.service

import fr.utbm.core.Client
import fr.utbm.repository.InsertClient

def void insertClientService(Client c)
{
    GroovyShell shell = new GroovyShell()
    def script = shell.parse(new File('./src/main/java/fr/utbm/repository/InsertClient.groovy'))
    script.insertClient(c)
}
