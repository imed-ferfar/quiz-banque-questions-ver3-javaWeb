// ========================== code page quiz etudiant


function enableBtnLancerQuiz(){
	$("#cbxChoixMultiple").click(function(){
  $("#btnLancerQuiz").prop("disabled", false); 
});

 $("#cbxTrouverErreur").click(function(){
  $("#btnLancerQuiz").prop("disabled", false); 
});
	
	$("#cbxFindResult").click(function(){
  $("#btnLancerQuiz").prop("disabled", false); 
});
}
 
// ===========

/*$(function () {
	enableBtnLancerQuiz();
	$("#btnLancerQuiz").click(function(){
		if( ($('input[name=cbxChoixMultiple]').is(':checked')) ||
		   ($('input[name=cbxTrouverErreur]').is(':checked') )||
		   ( $('input[name=cbxFindResult]').is(':checked'))
		  ){
    $("#btnLancerQuiz").prop("disabled", false); 
} else if( !($('input[name=cbxChoixMultiple]').is(':checked')) &&
		   !($('input[name=cbxTrouverErreur]').is(':checked') )&&
		   !( $('input[name=cbxFindResult]').is(':checked'))
 
		  ){
    $("#btnLancerQuiz").prop("disabled", true); 
}	
   
});
	
});*/

// =========



//  tester si les case cocher ou decocher 
/*
$(function () {
  $("#btnLancerQuiz").click(function(){
 
if( $('input[name=cbxChoixMultiple]').is(':checked') ){
    alert(" premier cocher jQuery c'est super");
} else {
    alert("premier decocher ");
}

  if( $('input[name=cbxTrouverErreur]').is(':checked') ){
    alert(" 2eme cocher jQuery c'est super");
} else {
    alert("2eme  decocher ");
}
	  
 if( $('input[name=cbxFindResult]').is(':checked') ){
    alert(" 3eme cocher jQuery c'est super");
} else {
    alert("3eme  decocher ");
}
	  	
});	
 
});  */


$("#cbxChoixMultiple").click(function() {
 
	$("#btnLancerQuiz").prop("disabled", true); 
	console.log("click . . . ");

});

$("#cbxTrouverErreur").click(function() {
 $("#btnLancerQuiz").prop("disabled", false); 
});

$("#cbxFindResult").click(function() {
  $("#btnLancerQuiz").attr("enabled", !this.checked);
});

 



// ==============================   end code page quiz etudiant 
