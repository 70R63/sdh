ACC.rop = {

	 _autoload: ["bindGeneraROPButton", "bindROPDialog"],

	bindGeneraROPButton: function () {
		$(document).on("click", "#generaROPButton", function (e) {
			e.preventDefault();


			var data = {};

			$.ajax({
				url: ACC.generaROPURL,
				data: data,
				type: "POST",
				success: function (data) {

					$( "#dialogRop" ).dialog( "open" );
					if(data.errores)
					{
						$("#ropDialogContent").html("");
						$.each(data.errores, function( index, value ) {
							$("#ropDialogContent").html($("#ropDialogContent").html()+value.txtmsj+"<br>");
						});


					}else
					{
						$("#ropDialogContent").html("");
						$("#ropDialogContent").html("ROP generado exitosamente.")

						$("#downloadROPHelper").attr("href",data.urlDownload);
						document.getElementById("downloadROPHelper").click();
						document.getElementById("action").disabled = false;

					}

				},
				error: function () {
					$( "#dialogRop" ).dialog( "open" );
					$("#ropDialogContent").html("Hubo un error al generar la declaración, por favor intentalo más tarde");
				}
			});

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