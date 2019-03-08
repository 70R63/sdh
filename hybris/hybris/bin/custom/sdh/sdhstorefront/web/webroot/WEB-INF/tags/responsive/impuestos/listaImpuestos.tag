<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/contribuyentes/presentar-declaracion"
	var="presentarDeclaracionUrl" htmlEscape="false" />



<br>
<div class="col-md-10 col-md-offset-2">
	<div class="row">
		<div class="col-md-3">
			<div class="form-group ">
				<label class="control-label required"><spring:theme
						code="impuestos.presentarDeclaracion.impuesto" /></label>

			<%--<sf:select path="impuesto" items="${dataForm.catalogosSo.impuesto}"
					referenceData="${dataForm.catalogosSo.impuesto}"
					class="form-control"/>--%>
					<sf:select id="impuestonew" class="form-control" path="impuesto"> 
				
				</sf:select>
			</div>
		</div>

		
		<div id="impuestoss" style="display: none;">
			<input value="${dataForm.optionPubliExt}" id="impuestoPE" />
		</div>
		<div id="impuestoss2" style="display: none;">
			<input value="${dataForm.optionGas}" id="impuestoGas" />
		</div>

		<div class="col-md-3">
			<div class="form-group ">
				<label class="control-label required"><spring:theme
						code="impuestos.presentarDeclaracion.anioGravableConsultar" /></label>

				<sf:select path="anoGravable"
					items="${dataForm.catalogosSo.anioGravable}"
					referenceData="${dataForm.catalogosSo.anioGravable}"
					class="form-control" />
			</div>


		</div>

		<div class="col-md-3">
			<div class="form-group ">
				<label class="control-label required"><spring:theme
						code="impuestos.presentarDeclaracion.Periodo" /></label>

				<sf:select path="periodo" items="${dataForm.catalogosSo.periodo}"
					referenceData="${dataForm.catalogosSo.periodo}"
					class="form-control" />
			</div>


		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<sf:button action="${presentarDeclaracionUrl}" type="submit"
				class="btn btn-primary btn-lg" id="action" name="action"
				value="presentarDeclaracion" style="width: 187px !important">
				<spring:theme
					code="impuestos.presentarDeclaracion.PresentarDeclaracion" />
			</sf:button>
		</div>
	</div>
</div>
<br>