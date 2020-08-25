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

<facturacion:autorizaciones/>

<script type="text/javascript">
window.onload = function() {
	alert("Los contribuyentes del predial, pueden obtener un descuento adicional del 1% sobre el valor a pagar del impuesto predial, para la vigencia 2020 si actualizan y reportan su información de contacto y autorizan que los datos registrados puedan ser usados con fines institucionales y para la notificación electrónica. ");
    $(".loader").fadeOut("slow");
}
</script>	