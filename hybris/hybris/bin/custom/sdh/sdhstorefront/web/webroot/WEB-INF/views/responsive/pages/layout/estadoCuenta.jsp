<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="consultas"
	tagdir="/WEB-INF/tags/responsive/edoCuenta"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>



<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
	<consultas:estadoCuentaMenu />
	<div id="idtodos" style="display: block;">
		<consultas:edoCuentaTodo />
	</div>
	<consultas:estadoCuentaImpuesto />

</sf:form>
		<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}

	function Selected(selectObject) {
		var value = selectObject.value;
		document.getElementById("Idimp").value = value;
	}

	function Selectedver(selectObject) {
		var value = selectObject.value;
		var x = document.getElementById('Idimp').value;
		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');
		var tabledeli = document.getElementById('table-delineacion');
		var tablegas = document.getElementById('table-gasolina');
		var taboblig = document.getElementById('table-obli-no-tributarias');
		var todo = document.getElementById('idtodos');
		var detpred = document.getElementById('detalle-predial');
		var detica = document.getElementById('detalle-ica');
		var detvehi = document.getElementById('detalle-vehiculos');
		var detdeli = document.getElementById('detalle-delurbana');
		var detgas = document.getElementById('detalle-gasolina');
		var detplubliext = document.getElementById('detalle-publiext');

		if (x == '1') {

			tablepredial.style.display = 'block';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			taboblig.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';

		} else if (x == '2') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'block';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			taboblig.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';

		} else if (x == '3') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'block';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			taboblig.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';

		} else if (x == '4') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'block';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			taboblig.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';

		} else if (x == '5') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'block';
			taboblig.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detgas.style.display = 'none';
			detdeli.style.display = 'none';
			detplubliext.style.display = 'none';

		} else if (x == '6') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'block';
			tablegas.style.display = 'none';
			taboblig.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
		} else if (x == '7') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			taboblig.style.display = 'block';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tablegas.style.display = 'none';
			tabledeli.style.display = 'none';
			taboblig.style.display = 'none';
			todo.style.display = 'block';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
		}

	}

	function cancelfun(selectObject) {

		var value = selectObject.value;
		var x = document.getElementById('Idimp').value;
		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');
		var tabledeli = document.getElementById('table-delineacion');
		var tablegas = document.getElementById('table-gasolina');
		var taboblig = document.getElementById('table-obli-no-tributarias');
		var todo = document.getElementById('idtodos');
		var newvalor = document.getElementById('impuesto');
		var detpred = document.getElementById('detalle-predial');
		var detica = document.getElementById('detalle-ica');
		var detvehi = document.getElementById('detalle-vehiculos');
		var detdeli = document.getElementById('detalle-delurbana');
		var detgas = document.getElementById('detalle-gasolina');
		var detplubliext = document.getElementById('detalle-publiext');

		if (x == '1' || x == '2' || x == '3' || x == '4' || x == '5'
				|| x == '6' || x == '7') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			taboblig.style.display = 'none';
			todo.style.display = 'block';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			$("#impuesto").val('0')

		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tablegas.style.display = 'none';
			tabledeli.style.display = 'none';
			taboblig.style.display = 'none';
			todo.style.display = 'block';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
		}
	}
</script>

