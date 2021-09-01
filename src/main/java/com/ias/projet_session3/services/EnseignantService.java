/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.services;

import com.ias.projet_session3.daos.EnseignantDao;
import com.ias.projet_session3.daos.SqlEnseignantDao;
import java.util.List;
import com.ias.projet_session3.entities.Groupe;
import com.ias.projet_session3.entities.Invitation;
import com.ias.projet_session3.entities.Personne;

/**
 *
 * @author BaDRi
 */
public class EnseignantService {
    
       // 1)Ajouter un groupe..6/23  //utilise Jpa
       /* public static void CreerGroupe(Groupe unGroupe)
        {
            EnseignantDao dao = new SqlEnseignantDao();
            dao.SetGroupe(unGroupe);
        }*/

        // 2)Recuperer tout les groupes..7/23
       /* public static List<Groupe> ChargerGroupes(Personne perso)
        {
            EnseignantDao dao = new SqlEnseignantDao();
            return dao.GetListeGroupes(perso);
        }*/

        // 3)Supprission d'un groupe..8/23
       /* public static void SupprimerGroupe(String id_groupe)
        {
            EnseignantDao dao = new SqlEnseignantDao();
            dao.SupprimerGroupe(id_groupe);
        }*/

      /*  // 4)Modification d'un groupe..9/23
        public static void ModifierGroupe(String id_groupe, String titre)
        {
            EnseignantDao dao = new SqlEnseignantDao();
            dao.ModifierGroupe(id_groupe,titre);
        }*/
        
        
        // 5)Envoyer une invitation de joindre un groupe  ..12/23
      /*  public static void EnvoyerInvitation(Invitation invit)
        {
            EnseignantDao dao = new SqlEnseignantDao();
            dao.SetInvitation(invit);
        }*/

        // 6)Recuperer la liste des invitation envoyees pour 1 enseignant ..13/23
        public static List<Invitation> ChargerInvitation(Personne perso)
        {
            EnseignantDao dao = new SqlEnseignantDao();
            return dao.GetListeInvitations(perso);
        }

        // 7)Annuler une invitation en cours ..14/23
      /*  public static void AnnulerInvitation(Invitation invit)
        {
            EnseignantDao dao = new SqlEnseignantDao();
            dao.DeleteInvitation(invit);
        }*/

        // 8)Recuperer un titre d'un groupe ..15/23
        public static String TitreGroupe(String id_groupe)
        {
            EnseignantDao dao = new SqlEnseignantDao();
            return dao.GetTitreGroupe(id_groupe);
        }
        
         // 9)Verifier si une une invitation est en cours existe   ..16/23
        public static boolean VerifierInvitation(String id_etudiant, String id_goupe)
        {
            EnseignantDao dao = new SqlEnseignantDao();
            return dao.IsInvitationExiste(id_etudiant, id_goupe);
        }
}
