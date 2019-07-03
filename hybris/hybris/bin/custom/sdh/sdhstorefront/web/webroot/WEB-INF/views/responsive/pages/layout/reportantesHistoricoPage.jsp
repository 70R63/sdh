<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="reportantes"
	tagdir="/WEB-INF/tags/responsive/reportantesInformacion"%>


<div class="container_new">
	<reportantes:reportantesHistoricoInicial />
	<div id="idPredial" style="display: none;">
		<reportantes:reportantesHistoricoPredial />
	</div>
	<div id="idOpain" style="display: none;">
		<reportantes:reportantesHistoricoOpain />
	</div>
	<div id="idIca" style="display: none;">
		<reportantes:reportantesHistoricoIca />
	</div>
	<div id="idVehicular" style="display: none;">
		<reportantes:reportantesHistoricoVehiculos />
	</div>
</div>


<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;
		document.getElementById("Idinrepor").value = value;
	}

	function myFunction() {

		var x = document.getElementById('Idinrepor').value;
		var idPredial = document.getElementById('idPredial');
		var idOpain = document.getElementById('idOpain');
		var idIca = document.getElementById('idIca');
		var idVehicular = document.getElementById('idVehicular');

		if (x == '1') {
			idPredial.style.display = 'block';
			idOpain.style.display = 'none';
			idIca.style.display = 'none';
			idVehicular.style.display = 'none';

		} else if (x == '2') {
			idPredial.style.display = 'none';
			idOpain.style.display = 'block';
			idIca.style.display = 'none';
			idVehicular.style.display = 'none';

		} else if (x == '3') {
			idPredial.style.display = 'none';
			idOpain.style.display = 'none';
			idIca.style.display = 'block';
			idVehicular.style.display = 'none';

		} else if (x == '4') {
			idPredial.style.display = 'none';
			idOpain.style.display = 'none';
			idIca.style.display = 'none';
			idVehicular.style.display = 'block';

		} else {
			idPredial.style.display = 'none';
			idOpain.style.display = 'none';
			idIca.style.display = 'none';
			idVehicular.style.display = 'none';
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

