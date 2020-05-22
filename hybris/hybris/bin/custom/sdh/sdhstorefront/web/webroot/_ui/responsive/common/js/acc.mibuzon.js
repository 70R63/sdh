ACC.mibuzon = {

	_autoload : [ "bindDescargar"],

	
	bindDescargar : function(objetodeN) {
//		$(document).on("click", ".download", function(e) {
//			e.preventDefault();
		
		
			debugger;
			var newpdf = $.trim($(objetodeN).attr("data-pdfimprimir"));
			var identif = $.trim($(objetodeN).attr("data-idRadicado")); 
			var autoridadEmisora= $.trim($(objetodeN).attr("data-autoridadEmisora")); 
			var asunto= $.trim($(objetodeN).attr("data-asunto"));
			var fecnot = $.trim($(objetodeN).attr("data-fechaNotificacion"));

				var pdf = 'data:application/newpdf;base64,'+ newpdf;
				 var dlnk = document.getElementById('dwnldLnk');
				  dlnk.href = pdf;
				  dlnk.click();
				  
			
				 // var newtr = $(objetodeN).closest('tr');
				  
					 $('#tabPaginacion1').append('<tr><td>' + identif + '</td><td>' + autoridadEmisora + '</td><td>' + asunto + '</td><td>' + fecnot + '</td><td><label class="control-label download2" style="text-transform: capitalize !important" data-pdfimprimir='+newpdf+' id="download2" onclick="downloaddos()"> <span class="glyphicon glyphicon-download-alt"></span></label></td><td><img src="/sdhstorefront/_ui/addons/sdhpsaddon/responsive/theme-psalpha/images/papeleraleidos.png" style="width: 20px"  onclick="eliminarleidos(this)" ></img></td><td style="visibility: hidden;">'+ newpdf +'</td</tr>');

					  $(objetodeN).closest('tr').remove();	 
				
//		});

	},
	
	bindDescargar2 : function(objetode) {	
			var newobjdes = objetode;
			debugger;
			var newpdf = $.trim($(newobjdes).attr("data-pdfimprimir"));

				
				var pdf = 'data:application/newpdf;base64,'+ newpdf;
				 var dlnk = document.getElementById('dwnldLnk');
				  dlnk.href = pdf;
				  dlnk.click();
			
	},
	
	bindPapeleraNuevos : function(objectf){
		
			debugger;
			
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
		  
		  
	
		  var newtr = $(this).closest('tr');
		  
			 $('#tabPaginacion3').append('<tr><td>' + identif + '</td><td>' + autoridadEmisora + '</td><td>' + asunto + '</td><td>' + fecnot + '</td><td><label class="control-label download2Noti" style="text-transform: capitalize !important" data-pdfimprimir='+ newpdf +' id="download2Noti" onclick="downloaddosNoti(this)"> <span class="glyphicon glyphicon-download-alt"></span></label></td></tr>');
	
},


descargarNoti2 : function(objectNoti2){
	
	var noti2 = objectNoti2;
	var newpdf = $.trim($(noti2).attr("data-pdfimprimir"));
	var pdf = 'data:application/newpdf;base64,'+ newpdf;
	 var dlnk = document.getElementById('dwnldLnk');
	  dlnk.href = pdf;
	  dlnk.click();

}
	
};