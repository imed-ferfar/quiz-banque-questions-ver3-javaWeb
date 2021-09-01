/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ias.projet_session3.entities.Etudiant;
import com.ias.projet_session3.entities.Invitation;
import com.ias.projet_session3.singleton.ConnexionBdd;

/**
 *
 * @author BaDRi
 */
public class SqlEtudiantDao implements EtudiantDao {

    //1) Liste des etudiants d'un groupe                ... 5/23
    @Override
    public List<Etudiant> GetListeEtudiants(String id_groupe) {
        PreparedStatement statementP = null;
        ResultSet res = null;
        String rq, id_etiduant, nom, prenom, courriel;
        boolean flag = true;
        
        List<Etudiant> list_etud = new LinkedList<>();
        Etudiant etud;

        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "SELECT p.id_personne, p.nom, p.prenom, p.courriel FROM etudiant e "
                    + "JOIN affectation a ON(e.id_etudiant = a.id_etudiant) "
                    + "JOIN personne p ON(e.id_etudiant = p.id_personne)"
                    + "WHERE a.id_groupe = ?";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, id_groupe);
                res = statementP.executeQuery();
                while (res.next()) {
                    System.out.println("ok");
                    id_etiduant = res.getString("id_personne");
                    nom = res.getString("nom");
                    prenom = res.getString("prenom");
                    courriel = res.getString("courriel");

                    etud = new Etudiant(id_etiduant, nom, prenom, courriel);
                    System.out.println("Etudiant : " + etud.toString());

                    list_etud.add(etud);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
        }
        return list_etud;
    }

    //2) Liste des etudiants d'un groupe                ... 10/23
    @Override
    public List<Etudiant> GetRechercheEtudiants(String motCle) {
        PreparedStatement statementP = null;
        ResultSet res = null;
        String rq, id_etiduant, nom, prenom, courriel;

        List<Etudiant> list_etud = new LinkedList<>();
        Etudiant etud;
        boolean flag = true;

        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "SELECT p.id_personne,p.nom,p.prenom,p.courriel "
                    + "FROM etudiant e JOIN personne p ON(p.id_personne = e.id_etudiant) "
                    + "WHERE (e.id_etudiant LIKE ?) || (UPPER(p.nom) LIKE ?) || (UPPER(p.prenom) LIKE ?)";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, "%" + motCle.toUpperCase() + "%");
                statementP.setString(2, "%" + motCle.toUpperCase() + "%");
                statementP.setString(3, "%" + motCle.toUpperCase() + "%");
                res = statementP.executeQuery();
                while (res.next()) {
                    id_etiduant = res.getString("id_personne");
                    nom = res.getString("nom");
                    prenom = res.getString("prenom");
                    courriel = res.getString("courriel");
                    etud = new Etudiant(id_etiduant, nom, prenom, courriel);
                    System.out.println("Etudiant : " + etud.toString());

                    list_etud.add(etud);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
            flag = false;
        }
        if (flag) {
            System.out.println("Vopici la liste des etudiant recherché :" + list_etud.toString());
        }
        return list_etud;
    }

    //3) Verifier si un etudiant est dans un groupe           ... ... 11/23
    @Override
    public boolean IsEtudiantDansGroupe(String id_etudiant, String id_groupe) {
        PreparedStatement statementP = null;
        ResultSet res = null;
        String rq;
        boolean flag = true, existe = true;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "SELECT * FROM affectation WHERE (id_etudiant = ?) && (id_groupe = ?)";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, id_etudiant);
                statementP.setString(2, id_groupe);
                res = statementP.executeQuery();
                existe = res.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
            flag = false;
        }
        if ((flag) && (existe)) {
            System.out.println("L'etudiant recherché existe dans le groupe");
        }
        return existe;
    }

    // 4) Repondre a une invitation     .. ... 19/23
    @Override
    public void SetReponseInvitation(Invitation invit) {
        PreparedStatement statementP = null, statementP2 = null;
        String rq = "";
        int nbr = 0;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "UPDATE invitation SET statut = ? WHERE id_etudiant =? AND id_groupe =?;";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, invit.getStatut());
                statementP.setString(2, invit.getId_etudiant());
                statementP.setString(3, invit.getId_groupe());
                nbr = statementP.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres probleme !!!" + ex.getMessage());
        }
        if (invit.getStatut().equals("false")) {
            System.out.println("L'invitation pour joindre le groupe : " + invit.getId_groupe() + ", a été bien rejetée.");
        } else {
            try ( Connection cnx = ConnexionBdd.getConnexion();) {
                rq = "INSERT INTO affectation (id_etudiant, id_groupe) VALUES (?, ?);";
                statementP = cnx.prepareStatement(rq);
                if (statementP != null) {
                    statementP.setString(1, invit.getId_etudiant());
                    statementP.setString(2, invit.getId_groupe());

                    nbr = statementP.executeUpdate();
                    System.out.println("ID= " + invit.getId_etudiant() + ", vous avez bien repondu à l'invitation");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Probleme de connexion!!!" + ex.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Autres probleme !!!" + ex.getMessage());
            }
        }
    }

}
