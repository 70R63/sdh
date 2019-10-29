<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="tramite" tagdir="/WEB-INF/tags/responsive/tramites"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<spring:url
	value="/contibuyentes/tramites/crear"
	var="enviarURL" htmlEscape="false" />

<sf:form action="${enviarURL}" method="POST" modelAttribute="dataForm" id="forma" onsubmit="return validarAntesSubmit();">
	<tramite:crearTramite/>
</sf:form>



<script>

window.onload = function() {
	
    $(".loader").fadeOut("slow");
}

function validarAntesSubmit() {

		
		var valorNivel0 = document.getElementById('selectNivel0').value;
		document.getElementById('pathValorN0').value = valorNivel0; 
		var valorNivel1 = document.getElementById('selectNivel1').value;
		document.getElementById('pathValorN1').value = valorNivel1; 
		var valorNivel2 = document.getElementById('selectNivel2').value;
		document.getElementById('pathValorN2').value = valorNivel2; 
		var valorNivel3 = document.getElementById('selectNivel3').value;
		document.getElementById('pathValorN3').value = valorNivel3; 

		
		document.form.submit();
		return true;

	}
</script>