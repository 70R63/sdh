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
					code="declaracion.publicidad.infovalla" /></span>
		</h3>
	</div>
</div>
<br display:block;
   margin: 5px 0;>
<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.luginst" /></label>
	</div>
	<div class="col-md-3">
		<select id="luginst" class="inputdropdown"
			onchange="ShowSelected(this);">
			<option value="">Seleccionar</option>
			<option value="01">Predio</option>
			<option value="02">Veh&iacuteculo</option>
		</select>
	</div>
</div>

<br display:block;
   margin: 5px 0;>
<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.OrValla" /></label>
	</div>
	<div class="col-md-3">
		<select id="OrValla" class="inputdropdown">
			<option value=" ">Seleccionar</option>

		</select>
	</div>
</div>
<br display:block;
   margin: 5px 0;>

<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.tamvalla" /></label>
	</div>
	<div class="col-md-3">
		<select id="basegrav" class="inputdropdown">
		<option value=" ">Seleccionar</option>

		</select>
	</div>
</div>

</br>










