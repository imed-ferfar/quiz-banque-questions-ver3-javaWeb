/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author BaDRi
 */
public class QCM extends Question {

    private String la_question;
    private List<Choix> liste_choix;

    //constructeurs
    public QCM() {
    }

    public QCM(int id_question, String titre, int ponderation, boolean partage, String id_enseignant, String id_matiere, String la_question) {
        super(id_question, titre, ponderation, partage, id_enseignant, id_matiere);
        this.la_question = la_question;
        liste_choix = new LinkedList<Choix>();
    }

    public QCM(int id_question, String la_question) {
        this.id_question = id_question;
        titre = TITRE_QCM;
        this.la_question = la_question;
        liste_choix = new LinkedList<Choix>();
    }

    //Ajouter un choix de reponeses
    public void ajouterChoix(Choix choix) {
        if (verifierChoix(choix)) {
            liste_choix.add(choix);
        }
    }

    private boolean verifierChoix(Choix choix) {
        for (Choix tmp : liste_choix) {
            if (choix.equals(tmp)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.la_question);
        hash = 97 * hash + Objects.hashCode(this.liste_choix);
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
        final QCM other = (QCM) obj;
        if (!Objects.equals(this.la_question, other.la_question)) {
            return false;
        }
        return true;
    }

    public String listingChoix() {
        String message = "";
        for (int i = 0; i < liste_choix.size(); i++) {
            message += " "+"choix" + i + ": " + liste_choix.get(i).getChoix()+"_"+liste_choix.get(i).isStatut_choix();
        }
        return message;
    }

    @Override
    public String toString() {
        return "QCM{" + super.toString() + ", la_question=" + la_question + ", liste_choix=" + liste_choix + '}';
    }

    public String getLa_question() {
        return la_question;
    }

    public List<Choix> getListe_choix() {
        return liste_choix;
    }

  
}
