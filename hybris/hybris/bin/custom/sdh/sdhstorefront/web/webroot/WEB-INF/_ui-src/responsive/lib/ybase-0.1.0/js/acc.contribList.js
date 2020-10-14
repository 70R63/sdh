ACC.contribList = {

	_autoload : [ "bindLabelVerDetalle" ],

	bindLabelVerDetalle : function() {
		$(document).on("click", ".labelVerDetalle", function(e) {
			e.preventDefault();
			var spinnerdiv=document.getElementById('cargandoSpinner');
			$("#cargandoSpinner").html(ACC.mirit.spinner);
			spinnerdiv.style.display = 'block';
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
				$("#cargandoSpinner").html();
				spinnerdiv.style.display = 'none';
					ACC.vehiculos.fillFieldsFromData(data);

				},
				error : function() {		
				$("#cargandoSpinner").html();
				spinnerdiv.style.display = 'none';
				}
			});

		});

	},

	fillFieldsFromData : function(data) {

		$("#placa").val(data.placa);

	}

};