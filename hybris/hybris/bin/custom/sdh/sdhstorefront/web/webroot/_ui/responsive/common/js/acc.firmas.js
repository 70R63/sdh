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

			var numIdentif = $.trim($(this).closest(".representante").find(".FirmTipoId").val());

			var tipoIdent = $.trim($(this).closest(".representante").find(".FirmNumId").val());

			if(numIdentif == "" || tipoIdent=="")
			{
				$("#dialogFirmas" ).dialog( "open" );
				$("#firmasDialogContent").html("");
				$("#firmasDialogContent").html("Por favor introduzca los datos necesarios.");
				return ;
			}

			var element = this;
			var posicion =0;
			$.each($(".justFirm"),function (index,value) {

				if($(value).is($(element))){
					posicion = index+1;
				}

			});


			var numForm = $("#numForm").val();

			if(numForm == "" )
			{
				$("#dialogFirmas" ).dialog( "open" );
				$("#firmasDialogContent").html("");
				$("#firmasDialogContent").html("Debe realizar el calculo primero");
				return;
			}

			var confirmacion = "X";

			var firmantes =[];

			var firmante = {};

			firmante.numForm=numForm;
			firmante.tipoIdent = tipoIdent;
			firmante.numIdentif = numIdentif;
			firmante.firmante = posicion;
			firmante.confirmacion = confirmacion;

			firmantes.push(firmante);

			var data = {};
			data.numForm=numForm;
			data.firmantes =firmantes;

			$.ajax({
				url: ACC.declaracionFirmas,
				data: JSON.stringify(data),
				type: "POST",
				contentType: "application/json",
				success: function (data) {
					$( "#dialogFirmas" ).dialog( "open" );
					$("#firmasDialogContent").html("");
					$.each(data.errores,function (index,value) {

						if(value.idmsj != "")
						{
							$("#firmasDialogContent").html($("#firmasDialogContent").html()+value.txtmsj+"<br>");
						}

					});

				},
				error: function () {
					$( "#dialogFirmas" ).dialog( "open" );
					$("#firmasDialogContent").html("");
					$("#firmasDialogContent").html("Hubo un error al intentar firmar la declaración, favor de intentarlo más tarde.")
				}
			});
		});

		$(".firmAndAdd").on("click",function(e){

			var numIdentif = $.trim($(this).closest(".representante").find(".FirmTipoId").val());

			var tipoIdent = $.trim($(this).closest(".representante").find(".FirmNumId").val());

			if(numIdentif == "" || tipoIdent=="")
			{
				$("#dialogFirmas" ).dialog( "open" );
				$("#firmasDialogContent").html("");
				$("#firmasDialogContent").html("Por favor introduzca los datos necesarios.");
				return ;
			}

			var element = this;
			var posicion =0;
			$.each($(".firmAndAdd"),function (index,value) {

				if($(value).is($(element))){
					posicion = index+1;
				}

			});


			var numForm = $("#numForm").val();

			if(numForm == "" )
			{
				$("#dialogFirmas" ).dialog( "open" );
				$("#firmasDialogContent").html("");
				$("#firmasDialogContent").html("Debe realizar el calculo primero");
				return;
			}

			var confirmacion = "X";

			var firmantes =[];

			var firmante = {};

			firmante.tipoIdent = tipoIdent;
			firmante.numIdentif = numIdentif;
			firmante.firmante = posicion;
			firmante.confirmacion = confirmacion;

			firmantes.push(firmante);

			var newTipoIdent = $.trim($(this).closest(".representante").siblings().find(".FirmTipoId").val());
			var newNumIdentif = $.trim($(this).closest(".representante").siblings().find(".FirmNumId").val());
			var newPosicion = posicion+1;
			var newConfirmacion = "Y";

			if(newTipoIdent == "" || newNumIdentif == ""){
				$("#dialogFirmas" ).dialog( "open" );
				$("#firmasDialogContent").html("");
				$("#firmasDialogContent").html("Introduzca los datos del nuevo firmante");
				return;
			}

			var newFirmante = {};
			newFirmante.tipoIdent = newTipoIdent;
			newFirmante.numIdentif = newNumIdentif;
			newFirmante.firmante = newPosicion;
			newFirmante.confirmacion = newConfirmacion;

			firmantes.push(newFirmante);


			var data = {};
			data.numForm=numForm;
			data.firmantes =firmantes;

			$.ajax({
				url: ACC.declaracionFirmas,
				data: JSON.stringify(data),
				type: "POST",
				contentType: "application/json",
				success: function (data) {
					$( "#dialogFirmas" ).dialog( "open" );
					$("#firmasDialogContent").html("");
					$.each(data.errores,function (index,value) {

						if(value.idmsj != "")
						{
							$("#firmasDialogContent").html($("#firmasDialogContent").html()+value.txtmsj+"<br>");
						}

					});

				},
				error: function () {
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

	}



};