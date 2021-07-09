ACC.aamenu = {

	 _autoload: ["updateMenuContrib"],


	 updateMenuContrib: function(){
		debugger;

		if(window.location.pathname.indexOf("retenedores") < 0 && ACC.flagFiltrarMenuContrib == true){
			
			
			$("a:contains('Mi Buzón')").closest("li").remove()
			$("a:contains('Impuestos')").closest("li").remove()
			$("a:contains('Trámites')").closest("li").remove()
			$("a:contains('Facturación')").closest("li").remove()
			$("a:contains('Declaraciones')").closest("li").remove()
//			$("a:contains('Consultas')").closest("li").remove()
			var objetoHref = null;
			var objetoInnerText = null;
			$("[href]").each(function() {
				objetoInnerText = $(this).text();
				if(objetoInnerText.trim() == "Consultas"){
					objetoHref = $(this).attr('href');
					if(objetoHref != null && objetoHref.indexOf("#") >= 0){
						$(this).closest("li").remove();
					}
				}
			});
		}
		
	 }
};