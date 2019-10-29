<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="asigna"
	tagdir="/WEB-INF/tags/responsive/asignarsecomoAgente"%>

<asigna:buscarContrib />
<div id="IdDetalleCrear" style="display: none">
	<asigna:selecCalidad />
	<asigna:selecImpuesto />
	<asigna:selecTramiteGeneral />
	<asigna:adjDocumentos />
	<asigna:resumen />
</div>


<script type="text/javascript">

window.onload = function() {
	debugger;
	var cosas = $(":input");
	var tam = cosas.length;
	if (false){
		for (var i = 0; i < tam; i++) {
			var valor = cosas[i].value;
			if (valor == "") {
				cosas[i].value = "-";

			}
		}
	}
	$(".loader").fadeOut("slow");
}
	function detalleBP() {
		debugger;
		var det = document.getElementById('IdDetalleCrear');
		det.style.display = 'block';
	}
</script>