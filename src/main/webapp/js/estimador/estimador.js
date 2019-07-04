$(document).ready(function(){
	listenerBtnSendFormulario();
});

function listenerBtnFormulario() {
	$('#btn-form').on('click',function(){
		$.ajax({
	        url: 'http://'+ window.location.href.split('/')[2] + '/sendFormularioEstimacion',
	        data: construirObjetoEnviarForm(),
	        type: 'POST',
			contentType: 'application/json',
	        success: function(data) {
	        	console.log("funciona.");
	          },
	        error: function() {
	              console.log("No se ha podido obtener la informacion.");
	          }
	      });
	});
}

function construirObjetoEnviarForm() {
	var cad = '{"piezas":'+$('#piezas').val() + ','+
		'"fechaIn":' + $('#fechaIn').val() + '}';
	return cad;
}
