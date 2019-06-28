<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new">
	<div id="divTubularComercial" style="display: none;">
		<div class="row">
			<div class="headline">
				<h2>
					<span class="col-md-10"><spring:theme
							code="publicidad.exterior.tubularComercial"
							text="Tubular Comercial" /></span>
				</h2>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-8">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.tubular.address" /></label> <input
						id="tubularComercialDireccion" name="tubularComercialDireccion"
						class="form-control" aria-required="true" type="text" value=""
						maxlength="240" disabled>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.tubular.location" /></label> <input
						id="tubularComercialLocalidad" name="tubularComercialLocalidad"
						class="form-control" aria-required="true" type="text"
						value="${publicidadForm.localidad}" maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.tubular.postalcode" /></label>
					<div class="form-group ">
						<input id="tubularComercialCodPostal"
							name="tubularComercialCodPostal" class="form-control"
							aria-required="true" type="text"
							value="${publicidadForm.codPostal}" maxlength="240" disabled>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.tubular.areaElemento"
							text="Área del elemento" /></label> <input
						id="tubularComercialAreaElemento"
						name="tubularComercialAreaElemento" class="form-control"
						aria-required="true" type="text" value="" maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-4 ">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.tubular.visualorientation" /></label> <input
						id="tubularComercialOrientacion"
						name="tubularComercialOrientacion" class="form-control"
						aria-required="true" type="text" value="" maxlength="240" disabled>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.tubular.avisoLuminoso"
							text="Aviso luminoso" /></label> <input id="tubularComercialAvisoLumino"
						name="tubularComercialAvisoLumino" class="form-control"
						aria-required="true" type="text"
						value="${publicidadForm.codPostal}" maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.tubular.chip" /></label> <input
						id="tubularComercialChip" name="tubularComercialChip"
						class="form-control" aria-required="true" type="text"
						value="${publicidadForm.chip}" maxlength="240" disabled>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.tubular.elementlocation" /></label> <input
						id="tubularComercialUbicacion" name="tubularComercialUbicacion"
						class="form-control" aria-required="true" type="text" value=""
						maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-4 ">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.tubular.propertyreg" /></label> <input
						id="tubularComercialMatricula" name="tubularComercialMatricula"
						class="form-control" aria-required="true" type="text" value=""
						maxlength="240" disabled>
				</div>
			</div>
		</div>
	</div>
</div>

