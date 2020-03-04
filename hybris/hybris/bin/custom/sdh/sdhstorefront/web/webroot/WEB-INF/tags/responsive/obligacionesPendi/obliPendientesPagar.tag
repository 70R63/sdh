<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL"
	htmlEscape="false" />

<div class="container">
	<div class="row">
		<sf:form action="${pagarURL}" method="POST" modelAttribute="infoPreviaPSE" id="infoPreviaPSE">
			<div class="col-md-2">
				<sf:hidden path="tipoImpuesto" id="pagarEnLinea_tipoImpuesto"/>
				<sf:hidden path="numBP" id="pagarEnLinea_numBP"/>
				<sf:hidden path="numDoc" id="pagarEnLinea_numDoc"/>
				<sf:hidden path="tipoDoc" id="pagarEnLinea_tipoDoc"/>
				<sf:hidden path="anoGravable" id="pagarEnLinea_anoGravable"/>
				<sf:hidden path="periodo" id="pagarEnLinea_periodo"/>
				<sf:hidden path="clavePeriodo" id="pagarEnLinea_clavePeriodo"/>
				<sf:hidden path="dv" id="pagarEnLinea_dv"/>
				<sf:hidden path="numObjeto" id="pagarEnLinea_numObjeto"/>
				<sf:hidden path="chip" id="pagarEnLinea_chip"/>
				<sf:hidden path="fechaVenc" id="pagarEnLinea_fechaVenc"/>
				<sf:hidden path="numRef" id="pagarEnLinea_numRef"/>
				<sf:hidden path="totalPagar" id="pagarEnLinea_totalPagar"/>
			</div>
		</sf:form>
	</div>
</div>
