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
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.model" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="vehiculoModelo" name="vehiculoModelo" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.typeadvertising" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="vehiculoTipoPublici" name="vehiculoTipoPublici" class="inputtextnew"
					aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.plate" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="vehiculoPlaca" name="vehiculoPlaca" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.typeitemreg" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="vehiculoTipoElemento" name="vehiculoTipoElemento" class="inputtextnew"
					aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.licensenumber" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="vehiculoNumLicenciaTrans" name="vehiculoNumLicenciaTrans"
					class="inputtextnew" aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.elementlocation" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="vehiculoOrientacion" name="vehiculoOrientacion" class="inputtextnew"
					aria-required="true" type="text"
					value="${publicidadForm.orientacion}" maxlength="240">

			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.vehicles.typeservice" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="vehiculoTipoServicio" name="vehiculoTipoServicio" class="inputtextnew"
					aria-required="true" type="text"
					value="${publicidadForm.tipoServicio}" maxlength="240">
			</div>
		</div>
	</div>
</div>


