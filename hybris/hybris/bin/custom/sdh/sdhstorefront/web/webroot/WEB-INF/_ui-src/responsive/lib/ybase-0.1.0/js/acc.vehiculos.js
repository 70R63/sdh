ACC.vehiculos = {

	_autoload : [ "bindLabelVerDetalle" ],

	bindLabelVerDetalle : function() {
		$(document).on("click", ".labelVerDetalle", function(e) {
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
					ACC.vehiculos;

				},
				error : function() {
				}
			});

		});

	},

	bindDialogPublicidadExterior : function() {

		$("#dialogPublicidadExterior").dialog({
			autoOpen : false,
			modal : true,
			draggable : false,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});

	}

};