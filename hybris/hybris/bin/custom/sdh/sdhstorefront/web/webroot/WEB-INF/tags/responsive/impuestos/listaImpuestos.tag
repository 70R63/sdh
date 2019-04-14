<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/contribuyentes/presentar-declaracion"
	var="presentarDeclaracionUrl" htmlEscape="false" />

<c:out value = "${dataForm.impuesto}"/>


<br>
<div class="col-md-10 col-md-offset-2">
	<div class="row">
		<div class="col-md-3">
			<div class="form-group ">
				<label class="control-label required"><spring:theme
						code="impuestos.presentarDeclaracion.impuesto" /></label>
				<sf:select 
					path="impuesto" 
					id="impuesto" 
					class="form-control" 
					onchange="onChange()" > 				
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

		<c:if test="${dataForm.impuesto ne '4'}">
		<div class="col-md-3">
			<div class="form-group ">
				<label class="control-label required"><spring:theme
						code="impuestos.presentarDeclaracion.Periodo" /></label>

				<sf:select path="periodo" items="${dataForm.catalogosSo.periodo}"
					referenceData="${dataForm.catalogosSo.periodo}"
					class="form-control" />
			</div>


		</div>
		</c:if>
	</div>
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-9 text-center">
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