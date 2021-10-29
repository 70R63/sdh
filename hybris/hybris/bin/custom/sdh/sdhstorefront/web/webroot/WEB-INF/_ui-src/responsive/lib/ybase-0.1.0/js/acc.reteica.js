ACC.reteica = {

	 _autoload: ["bindGeneraDeclaracionReteICAButton","bindActualizarButton","bindDownloadTemplateButton", "bindCargarButton","bindDialogReteICA","bindReteICAAnoGravable","bindReteICAEDOAnoGravable","bindReteIcaRecargar"],
	 
	 bindReteIcaRecargar: function(){
		
		 $(document).on("click", ".reteICARecargar", function (e) {
	 	        e.preventDefault();   
	 	      var estado = $(this).attr("data-estado");
	 	      if(estado=="02")
 	    	  {
	 	    	 window.location.href = ACC.reteICARegistroRetencionesURL;
 	    	  }
	 	      
	 	      if(estado == "03"){
	 	    	 
	 	    	$( "#dialogConfirmActionReteICA" ).dialog( "open" );
	 	    	$("#reteICADialogConfirmActionContent").html("");
	 	    	$("#reteICADialogConfirmActionContent").html("Se realizara una nueva carga del año y periodo indicado, la carga anterior que realizaste se sobre escribirá y quedara como final la nueva que se realice.");
	 	      }
	 	    	  
	 	       if(estado == "04")
 	    	   {
	 	    	   $( "#dialogConfirmActionReteICA" ).dialog( "open" );
		 	    	$("#reteICADialogConfirmActionContent").html("");
		 	    	$("#reteICADialogConfirmActionContent").html("Se realizara una nueva carga del año y periodo indicado. Con esta carga podrás generar una declaración pero será una corrección, ya que en el sistema ya se cuenta con una declaración presentada.");
 	    	   }
		 });
		 
	 },
	 bindGeneraDeclaracionReteICAButton: function () {
		 $(document).on("click", "#generaDeclaracionReteICAButton", function (e) {
	 	        e.preventDefault();
	 	       ACC.spinner.show();
	 	       var numForm  = $.trim($("#numForm").val());
	 	 
	 	       var data = {};
	 	       
	 	       data.numForm=numForm;
	 	
	 	      $.ajax({
		            url: ACC.reteICAGeneraDeclaracionURL,
		            data: data,
		            type: "POST",
		            success: function (data) {
						ACC.spinner.close(); 
		            	$( "#dialogReteICA" ).dialog( "open" );
		            	if(data.errores && ( data.errores[0].idmsj != 0 ))
	            		{
		            		$("#reteICADialogContent").html("");
		            		$.each(data.errores, function( index, value ) {
    	            			$("#reteICADialogContent").html($("#reteICADialogContent").html()+value.txtmsj+"<br>");
    	            		});
		            		
		            		
	            		}else
	            		{
	            			$("#reteICADialogContent").html("");
	            			$("#reteICADialogContent").html("La Declaración se ha presentado correctamente.")
	            			
	            			$("#downloadReteICADeclaracionHelper").attr("href",data.urlDownload);
	            			document.getElementById("downloadReteICADeclaracionHelper").click();
							document.getElementById("pagar").disabled = false;
	            		}
	 	      		
		            },
		            error: function () {
						ACC.spinner.close(); 
		            	$( "#dialogPublicidadialogReteICAdExterior" ).dialog( "open" );
		            	$("#reteICADialogContent").html("Hubo un error al generar la declaración, por favor intentalo más tarde");
		            }
		        });
	 	       
		 });
	 },
	 
	 bindActualizarButton: function(){
		 $(document).on("click", "#actualizarButton", function (e) {
			 e.preventDefault();
			 ACC.spinner.show();
			 var valorPagar =  $.trim( $("#valorPagar").val());
			 
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
						ACC.spinner.close();
		            	if(!data.errores)
		            	{
		            		if(data.numForm == "")
		            		{
			            		$("#generaDeclaracionReteICAButton").attr("disabled",true);
		            		}else
		            		{
		            			$("#numForm").val(data.numForm);
		            			$("#generaDeclaracionReteICAButton").attr("disabled",false);
		            		}
		            		
		            		if(data.infoDeclara)
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
				            	
				            	$( "#dialogReteICA" ).dialog( "open" );
				     	 		$("#reteICADialogContent").html("");
				     	 		$("#reteICADialogContent").html("Calculo realizado exitosamente");
				     	 		
		            		}else
	            			{
		            			$( "#dialogReteICA" ).dialog( "open" );
				     	 		$("#reteICADialogContent").html("");
				     	 		$("#reteICADialogContent").html("Hubo un problema al realizar el cálculo, por favor intentelo más tarde.");
	            			}
		            	}else
		            	{
		            		$("#generaDeclaracionReteICAButton").attr("disabled",true);
		            		$( "#dialogReteICA" ).dialog( "open" );
		            		$("#reteICADialogContent").html("");
	    	            	$.each(data.errores,function (index, value)
	    	            	{
	    	            		$("#reteICADialogContent").html($("#reteICADialogContent").html()+"<br>"+value.txtmsj);
	    	            	});
		            	}
		            },
		            error: function () {
						ACC.spinner.close();
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
	 
	 bindReteICAEDOAnoGravable: function(){
	    	$( document ).on("change","#reteICAEDOAnoGravable",function(e) {
	    		var anoGravable =  $.trim( $("#reteICAEDOAnoGravable").val());
	    		
	    		if(anoGravable != "")
    			{
	    			$("#edoCargasForm").submit();
    			}
	    		
	    	});
	    	
	    	
	    	},
	    	
	    	bindReteICAAnoGravable: function(){
				
	 	    	
	 	    	$( document ).on("change","#reteICAAnoGravable",function(e) {
	 	    		var anoGravable =  $.trim( $("#reteICAAnoGravable").val());
	 	    		
	 	    		var currentYear = new Date().getFullYear()
	 	    		
	 	    		if(anoGravable == "")
	     			{
	 	    			$("#reteICAPeriodo").empty();
	     				
	     				var period00= new Option("SELECCIONAR", "");
	     				/// jquerify the DOM object 'o' so we can use the html method
	     				$(period00).html("SELECCIONAR");
	     				$("#reteICAPeriodo").append(period00);
	     			}
	 	    		else if(anoGravable == currentYear)
	     			{
	 	    			$("#reteICAPeriodo").empty();
	     				
	     				var period00= new Option("SELECCIONAR", "");
	     				/// jquerify the DOM object 'o' so we can use the html method
	     				$(period00).html("SELECCIONAR");
	     				$("#reteICAPeriodo").append(period00);
	     				var currentMonth = new Date().getMonth();
	     				var bimester = Math.floor(  (currentMonth + 1) / 2);
	     				
	     				if(bimester > 0)
	     				{
	     					var period01 = new Option("Enero - Febrero", "01");
		     				/// jquerify the DOM object 'o' so we can use the html method
		     				$(period01).html("Enero - Febrero");
		     				$("#reteICAPeriodo").append(period01);
	     				}
	     				
	     				if(bimester > 1)
	     				{
	     					var period02 = new Option("Marzo - Abril", "02");
		     				/// jquerify the DOM object 'o' so we can use the html method
		     				$(period02).html("Marzo - Abril");
		     				$("#reteICAPeriodo").append(period02);
	     				}
	     				
	     				if(bimester > 2)
	     				{
	     					var period03 = new Option("Mayo - Junio", "03");
		     				/// jquerify the DOM object 'o' so we can use the html method
		     				$(period03).html("Mayo - Junio");
		     				$("#reteICAPeriodo").append(period03);
	     				}
	     				
	     				if(bimester > 3)
	     				{
	     					var period04 = new Option("Julio - Agosto", "04");
		     				/// jquerify the DOM object 'o' so we can use the html method
		     				$(period04).html("Julio - Agosto");
		     				$("#reteICAPeriodo").append(period04);
	     				}
	     				
	     				if(bimester > 4)
	     				{
	     					var period05 = new Option("Septiembre - Octubre", "05");
		     				/// jquerify the DOM object 'o' so we can use the html method
		     				$(period05).html("Septiembre - Octubre");
		     				$("#reteICAPeriodo").append(period05);
	     				}
	     				
	     				if(bimester > 5)
	     				{
	     					var period06 = new Option("Noviembre - Diciembre", "06");
		     				/// jquerify the DOM object 'o' so we can use the html method
		     				$(period06).html("Noviembre - Diciembre");
		     				$("#reteICAPeriodo").append(period06);
	     				}
	     				
	     				
	     				
	     				
	     				
	     			}else
     				{
	     				$("#reteICAPeriodo").empty();
	     				
	     				var period00= new Option("SELECCIONAR", "");
	     				/// jquerify the DOM object 'o' so we can use the html method
	     				$(period00).html("SELECCIONAR");
	     				$("#reteICAPeriodo").append(period00);
	     				
	     				var period01 = new Option("Enero - Febrero", "01");
	     				/// jquerify the DOM object 'o' so we can use the html method
	     				$(period01).html("Enero - Febrero");
	     				$("#reteICAPeriodo").append(period01);
	     				
	     				var period02 = new Option("Marzo - Abril", "02");
	     				/// jquerify the DOM object 'o' so we can use the html method
	     				$(period02).html("Marzo - Abril");
	     				$("#reteICAPeriodo").append(period02);
	     				
	     				var period03 = new Option("Mayo - Junio", "03");
	     				/// jquerify the DOM object 'o' so we can use the html method
	     				$(period03).html("Mayo - Junio");
	     				$("#reteICAPeriodo").append(period03);
	     				
	     				var period04 = new Option("Julio - Agosto", "04");
	     				/// jquerify the DOM object 'o' so we can use the html method
	     				$(period04).html("Julio - Agosto");
	     				$("#reteICAPeriodo").append(period04);
	     				
	     				var period05 = new Option("Septiembre - Octubre", "05");
	     				/// jquerify the DOM object 'o' so we can use the html method
	     				$(period05).html("Septiembre - Octubre");
	     				$("#reteICAPeriodo").append(period05);
	     				
	     				var period06 = new Option("Noviembre - Diciembre", "06");
	     				/// jquerify the DOM object 'o' so we can use the html method
	     				$(period06).html("Noviembre - Diciembre");
	     				$("#reteICAPeriodo").append(period06);
     				}
	 	    		
	 	    	});
	 	    	
	 	    	
	 	    	},
	 
	 bindCargarButton: function(){
		 
		 
		 
		 $(document).on("click", "#bindCargarButton", function (e) {
			 e.preventDefault();
			ACC.spinner.show();		 
			 var formData = new FormData();
			 
			 var anoGravable = $.trim( $("#reteICAAnoGravable").val());
			 
			 if(anoGravable == "")
			 {
				 $( "#dialogReteICA" ).dialog( "open" );
     	 		$("#reteICADialogContent").html("");
     	 		$("#reteICADialogContent").html("Por favor seleccione un año");
     	 		
     	 		return;
			 }
				 
			 var periodo = $.trim( $("#reteICAPeriodo").val());
			 
			 if(periodo == "")
			 {
				ACC.spinner.close();
				 $( "#dialogReteICA" ).dialog( "open" );
     	 		$("#reteICADialogContent").html("");
     	 		$("#reteICADialogContent").html("Por favor seleccione un periodo");
     	 		
     	 		return;
			 }
			 
			 
			 if(!($("#retencionesFile").prop('files')[0].name.indexOf(".txt") != -1) && !($("#retencionesFile").prop('files')[0].name.indexOf(".TXT") != -1))
			 {
				ACC.spinner.close();
				 $( "#dialogReteICA" ).dialog( "open" );
	     	 		$("#reteICADialogContent").html("");
	     	 		$("#reteICADialogContent").html("Tipo de archivo no permitido");
	     	 		
	     	 		return;
			 }
			 
			 var taxNumber = "04";
			 var fileName = $("#retencionesFile").prop('files')[0].name;
			 var numIDesperado = ACC.reteica.formarNumIDEsperado();
			 
			 if(fileName.length-4 != 21 || fileName.substring(0,2) != taxNumber || fileName.substring(2,6) != anoGravable || fileName.substring(6,8) != periodo || fileName.substring(8,19)  != numIDesperado)
			 {
				ACC.spinner.close();
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
						ACC.spinner.close(); 	
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
						ACC.spinner.close();
		            	 $( "#dialogReteICA" ).dialog( "open" );
		     	 		$("#reteICADialogContent").html("");
		     	 		$("#reteICADialogContent").html("Cargar Archivo Fallida!");
		            }
		        });
			 
			 
	 	       
		 });
			 
			 
			
		 
	 },
	 
	 
	 
	 formarNumIDEsperado: function(){
		
		var customerNIT = $.trim( $("#customerNIT").val());
		var numIDformado = null;
		var longitudEsperada = 11;
		var numID = customerNIT;
		
		if(numID.length == longitudEsperada ){
			numIDformado = customerNIT;
		}else if(numID.length < longitudEsperada){
			do {
				numID = "0" + numID;
			}
		while (numID.length < longitudEsperada);
			numIDformado = numID;
		}
		 
		return numIDformado;
	 },
	 
	 
	 uploadFile: function(){
		 ACC.spinner.show();
		 var formData = new FormData();
		 
		 var anoGravable = $.trim( $("#reteICAAnoGravable").val());
		 var periodo = $.trim( $("#reteICAPeriodo").val());
		 
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
	            	ACC.spinner.close();
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
					ACC.spinner.close();
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
    	
    	$( "#dialogConfirmActionReteICA" ).dialog({ 
    		autoOpen: false, 
    		modal: true,
			 draggable: false,
			 buttons: {
			        "Si": function() {
			          $( this ).dialog( "close" );
			          window.location.href = ACC.reteICARegistroRetencionesURL;
			        },
			        Cancel: function() {
			          $( this ).dialog( "close" );
			        }
			      }
    	});
    	
    }

    

};