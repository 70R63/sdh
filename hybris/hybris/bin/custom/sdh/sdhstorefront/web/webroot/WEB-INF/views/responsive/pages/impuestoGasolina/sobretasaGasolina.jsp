<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sobreTasaGasolina"
	tagdir="/WEB-INF/tags/responsive/sobretasaGasolina"%>
<spring:htmlEscape defaultHtmlEscape="true" />



<div class="container">
	<sobreTasaGasolina:sobGasolinaMenu />
	<sobreTasaGasolina:sobGasolinaGen />
	<sobreTasaGasolina:sobGasolinaBasicos />
	<sobreTasaGasolina:sobGasolinaRep />
</div>


<script type="text/javascript">
document.onreadystatechange = function () {
    if (document.readyState == "complete") {
    datatable();
  }
}

function datatable(e){
if ( $.fn.dataTable.isDataTable( '#example' ) ) {
  table = $('#example').DataTable();
  table.destroy();
}
var tabla =$("#example").DataTable({
     "sPaginationType": "full_numbers",
     "oLanguage": {
         "oPaginate": {
             "sPrevious": "Anterior",
             "sNext": "Siguiente",
             "sLast": "Última",
             "sFirst": "Primera"
         },
         "sLengthMenu": 'Mostrar <select>' +
          '<option value="5">5</option>' +
          '<option value="10">10</option>' +
         '<option value="15">15</option>' +
         '<option value="20">20</option>' +
         '<option value="30">30</option>' +
          '</select> registros',
         "sInfo": "Mostrando del _START_ a _END_ (Total: _TOTAL_ resultados)",
         "sInfoFiltered": " Filtrados de MAX registros",
         "sInfoEmpty": " ",
         "sZeroRecords": "No se encontraron registros",
         "sProcessing": "Espere, por favor...",
         "sSearch": "Buscar:",
     }
  });
}
</script>