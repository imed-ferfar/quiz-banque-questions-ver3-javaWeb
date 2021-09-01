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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ias.projet_session3.entities.ListeQuestions;
import com.ias.projet_session3.entities.Personne;
import com.ias.projet_session3.services.QuestionService;
import com.ias.projet_session3.utils.TraitementsServlets;

/**
 *
 * @author BaDRi
 */
@WebServlet(name = "Questions", urlPatterns = {"/Questions"})

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB 
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class Questions extends HttpServlet {

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

        String dest = "/WEB-INF/enseignant/banqueQuestions.jsp";  // monPortail
        String id_enseignat;
        int id_question, ponderation;
        boolean partage;
    

        HttpSession session = request.getSession();
        String source = (String) request.getParameter("source");
        Personne perso = (Personne) session.getAttribute("perso");

        if (source != null) {
            id_enseignat = perso.getId_personne();
            id_question = QuestionService.NouveauIdQuestion();
            ponderation = Integer.parseInt((String) request.getParameter("ponderation"));
            partage = (((String) request.getParameter("cbxPartager")) != null);

            /*System.out.println("resultat : id_enseignat :" + id_enseignat);
            System.out.println("resultat : id_question :" + id_question);
            System.out.println("resultat : ponderation : " + ponderation);
            System.out.println("resultat : partage : " + partage);
            System.out.println("resultat : partage val: " + (String) request.getParameter("cbxPartager"));*/

            //=======================QCM=====================
            
            if (source.equals("ajoutQCM")) {
                TraitementsServlets.ajouterQCM(request, id_question, ponderation, partage, id_enseignat);
                
            } //=======================ajoutImage=====================
            else if (source.equals("ajoutImage")) {
                TraitementsServlets.ajouterErreurImage(request, id_question, ponderation, partage, id_enseignat);
            } //=======================ajoutExecution=====================
            else if (source.equals("ajoutExecution")) {
                TraitementsServlets.ajouterResExecution(request, id_question, ponderation, partage, id_enseignat);
            }
        }

        ListeQuestions listeQues = QuestionService.ChargerLesQuestions(perso.getId_personne());
        List maListe = new LinkedList();
        int[] tab = listeQues.tableauCles();
        for (int i = 0; i < listeQues.getSize(); i++) {
            maListe.add(listeQues.getQuestionN(tab[i]));
        }

        session.setAttribute("maListe", maListe);

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
