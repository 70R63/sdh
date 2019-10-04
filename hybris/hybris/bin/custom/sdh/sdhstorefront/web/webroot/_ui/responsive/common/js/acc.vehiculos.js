ACC.vehiculos = {

	_autoload : [ "bindLabelVerDetalle" ],

	bindLabelVerDetalle : function() {
		$(document).on("click", ".labelVerDetalle", function(e) {
			e.preventDefault();
			debugger;
			var placas = $.trim($(this).attr("data-placa"));
			var numbp = $.trim($(this).attr("data-numbp"));
			var anograv = $.trim($("#an").val());

			if (anograv == "0") {
				alert("Por favor, selecciona el año a consultar");
				return;
			}

			var data = {};

			data.bpNum = numbp;
			data.placa = placas;
			data.anioGravable = anograv;

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