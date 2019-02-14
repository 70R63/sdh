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
						code="impuestos.decGasolina.Totales.titulo" /></span>
			</h2>
		</div>
	</div>
</div>

<div class="row">
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="impuestos.decGasolina.Totales.totalSobretasa" /></label> <input
					id="totalSobretasa" name="totalSobretasa" class="form-control"
					aria-required="true" type="text" readonly="readonly"
					value="${dataForm.dataForm.valoresDeclara.totalSobretasa}" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="impuestos.decGasolina.Totales.valorSanciones" /></label> <input
					id="valorSansiones" name="valorSansiones" class="form-control"
					aria-required="true" type="text" readonly="readonly"
					value="${dataForm.dataForm.valoresDeclara.vlrSancTotales}" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="impuestos.decGasolina.Totales.totalCargo" /></label> <input
					id="totalCargo" name="totalCargo" class="form-control"
					aria-required="true" type="text" readonly="readonly"
					value="${dataForm.dataForm.valoresDeclara.totalCargo}" maxlength="240">
			</div>
		</div>
	</div>
</div>

