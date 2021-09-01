/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.daos;

import java.util.List;
import com.ias.projet_session3.entities.Etudiant;
import com.ias.projet_session3.entities.Invitation;

/**
 *
 * @author BaDRi
 */
public interface EtudiantDao {
    
    public List<Etudiant> GetListeEtudiants(String id_groupe);

    public List<Etudiant> GetRechercheEtudiants(String motCle);

    public boolean IsEtudiantDansGroupe(String id_etudiant, String id_goupe);

    public void SetReponseInvitation(Invitation invit);
}
