/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.daos;

import java.util.List;
import com.ias.projet_session3.entities.Invitation;
import com.ias.projet_session3.entities.Personne;


/**
 *
 * @author BaDRi
 */
public interface EnseignantDao {
    
   // void SetGroupe(Groupe unGroupe);
    
   // List<Groupe> GetListeGroupes(Personne perso);

   // void SupprimerGroupe(String id_groupe);

   // void ModifierGroupe(String id_groupe,String titre);

   // public void SetInvitation(Invitation invit);

    public List<Invitation> GetListeInvitations(Personne perso);

   // public void DeleteInvitation(Invitation invit);

    public String GetTitreGroupe(String id_groupe);

    public boolean IsInvitationExiste(String id_etudiant, String id_goupe);
}
