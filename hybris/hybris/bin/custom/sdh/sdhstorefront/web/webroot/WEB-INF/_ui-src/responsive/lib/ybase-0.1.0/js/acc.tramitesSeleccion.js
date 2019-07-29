ACC.tramitesSeleccion = {

	_autoload : [ "bindTramitesSelect" ],

	
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

			debugger;
			var doc = document.getElementById('documentos');
			doc.style.display='none';
			
			if(dataActual.nivelSeleccion == 0){
				$("#divSubCategoria").hide();
				$("#divCategoria").hide();
				$("#divSubtramite").hide();
				$("#selectNivel1").find("option:gt(0)").remove();
				$("#selectNivel1").find("option:eq(0)").remove();
				$("#selectNivel2").find("option:gt(0)").remove();
				$("#selectNivel2").find("option:eq(0)").remove();
				$("#selectNivel3").find("option:gt(0)").remove();
				$("#selectNivel3").find("option:eq(0)").remove();
			}

			if(dataActual.nivelSeleccion == 1){
				$("#divSubCategoria").hide();
				$("#divCategoria").hide();
				$("#selectNivel2").find("option:gt(0)").remove();
				$("#selectNivel2").find("option:eq(0)").remove();
				$("#selectNivel3").find("option:gt(0)").remove();
				$("#selectNivel3").find("option:eq(0)").remove();			
			}

			if(dataActual.nivelSeleccion == 2){
				$("#divSubCategoria").hide();
				$("#selectNivel3").find("option:gt(0)").remove();
				$("#selectNivel3").find("option:eq(0)").remove();
			}
				

			
			
			$.ajax({
				url : ACC.tramitestSeleccionURL,
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
	
	fillFieldsFromDataSel : function(infoActual,infoResponse) {

		
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

			
			if(infoResponse.opciones.length > 0){
				$.each(infoResponse.opciones, function (index,value){
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

			if(infoResponse.opciones.length > 0){
				$.each(infoResponse.opciones, function (index,value){
					$('#selectNivel2').append("<option value="+ value.key+">"+value.label+"</option>");
				})
				$("#divCategoria").show();
			}
		}

		if(infoActual.nivelSeleccion == 2){
			$("#divSubCategoria").hide();
			$("#selectNivel3").find("option:gt(0)").remove();
			$("#selectNivel3").find("option:eq(0)").remove();
			
			if(infoResponse.opciones.length > 0){
				$.each(infoResponse.opciones, function (index,value){
					$('#selectNivel3').append("<option value="+ value.key+">"+value.label+"</option>");
				})
				$("#divSubCategoria").show();
			}
		}
		
		
		debugger;
		var doc = document.getElementById('documentos');
		var docDescripcion = document.getElementById('docTramite');
		if(infoResponse.docTramitesResponse != null){
			if(infoResponse.docTramitesResponse.documentos != null){
				if(infoResponse.docTramitesResponse.documentos.tipoDocumen_t != null){
					docDescripcion.value = infoResponse.docTramitesResponse.documentos.tipoDocumen_t;		
					doc.style.display='block';
				}else{
					doc.style.display='none';
				}						
			}else{
				doc.style.display='none';
			}
		}else{
			doc.style.display='none';
		}
		
				
//		debugger;
//		$.ajax({
//			url : ACC.tramitesDocTramitesURL,
//			data : infoActual,
//			type : "GET",
//			success : function(docTramites) {
//				ACC.tramitesSeleccion.fillFieldsFromDataDocs(docTramites);
//			},
//			error : function() {
//			}
//		});		
		
		
		
	},
	
	
	clearFieldsFromDataSel : function(infoActual) {

		var doc = document.getElementById('documentos');
		doc.style.display='none';	
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
		}

		if(infoActual.nivelSeleccion == 1){
			$("#divSubCategoria").hide();
			$("#divCategoria").hide();
			$("#selectNivel2").find("option:gt(0)").remove();
			$("#selectNivel2").find("option:eq(0)").remove();
			$("#selectNivel3").find("option:gt(0)").remove();
			$("#selectNivel3").find("option:eq(0)").remove();			
		}

		if(infoActual.nivelSeleccion == 2){
			$("#divSubCategoria").hide();
			$("#selectNivel3").find("option:gt(0)").remove();
			$("#selectNivel3").find("option:eq(0)").remove();
		}
		

	},
	
	
	fillFieldsFromDataDocs : function(docTramites) {

		debugger;
		var descripcionDocumento = docTramites.documentos.tipoDocumen_t;
		var doc = document.getElementById('documentos');
		
		if(descripcionDocumento != null){
			$("#docTramite").val = descripcionDocumento;		
			doc.style.display='block';
		}else{
			doc.style.display='none';
		}

		
	}
	

};