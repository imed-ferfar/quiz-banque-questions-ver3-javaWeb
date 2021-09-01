/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.services;

import com.ias.projet_session3.daos.SqlCompteDao;
import java.util.List;
import com.ias.projet_session3.entities.Personne;
import com.ias.projet_session3.daos.CompteDao;

/**
 *
 * @author BaDRi
 */
public class CompteService {

    // 1)Importer lises des comptes personnes (ID)...1/23
   /* public static List<String> GetIdPersonnes() {
        CompteDao dao = new SqlCompteDao();
        return dao.GetListePersonne();
    }*/

    // 2) Ajout d'un nouveau compte (Enseignant / Etudiant)   ... 2/23
    public static void AjouterPersonne(Personne perso) {
        CompteDao dao = new SqlCompteDao();
        dao.AjouterNouvellePersonne(perso);
    }

    //  3)Authentifier un compte (Enseignant / Etudiant) ... 3/23
    public static Personne AuthentifierPerso(Personne perso) {
        System.out.println("2++++++++++avant++++++"+perso.getId_personne()+" : "+perso.getMotPasse());
        CompteDao dao = new SqlCompteDao();
        return dao.AuthentifierPersonne(perso);
    }

    // 4)Modifier le mot de passe d'une personne   ..17/23
    public static void ModifierMotPasse(String id_personne, String mot_passe) {
        CompteDao dao = new SqlCompteDao();
        dao.SetNouveauPasse(id_personne, mot_passe);
    }

    // 5)Modifier les infos d'une personne   ..18/23
    public static void ModifierInfos(Personne perso) {
        CompteDao dao = new SqlCompteDao();
        dao.SetInfosPersonne(perso);
    }
}