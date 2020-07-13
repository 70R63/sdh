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

<miRit:personalData />
<miRit:generalData />
<miRit:contactData />
<facturacion:reexpedirFactura/>


<script type="text/javascript">
window.onload = function() {
	alert('Para reexpedición de factura, debes actualizar o confirmar datos y dar clic en el botón "Reexpedir Factura"');
    $(".loader").fadeOut("slow");
}
</script>	