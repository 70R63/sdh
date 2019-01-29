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
					code="impuestos.decGasolina.Totales.titulo" /></span>
		</h3>
	</div>
</div>
<div class="col-md-10">
	<div>
		<div class="row">
			<div class="col-md-2">
				<label class="inputlabelnew"><spring:theme
						code="impuestos.decGasolina.Totales.totalSobretasa" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="totalSobretasa" name="totalSobretasa"
						class="inputtextnew" aria-required="true" type="text"
						readonly="readonly"
						value="${dataForm.valoresDeclara.totalSobretasa}" maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<label class="inputlabelnew"><spring:theme
						code="impuestos.decGasolina.Totales.valorSansiones" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="valorSansiones" name="valorSansiones"
						class="inputtextnew" aria-required="true" type="text"
						readonly="readonly"
						value="${dataForm.valoresDeclara.vlrSancTotales}" maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<label class="inputlabelnew"><spring:theme
						code="impuestos.decGasolina.Totales.totalCargo" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="totalCargo" name="totalCargo" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${dataForm.valoresDeclara.totalCargo}" maxlength="240">
				</div>
			</div>
		</div>
	</div>
</div>



<div class="row"></div>