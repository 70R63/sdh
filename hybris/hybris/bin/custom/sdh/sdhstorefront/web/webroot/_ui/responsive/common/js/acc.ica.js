ACC.ica = {

	 _autoload: [ "bindCalculoButton","bindPresentarDeclaracionButton","bindDialogICA"],
	 
	
	 
	 
	 bindCalculoButton: function () {
		 $(document).on("click", "#icaCalculoButton", function (e) {
	 	        e.preventDefault();
	 	        
	 	        $("#icaCalculoButton").prop('disabled', true);
	 	       var data = {};
	 	       
			 	 data.numObjeto="00030000000000000220";
			 	 data.numForm="030000000334";
			 	 data.anoGravable="2018";
			 	 data.periodo="";
			 	 data.numBP="6212";
			 	 data.cantEstablec="2";
			 	 data.entFinanciera="";
			 	 data.impuestoAviso="";
			 	 data.totalIngrPeriodo="";
			 	 data.valorPagar="";
			 	 data.checkAporte="";
			 	 data.proyectoAporte="";
			 	 data.tarifaAporte="";
	 	
	 	      $.ajax({
		            url: ACC.icaDeclaracionCalculoURL,
		            data: data,
		            type: "POST",
		            success: function (data) {
		            	if(data.errores)
	            		{
		            		$( "#dialogICA" ).dialog( "open" );
		            		$("#icaDialogContent").html("Error");
//		            		$.each(data.errores, function( index, value ) {
//    	            			$("#publicidadExteriorDialogContent").html($("#publicidadExteriorDialogContent").html()+value.txtmsj+"<br>");
//    	            		});
//		            		
//		            		$("#impCar").val("");
//	            			$("#valsan").val("");
//	            			$("#valpag").val("");
//	            			$("#intmora").val("");
//	            			$("#totpag").val("");
//	            			$("#numForm").val("");
//	            			
//	            			$('#generaDeclaracionButton').prop("disabled", true);
//		            		alert("error");
		            		
	            		}else
	            		{
	            			$( "#dialogICA" ).dialog( "open" );
	            			$("#icaDialogContent").html("El cálculo se ha realizado exitosamente.")
	            			
//	            			$("#impCar").val(data.impCargo);
//	            			$("#valsan").val(data.vlrSancion);
//	            			$("#valpag").val(data.vlrPagar);
//	            			$("#intmora").val(data.interesMora);
//	            			$("#totpag").val(data.totalPagar);
//	            			$("#numForm").val(data.numForm);
//	            			
//	            			$('#generaDeclaracionButton').prop("disabled", false);
//	            			alert("exito!");
	            		}
	 	      		
		            },
		            error: function () {
//		            	$( "#dialogPublicidadExterior" ).dialog( "open" );
//		            	$("#publicidadExteriorDialogContent").html("");
//		            	$("#publicidadExteriorDialogContent").html("Hubo un error al realizar el cálculo, por favor intentalo más tarde");
//		            	$("#impCar").val("");
//            			$("#valsan").val("");
//            			$("#valpag").val("");
//            			$("#intmora").val("");
//            			$("#totpag").val("");
//            			$("#numForm").val("");
            			$("#icaCalculoButton").prop('disabled', false);
		            }
		        });
	 	       
		 });
	 },
	 
	 bindPresentarDeclaracionButton: function () {
		 $(document).on("click", "#icaPresentarDeclaracionButton", function (e) {
	 	        e.preventDefault();
	 	       $("#icaPresentarDeclaracionButton").prop('disabled', true);
	 	       var numForm  = $.trim($("#numForm").val());
	 		 	 
	 	       var data = {};
	 	       
	 	       data.numForm=numForm;
	 	
	 	      $.ajax({
		            url: ACC.generaDeclaracionURL,
		            data: data,
		            type: "POST",
		            success: function (data) {
		            	$( "#dialogICA" ).dialog( "open" );
		            	if(data.errores)
	            		{
		            		$("#icaDialogContent").html("");
		            		$.each(data.errores, function( index, value ) {
    	            			$("#icaDialogContent").html($("#icaDialogContent").html()+value.txtmsj+"<br>");
    	            		});
		            		
		            		$("#icaPresentarDeclaracionButton").prop('disabled', false);
	            		}else
	            		{
	            			$("#icaDialogContent").html("");
	            			$("#dialogICA").html("La declaración se ha generado exitosamente.")
	            			
	            			$("#downloadHelper").attr("href",data.urlDownload);
	            			document.getElementById("downloadHelper").click();
	            			$("#icaPresentarDeclaracionButton").prop('disabled', false);
	            		}
	 	      		
		            },
		            error: function () {
		            	$( "#dialogICA" ).dialog( "open" );
		            	$("#icaDialogContent").html("Hubo un error al generar la declaración, por favor intentalo más tarde");
		            	$("#icaPresentarDeclaracionButton").prop('disabled', false);
		            }
		        });
	 	       
		 });
	 },
	 
	    
    
    
    
	    bindDialogICA: function(){
    	
    	$( "#dialogICA" ).dialog({ 
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