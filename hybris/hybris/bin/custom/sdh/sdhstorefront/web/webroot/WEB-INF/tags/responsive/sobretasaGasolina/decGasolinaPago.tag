<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<div class="headline">
			<h2>
				<span tabindex="0"><spring:theme
						code="impuestos.decGasolina.Pago.titulo" /></span>
			</h2>
		</div>
	</div>
</div>

<div class="row">
	<div class="row">
		<div class="col-md-6 col-md-offset-4">
			<div class="form-group">
				<button class="btn btn-primary btn-lg" type="button">
					<spring:theme code="impuestos.decGasolina.Pago.GenerarDec" />
				</button>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6 col-md-offset-4">
			<div class="form-group">
				<button class="btn btn-primary btn-lg" type="button">
					<spring:theme code="impuestos.decGasolina.Pago.crearNuevaDec" />
				</button>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6 col-md-offset-4">
			<div class="form-group">
				<button class="btn btn-primary btn-lg" type="button">
					<spring:theme code="impuestos.decGasolina.Pago.PresentarDec" />
				</button>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6 col-md-offset-4">
			<div class="form-group">
				<button class="btn btn-primary btn-lg" type="button">
					<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
				</button>
			</div>
		</div>
	</div>
</div>

<br>
<div class="col-md-12">
	<div class="table-responsive">
		<div class="form-group">
			<span tabindex="0"><spring:theme
					code="impuestos.decGasolina.Pago.nota" /></span>
		</div>
	</div>
</div>

<div class="row"></div>

