<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="col-md-12">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-12">
				<h2>
					<span tabindex="0 headline"> <spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.titulo" />
					</span>
				</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="impuestos.sobreTasaGasolina.DatosGenerales.anioGravableConsultardisable" /></label>
					<sf:select path="anoGravable"
						items="${dataForm.catalogosSo.anioGravable}"
						referenceData="${dataForm.catalogosSo.anioGravable}"
						class="newalto form-control" disabled="true" readonly="true" />
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="impuestos.sobreTasaGasolina.DatosGenerales.Periododisable" /></label>
					<sf:select path="periodo" items="${dataForm.catalogosSo.periodo}"
						referenceData="${dataForm.catalogosSo.periodo}"
						class="newalto form-control" disabled="true" readonly="true" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.ubicacionPlantaAbasto" /></label>
				</div>
				<div class="form-group ">
					<input id="ubicaPlanta" name="ubicaPlanta"
						class="new_alto form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.ubicaPlanta}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.codigoPostal" /></label>
				</div>
				<div class="form-group">
					<input id="codPostal" name="codPostal"
						class="newalto form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.codPostal}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.municipio" /></label>
				</div>
				<div class="form-group ">
					<input id="localidad" name="localidad"
						class="newalto form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.localidad}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.calidadResponsable" /></label>
				</div>
				<div class="form-group ">
					<input id="calidResp" name="calidResp"
						class="newalto form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.calidResp}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.capacidadAlmacProd" /></label>
				</div>
				<div class="form-group ">
					<input id="almacProd" name="almacProd"
						class="newalto form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.almacProd}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.numTanques" /></label>
				</div>
				<div class="form-group ">
					<input id="numTanques" name="numTanques"
						class="newalto form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.numTanques}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.capacAlmacTanques" /></label>
				</div>
				<div class="form-group ">
					<input id="almacTanque" name="almacTanque"
						class="newalto form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.almacTanque}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row"></div>

