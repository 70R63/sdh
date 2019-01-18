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
			</div>
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
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label required" for="numDoc">
						<spring:theme code="delineacion.urbana.detail.dv" />
					</label> 
					<input id="dv" name="dv" class="form-control form-control" aria-required="true" disabled="disabled" type="text" value="" maxlength="240">
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
					<input id="nombreRazonSocial1" name="nombreRazonSocial1" class="form-control form-control" aria-required="true" disabled="disabled" type="text" value="${miRitForm.nombreRazonSocial1 }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<input id="nombreRazonSocial2" name="nombreRazonSocial2" class="form-control form-control" aria-required="true" disabled="disabled" type="text" value="${miRitForm.nombreRazonSocial2 }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<input id="nombreRazonSocial3" name="nombreRazonSocial3" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.nombreRazonSocial3 }" disabled="disabled" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<input id="nombreRazonSocial4" name="nombreRazonSocial4" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.nombreRazonSocial4 }" disabled="disabled" maxlength="240">
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
					<select class="form-control" disabled="disabled" id="formaJuridica" name="formaJuridica">
	                  <option value="${miRitForm.formaJuridica }"><spring:theme code="rit.legal.entity.${miRitForm.formaJuridica}" /></option>
	                </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="numeroMatriculaMercantil">
						<spring:theme code="mirit.pj.licenseNumber" />
					</label>
					<input id="numeroMatriculaMercantil" name="numeroMatriculaMercantil" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.numeroMatriculaMercantil}" disabled="disabled" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="fechaLiquidacion">
						<spring:theme code="mirit.pj.liqDate" />
					</label>
					<input id="fechaLiquidacion" name="fechaLiquidacion" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.fechaLiquidacion}" disabled="disabled" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="tipoRetenedor">
						<spring:theme code="mirit.pj.retainerType" />
					</label>
					<select class="form-control" disabled="disabled" id="tipoRetenedor" name="tipoRetenedor">
	                  <option value="${miRitForm.tipoRetenedor}"><spring:theme code="rit.legal.org.${miRitForm.tipoRetenedor}" /></option>
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
					<select class="form-control" disabled="disabled" >
	                  <option value="">Persona Jurídica</option>
	                </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		</form:form>
