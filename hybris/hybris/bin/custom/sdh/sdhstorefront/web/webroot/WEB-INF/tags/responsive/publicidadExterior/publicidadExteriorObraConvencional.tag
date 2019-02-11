<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div id="divObraConvencional" style="display: none;">
	<div class="row">
		<div class="headline">
			<h3>
				<span class="cintillo col-md-10 "><spring:theme
						code="publicidad.exterior.obraConventional" text="Obra Convencional"/></span>
			</h3>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-md-3 ">
			<label class="inputlabelnew avisos"><spring:theme
					code="publicidad.exterior.conventional.locationaddress" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="obraConvencionalDireccion" name="obraConvencionalDireccion" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.direccion}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew avisos"><spring:theme
					code="publicidad.exterior.vehicles.typeadvertising" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="obraConvencionaltipoPublici" name="obraConvencionaltipoPublici" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.tipoPublici}"
					maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew avisos"><spring:theme
					code="publicidad.exterior.conventional.location" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="obraConvencionalLocalidad" name="obraConvencionalLocalidad" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.localidad}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew avisos"><spring:theme
					code="publicidad.exterior.conventional.elementlocation" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="obraConvencionalUbicacion" name="obraConvencionalUbicacion" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.ubicacion}"
					maxlength="240">
			</div>
		</div>
		
	</div>

	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew avisos"><spring:theme
					code="publicidad.exterior.conventional.postalcode" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="obraConvencionalCodPostal" name="obraConvencionalCodPostal" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.codPostal}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew avisos"><spring:theme
					code="publicidad.exterior.conventional.CHIP" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="obraConvencionalChip" name="obraConvencionalChip" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.chip}"
					maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.luminousnotices" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="obraConvencionalAvisoLumino" name="obraConvencionalAvisoLumino" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.avisoLumino}" maxlength="240">
			</div>
		</div>	
		<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.matriculaInmo" text="Matricula inmobilar" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="obraConvencionalMatricula" name="obraConvencionalMatricula" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.matricula}" maxlength="240">
			</div>
		</div>	
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew avisos"><spring:theme
					code="publicidad.exterior.conventional.visualorientation" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="obraConvencionalOrientacion" name="obraConvencionalOrientacion" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.orientacion}"
					maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew avisos"><spring:theme
					code="publicidad.exterior.conventional.totalarea" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="obraConvencionalTotalArea" name="obraConvencionalTotalArea" class="inputtextnew"
					aria-required="true" type="text" value="${publicidadForm.areaTotal}"
					maxlength="240">
			</div>
		</div>
	</div>

</div>










