<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<div class="row">
		<div class="col-md-6">
			<h3>
				<span><spring:theme code="declaracion.publicidad.totpagar" /></span>
			</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="declaracion.publicidad.impcargo" /></label> <input id="impCar"
					name="impCar" class="newalto form-control" aria-required="true"
					type="" value="${declaPublicidadForm.impCar}" maxlength="30"
					size="30" disabled="disabled">
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="declaracion.publicidad.valsan" /></label> <input id="valsan"
					name="valsan" class="newalto form-control" aria-required="true"
					type="" value="${declaPublicidadForm.valsan}" maxlength="30"
					size="30" disabled="disabled">
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="declaracion.publicidad.valpaga" /></label> <input id="valpag"
					name="valpag" class="newalto form-control" aria-required="true"
					type="" value="${declaPublicidadForm.valsan}" maxlength="30"
					size="30" disabled="disabled">
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="declaracion.publicidad.intermora" /></label> <input id="intmora"
					name="intmora" class="newalto form-control" aria-required="true"
					type="" value="${declaPublicidadForm.intmora}" maxlength="30"
					size="30" disabled="disabled">
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="declaracion.publicidad.totalapagar" /></label> <input id="totpag"
					name="totpag" class="newalto form-control" aria-required="true"
					type="" value="${declaPublicidadForm.totpag}" maxlength="30"
					size="30" disabled="disabled">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2 col-md-offset-8">

			<button id="calculoButton" name="calculoButton" type="button"
				class="btn btn-primary">
				<spring:theme code="declaracion.publicidad.button.calcular" />
			</button>
		</div>
	</div>
</div>
