<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div id="acordeon" class="container_new">
	<div class="card cardmirit ">
		<div class="card-header" id="head3">
			<h5 class="mb-0 cardtitle">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse3" aria-expanded="true"
					aria-controls="collapse3">
					<h4>
							<span tabindex="0"><spring:theme
								code="mirit.changeEmail.title" text="Cambiar Correo" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse3" class="collapse" aria-ladelledby="head3"
			data-parent="#acordeon">
			<div class="card-body">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group ">
							<label class="control-label required" for="currentMail">
								<spring:theme code="mirit.changeEmail.email" />
							</label> <input id="currentMail" name="currentMail" class="newalto form-control "
								aria-required="true" type="text" value="${miRitForm.email }"
								maxlength="240">
							<div class="help-block">
								<span id="currentMailErrors" class="hidden">Seleccione un
									tipo de documento</span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3  ">
						<div class="form-group ">
							<label class="control-label required" for="newEmail"> <spring:theme
									code="mirit.changeEmail.newEmail" />
							</label> <input id="newEmail" name="newEmail" class="newalto form-control "
								aria-required="true" type="text" value="" maxlength="240">
							<div class="help-block">
								<span id="newEmailErrors" class="hidden"><spring:theme
										code="login.not.a.validEmail.exception" /></span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3  ">
						<div class="form-group ">
							<label class="control-label required" for="confirmNewEmail">
								<spring:theme code="mirit.changeEmail.confirmNewEmail" />
							</label> <input id="confirmNewEmail" name="confirmNewEmail"
								class="newalto form-control " aria-required="true" type="text" value=""
								maxlength="240">
							<div class="help-block">
								<span id="confirmNewEmailErrors" class="hidden"><spring:theme
										code="validation.confirmEmail.equals" /></span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class=" col-12 col-md-3  ">
						<div class="form-group ">
							<button class="btn btn-secondary btn-block btn-lg " type="button"
								id="updateEmailButton">
								<spring:theme code="mirit.contactData.updateEmail" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

