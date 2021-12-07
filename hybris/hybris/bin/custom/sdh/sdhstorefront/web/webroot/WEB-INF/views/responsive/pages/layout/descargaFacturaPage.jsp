<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="desfac"
	tagdir="/WEB-INF/tags/responsive/facturacion"%>
<!-- <div class="loader"></div> -->
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<c:choose>
	<c:when test="${ not empty facturacionForm.vehicular || not empty facturacionForm.predial}">
		<desfac:descargaFactura/>
	</c:when>
	<c:otherwise>
		<desfac:sinDescargaFactura/>
	</c:otherwise>
</c:choose>


<a id="downloadHelper" target="_blank"></a>
<div id="dialogMensajes" title="Descarga Factura">
	<div id="dialogMensajesContent"></div>
</div>

		<script type="text/javascript">
window.onload = function() {
	
// 	ACC.facturacion.establecerCat_aniograv();
 //   $(".loader").fadeOut("slow");
}
	function goBack() {
		window.history.back();
	}

</script>

