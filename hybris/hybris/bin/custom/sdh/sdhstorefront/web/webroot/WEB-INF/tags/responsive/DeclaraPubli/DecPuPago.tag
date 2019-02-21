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


<input type="hidden" id="numForm" name="numForm"
	value="${declaPublicidadForm.numform }" />
<div class="row">

	<div class="col-md-4 text-right">
		<div class="form-group">
			<button id="regresar" class="btn btn-primary btn-lg"
				name="generaDeclaracionButton" type="button" onclick="window.location.href ='<c:url value='/contribuyentes/publicidadexterior/' />';"> 
				<spring:theme code=""
					text="Regresar" />
			</button>
		</div>
		</div>


	<div class="col-md-3 text-center">	
			<a id="downloadHelper" target="_blank"></a>
			<button id="generaDeclaracionButton" class="btn btn-primary btn-lg"
				name="generaDeclaracionButton" type="button"
				<c:if test="${empty  declaPublicidadForm.numform}"> disabled="disabled"</c:if>>
				<spring:theme code="declaracion.publicidad.button.presdec" />
			</button>
		</div>

	<div class="col-md-2">
	
			<button id="pagarlinea" class="btn btn-primary btn-lg"
				name="pagarlinea" type="button">
				<spring:theme code="declaracion.publicidad.button.pago.linea" />
			</button>
		</div>
</div>
</div>