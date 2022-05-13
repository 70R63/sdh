ACC.descargaFacturaVA = {

	_autoload : [],

	
	buscarInfo : function (){
		ACC.spinner.show();
		
		var dow = document.getElementById('table-download');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(dow,'none');
		
		$("#nombreContribuyente").val("");
		$("#pagarFacturaVABtn").attr("data-impuesto","");
		$("#pagarFacturaVABtn").attr("data-numbp","");
		$("#pagarFacturaVABtn").attr("data-aniogravable","");
		$("#pagarFacturaVABtn").attr("data-numobjeto","");
		
		var tipoDoc = $("#tipoDoc").val();
		var numDoc = $("#numDoc").val();
		var currentTime = new Date();
		var year = currentTime.getFullYear().toString();
		var claveImpuesto = $("#claveImpuesto").val();
		
		if(ACC.descargaFacturaVA.validarAntesSubmitBuscarInfo(tipoDoc,numDoc,claveImpuesto)){
			var dataActual = {};	
			dataActual.tipoDoc = tipoDoc;
			dataActual.numDoc = numDoc;
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anioGravable = year;
			dataActual.claveObjeto = $("#claveObjeto").val().toUpperCase();
			
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
		}else{
			ACC.spinner.close();
		}
	 },
	 
	 
	manejarRespuesta_buscarInfo : function(dataResponse){
		
		if(dataResponse != null && dataResponse.nombreContribuyente != null){
			$("#nombreContribuyente").val(dataResponse.nombreContribuyente);
			$("#pagarFacturaVABtn").attr("data-impuesto",dataResponse.claveImpuesto);
			$("#pagarFacturaVABtn").attr("data-numbp",dataResponse.numBP);
			$("#pagarFacturaVABtn").attr("data-aniogravable",dataResponse.anioGravable);
			$("#pagarFacturaVABtn").attr("data-numobjeto",dataResponse.numObjeto);
			
			var dow = document.getElementById('table-download');
			ACC.opcionDeclaraciones.establecerEstiloDisplay(dow,'block');
		}else{
			alert("Error al consultar la información del contribuyente");
		}
		
		
		
	},
	
	
	validarAntesSubmitBuscarInfo : function(tipoDoc,numDoc,claveImpuesto){
		var validacionOK = false;
		
		if(tipoDoc != null && numDoc != null && claveImpuesto !="" && claveImpuesto != "00"){
			validacionOK = true;
		}
		
		return validacionOK;
	},
	
	
	descargaFactura : function (){
		ACC.spinner.show();
		var numBP = $("#pagarFacturaVABtn").attr("data-numbp");
		var anoGravable = $("#pagarFacturaVABtn").attr("data-aniogravable");
		var numObjeto = $("#claveObjeto").val().toUpperCase();
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
		}else{
			ACC.spinner.close();
		}
	 },
	 
	 descargaCertificadoPago : function (){
		ACC.spinner.show();
		var numBP = $("#pagarFacturaVABtn").attr("data-numbp");
		var numObjeto = $("#claveObjeto").val().toUpperCase();
		
		if(ACC.descargaFacturaVA.validarAntesSubmitDescargaCertificadoPago(numBP,numObjeto)){
			var dataActual = {};	
			
			dataActual.numBP = numBP;
			dataActual.numObjeto = numObjeto;
			
			$.ajax({
				url : ACC.descargaFacturaVADescargarCertificadoPagoURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					
					ACC.spinner.close();
					ACC.facturacion.manejarRespuesta(dataResponse);
					
				}
			,
				error : function() {
					
					ACC.spinner.close();
					alert("Error procesar la solicitud de descarga de certificado de pago");	
				}
			});
		}else{
			ACC.spinner.close();
		}
	 },
	 
	 
	 validarAntesSubmitDescargaFactura : function(numBP,anoGravable,numObjeto,tipoOperacion){
		var validacionOK = false;
		
		if(numBP != null && anoGravable != null && numObjeto != null && tipoOperacion != null){
			validacionOK = true;
		}
		
		return validacionOK;
	},
	
	validarAntesSubmitDescargaCertificadoPago : function(numBP,numObjeto){
		var validacionOK = false;
		
		if(numBP != null && numObjeto != null){
			validacionOK = true;
		}
		
		return validacionOK;
	},
	
	
};