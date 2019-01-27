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

			<option value="2019">2019</option>
			<option value="2018">2018</option>
			<option value="2017">2017</option>
			<option value="2016">2016</option>
			<option value="2015">2015</option>
			<option value="2014">2014</option>
			<option value="2013">2013</option>
			<option value="2012">2012</option>
			<option value="2011">2011</option>
			<option value="2010">2010</option>
		</select>
	</div>

	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme code="declaracion.publicidad.opuso" /></label>
	</div>
	<div class="col-md-2">
		<select id="opuso" class="inputdropdown">
			<option value="1">Declaraci&oacuten</option>
			<option value="2">Correcci&oacuten</option>
			<option value="3">S&oacutelo Pago</option>
			<option value="4">Acto Oficial</option>
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
			aria-required="true" type="text" value="" maxlength="30"
			disabled="disabled">
	</div>


	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme code="declaracion.publicidad.fenoti" /></label>
	</div>
	<div class="col-md-2">
		<input id="fecresol" name="fecresol" class="inputtextnew"
			aria-required="true" type="" value="${declaPublicidadForm.fechnotif}" maxlength="30"
			disabled="disabled">
	</div>
</div>