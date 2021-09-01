/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.entities;

import java.util.Objects;

/**
 *
 * @author BaDRi
 */
public class Question {

    protected final String TITRE_QCM = "Choisir la ou les bonnes réponses";
    protected final String TITRE_IMG_ERR = "Trouver l'erreur dans ce code";
    protected final String TITRE_RES_EXE = "Trouver le resultat d'execution de ce code";

    protected int id_question;
    protected String titre;
    protected int ponderation;
    protected boolean partage;
    protected String id_enseignant;
    protected String id_matiere;
    private String maQues;

    // Constructeurs
    public Question() {
    }

    public Question(int id_question, String titre, int ponderation, boolean partage, String id_enseignant, String id_matiere) {
        this.id_question = id_question;
        this.titre = titre;
        this.ponderation = ponderation;
        this.partage = partage;
        this.id_enseignant = id_enseignant;
        this.id_matiere = id_matiere;
    }
@Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id_question;
        hash = 67 * hash + Objects.hashCode(this.titre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.id_question != other.id_question) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return true;
    }
    
    //Getters
    public int getId_question() {
        return id_question;
    }
    
    public String getTitre() {
        return titre;
    }

    public int getPonderation() {
        return ponderation;
    }

    public boolean isPartage() {
        return partage;
    }

    public String getId_enseignant() {
        return id_enseignant;
    }

    public String getId_matiere() {
        return id_matiere;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setPonderation(int ponderation) {
        this.ponderation = ponderation;
    }

    public void setPartage(boolean partage) {
        this.partage = partage;
    }

    public void setId_enseignant(String id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public void setId_matiere(String id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setMaQues(String maQues) {
        this.maQues = maQues;
    }
     public String getMaQues() {
        return maQues;
    }

    @Override
    public String toString() {
        return "Question{" + "TITRE_QCM=" + TITRE_QCM + ", TITRE_IMG_ERR=" + TITRE_IMG_ERR + ", TITRE_RES_EXE=" + TITRE_RES_EXE
                + ", id_question=" + id_question + ", titre=" + titre + ", ponderation=" + ponderation + ", partage=" + partage
                + ", id_enseignant=" + id_enseignant + ", id_matiere=" + id_matiere + '}';
    }
    

}
