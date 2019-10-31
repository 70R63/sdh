<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="icadecla" tagdir="/WEB-INF/tags/responsive/ica"%>
<%@ taglib prefix="delineacionUrbana"
	tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>

	<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>

<div class="loader"></div>
	<icadecla:icaDeclaraInicial/>
	<icadecla:icaDeclaraGenerales/>
	<icadecla:icaDeclaraActFuera/>
	<icadecla:icaDeclaraDeduccion/>
	<icadecla:icaDeclaraTotal/>
	<icadecla:icaDeclaraValor/>
	<icadecla:icaDeclaraLiquidacion/>

	<c:url value='${redirectURL}' var="taxRedirection"/>
	<firmas:generalFirmas firmaContribuyenteRedirection="${taxRedirection}"/>

	<icadecla:icaDeclaraButtons />

	<div id="dialogICA" title="ICA" ><div id="icaDialogContent"></div></div>
	

<script>	

window.onload = function() {
	debugger;
	var cosas = $(":input");
	var tam = cosas.length;
	if (false){ //EMP-codigo comentado por observaciones en pruebas realizadas el 04 de octubre 2019
		for (var i = 0; i < tam; i++) {
			var valor = cosas[i].value;
			if (valor == "") {
				cosas[i].value = "-";

			}
		}
	}
	 $(".loader").fadeOut("slow");

}
	function goBack() {
		window.history.back();
	}
</script>	