ACC.relacionPagos = {
		
		relacionPagosServicio : function(obKey,impuesto){
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
						}
						if(data.Relacionpagosrespons.STRPDF != null){
							$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
						}
							
					}
					
					
					if(impuesto == "2"){
						$("#relPagosVehicular").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.Vehicular != null){
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
						}
						if(data.Relacionpagosrespons.STRPDF != null){
							$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
						}
					}
					
					if(impuesto == "3"){
						$("#relPagosICA").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.impuestoICA != null){
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
						}
						if(data.Relacionpagosrespons.STRPDF != null){
							$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
						}
					}
					
					
					if(impuesto == "4"){
						$("#relPagosPublicidad").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.Publicidadexterior != null){
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
						}
						if(data.Relacionpagosrespons.STRPDF != null){
							$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
						}
					}
					
					if(impuesto == "5"){
						$("#relPagosGasolina").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.SobretasaGasolina != null){
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
						}
						if(data.Relacionpagosrespons.STRPDF != null){
							$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
						}
					}
					
					
					if(impuesto == "6"){
						$("#relPagosDelineacion").find("tr:gt(0)").remove();
						if(data.Relacionpagosrespons.DelineacionUrbana != null){
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
						}
						if(data.Relacionpagosrespons.STRPDF != null){
							$("#strPDF").val( data.Relacionpagosrespons.STRPDF );
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