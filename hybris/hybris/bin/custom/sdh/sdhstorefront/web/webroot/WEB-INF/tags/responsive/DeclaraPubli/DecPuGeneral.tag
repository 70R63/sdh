<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span class="cintillo col-md-10"><spring:theme
					code="declaracion.publicidad.titulo" /></span>
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-6">
		<h3>
			<span class="cintillo col-md-10"><spring:theme
					code="declaracion.publicidad.datgene" /></span>
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme code="declaracion.publicidad.anogravable" /></label>
	</div>
	<div class="col-md-2">

		<select id="anograv" class="inputlabelnew" disabled="disabled">
<<<<<<< Updated upstream
			<option value="${declaPublicidadForm.anograv}">${declaPublicidadForm.anograv}</option>
=======
			<option value=" ">${declaPublicidadForm.anograv}</option>
>>>>>>> Stashed changes
		</select>
	</div>

	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme code="declaracion.publicidad.opuso" /></label>
	</div>
	<div class="col-md-2">
		<select id="opuso" class="inputdropdown">
		<option value="">${declaraPublidadForm.infodeclara.opcionUso}
			<option value="01">Declaraci&oacuten</option>
			<option value="02">Correcci&oacuten</option>
		</select>
	</div>
</div>
<br display: block;
   margin: 5px 0;>
<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme code="declaracion.publicidad.numresol" /></label>
	</div>
	<div class="col-md-2">
		<input id="numresol" name="numresol" class="inputtextnew"
			aria-required="true" type="text" value="${declaPublicidadForm.numresol}" maxlength="30"
			disabled="disabled">
	</div>


	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme code="declaracion.publicidad.fenoti" /></label>
	</div>
	<div class="col-md-2">
		<input id="fechnotif" name="fechnotif" class="inputtextnew"
			aria-required="true" type="" value="${declaPublicidadForm.fechnotif}" maxlength="30"
			disabled="disabled">
	</div>
</div>