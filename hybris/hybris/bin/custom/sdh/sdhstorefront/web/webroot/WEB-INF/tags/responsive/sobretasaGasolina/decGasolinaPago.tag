<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />




<div class="col-md-8 text-right">

	<button type="button"  class="btn btn-primary btn-lg" onclick="window.location.href ='<c:url value='/contribuyentes/sobretasa-gasolina' />';">Regresar</button>

		
	<button type="button" <c:if test="${empty  dataForm.dataForm.numForm}"> disabled="disabled"</c:if> class="btn btn-primary btn-lg" onclick="window.location.href ='<c:url value='/contribuyentes/sobretasa-gasolina/generar?numForm=${ dataForm.dataForm.numForm}' />';">Generar Declaraci�n</button>
	
	<div class="col-md-1"></div>
	
	<sf:button class="btn btn-primary btn-lg" type="submit" id="action"
		name="action">
		<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
	</sf:button>
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

