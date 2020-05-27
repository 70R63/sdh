ACC.opcionDeclaraciones = {

	dataActual_backup:{},
	dataResponse_backup:{},
	
	_autoload : [ "bindDeclaracionPDF", "bindCertiPagosImprime", "bindDeclaracionImprime","bindDialogDeclaracionGenerica"],

	
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

		debugger;
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
					debugger;
//					ACC.opcionDeclaraciones.dataActual_backup = dataActual;
//					ACC.opcionDeclaraciones.dataResponse_backup = dataResponse;
					ACC.opcionDeclaraciones.mostrarErrores_certiPagos(dataResponse);
					ACC.opcionDeclaraciones.updateFromResponseSeleccion_certiPagos(dataActual,dataResponse,null);					
					ACC.publicidadexterior.bindDataTable_Class();
//					ACC.opcionDeclaraciones.habilitarFiltroPeriodo(dataActual,dataResponse);
				},
				error : function() {
					alert("Error procesar la solicitud");	
				}
			});
		}
		
		
	},
	
	
	obtenerListaDeclaraciones : function() {

		debugger;
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
				url : ACC.listaDeclaracionesURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					debugger;
					ACC.opcionDeclaraciones.updateFromResponseSeleccion(dataActual,dataResponse);
					ACC.publicidadexterior.bindDataTable_Class();
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
	        var anoGravable = $("aniograv").val();  	       
			var dataActual = {};
		
			dataActual.claveImpuesto = claveImpuesto;
			dataActual.anoGravable = anoGravable;
			
			
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
	
	obtenerListaDeclaraciones_porAnio : function() {

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
					ACC.opcionDeclaraciones.updateFromResponsePeriodo_porAnio(dataActual,dataResponse);
					ACC.opcionDeclaraciones.obtenerListaDeclaraciones();
				},
				error : function() {
					alert("Error procesar la solicitud obtener tipo de periodo");	
				}
			});
		}else{
			ACC.opcionDeclaraciones.obtenerListaDeclaraciones();
		}
		
		
	},
	
	obtenerListaDeclaraciones_certiPagos_porAnio : function() {

		debugger;
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
					debugger;
					ACC.opcionDeclaraciones.updateFromResponsePeriodo_porAnio(dataActual,dataResponse);
					ACC.opcionDeclaraciones.obtenerListaDeclaraciones_certiPagos();
				},
				error : function() {
					alert("Error procesar la solicitud obtener tipo de periodo");	
				}
			});
		}else{
			ACC.opcionDeclaraciones.obtenerListaDeclaraciones_certiPagos();
		}
		
	},
	
	
	updateFromResponsePeriodo_porAnio : function(infoActual,infoResponse) {

		debugger;
		var perMensual = document.getElementById('Periodo1'); //mensual
		var perBimestral = document.getElementById('Periodo2'); //bimestral
		var perMensualValue = document.getElementById('periodoM'); 
		var perBimestralValue = document.getElementById('periodoB'); 
		
		perMensualValue.value = '00';
		perBimestralValue.value = '00';
		
		perMensual.style.display = 'none';
		perBimestral.style.display = 'none';
		if (infoResponse.tipoPeriodoDec == '1') {
			perMensual.style.display = 'block';
		} else if (infoResponse.tipoPeriodoDec == '2') {
			perBimestral.style.display = 'block';
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

			if(infoActual.claveImpuesto == '0001'){
				if(infoResponse.predial.length > 0){
					$.each(infoResponse.predial, function (index,value){
						$('#table-predial1').append("<tr>"+
								'<td>' + value.chip + '</td>'+
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
		var reteIca_consecutivo = "";
		var indiceTabla = 0;

debugger;
		if(infoResponse.declaracionesCertiPagos.declaraciones != null){
			if(infoResponse.declaracionesCertiPagos.declaraciones.length > 0){

				if(infoActual.claveImpuesto == '0001'){
					indiceTabla = 0;
					$.each(infoResponse.declaracionesCertiPagos.declaraciones, function (index1,value1){
						if(value1.numObjeto != ""){
							$.each(infoResponse.customerData.predial, function (index2,value2){
								if( value1.numObjeto.replace(/^0+/, '').trim() == value2.numObjeto.replace(/^0+/, '').trim() ){
									desc_clavePeriodo = ACC.opcionDeclaraciones.obtener_desc_clavePeriodo(value1.clavePeriodo);
									$('#table-predial1').append("<tr>"+
											'<td>' + value2.chip + '</td>'+
											'<td>' + value2.matrInmobiliaria + '</td>'+
											'<td>' + value2.direccionPredio + '</td>'+
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
									$('#table-vehicular1').append("<tr>"+
											'<td>' + value2.placa + '</td>'+
											'<td>' + value2.marca + '</td>'+
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
									'<td><a href="#" onclick="ACC.opcionDeclaraciones.validarDeclaracion(\''+url+'\',\''+value.placa+'\');">Generar Declaracion</a> </td>'+
									//'<td><a href="' + url + '">Presentar Declaracion</a> </td>'+
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
					nombrePresentarDec = "btnPresentarDec_"+value.chip;
					nombrePagarEnLinea = "btnPagarEnLinea_"+value.chip;
					nombreTotalPagar = "totalPagar_"+value.chip;
					var strChip = "'"+value.chip+"'";
					var strAnioGravable = "'"+value.anioGravable+"'";
					var strPeriodo = "''";
					var strNumObjeto = "'"+value.numObjeto+"'";



					$('#table-predial1').append("<tr>"+
							'<td>' + value.chip + '</td>'+
							'<td>' + value.matrInmobiliaria + '</td>'+
							'<td>' + value.direccionPredio + '</td>'+
							'<td>' + value.contratoArrenda + '</td>'+
//							'<td>' + '<button type="button" id="' + nombrePresentarDec +
//							'" name="'+ nombrePresentarDec+ '" value="presentarDec" class="btn-primary"'+
//							' onclick="presentarDeclaracion('+strChip+','+strAnioGravable+')">' +
//							'Presentar declaración</button>' + '</td>'+
//							'<td><label class="text-capitalize !important " id="'+nombreTotalPagar+'" hidden="true"></label></td>'+
//							'<td><button type="button" id="'+nombrePagarEnLinea+'"'+
//							'name="${nombrePagarEnLinea}" value="pagarEnLinea" class="btn-primary" hidden="true"'+
//							'onclick="pagarEnLinea('+strClaveImpuesto+','+strAnioGravable+','+strPeriodo+','+strNumObjeto+','+strChip+')">'+
//							'Pagar en linea</button>' + '</td>'+

							'<td><a href="#" onclick="ACC.opcionDeclaraciones.validarDeclaracionPredial(\''+value.chip+'\',\''+value.matrInmobiliaria+'\');">Generar Declaracion</a> </td>'+
							"</tr>");
				});

			}
		}

		if(flagHuboRegistros == true){
	        var btnAction = document.getElementById('action');
	        btnAction.style.display = 'block';
		}


	},

	validarDeclaracionPredial : function(chip,matricula){
	    var anioGravable = document.getElementById("anoGravable").value;

	    var data = {};

	    data.anioGravable = anioGravable;
		data.CHIP = chip;
		data.matrInmobiliaria = matricula;


        $.ajax({
            url : ACC.declaracionPredialURL,
            data : data,
            type : "GET",
            success : function(data) {
            	debugger;
				ACC.predial.establecerMensajeInfoObjeto(ACC.predial.leerMensajesInfoObjeto(data));
            	if(ACC.predial.mostrarMensajeInfoObjeto()){
            		return false;
            	}
            	//var currentUrl_tmp = "";
            	//var newurl = "";
        	    //var currentUrl = window.location.href;
                //alert(data.opcionuso);
                if(data.opcionuso == "02"){
                    var r = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
                    if (r == true) {
                        ACC.opcionDeclaraciones.redirectRequestPredial(data.url, data.anioGravable, data.chip, data.matrInmobiliaria, data.numBP);
                    } else {
                        window.location.href =  currentUrl;
                    }
                }else{
                    ACC.opcionDeclaraciones.redirectRequestPredial(data.url, data.anioGravable, data.chip, data.matrInmobiliaria, data.numBP);
                }
           	},
            error : function() {
                alert("Error");
            }
        });
	},

	redirectRequestPredial : function(url, anioGravable, chip, inmobiliatia, numBp){
		debugger;
	    var currentUrl_tmp = "";
        var newurl = "";
        var currentUrl = window.location.href;
				if(url == "1"){
                	 var targetUrl = "/contribuyentes/predialunificado_1?anioGravable=" + anioGravable + "&chip=" + chip + "&matricula=" +inmobiliatia +"&numBP=" +numBp;
                	 currentUrl_tmp = currentUrl.replace("/contribuyentes/presentar-declaracion",targetUrl);
                     newurl = currentUrl.replace("/contribuyentes/presentar-declaracion#",targetUrl);
                	 window.location.href =  newurl;
                } else if(url == "2"){
               	    var targetUrl = "/contribuyentes/predialunificado_2?anioGravable=" + anioGravable + "&chip=" + chip + "&matricula=" +inmobiliatia +"&numBP=" +numBp;
            	    currentUrl_tmp = currentUrl.replace("/contribuyentes/presentar-declaracion",targetUrl);
                    newurl = currentUrl.replace("/contribuyentes/presentar-declaracion#",targetUrl);
            	    window.location.href =  newurl;
                } else if(url == "3"){
               	    var targetUrl = "/contribuyentes/predialunificado_3?anioGravable=" + anioGravable + "&chip=" + chip + "&matricula=" +inmobiliatia +"&numBP=" +numBp;
            	    currentUrl_tmp = currentUrl.replace("/contribuyentes/presentar-declaracion",targetUrl);
                    newurl = currentUrl.replace("/contribuyentes/presentar-declaracion#",targetUrl);
            	    window.location.href =  newurl;
                } else if(url == "4"){
              	    var targetUrl = "/contribuyentes/predialunificado_4?anioGravable=" + anioGravable + "&chip=" + chip + "&matricula=" +inmobiliatia +"&numBP=" +numBp;
           	        currentUrl_tmp = currentUrl.replace("/contribuyentes/presentar-declaracion",targetUrl);
                    newurl = currentUrl.replace("/contribuyentes/presentar-declaracion#",targetUrl);
           	        window.location.href =  newurl;
                } else if(url == "5"){
              	    var targetUrl = "/contribuyentes/predialunificado_5?anioGravable=" + anioGravable + "&chip=" + chip + "&matricula=" +inmobiliatia +"&numBP=" +numBp;
           	        currentUrl_tmp = currentUrl.replace("/contribuyentes/presentar-declaracion",targetUrl);
                    newurl = currentUrl.replace("/contribuyentes/presentar-declaracion#",targetUrl);
           	        window.location.href =  newurl;
                } else if(url == "6"){
              	    var targetUrl = "/contribuyentes/predialunificado_6?anioGravable=" + anioGravable + "&chip=" + chip + "&matricula=" +inmobiliatia +"&numBP=" +numBp;
           	        currentUrl_tmp = currentUrl.replace("/contribuyentes/presentar-declaracion",targetUrl);
                    newurl = currentUrl.replace("/contribuyentes/presentar-declaracion#",targetUrl);
           	        window.location.href =  newurl;
                } else if(url == "7"){
              	    var targetUrl = "/contribuyentes/predialunificado_7?anioGravable=" + anioGravable + "&chip=" + chip + "&matricula=" +inmobiliatia +"&numBP=" +numBp;
           	        currentUrl_tmp = currentUrl.replace("/contribuyentes/presentar-declaracion",targetUrl);
                    newurl = currentUrl.replace("/contribuyentes/presentar-declaracion#",targetUrl);
           	        window.location.href =  newurl;
                } else if(url == "8"){
              	    var targetUrl = "/contribuyentes/predialunificado_8?anioGravable=" + anioGravable + "&chip=" + chip + "&matricula=" +inmobiliatia +"&numBP=" +numBp;
           	        currentUrl_tmp = currentUrl.replace("/contribuyentes/presentar-declaracion",targetUrl);
                    newurl = currentUrl.replace("/contribuyentes/presentar-declaracion#",targetUrl);
           	        window.location.href =  newurl;
                } else if(url == "9"){
              	    var targetUrl = "/contribuyentes/predialunificado/basespresuntivas?anioGravable=" + anioGravable + "&chip=" + chip + "&matricula=" +inmobiliatia +"&numBP=" +numBp;
           	        currentUrl_tmp = currentUrl.replace("/contribuyentes/presentar-declaracion",targetUrl);
                    newurl = currentUrl.replace("/contribuyentes/presentar-declaracion#",targetUrl);
           	        window.location.href =  newurl;
                } else{
            	    window.location.href =  currentUrl;
            	    alert("Hubo un error en la declaración");
                }
    },

	validarDeclaracion : function(url,placa){
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
                if(data == "02"){
                    ACC.opcionDeclaraciones.promtConfirmation(url);
                }else{
                    window.location.href = url;
                }
           	},
            error : function() {
                alert("Error");
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

		if(claveImpuesto == "0001" || claveImpuesto == "0002" || claveImpuesto == "0006" || claveImpuesto == "0007" || claveImpuesto == "0008"){
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

		if(claveImpuesto == "2" || claveImpuesto == "1" ){
			if(anoGravable != "" && anoGravable != "00"){
				validacionOK = true;
			}
		}

		return validacionOK;
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


	obtener_desc_consecutivo : function ( info_input ){
		var info_valor = "-";

		if(info_input!= null){
			reteIca_consecutivo = info_input;
		}

		return info_valor;
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

		ACC.opcionDeclaraciones.ocultarTablas_impuesto(x);


	},

	ocultarTablas_presentarDec : function() {

		debugger;
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


		if(tablepredial!=null){
			tablepredial.style.display = 'none';
		}
		if(tablevehicular!=null){
			tablevehicular.style.display = 'none';
		}
		if(tableica!=null){
			tableica.style.display = 'none';
		}
		if(tablereteica!=null){
			tablereteica.style.display = 'none';
		}
		if(tablegasolina!=null){
			tablegasolina.style.display = 'none';
		}
		if(cdus!=null){
			cdus.style.display = 'none';
		}
		if(tablepublicidad!=null){
			tablepublicidad.style.display = 'none';
		}

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
		debugger;
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
		ACC.opcionDeclaraciones.ocultarTablas_presentarDec();
		ACC.publicidadexterior.bindDataTable_Class_refresh();
		ACC.opcionDeclaraciones.vaciarTablasInfo_presentarDec();
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
					ACC.publicidadexterior.bindDataTable_Class();
				},
				error : function() {
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
		var cantidadAnoGravable = 0;
		
		debugger;
        
        var btnAction = document.getElementById('action');
        if(btnAction!=null){
        	btnAction.style.display = 'none';
        }
        
		if(claveImpuesto == '2'){ //vehicular
			ocultarPeriodo2=true;
	        cantidadAnoGravable = 7;
		}else if(claveImpuesto == '1'){ //predial
			ocultarPeriodo2=true;
			anoGravableBase--;
	        cantidadAnoGravable = 6;
		}
		
		if(ocultarPeriodo2==true){
	        var divPeriodo2 = document.getElementById('seccionPeriodo2');
	        if(divPeriodo2!=null){
	        	divPeriodo2.style.display = 'none';
	        }
		}
		
		if(anoGravableBase!=0 && cantidadAnoGravable != 0){
			ACC.opcionDeclaraciones.preparaCatAnioGravable_presentarDec(anoGravableBase,cantidadAnoGravable);
		}
		
	},
	
	
	predial_presentarDec : function(chip,anioGravable){

		debugger;
		if(ACC.opcionDeclaraciones.validarAntesSubmit_predial_presentarDec()){
			var dataActual = {};
		
			dataActual.chip = chip;
			dataActual.anioGravable = anioGravable;
			
			
			$.ajax({
				url : ACC.predial_presentarDecURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.opcionDeclaraciones.updateFromResponse_predial_presentarDec(dataActual,dataResponse);
				},
				error : function() {
					alert("Error procesar la solicitud presentar declaración");	
				}
			});
		}

		
	},
	
	
	updateFromResponse_predial_presentarDec : function(infoActual,infoResponse){
		debugger;
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
		
		$("#anoGravable").find("option:gt(0)").remove();
		if(claveImpuesto == '1' || claveImpuesto == '2'){ // predial vehicular 
			ACC.opcionDeclaraciones.preparaCatAnioGravable_presentarDec(anoGravableBase,7);
		}else if(claveImpuesto == '6'){ // delineacion
			//anoGravableBase--;
			ACC.opcionDeclaraciones.preparaCatAnioGravable_presentarDec(anoGravableBase,7);
		}else{
			anoGravableBase--;
			ACC.opcionDeclaraciones.preparaCatAnioGravable_presentarDec(anoGravableBase,6);
		}
		
	},
	
	
	vaciarTablasInfo_presentarDec : function(){
		$("#table-vehicular1").find("tr:gt(0)").remove();
		$("#table-predial1").find("tr:gt(0)").remove();
		$("#table-myTable").find("tr:gt(0)").remove();
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
	
	
	preparaAnioGravable : function(){
		var claveImpuesto = document.getElementById('seleccion').value;
		var d = new Date();
		var anoGravableBase = d.getFullYear();
		
		$("#aniograv").find("option:gt(0)").remove();
		if(claveImpuesto == '0001' || claveImpuesto == '0002'){ // predial vehicular 
			ACC.opcionDeclaraciones.preparaCatAnioGravable(anoGravableBase,7);
		}else if(claveImpuesto == '0006'){ // delineacion
			//anoGravableBase--;
			ACC.opcionDeclaraciones.preparaCatAnioGravable(anoGravableBase,7);
		}else{
			anoGravableBase--;
			ACC.opcionDeclaraciones.preparaCatAnioGravable(anoGravableBase,6);
		}
		
	},
	
	
	presentarDeclaracionGenerica(){
       var numForm  = $.trim($("#numForm").val());
	 	 
       var data = {};
       
       data.numForm=numForm;

      $.ajax({
            url: ACC.predial_presentarDecURL,
            data: data,
            type: "GET",
            success: function (data) {
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
	
	
};