ACC.reportesTerceroAutorizado = {
	
	_autoload : [],

	
	consultaTA : function(opcionConsulta) {
		ACC.spinner.show();
		ACC.reportesTerceroAutorizado.vaciarTablasInfo();
		ACC.reportesTerceroAutorizado.habilitarBotonGen('none');
		ACC.reportesTerceroAutorizado.displayTablas('none', ACC.reportesTerceroAutorizado.todosImpuestos());
		ACC.reportesTerceroAutorizado.bindDataTables_refresh();
		if(ACC.reportesTerceroAutorizado.validarAntesSubmit(opcionConsulta)){
			var dataActual = ACC.reportesTerceroAutorizado.determinarData(opcionConsulta);
			
			
			$.ajax({
				url : ACC.consultaTerceroAutorizado,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.spinner.close();
					ACC.reportesTerceroAutorizado.updateFromResponse(opcionConsulta,dataActual,dataResponse,null);
					ACC.reportesTerceroAutorizado.bindDataTable_id();
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud");	
				}
			});
		}
		
	},	

	
	bindDataTables_refresh : function () {
		ACC.publicidadexterior.bindDataTable_ID_refresh("#table-predial1");
		ACC.publicidadexterior.bindDataTable_ID_refresh("#table-vehicular1");
		ACC.publicidadexterior.bindDataTable_ID_refresh("#table-ica1");
		ACC.publicidadexterior.bindDataTable_ID_refresh("#table-reteica1");
		ACC.publicidadexterior.bindDataTable_ID_refresh("#table-publicidad1");
		ACC.publicidadexterior.bindDataTable_ID_refresh("#table-gasolina1");
		ACC.publicidadexterior.bindDataTable_ID_refresh("#table-delineacion1");

    	
    },
    
    bindDataTable_id : function(){
		ACC.publicidadexterior.bindDataTable_id("#table-predial1");
		ACC.publicidadexterior.bindDataTable_id("#table-vehicular1");
		ACC.publicidadexterior.bindDataTable_id("#table-ica1");
		ACC.publicidadexterior.bindDataTable_id("#table-reteica1");
		ACC.publicidadexterior.bindDataTable_id("#table-publicidad1");
		ACC.publicidadexterior.bindDataTable_id("#table-gasolina1");
		ACC.publicidadexterior.bindDataTable_id("#table-delineacion1");
		
		
    },
	
	
	mostrarErrores : function (infoResponse) {
		var flagErrores = false;
		
		
		if (infoResponse.errores != null && infoResponse.errores[0] != null && infoResponse.errores[0].id_msj != null && infoResponse.errores[0].id_msj != ""){
			alert(infoResponse.errores[0].txt_msj);
			flagErrores = true;
		}
		
		return flagErrores;
	},
	
	
	updateFromResponse : function(opcionConsulta,infoActual,infoResponse) {

		var flagTablas = ACC.reportesTerceroAutorizado.determinarTablas(opcionConsulta,infoActual,infoResponse);
		var flagMostrarTabla = {};
		var claveImpuestoBTN = "";

		ACC.reportesTerceroAutorizado.vaciarTablasInfo();
		if (ACC.reportesTerceroAutorizado.mostrarErrores(infoResponse) != true || opcionConsulta == "objeto" ){

			if(flagTablas.obligacionesPredios == true && infoResponse.obligacionesPredios != null && infoResponse.obligacionesPredios.length > 0){
				$.each(infoResponse.obligacionesPredios, function (index,value){
					if(value.chip != ""){
					$('#table-predial1').append("<tr>"+
						'<td>' + value.anoGravable + '</td>'+
						'<td>' + value.chip + '</td>'+
						'<td>' + value.matriculaInmobiliaria + '</td>'+
						'<td>' + value.direccion + '</td>'+
						'<td><input id="obligacionesPredios_registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="text" value="'+ value.estadoObligacion +'" data-chip="'+ value.chip +'"' +">" + "</td>"+
						"</tr>");
					flagMostrarTabla.obligacionesPredios = true;
					}
				});
				if(opcionConsulta == "objeto"){
					claveImpuestoBTN = "0001";
				}
			}
			
			if(flagTablas.obligacionesVehicular == true && infoResponse.obligacionesVehicular != null && infoResponse.obligacionesVehicular.length > 0){
				$.each(infoResponse.obligacionesVehicular, function (index,value){
					if(value.placa!=""){
						$('#table-vehicular1').append("<tr>"+
							'<td>' + value.anoGravable + '</td>'+
							'<td>' + value.placa + '</td>'+
							'<td>' + value.modelo + '</td>'+
							'<td>' + value.marca + '</td>'+
							'<td>' + value.linea + '</td>'+
							'<td><input id="obligacionesVehicular_registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="text" value="'+ value.estadoObligacion +'" data-chip="'+ value.chip +'"' +">" + "</td>"+
							"</tr>");
						flagMostrarTabla.obligacionesVehicular = true;
					}
				});
				if(opcionConsulta == "objeto"){
					claveImpuestoBTN = "0002";
				}
			}

			
			if(flagTablas.obligacionesICA == true && infoResponse.obligacionesICA != null && infoResponse.obligacionesICA.length > 0){
				$.each(infoResponse.obligacionesICA, function (index,value){
					if(value.anoGravable != "" && value.periodo != ""){
						$('#table-ica1').append("<tr>"+
							'<td>' + value.anoGravable + '</td>'+
							'<td>' + value.periodo + '</td>'+
							'<td><input id="obligacionesICA_registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="text" value="'+ value.estadoObligacion +'" data-chip="'+ value.chip +'"' +">" + "</td>"+
							"</tr>");
						flagMostrarTabla.obligacionesICA = true;
					}
				});
			}
			
			if(flagTablas.obligacionesGasolina == true && infoResponse.obligacionesGasolina != null && infoResponse.obligacionesGasolina.length > 0){
				$.each(infoResponse.obligacionesGasolina, function (index,value){
					if(value.anoGravable != "" && value.periodo != ""){
						$('#table-gasolina1').append("<tr>"+
							'<td>' + value.anoGravable + '</td>'+
							'<td>' + value.periodo + '</td>'+
							'<td><input id="obligacionesGasolina_registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="text" value="'+ value.estadoObligacion +'" data-chip="'+ value.chip +'"' +">" + "</td>"+
							"</tr>");
						flagMostrarTabla.obligacionesGasolina = true;
					}
				});
			}
			
			if(flagTablas.obligacionesDelineacion == true && infoResponse.obligacionesDelineacion != null && infoResponse.obligacionesDelineacion.length > 0){
				$.each(infoResponse.obligacionesDelineacion, function (index,value){
					if(value.cdu != "" || value.chip != ""){
						$('#table-delineacion1').append("<tr>"+
							'<td>' + value.anoGravable + '</td>'+
							'<td>' + value.cdu + '</td>'+
							'<td>' + value.chip + '</td>'+
							'<td>' + value.direccion + '</td>'+
							'<td><input id="obligacionesDelineacion_registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="text" value="'+ value.estadoObligacion +'" data-chip="'+ value.chip +'"' +">" + "</td>"+
							"</tr>");
						flagMostrarTabla.obligacionesDelineacion = true;
					}
				});
			}

			if(flagTablas.obligacionesPublicidad == true && infoResponse.obligacionesPublicidad != null && infoResponse.obligacionesPublicidad.length > 0){
				$.each(infoResponse.obligacionesPublicidad, function (index,value){
					if(value.anoGravable != "" && value.numResolucion != ""){
						$('#table-publicidad1').append("<tr>"+
								'<td>' + value.anoGravable + '</td>'+
								'<td>' + value.numResolucion + '</td>'+
								'<td>' + value.direccionValla + '</td>'+
								'<td>' + value.orientacionValla + '</td>'+
								'<td><input id="obligacionesPublicidad_registroNum_'+ index +'" style="visibility: visible !important; margin: 0; min-height: 0;" name="action" type="text" value="'+ value.estadoObligacion +'" data-chip="'+ value.chip +'"' +">" + "</td>"+
								"</tr>");
						flagMostrarTabla.obligacionesPublicidad = true;
					}
				});
			}
			
			ACC.reportesTerceroAutorizado.displayTablas('block',flagMostrarTabla);
		}
		if(ACC.reportesTerceroAutorizado.habilitarBtnGenImprimir(infoResponse)){
			ACC.reportesTerceroAutorizado.mostrarBtnGenImprimir(opcionConsulta,flagMostrarTabla,infoResponse,claveImpuestoBTN);			
		}

	},
	
	
	mostrarBtnGenImprimir : function(opcionConsulta,flagMostrarTabla,infoResponse,claveImpuestoBTN){
		var flagMostrarBoton = false;
		var idMensaje = "";
		var flagSeMostroAlgunaTabla = ACC.reportesTerceroAutorizado.seMostroAlgunaTabla(flagMostrarTabla);
		
		if (infoResponse != null && infoResponse.errores != null && infoResponse.errores[0] != null && infoResponse.errores[0].id_msj != null && infoResponse.errores[0].id_msj != ""){
			idMensaje = infoResponse.errores[0].id_msj;
		}
		
		switch(opcionConsulta){
		case "objeto":
			if(flagSeMostroAlgunaTabla == false && idMensaje == "09"){
				flagMostrarBoton = false;
			}
			if(flagSeMostroAlgunaTabla == false && idMensaje == "02"){
				flagMostrarBoton = true;
			}
			break;
		
		case "sujeto":
			if(flagSeMostroAlgunaTabla == false && idMensaje == "09"){
				flagMostrarBoton = false;
			}
			if(flagSeMostroAlgunaTabla == false && idMensaje == "02"){
				flagMostrarBoton = true;
			}
			break;
		}

		if(flagMostrarBoton){
			switch(opcionConsulta){
			case "objeto":
				$("#btnGenImprimirRep").data("claveImpuesto",claveImpuestoBTN);
				break;
			
			case "sujeto":
				$("#btnGenImprimirRep").data("claveImpuesto",$("#impuesto").val());
				break;
			}
			ACC.reportesTerceroAutorizado.habilitarBotonGen('block');
		}
		
	},
	
	
	seMostroAlgunaTabla : function(flagMostrarTabla){
		var flagValor = false;
		
		if(flagMostrarTabla.obligacionesPredios != undefined || 
				flagMostrarTabla.obligacionesVehicular != undefined || 
				flagMostrarTabla.obligacionesICA != undefined || 
				flagMostrarTabla.obligacionesReteica != undefined || 
				flagMostrarTabla.obligacionesGasolina != undefined || 
				flagMostrarTabla.obligacionesDelineacion != undefined || 
				flagMostrarTabla.obligacionesPublicidad != undefined){
			flagValor = true;
		}
		
		return flagValor;
	},
	
	
	determinarTablas :  function(opcionConsulta,infoActual,infoResponse){
		var flags = {};
		
		switch(opcionConsulta){
		case "objeto":
			flags.obligacionesPredios = true;
			flags.obligacionesVehicular = true;
			flags.obligacionesICA = true;
			flags.obligacionesReteica = true;
			flags.obligacionesGasolina = true;
			flags.obligacionesDelineacion = true;
			flags.obligacionesPublicidad = true;
			
			
			break;
			
			
		case "sujeto":
			var claveImpuesto = $("#impuesto").val();
			var nombreObjeto = null;
	        
			switch(claveImpuesto){
			case "0001": //predial
				nombreObjeto = 'table-predial';
				flags.obligacionesPredios = true;
				break;
			case "0002":
				nombreObjeto = 'table-vehicular';
				flags.obligacionesVehicular = true;
				break;
			case "0003":
				nombreObjeto = 'table-ica';
				flags.obligacionesICA = true;
				break;
			case "0004":
				nombreObjeto = 'table-reteica';
				flags.obligacionesReteica = true;
				break;
			case "0005":
				nombreObjeto = 'table-gasolina';
				flags.obligacionesGasolina = true;
				break;
			case "0006":
				nombreObjeto = 'table-delineacion';
				flags.obligacionesDelineacion = true;
				break;
			case "0007":
				nombreObjeto = 'table-publicidad';
				flags.obligacionesPublicidad = true;
				break;
			}
			if(nombreObjeto != null){
				var doc = document.getElementById(nombreObjeto);
				if(doc != null){
//					doc.style.display = 'block';
				}
			}

			break;
		}

		
		return flags;
	},
	
	
	displayTablas : function(opcionDisplay,flagTabla){
		var doc = null;
		
		if(flagTabla != undefined){
			if(flagTabla.obligacionesPredios == true){
				doc = document.getElementById('table-predial');
				if(doc != null){
					doc.style.display = opcionDisplay;
				}
			}
			if(flagTabla.obligacionesVehicular == true){
				doc = document.getElementById('table-vehicular');
				if(doc != null){
					doc.style.display = opcionDisplay;
				}
			}
			if(flagTabla.obligacionesICA == true){
				doc = document.getElementById('table-ica');
				if(doc != null){
					doc.style.display = opcionDisplay;
				}
			}
			if(flagTabla.obligacionesReteica == true){
				doc = document.getElementById('table-reteica');
				if(doc != null){
					doc.style.display = opcionDisplay;
				}
			}
			if(flagTabla.obligacionesGasolina == true){
				doc = document.getElementById('table-gasolina');
				if(doc != null){
					doc.style.display = opcionDisplay;
				}
			}
			if(flagTabla.obligacionesDelineacion == true){
				doc = document.getElementById('table-delineacion');
				if(doc != null){
					doc.style.display = opcionDisplay;
				}
			}
			if(flagTabla.obligacionesPublicidad == true){
				doc = document.getElementById('table-publicidad');
				if(doc != null){
					doc.style.display = opcionDisplay;
				}
			}
		}
	},
	
	
	habilitarBotonGen : function(opcionDisplay){
		
		var botonGen = document.getElementById('btnGenImprimirRep');
		if(botonGen!=null){
			botonGen.style.display = opcionDisplay;
		}
		
	},


	validarAntesSubmit : function(opcionConsulta) {
		var validacionOK = false;
		
		switch(opcionConsulta){
		case "objeto":
	        var numObjeto = $("#numObjeto").val();
			
	        if(numObjeto != ""){
	        	validacionOK = true;
	        }else{
	        	alert("Campo Número de objeto es obligatorio");
	        }
	        
			break;
		case "sujeto":
	        var claveImpuesto = $("#impuesto").val();
	        if(claveImpuesto != null && claveImpuesto != ""){
	        }else{
	        	alert("El campo Tipo de impuesto es obligatorio");
	        }
	        
	        var claveTipdoc = $("#tipdoc").val();
	        if(claveTipdoc != null && claveTipdoc != ""){
	        }else{
	        	alert("El campo Tipo de documento es obligatorio");
	        }
	        
	        var claveNumdoc = $("#numdoc").val();
	        
	        if(claveNumdoc != null && claveNumdoc != ""){
	        }else{
	        	alert("El campo Número de documento es obligatorio");
	        }

	        if(claveImpuesto != null && claveImpuesto != "" && claveTipdoc != null && claveTipdoc != "" && claveNumdoc != null && claveNumdoc != ""){
	        	validacionOK = true;
	        }
			break;
		}


		return validacionOK;
	},
	
	
	determinarData : function(opcionConsulta) {
		var dataActual = {};
		
		if(opcionConsulta=="objeto"){
			var numObjeto = $("#numObjeto").val();
			var dataActual = {};

		    
			dataActual.numObjeto = numObjeto;				
		}else if(opcionConsulta=="sujeto"){
			var impuesto = $("#impuesto").val();
			var tipdoc = $("#tipdoc").val();
			var numdoc = $("#numdoc").val();
			var dataActual = {};
			
			dataActual.impuesto = impuesto;
			dataActual.tipdoc = tipdoc;
			dataActual.numdoc = numdoc;
		}

		return dataActual;
	},
	

	vaciarTablasInfo : function(){
		$("#table-predial1").find("tr:gt(0)").remove();
		$("#table-vehicular1").find("tr:gt(0)").remove();
		$("#table-ica1").find("tr:gt(0)").remove();
		$("#table-reteica1").find("tr:gt(0)").remove();
		$("#table-gasolina1").find("tr:gt(0)").remove();
		$("#table-delineacion1").find("tr:gt(0)").remove();
		$("#table-publicidad1").find("tr:gt(0)").remove();


	},
	
	todosImpuestos : function(){
		var flags = {};
		
		flags.obligacionesPredios = true;
		flags.obligacionesVehicular = true;
		flags.obligacionesICA = true;
		flags.obligacionesReteica = true;
		flags.obligacionesGasolina = true;
		flags.obligacionesDelineacion = true;
		flags.obligacionesPublicidad = true;
		
		return flags;
	},
	
	
	habilitarBtnGenImprimir : function(infoResponse){
		var flagErrores = false;
		
		
		if (infoResponse != null && infoResponse.errores != null && infoResponse.errores[0] != null && infoResponse.errores[0].id_msj != null && infoResponse.errores[0].id_msj != "02"){
			flagErrores = true;
		}
		
		return flagErrores;
		
	}
	
	
};