ACC.gasolina = {

	 _autoload: ["bindGeneraDeclaracionButton","bindDialogGasolina","bindProductClass","bindPresentarDeclaracionButton"],
	 
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
				ACC.spinner.show();
	 	       var numForm  = $.trim($("#numForm").val());
	 	       var data = {};
	 	       data.numForm=numForm;
	 	
	 	      $.ajax({
		            url: ACC.gasolinaGeneraDeclaracionURL,
		            data: data,
		            type: "GET",
		            success: function (data) {
						
						ACC.spinner.close();
		            	$( "#dialogGasolina" ).dialog( "open" );
		            	if(data.errores && ( data.errores[0].idmsj != 0 ))
	            		{
		            		$("#gasolinaDialogContent").html("");
		            		$.each(data.errores, function( index, value ) {
    	            			$("#gasolinaDialogContent").html($("#gasolinaDialogContent").html()+value.txtmsj+"<br>");
    	            		});
		            		
		            		
	            		}else
	            		{
	            			$("#gasolinaDialogContent").html("");
	            			$("#gasolinaDialogContent").html("La Declaración se ha presentado correctamente.")
							$("#gasolinaDialogContent").html($("#gasolinaDialogContent").html()+ "<br><br>" +
							"Recuerda que la obligación del Impuesto de Sobretasa  a la Gasolina, solo se " +
							"culmina al momento en que se termine y se admita de manera exitosa el pago en línea.<br>" )
							
	            			
	            			$("#downloadHelper").attr("href",data.urlDownload);
	            			
	            			document.getElementById("downloadHelper").click();
	            			document.getElementById("pagar").disabled = false;
	            			$(".pagarbtn").attr("disabled", false);
	            			
	            		}
	 	      		
		            },
		            error: function () {
						
						
						ACC.spinner.close();
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
    	
    },


	 bindPresentarDeclaracionButton: function () {
		 $(document).on("click", "#presentarDeclaracionButton_0005", function (e) {
	 	        e.preventDefault();

			  var irDeclaracion = false;
	 	        
	 	      var anoGravable  = $.trim($("#anoGravable").val());
	 	      var periodo =  $("#periodo").val();
	 	      var tipoValla = $("#selectedTipoValla").val();

	 	      if(anoGravable == "0")
	 	        {
	 	        	alert("Por favor, selecciona el año a consultar");
	 	        	return;
	 	        }

	 	        if(periodo == "" || periodo == "")
	 	        {
	 	        	alert("Por favor, selecciona el impuesto a consultar");
	 	        	return;
	 	        }

	 	        var opcUso = $.trim($("#opcionUsoHidden").val());
                opcUso = opcUso.replace(" ", "");
                opcUso = opcUso.split("-")[0];

	 	        if(opcUso == '02'){
                    var response = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
                    if (response == true) {
						irDeclaracion = true;
                    } else {
                      return;
                    }
	 	        }else{
					irDeclaracion = true;
	 	        }

				if(irDeclaracion == true){
					var botonAction = document.getElementById("action");
					botonAction.click();
				}
	 	 });
	 },

    

};