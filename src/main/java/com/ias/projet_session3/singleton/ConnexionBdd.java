/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author BaDRi
 */
public class ConnexionBdd {
    private static Connection laConnexion = null;
    private static String urlBD = "";
    private static String user = "", password = "";
    
    private ConnexionBdd() {
    }
    public static boolean loadDriver(String driverString){
        try {
            Class.forName(driverString);
            return true;
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(DbConnexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static void setUrlBD(String urlBD) {
        ConnexionBdd.urlBD = urlBD;
    }

    public static void setUser(String user) {
        ConnexionBdd.user = user;
    }

    public static void setPassword(String password) {
        ConnexionBdd.password = password;
    }
    
    public static Connection getConnexion() {
        try {
            if (laConnexion == null || laConnexion.isClosed()) {
                    //System.out.println("Chaine du pilote : "+chainePilote);
                    //DbConnexion.loadDriver(chainePilote);
                    //Ouvrir la connexion à la BD.
                    if ("".equals(user))
                        laConnexion = DriverManager.getConnection(urlBD);
                    else
                        laConnexion = DriverManager.getConnection(urlBD,user,password);
                    System.out.println("OK!!! Connexion etablie avec succes.");
            }
        } catch (SQLException ex) {
            System.out.println("Connexion echouee!!! "+ex.getMessage());
        }
        return laConnexion;
    }
    public static void close() {
        if (laConnexion != null)
            try {
                laConnexion.close();
                laConnexion = null;
        } catch (SQLException ex) {
            //Logger.getLogger(DbConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
