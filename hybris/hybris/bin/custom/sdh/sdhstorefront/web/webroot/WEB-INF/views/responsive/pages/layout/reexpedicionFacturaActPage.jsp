<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="facturacion" tagdir="/WEB-INF/tags/responsive/facturacion"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="miRit" tagdir="/WEB-INF/tags/responsive/miRit"%>
<spring:url
	value="/contibuyentes/tramites/seguimiento"
	var="seguimientoURL" htmlEscape="false" />
	
<div class="loader"></div>


<c:choose>
	<c:when test="${ PJUR eq true}">
<!-- 	Se comentan secciones de Reexpedicoón de factura por petición de usurio 11/10/2020 -->
<%-- 		<miRit:personalDataPJ /> --%>
	</c:when>
	<c:otherwise>
		<miRit:personalData />
<%-- 		<miRit:generalData /> --%>
	</c:otherwise>
</c:choose>
<miRit:contactData />
<facturacion:reexpedirFactura/>

<a id="downloadHelper" target="_blank"></a>
<div id="dialogMensajes" title="Descarga Factura">
	<div id="dialogMensajesContent"></div>
</div>

<div id="dialog" title="Actualización de RIT">
	<div id="ritDialogContent"></div>
</div>


<script type="text/javascript">
window.onload = function() {
	alert('Para reexpedición de factura, debes actualizar o confirmar datos y dar clic en el botón "Reexpedir Factura"\nDe lo contrario se debe realizar un trámite ingresando por el menú superior opción Trámites');
    $(".loader").fadeOut("slow");
}
</script>	