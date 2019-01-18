<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span tabindex="0"><spring:theme
					code="declaracion.publicidad.totpagar" /></span>
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="declaracion.publicidad.impcargo" /></label>
	</div>
	<div class="col-md-3">
		<input id="impCar" name="impCar" class="form-control form-control"
			aria-required="true" type="number" value="0" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="declaracion.publicidad.valsan" /></label>
	</div>
	<div class="col-md-3">
		<input id="valsan" name="valsan" class="form-control form-control"
			aria-required="true" type="number" value="0" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>
<div class="row">
	<div class="col-md-2">
		<label><spring:theme code="declaracion.publicidad.valpaga" /></label>
	</div>
	<div class="col-md-3">
		<input id="valpag" name="valpag" class="form-control form-control"
			aria-required="true" type="number" value="0" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>
<div class="row">
	<div class="col-md-2">
		<label><spring:theme code="declaracion.publicidad.intermora" /></label>
	</div>
	<div class="col-md-3">
		<input id="intmora" name="intmora" class="form-control form-control"
			aria-required="true" type="number" value="0" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>
<div class="row">
	<div class="col-md-2">
		<label><spring:theme code="declaracion.publicidad.totalapagar" /></label>
	</div>
	<div class="col-md-3">
		<input id="totpag" name="totpag" class="form-control form-control"
			aria-required="true" type="number" value="0" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>
<div class="row">
	<div class="col-md-2">
<<<<<<< HEAD
		<button class="btn btn-primary btn-lg" type="button">
=======
		<button type="button" class="btn btn-default btn-block backToHome">
>>>>>>> dev
			<spring:theme code="declaracion.publicidad.button.calcular"  />
		</button>
	</div>
</div>