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
	function pagarEnLinea(tipoImpuesto,anoGravable,periodo,numObjeto,chip,fechaVenc,numRef,totalPagar){
		debugger;
		var numBP = "${customerData.numBP}";
		var numDoc = "${customerData.documentNumber}";
		var tipoDoc = "${customerData.documentType}";
		if (periodo === null || periodo === '' || typeof periodo === 'undefined' ){
			var clavePeriodo = anoGravable.substr(2,2).concat("A1");
		}	  
		else{
			var clavePeriodo = anoGravable.substr(2,2).concat(periodo);
		} 
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
		$("#pagarEnLinea_chip").val(chip);
		
		if(fechaVenc === '' || periodo.search("/") >= 0){
			$("#pagarEnLinea_fechaVenc").val(fechaVenc);
		}else{
			var fechaVencimineto = fechaVenc.substring(6,8).concat("/",fechaVenc.substring(4,6),"/",fechaVenc.substring(0,4));
			$("#pagarEnLinea_fechaVenc").val(fechaVencimineto);
		}
		
		$("#pagarEnLinea_numRef").val(numRef);
		$("#pagarEnLinea_totalPagar").val(totalPagar);
		
		
		var form = document.getElementById("infoPreviaPSE");
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
		
		var url = window.parent.location.href;
		var contenido_url = url.includes('agenteRetenedor');
		
		if(contenido_url == true){
			var contrib_select = document.getElementById('idImpuestoAgente');
// 			var impblock = document.getElementById('impRetenedor');
		
			contrib_select.style.display = 'block';
// 			impblock.style.display = 'block';
		}else{
			var contrib_select = document.getElementById('idImpuesto');
// 			var impblock = document.getElementById('impContribuyente');
			contrib_select.style.display = 'block';
// 			impblock.style.display = 'block';
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


