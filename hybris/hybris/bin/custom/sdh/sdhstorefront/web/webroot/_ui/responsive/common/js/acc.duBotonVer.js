ACC.duBotonVer = {

	_autoload : [ "bindLabelVerButton","bindCheckBoxSelect","bindGeneraDeclaracionButton","bindDialogGasolina" ],

	
	bindLabelVerButton : function() {
		$(document).on("click", ".label1Ver", function(e) {
			e.preventDefault();
			

 	       var valorCDU = $.trim($(this).attr("data-cdu")); 	       

 	       if (valorCDU == "") {
				alert("Por favor, selecciona un CDU");
				return;
			}

			$("#selectedCDU").val(valorCDU);

			var data = {};

			data.cdu = valorCDU;

			$.ajax({
				url : ACC.radicaDelinDetallesURL,
				data : data,
				type : "GET",
				success : function(dataResponse) {
					ACC.duBotonVer.fillFieldsFromData(dataResponse);

				},
				error : function() {
				}
			});
		});
	},
	
	fillFieldsFromData : function(data) {

		$("#divInfoRadicados").show();
		$("#duRadicados").find("tr:gt(0)").remove();
		$.each(data.radicados, function (index,value){
			if(value.numRadicado != ''){
			$('#duRadicados').append("<tr>"+ 
					 '<td><input id="numRadicado" name="" class="inputtextnew" aria-required="true" type="text" readonly="readonly" maxlength="240" style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;" value="' + value.numRadicado + '"></td>"' +
					 '<td><input id="fechaRadicado" name="" class="inputtextnew" aria-required="true" type="text" readonly="readonly" maxlength="240" style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;" value="' + value.fechaRadicado + '"></td>"' +
					 '<td><input id="modLicencia" name="" class="inputtextnew" aria-required="true" type="text" readonly="readonly" maxlength="240" style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;" value="' + value.modLicencia + '"></td>"' +
					 '<td><input id="presupuesto" name="" class="inputtextnew" aria-required="true" type="text" readonly="readonly" maxlength="240" style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;" value="' + value.presupuesto + '"></td>"' +
					 '<td><input id="estrato" name="" class="inputtextnew" aria-required="true" type="text" readonly="readonly" maxlength="240" style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;" value="' + value.estrato + '"></td>"' +
					 '<td><input class="inputtextnew selectRadicado" style="visibility: visible !important; width: 20% !important" type="checkbox"  data-numradicado="' + value.numRadicado + '" data-modlicencia="' + value.modLicencia +'" ></td> '+ 
					 "</tr>");	
			}
			document.getElementById("retenciondelibutton1").disabled = true;
			document.getElementById("declaradelibutton1").disabled = true; 
			$('#optradio1').prop('checked', 'checked');

		})
	},
	
	
	bindCheckBoxSelect : function() {
		$(document).on("click", ".selectRadicado", function(e) {
			
 	       var valorNumRadicado = $.trim($(this).attr("data-numradicado")); 	       
 	       var valorModLicencia = $.trim($(this).attr("data-modlicencia")); 	       

 	       $("#selectedRadicado").val(valorNumRadicado);
 	       $("#selectedTipoLicencia").val(valorModLicencia);

 	       if($( "input:checked" ).length == 2 ){
 	    	   document.getElementById("retenciondelibutton1").disabled = false;
 	       }else{
 	    	  document.getElementById("retenciondelibutton1").disabled = true;
 	       }
 	       
		});
	},
	
	
	bindGeneraDeclaracionButton: function () {
		 $(document).on("click", "#duGeneraDeclaracionButton", function (e) {
	 	        e.preventDefault();
	 	        
	 	       var numForm  = $.trim($("#numForm").val());
	 	 
	 	       var data = {};
	 	       
	 	       data.numForm=numForm;
	 	
	 	      $.ajax({
		            url: ACC.duGeneraDeclaracionURL,
		            data: data,
		            type: "GET",
		            success: function (data) {
		            	$( "#dialogDU" ).dialog( "open" );
		            	if(data.errores)
	            		{
		            		$("#duDialogContent").html("");
		            		$.each(data.errores, function( index, value ) {
   	            			$("#duDialogContent").html($("#duDialogContent").html()+value.txtmsj+"<br>");
   	            		});
		            		
		            		
	            		}else
	            		{
	            			$("#duDialogContent").html("");
	            			$("#duDialogContent").html("La declaración se ha generado exitosamente.")
	            			
	            			$("#downloadHelper").attr("href",data.urlDownload);
	            			
	            			document.getElementById("downloadHelper").click();
	            			
	            		}
	 	      		
		            },
		            error: function () {
		            	$( "#dialogDU" ).dialog( "open" );
		            	$("#duDialogContent").html("Hubo un error al generar la declaración, por favor inténtalo más tarde");
		            }
		        });
	 	       
		 });
	 },
	 
	
   
	    bindDialogGasolina: function(){
   	
   	$( "#dialogDU" ).dialog({ 
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