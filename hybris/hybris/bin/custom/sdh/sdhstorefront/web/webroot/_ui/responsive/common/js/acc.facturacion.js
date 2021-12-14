ACC.facturacion = {

	_autoload : ["bindBuscar"],

	
	bindBuscar : function(){
		$(document).on("click", ".facBuscar", function(){

			var imp = document.getElementById('impuesto').value;
			var tabpred = document.getElementById('table-predial');
			var tabveh = document.getElementById('table-vehiculos');
			var aniogravFiltro = document.getElementById('aniograv').value;
			var borrar = false;
			
			tabpred.style.display = 'none';
			tabveh.style.display = 'none';

			if(aniogravFiltro != ""){
				switch(imp){
				case "0001":
	//				ACC.facturacion.filtrarRegistros_aniograv("tabPaginacion0","0",aniogravFiltro);
					tabpred.style.display = 'block';
					break;
				case "0002":
	//				ACC.facturacion.filtrarRegistros_aniograv("tabPaginacion1","0",aniogravFiltro);
					tabveh.style.display = 'block';
					break;
					
				default:
					break;
				}
			}
			
		}
		);
	},
	
	
	filtrarRegistros_aniograv : function(nombreTabla,indiceFiltro,aniogravFiltro){
		
		$("#"+nombreTabla+" tbody tr").each(function(index){
			var borrar = false;
			
			$(this).find('td:eq('+indiceFiltro+')').each(function (index){
				var valor = $(this).html();
				if(valor != aniogravFiltro && valor != "No se encontraron registros"){
					borrar = true;
				}
			});
			if(borrar == true){
				$(this).hide();
			}else{
				$(this).show();
			}
		}
		);
		
	},
	
	establecerCat_aniograv : function(){
		var aniograv = new Date().getFullYear();
		
		$("#aniograv").empty();
		$("#aniograv").append('<option value="">Seleccionar</option>');
		$("#aniograv").append('<option value="'+ aniograv + '">'+ aniograv + '</option>');
		
	},
	
	
	descargaFactura : function (anoGravable,numObjeto,tipoOperacion,descargaFactura1){
		debugger;
		ACC.spinner.show();
		if(descargaFactura1 != undefined && descargaFactura1 != null){
			var objnew = descargaFactura1;
			
			anoGravable = $.trim($(objnew).attr("data-anioGrav"));
			numObjeto = $.trim($(objnew).attr("data-numObjeto"));
		}
			
		if(ACC.facturacion.validarAntesSubmit(anoGravable,numObjeto)){
			var dataActual = {};	
		
			
			dataActual.anoGravable = anoGravable;
			dataActual.numObjeto = numObjeto;
			dataActual.tipoOperacion = tipoOperacion;
			
			
			$.ajax({
				url : ACC.descargaFacturaURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					
					ACC.spinner.close();
					ACC.facturacion.manejarRespuesta(dataResponse);
					
				}
			,
				error : function() {
					
					ACC.spinner.close();
					alert("Error procesar la solicitud de descarga de factura");	
				}
			});
		}
	 },
	 
	 
	 manejarRespuesta : function (dataResponse){
		var descargarFactura = false;
		var strMensajeError = "";
		if(dataResponse != null && dataResponse.errores != null ){
    		$.each(dataResponse.errores, function( index, value ) {
    			if(value.txt_msj.trim() != ""){
    				strMensajeError = strMensajeError + value.txt_msj+"<br>";
    			}
    		});
		}
		
		if(strMensajeError != ""){
			$("#dialogMensajes" ).dialog( "open" );
			$("#dialogMensajesContent").html(strMensajeError);
		}else{
			if(dataResponse.urlDownload!=null && dataResponse.urlDownload != ""){
    			$("#downloadHelper").attr("href",dataResponse.urlDownload);
    			
    			document.getElementById("downloadHelper").click();
			}
		}
	 },


	refreshTablas : function(){
		var tabpred = document.getElementById('table-predial');
		var tabveh = document.getElementById('table-vehiculos');
		
		if(tabpred != null){
			tabpred.style.display = 'none';
		}
		if(tabveh != null){
			tabveh.style.display = 'none';
		}

	},
	 
	 
	 validarAntesSubmit : function (anoGravable,numObjeto){
		 var flagValidacion = false;
		 
		 if(anoGravable!= null && numObjeto != null){
			 flagValidacion = true;
		 }
		 return flagValidacion;
	 },

	copieied: function(text) {

	 $("#asmCopyHoldtext").val(text);
    $("#asmCopyHoldtext").show();
    $("#asmCopyHoldtext").select();
    try {
        return document.execCommand("copy");
    } catch (ex) {
        console.debug("Copy to clipboard failed.", ex);
        return false;
    } finally {
        $("#asmCopyHoldtext").hide();
    }

		

	},
	
};