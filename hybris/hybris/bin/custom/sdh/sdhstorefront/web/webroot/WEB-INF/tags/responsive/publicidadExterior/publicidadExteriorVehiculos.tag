<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div id="divVehiculos" style="display: none;">
		<div class="row">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="publicidad.exterior.vehicles" /></span>
				</h2>
			</div>
		</div>
		<br />

		<div class="row">
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.vehicles.model" /></label> <input
						id="vehiculoModelo" name="vehiculoModelo"
						class="newalto form-control" aria-required="true" type="text"
						value="" maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.vehicles.typeadvertising" /></label> <input
						id="vehiculoTipoPublici" name="vehiculoTipoPublici"
						class="newalto form-control" aria-required="true" type="text"
						value="" maxlength="240" disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.vehicles.plate" /></label> <input
						id="vehiculoPlaca" name="vehiculoPlaca"
						class="newalto form-control" aria-required="true" type="text"
						value="" maxlength="240" disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.vehicles.typeitemreg" /></label> <input
						id="vehiculoTipoElemento" name="vehiculoTipoElemento"
						class="newalto form-control" aria-required="true" type="text"
						value="" maxlength="240" disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.vehicles.licensenumber" /></label> <input
						id="vehiculoNumLicenciaTrans" name="vehiculoNumLicenciaTrans"
						class="newalto form-control" aria-required="true" type="text"
						value="" maxlength="240" disabled>
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.vehicles.typeservice" /></label> <input
						id="vehiculoTipoServicio" name="vehiculoTipoServicio"
						class="newalto form-control" aria-required="true" type="text"
						value="${publicidadForm.tipoServicio}" maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.vehicles.elementlocation" /></label> <input
						id="vehiculoOrientacion" name="vehiculoOrientacion"
						class="newalto form-control" aria-required="true" type="text"
						value="${publicidadForm.orientacion}" maxlength="240" disabled>
				</div>
			</div>
		</div>
	</div>
</div>