<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div id="acordeon" class="container">
	<div class="card cardmirit ">
		<div class="card-header" id="head0">
			<h5 class="mb-0 cardtitle">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse0" aria-expanded="true"
					aria-controls="collapse0">
					<h4>
						<span tabindex="0"><spring:theme
								code="mirit.personalData.title" text="Mis datos personales" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse0" class="collapse" aria-ladelledby="head0"
			data-parent="#acordeon">
			<div class="card-body">
				<div class="row">
					<c:url value="/contribuyentes/mirit/updatePersonalData"
						var="formAction" />
					<form:form method="post" commandName="miRitForm"
						action="${formAction}">
						<!--  First column of form -->
						<div class="col-md-3">
							<div class="form-group ">
								<label class="control-label required" for="tipoDoc"> <spring:theme
										code="mirit.personalData.documentType"
										text="Mis datos personales" />
								</label> <select id="documentType" class="newalto form-control "
									disabled="disabled">
									<option value="${miRitForm.tipoDoc }"><spring:theme
											code="register.id.types.${miRitForm.tipoDoc}" /></option>
								</select>

								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
							<div class="form-group ">
								<label class="control-label required" for="primNom"> <spring:theme
										code="mirit.personalData.firstName" />
								</label> <input id="primNom" name="primNom"
									class="newalto form-control" aria-required="true"
									type="text" data-original="${miRitForm.primNom }"
									value="${miRitForm.primNom }" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
							<div class="form-group ">
								<label class="control-label  required" for="primApe"> <spring:theme
										code="mirit.personalData.firstLastName" />
								</label> <input id="primApe" name="primApe"
									class="newalto form-control" aria-required="true"
									type="text" data-original="${miRitForm.primApe }"
									value="${miRitForm.primApe }" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
							<div class="form-group ">
								<label class="control-label required" for="fchExp"> <spring:theme
										code="mirit.personalData.documnetIssueDate" />
								</label> <input id="fchExp" name="fchExp"
									class="newalto form-control" aria-required="true"
									type="text" value="${miRitForm.fchExp }" maxlength="240" placeholder="dd/mm/aaaa">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>

						</div>

						<!--  Second column of form -->
						<div class="col-md-3">
							<div class="form-group ">
								<label class="control-label required" for="numDoc"> <spring:theme
										code="mirit.personalData.documentNumber" />
								</label> <input id="numDoc" name="numDoc"
									class="newalto form-control" aria-required="true"
									disabled="disabled" type="text" value="${miRitForm.numDoc }"
									maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
							<div class="form-group ">
								<label class="control-label required" for="segNom"> <spring:theme
										code="mirit.personalData.secondFirstName" />
								</label> <input id="segNom" name="segNom"
									class="newalto form-control" aria-required="true"
									type="text" data-original="${miRitForm.segNom }"
									value="${miRitForm.segNom }" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
							<div class="form-group ">
								<label class="control-label required" for="segApe"> <spring:theme
										code="mirit.personalData.secondLasName" />
								</label> <input id="segApe" name="segApe"
									class="newalto form-control" aria-required="true"
									type="text" data-original="${miRitForm.segApe }"
									value="${miRitForm.segApe }" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
							<div class="form-group ">
								<label class="control-label " for="address.surname"> </label>
								<button
									class="btn btn-primary  btn-block change_address_button show_processing_message"
									type="button" id="certifNombButton">
									<spring:theme code="mirit.personalData.certifName" />
								</button>
								<button
									class="btn btn-primary   btn-block change_address_button show_processing_message"
									type="button" id="updateNombreButton">
									<spring:theme code="mirit.personalData.updateName" />
								</button>

							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
