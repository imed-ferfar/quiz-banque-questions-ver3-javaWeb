/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.services;

import com.ias.projet_session3.daos.EtudiantDao;
import com.ias.projet_session3.daos.SqlEtudiantDao;
import java.util.List;
import com.ias.projet_session3.entities.Etudiant;
import com.ias.projet_session3.entities.Invitation;

/**
 *
 * @author BaDRi
 */
public class EtudiantService {

    // 1)Importer lise des etudiant dans 1 groupe ...5/23
    public static List<Etudiant> EtudiantsGroupe(String id_groupe) {
        EtudiantDao dao = new SqlEtudiantDao();
        return dao.GetListeEtudiants(id_groupe);
    }

    // 2)Rechercher etudiants ..10/23
    public static List<Etudiant> RechercherEtudiant(String motCle) {
        EtudiantDao dao = new SqlEtudiantDao();
        return dao.GetRechercheEtudiants(motCle);
    }

    // 3)Verifier si un etudiant appartient à un groupe    ..11/23
    public static boolean VerifierEtudiantDansGroupe(String id_etudiant, String id_goupe) {
        EtudiantDao dao = new SqlEtudiantDao();
        return dao.IsEtudiantDansGroupe(id_etudiant, id_goupe);
    }

    // 4)Verifier si un etudiant appartient à un groupe    ..19/23
    public static void RepondreInvitation(Invitation invit, String reponse) {
        EtudiantDao dao = new SqlEtudiantDao();
        dao.SetReponseInvitation(invit);
    }
}
