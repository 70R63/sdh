ACC.delineacionurbana = {

	 _autoload: ["bindRetencioDelineacionButton","bindGeneraDeclaracionButton", "bindTipoLicencia"],
	 
	
	 bindRetencioDelineacionButton: function () {
		 $(document).on("click", "#retenciondelibutton", function (e) {
	 	        e.preventDefault();
	 	        debugger;
	 	       
	 	      window.location.href = ACC.retencionDelineacionurbanaURL;
	 	
	 	       
		 });
	 },
	 bindGeneraDeclaracionButton: function () {
		 $(document).on("click", "#declaradelibutton", function (e) {
	 	        e.preventDefault();
	 	        debugger;
	 	       
	 	       window.location.href = ACC.declaracionDelineacionurbanaURL;
		  
	 	       
		 });
	 },
	 
	 bindTipoLicencia: function (){
		 $(document).on("change", "#tipoDeLicencia", function(e){
			 e.preventDefault();
			 debugger;
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
	 }
	 
	 
    	
    

    

};