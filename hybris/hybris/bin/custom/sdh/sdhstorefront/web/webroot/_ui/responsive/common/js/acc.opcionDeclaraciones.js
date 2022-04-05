ACC.opcionDeclaraciones = {

	dataActual_backup:{},
	dataResponse_backup:{},
	
	_autoload : [ "bindDeclaracionPDF", "bindCertiPagosImprime", "bindCertiPagosImprimeForm", "bindDeclaracionImprime","bindDialogDeclaracionGenerica"],
	
	bindDeclaracionPDF : function() {
		$(document).on("click", ".consultaDecPDF", function(e) {
			e.preventDefault();	
			ACC.spinner.show();
			if(ACC.opcionDeclaraciones.validarAntesSubmit()){
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
						continue;
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
						ACC.spinner.close();
						ACC.opcionDeclaraciones.updateFromResponsePDF(dataActual,dataResponse);
					},
					error : function() {
						ACC.spinner.close();
						alert("Error procesar la solicitud");	
					}
				});
			}
		});
	},
	
	
	bindDeclaracionImprime : function() {
		$(document).on("click", ".declaracionImprime", function(e) {
			e.preventDefault();	
			ACC.spinner.show();
			if(ACC.opcionDeclaraciones.validarAntesSubmit()){
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
						ACC.spinner.close();
						ACC.opcionDeclaraciones.updateFromResponsePDF(dataActual,dataResponse);
					},
					error : function() {
						ACC.spinner.close();
						alert("Error procesar la solicitud");	
					}
				});
			}
		});
	},
	
	
	bindCertiPagosImprime : function() {
		$(document).on("click", ".certiPagosImprime", function(e) {
			e.preventDefault();	
			ACC.spinner.show();

			if(ACC.opcionDeclaraciones.validarAntesSubmit()){
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
					
				for (var i = 0; i < 1000; i++) {
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
						ACC.spinner.close();
						ACC.opcionDeclaraciones.updateFromResponseImprimir(dataActual,dataResponse);
					},
					error : function() {
						ACC.spinner.close();
						alert("Error procesar la solicitud");	
					}
				});
			}
		});
	},
	
	
	bindCertiPagosImprimeForm : function() {
		$(document).on("click", ".certiPagosImprimeForm", function(e) {
			e.preventDefault();	
			ACC.spinner.show();

			
			var dataActual = {};
			
			dataActual.bp = document.getElementById("psePaymentForm.bp").value;
			dataActual.tipoDeImpuesto = document.getElementById("psePaymentForm.tipoDeImpuesto").value;
			dataActual.anoGravable = document.getElementById("psePaymentForm.anoGravable").value;
			dataActual.periodo = document.getElementById("psePaymentForm.periodo").value;
			dataActual.numeroDeReferencia = document.getElementById("psePaymentForm.numeroDeReferencia").value;
			
			$.ajax({
				url : ACC.certiPagoImprimeFormURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.spinner.close();
					ACC.opcionDeclaraciones.updateFromResponseImprimirForm(dataActual,dataResponse);
				},
				error : function() {
					ACC.spinner.close();
					alert("Error la procesar la solicitud");	
				}
			});
			
		});
	},
	
	updateFromResponseImprimirForm : function(infoActual,infoResponse) {
		if(infoResponse.urlDownload != null){
			$("#downloadHelper").attr("href",infoResponse.urlDownload);
			document.getElementById("downloadHelper").click();
		}
		else{
			alert(infoResponse.impresionResponse.errores[0].txtmsj);
		}		
	},
	
	
	updateFromResponsePDF : function(infoActual,infoResponse) {
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
		if (infoResponse.impresionResponse.errores != null){
			if (infoResponse.impresionResponse.errores[0].idmsj == "0" || infoResponse.impresionResponse.errores[0].idmsj == ""){
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
	
	
	
	
	
	obtenerListaDeclaraciones_certiPagos : function() {
		
		ACC.spinner.show();
		ACC.opcionDeclaraciones.ocultarTablas();
		ACC.publicidadexterior.bindDataTable_Class_refresh();
		ACC.opcionDeclaraciones.vaciarTablasInfo();
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
					ACC.spinner.close();
//					ACC.opcionDeclaraciones.dataActual_backup = dataActual;
//					ACC.opcionDeclaraciones.dataResponse_backup = dataResponse;
					ACC.opcionDeclaraciones.mostrarErrores_certiPagos(dataResponse);
					ACC.opcionDeclaraciones.updateFromResponseSeleccion_certiPagos(dataActual,dataResponse,null);					
					ACC.publicidadexterior.bindDataTable_Class();
//					ACC.opcionDeclaraciones.habilitarFiltroPeriodo(dataActual,dataResponse);
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud");	
				}
			});
		}else{
			ACC.spinner.close();
		}
		
		
	},
	
	
	obtenerListaDeclaraciones : function(certificacionDeclaracion) {
		ACC.spinner.show();
		ACC.opcionDeclaraciones.ocultarTablas();
		ACC.publicidadexterior.bindDataTable_Class_refresh();
		ACC.opcionDeclaraciones.vaciarTablasInfo();
		if(ACC.opcionDeclaraciones.validarAntesSubmit()){
	        var claveImpuesto = $("#seleccion").val();  	       
	        var anoGravable = $("#aniograv").val();
			var dataActual = {};

			
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anoGravable = anoGravable;
			dataActual.periodo = ACC.opcionDeclaraciones.obtenerPeriodoPorImpuesto(claveImpuesto);
			dataActual.certificacionDeclaracion = certificacionDeclaracion;
			
			$.ajax({
				url : ACC.listaDeclaracionesURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.spinner.close();
					ACC.opcionDeclaraciones.updateFromResponseSeleccion(dataActual,dataResponse);
					ACC.publicidadexterior.bindDataTable_Class();
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud");	
				}
			});
		}else{
			ACC.spinner.close();
		}
		
		
	},
	
	
	
	
	
	obtenerPeriodoPorImpuesto : function(claveImpuesto){
        var periodoM = $("#periodoM").val();
        var periodoB = $("#periodoB").val();
        var perBimestral = document.getElementById('Periodo2'); //bimestral
        var periodo = '00';

		if(perBimestral != null && perBimestral.style.display == 'block'){
			periodo = periodoB;
		}else{
			periodo = periodoM;
		}
		
		return periodo;
	},
	
	
	prepararPeriodo : function() {
		ACC.spinner.show();
		if(ACC.opcionDeclaraciones.validarAntesSubmitPeriodo()){
	        var claveImpuesto = $("#seleccion").val();  	       
	        var anoGravable = $("aniograv").val();  	       
			var dataActual = {};
		
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anoGravable = anoGravable;
			
			
			$.ajax({
				url : ACC.tipoPeriodoDeclaracionURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.spinner.close();
					ACC.opcionDeclaraciones.updateFromResponsePeriodo(dataActual,dataResponse);
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud obtener tipo de periodo");	
				}
			});
		}else{
			ACC.spinner.close();
		}
		
		
	},
	
	obtenerListaDeclaraciones_porAnio : function(certificacionDeclaracion) {
		
		ACC.spinner.show();
		
		ACC.opcionDeclaraciones.vaciarTablasInfo();
		
		if(ACC.opcionDeclaraciones.validarAntesSubmitPeriodo()){
	        var claveImpuesto = $("#seleccion").val();  	       
	        var anoGravable = $("#aniograv").val();  	       
			var dataActual = {};
		
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anoGravable = anoGravable;
			
			
			$.ajax({
				url : ACC.tipoPeriodoDeclaracionURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.spinner.close();
					ACC.opcionDeclaraciones.updateFromResponsePeriodo_porAnio(dataActual,dataResponse);
					ACC.opcionDeclaraciones.obtenerListaDeclaraciones(certificacionDeclaracion);
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud obtener tipo de periodo");	
				}
			});
		}else{
			ACC.spinner.close();
		    ACC.opcionDeclaraciones.obtenerListaDeclaraciones(certificacionDeclaracion);
		}
		
		
	},
	
	obtenerListaDeclaraciones_certiPagos_porAnio : function() {
		ACC.spinner.show();
		if(ACC.opcionDeclaraciones.validarAntesSubmitPeriodo()){
	        var claveImpuesto = $("#seleccion").val();  	       
	        var anoGravable = $("#aniograv").val();  	       
			var dataActual = {};
		
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anoGravable = anoGravable;
			
			
			$.ajax({
				url : ACC.tipoPeriodoDeclaracionURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.spinner.close();
					ACC.opcionDeclaraciones.updateFromResponsePeriodo_porAnio(dataActual,dataResponse);
					ACC.opcionDeclaraciones.obtenerListaDeclaraciones_certiPagos();
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud obtener tipo de periodo");	
				}
			});
		}else{
			ACC.spinner.close();
			ACC.opcionDeclaraciones.obtenerListaDeclaraciones_certiPagos();
		}
		
	},
	
	
	updateFromResponsePeriodo_porAnio : function(infoActual,infoResponse) {
		var perMensual = document.getElementById('Periodo1'); //mensual
		var perBimestral = document.getElementById('Periodo2'); //bimestral
		var perMensualValue = document.getElementById('periodoM'); 
		var perBimestralValue = document.getElementById('periodoB'); 
		
		perMensualValue.value = '00';
		perBimestralValue.value = '00';
		
		ACC.opcionDeclaraciones.establecerEstiloDisplay(perMensual,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(perBimestral,'none');
		if (infoResponse.tipoPeriodoDec == '1') {
			ACC.opcionDeclaraciones.establecerEstiloDisplay(perMensual,'block');
		} else if (infoResponse.tipoPeriodoDec == '2') {
			ACC.opcionDeclaraciones.establecerEstiloDisplay(perBimestral,'block');
		}
		
		
	},
	
	updateFromResponsePeriodo : function(infoActual,infoResponse) {
		var perMensual = document.getElementById('Periodo1'); //mensual
		var perBimestral = document.getElementById('Periodo2'); //bimestral
		var perAnual = document.getElementById('aniograv');
		var perMensualValue = document.getElementById('periodoM'); 
		var perBimestralValue = document.getElementById('periodoB'); 
		
		perAnual.value = '00';
		perMensualValue.value = '00';
		perBimestralValue.value = '00';
		
		ACC.opcionDeclaraciones.establecerEstiloDisplay(perMensual,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(perBimestral,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(perAnual,'none');
		if (infoResponse.tipoPeriodoDec == '0') {
			ACC.opcionDeclaraciones.establecerEstiloDisplay(perAnual,'block');
		} else if (infoResponse.tipoPeriodoDec == '1') {
			ACC.opcionDeclaraciones.establecerEstiloDisplay(perAnual,'block');
			ACC.opcionDeclaraciones.establecerEstiloDisplay(perMensual,'block');
		} else if (infoResponse.tipoPeriodoDec == '2') {
			ACC.opcionDeclaraciones.establecerEstiloDisplay(perAnual,'block');
			ACC.opcionDeclaraciones.establecerEstiloDisplay(perBimestral,'block');
		}
		
		
	},
	
	
	mostrarErrores_certiPagos : function (infoResponse) {
		if (infoResponse.errores != null && infoResponse.errores[0] != null && infoResponse.errores[0].idmsj != 0){
			alert(infoResponse.errores[0].txtmsj);
		}
	},
	
	
	updateFromResponseSeleccion : function(infoActual,infoResponse) {
		ACC.opcionDeclaraciones.vaciarTablasInfo();

		if (infoResponse.errores != null){
			alert(infoResponse.errores[0].txtmsj);
		}else{

			if(infoActual.claveImpuesto == '0001'){
				if(infoResponse.predial.length > 0){
					$.each(infoResponse.predial, function (index,value){
						$('#table-predial1').append("<tr>"+
								'<td>' + value.CHIP + '</td>'+
								'<td>' + value.matrInmobiliaria + '</td>'+
								'<td>' + value.direccionPredio + '</td>'+
								'<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value.numObjeto +'"' +">" + "</td>"+
								"</tr>");
					});
				}
			}

			if(infoActual.claveImpuesto == '0002'){
				if(infoResponse.vehicular.length > 0){
					$.each(infoResponse.vehicular, function (index,value){
						var marcaDescripcion = ACC.opcionDeclaraciones.obtenerDesc_marca(value.marca);
						
						$('#table-vehicular1').append("<tr>"+
								'<td>' + value.placa + '</td>'+
								'<td>' + marcaDescripcion + '</td>'+
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
							if(value.radicados!= null){
								numRadicado = value.radicados[0].numRadicado;
							}

							if(infoActual.certificacionDeclaracion != null ){
                                if(  numRadicado == null || numRadicado == "" ){
                                    $('#table-delineacion1').append("<tr>"+
                                        '<td>' + value.cdu + '</td>'+
                                        '<td>' + numRadicado + '</td>'+
                                        '<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value.numObjeto + '" data-numRadicado="'+ numRadicado +'"' +">" + "</td>"+
                                        "</tr>");
                                }        
                            }else{                                
                                $('#table-delineacion1').append("<tr>"+
                                        '<td>' + value.cdu + '</td>'+
                                        '<td>' + numRadicado + '</td>'+
                                        '<td><input id="registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value.numObjeto + '" data-numRadicado="'+ numRadicado +'"' +">" + "</td>"+
                                        "</tr>");
                            }        
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
		debugger;
		var desc_clavePeriodo = "";
		var reteIca_consecutivo = "";
		var indiceTabla = 0;
		if(infoResponse != null && infoResponse.declaracionesCertiPagos!= null && infoResponse.declaracionesCertiPagos.declaraciones != null){
			if(infoResponse.declaracionesCertiPagos.declaraciones.length > 0){

				if(infoActual.claveImpuesto == '0001'){
					indiceTabla = 0;
					$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index1,value1){
						if(value1.numObjeto != ""){
							$.each(infoResponse.customerData.predial, function (index2,value2){
								if( value1.numObjeto.replace(/^0+/, '').trim() == value2.numObjeto.replace(/^0+/, '').trim() ){
									desc_clavePeriodo = ACC.opcionDeclaraciones.obtener_desc_clavePeriodo(value1.clavePeriodo);
									$('#table-predial1').append("<tr>"+
											'<td>' + value2.CHIP + '</td>'+
											'<td>' + value2.matrInmobiliaria + '</td>'+
											'<td>' + value1.direccionPredio + '</td>'+
											'<td><input id="registroNum_'+ indiceTabla +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto  +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe.replace(/,/g, '') + '"' +">" + "</td>"+
											"</tr>");
										indiceTabla++;
								}
							});
						}
					});
				}

				if(infoActual.claveImpuesto == '0002'){
					indiceTabla = 0;
					$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
						if(value1.numObjeto != ""){
							$.each(infoResponse.customerData.vehicular, function (index,value2){
								if(value1.numObjeto == value2.numObjeto){
									desc_clavePeriodo = ACC.opcionDeclaraciones.obtener_desc_clavePeriodo(value1.clavePeriodo);
									var desc_marca = ACC.opcionDeclaraciones.obtenerDesc_marca(value2.marca);
									
									$('#table-vehicular1').append("<tr>"+
											'<td>' + value2.placa + '</td>'+
											'<td>' + desc_marca + '</td>'+
											'<td>' + desc_clavePeriodo + '</td>'+
											'<td>' + value1.referencia + '</td>'+
											'<td>' + value1.importe + '</td>'+
											'<td>' + value1.moneda + '</td>'+
											'<td><input id="registroNum_'+ indiceTabla +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto  +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
											"</tr>");
										indiceTabla++;
								}
							});
						}
					});
				}

				if(infoActual.claveImpuesto == '0003'){
					indiceTabla = 0;
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
											'<td><input id="registroNum_'+ indiceTabla +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto +'" data-ctaContrato="' + value1.ctaContrato + '" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
											"</tr>");
										indiceTabla++;
									}
								}
							}
						});
					}
				}


				if(infoActual.claveImpuesto == '0004'){
					indiceTabla = 0;
					$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
						if(value1.numObjeto != ""){
							if(value1.numObjeto == infoResponse.customerData.reteIca.numObjeto){
								desc_clavePeriodo = ACC.opcionDeclaraciones.obtener_desc_clavePeriodo(value1.clavePeriodo);
								reteIca_consecutivo = ACC.opcionDeclaraciones.obtener_desc_consecutivo(infoResponse.customerData.reteIca.consecutivo);
								$('#table-reteica1').append("<tr>"+
									'<td>' + infoResponse.customerData.reteIca.numID  + '</td>'+
									'<td>' + reteIca_consecutivo + '</td>'+
									'<td>' + desc_clavePeriodo + '</td>'+
									'<td>' + value1.referencia + '</td>'+
									'<td>' + value1.importe + '</td>'+
									'<td>' + value1.moneda + '</td>'+
									'<td><input id="registroNum_'+ indiceTabla +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia +  '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
									"</tr>");
								indiceTabla++;
							}
						}
					});
				}

				if(infoActual.claveImpuesto == '0005'){
					indiceTabla = 0;
					$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
						if(value1.numObjeto != ""){
							$.each(infoResponse.customerData.gasolina, function (index,value2){
								if(value1.numObjeto == value2.numObjeto){
									desc_clavePeriodo = ACC.opcionDeclaraciones.obtener_desc_clavePeriodo(value1.clavePeriodo);
									$('#table-gasolina1').append("<tr>"+
										'<td>' + value2.tipoDoc  + '</td>'+
										'<td>' + value2.numDoc + '</td>'+
										'<td>' + desc_clavePeriodo + '</td>'+
										'<td>' + value1.referencia + '</td>'+
										'<td>' + value1.importe + '</td>'+
										'<td>' + value1.moneda + '</td>'+
										'<td><input id="registroNum_'+ indiceTabla +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm +  '" data-importe="' + value1.importe + '"' +">" + "</td>"+
										"</tr>");
									indiceTabla++;
								}
							});
						}
					});
				}

				if(infoActual.claveImpuesto == '0006'){
					indiceTabla = 0;
					$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
						if(value1.numObjeto != ""){
							$.each(infoResponse.customerData.delineacion, function (index,value2){
								if(value1.numObjeto == value2.numObjeto){
									desc_clavePeriodo = ACC.opcionDeclaraciones.obtener_desc_clavePeriodo(value1.clavePeriodo);
									$('#table-delineacion1').append("<tr>"+
											'<td>' + value1.numRadicado + '</td>'+
											'<td>' + value1.noRadicado + '</td>'+
											'<td>' + desc_clavePeriodo + '</td>'+
											'<td>' + value1.referencia + '</td>'+
											'<td>' + value1.importe + '</td>'+
											'<td>' + value1.moneda + '</td>'+
											'<td><input id="registroNum_'+ indiceTabla +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto  +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
											"</tr>");
									indiceTabla++;
								}
							});
						}
					});
				}

				if(infoActual.claveImpuesto == '0007'){
					indiceTabla = 0;
					$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
						if(value1.numObjeto != ""){
							$.each(infoResponse.customerData.publicidadExt, function (index,value2){
								if(value1.numObjeto == value2.numObjeto){
									desc_clavePeriodo = ACC.opcionDeclaraciones.obtener_desc_clavePeriodo(value1.clavePeriodo);
									$('#table-publicidad1').append("<tr>"+
											'<td>' + value2.numResolu + '</td>'+
											'<td>' + value2.tipoValla + '</td>'+
											'<td>' + desc_clavePeriodo + '</td>'+
											'<td>' + value1.referencia + '</td>'+
											'<td>' + value1.importe + '</td>'+
											'<td>' + value1.moneda + '</td>'+
											'<td><input id="registroNum_'+ indiceTabla +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto  +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
											"</tr>");
									indiceTabla++;
								}
							});
						}
					});
				}


				if(infoActual.claveImpuesto == '0008'){
					indiceTabla = 0;
					$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
						if(value1.numObjeto != ""){
							$.each(infoResponse.customerData.delineacion, function (index,value2){
								if(value1.numObjeto == value2.numObjeto){
									desc_clavePeriodo = ACC.opcionDeclaraciones.obtener_desc_clavePeriodo(value1.clavePeriodo);
									$('#table-retedelineacion1').append("<tr>"+
											'<td>' + value2.cdu + '</td>'+
											'<td>' + value1.noRadicado + '</td>'+
											'<td>' + desc_clavePeriodo + '</td>'+
											'<td>' + value1.referencia + '</td>'+
											'<td>' + value1.importe + '</td>'+
											'<td>' + value1.moneda + '</td>'+
											'<td><input id="registroNum_'+ indiceTabla +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="radio" value="" data-numObjeto="'+ value1.numObjeto  +'" data-ctaContrato="' + value1.ctaContrato +'" data-clavePeriodo="' + value1.clavePeriodo + '" data-referencia="' + value1.referencia + '" data-fechaCompensa="' + value1.fechaCompensa + '" data-moneda="' + value1.moneda + '" data-numDocPago="' + value1.numDocPago + '" data-numfactForm="' + value1.numfactForm + '" data-importe="' + value1.importe + '"' +">" + "</td>"+
											"</tr>");
									indiceTabla++;
								}
							});
						}
					});
				}


			}
		}


	},


	updateFromResponseSeleccion_presentarDec : function(infoActual,infoResponse) {
		var flagHuboRegistros = false;
		var anioGravable = document.getElementById("anoGravable").value;

		ACC.opcionDeclaraciones.vaciarTablasInfo_presentarDec();

		if (infoResponse.errores != null){
			alert(infoResponse.errores[0].txtmsj);
		}else{
			if(infoActual.claveImpuesto == '2'){
				var urlDeclaracion = "contribuyentes/sobrevehiculosautomotores/prepararParaDeclaracion";
				var urlPrefijo = obtenerURLBase();
				if(infoResponse.vehicular.length > 0){
					$.each(infoResponse.vehicular, function (index,value){
						if(value.placa != null && value.placa !=""){
//							var url = urlPrefijo + urlDeclaracion + '?anioGravable=' + anioGravable + '&placa=' + value.placa + '&numBPP=' + infoResponse.numBP + '&numForma=' + value.numForm ;
							var url = urlPrefijo + urlDeclaracion + '?anioGravable=' + anioGravable + '&placa=' + value.placa + '&numBPP=' + infoResponse.numBP;

							value.blindado = ACC.opcionDeclaraciones.obtenerDesc_blindado(value.blindado);
							value.carroceria = ACC.opcionDeclaraciones.obtenerDesc_carroceria(value.carroceria);
							value.clase = ACC.opcionDeclaraciones.obtenerDesc_clase(value.clase);
							value.linea = ACC.opcionDeclaraciones.obtenerDesc_linea(value.marca+"_"+value.linea);
							value.marca = ACC.opcionDeclaraciones.obtenerDesc_marca(value.marca);

							
							var idActo = 12345;
							var fechActo = 12/03/2020;
							var desActo = "Ejemplo de acto";
							var expActo = "12345ABC";


							 var obtenerURLGenDec = ACC.opcionDeclaraciones.verificarGenerarDec(value,url);
						
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
							
//									'<td>'+'<div data-toggle="tooltip" title="ID Acto: '+idActo+'&#10 Fecha de Notificación: '+fechActo+'&#10 Descripción: '+desActo+'&#10 Expediente: '+expActo+'">'+'<a href="#" onclick="">?</a>'+'</div></td>'+
//									'<td><a href="#" onclick="ACC.opcionDeclaraciones.validarDeclaracion(\''+url+'\',\''+value.placa+'\');">Generar Declaracion</a> </td>'+
// ACC.opcionDeclaraciones.detalleActo(); Agregar para mandar a la siguiente página
									'<td>' + obtenerURLGenDec + '</td>'+
									"</tr>");
						}
					});
				}

			}else if(infoActual.claveImpuesto == '1'){
				var nombrePresentarDec = "";
				var nombrePagarEnLinea = "";
				var nombreTotalPagar = "";

				var strClaveImpuesto = "'5101'";

				$.each(infoResponse.predial, function (index,value){
					debugger;
					nombrePresentarDec = "btnPresentarDec_"+value.CHIP;
					nombrePagarEnLinea = "btnPagarEnLinea_"+value.CHIP;
					nombreTotalPagar = "totalPagar_"+value.CHIP;
					
					var strChip = "''";
					if ( value.CHIP != null ){
					  var strChip = "'"+value.CHIP+"'";	
					}else{
					  value.CHIP  = "";	
					}	
					
					var strMatrInmobiliaria = "'"+value.matrInmobiliaria+"'";
					var strAnioGravable = "'"+value.anioGravable+"'";
					var strAnioGravable_value = "''";
					
					var strPeriodo = "''";
					var strNumObjeto = "'"+value.numObjeto+"'";

					var idActo = 12345;
					var fechActo = 12/03/2020;
					var desActo = "Ejemplo de acto";
					var expActo = "12345ABC";
					
					var direccionPredioOut = "";
					if(value.direccionPredio != null){
						direccionPredioOut = value.direccionPredio;
					}
					
					var contratoArrendaOut = "";
					if(value.contratoArrenda != null){
						contratoArrendaOut = value.contratoArrenda;
					}
					if(document.getElementById("anoGravable") != null){
						strAnioGravable_value = "'"+ document.getElementById("anoGravable").value+"'";
					}
					
					


					$('#table-predial1').append("<tr>"+
							'<td>' + value.CHIP + '</td>'+
							'<td>' + value.matrInmobiliaria + '</td>'+
							'<td>' + direccionPredioOut + '</td>'+
							'<td>' + contratoArrendaOut + '</td>'+
					//		'<td><div data-toggle="tooltip" title="tooltip">'+'<a href="#" onclick="ACC.opcionDeclaraciones.detalleActo();">?</a>'+'</div></td>'+
//				'<td>'+'<div data-toggle="tooltip" title="ID Acto: '+idActo+'&#10 Fecha de Notificación: '+fechActo+'&#10 Descripción: '+desActo+'&#10 Expediente: '+expActo+'">'+'<a href="#" onclick="">?</a>'+'</div></td>'+
				// ACC.opcionDeclaraciones.detalleActo(); agregara para funcionamiento de id acto ?
//							'<td>' + '<button type="button" id="' + nombrePresentarDec +
//							'" name="'+ nombrePresentarDec+ '" value="presentarDec" class="btn-primary"'+
//							' onclick="presentarDeclaracion('+strChip+','+strAnioGravable+')">' +
//							'Presentar declaración</button>' + '</td>'+
//							'<td><label class="text-capitalize !important " id="'+nombreTotalPagar+'" hidden="true"></label></td>'+
//							'<td><button type="button" id="'+nombrePagarEnLinea+'"'+
//							'name="${nombrePagarEnLinea}" value="pagarEnLinea" class="btn-primary" hidden="true"'+
//							'onclick="pagarEnLinea('+strClaveImpuesto+','+strAnioGravable+','+strPeriodo+','+strNumObjeto+','+strChip+')">'+
//							'Pagar en linea</button>' + '</td>'+

							'<td><a href="#" onclick="ACC.opcionDeclaraciones.validarDeclaracionPredial(' + strChip + ',' + strMatrInmobiliaria + ',' + strNumObjeto + ',' + strAnioGravable_value +');">Generar Declaracion</a> </td>'+
							"</tr>");
				});

			}else if(infoActual.claveImpuesto == '6'){
				var nombrePresentarDec = "";
				var nombrePagarEnLinea = "";
				var nombreTotalPagar = "";

				var strClaveImpuesto = "'5101'";

				$.each(infoResponse.delineacion, function (index,value){
//					nombrePresentarDec = "btnPresentarDec_"+value.chip;
//					nombrePagarEnLinea = "btnPagarEnLinea_"+value.chip;
//					nombreTotalPagar = "totalPagar_"+value.chip;
//					var strChip = "'"+value.chip+"'";
//					var strAnioGravable = "'"+value.anioGravable+"'";
//					var strPeriodo = "''";
//					var strNumObjeto = "'"+value.numObjeto+"'";
//
//					var idActo = 12345;
//					var fechActo = 12/03/2020;
//					var desActo = "Ejemplo de acto";
//					var expActo = "12345ABC";


					$('#table-delineacion1').append("<tr>"+
							'<td class="col-sm-2">' + value.cdu + '</td>'+
							'<td><select id="selctipobliga" class="newalto form-control" onchange="ShowSelected(this)"> <option value="0-${item.cdu}">Seleccionar</option> <option value="1-${item.cdu}">Declaraci&oacuten</option><option value="2-${item.cdu}">Retenci&oacuten</option> </select> </td>'+
							'<td>' + "tipo licencia" + '</td>'+
							'<td>' + "Presentar declaracion" + '</td>'+
					//		'<td><div data-toggle="tooltip" title="tooltip">'+'<a href="#" onclick="ACC.opcionDeclaraciones.detalleActo();">?</a>'+'</div></td>'+
//				'<td>'+'<div data-toggle="tooltip" title="ID Acto: '+idActo+'&#10 Fecha de Notificación: '+fechActo+'&#10 Descripción: '+desActo+'&#10 Expediente: '+expActo+'">'+'<a href="#" onclick="">?</a>'+'</div></td>'+
				// ACC.opcionDeclaraciones.detalleActo(); agregara para funcionamiento de id acto ?
//							'<td>' + '<button type="button" id="' + nombrePresentarDec +
//							'" name="'+ nombrePresentarDec+ '" value="presentarDec" class="btn-primary"'+
//							' onclick="presentarDeclaracion('+strChip+','+strAnioGravable+')">' +
//							'Presentar declaración</button>' + '</td>'+
//							'<td><label class="text-capitalize !important " id="'+nombreTotalPagar+'" hidden="true"></label></td>'+
//							'<td><button type="button" id="'+nombrePagarEnLinea+'"'+
//							'name="${nombrePagarEnLinea}" value="pagarEnLinea" class="btn-primary" hidden="true"'+
//							'onclick="pagarEnLinea('+strClaveImpuesto+','+strAnioGravable+','+strPeriodo+','+strNumObjeto+','+strChip+')">'+
//							'Pagar en linea</button>' + '</td>'+

//							'<td><a href="#" onclick="ACC.opcionDeclaraciones.validarDeclaracionPredial(\''+value.chip+'\',\''+value.matrInmobiliaria+'\');">Generar Declaracion</a> </td>'+
							"</tr>");
				});

			}
			
			
			
		}

		if(flagHuboRegistros == true){
	        var btnAction = document.getElementById('action');
			ACC.opcionDeclaraciones.establecerEstiloDisplay(btnAction,'block');
		}


	},
	
	
	obtenerDesc_blindado : function(id_item){
		var descripcion = "";
		blindado_vehi.some(function (eachCat) {
			if(eachCat.i == id_item){
				descripcion = eachCat.d;
				return true;
			}
		});
		
		return descripcion;
	},
	
	
	obtenerDesc_carroceria : function(id_item){
		var descripcion = "";
		carroceria_vehi.some(function (eachCat) {
			if(eachCat.i == id_item){
				descripcion = eachCat.d;
				return true;
			}
		});
		
		return descripcion;
	},
	
	
	obtenerDesc_clase : function(id_item){
		var descripcion = "";
		clase_vehi.some(function (eachCat) {
			if(eachCat.i == id_item){
				descripcion = eachCat.d;
				return true;
			}
		});
		
		return descripcion;
	},
	
	
	obtenerDesc_marca : function(id_item){
		var descripcion = "";
		marca_vehi.some(function (eachCat) {
			if(eachCat.i == id_item){
				descripcion = eachCat.d;
				return true;
			}
		});
		
		return descripcion;
	},
	
	
	obtenerDesc_linea : function(id_item){
		var descripcion = "";
		var flagEncontrado = false;
		
		linea_vehi.some(function (eachCat) {
			if(eachCat.i == id_item){
				descripcion = eachCat.d;
				flagEncontrado = true;
				return true;
			}
		});
		
		
		if(!flagEncontrado){
			linea_vehi2.some(function (eachCat) {
				if(eachCat.i == id_item){
					descripcion = eachCat.d;
					flagEncontrado = true;
					return true;
				}
			});
		}
		
		if(!flagEncontrado){
			linea_vehi3.some(function (eachCat) {
				if(eachCat.i == id_item){
					descripcion = eachCat.d;
					flagEncontrado = true;
					return true;
				}
			});
		}
		
		if(!flagEncontrado){
			linea_vehi4.some(function (eachCat) {
				if(eachCat.i == id_item){
					descripcion = eachCat.d;
					flagEncontrado = true;
					return true;
				}
			});
		}
		
		if(!flagEncontrado){
			linea_vehi5.some(function (eachCat) {
				if(eachCat.i == id_item){
					descripcion = eachCat.d;
					flagEncontrado = true;
					return true;
				}
			});
		}
		
		if(!flagEncontrado){
			linea_vehi6.some(function (eachCat) {
				if(eachCat.i == id_item){
					descripcion = eachCat.d;
					flagEncontrado = true;
					return true;
				}
			});
		}

		if(!flagEncontrado){
			linea_vehi7.some(function (eachCat) {
				if(eachCat.i == id_item){
					descripcion = eachCat.d;
					flagEncontrado = true;
					return true;
				}
			});
		}		
		
		return descripcion;
	},

	

	validarDeclaracionPredial : function(chip,matricula, numObjeto, anioGravable_value){
		debugger;
		ACC.spinner.show();
		var anioGravable = anioGravable_value;


	    var data = {};

	    data.anioGravable = anioGravable;
		data.CHIP = chip;
		data.matrInmobiliaria = matricula;
		data.numObjeto = numObjeto;


        $.ajax({
            url : ACC.declaracionPredialURL,
            data : data,
            type : "GET",
            success : function(dataResponse) {
            	ACC.spinner.close();
				ACC.predial.establecerMensajeInfoObjeto(ACC.predial.leerMensajesInfoObjeto(dataResponse));
            	if(ACC.predial.mostrarMensajeInfoObjeto()){
            		return false;
            	}
            	//var currentUrl_tmp = "";
            	//var newurl = "";
        	    //var currentUrl = window.location.href;
                //alert(data.opcionuso);
                if(dataResponse.opcionuso == "02"){
                    var r = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
                    if (r == true) {
                        ACC.opcionDeclaraciones.redirectRequestPredial(dataResponse.url, dataResponse.anioGravable, dataResponse.chip, dataResponse.matrInmobiliaria, dataResponse.numBP, data.numObjeto);
                    } else {
                        window.location.href =  currentUrl;
                    }
                }else{
	
                    ACC.opcionDeclaraciones.redirectRequestPredial(dataResponse.url, dataResponse.anioGravable, dataResponse.chip, dataResponse.matrInmobiliaria, dataResponse.numBP, data.numObjeto);
                }
           	},
            error : function() {
				ACC.spinner.close();
                alert("Error");
            }
        });
	},

	redirectRequestPredial : function(url, anioGravable, chip, inmobiliatia, numBp, objetoContrato){
	    var currentUrl_tmp = "";
        var newurl = "";
		var parametros = "?anioGravable=" + anioGravable + "&chip=" + chip + "&matricula=" +inmobiliatia +"&numBP=" +numBp + "&objetoContrato=" + objetoContrato;

        var currentUrl = window.location.href;
        var currentUrl_origen = "";
        var targetUrl = "";
        
        if(currentUrl.indexOf("/contribuyentes/presentar-declaracion") >= 0){
			currentUrl_origen = "/contribuyentes/presentar-declaracion";
		}
		if(currentUrl.indexOf("/contribuyentes/consultas/obligaciones") >= 0){
			currentUrl_origen = "/contribuyentes/consultas/obligaciones";
		}
        
        switch (url){
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
				targetUrl = "/contribuyentes/predialunificado_" + url + parametros;
				break;
			case "9":
				targetUrl = "/contribuyentes/predialunificado/basespresuntivas" + parametros;
				break;
			default:
				break;
		}
        
        if(targetUrl != ""){
			 currentUrl_tmp = currentUrl.replace(currentUrl_origen,targetUrl);
             newurl = currentUrl.replace(currentUrl_origen + "#",targetUrl);
        	 window.location.href =  newurl;
		}else{
    	    window.location.href =  currentUrl;
    	    alert("Hubo un error en la declaración");
        }
    },

	validarDeclaracion : function(url,placa){
		ACC.spinner.show();
	    var anioGravable = document.getElementById("anoGravable").value;
	    var impuesto = document.getElementById("impuesto");
	    impuesto = impuesto.options[impuesto.selectedIndex].value;
	    var currentUrl_tmp = "";

	    var currentUrl = window.location.href;
        var targetUrl = "infoObject/getUseOption?anioGravable="	+
               		    anioGravable + "&placa=" +
               		    placa + "&taxType=" + impuesto;

        currentUrl_tmp = currentUrl.replace("contribuyentes/presentar-declaracion",targetUrl);
        if(currentUrl_tmp != currentUrl){
        	currentUrl = currentUrl_tmp;
        }else{
        	currentUrl = currentUrl.replace("contribuyentes/presentar-declaracion#",targetUrl);
        }

        $.ajax({
            url : currentUrl,
            type : "GET",
            success : function(data) {
				ACC.spinner.close();
                if(data == "02"){
                    ACC.opcionDeclaraciones.promtConfirmation(url);
                }else{
                    window.location.href = url;
                }
           	},
            error : function() {
				ACC.spinner.close();
                alert("Error al verificar: opcionUso");
            }
        });
	},


	promtConfirmation : function(url){
        var r = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
        if (r == true) {
            window.location.href = url;
        } else {
            return false;
        }
    },

	habilitarFiltroPeriodo : function(infoActual,infoResponse) {


        var periodoM = $("#periodoM").val();
        var periodoB = $("#periodoB").val();
		var perMensual = document.getElementById('Periodo1'); //mensual
		var perBimestral = document.getElementById('Periodo2'); //bimestral
		var tipoPeriodo = "";

		if (infoResponse.errores != null && infoResponse.errores[0] != null && infoResponse.errores[0].idmsj != 0){

		}else{
			if(infoResponse.declaracionesCertiPagos.declaraciones != null){
				if(infoResponse.declaracionesCertiPagos.declaraciones.length > 0){

					if(infoActual.claveImpuesto == '0003'){
						$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index,value1){
							if(value1.numObjeto != ""){
								if(value1.numObjeto == infoResponse.customerData.ica.numObjeto){
									tipoPeriodo = ACC.opcionDeclaraciones.obtener_tipoPeriodo(value1.clavePeriodo);
									if(tipoPeriodo == 'B'){
										ACC.opcionDeclaraciones.establecerEstiloDisplay(perBimestral,'block');
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
        var claveImpuesto = $("#seleccion").val();
        var anoGravable = $("#aniograv").val();
        var periodoM = $("#periodoM").val();
        var periodoB = $("#periodoB").val();
		var perMensual = document.getElementById('Periodo1'); //mensual
		var perBimestral = document.getElementById('Periodo2'); //bimestral
		var validacionOK = false;

		if(claveImpuesto == "0001" || claveImpuesto == "0002" || claveImpuesto == "0006" || claveImpuesto == "0007" || claveImpuesto == "0008"){
			if(anoGravable != "" && anoGravable != "00"){
				validacionOK = true;
			}
		}else if( claveImpuesto == "0003" || claveImpuesto == "0004" ){
			if(anoGravable != "" && anoGravable != "00"){
				if(perBimestral != null && perBimestral.style.display == 'block'){
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
        var claveImpuesto = $("#seleccion").val();
		var validacionOK = false;

		if(claveImpuesto == "0003" || claveImpuesto == "0004" || claveImpuesto == "0005"){
			validacionOK = true;
		}

		return validacionOK;
	},


	validarAntesSubmit_presentarDec : function() {
        var claveImpuesto = $("#impuesto").val();
        var anoGravable = $("#anoGravable").val();
		var validacionOK = false;

		if(claveImpuesto == "2" || claveImpuesto == "1" || claveImpuesto == "6" ){ //vehicular, predial, delineacion urbana
			if(anoGravable != "" && anoGravable != "00"){
				validacionOK = true;
			}
		}

		return validacionOK;
	},


	validarFiltro : function (itemInfo,idPeriodoFiltro){
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
		var descripcion = "";
		var des_periodo = "";
		var des_anio = "";

		tipo_periodo = ACC.opcionDeclaraciones.obtener_tipoPeriodo(clavePeriodo);
		if(tipo_periodo == "B"){
			id_periodo = ACC.opcionDeclaraciones.obtener_valorPeriodo(clavePeriodo);

			des_periodoB.forEach(function (eachItem) {
    	    	if(eachItem.itemId == id_periodo)
    	    		des_periodo = eachItem.itemValue;
    		});
		}
		if(clavePeriodo != null){
			des_anio = clavePeriodo.substring(0,2);			
		}

		if(des_periodo == ""){
			descripcion = "20" + des_anio;
		} else{
			descripcion = "20" + des_anio + " periodo " + des_periodo;
		}


		return descripcion;
	},


	obtener_desc_consecutivo : function ( info_input ){
		var info_valor = "-";

		if(info_input!= null){
			reteIca_consecutivo = info_input;
		}

		return info_valor;
	},



	obtener_tipoPeriodo : function(clavePeriodo) {
		var clavePosfijo = "";
		
		if(clavePeriodo != null){
			clavePosfijo = clavePeriodo.substring(2,3);
		}

		return clavePosfijo;
	},


	obtener_valorPeriodo : function(clavePeriodo) {
		var clavePosfijo = "";
		
		if(clavePeriodo != null){
			clavePosfijo = clavePeriodo.substring(2,4);
		}

		return clavePosfijo;
	},



	ocultarTablas : function() {
		var x = document.getElementById('seleccion').value;

		ACC.opcionDeclaraciones.ocultarTablas_impuesto(x);


	},

	ocultarTablas_presentarDec : function() {
		var x = '000'+document.getElementById('impuesto').value;

		ACC.opcionDeclaraciones.ocultarTablas_impuesto(x);


	},

	ocultarTablas_impuesto : function(x) {

		var tablepredial = document.getElementById('table-predial');
		var tablevehicular = document.getElementById('table-vehicular');
		var tableica = document.getElementById('table-ica');
		var tablereteica = document.getElementById('table-reteica');
		var tablepublicidad = document.getElementById('table-publicidad');
		var tablegasolina = document.getElementById('table-gasolina');
		var cdus = document.getElementById('table-delineacion');

		ACC.opcionDeclaraciones.establecerEstiloDisplay(tablepredial,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tablevehicular,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tableica,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tablereteica,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tablegasolina,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(cdus,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tablepublicidad,'none');

		ACC.opcionDeclaraciones.vaciarTablasInfo();

		if (x == '0001') {  //predial
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tablepredial,'block');
		} else if (x == '0002') { //vehicular
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tablevehicular,'block');
		} else if (x == '0003') { //ica
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tableica,'block');
		} else if (x == '0004') { //reteica
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tablereteica,'block');
		} else if (x == '0005') { //gasolina
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tablegasolina,'block');
		} else if (x == '0006') { //delineacion
			ACC.opcionDeclaraciones.establecerEstiloDisplay(cdus,'block');
		} else if (x == '0007') { //publicidad
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tablepublicidad,'block');
		}


	},
	
	
	establecerEstiloDisplay : function(tabla,display) {
		if(tabla!=null){
			tabla.style.display = display;
		}
	},
	

	vaciarTablasInfo : function(){
		$("#table-vehicular1").find("tr:gt(0)").remove();
		$("#table-publicidad1").find("tr:gt(0)").remove();
		$("#table-gasolina1").find("tr:gt(0)").remove();
		$("#table-ica1").find("tr:gt(0)").remove();
		$("#table-reteica1").find("tr:gt(0)").remove();
		$("#table-delineacion1").find("tr:gt(0)").remove();
		$("#table-predial1").find("tr:gt(0)").remove();

	},


	ocultarPeriodo : function(periodo) {
		var periodoElemento = document.getElementById('Periodo'+periodo);
		ACC.opcionDeclaraciones.establecerEstiloDisplay(periodoElemento,'none');


	},


	mostrarPeriodo : function(periodo) {
		var periodoElemento = document.getElementById('Periodo'+periodo);
		ACC.opcionDeclaraciones.establecerEstiloDisplay(periodoElemento,'block');


	},


	reiniciaPeriodo : function(periodo){

		if(periodo == "0"){
			var perAnual = document.getElementById('aniograv');
			if(perAnual != null){
				perAnual.value = '00';
			}
		}else if(periodo == "1"){
			var perMensualValue = document.getElementById('periodoM');
			if(perMensualValue != null){
				perMensualValue.value = '00';
			}
		}else if(periodo == "2"){
			var perBimestralValue = document.getElementById('periodoB');
			if(perBimestralValue != null){
				perBimestralValue.value = '00';
			}
		}

	},

	reiniciaCertipagos : function(){

		ACC.opcionDeclaraciones.dataActual_backup = null;
		ACC.opcionDeclaraciones.dataResponse_backup = null;
		ACC.opcionDeclaraciones.reiniciaPeriodo("0");

		ACC.opcionDeclaraciones.ocultarPeriodo("1");
		ACC.opcionDeclaraciones.ocultarPeriodo("2");
		ACC.opcionDeclaraciones.reiniciaPeriodo("1");
		ACC.opcionDeclaraciones.reiniciaPeriodo("2");



	},


	reiniciaPeriodosMB : function(){
		ACC.opcionDeclaraciones.ocultarPeriodo("1");
		ACC.opcionDeclaraciones.ocultarPeriodo("2");
		ACC.opcionDeclaraciones.reiniciaPeriodo("1");
		ACC.opcionDeclaraciones.reiniciaPeriodo("2");

	},

	determinaPeriodoMBCertipagos : function(){

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

		ACC.opcionDeclaraciones.ocultarTablas_presentarDec();
		ACC.publicidadexterior.bindDataTable_Class_refresh();
		ACC.opcionDeclaraciones.vaciarTablasInfo_presentarDec();
		if(ACC.opcionDeclaraciones.validarAntesSubmit_presentarDec()){
			ACC.spinner.show();
			var anoGravable = $("#anoGravable").val();
			var dataActual = {};


			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anoGravable = anoGravable;


			$.ajax({
				url : ACC.presentarDecListaDeclaracionesURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					debugger;
					ACC.spinner.close();
					ACC.opcionDeclaraciones.updateFromResponseSeleccion_presentarDec(dataActual,dataResponse);
					ACC.publicidadexterior.bindDataTable_Class();
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud");	
				}
			});
		}
		
		
	},
	
	
	prepararImpuesto_presentarDec : function(claveImpuesto){
		ACC.opcionDeclaraciones.ocultarTablas_presentarDec();
		
		var ocultarPeriodo2 = false;
        var d = new Date();
		var anoGravableBase = d.getFullYear();
		var cantidadAnoGravable = ACC.opcionDeclaraciones.detCantidadAnoGravable(claveImpuesto,ACC.configCatalogos_ambito_presentarDeclaracion);
		
        
        var btnAction = document.getElementById('action');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(btnAction,'none');
        
		if(claveImpuesto == '2'){ //vehicular
			ocultarPeriodo2=true;
//	        cantidadAnoGravable = 7;
		}else if(claveImpuesto == '1'){ //predial
			ocultarPeriodo2=true;
//			anoGravableBase--;
//	        cantidadAnoGravable = 6;
		}else if(claveImpuesto == '6'){ //delineacion urbana
			ocultarPeriodo2=true;
//			anoGravableBase--;
//	        cantidadAnoGravable = 6;
		}
		
		if(ocultarPeriodo2==true){
	        var divPeriodo2 = document.getElementById('seccionPeriodo2');
			ACC.opcionDeclaraciones.establecerEstiloDisplay(divPeriodo2,'none');
		}
		
		if(anoGravableBase!=0 && cantidadAnoGravable != 0){
			ACC.opcionDeclaraciones.preparaCatAnioGravable_presentarDec(anoGravableBase,cantidadAnoGravable);
		}
		
	},
	
	
	predial_presentarDec : function(chip,anioGravable){
		ACC.spinner.show();
		if(ACC.opcionDeclaraciones.validarAntesSubmit_predial_presentarDec()){
			var dataActual = {};
		
			dataActual.chip = chip;
			dataActual.anioGravable = anioGravable;
			
			
			$.ajax({
				url : ACC.predial_presentarDecURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.spinner.close();
					ACC.opcionDeclaraciones.updateFromResponse_predial_presentarDec(dataActual,dataResponse);
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud presentar declaración");	
				}
			});
		}

		
	},
	
	
	updateFromResponse_predial_presentarDec : function(infoActual,infoResponse){
		var nombreTotalPagar_valor = "totalPagar_"+infoActual.chip;
		var nombrePagarEnLinea_boton = "btnPagarEnLinea_"+infoActual.chip;
		var lblTotalPagar_valor = document.getElementById(nombreTotalPagar_valor);
		var btnPagarEnLinea_boton = document.getElementById(nombrePagarEnLinea_boton);
		var idError = "";
		var mensajeError = "";
		var mensajes = "";
		
		
		lblTotalPagar_valor.hidden = false;
		btnPagarEnLinea_boton.hidden = false;
		lblTotalPagar_valor.innerHTML = infoResponse.total;
		
		$("#downloadHelper").attr("href",infoResponse.urlDownload);
		document.getElementById("downloadHelper").click();
		
		if(infoResponse.errores !=null){
			for(var i = 0; i<infoResponse.errores.length;i++){
				if(infoResponse.errores[i].id != null && infoResponse.errores[i].id != ""){
					idError = infoResponse.errores[i].id;
					mensajeError = infoResponse.errores[i].mensaje;
					mensajes = mensajes+"ID: "+idError+" MENSAJE: "+ mensajeError+"\n";
				}
			}
			if(mensajes!=""){
				alert(mensajes);
			}

		}
	},
	
	
	validarAntesSubmit_predial_presentarDec : function(){
		var validacionOK = true;
		
		return validacionOK;
	},
	
	
	preparaCatAnioGravable_presentarDec : function(anoGravableBase,cantidadAnos){
        
		$("#anoGravable").find("option:gt(0)").remove();
		for(var i=0;i<cantidadAnos;i++){
			$('#anoGravable').append('<option value="'+ anoGravableBase +'">'+ anoGravableBase + "</option>");
			anoGravableBase--;			
		}
		
	},
	
	
	preparaCatAnioGravable : function(anoGravableBase,cantidadAnos){
        
		$("#aniograv").find("option:gt(0)").remove();
		for(var i=0;i<cantidadAnos;i++){
			$('#aniograv').append('<option value="'+ anoGravableBase +'">'+ anoGravableBase + "</option>");
			anoGravableBase--;			
		}
		
	},
	
	
	preparaAnioGravable_presentarDec : function(claveImpuesto){

		var d = new Date();
		var anoGravableBase = d.getFullYear();
		var cantidadAnoGravable = ACC.opcionDeclaraciones.detCantidadAnoGravable(claveImpuesto,ACC.configCatalogos_ambito_presentarDeclaracion);
		
		$("#anoGravable").find("option:gt(0)").remove();
		if(claveImpuesto == '1' || claveImpuesto == '2'){ // predial vehicular 
			ACC.opcionDeclaraciones.preparaCatAnioGravable_presentarDec(anoGravableBase,cantidadAnoGravable);
		}else if(claveImpuesto == '6'){ // delineacion
			//anoGravableBase--;
			ACC.opcionDeclaraciones.preparaCatAnioGravable_presentarDec(anoGravableBase,cantidadAnoGravable);
		}else{
//			anoGravableBase--;
			ACC.opcionDeclaraciones.preparaCatAnioGravable_presentarDec(anoGravableBase,cantidadAnoGravable);
		}
		
	},
	
	
	vaciarTablasInfo_presentarDec : function(){
		$("#table-vehicular1").find("tr:gt(0)").remove();
		$("#table-predial1").find("tr:gt(0)").remove();
		$("#table-myTable").find("tr:gt(0)").remove();
		$("#table-delineacion1").find("tr:gt(0)").remove();
	},
	
	
	llamarPrepararPagoPSE : function(tipoImpuesto,numBP,numDoc,tipoDoc,anoGravable,periodo,clavePeriodo,dv,numObjeto,chip){
		
		$("#pagarEnLinea_tipoImpuesto").val(tipoImpuesto);
		$("#pagarEnLinea_numBP").val(numBP);
		$("#pagarEnLinea_numDoc").val(numDoc);
		$("#pagarEnLinea_tipoDoc").val(tipoDoc);		
		$("#pagarEnLinea_anoGravable").val(anoGravable);
		$("#pagarEnLinea_periodo").val(periodo);
		$("#pagarEnLinea_clavePeriodo").val(clavePeriodo);
		$("#pagarEnLinea_dv").val(dv);
		$("#pagarEnLinea_numObjeto").val(numObjeto);
		$("#pagarEnLinea_chip").val(chip);
		
		
		var form = document.getElementById("infoPreviaPSE");
		if(form!=null){
			form.submit();
		}
		
	},
	
	
	preparaAnioGravable : function(ambito){
		var claveImpuesto = document.getElementById('seleccion').value;
		if (claveImpuesto == null || claveImpuesto == "" ){
            claveImpuesto = document.getElementById('selCerDecImpAR').value;
        }    
		
		var d = new Date();
		var anoGravableBase = d.getFullYear();
		var cantidadAnoGravable = ACC.opcionDeclaraciones.detCantidadAnoGravable(claveImpuesto.substring(3,4),ambito);
		
		$("#aniograv").find("option:gt(0)").remove();
		if(claveImpuesto == '0001' || claveImpuesto == '0002'){ // predial vehicular 
			ACC.opcionDeclaraciones.preparaCatAnioGravable(anoGravableBase,cantidadAnoGravable);
		}else if(claveImpuesto == '0006'){ // delineacion
			//anoGravableBase--;
			ACC.opcionDeclaraciones.preparaCatAnioGravable(anoGravableBase,cantidadAnoGravable);
		}else{
//			anoGravableBase--;
			ACC.opcionDeclaraciones.preparaCatAnioGravable(anoGravableBase,cantidadAnoGravable);
		}
		
	},
	
	
	presentarDeclaracionGenerica(){
		ACC.spinner.show();
       var numForm  = $.trim($("#numForm").val());
	 	 
       var data = {};
       
       data.numForm=numForm;

      $.ajax({
            url: ACC.predial_presentarDecURL,
            data: data,
            type: "GET",
            success: function (data) {
				ACC.spinner.close();
            	$( "#dialogDeclaracion" ).dialog( "open" );
            	if(data.errores && ( data.errores[0].idmsj != 0 ))
        		{
            		$("#declaracionDialogContent").html("");
            		$.each(data.errores, function( index, value ) {
            			$("#declaracionDialogContent").html($("#declaracionDialogContent").html()+value.txtmsj+"<br>");
            		});
            		
            		
        		}else
        		{
        			$("#declaracionDialogContent").html("");
        			$("#declaracionDialogContent").html("La Declaración se ha presentado correctamente.")
					
        			
        			$("#downloadHelper").attr("href",data.urlDownload);
        			
        			document.getElementById("downloadHelper").click();
        			var botonPagar = document.getElementById("pagar");
        			if(botonPagar!=null){
        				document.getElementById("pagar").disabled = false;
        			}
        			$(".pagarbtn").attr("disabled", false);
        			
        		}
      		
            },
            error: function () {
				ACC.spinner.close();
            	$( "#dialogDeclaracion" ).dialog( "open" );
            	$("#declaracionDialogContent").html("Hubo un error al generar la declaración, por favor inténtalo más tarde");
            }
        });
	},
	
	bindDialogDeclaracionGenerica: function(){
    	
    	$( "#dialogDeclaracion" ).dialog({ 
    		autoOpen: false, 
    		modal: true,
			 draggable: false,
    		buttons: {
    			Ok: function() {
    				$( this ).dialog( "close" );
    			}
    	    } 
    	});
    	
    },
    
    
	verificarGenerarDec(infoRegistro,url){
		var obtenerURLGenDec = null;
		var flagVerificar = true;
		
		$.each(infoRegistro.errores, function (index,value){
			if(flagVerificar){
				switch (value.id_msj) {
				case "07":
				case "08":
					obtenerURLGenDec = value.txt_msj;
					flagVerificar = false;
					break;
	
				default:
					break;
				}
			}
		});
		
		if(obtenerURLGenDec == null){
			obtenerURLGenDec = '<a href="#" onclick="ACC.opcionDeclaraciones.validarDeclaracion(\''+url+'\',\''+infoRegistro.placa+'\');">Generar Declaracion</a>';
		}
		
		
		return obtenerURLGenDec;
	},
	
	
	detCantidadAnoGravable : function(claveImpuesto,ambito){
		var cantidadAnoGravable = 0;

        switch (ambito) {
			case ACC.configCatalogos_ambito_consultas:
		        switch (claveImpuesto) {
					case "1":		//predial
						cantidadAnoGravable = ACC.configCatalogos_cantidadAnios_Consultas_predial;
						break;
					case "2":		//vehiculos
						cantidadAnoGravable = ACC.configCatalogos_cantidadAnios_Consultas_vehiculos;
						break;
					case "3":		//ica
						cantidadAnoGravable = ACC.configCatalogos_cantidadAnios_Consultas_ica;
						break;
					case "5":		//gasolina
						cantidadAnoGravable = ACC.configCatalogos_cantidadAnios_Consultas_gasolina;
						break;
					case "6":		//delineacion
						cantidadAnoGravable = ACC.configCatalogos_cantidadAnios_Consultas_delineacion;
						break;
					case "7":		//publicidad
						cantidadAnoGravable = ACC.configCatalogos_cantidadAnios_Consultas_publicidad;
						break;
					default:
						cantidadAnoGravable = 0;
						break;
					}
				break;
			case ACC.configCatalogos_ambito_certiDeclaracion:
		        switch (claveImpuesto) {
					case "1":		//predial
					case "2":		//vehiculos
					case "3":		//ica
					case "4":		//ReteIca
					case "5":		//gasolina
					case "6":		//delineacion
					case "7":		//publicidad
						cantidadAnoGravable = ACC.configCatalogos_cantidadAnios_CertiDeclaracion;
						break;
					default:
						cantidadAnoGravable = 0;
						break;
					}
				break;
			case ACC.configCatalogos_ambito_reimpresionDeclaracion:
		        switch (claveImpuesto) {
					case "1":		//predial
					case "2":		//vehiculos
					case "3":		//ica
					case "4":		//ReteIca
					case "5":		//gasolina
					case "6":		//delineacion
					case "7":		//publicidad
						cantidadAnoGravable = ACC.configCatalogos_cantidadAnios_ReimpresionDeclaracion;
						break;
					default:
						cantidadAnoGravable = 0;
						break;
					}
				break;
			case ACC.configCatalogos_ambito_presentarDeclaracion:
		        switch (claveImpuesto) {
					case "1":		//predial
					case "2":		//vehiculos
					case "3":		//ica
					case "4":		//ReteIca
					case "5":		//gasolina
					case "6":		//delineacion
					case "7":		//publicidad
						cantidadAnoGravable = ACC.configCatalogos_cantidadAnios_PresentarDeclaracion;
						break;
					default:
						cantidadAnoGravable = 0;
						break;
				}
				break;
			default:
		        switch (claveImpuesto) {
				case "5":		//gasolina
				case "7":		//publicidad exterior
					cantidadAnoGravable = 2;
					break;
				case "6":		//delineacion
					cantidadAnoGravable = 7;
					break;
				default:
					cantidadAnoGravable = 5;
					break;
				}
		}	

        
        return cantidadAnoGravable;
	},
	
	detalleActo : function(){
		var urlDetalleActo = "/contribuyentes/detalleActo";
				var urlPrefijo = obtenerURLBase();
		 window.location.href =  urlPrefijo + urlDetalleActo;
	},
	
	
	validarPublicidadForm: function (anioGravable,numResolu,tipoVallaCode){
		ACC.spinner.show();
		var urlDeclaracion = "publicidadexterior/declaracion?numResolu="+numResolu+"&anoGravable="+anioGravable+"&tipoValla="+tipoVallaCode;

		var dataRequest = {};
		dataRequest.anoGravable = anioGravable;
		dataRequest.numResolu = numResolu;
		dataRequest.tipoValla = tipoVallaCode;
		
	    $.ajax({
			url : ACC.presentarDecValidacionPublicidadURL,
			type : "GET",
			data: dataRequest,
			success : function(dataResponse) {
				ACC.spinner.close();
				if(dataResponse != null){
					if(!ACC.opcionDeclaraciones.manejarError200_publicidad(dataResponse)){
						if(dataResponse.opcionUso != null && dataResponse.opcionUso.trim().startsWith("02")){
							var r = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
			    			if (r == true) {
			 					window.location.href = urlDeclaracion;
			    			}else{
								return false;
			    			}
						}else{
							window.location.href = urlDeclaracion;
			 			}
					}else{
						return false;
					}
				}else{
            		$("#dialogDeclaracion").dialog( "open" );
	    			$("#declaracionDialogContent").html("Error al consultar infoObjeto");
				}
			},
				error : function() {
					ACC.spinner.close();
            		$("#dialogDeclaracion").dialog( "open" );
	    			$("#declaracionDialogContent").html("Error al consultar infoObjeto");
			}
		});
	},
	
	
	manejarError200_publicidad: function(dataResponse){
		var flagError = false;

		if(dataResponse.errores != null){
			$.each(dataResponse.errores, function (index,value){
				if(value.idmsj == "200" && !flagError){
	            	$( "#dialogDeclaracion" ).dialog( "open" );
	    			$("#declaracionDialogContent").html(value.txtmsj);
					flagError = true;
				}
			});
		}
		
		
		return flagError;
	},
	
	
	prepararPeriodoMensual : function(){
		var meses = [
			'<option value="01">1-Enero</option>',
			'<option value="02">2-Febrero</option>',
			'<option value="03">3-Marzo</option>',
			'<option value="04">4-Abril</option>',
			'<option value="05">5-Mayo</option>',
			'<option value="06">6-Junio</option>',
			'<option value="07">7-Julio</option>',
			'<option value="08">8-Agosto</option>',
			'<option value="09">9-Septiembre</option>',
			'<option value="10">10-Octubre</option>',
			'<option value="11">11-Noviembre</option>',
			'<option value="12">12-Diciembre</option>'
			];
		var perMensual = document.getElementById("Periodo1"); //mensual
		var aniograv = $("#aniograv").val();
		var fechaActual = new Date();
		var mesActual = fechaActual.getMonth() +1;
		
		if(perMensual!=null && perMensual.style.display == "block"){
			$("#periodoM").find("option:gt(0)").remove();
			switch(aniograv){
				case "":
				case "00":
					break;
				case "2021":
					for(var i = 9; i<12; i++){
						$("#periodoM").append(meses[i]);
					}
					break;
				default:
					for(var i = 0; i<mesActual; i++){
						$("#periodoM").append(meses[i]);
					}
					break;
			}
		}
	}
	
	
};