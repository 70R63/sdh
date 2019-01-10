<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
			<div class="headline">
				<h2>
					<span tabindex="0"><spring:theme code="mirit.generalData.title" text="Mis datos generales"/></span>
				</h2>
			</div>
			
			<!--  First column of form -->
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="tratamiento">
						<spring:theme code="mirit.generalData.treatment"/>
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
					<select id="tratamiento" name="tratamiento" class="form-control" disabled="">
		                <option value="${miRitForm.tratamiento}" ><spring:theme code="rit.tratamiento.t${miRitForm.tratamiento}" /></option>
		              </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="sexo">
						<spring:theme code="mirit.generalData.gender" />
					</label> 
					<input id="sexo" name="sexo" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="<spring:theme code="rit.sexo.s${miRitForm.tratamiento}" />" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="birthDate">
						<spring:theme code="mirit.generalData.birthDate" />
					</label> 
					<input id="birthDate" name="birthDate" class="form-control" disabled="disabled" aria-required="true" type="text" value="${miRitForm.fechaNacimiento}" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="paisOrigen">
						<spring:theme code="mirit.generalData.originCountry" />
					</label> 
					<input id="paisOrigen" name="paisOrigen" class="form-control " disabled="disabled" aria-required="true" type="text" value="<spring:theme code="rit.pais.p${miRitForm.paisOrigen}" />" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
			</div>
			
			
			<!--  Second column of form -->
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="claseIC">
						<spring:theme code="mirit.generalData.classIC" />
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
					<select id="claseIC" name="claseIC" class="form-control" disabled="disabled">
						 <option value="${miRitForm.claseIC}"><spring:theme code="rit.claseIC.c${miRitForm.claseIC}" /></option>
					</select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="nacionalidad">
						<spring:theme code="mirit.generalData.nationality" />
					</label> 
					<input id="nacionalidad" name="nacionalidad" disabled="disabled" class="form-control  " aria-required="true" type="text" value="<spring:theme code="rit.pais.p${miRitForm.nacionalidad}" />" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="lugarNacimiento">
						<spring:theme code="mirit.generalData.birthPlace" />
					</label> 
					<input id="lugarNacimiento" name="lugarNacimiento" class="form-control  " disabled="disabled" aria-required="true" type="text" value="${miRitForm.lugarNacimiento}" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
			</div>
		</div>
