<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="ica" tagdir="/WEB-INF/tags/responsive/ica"%>

<div class="loader"></div>

<c:out value="${opcionUso}"/>
<input type="hidden" id="icaOpcionUso" name="icaOpcionUso" value="${opcionUso}">
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
		$(".loader").fadeOut("slow");

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
									"sLast" : "Ultima",
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
									"sLast" : "Ultima",
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
	
	function onClick(numObject) {
	        var opcUso = document.getElementById("icaOpcionUso").value;
	        var redirectedUrl = window.location.href + '/declaracion?&numObjeto=' + numObject;
	        if(opcUso == '02'){
	            var r = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
                if (r == true) {
                    window.location.href = redirectedUrl;
                }
	        }else{
                window.location.href = redirectedUrl;
	        }

    	}
	
	
	
</script>



