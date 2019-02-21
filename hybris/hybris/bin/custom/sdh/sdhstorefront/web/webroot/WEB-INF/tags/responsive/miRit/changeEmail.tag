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
					<label class="control-label required" for="currentMail">
						<spring:theme code="mirit.changeEmail.email" />
					</label> 
					<input  id="currentMail"   name="currentMail" class="form-control " aria-required="true" type="text" value="${miRitForm.email }" maxlength="240">
					<div class="help-block">
						<span id="currentMailErrors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<label class="control-label required" for="newEmail">
						<spring:theme code="mirit.changeEmail.newEmail" />
					</label>
					<input  id="newEmail"   name="newEmail" class="form-control " aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="newEmailErrors" class="hidden"><spring:theme code="login.not.a.validEmail.exception" /></span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<label class="control-label required" for="confirmNewEmail">
						<spring:theme code="mirit.changeEmail.confirmNewEmail" />
					</label>
					<input  id="confirmNewEmail"   name="confirmNewEmail" class="form-control " aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="confirmNewEmailErrors" class="hidden"><spring:theme code="validation.confirmEmail.equals" /></span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<button class="btn btn-secondary btn-lg " type="button" id="updateEmailButton">
							<spring:theme code="mirit.contactData.updateEmail" />
					</button>
				</div>
			</div>
		</div>
		
