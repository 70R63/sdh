ACC.delineacionurbana = {

	 _autoload: ["bindRetencioDelineacionButton","bindGeneraDeclaracionButton"],
	 
	
	 bindRetencioDelineacionButton: function () {
		 $(document).on("click", "#retenciondelibutton", function (e) {
	 	        e.preventDefault();
	 	        debugger;
	 	       
	 	      window.location.href = ACC.retencionDelineacionurbanaURL
	 	
	 	       
		 });
	 },
	 bindGeneraDeclaracionButton: function () {
		 $(document).on("click", "#declaradelibutton", function (e) {
	 	        e.preventDefault();
	 	        debugger;
	 	       
	 	       window.location.href = ACC.declaracionDelineacionurbanaURL
		  
	 	       
		 });
	 }
	 
	 
    	
    

    

};