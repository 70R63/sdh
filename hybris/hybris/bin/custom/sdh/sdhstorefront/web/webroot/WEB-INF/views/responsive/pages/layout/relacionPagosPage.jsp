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

         
function descargaRelacionPagosPDF() {
	
	
	var x = document.getElementById('Idimp').value;
	var fileName = "RelacionPagos.pdf" ;
	
	if (x == '1') {
		fileName = "RelacionPagosPredial.pdf" ;
	} else if (x == '2') {
		fileName = "RelacionPagosVehiculos.pdf" ;
	} else if (x == '3') {
		fileName = "RelacionPagosICA.pdf" ;
	} else if (x == '4') {
		fileName = "RelacionPagosPublicidad.pdf" ;
	} else if (x == '5') {
		fileName = "RelacionPagosGasolina.pdf" ;
	} else if (x == '6') {
		fileName = "RelacionPagosDelineacion.pdf" ;
	}
	
	
	var pdf = document.getElementById('strPDF').value;
	if (pdf){
		const linkSource = 'data:application/pdf;base64,' + pdf;
	    const downloadLink = document.createElement("a");	    	
	    downloadLink.href = linkSource;
	    downloadLink.download = fileName;
	    downloadLink.click();
	}    
}


function goBack() {
	window.location.href ='<c:url value='/contribuyentes' />';

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
		var tabrad = document.getElementById('table-delineacion-radicados');
		var todo = document.getElementById('idtodos');
		var detpred = document.getElementById('detalle-predial');
		var detica = document.getElementById('detalle-ica');
		var detvehi = document.getElementById('detalle-vehiculos');
		var detdeli = document.getElementById('detalle-delurbana');
		var detgas = document.getElementById('detalle-gasolina');
		var detplubliext = document.getElementById('detalle-publiext');
		var detradic = document.getElementById('detalle-retenciones');
		
		
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tablepredial,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tablevehiculos,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tableica,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tablepublicidad,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tabledeli,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tablegas,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(todo,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(detpred,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(detica,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(detvehi,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(detdeli,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(detgas,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(detplubliext,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(detradic,'none');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(tabrad,'none');

		switch(x){
		case '1':
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tablepredial,'block');
			break;
		case '2':
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tablevehiculos,'block');
			break;
		case '3':
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tableica,'block');
			break;
		case '4':
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tablepublicidad,'block');
			break;
		case '5':
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tablegas,'block');
			break;
		case '6':
			ACC.opcionDeclaraciones.establecerEstiloDisplay(tabledeli,'block');
			break;
		default:
			ACC.opcionDeclaraciones.establecerEstiloDisplay(todo,'block');
			break;
		}

	}
	
	function cancelfun(selectObject) {
		
		goBack();
		
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

