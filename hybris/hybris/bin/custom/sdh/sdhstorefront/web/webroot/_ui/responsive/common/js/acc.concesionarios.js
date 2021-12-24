ACC.concesionarios = {

//	_autoload : [],

	
	buscar : function() {
		ACC.spinner.show();
		ACC.concesionarios.ocultarTablas();
		ACC.publicidadexterior.bindDataTable_Class_refresh();
		ACC.concesionarios.vaciarTablasInfo();
		if(ACC.concesionarios.validarAntesSubmit()){
			var fecha = $("#fecInio").val;
			var status = $("#referenceStatus").val;
			var dataActual = {};

			dataActual.fecInio = fecha;
			dataActual.referenceStatus = status;
			$.ajax({
				url : ACC.listaConcesionariosURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.spinner.close();
					ACC.opcionDeclaraciones.updateFromResponseSeleccion(dataActual,dataResponse);
					ACC.publicidadexterior.bindDataTable_Class();
				},
				error : function() {
					ACC.spinner.close();
					alert("Error procesar la solicitud");	
				}
			});
		}
		
		
	},
	
	
	ocultarTablas : function (){
		var div_concesionarios = document.getElementById('table-concesionarios');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(div_concesionarios,'none');
		
	},
	
	vaciarTablasInfo : function (){
		$("#concesionarios1").find("tr:gt(0)").remove();
	},
	
	
	
	validarAntesSubmit : function(){
		return true;
		
	}
	
	
	
	
	
	
};