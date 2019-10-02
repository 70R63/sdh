<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="DeclaraPubli"
	tagdir="/WEB-INF/tags/responsive/DeclaraPubli"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!-- <div class="row"> -->
	<!-- 	<div class="container"> -->
<!-- 	<div class="account-section-content"> -->
<!-- 		<div class="account-section-form"> -->
			<form:form
				action="${pageContext.request.contextPath}/contribuyentes/publicidadexterior/declaracion"
				method="post" commandName="declaPublicidadForm">
				<DeclaraPubli:DecPuGeneral />
				<DeclaraPubli:DecPuInfoValla />
				<DeclaraPubli:DecPuTotalPag />
				<c:url value='/contribuyentes/publicidadexterior' var="taxRedirection"/>
				<firmas:generalFirmas firmaContribuyenteRedirection="${taxRedirection}"/>
			</form:form>
			<DeclaraPubli:DecPuPago />
<!-- 		</div> -->
<!-- 	</div> -->
	<!-- 	</div> -->
<!-- </div> -->

<div id="dialogPublicidadExterior" title="Publicidad Exterior">
	<div id="publicidadExteriorDialogContent"></div>
</div>

<script>

window.onload = function() {
	debugger;
	var cosas = $(":input");
	var tam = cosas.length;
	for (var i = 0; i < tam; i++) {
		var valor = cosas[i].value;
		if (valor == "") {
			cosas[i].value = "-";

		}
	}

}
</script>