<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="agentes"
	tagdir="/WEB-INF/tags/responsive/agentesAutorizadosConsulta"%>


<div class="loader"></div>


<agentes:consultainicial />
<c:if test="${not empty fileConsultaResponse.resultado.stringFile}">
    <agentes:consultaTable />
</c:if>


<script type="text/javascript">

window.onload = function() {
	debugger;
	var cosas = $(":input");
	var tam = cosas.length;
	if (false){
		for (var i = 0; i < tam; i++) {
			var valor = cosas[i].value;
			if (valor == "") {
				cosas[i].value = "-";

			}
		}
	}
	  $(".loader").fadeOut("slow");
}
	function goBack() {
		window.history.back();
	}
	document.onreadystatechange = function() {
		if (document.readyState == "complete") {
			datatable();
		}
	}

	function datatable(e) {
		if ($.fn.dataTable.isDataTable('#example')) {
			table = $('#example').DataTable();
			table.destroy();
		}
		var tabla = $("#example")
				.DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : " Anterior ",
									"sNext" : " Siguiente ",
									"sLast" : " �ltima ",
									"sFirst" : " Primera "
								},
								"sLengthMenu" : 'Mostrar <select>'
										+ '<option value="5">5</option>'
										+ '<option value="10">10</option>'
										+ '<option value="15">15</option>'
										+ '<option value="20">20</option>'
										+ '<option value="30">30</option>'
										+ '</select> registros',
								"sInfo" : "Mostrando _START_ al _END_ de _TOTAL_ registros",
								"sInfoFiltered" : " Filtrados de MAX registros",
								"sInfoEmpty" : " ",
								"sZeroRecords" : "No se encontraron registros",
								"sProcessing" : "Espere, por favor...",
								"sSearch" : "Buscar:",
							}
						});
	}

	function show() {
		var tab = document.getElementById('tabla');
		tab.style.display = 'block';

	}
</script>

