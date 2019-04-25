ACC.conciliaciones = {

	 _autoload: ["bindConciliacionFile","bindDialogConciliaciones"],
	 
	
	 
	 bindConciliacionFile: function () {
		 $(document).on("change", "#conciliacionFile", function (e) {
	 	        
			 if(this.files[0].name.indexOf(".p7z") === -1)
			 {
				 $("#dialogConciliaciones").dialog( "open" );
				 $("#conciliacionesDialogContent").html("");
				 $("#conciliacionesDialogContent").html("Tipo de archivo inválido");
				 return;
			 }
			 
			 if(this.files[0].size/1024/1024/1024 > 2)
			 {
				 $("#dialogConciliaciones").dialog( "open" );
				 $("#conciliacionesDialogContent").html("");
				 $("#conciliacionesDialogContent").html("El tamaño de archivo excede el permitido");
			 }
			 
		 });
	 },
	 
	 bindDialogConciliaciones: function(){
	    	
	    	$( "#dialogConciliaciones" ).dialog({ 
	    		autoOpen: false, 
	    		modal: true,
				 draggable: false,
	    		buttons: {
	    			Ok: function() {
	    				$( this ).dialog( "close" );
	    			}
	    	    } 
	    	});
	 }
};