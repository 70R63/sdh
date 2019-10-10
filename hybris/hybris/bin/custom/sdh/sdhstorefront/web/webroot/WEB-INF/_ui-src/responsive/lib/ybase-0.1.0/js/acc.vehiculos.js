ACC.vehiculos = {

	_autoload : [ "bindLabelVerDetalle", "bindLabelVerDetVeh" ],

	bindLabelVerDetalle : function() {
		$(document).on("click", ".labelVerDetalle", function(e) {
			e.preventDefault();
			debugger;
//			var placa = $.trim($(this).attr("data-placa"));
//			var bpNum = $.trim($(this).attr("data-numbp"));
//			var anioGravable = $.trim($("#an").val());
//
//			if (anioGravable == "0") {
//				alert("Por favor, selecciona el año a consultar");
//				return;
//			}
//
//			var data = {};
//
//			data.bpNum = bpNum;
//			data.placa = placa;
//			data.anioGravable = anioGravable;
//
//			$.ajax({
//				url : ACC.vehiculosDetalleURL,
//				data : data,
//				type : "GET",
//				success : function(data) {
//					ACC.vehiculos.fillFieldsFromData(data);
//
//				},
//				error : function() {
//				}
//			});
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
							
							
							if ( relUno == '' 
									&& relDos == '' 
									&& relTres == '') {
//								$('#tabRelacion')
//										.append(
//												"<tr>"
//														+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="No tiene Relaciones" /></td>');
								alert("No cuenta con Relaciones");
							}else{
								
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
							}else{
								
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
							}else{
								
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
							}else{
								
							}
							tabRel.style.display = 'block';

		});

	},

	
	bindLabelVerDetVeh : function() {
		$(document).on("click", ".labelVerDetVeh", function(e) {
			e.preventDefault();
			debugger;
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
		$("#inidServicio").val(data.idServicio);
		$("#inidEstado").val(data.idEstado);
		$("#inwatts").val(data.watts);
		$("#inclasico").val(data.clasicoAntig);
		$("#intipvehiculo").val(data.tipoVeh);
		$("#inpasajeros").val(data.capacidadPas);
		$("#inton").val(data.capacidadTon);
		$("#infecinacti").val(data.fechaDesde);
		$("#infechacambio").val(data.fechaCambio);
		$("#inTipo").val(data.tipoID);
		$("#inNomcom").val(data.nombre)

	}

};