$(function () {
// $("#inpName").height(20) ;
//   $("#btnModif").width(130) ;
 //  $("#btnModif").height(45) ;

$("#btnModif").css({
"color": "green",
 "font-weight": "bold", 
"background": "yellow"
});
	
 
        
$("#zoneDetailGroupe").hide();
$("#zoneModifierGroupe").hide();
$("#zoneSupprimerGroupe").hide();
	
$("#zoneModifPwd").hide(); 

$("#zoneTypeQuestion1").hide();
$("#zoneTypeQuestion2").hide();
$("#zoneTypeQuestion3").hide();
$("#zoneNouvelleQuestion").hide();
 
});
 
$(function () {
    
    $("#btnCreerGroupe").click(function () {
        
        $("#zoneDetailGroupe").toggle(); 
        $("#zoneModifierGroupe").hide();
        $("#zonebtnValiderpprimerGroupe").hide();
  });
});


$(function () {
    
    $("#btnModifier").click(function () {
        $("#zoneModifierGroupe").toggle(); 
        $("#zoneDetailGroupe").hide();
        $("#zoneSupprimerGroupe").hide();
  });
});

$(function () {
    
    $("#btnSupprimer").click(function () {
        $("#zoneSupprimerGroupe").toggle(); 
        $("#zoneDetailGroupe").hide();
        $("#zoneModifierGroupe").hide();
  });
});

$(function () {
  $("#lblModifPwd").click(function () {
 
$("#zoneModifPwd").toggle(); 
	  
 if( $(this).hasClass('active') )
  $(this).text('Modifier Mot de passe');
else
  $(this).text('Masquer Modification');
   
  });
 
 $("#btnCancel").click(function () {
$("#zoneModifPwd").hide(); 
$("lblModifPwd").text('Modifier mot de passe');
 
  });

});







// fonction pour la page Question 
$(function () {
  $("#txtCreerQuestion").click(function () {
    $("#zoneNouvelleQuestion").toggle();
  });
});





$(function () {
    $("#TypeQuestionSelect").change(function () {
        var $option = $(this).find('option:selected');
        var value = $option.val(); //  to get value of option   ---->> content of "value" attrib
        var text = $option.text(); //  to get text              --->>> <option>Text</option> content
        //$("#textfieldTitreQuestion").val(text);

        if (value == 'QCM') {
            $("#zoneTypeQuestion1").toggle();
            $("#zoneTypeQuestion2").hide();
            $("#zoneTypeQuestion3").hide();

        } else if (value === 'Erreur') {

            $("#zoneTypeQuestion2").toggle();
            $("#zoneTypeQuestion1").hide();
            $("#zoneTypeQuestion3").hide();

        } else if (value == 'Execution') {

            $("#zoneTypeQuestion3").toggle();
            $("#zoneTypeQuestion1").hide();
            $("#zoneTypeQuestion2").hide();

        } else
        {
            $("#zoneTypeQuestion1").hide();
            $("#zoneTypeQuestion2").hide();
            $("#zoneTypeQuestion3").hide();
        }
    });

});




$(function(){
$("#open").click (function ()    // Open button Treatment
{
	
 var fileName = $('#inputImg').val();

  var clean=fileName.split('\\').pop(); // clean from C:\fakepath OR C:\fake_path 
 


	
	$('#zoneImage').empty(); 
  $('#zoneImage').append('<div id="dialog" title="image"><img src='+fileName  + '" width="300" /></div>');
        $('#dialog').dialog();
  
alert('clean file name : '+ fileName);
	
});


	
});

 // ============================ select image 
 
function previewFile() {
  const preview = document.querySelector('img');
  const file = document.querySelector('input[type=file]').files[0];
  const reader = new FileReader();

  reader.addEventListener("load", function () {
    // convert image file to base64 string
    preview.src = reader.result;
  }, false);

  if (file) {
    reader.readAsDataURL(file);
  }
}

// ==================================== end select image 





