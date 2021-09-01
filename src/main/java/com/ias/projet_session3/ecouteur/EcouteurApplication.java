/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.ecouteur;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.ias.projet_session3.singleton.ConnexionBdd;
import com.ias.projet_session3.singleton.EntityManagerSingleton;

/**
 *
 * @author BaDRi
 */
public class EcouteurApplication implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Démarrage de l'application ["
                + sce.getServletContext().getServletContextName()
                + "].");
        ServletContext contexte = sce.getServletContext(); //l'objet application
        String piloteJdbc = contexte.getInitParameter("pilote");
        String urlBd = contexte.getInitParameter("urlBd");
        ConnexionBdd.loadDriver(piloteJdbc);
        ConnexionBdd.setUrlBD(urlBd);
        String user = contexte.getInitParameter("userBd");
        System.out.println("Infos de connexion :");
        System.out.println("URL : " + urlBd);
        System.out.println("Pilote : " + piloteJdbc);
        System.out.println("User : " + user);
        System.out.println("Password :");
        if (user != null && !"".equals(user)) {
            ConnexionBdd.setUser(user);
            ConnexionBdd.setPassword(contexte.getInitParameter("motPasseBd"));
        } else {
            ConnexionBdd.setUser("");
        }

        //configuratiion singleton JPA
        String nomPersistence = contexte.getInitParameter("nomPersistence");
        EntityManagerSingleton.setPersistenceUnit(nomPersistence);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
