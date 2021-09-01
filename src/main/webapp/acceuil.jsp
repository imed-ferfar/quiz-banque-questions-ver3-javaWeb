
<%@page import="com.ias.projet_session3.entities.Personne"%>
<!DOCTYPE html>
<html  lang="fr">
    <head>
        <%@ page contentType="text/html; charset=UTF-8" %>
        <!-- Le titre de la page-->
        <title>Bannque de question de Bois-de-Boulogne</title>
        <!-- Ajout d'une icone au titre de la page-->
        <link rel="icon" href="images/image5.jfif">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet"></link>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
        <script src ="script.js"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/responsee.css">
        <link rel="stylesheet" href="css/template-style.css"> 
        <style>
            body {
                background:   #E67E30;
            }

            .container {
                max-width: 100000px;
            }
            .has-error label,
            .has-error input,
            .has-error textarea {
                color: red;
                border-color: red;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-9">
                    <div class="container-fluid">
                        <!-- data-ride=carrousel, demarre le slide des le chargement de la page-->
                        <!--.slide ajoute un effet de transition lorsqu'on passe d'une image à l'autre (on peut l'enlever)  -->
                        <div id="carouselExample" class="carousel slide" data-ride="carousel">
                            <!--Ajoute un indicateur pour savoir quelle image est actuellement affichée-->
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExample" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExample" data-slide-to="1"></li>
                                <li data-target="#carouselExample" data-slide-to="2"></li>
                                <li data-target="#carouselExample" data-slide-to="3"></li>
                                <li data-target="#carouselExample" data-slide-to="4"></li>
                                <li data-target="#carouselExample" data-slide-to="4"></li>
                                <li data-target="#carouselExample" data-slide-to="4"></li>
                            </ol>   

                            <div class="carousel-inner">  <!--div avec les images ou le texte à afficher: carrousel-inner-->
                                <div class="carousel-item active">
                                    <!--d-block et w-100 c'est pour empécher le navigateur d'aligner les images selon les positions par défaut -->
                                    <a href="tp2_page_info_1.html"><img class="d-block w-100" src="images/image1.jfif" alt="First slide"></a>
                                </div>
                                <div class="carousel-item">
                                    <a href="tp2_page_info_1.html"><img class="d-block w-100" src="images/image2.jfif" alt="Second slide"></a>
                                </div>
                                <div class="carousel-item">
                                    <a href="tp2_page_info_1.html"><img class="d-block w-100" src="images/image3.jpg" alt="Third slide"></a>
                                </div>
                                <div class="carousel-item">
                                    <a href="tp2_page_info_1.html"><img class="d-block w-100" src="images/image4.jfif" alt="Fourth slide"></a>
                                </div>
                                <div class="carousel-item">
                                    <a href="tp2_page_info_1.html"><img class="d-block w-100" src="images/image5.jfif" alt="Fifth slide"></a>
                                </div>
                                <div class="carousel-item">
                                    <a href="tp2_page_info_1.html"><img class="d-block w-100" src="images/image6.jfif" alt="Fifth slide"></a>
                                </div>
                                <div class="carousel-item">
                                    <a href="tp2_page_info_1.html"><img class="d-block w-100" src="images/image7.jfif" alt="Fifth slide"></a>
                                </div>
                            </div>

                            <!-- controles précédent et suivant-->
                            <a class="carousel-control-prev" href="#carouselExample" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" ></span>

                            </a>
                            <a class="carousel-control-next" href="#carouselExample" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" ></span>
                            </a>
                        </div>
                    </div>  
                </div>
                
                <div class="col-md-3" style="background:#FDEDEC">
                    <div style="text-align:center"> <br>  <br>  <br>
                        <h2>Projet Session #3</h2>
                        <h4>Programmation Orienté objet et base de données
                        <br> & <br> Application Web
                        </h4>

                    </div>

                    <div class="container md-12">
                        <div class="card">
                            <h4 class="card-header text-center">Se connecter</h4>
                            <div class="card-body">
                                <form action="Authentification" class="needs-validation" method="post">
                                    <!boutton radios>
                                    <div class="form-group" align="center">
                                        <label class="btn btn-warning">
                                            <input type="radio" name="personne" id="personne" value="enseignant" checked>Enseignant
                                        </label>
                                        <label class="btn btn-warning">
                                            <input type="radio"  name="personne" id="personne" value="etudiant" >Etudiant
                                        </label>
                                    </div>
                                    <%
                                        String tache = request.getParameter("source");
                                        if (tache != null) {
                                            out.println("<div><table border='0' style='color:red;background: #F2D7D5'>");
                                            if (tache.equals("erreur")) {
                                                out.println("<tr><b><th style='size :15;'>Erreur</th></b></tr>"
                                                        + "<tbody>"
                                                        + "<tr><td>Votre No de DA ou votre mot de passe est invalide.<br>"
                                                        + "Assurez - vous davoir sélectionné le bon type d'utilisateur ci-dessus et essayez à nouveau.</td></tr>"
                                                        + "</tbody>"
                                                        + "</table >");
                                            } else if (tache.equals("bloquer")) {

                                                out.println("<tr><b><th style='size :15;'>Compte bloqué</th></b></tr>"
                                                        + "<tbody>"
                                                        + "<tr><td>Votre compte est bloqué, veuillez contacter Le service technique.</td></tr>"
                                                        + "</tbody>"
                                                        + "</table >");
                                            } else if (tache.equals("new")) {

                                                out.println("<tr><b><th style='size :15;'>Bienvenue!</th></b></tr>"
                                                        + "<tbody>"
                                                        + "<tr><td>Voici votre n de DA :");%> 
                                                        ${sessionScope.perso.id_personne} 
                                                        <%out.println("</td></tr>"
                                                        + "</tbody>"
                                                        
                                                        + "</table >");
                                            }
                                            out.println("</div>");
                                        }
                                    %>
                                    <div class="form-group">
                                        <label>No de DA</label>
                                        <div class="form-group">
                                            <input type="text" data-minlength="7" maxlength="7" class="form-control" name="id_personne" id="id_personne" value="<% 
                                                   if (request.getSession().getAttribute("perso") != null)
                                                   out.println(((Personne)request.getSession().getAttribute("perso")).getId_personne());
                                                   else
                                                   out.println("1111111");
                                        %>"
                                                   data-error="Le champ 'No de DA' est requis." placeholder="0000000" required />

                                            <!-- Error -->
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Mot de passe</label>
                                        <div class="form-group">
                                            <input type="password" class="form-control" id="motPasse" name="motPasse" value="11111111"
                                                   data-error="Le champ 'Mot de passe' est requis." placeholder="********" required />
                                            <!-- Error -->
                                            <div class="help-block with-errors"></div>
                                            <div class="form-group" align="left">
                                                <a href="acceuil.jsp?source=erreurMotPasse" onclick=return oublierMotPasse();>Vous avez oublié votre mot de passe?</a>
                                            </div>
                                            <%
                                                tache = request.getParameter("source");
                                                if ((tache != null) && (tache.equals("erreurMotPasse"))) {
                                                    out.println("<span class='erreur'>Désolé, cette option n'est pas encore disponible.</span>");
                                                    out.println("<span class='erreur'>Veuillez contacter le service technique.</span>");
                                                    tache = null;
                                                }
                                            %>
                                        </div>
                                    </div>

                                    <div class="form-group" align="right">
                                        <button type="submit" class="btn btn-primary">Connexion</button>
                                    </div>
                                    <div class="form-group" align="left">
                                        <a href="formulaire_insc.html">Créer un nouveau compte.</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>