<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

			<div class="headline">
				<h2>
					<span tabindex="0"><spring:theme code="mirit.changeEmail.title" text="Cambiar Correo"/></span>
				</h2>
			</div>
			
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.changeEmail.email" />
					</label> 
					<input  id="address.surname"   name="lastName" class="form-control " aria-required="true" type="text" value="${miRitForm.email }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.changeEmail.newEmail" />
					</label>
					<input  id="address.surname"   name="lastName" class="form-control " aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.changeEmail.confirmNewEmail" />
					</label>
					<input  id="address.surname"   name="lastName" class="form-control " aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		
