<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="publicidadExterior" tagdir="/WEB-INF/tags/responsive/publicidadExterior"%>


<spring:htmlEscape defaultHtmlEscape="true" />

	<div class="row">
		<div class="headline">
			<h3>
				<span class="cintillo col-md-10 "><spring:theme code="publicidad.exterior.detail.basicdata" /></span>
			</h3>
		</div>			
	</div>

	<div class="row">				
		<div class="col-md-2 ">
			<label class="inputlabelnew"><spring:theme code="publicidad.exterior.detail.dateresolution" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="address.surname" name="fechResolu" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.fechResolu}" maxlength="240">
			</div>
		</div>
		<div class="col-md-2">
			<label class="inputlabelnew"><spring:theme code="publicidad.exterior.detail.type" /></label>
		</div>
		<div class="col-md-1">
			<div class="form-group ">
				<input id="address.surname" name="tipoSolicitud" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.tipoSolicitud}" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">				
		<div class="col-md-2 ">
			<label class="inputlabelnew"><spring:theme code="publicidad.exterior.detail.Datenotification" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="address.surname" name="fechNotif" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.fechNotif}" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
	<div class="col-md-2 ">
		<label class="inputlabelnew"><spring:theme code="publicidad.exterior.detail.validsince" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="vigenDesde" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.vigenDesde}" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label class="inputlabelnew"><spring:theme code="publicidad.exterior.detail.validityuntil" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="vigenHasta" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.vigenHasta}" maxlength="240">
		</div>
	</div>
</div>


