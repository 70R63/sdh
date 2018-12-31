<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

			<div class="headline">
				<h2>
					<span tabindex="0"><spring:theme code="mirit.changePassword.title" text="Cambiar Contraseña"/></span>
				</h2>
			</div>
			
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.changePassword.password" />
					</label> 
					<input  id="address.surname"   name="lastName" class="form-control " aria-required="true" type="password" value="" maxlength="240">
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
						<spring:theme code="mirit.changePassword.newPassword" />
					</label>
					<input  id="password"   name="password" class="form-control password-strength" aria-required="true" type="password" value="" maxlength="240">
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
						<spring:theme code="mirit.changePassword.confirmPassword" />
					</label>
					<input  id="address.surname"   name="lastName" class="form-control " aria-required="true" type="password" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="description"><spring:theme code="mirit.changePassword.passwordRequirements" htmlEscape="false"/></div>
		
