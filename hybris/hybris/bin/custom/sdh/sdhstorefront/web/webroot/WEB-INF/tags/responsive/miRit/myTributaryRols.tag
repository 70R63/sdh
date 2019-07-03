<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div id="acordeon" class="container">
	<div class="card cardmirit ">
		<div class="card-header" id="head8">
			<h5 class="mb-0 cardtitle">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse8" aria-expanded="true"
					aria-controls="collapse8">
					<h4>
						<span tabindex="0"><spring:theme
								code="mirit.tributaryRols.title" text="Mis Roles Tributarios" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse8" class="collapse" aria-ladelledby="head8"
			data-parent="#acordeon">
			<div class="card-body">
				<c:if test="${miRitForm.hasCORol }">
					<div class="row">
						<div class="col-md-3  text-center">
							<div class="form-group ">
								<input id="address.surname" disabled name="lastName"
									class="newalto form-control text-center" aria-required="true"
									type="text" value="Contribuyente" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${miRitForm.hasAARol }">
					<div class="row">
						<div class="col-md-3  text-center">
							<div class="form-group ">
								<input id="address.surname" disabled name="lastName"
									class="newalto form-control text-center" aria-required="true"
									type="text" value="Agente Autorizado" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${miRitForm.hasTARol }">
					<div class="row">
						<div class="col-md-3 text-center">
							<div class="form-group ">
								<input id="address.surname" disabled name="lastName"
									class="newalto form-control text-center" aria-required="true"
									type="text" value="Tercero Autorizado" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${miRitForm.hasARRol }">
					<div class="row">
						<div class="col-md-3 text-center">
							<div class="form-group ">
								<input id="address.surname" disabled name="lastName"
									class="newalto form-control text-center" aria-required="true"
									type="text" value="Agente Retenedor" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${miRitForm.hasRIRol }">
					<div class="row">
						<div class="col-md-3 text-center">
							<div class="form-group ">
								<input id="address.surname" disabled name="lastName"
									class="newalto form-control text-center" aria-required="true"
									type="text" value="Reportantes de Información" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un
										tipo de documento</span>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>

