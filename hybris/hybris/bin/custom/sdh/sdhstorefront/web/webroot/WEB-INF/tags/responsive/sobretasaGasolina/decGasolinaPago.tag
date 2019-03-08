<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/impuestos/pagoEnLinea/form" var="pagarURL"
	htmlEscape="false" />



<div class="col-md-8 text-right">
	<sf:form action="${pagarURL}" method="POST"
		modelAttribute="psePaymentForm" id="psePaymentForm">

		<a id="downloadHelper" target="_blank"></a>
		<input type="hidden" id="numForm" value="${dataForm.numForm }">
		<%--<button type="button" class="btn btn-primary btn-lg"
		onclick="window.location.href ='<c:url value='/contribuyentes/sobretasa-gasolina' />';"><spring:theme code="impuestos.decGasolina.Pago.Regresar" /></button> --%>
		<button type="button" class="btn btn-primary btn-lg" onclick="goBack()"><spring:theme
			code="impuestos.decGasolina.Pago.Regresar" />
		</button>
		<button id="gasolinaGeneraDeclaracionButton" type="button"
			<c:if test="${empty  dataForm.numForm}"> disabled="disabled"</c:if>
			class="btn btn-primary btn-lg">
			<spring:theme code="impuestos.decGasolina.Pago.PresentarDec" />
		</button>

		<sf:input path="tipoDeImpuesto" type="hidden" />
		<sf:input path="anoGravable" type="hidden" />
		<sf:input path="valorAPagar" type="hidden" />
		<sf:input path="periodo" type="hidden" />
		<sf:input path="tipoDeIdentificacion" type="hidden" />
		<sf:input path="noIdentificacion" type="hidden" />
		<sf:input path="numeroDeReferencia" type="hidden" />
		<sf:input path="fechaLimiteDePago" type="hidden" />
		<sf:input path="DV" type="hidden" />
		<sf:input path="objPago" type="hidden" />
		<sf:button class="btn btn-primary btn-lg" type="submit" id="action"
<<<<<<< HEAD
<<<<<<< HEAD
			name="pagar" value="pagar" >
=======
			name="pagar" value="pagar"
			disabled="${empty psePaymentForm.numeroDeReferencia ? 'true' : 'false'}">
>>>>>>> dev-maria
=======
			name="pagar" value="pagar"
			disabled="${empty psePaymentForm.numeroDeReferencia ? 'true' : 'false'}">
=======
			name="pagar" value="pagar" >
>>>>>>> dev
>>>>>>> dev-maria
			<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
		</sf:button>
	</sf:form>
</div>

<br>
<div class="col-md-12">
	<div class="table-responsive">
		<div class="form-group">
			<span tabindex="0"><spring:theme
					code="impuestos.decGasolina.Pago.nota" /></span>
		</div>
	</div>
</div>

<div class="row"></div>

<div id="dialogGasolina" title="Gasolina">
	<div id="gasolinaDialogContent"></div>
</div>