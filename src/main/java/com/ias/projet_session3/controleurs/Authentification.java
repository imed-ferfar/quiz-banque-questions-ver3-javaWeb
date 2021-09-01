/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.controleurs;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ias.projet_session3.entities.Enseignant;
import com.ias.projet_session3.entities.Etudiant;
import com.ias.projet_session3.entities.ListeQuestions;
import com.ias.projet_session3.entities.Personne;
import com.ias.projet_session3.services.CompteService;
import com.ias.projet_session3.services.EntitiesServiceJpa;
import com.ias.projet_session3.services.QuestionService;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author BaDRi
 */
public class Authentification extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String dest;  // monPortail
        Personne perso = null;
        ListeQuestions listeQues;
        String id_enseig = "";

        String compte = request.getParameter("personne");
        String id_personne = request.getParameter("id_personne");
        String motPsse = request.getParameter("motPasse");

        if (compte.equals("etudiant")) {
            perso = new Etudiant(id_personne, motPsse);
        } else if (compte.equals("enseignant")) {
            perso = new Enseignant(id_personne, motPsse);
        }
        //Autentifier la personne
        perso = CompteService.AuthentifierPerso(perso);

        if (perso == null) {
            dest = "/acceuil.jsp?source=erreur";
        } else if (perso.getEtat().equals("true")) {
            if (perso instanceof Etudiant) {
                dest = "/WEB-INF/etudiant/portailEtudiant.jsp";
                id_enseig = "%";
            } else {
                dest = "/WEB-INF/enseignant/portailEnseignant.jsp";
                id_enseig = id_personne;
            }

            listeQues = QuestionService.ChargerLesQuestions(id_enseig);
            session.setAttribute("perso", perso);
            session.setAttribute("listeQues", listeQues);
            Locale localReq = request.getLocale();
            session.setAttribute("langue", localReq.getLanguage());

        } else {
            dest = "/acceuil.jsp?source=bloquer";
        }
        listeQues = QuestionService.ChargerLesQuestions(id_enseig);
        listeQues.listerQuestion();

        //=========================test de toutes les methodes JDBC/JPA du prijet==============//
        //QCM maQcm = (QCM)listeQues.getQuestionN(1);
        //maQcm.setId_question(10);
        //EnseignantService.CreerGroupe(new Groupe("test","test ","1111111"));
        // EnseignantService.ChargerGroupes(perso);
        //EnseignantService.ModifierGroupe("test", "new titre");
        //EnseignantService.SupprimerGroupe("test");
        // EtudiantService.VerifierEtudiantDansGroupe("3333333", "G1201");
        //EnseignantService.EnvoyerInvitation(new Invitation("1111111", "3333333", "g123", "Vous avez recu une invitation de la part de : Flou..."));
        // EnseignantService.ChargerInvitation(perso);
        //EnseignantService.AnnulerInvitation(new Invitation("3333333","g123"));
        //EnseignantService.TitreGroupe("G1201");
        //EnseignantService.VerifierInvitation("8540820", "g123");
        //CompteService.ModifierMotPasse("1111111", "000000000");
        //CompteService.ModifierInfos(perso);
        //System.out.println(QuestionService.NouveauIdQuestion());
        //QuestionService.AjouterQuestion(maQcm);
        //QuestionService.SupprimerQuestion(maQcm);
        // QuestionService.ModifierQuestion(maQcm);
        
        List<String> List_id = EntitiesServiceJpa.GetIdPersonnesJpa();
        System.out.println("==================");
        for (int i = 0;i<List_id.size();i++){
            System.out.println("\t"+List_id.get(i));
        }

        RequestDispatcher disp = getServletContext().getRequestDispatcher(dest);
        disp.forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
