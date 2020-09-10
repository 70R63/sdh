ACC.rop = {

	 _autoload: ["bindGeneraROPButton", "bindROPDialog"],

	bindGeneraROPButton: function () {
		$(document).on("click", "#generaROPButton", function (e) {
			e.preventDefault();

			var importeusuario = $("#importeusuario").val().replace(/\./g,'').replace(/\,/g,'.');
			var tipoImp = $("#tipoImp").val();
            var numObjeto = $("#numObjeto").val();
            var numBP = $("#numBP").val();
            var clavePeriodo = $("#clavePeriodo").val();

			if(importeusuario != "" && (importeusuario < 1000 || importeusuario % 1000 !== 0))
			{
				$( "#dialogRop" ).dialog( "open" );
				$("#ropDialogContent").html("");
				$("#ropDialogContent").html("Por favor, introduce un valor múltiplo de $1.000");
				return;
			}

			var data = {};
			data.importeusuario = importeusuario;
			data.tipoImp = tipoImp;
            data.numObjeto = numObjeto;
            data.numBP = numBP;
            data.clavePeriodo = clavePeriodo;
            data.consulta = 'X';
            
                        
            var acciones = {};
            acciones.flagGenerarROP = false;
			$.ajax({
				url: ACC.generaROPURL,
				data: data,
				type: "POST",
				success: function (dataResponse) {
					acciones = ACC.rop.accionConsulta(dataResponse);
					
					if(acciones.flagGenerarROP == true){
						ACC.rop.generarNuevoROP(data,dataResponse);
					}
				},
				error: function () {
					$( "#dialogRop" ).dialog( "open" );
					$("#ropDialogContent").html("Hubo un error al generar la declaración, por favor intentalo más tarde");
				}
			});
			
		});
	},
	
	accionConsulta: function(data){
		var flagGenerarROP = false;
		var flagConfReimpresion = false;
		var strMensaje = "";
		var dataResponse = {};
		
		if(data.errores != null)
		{
			$.each(data.errores, function( index, value ) {
				if(value.idmsj!=null && value.idmsj.trim() == "09"){
					flagConfReimpresion = true;
					strMensaje = value.txtmsj.trim();
				}
			});
		}
		
		if(flagConfReimpresion == true){
			var valConfReimpresion = confirm(strMensaje);
			
			if(valConfReimpresion){
				$("#downloadROPHelper").attr("href",data.urlDownload);
				document.getElementById("downloadROPHelper").click();
				document.getElementById("action").disabled = false;
			}else{
				flagGenerarROP = confirm("¿Desea generar un nuevo ROP?");
			}
		}
		
		dataResponse.flagGenerarROP = flagGenerarROP;
		return dataResponse
	},
	
	
	generarNuevoROP: function(data,dataResponse){
		data.consulta = '';
		$.ajax({
			url: ACC.generaROPURL,
			data: data,
			type: "POST",
			success: function (dataResponseGen) {
				var strMensaje = "";

				if(dataResponseGen.errores != null)
				{
					$.each(dataResponseGen.errores, function( index, value ) {
						if(value.txtmsj!=null && value.txtmsj.trim() != "" && value.txtmsj.trim() != "OK"){
							strMensaje += value.txtmsj.trim()+"<br>";
						}
					});

				}
				if(strMensaje != ""){
					$( "#dialogRop" ).dialog( "open" );
					$("#ropDialogContent").html(strMensaje);
				}
				else
				{
					$( "#dialogRop" ).dialog( "open" );
					$("#ropDialogContent").html("");
					$("#ropDialogContent").html("ROP generado exitosamente.")

					$("#downloadROPHelper").attr("href",dataResponseGen.urlDownload);
					document.getElementById("downloadROPHelper").click();
					document.getElementById("action").disabled = false;

				}

			},
			error: function () {
				$( "#dialogRop" ).dialog( "open" );
				$("#ropDialogContent").html("Hubo un error al generar la declaración, por favor intentalo más tarde");
			}
		});

	},
	

	bindROPDialog: function(){

		$( "#dialogRop" ).dialog({
			autoOpen: false,
			modal: true,
			draggable: false,
			buttons: {
				Ok: function() {
					$( this ).dialog( "close" );
				}
			}
		});

	}
};