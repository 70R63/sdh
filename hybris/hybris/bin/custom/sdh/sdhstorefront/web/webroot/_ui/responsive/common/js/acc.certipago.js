ACC.certipago = {

		 _autoload: ["bindGenerarPDFButton", "bindDialog"],
		 
		 bindGenerarPDFButton: function () {
		        $(document).on("click", "#generarPDFButton", function (e) {
		    	        e.preventDefault();
		    	        
		    	        
		    	        debugger;
		    	      
		    	        var generarCertificacionData = {};
		    	        
		    	      
		    	        generarCertificacionData.impuesto = $.trim( $("#Idimp").val());
		    	        generarCertificacionData.anio = $.trim( $("#Idanio").val());
		    	        generarCertificacionData.periodo = $.trim( $("#Idper").val());
		    	       
   	        
			   	        $.ajax({
			   	            url: ACC.certificacionPagosGenerarURL,
			   	            data: generarCertificacionData,
			   	            type: "POST",
			   	            success: function (data) {
			        	        	$( "#dialog" ).dialog( "open" );
			        	        	
			    	            	
			   	            },
			   	            error: function () {
			   	            	$( "#dialog" ).dialog( "open" );
			    	            	$("#ritDialogContent").html("");
			   	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar su RIT, por favor intentalo mas tarde.");
			   	            }
			   	        });
		        });
		   },
		 
		   
   	 
        
    
    bindDialog: function(){
    	
    	$( "#dialog" ).dialog({ 
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