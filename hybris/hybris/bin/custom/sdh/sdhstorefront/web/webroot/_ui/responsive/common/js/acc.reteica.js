ACC.reteica = {

	 _autoload: [ "bindCargarButton","bindDialogReteICA"],
	 
	 
	 
	 bindCargarButton: function(){
		 
		 
		 
		 $(document).on("click", "#bindCargarButton", function (e) {
			 e.preventDefault();
			 
			 var formData = new FormData();
			 
//			 var jsonData = {};
//			 
//			 jsonData.anoGravable="2019";
//			 jsonData.periodo="Ene/Feb";
			 
			 formData.append("retencionesFile",$("#retencionesFile").prop('files')[0]); 
			 formData.append("retencionesForm",new Blob([JSON.stringify({
	                "anoGravable": "2019",
	                "periodo": "Ene/Feb"                    
	            })], {
	                type: "application/json"
	            }));
			 $.ajax({
	 	    	  url: ACC.reteICARegistroRetencionesURL,
		            data: formData,
		            type: "POST",
		            contentType: false,
		            processData: false ,
		            success: function (data) {
		            	
		            	 $( "#dialogReteICA" ).dialog( "open" );
		     	 		$("#reteICADialogContent").html("");
		     	 		$("#reteICADialogContent").html("Cargar Archivo Exitosa!");
	 	      		
		            },
		            error: function () {
		            	 $( "#dialogReteICA" ).dialog( "open" );
		     	 		$("#reteICADialogContent").html("");
		     	 		$("#reteICADialogContent").html("Cargar Archivo Fallida!");
		            }
		        });
	 	       
		 });
			 
			 
			
		 
	 } ,
	 
	
	 
	    
    
    
    
	    bindDialogReteICA: function(){
    	
    	$( "#dialogReteICA" ).dialog({ 
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