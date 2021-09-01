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
public class Choix {

    private String choix;
    private boolean statut_choix;

    public Choix(String choix, boolean statut_choix) {
        this.choix = choix;
        this.statut_choix = statut_choix;
    }

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public boolean isStatut_choix() {
        return statut_choix;
    }

    public void setStatut_choix(boolean statut_choix) {
        this.statut_choix = statut_choix;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.choix);
        hash = 97 * hash + (this.statut_choix ? 1 : 0);
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
        final Choix other = (Choix) obj;
        if (this.statut_choix != other.statut_choix) {
            return false;
        }
        if (!Objects.equals(this.choix, other.choix)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Choix{" + "choix=" + choix + ", statut_choix=" + statut_choix + '}';
    }

    


}
