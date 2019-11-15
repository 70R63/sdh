ACC.opcionDeclaraciones = {

	dataActual_backup:{},
	dataResponse_backup:{},
	
	_autoload : [ "bindDeclaracionPDF", "bindCertiPagosImprime", "bindDeclaracionImprime"],

	
	bindDeclaracionPDF : function() {
		$(document).on("click", ".consultaDecPDF", function(e) {
			e.preventDefault();	
			
			if(ACC.opcionDeclaraciones.validarAntesSubmit()){
				debugger;
				var nombreCampo;
				var valorCampo;
				var valNumObjeto;
				var valNumRadicado;
					
				for (var i = 0; i < e.target.form.length; i++) {
					nombreCampo = "registroNum_" + i;
					valorCampo = null;
					valorCampo = document.getElementById(nombreCampo);
					if(valorCampo != null){
						var seleccionado = valorCampo.checked;
						if(seleccionado == true){
							 valNumObjeto = $.trim($(valorCampo).attr("data-numObjeto")); 
							 valNumRadicado = $.trim($(valorCampo).attr("data-numRadicado")); 
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
				dataActual.referencia = valNumRadicado;
				dataActual.objContrato = objContrato;
				dataActual.numObjeto = valNumObjeto;
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
	
	
	bindDeclaracionImprime : function() {
		$(document).on("click", ".declaracionImprime", function(e) {
			e.preventDefault();	
			
			if(ACC.opcionDeclaraciones.validarAntesSubmit()){
				debugger;
				var nombreCampo;
				var valorCampo;
				var valNumObjeto;
				var valNumRadicado;
					
				for (var i = 0; i < e.target.form.length; i++) {
					nombreCampo = "registroNum_" + i;
					valorCampo = null;
					valorCampo = document.getElementById(nombreCampo);
					if(valorCampo != null){
						var seleccionado = valorCampo.checked;
						if(seleccionado == true){
							 valNumObjeto = $.trim($(valorCampo).attr("data-numObjeto")); 
							 valNumRadicado = $.trim($(valorCampo).attr("data-numRadicado")); 
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
				dataActual.numObjeto = valNumObjeto;
				dataActual.referencia = valNumRadicado;
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
				var valReferencia;
				var valFechaCompensa;
				var valMoneda;
				var valNumDocPago;
				var valNumfactForm;
					
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
							 valFechaCompensa = $.trim($(valorCampo).attr("data-fechaCompensa")); 
							 valMoneda = $.trim($(valorCampo).attr("data-moneda")); 
							 valNumDocPago = $.trim($(valorCampo).attr("data-numDocPago")); 
							 valNumfactForm = $.trim($(valorCampo).attr("data-numfactForm")); 

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
				dataActual.fechaCompensa = valFechaCompensa;
				dataActual.moneda = valMoneda;
				dataActual.numDocPago = valNumDocPago;
				dataActual.numfactForm = valNumfactForm;
				
	
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
			if (infoResponse.declaraPDFResponse.errores.idMensaje == "0"){
				if(infoResponse.urlDownload != null){
					$("#downloadHelper").attr("href",infoResponse.urlDownload);
					document.getElementById("downloadHelper").click();
				}
			}else{
				alert(infoResponse.declaraPDFResponse.errores.textoMensaje);
			}
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
			} else{
				alert(infoResponse.impresionResponse.errores[0].txtmsj);
			}
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
			var dataActual = {};

			
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anoGravable = anoGravable;
			dataActual.periodo = ACC.opcionDeclaraciones.obtenerPeriodoPorImpuesto(claveImpuesto);
			
			
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
			var dataActual = {};	
		
			
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anoGravable = anoGravable;
			dataActual.periodo = ACC.opcionDeclaraciones.obtenerPeriodoPorImpuesto(claveImpuesto);
			
			
			$.ajax({
				url : ACC.certiPagosListaURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					debugger;
//					ACC.opcionDeclaraciones.dataActual_backup = dataActual;
//					ACC.opcionDeclaraciones.dataResponse_backup = dataResponse;
					ACC.opcionDeclaraciones.mostrarErrores_certiPagos(dataResponse);
					ACC.opcionDeclaraciones.updateFromResponseSeleccion_certiPagos(dataActual,dataResponse,null);					
//					ACC.opcionDeclaraciones.habilitarFiltroPeriodo(dataActual,dataResponse);
				},
				error : function() {
					alert("Error procesar la solicitud");	
				}
			});
		}
		
		
	},
	
	
	obtenerPeriodoPorImpuesto : function(claveImpuesto){
		debugger;
        var periodoM = $("#periodoM").val();
        var periodoB = $("#periodoB").val();
        var perBimestral = document.getElementById('Periodo2'); //bimestral
        var periodo = '00';

		if(perBimestral.style.display == 'block'){
			periodo = periodoB;
		}else{
			periodo = periodoM;
		}
		
		return periodo;
	},
	
	
	prepararPeriodo : function() {

		debugger;
		if(ACC.opcionDeclaraciones.validarAntesSubmitPeriodo()){
	        var claveImpuesto = $("#seleccion").val();  	       
			var dataActual = {};
		
			dataActual.claveImpuesto = claveImpuesto;
			
			
			$.ajax({
				url : ACC.tipoPeriodoDeclaracionURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.opcionDeclaraciones.updateFromResponsePeriodo(dataActual,dataResponse);
				},
				error : function() {
					alert("Error procesar la solicitud obtener tipo de periodo");	
				}
			});
		}
		
		
	},
	
	updateFromResponsePeriodo : function(infoActual,infoResponse) {

		debugger;
		var perMensual = document.getElementById('Periodo1'); //mensual
		var perBimestral = document.getElementById('Periodo2'); //bimestral
		var perAnual = document.getElementById('aniograv');
		var perMensualValue = document.getElementById('periodoM'); 
		var perBimestralValue = document.getElementById('periodoB'); 
		
		perAnual.value = '00';
		perMensualValue.value = '00';
		perBimestralValue.value = '00';
		
		perMensual.style.display = 'none';
		perBimestral.style.display = 'none';
		perAnual.style.display = 'none';
		if (infoResponse.tipoPeriodoDec == '0') {
			perAnual.style.display = 'block';
		} else if (infoResponse.tipoPeriodoDec == '1') {
			perAnual.style.display = 'block';
			perMensual.style.display = 'block';
		} else if (infoResponse.tipoPeriodoDec == '2') {
			perAnual.style.display = 'block';
			perBimestral.style.display = 'block';
		}
		
		
	},
	
	
	mostrarErrores_certiPagos : function (infoResponse) {
		debugger;
		if (infoResponse.errores != null && infoResponse.errores[0] != null && infoResponse.errores[0].idmsj != 0){
			alert(infoResponse.errores[0].txtmsj);
		}
	},
	
	
	updateFromResponseSeleccion : function(infoActual,infoResponse) {

		debugger;
		ACC.opcionDeclaraciones.vaciarTablasInfo();
		
		if (infoResponse.errores != null){
			alert(infoResponse.errores[0].txtmsj);
		}else{
			if(infoActual.claveImpuesto == '0002'){
				if(infoResponse.vehicular.length > 0){
					$.each(infoResponse.vehicular, function (index,value){
						$('#table-vehicular1').append("<tr>"+ 
								'<td>' + value.placa + '</td>'+
								'<td>' + value.marca + '</td>'+
								'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value.numObjeto +'"' +">" + "</td>"+
								"</tr>");
					});
				}
				
			}
			if(infoActual.claveImpuesto == '0003'){
				$('#table-ica1').append("<tr>"+ 
						'<td>' + "Industria y Comercio" + '</td>'+
						'<td>' + infoResponse.anoGravable + '</td>'+
						'<td><input id="registroNum_'+ 0 +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ infoResponse.ica.numObjeto +'"' +">" + "</td>"+
						"</tr>");
			}
			if(infoResponse.reteIca != null){
				if(infoResponse.reteIca.consecutivo == null){
					infoResponse.reteIca.consecutivo ="-";
				}
			}
			
			if(infoActual.claveImpuesto == '0004'){
				$('#table-reteica1').append("<tr>"+ 
						'<td>' + infoResponse.reteIca.numID + '</td>'+
						'<td>' + infoResponse.reteIca.consecutivo + '</td>'+
						'<td><input id="registroNum_'+ 0 +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ infoResponse.reteIca.numObjeto +'"' +">" + "</td>"+
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
							//debugger
							if(value.radicados!= null){
								numRadicado = value.radicados[0].numRadicado;
							}
							
							$('#table-delineacion1').append("<tr>"+ 
									'<td>' + value.cdu + '</td>'+
									'<td>' + numRadicado + '</td>'+
									'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value.numObjeto + '" data-numRadicado="'+ numRadicado +'"' +">" + "</td>"+
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
	
	
	updateFromResponseSeleccion_certiPagos : function(infoActual,infoResponse,filtroPeriodo) {
		var desc_clavePeriodo = "";
		
		
debugger;
		if(infoResponse.declaracionesCertiPagos.declaraciones != null){
			if(infoResponse.declaracionesCertiPagos.declaraciones.length > 0){
				
				if(infoActual.claveImpuesto == '0002'){
					$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
						if(value1.numObjeto != ""){
							$.each(infoResponse.customerData.vehicular, function (index,value2){
								if(value1.numObjeto == value2.numObjeto){
									desc_clavePeriodo = ACC.opcionDeclaraciones.obtener_desc_clavePeriodo(value1.clavePeriodo);
									$('#table-vehicular1').append("<tr>"+ 
											'<td>' + value2.placa + '</td>'+
											'<td>' + value2.marca + '</td>'+
											'<td>' + desc_clavePeriodo + '</td>'+
											'<td>' + value1.referencia + '</td>'+
											'<td>' + value1.importe + '</td>'+
											'<td>' + value1.moneda + '</td>'+
											'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto  +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
											"</tr>");
								}
							});
						}
					});
				}
				
				if(infoActual.claveImpuesto == '0003'){
					if(infoResponse.declaracionesCertiPagos != null){
						$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
							if(value1.numObjeto != null && value1.numObjeto != ""){
								if(value1.numObjeto == infoResponse.customerData.ica.numObjeto){
									if(ACC.opcionDeclaraciones.validarFiltro(value1,filtroPeriodo)){
										desc_clavePeriodo = ACC.opcionDeclaraciones.obtener_desc_clavePeriodo(value1.clavePeriodo);
										$('#table-ica1').append("<tr>"+ 
											'<td>' + "Industria y Comercio" + '</td>'+
											'<td>' + desc_clavePeriodo + '</td>'+
											'<td>' + value1.referencia + '</td>'+
											'<td>' + value1.importe + '</td>'+
											'<td>' + value1.moneda + '</td>'+
											'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto +'" data-ctaContrato="' + value1.ctaContrato + '" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
											"</tr>");
									}
								}
							}
						});
					}
				}
			
		
				if(infoActual.claveImpuesto == '0004'){
					$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
						if(value1.numObjeto != ""){
							if(value1.numObjeto == infoResponse.customerData.reteIca.numObjeto){
								$('#table-reteica1').append("<tr>"+ 
									'<td>' + infoResponse.customerData.reteIca.numID  + '</td>'+
									'<td>' + infoResponse.customerData.reteIca.consecutivo + '</td>'+
									'<td>' + value1.clavePeriodo + '</td>'+
									'<td>' + value1.referencia + '</td>'+
									'<td>' + value1.importe + '</td>'+
									'<td>' + value1.moneda + '</td>'+
									'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia +  '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
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
										'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm +  '" data-importe="' + value1.importe + '"' +">" + "</td>"+
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
											'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto  +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
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
											'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto  +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
											"</tr>");
								}
							});
						}
					});
				}
				
			}
		}
		
	
	},
	
	
	updateFromResponseSeleccion_presentarDec : function(infoActual,infoResponse) {
		debugger;
		var flagHuboRegistros = false;
		var anioGravable = document.getElementById("anoGravable").value;
	
		ACC.opcionDeclaraciones.vaciarTablasInfo_presentarDec();
		
		if (infoResponse.errores != null){
			alert(infoResponse.errores[0].txtmsj);
		}else{
			if(infoActual.claveImpuesto == '2'){
				var urlDeclaracion = "contribuyentes/sobrevehiculosautomotores/declaracion";
				var urlPrefijo = obtenerURLBase();
				if(infoResponse.vehicular.length > 0){
					$.each(infoResponse.vehicular, function (index,value){
						if(value.placa != null && value.placa !=""){
							var url = urlPrefijo + urlDeclaracion + '?anioGravable=' + anioGravable + '&placa=' + value.placa + '&numBPP=' + infoResponse.numBP + '&numForma=' + value.numForm ;
							
							blindado_vehi.forEach(function (eachBLI) {
						    		if(eachBLI.id_blindado== value.blindado)
						    		{
						    			var nuevo_blindado = eachBLI.item_blindado;
						    			value.blindado = nuevo_blindado;
						    		}
						    	});
							 marca_vehi.forEach(function (eachMAR) {
						    		if(eachMAR.id_marca == value.marca)
						    		{
						    			var nuevo_marca = eachMAR.item_marca;
						    			value.marca = nuevo_marca;
						    		}
						    	});
							 carroceria_vehi.forEach(function (eachCAR) {
						    		if(eachCAR.id_carroceria == value.carroceria)
						    		{
						    			var nuevo_carroceria = eachCAR.item_carriceria;
						    			value.carroceria = nuevo_carroceria;
						    		}
						    	});
							 clase_vehi.forEach(function (eachCLA) {
						    		if(eachCLA.id_clase == value.clase)
						    		{
						    			var nuevo_clase = eachCLA.item_clase;
						    			value.clase = nuevo_clase;
						    		}
						    	});
							 var linea_inicial = value.linea;
							 
							 linea_vehi.forEach(function (eachLIN) {
						    		if(eachLIN.id_linea == value.linea)
						    		{
						    			var nuevo_linea = eachLIN.item_linea;
						    			value.linea = nuevo_linea;
						    		}
						    	});
							 debugger;
							 if(linea_inicial == value.linea)
								 {
								 linea_vehi2.forEach(function (eachLIN) {
							    		if(eachLIN.id_linea == value.linea)
							    		{
							    			var nuevo_linea = eachLIN.item_linea;
							    			value.linea = nuevo_linea;
							    		}
							    	});
								 }
							


							$('#table-vehicular1').append("<tr>"+ 
									'<td>' + value.placa + '</td>'+
									'<td>' + value.marca + '</td>'+ 
									'<td>' + value.linea + '</td>'+ 
									'<td>' + value.modelo + '</td>'+ 
									'<td>' + value.clase + '</td>'+ 
									'<td>' + value.carroceria + '</td>'+ 
									'<td>' + value.numPuertas + '</td>'+ 
									'<td>' + value.blindado + '</td>'+ 
									'<td>' + value.cilindraje + '</td>'+ 
									'<td><a href="' + url + '">Presentar Declaracion</a> </td>'+
									"</tr>");
						}
					});
				}
				
			}
		}
		
		if(flagHuboRegistros == true){
	        var btnAction = document.getElementById('action');
	        btnAction.style.display = 'block';
		}
		
	
	},
	
	
	
	habilitarFiltroPeriodo : function(infoActual,infoResponse) {

		
        var periodoM = $("#periodoM").val();
        var periodoB = $("#periodoB").val();
		var perMensual = document.getElementById('Periodo1'); //mensual
		var perBimestral = document.getElementById('Periodo2'); //bimestral
		var tipoPeriodo = "";
		
		debugger;
		if (infoResponse.errores != null && infoResponse.errores[0] != null && infoResponse.errores[0].idmsj != 0){
			
		}else{
			if(infoResponse.declaracionesCertiPagos.declaraciones != null){
				if(infoResponse.declaracionesCertiPagos.declaraciones.length > 0){
					
					if(infoActual.claveImpuesto == '0003'){
						$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
							//debugger;
							if(value1.numObjeto != ""){
								if(value1.numObjeto == infoResponse.customerData.ica.numObjeto){
									tipoPeriodo = ACC.opcionDeclaraciones.obtener_tipoPeriodo(value1.clavePeriodo);
									if(tipoPeriodo == 'B'){
										perBimestral.style.display = 'block';
									}
									
								}
							}
						});
					}
			
					if(infoActual.claveImpuesto == '0004'){
						$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
							if(value1.numObjeto != ""){
								if(value1.numObjeto == infoResponse.customerData.reteICA.numObjeto){

								}
							}
						});
					}
			
					if(infoActual.claveImpuesto == '0005'){
						$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
							if(value1.numObjeto != ""){
								$.each(infoResponse.customerData.gasolina, function (index,value2){
									if(value1.numObjeto == value2.numObjeto){

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

		debugger;
        var claveImpuesto = $("#seleccion").val();  	       
        var anoGravable = $("#aniograv").val(); 	       
        var periodoM = $("#periodoM").val();
        var periodoB = $("#periodoB").val();
		var perMensual = document.getElementById('Periodo1'); //mensual
		var perBimestral = document.getElementById('Periodo2'); //bimestral
		var validacionOK = false;

		if(claveImpuesto == "0001" || claveImpuesto == "0002" || claveImpuesto == "0006" || claveImpuesto == "0007"){
			if(anoGravable != "" && anoGravable != "00"){
				validacionOK = true;
			}
		}else if( claveImpuesto == "0003" || claveImpuesto == "0004" ){
			if(anoGravable != "" && anoGravable != "00"){
				if(perBimestral.style.display == 'block'){
					if( periodoB != "" && periodoB != '00'){
						validacionOK = true;
					}
				}else{
					validacionOK = true; 
				}
			}
		}else if(claveImpuesto == "0005"){
			if(anoGravable != "" && anoGravable != "00" && periodoM != "" && periodoM != "00"){
				validacionOK = true;
			}
		}
		
		return validacionOK;
	},
	
	validarAntesSubmitPeriodo : function() {

		debugger;
        var claveImpuesto = $("#seleccion").val();
		var validacionOK = false;

		if(claveImpuesto == "0003" || claveImpuesto == "0004" || claveImpuesto == "0005"){
			validacionOK = true;
		}
		
		return validacionOK;
	},
	
	
	validarAntesSubmit_presentarDec : function() {

		debugger;
        var claveImpuesto = $("#impuesto").val();  	       
        var anoGravable = $("#anoGravable").val(); 	       
		var validacionOK = false;

		if(claveImpuesto == "2"){
			if(anoGravable != "" && anoGravable != "00"){
				validacionOK = true;
			}
		}
		
		return validacionOK;
	},
	
	
	obtener_desc_clavePeriodo : function (clavePeriodo){
		debugger;
		var descripcion = "";
		var des_periodo = clavePeriodo;
		
		tipo_periodo = ACC.opcionDeclaraciones.obtener_tipoPeriodo(clavePeriodo);
		if(tipo_periodo == "B"){
			id_periodo = ACC.opcionDeclaraciones.obtener_valorPeriodo(clavePeriodo);
			
			des_periodoB.forEach(function (eachItem) {
    	    	if(eachItem.itemId == id_periodo)
    	    		des_periodo = eachItem.itemValue;
    		});
		}
		des_anio = clavePeriodo.substring(0,2);
		descripcion = "20" + des_anio + " periodo " + des_periodo;
		
		
		return descripcion;
	},
	
	
	validarFiltro : function (itemInfo,idPeriodoFiltro){
		debugger;
		var validacionOK = false;
		var tipo_periodo = "";
		var idPeriodoItem = null;
		
		if(idPeriodoFiltro != null ){
			tipo_periodo = ACC.opcionDeclaraciones.obtener_tipoPeriodo(itemInfo.clavePeriodo);
			if(tipo_periodo == "B"){
				idPeriodoItem = ACC.opcionDeclaraciones.obtener_valorPeriodo(itemInfo.clavePeriodo);
				if(idPeriodoItem == idPeriodoFiltro){
					validacionOK = true;
				}
			}
		}else{
			validacionOK = true;
		}
		
		return validacionOK;
	},
	
	
	obtener_desc_clavePeriodo : function (clavePeriodo){
		debugger;
		var descripcion = "";
		var des_periodo = "";
		
		tipo_periodo = ACC.opcionDeclaraciones.obtener_tipoPeriodo(clavePeriodo);
		if(tipo_periodo == "B"){
			id_periodo = ACC.opcionDeclaraciones.obtener_valorPeriodo(clavePeriodo);
			
			des_periodoB.forEach(function (eachItem) {
    	    	if(eachItem.itemId == id_periodo)
    	    		des_periodo = eachItem.itemValue;
    		});
		}
		des_anio = clavePeriodo.substring(0,2);
		if(des_periodo == ""){
			descripcion = "20" + des_anio;	
		} else{
			descripcion = "20" + des_anio + " periodo " + des_periodo;	
		}
		
		
		return descripcion;
	},
	
	
	obtener_tipoPeriodo : function(clavePeriodo) {
		
		return clavePeriodo.substring(2,3);
	},
	
	
	obtener_valorPeriodo : function(clavePeriodo) {
		
		return clavePeriodo.substring(2,4);
	},
	
	
	
	ocultarTablas : function() {

		debugger;
		var x = document.getElementById('seleccion').value;
		
		var tablepredial = document.getElementById('table-predial');
		var tablevehicular = document.getElementById('table-vehicular');
		var tableica = document.getElementById('table-ica');
		var tablereteica = document.getElementById('table-reteica');
		var tablepublicidad = document.getElementById('table-publicidad');
		var tablegasolina = document.getElementById('table-gasolina');
		var cdus = document.getElementById('table-delineacion');
		
		
		tablepredial.style.display = 'none';
		tablevehicular.style.display = 'none';
		tableica.style.display = 'none';
		tablereteica.style.display = 'none';
		tablegasolina.style.display = 'none';
		cdus.style.display = 'none';
		tablepublicidad.style.display = 'none';
		
		ACC.opcionDeclaraciones.vaciarTablasInfo();

		if (x == '0001') {  //predial
			tablepredial.style.display = 'block';
		} else if (x == '0002') { //vehicular
			tablevehicular.style.display = 'block';
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
		
		
	},
	
	vaciarTablasInfo : function(){
		$("#table-vehicular1").find("tr:gt(0)").remove();
		$("#table-publicidad1").find("tr:gt(0)").remove();
		$("#table-gasolina1").find("tr:gt(0)").remove();
		$("#table-ica1").find("tr:gt(0)").remove();
		$("#table-reteica1").find("tr:gt(0)").remove();
		$("#table-delineacion1").find("tr:gt(0)").remove();
	},
	
	
	ocultarPeriodo : function(periodo) {
		var periodoElemento = document.getElementById('Periodo'+periodo);
		periodoElemento.style.display = 'none';
		
		
	},
	
	
	mostrarPeriodo : function(periodo) {
		var periodoElemento = document.getElementById('Periodo'+periodo);
		periodoElemento.style.display = 'block';

		
	},
	

	reiniciaPeriodo : function(periodo){
		
		if(periodo == "0"){
			var perAnual = document.getElementById('aniograv');
			perAnual.value = '00';
			
		}else if(periodo == "1"){
			var perMensualValue = document.getElementById('periodoM'); 
			perMensualValue.value = '00';
			
		}else if(periodo == "2"){
			var perBimestralValue = document.getElementById('periodoB');
			perBimestralValue.value = '00';
		}
		
	},
	
	reiniciaCertipagos : function(){
		var claveImpuesto = document.getElementById('seleccion').value;
		
		ACC.opcionDeclaraciones.dataActual_backup = null;
		ACC.opcionDeclaraciones.dataResponse_backup = null;
		ACC.opcionDeclaraciones.reiniciaPeriodo("0");
		
		ACC.opcionDeclaraciones.ocultarPeriodo("1");
		ACC.opcionDeclaraciones.ocultarPeriodo("2");
		ACC.opcionDeclaraciones.reiniciaPeriodo("1");
		ACC.opcionDeclaraciones.reiniciaPeriodo("2");
		
		

	},
	
	
	reiniciaPeriodosMB : function(){

		debugger;
		ACC.opcionDeclaraciones.ocultarPeriodo("1");
		ACC.opcionDeclaraciones.ocultarPeriodo("2");
		ACC.opcionDeclaraciones.reiniciaPeriodo("1");
		ACC.opcionDeclaraciones.reiniciaPeriodo("2");
		
	},
	
	determinaPeriodoMBCertipagos : function(){
		
		debugger;
		var claveImpuesto = document.getElementById('seleccion').value;
		
		if(claveImpuesto == '0005'){
			ACC.opcionDeclaraciones.mostrarPeriodo(1);
		}
		
		if(claveImpuesto == '0004'){
			ACC.opcionDeclaraciones.mostrarPeriodo(2);
		}
		
		if(claveImpuesto == '0003'){
			ACC.opcionDeclaraciones.mostrarPeriodo(2);
		}
		
	},
	
	
	obtenerListaDeclaraciones_presentarDec : function(claveImpuesto) {

		debugger;
		if(ACC.opcionDeclaraciones.validarAntesSubmit_presentarDec()){
	        var anoGravable = $("#anoGravable").val();
			var dataActual = {};

			
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anoGravable = anoGravable;
			
			
			$.ajax({
				url : ACC.presentarDecListaDeclaracionesURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.opcionDeclaraciones.updateFromResponseSeleccion_presentarDec(dataActual,dataResponse);
				},
				error : function() {
					alert("Error procesar la solicitud");	
				}
			});
		}
		
		
	},
	
	
	prepararVehicular_presentarDec : function(claveImpuesto){
		
		debugger;
		if(claveImpuesto == '2'){ 
	        var divPeriodo2 = document.getElementById('seccionPeriodo2');
	        divPeriodo2.style.display = 'none';
	        
	        var btnAction = document.getElementById('action');
	        btnAction.style.display = 'none';
	        
	        var tblVehicular = document.getElementById('table-vehicular');
	        tblVehicular.style.display = 'block';
	        
	        var anoGravable = document.getElementById('anoGravable');
	        var d = new Date();
	        var n = d.getFullYear();
	        
			$("#anoGravable").find("option:gt(0)").remove();

			$('#anoGravable').append('<option value="'+ n +'">'+ n + "</option>");
			n--;
			$('#anoGravable').append('<option value="'+ n +'">'+ n + "</option>");
			n--;
			$('#anoGravable').append('<option value="'+ n +'">'+ n + "</option>");
			
			
		}
		
	},
	
	
	vaciarTablasInfo_presentarDec : function(){
		$("#table-vehicular1").find("tr:gt(0)").remove();
		$("#table-myTable").find("tr:gt(0)").remove();
	},

	

	

};