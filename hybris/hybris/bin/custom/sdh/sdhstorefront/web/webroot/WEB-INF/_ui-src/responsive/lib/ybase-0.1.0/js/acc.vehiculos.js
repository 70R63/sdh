ACC.vehiculos = {
	flagMsjInfoObjeto : {},

	_autoload : [ "bindLabelVerDetalle", "bindLabelVerDetVeh","bindPresentarDeclaracionVehiculoButton", "bindGeneraDeclaracionVehiculosButton","bindCalcularVehButton","bindFormatoImporte"],

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
	 	        if(ACC.vehiculos.flagMsjInfoObjeto){
	 	        	ACC.vehiculos.mostrarMensajesInfoObjeto2();
	 	        	return;
	 	        }
				ACC.spinner.show();
	 	        var anioGravable = $.trim($("#an").val());
	 	        var placa = $.trim($("#placas").val());
	 	       var numBPP  = $.trim($("#numBPP").val());
	 	       var numForma = $.trim($("#numFormdet").val());

	 	      
	 	      if(anioGravable == "0")
	 	        {	
					$("#cargandoSpinner").html();
					spinnerdiv.style.display = 'none';
	 	        	alert("Por favor, selecciona el año a consultar");
	 	        	return;
	 	        }
	 	        	
	 	        if(placa == "" || placa == "-")
	 	        {
					ACC.spinner.close();
	 	        	alert("Por favor, selecciona un vehiculo");
	 	        	return;
	 	        }

	 	       // Confirmation message - sobrevehiculosautomotores
	 	      if(document.getElementById('opcionUso').value == "02"){
                var r = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
                if (r == true) {
					ACC.spinner.close();
                    window.location.href = ACC.vehiculosDeclararionURL+"?anioGravable="+anioGravable+"&placa="+placa+"&numBPP="+numBPP+"&numForma="+numForma;
                } else {
					ACC.spinner.close();
                    return;
                }
              }else{
				ACC.spinner.close();
                window.location.href = ACC.vehiculosDeclararionURL+"?anioGravable="+anioGravable+"&placa="+placa+"&numBPP="+numBPP+"&numForma="+numForma;
              }
		 });
	 },
	 
	  bindGeneraDeclaracionVehiculosButton: function () {
		 $(document).on("click", "#generaDeclaracionVehiculosButton", function (e) {

	 	        e.preventDefault();
				ACC.spinner.show();
 	        
	 	       var numForm  = $.trim($("#numForm").val());
	 	 
	 	       var data = {};
	 	       
	 	       data.numForm=numForm;
	 	
	 	      $.ajax({
		            url: ACC.vehiculosGeneraDeclaracionURL,
		            data: data,
		            type: "POST",
		            success: function (data) {
						ACC.spinner.close();
		            	$( "#dialogPublicidadExterior" ).dialog( "open" );
		            	if(data.errores && ( data.errores[0].idmsj != 0 ) )
	            		{
		            		$("#publicidadExteriorDialogContent").html("");
		            		$.each(data.errores, function( index, value ) {
    	            			$("#publicidadExteriorDialogContent").html($("#publicidadExteriorDialogContent").html()+value.txtmsj+"<br>");
    	            		});
		            		
		            		
	            		}else
	            		{
	            			$(".pagarbtn").attr("disabled", false);
	            			$("#publicidadExteriorDialogContent").html("");
	            			$("#publicidadExteriorDialogContent").html("La Declaración se ha presentado correctamente.")
	            			
	            			$("#downloadHelper").attr("href",data.urlDownload);
	            			document.getElementById("downloadHelper").click();
							document.getElementById("action").disabled = false;
							
	            		}
	 	      		
		            },
		            error: function () {
						ACC.spinner.close();
		            	$( "#dialogPublicidadExterior" ).dialog( "open" );
		            	$("#publicidadExteriorDialogContent").html("Hubo un error al generar la declaración, por favor intentalo más tarde");
		            }
		        });
	 	       
		 });
	 },
	 
	 bindCalcularVehButton : function() {
			$(document).on("click", ".calcularVehButton", function(e) {
				e.preventDefault();
				ACC.spinner.show();
				
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
						ACC.spinner.close();
						var mensajesError = "";
						$.each(data.errores, function( index, value ) {
            				if(value.txtmsj != null && value.txtmsj != ""){
								mensajesError = mensajesError + value.txtmsj + "\n";
							}
	            		});
						if(mensajesError.length>0){
							alert(mensajesError);
//								Estos se comentaron por reporte de incidencias inicio
//								$("#avaluoAct").val("");
//								$("#valimpcar").val("");
//								$("#valsemafo").val("");
//								$("#despronpag").val("");
//								$("#taract").val("");
//								$("#totpag").val("");
//								$("#sancion").val("");
//								$("#valpagar").val("");
//								$("#intereses").val("");
//								$("#totpagvol").val("");
//								$("#numForm").val("");
//								Estos se comentaron por reporte de incidencias fin
		            			// $('#generaDeclaracionButton').prop("disabled",
								// true);
						}else{
							$("#avaluoAct").val(data.avaluoActual);
							$("#valimpcar").val(data.impuestoCargo);
							$("#valsemafo").val(data.valorSemafor);
							$("#despronpag").val(data.descuentoProntop);
							$("#taract").val(data.tarifaActual);
							$("#totpag").val(data.totalPagar);
							$("#sancion").val(data.sancion);
							$("#valpagar").val(data.valorPagar);
							$("#intereses").val(data.intereses);
							$("#totpagvol").val(data.totalPagoVol);
							$("#descuentoconbustible").val(data.descuentoconbustible);
							$("#descuentoadicional").val(data.descuentoadicional);
							$("#numForm").val(data.numForm);
							ACC.vehiculos.habilitarBotonPresentarDeclaracion();
						}
		},error: function () {
			ACC.spinner.close();
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
			$("#descuentoconbustible").val("");
			$("#descuentoadicional").val("");
			$("#numForm").val("");
// $("#calculoButton").prop('disabled', false);
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
			ACC.spinner.show();

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
					ACC.spinner.close();
	            	ACC.vehiculos.leerMensajesInfoObjeto2(data.erroresWS);
					ACC.vehiculos.fillFieldsFromData(data);
                    document.getElementById('opcionUso').value = data.opcionUso;
				},
				error : function() {
					ACC.spinner.close();
				}
			});
		});

	},

	fillFieldsFromData : function(data) {
		
		$('#tableJur tbody').empty();
		$('#tablemarcas tbody').empty();
		$('#tableLiq tbody').empty();
		$('#numFormdet').val(data.numForm);
		$('#objetoCont').val(data.objetoCont);
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
				
// var fecjur1 = liq[i].anio;
// var mes = fecjur1.slice(4, 6);
// var dia = fecjur1.slice(6);
// var anio = fecjur1.slice(0, 4);
				
// liq[i].anio = dia + '/' + mes + '/' + anio;;

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

	},
	
	
	obtenerCatalogosInicialVehiculos : function(cat_valores_actuales, homologado,opcionUso,bloquearCampos_flag) {
		
		var elementoCat = null;
		elementoCat = document.getElementById("linea");
		$("#linea").prop("disabled", true );
		elementoCat = document.getElementById("cilindraje");
		$("#cilindraje").prop("disabled", true );
		
		dataActual = null;
		dataActual = ACC.vehiculos.determinarInfoInicialParaCatalogo("linea",cat_valores_actuales);
		ACC.vehiculos.obtenerCatalogosVehiculos(dataActual,"linea",cat_valores_actuales, homologado,opcionUso,bloquearCampos_flag);
		dataActual = ACC.vehiculos.determinarInfoInicialParaCatalogo("cilindraje",cat_valores_actuales);
		ACC.vehiculos.obtenerCatalogosVehiculos(dataActual,"cilindraje",cat_valores_actuales, homologado,opcionUso,bloquearCampos_flag);
		
		
	},
	
	
	actualizaHomologado : function(homologado,opcionUso,controlCampos) {
	
		if(homologado == "X"){
			switch (opcionUso){
				case "01":
					ACC.vehiculos.bloquearCampos(controlCampos);
					break;
				case "02":
					controlCampos.linea = false;
					controlCampos.cilindraje = false;
					controlCampos.avaluoAct = true;
					ACC.vehiculos.bloquearCampos(controlCampos);
					break;
				default:
					break;
			}
		}else{
			ACC.vehiculos.bloquearCampos(controlCampos);
		}
		
		
	},
	
	
	bloquearCampos : function(controlCampos) {
	
		$("#linea").prop("disabled",controlCampos.linea);
		$("#cilindraje").prop("disabled",controlCampos.cilindraje);
		$("#avaluoAct").prop("disabled",controlCampos.avaluoAct);
				
	},
	
	
	obtenerCatalogosVehiculos : function(dataActual, campo_catalogo, cat_valores_actuales, homologado,opcionUso,bloquearCampos_flag) {
		ACC.spinner.show();
		$.ajax({
			url : ACC.vehiculosCatalogosURL,
			data : dataActual,
			type : "GET",
			success : function(dataResponse) {
				
				ACC.spinner.close();
				ACC.vehiculos.updateFromResponse_catalogos(campo_catalogo,cat_valores_actuales,dataActual,dataResponse, homologado,opcionUso,bloquearCampos_flag);					
			},
			error : function() {
				ACC.spinner.close();
				alert("Error al obtener el catalogo de:"+campo_catalogo);
			}
		});
		
		
	},
	
	
	updateFromResponse_catalogos : function(campo_catalogo, cat_valores_actuales, infoActual, infoResponse, homologado,opcionUso,bloquearCampos_flag){
		var registrosAgregados = 0;
		var controlCampos = {};

		controlCampos.avaluoAct = true;		
		if(bloquearCampos_flag){
			controlCampos.linea = true;
			controlCampos.cilindraje = true;
		}else{
			controlCampos.linea = false;
			controlCampos.cilindraje = false;
		}
		
		if(campo_catalogo == 'linea'){
			$("#linea").find("option:gt(0)").remove();
			$("#linea").find("option:eq(0)").remove();
			
			$('#linea').append('<option value="">'+ "Seleccionar" + "</option>");
			$.each(infoResponse.catalogo.vehicularlinearesponse, function (index,value){
				$('#linea').append('<option value="'+ value.linea.trim() +'">'+ value.desc_linea + "</option>");
			});
			$("#linea").val(cat_valores_actuales[3]);
		}else if(campo_catalogo == 'cilindraje'){
			$("#cilindraje").find("option:gt(0)").remove();
			$("#cilindraje").find("option:eq(0)").remove();
			
			if(infoResponse.catalogo.vehicularcilindrajeresponse == null){
				$('#cilindraje').append('<option value="">'+ "No se encontraron opciones" + "</option>");
			}else{
				$('#cilindraje').append('<option value="">'+ "Seleccionar" + "</option>");
				$.each(infoResponse.catalogo.vehicularcilindrajeresponse, function (index,value){
					if(value.cilindraje != null && value.cilindraje != ""){
						$('#cilindraje').append('<option value="'+ value.cilindraje.trim() +'">'+ value.cilindraje + "</option>");
						registrosAgregados++;
					}
				});
			}
			if(registrosAgregados > 0){
				var valueSelected = "";
				if(cat_valores_actuales!=null && cat_valores_actuales[1] != "" ){
					if($('#cilindraje option').length == 1){
						$('#cilindraje').append('<option value="'+cat_valores_actuales[1]+'">'+ cat_valores_actuales[1] + "</option>");				
					}
					valueSelected = cat_valores_actuales[1];
				}
				$("#cilindraje").val(valueSelected);
			}else{
				$("#cilindraje").find("option:eq(0)").remove();
				$('#cilindraje').append('<option value="0">'+ "Seleccionar" + "</option>");
				controlCampos.avaluoAct = false;
			}
		}else if(campo_catalogo == 'avaluo'){
			if(infoResponse.catalogo.avaluoactual  == null){
				if(infoResponse.catalogo.errores != undefined){
					var error = infoResponse.catalogo.errores;
					var tam = error.length;
					var showerror = $("#AvaluoMensaje");
					showerror.style.display = 'block';
					for(var i = 0; i<=tam; i++){
						$("#mensajeAvaluo").val(error.txt_msj);
					}
				}
			}else{
				switch(infoResponse.catalogo.avaluoactual){
					case "":
						$("#avaluoAct").val(infoResponse.catalogo.avaluoactual);
						if(!bloquearCampos_flag){
							controlCampos.avaluoAct = false;
						}
						$(document).off("change", "#avaluoAct", ACC.vehiculos.validacionMonto_avaluoAct);
						$(document).on("change", "#avaluoAct", ACC.vehiculos.validacionMonto_avaluoAct);
						break;
					default:
						var showerror = $("#AvaluoMensaje");
						showerror.style.display = 'none';
						controlCampos.avaluoAct = true;
						$("#avaluoAct").val(infoResponse.catalogo.avaluoactual);
						if(!ACC.vehiculos.validacionMontoAD_generica_estricta($("#avaluoAct").data("valoriginal"),infoResponse.catalogo.avaluoactual)){
							alert("El avaluo no puede ser menor al original");
							$("#linea").val("");
							$("#cilindraje").val("");
							$("#avaluoAct").val("");
						}
						break;
				}
			}
		}
		
		if(bloquearCampos_flag){
			ACC.vehiculos.bloquearCampos(controlCampos);
		}else{
			ACC.vehiculos.actualizaHomologado(homologado,opcionUso,controlCampos);			
		}


	},
	
	
	determinarInfoParaCatalogo : function(campo_catalogo){
		var data = {};
		
		data.campo_catalogo = campo_catalogo;
		if(campo_catalogo == 'linea'){
			data.marca = ACC.vehiculos.obtenerCampo('marca');
		}else if(campo_catalogo == 'cilindraje'){
			data.marca = ACC.vehiculos.obtenerCampo('marca');
			data.linea = ACC.vehiculos.obtenerCampo('linea');
			data.modelo = ACC.vehiculos.obtenerCampo('modelo');
		}else if(campo_catalogo == 'avaluo'){
			data.clase = ACC.vehiculos.obtenerCampo('clase');
			data.cilindraje = ACC.vehiculos.obtenerCampo('cilindraje');
			data.marca = ACC.vehiculos.obtenerCampo('marca');
			data.linea = ACC.vehiculos.obtenerCampo('linea');
			data.modelo = ACC.vehiculos.obtenerCampo('modelo');
			data.carroceria = ACC.vehiculos.obtenerCampo('carroceria');
		}
		
		return data;
	},
	
	
	determinarInfoInicialParaCatalogo : function(campo_catalogo,cat_valores_actuales){
		var data = {};
		
		data.campo_catalogo = campo_catalogo;
		if(campo_catalogo == 'linea'){
			data.marca = cat_valores_actuales[2];
		}else if(campo_catalogo == 'cilindraje'){
			data.marca = cat_valores_actuales[2];
			data.linea = cat_valores_actuales[3];
			data.modelo = cat_valores_actuales[4];
		}else if(campo_catalogo == 'avaluo'){
			data.clase = cat_valores_actuales[0];
			data.cilindraje = cat_valores_actuales[1];
			data.marca = cat_valores_actuales[2];
			data.linea = cat_valores_actuales[3];
			data.modelo = cat_valores_actuales[4];
			data.carroceria = cat_valores_actuales[5];
		}
		
		return data;
	},
	
	
	obtenerCampo : function(nombre_campo){
		 var campo = document.getElementById(nombre_campo);
		 var val_campo = "";
		 
		 if(campo!=null){
			 val_campo = campo.value;
		 }
		 
		 return val_campo;
	},
	
	
	leerMensajesInfoObjeto2 : function(errores){
		ACC.vehiculos.flagMsjInfoObjeto = false;
		
		$.each(errores, function (index,value){
			switch (value.id_msj) {
				case "07":
				case "08":
					ACC.vehiculos.flagMsjInfoObjeto = true;
					mensaje = value.txt_msj;
					$("#dialogMensajesContent").html("");
		    		$("#dialogMensajesContent").html(mensaje.trim()+"<br>");
					break;
	
				default:
					break;
			}
		});

	 },
	 
	mostrarMensajesInfoObjeto2 : function(errores){		
        $("#dialogMensajes" ).dialog( "open" );

	 },
	 
	bindFormatoImporte : function(){
		$(document).on("change",".valFormatoImporte",function(e){
			e.preventDefault();
			var campoImporte = e.target.value;
			var formateado = ACC.vehiculos.formateoImporte1(e.target.value);
			if(formateado != null){
				e.target.value = formateado;
			}else{
				e.target.value = "0,00";
			}			
			
		});
	},
	
	
	formateoImporte1 : function(campoImporte) {
		var campoImporteTemp = "";
		var formateado = null;
		
		campoImporteTemp = campoImporte;
		campoImporteTemp = campoImporteTemp.replaceAll(" ","");
		campoImporteTemp = campoImporteTemp.replaceAll(".","");
		campoImporteTemp = ACC.vehiculos.reemplazarTodasMenosUltima(campoImporteTemp,",","");
		campoImporteTemp = campoImporteTemp.replaceAll(",",".");
		if(!isNaN(campoImporteTemp)){
			var campoImporteFloat = parseFloat(campoImporteTemp);
			formateado = (campoImporteFloat).toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&.');
			var n = formateado.lastIndexOf(".");
			if (n >= 0) {
				formateado = formateado.substring(0, n) + "," + formateado.substring(n+1, formateado.length);
			}			
		}
	
		return formateado;
	},
	
	
	reemplazarTodasMenosUltima : function(cadenaOriginal,strBusqueda,strReemplazo){
		var cadenaNueva = "";
		
		var indiceUltima = cadenaOriginal.lastIndexOf(strBusqueda);
		var cadenaTempInicio = cadenaOriginal.substring(0, indiceUltima).replaceAll(strBusqueda,strReemplazo);
		
		cadenaNueva = cadenaTempInicio + cadenaOriginal.substring(indiceUltima, cadenaOriginal.length);
		
		return cadenaNueva;
	},
	
	
	cargarDescripciones : function(){
		$('.td_blindado').each( function( index,value ) {
			$(value).html(ACC.opcionDeclaraciones.obtenerDesc_blindado($(value).html()));
		});
		$('.td_carroceria').each( function( index,value ) {
			$(value).html(ACC.opcionDeclaraciones.obtenerDesc_carroceria($(value).html()));
		});
		$('.td_clase').each( function( index,value ) {
			$(value).html(ACC.opcionDeclaraciones.obtenerDesc_clase($(value).html()));
		});
		$('.td_linea').each( function( index,value ) {
			$(value).html(ACC.opcionDeclaraciones.obtenerDesc_linea($(value).html()));
		});
		$('.td_marca').each( function( index,value ) {
			$(value).html(ACC.opcionDeclaraciones.obtenerDesc_marca($(value).html()));
		});
		ACC.publicidadexterior.bindDataTable_id("#tabla_vehi");
		
	},
	
	cargarDescripciones_val : function(){
		$('.td_blindado').each( function( index,value ) {
			$(value).val(ACC.opcionDeclaraciones.obtenerDesc_blindado($(value).val()));
		});
		$('.td_carroceria').each( function( index,value ) {
			$(value).val(ACC.opcionDeclaraciones.obtenerDesc_carroceria($(value).val()));
		});
		$('.td_clase').each( function( index,value ) {
			$(value).val(ACC.opcionDeclaraciones.obtenerDesc_clase($(value).val()));
		});
		$('.td_linea').each( function( index,value ) {
			$(value).val(ACC.opcionDeclaraciones.obtenerDesc_linea($(value).val()));
		});
		$('.td_marca').each( function( index,value ) {
			$(value).val(ACC.opcionDeclaraciones.obtenerDesc_marca($(value).val()));
		});
		
	},
	
	
	validacionMonto_avaluoAct : function(){
		if(!ACC.vehiculos.validacionMonto1_avaluoAct()){
			alert("El valor del avaluo debe mayor o igual al original");
			$("#avaluoAct").val($("#avaluoAct").data("valoriginal"));
		}
		
		
	},
	
	
	validacionMonto1_avaluoAct : function(){
		var validacion = false;
		var valoriginal = $("#avaluoAct").data("valoriginal");
		var val5milmillones = "5000000000";
		var valorAvaluo = $("#avaluoAct").val();
		
		if(ACC.predial.validacionMontoAD_generica(valoriginal,valorAvaluo) && ACC.predial.validacionMontoAD_generica(valorAvaluo,val5milmillones)){
			validacion = true;
		}
		
		return validacion;
	},
	
	
	validacionMonto2_avaluoAct : function(){
		var validacion = false;
		var valorOriginal = ($("#avaluoAct").data("valoriginal")).toString();
		var valorAvaluo = $("#avaluoAct").val();
		
		if(ACC.predial.validacionMontoAD_generica(valorOriginal,valorAvaluo)){
			validacion = true;
		}
		
		return validacion;
	}


};