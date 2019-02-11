<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div id="divTubularComercial" style="display: none;">
	<div class="row">
		<div class="headline">
			<h3>
				<span class="cintillo col-md-10 "><spring:theme
						code="publicidad.exterior.tubularComercial" text="Tubular Comercial" /></span>
			</h3>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.address" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularComercialDireccion" name="tubularComercialDireccion" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.areaElemento" text="Área del elemento"/></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularComercialAreaElemento" name="tubularComercialAreaElemento" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.location" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularComercialLocalidad" name="tubularComercialLocalidad" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.localidad}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.visualorientation" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularComercialOrientacion" name="tubularComercialOrientacion" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.postalcode" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularComercialCodPostal" name="tubularComercialCodPostal" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.codPostal}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.avisoLuminoso" text="Aviso luminoso"/></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularComercialAvisoLumino" name="tubularComercialAvisoLumino" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.codPostal}"
					maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.chip" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularComercialChip" name="tubularComercialChip" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.chip}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.elementlocation" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularComercialUbicacion" name="tubularComercialUbicacion" class="inputtextnew"
					aria-required="true" type="text" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.propertyreg" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularComercialMatricula" name="tubularComercialMatricula" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>

</div>

