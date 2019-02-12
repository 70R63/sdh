<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/contribuyentes/publicidadexterior/declaracion"
	var="CalculodeclaracionUrl" htmlEscape="false" />
<spring:url value="/contribuyentes/publicidadexterior/declaracion"
	var="CalculodeclaracionUrl2" htmlEscape="false" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span class="cintillo col-md-10"><spring:theme
					code="declaracion.publicidad.pago" /></span>
		</h3>
	</div>
</div>
<input type="hidden" id="numForm" name="numForm" />
<div class="row">
	<div class="col-md-3 col-md-offset-6 center">
		<div class="accountActions">
			<div class="boton" type="button">
				<spring:theme code="declaracion.publicidad.button.gendecl" />
			</div>
		</div>
		<div class="accountActions">
			<sf:form action="${presentarDeclaracionUrl2}"
				id="presentarDeclaracionUrl1" commandName="presentarDeclaracion"
				method="GET">		
					<button id="${presentarDeclaracionUrl2}" type="submit"
						class="boton">
						<spring:theme code="declaracion.publicidad.button.crenewdec" />
					</button>
			</sf:form>
		</div>
	<div class="accountActions">
		<div class="boton" type="button">
			<spring:theme code="declaracion.publicidad.button.presdec" />
		</div>
	</div>
	<div class="accountActions">
		<div class="boton" type="button">
			<spring:theme code="declaracion.publicidad.button.pago.linea" />
		</div>

		<div class="accountActions">
			<div class="boton" type="button">
				<spring:theme code="declaracion.publicidad.button.rop" />
			</div>
		</div>
	</div>
</div>
</div>



