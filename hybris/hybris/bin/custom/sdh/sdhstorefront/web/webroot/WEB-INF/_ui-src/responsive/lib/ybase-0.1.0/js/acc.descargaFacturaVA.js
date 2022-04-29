ACC.descargaFacturaVA = {

	_autoload : [],

	
	buscarInfo : function (){
		ACC.spinner.show();
		var tipoDoc = $("#tipoDoc").val();
		var numDoc = $("#numDoc").val();
		
		if(ACC.descargaFacturaVA.validarAntesSubmitBuscarInfo(tipoDoc,numDoc)){
			var dataActual = {};	
			
			dataActual.tipoDoc = tipoDoc;
			dataActual.numDoc = numDoc;
			
			$.ajax({
				url : ACC.descargaFacturaVABuscarInfoURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					
					ACC.spinner.close();
					ACC.descargaFacturaVA.manejarRespuesta_buscarInfo(dataResponse);
					
				}
			,
				error : function() {
					
					ACC.spinner.close();
					alert("Error al consultar la información del contribuyente");	
				}
			});
		}
	 },
	 
	 
	manejarRespuesta_buscarInfo : function(dataResponse){
		
		if(dataResponse != null && dataResponse.nombreContribuyente != null){
			$("#nombreContribuyente").val(dataResponse.nombreContribuyente);
			$("#numBP").val(dataResponse.numBP);
			var dow = document.getElementById('table-download');
			ACC.opcionDeclaraciones.establecerEstiloDisplay(dow,'block');
		}else{
			alert("Error al consultar la información del contribuyente");
		}
		
		
		
	},
	
	
	validarAntesSubmitBuscarInfo : function(tipoDoc,numDoc){
		var validacionOK = false;
		
		if(tipoDoc != null && numDoc != null){
			validacionOK = true;
		}
		
		return validacionOK;
	},
	
	
	descargaFactura : function (){
		ACC.spinner.show();
		debugger;
		var numBP = $("#numBP").val();
		var anoGravable = "2022";
		var numObjeto = $("#numObjeto").val().toUpperCase();
		var tipoOperacion = "1";
		
		if(ACC.descargaFacturaVA.validarAntesSubmitDescargaFactura(numBP,anoGravable,numObjeto,tipoOperacion)){
			var dataActual = {};	
			
			dataActual.numBP = numBP;
			dataActual.anoGravable = anoGravable;
			dataActual.numObjeto = numObjeto;
			dataActual.tipoOperacion = tipoOperacion;
			
			$.ajax({
				url : ACC.descargaFacturaVADescargarFacturaURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					
					ACC.spinner.close();
					ACC.facturacion.manejarRespuesta(dataResponse);
					
				}
			,
				error : function() {
					
					ACC.spinner.close();
					alert("Error procesar la solicitud de descarga de factura");	
				}
			});
		}
	 },
	 
	 
	 validarAntesSubmitDescargaFactura : function(numBP,anoGravable,numObjeto,tipoOperacion){
		var validacionOK = false;
		
		if(numBP != null && anoGravable != null && numObjeto != null && tipoOperacion != null){
			validacionOK = true;
		}
		
		return validacionOK;
	},
	
	
};
