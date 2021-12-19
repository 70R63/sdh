ACC.facturacion = {

	_autoload : ["bindBuscar","bindPagarFacturaBtn"],

	
	bindBuscar : function(){
		$(document).on("click", ".facBuscar", function(){

			var imp = document.getElementById('impuesto').value;
			var tabpred = document.getElementById('table-predial');
			var tabveh = document.getElementById('table-vehiculos');
			var aniogravFiltro = document.getElementById('aniograv').value;
			var borrar = false;
			
			tabpred.style.display = 'none';
			tabveh.style.display = 'none';

			if(aniogravFiltro != ""){
				switch(imp){
				case "0001":
	//				ACC.facturacion.filtrarRegistros_aniograv("tabPaginacion0","0",aniogravFiltro);
					tabpred.style.display = 'block';
					break;
				case "0002":
	//				ACC.facturacion.filtrarRegistros_aniograv("tabPaginacion1","0",aniogravFiltro);
					tabveh.style.display = 'block';
					break;
					
				default:
					break;
				}
			}
			
		}
		);
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
    			if(value.txt_msj.trim() != ""){
    				strMensajeError = strMensajeError + value.txt_msj+"<br>";
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
		var tabpred = document.getElementById('table-predial');
		var tabveh = document.getElementById('table-vehiculos');
		
		if(tabpred != null){
			tabpred.style.display = 'none';
		}
		if(tabveh != null){
			tabveh.style.display = 'none';
		}

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
			var numObjeto = $(this).data("numObjeto");
			var anoGravable = $("#aniograv");
			
			if(ACC.facturacion.validarAntesSubmitWSPagar(impuesto,anoGravable,numObjeto)){
				ACC.spinner.show();
				var dataActual = {};	
			
				
				dataActual.impuesto = anoGravable;
				dataActual.numObjeto = numObjeto;
				dataActual.impuesto = impuesto;
				
//PENDIENTE: implementar llamada a WS y quitar este IF - INICIO
				var dataResponse = null;
				ACC.facturacion.manejarRespuestaWSPagar(dataActual,dataResponse);
				if(true){
					ACC.spinner.close();
					return;				
				}
//PENDIENTE: implementar llamada a WS y quitar este IF - FIN

				$.ajax({
					url : ACC.obtenerListaPagarFacturaURL,
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
	 	ACC.publicidadexterior.bindDataTable_ID_refresh("#example");
		ACC.facturacion.manejarRespuestaWSPagar_registrosTabla(dataActual,dataResponse);
		
		var tableImpuesto = document.getElementsByClassName("table pagarImpuesto");
		tableImpuesto[0].setAttribute("id","example");
		ACC.publicidadexterior.bindDataTable_id("#example");
		
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
		
		var claveCSSTabla = null;
		
//datos dummy de prueba, se cambiaran por el resultado de la llamada al WS - INICIO
			var value = {};
			var concepto = "Concepto";
//datos dummy de prueba, se cambiaran por el resultado de la llamada al WS - FIN
		
		switch (dataActual.impuesto){
			case "0001":
				claveCSSTabla = ".pagarImpuesto";
//datos dummy de prueba, se cambiaran por el resultado de la llamada al WS - INICIO
			value.numReferencia = "01";
			value.monto = "01";
//datos dummy de prueba, se cambiaran por el resultado de la llamada al WS - FIN

				break;
			
			case "0002":
				claveCSSTabla = ".pagarImpuesto";
				
//datos dummy de prueba, se cambiaran por el resultado de la llamada al WS - INICIO
			value.numReferencia = "02";
			value.monto = "02";
//datos dummy de prueba, se cambiaran por el resultado de la llamada al WS - FIN
			break;
		}
		
		
		if( claveCSSTabla != null){
			$(claveCSSTabla+" tbody tr").remove();
			
			$(claveCSSTabla+" tbody").append(
			'<tr>'+
			'<td>'+ "Pago con aporte voluntario" + '</td>' +
			'<td>'+ value.numReferencia + '</td>' +
			'<td>'+ value.monto + '</td>' +
			'<td><button id="btnAccionPagarFactura" data-concepto="' + "CON" + '" data-numreferencia="' + value.numReferencia + '" data-monto="' + value.monto + '" type="button" onclick="ACC.facturacion.llamarPago(this)">Pagar</button></td>'+
			'</tr>');
			
			$(claveCSSTabla+" tbody").append(
			'<tr>'+
			'<td>'+ "Pago sin aporte voluntario" + '</td>' +
			'<td>'+ value.numReferencia + '</td>' +
			'<td>'+ value.monto + '</td>' +
			'<td><button id="btnAccionPagarFactura" data-concepto="' + "SIN" + '" data-numreferencia="' + value.numReferencia + '" data-monto="' + value.monto + '" type="button" onclick="ACC.facturacion.llamarPago(this)">Pagar</button></td>'+
			'</tr>');
		}

		
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
		
		
	}
	
	
	
};