<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="ica" tagdir="/WEB-INF/tags/responsive/ica"%>

<ica:icaTable />
<ica:icaDetalle />
<ica:icaActividades />
<ica:icaEstablecimientos />
<ica:icaEconomicos />
<ica:icaMarcas />
<ica:icaRepresentantes />

<div id="dialogICA" title="ICA" ><div id="icaDialogContent"></div></div>

<script type="text/javascript">
// window.onload = function() {
// 	var inputcol = document.getElementsByTagName("input");
// 	for (i = 0; i < inputcol.length; i++) {
// 		var texto = inputcol[i].value;
// 		inputcol[i].style.width = (texto.length + 1) * 7 + 'px';
// 	}

// }
	
	window.onload = function() {
		debugger;
		var cosas = $(":input");
		var tam = cosas.length;
		if (false){ //EMP-codigo comentado por observaciones en pruebas realizadas el 04 de octubre 2019
			for (var i = 0; i < tam; i++) {
				var valor = cosas[i].value;
				if (valor == "") {
					cosas[i].value = "-";

				}
			}
		}	

	}

	function goBack() {
		window.history.back();
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
									"sPrevious" : "Anterior",
									"sNext" : "Siguiente",
									"sLast" : "Ãltima",
									"sFirst" : "Primera"
								},
								"sLengthMenu" : 'Mostrar <select>'
										+ '<option value="5">5</option>'
										+ '<option value="10">10</option>'
										+ '<option value="15">15</option>'
										+ '<option value="20">20</option>'
										+ '<option value="30">30</option>'
										+ '</select> registros',
								"sInfo" : "Mostrando del START a END (Total: TOTAL resultados)",
								"sInfoFiltered" : " Filtrados de MAX registros",
								"sInfoEmpty" : " ",
								"sZeroRecords" : "No se encontraron registros",
								"sProcessing" : "Espere, por favor...",
								"sSearch" : "Buscar:",
							}
						});
		
		if ($.fn.dataTable.isDataTable('#example2')) {
			table = $('#example2').DataTable();
			table.destroy();
		}
		var tabla = $("#example2")
				.DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : "Anterior",
									"sNext" : "Siguiente",
									"sLast" : "Ãltima",
									"sFirst" : "Primera"
								},
								"sLengthMenu" : 'Mostrar <select>'
										+ '<option value="5">5</option>'
										+ '<option value="10">10</option>'
										+ '<option value="15">15</option>'
										+ '<option value="20">20</option>'
										+ '<option value="30">30</option>'
										+ '</select> registros',
								"sInfo" : "Mostrando del START a END (Total: TOTAL resultados)",
								"sInfoFiltered" : " Filtrados de MAX registros",
								"sInfoEmpty" : " ",
								"sZeroRecords" : "No se encontraron registros",
								"sProcessing" : "Espere, por favor...",
								"sSearch" : "Buscar:",
							}
						});
	}
	
	
	
	
	
</script>



