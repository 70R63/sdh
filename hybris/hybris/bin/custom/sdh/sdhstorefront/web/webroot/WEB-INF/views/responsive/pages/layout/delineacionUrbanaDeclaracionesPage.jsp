<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="delineacionUrbana"
	tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/contribuyentes/delineacionurbana/retencion"
	var="duRetencionURL" htmlEscape="false" />


<sf:form action="${duRetencionURL}" method="POST"
	modelAttribute="dataForm" id="forma">
	<delineacionUrbana:delineacionUrbanaDecGenerales />
	<delineacionUrbana:delineacionUrbanaRetenAreasUsos />
	<delineacionUrbana:delineacionUrbanaDecAreasUsosFechas />
	<delineacionUrbana:delineacionUrbanaDecLiqPriva />
	</sf:form>
	<delineacionUrbana:delineacionUrbanaDecFirma />





<script>
	function goBack() {
		var declaracion = '${param.declaracion}';
		
		if(declaracion){
			window.location.href = "/sdhstorefront/es/contribuyentes/presentar-declaracion";
		}else{
			window.history.back();
		}
	}
	
	function obranueva(){
		
		var value = selectObject.value;
		var areaintervenida = document.getElementById('selectareinter');
		var inareainter = document.getElementById('inputareainter');
		
		if (value == '6'){
			
			areaintervenida.disabled=false;
			inareainter.disabled=false;
			
		}else{
			areaintervenida.disabled=true;
			inareainter.disabled=true;
		}
		
}
	window.onload = function data() {

		debugger;

		var value = document.getElementById("selecmodlicen");
		var areaintervenida = document.getElementById('selectareinter');
		var inareainter = document.getElementById('inputareainter');
		
		if (value == '6'){
			
			areaintervenida.disabled=false;
			inareainter.disabled=false;
			
		}else{
			areaintervenida.disabled=true;
			inareainter.disabled=true;
		}
	}
</script>

