ACC.opcionDeclaraciones = {
		
	_autoload : [ "bindDeclaracionPDF" ],

	
	bindDeclaracionPDF : function() {
		$(document).on("click", ".consultaDecPDF", function(e) {
			e.preventDefault();	
						
			debugger;
			var nombreCampo;
			var valorCampo;
			var valNumObjeto;
				
			for (var i = 0; i < e.target.form.length; i++) {
				nombreCampo = "registroNum_" + i;
				valorCampo = null;
				valorCampo = document.getElementById(nombreCampo);
				if(valorCampo != null){
					var seleccionado = valorCampo.checked;
					if(seleccionado == true){
						 valNumObjeto = $.trim($(valorCampo).attr("data-numObjeto")); 
						 break;
					}
				}else{
					break;
				}
			}
 	        var claveImpuesto = $("#seleccion").val();  	       
 	        var anoGravable = $("#aniograv").val(); 	       
 	        var periodo = $("#periodo").val(); 	       
			var dataActual = {};
			var objContrato = valNumObjeto;
						
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.objContrato = objContrato;
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
					alert("Error procesar la solicitud");	
				}
			});
		});
	},
	
	updateFromResponse : function(infoActual,infoResponse) {

		debugger;
		if (infoResponse.declaraPDFResponse.errores != null){
			alert(infoResponse.declaraPDFResponse.errores.textoMensaje);
		}else{
			if(infoResponse.urlDownload != null){
				$("#downloadHelper").attr("href",infoResponse.urlDownload);
				document.getElementById("downloadHelper").click();
			}
		}
		
				
	},
	
	
	obtenerListaDeclaraciones : function() {

//		debugger;
        var claveImpuesto = $("#seleccion").val();  	       
        var anoGravable = $("#aniograv").val(); 	       
        var periodo = $("#periodo").val(); 	       
		var dataActual = {};
		
		dataActual.claveImpuesto = claveImpuesto;
		dataActual.anoGravable = anoGravable;
		dataActual.periodo = periodo;
		
		$.ajax({
			url : ACC.listaDeclaracionesURL,
			data : dataActual,
			type : "GET",
			success : function(dataResponse) {
				ACC.opcionDeclaraciones.updateFromResponseSeleccion(dataActual,dataResponse);
			},
			error : function() {
				alert("Error procesar la solicitud");	
			}
		});
				
	},
	
	
	updateFromResponseSeleccion : function(infoActual,infoResponse) {

//		debugger;
		$("#table-publicidad1").find("tr:gt(0)").remove();
		if(infoResponse.publicidadExt.length > 0){
			$.each(infoResponse.publicidadExt, function (index,value){
				$('#table-publicidad1').append("<tr>"+ 
						'<td>' + value.numResolu + '</td>'+
						'<td>' + value.tipoValla + '</td>'+
						'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value.numObjeto +'"' +">" + "</td>"+
						"</tr>");
			});
		}
				
	}

	

};