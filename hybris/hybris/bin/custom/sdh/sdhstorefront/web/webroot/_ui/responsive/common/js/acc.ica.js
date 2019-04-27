ACC.ica = {

	 _autoload: [ "bindCalculoButton","bindPresentarDeclaracionButton","bindDialogICA"],
	 
	
	 
	 
	 bindCalculoButton: function () {
		 $(document).on("click", "#icaCalculoButton", function (e) {
	 	        e.preventDefault();
	 	        
	 	        $("#icaCalculoButton").prop('disabled', true);
	 	       var icaCalculaDeclaracionForm = {};
	 	       
				icaCalculaDeclaracionForm.numObjeto=$.trim($("#numObjeto").val());
				icaCalculaDeclaracionForm.numForm=$.trim($("#numForm").val());
				icaCalculaDeclaracionForm.anoGravable=$.trim($("#anoGravable").val());
				icaCalculaDeclaracionForm.periodo=$.trim($("#periodo").val());
				icaCalculaDeclaracionForm.cantEstablec=$.trim($("#cantEstablec").val());
				icaCalculaDeclaracionForm.entFinanciera=$.trim($("#entFinanciera").val());
				icaCalculaDeclaracionForm.impuestoAviso=$.trim($("#impuestoAviso").val());
				icaCalculaDeclaracionForm.totalIngrPeriodo=$.trim($("#totalIngrPeriodo").val());
				icaCalculaDeclaracionForm.valorPagar=$.trim($("#valorPagar").val());
				icaCalculaDeclaracionForm.checkAporte=$.trim($("#checkAporte").val());
				icaCalculaDeclaracionForm.proyectoAporte=$.trim($("#proyectoAporte").val());
				icaCalculaDeclaracionForm.tarifaAporte=$.trim($("#tarifaAporte").val());
			 	 
			 	var ingFueraBog = new Array();
			 	 
			 	 $.each($(".actvifuera"),function(index,value){
	    	        	
	    	        	var codCIIU = $.trim($(value).find(".codCIIU").val());
	    	        	var codMunicipio = $.trim($(value).find(".codMunicipio").val());
	    	        	var ingresos = $.trim($(value).find(".ingresos").val());
	    	        	
	    	        	if(codCIIU != "" && codMunicipio != ""&& ingresos != "")
	    	        	{
		    	        	var eachIngreso=new Object();
		    	        	
		    	        	eachIngreso.codCIIU = codCIIU;
		    	        	eachIngreso.codMunicipio = codMunicipio;
		    	        	eachIngreso.ingresos = ingresos;
		    	        	
		    	        	ingFueraBog.push(eachIngreso);
		    	        	
		    	        	
	    	        	}
	    	        	
	    	        });
			 	 
			 	icaCalculaDeclaracionForm.ingFueraBog=JSON.stringify(ingFueraBog);
			 	
			 	
			 	var ingNetosGrava = new Array();
			 	 
			 	 $.each($(".totaluno"),function(index,value){
	    	        	
			 		 	var actPrincipalChecked =  $(value).find(".actPrincipal").prop("checked");
			 		 	var actPrincipal = "";
			 		 	if(actPrincipalChecked == true)
			 		 	{
			 		 		actPrincipal ="X";
			 		 	}
			 		 		
	    	        	var codCIIU = $.trim($(value).find(".codCIIU").val());
	    	        	var ingresos = $.trim($(value).find(".ingresos").val());
	    	        	
	    	        	if(codCIIU != "" && ingresos != "")
	    	        	{
		    	        	var eachIngreso=new Object();
		    	        	
		    	        	eachIngreso.actPrincipal = actPrincipal;
		    	        	eachIngreso.codCIIU = codCIIU;
		    	        	eachIngreso.ingresos = ingresos;
		    	        	
		    	        	ingNetosGrava.push(eachIngreso);
		    	        	
		    	        	
	    	        	}
	    	        	
	    	        });
			 	 
			 	icaCalculaDeclaracionForm.ingNetosGrava=JSON.stringify(ingNetosGrava);
			 	
			 	
			 	
			 	
			 	var ingPorCIIU = new Array();
			 	 
			 	 $.each($(".totaldos"),function(index,value){
	    	        	
			 		 	
			 		 		
			 		var anoGravable=$.trim($(value).find(".anoGravable").val());
			 		var tipoID=$.trim($(value).find(".tipoID").val());
			 		var numID=$.trim($(value).find(".numID").val());
			 		var razonSocial=$.trim($(value).find(".razonSocial").val());
			 		var direccion=$.trim($(value).find(".direccion").val());
			 		var telefono=$.trim($(value).find(".telefono").val());
			 		var codCIIU=$.trim($(value).find(".codCIIU").val());
			 		var ingBrutoSINIVA=$.trim($(value).find(".ingBrutoSINIVA").val());
			 		var valorTotalDevol=$.trim($(value).find(".valorTotalDevol").val());

	    	        	
	    	        	if(anoGravable != "" && tipoID != "" && numID != "" && razonSocial != "" && direccion != "" && telefono != "" && codCIIU != "" && ingBrutoSINIVA != "" && valorTotalDevol != "")
	    	        	{
		    	        	var eachIngreso=new Object();
		    	        	
		    	        	eachIngreso.anoGravable=anoGravable;
		    	        	eachIngreso.tipoID=tipoID;
		    	        	eachIngreso.numID=numID;
		    	        	eachIngreso.razonSocial=razonSocial;
		    	        	eachIngreso.direccion=direccion;
		    	        	eachIngreso.telefono=telefono;
		    	        	eachIngreso.codCIIU=codCIIU;
		    	        	eachIngreso.ingBrutoSINIVA=ingBrutoSINIVA;
		    	        	eachIngreso.valorTotalDevol=valorTotalDevol;
		    	        	
		    	        	ingPorCIIU.push(eachIngreso);
		    	        	
		    	        	
	    	        	}
	    	        	
	    	        });
			 	 
			 	icaCalculaDeclaracionForm.ingNetosGrava=JSON.stringify(ingPorCIIU);
			 	
			 	var valorRetenido = new Array();
			 	 
			 	 $.each($(".valor"),function(index,value){
	    	        	
			 		 	
			 		 		
			 		var anoGravable=$.trim($(value).find(".anoGravable").val());
			 		var tipoID=$.trim($(value).find(".tipoID").val());
			 		var numID=$.trim($(value).find(".numID").val());
			 		var razonSocial=$.trim($(value).find(".razonSocial").val());
			 		var codMunicipio=$.trim($(value).find(".codMunicipio").val());
			 		var direccion=$.trim($(value).find(".direccion").val());
			 		var telefono=$.trim($(value).find(".telefono").val());
			 		var tarifaApl=$.trim($(value).find(".tarifaApl").val());
			 		var montoRetenido=$.trim($(value).find(".montoRetenido").val());

	    	        	
	    	        	if(anoGravable != "" && tipoID != "" && numID != "" && razonSocial != "" && direccion != "" && telefono != "" && codMunicipio != "" && tarifaApl != "" && montoRetenido != "")
	    	        	{
		    	        	var eachIngreso=new Object();
		    	        	
		    	        	eachIngreso.anoGravable=anoGravable;
		    	        	eachIngreso.tipoID=tipoID;
		    	        	eachIngreso.numID=numID;
		    	        	eachIngreso.razonSocial=razonSocial;
		    	        	eachIngreso.direccion=direccion;
		    	        	eachIngreso.telefono=telefono;
		    	        	eachIngreso.codMunicipio=codMunicipio;
		    	        	eachIngreso.tarifaApl=tarifaApl;
		    	        	eachIngreso.montoRetenido=montoRetenido;
		    	        	
		    	        	valorRetenido.push(eachIngreso);
		    	        	
		    	        	
	    	        	}
	    	        	
	    	        });
			 	 
			 	icaCalculaDeclaracionForm.valorRetenido=JSON.stringify(valorRetenido);
	 	
	 	
	 	      $.ajax({
		            url: ACC.icaDeclaracionCalculoURL,
		            data: icaCalculaDeclaracionForm,
		            type: "POST",
		            success: function (data) {
		            	if(data.errores)
	            		{
		            		$( "#dialogICA" ).dialog( "open" );
		            		$("#icaDialogContent").html("Error");
		            		$.each(data.errores, function( index, value ) {
    	            			$("#icaDialogContent").html($("#icaDialogContent").html()+value.txtmsj+"<br>");
    	            		});
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