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


<div class="col-md-12">
	<div class="table-responsive">
		<div class="form-group">
			<span tabindex="0"><spring:theme
					code="impuestos.decGasolina.Pago.redireccionandoPSE" /></span>
		</div>
	</div>
</div>
<div class="container">
	<sf:form action="${pagarURL}" method="POST"
		modelAttribute="psePaymentForm" id="psePaymentForm">
		<sf:hidden path="tipoDeImpuesto" />
		<sf:hidden path="anoGravable" />
		<sf:hidden path="valorAPagar" />
		<sf:hidden path="periodo" />
		<sf:hidden path="tipoDeIdentificacion" />
		<sf:hidden path="noIdentificacion" />
		<sf:hidden path="numeroDeReferencia" />
		<sf:hidden path="fechaLimiteDePago" />
		<sf:hidden path="DV" />
		<sf:hidden path="objPago" />
		<sf:hidden path="CUD" />
		<sf:hidden path="CHIP" />
		<sf:hidden path="cdu" />
		<sf:hidden path="placa" />
		<sf:button class="btn btn-primary btn-lg" type="submit" id="action"
			name="pagar" value="pagar" disabled="true">
			<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
		</sf:button>
	</sf:form>
</div>