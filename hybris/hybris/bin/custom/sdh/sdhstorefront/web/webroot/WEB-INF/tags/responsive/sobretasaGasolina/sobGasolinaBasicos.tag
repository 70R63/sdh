<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="col-md-12">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-12">
				<h3>
					<span tabindex="0" class="col-md-12 cintillo"> <spring:theme
							code="impuestos.sobreTasaGasolina.datosBasicos.titulo" />
					</span>
				</h3>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<label class="inputlabelnew"><spring:theme
						code="impuestos.sobreTasaGasolina.datosBasicos.calidadResponsable" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="calidResp" name="calidResp" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value='<c:out value="${dataForm.dataForm.calidResp}"></c:out>'
						maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label class="inputlabelnew"><spring:theme
						code="impuestos.sobreTasaGasolina.datosBasicos.numTanques" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="numTanques" name="numTanques" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value='<c:out value="${dataForm.dataForm.numTanques}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<label class="inputlabelnew"><spring:theme
						code="impuestos.sobreTasaGasolina.datosBasicos.capacidadAlmacProd" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="almacProd" name="almacProd" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value='<c:out value="${dataForm.dataForm.almacProd}"></c:out>'
						maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label class="inputlabelnew"><spring:theme
						code="impuestos.sobreTasaGasolina.datosBasicos.capacAlmacTanques" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="almacTanque" name="almacTanque" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value='<c:out value="${dataForm.dataForm.almacTanque}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<label class="inputlabelnew"><spring:theme
						code="impuestos.sobreTasaGasolina.datosBasicos.ubicacionPlantaAbasto" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="ubicaPlanta" name="ubicaPlanta" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value='<c:out value="${dataForm.dataForm.ubicaPlanta}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<label class="inputlabelnew"><spring:theme
						code="impuestos.sobreTasaGasolina.datosBasicos.codigoPostal" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="codPostal" name="codPostal" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value='<c:out value="${dataForm.dataForm.codPostal}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>



		<div class="row">
			<div class="col-md-2">
				<label class="inputlabelnew"><spring:theme
						code="impuestos.sobreTasaGasolina.datosBasicos.localidad" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="localidad" name="localidad" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value='<c:out value="${dataForm.dataForm.localidad}"></c:out>'
						maxlength="240">
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row"></div>
