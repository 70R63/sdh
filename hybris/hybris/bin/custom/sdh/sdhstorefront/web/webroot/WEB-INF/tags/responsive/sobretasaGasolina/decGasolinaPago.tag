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
					code="impuestos.decGasolina.Pago.titulo" /></span>
		</h3>
	</div>
</div>

<div class="col-md-12">
	<div class="table-responsive">
		<table class="table">
			<tbody>
				<tr>
					<td></td>
					<td><div class="form-group ">
							<button class="btn btn-primary btn-block" type="button">
								<spring:theme code="impuestos.decGasolina.Pago.GenerarDec" />
							</button>
						</div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><div class="form-group ">
							<button class="btn btn-primary btn-block" type="button">
								<spring:theme code="impuestos.decGasolina.Pago.crearNuevaDec" />
							</button>
						</div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><div class="form-group ">
							<button class="btn btn-primary btn-block" type="button">
								<spring:theme code="impuestos.decGasolina.Pago.PresentarDec" />
							</button>
						</div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><div class="form-group ">
							<button class="btn btn-primary btn-block" type="button">
								<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
							</button>
						</div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><span tabindex="0"><spring:theme
								code="impuestos.decGasolina.Pago.nota" /></span></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="row"></div>

