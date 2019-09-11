ACC.opcionDeclaraciones = {
		
	_autoload : [ "bindDeclaracionPDF" ],

	
	bindDeclaracionPDF : function() {
		$(document).on("click", ".consultaDecPDF", function(e) {
			e.preventDefault();	
						
			 debugger;
 	        var claveImpuesto = $("#seleccion").val();  	       
 	        var anoGravable = $("#aniograv").val(); 	       
 	        var periodo = $("#periodo").val(); 	       
			var dataActual = {};
			
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anoGravable = anoGravable;
			dataActual.periodo = periodo;
			

			$.ajax({
				url : ACC.declaracionPDFURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.opcionDeclaraciones.updateFromResponse(dataActual,dataResponse);
				},
				error : function() {
				}
			});
		});
	},
	
	updateFromResponse : function(infoActual,infoResponse) {

		alert(infoResponse.textoMensaje);
					
				
	}	

	

};