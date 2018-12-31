<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

			<div class="headline">
				<h2>
					<span tabindex="0"><spring:theme code="mirit.tributaryRols.title" text="Mis Roles Tributarios"/></span>
				</h2>
			</div>
			
		<div class="row">
			<div class="col-md-4 col-md-offset-2 text-center">
				<div class="form-group ">
					<input  id="address.surname" disabled  name="lastName" class="form-control text-center" aria-required="true" type="text" value="Contribuyente" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-2 text-center">
				<div class="form-group ">
					<input  id="address.surname" disabled  name="lastName" class="form-control text-center" aria-required="true" type="text" value="Agente Autorizado" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-2 text-center">
				<div class="form-group ">
					<input  id="address.surname" disabled  name="lastName" class="form-control text-center" aria-required="true" type="text" value="Tercero Autorizado" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-2 text-center">
				<div class="form-group ">
					<input  id="address.surname" disabled  name="lastName" class="form-control text-center" aria-required="true" type="text" value="Agente Retenedor" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-2 text-center">
				<div class="form-group ">
					<input  id="address.surname" disabled  name="lastName" class="form-control text-center" aria-required="true" type="text" value="Reportantes de Información" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
