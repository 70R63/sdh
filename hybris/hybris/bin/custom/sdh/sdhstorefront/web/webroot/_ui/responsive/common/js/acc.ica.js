ACC.ica = {

	 _autoload: [ "bindCalculoButton","bindPresentarDeclaracionButton","bindDialogICA","bindDeduccionesLists","bindDeleteDeducciones"],
	 
	 bindDeleteDeducciones: function(){
		 $(document).on("click", ".delededucciones", function (e) {
			 e.preventDefault();
			 $(this).parent().parent().parent().remove();
			 
		 });
		 
	 } ,
	 
	 bindDeduccionesLists: function(){
		
		 $(document).on("change", ".deducci", function (e) {
	 	        e.preventDefault();
	 	       
	 	       var tam = $(".deducciones").length;
	 	        
	 	      if ($(".deducciones").length == 20)
	 	      {
	 	    	 $( "#dialogICA" ).dialog( "open" );
        		$("#icaDialogContent").html("");
        		$("#icaDialogContent").html("No puede agregar más registros");
        		$(this).val("0");
        		return;
	 	      }
	 	      
	 	      var selectedOption = $(this);
	 	      var alreadyInList = false;
	 	     $.each($(".deducciones"),function(index,value){
 	        	
	 	    	 if(selectedOption.val() == $(value).find(".deducci").val() && selectedOption.parent().parent()[0] != value)
 	    		 {
	 	    		alreadyInList = true;
	 	    		
	        		return;
 	    		 }
 	        	
	 	     });
	 	     
	 	     if(alreadyInList)
	 	    {
	 	    	$( "#dialogICA" ).dialog( "open" );
        		$("#icaDialogContent").html("");
        		$("#icaDialogContent").html("La deducción seleccionada ya se encuentra en la lista.");
        		$(this).val("0");
        		return;
	 	    } 
	 	      
	 	        
	 	        var clonedRow = $(this).closest(".deducciones").clone();
	 	       $(this).closest(".deducciones").parent().last().append(clonedRow);
	 	       $(this).find("option").not(":selected").remove();
	 	      
	 	      $(this).closest(".deducciones").find(".col-md-1").find(".form-group").html("<img class='delededucciones' src='" + ACC.config.themeResourcePath +"/images/deledelineacion.png' style='width: 25px'></img>")
		 });
		 
	 },
	 
	 
	 bindCalculoButton: function () {
		 $(document).on("click", "#icaCalculoButton", function (e) {
	 	        e.preventDefault();
	 	        
//	 	        $("#icaCalculoButton").prop('disabled', true);
	 	       var icaCalculaDeclaracionForm = {};
	 	       
				icaCalculaDeclaracionForm.numObjeto=$.trim($("#numObjeto").val());
				icaCalculaDeclaracionForm.numForm=$.trim($("#numForm").val());
				icaCalculaDeclaracionForm.anoGravable=$.trim($("#anoGravable").val());
				icaCalculaDeclaracionForm.periodo=$.trim($("#periodo").val());
				
				
				if($("input[name='entidadFinanciera']:checked").val() == "si")
				{
					icaCalculaDeclaracionForm.cantEstablec=$.trim($("#cantEstablec").val());
					icaCalculaDeclaracionForm.entFinanciera="X";
				}else
				{
					icaCalculaDeclaracionForm.cantEstablec="";
					icaCalculaDeclaracionForm.entFinanciera="";
				}
				
				var impuestoAvisoRadio = $("input[name='impAviso']:checked"). val();
				
				if(impuestoAvisoRadio == 'si')
				{
					icaCalculaDeclaracionForm.impuestoAviso = "X";
					icaCalculaDeclaracionForm.valorImpAviso = "0.00";
				}else
				{
					icaCalculaDeclaracionForm.impuestoAviso = "";
					icaCalculaDeclaracionForm.valorImpAviso=$.trim($("#valorImpAviso").val());
				}
				
				
				
				
				
				
				
				icaCalculaDeclaracionForm.totalIngrPeriodo=$.trim($("#totalIngrPeriodo").val());
				icaCalculaDeclaracionForm.valorPagar=$.trim($("#valorPagar").val());
				
				
				var checkAporteRadio = $("input[name='aporte']:checked"). val();
				
				if(checkAporteRadio == 'si')
				{
					icaCalculaDeclaracionForm.checkAporte="X";
					var idaporte = $.trim($("#idaporte").val());
					icaCalculaDeclaracionForm.proyectoAporte=idaporte;
					if(idaporte == '02')
					{
						icaCalculaDeclaracionForm.tarifaAporte=$.trim($("#tarifaAporte1").val());
					}
					else if(idaporte == '01')
					{
						icaCalculaDeclaracionForm.tarifaAporte=$.trim($("#tarifaAporte2").val());
					}
					
				
				}else{
					icaCalculaDeclaracionForm.checkAporte="";
					icaCalculaDeclaracionForm.proyectoAporte="";
					icaCalculaDeclaracionForm.tarifaAporte="";
				}
				
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
			 	 
			 	icaCalculaDeclaracionForm.ingFueraBog=ingFueraBog;
			 	
			 	
			 	var deducciones = {};
			 	
			 	var deduccionValue= 0;
			 	
			 	deduccionValue = $('.deducci option[value="actnosubPA"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.actnosubPA = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="enajActFijo"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.enajActFijo = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="exportBienes"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.exportBienes = deduccionValue;
		 		}
			 	
			 	
			 	deduccionValue = $('.deducci option[value="exportServ"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.exportServ = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="actnosub39"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.actnosub39 = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="actnosubPH"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.actnosubPH = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="juegoSuerteAzar"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.juegoSuerteAzar = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="donaciones"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.donaciones = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="exenActos"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.exenActos = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="baseGravEsp"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.baseGravEsp = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="ingrActConsorc"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.ingrActConsorc = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="diviNOGiroOrd"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.diviNOGiroOrd = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="exenVictima"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.exenVictima = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="correcMoneda"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.correcMoneda = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="reintegro"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.reintegro = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="salarios"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.salarios = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="devoluciones"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.devoluciones = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="rebajas"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.rebajas = deduccionValue;
		 		}
			 	
			 	deduccionValue = $('.deducci option[value="descuentos"]:selected').parent().parent().parent().find(".valordedu").val();
			 	
			 	if($.isNumeric(deduccionValue))
			 	{	
			 		deducciones.descuentos = deduccionValue;
		 		}
			 	
			 	
			 	
			 	
			 	
			 	icaCalculaDeclaracionForm.deducciones = deducciones;
			 	
			 	
			 	
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
			 	 
			 	icaCalculaDeclaracionForm.ingNetosGrava=ingNetosGrava;
			 	
			 	
			 	
			 	
//			 	var ingPorCIIU = new Array();
//			 	 
//			 	 $.each($(".totaldos"),function(index,value){
//	    	        	
//			 		 	
//			 		 		
//			 		var anoGravable=$.trim($(value).find(".anoGravable").val());
//			 		var tipoID=$.trim($(value).find(".tipoID").val());
//			 		var numID=$.trim($(value).find(".numID").val());
//			 		var razonSocial=$.trim($(value).find(".razonSocial").val());
//			 		var direccion=$.trim($(value).find(".direccion").val());
//			 		var telefono=$.trim($(value).find(".telefono").val());
//			 		var codCIIU=$.trim($(value).find(".codCIIU").val());
//			 		var ingBrutoSINIVA=$.trim($(value).find(".ingBrutoSINIVA").val());
//			 		var valorTotalDevol=$.trim($(value).find(".valorTotalDevol").val());
//
//	    	        	
//	    	        	if(anoGravable != "" && tipoID != "" && numID != "" && razonSocial != "" && direccion != "" && telefono != "" && codCIIU != "" && ingBrutoSINIVA != "" && valorTotalDevol != "")
//	    	        	{
//		    	        	var eachIngreso=new Object();
//		    	        	
//		    	        	eachIngreso.anoGravable=anoGravable;
//		    	        	eachIngreso.tipoID=tipoID;
//		    	        	eachIngreso.numID=numID;
//		    	        	eachIngreso.razonSocial=razonSocial;
//		    	        	eachIngreso.direccion=direccion;
//		    	        	eachIngreso.telefono=telefono;
//		    	        	eachIngreso.codCIIU=codCIIU;
//		    	        	eachIngreso.ingBrutoSINIVA=ingBrutoSINIVA;
//		    	        	eachIngreso.valorTotalDevol=valorTotalDevol;
//		    	        	
//		    	        	ingPorCIIU.push(eachIngreso);
//		    	        	
//		    	        	
//	    	        	}
//	    	        	
//	    	        });
//			 	 
//			 	icaCalculaDeclaracionForm.ingPorCIIU=ingPorCIIU;
			 	
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
			 	 
			 	icaCalculaDeclaracionForm.valorRetenido=valorRetenido;
	 	
	 	
	 	      $.ajax({
	 	    	  url: ACC.icaDeclaracionCalculoURL,
		            data: JSON.stringify(icaCalculaDeclaracionForm),
		            type: "POST",
		            dataType: "json",
		              contentType: "application/json",
		            success: function (data) {
		            	
		            	var actualErrors = [];
		            	
		            	if(data.errores)
		            	{
		            		$.each(data.errores, function( index, value ) {
		            			if(value.idmsj != "0")
		            			actualErrors.push(value);
    	            		});
		            	}
		            	
		            	if(actualErrors.length > 0)
	            		{
		            		$( "#dialogICA" ).dialog( "open" );
		            		$("#icaDialogContent").html("Error");
		            		$.each(data.errores, function( index, value ) {
    	            			$("#icaDialogContent").html($("#icaDialogContent").html()+value.txtmsj+"<br>");
    	            		});
		            		
		            		$("#icaPresentarDeclaracionButton").prop("disabled",true);
//		            		
	            		}else
	            		{
	            			$( "#dialogICA" ).dialog( "open" );
	            			$("#icaDialogContent").html("El cálculo se ha realizado exitosamente.")
	            			
	            			
	            			$("#totalingPeriodo").val(data.declaracion.totalingPeriodo);
	            			$("#totalingFueraBog").val(data.declaracion.totalingFueraBog);
	            			$("#totalingBrutos").val(data.declaracion.totalingBrutos);
	            			$("#devolDescuentos").val(data.declaracion.devolDescuentos);
	            			$("#totalDeduccion").val(data.declaracion.totalDeduccion);
	            			$("#totalingNetos").val(data.declaracion.totalingNetos);
	            			$("#impIndusComer").val(data.declaracion.impIndusComer);
	            			$("#valorImpAviso").val(data.declaracion.valorImpAviso);
	            			$("#totalUnidadAdic").val(data.declaracion.totalUnidadAdic);
	            			$("#impuestoCargo").val(data.declaracion.impuestoCargo);
	            			$("#valorReteIndusComer").val(data.declaracion.valorReteIndusComer);
	            			$("#saldoCargo").val(data.declaracion.saldoCargo);
	            			$("#valorPagar").val(data.declaracion.valorPagar);
	            			$("#sanciones").val(data.declaracion.sanciones);
	            			$("#interesMora").val(data.declaracion.interesMora);
	            			$("#totalPagar").val(data.declaracion.totalPagar);
	            			$("#totalAporteVolun").val(data.declaracion.totalAporteVolun);
	            			
	            			$("#numForm").val(data.numForm)
	            			
	            			$("#icaPresentarDeclaracionButton").prop("disabled",false);
	            		}
	 	      		
		            },
		            error: function () {
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