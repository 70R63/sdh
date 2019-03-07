<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url
	value="/contribuyentes/sobretasa-gasolina/declaracion-gasolina"
	var="presentarDeclaracionUrl" htmlEscape="false" />
<spring:url value="/contribuyentes/sobretasa-gasolina" var="buscarUrl"
	htmlEscape="false" />


<div class="row">
	<div class="col-md-6">
		<h2>
			<span tabindex="0 headline"> <spring:theme
					code="impuestos.sobreTasaGasolina.representantes.detalleanteriores" />
			</span>
		</h2>
	</div>
</div>
<div class="row">
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="impuestos.decGasolina.DatosGenerales.anioGravableConsultar" /></label>
			<sf:select path="anoGravable"
				items="${dataForm.catalogosSo.anioGravable}"
				referenceData="${dataForm.catalogosSo.anioGravable}"
				class="form-control" />
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<div class="form-group ">
			<label class="control-label"><spring:theme
					code="impuestos.decGasolina.DatosGenerales.Periodo" /></label>
			<sf:select path="periodo" items="${dataForm.catalogosSo.periodo}"
				referenceData="${dataForm.catalogosSo.periodo}" class="form-control" />
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-8  text-right">
		<sf:button action="${buscarUrl}" type="submit"
			class="btn btn-primary btn-lg" id="action" name="action"
			value="buscar">
			<spring:theme
				code="impuestos.sobreTasaGasolina.DatosGenerales.buscar" />
		</sf:button>
	</div>
</div>
<div class="row"></div>



