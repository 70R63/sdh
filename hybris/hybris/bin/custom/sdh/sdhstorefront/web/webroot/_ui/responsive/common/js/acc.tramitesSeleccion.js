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

// debugger;
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

//			debugger;
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
//				var contenidoArchivo = "";
//				var desArchivo = "";
//				var nombreArchivo = "";
				var itemSeleccionado;
				var idItemSeleccionado;
				var indiceArchivo = 0;
//				var campoNomArchivo;
				var campoEnData;
				var valorCampo = "";

				
				for (var i = 0; i < e.target.form.length; i++) {
					itemSeleccionado = e.target.form[i];
					idItemSeleccionado = e.target.form[i].id;
					indiceItemSeleccionado = idItemSeleccionado.substring(17,18);
//					idItemSeleccionado = e.target.form[i].id;
					idItemSeleccionado = idItemSeleccionado.substring(0,17);
					
					if(idItemSeleccionado == "docNombreArchivo_"){
						debugger;
//						let file = e.target.form[i].files[0];
//						let reader = new FileReader();
//						reader.readAsDataURL(file);
//						setTimeout(function(){ }, 5000);

//						reader.onload = function() {
//							contenidoArchivo = reader.result;
//							console.log(contenidoArchivo);
//							clearTimeOut();							
//						};
//						valorCampo = reader.result;
						
//						if(valorCampo == ""){
							valorCampo = "Ly8tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0gIA0KaW1wb3J0IG9yZy5zcHJpbmdmcmFtZXdvcmsuaHR0cC5jbGllbnQuc3VwcG9ydC5CYXNpY0F1dGhvcml6YXRpb25JbnRlcmNlcHRvcjsNCmltcG9ydCBvcmcuc3ByaW5nZnJhbWV3b3JrLndlYi5jbGllbnQuUmVzdFRlbXBsYXRlOw0KaW1wb3J0IGRlLmh5YnJpcy5zZGguY29yZS5jcmVkaWJhbmNvLio7DQppbXBvcnQgb3JnLnNwcmluZ2ZyYW1ld29yay5odHRwLkh0dHBIZWFkZXJzOw0KaW1wb3J0IG9yZy5zcHJpbmdmcmFtZXdvcmsuaHR0cC5NZWRpYVR5cGU7DQppbXBvcnQgb3JnLnNwcmluZ2ZyYW1ld29yay5odHRwLkh0dHBFbnRpdHk7DQppbXBvcnQgY29tLmZhc3RlcnhtbC5qYWNrc29uLmRhdGFiaW5kLk9iamVjdE1hcHBlcjsNCmltcG9ydCBqYXZhLm5pby5jaGFyc2V0LlN0YW5kYXJkQ2hhcnNldHM7DQppbXBvcnQgamF2YS51dGlsLkJhc2U2NDsNCg0KDQoNCkhlYWRlciBoZWFkZXIgPSBuZXcgSGVhZGVyKCJqd3QiLCJSUzI1NiIpOw0KbWFwcGVyID0gbmV3IE9iamVjdE1hcHBlcigpOw0KaGVhZGVySnNvbiA9ICBtYXBwZXIud3JpdGVWYWx1ZUFzU3RyaW5nKGhlYWRlcikNCmhlYWRlQmFzZTY0ID0gQmFzZTY0LmdldFVybEVuY29kZXIoKS53aXRob3V0UGFkZGluZygpLmVuY29kZVRvU3RyaW5nKGhlYWRlckpzb24uZ2V0Qnl0ZXMoU3RhbmRhcmRDaGFyc2V0cy5VVEZfOCkpOw0KcHJpbnRsbiAiSGVhZGVySnNvbjogIiArIGhlYWRlckpzb24NCnByaW50bG4gIkhlYWRlckJhc2U2NDogIiArIGhlYWRlQmFzZTY0DQpwcmludGxuICItLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0iDQoNCkluaXRpdGFsaXplVHJhbnNhY3Rpb25SZXF1ZXN0IHJlcXVlc3RPYmplY3QgPSBuZXcgSW5pdGl0YWxpemVUcmFuc2FjdGlvblJlcXVlc3QoIjEyMjIxMyIsIjA5MCIsIiIsIjEiLCANCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgImh0dHBzOi8vc2RoZGV2LmxvY2FsOjkwMDIvc2Roc3RvcmVmcm9udCIsDQoiMTUyMDAwMCIsIjAiLCI1NjMyOTg2NjIiLCJCV0Q4NjUiLCI1ODY2OSIpOw0KbWFwcGVyID0gbmV3IE9iamVjdE1hcHBlcigpOw0KcmVxdWVzdE9iamVjdEpzb24gPSBtYXBwZXIud3JpdGVWYWx1ZUFzU3RyaW5nKHJlcXVlc3RPYmplY3QpDQpqYXZhLnNlY3VyaXR5Lk1lc3NhZ2VEaWdlc3QgbWQgPSBqYXZhLnNlY3VyaXR5Lk1lc3NhZ2VEaWdlc3QuZ2V0SW5zdGFuY2UoIk1ENSIpOw0KYnl0ZVtdIGFycmF5ID0gbWQuZGlnZXN0KHJlcXVlc3RPYmplY3RKc29uLmdldEJ5dGVzKCkpOw0KU3RyaW5nQnVmZmVyIHNiID0gbmV3IFN0cmluZ0J1ZmZlcigpOw0KZm9yIChpbnQgaSA9IDA7IGkgPCBhcnJheS5sZW5ndGg7ICsraSkgew0KICAgIHNiLmFwcGVuZChJbnRlZ2VyLnRvSGV4U3RyaW5nKChhcnJheVtpXSAmIDB4RkYpIHwgMHgxMDApLnN1YnN0cmluZygxLDMpKTsNCn0NCmluaXRpYWxpemVUcmFuc2FjdGlvbiA9IHNiLnRvU3RyaW5nKCk7DQpwcmludGxuICJJbml0aWFsaXplVHJhbnNhY3Rpb25Kc29uOiAiICsgcmVxdWVzdE9iamVjdEpzb24NCnByaW50bG4gIkluaXRpYWxpemVUcmFuc2FjdGlvbkhhc2hNZDU6ICIgKyBpbml0aWFsaXplVHJhbnNhY3Rpb247DQpwcmludGxuICItLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0iDQoNCg0KbWFwcGVyID0gbmV3IE9iamVjdE1hcHBlcigpOw0KUGF5bG9hZCBwYXlsb2FkID0gbmV3IFBheWxvYWQoaW5pdGlhbGl6ZVRyYW5zYWN0aW9uLCAiU0RIIiwgIjE1MTI1ODMwODAiLCAiSW5pdGlhbGl6ZVRyYW5zYWN0aW9uIikNCnBheWxvYWRKc29uID0gbWFwcGVyLndyaXRlVmFsdWVBc1N0cmluZyhwYXlsb2FkKQ0KcGF5bG9hZEJhc2U2NCA9IEJhc2U2NC5nZXRVcmxFbmNvZGVyKCkud2l0aG91dFBhZGRpbmcoKS5lbmNvZGVUb1N0cmluZyhwYXlsb2FkSnNvbi5nZXRCeXRlcyhTdGFuZGFyZENoYXJzZXRzLlVURl84KSkrIj09Ig0KcHJpbnRsbiAiUGF5bG9hZEpzb246ICIgKyBwYXlsb2FkSnNvbg0KcHJpbnRsbiAiUGF5bG9hZEJhc2U2NDogIiArIHBheWxvYWRCYXNlNjQNCnByaW50bG4gIi0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLSINCg0Kc3RyaW5ndG9FbmNvZGUgPSBoZWFkZUJhc2U2NCArICIuIiArIHBheWxvYWRCYXNlNjQNCnByaW50bG4gIkhlYWRlckJhc2U2NC5QYXlsb2FkQmFzZTY0OiAiICsgc3RyaW5ndG9FbmNvZGUNCi8vcHJpbnRsbiAiLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tIg0KDQoNCmltcG9ydCBqYXZheC5jcnlwdG8uQ2lwaGVyOw0KaW1wb3J0IGphdmEuc2VjdXJpdHkuUHJpdmF0ZUtleTsNCmltcG9ydCBqYXZhLnNlY3VyaXR5LktleVN0b3JlOw0KDQppblN0cmVhbSA9IEhlYWRlci5jbGFzcy5nZXRDbGFzc0xvYWRlcigpLmdldFJlc291cmNlQXNTdHJlYW0oInNhcHNkaC5qa3MiKQ0KU3RyaW5nIHBhc3N3b3JkID0gImJvZ2RhdGEiOw0KS2V5U3RvcmUga2V5c3RvcmUgPSBLZXlTdG9yZS5nZXRJbnN0YW5jZShLZXlTdG9yZS5nZXREZWZhdWx0VHlwZSgpKTsNCmtleXN0b3JlLmxvYWQoaW5TdHJlYW0sIHBhc3N3b3JkLnRvQ2hhckFycmF5KCkpOw0KUHJpdmF0ZUtleSBwcml2YXRlS2V5ID0gKFByaXZhdGVLZXkpa2V5c3RvcmUuZ2V0S2V5KCJzZGgiLCBwYXNzd29yZC50b0NoYXJBcnJheSgpKTsNCg0KQ2lwaGVyIGNpcGhlciA9IENpcGhlci5nZXRJbnN0YW5jZSgiUlNBIik7DQpjaXBoZXIuaW5pdChDaXBoZXIuRU5DUllQVF9NT0RFLCBwcml2YXRlS2V5KTsNCg0KZW5jb2RlZFN0cmluZyA9IEJhc2U2NC5nZXRFbmNvZGVyKCkuZW5jb2RlVG9TdHJpbmcoY2lwaGVyLmRvRmluYWwoc3RyaW5ndG9FbmNvZGUuZ2V0Qnl0ZXMoKSkpDQpzdHJpbmdUb0VuY29kZUFuZEVuY29kZWRTdHJpbmcgID0gc3RyaW5ndG9FbmNvZGUgKyAiLiIgKyBlbmNvZGVkU3RyaW5nDQpwcmludGxuICJGaXJtYURpZ2l0YWwoSGVhZGVyQmFzZTY0LlBheWxvYWRCYXNlNjQpOiAiICsgZW5jb2RlZFN0cmluZw0KcHJpbnRsbiAiLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tIg0KcHJpbnRsbiBzdHJpbmdUb0VuY29kZUFuZEVuY29kZWRTdHJpbmcNCg0KDQoNCkh0dHBIZWFkZXJzIGhlYWRlcnMgPSBuZXcgSHR0cEhlYWRlcnMoKTsNCmhlYWRlcnMuc2V0Q29udGVudFR5cGUoTWVkaWFUeXBlLkFQUExJQ0FUSU9OX0pTT04pOw0KaGVhZGVycy5zZXQoIkF1dGhvcml6YXRpb24iLCAiQmVhcmVyICIrIHN0cmluZ1RvRW5jb2RlQW5kRW5jb2RlZFN0cmluZyk7DQoNCkh0dHBFbnRpdHk8SW5pdGl0YWxpemVUcmFuc2FjdGlvblJlcXVlc3Q+IHJlcXVlc3QgPSBuZXcgSHR0cEVudGl0eTxJbml0aXRhbGl6ZVRyYW5zYWN0aW9uUmVxdWVzdD4ocmVxdWVzdE9iamVjdCxoZWFkZXJzKTsNClJlc3RUZW1wbGF0ZSByZXN0VGVtcGxhdGUgPSBuZXcgUmVzdFRlbXBsYXRlKCk7DQpyZXN0VGVtcGxhdGUucG9zdEZvck9iamVjdCgiaHR0cHM6Ly8xNzIuMjcuMS40Nzo4MDIyL1RpbGFjaW5vL2FwaS9zZGgvaW5pdGlhbGl6ZVRyYW5zYWN0aW9uIiwgcmVxdWVzdCwgT2JqZWN0LmNsYXNzKTsNCg0KLy8tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0=";
//						}
						
						campoEnData = "dataCreacionCaso.conA" + indiceArchivo;
						eval(campoEnData+"="+eval('"valorCampo"'));
						
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
					}
				}
//				console.log("llamada ajax");
				
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
			
		});
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
						'<td><label class="control-label labeltabletd tableident selectCaso" data-num_caso=" '+ value.num_caso +'" data-num_radicado=" '+ value.num_radicado +'" data-tramite=" '+ value.tramite +'" data-estatus=" '+ value.estatus +'" data-cat01=" '+ value.cat01 +'" data-cat02=" '+ value.cat02 +'" data-cat03=" '+ value.cat03 +'" data-cat04=" '+ value.cat04 +'"' +'>'+ value.num_caso +'</label>'+
						'<td><input class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="' + value.num_radicado + '" /></td>'+
						'<td><input class="inputtextnew tablenumiden" disabled="disabled" type="text" size="100" value="' + value.tramite + '" /></td>'+
						'<td><input class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="' + value.estatus + '" /></td>'+
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
		
		
		$("#documentos").find("tr:gt(0)").remove();
		$.each(docTramites.docTramitesResponse.documentos, function (index,value){
			if(value.tipoDocumen_t != ''){
				 debugger;

				$('#documentos').append("<tr>"+ 
					 '<td><input class="inputtextnew" disabled="disabled" type="text" size="30" id="docDescArchivo_'+ index +'" value="'+ value.tipoDocumen_t + '"/></td>"'+
					 '<td>'+
					 '<input style="width:405px" class="inputtextnew" type="file" size="150" id="docNombreArchivo_'+ index +'" />'+
					 '<input type="hidden" id="docDependencia_'+ index +'" value="'+ value.dependencia +'" />'+
					 '<input type="hidden" id="docSerieID_'+ index +'" value="'+ value.serie +'" />'+
					 '<input type="hidden" id="docSSerieID_'+ index +'" value="'+ value.subserie_t +'" />'+
					 '<input type="hidden" id="docTipoDoc_'+ index +'" value="'+ value.tipoDocumen +'" />'+
					 "</td>"+
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

// debugger;
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