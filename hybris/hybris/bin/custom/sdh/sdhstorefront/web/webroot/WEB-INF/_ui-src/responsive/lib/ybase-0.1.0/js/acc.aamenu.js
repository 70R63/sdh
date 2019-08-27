ACC.aamenu = {

	 _autoload: ["updateAAMenu"],


	updateAAMenu: function(){


		if(ACC.aamenus.indexOf("ZM01") === -1)
		{
			$("a:contains('Mi RIT')").closest("li").remove()
		}
		if(ACC.aamenus.indexOf("ZM02") === -1)
		{
			$("a:contains('Mi Buzón')").closest("li").remove()
		}
		if(ACC.aamenus.indexOf("ZM03") === -1)
		{
			$("a:contains('Impuestos')").closest("li").remove()
		}
		if(ACC.aamenus.indexOf("ZM04") === -1)
		{
			$("a:contains('Trámites')").closest("li").remove()
		}
		if(ACC.aamenus.indexOf("ZM05") === -1)
		{
			$("a:contains('Facturación')").closest("li").remove()
		}
		if(ACC.aamenus.indexOf("ZM06") === -1)
		{
			$("a:contains('Declaraciones')").closest("li").remove()
		}
		if(ACC.aamenus.indexOf("ZM07") === -1)
		{
			$("a:contains('Consultas')").closest("li").remove()
		}

	}
};