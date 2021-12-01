ACC.frimas = {

	_autoload: ["bindEvents","bindFirmasDialog"],


	bindEvents: function(){

		$(".FirmInterFunct").on("change",function(e){
			var internalFunctionSelected = $(this).val();
			var nameSelect = $(this).closest(".representante").find(".FirmSelectNombre");
			if (internalFunctionSelected == "") {
				$(nameSelect).find('option').remove();
				var o = new Option("SELECCIONAR", "");
				/// jquerify the DOM object 'o' so we can use the html method
				$(o).html("SELECCIONAR");
				$(nameSelect).append(o);
				$(this).closest(".representante").find(".FirmTipoId").val("");
				$(this).closest(".representante").find(".FirmNumId").val("");
				$(this).closest(".representante").find(".FirmTarjetaProf").val("");
				return;
			} else {

				$.each(ACC.agentesFirmas[internalFunctionSelected], function (key, value) {
					var o = new Option(value.completeName, key);
					/// jquerify the DOM object 'o' so we can use the html method
					$(o).html(value.completeName);
					$(nameSelect).append(o);
				});


			}
		});

		$(".FirmSelectNombre").on("change",function(e){
			
			var nameSelected = $(this).val();

			if(nameSelected == "")
			{
				$(this).closest(".representante").find(".FirmTipoId").val("");
				$(this).closest(".representante").find(".FirmNumId").val("");
				$(this).closest(".representante").find(".FirmTarjetaProf").val("");
				return;
			}

			var internalFunctionSelected = $(this).closest(".representante").find(".FirmInterFunct").val();

			var documentNumber = ACC.agentesFirmas[internalFunctionSelected][nameSelected].documentNumber;

			var documentType = ACC.agentesFirmas[internalFunctionSelected][nameSelected].documentType;

			var tarjetaProf = ACC.agentesFirmas[internalFunctionSelected][nameSelected].bp;

			$(this).closest(".representante").find(".FirmTipoId").val(documentType);
			$(this).closest(".representante").find(".FirmNumId").val(documentNumber);
			$(this).closest(".representante").find(".FirmTarjetaProf").val(tarjetaProf);
		});

		$(".justFirm").on("click",function(e){
			ACC.spinner.show();
			
			var numForm = $("#numForm").val();

			if(numForm == "" )
			{
				ACC.spinner.close();
				$("#dialogFirmas" ).dialog( "open" );
				$("#firmasDialogContent").html("");
				$("#firmasDialogContent").html("Debe realizar el calculo primero");
				return;
			}

			var currentRow = $.trim($(this).closest(".representante"));

			var firmantes =[];

			$.each($(".representante .registro"),function (index,value) {

				var tipoIdent= $.trim($(value).find(".FirmTipoId").val());

				var  numIdentif  =$.trim($(value).find(".FirmNumId").val());

				var tipoDocEl = document.getElementById("firmas_contribuyente_documentType");
				var tipoDoc = "";
				if(tipoDocEl != null){
					tipoDoc = tipoDocEl.value;
				}
				var confirmacion = "";
				
				if(tipoDoc == "NIT"){
					confirmacion = "Y";
				}else{
					confirmacion = "X";
				}

				var posicion = index+1;

				var firmante = {};

				firmante.tipoIdent = tipoIdent;
				firmante.numIdentif = numIdentif;
				firmante.firmante = posicion;
				firmante.confirmacion = confirmacion;

				firmantes.push(firmante);

			});

			var data = {};
			data.numForm=numForm;
			data.firmantes =firmantes;

			$.ajax({
				url: ACC.declaracionFirmas,
				data: JSON.stringify(data),
				type: "POST",
				contentType: "application/json",
				success: function (data) {
					
					ACC.spinner.close();
					$( "#dialogFirmas" ).dialog( "open" );
					$("#firmasDialogContent").html("");
					$.each(data.errores,function (index,value) {

						if(value.idmsj != "")
						{
							$("#firmasDialogContent").html($("#firmasDialogContent").html()+value.txtmsj+"<br>");
						}
						if(value.idmsj == "0"){
							$("#generaDeclaracionVehiculosButton").attr("disabled",false);
							ACC.frimas.habilitaPresentarDec("justFirm");
						}

					});
					$("#generaDeclaracionVehiculosButton").attr("disabled",false);
					ACC.frimas.habilitaPresentarDec("justFirm");

				},
				error: function () {
					
					ACC.spinner.close();
					$( "#dialogFirmas" ).dialog( "open" );
					$("#firmasDialogContent").html("");
					$("#firmasDialogContent").html("Hubo un error al intentar firmar la declaración, favor de intentarlo más tarde.")
				}
			});
		});

		$(".firmAndAdd").on("click",function(e){
			ACC.spinner.show();
			var numForm = $("#numForm").val();

			if(numForm == "" )
			{
				ACC.spinner.close();
				$("#dialogFirmas" ).dialog( "open" );
				$("#firmasDialogContent").html("");
				$("#firmasDialogContent").html("Debe realizar el calculo primero");
				return;
			}

			var currentRow = $.trim($(this).closest(".representante"));

			var firmantes =[];

			$.each($(".representante .row"),function (index,value) {

				var tipoIdent= $.trim($(value).find(".FirmTipoId").val());

				var  numIdentif  =$.trim($(value).find(".FirmNumId").val());

				var tipoDocEl = document.getElementById("firmas_contribuyente_documentType");
				var tipoDoc = "";
				if(tipoDocEl != null){
					tipoDoc = tipoDocEl.value;
				}
				var confirmacion = "";
				
				if(tipoDoc == "NIT"){
					confirmacion = "Y";
				}else{
					confirmacion = "X";
				}

				var posicion = index+1;

				var firmante = {};

				firmante.tipoIdent = tipoIdent;
				firmante.numIdentif = numIdentif;
				firmante.firmante = posicion;
				firmante.confirmacion = confirmacion;

				firmantes.push(firmante);

			});

			if(firmantes.length < 3){

				var newFirmante = {};
				newFirmante.tipoIdent = "";
				newFirmante.numIdentif = "";
				newFirmante.firmante = firmantes.length+1;
				newFirmante.confirmacion = "Y";

				firmantes.push(newFirmante);
			}


			var data = {};
			data.numForm=numForm;
			data.firmantes =firmantes;

			$.ajax({
				url: ACC.declaracionFirmas,
				data: JSON.stringify(data),
				type: "POST",
				contentType: "application/json",
				success: function (data) {
					ACC.spinner.close();
					$( "#dialogFirmas" ).dialog( "open" );
					$("#firmasDialogContent").html("");

					var success = false;
					$.each(data.errores,function (index,value) {

						if(value.idmsj != "")
						{
							$("#firmasDialogContent").html($("#firmasDialogContent").html()+value.txtmsj+"<br>");
						}

						if(value.idmsj == "0"){
							success=true;
						}



					});

					if(success){
						ACC.frimas.habilitaPresentarDec("firmAndAdd");
//						window.setTimeout(function(){
//
//							// Move to a new location or you can do something else
//							window.location.href = $("#taxTypeRedirection").val();
//
//						}, 3000);
					}

				},
				error: function () {
					ACC.spinner.close();
					$( "#dialogFirmas" ).dialog( "open" );
					$("#firmasDialogContent").html("");
					$("#firmasDialogContent").html("Hubo un error al intentar firmar la declaración, favor de intentarlo más tarde.")
				}
			});
		});
	},
	bindFirmasDialog: function(){

		$( "#dialogFirmas" ).dialog({
			autoOpen: false,
			modal: true,
			draggable: false,
			buttons: {
				Ok: function() {
					$( this ).dialog( "close" );
				}
			}
		});

	},
	
	
	habilitaPresentarDec: function(botonActivado){
		
		if(botonActivado == "justFirm"){
			$(".GeneraDeclaracionButton").attr("disabled",false);
		}else if(botonActivado == "firmAndAdd"){
			var contribuyenteNoNIT = document.getElementById("contribuyenteNoNIT");
			
			if(contribuyenteNoNIT == null || contribuyenteNoNIT.value!="X"){
				$(".GeneraDeclaracionButton").attr("disabled",false);
			}			
		}
		
	}



};