<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div id="divObraConvencional" style="display: none;">
		<div class="row">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="publicidad.exterior.obraConventional"
							text="Obra Convencional" /></span>
				</h2>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.conventional.locationaddress" /></label> <input
						id="obraConvencionalDireccion" name="obraConvencionalDireccion"
						class="form-control new_alto" aria-required="true" type="text"
						value="${publicidadForm.direccion}" maxlength="240" disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.conventional.location" /></label> <input
						id="obraConvencionalLocalidad" name="obraConvencionalLocalidad"
						class="form-control newalto" aria-required="true" type="text"
						value="${publicidadForm.localidad}" maxlength="240" disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.conventional.postalcode" /></label> <input
						id="obraConvencionalCodPostal" name="obraConvencionalCodPostal"
						class="form-control newalto" aria-required="true" type="text"
						value="${publicidadForm.codPostal}" maxlength="240" disabled>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label" style="margin-top: 20px"><spring:theme
							code="publicidad.exterior.vehicles.typeadvertising" /></label> <input
						id="obraConvencionaltipoPublici"
						name="obraConvencionaltipoPublici" class="form-control newalto"
						aria-required="true" type="text"
						value="${publicidadForm.tipoPublici}" maxlength="240" disabled>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.conventional.elementlocation" /></label> <input
						id="obraConvencionalUbicacion" name="obraConvencionalUbicacion"
						class="form-control newalto" aria-required="true" type="text"
						value="${publicidadForm.ubicacion}" maxlength="240" disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label" style="margin-top: 20px"><spring:theme
							code="publicidad.exterior.conventional.CHIP" /></label> <input
						id="obraConvencionalChip" name="obraConvencionalChip"
						class="form-control newalto" aria-required="true" type="text"
						value="${publicidadForm.chip}" maxlength="240" disabled>
				</div>
			</div>
		</div>

		<div class="row">

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.detail.luminousnotices" /></label> <input
						id="obraConvencionalAvisoLumino"
						name="obraConvencionalAvisoLumino" class="form-control newalto"
						aria-required="true" type="text"
						value="${publicidadForm.avisoLumino}" maxlength="240" disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.detail.matriculaInmo"
							text="Matricula inmobilar" /></label> <input
						id="obraConvencionalMatricula" name="obraConvencionalMatricula"
						class="form-control newalto" aria-required="true" type="text"
						value="${publicidadForm.matricula}" maxlength="240" disabled>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.conventional.visualorientation" /></label> <input
						id="obraConvencionalOrientacion"
						name="obraConvencionalOrientacion" class="form-control newalto"
						aria-required="true" type="text"
						value="${publicidadForm.orientacion}" maxlength="240" disabled>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.conventional.totalarea" /></label> <input
						id="obraConvencionalTotalArea" name="obraConvencionalTotalArea"
						class="form-control newalto" aria-required="true" type="text"
						value="${publicidadForm.areaTotal}" maxlength="240" disabled>
				</div>
			</div>
		</div>
	</div>
</div>