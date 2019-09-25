ACC.opcionDeclaraciones = {
		
	_autoload : [ "bindDeclaracionPDF" ],

	
	bindDeclaracionPDF : function() {
		$(document).on("click", ".consultaDecPDF", function(e) {
			e.preventDefault();	
			
			if(ACC.opcionDeclaraciones.validarAntesSubmit()){
//				debugger;
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
						ACC.opcionDeclaraciones.updateFromResponsePDF(dataActual,dataResponse);
					},
					error : function() {
						alert("Error procesar la solicitud");	
					}
				});
			}
		});
	},
	
	updateFromResponsePDF : function(infoActual,infoResponse) {

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

		debugger;
		ACC.opcionDeclaraciones.ocultarTablas();
		if(ACC.opcionDeclaraciones.validarAntesSubmit()){
	        var claveImpuesto = $("#seleccion").val();  	       
	        var anoGravable = $("#aniograv").val(); 	       
	        var periodo = $("#periodo").val(); 	       
			var dataActual = {};
			var validacionOK = false;

		
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
		}
		
		
	},
	
	
	updateFromResponseSeleccion : function(infoActual,infoResponse) {

		debugger;
		$("#table-publicidad1").find("tr:gt(0)").remove();
		$("#table-gasolina1").find("tr:gt(0)").remove();
		$("#table-ica1").find("tr:gt(0)").remove();
		$("#table-reteica1").find("tr:gt(0)").remove();
		$("#table-delineacion1").find("tr:gt(0)").remove();
		
		
		if (infoResponse.errores != null){
			alert(infoResponse.errores[0].txtmsj);
		}else{
			if(infoActual.claveImpuesto == '0003'){
				$('#table-ica1').append("<tr>"+ 
						'<td>' + "Industria y Comercio" + '</td>'+
						'<td>' + infoResponse.anoGravable + '</td>'+
						'<td><input id="registroNum_'+ 0 +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ infoResponse.ica.numObjeto +'"' +">" + "</td>"+
						"</tr>");
			}
			
			if(infoActual.claveImpuesto == '0004'){
				$('#table-reteica1').append("<tr>"+ 
						'<td>' + infoResponse.reteica.numID + '</td>'+
						'<td>' + infoResponse.reteica.consecutivo + '</td>'+
						'<td><input id="registroNum_'+ 0 +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ infoResponse.reteica.numObjeto +'"' +">" + "</td>"+
						"</tr>");
			}
			
			if(infoActual.claveImpuesto == '0005'){
				if(infoResponse.gasolina.length > 0){
					$.each(infoResponse.gasolina, function (index,value){
						$('#table-gasolina1').append("<tr>"+ 
								'<td>' + value.numDoc + '</td>'+
								'<td>' + value.tipoDoc + '</td>'+
								'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value.numObjeto +'"' +">" + "</td>"+
								"</tr>");
					});
				}
			}
			
			if(infoActual.claveImpuesto == '0006'){
				if(infoResponse.delineacion != null){
					if(infoResponse.delineacion.length > 0){
						$.each(infoResponse.delineacion, function (index,value){
							$('#table-delineacion1').append("<tr>"+ 
									'<td>' + value.cdu + '</td>'+
									'<td>' + value.radicados[0].numRadicado + '</td>'+
									'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value.numObjeto +'"' +">" + "</td>"+
									"</tr>");
						});
					}
				}
			}

			if(infoActual.claveImpuesto == '0007'){
				if(infoResponse.publicidadExt != null){
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
			}
		}
		
	
	},
	
	
	validarAntesSubmit : function() {

//		debugger;
        var claveImpuesto = $("#seleccion").val();  	       
        var anoGravable = $("#aniograv").val(); 	       
        var periodo = $("#periodo").val(); 	       
		var validacionOK = false;

		if(claveImpuesto == "0001" || claveImpuesto == "0002" || claveImpuesto == "0003" || claveImpuesto == "0004" || claveImpuesto == "0006" || claveImpuesto == "0007"){
			if(anoGravable != "" && anoGravable != "00"){
				validacionOK = true;
			}else{
				validacionOK = false;
			}
		}
		if(claveImpuesto == "0005"){
			if(anoGravable != "" && anoGravable != "00" && periodo != "" && periodo != "00"){
				validacionOK = true;
			}else{
				validacionOK = false;
			}
		}
		
		return validacionOK;
	},
	
	
	ocultarTablas : function() {

//		debugger;
//		var value = selectObject.value;
		var x = document.getElementById('seleccion').value;
		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablereteica = document.getElementById('table-reteica');
		var tablepublicidad = document.getElementById('table-publicidad');
		var tablegasolina = document.getElementById('table-gasolina');
		var cdus = document.getElementById('table-delineacion');

// 		document.getElementById('periodo').value = '00'; 
		
		tablepredial.style.display = 'none';
		tablevehiculos.style.display = 'none';
		tableica.style.display = 'none';
		tablereteica.style.display = 'none';
		tablegasolina.style.display = 'none';
		cdus.style.display = 'none';
		tablepublicidad.style.display = 'none';
		

		if (x == '0001') {  //predial
			tablepredial.style.display = 'block';
		} else if (x == '0002') { //vehiculos
			tablevehiculos.style.display = 'block';
		} else if (x == '0003') { //ica
			tableica.style.display = 'block';
		} else if (x == '0004') { //reteica
			tablereteica.style.display = 'block';
		} else if (x == '0005') { //gasolina
			tablegasolina.style.display = 'block';
		} else if (x == '0006') { //delineacion
			cdus.style.display = 'block';
		} else if (x == '0007') { //publicidad
			tablepublicidad.style.display = 'block';
		}
		
		
	}
	

	

};