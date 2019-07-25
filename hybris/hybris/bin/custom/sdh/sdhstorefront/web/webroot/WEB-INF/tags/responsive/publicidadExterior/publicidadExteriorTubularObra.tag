<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div id="divTubularObra" style="display: none;">
		<div class="row">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="publicidad.exterior.tubularObra" text="Tubular de Obra" /></span>
				</h2>
			</div>
		</div>
		<br />



		<div class="row">
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.tubular.address" /></label> <input
						id="tubularObraDireccion" name="tubularObraDireccion"
						class="form-control new_alto" type="text" value="" maxlength="240"
						disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.tubular.location" /></label> <input
						id="tubularObraLocalidad" name="tubularObraLocalidad"
						class="form-control newalto" type="text"
						value="${publicidadForm.localidad}" maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.tubular.postalcode" /></label> <input
						id="tubularObraCodPostal" name="tubularObraCodPostal"
						class="form-control newalto" type="text"
						value="${publicidadForm.codPostal}" maxlength="240" disabled>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.tubular.licenciaUrb"
							text="Licencia Urbana" /></label> <input id="tubularObraLicenciaUrb"
						name="tubularObraLicenciaUrb" class="form-control newalto"
						type="text" value="" maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.tubular.contratoObra"
							text="Contrato de Obra" /></label> <input id="tubularObraContratoObra"
						name="tubularObraContratoObra" class="form-control newalto"
						type="text" value="${publicidadForm.contratoObra}" maxlength="240"
						disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.tubular.buildingpermit" /></label> <input
						id="tubularObraLicenciaConstruc"
						name="tubularObraLicenciaConstruc" class="form-control newalto"
						type="text" value="" maxlength="240" disabled>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label" style="margin-top: 20px"><spring:theme
							code="publicidad.exterior.tubular.chip" /></label> <input
						id="tubularObraChip" name="tubularObraChip"
						class="form-control newalto" type="text"
						value="${publicidadForm.chip}" maxlength="240" disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.tubular.licensevalidity" /></label> <input
						id="tubularObraVigLicenConstruc"
						name="tubularObraVigLicenConstruc" class="form-control newalto"
						type="text" value="" maxlength="240" disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label" style="margin-top: 20px"><spring:theme
							code="publicidad.exterior.tubular.propertyreg" /></label> <input
						id="tubularObraMatricula" name="tubularObraMatricula"
						class="form-control newalto" type="text" value="" maxlength="240"
						disabled>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label" style="margin-top: 20px"><spring:theme
							code="publicidad.exterior.tubular.areaTotal" text="Área Total" /></label>

					<input id="tubularObraAreaTotal" name="tubularObraAreaTotal"
						class="form-control newalto" type="text" value="" maxlength="240"
						disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.tubular.elementlocation" /></label> <input
						id="tubularObraUbicacion" name="tubularObraUbicacion"
						class="form-control newalto" type="text" value="" maxlength="240"
						disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.tubular.periodicidad"
							text="Periodicidad (duración de la obra)" /></label> <input
						id="tubularObraPeriodicidad" name="tubularObraPeriodicidad"
						class="form-control newalto" type="text" value="" maxlength="240"
						disabled>
				</div>
			</div>
		</div>

		<div class="row">

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label" style="margin-top: 20px"><spring:theme
							code="publicidad.exterior.tubular.visualorientation" /></label> <input
						id="tubularObraOrientacion" name="tubularObraOrientacion"
						class="form-control newalto" type="text" value="" maxlength="240"
						disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.tubular.numberfaces" /></label> <input
						id="tubularObraNumcaras" name="tubularObraNumcaras"
						class="form-control newalto" type="text" value="" maxlength="240"
						disabled>
				</div>
			</div>
		</div>
	</div>
</div>