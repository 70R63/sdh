ACC.concesionarios = {

//	_autoload : [],

	
	buscar : function() {

		ACC.concesionarios.ocultarTablas();
		ACC.publicidadexterior.bindDataTable_Class_refresh();
		ACC.concesionarios.vaciarTablasInfo();
		var fecha = $("#fecInio").val();
		var status = $("#referenceStatus").val();
		var dataActual = {};

		dataActual.fecInio = fecha;
		dataActual.referenceStatus = status;
		if(ACC.concesionarios.validarAntesSubmit(dataActual)){
			ACC.spinner.show();
			$.ajax({
				url : ACC.listaConcesionariosURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.spinner.close();
					ACC.concesionarios.updateFromResponseSeleccion(dataActual,dataResponse);
					ACC.publicidadexterior.bindDataTable_Class();
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud");	
				}
			});
		}
		
		
	},
	
	
	updateFromResponseSeleccion : function(infoActual,infoResponse) {
		ACC.concesionarios.vaciarTablasInfo();

		if (infoResponse != null){
			var status = ACC.concesionarios.obtenerDescripcionStatus($("#referenceStatus").val());
			
			$.each(infoResponse, function (index,value){
				var fechaVencimiento= "";
				if(value.FAEDN != null){
					fechaVencimiento = value.FAEDN;
					fechaVencimiento = fechaVencimiento.substring(6,8) + "/" + fechaVencimiento.substring(4,6) + "/" + fechaVencimiento.substring(0,4);
				}

				var fechaVigencia = "";
				if(value.PERSL != null){
					fechaVigencia = "Año " + value.PERSL.substring(0,2);
				}
				
				$('#concesionarios1').append("<tr>"+
						'<td>' + value.XBLNR + '</td>'+
						'<td>' + value.PSOBTXT + '</td>'+
						'<td>' + fechaVigencia + '</td>'+
						'<td>' + fechaVencimiento + '</td>'+
						'<td>' + status + '</td>'+
						'<td>' + value.BETRW + '</td>'+
						'<td><label class="control-label" style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important; text-align: center " id="Detalle" '+ 
						'onclick="pagarEnLinea(' + '\'5103\'' + ',\'' 
						                         + value.PERSL.substring(0,2) + '\','
												 + '\'\'' + ',\'' 
												 + value.PSOBTXT + '\',' 
												 + '\'\'' + ',\'' 
												 + fechaVencimiento + '\',\'' 
												 + value.XBLNR + '\',\'' 
												 + value.BETRW + '\',' 
												 + '\'\'' + ',\'' 
												 + value.PSOBTXT + '\',' 
												 + '\'\'' + ',' 
												 + '\'\'' 
						+')" ' + 
						'>Pagar</label></td>'+	
						"</tr>");
			});
		}
		ACC.concesionarios.mostrarTablas();


	},
	
	
	ocultarTablas : function (){
		var div_concesionarios = document.getElementById('table-concesionarios');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(div_concesionarios,'none');
		
	},
	
	
	mostrarTablas : function (){
		var div_concesionarios = document.getElementById('table-concesionarios');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(div_concesionarios,'block');
	},
	
	
	vaciarTablasInfo : function (){
		$("#concesionarios1").find("tr:gt(0)").remove();
	},
	
	
	
	validarAntesSubmit : function(dataActual){
		var validacionOK = false;
		
		if(dataActual.fecInio != ""){
			validacionOK = true;
		}else{
			alert("Por favor ingresar fecha");
		}

		
		return validacionOK;
	},
	
	obtenerDescripcionStatus : function(status){
		var descripcion = "";
		
		switch(status){
			case "01":
				descripcion = "Por pagar";
				break;
			
			case "02":
				descripcion = "Pagadas";
				break;
			
			case "03":
				descripcion = "Canceladas";
				break;
			
			case "04":
				descripcion = "Todas";
				break;
			
			default:
				descripcion = "";
				break;
		}
		
		
		return descripcion;
	}
	
	
	
};