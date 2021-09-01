/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.daosJpa;

import java.util.List;
import com.ias.projet_session3.entities.Groupe;
import com.ias.projet_session3.entities.Invitation;
import com.ias.projet_session3.entities.Personne;

/**
 *
 * @author BaDRi
 */
public interface EntitiesDaoJpa {

    List<String> GetListePersonne();    
    
    //====================================================//
    void SetGroupe(Groupe unGroupe);
    
    List<Groupe> GetListeGroupes(Personne perso);
    
    void SupprimerGroupe(String id_groupe);
    
    void ModifierGroupe(String id_groupe,String titre);

    public void SetInvitation(Invitation invit);
    
    public void DeleteInvitation(Invitation invit);
}
