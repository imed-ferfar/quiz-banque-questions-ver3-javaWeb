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
public class Erreur_image extends Question{

    private String url_image;
    private int num_ligne;
    private String erreur;
    private String correction;

    public Erreur_image(int id_question, String titre, int ponderation, boolean partage, String id_enseignant, String id_matiere, String url_image, int num_ligne, String erreur, String correction){
        super(id_question, titre, ponderation, partage, id_enseignant, id_matiere);
        this.url_image = url_image;
        this.num_ligne = num_ligne;
        this.erreur = erreur;
        this.correction = correction;
    }

    public Erreur_image(int id_question, String url_image, int num_ligne, String erreur, String correction) {
        this.id_question = id_question;
        titre = TITRE_IMG_ERR;
        this.url_image = url_image;
        this.num_ligne = num_ligne;
        this.erreur = erreur;
        this.correction = correction;
    }

    public Erreur_image(int id_question) {
        this.id_question = id_question;
        titre = TITRE_IMG_ERR;
    }

    public String getUrl_image() {
        return url_image;
    }

    public int getNum_ligne() {
        return num_ligne;
    }

    public String getErreur() {
        return erreur;
    }

    public String getCorrection() {
        return correction;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public void setNum_ligne(int num_ligne) {
        this.num_ligne = num_ligne;
    }

    public void setErreur(String erreur) {
        this.erreur = erreur;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.url_image);
        hash = 37 * hash + this.num_ligne;
        hash = 37 * hash + Objects.hashCode(this.erreur);
        hash = 37 * hash + Objects.hashCode(this.correction);
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
        final Erreur_image other = (Erreur_image) obj;
        if (this.num_ligne != other.num_ligne) {
            return false;
        }
        if (!Objects.equals(this.url_image, other.url_image)) {
            return false;
        }
        if (!Objects.equals(this.erreur, other.erreur)) {
            return false;
        }
        if (!Objects.equals(this.correction, other.correction)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Erreur_image{" +super.toString()+ ", url_image=" + url_image + ", num_ligne=" + num_ligne + ", erreur=" + erreur + ", correction=" + correction + '}';
    }

}
