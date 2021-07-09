ACC.aaEntidadBancariaMenu = {
	 _autoload: ["updateAAEntidadBancariaMenu"],


	 updateAAEntidadBancariaMenu: function(){
		 debugger;
		if(ACC.aaEntidadBancariaMenuflagEjecutar == true){
			$("a:contains('Mi RIT')").closest("li").remove();
			$("a:contains('Mi Buzón')").closest("li").remove();
			$("a:contains('Impuestos')").closest("li").remove();
			$("a:contains('Trámites')").closest("li").remove();
			$("a:contains('Facturación')").closest("li").remove();
			$("a:contains('Declaraciones')").closest("li").remove();
//			$("a:contains('Consultas')").closest("li").remove()
			var objetoHREF = null;
			var objetoInnerText = null;
			$("[href]").each(function(value) {
				objetoHREF = $(this).attr('href');
				objetoInnerText = $(this).attr('innerText');
				if(objetoInnerText === undefined){
					objetoInnerText = $(this).text();	
				}
				if(objetoHREF != null && objetoHREF == "#" && objetoInnerText.indexOf("Consultas") >= 0){
					$(this).closest("li").remove();
				}
			});			
//			$("a:contains('Reportar Información')").closest("li").remove()
		}

	}
};