ACC.relacionPago = {
		
		
		
		relacionPagoServicio : function(obKey,impuesto){
			
			ACC.spinner.show();
			
			var data = {};
	 	    data.obKey=obKey;
	 	    
			$.ajax({
	            url: ACC.relacionPagosServicioURL,
	            data: data,
	            type: "POST",
	            success: function (data) {
					var flagRegistrosAgregados = false;
					var total_pgo = 0;
					var aporte = 0;
					
					if(impuesto == "1"){
						$("#relPagosPredial").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.PredialUnificado != null){
							$.each(data.Relacionpagosrespons.PredialUnificado, function (index,value){
								
								total_pgo = value.total_pgo;
								aporte = value.aporte;
								
								if ( total_pgo == null || total_pgo == '' || total_pgo == undefined ){
									total_pgo = 0;
								}	
								
								if ( aporte == null || aporte == '' || aporte == undefined ){
									aporte = 0;
								}
								
								if(true){
									$('#relPagosPredial').append(
										"<tr>"+ 
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.chip +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.anio +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.doctyp +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.xblnr +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.fbnum +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.bldat +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ total_pgo +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ aporte +'" type="text" /></td>'+									
										"</tr>"
									);
									flagRegistrosAgregados = true;
								}
							});
						}
						if(flagRegistrosAgregados){								
							if(data.Relacionpagosrespons.STRPDF != null){
								$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								$("#descargaRelacionPDF").show();
							}
						}else{
							$('#relPagosPredial').append(
								"<tr>"+ 
								'<td colspan="9" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
								"</tr>"
							);
							$("#descargaRelacionPDF").hide();
						}
							
					}
					
					
					
					if(impuesto == "2"){
						$("#relPagosVehicular").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.Vehicular != null){
							
							$.each(data.Relacionpagosrespons.Vehicular, function (index,value){
								
								total_pgo = value.total_pgo;
								aporte = value.aporte;
								
								if ( total_pgo == null || total_pgo == '' || total_pgo == undefined ){
									total_pgo = 0;
								}	
								
								if ( aporte == null || aporte == '' || aporte == undefined ){
									aporte = 0;
								}
								
								if(true){
									$('#relPagosVehicular').append(
										"<tr>"+ 
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.placa +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.anio +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.doctyp +'" type="text" /></td>'+
										'<td><input class="inputtextnew tableRelacion" disabled="disabled" value="'+ value.xblnr +'" type="text" /></td>'+
										'<td><input class="inputtextnew tableRelacion" disabled="disabled" value="'+ value.fbnum +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.bldat +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ total_pgo +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ aporte +'" type="text" /></td>'+
										"</tr>"
									);
									flagRegistrosAgregados = true;
								}
							});
						}
						if(flagRegistrosAgregados){								
							if(data.Relacionpagosrespons.STRPDF != null){
								$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								$("#descargaRelacionPDF").show();
							}
						}else{
							$('#relPagosVehicular').append(
								"<tr>"+ 
								'<td colspan="9" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
								"</tr>"
							);
							$("#descargaRelacionPDF").hide();
						}
							
					}
					
					
					if(impuesto == "3"){
						$("#relPagosICA").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.impuestoICA != null){
							$.each(data.Relacionpagosrespons.impuestoICA, function (index,value){
								
								total_pgo = value.total_pgo;
								aporte = value.aporte;
								
								if ( total_pgo == null || total_pgo == '' || total_pgo == undefined ){
									total_pgo = 0;
								}	
								
								if ( aporte == null || aporte == '' || aporte == undefined ){
									aporte = 0;
								}
								
								if(true){
									$('#relPagosICA').append(
										"<tr>"+ 
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.anio +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.persl +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.doctyp +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.xblnr +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.fbnum +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.bldat +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ total_pgo +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ aporte +'" type="text" /></td>'+
										"</tr>"
									);
									flagRegistrosAgregados = true;
								}
							});
						}
						if(flagRegistrosAgregados){								
							if(data.Relacionpagosrespons.STRPDF != null){
								$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								$("#descargaRelacionPDF").show();
							}
						}else{
							$('#relPagosICA').append(
								"<tr>"+ 
								'<td colspan="9" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
								"</tr>"
							);
							$("#descargaRelacionPDF").hide();
						}
						
							
					}
					
					
					if(impuesto == "4"){
						$("#relPagosPublicidad").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.Publicidadexterior != null){
							$.each(data.Relacionpagosrespons.Publicidadexterior, function (index,value){
								
								total_pgo = value.total_pgo;
								
								if ( total_pgo == null || total_pgo == '' || total_pgo == undefined ){
									total_pgo = 0;
								}	
								
								if(true){
									$('#relPagosPublicidad').append(
										"<tr>"+ 
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.numberid +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.linstal +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.nslctud +'" type="text" /></td>'+
									'<td><input class="inputtextnew tableRelacion" disabled="disabled" value="'+ value.xblnr +'" type="text" /></td>'+
									'<td><input class="inputtextnew tableRelacion"" disabled="disabled" value="'+ value.fbnum +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.doctyp +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.bldat +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ total_pgo +'" type="text" /></td>'+
								    "</tr>"
									);
									flagRegistrosAgregados = true;									
								}
							});
						}
						if(flagRegistrosAgregados){								
							if(data.Relacionpagosrespons.STRPDF != null){
								$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								$("#descargaRelacionPDF").show();
							}
						}else{
							$('#relPagosPublicidad').append(
								"<tr>"+ 
								'<td colspan="9" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
								"</tr>"
							);
							$("#descargaRelacionPDF").hide();
						}
						
							
							
					}
					
					if(impuesto == "5"){
						$("#relPagosGasolina").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.SobretasaGasolina != null){
							$.each(data.Relacionpagosrespons.SobretasaGasolina, function (index,value){
								
								total_pgo = value.total_pgo;
								
								if ( total_pgo == null || total_pgo == '' || total_pgo == undefined ){
									total_pgo = 0;
								}	
								
								if(true){
									$('#relPagosGasolina').append(
									"<tr>"+ 
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.anio +'" type="text" /></td>'+
									'<td><input class="inputtextnew tableRelacion" disabled="disabled" value="'+ value.periodo +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.doctyp +'" type="text" /></td>'+
									'<td><input class="inputtextnew tableRelacion" disabled="disabled" value="'+ value.xblnr +'" type="text" /></td>'+
									'<td><input class="inputtextnew tableRelacion" disabled="disabled" value="'+ value.fbnum +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.bldat +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ total_pgo +'" type="text" /></td>'+
//									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.aporte +'" type="text" /></td>'+
//									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.aporte +'" type="text" /></td>'+
								    "</tr>"
								);
									flagRegistrosAgregados = true;
								}
							});
						}
						if(flagRegistrosAgregados){								
							if(data.Relacionpagosrespons.STRPDF != null){
								$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								$("#descargaRelacionPDF").show();
							}
						}else{
							$('#relPagosGasolina').append(
								"<tr>"+ 
								'<td colspan="9" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
								"</tr>"
							);
							$("#descargaRelacionPDF").hide();
						}
							
							
							
							
					}
					
					
					if(impuesto == "6"){
						$("#relPagosDelineacion").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.DelineacionUrbana != null){
							
							$.each(data.Relacionpagosrespons.DelineacionUrbana, function (index,value){
								
								total_pgo = value.total_pgo;
								
								if ( total_pgo == null || total_pgo == '' || total_pgo == undefined ){
									total_pgo = 0;
								}	
								
								if(true){
									$('#relPagosDelineacion').append(
										"<tr>"+ 
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.cdu +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.xblnr +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.doctyp +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.cdu +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.doctyp +'" type="text" /></td>'+
										'<td><input class="inputtextnew tableRelacion" disabled="disabled" value="'+ value.xblnr +'" type="text" /></td>'+
										'<td><input class="inputtextnew" disabled="disabled" value="'+ value.fbnum +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ value.bldat +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ total_pgo +'" type="text" /></td>'+
									    "</tr>"
									);
								flagRegistrosAgregados = true;
								}
							});
						}
						if(flagRegistrosAgregados){								
							if(data.Relacionpagosrespons.STRPDF != null){
								$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								$("#descargaRelacionPDF").show();
							}
						}else{
							$('#relPagosDelineacion').append(
								"<tr>"+ 
								'<td colspan="9" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
								"</tr>"
							);
							$("#descargaRelacionPDF").hide();
						}
							
					}
					
					
					
	            	ACC.spinner.close();
 	      		    
	            },
	            error: function () {
					
	            	ACC.spinner.close();
	            	
	            }
	        });
			
		}
}