<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span class="cintillo col-md-10"><spring:theme
					code="delineacion.urbana.dec.generales.title" /></span>
		</h3>
	</div>
</div>

<form:form>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.generales.anigrav" /></label>
		</div>
		<div class="col-md-2">
			<select id="anio" class="inputdropdown" name=" " onchange=" " disabled>
				<option value="2019">2019</option>
				<option value="2018">2018</option>
				<option value="2017">2017</option>
				<option value="2016">2016</option>
			</select>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.generales.periodo" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.generales.cdu" /></label>
		</div>
		<div class="col-md-2">
			<input id="" name="" class="inputtextnew" aria-required="true"
				type="text" readonly="readonly" value="" maxlength="240">
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.generales.opuso" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<select id="anio" class="inputdropdown" name=" " onchange=" ">
					<option value="01">Retención</option>
					<option value="02">Declaración</option>
					<option value="03">Corrección</option>
				</select>
			</div>
		</div>
	</div>
</form:form>

