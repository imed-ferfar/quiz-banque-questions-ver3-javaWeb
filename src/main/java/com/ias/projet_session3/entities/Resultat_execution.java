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
public class Resultat_execution extends Question {

    public String le_code;
    public String reponse;

    public Resultat_execution(int id_question, String titre, int ponderation, boolean partage, String id_enseignant, String id_matiere, String le_code, String reponse) {
        super(id_question, titre, ponderation, partage, id_enseignant, id_matiere);
        this.le_code = le_code;
        this.reponse = reponse;
    }

    public Resultat_execution(int id_question, String le_code, String reponse) {
        this.id_question = id_question;
        titre = TITRE_RES_EXE;
        this.le_code = le_code;
        this.reponse = reponse;
    }

    public String getLe_code() {
        return le_code;
    }

    public String getReponse() {
        return reponse;
    }

    public void setLe_code(String le_code) {
        this.le_code = le_code;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.le_code);
        hash = 13 * hash + Objects.hashCode(this.reponse);
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
        final Resultat_execution other = (Resultat_execution) obj;
        if (!Objects.equals(this.le_code, other.le_code)) {
            return false;
        }
        if (!Objects.equals(this.reponse, other.reponse)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Resultat_execution{" +super.toString()+ ", le_code=" + le_code + ", reponse=" + reponse + '}';
    }
   

   

    
}
