ACC.gasolina = {

	 _autoload: ["bindGeneraDeclaracionButton","bindDialogGasolina","bindProductClass"],
	 
	 bindProductClass: function () {
		 $(document).on("change", ".form-control-gasolina", function (e) {
	 	        
			 var productClass = $(this).val();
			 var alcoholCarbID = $(this).attr("id").replace("claseProd","alcoholCarbu");
			 
			 if(productClass == "01" || productClass == "03")
			 {
				 $(document.getElementById(alcoholCarbID)).attr("readonly",true);
				 $(document.getElementById(alcoholCarbID)).val("0.00");
			 }else{
				 $(document.getElementById(alcoholCarbID)).attr("readonly",false);
			 }
			 
	 	       
		 });
	 },
	 
	 bindGeneraDeclaracionButton: function () {
		 $(document).on("click", "#gasolinaGeneraDeclaracionButton", function (e) {
	 	        e.preventDefault();
	 	        
	 	       var numForm  = $.trim($("#numForm").val());
	 	 
	 	       var data = {};
	 	       
	 	       data.numForm=numForm;
	 	
	 	      $.ajax({
		            url: ACC.gasolinaGeneraDeclaracionURL,
		            data: data,
		            type: "GET",
		            success: function (data) {
		            	$( "#dialogGasolina" ).dialog( "open" );
		            	if(data.errores)
	            		{
		            		$("#gasolinaDialogContent").html("");
		            		$.each(data.errores, function( index, value ) {
    	            			$("#gasolinaDialogContent").html($("#gasolinaDialogContent").html()+value.txtmsj+"<br>");
    	            		});
		            		
		            		
	            		}else
	            		{
	            			$("#gasolinaDialogContent").html("");
	            			$("#gasolinaDialogContent").html("La declaración se ha generado exitosamente.")
							$("#gasolinaDialogContent").html($("#gasolinaDialogContent").html()+ "<br><br>" +
							"Recuerda que la obligación del Impuesto de Sobretasa  a la Gasolina, solo se " +
							"culmina al momento en que se termine y se admita de manera exitosa el pago en línea.<br>" )
							
	            			
	            			$("#downloadHelper").attr("href",data.urlDownload);
	            			
	            			document.getElementById("downloadHelper").click();
	            			
	            		}
	 	      		
		            },
		            error: function () {
		            	$( "#dialogGasolina" ).dialog( "open" );
		            	$("#gasolinaDialogContent").html("Hubo un error al generar la declaración, por favor inténtalo más tarde");
		            }
		        });
	 	       
		 });
	 },
	 
	
    
	    bindDialogGasolina: function(){
    	
    	$( "#dialogGasolina" ).dialog({ 
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