<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sobretasaGasolina" tagdir="/WEB-INF/tags/responsive/sobretasaGasolina"%>

<template:page pageTitle="${pageTitle}">

		
		<sobretasaGasolina:sobretasaGasolinaTable/>
		
		<c:if test="${not empty showDetail }">
		
			<sobretasaGasolina:sobretasaGasolinaDetail/>
		
		</c:if>


		
		



</template:page>

<script>
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
}
	function goBack() {
		window.history.back();
	}
</script>
