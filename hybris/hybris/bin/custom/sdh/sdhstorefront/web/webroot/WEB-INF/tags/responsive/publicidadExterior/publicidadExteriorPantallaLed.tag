<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new">
	<div id="divPantallaLed" style="display: none;">
		<div class="row">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="publicidad.exterior.pantallaLed" text="Pantalla LED" /></span>
				</h2>
			</div>
		</div>
		<br />

		<div class="row">
			<div class="col-md-8">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.pantalla.address" text="Dirección" /></label>
					<input id="pantallaLedDireccion" name="pantallaLedDireccion"
						class="form-control" aria-required="true" type="text" value=""
						maxlength="240" disabled>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.pantalla.postalcode"
							text="Código postal" /></label> <input id="pantallaLedCodPostal"
						name="pantallaLedCodPostal" class="form-control"
						aria-required="true" type="text" value="" maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.pantalla.location" text="Localidad" /></label>
					<input id="pantallaLedLocalidad" name="pantallaLedLocalidad"
						class="form-control" aria-required="true" type="text"
						value="${publicidadForm.localidad}" maxlength="240" disabled>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.pantalla.ubicacion" text="Ubicación" /></label>
					<input id="pantallaLedUbicacion" name="pantallaLedUbicacion"
						class="form-control" aria-required="true" type="text" value=""
						maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.pantalla.matricula"
							text="Matrícula inmobilaria" /></label> <input id="pantallaLedMatricula"
						name="pantallaLedMatricula" class="form-control"
						aria-required="true" type="text" value="" maxlength="240" disabled>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.pantalla.tipoPublicidad"
							text="Tipo de publicidad" /></label> <input
						id="pantallaLedTipoPublicidad" name="pantallaLedTipoPublicidad"
						class="form-control" aria-required="true" type="text" value=""
						maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.pantalla.chip" text="CHIP" /></label> <input
						id="pantallaLedChip" name="pantallaLedChip" class="form-control"
						aria-required="true" type="text" value="" maxlength="240" disabled>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.pantalla.orientacionVisual"
							text="Orientación visual" /></label> <input
						id="pantallaLedOrientacionVisual"
						name="pantallaLedOrientacionVisual" class="form-control"
						aria-required="true" type="text" value="" maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.pantalla.areaTotal" text="Área total" /></label>
					<input id="pantallaLedAreaTotal" name="pantallaLedAreaTotal"
						class="form-control" aria-required="true" type="text" value=""
						maxlength="240" disabled>
				</div>
			</div>
		</div>
	</div>
</div>
