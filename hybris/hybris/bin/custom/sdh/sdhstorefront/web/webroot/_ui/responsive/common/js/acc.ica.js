ACC.publicidadexterior = {

	 _autoload: [ "bindCalculoButton","bindPresentarDeclaracionButton","bindDialogPublicidadExterior"],
	 
	
	 
	 
	 bindCalculoButton: function () {
		 $(document).on("click", "#icaCalculoButton", function (e) {
	 	        e.preventDefault();
	 	        
	 	        alert("Calcula!");
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
//		            		$( "#dialogPublicidadExterior" ).dialog( "open" );
//		            		$("#publicidadExteriorDialogContent").html("");
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
	            			$('#generaDeclaracionButton').prop("disabled", true);
		            		alert("error");
		            		
	            		}else
	            		{
//	            			$("#publicidadExteriorDialogContent").html("El cálculo se ha realizado exitosamente.")
	            			
//	            			$("#impCar").val(data.impCargo);
//	            			$("#valsan").val(data.vlrSancion);
//	            			$("#valpag").val(data.vlrPagar);
//	            			$("#intmora").val(data.interesMora);
//	            			$("#totpag").val(data.totalPagar);
//	            			$("#numForm").val(data.numForm);
//	            			
	            			$('#generaDeclaracionButton').prop("disabled", false);
	            			alert("exito!");
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
//		 $(document).on("click", "#presentarDeclaracionButton", function (e) {
//	 	        e.preventDefault();
//	 	        
//	 	       var anoGravable  = $.trim($("#anio").val());
//	 	       var numResolu =  $("#selectedNumRes").val();
//	 	      var tipoValla = $("#selectedTipoValla").val();
//	 	      
//	 	      if(anoGravable == "0")
//	 	        {	
//	 	        	alert("Por favor, selecciona el año a consultar");
//	 	        	return;
//	 	        }
//	 	        	
//	 	        if(numResolu == "" || numResolu == "")
//	 	        {
//	 	        	alert("Por favor, selecciona el impuesto a consultar");
//	 	        	return;
//	 	        }
//	 	       
//	 	      window.location.href = ACC.publicidadExteriorDeclararionURL+"?numResolu="+numResolu+"&anoGravable="+anoGravable+"&tipoValla="+tipoValla;
//	 	       
//		 });
	 },
	 
	    
    
    
    
	    bindDialogPublicidadExterior: function(){
    	
    	$( "#dialogPublicidadExterior" ).dialog({ 
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