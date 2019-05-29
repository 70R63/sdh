ACC.reteica = {

	 _autoload: ["bindGeneraDeclaracionReteICAButton","bindActualizarButton","bindDownloadTemplateButton", "bindCargarButton","bindDialogReteICA","bindAnoGravable"],
	 
	 
	 bindGeneraDeclaracionReteICAButton: function () {
		 $(document).on("click", "#generaDeclaracionReteICAButton", function (e) {
	 	        e.preventDefault();
	 	        
	 	       var numForm  = $.trim($("#numForm").val());
	 	 
	 	       var data = {};
	 	       
	 	       data.numForm=numForm;
	 	
	 	      $.ajax({
		            url: ACC.reteICAGeneraDeclaracionURL,
		            data: data,
		            type: "POST",
		            success: function (data) {
		            	$( "#dialogReteICA" ).dialog( "open" );
		            	if(data.errores)
	            		{
		            		$("#reteICADialogContent").html("");
		            		$.each(data.errores, function( index, value ) {
    	            			$("#reteICADialogContent").html($("#reteICADialogContent").html()+value.txtmsj+"<br>");
    	            		});
		            		
		            		
	            		}else
	            		{
	            			$("#reteICADialogContent").html("");
	            			$("#reteICADialogContent").html("La declaración se ha generado exitosamente.")
	            			
	            			$("#downloadReteICADeclaracionHelper").attr("href",data.urlDownload);
	            			document.getElementById("downloadReteICADeclaracionHelper").click();
	            		}
	 	      		
		            },
		            error: function () {
		            	$( "#dialogPublicidadialogReteICAdExterior" ).dialog( "open" );
		            	$("#reteICADialogContent").html("Hubo un error al generar la declaración, por favor intentalo más tarde");
		            }
		        });
	 	       
		 });
	 },
	 
	 bindActualizarButton: function(){
		 $(document).on("click", "#actualizarButton", function (e) {
			 e.preventDefault();
			 
			 var valorPagar =  $.trim( $("#totalPagar").val());
			 
			 if(valorPagar == "")
			 {
				 $( "#dialogReteICA" ).dialog( "open" );
	  	 		$("#reteICADialogContent").html("");
	  	 		$("#reteICADialogContent").html("Por favor introduzca un total a pagar");
	  	 		
	  	 		return;
			 }
			 
			 var numForm =  $.trim( $("#numForm").val());
			 
			 if(numForm == "")
			 {
				 $( "#dialogReteICA" ).dialog( "open" );
	  	 		$("#reteICADialogContent").html("");
	  	 		$("#reteICADialogContent").html("No se ha encontrado NumForm, por favor actualice nuevamente");
	  	 		
	  	 		return;
			 }
			 
			 var data = {};
			 
			 data.numForm = numForm;
			 data.valorPagar = valorPagar;
			 
			 
			 $.ajax({
		    	  url: ACC.reteICACalculoURL,
		            data: data,
		            type: "POST",
		            success: function (data) {
		            	if(!data.errores)
		            	{
			            	$("#baseReten").val(data.infoDeclara.baseReten)
			            	$("#totalRetePer").val(data.infoDeclara.totalRetePer)
			            	$("#descDevol").val(data.infoDeclara.descDevol)
			            	$("#totalReteDecl").val(data.infoDeclara.totalReteDecl)
			            	$("#sancion").val(data.infoDeclara.sancion)
			            	$("#totalSaldo").val(data.infoDeclara.totalSaldo)
			            	$("#valorPagar").val(data.infoDeclara.valorPagar)
			            	$("#interesMora").val(data.infoDeclara.interesMora)
			            	$("#totalPagar").val(data.infoDeclara.totalPagar)
			            	
			            	$("#numForm").val(data.numForm)
		            		
			            	$( "#dialogReteICA" ).dialog( "open" );
			     	 		$("#reteICADialogContent").html("");
			     	 		$("#reteICADialogContent").html("Calculo realizado exitosamente");
		            		
		            	}else
		            	{
		            		$( "#dialogReteICA" ).dialog( "open" );
		            		$("#reteICADialogContent").html("");
	    	            	$.each(data.errores,function (index, value)
	    	            	{
	    	            		$("#reteICADialogContent").html($("#reteICADialogContent").html()+"<br>"+value.txtmsj);
	    	            	});
		            	}
		            },
		            error: function () {
		            	 $( "#dialogReteICA" ).dialog( "open" );
		     	 		$("#reteICADialogContent").html("");
		     	 		$("#reteICADialogContent").html("Error al realizar el calculo, por favor intelo nuevamente más tarde.");
		            }
		        });
			});
	 },
	 
	 bindDownloadTemplateButton: function(){
		
		 $(document).on("click", "#downloadTemplateButton", function (e) {
			 e.preventDefault();
			 
			 $("#reteICADownloadHelper").attr("href",ACC.reteICADownloadTemplate);
			 document.getElementById("reteICADownloadHelper").download = "Ayuda Rete ICA -Hybris.xlsm";
			 document.getElementById("reteICADownloadHelper").click();
 			
	 	       
		 });
		 
	 },
	 
	 bindAnoGravable: function(){
	    	
	    	$( document ).on("change","#anoGravable",function(e) {
	    		
	    		var anoGravable =  $.trim( $("#anoGravable").val());
	    		
	    		if(anoGravable != "")
    			{
	    			$("#edoCargasForm").submit();
    			}
	    		
	    	});
	    	
	    	
	    	},
	 
	 bindCargarButton: function(){
		 
		 
		 
		 $(document).on("click", "#bindCargarButton", function (e) {
			 e.preventDefault();
			 
			 var formData = new FormData();
			 
			 var anoGravable = $.trim( $("#anoGravable").val());
			 
			 if(anoGravable == "")
			 {
				 $( "#dialogReteICA" ).dialog( "open" );
     	 		$("#reteICADialogContent").html("");
     	 		$("#reteICADialogContent").html("Por favor seleccione un año");
     	 		
     	 		return;
			 }
				 
			 var periodo = $.trim( $("#periodo").val());
			 
			 if(periodo == "")
			 {
				 $( "#dialogReteICA" ).dialog( "open" );
     	 		$("#reteICADialogContent").html("");
     	 		$("#reteICADialogContent").html("Por favor seleccione un periodo");
     	 		
     	 		return;
			 }
			 
			 
			 if(!($("#retencionesFile").prop('files')[0].name.indexOf(".txt") != -1) && !($("#retencionesFile").prop('files')[0].name.indexOf(".TXT") != -1))
			 {
				 $( "#dialogReteICA" ).dialog( "open" );
	     	 		$("#reteICADialogContent").html("");
	     	 		$("#reteICADialogContent").html("Tipo de archivo no permitido");
	     	 		
	     	 		return;
			 }
			 
			 var taxNumber = "04";
			 var fileName = $("#retencionesFile").prop('files')[0].name;
			 
			 if(fileName.length-4 != 21 || fileName.substring(0,2) != taxNumber || fileName.substring(2,6) != anoGravable || fileName.substring(6,8) != periodo || fileName.substring(8,19)  != ACC.customerNIT)
			 {
				 $( "#dialogReteICA" ).dialog( "open" );
	     	 		$("#reteICADialogContent").html("");
	     	 		$("#reteICADialogContent").html("Nombre de archivo no válido");
	     	 		
	     	 		return;
			 }
			 
			 var data = {};
			 
			 data.fileName = fileName;
			 data.anoGravable = anoGravable;
			 data.periodo = periodo;
			 
			 
			 $.ajax({
	 	    	  url: ACC.reteICAValidaArchivoURL,
		            data: data,
		            type: "POST",
		            success: function (data) {
		            	
		            	if(data.allowFileUpload == true && data.requestCofirmation == false)
	            		{
		            		ACC.reteica.uploadFile();
	            		}else if(data.allowFileUpload == true && data.requestCofirmation == true)
            			{
	            			$( "#dialogConfirmReteICA" ).dialog( "open" );
		            		$("#reteICADialogConfirmContent").html("");
	    	            	$.each(data.errores,function (index, value)
	    	            	{
	    	            		$("#reteICADialogConfirmContent").html($("#reteICADialogConfirmContent").html()+"<br>"+value.txtmsj);
	    	            	});
            			}if(data.allowFileUpload == false)
            			{
            				$( "#dialogReteICA" ).dialog( "open" );
    	            		$("#reteICADialogContent").html("");
        	            	$.each(data.errores,function (index, value)
        	            	{
        	            		$("#reteICADialogContent").html($("#reteICADialogContent").html()+"<br>"+value.txtmsj);
        	            	});
            			}
		            	
		            },
		            error: function () {
		            	 $( "#dialogReteICA" ).dialog( "open" );
		     	 		$("#reteICADialogContent").html("");
		     	 		$("#reteICADialogContent").html("Cargar Archivo Fallida!");
		            }
		        });
			 
			 
	 	       
		 });
			 
			 
			
		 
	 },
	 
	 
	 uploadFile: function(){
		 
		 var formData = new FormData();
		 
		 var anoGravable = $.trim( $("#anoGravable").val());
		 var periodo = $.trim( $("#periodo").val());
		 
		 formData.append("retencionesFile",$("#retencionesFile").prop('files')[0]); 
		 formData.append("retencionesForm",new Blob([JSON.stringify({
                "anoGravable": anoGravable,
                "periodo": periodo                    
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
	            	
	            	if(!data.errores)
	            	{
		            	$( "#dialogReteICA" ).dialog( "open" );
		     	 		$("#reteICADialogContent").html("");
		     	 		$("#reteICADialogContent").html("Carga Archivo Exitosa!");
	            	}else
	            	{
	            		$( "#dialogReteICA" ).dialog( "open" );
	            		$("#reteICADialogContent").html("");
    	            	$.each(data.errores,function (index, value)
    	            	{
    	            		$("#reteICADialogContent").html($("#reteICADialogContent").html()+"<br>"+value.txtmsj);
    	            	});
	            	}
	            	
	            },
	            error: function () {
	            	 $( "#dialogReteICA" ).dialog( "open" );
	     	 		$("#reteICADialogContent").html("");
	     	 		$("#reteICADialogContent").html("Cargar Archivo Fallida!");
	            }
	        });
		 
		 
	 }
	 
	 ,
	
	 
	    
    
    
    
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
    	
    	$( "#dialogConfirmReteICA" ).dialog({ 
    		autoOpen: false, 
    		modal: true,
			 draggable: false,
			 buttons: {
			        "Si": function() {
			          $( this ).dialog( "close" );
			          ACC.reteica.uploadFile();
			        },
			        Cancel: function() {
			          $( this ).dialog( "close" );
			        }
			      }
    	});
    	
    }

    

};