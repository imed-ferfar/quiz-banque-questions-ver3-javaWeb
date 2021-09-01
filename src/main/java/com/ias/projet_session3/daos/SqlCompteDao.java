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
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ias.projet_session3.entities.Enseignant;
import com.ias.projet_session3.entities.Etudiant;
import com.ias.projet_session3.entities.Personne;
import com.ias.projet_session3.singleton.ConnexionBdd;

/**
 *
 * @author BaDRi
 */
public class SqlCompteDao implements CompteDao {

  /*  @Override  // 1)Importer lises des comptes personnes (ID) ... 1/23
    public List<String> GetListePersonne() {
        LinkedList<String> liste = new LinkedList<>();
        String id_personne;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            Statement stm = cnx.createStatement();
            ResultSet res = stm.executeQuery("SELECT id_personne FROM `personne`");
            while (res.next()) {
                id_personne = res.getString("id_personne");
                liste.add(id_personne);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
        }
        return liste;
    }*/

    @Override // 2) Ajout d'un nouveau compte (Enseignant / Etudiant)   ... 2/23
    public void AjouterNouvellePersonne(Personne perso) {
        PreparedStatement statementP = null, statementP2 = null;
        String rq = "";
        String rq2 = "";
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "INSERT INTO personne (id_personne, nom, prenom, courriel, motPasse, etat) VALUES (?, ?, ?, ?, ?, 'true');";
            if (perso instanceof Enseignant) {
                rq2 = "INSERT INTO enseignant (id_enseignant) VALUES(?);";
            } else if (perso instanceof Etudiant) {
                rq2 = "INSERT INTO etudiant (id_etudiant) VALUES (?);";
            }

            statementP = cnx.prepareStatement(rq);
            statementP2 = cnx.prepareStatement(rq2);

            if ((statementP != null) && (statementP2 != null)) {
                statementP.setString(1, perso.getId_personne());
                statementP.setString(2, perso.getNom());
                statementP.setString(3, perso.getPrenom());
                statementP.setString(4, perso.getCourriel());
                statementP.setString(5, perso.getMotPasse());
                statementP2.setString(1, perso.getId_personne());

                statementP.executeUpdate();
                statementP2.executeUpdate();
            }
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
        }
    }

    @Override  //  3)Authentifier un compte (Enseignant / Etudiant) ... 3/23
   public Personne AuthentifierPersonne(Personne perso) {
        PreparedStatement statementP = null;
        ResultSet res = null;
        String rq = "";
        String id_personne, nom, prenom, courriel, motPasse, etat, id_groupe;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
                if(perso instanceof Enseignant){
                rq = "SELECT * FROM personne p JOIN enseignant e ON(p.id_personne= e.id_enseignant) WHERE p.id_personne = ? AND p.motPasse = ?";
            } else if (perso  instanceof Etudiant) {
                rq = "SELECT * FROM personne p JOIN etudiant e ON(p.id_personne= e.id_etudiant) WHERE p.id_personne = ? AND p.motPasse = ?";
            }

            statementP = cnx.prepareStatement(rq);

            if (statementP != null) {
                statementP.setString(1, perso.getId_personne());
                statementP.setString(2, perso.getMotPasse());
                res = statementP.executeQuery();
                if (res.next()) {
                    id_personne = res.getString("id_personne");
                    nom = res.getString("nom");
                    prenom = res.getString("prenom");
                    courriel = res.getString("courriel");
                    motPasse = res.getString("motPasse"); // 
                    etat = res.getString("etat");
                    System.out.println("---> " + id_personne + nom + prenom + courriel + motPasse + etat);
                    if (perso instanceof Etudiant) {
                        perso = new Etudiant(id_personne, nom, prenom, courriel, motPasse, etat);
                    } else {
                        perso = new Enseignant(id_personne, nom, prenom, courriel, motPasse, etat);
                    }
                    return perso;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
            return null;
        }
        return null;
    }

    @Override   //  4)Modifier le mot de passe d'une personne ... 17/23
    public void SetNouveauPasse(String id_personne, String mot_passe) {
        PreparedStatement statementP = null, statementP2 = null;
        String rq = "";
        int nbr = 0;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "UPDATE personne SET motPasse =? WHERE id_personne =?;";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, mot_passe);
                statementP.setString(2, id_personne);
                nbr = statementP.executeUpdate();
                System.out.println("Le mot de passe de la personne ID= " + id_personne + "a été bien modifié");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres probleme !!!" + ex.getMessage());
        }
    }

    @Override   //  5)Modifier les infos d'une personne ... 18/23
    public void SetInfosPersonne(Personne perso) {
         PreparedStatement statementP = null, statementP2 = null;
        String rq = "";
        int nbr = 0;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "UPDATE personne SET nom = ?, prenom = ?, courriel = ? WHERE id_personne =?;";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, perso.getNom());
                statementP.setString(2, perso.getPrenom());
                statementP.setString(3, perso.getCourriel());
                statementP.setString(4, perso.getId_personne());
                nbr = statementP.executeUpdate();
                System.out.println("Les infos personnelles ont été mises à jour, : " + perso.toString());
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
