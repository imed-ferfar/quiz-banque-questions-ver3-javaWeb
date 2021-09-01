/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.entities;

import com.ias.projet_session3.services.EnseignantService;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

/**
 *
 * @author BaDRi
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Invitation.findAllId", query="select i.id_groupe from Invitation i"),
    @NamedQuery(name="Invitation.findById", query="select i from Invitation i where i.id_enseignant = :id_enseignant AND i.id_groupe = :id_groupe AND i.id_etudiant = :id_etudiant")
})
public class Invitation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id_enseignant;
    @Id
    private String id_etudiant;
    @Id
    private String id_groupe;
    private String date;
    private String heure;
    private String commentaire;
    @Column (name="statut",nullable = true)
    private String statut;
    //@Column (name="nom",nullable = true)
    @Transient
    private String nom;
    //@Column (name="prenom",nullable = true)
    @Transient
    private String prenom;
    //@Column (name="titre",nullable = true)
    @Transient
    private String titre;
    @Transient
    Date dateSysteme;
    @Transient
    DateFormat formatDate,formatHeure;

    public Invitation() {
    }

    
    
    //constructeur#1
    public Invitation(String id_enseignant, String id_etudiant, String id_groupe, String commentaire) {
       /* formatDate = new SimpleDateFormat("dd/MM/YY");
        formatHeure = new SimpleDateFormat("HH/mm");*/
        dateSysteme = new Date();
        
        this.id_enseignant = id_enseignant;
        this.id_etudiant = id_etudiant;
        this.id_groupe = id_groupe;
        date = new SimpleDateFormat("dd/MM/YY").format(dateSysteme);
        heure = new SimpleDateFormat("HH:mm").format(dateSysteme);
        this.commentaire = commentaire;
    }
    
    //constructeur#2
    public Invitation(String id_etudiant, String id_groupe, String titre, String nom, String prenom, String date, String heure, String commentaire) {
        this.id_etudiant = id_etudiant;
        this.id_groupe = id_groupe;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.heure = heure;
        this.commentaire = commentaire;
    }

    //constructeur#3
    public Invitation(String id_enseignant, String id_etudiant, String id_groupe) {
        this.id_enseignant = id_enseignant;
        this.id_etudiant = id_etudiant;
        this.id_groupe = id_groupe;
        dateSysteme = new Date();
        date = new SimpleDateFormat("dd/MM/YY").format(dateSysteme);
        heure = new SimpleDateFormat("HH:mm").format(dateSysteme);
        commentaire = "Vous avez recu une invitation de la part de : "+id_enseignant
                +" ,pour joindre le groupe  (ID: "+ id_groupe + ")";
    }

    //constructeur#4
    public Invitation(String id_etudiant, String id_groupe) {
        this.id_etudiant = id_etudiant;
        this.id_groupe = id_groupe;
    }

    public String getId_enseignant() {
        return id_enseignant;
    }

    public String getId_etudiant() {
        return id_etudiant;
    }

    public String getId_groupe() {
        return id_groupe;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getStatut() {
        return statut;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDateSysteme() {
        return dateSysteme;
    }

    public DateFormat getFormatDate() {
        return formatDate;
    }

    public DateFormat getFormatHeure() {
        return formatHeure;
    }

    
    @Override
    public String toString() {
        return "Invitation{" + "id_enseignant=" + id_enseignant + ", id_etudiant=" + id_etudiant + 
                ", id_groupe=" + id_groupe + ", date=" + date + ", heure=" + heure + ", commentaire=" + commentaire
                + ", statut=" + statut + ", nom=" + nom + ", prenom=" + prenom + ", titre=" + titre + '}';
    }

    
    
}
