/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author BaDRi
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Groupe.findAllId", query="select g.id_groupe from Groupe g"),
    @NamedQuery(name="Groupe.findById", query="select g from Groupe g where g.id_groupe = :id_groupe"),
    @NamedQuery(name="Groupe.findByIdEnseignant", query="select g from Groupe g where g.id_enseignant = :id_enseignant")
})
public class Groupe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(length=10)
    private String id_groupe;
    @Column(length=30)
    private String titre;
    private String id_enseignant;
    @ManyToMany
    @JoinTable(name="AFFECTATION",
            joinColumns = @JoinColumn(name="id_groupe"),
            inverseJoinColumns = @JoinColumn(name="id_etudiant"))
    private List<Etudiant> etudiants = new LinkedList<>();

    public Groupe() {
    }

    //Constructeur #1
    public Groupe(String id_groupe, String titre, String id_enseignant) {
        this.id_groupe = id_groupe;
        this.titre = titre;
        this.id_enseignant = id_enseignant;
    }

    //Constructeur #2
    public Groupe(String id_groupe, String titre) {
        this.id_groupe = id_groupe;
        this.titre = titre;
    }

    public String getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(String id_groupe) {
        this.id_groupe = id_groupe;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(String id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public void inscrire(Etudiant e)
    {
        etudiants.add(e);
        e.getGroupe().add(this);
        //e.sinscrireA(this);
    }

    public void desinscrire(Etudiant e)
    {
        etudiants.remove(e);
        e.getGroupe().remove(this);
    }
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
    
    @Override
    public String toString() {
        return "Groupe{" + "id_groupe=" + id_groupe + ", titre=" + titre + ", id_enseignant=" + id_enseignant + '}';
    }
    
}
