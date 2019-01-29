<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

			<div class="headline">
				<h2>
					<span tabindex="0"><spring:theme code="mirit.changePassword.title" text="Cambiar Contraseņa"/></span>
				</h2>
			</div>
			
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<label class="control-label required" for="currentPassword">
						<spring:theme code="mirit.changePassword.password" />
					</label> 
					<input  id="currentPassword"   name="currentPassword" class="form-control " aria-required="true" type="password" value="" maxlength="240">
					<div class="help-block">
						<span id="currentPasswordErrors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.changePassword.newPassword" />
					</label>
					<input  id="newPassword"   name="newPassword" class="form-control password-strength" aria-required="true" type="password" value="" maxlength="240">
					<div class="help-block">
						<span id="sameOldPasswordError" class="hidden"><spring:theme code="updatePwd.token.sameOldPassword"></spring:theme></span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.changePassword.confirmPassword" />
					</label>
					<input  id="confirmNewPassword"   name="confirmNewPassword" class="form-control " aria-required="true" type="password" value="" maxlength="240">
					<div class="help-block">
						<span id="confirmNewPasswordErrors" class="hidden"><spring:theme code="validation.checkPwd.equals" /></span>
					</div>
				</div>
			</div>
		</div>
		<div class="description"><spring:theme code="mirit.changePassword.passwordRequirements" htmlEscape="false"/></div>
		
