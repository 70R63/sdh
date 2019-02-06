ACC.publicidadexterior = {

	 _autoload: [ "bindSearchButton","bindDialog","bindDataTable"],
	    

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
			            	
			            	if(tipoValla == "Valla Vehículos")
		            		{
			            		$("#divVehiculos").show();
			            		$(".inputtextnew").val();
			            		
			            		$("#fechResolu").val(data.fechResolu);
			            		$("#fechNotif").val(data.fechNotif);
			            		$("#tipoSolicitud").val(data.tipoSolicitud);
			            		$("#vigenDesde").val(data.vigenDesde);
			            		$("#vigenHasta").val(data.vigenHasta);
			            		$("#tipoPublici").val(data.vigenHasta);
			            		$("#modelo").val(data.modelo);
			            		$("#tipoElemento").val(data.tipoElemento);
			            		$("#placa").val(data.placa);
			            		$("#numCaras").val(data.numCaras);
			            		$("#numLicenciaTrans").val(data.numLicenciaTrans);
			            		$("#periodicidad").val(data.periodicidad);
			            		$("#tipoServicio").val(data.tipoServicio);
			            		$("#ubicacion").val(data.ubicacion);
		            		}
			            	
			            },
			            error: function () {
			            	$("#textCertNom").html("No se puede certificar el nombre");
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