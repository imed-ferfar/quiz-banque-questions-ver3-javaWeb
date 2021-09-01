/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author BaDRi
 */
public class EntityManagerSingleton {
    private static EntityManager em;
    private static String PU;
    
    public static EntityManager getEntityManager() {
        if (em==null || !em.isOpen()) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
            em = emf.createEntityManager();
        }
        return em;
    }
    public static void setPersistenceUnit(String persistenceUnit) {
        EntityManagerSingleton.PU = persistenceUnit;
    }
    public static void close() {
        EntityManagerFactory emf = em.getEntityManagerFactory();
        em.close();
        emf.close();
    }
}