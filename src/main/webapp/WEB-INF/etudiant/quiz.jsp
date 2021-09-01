<%@page import="com.ias.projet_session3.entities.Resultat_execution"%>
<%@page import="com.ias.projet_session3.entities.Erreur_image"%>
<%@page import="com.ias.projet_session3.entities.QCM"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="./index.css">
    </head>
    <body>
        <%@include file="/WEB-INF/etudiant/enteteEtud.jspf" %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
 
        <div class="divider-custom">
          <div class="divider-custom-line"></div>
          <div class="divider-custom-line"></div>
          <div class="divider-custom-line"></div>
        </div>
        
        <div class="container">
          <div class="row">
            <div class="col-md-12">
                <div class="card">
          
        
        
    <!-- ====================Bloc1 Question type1  =================================-->
    
            <% 
            List<QCM> maListQCM = (List)session.getAttribute("maListeQCM");
            int i = 0;%>

      
            <c:forEach var="qcm" items="${sessionScope.maListeQCM}"> 
                <%QCM maQCM = maListQCM.get(i);%>
            <div>
                <form name="formQuiz1">
                    <br>
                    <div class="form-group"> <br>
                        <!-- Tables des question type 1-->
                        <div>
                            <h5 class="card-header text-center"><b>Question N <%out.println(i+1); i++;%> :  Choisir la ou les bonnes réponses</b> </h5>
                            <br>
                            <label><b>La question : </b></label>
                            <input name="id_goupe" type="text"  required class="form-control" id="textfieldEnnonceQuestion" value="${qcm.la_question}" disabled />
                            <table width="1088" border="1">
                                <tbody>
                                    <tr>
                                        <th><br></th>
                                        <th><br></th>
                                    </tr>
                                    <%for (int j = 0;j<maQCM.getListe_choix().size();j++){%>
                                    <tr>
                                        <td><input type="text" class="form-control" name="choix1" id="question1" value="<%out.println(maQCM.getListe_choix().get(j).getChoix());%>" disabled/></td>
                                        <td><input type="checkbox" class="form-control" name="cbx1" id="cbx1" "   /></td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div>
                        <input class="btn-secondary"  id="btnLancerQuiz" type="submit" value="Valider"/>
                    </div>
                </form>
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-line"></div>
                </div>
            </div>
            </c:forEach>
            <br><br><br><br><br>
        <!--    ===========Bloc1 Question type2 ================================= -->
        <% 
        List<Erreur_image> maListeImg = (List)session.getAttribute("maListeImg");
        int j = 0;%>
         <c:forEach var="quesImg" items="${sessionScope.maListeImg}"> 
              <%Erreur_image quesImg = maListeImg.get(i);%>
            <div>
                <form name="formQuiz2">
                    <br>
                    <div class="form-group">
                        <br>
                        <div>
                            <h5 class="card-header text-center"><b>Question N <%out.println(i+j+1); j++;%> : Trouver l'erreur dans ce code</b> </h5>
                            <div>
                                <div id="dialog" title="Window title">
                                    <div id="zoneImage">
                                        <br>
                                        <img src="images/image2.jfif" height="330" width="630" alt=""> </div><br>
                                    <label><b>Numéro de ligne</b></label>
                                    <input type="number"  class="form-control" name="textfieldNumLigne" id="textfieldNumLigne" data-error="Le champ 'Numéro de ligne." required    />
                                    <label><b>L'erreur</b></label>
                                    <input type="text"  class="form-control" name="textfieldErreur" id="textfieldErreur" data-error="Le champ 'L'erreur."  required/>
                                    <label><b>La correction</b></label>
                                    <input type="text"  class="form-control" name="textfieldCorrection" id="textfieldCorrection" data-error="Le champ 'La correctio." required    />
                                </div>
                            </div>
                            <!-- Tables des question type 2-->
                            <div class="help-block with-errors"></div>
                            <br>
                        </div>
                    </div>
                    <div>
                        <input class="btn-secondary"  id="btnLancerQuiz" type="submit" value="Valider"/>
                    </div>
                </form> 
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-line"></div>
                </div>
            </div> 
            </c:forEach>
            <br><br><br><br><br>
        <!-- ============Bloc1 Question type3===================== -->
         <% 
        List<Resultat_execution> maListeExe = (List)session.getAttribute("maListeExe");
        int k = 0;%>
         <c:forEach var="quesExe" items="${sessionScope.maListeExe}"> 
            <div>
              <form name="formQuiz3">
                <br>
                <div class="form-group">
                  <br>
                  <div>
                    <h5 class="card-header text-center"><b>Question N<%out.println(i+j+k+1); j++;%> :  Trouver le résultat d'exécution de ce code</b> </h5>
                    <table width="1088" border="1">
                      <tbody>
                        <tr>
                          <th width="723" scope="col"> <label><b> Question</b></label>
                          </th>
                        </tr>
                        <tr>
                          <td><textarea class="form-control" id="saisieQestType3" name="saisieQestType3" rows="4" disabled>${quesExe.le_code} </textarea></td>
                        </tr>
                        <tr>
                          <th width="723" scope="col"> <label><b> Resultat d'execution du code </b></label>
                          </th>
                        </tr>
                        <tr>
                          <td><input type="text"  class="form-control" name="reponseQestType3" id="reponseQestType3" data-error="Le champ 'No de DA' est requis."  required /></td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="help-block with-errors"></div>
                  <br>
                </div>
                <div>
                    <input class="btn-secondary"  id="btnLancerQuiz" type="submit" value="Valider"/>
                  </div>
              </form>
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-line"></div>
                </div>
            </div>
        </c:forEach>
        <!--            ============================================= --> 
        
        </div>
    </div>
  </div>
</div>
        <br><br><br>
    
    <section class="page-section portfolio" id="portfolio">
    </section>

    <section>
        <footer>
        <div align="center">reserved Copyright 2021 - IAS-Company.</div>
        </footer>
    </section>

    </body>
</html>