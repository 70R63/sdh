ACC.retencionesPracticadas = {

	_autoload : [],

	
		buscarInfoTable : function (){
		ACC.spinner.show();

		var anioGrav = $("#anioGrav").val();
		debugger;
			var dataActual = {};	

			dataActual.anio = anioGrav;
			
			$.ajax({
				url : ACC.retencionesPracticadasTableURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					debugger;
					ACC.spinner.close();

	 var pro = document.getElementById('tableData');
	 var detail = document.getElementById('detailRetenedor');
$('#tableData').find("tr:gt(0)").remove();
$('#tabPaginacion0').find("tr:gt(0)").remove();
$('#detailTotalTable').find("tr:gt(0)").remove();
$('#example')
								.append(
										"<tr>"
												+ '<td><input class="inputtextnew" disabled="disabled" type="text" value="'
												+ dataResponse.Tipodedocumento
												+ '" /></td>'
												+ '<td><input class="inputtextnew" disabled="disabled" type="text" value="'
												+ dataResponse.Numbbpretenedor
												+ '" /></td>'
												+ '<td><input class="inputtextnew" disabled="disabled" type="text" value="'
												+ dataResponse.Retenedor
												+ '" /></td>'
												+ '<td><label class="labelVerDetalle text-capitalize !important" id="labelVerDetalle" style="color: #0358d8 !important" onclick="showDetail()"> Detalle</label></td></tr>');
$('#tabPaginacion0')
								.append(
										"<tr>"
												+ '<td><input style="width: 123px !important; text-align: center" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="'
												+ dataResponse.PeriodoReportado
												+ '" /></td>'
												+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ dataResponse.Retenedor
												+ '" /></td>'
												+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ dataResponse.Tipodedocumento
												+ '" /></td>'
												+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ dataResponse.IdentificacionRetenedor
												+ '" /></td>'
												+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ dataResponse.Basederetencion
												+ '" /></td>'
												+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ dataResponse.TarifaAplicada
												+ '" /></td>'
												+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ dataResponse.ValoresRetenidos
												+ '" /></td></tr>');
$('#detailTotalTable')
								.append(
										"<tr>"
												+ '<td>Total Retenciones Practicadas</td>'
												+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ dataResponse.TotalRetenciones
												+ '" /></td></tr>');

		pro.style.display = 'block';
		detail.style.display = 'none';
					
				}
			,
				error : function() {
					debugger;
					ACC.spinner.close();
					alert("Error al consultar la información del contribuyente");	
				}
			});
		
	 },

	buscarInfo : function (){
		ACC.spinner.show();
		var tipoDoc = $("#tipoDoc").val();
		var numDoc = $("#numDoc").val();
		
		if(ACC.descargaFacturaVA.validarAntesSubmitBuscarInfo(tipoDoc,numDoc)){
			var dataActual = {};	
			
			dataActual.tipoDoc = tipoDoc;
			dataActual.numDoc = numDoc;
			
			$.ajax({
				url : ACC.descargaFacturaVABuscarInfoURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					
					ACC.spinner.close();
					ACC.descargaFacturaVA.manejarRespuesta_buscarInfo(dataResponse);
					
				}
			,
				error : function() {
					
					ACC.spinner.close();
					alert("Error al consultar la información del contribuyente");	
				}
			});
		}
	 },
	 
	 
	manejarRespuesta_buscarInfo : function(dataResponse){
		
		if(dataResponse != null && dataResponse.nombreContribuyente != null){
			$("#nombreContribuyente").val(dataResponse.nombreContribuyente);
			$("#numBP").val(dataResponse.numBP);
			var dow = document.getElementById('table-download');
			ACC.opcionDeclaraciones.establecerEstiloDisplay(dow,'block');
		}else{
			alert("Error al consultar la información del contribuyente");
		}
		
		
		
	},
	
	
	validarAntesSubmitBuscarInfo : function(tipoDoc,numDoc){
		var validacionOK = false;
		
		if(tipoDoc != null && numDoc != null){
			validacionOK = true;
		}
		
		return validacionOK;
	},
	
	
	descargaFactura : function (){
		ACC.spinner.show();
		debugger;
		var numBP = $("#numBP").val();
		var anoGravable = "2022";
		var numObjeto = $("#numObjeto").val();
		var tipoOperacion = "1";
		
		if(ACC.descargaFacturaVA.validarAntesSubmitDescargaFactura(numBP,anoGravable,numObjeto,tipoOperacion)){
			var dataActual = {};	
			
			dataActual.numBP = numBP;
			dataActual.anoGravable = anoGravable;
			dataActual.numObjeto = numObjeto;
			dataActual.tipoOperacion = tipoOperacion;
			
			$.ajax({
				url : ACC.descargaFacturaVADescargarFacturaURL,
				data : dataActual,
				type : "GET",
				success : function(dataResponse) {
					
					ACC.spinner.close();
					ACC.facturacion.manejarRespuesta(dataResponse);
					
				}
			,
				error : function() {
					
					ACC.spinner.close();
					alert("Error procesar la solicitud de descarga de factura");	
				}
			});
		}
	 },
	 
	 
	 validarAntesSubmitDescargaFactura : function(numBP,anoGravable,numObjeto,tipoOperacion){
		var validacionOK = false;
		
		if(numBP != null && anoGravable != null && numObjeto != null && tipoOperacion != null){
			validacionOK = true;
		}
		
		return validacionOK;
	},
	
	
};