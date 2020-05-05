<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="facturacion" tagdir="/WEB-INF/tags/responsive/facturacion"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<spring:url
	value="/contibuyentes/tramites/seguimiento"
	var="seguimientoURL" htmlEscape="false" />
	
<div class="loader"></div>

<facturacion:personaNatGenBas/>
<facturacion:datosContacto/>
<facturacion:autorizaciones/>

<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>	