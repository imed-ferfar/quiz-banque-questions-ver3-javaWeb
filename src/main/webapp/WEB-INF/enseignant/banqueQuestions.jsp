<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="fr">
    <head>
       <meta charset="utf-8">
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
<div class="container">
  <div class="row">
    <div class="col-md-9">
      <h2>Liste des Questions </h2>
    </div>
  </div>
    <div class="row">
        <div class="col-md-12">
            <div>
                <form id="formGroupe" name="formGroupe" action="" method="post">
                    <ol>
                        <table width="892" height="99" border="1" id="tabGroupe">
                            <tr>
                                <th width="74.5" scope="col">Code</th>
                                <th width="300" scope="col">Titre</th>
                                <th width="450" scope="col">Question</th>
                                <th width="120" scope="col">Code Ens</th>
                            </tr>
                           
                            <tbody>
                            <c:forEach var="ques" items="${sessionScope.maListe}">
                                 <tr>
                                <td><a href=Question?source=${ques.id_question}>${ques.id_question}</a></td>
                                <td>${ques.titre}</td>
                                <td>${ques.maQues}</td>
                                <td>${ques.id_enseignant}</td>
                                </tr>
                             </c:forEach>
                            </tbody>
                        </table>
                    </ol>
                </form>
            </div>
        </div>
        <div class="col-md-3">
      <h4 id="txtCreerQuestion" align="right" class=" btn-link">Ajouter Question</h4>
    </div>
    </div>
</div>
<br>

<div class="divider-custom">
  <div class="divider-custom-line"></div>
  <div class="divider-custom-line"></div>
  <div class="divider-custom-line"></div>
</div>
<div class="container">
  <div class="row">
    <div class="col-md-12" id="zoneNouvelleQuestion">
      <div class="card">
        <h5 class="card-header text-center">
          <label for="select">Select:</label>
          <b>Détails Question</b></h5>
        <div>
          <h5 class="card-header text-center"><b>Type de Question</b>
            <select name="TypeQuestionSelect" id="TypeQuestionSelect" class="btn-secondary">
              <option id="opt0" value="">== Veuillez choisir le type de question ==</option>
              <option id="opt1" value="QCM">Choisir la ou les bonnes réponses</option>
              <option id="opt2" value="Erreur">Trouver l'erreur dans ce code</option>
              <option id="opt3" value="Execution">Trouver le resultat d'execution de ce code</option>
            </select>	  
          </h5>
        </div>
        <div id="detailQuestion">
          
            <br>
            <div class="form-group">
              <!-- Tables des question type 1-->
              <div id="zoneTypeQuestion1">
                  <form name="formQuestionQCM" action="Questions?source=ajoutQCM" method="post">
                      <label><b>Titre Question</b></label>
                      <input type="text" class="form-control" name="titreQuestion" value="Choisir la ou les bonnes réponses" disabled/>
                      <label><b> Ponderation </b></label>
                      <input type="number" class="form-control" name="ponderation" id="textfieldPonderation" value="1" data-error="Le champ 'No de DA' est requis."  required />
                      <label><b> Partager </b></label>
                      <input type="checkbox" class="btn-secondary" name="cbxPartager" id="cbxPartager" value="ok" checked="" />
                      <br>
                      <br>
                      <label><b> Nombre de choix proposes</b></label>
                      <input name="nb_choix" type="number"  required class="form-control" id="textfieldNbrChoix" value="5" data-error="Le champ 'Nombre de choix' est requis." />
                      <label><b> La Question :</b></label>
                      <input name="laQuestion" type="text" required class="form-control" id="textfieldEnnonceQuestion" data-error="Le champ 'La Question' est requis." />
                      <table width="1088" border="1">
                          <tbody>
                              <tr>
                                  <th width="723" scope="col"> <label><b> Liste des choix</b></label>
                                  </th>
                                  <th width="120" scope="col">Bonne réponse</th>
                              </tr>
                              <tr>
                                  <td><input type="text" class="form-control" name="choix1" id="choix1" data-error="Le champ 'No de DA' est requis."  required /></td>
                                  <td><input type="checkbox" class="form-control" name="cbx1" id="cbx1"/></td>
                              </tr>
                              <tr>
                                  <td><input type="text" class="form-control" name="choix2" id="choix2" data-error="Le champ 'No de DA' est requis."  required /></td>
                                  <td><input type="checkbox" class="form-control" name="cbx2" id="cbx2"/></td>
                              </tr>
                              <tr>
                                  <td><input type="text" class="form-control" name="choix3" id="choix3" /></td>
                                  <td><input type="checkbox" class="form-control" name="cbx3" id="cbx3"/></td>
                              </tr>
                              <tr>
                                  <td><input type="text" class="form-control" name="choix4" id="choix4"/></td>
                                  <td><input type="checkbox" class="form-control" name="cbx4" id="cbx4"/></td>
                              </tr>
                              <tr>
                                  <td><input type="text" class="form-control" name="choix5" id="choix5"/></td>
                                  <td><input type="checkbox" class="form-control" name="cbx5" id="cbx5" /></td>
                              </tr>
                          </tbody>
                      </table>
                      <div>
                          <input class="btn-success" id="btnValiderQuestion" type="submit" value="Valider" align="center"/>
                      </div>
                  </form>
              </div>
              
              <!-- Tables des question type 2-->
              <div id="zoneTypeQuestion2">
                  <form name="formQuestionImage" action="Questions?source=ajoutImage" method="post" enctype="multipart/form-data">
                      <label><b>Titre Question</b></label>
                      <input type="text" class="form-control" name="textfieldTitreQuestion" id="textfieldTitreQuestion" value = "Trouver l'erreur dans ce code" disabled/>
                      <label><b> Ponderation </b></label>
                      <input type="number" class="form-control" name="ponderation" id="textfieldPonderation" value="1" data-error="Le champ 'Ponderation' est requis."  required />
                      <label><b> Partager </b></label>
                      <input type="checkbox" class="btn-secondary" name="cbxPartager" id="cbxPartager" checked="" />
                      <br>
                      <div>
                          <div id="dialog" title="Window title">
                              <p>Veuillez choisir une image pour la question</p>
                          </div>
                          <div id="zoneImage">
                              <input type="file" name="photo" size="50" onchange="previewFile()" class="btn-secondary"><br>
                              <img src="" height="270" width="570" alt="Image ...">
                          </div>
                          <label><b>Numéro Ligne</b></label>
                          <input type="number" class="form-control" name="numLigne" id="textfieldNumLigne" value="1" data-error="Le champ 'No de DA' est requis."  required/>

                          <label><b>Erreur</b></label>
                          <input type="text"    class="form-control" name="erreur" id="erreur" data-error="Le champ 'Erreur' est requis."  required />

                          <label><b>Correction</b></label>
                          <input type="text" class="form-control" name="correction" id="correction" data-error="Le champ 'Correction' est requis." required/>
                      </div>
                      <div>
                          <input class="btn-success"  id="btnValiderQuestion" type="submit" value="Valider"/>
                      </div>
                  </form>
              </div>
              
              <!-- Tables des question type 3-->
              <div id="zoneTypeQuestion3">
                  <form name="formQuestionExecution" action="Questions?source=ajoutExecution" method="post">
                      <label><b>Titre Question</b></label>
                      <input type="text" class="form-control" name="textfieldTitreQuestion" id="textfieldTitreQuestion"value="Trouver le resultat d'execution de ce code" disabled/>
                      <label><b> Ponderation </b></label>
                      <input type="number" class="form-control" name="ponderation" id="ponderation" value="1" data-error="Le champ 'Ponderation' est requis."  required />
                      <label><b> Partager </b></label>
                      <input type="checkbox" class="btn-secondary" name="cbxPartager" id="cbxPartager" checked="" />
                      <br>
                      <table width="1088" border="1">
                          <tbody>
                              <tr>
                                  <th width="723" scope="col"> <label><b>Tapez le code :</b></label>
                                  </th>
                              </tr>
                              <tr>
                                  <td> 
                                      <textarea class="form-control" id="laQuestion" name="laQuestion" rows="4" placeholder="Saisir le programme a executer "> </textarea>
                                  </td>
                              </tr>
                              <tr>
                                  <th width="723" scope="col"> <label><b> Resultat d'execution du code </b></label>
                                  </th>
                              </tr>
                              <tr> 
                                  <td><input type="text"  class="form-control" name="laReponse" id="laReponse" data-error="Le champ 'No de DA' est requis."  required /></td>
                              </tr>
                          </tbody>
                      </table>
                      <div>
                          <input class="btn-success"  id="btnValiderQuestion" type="submit" value="Valider"/>
                      </div>
                  </form>
              </div>
              <br>
              
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="divider-custom">
    <div class="divider-custom-line"></div>
    <div class="divider-custom-line"></div>
    <div class="divider-custom-line"></div>
</div>


<section>
  <footer>
    <div align="center">reserved Copyright 2021 - IAS-Company.</div>
  </footer>
</section>
</body>
</html>