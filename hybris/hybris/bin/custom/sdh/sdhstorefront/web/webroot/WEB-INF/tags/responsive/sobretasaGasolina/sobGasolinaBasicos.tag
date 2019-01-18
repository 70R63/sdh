<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span tabindex="0"> <spring:theme
					code="impuestos.sobreTasaGasolina.datosBasicos.titulo" />
			</span>
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.sobreTasaGasolina.datosBasicos.calidadResponsable" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="calidadResponsable" class="form-control">
				<c:forEach items="${dataFormCatalogos.calidadResponsable}"
					var="elemento">
					<option value="${elemento.key}"><c:out
							value="${elemento.label}" /></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.sobreTasaGasolina.datosBasicos.numTanques" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="numTanques" name="numTanques"
				class="form-control form-control" aria-required="true" type="text"
				value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.sobreTasaGasolina.datosBasicos.capacidadAlmacProd" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="capacidadAlmacProd" name="capacidadAlmacProd"
				class="form-control form-control" aria-required="true" type="text"
				value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.sobreTasaGasolina.datosBasicos.capacAlmacTanques" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="capacAlmacTanques" name="capacAlmacTanques"
				class="form-control form-control" aria-required="true" type="text"
				value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.sobreTasaGasolina.datosBasicos.ubicacionPlantaAbasto" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="ubicacionPlantaAbasto" name="ubicacionPlantaAbasto"
				class="form-control form-control" aria-required="true" type="text"
				value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.sobreTasaGasolina.datosBasicos.codigoPostal" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="codigoPostal" class="form-control">
				<c:forEach items="${dataFormCatalogos.codigoPostal}" var="elemento">
					<option value="${elemento.key}"><c:out
							value="${elemento.label}" /></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.sobreTasaGasolina.datosBasicos.localidad" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="localidad" class="form-control">
				<c:forEach items="${dataFormCatalogos.localidad}" var="elemento">
					<option value="${elemento.key}"><c:out
							value="${elemento.label}" /></option>
				</c:forEach>
			</select>
		</div>
	</div>
</div>