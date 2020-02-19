ACC.predial = {

	_autoload : [ "bindoptionNo", "bindprophorizontal", "binbuttonPrecalculo",
			"bindDetallePredial" ],

	bindoptionNo : function() {
		$(document).on("click", ".optradio", function() {
			var valo = this.value;
			var pro = document.getElementById('proyecto');

			if (valo == '2') {
				pro.style.display = 'none';
			} else if (valo == '1') {
				pro.style.display = 'block';
			}

		});
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

	binbuttonPrecalculo : function() {
		$(document).on("click", ".buttonPrecalculo", function(e) {
			e.preventDefault();
			var base = document.getElementById('BasesDetalle');
			base.style.display = 'block';

		});
	},

	bindDetallePredial : function() {
		$(document).on("click", ".showDetailPredio", function(e) {
			e.preventDefault();

			var show = document.getElementById('InicialDetalle');
			show.style.display = 'block';
			var anio = $.trim($(this).attr("data-anioGravable"));
			var chip = $.trim($(this).attr("data-chip"));
			var matric = $.trim($(this).attr("data-matrInmobiliaria"));

			var data = {};

			data.anioGravable = anio;
			data.chip = chip;
			data.matrInmobiliaria = matric;

			$.ajax({
				url : ACC.predialDetalleURL,
				data : data,
				type : "POST",
				success : function(data) {
					debugger;
					$(".chip").val(data.CHIP);
					var econo = data.datosEconomicos;
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
									+ econo.avaluoMejoraConstruccion + '" /></td>');

				
				},
				error : function() {
					alert("ERROR");
				}
			});

		});
	}

};