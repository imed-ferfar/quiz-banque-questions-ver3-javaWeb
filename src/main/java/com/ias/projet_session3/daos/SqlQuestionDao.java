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
import com.ias.projet_session3.entities.Choix;
import com.ias.projet_session3.entities.Erreur_image;
import com.ias.projet_session3.entities.ListeQuestions;
import com.ias.projet_session3.entities.QCM;
import com.ias.projet_session3.entities.Question;
import com.ias.projet_session3.entities.Resultat_execution;
import com.ias.projet_session3.singleton.ConnexionBdd;

/**
 *
 * @author BaDRi
 */
public class SqlQuestionDao implements QuestionDao {

    @Override // 1)Charger les questions de la bdd ... 4/23
    public ListeQuestions ChargerLesQuestions(String id_enseig) {
        PreparedStatement statementP = null;
        ResultSet res = null;
        String rq = "", choix;
        ListeQuestions maListeQues = new ListeQuestions();
        String titre, id_enseignant, id_matiere, la_question, url_image, erreur, correction, le_code, reponse;

        int id_question, ponderation, num_ligne;
        boolean partage, statut_choix;
        QCM maQcm;
        Erreur_image maQesImg;
        Resultat_execution maQuesExe;
        Choix unChoix;
        List<String> listTemp = new LinkedList<>();

        //charger QCM :
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "SELECT *  FROM question q JOIN qcm c ON(q.id_question = c.id_question) WHERE (id_enseignant LIKE ?) OR partage = 'true'";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, id_enseig);
                res = statementP.executeQuery();
                while (res.next()) {
                    id_question = res.getInt("id_question");
                    titre = res.getString("titre");
                    ponderation = res.getInt("ponderation");
                    partage = res.getBoolean("partage");
                    id_enseignant = res.getString("id_enseignant");
                    id_matiere = res.getString("id_matiere");
                    la_question = res.getString("la_question");
                    maQcm = new QCM(id_question, titre, ponderation, partage, id_enseignant, id_matiere, la_question);
                    maQcm.setMaQues(la_question);
                    System.out.println("Question : " + maQcm.toString());
                    maListeQues.ajouterQuestion(maQcm);
                    listTemp.add(String.valueOf(id_question));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
        }

        //charger les choix de chaque QCM
        for (String tmp : listTemp) {
            try ( Connection cnx = ConnexionBdd.getConnexion();) {
                rq = "SELECT * FROM liste_choix where id_question = ?";
                statementP = cnx.prepareStatement(rq);
                if (statementP != null) {
                    statementP.setString(1, tmp);
                    res = statementP.executeQuery();
                    while (res.next()) {
                        choix = res.getString("choix");
                        statut_choix = res.getBoolean("statut_choix");
                        unChoix = new Choix(choix, statut_choix);
                        maQcm = (QCM) maListeQues.getQuestionN(Integer.parseInt(tmp));
                        maQcm.ajouterChoix(unChoix);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Probleme de connexion!!!" + ex.getMessage());
            }
        }

        // charger Image erreur
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "SELECT *  FROM question q JOIN erreur_image c ON(q.id_question = c.id_question) WHERE (id_enseignant LIKE ?) OR partage = 'true'";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, id_enseig);
                res = statementP.executeQuery();
                while (res.next()) {
                    id_question = res.getInt("id_question");
                    titre = res.getString("titre");
                    ponderation = res.getInt("ponderation");
                    partage = res.getBoolean("partage");
                    id_enseignant = res.getString("id_enseignant");
                    id_matiere = res.getString("id_matiere");

                    url_image = res.getString("url_image");
                    num_ligne = res.getInt("num_ligne");
                    erreur = res.getString("erreur");
                    correction = res.getString("correction");
                    maQesImg = new Erreur_image(id_question, titre, ponderation, partage, id_enseignant, id_matiere, url_image, num_ligne, erreur, correction);
                    maQesImg.setMaQues(url_image);
                    System.out.println("Question : " + maQesImg.toString());
                    maListeQues.ajouterQuestion(maQesImg);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
        }

        // charger Resultat execution
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "SELECT *  FROM question q JOIN resultat_execution c ON(q.id_question = c.id_question) WHERE(id_enseignant LIKE ?) OR partage = 'true'";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                statementP.setString(1, id_enseig);
                res = statementP.executeQuery();
                while (res.next()) {
                    id_question = res.getInt("id_question");
                    titre = res.getString("titre");
                    ponderation = res.getInt("ponderation");
                    partage = res.getBoolean("partage");
                    id_enseignant = res.getString("id_enseignant");
                    id_matiere = res.getString("id_matiere");

                    le_code = res.getString("le_code");
                    reponse = res.getString("reponse");
                    maQuesExe = new Resultat_execution(id_question, titre, ponderation, partage, id_enseignant, id_matiere, le_code, reponse);
                    maQuesExe.setMaQues(le_code);
                    System.out.println("Question : " + maQuesExe.toString());
                    maListeQues.ajouterQuestion(maQuesExe);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
        }
        return maListeQues;
    }

    @Override  //  2) Generer un id_question (min)  ... 20/23
    public int GetNewIdQuestion() {
        PreparedStatement statementP = null;
        ResultSet res = null;
        String rq, id_ques = "";
        boolean flag = true, existe = true;
        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "SELECT MAX(CONVERT(id_question,UNSIGNED INTEGER)) as 'max(id_question)' FROM question;";
            statementP = cnx.prepareStatement(rq);
            if (statementP != null) {
                res = statementP.executeQuery();
                if (res.next()) {
                    id_ques = res.getString("max(id_question)");
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
        if ((flag) && (existe)) {
            System.out.println("L'etudiant recherché existe dans le groupe");
        }
        return Integer.parseInt(id_ques) + 1;
    }

    @Override   //  3) Ajouter une nouvelle question  ... 21/23
    public void SetQuestion(Question ques) {
        PreparedStatement statementP, statementP2;
        String rq;
        String rq2 = "";
        boolean flag = true;
        QCM maQCM = null;
        Resultat_execution maResExe = null;
        Erreur_image maErrImg = null;

        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "INSERT INTO question (id_question, titre, ponderation, partage, id_enseignant, id_matiere) VALUES (?, ?, ?, ?, ?, ?);";
            if (ques instanceof QCM) {
                rq2 = "INSERT INTO qcm (id_question, la_question) VALUES (?, ?);";
                maQCM = (QCM) ques;
            } else if (ques instanceof Resultat_execution) {
                rq2 = "INSERT INTO Resultat_execution (id_question, le_code, reponse) VALUES (?, ?, ?);";
                maResExe = (Resultat_execution) ques;
            } else if (ques instanceof Erreur_image) {
                rq2 = "INSERT INTO erreur_image (`id_question`,`url_image`,`num_ligne`,`erreur`,`correction`) VALUES (?, ?, ?, ?, ?);";
                maErrImg = (Erreur_image) ques;
            }

            statementP = cnx.prepareStatement(rq);
            statementP2 = cnx.prepareStatement(rq2);
            if ((statementP != null) && (statementP2 != null)) {
                statementP.setInt(1, ques.getId_question());
                statementP.setString(2, ques.getTitre());
                statementP.setInt(3, ques.getPonderation());
                statementP.setString(4, Boolean.toString(ques.isPartage()));
                statementP.setString(5, ques.getId_enseignant());
                statementP.setString(6, ques.getId_matiere());
                if (ques instanceof QCM) {
                    statementP2.setInt(1, ques.getId_question());
                    statementP2.setString(2, maQCM.getLa_question());
                } else if (ques instanceof Resultat_execution) {
                    statementP2.setInt(1, ques.getId_question());
                    statementP2.setString(2, maResExe.getLe_code());
                    statementP2.setString(3, maResExe.getReponse());
                } else if (ques instanceof Erreur_image) {
                    statementP2.setInt(1, ques.getId_question());
                    statementP2.setString(2, maErrImg.getUrl_image());
                    statementP2.setInt(3, maErrImg.getNum_ligne());
                    statementP2.setString(4, maErrImg.getErreur());
                    statementP2.setString(5, maErrImg.getCorrection());
                }
                statementP.executeUpdate();
                statementP2.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autre probleme!!!" + ex.getMessage());
            flag = false;
        }
        if (ques instanceof QCM) {
            for (int i = 0; i < maQCM.getListe_choix().size(); i++) {
                try ( Connection cnx = ConnexionBdd.getConnexion();) {
                    rq = "INSERT INTO liste_choix(id_question, choix, statut_choix) VALUES(?, ?, ?)";
                    statementP = cnx.prepareStatement(rq);
                    if (statementP != null) {
                        statementP.setInt(1, ques.getId_question());
                        statementP.setString(2, maQCM.getListe_choix().get(i).getChoix());
                        statementP.setString(3, Boolean.toString(maQCM.getListe_choix().get(i).isStatut_choix()));
                        statementP.executeUpdate();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Probleme de connexion!!!" + ex.getMessage());
                    flag = false;
                } catch (Exception ex) {
                    Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Autre probleme!!!" + ex.getMessage());
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println("La question suivante a été bien ajoutée :\nID_question : " + ques.getId_question() + "\nTitre : " + ques.getTitre());
        }
    }

    @Override   //  4) Supprimer ma propre question  ... 22/23
    public void DeleteQuestion(Question ques) {
        PreparedStatement statementP, statementP2;
        String rq = "";
        String rq2;
        boolean flag = true;
        if (ques instanceof QCM) {
            for (int i = 0; i < ((QCM) ques).getListe_choix().size(); i++)
                   try ( Connection cnx = ConnexionBdd.getConnexion();) {
                statementP = cnx.prepareStatement("DELETE FROM liste_choix WHERE id_question = ?;");
                if (statementP != null) {
                    statementP.setInt(1, ques.getId_question());
                    statementP.executeUpdate();
                }
                rq = "DELETE FROM qcm WHERE id_question = ?;";
            } catch (SQLException ex) {
                Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Probleme de connexion!!!" + ex.getMessage());
                flag = false;
            } catch (Exception ex) {
                Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Autre probleme!!!" + ex.getMessage());
                flag = false;
            }
        } else if (ques instanceof Resultat_execution) {
            rq = "DELETE FROM resultat_execution WHERE id_question = ?;";
        } else if (ques instanceof Erreur_image) {
            rq = "DELETE FROM erreur_image WHERE id_question = ?;";
        }
        rq2 = "DELETE FROM question WHERE id_question = ?";

        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            statementP = cnx.prepareStatement(rq);
            statementP2 = cnx.prepareStatement(rq2);
            if ((statementP != null) && (statementP2 != null)) {
                statementP.setInt(1, ques.getId_question());
                statementP2.setInt(1, ques.getId_question());
                statementP.executeUpdate();
                statementP2.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autre probleme!!!" + ex.getMessage());
            flag = false;
        }
        if (flag) {
            System.out.println("La question suivantt a été bien supprimé :\nID_question : " + ques.getId_question());
        }

    }

    @Override  //  5) Editer ma propre question   ... 23/23
    public void EditerQuestion(Question ques) {
        PreparedStatement statementP, statementP2;
        String rq;
        String rq2 = "", rq3;
        boolean flag = true;
        QCM maQCM = null;
        Resultat_execution maResExe = null;
        Erreur_image maErrImg = null;

        try ( Connection cnx = ConnexionBdd.getConnexion();) {
            rq = "UPDATE question SET ponderation = ?, partage = ?, id_matiere =  ? WHERE id_question = ?;";
            if (ques instanceof QCM) {
                rq2 = "UPDATE  qcm SET la_question = ? WHERE id_question = ?;";
                maQCM = (QCM) ques;
            } else if (ques instanceof Resultat_execution) {
                rq2 = "UPDATE resultat_execution SET `le_code` = ?, `reponse` = ? WHERE `id_question` = ?;";
                maResExe = (Resultat_execution) ques;
            } else if (ques instanceof Erreur_image) {
                rq2 = "UPDATE erreur_image SET `url_image` = ?, `num_ligne` = ?, `erreur` = ?,"
                        + " `correction` = ? WHERE `id_question` = ?;";
                maErrImg = (Erreur_image) ques;

            }
            statementP = cnx.prepareStatement(rq);
            statementP2 = cnx.prepareStatement(rq2);
            if ((statementP != null) && (statementP2 != null)) {
                statementP.setInt(1, ques.getPonderation());
                statementP.setBoolean(2, ques.isPartage());
                statementP.setString(3, ques.getId_matiere());
                statementP.setInt(4, ques.getId_question());
                if (ques instanceof QCM) {
                    statementP2.setString(1, maQCM.getLa_question());
                    statementP2.setInt(2, ques.getId_question());
                } else if (ques instanceof Resultat_execution) {
                    statementP.setInt(3, ques.getId_question());
                    statementP2.setString(1, maResExe.getLe_code());
                    statementP2.setString(2, maResExe.getReponse());
                } else if (ques instanceof Erreur_image) {
                    statementP.setInt(5, ques.getId_question());
                    statementP2.setString(1, maErrImg.getUrl_image());
                    statementP2.setInt(2, maErrImg.getNum_ligne());
                    statementP2.setString(3, maErrImg.getErreur());
                    statementP2.setString(4, maErrImg.getCorrection());
                }
                statementP.executeUpdate();
                statementP2.executeUpdate();
                System.out.println("ok");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion!!!" + ex.getMessage());
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Autre probleme!!!" + ex.getMessage());
            flag = false;
        }
        if (ques instanceof QCM) {
            for (int i = 0; i < maQCM.getListe_choix().size(); i++) {
                try ( Connection cnx = ConnexionBdd.getConnexion();) {
                    rq = "DELETE FROM liste_choix WHERE `id_question` = ?;";
                    rq2 = "INSERT INTO liste_choix(id_question, choix, statut_choix) VALUES(?, ?, ?)";
                    statementP = cnx.prepareStatement(rq);
                    statementP2 = cnx.prepareStatement(rq2);
                    if ((statementP != null) && (statementP != null)) {
                        statementP.setInt(1, ques.getId_question());

                        statementP2.setInt(1, ques.getId_question());
                        statementP2.setString(2, maQCM.getListe_choix().get(i).getChoix());
                        statementP2.setBoolean(3, maQCM.getListe_choix().get(i).isStatut_choix());

                        statementP.executeUpdate();
                        statementP2.executeUpdate();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Probleme de connexion!!!" + ex.getMessage());
                    flag = false;
                } catch (Exception ex) {
                    Logger.getLogger(SqlCompteDao.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Autre probleme!!!" + ex.getMessage());
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println("La question suivante a été bien modifiée :\nID_question : " + ques.getId_question() + "\nTitre : " + ques.getTitre());
        }
    }
}
