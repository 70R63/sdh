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

<div class="loader"></div>

<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
	<consultas:estadoCuentaMenu />

	<consultas:edoCuentaTodo />
	
	<consultas:edoCuentaImprimir/>

	<%-- 	<consultas:estadoCuentaImpuesto /> --%>

</sf:form>
<script type="text/javascript">
	window.onload = function() {
		var url = window.parent.location.href;
		var contenido_url = url.includes('agenteRetenedor');
		
		if(contenido_url == true){
			var contrib_select = document.getElementById('idImpuestoAgente');
			var impblock = document.getElementById('impRetenedor');
		
			contrib_select.style.display = 'block';
			impblock.style.display = 'block';
		}else{
			var contrib_select = document.getElementById('idImpuesto');
			var impblock = document.getElementById('impContribuyente');
			var btn = document.getElementById('btnBuscar');
			contrib_select.style.display = 'block';
			impblock.style.display = 'block';
			btn.style.display = 'block';
		}

		$(".loader").fadeOut("slow");
	}

	function Selected(selectObject) {
		var value = selectObject.value;
		document.getElementById("impuesto").val() = value;
	}

	function Selectedver(selectObject) {
		var contrib_select = document.getElementById('idImpuesto');
		var impblock = document.getElementById('impContribuyente');
		contrib_select.style.display = 'block';
		impblock.style.display = 'block';
		var value = selectObject.value;
		var xx = document.getElementById('impuesto');
		var x = xx.value;

		// 		var todo = document.getElementById('idtodos');
		var detpred = document.getElementById('predial');
		var detica = document.getElementById('ica');
		var detvehi = document.getElementById('vehiculos');
		var detdeli = document.getElementById('delurbana');
		var detgas = document.getElementById('gasolina');
		var detplubliext = document.getElementById('publiext');
		var oblig = document.getElementById('obli-no-tributarias')

		if (x == '1') {

			// 			todo.style.display = 'none';
			detpred.style.display = 'block';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			oblig.style.display = 'none';

		} else if (x == '2') {

			// 			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'block';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			oblig.style.display = 'none';

		} else if (x == '3') {

			// 			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'block';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			oblig.style.display = 'none';

		} else if (x == '4') {

			// 			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'block';
			oblig.style.display = 'none';

		} else if (x == '5') {

			// 			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'block';
			detplubliext.style.display = 'none';
			oblig.style.display = 'none';

		} else if (x == '6') {

			// 			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detgas.style.display = 'none';
			detdeli.style.display = 'block';
			detplubliext.style.display = 'none';
			oblig.style.display = 'none';

		} else if (x == '7') {

			// 			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detgas.style.display = 'none';
			detdeli.style.display = 'none';
			detplubliext.style.display = 'none';
			oblig.style.display = 'block';

		} else if (x == '0') {

			// 			todo.style.display = 'block';
			detpred.style.display = 'block';
			detica.style.display = 'block';
			detvehi.style.display = 'block';
			detdeli.style.display = 'block';
			detgas.style.display = 'block';
			detplubliext.style.display = 'block';
			oblig.style.display = 'block';
		} else {

			// 			todo.style.display = 'block';
			detpred.style.display = 'block';
			detica.style.display = 'block';
			detvehi.style.display = 'block';
			detdeli.style.display = 'block';
			detgas.style.display = 'block';
			detplubliext.style.display = 'block';
			oblig.style.display = 'block';
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

