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
				<span tabindex="0"><spring:theme code="mirit.pj.personalData.title" text="Mis datos personales"/></span>
			</h2>
		</div>
	</div>
	<c:url value="/contribuyentes/mirit/updatePersonalData" var="formAction"/>
	<form:form method="post" commandName="miRitForm" action="${formAction}">
		<div class="row">
			<div class="col-md-6">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.personalData.documentType" text="Mis datos personales"/>
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
					
					<select  class="form-control" disabled="disabled">
						<option value="${miRitForm.tipoDoc }"><spring:theme code="register.id.types.${miRitForm.tipoDoc}" /></option>
					</select>
					
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
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
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label required" for="numDoc">
						<spring:theme code="delineacion.urbana.detail.dv" />
					</label> 
					<input id="address.surname" name="numDoc" class="form-control form-control" aria-required="true" disabled="disabled" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<label class="control-label required" for="nameOrganization">
						<spring:theme code="mirit.pj.name" />
					</label> 
					<input id="name" name="name" class="form-control form-control" aria-required="true" disabled="disabled" type="text" value="${miRitForm.primNom }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<input id="address.surname" name="primApe" class="form-control form-control" aria-required="true" disabled="disabled" type="text" value="${miRitForm.primApe }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<input id="address.surname" name="primApe" class="form-control form-control" aria-required="true" type="text" value="" disabled="disabled" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<input id="address.surname" name="primApe" class="form-control form-control" aria-required="true" type="text" value="" disabled="disabled" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="numDoc">
						<spring:theme code="mirit.pj.formajuridica" />
					</label>
					<select class="form-control">
	                  <option value="FACEBOOK">S. Colectiva</option>
	                </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="numDoc">
						<spring:theme code="mirit.pj.licenseNumber" />
					</label>
					<input id="address.surname" name="primApe" class="form-control form-control" aria-required="true" type="text" value="" disabled="disabled" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="numDoc">
						<spring:theme code="mirit.pj.liqDate" />
					</label>
					<input id="address.surname" name="primApe" class="form-control form-control" aria-required="true" type="text" value="" disabled="disabled" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="numDoc">
						<spring:theme code="mirit.pj.retainerType" />
					</label>
					<select class="form-control">
	                  <option value="FACEBOOK">Emp. públicas</option>
	                </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="numDoc">
						<spring:theme code="mirit.pj.claseIC" />
					</label>
					<select class="form-control">
	                  <option value="FACEBOOK">Persona Jurídica</option>
	                </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		</form:form>
