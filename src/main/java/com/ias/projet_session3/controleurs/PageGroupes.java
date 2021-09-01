/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.controleurs;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ias.projet_session3.entities.Etudiant;
import com.ias.projet_session3.entities.Groupe;
import com.ias.projet_session3.entities.Invitation;
import com.ias.projet_session3.entities.Personne;
import com.ias.projet_session3.services.EnseignantService;
import com.ias.projet_session3.services.EntitiesServiceJpa;
import com.ias.projet_session3.services.EtudiantService;
import com.ias.projet_session3.singleton.EntityManagerSingleton;
import javax.persistence.EntityTransaction;

/**
 *
 * @author BaDRi
 */
public class PageGroupes extends HttpServlet {

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
        String dest = "/WEB-INF/enseignant/tgroupe.jsp";  // monPortail
        Personne perso = (Personne) session.getAttribute("perso");
        String source = (String) request.getParameter("source");
        String motCle = (String) request.getParameter("motCle");
        Invitation invit;
        String id_enseignant, id_groupe;
        System.out.println("source = " + source);
        if (perso == null) {
            dest = "/acceuil.jsp";
        } else {
            if (source != null) {
                if (source.equals("creer")) {
                    id_groupe = request.getParameter("id_goupe");
                    String titre = request.getParameter("titre");
                    Groupe nouveauGroupe = new Groupe(id_groupe, titre, perso.getId_personne());
                    //EnseignantService.CreerGroupe(nouveauGroupe);
                    //Appel Jpa Dao
                    EntityTransaction tr = EntityManagerSingleton.getEntityManager().getTransaction();
                    tr.begin();
                    EntitiesServiceJpa.CreerGroupe(nouveauGroupe);
                    tr.commit();

                    EntityManagerSingleton.close();
                } else if (source.equals("modifier")) {
                    id_groupe = request.getParameter("id_goupeModif");
                    String titre = request.getParameter("titreModif");
                    //EnseignantService.ModifierGroupe(id_groupe, titre);  ...Jdbc
                    //Jpa :
                    EntitiesServiceJpa.ModifierGroupe(id_groupe, titre);
                } else if (source.equals("supprimer")) {
                    id_groupe = request.getParameter("id_goupeSupprim");
                   // EnseignantService.SupprimerGroupe(id_groupe);   ...jdbc
                   //jpa
                   EntitiesServiceJpa.SupprimerGroupe(id_groupe);
                } else if (source.equals("annulerInv")) {
                    /*String id_groupe = request.getParameter("id_goupeSupprim");
                    EnseignantService.SupprimerGroupe(id_groupe);*/
                    String annulInvit = request.getParameter("listInvitation");
                    if (annulInvit == null) {
                        dest = "/WEB-INF/enseignant/tgroupe.jsp?retour=choisirInvit";
                    } else {
                        StringTokenizer token = new StringTokenizer(annulInvit);
                        invit = new Invitation(token.nextToken("_"), token.nextToken("_"));
                        //EnseignantService.AnnulerInvitation(invit); ... Jdbc
                        //Jpa
                        EntitiesServiceJpa.AnnulerInvitation(invit);
                    }
                } else if (source.equals("chercherEtud")) {
                    /*String id_groupe = request.getParameter("id_goupeSupprim");
                EnseignantService.SupprimerGroupe(id_groupe);*/
                    if (!motCle.equals("")) {
                        List<Etudiant> list_etud = EtudiantService.RechercherEtudiant(motCle);
                        session.setAttribute("liste_etud", list_etud);
                        /*System.out.println("Liste etudiants recherches :");
                    for(Etudiant etud : list_etud)
                        System.out.println(etud.toString()); */
                    }
                } else if (source.equals("envoyerInvit")) {
                    /*String id_groupe = request.getParameter("id_goupeSupprim");
                    EnseignantService.SupprimerGroupe(id_groupe);*/
                    String id_etudiant;
                    System.out.println("id_goupeInvit  :  " + (String) request.getParameter("id_goupeInvit"));
                    System.out.println("etudiantChoisi" + request.getParameter("etudiantChoisi"));
                    if (((id_etudiant = (String) request.getParameter("etudiantChoisi")) != null)
                            && (id_groupe = (String) request.getParameter("id_goupeInvit")) != null) {
                        id_enseignant = perso.getId_personne();
                        invit = new Invitation(id_enseignant, id_etudiant, id_groupe);
                        System.out.println("invitation : " + invit.toString());

                        if (EtudiantService.VerifierEtudiantDansGroupe(id_etudiant, id_groupe)) {
                            dest = "/WEB-INF/enseignant/tgroupe.jsp?retour=etudiantDsGroupe";
                            System.out.println("VerifierEtudiantDansGroupe");
                        } else if (EnseignantService.VerifierInvitation(id_etudiant, id_groupe)) {
                            dest = "/WEB-INF/enseignant/tgroupe.jsp?retour=invitExiste";
                            System.out.println(".VerifierInvitation");
                        } else {
                            //EnseignantService.EnvoyerInvitation(invit);  ...Jdbc
                            //Jpa
                            EntitiesServiceJpa.EnvoyerInvitation(invit);
                        }
                    } else {
                        dest = "/WEB-INF/enseignant/tgroupe.jsp?retour=erreurChoix";
                    }
                }

            }
           // List<Groupe> list_groupe = EnseignantService.ChargerGroupes(perso);  ..jdbc
           //Jpa
           List<Groupe> list_groupe = EntitiesServiceJpa.ChargerGroupes(perso);
           List<Invitation> list_invit = EnseignantService.ChargerInvitation(perso);

            for (Invitation invitation : list_invit) {
                System.out.println(invitation.toString());
            }

            id_groupe = list_groupe.get(0).getId_groupe();
            List<Etudiant> list_etudiant = EtudiantService.EtudiantsGroupe(id_groupe);

            session.setAttribute("list_groupe", list_groupe);
            session.setAttribute("id_groupe_selec", id_groupe);
            session.setAttribute("list_etudiant", list_etudiant);
            session.setAttribute("list_invit", list_invit);
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
