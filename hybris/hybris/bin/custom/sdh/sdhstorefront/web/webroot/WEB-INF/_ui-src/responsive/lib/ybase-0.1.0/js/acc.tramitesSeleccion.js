ACC.tramitesSeleccion = {

	_autoload : [ "bindTramitesSelect" ],

	
	bindTramitesSelect : function() {
		$(document).on("change", ".tramitestSN", function(e) {
						
 	        var valorNivel = $.trim($(this).attr("data-nivel")); 	       
			var valorActual = this.value;
			var dataActual = {};
			
			debugger;
			dataActual.nivelSeleccion = valorNivel;
			dataActual.valorN0 = $("#selectNivel0").val();
			dataActual.valorN1 = $("#selectNivel1").val();
			dataActual.valorN2 = $("#selectNivel2").val();
			dataActual.valorN3 = $("#selectNivel3").val();

			$.ajax({
				url : ACC.tramitestSeleccionURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					ACC.tramitesSeleccion.fillFieldsFromData(dataActual,dataResponse);
				},
				error : function() {
				}
			});
		});
	},
	
	fillFieldsFromData : function(infoActual,infoCascada) {

		debugger;
		if(infoActual.nivelSeleccion == 0){
			$("#divSubCategoria").hide();
			$("#divCategoria").hide();
			$("#divSubtramite").hide();
			$("#selectNivel1").find("option:gt(0)").remove();
			$("#selectNivel1").find("option:eq(0)").remove();
			$("#selectNivel2").find("option:gt(0)").remove();
			$("#selectNivel2").find("option:eq(0)").remove();
			$("#selectNivel3").find("option:gt(0)").remove();
			$("#selectNivel3").find("option:eq(0)").remove();

			
			if(infoCascada.length > 0){
				$.each(infoCascada, function (index,value){
					$('#selectNivel1').append("<option value="+ value.key+">"+value.label+"</option>");
				})
				$("#divSubtramite").show();
			}
		}

		if(infoActual.nivelSeleccion == 1){
			$("#divSubCategoria").hide();
			$("#divCategoria").hide();
			$("#selectNivel2").find("option:gt(0)").remove();
			$("#selectNivel2").find("option:eq(0)").remove();
			$("#selectNivel3").find("option:gt(0)").remove();
			$("#selectNivel3").find("option:eq(0)").remove();			

			if(infoCascada.length > 0){
				$.each(infoCascada, function (index,value){
					$('#selectNivel2').append("<option value="+ value.key+">"+value.label+"</option>");
				})
				$("#divCategoria").show();
			}
		}

		if(infoActual.nivelSeleccion == 2){
			$("#divSubCategoria").hide();
			$("#selectNivel3").find("option:gt(0)").remove();
			$("#selectNivel3").find("option:eq(0)").remove();
			
			if(infoCascada.length > 0){
				$("#selectNivel3").find("option:gt(0)").remove();
				$("#selectNivel3").find("option:eq(0)").remove();
				$.each(infoCascada, function (index,value){
					$('#selectNivel3').append("<option value="+ value.key+">"+value.label+"</option>");
				})
				$("#divSubCategoria").show();
			}
		}
		
		
	},
	
	

};