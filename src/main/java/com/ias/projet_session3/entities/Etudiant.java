/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 *
 * @author BaDRi
 */
@Entity
@DiscriminatorValue("T")
@NamedQuery(name="Etudiant.findAll", query="select e from Etudiant e")
public class Etudiant extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ManyToMany(mappedBy = "etudiants")
    private List<Groupe> groupe = new LinkedList<>();
    
    public Etudiant() {
    }

    //constructeur#1
    public Etudiant(String id_personne, String nom, String prenom, String courriel, String motPasse, String etat) {
        super(id_personne, nom, prenom, courriel, motPasse, etat);
        
    }

    //constructeur#2
    public Etudiant(String id_personne, String nom, String prenom, String courriel) {
        super(id_personne, nom, prenom, courriel);
    }

    //constructeur#3
    public Etudiant(String id_personne, String motPasse) {
        super(id_personne, motPasse);
    }

    private String listerGroupe() {
        String message = "";
        if (!listinGroupe.equals(null)) {
            for (Groupe tmp : listinGroupe)
                message += " ||" + tmp.toString();
            return message;
        } else
            return "Aucun groupe";
    }
    
    public void sinscrireA(Groupe c) {
        groupe.add(c);
        c.getEtudiants().add(this);
    }

    public void seDesinscrireDe(Groupe c) {
        groupe.remove(c);
        c.getEtudiants().remove(this);
    }
    public List<Groupe> getGroupe() {
        return groupe;
    }

    @Override
    public String toString() {
        return "Etudiant{" + super.toString() + "Groupes= " + listerGroupe() + '}';
    }

}
