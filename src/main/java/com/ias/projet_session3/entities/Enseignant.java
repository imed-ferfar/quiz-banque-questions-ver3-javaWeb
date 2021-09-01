/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.entities;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 *
 * @author BaDRi
 */
@Entity
@DiscriminatorValue("E")
@NamedQuery(name="Enseignant.findAll", query="select e from Enseignant e")
public class Enseignant extends Personne implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private double salaire;

    public Enseignant() {
    }

    public Enseignant(String id_personne, String nom, String prenom, String courriel, String motPasse, String etat) {
        super(id_personne, nom, prenom, courriel, motPasse, etat);
    }

    public Enseignant(String id_personne, String motPasse) {
        super(id_personne, motPasse);
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Enseignant{" + "salaire=" + salaire + '}';
    }

}
