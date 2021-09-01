

$(document).ready(function ()
{
    $("#motCle").keyup(function () {
        $("#res").empty();
        $.getJSON("ServletJson?motCle="+document.formEtudiant.motCle.value,
                function (result) {
                    $("#res").empty();
                    $.each(result,
                            function (i, etud) {
                                
                                //$("div").append(i + " " + ddd.id + " : " + ddd.name + " <br>");
                                $("#res").append("<tr><td>"+etud.id_personne+"</td><td>"+etud.nom+"</td><td>"+etud.prenom+"</td><td>"+etud.courriel+"</td><td>\n\
                                    <input type='radio' name='etudiantChoisi' value="+etud.id_personne+" /></td></tr>");
                            }
                    );
                }
        );
    }
    );
}
);