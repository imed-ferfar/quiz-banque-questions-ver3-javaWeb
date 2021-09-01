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
import com.ias.projet_session3.entities.Personne;
import com.ias.projet_session3.services.CompteService;
import com.ias.projet_session3.entities.Enseignant;
import com.ias.projet_session3.entities.Etudiant;
import com.ias.projet_session3.utils.TraitementsServlets;

/**
 *
 * @author BaDRi
 */
public class PageProfil extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String dest = "";
        HttpSession session = request.getSession();
        String source = (String) request.getParameter("source");
        System.out.println("source : " + source);
        Personne perso = (Personne) session.getAttribute("perso");
        if (perso instanceof Enseignant)
            dest = "/WEB-INF/enseignant/profileEns.jsp";
        else if (perso instanceof Etudiant)
            dest = "/WEB-INF/etudiant/profileEtu.jsp";
        else
        
        if (session.getAttribute("perso") == null) {
            dest = "/acceuil.jsp";
        } else {
            if (source != null) {
                if (source.equals("modifInfo")) {
                    TraitementsServlets.modiferPersonne(request, perso);
                    session.setAttribute("perso", perso);
                } else if (source.equals("modifPasse")) {

                    String nouveauPasse = request.getParameter("nouveauPasse");
                    CompteService.ModifierMotPasse(perso.getId_personne(), nouveauPasse);
                }
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
