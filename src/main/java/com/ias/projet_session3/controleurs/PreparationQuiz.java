/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.controleurs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ias.projet_session3.entities.Erreur_image;
import com.ias.projet_session3.entities.ListeQuestions;
import com.ias.projet_session3.entities.Personne;
import com.ias.projet_session3.entities.QCM;
import com.ias.projet_session3.entities.Question;
import com.ias.projet_session3.entities.Resultat_execution;
import com.ias.projet_session3.entities.Scenario;
import com.ias.projet_session3.services.QuestionService;

/**
 *
 * @author BaDRi
 */
public class PreparationQuiz extends HttpServlet {

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
        String dest = "/WEB-INF/etudiant/preparerQuiz.jsp";
        Personne perso = (Personne) session.getAttribute("perso");
        Question ques;
        int typeQuestChoisies = 0;
        if (perso == null) {
            dest = "acceuil";
        } else if (request.getParameter("source") != null) {

            int nombreQues = Integer.parseInt((String) request.getParameter("nombreQues"));
            String choixQcm = (String) request.getParameter("cbxQCM");
            String cbxImgErreur = (String) request.getParameter("cbxImgErreur");
            String cbxResultatExs = (String) request.getParameter("cbxResultatExs");
            if (choixQcm != null || cbxImgErreur != null || cbxResultatExs != null) {
                ListeQuestions listeQues = QuestionService.ChargerLesQuestions(perso.getId_personne());
                dest = "/WEB-INF/etudiant/quiz.jsp";
                System.out.println(nombreQues + " : " + choixQcm + " : " + cbxImgErreur + " : " + cbxResultatExs);
                if (choixQcm != null) {
                    typeQuestChoisies += 1;
                }
                if (cbxImgErreur != null) {
                    typeQuestChoisies += 2;
                }
                if (cbxResultatExs != null) {
                    typeQuestChoisies += 4;
                }
                System.out.println("typeQuestChoisies : " + typeQuestChoisies);
                Scenario monScenario = new Scenario(nombreQues, listeQues, typeQuestChoisies);
                List<QCM> maListeQCM = new LinkedList();
                List<Erreur_image> maListeImg = new LinkedList();
                List<Resultat_execution> maListeExe = new LinkedList();
                int[] tab = monScenario.tableauCles();
                for (int i = 0; i < monScenario.getSize(); i++) {
                    ques = monScenario.getQuestionN(tab[i]);
                    if (ques instanceof QCM)
                        maListeQCM.add((QCM)ques);
                    else if (ques instanceof Erreur_image)
                        maListeImg.add((Erreur_image)ques);
                    else
                        maListeExe.add((Resultat_execution)ques);
                }
                session.setAttribute("maListeQCM", maListeQCM);
                session.setAttribute("maListeImg", maListeImg);
                session.setAttribute("maListeExe", maListeExe);
                System.out.println("tt ok");
            }
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
