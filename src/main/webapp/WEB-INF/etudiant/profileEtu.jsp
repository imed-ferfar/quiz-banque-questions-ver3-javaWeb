<!DOCTYPE html>
<html lang="fr">
    <head>
        <!-- Le titre de la page-->
        <title>Bannque de question de Bois-de-Boulogne</title>
        <!-- Ajout d'une icone au titre de la page-->
        <link rel="icon" href="images/image5.jfif">

        <!--<meta name="viewport" content="width=device-width, initial-scale=1">-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/responsee.css">
        <link rel="stylesheet" href="css/template-style.css">
        <script src="/WEB-INF/scripts/script.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />

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
        <%@include file="/WEB-INF/etudiant/enteteEtud.jspf" %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center"> </div>

        <!--fin container --> 

        <!-- separateur -->

        <div class="container">
            <div class="row">
                <div class="col-md-9" id="zoneProfil">
                    <div class="card">
                        <h5 class="card-header text-center"><b>Profil Enseignant </b> </h5>
                        <div id="profilEns">
                            <form name="formProfilEns" action="PageProfil">
                                <div class="form-group">
                                    <div class="card-body">

                                        <form action="NouveauCompte" role="form" data-toggle="validator" method="post">
                                            <div class="form-group">
                                                <label>Numéro DA</label>
                                                <input type="text" class="form-control" data-error="Le nom est obligatoire" name="nom" id="txtNumEns"
                                                       value="${sessionScope.perso.id_personne}" maxlength="25"  placeholder="Num DA" required disabled>
                                                <input type="hidden" name="source" id="source" value="modifInfo">
                                                <div class="form-group">
                                                    <label>Nom</label>
                                                    <input type="text" class="form-control" data-error="Le nom est obligatoire" name="nom" id="nomEns" 
                                                           value="${sessionScope.perso.nom}" maxlength="25" pattern="^[a-zA-Z]*$" placeholder="Nom" required>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                                <div class="form-group">
                                                    <label>Prénom</label>
                                                    <input type="text" class="form-control" name="prenom" maxlength="25" minlength="3" pattern="^[a-zA-Z]*$"
                                                           id="prenom" placeholder="Prénom" value="${sessionScope.perso.prenom}"required>

                                                    <!-- Erreur -->
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                                <div class="form-group">
                                                    <label>Courriel</label>
                                                    <input type="email" class="form-control" name="courriel" id="courriel" placeholder="Courriel" 
                                                           value="${sessionScope.perso.courriel}" required>

                                                    <!-- Erreur -->
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                                <div class="form-group">
                                                    <button type="submit" class="btn btn-primary btn-block">Soumettre</button>
                                                </div>
                                            </div>
                                        </form>
                                        <!--  fin formulaire modification profil enseignant --> 

                                        <br>
                                        <div id=""><p id="msgSucces">  </p></div>
                                        <label id="lblModifPwd" class="btn-outline-primary"> <b>Modifier Mot de passe </b></label>
                                        <div class="form-group"> </div>
                                        <br>
                                        <div id="zoneModifPwd">
                                            <div class="card">
                                                <h5 class="card-header text-center"><b>Modifier mot de passe </b> </h5>
                                                <form name="formProfilEns" action="PageProfil">
                                                    <div class="form-group">
                                                        <div class="card-body">
                                                            <div class="form-group">
                                                                <label >Mot de passe actuel</label>
                                                                <input type="password" class="form-control" data-error="Le nom est obligatoire" name="nom" id="actualPwd"
                                                                       minlength="8"       maxlength="12"  placeholder="********" required >
                                                                <div class="form-group">
                                                                    <label>Nouveau mot de passe</label>
                                                                    <input type="password" class="form-control" data-error="Le nom est obligatoire" name="nouveauPasse" id="nouveauPasse"
                                                                           minlength="8"   maxlength="12"   placeholder="Nouveau  " required>
                                                                    <input type="hidden" name="source" id="source" value="modifPasse">

                                                                    <!-- Erreur -->
                                                                    <div class="help-block with-errors"></div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label>Confirmation mot de passe </label>
                                                                    <input type="password" class="form-control" name="confirmePasse"  minlength="8" maxlength="12"  
                                                                           id="confirmePasse" placeholder="Confirmation " required
                                                                           data-match="#nouveauPasse" data-match-error="Mot de passe non identique!">
                                                                     <input type="hidden" name="source" id="source" value="modifPasse">
                                                                </div>

                                                                <!-- dÃ©claration du bouton de validation -->
                                                                <div class="form-group">
                                                                    <button id="btnSave" type="submit" class="btn btn-primary btn-block">Enregistrer Modification Mot de passe</button>
                                                                    <button id="btnCancel" type="reset" class="btn btn-primary btn-block">Annuler Modification Mot de passe</button>
                                                                </div>
                                                                <br> 
                                                            </div>
                                                            <div class="help-block with-errors"></div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <!-- fin zonne modif mot de passe -->
                                        </form>
                                    </div>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <br><br><br><br><br><br><br><br>
        <footer>
            <div align="center">reserved Copyright 2021 - IAS-Company.</div>
        </footer>
    </section>
</body>
</html>