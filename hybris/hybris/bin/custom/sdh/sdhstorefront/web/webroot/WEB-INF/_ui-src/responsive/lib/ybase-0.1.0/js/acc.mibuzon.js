ACC.mibuzon = {


	
	bindDescargar : function(objetodeN) {

			var radicado = $.trim($(objetodeN).attr("data-idRadicado")); 
			var numBP= $.trim($(objetodeN).attr("data-numBP")); 
			var idDocumento= $.trim($(objetodeN).attr("data-idDocumento"));
			var name = $.trim($(objetodeN).attr("data-name"));
			
			var dataActual = {};	

			dataActual.numBP = numBP;
			dataActual.idDocumento = idDocumento;
			dataActual.idRadicado = radicado;
			
			$.ajax({
				url : ACC.descargaAnexoPDFBuzon,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
				if(dataResponse != null || dataResponse != ""){
				var pdf = 'data:application/newpdf;base64,'+ dataResponse;
				 var dlnk = document.getElementById('dwnldLnk');
				  dlnk.href = pdf;
				  dlnk.click();
		
		         $('#tabPaginacion1').append('<tr><td>' + name + '</td><td>'+ '</td><td>' + '</td><td>' +'</td><td><label class="control-label download2" style="text-transform: capitalize !important" data-pdfimprimir='+pdf+' id="download2" onclick="downloaddos()"> <span class="glyphicon glyphicon-download-alt"></span></label></td></tr>');
//					                      $(objetodeN).closest('tr').remove();    
}else{
	alert("Error procesar la solicitud de descarga de Anexo");	
} 
				}
			,
				error : function() {

					alert("Error procesar la solicitud de descarga de Anexo");	
				}
			});
	},
	
	bindDescargar2 : function(objetode) {	
			var newobjdes = objetode;
			
			var newpdf = $.trim($(newobjdes).attr("data-pdfimprimir"));

				
				var pdf = 'data:application/newpdf;base64,'+ newpdf;
				 var dlnk = document.getElementById('dwnldLnk');
				  dlnk.href = pdf;
				  dlnk.click();
			
	},
	
	bindPapeleraNuevos : function(objectf){

			var objnew = objectf;
			
			var newpdf = $.trim($(objnew).attr("data-pdfimprimir"));
			var autoridadEmisora= $.trim($(objnew).attr("data-autoridadEmisora")); 
			var identif = $.trim($(objnew).attr("data-idRadicado"));
			var asunto= $.trim($(objnew).attr("data-asunto"));
			var fecnot = $.trim($(objnew).attr("data-fechaNotificacion"));
						  
			 $('#tabPaginacion1').append('<tr><td>' + identif + '</td><td>' + autoridadEmisora + '</td><td>' + asunto + '</td><td>' + fecnot + '</td><td><label class="control-label download2" style="text-transform: capitalize !important" data-pdfimprimir='+newpdf+' id="download2" onclick="downloaddos()"> <span class="glyphicon glyphicon-download-alt"></span></label></td><td><img src="/sdhstorefront/_ui/addons/sdhpsaddon/responsive/theme-psalpha/images/papeleraleidos.png" style="width: 20px"  onclick="eliminarleidos(this)"></img></td></tr>');

	},
	
	
	
	descargarNoti : function(objectNoti){
		
		var noti = objectNoti;
		var newpdf = $.trim($(noti).attr("data-pdfimprimir"));
		var identif = $.trim($(noti).attr("data-idRadicado")); 
		var autoridadEmisora= $.trim($(noti).attr("data-autoridadEmisora")); 
		var asunto= $.trim($(noti).attr("data-asunto"));
		var fecnot = $.trim($(noti).attr("data-fechaNotificacion"));
			
		var pdf = 'data:application/newpdf;base64,'+ newpdf;
	
		 var dlnk = document.getElementById('dwnldLnk');
		  dlnk.href = pdf;
		  dlnk.click();
		  
		  
		  ACC.publicidadexterior.bindDataTable_ID_refresh("#tabPaginacion3");	
		  var newtr = $(this).closest('tr');
		  
			 $('#tabPaginacion3').append('<tr><td>' + identif + '</td><td>' + autoridadEmisora + '</td><td>' + asunto + '</td><td>' + fecnot + '</td><td><label class="control-label download2Noti" style="text-transform: capitalize !important" data-pdfimprimir='+ newpdf +' id="download2Noti" onclick="downloaddosNoti(this)"> <span class="glyphicon glyphicon-download-alt"></span></label></td></tr>');
			 ACC.publicidadexterior.bindDataTable_id("#tabPaginacion3");
	
},


descargarNoti2 : function(objectNoti2){
	
	var noti2 = objectNoti2;

	var radicado = $.trim($(noti2).attr("data-idRadicado")); 
			var numBP= $.trim($(noti2).attr("data-numBP")); 
			var idDocumento= $.trim($(noti2).attr("data-idDocumento"));
				var name = $.trim($(noti2).attr("data-name"));
			
			var dataActual = {};	

			dataActual.numBP = numBP;
			dataActual.idDocumento = idDocumento;
			dataActual.idRadicado = radicado;
			
			
			$.ajax({
				url : ACC.descargaAnexoPDFBuzon,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					
					if(dataResponse != null || dataResponse != ""){
				var pdf = 'data:application/newpdf;base64,'+ dataResponse;
				 var dlnk = document.getElementById('dwnldLnk');
				  dlnk.href = pdf;
				  dlnk.click(); 
					}else{
						alert("Error procesar la solicitud de descarga de Anexo");
					}
			   
				}
			,
				error : function() {

					alert("Error procesar la solicitud de descarga de Anexo");	
				}
			});

},


descargarNoti1_v2 : function(objectNoti){
	ACC.publicidadexterior.bindDataTable_ID_refresh("#tabPaginacion2");
	ACC.publicidadexterior.bindDataTable_ID_refresh("#tabPaginacion3");	
	
		var radicado = $.trim($(objectNoti).attr("data-idRadicado")); 
			var numBP= $.trim($(objectNoti).attr("data-numBP")); 
			var idDocumento= $.trim($(objectNoti).attr("data-idDocumento"));
				var name = $.trim($(objectNoti).attr("data-name"));
			
			var dataActual = {};	

			dataActual.numBP = numBP;
			dataActual.idDocumento = idDocumento;
			dataActual.idRadicado = radicado;
			
			
			$.ajax({
				url : ACC.descargaAnexoPDFBuzon,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					
					if(dataResponse != null || dataResponse != ""){
				var pdf = 'data:application/newpdf;base64,'+ dataResponse;
				 var dlnk = document.getElementById('dwnldLnk');
				  dlnk.href = pdf;
				  dlnk.click(); 
//		objectNoti.offsetParent.parentNode.remove();
	$('#tabPaginacion3').append('<tr><td>' + name + '</td><td>' + idDocumento + '</td><td>' +'</td><td>' +'</td><td><label class="control-label download2Noti" style="text-transform: capitalize !important" data-pdfimprimir='+ pdf +' id="download2Noti" onclick="downloaddosNoti(this)"> <span class="glyphicon glyphicon-download-alt"></span></label></td></tr>');

					}else{
						alert("Error procesar la solicitud de descarga de Anexo");
					}
			   
				}
			,
				error : function() {

					alert("Error procesar la solicitud de descarga de Anexo");	
				}
			});

	

	
	
	

	ACC.publicidadexterior.bindDataTable_id("#tabPaginacion2");
	ACC.publicidadexterior.bindDataTable_id("#tabPaginacion3");
	
}
	
};