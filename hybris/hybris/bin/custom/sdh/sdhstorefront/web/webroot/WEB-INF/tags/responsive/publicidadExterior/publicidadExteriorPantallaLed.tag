<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div id="divPantallaLed" style="display: none;">
	<div class="row">
		<div class="headline">
			<h3>
				<span class="cintillo col-md-10 "><spring:theme
						code="publicidad.exterior.pantallaLed" text="Pantalla LED" /></span>
			</h3>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.pantalla.address" text="Dirección"/></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="pantallaLedDireccion" name="pantallaLedDireccion" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.pantalla.matricula" text="Matrícula inmobilaria" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="pantallaLedMatricula" name="pantallaLedMatricula" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.pantalla.location" text="Localidad" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="pantallaLedLocalidad" name="pantallaLedLocalidad" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.localidad}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.pantalla.ubicacion" text="Ubicación" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="pantallaLedUbicacion" name="pantallaLedUbicacion" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.pantalla.postalcode" text="Código postal" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="pantallaLedCodPostal" name="pantallaLedCodPostal" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.pantalla.tipoPublicidad" text="Tipo de publicidad"/></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="pantallaLedTipoPublicidad" name="pantallaLedTipoPublicidad" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.pantalla.chip" text="CHIP"/></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="pantallaLedChip" name="pantallaLedChip" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.pantalla.orientacionVisual" text="Orientación visual"/></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="pantallaLedOrientacionVisual" name="pantallaLedOrientacionVisual" class="inputtextnew"
					aria-required="true" type="text" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.pantalla.areaTotal" text="Área total"/></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="pantallaLedAreaTotal" name="pantallaLedAreaTotal" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>

</div>

