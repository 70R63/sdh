ACC.contribList = {

	_autoload : [ "bindLabelVerDetalle" ],

	bindLabelVerDetalle : function() {
		$(document).on("click", ".labelVerDetalle", function(e) {
			e.preventDefault();
			ACC.spinner.show();
			var placa = $.trim($(this).attr("data-placa"));
			var bpNum = $.trim($(this).attr("data-numbp"));
			var anioGravable = $.trim($("#an").val());

			if (anioGravable == "0") {
				ACC.spinner.close();
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
				ACC.vehiculos.fillFieldsFromData(data);

				},
				error : function() {		
				ACC.spinner.close();
				}
			});

		});

	},

	fillFieldsFromData : function(data) {

		$("#placa").val(data.placa);

	}

};