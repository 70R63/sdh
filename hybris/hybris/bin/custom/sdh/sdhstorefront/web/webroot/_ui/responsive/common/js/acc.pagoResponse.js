ACC.pagoResponse = {

	
	bindPagoARDialog: function(){
		$(document).on("click", ".pagoARResponse", function (e) {
			e.preventDefault();
			
			$( "#pagoARResponse" ).dialog( "open" );
 	    	$("#pagoARResponseContent").html("");
 	    	$("#pagoARResponseContent").html("La impresion de certificado se realiza con usuario del contribuyente o usuario NIT");			
		};

	}
};