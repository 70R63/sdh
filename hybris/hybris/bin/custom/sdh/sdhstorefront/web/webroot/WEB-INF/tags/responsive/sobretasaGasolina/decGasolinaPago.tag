<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url
	value="/contribuyentes/sobretasa-gasolina/declaracion-gasolinaPagar"
	var="pagarURL" htmlEscape="false" />


<div class="container">
	<div class="col-md-8 text-center">


		<sf:form action="${pagarURL}" method="POST"
			modelAttribute="detallePagoRequest" id="detallePagoRequest">

			<a id="downloadHelper" target="_blank"></a>
			<input type="hidden" id="numForm" value="${dataForm.numForm }">
			<button type="button" class="btn btn-secondary btn-lg"
				onclick="goBack()">
				<spring:theme code="impuestos.decGasolina.Pago.Regresar" />
			</button>
			<button id="gasolinaGeneraDeclaracionButton"  type="button" class="btn btn-primary btn-lg GeneraDeclaracionButton">
				<spring:theme code="impuestos.decGasolina.Pago.PresentarDec"/>
			</button>
			<sf:hidden path="numBP" />
			<sf:hidden path="clavePeriodo" />
			<sf:hidden path="numObjeto" />
			<c:choose>
				<c:when test="${empty dataForm.habilitaPagarEnLinea}">
					<c:set var = "deshabilitarPagar" value = "true"/>
				</c:when>
				<c:otherwise>
					<c:set var = "deshabilitarPagar" value = "false"/>	
				</c:otherwise>
			</c:choose>
			<sf:button class="btn btn-primary btn-lg pagarbtn" type="submit" id="pagar"
				name="action" value="pagar" disabled="${deshabilitarPagar}">
				<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
			</sf:button>
		</sf:form>
	</div>

	<br>
	<div class="col-md-12">
		<div class="table-responsive">
			<div class="form-group" style="text-align: center !important">
				<spring:theme
						code="impuestos.decGasolina.Pago.nota" />
			</div>
		</div>
	</div>

	<div class="row"></div>

	<div id="dialogGasolina" title="Gasolina">
		<div id="gasolinaDialogContent"></div>
	</div>
</div>