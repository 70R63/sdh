ACC.facturacion = {

	_autoload : ["bindBuscar","bindPagarFacturaBtn","bindPagarFacturaVABtn"],

	
	bindBuscar : function(){
		$(document).on("click", ".facBuscar", function(){

			var impuesto = document.getElementById('impuesto').value;
			var anoGravable = document.getElementById('aniograv').value;
			ACC.opcionDeclaraciones.establecerEstiloDisplay(document.getElementById('oblipend-predial'),'none');
			ACC.opcionDeclaraciones.establecerEstiloDisplay(document.getElementById('oblipend-vehiculos'),'none');


			switch(impuesto){
			case "0001":
			case "0002":
				ACC.facturacion.buscarRegistrosImpuesto(impuesto, anoGravable);
				break;
				
			default:
			
				break;
			}
			
		});
	},
	
	
	buscarRegistrosImpuesto : function(impuesto,anoGravable){
		
		
		if(ACC.facturacion.validarAntesSubmitWSBuscarReg(impuesto,anoGravable)){
			ACC.spinner.show();
			var dataActual = {};	
			
			dataActual.claveImpuesto = impuesto;
			$.ajax({
				url : ACC.descargaFacturaBuscarURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.spinner.close();
					ACC.facturacion.manejarRespuestaWSBuscarReg(dataActual,dataResponse);
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud de busqueda de registros");	
				}
			});
		}
			
	},
	
	
	manejarRespuestaWSBuscarReg : function(dataActual,infoResponse){
		
		switch(dataActual.claveImpuesto){
			case "0001":
				ACC.facturacion.updateResponse_predial(dataActual,infoResponse);
				break;
			case "0002":
				ACC.facturacion.updateResponse_vehiculos(dataActual,infoResponse);
				break;
			
			default:
				break;
		}
		
		
	},
	
	
	updateResponse_vehiculos : function(dataActual,infoResponse){
		var id_tabla = "#tabla_vehi";
		var tablaInfo = infoResponse.vehicular;
		
		if(tablaInfo == null){
			alert("No se encontraron registros");
		}else{
			ACC.publicidadexterior.bindDataTable_ID_refresh(id_tabla);
			$(id_tabla).find("tr:gt(0)").remove();
			$.each(tablaInfo, function (indexH,valueH){
				var tr_value = "";
				
				if(valueH != null && ((valueH.anioGravable != null && valueH.anioGravable != "" ) &&
					((valueH.placa != null && valueH.placa != "") || (valueH.marca != null && valueH.marca != "")))){
					var infoAdicional = {};
					infoAdicional.claveImpuesto = "0002";
					infoAdicional.nombreObjeto = "objetoVehicular";
					
					var td_placa = ACC.facturacion.obtenerValorTD_simple(valueH.placa);
					var td_marca = ACC.facturacion.obtenerValorTD_simple(valueH.marca);
					var td_imagenDescarga = ACC.facturacion.obtenerValorTD_imagenDescarga(valueH,infoAdicional);
					var td_actualizar = ACC.facturacion.obtenerValorTD_actualizar(valueH,infoAdicional);
					var td_obtenerDescuento = ACC.facturacion.obtenerValorTD_obtenerDescuento(valueH,infoAdicional);
					var td_pagar = ACC.facturacion.obtenerValorTD_pagar(valueH,infoAdicional);
					var td_checkbox = ACC.facturacion.obtenerValorTD_checkbox(valueH);
					
					tr_value = 
						"<tr>" +
						"<td>" + td_placa +"</td>"+
						'<td class="td_marca">' + td_marca +"</td>"+
						"<td>" + td_imagenDescarga +"</td>"+
						"<td>" + td_actualizar +"</td>"+
						"<td>" + td_obtenerDescuento +"</td>"+
						"<td>" + td_pagar +"</td>"+
						"<td>" + td_checkbox +"</td>"+
						"</tr>";
					$(id_tabla).append(tr_value);
				}
			});
			ACC.vehiculos.cargarDescripciones();
			ACC.oblipend.mostrarTablaDelImpuesto(dataActual.claveImpuesto);
		}
		
	},
	
	
	updateResponse_predial : function(dataActual,infoResponse){
		var id_tabla = "#table-predial1";
		var tablaInfo = infoResponse.predial;
		
		if(tablaInfo == null){
			alert("No se encontraron registros");
		}else{
			ACC.publicidadexterior.bindDataTable_ID_refresh(id_tabla);
			$(id_tabla).find("tr:gt(0)").remove();
			$.each(tablaInfo, function (indexH,valueH){
				var tr_value = "";
				
				if(valueH != null && ((valueH.matrInmobiliaria != null && valueH.matrInmobiliaria != "" ) 
				|| (valueH.CHIP != null && valueH.CHIP != "")) && 
				((valueH.anioGravable != null && valueH.anioGravable != "" ) ||
				(valueH.direccionPredio != null && valueH.direccionPredio != ""))){
					var infoAdicional = {};
					infoAdicional.claveImpuesto = "0001";
					infoAdicional.nombreObjeto = "objetoPredial";
					var td_chip = ACC.facturacion.obtenerValorTD_simple(valueH.CHIP);
					var td_matrInmobiliaria = ACC.facturacion.obtenerValorTD_simple(valueH.matrInmobiliaria);
					var td_direccionPredio = ACC.facturacion.obtenerValorTD_simple(valueH.direccionPredio);
					var td_imagenDescarga = ACC.facturacion.obtenerValorTD_imagenDescarga(valueH,infoAdicional);
					var td_actualizar = ACC.facturacion.obtenerValorTD_actualizar(valueH,infoAdicional);
					var td_obtenerDescuento = ACC.facturacion.obtenerValorTD_obtenerDescuento(valueH,infoAdicional);
					var td_pagar = ACC.facturacion.obtenerValorTD_pagar(valueH,infoAdicional);
					var td_checkbox = ACC.facturacion.obtenerValorTD_checkbox(valueH);
					
					tr_value = 
						"<tr>" +
						"<td>" + td_chip +"</td>"+
						"<td>" + td_matrInmobiliaria +"</td>"+
						"<td>" + td_direccionPredio +"</td>"+
						"<td>" + td_imagenDescarga +"</td>"+
						"<td>" + td_actualizar +"</td>"+
						"<td>" + td_obtenerDescuento +"</td>"+
						"<td>" + td_pagar +"</td>"+
						"<td>" + td_checkbox +"</td>"+
						"</tr>";
					$(id_tabla).append(tr_value);
				}
			});
			ACC.publicidadexterior.bindDataTable_id(id_tabla);
			ACC.oblipend.mostrarTablaDelImpuesto(dataActual.claveImpuesto);
		}
		
	},
	
	
	obtenerValorTD_checkbox : function(registro){
		var valorRetorno = "";
		
		if(registro != null){
			valorRetorno = '<div class="checkbox" role="checkbox" aria-checked="false" id="buzon2" style=" cursor: not-allowed;" ' +
						'data-numobjeto="' + registro.numObjeto + '" >' +
						'<label tabindex="0" class="control-label" id="checkBeEneficio"><input id="checkBeEneficio" name="checkBeEneficio" type="checkbox" value="true"></label></div>';
		}
		
		return valorRetorno;
		
	},
	
	
	obtenerValorTD_pagar : function(registro, infoAdicional){
		var valorRetorno = "";
		
		if(registro != null){
			valorRetorno = '<button class="renglonBeneficios" id="pagarFacturaBtn" type="button" ' +
						'data-impuesto="' + infoAdicional.claveImpuesto + '" ' +
						'data-anioGravable="' + registro.anioGravable + '" ' +
						'data-numObjeto="' + registro.numObjeto + '" ' +
						'>Pagar</button>';
		}
		
		return valorRetorno;
		
	},
	
	
	obtenerValorTD_obtenerDescuento : function(registro, infoAdicional){
		var valorRetorno = "";
		
		if(registro != null){
			valorRetorno = '<label class="control-label renglonBeneficios"'+
						'style="text-transform: capitalize !importan;color: #2196f3; text-decoration: underline !important; font-size: 13px;t"'+
						'id="obtainBenef" '+
						'data-claveImpuesto="' + infoAdicional.claveImpuesto + '" ' +
						'data-nombreObjeto="' + infoAdicional.nombreObjeto +'" ' + 
						'data-anioGrav="' + ACC.facturacion.obtenerValorTD_simple(registro.anioGravable) + '" ' +
						'data-numobjeto="' + ACC.facturacion.obtenerValorTD_simple(registro.numObjeto) + '" ' +
						'onclick="obtainBene(this)"> <span class="">Obtener Descuento</span></label>';
		}
		
		return valorRetorno;
		
	},
	
	
	obtenerValorTD_actualizar : function(registro, infoAdicional){
		var valorRetorno = "";
		
		if(registro != null){
			valorRetorno = '<label class="control-label renglonBeneficios"'+
						'style="text-transform: capitalize !importan;color: #2196f3; text-decoration: underline !important; font-size: 13px;t"'+
						'id="downloadFac" '+
						'data-claveImpuesto="' + infoAdicional.claveImpuesto + '" ' +
						'data-nombreObjeto="' + infoAdicional.nombreObjeto +'" ' + 
						'data-anioGrav="' + ACC.facturacion.obtenerValorTD_simple(registro.anioGravable) + '" ' +
						'data-numobjeto="' + ACC.facturacion.obtenerValorTD_simple(registro.numObjeto) + '" ' +
						'onclick="reexpedicion(this)"> <span class="">Actualizar</span></label>';
		}
		
		return valorRetorno;
		
	},
	
	
	obtenerValorTD_imagenDescarga : function(registro, infoAdicional){
		var valorRetorno = "";
		
		if(registro != null){
			valorRetorno = '<img id="imgDescarga" class="renglonBeneficios" src="' + ACC.themeResourcePath + 
						'/images/download_icon.png" onclick="descargaFactura(this)"' + 
						'data-claveImpuesto="' + infoAdicional.claveImpuesto + '" ' +
						'data-nombreObjeto="' + infoAdicional.nombreObjeto +'" ' + 
						'data-anioGrav="' + ACC.facturacion.obtenerValorTD_simple(registro.anioGravable) + '" ' +
						'data-numobjeto="' + ACC.facturacion.obtenerValorTD_simple(registro.numObjeto) + '" ' + 
						'></img>';
		}
		
		return valorRetorno;
		
	},
	
	
	obtenerValorTD_simple : function(campo){
		var valorRetorno = "";
		
		if(campo != null){
			valorRetorno = campo;
		}
		
		return valorRetorno;
		
	},
	
	
	validarAntesSubmitWSBuscarReg : function(impuesto, anoGravable){
		var validacionOK = false;
		
		if(impuesto != "" && impuesto != "00" && anoGravable != ""){
			validacionOK = true;
		}
		
		return validacionOK;
	},
	
	
	filtrarRegistros_aniograv : function(nombreTabla,indiceFiltro,aniogravFiltro){
		
		$("#"+nombreTabla+" tbody tr").each(function(index){
			var borrar = false;
			
			$(this).find('td:eq('+indiceFiltro+')').each(function (index){
				var valor = $(this).html();
				if(valor != aniogravFiltro && valor != "No se encontraron registros"){
					borrar = true;
				}
			});
			if(borrar == true){
				$(this).hide();
			}else{
				$(this).show();
			}
		}
		);
		
	},
	
	establecerCat_aniograv : function(){
		var aniograv = new Date().getFullYear();
		
		$("#aniograv").empty();
		$("#aniograv").append('<option value="">Seleccionar</option>');
		$("#aniograv").append('<option value="'+ aniograv + '">'+ aniograv + '</option>');
		
	},
	
	
	descargaFactura : function (anoGravable,numObjeto,tipoOperacion,descargaFactura1){
		ACC.spinner.show();
		if(descargaFactura1 != undefined && descargaFactura1 != null){
			var objnew = descargaFactura1;
			
//			anoGravable = $.trim($(objnew).attr("data-anioGrav"));
			numObjeto = $.trim($(objnew).attr("data-numObjeto"));
		}
			
		if(ACC.facturacion.validarAntesSubmit(anoGravable,numObjeto)){
			var dataActual = {};	
		
			
			dataActual.anoGravable = anoGravable;
			dataActual.numObjeto = numObjeto;
			dataActual.tipoOperacion = tipoOperacion;
			
			
			$.ajax({
				url : ACC.descargaFacturaURL,
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
	 
	 
	 manejarRespuesta : function (dataResponse){
		var descargarFactura = false;
		var strMensajeError = "";
		if(dataResponse != null && dataResponse.errores != null ){
    		$.each(dataResponse.errores, function( index, value ) {
    			if(value != null && value.txt_msj != null && value.txt_msj.trim() != ""){
    				strMensajeError = strMensajeError + value.txt_msj+"<br>";
    			} else if(value != null && value.txtmsj != null && value.txtmsj.trim() != ""){
					strMensajeError = strMensajeError + value.txtmsj+"<br>";
				}
    		});
		}
		
		if(strMensajeError != ""){
			$("#dialogMensajes" ).dialog( "open" );
			$("#dialogMensajesContent").html(strMensajeError);
		}else{
			if(dataResponse.urlDownload!=null && dataResponse.urlDownload != ""){
    			$("#downloadHelper").attr("href",dataResponse.urlDownload);
    			
    			document.getElementById("downloadHelper").click();
			}
		}
	 },


	refreshTablas : function(){
		ACC.opcionDeclaraciones.establecerEstiloDisplay(document.getElementById('oblipend-predial'),'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(document.getElementById('oblipend-vehiculos'),'none');

	},
	 
	 
	 validarAntesSubmit : function (anoGravable,numObjeto){
		 var flagValidacion = false;
		 
		 if(anoGravable!= null && numObjeto != null){
			 flagValidacion = true;
		 }
		 return flagValidacion;
	 },

	copieied: function(text) {

	 $("#asmCopyHoldtext").val(text);
    $("#asmCopyHoldtext").show();
    $("#asmCopyHoldtext").select();
    try {
        return document.execCommand("copy");
    } catch (ex) {
        console.debug("Copy to clipboard failed.", ex);
        return false;
    } finally {
        $("#asmCopyHoldtext").hide();
    }

		

	},
	
	
	bindPagarFacturaBtn : function(){
		$(document).on("click", "#pagarFacturaBtn", function(e) {
			e.preventDefault();
			
			var impuesto = $(this).data("impuesto");
			var numbp = $(this).data("numbp");
			var numObjeto = $(this).data("numobjeto");
			var anioGravable = $(this).data("aniogravable");
			
			if(ACC.facturacion.validarAntesSubmitWSPagar(impuesto,anioGravable,numObjeto)){
				ACC.spinner.show();
				var dataActual = {};	
				
				dataActual.impuesto = impuesto;
				dataActual.numbp = numbp;
				dataActual.numObjeto = numObjeto;
				dataActual.anioGravable = anioGravable;
				$.ajax({
					url : ACC.facturacionPagosURL,
					data : dataActual,
					type : "GET",
					success : function(dataResponse) {
						ACC.spinner.close();
						ACC.facturacion.manejarRespuestaWSPagar(dataActual,dataResponse);
					},
					error : function() {
						ACC.spinner.close();
						alert("Error procesar la solicitud de proceso de pago");	
					}
				});
			}
			
			
		});
		
		
	},
	
	
	bindPagarFacturaVABtn : function(){
		$(document).on("click", "#pagarFacturaVABtn", function(e) {
			e.preventDefault();
			
			var impuesto = $("#pagarFacturaVABtn").attr("data-impuesto");
			var numbp = $("#pagarFacturaVABtn").attr("data-numbp");
			var numObjeto =  $("#pagarFacturaVABtn").attr("data-numobjeto");
			var anioGravable = $("#pagarFacturaVABtn").attr("data-aniogravable");
			
			if(ACC.facturacion.validarAntesSubmitWSPagar(impuesto,anioGravable,numObjeto)){
				ACC.spinner.show();
				var dataActual = {};	
				
				dataActual.impuesto = impuesto;
				dataActual.numbp = numbp;
				dataActual.numObjeto = numObjeto;
				dataActual.anioGravable = anioGravable;
				$.ajax({
					url : ACC.descargaFacturaVAPagosURL,
					data : dataActual,
					type : "GET",
					success : function(dataResponse) {
						ACC.spinner.close();
						ACC.facturacion.manejarRespuestaWSPagar(dataActual,dataResponse);
					},
					error : function() {
						ACC.spinner.close();
						alert("Error procesar la solicitud de proceso de pago");	
					}
				});
			}
			
			
		});
		
		
	},
	
	
	manejarRespuestaWSPagar : function(dataActual,dataResponse){
//		ACC.publicidadexterior.bindDataTable_ID_refresh("#example");
		ACC.facturacion.manejarRespuestaWSPagar_registrosTabla(dataActual,dataResponse);
		
		var tableImpuesto = document.getElementsByClassName("table pagarImpuesto");
//		tableImpuesto[0].setAttribute("id","example");
//		ACC.publicidadexterior.bindDataTable_id("#example");
		
		switch (dataActual.impuesto){
			case "0001":
				ACC.facturacion.visualizacionPopUpPagar (tableImpuesto[0],"Predial","0001");
			break;
			case "0002":
				ACC.facturacion.visualizacionPopUpPagar (tableImpuesto[0],"Vehicular","0001");
			break;
		}

		
	},
	
	
	manejarRespuestaWSPagar_registrosTabla : function(dataActual,dataResponse){
		var claveCSSTabla = ".pagarImpuesto";
		
		var valueS = {};
		var valueC = {};
		var value = {};
		if(dataResponse != null){
			switch (dataActual.impuesto){
				case "0001":
					if(dataResponse.responsePredial != null){
						value.impuesto = "5101";
						value.periodo = "";
						value.cdu = "";
						value.placa = "";
						value.facilidad = "";
						value.montoFacilidad = "";
						value.anoGravable = dataResponse.responsePredial.anoGravable;
						value.chip = dataResponse.responsePredial.CHIP;
						value.numObjeto = dataResponse.responsePredial.CHIP;
						value.fechaVenc = dataResponse.responsePredial.fechaVencimiento;
						value.numRef = dataResponse.responsePredial.numReferencia;
						valueS = Object.assign({}, value);
						valueC = Object.assign({}, value);
						valueS.montoAporte = dataResponse.responsePredial.totalPagar;
						valueS.pagoVoluntario = "0.00";
						valueC.montoAporte = dataResponse.responsePredial.totalConVoluntario;
						valueC.pagoVoluntario = dataResponse.responsePredial.pagoVoluntario;
					}
					break;
				
				case "0002":
					if(dataResponse.responseVehicular != null){
						value.impuesto = "5103";
						value.periodo = "";
						value.chip = "";
						value.cdu = "";
						value.facilidad = "";
						value.montoFacilidad = "";
						value.anoGravable = dataResponse.responseVehicular.anoGravable;
						value.placa = dataResponse.responseVehicular.placa;
						value.numObjeto = dataResponse.responseVehicular.placa;
						value.fechaVenc = dataResponse.responseVehicular.fechaVencimiento;
						value.numRef = dataResponse.responseVehicular.numReferencia;
						valueS = Object.assign({}, value);
						valueC = Object.assign({}, value);
						valueS.montoAporte = dataResponse.responseVehicular.totalPagar;
						valueS.pagoVoluntario = "0.00";
						valueC.montoAporte = dataResponse.responseVehicular.totalConVoluntario;
						valueC.pagoVoluntario = dataResponse.responseVehicular.pagoVoluntario;
					}
					break;
				default:
					break;
			}
		}
		
		
		if( claveCSSTabla != null){
			$(claveCSSTabla+" tbody tr").remove();
			$(claveCSSTabla+" tbody").append(ACC.facturacion.generarRegistroTablaPagar("Pago sin aporte voluntario",valueS));
			$(claveCSSTabla+" tbody").append(ACC.facturacion.generarRegistroTablaPagar("Pago con aporte voluntario",valueC));
		}

		
	},
	
	
	generarRegistroTablaPagar : function(tituloTD,value){
		return '<tr>'+
			'<td>'+ tituloTD  + '</td>' +
			'<td>'+ value.numRef + '</td>' +
			'<td>'+ value.montoAporte + '</td>' +
			'<td><label class="control-label" style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important; text-align: center " id="Detalle" '+ 
			'onclick="pagarEnLinea('
				+ '\'' + value.impuesto + '\','
				+ '\'' + value.anoGravable + '\','
				+ '\'' + value.periodo + '\','
				+ '\'' + value.numObjeto + '\','
				+ '\'' + value.chip + '\','
				+ '\'' + value.fechaVenc + '\','
				+ '\'' + value.numRef + '\','
				+ '\'' + value.montoAporte + '\','
				+ '\'' + value.cdu + '\','
				+ '\'' + value.placa + '\','
				+ '\'' + value.facilidad + '\','
				+ '\'' + value.montoFacilidad + '\','
				+ '\'' + value.pagoVoluntario + '\''	
				+')" ' +			
			'>Pagar</label></td>'+
			'</tr>'
	},
	
	
	llamarPago : function(boton){
		var concepto = $(boton).data("concepto");
		var numReferencia = $(boton).data("numreferencia");
		var monto = $(boton).data("monto");
		
		alert("aca se realiza el llamado para pagar concepto: " + concepto + " numReferencia: " + numReferencia + " monto: " + monto);	
	},
	
	
	
	validarAntesSubmitWSPagar : function(impuesto,anoGravable,numObjeto){
		var validacion = true;
		
		return validacion;
	},
	
	
	visualizacionPopUpPagar : function(tabla, tituloTabla, impuesto){

        ACC.colorbox.open(tituloTabla, {
            href: ".js-"+ impuesto +"-facet",
            inline: true,
            width: "90%",
            onComplete: function () {
                $(document).on("click", ".js-"+ impuesto +"-facet .js-facet-name-" + impuesto, function (e) {
                    e.preventDefault();
                    $(".js-"+ impuesto +"-facet  .js-facet-" + impuesto).removeClass("active");
                    $(this).parents(".js-facet-" + impuesto).addClass("active");
                    $.colorbox.resize()
                })
            },
            onClosed: function () {
                $(document).off("click", ".js-"+ impuesto +"-facet .js-facet-name-" + impuesto );
            }
        });
	},
	
	obtainBeneficio: function(objeto, numObjeto)  {
	var selectRefinementsTitle = "Ser acreedor del descuento del 1%";
	var saveObj = document.getElementById('objetosBene');
	;
	saveObj.value=numObjeto;

	ACC.colorbox.open(selectRefinementsTitle, {
		href: ".js-beneficio-facet",
		inline: true,
		width: "90%",
		onComplete: function() {
			$(document).on("click", ".js-beneficio-facet .js-facet-name-ben", function(e) {
				e.preventDefault();
				$(".js-beneficio-facet  .js-facet-ben").removeClass("active");
				$(this).parents(".js-facet-ben").addClass("active");
				$.colorbox.resize()
			})
		},
		onClosed: function() {
			$(document).off("click", ".js-beneficio-facet .js-facet-name-ben");
		}
	});
},
btnBeneficio: function(items) {
	var cont = 0;
	var saveObj = "";
	var saveObjet = document.getElementById('objetosBene');
	for (i = 0; i < items.length;  i++) {
		var selected = items[i].getAttribute("aria-checked");
		if (selected == "true") {
			saveObj = saveObj+","+items[i].getAttribute("data-numobjeto");
			cont = cont + 1;
		}

	}

	if (cont <= 1) {

		alert("Atención: Se debe seleccionar más de un predio/vehículo");

	} else if (cont > 5) {
		alert("Atención: Solo puedes seleccionar máximo 5 facturas");
	} else {
		saveObjet.value = saveObj;
		var selectRefinementsTitle = "Ser acreedor del descuento del 1%";
		ACC.colorbox.open(selectRefinementsTitle, {
			href: ".js-beneficio-facet",
			inline: true,
			width: "90%",
			onComplete: function() {
				$(document).on("click", ".js-beneficio-facet .js-facet-name-ben", function(e) {
					e.preventDefault();
					$(".js-beneficio-facet  .js-facet-ben").removeClass("active");
					$(this).parents(".js-facet-ben").addClass("active");
					$.colorbox.resize()
				})
			},
			onClosed: function() {
				$(document).off("click", ".js-beneficio-facet .js-facet-name-ben");
			}
		});

	}
	},
	
	solBeneficio: function(objeto){
		ACC.spinner.show();
		$("#contObtainBen").attr("disabled","disabled");
		ACC.colorbox.close();
		
		var numObjeto = document.getElementById("objetosBene");
        var year = new Date().getFullYear();
		var constantA1 = "A1";
		var dataActual = {};	
		var yearStr = "";
		
			dataActual.fbnum = numObjeto.value;
			dataActual.casef = 0;
			dataActual.i_laufi = 0;
			if(year.toString().length >= 4){
				yearStr = year.toString().substring(2);
			}
			dataActual.i_periodo = yearStr+constantA1;
			
			$.ajax({
				url : ACC.anularFormularioURL,
				data : dataActual,
				type : "GET",
				success : function(dataForm) {
					ACC.spinner.close();
			var items = document.getElementsByClassName("checkbox");
				if (numObjeto.value.includes(",")) {
						var objects = numObjeto.value.split(",");
						
						for(i=0; i<objects.length; i++){
							for (i = 0; i < items.length; i++) {
							var selected = items[i].getAttribute("data-numobjeto");

							if (selected == objects[i]) {
								;
								items[i].setAttribute("aria-checked", false);
								disabledCheck = items[i].parentNode;
								disabledCheck2 = disabledCheck.parentNode;
								disabledCheck3 = disabledCheck2.parentNode;
								disabledCheck4 = disabledCheck3.parentNode;
								disabledCheck5 = disabledCheck4.parentNode;
								disabledCheck2.setAttribute("disabled", true);
							}

						}
						}
					} else {
						for (i = 0; i < items.length; i++) {
							var selected = items[i].getAttribute("data-numobjeto");
							if (selected.includes(numObjeto.value)) {
								;
								disabledCheck = items[i].parentNode;
								disabledCheck2 = disabledCheck.parentNode;
								disabledCheck3 = disabledCheck2.parentNode;
								disabledCheck4 = disabledCheck3.parentNode;
								disabledCheck5 = disabledCheck4.parentNode;
								
								disabledCheck2.setAttribute("disabled", true);
							}

						}
					}

					alert("Se realizó la petición del beneficio.");
					ACC.facturacion.deshabilitarBotonesBeneficio(numObjeto.value);
					
					
				}
			,
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud");	
				}
			});	
				var items = document.getElementsByClassName("checkbox");
				for (i = 0; i < items.length;  i++) {
		var selected = items[i].getAttribute("aria-checked");
		if (selected == "true") {
	items[i].setAttribute("aria-checked", false);
		}

	}	
	},
	
	
	deshabilitarBotonesBeneficio : function(numObjeto){
		$(".renglonBeneficios").each(function (index, value){
			var numObjetoActual = $(value).attr("data-numobjeto");
			if(numObjeto == numObjetoActual){
				var idObjecto = $(value).attr("id");
				switch(idObjecto){
					case "imgDescarga":
					case "downloadFac":
					case "obtainBenef":
					case "ontainBeneVehi":
						$(value).prop("onclick", false);
						break;
					case "pagarFacturaBtn":
						$(value).attr("disabled","disabled");
						break;
					default:
						break;
				}
			}
		});
		
	}
	
	
};
