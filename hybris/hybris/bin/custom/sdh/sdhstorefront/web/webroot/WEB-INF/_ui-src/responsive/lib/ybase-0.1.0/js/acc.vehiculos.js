ACC.vehiculos = {

	_autoload : [ "bindLabelVerDetalle", "bindLabelVerDetVeh","bindPresentarDeclaracionVehiculoButton", "bindGeneraDeclaracionVehiculosButton","bindCalcularVehButton"],

	bindLabelVerDetalle : function() {
		$(document)
				.on(
						"click",
						".labelVerDetalle",
						function(e) {
							e.preventDefault();

							var tabRel = document.getElementById('tabRelacion');
							tabRel.style.display = 'none';
							$('#tabRelacion tbody').empty();
							var relUno = $.trim($(this).attr("data-relacion1"));
							var tipUno = $.trim($(this).attr("data-tipo1"));
							var numUno = $.trim($(this).attr("data-num1"));
							var nomUno = $.trim($(this).attr("data-nom1"));
							var relDos = $.trim($(this).attr("data-relacion2"));
							var tipDos = $.trim($(this).attr("data-tipo2"));
							var numDos = $.trim($(this).attr("data-num2"));
							var nomDos = $.trim($(this).attr("data-nom2"));
							var relTres = $
									.trim($(this).attr("data-relacion3"));
							var tipTres = $.trim($(this).attr("data-tipo3"));
							var numTres = $.trim($(this).attr("data-num3"));
							var nomTres = $.trim($(this).attr("data-nom3"));

							if (relUno == '' && relDos == '' && relTres == '') {
								alert("No cuenta con Relaciones");
							} else {

							}

							if (relUno != '') {
								$('#tabRelacion')
										.append(
												"<tr>"
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ relUno
														+ '" /></td>'
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ tipUno
														+ '" /></td>'
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ numUno
														+ '" /></td>'
														+ '<td><input style="width: 203px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ nomUno + '" /></td>');
							} else {

							}

							if (relDos != '') {
								$('#tabRelacion')
										.append(
												"<tr>"
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ relDos
														+ '" /></td>'
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ tipDos
														+ '" /></td>'
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ numDos
														+ '" /></td>'
														+ '<td><input style="width: 203px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ nomDos + '" /></td>');
							} else {

							}

							if (relTres != '') {
								$('#tabRelacion')
										.append(
												"<tr>"
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ relTres
														+ '" /></td>'
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ tipTres
														+ '" /></td>'
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ numTres
														+ '" /></td>'
														+ '<td><input style="width: 203px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ nomTres + '" /></td>');
							} else {

							}
							tabRel.style.display = 'block';

						});

	},
	
	bindPresentarDeclaracionVehiculoButton: function () {
		 $(document).on("click", "#bindPresentarDeclaracionVehiculoButton", function (e) {
	 	        e.preventDefault();
	 	        debugger;
	 	        
	 	        var anioGravable = $.trim($("#an").val());
	 	        var placa = $.trim($("#placas").val());
	 	       var numBPP  = $.trim($("#numBPP").val());
	 	       var numForma = $.trim($("#numFormdet").val());

	 	      
	 	      if(anioGravable == "0")
	 	        {	
	 	        	alert("Por favor, selecciona el año a consultar");
	 	        	return;
	 	        }
	 	        	
	 	        if(placa == "" || placa == "-")
	 	        {
	 	        	alert("Por favor, selecciona un vehiculo");
	 	        	return;
	 	        }
	 	       
	 	      window.location.href = ACC.vehiculosDeclararionURL+"?anioGravable="+anioGravable+"&placa="+placa+"&numBPP="+numBPP+"&numForma="+numForma;
	 	       
		 });
	 },
	 
	  bindGeneraDeclaracionVehiculosButton: function () {
		 $(document).on("click", "#generaDeclaracionVehiculosButton", function (e) {
				debugger;
	 	        e.preventDefault();
	 	        
	 	       var numForm  = $.trim($("#numForm").val());
	 	 
	 	       var data = {};
	 	       
	 	       data.numForm=numForm;
	 	
	 	      $.ajax({
		            url: ACC.vehiculosGeneraDeclaracionURL,
		            data: data,
		            type: "POST",
		            success: function (data) {
						
		            	$( "#dialogPublicidadExterior" ).dialog( "open" );
		            	if(data.errores)
	            		{
		            		$("#publicidadExteriorDialogContent").html("");
		            		$.each(data.errores, function( index, value ) {
    	            			$("#publicidadExteriorDialogContent").html($("#publicidadExteriorDialogContent").html()+value.txtmsj+"<br>");
    	            		});
		            		
		            		
	            		}else
	            		{
	            			$(".pagarbtn").attr("disabled", false);
	            			$("#publicidadExteriorDialogContent").html("");
	            			$("#publicidadExteriorDialogContent").html("La declaración se ha generado exitosamente.")
	            			
	            			$("#downloadHelper").attr("href",data.urlDownload);
	            			document.getElementById("downloadHelper").click();
							document.getElementById("action").disabled = false;
							
	            		}
	 	      		
		            },
		            error: function () {
		            	$( "#dialogPublicidadExterior" ).dialog( "open" );
		            	$("#publicidadExteriorDialogContent").html("Hubo un error al generar la declaración, por favor intentalo más tarde");
		            }
		        });
	 	       
		 });
	 },
	 
	 bindCalcularVehButton : function() {
			$(document).on("click", ".calcularVehButton", function(e) {
				e.preventDefault();
				
				debugger;

				var bpNum=$.trim($("#numBPcal").val());
				var placa=$.trim($("#placaDec").val());
				var numForm=$.trim($("#numForm").val());
				var anioGravable=$.trim($("#anioGravablecal").val());
				var opcionUso=$.trim($("#opcionUsocal").val());
				var clase=$.trim($("#clasecal").val());
				var idServicio=$.trim($("#idServiciocal").val());
				var cilindraje=$.trim($("#cilindrajecal").val());
				var marca=$.trim($("#marcacal").val());
				var linea=$.trim($("#lineacal").val());
				var modelo=$.trim($("#modelocal").val());
				var clasicoAntiguo=$.trim($("#clasicoAntiguocal").val());
				var checkAporte=$.trim($("#checkAportecal").val());
				var proyectoAporte=$.trim($("#proyecto").val());
				var blindado=$.trim($("#blindadocal").val());
				if(blindado == "S" || blindado == "s"){
					blindado = "X";
				}else{
				blindado = "N";
				}
				var capacidadTon=$.trim($("#capacidadToncal").val());
				var capacidadPas=$.trim($("#capacidadPascal").val());
				var avaluo=$.trim($("#avaluoAct").val());
				var claseSdh=$.trim($("#an").val());
				var tipoVehSdh=$.trim($("#an").val());
				var lineaHomologa=$.trim($("#an").val());
				var fuenteHomologa=$.trim($("#an").val());

				var data = {};

				data.bpNum=bpNum;
				data.placa=placa;
				data.numForm=numForm;
				data.anioGravable=anioGravable;
				data.opcionUso=opcionUso;
				data.clase=clase;
				data.idServicio=idServicio;
				data.cilindraje=cilindraje;
				data.marca=marca;
				data.linea=linea;
				data.modelo=modelo;
				data.clasicoAntiguo=clasicoAntiguo;
				data.checkAporte=checkAporte;
				data.proyectoAporte=proyectoAporte;
				data.blindado=blindado;
				data.capacidadTon=capacidadTon;
				data.capacidadPas=capacidadPas;
				data.avaluo=avaluo;
				data.claseSdh=claseSdh;
				data.tipoVehSdh=tipoVehSdh;
				data.lineaHomologa=lineaHomologa;
				data.fuenteHomologa=fuenteHomologa;

				$.ajax({
					url : ACC.vehiculosDeclaCalculoURL,
					data : data,
					type : "POST",
					success : function(data) {
						debugger;
		            	if(data.errores != null)
	            		{
		            		
							if (data.errores[0].txtmsj != null && data.errores[0].txtmsj != ""){
								alert(data.errores[0].txtmsj);
								
								//$( "#dialogVehiculos" ).dialog( "open" );
								//$("#vehiculosDialogContent").html("");
								//$.each(data.errores, function( index, value ) {
								//	$("#vehiculosDialogContent").html($("#publicidadExteriorDialogContent").html()+value.txtmsj+"<br>");
								//});
								
								$("#avaluoAct").val("");
								$("#valimpcar").val("");
								$("#valsemafo").val("");
								$("#despronpag").val("");
								$("#taract").val("");
								$("#totpag").val("");
								$("#sancion").val("");
								$("#valpagar").val("");
								$("#intereses").val("");
								$("#totpagvol").val("");
								$("#numForm").val("");
							
								
		            			//$('#generaDeclaracionButton').prop("disabled", true);
							}else{
								$("#avaluoAct").val(data.avaluo);
								$("#valimpcar").val(data.impuestoCargo);
								$("#valsemafo").val(data.valorSemafor);
								$("#despronpag").val(data.descuentoProntop);
								$("#taract").val(data.tarifaActual);
								$("#totpag").val(data.totalPagar);
								$("#sancion").val(data.sancion);
								$("#valpagar").val(data.valorPagar);
								$("#intereses").val(data.intereses);
								$("#totpagvol").val(data.totalPagoVol);
								$("#numForm").val(data.numForm);
								ACC.vehiculos.habilitarBotonPresentarDeclaracion();
							}
		            		
	            		}else
	            		{	            			
							$("#avaluoAct").val(data.avaluo);
	            			$("#valimpcar").val(data.impuestoCargo);
	            			$("#valsemafo").val(data.valorSemafor);
	            			$("#despronpag").val(data.descuentoProntop);
	            			$("#taract").val(data.tarifaActual);
	            			$("#totpag").val(data.totalPagar);
	            			$("#sancion").val(data.sancion);
	            			$("#valpagar").val(data.valorPagar);
	            			$("#intereses").val(data.intereses);
	            			$("#totpagvol").val(data.totalPagoVol);
	            			$("#numForm").val(data.numForm);
	            			ACC.vehiculos.habilitarBotonPresentarDeclaracion();
	            			
	            			
//	            			$('#generaDeclaracionButton').prop("disabled", false);
	            			
	            		}
	 	      		
		            

		},error: function () {
        	$( "#dialogVehiculos" ).dialog( "open" );
        	$("#vehiculosDialogContent").html("");
        	$("#vehiculosDialogContent").html("Hubo un error al realizar el cálculo, por favor intentalo más tarde");
        	$("#avaluoAct").val("");
			$("#valimpcar").val("");
			$("#valsemafo").val("");
			$("#despronpag").val("");
			$("#taract").val("");
			$("#totpag").val("");
			$("#sancion").val("");
			$("#valpagar").val("");
			$("#intereses").val("");
			$("#totpagvol").val("");
			$("#numForm").val("");
//			$("#calculoButton").prop('disabled', false);
        }
    });
    
});
},


	habilitarBotonPresentarDeclaracion: function(){
		var btnPresentarDec = document.getElementById("generaDeclaracionVehiculosButton");
		
		btnPresentarDec.disabled = false;
	},


	bindLabelVerDetVeh : function() {
		$(document).on("click", ".labelVerDetVeh", function(e) {
			e.preventDefault();
			var doc = document.getElementById('detalleVehiculos');
			doc.style.display='block';

			var placa = $.trim($(this).attr("data-placa"));
			var bpNum = $.trim($(this).attr("data-numbp"));
			var anioGravable = $.trim($("#an").val());

			if (anioGravable == "0") {
				alert("Por favor, selecciona el año a consultar");
				return;
			}

			var data = {};

			data.bpNum = bpNum;
			data.placa = placa;
			data.anioGravable = anioGravable;

			$.ajax({
				url : ACC.vehiculosDetalleURL,
				data : data,
				type : "GET",
				success : function(data) {
					ACC.vehiculos.fillFieldsFromData(data);

				},
				error : function() {
				}
			});
		});

	},

	fillFieldsFromData : function(data) {
		
		$('#tableJur tbody').empty();
		$('#tablemarcas tbody').empty();
		$('#tableLiq tbody').empty();
		$('#numFormdet').val(data.numForm);
		$("#placas").val(data.placa);

		if (data.idServicio == "01") {
			data.idServicio = "PARTICULAR";
		} else if (data.idServicio == "02") {
			data.idServicio = "PÚBLICO";
		} else if (data.idServicio == "03") {
			data.idServicio = "OFICIAL";
		} else {
			data.idServicio = "";
		}
		$("#inidServicio").val(data.idServicio);

		if (data.idEstado == "1") {
			data.idEstado = "ACTIVO";
		} else if (data.idEstado == "7") {
			data.idEstado = "INHABILITADO";
		} else if (data.idEstado == "8") {
			data.idEstado = "CANCELACIÓN";
		} else if (data.idEstado == "9") {
			data.idEstado = "TRASLADADO";
		} else {
			data.idEstado = "";
		}

		$("#inidEstado").val(data.idEstado);
		$("#inwatts").val(data.watts);

		if (data.clasicoAntig == "0") {
			data.clasicoAntig = "NO APLICA";
		} else if (data.clasicoAntig == "1") {
			data.clasicoAntig = "ANTIGUO";
		} else if (data.clasicoAntig == "2") {
			data.clasicoAntig = "CLASICO";
		} else {
			data.clasicoAntig = "";
		}
		$("#inclasico").val(data.clasicoAntig);

		if (data.tipoVeh == "1") {
			data.tipoVeh = "AUTOMÓVILES";
		} else if (data.tipoVeh == "2") {
			data.tipoVeh = "CAMPEROS Y CAMIONETAS";
		} else if (data.tipoVeh == "3") {
			data.tipoVeh = "CAMIONETAS DOBLE CABINA";

		} else if (data.tipoVeh == "4") {
			data.tipoVeh = "ELÉCTRICOS";

		} else if (data.tipoVeh == "5") {
			data.tipoVeh = "MOTOS Y MOTOCARROS";

		} else if (data.tipoVeh == "6") {
			data.tipoVeh = "PASAJEROS";

		} else if (data.tipoVeh == "7") {
			data.tipoVeh = "CARGA";
		} else if (data.tipoVeh == "8") {
			data.tipoVeh = "AMBULANCIAS";
		} else {
			data.tipoVeh = "";

		}

		$("#intipvehiculo").val(data.tipoVeh);

		$("#inpasajeros").val(data.capacidadPas);
		$("#inton").val(data.capacidadTon);
		$("#infecinacti").val(data.fechaDesde);
		$("#infechacambio").val(data.fechaCambio);
		$("#inTipo").val(data.tipoID);
		$("#inNomcom").val(data.nombre)

		var jur = data.datosJuridicos;

		if (jur != null) {
			for (var i = 0; i < jur.length; i++) {

				if (jur[i].calidad == "1") {
					jur[i].calidad = "PROPIETARIO";

				} else if (jur[i].calidad == "2") {
					jur[i].calidad = "FIDEICOMETENTE";
				} else if (jur[i].calidad == "3") {
					jur[i].calidad = "POSEEDOR";
				} else if (jur[i].calidad == "4") {
					jur[i].calidad = "BENEFICIARIO";
				} else if (jur[i].calidad == "5") {
					jur[i].calidad = "USUFRUCTUARIO";
				} else if (jur[i].calidad == "6") {
					jur[i].calidad = "ARRENDATARIO";
				} else {
					jur[i].calidad = "";
				}

				var fec1 = jur[i].fechaDesde;

				var anio = fec1.slice(0, 4);
				var mes = fec1.slice(4, 6);
				var dia = fec1.slice(6);
				jur[i].fechaDesde = dia + '/' + mes + '/' + anio;

				var fechasta = jur[i].fechaHasta;
				var anioh = fechasta.slice(0, 4);
				var mesh = fechasta.slice(4, 6);
				var diah = fechasta.slice(6);
				jur[i].fechaHasta = diah + '/' + mesh + '/' + anioh;
				$('#tableJur')
						.append(
								"<tr>"
										+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="'
										+ jur[i].calidad
										+ '" /></td>'
										+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ jur[i].procProp
										+ '" /></td>'
										+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ jur[i].fechaDesde
										+ '" /></td>'
										+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ jur[i].fechaHasta + '" /></td>');

			}
		} else {
			$('#tableJur')
					.append(
							"<tr>"
									+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="No cuenta con datos de marcas" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="" /></td>');
		}

		var marca = data.marcas;
		if (marca != null) {
			for (var i = 0; i < marca.length; i++) {
	
				var fec1 = marca[i].fechaDesde;

				var anio = fec1.slice(0, 4);
				var mes = fec1.slice(4, 6);
				var dia = fec1.slice(6);
				marca[i].fechaDesde = dia + '/' + mes + '/' + anio;

				var fechasta = marca[i].fechaHasta;
				var anioh = fechasta.slice(0, 4);
				var mesh = fechasta.slice(4, 6);
				var diah = fechasta.slice(6);
				marca[i].fechaHasta = diah + '/' + mesh + '/' + anioh;
				$('#tablemarcas')
						.append(
								"<tr>"
										+ '<td><input style="width: 95px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="'
										+ marca[i].codigoMarca
										+ '" /></td>'
										+ '<td><input style="width: 495px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ marca[i].descripcion
										+ '" /></td>'
										+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ marca[i].porcExencion
										+ '" /></td>'
										+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ marca[i].valorExencion
										+ '" /></td>'
										+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ marca[i].fechaDesde
										+ '" /></td>'
										+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ marca[i].fechaHasta + '" /></td>');

			}
		} else {
			$('#tablemarcas')
					.append(
							"<tr>"
									+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="No cuenta con dato Juridicos" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="" /></td>'
									+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="" /></td>'
									+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="" /></td>');
		}

		var liq = data.liquidacion

		if (liq != null) {
			for (var i = 0; i < liq.length; i++) {
				
//				var fecjur1 = liq[i].anio;
//				var mes = fecjur1.slice(4, 6);
//				var dia = fecjur1.slice(6);
//				var anio = fecjur1.slice(0, 4);
				
//				liq[i].anio = dia + '/' + mes + '/' + anio;;

				$('#tableLiq')
						.append(
								"<tr>"
										+ '<td><input style="width: 80px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="'
										+ liq[i].anio
										+ '" /></td>'
										+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ liq[i].avaluo
										+ '" /></td>'
										+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ liq[i].tarifa + '" /></td>');

			}
		} else {
			$('#tableLiq')
					.append(
							"<tr>"
									+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="No cuenta con datos de Liquidación" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="" /></td>');
		}

	}

};