/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;


/**
 *
 * @author BaDRi
 */
@Entity
@Inheritance (strategy=InheritanceType.JOINED)  // stratigie #2
//@Inheritance (strategy=InheritanceType.TABLE_PER_CLASS)  // stratigie #2
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //par défaut
@DiscriminatorColumn(name="TYPEPERS", discriminatorType=DiscriminatorType.CHAR)
@DiscriminatorValue("P")
@NamedQuery(name="Personne.findAllId", query="select p.id_personne from Personne p")
public class Personne implements Serializable {

    @Id
    @Column(length = 7)
    private String id_personne;
    @Column(length = 25)
    private String nom;
    @Column(length = 25)
    private String prenom;
    @Column(length = 50)
    private String courriel;
    @Column(length = 15)
    private String motPasse;
    @Column(length = 5)
    private String etat;

    @Transient
    protected List<Groupe> listinGroupe;

    public Personne() {
        listinGroupe = new LinkedList<>();
    }

    public Personne(String id_personne, String nom, String prenom, String courriel, String motPasse, String etat) {
        this.id_personne = id_personne;
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.motPasse = motPasse;
        this.etat = etat;
        listinGroupe = new LinkedList<>();
    }

    public Personne(String id_personne, String nom, String prenom, String courriel) {
        this.id_personne = id_personne;
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        listinGroupe = new ArrayList<>();
    }

    public Personne(String id_personne, String motPasse) {
        this.id_personne = id_personne;
        this.motPasse = motPasse;
    }

    public String getId_personne() {
        return id_personne;
    }

    public void setId_personne(String id_personne) {
        this.id_personne = id_personne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void ListerGroupe() {
        for(Groupe tmp : listinGroupe){
            System.out.println(tmp.toString());
        }
    }

    @Override
    public String toString() {
        return "id_personne=" + id_personne + ", nom=" + nom + ", prenom=" + prenom + ", courriel=" + courriel + ", motPasse=" + motPasse + ", etat=" + etat;
    }

}
