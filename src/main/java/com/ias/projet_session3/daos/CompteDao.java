/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.daos;


import com.ias.projet_session3.entities.Personne;

/**
 *
 * @author BaDRi
 */
public interface CompteDao {

    //List<String> GetListePersonne(); //utilise JPA

    void AjouterNouvellePersonne(Personne perso);

    Personne AuthentifierPersonne(Personne perso);

    public void SetNouveauPasse(String id_personne, String mot_passe);

    public void SetInfosPersonne(Personne perso);

}
