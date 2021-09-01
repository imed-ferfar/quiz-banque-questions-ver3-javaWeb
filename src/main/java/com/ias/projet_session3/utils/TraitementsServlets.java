/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.utils;

import javax.servlet.http.HttpServletRequest;
import com.ias.projet_session3.entities.Choix;
import com.ias.projet_session3.entities.Enseignant;
import com.ias.projet_session3.entities.Erreur_image;
import com.ias.projet_session3.entities.Etudiant;
import com.ias.projet_session3.entities.Personne;
import com.ias.projet_session3.entities.QCM;
import com.ias.projet_session3.entities.Resultat_execution;
import com.ias.projet_session3.services.CompteService;
import com.ias.projet_session3.services.EntitiesServiceJpa;
import com.ias.projet_session3.services.QuestionService;
import static com.ias.projet_session3.utils.GestionCompte.GenererIdPersonne;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Part;

/**
 *
 * @author BaDRi
 */
public class TraitementsServlets {
    
    public static void ajouterQCM(HttpServletRequest request, int id_question, int ponderation, boolean partage, String id_enseignat) throws NumberFormatException {
        int nb_choix;
        String laQuestion;
        QCM maQCM;
        String unChoix;
        boolean reponse;
        nb_choix = Integer.parseInt((String) request.getParameter("nb_choix"));
        laQuestion = (String) request.getParameter("laQuestion");
        /* System.out.println("resultat : nb_choix : " + nb_choix);
        System.out.println("resultat : laQuestion " + laQuestion);*/
        maQCM = new QCM(id_question, laQuestion);
        Choix choix;
        for (int i = 1; i <= nb_choix; i++) {
            if (!(unChoix = (String) request.getParameter("choix" + i)).equals("")) {
                reponse = (((String) request.getParameter("cbx" + i)) != null);
                choix = new Choix(unChoix, reponse);
                maQCM.ajouterChoix(choix);
                System.out.println("choix : " + choix.toString());
            }
        }
        System.out.println("maQCM.isPartage() : " + maQCM.isPartage());
        maQCM.setPonderation(ponderation);
        maQCM.setPartage(partage);
        maQCM.setId_enseignant(id_enseignat);
        maQCM.setId_matiere("420-A07-BB");
        QuestionService.AjouterQuestion(maQCM);
    }
    
    
    public static void ajouterErreurImage(HttpServletRequest request, int id_question, int ponderation, boolean partage, String id_enseignat) throws ServletException, NumberFormatException {
        Erreur_image maQuesImg;
        InputStream inputStream = null; //
        try {
            Part filePart = request.getPart("photo");
            if (filePart != null) {
                int nbr = 55;
                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
                String urlImage = "/ImageErreurs/question" + id_question + ".png";
                File f = new File("C:/Users/BaDRi/source/repos/Projet1_questions" + urlImage);
                OutputStream os = new FileOutputStream(f);
                byte[] buf = new byte[1024];
                int len;
                while ((len = inputStream.read(buf)) > 0) {
                    os.write(buf, 0, len);
                }
                os.close();
                inputStream.close();
                
                int numLigne = Integer.parseInt(request.getParameter("numLigne"));
                String erreur = request.getParameter("erreur");
                String correction = request.getParameter("correction");
                maQuesImg = new Erreur_image(id_question, urlImage, numLigne, erreur, correction);
                
                System.out.println("resultat : numLigne : " + numLigne);
                System.out.println("resultat : urlImage : " + urlImage);
                
                maQuesImg.setPonderation(ponderation);
                maQuesImg.setPartage(partage);
                maQuesImg.setId_enseignant(id_enseignat);
                maQuesImg.setId_matiere("420-A07-BB");
                
                QuestionService.AjouterQuestion(maQuesImg);
            }
        } catch (IOException ex) {
            System.out.println("probleme IO : " + ex.getMessage());
        }
    }
    ///
    
    public static void ajouterResExecution(HttpServletRequest request, int id_question, int ponderation, boolean partage, String id_enseignat) {
        String laQuestion;
        String laReponse;
        Resultat_execution maQuesRes;
        laQuestion = request.getParameter("laQuestion");
        laReponse = request.getParameter("laReponse");
        maQuesRes = new Resultat_execution(id_question, laQuestion, laReponse);
        maQuesRes.setPonderation(ponderation);
        maQuesRes.setPartage(partage);
        maQuesRes.setId_enseignant(id_enseignat);
        maQuesRes.setId_matiere("420-A07-BB");
        QuestionService.AjouterQuestion(maQuesRes);
    }
    
    
    
    public static Personne creerPersonne(HttpServletRequest request) {
        
        String compte = request.getParameter("personne");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String courriel = request.getParameter("courriel");
        String motPasse = request.getParameter("motPasse");
        String motPasseConfirme = request.getParameter("motPasseConfirme");
        List<String> List_id = EntitiesServiceJpa.GetIdPersonnesJpa();
        String id_personne = GenererIdPersonne(List_id);
        Personne perso;
        if (compte.equals("enseignant")) {
            perso = new Enseignant();
            
            
            //id_personne, nom, prenom, courriel, motPasse, "true");
        } else {
            perso = new Etudiant();
            perso.setId_personne(id_personne);
            perso.setNom(nom);
            perso.setPrenom(prenom);
            perso.setCourriel(courriel);
            perso.setMotPasse(motPasse);
            perso.setEtat("true");
            // perso = new Etudiant(id_personne, nom, prenom, courriel, motPasse, "true");
        }
        perso.setId_personne(id_personne);
        perso.setNom(nom);
        perso.setPrenom(prenom);
        perso.setCourriel(courriel);
        perso.setMotPasse(motPasse);
        perso.setEtat("true");
        return perso;
    }
    
    
    public static void modiferPersonne(HttpServletRequest request, Personne perso) {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String courriel = request.getParameter("courriel");
        perso.setNom(nom);
        perso.setPrenom(prenom);
        perso.setCourriel(courriel);
        CompteService.ModifierInfos(perso);
    }
}
