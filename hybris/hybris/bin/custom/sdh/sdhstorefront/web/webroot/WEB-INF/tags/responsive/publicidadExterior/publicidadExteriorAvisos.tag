<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div id="divAvisos" style="display: none;">
		<div class="row">
			<div class="headline">
				<h3>
					<span class="cintillo col-md-10 "><spring:theme code="publicidad.exterior.detail.notices" /></span>
				</h3>
			</div>	
		</div> 
		<br/>
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.typeelementreg" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="tipoElemento" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.tipoElemento}" maxlength="240">
				</div>
			</div>	
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.locationaddress" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="direccion" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.direccion}" maxlength="240">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.luminousnotices" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="avisoLumino" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.avisoLumino}" maxlength="240">
				</div>
			</div>	
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.location" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="localidad" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.localidad}" maxlength="240">
				</div>
			</div>	
		</div>		

		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.elementlocation" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="areaElemento" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.areaElemento}" maxlength="240">
				</div>
			</div>			
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.postalcode" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="ubicacion" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.ubicacion}" maxlength="240">
				</div>
			</div>
		</div>			
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.chip" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="chip" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.chip}" maxlength="240">
				</div>
			</div>			
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.elementarea" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="areaElemento" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.areaElemento}" maxlength="240">
				</div>
			</div>	
		</div>
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.propertyreg" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.facadearea" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="areaFachada" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.areaFachada}" maxlength="240">
				</div>
			</div>	
		</div>
		
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme code="publicidad.exterior.detail.numberfactions" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="numFracciones" class="inputtextnew" aria-required="true" type="text" value="${publicidadForm.numFracciones}" maxlength="240">
				</div>
			</div>			
		</div>
		</div>