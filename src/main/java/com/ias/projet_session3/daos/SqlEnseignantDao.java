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
import com.ias.projet_session3.entities.Groupe;
import com.ias.projet_session3.entities.Invitation;
import com.ias.projet_session3.entities.Personne;
import com.ias.projet_session3.singleton.ConnexionBdd;
import com.ias.projet_session3.entities.Enseignant;

/**
 *
 * @author BaDRi
 */
public class SqlEnseignantDao implements EnseignantDao {

   /* @Override  // 1)Ajouter un nouveau groupe ... 6/23
    public void SetGroupe(Groupe unGroupe) {
        PreparedStatement statementP = null;
        String rq;
        boolean flag = true;
        int nbr = 0;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "INSERT INTO groupe (id_groupe, titre, id_enseignant) VALUES (?, ?, ?);";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, unGroupe.getId_groupe());
                statementP.setString(2, unGroupe.getTitre());
                statementP.setString(3, unGroupe.getId_enseignant());
                nbr = statementP.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion " + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
            flag = false;
        }
        if (flag) {
            System.out.println("Le groupe suivant a été bien ajouté :\n" + nbr + "-ID_groupe : " + unGroupe.getId_groupe()
                    + "\nTitre : " + unGroupe.getTitre());
        }
    }*/

   /* @Override  // 2)Charger liste des groupes ... 7/23
    public List<Groupe> GetListeGroupes(Personne perso) {
        PreparedStatement statementP = null;
        ResultSet res = null;
        String rq, id_groupe, titre;
        List<Groupe> list_gr = new LinkedList<>();
        boolean flag = true;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            if (perso.getClass().getName().equals("modele.Enseignant")) {
                rq = "SELECT * FROM groupe where id_enseignant = ?";
            } else {
                rq = "SELECT * FROM affectation a JOIN groupe g ON (a.id_groupe = g.id_groupe) "
                        + "WHERE a.id_etudiant = ?";
            }
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, perso.getId_personne());
                res = statementP.executeQuery();
                while (res.next()) {
                    id_groupe = res.getString("id_groupe");
                    titre = res.getString("titre");
                    list_gr.add(new Groupe(id_groupe, titre));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Désolé, cet ID_groupe déjà utilisé, veuillez le changer\n" + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
            flag = false;
        }
        if (flag) {
            System.out.println("Voici la liste des groupes :\n" + list_gr.toString()
                    + "\nListe des groupes : " + list_gr.toString());
        }
        return list_gr;

    }*/

    /*@Override  // 3)Supprimer un groupe ... 8/23
    public void SupprimerGroupe(String id_groupe) {
        PreparedStatement statementP = null;
        String rq;
        int nbr = 0;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "DELETE FROM groupe where id_groupe = ?";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, id_groupe);
                nbr = statementP.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Désolé, cet ID_groupe déjà utilisé, veuillez le changer\n" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
        }
        if (nbr > 0) {
            System.out.println("Le groupe suivant a été bien supprimé :\n" + nbr + "-ID_groupe : " + id_groupe);
        }

    }*/

    /*@Override  // 4)Modifier un groupe ... 9/23
    public void ModifierGroupe(String id_groupe, String titre) {
        PreparedStatement statementP = null;
        String rq;
        int nbr = 0;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "UPDATE groupe SET titre = ? WHERE id_groupe = ?";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, titre);
                statementP.setString(2, id_groupe);
                nbr = statementP.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Désolé, cet ID_groupe déjà utilisé, veuillez le changer\n" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
        }
        if (nbr > 0) {
            System.out.println("Le groupe suivant a été bien modifié :\n" + nbr + "-ID_groupe : " + id_groupe);
        }
    }*/

   /* @Override  // 5)Ajouter une invitation pour joindre un groupe ... 12/23
    public void SetInvitation(Invitation invit) {

        PreparedStatement statementP = null;
        String rq;
        boolean flag = true;
        int nbr = 0;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "INSERT INTO invitation (id_enseignant, id_etudiant,id_groupe,date, heure,commentaire) VALUES (?, ?, ?, ?, ?, ?);";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, invit.getId_enseignant());
                statementP.setString(2, invit.getId_etudiant());
                statementP.setString(3, invit.getId_groupe());
                statementP.setString(4, invit.getDate());
                statementP.setString(5, invit.getHeure());
                statementP.setString(6, invit.getCommentaire());
                nbr = statementP.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion " + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
            flag = false;
        }
        if (flag) {
            System.out.println("L'invitation  suivante a été bien envoyée :\nID_etudiant : " + invit.getId_etudiant()
                    + "ànID_groupe : " + invit.getId_groupe());
        }

    }*/

    @Override  // 6)Recuperer la liste des invitations en cours, pour un enseignant ... 13/23
    public List<Invitation> GetListeInvitations(Personne perso) {
        PreparedStatement statementP = null;
        ResultSet res = null;
        String rq, id_etudiant, id_groupe, titre, nom, prenom, date, heure, commentaire;
        List<Invitation> list_invi = new LinkedList<Invitation>();
        Invitation invit;
        boolean flag = true;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            if (perso instanceof Enseignant) {
                rq = "SELECT * FROM invitation i "
                        + "JOIN personne p ON(i.id_etudiant= p.id_personne) "
                        + "JOIN groupe g ON(i.id_groupe= g.id_groupe) "
                        + "WHERE i.id_enseignant = ? AND i.statut is null";
            } else {
                rq = "SELECT * FROM invitation i "
                        + "JOIN personne p ON(i.id_enseignant= p.id_personne) "
                        + "JOIN groupe g ON(i.id_groupe= g.id_groupe) "
                        + "WHERE i.id_etudiant = ? AND i.statut is null";
            }
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, perso.getId_personne());
                res = statementP.executeQuery();
                while (res.next()) {
                    id_etudiant = res.getString("id_etudiant");
                    id_groupe = res.getString("id_groupe");
                    titre = res.getString("titre");
                    nom = res.getString("nom");
                    prenom = res.getString("prenom");
                    date = res.getString("date");
                    heure = res.getString("heure");
                    commentaire = res.getString("commentaire");
                    invit = new Invitation(id_etudiant, id_groupe, titre, nom, prenom, date, heure, commentaire);
                    list_invi.add(invit);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Désolé, cet ID_groupe déjà utilisé, veuillez le changer\n" + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
            flag = false;
        }
        if (flag) {
            System.out.println("Voici la liste des invitations en cours :\n" + list_invi.toString());
        }
        return list_invi;
    }

   /* @Override  // 7) Annuler une invitation en cours ... 14/23
    public void DeleteInvitation(Invitation invit) {
        PreparedStatement statementP = null;
        String rq;
        int nbr = 0;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "Delete FROM invitation WHERE id_groupe = ? AND id_etudiant = ? AND statut is NULL;";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, invit.getId_groupe());
                statementP.setString(2, invit.getId_etudiant());
                nbr = statementP.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Désolé, cet ID_groupe déjà utilisé, veuillez le changer\n" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
        }
        System.out.println("L'invitation suivante a été bien supprimée :\n" + nbr + "-ID_groue : " + invit.getId_groupe() + "\nID_etudiant : " + invit.getId_etudiant());

    }*/

    @Override  // 8)Recuperer un titre d'un groupe ... 15/23
    public String GetTitreGroupe(String id_groupe) {
        PreparedStatement statementP = null;
        ResultSet res = null;
        String rq, titre = "";
        List<Groupe> list_gr = new LinkedList<>();
        boolean flag = true;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "SELECT titre FROM groupe WHERE id_groupe = ?";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, id_groupe);
                res = statementP.executeQuery();
                if (res.next()){
                    titre = res.getString("titre");
                    System.out.println("Voici le titre du group n"+id_groupe+" : " + titre);
                } else
                    System.out.println("Le group n"+id_groupe+" n'existe pas! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Désolé, probleme de connexion" + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
            flag = false;
        }
        return titre;
    }

    @Override   // 6)Recuperer un titre d'un groupe ... 16/23
    public boolean IsInvitationExiste(String id_etudiant, String id_groupe) {
        PreparedStatement statementP = null;
        ResultSet res = null;
        String rq;
        boolean flag = false;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "SELECT * FROM invitation WHERE (id_etudiant = ?) AND (id_groupe = ?) AND (statut IS NULL)";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, id_etudiant);
                statementP.setString(2, id_groupe);
                res = statementP.executeQuery();
                if (res.next()){
                    flag = true;
                    System.out.println("L'invitation existe n :"+id_etudiant+" / " + id_groupe);
                } else
                    System.out.println("L'invitation n'existe pas!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Désolé, probleme de connexion" + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autres Probleme!!!" + ex.getMessage());
            flag = false;
        }
        return flag;
        
        

     
    }
}
