ACC.facturacion = {

	_autoload : ["bindBuscar"],

	
	bindBuscar : function(){
		$(document).on("click", ".facBuscar", function(){
			
			debugger;
			var imp = document.getElementById('impuesto').value;
			var tabpred = document.getElementById('table-predial');
			var tabveh = document.getElementById('table-vehiculos');
			var buscar = document.getElementById('aniograv').value;
			

			if (imp == '01') {
				
				$("#tabPaginacion0 tr").find('td:eq(0)').each(function () {
					 
					
					  valor = $(this).html();
					  if(valor == buscar){
						  $("#tabPaginacion0 tr").show();
						  
					  }else{
					
						  $("#tabPaginacion0 tr").hide();
					  }
					})
					 
				
				tabpred.style.display = 'block';
				tabveh.style.display = 'none';


		        
			} else if (imp == '02') {
				$("#tabPaginacion1 tr").find('td:eq(0)').each(function () {
					 
					  valor = $(this).html();
					  if(valor == buscar && valor != " "){
						  $("#tabPaginacion1 tr").show();
						  
					  }else{
					
						  $("#tabPaginacion1 tr").hide();
					  }
					})
				tabpred.style.display = 'none';
				tabveh.style.display = 'block';
			} else {
				tabpred.style.display = 'none';
				tabveh.style.display = 'none';
			}

			
		});
	},
	
	
	descargaFactura : function (anoGravable,numObjeto){

		debugger;
		if(ACC.facturacion.validarAntesSubmit(anoGravable,numObjeto)){
			var dataActual = {};	
		
			
			dataActual.numBP = '1';
			dataActual.anoGravable = anoGravable;
			dataActual.numObjeto = numObjeto;
			
			
			$.ajax({
				url : ACC.descargaFacturaURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					var descargarFactura = false;
					if(dataResponse != null && dataResponse.errores != null ){
		            	$("#dialogMensajes" ).dialog( "open" );
	            		$.each(dataResponse.errores, function( index, value ) {
	            			if(value.txt_msj.trim() != ""){
	            				$("#dialogMensajesContent").html($("#dialogMensajesContent").html()+value.txt_msj+"<br>");
	            			}
	            		});
					}else{
						if(dataResponse.urlDownload!=null && dataResponse.urlDownload != ""){
		        			$("#downloadHelper").attr("href",dataResponse.urlDownload);
		        			
		        			document.getElementById("downloadHelper").click();
						}						
					}
					
				}
			
			,
				error : function() {
					alert("Error procesar la solicitud de descarga de factura");	
				}
			});
		}
	 },
	 
	 
	 validarAntesSubmit : function (anoGravable,numObjeto){
		 var flagValidacion = false;
		 
		 if(anoGravable!= null && numObjeto != null){
			 flagValidacion = true;
		 }
		 
		 
		 return flagValidacion;
	 }
	
};