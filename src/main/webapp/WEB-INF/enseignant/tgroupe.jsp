<%@page import="com.ias.projet_session3.entities.Etudiant"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="fr">
    <head>
       <meta charset="utf-8">
        <!-- Le titre de la page-->
        <title>Bannque de question de Bois-de-Boulogne</title>
        <!-- Ajout d'une icone au titre de la page-->
        <script src="scripts/script.js"></script>
        <!-- Ajout d'une icone au titre de la page-->
        <link rel="icon" href="images/image5.jfif">

        <!--<meta name="viewport" content="width=device-width, initial-scale=1">-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>   
        <script src ="scripts/scriptAjax.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/responsee.css">
        <link rel="stylesheet" href="css/template-style.css">


        <!-- Chargement des polices (fontawesome)--> 
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script> 
        <!-- Chargement des polices (google)-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/responsee.css">
        <link rel="stylesheet" href="css/template-style.css">
    </head>
    <body>
        
        
        <%@include file="/WEB-INF/enseignant/enteteEnsei.jspf" %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <!--liste des groupe -->
        <div class="container">
            <div class="row">
                <div class="col-md-9">
                    <h2><fmt:message key="groupEns.liste"/></h2>
                </div>
                <div class="col-md-3">
                    <h4>
                    <input id="btnCreerGroupe" type="button" name="btnCreerGroupe" value="Créer un nouveau groupe" class="btn btn-link">
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9">
                    <div>
                        <form id="formGroupe" name="formGroupe" action="" method="post">
                            <ol>
                                <table width="1416.5" height="99" border="1" id="tabGroupe">
                                    <tr>
                                        <th width="168.5" scope="col"><fmt:message key="groupEns.code"/></th>
                                        <th width="452.5" scope="col"><fmt:message key="groupEns.titreGroupe"/></th>
                                    </tr>
                                    <tbody>
                                        <c:forEach var="groupe" items="${sessionScope.list_groupe}">
                                        <tr>
                                            <td><a href=ListerEtudiant?source=${groupe.id_groupe}>${groupe.id_groupe}</a></td>
                                             <td>${groupe.titre}</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <input id="btnModifier" type="button" name="" value=<fmt:message key="groupEns.btnModifer"/> class="btn-secondary">
                                <input id="btnSupprimer" type="button" name="" value=<fmt:message key="groupEns.btnSupprimer"/> class="btn-secondary">
                            </ol>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <br>
    
         <!-- Zone detail d'un groupe-->
        <div class="container" id="zoneDetailGroupe">
            <div class="row">
                <div class="col-md-6" >
                    <div class="card">
                        <h5 class="card-header text-center" ><b><fmt:message key="groupEns.details"/></b></h5>
                            <div id="detailGroupe">
                                <form name="formDetailGroupe" action="PageGroupes?source=creer" method="post">
                                <br>
                                    <div class="form-group">
                                        <label for="textfield" > <b><fmt:message key="groupEns.lblCode"/></b></label>
                                        <input type="text"    class="form-control" name="id_goupe" id="id_groupe" data-error="Le champ 'No de DA' est requis."  required/>
                                        <label><b><fmt:message key="groupEns.lblGroupe"/></b></label>
                                        <input type="text"    class="form-control" name="titre" id="titre" data-error="Le champ 'No de DA' est requis."  required />
                                        <div class="help-block with-errors"></div>
                                        <br>
                                        <div> 
                                        <input type="submit" class="btn btn-success"  value="Soumettre" method="post"/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                    </div>
                </div>
            </div>
        </div>
         
         <!-- Zone de Modification d'un groupe-->
        <div class="container" id="zoneModifierGroupe">
            <div class="row">
                <div class="col-md-6" >
                    <div class="card">
                        <h5 class="card-header text-center" ><b><fmt:message key="groupEns.detailsModif"/></b></h5>
                            <div id="detailGroupe">
                                <form name="formDetailGroupe" action="PageGroupes?source=modifier" method="post">
                                <br>
                                    <div class="form-group">
                                        <select name="id_goupeModif" class="btn-secondary">
                                           <option><fmt:message key="groupEns.optionModif"/></option>
                                            <c:forEach var="groupe" items="${sessionScope.list_groupe}"> 
                                            <option value="${groupe.id_groupe}">${groupe.id_groupe}</option>
                                            </c:forEach>
                                        </select><br><br><br>

                                        <label><b><fmt:message key="groupEns.titre"/></b></label>
                                        <input type="text" class="form-control" name="titreModif" id="titreModif" data-error="Le champ 'No de DA' est requis." required />
                                        <div class="help-block with-errors"></div>
                                        <br>
                                        <div> 
                                        <input type="submit" class="btn btn-success"  value="<fmt:message key="groupEns.btnModifer"/>" method="post"/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                    </div>
                </div>
            </div>
        </div>
        
          <!-- Zone de supprission d'un groupe-->
        <div class="container" id="zoneSupprimerGroupe">
            <div class="row">
                <div class="col-md-6" >
                    <div class="card">
                        <h5 class="card-header text-center" ><b>Détails Groupe à supprimer :<b></h5>
                            <div id="detailGroupe">
                                <form name="formDetailGroupe" action="PageGroupes?source=supprimer" method="post">
                                <br>
                                    <div class="form-group">
                                        <select name="id_goupeSupprim"  class="btn-secondary" id="id_goupeSupprim">
                                            <option>--Choisir le ID du groupe à modifer--</option>
                                            <c:forEach var="groupe" items="${sessionScope.list_groupe}">
                                            <option value="${groupe.id_groupe}">${groupe.id_groupe}</option>
                                            </c:forEach>
                                        </select><br><br><br>
                                        <br>
                                        <div> 
                                        <input type="submit" class="btn btn-success"  value="Supprimer" method="post"/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                    </div>
                </div>
            </div>
        </div>
        
        
        
        
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <h4><fmt:message key="groupEns.titreListe"/></h4>
                    <div class="col-md-4">
                        <h4 id="txt_IdGroupe" align="right">Groupe
                            <input type="text" disabled id="idGroupeSelect" size="4" value="${sessionScope.id_groupe_selec}">
                        </h4>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <form id="formGroupe" name="formGroupe" action="" method="post">
                            <ol>
                                <table width="1416.5" height="99" border="1" id="tabGroupe">
                                    <tr>
                                        <th width="168.5" scope="col">Numéro DA</th>
                                        <th width="452.5" scope="col">Nom</th>
                                        <th width="452.5" scope="col">Prénom</th>
                                        <th width="452.5" scope="col">Courriel</th>
                                    </tr>
                                    <tbody>
                                        <c:forEach var="etudiant" items="${sessionScope.list_etudiant}">
                                            <tr>
                                                <td width="168.5" scope="col">${etudiant.id_personne}</td>
                                                <td width="452.5" scope="col">${etudiant.nom}</td>
                                                <td width="452.5" scope="col">${etudiant.prenom}</td>
                                                <td width="452.5" scope="col">${etudiant.courriel}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </ol>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!--fin container -->
        <!-- separateur --> 
        <!-- Section de la galerie-->
        <section class="page-section portfolio" id="portfolio">
            <div class="divider-custom">
                <div class="divider-custom-line"></div>
                <div class="divider-custom-line"></div>
                <div class="divider-custom-line"></div>
            </div>
        </section>
        
        
        <!--liste des invitations -->
        <div class="container">
            <div class="row">
                <div class="col-md-9">
                    <a name="invitation"><h2><fmt:message key="groupEns.titreInv"/></h2></a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <form id="formGroupe" name="formGroupe" action="PageGroupes?source=annulerInv" method="post">
                            <ol>
                                <table border="1" id="tabGroupe">
                                    <tr>
                                        <th  scope="col">N de DA</th>
                                        <th  scope="col">Nom & Prénom</th>
                                        <th  scope="col">ID Groupe</th>
                                        <th scope="col">Titre groupe</th>
                                        <th  scope="col">Date</th>
                                        <th  scope="col">Heure</th>
                                        <th width="452.5" scope="col">Commentaire</th>
                                    </tr>
                                    <tbody>
                                        <c:forEach var="invit" items="${sessionScope.list_invit}">
                                        <tr>
                                            <td>${invit.id_etudiant}</td>
                                            <td>${invit.nom} ${invit.prenom}</td>
                                            <td>${invit.id_groupe}</td>
                                            <td>${invit.titre}</td>
                                            <td>${invit.date}</td>
                                            <td>${invit.heure}</td>
                                            <td>${invit.commentaire}</td>
                                            <td><input type="radio" name="listInvitation" value="${invit.id_etudiant}_${invit.id_groupe}" /> 
                                        </tr>
                                        </c:forEach> 
                                    </tbody>
                                </table>
                                <%
                                String retour = request.getParameter("retour");
                                if (retour != null) {
                                    out.println("<div><table border='0' style='color:red;background: #F2D7D5'>");
                                    if (retour.equals("choisirInvit")) {
                                        out.println("<tr><b><th style='size :15;'>Invitation non anuulée</th></b></tr>"
                                                + "<tbody>"
                                                + "<tr><td>Vous devez cocher l'invitation à annuler.</td></tr>"
                                                + "</tbody>"
                                                + "</table >");
                                    }
                                session = request.getSession();
                                if (((List<Etudiant>)session.getAttribute("list_invit")) != null)
                                    if (((List<Etudiant>)session.getAttribute("list_invit")).size()>0)
                                    out.println("<input id='btnAnnuler' type='submit' value='Annuler invitation' class='btn-secondary'/>");
                                    }     
                                %>
                            </ol>
                        </form>
                    </div>
                </div>
            </div>
        </div>
         
         <!--trouver un etudiant -->
         <br><br><br>
         <div class="container">
            <div class="row">
                <div class="col-md-9">
                    <h4>Trouver un etudiant</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9">
                    <form id="formGroupe" name="formEtudiant" action="PageGroupes?source=chercherEtud" method="post">
                        <label><fmt:message key="groupEns.search"/>
                        </label>
                        <input type="text" name="motCle" id="motCle"/>
                        <input type="submit" value="<fmt:message key="groupEns.btnsearch"/>" class="btn-secondary"/>
                    </form>
                </div>
                <div class="col-md-12">
                    <div>
                        <form id="formGroupe" name="formEtudiant2" action="PageGroupes?source=envoyerInvit" method="post">
                            <ol>
                               
                                <table width="1416.5" height="99" border="1">
                                    <tr>
                                        <th width="168.5" scope="col"><fmt:message key="groupEns.num"/></th>
                                        <th width="452.5" scope="col"><fmt:message key="groupEns.nom"/></th>
                                        <th width="452.5" scope="col"><fmt:message key="groupEns.prenom"/></th>
                                        <th width="452.5" scope="col"><fmt:message key="groupEns.courriel"/></th>
                                    </tr>
                                    <tbody id="res">
                                      
                                    </tbody>
                                </table>
                            </ol>
                            <%
                                retour = request.getParameter("retour");
                                if (retour != null) {
                                    out.println("<div><table border='0' style='color:red;background: #F2D7D5'>");
                                    if (retour.equals("etudiantDsGroupe")) {
                                        out.println("<tr><b><th style='size :15;'>Invitation non envoyée</th></b></tr>"
                                                + "<tbody>"
                                                + "<tr><td>L'etudisnt invité est déja dans le meme groupe.</td></tr>"
                                                + "</tbody>"
                                                + "</table >");
                                    } else if (retour.equals("invitExiste")) {

                                        out.println("<tr><b><th style='size :15;'>Invitation non envoyée</th></b></tr>"
                                                + "<tbody>"
                                                + "<tr><td>Une invitation est déja en cours pour le meme etudiant et groupe.</td></tr>"
                                                + "</tbody>"
                                                + "</table >");
                                    } else if (retour.equals("erreurChoix")) {

                                        out.println("<tr><b><th style='size :15;'>Erreur de choix</th></b></tr>"
                                                + "<tbody>"
                                                + "<tr><td>Vous devez cocher l'etudiant et choisir le groupe pour l'inviter.</td></tr>"
                                                + "</tbody>"
                                                + "</table >");
                                    }
                                }
                            %>
                            
                            
                            <select name="id_goupeInvit"  class="btn-secondary" id="id_goupeInvit">
                                <option>--Choisir le ID du groupe pour inviter--</option>
                                <c:forEach var="groupe" items="${sessionScope.list_groupe}">
                                    <option value="${groupe.id_groupe}">${groupe.id_groupe}</option>
                                </c:forEach>
                            </select><br><br> 
                            
                            <%
                                session = request.getSession();
                                if (((List<Etudiant>)session.getAttribute("liste_etud")) != null)
                                    if (((List<Etudiant>)session.getAttribute("liste_etud")).size()>0) {
                                    out.println("<input type='submit' value='Envoyer invitation' class='btn-success'/>");
                                    }     
                            %>
                            <br>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                                    
        <section>
            <footer>
                <div align="center">reserved Copyright 2021 - IAS-Company.</div>
            </footer>
        </section>
    </body>
</html>