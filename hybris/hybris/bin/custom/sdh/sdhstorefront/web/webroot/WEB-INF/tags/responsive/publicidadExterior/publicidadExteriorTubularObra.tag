<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div id="divTubularObra" style="display: none;">
	<div class="row">
		<div class="headline">
			<h3>
				<span class="cintillo col-md-10 "><spring:theme
						code="publicidad.exterior.tubularObra" text="Tubular de Obra"/></span>
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
				<input id="tubularObraDireccion" name="tubularObraDireccion" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.licenciaUrb" text="Licencia Urbana"/></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularObraLicenciaUrb" name="tubularObraLicenciaUrb" class="inputtextnew"
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
				<input id="tubularObraLocalidad" name="tubularObraLocalidad" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.localidad}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.contratoObra" text="Contrato de Obra" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularObraContratoObra" name="tubularObraContratoObra" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.contratoObra}"
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
				<input id="tubularObraCodPostal" name="tubularObraCodPostal" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.codPostal}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.buildingpermit" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularObraLicenciaConstruc" name="tubularObraLicenciaConstruc" class="inputtextnew"
					aria-required="true" type="text" value="" maxlength="240">
			</div>
		</div>

		
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.chip" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularObraChip" name="tubularObraChip" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.chip}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.licensevalidity" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularObraVigLicenConstruc" name="tubularObraVigLicenConstruc" class="inputtextnew"
					aria-required="true" type="text"
					value="" maxlength="240">
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
				<input id="tubularObraMatricula" name="tubularObraMatricula" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.areaTotal" text="Área Total"/></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularObraAreaTotal" name="tubularObraAreaTotal" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.elementlocation" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularObraUbicacion" name="tubularObraUbicacion" class="inputtextnew"
					aria-required="true" type="text" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.periodicidad" text="Periodicidad (duración de la obra)"/></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularObraPeriodicidad" name="tubularObraPeriodicidad" class="inputtextnew"
					aria-required="true" type="text" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3 ">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.visualorientation" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularObraOrientacion" name="tubularObraOrientacion" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew vehiculos"><spring:theme
					code="publicidad.exterior.tubular.numberfaces" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="tubularObraNumcaras" name="tubularObraNumcaras" class="inputtextnew"
					aria-required="true" type="text" value=""
					maxlength="240">
			</div>
		</div>
	</div>

</div>

