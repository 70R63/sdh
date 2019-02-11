ACC.publicidadexterior = {

	 _autoload: [ "bindSearchButton","bindPresentarDeclaracionButton","bindDialog","bindDataTable"],
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
			            		
			            		departments.forEach(function (eachDep) {
					    	    	if(parseInt(eachDep.depId) == parseInt(data.localidad))
					    	    		localidadText = eachDep.name;
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
			            		
			            		departments.forEach(function (eachDep) {
					    	    	if(parseInt(eachDep.depId) == parseInt(data.localidad))
					    	    		localidadText = eachDep.name;
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
			            		
			            		departments.forEach(function (eachDep) {
					    	    	if(parseInt(eachDep.depId) == parseInt(data.localidad))
					    	    		localidadText = eachDep.name;
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
			            		
			            		departments.forEach(function (eachDep) {
					    	    	if(parseInt(eachDep.depId) == parseInt(data.localidad))
					    	    		localidadText = eachDep.name;
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
    
    
    bindDialog: function(){
    	
    	$( "#dialog" ).dialog({ 
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