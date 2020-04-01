ACC.predial = {

	_autoload : [ "bindoptionNo", "bindprophorizontal","bindGeneraDeclaracionButton_predial", "bindMostrarAporteVolintario"],

	bindoptionNo : function() {
		$(document).on("click", ".optradio", function() {
			
			var valo = this.value;
			var pro = document.getElementById('proyecto');

			if (valo == '2') {
				pro.style.display = 'none';
				$('#ValorAporteVoluntario').prop('disabled', true);				
			} else if (valo == '1') {
				pro.style.display = 'block';
				$('#ValorAporteVoluntario').prop('disabled', false);				
			}

		});
	},
	
	bindMostrarAporteVolintario : function(){
//		debugger;
		var mostrarAporteVoluntario = document.getElementById('mostrarAporteVoluntario');
		if (mostrarAporteVoluntario != null && mostrarAporteVoluntario.value == "true"){
			$('#proyectoLiq').prop('disabled', false);
			$('#optionSi').prop('disabled', false);
			$('#optionNo').prop('disabled', false);
		}else{
			$('#proyectoLiq').prop('disabled', true);
			$('#optionSi').prop('disabled', true);
			$('#optionNo').prop('disabled', true);
		}		
	},	
	
	bindprophorizontal : function() {
		$(document).on("change", ".prophorizontal", function(e) {
			e.preventDefault();
			var val = this.value;

			if (val == 'Si') {
				$('#areaconstruccion').prop('disabled', false);
				;
				$('#areaterreno').prop('disabled', true);
				;
			} else if (val == 'No') {
				$('#areaconstruccion').prop('disabled', false);
				;
				$('#areaterreno').prop('disabled', false);
				;
			} else {
				$('#areaconstruccion').prop('disabled', true);
				;
				$('#areaterreno').prop('disabled', true);
				;
			}

		});
	},

	detalle_tres : function(anioGravable, chip, matrInmobiliaria) {
	
		var show = document.getElementById('InicialDetalle');
		show.style.display = 'block';

		$('#DatosEconomicos tbody').empty();
		$('#DatosFisicosPredial tbody').empty();
		$('#DatosLiquidaPredial tbody').empty();
		$('#MarcasPredial tbody').empty();

		var data = {};

		data.anioGravable = anioGravable;
		data.CHIP = chip;
		data.matrInmobiliaria = matrInmobiliaria;

		$("#reCHIP").val(data.CHIP);
		$("#rematrInmobiliaria").val(data.matrInmobiliaria);
		$("#reanioGravable").val(data.anioGravable);

		$
				.ajax({
					url : ACC.predialDetalleURL,
					data : data,
					type : "GET",
					success : function(result) {
						console.log(result);
						$(".chip").val(result.chip);
						$("#opcUsoPredialUni").val(result.opcionuso);
						var econo = result.datosEconomicos;
						$('#DatosEconomicos')
								.append(
										"<tr>"
												+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="'
												+ econo.baseGravable
												+ '" /></td>'
												+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ econo.avaluoCatastral
												+ '" /></td>'
												+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ econo.avaluoContratoArriendo
												+ '" /></td>'
												+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ econo.avaluoMejoraConstruccion
												+ '" /></td>');

						var datJur = result.datosJuridicos;
						$("#JurOtros").val(datJur.otros);
						$("#JurProp").val(datJur.porcentajePropiedad);
						var cal = datJur.calidadSujecion;

						if (cal == "1") {
							$("#JurCal").val("Propietario");
						} else if (cal == "2") {
							$("#JurCal").val("Fideicometente");
						} else if (cal == "3") {
							$("#JurCal").val("Pseedor");
						} else if (cal == "4") {
							$("#JurCal").val("Beneficiario");
						} else if (cal == "5") {
							$("#JurCal").val("Usufructuario");
						} else if (cal == "6") {
							$("#JurCal").val("Arrendatario");
						} else {
							$("#JurCal").val("-");
						}

						// $("#JurCal").val(datJur.calidadSujecion);
						$("#JurTipDoc").val(result.tipDoc);
						$("#JurNom").val(result.compleName);
						$("#JurNumDoc").val(result.numDoc);

						var datFis = result.datosFisicos;
						$('#DatosFisicosPredial')
								.append(
										"<tr>"
												+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="'
												+ datFis.areaConstruida
												+ '" /></td>'
												+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ datFis.areaTerrenoCatastro
												+ '" /></td>'
												+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ datFis.codigoEstrato
												+ '" /></td>'
												+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ datFis.areaTerrenoMejora
												+ '" /></td>'
												+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ datFis.areaTerrenoMatrizMejora
												+ '" /></td>'
												+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ datFis.areaTerrenoMejoraCatastro
												+ '" /></td>');

						var datLiq = result.estrLiquidacionPredial;
						var deshac = datLiq.destinoHacendario;
						var destino = "";

						if (deshac == "61") {
							destino = "Residenciales urbanos y rurales";
						} else if (deshac == "62") {
							destino = "Comerciales urbanos y rurales";
						} else if (deshac == "63") {
							destino = "Financiero";
						} else if (deshac == "64") {
							destino = "Industriales urbanos y rurales";
						} else if (deshac == "65") {
							destino = "Depositos y parqueaderos";
						} else if (deshac == "66") {
							destino = "Dotacionales";
						} else if (deshac == "67") {
							destino = "Lote/Urbanizables no urbanizados/urbanizados no edificados";
						} else if (deshac == "69") {
							destino = "Pequeña propiedad rural para producción agropecuaria";
						} else if (deshac == "70") {
							destino = "No urbanizables";
						} else if (deshac == "71") {
							destino = "Rurales";
						} else if (deshac == "72") {
							destino = "Sistema de áreas protegidas";
						} else {
							destino = "-";
						}

						$('#DatosLiquidaPredial')
								.append(
										"<tr>"
												+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="'
												+ datLiq.baseGravable
												+ '" /></td>'
												+ '<td><input style="width: 403px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ destino
												+ '" /></td>'
												+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ datLiq.tarifaLiquidacion
												+ '" /></td>'
												+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
												+ datLiq.valorImpuesto
												+ '" /></td>');

						var marc = result.marcas;

						if (marc != null) {
							for (var i = 0; i < marc.length; i++) {
								
								
								var desmarc = "";
								if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "1") {
									desmarc = "SALÓN COMUNAL";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "10") {
									desmarc = "INSTALACIONES MILITARES Y DE POLICÍA";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "11") {
									desmarc = "PARQUES PÚBLICOS";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "13") {
									desmarc = "RAMA JUDICIAL";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "16") {
									desmarc = "PREDIOS RESIDENCIALES ESTRATO 1  Y 2 NO OBLIG";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "2") {
									desmarc = "SSP NO OBLIGADOS";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "4") {
									desmarc = "IGLESIA";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "5") {
									desmarc = "BIENES DE USO PÚBLICO";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "6") {
									desmarc = "DEFENSA CIVIL COLOMBIANA";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "7") {
									desmarc = "DISTRITAL";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "8") {
									desmarc = "CRUZ ROJA COLOMBIANA";
								} else if (marc[i].tipoMarca == "1"
										&& marc[i].marca == "9") {
									desmarc = "EMBAJADAS";
								} else if (marc[i].tipoMarca == "2"
										&& marc[i].marca == "1") {
									desmarc = "SECUESTRADO";
								} else if (marc[i].tipoMarca == "2"
										&& marc[i].marca == "2") {
									desmarc = "ATENTADO O CATÁSTROFE";
								} else if (marc[i].tipoMarca == "2"
										&& marc[i].marca == "3") {
									desmarc = "BIEN DE INTERÉS CULTURAL";
								} else if (marc[i].tipoMarca == "2"
										&& marc[i].marca == "4") {
									desmarc = "BANCO DE SUELOS DISTRITAL";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "1") {
									desmarc = "SIN AVALÚO CATASTRAL";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "10") {
									desmarc = "SIN SUJETO VALIDO";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "11") {
									desmarc = "PREDIOS INCAUTADOS IMPRODUCTIVOS";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "12") {
									desmarc = "PREDIOS INCAUTADOS PRODUCTIVOS";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "2") {
									desmarc = "LOTES EN PH SIN CONSTRUIR";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "3") {
									desmarc = "AREA CONSTRUIDA 0 Y ÁREA TERRENO 0";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "4") {
									desmarc = "DESTINO HACENDARIO 0";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "5") {
									desmarc = "INCONSISTENCIA POR ÁREA CONSTRUIDA";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "6") {
									desmarc = "INCONSISTENCIA POR USO CATASTRAL";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "7") {
									desmarc = "RESIDENCIAL URBANO SIN ESTRATO";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "8") {
									desmarc = "SIN DIRECCIÓN DE NOTIFICACIÓN";
								} else if (marc[i].tipoMarca == "3"
										&& marc[i].marca == "9") {
									desmarc = "IMPUESTO CERO";
								} else if (marc[i].tipoMarca == "4"
										&& marc[i].marca == "1") {
									desmarc = "DISTRITO PARCIAL";
								} else if (marc[i].tipoMarca == "4"
										&& marc[i].marca == "2") {
									desmarc = "IGLESIA PARCIAL";
								} else if (marc[i].tipoMarca == "4"
										&& marc[i].marca == "3") {
									desmarc = "SALON PARCIAL";
								} else if (marc[i].tipoMarca == "4"
										&& marc[i].marca == "4") {
									desmarc = "USO PÚBLICO PARCIAL";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "1") {
									desmarc = "FINANCIERO";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "10") {
									desmarc = "RESIDENCIALES SUELO EXPANSION";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "11") {
									desmarc = "DEPÓSITO";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "12") {
									desmarc = "RESTRICCIÓN ÍNDICE OCUPACIÓN";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "13") {
									desmarc = "ID MEJORA MATRIZ";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "14") {
									desmarc = "IMPACTO PREDIO";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "15") {
									desmarc = "MUTACION FISICA";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "16") {
									desmarc = "OPAIN";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "2") {
									desmarc = "ZONA FRANCA";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "3") {
									desmarc = "ÁREAS PROTEGIDAS";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "4") {
									desmarc = "TENDERO";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "5") {
									desmarc = "PREDIOS RESID. TARIFA ESPECIAL";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "6") {
									desmarc = "NO URBANIZABLES";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "7") {
									desmarc = "PPR-UAF";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "8") {
									desmarc = "GARAJES Y DEPOSITOS CON USO 090";
								} else if (marc[i].tipoMarca == "5"
										&& marc[i].marca == "9") {
									desmarc = "ASISTENCIA PÚBLICA";
								} else {
									desmarc = "-";
								}

								var destipmarc = "";
								if (marc[i].tipoMarca == "1") {
									destipmarc = "EXCLUIDO";
								} else if (marc[i].tipoMarca == "2") {
									destipmarc = "EXENTO";
								} else if (marc[i].tipoMarca == "3") {
									destipmarc = "INCONSISTENTE";
								} else if (marc[i].tipoMarca == "4") {
									destipmarc = "EXCLUSION PARCIAL";
								} else if (marc[i].tipoMarca == "5") {
									destipmarc = "AFECTA LIQUIDACIÓN";
								} else {
									destipmarc = "-";
								}

								var conhis = "";

								if (marc[i].conservacionHistorica == "I") {
									conhis = "CONSERVACIÓN INTEGRAL";
								} else if (marc[i].conservacionHistorica == "M") {
									conhis = "CONSERVACIÓN MONUMENTAL";
								} else if (marc[i].conservacionHistorica == "N") {
									conhis = "SIN CONSERVACIÓN (VALOR POR DEFECTO)";
								} else if (marc[i].conservacionHistorica == "T") {
									conhis = "CONSERVACIÓN TIPOLÓGICA";
								} else {
									"-";
								}

								$('#MarcasPredial')
										.append(
												"<tr>"
														+ '<td><input style="width: 190px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="'
														+ desmarc
														+ '" /></td>'
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ destipmarc
														+ '" /></td>'
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ marc[i].porcMarca
														+ '" /></td>'
														+ '<td><input style="width: 80px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ marc[i].valorExencion
														+ '" /></td>'
														+ '<td><input style="width: 190px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ conhis + '" /></td>');

							}

						}

						var tipoRegistro = result.estrLiquidacionPrivada;
						$("#retipRegistro").val(tipoRegistro.tipoRegistro);
						
						var tipdeclar = result.estrDatosGenerales;
						$("#retipDeclaracion").val(tipdeclar.tipoDeclaracion);



					},
					error : function() {
						alert("Error al consultar el Detalle del Predio, Intentalo más tarde");
					}
				});

	},

	declaracionPredial : function() {


		var chip = $("#reCHIP").val();
		var inmo = $("#rematrInmobiliaria").val();
		var anio = $("#reanioGravable").val();
		var tipReg = $("#retipRegistro").val();

		var data ={};

		data.anioGravable = anio;
		data.CHIP = chip;
		data.matrInmobiliaria = inmo;
		data.retipRegistro = tipReg;

		var URL = "";

		if (tipReg == "1") {
			URL = ACC.predialDeclaraURL;

		} else if (tipReg == "2") {
			URL = ACC.predialDeclaradosURL;

		} else if (tipReg == "3") {
			URL = ACC.predialDeclaratresURL;

		} else if (tipReg == "4") {
			URL = ACC.predialDeclaracuatroURL;

		} else if (tipReg == "5") {
			URL = ACC.predialDeclaracincoURL;

		} else if (tipReg == "6") {
			URL = ACC.predialDeclaraseisURL;

		} else if (tipReg == "7") {
			URL = ACC.predialDeclarasieteURL;

		} else if (tipReg == "8") {
			URL = ACC.predialDeclaraochoURL;

		} else if (tipReg == "9") {
			URL = ACC.predialDeclarabasesURL;
		} else {
			alert("El tipo de registro no existe");
		}

	},

	calculoPredial : function() {
		debugger;
		var dataForm = {};
		dataForm.numBP = $("#NumBP").val();
		dataForm.chipcalculo = $("#CHIP").val();
		dataForm.matrInmobiliaria = $("#MatrInmobiliaria").val();
		dataForm.anioGravable = $("#AnioGravable").val();
		dataForm.opcionuso = $("#OpcionUso").val();
		
		var newLiquidacionRequ = {};
		
		var checkAporteRadio = $("input[name='optradio']:checked"). val();
				
				if(checkAporteRadio == '1')
				{
					newLiquidacionRequ.aporteVoluntario="X";
					
				
				}else{
					newLiquidacionRequ.aporteVoluntario="";
				}
				
				//LiquidacionPrivada.AporteVoluntario = $("#AporteVoluntario").val();
				newLiquidacionRequ.proyecto = $("#proyectoLiq").val();
				
				dataForm.newLiquidacionRequ = newLiquidacionRequ;
	
				
		
		var DatosLiquidacion = {};
		DatosLiquidacion.TipoDeclaracion = $("#TipoDeclaracion").val();
		DatosLiquidacion.PorcentajePropiedad =$("#PorcentajePropiedad").val();
		DatosLiquidacion.PorcentajeExclusion =$("#porceexclu").val();
		DatosLiquidacion.PorcentajeExencion =$("#porcenexe").val();
		DatosLiquidacion.TarifaLiquidacion = $("#TarifaLiquidacion").val();
		DatosLiquidacion.DestinoHacendario = $("#DestinoHacendario").val();
		DatosLiquidacion.BaseGravable = $("#BaseGravable").val();
		DatosLiquidacion.CanonArrendamiento = $("#CanonArrendamiento").val();
		DatosLiquidacion.CalidadSujecion = $("#CalidadSujecion").val();
		DatosLiquidacion.AvaluoMatrizMejora = $("#AvaluoMatrizMejora").val();
		DatosLiquidacion.AreaTerrenoMejoraContrib = $("#AreaTerrenoMejoraContribuye").val();
		DatosLiquidacion.AvaluoProrrateado = $("#AvaluoProrrateado").val();
		DatosLiquidacion.AvaluoIndiceEdificabilidad = $("#AvaluoIndiceEdificabilidad").val();
		DatosLiquidacion.ExclusionParcial = $("#ExclusionParcial").val();
		dataForm.newDatosLiquidacion = DatosLiquidacion;

		var calcLiquidacionPrivada ={};
		debugger;
		var checkAporteRadio = $("input[name='optradio']:checked"). val();
		
		if(checkAporteRadio == '1')
		{ 
			calcLiquidacionPrivada.AporteVoluntario="X";
			
		
		}else{
			calcLiquidacionPrivada.AporteVoluntario="";
		}
		
		//LiquidacionPrivada.AporteVoluntario = $("#AporteVoluntario").val();
		calcLiquidacionPrivada.Proyecto = $("#proyectoLiq").val();
		
		dataForm.calcLiquidacionPrivada = calcLiquidacionPrivada;
		
		var newLiquidacionRequ = {};
		
var checkAporteRadio = $("input[name='optradio']:checked"). val();
		
		if(checkAporteRadio == '1')
		{
			newLiquidacionRequ.AporteVoluntario="X";
			
		
		}else{
			newLiquidacionRequ.AporteVoluntario="";
		}
		
		//LiquidacionPrivada.AporteVoluntario = $("#AporteVoluntario").val();
		newLiquidacionRequ.Proyecto = $("#proyectoLiq").val();
		
		dataForm.newLiquidacionRequ = newLiquidacionRequ;
		
		
		
		
		$.ajax({
			url : ACC.calculoPredialURL,
			data: JSON.stringify(dataForm),
			//data : data,
			type : "POST",
			 dataType: "json",
			contentType: "application/json",
			success : function(result) {
			    debugger;
				var actualErrors = [];
            	
            	if(result.errores)
            	{
            		$.each(result.errores, function( index, value ) {
            			if(value.idError != "0" && value.idError != "00" && value.idError != "")
            			actualErrors.push(value);
            		});
            	}
            	if(actualErrors.length > 0)
        		{
            		$( "#dialogICA" ).dialog( "open" );
            		$("#icaDialogContent").html("");
            		$.each(result.errores, function( index, value ) {
            			$("#icaDialogContent").html($("#icaDialogContent").html()+value.descError+"<br>");
            		});
            		
            		  		
        		}else
        		{
				
        			$( "#dialogICA" ).dialog( "open" );
        			$("#icaDialogContent").html("El cálculo se ha realizado exitosamente.");
        			$("#numForm").val(result.numFrom);
        			var liq = result.liquidacionPrivada;
    			$("#ValorImpuestoACargo").val(liq.valorImpuestoACargo);
				$("#ValorImpuestoAjustadoActual").val(result.liquidacionPrivada.aporteVoluntario);
				$("#DescuentoPorIncrementoDiferencias").val(result.liquidacionPrivada.descuentoIncrementoDiferencial);
				$("#ValorImpuestoAjustadoActual").val(result.liquidacionPrivada.valorImpuestoAjustadoActual);
				$("#Sancion").val(result.liquidacionPrivada.sancion);
				$("#TotalSaldoACargo").val(result.liquidacionPrivada.totalSaldoACargo);
				$("#ValorAPagar").val(result.liquidacionPrivada.valorAPagar);
				$("#DescuentoPorProntoPago").val(result.liquidacionPrivada.descuentoPorProntoPago);
				$("#DescuendoAdicional1").val(result.liquidacionPrivada.descuendoAdicional1);
				$("#Intereses").val(result.liquidacionPrivada.intereses);
				$("#TotalAPagar").val(result.liquidacionPrivada.totalAPagar);
				$("#ValorAporteVoluntario").val(result.liquidacionPrivada.valorAporteVoluntario);
				$("#TotalConPagoVoluntario").val(result.liquidacionPrivada.totalConPagoVoluntario);
				
				
				if(liq.proyecto == "1"){
					$("#proyectoLiq").val('01');
				}else if(liq.proyecto == "2"){
					$("#proyectoLiq").val('02');
        		}else{
        			$("#proyectoLiq").val('00');
        		}
        		
        		}
			},
			error : function() {
				alert("ERROR");
			}
		});
	},
	
	calculoPredialSinAporte : function(){
		var dataForm = {};
		dataForm.numBP = $("#NumBP").val();
		dataForm.chipcalculo = $("#CHIP").val();
		dataForm.matrInmobiliaria = $("#MatrInmobiliaria").val();
		dataForm.anioGravable = $("#AnioGravable").val();
		dataForm.opcionuso = $("#OpcionUso").val();
		
		var DatosLiquidacion = {};
		DatosLiquidacion.TipoDeclaracion = $("#TipoDeclaracion").val();
		DatosLiquidacion.PorcentajePropiedad =$("#PorcentajePropiedad").val();
		DatosLiquidacion.TarifaLiquidacion = $("#TarifaLiquidacion").val();
		DatosLiquidacion.DestinoHacendario = $("#DestinoHacendario").val();
		DatosLiquidacion.BaseGravable = $("#BaseGravable").val();
		DatosLiquidacion.CanonArrendamiento = $("#CanonArrendamiento").val();
		DatosLiquidacion.CalidadSujecion = $("#CalidadSujecion").val();
		DatosLiquidacion.AvaluoMatrizMejora = $("#AvaluoMatrizMejora").val();
		DatosLiquidacion.AreaTerrenoMejoraContrib = $("#AreaTerrenoMejoraContribuye").val();
		DatosLiquidacion.AvaluoProrrateado = $("#AvaluoProrrateado").val();
		DatosLiquidacion.AvaluoIndiceEdificabilidad = $("#AvaluoIndiceEdificabilidad").val();
		DatosLiquidacion.ExclusionParcial = $("#ExclusionParcial").val();
		dataForm.newDatosLiquidacion = DatosLiquidacion;
		
		var LiquidacionPrivada ={};
			
		LiquidacionPrivada.AporteVoluntario = $("#AporteVoluntario").val();
		LiquidacionPrivada.Proyecto = $("#Proyecto").val();
		
		dataForm.calcLiquidacionPrivada = LiquidacionPrivada;
		
		$.ajax({
			url : ACC.calculoPredialURL,
			data: JSON.stringify(dataForm),
			//data : data,
			type : "POST",
			 dataType: "json",
			contentType: "application/json",
			success : function(result) {
		
				var actualErrors = [];
            	
            	if(result.errores)
            	{
            		$.each(result.errores, function( index, value ) {
            			if(value.idError == "0")
            			actualErrors.push(value);
            		});
            	}
            	if(actualErrors.length > 0)
        		{
            		$( "#dialogICA" ).dialog( "open" );
            		$("#icaDialogContent").html("");
            		$.each(result.errores, function( index, value ) {
            			$("#icaDialogContent").html($("#icaDialogContent").html()+value.txtmsj+"<br>");
            		});
            		
            		
            		//$("#icaPresentarDeclaracionButton").prop("disabled",true);           		
        		}else
        		{
				
        			$( "#dialogICA" ).dialog( "open" );
        			$("#icaDialogContent").html("El cálculo se ha realizado exitosamente.");
    			
				$("#ValorImpuestoACargo").val(result.liquidacionPrivada.valorImpuestoCargo);
			//	$("#ValorImpuestoAjustadoActual").val(result.liquidacionPrivada.valorAporteVoluntario);
				$("#DescuentoPorIncrementoDiferencias").val(result.liquidacionPrivada.descuentoIncrementoDiferencial);
				$("#ValorImpuestoAjustadoActual").val(result.liquidacionPrivada.valorImpuestoAjustadoActual);
				$("#Sancion").val(result.liquidacionPrivada.sancion);
				$("#TotalSaldoACargo").val(result.liquidacionPrivada.totalSaldoACargo);
				$("#ValorAPagar").val(result.liquidacionPrivada.valorAPagar);
			//	$("#DescuentoPorProntoPago").val(result.liquidacionPrivada.descuentoPorProntoPago);
			//	$("#DescuendoAdicional1").val(result.liquidacionPrivada.descuendoAdicional1);
				$("#Intereses").val(result.liquidacionPrivada.intereses);
				$("#TotalAPagar").val(result.liquidacionPrivada.totalAPagar);
			//	$("#ValorAporteVoluntario").val(result.liquidacionPrivada.valorAporteVoluntario);
			//	$("#TotalConPagoVoluntario").val(result.liquidacionPrivada.totalConPagoVoluntario);
        		}
			},
			error : function() {
				alert("ERROR");
			}
		});
		
	},
	
	bindGeneraDeclaracionButton_predial: function () {
		 $(document).on("click", "#predialGeneraDeclaracionButton", function (e) {
	 	        e.preventDefault();
	 	       ACC.opcionDeclaraciones.presentarDeclaracionGenerica();
	 	       
		 });
	 }

};