<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="relacionpagos"
	tagdir="/WEB-INF/tags/responsive/relacionPagos"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<spring:htmlEscape defaultHtmlEscape="true" />

	<relacionpagos:relacionPagosMenu />
		<c:choose>
			<c:when test="${not empty Retenedor}">
				<relacionpagos:relacionPagosRETEICA/>
			</c:when>
			<c:otherwise>
	<div id="idtodos" style="display: none;">
	<relacionpagos:relacionPagosTodo />
	</div>
	<relacionpagos:relacionPagosImpuesto/>
	</c:otherwise>
	</c:choose>

	
	
	<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
	var url = window.parent.location.href;
	var contenido_url = url.includes('agenteRetenedor');
	
}

	function Selected(selectObject) {
		
		var value = selectObject.value;
		document.getElementById("Idimp").value = value;
		
		var inputSearch =  document.getElementById('idinputImpuesto')
		

		 switch (value) {
		   case "0": // foo es 0, por lo tanto se cumple la condición y se ejecutara el siguiente bloque
				inputSearch.style.display = 'none';
		     break;
		     // NOTA: el "break" olvidado debería estar aquí
		   case "1": // No hay sentencia "break" en el 'case 0:', por lo tanto este caso también será ejecutado
			   inputSearch.style.display = 'block';
				 document.getElementById('labelSearch').innerHTML
		         = 'CHIP/Matricula Inmobiliaria';
		     break; // Al encontrar un "break", no será ejecutado el 'case 2:'
		   case "2":
			   inputSearch.style.display = 'block';
				 document.getElementById('labelSearch').innerHTML
		         = 'Placa';
		     break;
		   case "3":
			   inputSearch.style.display = 'none';
			     break;
		   case "4":
			   inputSearch.style.display = 'block';
				 document.getElementById('labelSearch').innerHTML
		         = 'Numero de resolucion';
			     break;
		   case "5":
			   inputSearch.style.display = 'none';
			     break;
		   case "6":
			   inputSearch.style.display = 'block';
				 document.getElementById('labelSearch').innerHTML
		         = 'CDU';
			     break;
		   default:
		     console.log('default');
		 }
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
		var tabrad = document.getElementById('table-delineacion-radicados');
		var todo = document.getElementById('idtodos');
		var detpred = document.getElementById('detalle-predial');
		var detica = document.getElementById('detalle-ica');
		var detvehi = document.getElementById('detalle-vehiculos');
		var detdeli = document.getElementById('detalle-delurbana');
		var detgas = document.getElementById('detalle-gasolina');
		var detplubliext = document.getElementById('detalle-publiext');
		var detradic = document.getElementById('detalle-retenciones');


		if (x == '1') {

			tablepredial.style.display = 'block';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display='none';

		} else if (x == '2') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'block';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display='none';

		} else if (x == '3') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'block';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display='none';

		} else if (x == '4') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'block';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display='none';

		} else if (x == '5') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detgas.style.display = 'block';
			detdeli.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display='none';

		} else if (x == '6') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'block';
			tablegas.style.display = 'none';
			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display='none';
		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tablegas.style.display = 'none';
			tabledeli.style.display = 'none';
			tabrad.style.display='none';
			todo.style.display = 'block';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
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
		var detpred = document.getElementById('detalle-predial');
		var detica = document.getElementById('detalle-ica');
		var detvehi = document.getElementById('detalle-vehiculos');
		var detdeli = document.getElementById('detalle-delurbana');
		var detgas = document.getElementById('detalle-gasolina');
		var detplubliext = document.getElementById('detalle-publiext');
		var detradic = document.getElementById('detalle-retenciones');
		var tabrad = document.getElementById('table-delineacion-radicados');

		if (x == '1' || x == '2' || x == '3' || x == '4' || x == '5' || x == '6' ) {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			tabrad.style.display='none';
			todo.style.display = 'block';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			$("#impuesto").val('0')

		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tablegas.style.display = 'none';
			tabledeli.style.display = 'none';
			todo.style.display = 'block';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display='none';
		}
	}
</script>

