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
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.generalData.treatment"/>
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
					<select id="u5187_input" class="form-control" disabled="">
		                <option value="Señor">Señor</option>
		                <option value="Señora">Señora</option>
		                <option value="Señores">Señores</option>
		                <option value="Señor/a">Señor/a</option>
		              </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.generalData.gender" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.generalData.birthDate" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.generalData.originCountry" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
			</div>
			
			
			<!--  Second column of form -->
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.generalData.classIC" />
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
					<select class="form-control" disabled="disabled">
						 <option value="Persona Natural">Persona Natural</option>
                <option value="Persona Jurídica">Persona Jurídica</option>
					</select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.generalData.nationality" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.generalData.birthPlace" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
			</div>
		</div>
