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
<div class="loader"></div>

<sf:form action="${duRetencionURL}" method="POST"
	modelAttribute="dataForm" id="forma">
	<delineacionUrbana:delineacionUrbanaDecGenerales />
	<delineacionUrbana:delineacionUrbanaRetenAreasUsos />
	<delineacionUrbana:delineacionUrbanaDecAreasUsosFechas />
	<delineacionUrbana:delineacionUrbanaDecLiqPriva />
</sf:form>
<%-- 	<delineacionUrbana:delineacionUrbanaDecFirma /> --%>
<delineacionUrbana:delineacionUrbanaDecFirmas />




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
// 	var tipnot = document.getElementById('tipnota').val;
// 	var tipnotshow1 = document.getElementById('notaCon');
// 	var tipnotshow2 = document.getElementById('notaEmp');
// 		if(tipnot == 'NIT'){
// 			tipnotshow2.style.display = 'block';
			
// 		}else{
// 			tipnotshow1.style.display = 'block';
// 		}
debugger;
		var valexe = document.getElementById('valorExen');
		var causex = document.getElementById('cauexen').value;
		if (causex != '00' || valex != null)
			{
			 valexe.disable = false;
			}
		else{
			 valexe.disable = true;
		}
	
	
	
		$(".loader").fadeOut("slow");
		
		

}
	function goBack() {
		var declaracion = '${param.declaracion}';

		if (declaracion) {
			window.location.href = "/sdhstorefront/es/contribuyentes/presentar-declaracion";
		} else {
			window.history.back();
		}
	}

	
</script>

