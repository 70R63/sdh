ACC.reportesTerceroAutorizado = {
	
	_autoload : [ "consultaTA"],

	
	consultaTA : function() {

		debugger;
//		ACC.reportesTerceroAutorizado.ocultarTablas();
//		ACC.reportesTerceroAutorizado.()
//		ACC.publicidadexterior.bindDataTable_ID_refresh();
		ACC.reportesTerceroAutorizado.vaciarTablasInfo();
		if(ACC.reportesTerceroAutorizado.validarAntesSubmit()){
			var impuesto = $("#impuesto").val();
			var numObjeto = $("#numObjeto").val();
			var dataActual = {};
		
			
			dataActual.impuesto = impuesto;
			dataActual.numObjeto = numObjeto;
			
			
			$.ajax({
				url : ACC.consultaTerceroAutorizado,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					debugger;
					ACC.reportesTerceroAutorizado.mostrarErrores(dataResponse);
					ACC.reportesTerceroAutorizado.updateFromResponse(dataActual,dataResponse,null);					
					ACC.reportesTerceroAutorizado.bindDataTable_Class();
				},
				error : function() {
					alert("Error procesar la solicitud");	
				}
			});
		}
		
		
	},	

    bindDataTable_ID_refresh: function (id) {
		table = $(id).DataTable();
		table.destroy();
    	
    },
	
	
	
	mostrarErrores : function (infoResponse) {
		debugger;
		if (infoResponse.errores != null && infoResponse.errores[0] != null && infoResponse.errores[0].idmsj != 0){
			alert(infoResponse.errores[0].txtmsj);
		}
	},
	
	
	updateFromResponse : function(infoActual,infoResponse) {

		debugger;
		ACC.reportesTerceroAutorizado.vaciarTablasInfo();

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


	validarAntesSubmit : function(opcionConsulta) {
		var validacionOK = false;
		
		if(opcionConsulta == "objeto"){
	        var numObjeto = $("#numObjeto").val();
			
	        if(numObjeto != ""){
	        	validacionOK = true;
	        }else{
	        	alert("Campo Número de objeto es obligatorio");
	        }
		}else if(opcionConsulta == "sujeto"){
	        var claveImpuesto = $("#impuesto").val();
	        
	        if(claveImpuesto != ""){
	        	validacionOK = true;
	        }else{
	        	alert("Campo Tipo de impuesto es obligatorio");
	        }
			
		}

		return validacionOK;
	},


	ocultarTablas : function() {

		debugger;
		var x = $("#impuesto").val;

		ACC.reportesTerceroAutorizado.ocultarTablas_impuesto(x);


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

		ACC.reportesTerceroAutorizado.vaciarTablasInfo();

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
		$("#table-predial1").find("tr:gt(0)").remove();
		$("#table-vehicular1").find("tr:gt(0)").remove();
		$("#table-publicidad1").find("tr:gt(0)").remove();
		$("#table-gasolina1").find("tr:gt(0)").remove();
		$("#table-ica1").find("tr:gt(0)").remove();
		$("#table-reteica1").find("tr:gt(0)").remove();
		$("#table-delineacion1").find("tr:gt(0)").remove();

	},

	
	vaciarTablasInfo_presentarDec : function(){
		$("#table-vehicular1").find("tr:gt(0)").remove();
		$("#table-predial1").find("tr:gt(0)").remove();
		$("#table-myTable").find("tr:gt(0)").remove();
	},
	
	
	
};