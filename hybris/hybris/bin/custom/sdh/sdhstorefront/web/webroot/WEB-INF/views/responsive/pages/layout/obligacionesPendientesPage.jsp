<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="obligaciones"
	tagdir="/WEB-INF/tags/responsive/obligacionesPendi"%>

<div class="loader"></div>

<obligaciones:obliPendientesMenu />
<div id="idtodos" style="display: block;">
	<obligaciones:obliPendientesTodo />
</div>
<obligaciones:obliPendientesPagar />


<script>
	function pagarEnLinea(tipoImpuesto,anoGravable,periodo,numObjeto){
		debugger;
		var numBP = "${customerData.numBP}";
		var numDoc = "${customerData.documentNumber}";
		var tipoDoc = "${customerData.documentType}";
		var clavePeriodo = "";
		var dv = "${customerData.digVer}";
		
		
		$("#pagarEnLinea_tipoImpuesto").val(tipoImpuesto);
		$("#pagarEnLinea_numBP").val(numBP);
		$("#pagarEnLinea_numDoc").val(numDoc);
		$("#pagarEnLinea_tipoDoc").val(tipoDoc);		
		$("#pagarEnLinea_anoGravable").val(anoGravable);
		$("#pagarEnLinea_periodo").val(periodo);
		$("#pagarEnLinea_clavePeriodo").val(clavePeriodo);
		$("#pagarEnLinea_dv").val(dv);
		$("#pagarEnLinea_numObjeto").val(numObjeto);
		
		
		form = document.getElementById("infoPreviaPSE");
		if(form!=null){
			form.submit();
		}
		
	}
	
	window.onload = function() {
		debugger;
		var cosas = $(":input");
		var tam = cosas.length;
		if (false) {
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

	function datatable() {
		debugger;
		if ($.fn.dataTable.isDataTable('#example')) {
			debugger;
			table = $('#example').DataTable();
			table.destroy();
			
		}
		var tabla = $("#example").DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : " Anterior ",
									"sNext" : " Siguiente ",
									"sLast" : "Ultima",
									"sFirst" : " Primera "
								},
								"sLengthMenu" : 'Mostrar <select>'
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

		if ($.fn.dataTable.isDataTable('#example_vehiculos')) {
			
			table = $('#example_vehiculos').DataTable();
			table.destroy();
		}
		var tabla = $("#example_vehiculos")
				.DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : " Anterior ",
									"sNext" : " Siguiente ",
									"sLast" : "Ultima",
									"sFirst" : " Primera "
								},
								"sLengthMenu" : 'Mostrar <select>'
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

		if ($.fn.dataTable.isDataTable('#example_ica')) {
			debugger;
			table = $('#example_ica').DataTable();
			table.destroy();
		}
		var tabla = $("#example_ica")
				.DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : " Anterior ",
									"sNext" : " Siguiente ",
									"sLast" : "Ultima",
									"sFirst" : " Primera "
								},
								"sLengthMenu" : 'Mostrar <select>'
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

		if ($.fn.dataTable.isDataTable('#example_gasolina')) {
			table = $('#example_gasolina').DataTable();
			table.destroy();
		}
		var tabla = $("#gasolina")
				.DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : " Anterior ",
									"sNext" : " Siguiente ",
									"sLast" : "Ultima",
									"sFirst" : " Primera "
								},
								"sLengthMenu" : 'Mostrar <select>'
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

		if ($.fn.dataTable.isDataTable('#example_publicidad')) {
			table = $('#example_publicidad').DataTable();
			table.destroy();
		}
		var tabla = $("#example_publicidad")
				.DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : " Anterior ",
									"sNext" : " Siguiente ",
									"sLast" : "Ultima",
									"sFirst" : " Primera "
								},
								"sLengthMenu" : 'Mostrar <select>'
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

		if ($.fn.dataTable.isDataTable('#ejemplo_delineacion')) {
			table = $('#ejemplo_delineacion').DataTable();
			table.destroy();
		}
		var tabla = $("#ejemplo_delineacion")
				.DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : " Anterior ",
									"sNext" : " Siguiente ",
									"sLast" : "Ultima",
									"sFirst" : " Primera "
								},
								"sLengthMenu" : 'Mostrar <select>'
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
</script>


