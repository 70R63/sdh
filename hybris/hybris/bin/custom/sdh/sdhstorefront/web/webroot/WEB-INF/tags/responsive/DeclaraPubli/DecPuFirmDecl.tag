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
					code="declaracion.publicidad.FirmaDeclarante" /></span>
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.tipoiden" /></label>
	</div>

	<div class="col-md-4">
		<label class="inputlabelnew"><spring:theme code="declaracion.publicidad.numidenti" /></label>
	</div>

	<div class="col-md-4">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.nombreyrazon" /></label>
	</div>
</div>

<br display: block;
   margin: 5px 0;>
<div class="row">

	<div class="col-md-4">
		<select id="tipiden" class="inputdropdown2" disabled="disabled">
			<option value="CC"><spring:theme code="register.id.types.${declaPublicidadForm.idType}" /></option>
		</select>
	</div>
	
	<div class="col-md-4">
		<input id="numide" name="numide" class="inputtextnew"
			aria-required="true" type="text" value="${declaPublicidadForm.idNumber}" maxlength="30" size="30"
			disabled="disabled">
	</div>
	<div class="col-md-4">
		<input id="name" name="name" class="inputtextnew"
			aria-required="true" type="text" value="" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>