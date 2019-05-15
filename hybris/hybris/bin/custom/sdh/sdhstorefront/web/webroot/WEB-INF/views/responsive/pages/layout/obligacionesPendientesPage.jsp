<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="obligaciones"
	tagdir="/WEB-INF/tags/responsive/obligacionesPendi"%>



<obligaciones:obliPendientesMenu />
<div id="idtodos" style="display: block;">
	<obligaciones:obliPendientesTodo />
</div>
	<obligaciones:obliPendientesImpuesto />





<script type="text/javascript">
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
		var todo = document.getElementById('idtodos');

		if (x == '1') {

			tablepredial.style.display = 'block';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			todo.style.display = 'none';

		} else if (x == '2') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'block';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			todo.style.display = 'none';

		} else if (x == '3') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'block';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			todo.style.display = 'none';

		} else if (x == '4') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'block';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			todo.style.display = 'none';

		} else if (x == '5') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'block';
			todo.style.display = 'none';

		} else if (x == '6') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'block';
			tablegas.style.display = 'none';
			todo.style.display = 'none';
		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tablegas.style.display = 'none';
			tabledeli.style.display = 'none';
			todo.style.display = 'block';
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
		var todo = document.getElementById('idtodos');
		var newvalor= document.getElementById('impuesto');

		if (x == '1' || x == '2' || x == '3' || x == '4' || x == '5' || x == '6' ) {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			todo.style.display = 'block';
			$("#impuesto").val('0')

		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tablegas.style.display = 'none';
			tabledeli.style.display = 'none';
			todo.style.display = 'block';
		}
	}
</script>

