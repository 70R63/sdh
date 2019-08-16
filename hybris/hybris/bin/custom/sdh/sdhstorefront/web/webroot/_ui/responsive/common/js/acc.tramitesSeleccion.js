ACC.tramitesSeleccion = {

	_autoload : [ "bindTramitesSelect", "bindTramitesEnviar", "bindConsCasoEnviar", "bindSelectCaso" ],

	
	bindTramitesSelect : function() {
		$(document).on("change", ".tramitestSN", function(e) {
						
 	        var valorNivel = $.trim($(this).attr("data-nivel")); 	       
			var valorActual = this.value;
			var dataActual = {};
			
			dataActual.nivelSeleccion = valorNivel;
			dataActual.valorN0 = $("#selectNivel0").val();
			dataActual.valorN1 = $("#selectNivel1").val();
			dataActual.valorN2 = $("#selectNivel2").val();
			dataActual.valorN3 = $("#selectNivel3").val();

//			debugger;
			var doc = document.getElementById('documentos');
			doc.style.display='none';
			
			if(dataActual.nivelSeleccion == 0){
				ACC.tramitesSeleccion.clearFieldsFromDataSelN0();
			}

			if(dataActual.nivelSeleccion == 1){
				ACC.tramitesSeleccion.clearFieldsFromDataSelN1();		
			}

			if(dataActual.nivelSeleccion == 2){
				ACC.tramitesSeleccion.clearFieldsFromDataSelN2();
			}

			
			$.ajax({
				url : ACC.casoSeleccionURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.tramitesSeleccion.updateFromResponse(dataActual,dataResponse);
				},
				error : function() {
				}
			});
		});
	},
	
	bindTramitesEnviar : function() {
		$(document).on("click", ".tramitesEnviar", function(e) {
			e.preventDefault();
						
			
 	        var valorNivel = 0; 	       
			var valorActual = this.value;
			var validacion = false;
			var dataActual = {};
			
			dataActual.nivelSeleccion = valorNivel;
			dataActual.valorN0 = $("#selectNivel0").val();
			dataActual.valorN1 = $("#selectNivel1").val();
			dataActual.valorN2 = $("#selectNivel2").val();
			dataActual.valorN3 = $("#selectNivel3").val();
			dataActual.mensaje = $("#mensaje").val();			
			
			debugger;
			validacion = ACC.tramitesSeleccion.validarInfoAntesSubmit(dataActual);
			
			if(validacion == true){
				$.ajax({
					url : ACC.casoCreacionURL,
					data : dataActual,
					type : "GET",
					success : function(dataResponse) {
						ACC.tramitesSeleccion.resultadoCreacionCaso(dataActual,dataResponse);
					},
					error : function() {
					}
				});
			}
			
		});
	},
	
	bindConsCasoEnviar : function() {
		$(document).on("click", ".consCasoEnviar", function(e) {
			e.preventDefault();

			ACC.tramitesSeleccion.clearSeleccionCaso();

						
			var dataActual = {};
			
			dataActual.num_caso = $("#num_caso").val();
			dataActual.tipoId = $("#tipoId").val();
			dataActual.numDoc = $("#numDoc").val();
			
			debugger;
			$.ajax({
				url : ACC.casoConsultaURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.tramitesSeleccion.resultadoConsultaCaso(dataActual,dataResponse);
				},
				error : function() {
				}
			});
			
		});
	},
	
	resultadoConsultaCaso : function(infoSeleccion, infoResponse) {

		debugger;
		ACC.tramitesSeleccion.clearSeleccionCaso();
		var mostrarTabDocs = false;
		
		
		$("#tableInfo").find("tr:gt(0)").remove();
		if(infoResponse.infoCasos.length > 0){
			$.each(infoResponse.infoCasos, function (index,value){
				$('#tableInfo').append("<tr>"+ 
						'<td><label class="control-label labeltabletd tableident selectCaso" data-num_caso=" '+ value.num_caso +'" data-num_radicado=" '+ value.num_radicado +'" data-tramite=" '+ value.tramite +'"data-estatus=" '+ value.estatus +'"     >'+ value.num_caso +'</label>'+
						'<td><input class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="' + value.num_radicado + '" /></td>'+
						'<td><input class="inputtextnew tablenumiden" disabled="disabled" type="text" size="100" value="' + value.tramite +'" /></td>'+
						'<td><input class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="' + value.estatus +'" /></td>'+
						 "</tr>");
				mostrarTabDocs = true;
			});			
		}
		if(mostrarTabDocs == true){
			var doc = document.getElementById('tableInfo');
			doc.style.display='block';
		}
		if(infoResponse.mensaje != null && infoResponse.mensaje != ""){
			alert(infoResponse.mensaje);			
		}
	
	},
	
	bindSelectCaso : function() {
		$(document).on("click", ".selectCaso", function(e) {
			
		var valorCampo; 
		
		valorCampo = $.trim($(this).attr("data-num_caso"));
		$("#det_num_caso").val(valorCampo);
		valorCampo = $.trim($(this).attr("data-num_radicado"));
		$("#det_num_radicado").val(valorCampo);
		valorCampo = $.trim($(this).attr("data-tramite"));
		$("#det_tramite").val(valorCampo);		
		valorCampo = $.trim($(this).attr("data-estatus"));
		$("#det_estatus").val(valorCampo);

		var deta = document.getElementById('detalle');
 		deta.style.display = 'block';
 	       
		});
	},
	
	clearSeleccionCaso :function() {

		var doc = document.getElementById('tableInfo');
		doc.style.display='none';

		var deta = document.getElementById('detalle');
		deta.style.display = 'none';
		
	},
	
	validarInfoAntesSubmit : function(infoActual,infoResponse) {

		debugger;
		var mensaje = "";
		var validacion = true;
		
		
		if(infoActual.valorN0 != null){
			if(infoActual.valorN0 == "00"){
				validacion = false;
			}else{
				if(infoActual.valorN1 != null){
					if(infoActual.valorN1 == "00"){
						validacion = false;
					}else{
						if(infoActual.valorN2 != null){
							if(infoActual.valorN2 == "00"){
								validacion = false;
							}else{
								if(infoActual.valorN3 != null){
									if(infoActual.valorN3 == "00"){
										validacion = false;
									}
								}
							}
						}
					}
				}
			}
		}else{
			validacion = false;
		}
		
		if(infoActual.mensaje != null){
			if(infoActual.mensaje == ""){
				validacion = false;
			}
		}else{
			validacion = false;
		}
		
		if(validacion == false){
			alert("Por favor ingresar los valores obligatorios marcados con *");
		}
		
		return validacion;		
	},
	
	
	updateFromResponse : function(infoActual,infoResponse) {

		debugger;
		ACC.tramitesSeleccion.performActionFromResponse(infoResponse);	
		ACC.tramitesSeleccion.updateSelectFromResponse(infoActual,infoResponse);		
		ACC.tramitesSeleccion.fillDocsDataFromResponse(infoResponse);		
			
		
	},
	
	
	updateSelectFromResponse : function(infoActual,infoResponse) {	
		
		if(infoActual.nivelSeleccion == 0){
			ACC.tramitesSeleccion.clearFieldsFromDataSelN0();
			if(infoResponse.opciones.length > 0){
				$.each(infoResponse.opciones, function (index,value){
					$('#selectNivel1').append("<option value="+ value.key+">"+value.label+"</option>");
				})
				$("#divSubtramite").show();
			}
		}

		if(infoActual.nivelSeleccion == 1){
			ACC.tramitesSeleccion.clearFieldsFromDataSelN1();
			
			if(infoResponse.opciones.length > 0){
				$.each(infoResponse.opciones, function (index,value){
					$('#selectNivel2').append("<option value="+ value.key+">"+value.label+"</option>");
				})
				$("#divCategoria").show();
			}
		}

		if(infoActual.nivelSeleccion == 2){
			ACC.tramitesSeleccion.clearFieldsFromDataSelN2();
			
			if(infoResponse.opciones.length > 0){
				$.each(infoResponse.opciones, function (index,value){
					$('#selectNivel3').append("<option value="+ value.key+">"+value.label+"</option>");
				})
				$("#divSubCategoria").show();
			}
		}	
		
	},
	
	
	resultadoCreacionCaso : function(infoActual,infoResponse) {

		debugger;
		var mensaje = "";
		
		if(infoResponse.respuesta.num_caso != null){
			mensaje = infoResponse.respuesta.descripcion + " " + infoResponse.respuesta.num_caso;
			var doc = document.getElementById('documentos');
			doc.style.display='none';
			$("#mensaje").val("");	
			ACC.tramitesSeleccion.clearFieldsFromDataSelN0();
			$("#selectNivel0").val("00");	
		}else{
			mensaje = infoResponse.respuesta.descripcion;
		}
		alert(mensaje);		
		
		
	},
	
	
	fillDocsDataFromResponse : function(docTramites) {

		debugger;
		var doc = document.getElementById('documentos');
		var mostrarTabDocs = false;
		
		
		$("#documentos").find("tr:gt(0)").remove();
		$.each(docTramites.docTramitesResponse.documentos, function (index,value){
			if(value.tipoDocumen_t != ''){
			$('#documentos').append("<tr>"+ 
					 '<td><input class="inputtextnew" disabled="disabled" type="text" size="30" id = "docTramite" value="'+ value.tipoDocumen_t + '"/></td>"'+
					 '<td><input class="inputtextnew" type="file" size="30" /></td>'+
					 "</tr>");
			mostrarTabDocs = true;
			}
		});
		if(mostrarTabDocs == true){
			doc.style.display='block';
		}else{
			doc.style.display='none';
		}
	
	},
	
	performActionFromResponse : function(infoResponse) {

		debugger;
		var urlAccion = $.ajaxPrefilter();
		urlAccion = urlAccion + infoResponse.urlAccion;
		
		if(infoResponse.urlAccion != null){
			redireccionar(infoResponse.urlAccion);		
		}
	
		
	},
	
	clearFieldsFromDataSelN0 : function(infoActual) {
		
		$("#divSubCategoria").hide();
		$("#divCategoria").hide();
		$("#divSubtramite").hide();
		$("#selectNivel1").find("option:gt(0)").remove();
		$("#selectNivel1").find("option:eq(0)").remove();
		$("#selectNivel2").find("option:gt(0)").remove();
		$("#selectNivel2").find("option:eq(0)").remove();
		$("#selectNivel3").find("option:gt(0)").remove();
		$("#selectNivel3").find("option:eq(0)").remove();

	},
	
	clearFieldsFromDataSelN1 : function(infoActual) {

		$("#divSubCategoria").hide();
		$("#divCategoria").hide();
		$("#selectNivel2").find("option:gt(0)").remove();
		$("#selectNivel2").find("option:eq(0)").remove();
		$("#selectNivel3").find("option:gt(0)").remove();
		$("#selectNivel3").find("option:eq(0)").remove();			
	
	},
	
	clearFieldsFromDataSelN2 : function(infoActual) {
		$("#divSubCategoria").hide();
		$("#selectNivel3").find("option:gt(0)").remove();
		$("#selectNivel3").find("option:eq(0)").remove();
	
	}
	

};