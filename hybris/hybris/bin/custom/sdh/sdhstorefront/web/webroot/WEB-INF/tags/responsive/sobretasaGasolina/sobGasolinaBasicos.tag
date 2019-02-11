<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
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
				<div class="col-md-4">
					<div class="form-group">
						<label  class="control-label"><spring:theme
								code="impuestos.sobreTasaGasolina.DatosGenerales.anioGravableConsultardisable" /></label>
						<sf:select disabled="true" path="anoGravable"
							items="${dataForm.catalogosSo.anioGravable}"
							referenceData="${dataForm.catalogosSo.anioGravable}"
							class="form-control"/>
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="impuestos.sobreTasaGasolina.DatosGenerales.Periododisable" /></label>
						<sf:select disabled="true" path="periodo" items="${dataForm.catalogosSo.periodo}"
							referenceData="${dataForm.catalogosSo.periodo}"
							class="form-control"/>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-8">
					<div class="form-group">
						<label class="control-label "><spring:theme
								code="impuestos.sobreTasaGasolina.datosBasicos.ubicacionPlantaAbasto" /></label>
					</div>
					<div class="form-group ">
						<input id="ubicaPlanta" name="ubicaPlanta"
							class="form-control form-control" aria-required="true"
							type="text" disabled="disabled"
							value='<c:out value="${dataForm.dataForm.ubicaPlanta}"></c:out>'
							maxlength="240">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label "><spring:theme
								code="impuestos.sobreTasaGasolina.datosBasicos.codigoPostal" /></label>
					</div>
					<div class="form-group">
						<input id="codPostal" name="codPostal"
							class="form-control form-control" aria-required="true"
							type="text" disabled="disabled"
							value='<c:out value="${dataForm.dataForm.codPostal}"></c:out>'
							maxlength="240">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label "><spring:theme
								code="impuestos.sobreTasaGasolina.datosBasicos.localidad" /></label>
					</div>
					<div class="form-group ">
						<input id="localidad" name="localidad"
							class="form-control form-control" aria-required="true"
							type="text" disabled="disabled"
							value='<c:out value="${dataForm.dataForm.localidad}"></c:out>'
							maxlength="240">
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.calidadResponsable" /></label>
				</div>
				<div class="form-group ">
					<input id="calidResp" name="calidResp"
						class="form-control form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.calidResp}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.capacidadAlmacProd" /></label>
				</div>
				<div class="form-group ">
					<input id="almacProd" name="almacProd"
						class="form-control form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.almacProd}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.numTanques" /></label>
				</div>
				<div class="form-group ">
					<input id="numTanques" name="numTanques"
						class="form-control form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.numTanques}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.capacAlmacTanques" /></label>
				</div>
				<div class="form-group ">
					<input id="almacTanque" name="almacTanque"
						class="form-control form-control" aria-required="true" type="text"
						disabled="disabled"
						value='<c:out value="${dataForm.dataForm.almacTanque}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>
	</div>

	<div class="row"></div>
</sf:form>

