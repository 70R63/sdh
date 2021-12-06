ACC.delineacionurbana = {

	 _autoload: ["bindRetencioDelineacionButton","bindGeneraDeclaracionButton", "bindTipoLicencia"],
	 
	
	 bindRetencioDelineacionButton: function () {
		 $(document).on("click", "#retenciondelibutton", function (e) {
	 	        e.preventDefault();
	 	  	 	       
	 	      window.location.href = ACC.retencionDelineacionurbanaURL;
	 	
	 	       
		 });
	 },
	 bindGeneraDeclaracionButton: function () {
		 $(document).on("click", "#declaradelibutton", function (e) {
	 	        e.preventDefault();
	
	 	       window.location.href = ACC.declaracionDelineacionurbanaURL;
		  
	 	       
		 });
	 },
	 
	 bindTipoLicencia: function (){
		 $(document).on("change", "#tipoDeLicencia", function(e){
			 e.preventDefault();
			 var tiplic = $.trim($("#tipoDeLicencia").val());
			 var valor = document.getElementById('infObjetoDelineacion.infoDeclara.valorEjecutado');
			 if(tiplic=="Reconocimiento" || tiplic=="02"){
				 valor.disabled = true;
				 valor.readonly=true;
				 
			 }else{
				 valor.disabled = false;
				 valor.readonly=false;
			 }
		 });
	 },


	agregarRegistro: function(elemento,infoElemento){
		
		var numRegistros = $("#"+infoElemento.divParent).children().length;
		if (numRegistros < 10000) {
			$(elemento).closest($("."+infoElemento.seccion)).parent().append($(elemento).closest($("."+infoElemento.seccion)).clone());

			var elementoHTML = $($("."+infoElemento.seccion)[numRegistros]).find('select');
			if(elementoHTML != null){
				$(elementoHTML).val("00");
				$(elementoHTML).attr("name", infoElemento.nombrePrefijoSelect+"[" + numRegistros + "]."+infoElemento.nombreSufijoSelect);
				$(elementoHTML).attr("id", infoElemento.nombrePrefijoSelect + numRegistros + "."+infoElemento.nombreSufijoSelect);
			}

			var elementoHTML = $($("."+infoElemento.seccion)[numRegistros]).find('input');
			if(elementoHTML != null){
				$(elementoHTML).val("");
				$(elementoHTML).attr("name", infoElemento.nombrePrefijoInput+"[" + numRegistros + "]." + infoElemento.nombreSufijoInput);
				$(elementoHTML).attr("id", infoElemento.nombrePrefijoInput + numRegistros + "." + infoElemento.nombreSufijoInput);
			}
			$($("."+infoElemento.seccion)[numRegistros]).css("display", "block");

		} else {
			alert("No puede agregar más registros");
		}
		
	},


	 borrarRegistro: function(elemento,infoElemento){
		
		var numRegistros = $("#"+infoElemento.divParent).children().length;
		if (numRegistros <= 10000 && numRegistros > 1) {
			$(elemento).closest($("." + infoElemento.seccion)).find("." + infoElemento.classSelect).val("00");
			$(elemento).closest($("." + infoElemento.seccion)).find("." + infoElemento.classInput).val("");
			$(elemento).closest($("." + infoElemento.seccion)).css("display", "none");

		} else if (numRegistros <= 1) {
			alert("No puede eliminar todos los registros");
		}
		
	},
	
	
	 obtenerInfoElemento: function(seccion){
		var infoElemento = {};

		
		switch (seccion){
		case "areasusos":
			infoElemento.nombrePrefijoSelect = "infObjetoDelineacion.usos";
			infoElemento.nombrePrefijoInput = "infObjetoDelineacion.usos";
			infoElemento.nombreSufijoSelect = "uso";
			infoElemento.nombreSufijoInput = "areaNeta";
			infoElemento.classSelect = "usoSelect";
			infoElemento.classInput = "usoInput";
			infoElemento.seccion = "areasusos";
			infoElemento.divParent = "divUsos";
			
			break;

		case "areausosdos":
			infoElemento.nombrePrefijoSelect = "infObjetoDelineacion.areaIntervenida";
			infoElemento.nombrePrefijoInput = "infObjetoDelineacion.areaIntervenida";
			infoElemento.nombreSufijoSelect = "areaInter";
			infoElemento.nombreSufijoInput = "aream2";
			infoElemento.classSelect = "intervenidaSelect";
			infoElemento.classInput = "intervenidaInput";
			infoElemento.seccion = "areausosdos";
			infoElemento.divParent = "divIntervenida";
			
			break;

		case "arearquitec":
			infoElemento.nombrePrefijoSelect = "infObjetoDelineacion.areaProyecto";
			infoElemento.nombrePrefijoInput = "infObjetoDelineacion.areaProyecto";
			infoElemento.nombreSufijoSelect = "areaProy";
			infoElemento.nombreSufijoInput = "aream2";
			infoElemento.classSelect = "areaProySelect";
			infoElemento.classInput = "areaProyInput";
			infoElemento.seccion = "arearquitec";
			infoElemento.divParent = "divArearquitec";
			
			break;
			
		}
		
		
		return infoElemento;
	}
	 
	 
    	
    

    

};