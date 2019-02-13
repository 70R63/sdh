<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<div class="headline">
			<h2>
				<span tabindex="0"> <spring:theme
						code="impuestos.decGasolina.DatosGenerales.titulo" />
				</span>
			</h2>
		</div>
	</div>
</div>


<div class="row">
	<div class="col-md-4">
		<div class="form-group ">
			<label class="control-label"><spring:theme
					code="impuestos.decGasolina.DatosGenerales.anioGravableConsultar" /></label>
			<sf:select path="anoGravable"
				items="${dataForm.catalogosSo.anioGravable}"
				referenceData="${dataForm.catalogosSo.anioGravable}"
				class="form-control" />
		</div>
	</div>
	<div class="col-md-4">
		<div class="form-group ">
			<label class="control-label"><spring:theme
					code="impuestos.decGasolina.DatosGenerales.Periodo" /></label>
			<sf:select path="periodo" items="${dataForm.catalogosSo.periodo}"
				referenceData="${dataForm.catalogosSo.periodo}" class="form-control" />
		</div>
	</div>
</div>
<br>

<div class="row">
	<div class="col-md-4">
		<div class="form-group ">
			<label class="control-label"><spring:theme
					code="impuestos.decGasolina.DatosGenerales.numeroIdentificacion" /></label>
			<sf:input path="numDoc" value="${dataForm.numDoc}"
				class="form-control form-control" maxlength="30" size="20"
				readonly="true" />
			<!-- 				<input id="numeroId" name="numeroId" class="form-control form-control" -->
			<!-- 					aria-required="true" type="text" value="" maxlength="240"> -->
		</div>
	</div>

	<div class="col-md-4">
		<div class="form-group ">
			<label class="control-label"><spring:theme
					code="impuestos.decGasolina.DatosGenerales.OpcionesUso" /></label>
			<div class="form-group ">
				<sf:select path="opcionUso"
					items="${dataForm.catalogosSo.opcionesUso}"
					referenceData="${dataForm.catalogosSo.opcionesUso}"
					class="form-control" />
			</div>
		</div>
	</div>
</div>



