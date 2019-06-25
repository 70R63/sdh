<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<sf:form action="${declaracionURL}" method="POST"
		modelAttribute="dataForm" id="forma">

		<div class="row">
			<div class="col-md-6">
				<div class="headline">
					<h3>
						<span tabindex="0"><spring:theme
								code="impuestos.decGasolina.Pagos.titulo" /></span>
					</h3>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="impuestos.decGasolina.Pagos.valorSobretasa" /></label> <input
							id="valorSobretasa" name="valorSobretasa" class="form-control"
							aria-required="true" type="text" readonly="readonly"
							value="${dataForm.dataForm.valoresDeclara.vlrSobretasa}"
							maxlength="240">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="impuestos.decGasolina.Pagos.valorSanciones" /></label> <input
							id="valorSansiones" name="valorSansiones" class="form-control"
							aria-required="true" type="text" readonly="readonly"
							value="${dataForm.dataForm.valoresDeclara.vlrSancPagos}"
							maxlength="240">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="impuestos.decGasolina.Pagos.valorIntereses" /></label> <input
							id="valorIntereses" name="valorIntereses" class="form-control"
							aria-required="true" type="text" readonly="readonly"
							value="${dataForm.dataForm.valoresDeclara.interesMora}"
							maxlength="240">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="impuestos.decGasolina.Pagos.menosCompensaciones" /></label> <input
							id="menosCompensaciones" name="menosCompensaciones"
							class="form-control" aria-required="true" type="text"
							readonly="readonly"
							value="${dataForm.dataForm.valoresDeclara.menosCompensa}"
							maxlength="240">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="impuestos.decGasolina.Pagos.valorTotalPagar" /></label> <input
							id="valorTotalPagar" name="valorTotalPagar" class="form-control"
							aria-required="true" type="text" readonly="readonly"
							value="${dataForm.dataForm.valoresDeclara.totalPagar}"
							maxlength="240">
					</div>
				</div>
			</div>
		</div>
	</sf:form>
</div>
