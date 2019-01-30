<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

		<div class="row">
			<div class="headline">
				<h3>
					<span class="cintillo col-md-10 "><spring:theme code="publicidad.exterior.tubular" /></span>
				</h3>
			</div>	
		</div> 
		<br/>
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.elementtype" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="${publicForm.tipoElemento}" maxlength="240">
				</div>
			</div>	
			<div class="col-md-3">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.address" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="${publicForm.direccion}" maxlength="240">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.location" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="${publicForm.localidad}" maxlength="240">
				</div>
			</div>	
			<div class="col-md-3">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.postalcode" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="${publicForm.codPostal}" maxlength="240">
				</div>
			</div>	
		</div>		

		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.buildingpermit" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="" maxlength="240">
				</div>
					</div>
	
			<div class="col-md-3">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.licensevalidity" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="${publicForm.licenciaConstruc}" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.elementlocation" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
			<div class="col-md-3">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.typeroad" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="${publicForm.tipoPublici}" maxlength="240">
				</div>
			</div>	
		</div>
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.visualorientation" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="${publicForm.orientacion}" maxlength="240">
				</div>
			</div>			
			<div class="col-md-3">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.chip" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="${publicForm.chip}" maxlength="240">
				</div>
			</div>	
		</div>
		
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.propertyreg" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="${publicForm.matricula}" maxlength="240">
				</div>
			</div>		
			<div class="col-md-3">
				<label class="inputlabelnew vehiculos"><spring:theme code="publicidad.exterior.tubular.numberfaces" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew" aria-required="true" type="text" value="${publicForm.numCaras}" maxlength="240">
				</div>
			</div>	
		</div>
		

		
		
		
		
		
		
		
		
