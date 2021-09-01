/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.daosJpa;

import java.util.List;
import com.ias.projet_session3.singleton.EntityManagerSingleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.ias.projet_session3.entities.Enseignant;
import com.ias.projet_session3.entities.Groupe;
import com.ias.projet_session3.entities.Invitation;
import com.ias.projet_session3.entities.Personne;

/**
 *
 * @author BaDRi
 */
public class JpaEntitiesDaoJpa implements EntitiesDaoJpa {

    @Override  // Importer lises des comptes personnes (ID) ... 
    public List<String> GetListePersonne() {
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Query qr = em.createNamedQuery("Personne.findAllId");
        return qr.getResultList();
    }

    @Override  // Ajouter un nouveau groupe ... 
    public void SetGroupe(Groupe unGroupe) {
        try {
            EntityManagerSingleton.getEntityManager().persist(unGroupe);
        } catch (Exception exp) {
        }

    }

    @Override
    public List<Groupe> GetListeGroupes(Personne perso) {
        if (perso instanceof Enseignant) {
            EntityManager em = EntityManagerSingleton.getEntityManager();
            Query qr = em.createNamedQuery("Groupe.findByIdEnseignant");   //Contact.findStatic
            qr.setParameter("id_enseignant", perso.getId_personne());
            return qr.getResultList();
        }
        return null;

    }

    @Override
    public void SupprimerGroupe(String id_groupe) {
        Groupe g = EntityManagerSingleton.getEntityManager().find(Groupe.class, id_groupe);
        if (g != null) {
            EntityTransaction t = EntityManagerSingleton.getEntityManager().getTransaction();
            t.begin();
            EntityManagerSingleton.getEntityManager().remove(g);
            t.commit();
        }
    }

    @Override
    public void ModifierGroupe(String id_groupe, String titre) {
        Groupe g = EntityManagerSingleton.getEntityManager().find(Groupe.class, id_groupe);
        if (g != null) {
            EntityTransaction t = EntityManagerSingleton.getEntityManager().getTransaction();
            g.setTitre(titre);
            t.begin();
            EntityManagerSingleton.getEntityManager().merge(g);
            t.commit();
        }
    }

    @Override
    public void SetInvitation(Invitation invit) {
        EntityTransaction t = EntityManagerSingleton.getEntityManager().getTransaction();
        t.begin();
        try {
            EntityManagerSingleton.getEntityManager().persist(invit);
        } catch (Exception exp) {
        }
        t.commit();
    }

    @Override
    public void DeleteInvitation(Invitation invit) {
       // Groupe g = EntityManagerSingleton.getEntityManager().find(Groupe.class, invit);
        if (invit != null) {
            EntityTransaction t = EntityManagerSingleton.getEntityManager().getTransaction();
            t.begin();
            EntityManagerSingleton.getEntityManager().remove(invit);
            t.commit();
        }
    }
}
