<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div id="divVehiculos" style="display: none;">
	<div class="row">
		<div class="headline">
			<h3>
				<span class="cintillo col-md-10 "><spring:theme
						code="publicidad.exterior.vehicles" /></span>
			</h3>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.typeadvertising" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tipoPublici" name="tipoPublici" class="inputtextnew"
					aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.model" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="modelo" name="modelo" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.typeitemreg" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tipoElemento" name="tipoElemento" class="inputtextnew"
					aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.plate" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="placa" name="placa" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.numberfaces" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="numCaras" name="numCaras" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.licensenumber" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="numLicenciaTrans" name="numLicenciaTrans"
					class="inputtextnew" aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.periodicity" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="periodicidad" name="periodicidad" class="inputtextnew"
					aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.typeservice" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tipoServicio" name="tipoServicio" class="inputtextnew"
					aria-required="true" type="text"
					value="${publicidadForm.tipoServicio}" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.elementlocation" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="ubicacion" name="ubicacion" class="inputtextnew"
					aria-required="true" type="text"
					value="${publicidadForm.ubicacion}" maxlength="240">

			</div>
		</div>

	</div>

</div>


