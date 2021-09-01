/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.services;

import java.util.List;
import com.ias.projet_session3.daosJpa.JpaEntitiesDaoJpa;

import com.ias.projet_session3.daosJpa.EntitiesDaoJpa;
import com.ias.projet_session3.entities.Groupe;
import com.ias.projet_session3.entities.Invitation;
import com.ias.projet_session3.entities.Personne;

/**
 *
 * @author BaDRi
 */
public class EntitiesServiceJpa {

    // 1)Importer lises des comptes personnes (ID)...
    public static List<String> GetIdPersonnesJpa() {
        EntitiesDaoJpa dao = new JpaEntitiesDaoJpa();
        return dao.GetListePersonne();
    }

    // 2)Ajouter un groupe..
    public static void CreerGroupe(Groupe unGroupe) {
        EntitiesDaoJpa dao = new JpaEntitiesDaoJpa();
        dao.SetGroupe(unGroupe);
    }

    // 3)Recuperer tout les groupes..
    public static List<Groupe> ChargerGroupes(Personne perso) {
        EntitiesDaoJpa dao = new JpaEntitiesDaoJpa();
        return dao.GetListeGroupes(perso);
    }

    // 4)Supprission d'un groupe..
    public static void SupprimerGroupe(String id_groupe) {
        EntitiesDaoJpa dao = new JpaEntitiesDaoJpa();
        dao.SupprimerGroupe(id_groupe);
    }

    // 5)Modification d'un groupe..9/23
    public static void ModifierGroupe(String id_groupe, String titre) {
        EntitiesDaoJpa dao = new JpaEntitiesDaoJpa();
        dao.ModifierGroupe(id_groupe, titre);
    }

    // 6)Envoyer une invitation de joindre un groupe  ..12/23
    public static void EnvoyerInvitation(Invitation invit) {
        EntitiesDaoJpa dao = new JpaEntitiesDaoJpa();
        dao.SetInvitation(invit);
    }

    // 7)Annuler une invitation en cours ..14/23
    public static void AnnulerInvitation(Invitation invit) {
        EntitiesDaoJpa dao = new JpaEntitiesDaoJpa();
        dao.DeleteInvitation(invit);
    }
}
