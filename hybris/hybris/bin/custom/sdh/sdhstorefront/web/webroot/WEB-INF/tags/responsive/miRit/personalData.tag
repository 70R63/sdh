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
					<label class="control-label required" for="tipoDoc">
						<spring:theme code="mirit.personalData.documentType" text="Mis datos personales"/>
					</label> 
					
					<select  class="form-control" disabled="disabled">
						<option value="${miRitForm.tipoDoc }"><spring:theme code="register.id.types.${miRitForm.tipoDoc}" /></option>
					</select>
					
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="primNom">
						<spring:theme code="mirit.personalData.firstName" />
					</label> 
					<input id="primNom" name="primNom" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.primNom }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="primApe">
						<spring:theme code="mirit.personalData.firstLastName" />
					</label> 
					<input id="primApe" name="primApe" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.primApe }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="fchExp">
						<spring:theme code="mirit.personalData.documnetIssueDate" />
					</label> 
					<input id="fchExp" name="fchExp" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.fchExp }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
			</div>
			
<div id="dialog" title="Certificación de Nombre" ><div id="textCertNom"></div></div>
			
			
			<!--  Second column of form -->
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="numDoc">
						<spring:theme code="mirit.personalData.documentNumber" />
					</label> 
					<input id="numDoc" name="numDoc" class="form-control form-control" aria-required="true" disabled="disabled" type="text" value="${miRitForm.numDoc }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="segNom">
						<spring:theme code="mirit.personalData.secondFirstName" />
					</label> 
					<input id="segNom" name="segNom" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.segNom }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="segApe">
						<spring:theme code="mirit.personalData.secondLasName" />
					</label> 
					<input id="segApe" name="segApe" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.segApe }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
							<label class="control-label " for="address.surname">
					</label> 
								<button class="btn btn-primary btn-block change_address_button show_processing_message" type="button" id="certifNombButton">
									<spring:theme code="mirit.personalData.updateName" />
								</button>
							
				</div>
			</div>
		</form:form>
	</div>
