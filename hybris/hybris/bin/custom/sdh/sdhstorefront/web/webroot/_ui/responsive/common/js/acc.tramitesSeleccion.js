ACC.tramitesSeleccion = {
		
		dataCreacionCaso:{},
		cantidadArchivos:{},

	_autoload : [ "bindTramitesSelect", "bindTramitesEnviar", "bindConsCasoEnviar", "bindSelectCaso" ],

	
	bindTramitesSelect : function() {
		$(document).on("change", ".tramitestSN", function(e) {
						
 	        var valorNivel = $.trim($(this).attr("data-nivel")); 	       
			var valorActual = this.value;
			var dataActual = {};
			
			dataActual.nivelSeleccion = valorNivel;
			dataActual.valorN0 = "";
			dataActual.valorN1 = "";
			dataActual.valorN2 = "";
			dataActual.valorN3 = "";
			
// debugger;
			var doc = document.getElementById('documentos');
			doc.style.display='none';
			
			if(dataActual.nivelSeleccion == 0){
				ACC.tramitesSeleccion.clearFieldsFromDataSelN0();
				dataActual.valorN0 = $("#selectNivel0").val();
			}

			if(dataActual.nivelSeleccion == 1){
				ACC.tramitesSeleccion.clearFieldsFromDataSelN1();		
				dataActual.valorN0 = $("#selectNivel0").val();
				dataActual.valorN1 = $("#selectNivel1").val();
			}

			if(dataActual.nivelSeleccion == 2){
				ACC.tramitesSeleccion.clearFieldsFromDataSelN2();
				dataActual.valorN0 = $("#selectNivel0").val();
				dataActual.valorN1 = $("#selectNivel1").val();
				dataActual.valorN2 = $("#selectNivel2").val();
			}
			
			if(dataActual.nivelSeleccion == 3){
				dataActual.valorN0 = $("#selectNivel0").val();
				dataActual.valorN1 = $("#selectNivel1").val();
				dataActual.valorN2 = $("#selectNivel2").val();
				dataActual.valorN3 = $("#selectNivel3").val();
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
			var dataCreacionCaso = {};
			

			dataCreacionCaso.nivelSeleccion = valorNivel;
			dataCreacionCaso.valorN0 = $("#selectNivel0").val();
			dataCreacionCaso.valorN1 = $("#selectNivel1").val();
			dataCreacionCaso.valorN2 = $("#selectNivel2").val();
			dataCreacionCaso.valorN3 = $("#selectNivel3").val();
			dataCreacionCaso.mensaje = $("#mensaje").val();
			
			validacion = ACC.tramitesSeleccion.validarInfoAntesSubmit(dataCreacionCaso);

//			debugger;
			if(validacion == true){
				var itemSeleccionado;
				var idItemSeleccionado;
				var indiceArchivo = 0;
				var campoEnData;
				var valorCampo = "";

				dataCreacionCaso.archivosLeidos = 0;
				for (var i = 0; i < e.target.form.length; i++) {
					itemSeleccionado = e.target.form[i];
					idItemSeleccionado = e.target.form[i].id.substring(0,17);					
										
					if(idItemSeleccionado == "docNombreArchivo_"){
						indiceItemSeleccionado = e.target.form[i].id.substring(17,18);

//						debugger;
						let file = e.target.form[i].files[0];
						let reader = new FileReader();
						reader.readAsDataURL(file);
						

						reader.onload = function(evt) {
//							console.log("onload");
//							debugger;
							indiceItemSeleccionado = ACC.tramitesSeleccion.obtenerIndiceArchivos(file.name);

							indiceArchivo = dataCreacionCaso.archivosLeidos;
							dataCreacionCaso.archivosLeidos++;
						
							campoEnPantalla = "#docLeido_" + indiceItemSeleccionado;
							$(campoEnPantalla).val("X");

							valorCampo = reader.result.substring(28);							
							campoEnData = "dataCreacionCaso.conA" + indiceArchivo;
							eval(campoEnData+"="+eval('"valorCampo"'));
//							var mensaje = file.name + valorCampo;
//							console.log(mensaje);
							
							campoEnPantalla = "#docDescArchivo_" + indiceItemSeleccionado;
							valorCampo = $(campoEnPantalla).val();
							campoEnData = "dataCreacionCaso.desA" + indiceArchivo;
							eval(campoEnData+"="+eval('"valorCampo"'));

							campoEnPantalla = "#docDependencia_" + indiceItemSeleccionado;
							valorCampo = $(campoEnPantalla).val();
							campoEnData = "dataCreacionCaso.depe" + indiceArchivo;
							eval(campoEnData+"="+eval('"valorCampo"'));						

							campoEnPantalla = "#docSerieID_" + indiceItemSeleccionado;
							valorCampo = $(campoEnPantalla).val();
							campoEnData = "dataCreacionCaso.seri" + indiceArchivo;
							eval(campoEnData+"="+eval('"valorCampo"'));
							
							campoEnPantalla = "#docSSerieID_" + indiceItemSeleccionado;
							valorCampo = $(campoEnPantalla).val();
							campoEnData = "dataCreacionCaso.sser" + indiceArchivo;
							eval(campoEnData+"="+eval('"valorCampo"'));

							campoEnPantalla = "#docTipoDoc_" + indiceItemSeleccionado;
							valorCampo = $(campoEnPantalla).val();
							campoEnData = "dataCreacionCaso.tipd" + indiceArchivo;
							eval(campoEnData+"="+eval('"valorCampo"'));						

							indiceArchivo++;
							if(indiceArchivo == cantidadArchivos){
								
								
								$.ajax({
									url : ACC.casoCreacionURL,
									data : dataCreacionCaso,
									type : "POST",
									success : function(dataResponse) {
										ACC.tramitesSeleccion.resultadoCreacionCaso(dataCreacionCaso,dataResponse);
									},
									error : function() {
									}
								});
							}
						};
						
					}
				}

			}
			
		});
	},
	
	
	obtenerIndiceArchivos : function(nombreArchivo) {
		var indiceArchivo = -1;
		var campoEnPantalla = "";
		var nombreArchivoPantalla = "";
		
		for (var i = 0; i < 10; i++) {
			campoEnPantalla = "#docNombreArchivo_" + i;
			nombreArchivoPantalla = $(campoEnPantalla).val();
			
			if(nombreArchivo == nombreArchivoPantalla.substring(12)){
				indiceArchivo = i;
				break;
			}
		} 
		
		
		return indiceArchivo;
	},
	
	
	bindConsCasoEnviar : function() {
		$(document).on("click", ".consCasoEnviar", function(e) {
			e.preventDefault();

			ACC.tramitesSeleccion.clearSeleccionCaso();

						
			var dataActual = {};
			debugger;
			dataActual.num_caso = $("#num_caso").val();
//			dataActual.tipoId = $("#tipoId").val();
//			dataActual.numDoc = $("#numDoc").val();
			dataActual.radicado = $("#radicado").val();
			
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
						'<td><label class="control-label labeltabletd tableident selectCaso" data-num_caso=" '+ value.num_caso +'" data-num_radicado=" '+ value.num_radicado +'" data-tramite=" '+ value.tramite +'" data-estatus=" '+ value.estatus +'" data-cat01=" '+ value.cat01 +'" data-cat02=" '+ value.cat02 +'" data-cat03=" '+ value.cat03 +'" data-cat04=" '+ value.cat04 +'" data-mensaje=" '+ value.mensaje +'"' +'>'+ value.num_caso +'</label>'+
						'<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="' + value.num_radicado + '" /></td>'+
						'<td><input style="width: 195px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="100" value="' + value.tramite + '" /></td>'+
						'<td><input style="width: 135px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="' + value.estatus + '" /></td>'+
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
//		valorCampo = $.trim($(this).attr("data-tramite"));
//		$("#det_tramite").val(valorCampo);		
		valorCampo = $.trim($(this).attr("data-estatus"));
		$("#det_estatus").val(valorCampo);
		valorCampo = $.trim($(this).attr("data-cat01"));
		$("#det_cat01").val(valorCampo);
		valorCampo = $.trim($(this).attr("data-cat02"));
		$("#det_cat02").val(valorCampo);
		valorCampo = $.trim($(this).attr("data-cat03"));
		$("#det_cat03").val(valorCampo);
		valorCampo = $.trim($(this).attr("data-cat04"));
		$("#det_cat04").val(valorCampo);
		valorCampo = $.trim($(this).attr("data-mensaje"));
		$("#mensaje").val(valorCampo);

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

// debugger;
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
		
//		if(infoActual.mensaje != null){
//			if(infoActual.mensaje == ""){
//				validacion = false;
//			}
//		}else{
//			validacion = false;
//		}
		if(validacion == true){
			validacion = ACC.tramitesSeleccion.validarArchivosAntesSubmit();			
		}
		
		if(validacion == false){
			alert("Por favor ingresar los valores obligatorios marcados con *");
		}
		
		
		return validacion;		
	},
	
	
	validarArchivosAntesSubmit : function() {

		var validacion = true;		
		var campoDesArchivo = "";
		var campoNomArchivo = "";
		var contenidoArchivo = "";
		var desArchivo = "";
		var nombreArchivo = "";

		
//		debugger;
		for (var i = 0; i < 10; i++) {
			campoDesArchivo = "#docDescArchivo_" + i;
			desArchivo = $(campoDesArchivo).val();
			
			if(desArchivo != undefined){
				campoNomArchivo = "#docNombreArchivo_" + i;
				nombreArchivo = $(campoNomArchivo).val();
				if(nombreArchivo == undefined || nombreArchivo == ""){
					validacion = false;
					break;
				}
			}else{
				break;
			}
		} 

		
		return validacion;		
	},
	
	
	updateFromResponse : function(infoActual,infoResponse) {

// debugger;
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

// debugger;
		var doc = document.getElementById('documentos');
		var mostrarTabDocs = false;
		
		cantidadArchivos = 0;
		if(docTramites.docTramitesResponse != null){
			cantidadArchivos = docTramites.docTramitesResponse.documentos.length - 1;
			$("#documentos").find("tr:gt(0)").remove();
			$.each(docTramites.docTramitesResponse.documentos, function (index,value){
				if(value.tipoDocumen_t != ''){
//					 debugger;

					$('#documentos').append("<tr>"+ 
						 '<td><input style="width:710px; font-size:9px !important" class="inputtextnew" disabled="disabled" type="text" size="30" id="docDescArchivo_'+ index +'" value="'+ value.tipoDocumen_t + '"/></td>"'+
						 '<td>'+
						 '<input style="width:405px" class="inputtextnew" type="file" size="150" id="docNombreArchivo_'+ index +'" />'+
						 '<input type="hidden" id="docDependencia_'+ index +'" value="'+ value.dependencia +'" />'+
						 '<input type="hidden" id="docSerieID_'+ index +'" value="'+ value.serie +'" />'+
						 '<input type="hidden" id="docSSerieID_'+ index +'" value="'+ value.subserie +'" />'+
						 '<input type="hidden" id="docTipoDoc_'+ index +'" value="'+ value.tipoDocumen +'" />'+
						 '<input type="hidden" id="docLeido_'+ index +'" value="" />'+
						 "</td>"+
						 "</tr>");
					mostrarTabDocs = true;
				}
			});
		}
		
		if(mostrarTabDocs == true){
			doc.style.display='block';
		}else{
			doc.style.display='none';
		}
	
	},
	
	performActionFromResponse : function(infoResponse) {

// debugger;
		var urlAccion = $.ajaxPrefilter();
		urlAccion = urlAccion + infoResponse.urlAccion;
		
		if(infoResponse.urlAccion != null){
			redireccionar(infoResponse.urlAccion);		
		}
		
	},
	
	
	clearFieldsFromDataSelN0 : function() {
		
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
	
	
	clearFieldsFromDataSelN1 : function() {

		$("#divSubCategoria").hide();
		$("#divCategoria").hide();
		$("#selectNivel2").find("option:gt(0)").remove();
		$("#selectNivel2").find("option:eq(0)").remove();
		$("#selectNivel3").find("option:gt(0)").remove();
		$("#selectNivel3").find("option:eq(0)").remove();			
	
	},
	
	
	clearFieldsFromDataSelN2 : function() {
		$("#divSubCategoria").hide();
		$("#selectNivel3").find("option:gt(0)").remove();
		$("#selectNivel3").find("option:eq(0)").remove();
	
	}
	

};