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
			<span tabindex="0" class="col-md-12 cintillo"><spring:theme
					code="impuestos.decGasolina.Pago.titulo" /></span>
		</h3>
	</div>
</div>

<div class="col-md-12">
	<div class="table-responsive">

		<div class="col-md-6 col-md-offset-4">
			<button class="boton" type="button">
				<spring:theme code="impuestos.decGasolina.Pago.GenerarDec" />
			</button>
		</div>
		<div class="col-md-6 col-md-offset-4">
			<button class="boton" type="button">
				<spring:theme code="impuestos.decGasolina.Pago.crearNuevaDec" />
			</button>
		</div>
		<div class="col-md-6 col-md-offset-4">
			<button class="boton" type="button">
				<spring:theme code="impuestos.decGasolina.Pago.PresentarDec" />
			</button>
		</div>
		<div class="col-md-6 col-md-offset-4">
			<button class="boton" type="button">
				<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
			</button>
		</div>
	</div>
</div>

<br>
<div class="col-md-12">
	<div class="table-responsive">
		<span tabindex="0"><spring:theme
				code="impuestos.decGasolina.Pago.nota" /></span>
	</div>
</div>

<div class="row"></div>

