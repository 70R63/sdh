

<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="predial"
	tagdir="/WEB-INF/tags/responsive/predial/predialBasesPresuntivas"%>
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<predial:predialBasesGenerales />
<predial:predialBasesDatPredio />

<c:set var="flagDisplay" value="display: none"/>
<c:if test="${predialFormbases.controlCampos.datosPredio == true}" >
<c:set var="flagDisplay" value="display: block"/>
</c:if>
<div class="BasesDetalle" id="BasesDetalle" style="${flagDisplay}">
<predial:predialBasesDatLiq />
	<predial:predialBasesLiqPrivada />
	<firmas:generalFirmas />
	<predial:predialBasesBotones />
</div>

<div id="dialogMensajes" title="Predial">
	<div id="dialogMensajesContent"></div>
</div>
<div id="dialogICA" title="Predial" ><div id="icaDialogContent"></div></div>
<a id="downloadHelper" target="_blank"></a>
<div id="dialogDeclaracion" title="Declaracion">
	<div id="declaracionDialogContent"></div>
</div>
<script>

window.onload = function() {
	
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
</script>