ACC.vehiculos = {

	_autoload : [ "bindLabelVerDetalle", "bindLabelVerDetVeh" ],

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
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
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
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
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
														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
														+ nomTres + '" /></td>');
							} else {

							}
							tabRel.style.display = 'block';

						});

	},

	bindLabelVerDetVeh : function() {
		$(document).on("click", ".labelVerDetVeh", function(e) {
			e.preventDefault();

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
		$("#placas").val(data.placa);

		if (data.idServicio == "01") {
			data.idServicio = "PARTICULAR";
		} else if (data.idServicio == "02") {
			data.idServicio = "PÚBLICO";
		} else if (data.idServicio == "03") {
			data.idServicio = "OFICIAL";
		} else {
			data.idServicio = "-";
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
			data.idEstado = "-";
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
			data.clasicoAntig = "-";
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
			data.tipoVeh = "-";

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
					jur[i].calidad = "-";
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
										+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ jur[i].fechaDesde
										+ '" /></td>'
										+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ jur[i].fechaHasta + '" /></td>');

			}
		} else {
			$('#tableJur')
					.append(
							"<tr>"
									+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="No cuenta con dato Juridicos" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="-" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="-" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="-" /></td>');
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
										+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ marca[i].fechaDesde
										+ '" /></td>'
										+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
										+ marca[i].fechaHasta + '" /></td>');

			}
		} else {
			$('#tablemarcas')
					.append(
							"<tr>"
									+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="No cuenta con dato Juridicos" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="-" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="-" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="-" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="-" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="-" /></td>');
		}

		var liq = data.liquidacion

		if (liq != null) {
			for (var i = 0; i < liq.length; i++) {

				$('#tableLiq')
						.append(
								"<tr>"
										+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="'
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
									+ '<td><input style="width: 123px !important" class="inputtextnew calidad" disabled="disabled" type="text" size="40" value="No cuenta con dato Juridicos" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="-" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="-" /></td>');
		}

	}

};