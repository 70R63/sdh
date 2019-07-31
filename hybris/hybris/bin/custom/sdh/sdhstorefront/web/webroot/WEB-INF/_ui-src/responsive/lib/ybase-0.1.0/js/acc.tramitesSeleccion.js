ACC.tramitesSeleccion = {

	_autoload : [ "bindTramitesSelect", "bindTramitesEnviar", "bindConsCasoEnviar" ],

	
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
					ACC.tramitesSeleccion.fillFieldsFromDataSel(dataActual,dataResponse);
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
						
			var dataActual = {};
			
			dataActual.num_caso = $("#num_caso").val();
			
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
	
	resultadoConsultaCaso : function(infoSeleccion, infoCaso) {

		debugger;
		var doc = document.getElementById('tableInfo');
		var mostrarTabDocs = false;
		
		
		$("#tableInfo").find("tr:gt(0)").remove();
		$.each(infoCaso, function (index,value){
			$('#tableInfo').append("<tr>"+ 
					'<td><label class="control-label labeltabletd tableident" onclick="showdetalle() value="'+ value.num_caso + '" /></label></td>'+
					'<td><input class="inputtextnew tablenumiden" disabled="disabled" type="text" size="30" value="' + value.num_radicado + '" /></td>'+
					'<td><input class="inputtextnew tablenumiden" disabled="disabled" type="text" size="30" value="' + value.tramite +'" /></td>'+
					'<td><input class="inputtextnew tablenumiden" disabled="disabled" type="text" size="30" value="' + value.estatus +'" /></td>'+
					 "</tr>");
			mostrarTabDocs = true;
		});
		if(mostrarTabDocs == true){
			doc.style.display='block';
		}else{
			doc.style.display='none';
		}
	
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
	
	
	fillFieldsFromDataSel : function(infoActual,infoResponse) {

		var doc = document.getElementById('documentos');
		doc.style.display='none';
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
		
		ACC.tramitesSeleccion.fillFieldsFromDataDocs(infoResponse);		
		
	},
	
	resultadoCreacionCaso : function(infoActual,infoResponse) {

		debugger;
		var mensaje = "";
		
		if(infoResponse.respuesta.num_caso != null){
			mensaje = infoResponse.respuesta.descripcion + " " + infoResponse.respuesta.num_caso;
		}else{
			mensaje = infoResponse.respuesta.descripcion;
		}
		alert(mensaje);
		
		
	},
	
	
	fillFieldsFromDataDocs : function(docTramites) {

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