ACC.oblipend = {

	_autoload : [ "bindBuscarObliPend", "bindDetalle" ],

	bindBuscarObliPend : function() {

		$(document).on("click", "#buscarObliPend", function(e) {
			e.preventDefault();

			$(".oblipend-table").hide();
			$(".oblipend-tabledetalle").hide();

			var impuesto = $("#impuesto").val();

			if (impuesto == "1") {

				$("#oblipend-predial").show();

			} else if (impuesto == "2") {

				$("#oblipend-vehiculos").show();

			} else if (impuesto == "3") {

				$("#oblipend-ica").show();

			} else if (impuesto == "4") {

				$("#oblipend-publiext").show();

			} else if (impuesto == "5") {

				$("#oblipend-gasolina").show();

			} else if (impuesto == "6") {

				$("#oblipend-delurbana").show();

			}

		});

	},

	bindDetalle : function() {

		$(document).on(
				"click",
				"#Detalle",
				function(e) {
					e.preventDefault();
					debugger;
					$(".oblipend-tabledetalle").hide();

					var fecha = new Date();
					var impuesto = $("#impuesto").val();
					var mes = fecha.getMonth() + 1;

					if (impuesto == "1") {

						$("#detalle-predial").show();
						if(mes < 10){
						$("#fechreportepred").val(
								fecha.getDate() + "/0" + (fecha.getMonth() + 1)
										+ "/" + fecha.getFullYear());
						}else{
							$("#fechreportepred").val(
									fecha.getDate() + "/0" + (fecha.getMonth() + 1)
											+ "/" + fecha.getFullYear());
						}

					} else if (impuesto == "2") {

						$("#detalle-vehiculos").show();
						if(mes < 10){
						$("#fechreportevh").val(
								fecha.getDate() + "/0" + (fecha.getMonth() + 1)
										+ "/" + fecha.getFullYear());
						}else{
							$("#fechreportevh").val(
									fecha.getDate() + "/" + (fecha.getMonth() + 1)
											+ "/" + fecha.getFullYear());
						}

					} else if (impuesto == "3") {

						$("#detalle-ica").show();
						if (mes < 10){
						$("#fechreporteica").val(
								fecha.getDate() + "/0" + (fecha.getMonth() + 1)
										+ "/" + fecha.getFullYear());
						}else{
							$("#fechreporteica").val(
									fecha.getDate() + "/" + (fecha.getMonth() + 1)
											+ "/" + fecha.getFullYear());
						}

					} else if (impuesto == "4") {

						var numrespub = this.attributes[4].nodeValue;
						var angravpub = this.attributes[3].nodeValue;

						$("#detalle-publiext").show();
						if (mes < 10) {
							$("#fechreportepub").val(
									fecha.getDate() + "/0"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						} else {
							$("#fechreportepub").val(
									fecha.getDate() + "/"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						}

						$("#numResOB").val(numrespub);
						$("#angravPUB").val(angravpub);

					} else if (impuesto == "5") {

						$("#detalle-gasolina").show();
						if (mes < 10) {
							$("#fechreportegas").val(
									fecha.getDate() + "/0"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						} else {
							$("#fechreportegas").val(
									fecha.getDate() + "/"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						}

					} else if (impuesto == "6") {
						var cduDEL = this.attributes[2].nodeValue;
						
						var division = cduDEL.split("U");
						var anio = division[1].split('',2);
						var anioimp = anio[0] +  anio[1];

						$("#detalle-delurbana").show();

						if (mes < 10) {
							$("#fechreportedel").val(
									fecha.getDate() + "/0"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						} else {
							$("#fechreportedel").val(
									fecha.getDate() + "/"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						}

						$("#cduobDELI").val(cduDEL);
						
						if (anioimp < 99){
							
							$("#angravDELI").val("20"+anioimp);
							
						}else{
							$("#angravDELI").val("Error");
						}

					}
				});
	}
};