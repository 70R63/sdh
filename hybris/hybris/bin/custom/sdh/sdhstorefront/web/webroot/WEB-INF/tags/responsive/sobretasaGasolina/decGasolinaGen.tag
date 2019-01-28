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
		<h3>
			<span tabindex="0"> <spring:theme
					code="impuestos.decGasolina.DatosGenerales.titulo" />
			</span>
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.decGasolina.DatosGenerales.anioGravableConsultar" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="anoGravable" name="anoGravable"
				class="form-control form-control" aria-required="true" type="text"
				value="${dataForm.anoGravable}" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.decGasolina.DatosGenerales.Periodo" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="periodo" name="periodo" class="form-control form-control"
				aria-required="true" type="text" value="${dataForm.periodo}"
				maxlength="240">
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.decGasolina.DatosGenerales.numeroIdentificacion" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="numDoc" name="numDoc" class="form-control form-control"
				aria-required="true" type="text" value="${dataForm.numDoc}"
				maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.decGasolina.DatosGenerales.OpcionesUso" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
						<sf:select path="dataForm.opcionesUso"
							items="${dataForm.catalogos.opcionesUso}"
							referenceData="${dataForm.catalogos.opcionesUso}" />
<!-- 			<select id="opcionesUso" class="form-control"> -->
<%-- 				<c:forEach items="${dataForm.catalogos.opcionesUso}" var="elemento"> --%>
<%-- 					<option value="${elemento.key}" --%>
<%-- 						${elemento.key == infoDeclara.opcionesUso ? 'selected="selected"' : ''}> --%>
<%-- 						<c:out value="${elemento.label}" /></option> --%>
<%-- 				</c:forEach> --%>
<!-- 			</select> -->
		</div>
	</div>
</div>


