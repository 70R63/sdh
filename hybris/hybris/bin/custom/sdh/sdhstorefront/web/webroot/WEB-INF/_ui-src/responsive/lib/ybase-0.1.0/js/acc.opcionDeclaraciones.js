ACC.opcionDeclaraciones = {
		
	_autoload : [ "bindDeclaracionPDF", "bindCertiPagosImprime", "binDeclaracionImprime" ],

	
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
	
	binDeclaracionImprime : function() {
		$(document).on("click", ".declaracionImprime", function(e) {
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
					url : ACC.declaracionImprimirURL,
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
	
	
	bindCertiPagosImprime : function() {
		$(document).on("click", ".certiPagosImprime", function(e) {
			e.preventDefault();	
			
			if(ACC.opcionDeclaraciones.validarAntesSubmit()){
				debugger;
				var nombreCampo;
				var valorCampo;
				var valNumObjeto;
				var valCtaContrato;
				var valClavePeriodo;
				var valImporte;
				var valReferencia
					
				for (var i = 0; i < e.target.form.length; i++) {
					nombreCampo = "registroNum_" + i;
					valorCampo = null;
					valorCampo = document.getElementById(nombreCampo);
					if(valorCampo != null){
						var seleccionado = valorCampo.checked;
						if(seleccionado == true){
							 valNumObjeto = $.trim($(valorCampo).attr("data-numObjeto")); 
							 valCtaContrato = $.trim($(valorCampo).attr("data-ctaContrato")); 
							 valClavePeriodo = $.trim($(valorCampo).attr("data-clavePeriodo")); 
							 valReferencia = $.trim($(valorCampo).attr("data-referencia")); 
							 valImporte = $.trim($(valorCampo).attr("data-importe")); 
							 break;
						}
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
				
				dataActual.ctaContrato = valCtaContrato;
				dataActual.clavePeriodo = valClavePeriodo;
				dataActual.referencia = valReferencia;
				dataActual.importe = valImporte;
				
				
	
				$.ajax({
					url : ACC.certiPagoImprimeURL,
					data : dataActual,
					type : "GET",
					success : function(dataResponse) {
						ACC.opcionDeclaraciones.updateFromResponseImprimir(dataActual,dataResponse);
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
			if (infoResponse.declaraPDFResponse.errores[0].idmsj == "0"){
				if(infoResponse.urlDownload != null){
					$("#downloadHelper").attr("href",infoResponse.urlDownload);
					document.getElementById("downloadHelper").click();
				}
			}	
			alert(infoResponse.declaraPDFResponse.errores[0].txtmsj);
		}else{
			if(infoResponse.urlDownload != null){
				$("#downloadHelper").attr("href",infoResponse.urlDownload);
				document.getElementById("downloadHelper").click();
			}
		}
		
				
	},
	
	
	updateFromResponseImprimir : function(infoActual,infoResponse) {

		debugger;
		if (infoResponse.impresionResponse.errores != null){
			if (infoResponse.impresionResponse.errores[0].idmsj == "0"){
				if(infoResponse.urlDownload != null){
					$("#downloadHelper").attr("href",infoResponse.urlDownload);
					document.getElementById("downloadHelper").click();
				}
			}	
			alert(infoResponse.impresionResponse.errores[0].txtmsj);
		}else{
			if(infoResponse.urlDownload != null){
				$("#downloadHelper").attr("href",infoResponse.urlDownload);
				document.getElementById("downloadHelper").click();
			}
		}
		
				
	},
	
	
	obtenerListaDeclaraciones : function() {

//		debugger;
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
	
	
	obtenerListaDeclaraciones_certiPagos : function() {

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
				url : ACC.certiPagosListaURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.opcionDeclaraciones.updateFromResponseSeleccion_certiPagos(dataActual,dataResponse);
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
							var numRadicado = "";
							
							if(value.radicados!= null){
								numRadicado = value.radicados[0].numRadicado;
							}
							
							$('#table-delineacion1').append("<tr>"+ 
									'<td>' + value.cdu + '</td>'+
									'<td>' + numRadicado + '</td>'+
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
	
	
	updateFromResponseSeleccion_certiPagos : function(infoActual,infoResponse) {

//		debugger;
		$("#table-publicidad1").find("tr:gt(0)").remove();
		$("#table-gasolina1").find("tr:gt(0)").remove();
		$("#table-ica1").find("tr:gt(0)").remove();
		$("#table-reteica1").find("tr:gt(0)").remove();
		$("#table-delineacion1").find("tr:gt(0)").remove();
		
		
		if (infoResponse.errores != null && infoResponse.errores[0] != null && infoResponse.errores[0].idmsj != 0){
			alert(infoResponse.errores[0].txtmsj);
		}else{
			if(infoResponse.declaracionesCertiPagos.declaraciones != null){
				if(infoResponse.declaracionesCertiPagos.declaraciones.length > 0){
					
					if(infoActual.claveImpuesto == '0003'){
						$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
							if(value1.numObjeto != ""){
								if(value1.numObjeto == infoResponse.customerData.ica.numObjeto){
									$('#table-ica1').append("<tr>"+ 
										'<td>' + "Industria y Comercio" + '</td>'+
										'<td>' + value1.clavePeriodo + '</td>'+
										'<td>' + value1.referencia + '</td>'+
										'<td>' + value1.importe + '</td>'+
										'<td>' + value1.moneda + '</td>'+
										'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto +'" data-ctaContrato="' + value1.ctaContrato + '" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
										"</tr>");
								}
							}
						});
					}
				
			
					if(infoActual.claveImpuesto == '0004'){
						$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
							if(value1.numObjeto != ""){
								if(value1.numObjeto == infoResponse.customerData.reteICA.numObjeto){
									$('#table-reteica1').append("<tr>"+ 
										'<td>' + infoResponse.customerData.reteIca.numID  + '</td>'+
										'<td>' + infoResponse.customerData.reteIca.consecutivo + '</td>'+
										'<td>' + value1.clavePeriodo + '</td>'+
										'<td>' + value1.referencia + '</td>'+
										'<td>' + value1.importe + '</td>'+
										'<td>' + value1.moneda + '</td>'+
										'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia +'" data-importe="' + value1.importe + '"' +">" + "</td>"+
										"</tr>");
								}
							}
						});
					}
			
					if(infoActual.claveImpuesto == '0005'){
						$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
							if(value1.numObjeto != ""){
								$.each(infoResponse.customerData.gasolina, function (index,value2){
									if(value1.numObjeto == value2.numObjeto){
										$('#table-gasolina1').append("<tr>"+ 
											'<td>' + value2.tipoDoc  + '</td>'+
											'<td>' + value2.numDoc + '</td>'+
											'<td>' + value1.clavePeriodo + '</td>'+
											'<td>' + value1.referencia + '</td>'+
											'<td>' + value1.importe + '</td>'+
											'<td>' + value1.moneda + '</td>'+
											'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
											"</tr>");
									}
								});
							}
						});
					}
			
					if(infoActual.claveImpuesto == '0006'){
						$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
							if(value1.numObjeto != ""){
								$.each(infoResponse.customerData.delineacion, function (index,value2){
									if(value1.numObjeto == value2.numObjeto){
										$('#table-delineacion1').append("<tr>"+ 
												'<td>' + value2.cdu + '</td>'+
												'<td>' + value1.clavePeriodo + '</td>'+
												'<td>' + value1.referencia + '</td>'+
												'<td>' + value1.importe + '</td>'+
												'<td>' + value1.moneda + '</td>'+
												'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto  +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
												"</tr>");
									}
								});
							}	
						});	
					}

					if(infoActual.claveImpuesto == '0007'){
						$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
							if(value1.numObjeto != ""){
								$.each(infoResponse.customerData.publicidadExt, function (index,value2){
									if(value1.numObjeto == value2.numObjeto){
										$('#table-publicidad1').append("<tr>"+ 
												'<td>' + value2.numResolu + '</td>'+
												'<td>' + value2.tipoValla + '</td>'+
												'<td>' + value1.clavePeriodo + '</td>'+
												'<td>' + value1.referencia + '</td>'+
												'<td>' + value1.importe + '</td>'+
												'<td>' + value1.moneda + '</td>'+
												'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto  +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia +'" data-importe="' + value1.importe + '"' +">" + "</td>"+
												"</tr>");
									}
								});
							}
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
		
		$("#table-publicidad1").find("tr:gt(0)").remove();
		$("#table-gasolina1").find("tr:gt(0)").remove();
		$("#table-ica1").find("tr:gt(0)").remove();
		$("#table-reteica1").find("tr:gt(0)").remove();
		$("#table-delineacion1").find("tr:gt(0)").remove();
		

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