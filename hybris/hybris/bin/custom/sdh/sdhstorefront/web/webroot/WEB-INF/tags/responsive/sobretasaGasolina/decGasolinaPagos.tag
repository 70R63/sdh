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
					code="impuestos.decGasolina.Pagos.titulo" /></span>
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.decGasolina.Pagos.valorSobretasa" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="valorSobretasa" name="valorSobretasa"
				class="form-control form-control" aria-required="true" type="text"
				value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.decGasolina.Pagos.valorSansiones" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="valorSansiones" name="valorSansiones"
				class="form-control form-control" aria-required="true" type="text"
				value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.decGasolina.Pagos.valorIntereses" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="valorIntereses" name="valorIntereses"
				class="form-control form-control" aria-required="true" type="text"
				value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.decGasolina.Pagos.menosCompensaciones" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="menosCompensaciones" name="menosCompensaciones"
				class="form-control form-control" aria-required="true" type="text"
				value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme
				code="impuestos.decGasolina.Pagos.valorTotalPagar" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="valorTotalPagar" name="valorTotalPagar"
				class="form-control form-control" aria-required="true" type="text"
				value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row"></div> 