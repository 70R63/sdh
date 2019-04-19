ACC.duBotonVer = {

	_autoload : [ "bindLabelVerButton" ],

	
	bindLabelVerButton : function() {
		$(document).on("click", ".label1Ver", function(e) {
			e.preventDefault();
			

 	       var tipoValla = $.trim($(this).attr("data-cdu")); 	       

 	       if (tipoValla == "") {
				alert("Por favor, selecciona un CDU");
				return;
			}

			$("#selectedTipoValla").val(tipoValla);

			var data = {};

			data.cdu = tipoValla;

			$.ajax({
				url : ACC.radicaDelinDetallesURL,
				data : data,
				type : "GET",
				success : function(dataResponse) {
					ACC.duBotonVer.fillFieldsFromData(dataResponse);

				},
				error : function() {
				}
			});
		});
	},
	
	fillFieldsFromData : function(data) {

		var tipoValla = $("#selectedTipoValla").val();

		$("#divInfoRadicados").show();	
		$("#duRadicados").find("tr:gt(0)").remove();
		$.each(data.radicados, function (index,value){
			$('#duRadicados').append("<tr>"+ 
					 '<td><input id="numRadicado" name="" class="inputtextnew" aria-required="true" type="text" readonly="readonly" maxlength="240" style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;" value="' + value.numRadicado + '"></td>"' +
					 '<td><input id="fechaRadicado" name="" class="inputtextnew" aria-required="true" type="text" readonly="readonly" maxlength="240" style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;" value="' + value.fechaRadicado + '"></td>"' +
					 '<td><input id="modLicencia" name="" class="inputtextnew" aria-required="true" type="text" readonly="readonly" maxlength="240" style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;" value="' + value.modLicencia + '"></td>"' +
					 '<td><input id="presupuesto" name="" class="inputtextnew" aria-required="true" type="text" readonly="readonly" maxlength="240" style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;" value="' + value.presupuesto + '"></td>"' +
					 '<td><input id="estrato" name="" class="inputtextnew" aria-required="true" type="text" readonly="readonly" maxlength="240" style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;" value="' + value.estrato + '"></td>"' +
					 '<td><input class="inputtextnew" style="visibility: visible !important; width: 20% !important" type="checkbox" id="selec"></td> '+ 
					 "</tr>");	
		})
	}


};