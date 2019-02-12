ACC.publicidadexterior = {

	 _autoload: [ "bindCalculoButton","bindSearchButton","bindPresentarDeclaracionButton","bindDialogPublicidadExterior","bindDataTable"],
	 bindCalculoButton: function () {
		 $(document).on("click", "#calculoButton", function (e) {
	 	        e.preventDefault();
	 	        
	 	       var anograv  = $.trim($("#anograv").val());
	 	       var numresol = $.trim($("#numresol").val());
	 	       var fechnotif =  $.trim($("#fechnotif").val());
	 	       var opuso  = $.trim($("#opuso").val());
	 	       var luginst  = $.trim($("#luginst").val());
	 	       var direccion  = $.trim($("#direccion").val());
	 	       var placa  = $.trim($("#placa").val());
	 	       var orValla  = $.trim($("#orValla").val());
	 	       var tamValla  = $.trim($("#tamValla").val());
	 	       var municipioContrib  = $.trim($("#municipioContrib").val());
	 	       var tipoIDdeclara  = $.trim($("#tipoIDdeclara").val());
	 	       var idDeclarante  = $.trim($("#idDeclarante").val());
	 	 
	 	       var data = {};
	 	       
	 	       data.anograv=anograv;
	 	      data.numresol=numresol;
	 	      data.fechnotif = fechnotif; 
	 	      data.opuso = opuso; 
	   	      data.luginst = luginst; 
	 	      data.direccion = direccion; 
	 	      data.placa = placa; 
	 	      data.orValla = orValla; 
	 	      data.tamValla = tamValla; 
	 	      data.municipioContrib = municipioContrib; 
	 	      data.tipoIDdeclara = tipoIDdeclara; 
	 	      data.idDeclarante = idDeclarante; 
	 	
	 	      $.ajax({
		            url: ACC.publicidadExteriorCalculoURL,
		            data: data,
		            type: "POST",
		            success: function (data) {
		            	$( "#dialogPublicidadExterior" ).dialog( "open" );
		            	if(data.errores)
	            		{
		            		$.each(data.errores, function( index, value ) {
    	            			$("#publicidadExteriorDialogContent").html($("#publicidadExteriorDialogContent").html()+value.txtmsj+"<br>");
    	            		});
		            		
		            		$("#impCar").val("");
	            			$("#valsan").val("");
	            			$("#valpag").val("");
	            			$("#intmora").val("");
	            			$("#totpag").val("");
	            			$("#numForm").val("");
		            		
	            		}else
	            		{
	            			$("#publicidadExteriorDialogContent").html("El cálculo se ha realizado exitosamente.")
	            			
	            			$("#impCar").val(data.impCargo);
	            			$("#valsan").val(data.vlrSancion);
	            			$("#valpag").val(data.vlrPagar);
	            			$("#intmora").val(data.interesMora);
	            			$("#totpag").val(data.totalPagar);
	            			$("#numForm").val(data.numForm);
	            			
	            		}
	 	      		
		            },
		            error: function () {
		            	$( "#dialogPublicidadExterior" ).dialog( "open" );
		            	$("#publicidadExteriorDialogContent").html("Hubo un error al realizar el cálculo, por favor intentalo más tarde");
		            	$("#impCar").val("");
            			$("#valsan").val("");
            			$("#valpag").val("");
            			$("#intmora").val("");
            			$("#totpag").val("");
            			$("#numForm").val("");
		            }
		        });
	 	       
		 });
	 },
	 
	 bindPresentarDeclaracionButton: function () {
		 $(document).on("click", "#presentarDeclaracionButton", function (e) {
	 	        e.preventDefault();
	 	        
	 	       var anoGravable  = $.trim($("#anio").val());
	 	       var numResolu = $.trim($("#example input[type='radio']:checked").attr("data-numRes"));
	 	       
	 	      if(anoGravable == "0")
	 	        {	
	 	        	alert("Por favor, selecciona el año a consultar");
	 	        	return;
	 	        }
	 	        	
	 	        if(numResolu == "" || numResolu == "")
	 	        {
	 	        	alert("Por favor, selecciona el impuesto a consultar");
	 	        	return;
	 	        }
	 	       
	 	      window.location.href = ACC.publicidadExteriorDeclararionURL+"?numResolu="+numResolu+"&anoGravable="+anoGravable;
	 	       
		 });
	 },
	 
	    bindSearchButton: function () {
	    	 $(document).on("click", "#searchDetailButton", function (e) {
		 	        e.preventDefault();
		 	        
		 	        var anoGravable  = $.trim($("#anio").val());
		 	        var tipoValla = $.trim($("#example input[type='radio']:checked").attr("data-tipoValla"));
		 	       var numResolu = $.trim($("#example input[type='radio']:checked").attr("data-numRes"));
		 	        
		 	        if(anoGravable == "0")
		 	        {	
		 	        	alert("Por favor, selecciona el año a consultar");
		 	        	return;
		 	        }
		 	        	
		 	        if(tipoValla == "" || numResolu == "")
		 	        {
		 	        	alert("Por favor, selecciona el impuesto a consultar");
		 	        	return;
		 	        }
		 	        
		 	        
		 	       var data={};
			        
			       data.numResolu = numResolu;
			       data.anoGravable = anoGravable;
			       data.tipoValla = tipoValla;
			       
			        $.ajax({
			            url: ACC.publicidadExteriorDetalleURL,
			            data: data,
			            type: "GET",
			            success: function (data) {
			            	var tipoValla = $.trim($("#example input[type='radio']:checked").attr("data-tipoValla"));

			            	$("#divAvisos").hide();
			            	$("#divConvencional").hide();
			            	$("#divVehiculos").hide();
			            	$("#divTubular").hide();
			            	
			            	if(tipoValla == "Valla Tubular Comercial")
		            		{
			            		$("#divTubularComercial").show();
			            		$(".inputtextnew").val();
			            		
			            		$("#fechResolu").val(data.fechResolu);
			            		$("#fechNotif").val(data.fechNotif);
			            		$("#tipoSolicitud").val(data.tipoSolicitud);
			            		
			            		$("#tubularComercialDireccion").val(data.direccion);
			            		$("#tubularComercialAreaElemento").val(data.areaElemento);
			            		
			            		var localidadText  = data.localidad;
			            		
			            		localidades.forEach(function (eachLoc) {
					    	    	if(parseInt(eachLoc.locId) == parseInt(data.localidad))
					    	    		localidadText = eachLoc.name;
			            		});
			            		
			            		
			            		$("#tubularComercialLocalidad").val(localidadText);
			            		$("#tubularComercialOrientacion").val(data.orientacion);
			            		$("#tubularComercialCodPostal").val(data.codPostal);
			            		$("#tubularComercialChip").val(data.chip);
			            		$("#tubularComercialAvisoLumino").val(data.avisoLumino);
			            		$("#tubularComercialUbicacion").val(data.ubicacion);
			            		$("#tubularComercialMatricula").val(data.matricula);
		            		}else if(tipoValla == "Valla Vehículos")
		            		{
		            			$("#divVehiculos").show();
			            		$(".inputtextnew").val();
			            		
			            		$("#fechResolu").val(data.fechResolu);
			            		$("#fechNotif").val(data.fechNotif);
			            		$("#tipoSolicitud").val(data.tipoSolicitud);
			            		
			            		$("#vehiculoModelo").val(data.modelo);
			            		$("#vehiculoTipoPublici").val(data.tipoPublici);
			            		$("#vehiculoPlaca").val(data.placa);
			            		$("#vehiculoTipoElemento").val(data.tipoElemento);
			            		$("#vehiculoNumLicenciaTrans").val(data.numLicenciaTrans);
			            		$("#vehiculoOrientacion").val(data.orientacion);
			            		$("#vehiculoTipoServicio").val(data.tipoServicio);
			            		
		            		}else if(tipoValla == "Valla Tubular de Obra")
		            		{
		            			$("#divTubularObra").show();
			            		$(".inputtextnew").val();
			            		
			            		$("#fechResolu").val(data.fechResolu);
			            		$("#fechNotif").val(data.fechNotif);
			            		$("#tipoSolicitud").val(data.tipoSolicitud);
			            		
			            		$("#tubularObraDireccion").val(data.direccion);
			            		$("#tubularObraLicenciaUrb").val(data.licenciaUrb);
			            		
			            		var localidadText  = data.localidad;
			            		
			            		localidades.forEach(function (eachLoc) {
					    	    	if(parseInt(eachLoc.locId) == parseInt(data.localidad))
					    	    		localidadText = eachLoc.name;
			            		});
			            		
			            		$("#tubularObraLocalidad").val(localidadText);
			            		$("#tubularObraContratoObra").val(data.contratoObra);
			            		$("#tubularObraCodPostal").val(data.codPostal);
			            		$("#tubularObraLicenciaConstruc").val(data.licenciaContruc);
			            		$("#tubularObraChip").val(data.chip);
			            		$("#tubularObraVigLicenConstruc").val(data.vigLicenConstruc);
			            		$("#tubularObraMatricula").val(data.matricula);
			            		$("#tubularObraAreaTotal").val(data.areaTotal);
			            		$("#tubularObraUbicacion").val(data.ubicacion);
			            		$("#tubularObraPeriodicidad").val(data.periodicidad);
			            		$("#tubularObraOrientacion").val(data.orientacion);
			            		$("#tubularObraNumcaras").val(data.numCaras);
		            			
		            		}else if(tipoValla == "Valla de Obra Convencional")
		            		{
		            			
		            			$("#divObraConvencional").show();
			            		$(".inputtextnew").val();
			            		
			            		$("#fechResolu").val(data.fechResolu);
			            		$("#fechNotif").val(data.fechNotif);
			            		$("#tipoSolicitud").val(data.tipoSolicitud);
			            		
			            		$("#obraConvencionalDireccion").val(data.direccion);
			            		$("#obraConvencionaltipoPublici").val(data.tipoPublici);
			            		
			            		var localidadText  = data.localidad;
			            		
			            		localidades.forEach(function (eachLoc) {
					    	    	if(parseInt(eachLoc.locId) == parseInt(data.localidad))
					    	    		localidadText = eachLoc.name;
			            		});
			            		
			            		$("#obraConvencionalLocalidad").val(localidadText);
			            		$("#obraConvencionalUbicacion").val(data.ubicacion);
			            		$("#obraConvencionalCodPostal").val(data.codPostal);
			            		$("#obraConvencionalChip").val(data.chip);
			            		$("#obraConvencionalAvisoLumino").val(data.avisoLumino);
			            		$("#obraConvencionalMatricula").val(data.matricula);
			            		$("#obraConvencionalOrientacion").val(data.orientacion);
			            		$("#obraConvencionalTotalArea").val(data.areaTotal);
		            		}else if(tipoValla == "Pantalla LED")
		            		{
		            			$("#divPantallaLed").show();
			            		$(".inputtextnew").val();
			            		
			            		$("#fechResolu").val(data.fechResolu);
			            		$("#fechNotif").val(data.fechNotif);
			            		$("#tipoSolicitud").val(data.tipoSolicitud);
			            		
			            		$("#pantallaLedDireccion").val(data.direccion);
			            		$("#pantallaLedMatricula").val(data.matricula);
			            		
			            		var localidadText  = data.localidad;
			            		
			            		localidades.forEach(function (eachLoc) {
					    	    	if(parseInt(eachLoc.locId) == parseInt(data.localidad))
					    	    		localidadText = eachLoc.name;
			            		});
			            		
			            		$("#pantallaLedLocalidad").val(localidadText);
			            		$("#pantallaLedUbicacion").val(data.ubicacion);
			            		$("#pantallaLedCodPostal").val(data.copPostal);
			            		$("#pantallaLedTipoPublicidad").val(data.tipoPublici);
			            		$("#pantallaLedChip").val(data.chip);
			            		$("#pantallaLedOrientacionVisual").val(data.orientacion);
			            		$("#pantallaLedAreaTotal").val(data.areaTotal);
		            		}
			            	
			            },
			            error: function () {
			            }
			        });
		 	        
		 	        
		 	  });
	    	
	    },
    
	    bindDataTable: function () {
	    	if ($.fn.dataTable.isDataTable('#example')) {
				table = $('#example').DataTable();
				table.destroy();
			}
			var tabla = $("#example")
					.DataTable(
							{
								"sPaginationType" : "full_numbers",
								"oLanguage" : {
									"oPaginate" : {
										"sPrevious" : "Anterior",

										"sNext" : "Siguiente",
										"sLast" : "Ultima",
										"sFirst" : "Primera"
									},
									"sLengthMenu" : 'Mostrando <select>'
											+ '<option value="5">5</option>'
											+ '<option value="10">10</option>'
											+ '<option value="15">15</option>'
											+ '<option value="20">20</option>'
											+ '<option value="30">30</option>'
											+ '</select> datos por página',
									"sInfo" : "Mostrando del START a END (Total: TOTAL resultados)",
									"sInfoFiltered" : " Filtrados de MAX registros",
									"sInfoEmpty" : " ",
									"sZeroRecords" : "No se encontraron registros",
									"sProcessing" : "Espere, por favor...",
									"sSearch" : "Buscar:",
								}
							});
	    	
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