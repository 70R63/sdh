<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

	<div class="row">
		<div class="headline">
			<h2>
				<span tabindex="0"><spring:theme code="mirit.personalData.title" text="Mis datos personales"/></span>
			</h2>
		</div>
		<c:url value="/contribuyentes/mirit/updatePersonalData" var="formAction"/>
		<form:form method="post" commandName="miRitForm" action="${formAction}">
			<!--  First column of form -->
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.personalData.documentType" text="Mis datos personales"/>
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
					
					<select  class="form-control" disabled="disabled">
						<option value="Cédula de Ciudadanía">Cédula de Ciudadanía</option>
		                <option value="Carnet Diplomático">Carnet Diplomático</option>
		                <option value="Cédula de Extranjería">Cédula de Extranjería</option>
		                <option value="Número de Identificación Tributaria">Número de Identificación Tributaria</option>
		                <option value="NIT Compuesto (Utilización Múltiple)">NIT Compuesto (Utilización Múltiple)</option>
		                <option value="NIT Extranjero">NIT Extranjero</option>
		                <option value="Número Único de Identificación Personal">Número Único de Identificación Personal</option>
		                <option value="Pasaporte">Pasaporte</option>
		                <option value="Registro Civil">Registro Civil</option>
		                <option value="Persona Indeterminada">Persona Indeterminada</option>
		                <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
		                <option value="Tarjeta de Identidad de Extranjero">Tarjeta de Identidad de Extranjero</option>
		                <option value="Tarjeta Profesional Abogacía">Tarjeta Profesional Abogacía</option>
		                <option value="Tarjeta Profesional Contador Público">Tarjeta Profesional Contador Público</option>
					</select>
					
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="primNom">
						<spring:theme code="mirit.personalData.firstName" />
					</label> 
					<input id="address.surname" name="primNom" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.primNom }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="primApe">
						<spring:theme code="mirit.personalData.firstLastName" />
					</label> 
					<input id="address.surname" name="primApe" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.primApe }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="fchExp">
						<spring:theme code="mirit.personalData.documnetIssueDate" />
					</label> 
					<input id="address.surname" name="fchExp" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.fchExp }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
			</div>
			
			
			<!--  Second column of form -->
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="numDoc">
						<spring:theme code="mirit.personalData.documentNumber" />
					</label> 
					<input id="address.surname" name="numDoc" class="form-control form-control" aria-required="true" disabled="disabled" type="text" value="${miRitForm.numDoc }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="segNom">
						<spring:theme code="mirit.personalData.secondFirstName" />
					</label> 
					<input id="address.surname" name="segNom" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.segNom }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="segApe">
						<spring:theme code="mirit.personalData.secondLasName" />
					</label> 
					<input id="address.surname" name="segApe" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.segApe }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
							<label class="control-label " for="address.surname">
					</label> 
								<button class="btn btn-primary btn-block change_address_button show_processing_message" type="submit">
									<spring:theme code="mirit.personalData.updateName" />
								</button>
							
				</div>
			</div>
		</form:form>
	</div>
