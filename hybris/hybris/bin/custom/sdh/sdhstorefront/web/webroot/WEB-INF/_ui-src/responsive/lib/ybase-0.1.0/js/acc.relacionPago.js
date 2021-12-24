ACC.relacionPago = {
		
		
		
		relacionPagoServicio : function(obKey,impuesto){
			debugger;
			ACC.spinner.show();
			
			var data = {};
	 	    data.obKey=obKey;
	 	    
			$.ajax({
	            url: ACC.relacionPagosServicioURL,
	            data: data,
	            type: "POST",
	            success: function (data) {
					debugger;
					
					if(impuesto == "1"){
						$("#relPagosPredial").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.PredialUnificado != null){
							
							if(data.Relacionpagosrespons.PredialUnificado.chip != null){								
								$('#relPagosPredial').append(
										"<tr>"+ 
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.PredialUnificado.chip +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.PredialUnificado.anio +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.PredialUnificado.doctyp +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.PredialUnificado.xblnr +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.PredialUnificado.fbnum +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.PredialUnificado.bldat +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.PredialUnificado.total_pgo +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.PredialUnificado.aporte +'" type="text" /></td>'+									
										"</tr>"
								);
								
								if(data.Relacionpagosrespons.STRPDF != null){
									$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								}
								
								$("#descargaRelacionPDF").show();
							}
							else{
								$('#relPagosPredial').append(
									"<tr>"+ 
									'<td colspan="8" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
									"</tr>"
								);
								$("#descargaRelacionPDF").hide();
							}	
						}
						else{
							$('#relPagosPredial').append(
								"<tr>"+ 
								'<td colspan="8" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
								"</tr>"
							);
							$("#descargaRelacionPDF").hide();
						}	
						
							
					}
					
					
					
					if(impuesto == "2"){
						$("#relPagosVehicular").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.Vehicular != null){
							
							if(data.Relacionpagosrespons.Vehicular.placa != null){								
								$('#relPagosVehicular').append(
										"<tr>"+ 
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Vehicular.placa +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Vehicular.anio +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Vehicular.doctyp +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Vehicular.xblnr +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Vehicular.fbnum +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Vehicular.bldat +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Vehicular.total_pgo +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Vehicular.aporte +'" type="text" /></td>'+
										"</tr>"
								);
								
								if(data.Relacionpagosrespons.STRPDF != null){
									$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								}
								
								$("#descargaRelacionPDF").show();
							}
							else{
								$('#relPagosVehicular').append(
									"<tr>"+ 
									'<td colspan="8" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
									"</tr>"
								);
								$("#descargaRelacionPDF").hide();
							}	
						}
						else{
							$('#relPagosVehicular').append(
								"<tr>"+ 
								'<td colspan="8" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
								"</tr>"
							);
							$("#descargaRelacionPDF").hide();
						}	
							
					}
					
					
					if(impuesto == "3"){
						$("#relPagosICA").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.impuestoICA != null){
							
							if(data.Relacionpagosrespons.impuestoICA.anio != null){								
								$('#relPagosICA').append(
										"<tr>"+ 
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.impuestoICA.anio +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.impuestoICA.persl +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.impuestoICA.doctyp +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.impuestoICA.xblnr +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.impuestoICA.fbnum +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.impuestoICA.bldat +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.impuestoICA.total_pgo +'" type="text" /></td>'+
										'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.impuestoICA.aporte +'" type="text" /></td>'+
										"</tr>"
								);
								
								if(data.Relacionpagosrespons.STRPDF != null){
									$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								}
								
								$("#descargaRelacionPDF").show();
							}
							else{
								$('#relPagosICA').append(
									"<tr>"+ 
									'<td colspan="8" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
									"</tr>"
								);
								$("#descargaRelacionPDF").hide();
							}	
						}						
						else{
							$('#relPagosICA').append(
								"<tr>"+ 
								'<td colspan="8" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
								"</tr>"
							);
							$("#descargaRelacionPDF").hide();
						}	
					}
					
					
					if(impuesto == "8"){
						$("#relPagosPublicidad").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.Publicidadexterior != null){
							
							if(data.Relacionpagosrespons.Publicidadexterior.nslctud != null){								
								$('#relPagosPublicidad').append(
										"<tr>"+ 
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Publicidadexterior.nslctud +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Publicidadexterior.numberid +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Publicidadexterior.doctyp +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Publicidadexterior.xblnr +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Publicidadexterior.fbnum +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Publicidadexterior.bldat +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Publicidadexterior.total_pgo +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Publicidadexterior.aporte +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.Publicidadexterior.aporte +'" type="text" /></td>'+
								    "</tr>"
								);
								
								if(data.Relacionpagosrespons.STRPDF != null){
									$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								}
								
								$("#descargaRelacionPDF").show();
							}
							else{
								$('#relPagosPublicidad').append(
									"<tr>"+ 
									'<td colspan="9" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
									"</tr>"
								);
								$("#descargaRelacionPDF").hide();
							}	
						}
						else{
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
							
							if(data.Relacionpagosrespons.SobretasaGasolina.nslctud != null){								
								$('#relPagosGasolina').append(
									"<tr>"+ 
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.SobretasaGasolina.nslctud +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.SobretasaGasolina.numberid +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.SobretasaGasolina.doctyp +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.SobretasaGasolina.xblnr +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.SobretasaGasolina.fbnum +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.SobretasaGasolina.bldat +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.SobretasaGasolina.total_pgo +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.SobretasaGasolina.aporte +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.SobretasaGasolina.aporte +'" type="text" /></td>'+
								    "</tr>"
								);
								
								if(data.Relacionpagosrespons.STRPDF != null){
									$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								}
								
								$("#descargaRelacionPDF").show();
							}
							else{
								$('#relPagosGasolina').append(
									"<tr>"+ 
									'<td colspan="9" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
									"</tr>"
								);
								$("#descargaRelacionPDF").hide();
							}	
						}
						else{
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
							
							if(data.Relacionpagosrespons.DelineacionUrbana.nslctud != null){								
								$('#relPagosDelineacion').append(
									"<tr>"+ 
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.DelineacionUrbana.nslctud +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.DelineacionUrbana.numberid +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.DelineacionUrbana.doctyp +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.DelineacionUrbana.xblnr +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.DelineacionUrbana.fbnum +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.DelineacionUrbana.bldat +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.DelineacionUrbana.total_pgo +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.DelineacionUrbana.aporte +'" type="text" /></td>'+
									'<td><input class="inputtextnew tabledoobli" disabled="disabled" value="'+ data.Relacionpagosrespons.DelineacionUrbana.aporte +'" type="text" /></td>'+
								    "</tr>"
								);
								
								if(data.Relacionpagosrespons.STRPDF != null){
									$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
								}
								
								$("#descargaRelacionPDF").show();
							}
							else{
								$('#relPagosDelineacion').append(
									"<tr>"+ 
									'<td colspan="9" class="dataTables_empty" valign="top">No se encontraron registros</td>' + 
									"</tr>"
								);
								$("#descargaRelacionPDF").hide();
							}	
						}
						else{
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
					debugger;
	            	ACC.spinner.close();
	            	
	            }
	        });
			
		}
}