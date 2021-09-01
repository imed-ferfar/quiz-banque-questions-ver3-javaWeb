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
        <script src="/scripts/scriptEtud.js"></script>

        <link rel="stylesheet" href="./index.css">

    </head>
    <body>
        <%@include file="/WEB-INF/etudiant/enteteEtud.jspf" %>

        <br><br><br><br><br><br>
 
        <div class="divider-custom">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-line"></div>
            <div class="divider-custom-line"></div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-12"">
                    <div class="card">
                        <h4 class="card-header text-center">
                            <label for="select">Select:</label>
                            <b>Détails Question</b>
                        </h4>
                        <form name="formPreparerQuiz" action="PreparerQuiz?source=ok" method="post">
                            <div>
                                <h5 class="card-header text-center"><b>Veuillez choisir le nombre de question du quiz</b>
                                    <select name="nombreQues" id="TypeQuestionSelect">
                                        <option id="opt0" value="5">5 </option>
                                        <option id="opt1" value="10">10 </option>
                                        <option id="opt2" value="15">15 </option>
                                        <option id="opt3" value="25">25 </option>
                                    </select>	  
                                </h5>
                            </div>
                            <br>
                            <div class="form-group">
                                <label for="textfield"> <b> Question à choix multiple</b></label>
                                <input type="checkbox" class="form-control" name="cbxQCM" id="cbxChoixMultiple" value="1"/>

                                <label for="textfield"> <b>Trouver erreur dans une partie du code </b></label>
                                <input type="checkbox" class="form-control" name="cbxImgErreur" id="cbxTrouverErreur" value="2"/>

                                <label><b>Trouver le resultat d'execution</b></label>
                                <input type="checkbox"  class="form-control" id="cbxFindResult" name="cbxResultatExs" value="4"/>
                                <br>
                                <input type="submit"  value="Lancer Quiz"  class=" btn btn-success"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="divider-custom">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-line"></div>
            <div class="divider-custom-line"></div>
        </div>
        <section class="page-section portfolio">
        </section>
        <section>
            <footer>
                <div align="center">reserved Copyright 2021 - IAS-Company.</div>
            </footer>
        </section>
    </body>
</html>