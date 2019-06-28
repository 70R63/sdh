<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new">
	<sf:form action="${declaracionURL}" method="POST"
		modelAttribute="dataForm" id="forma">

		<div class="row">
			<div class="col-md-6 headline">
				<h3>
					<span tabindex="0"><spring:theme
							code="impuestos.decGasolina.DatosRevisor.titulo" /></span>
				</h3>
			</div>
		</div>



		<div class="row">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="impuestos.decGasolina.DatosRevisor.nombre" /></label> <input
							id="nombre" name="nombre" class="form-control"
							aria-required="true" type="text"
							value="${dataForm.revisor.nombres}" maxlength="240"
							readonly="readonly">
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="impuestos.decGasolina.DatosRevisor.tipoId" /></label> <input
							id="nombre" name="nombre" class="form-control"
							aria-required="true" type="text"
							value="${dataForm.revisor.tipoDocDESC}" maxlength="240"
							readonly="readonly">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="impuestos.decGasolina.DatosRevisor.numeroId" /></label> <input
							id="numeroId" name="gnumeroId" class="form-control"
							aria-required="true" type="text"
							value="${dataForm.revisor.numDoc}" maxlength="240"
							readonly="readonly">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="impuestos.decGasolina.DatosRevisor.numeroTarjetaProf" /></label>
						<input id="numeroTarjetaProf" name="numeroTarjetaProf"
							class="form-control" aria-required="true" type="text"
							value="${dataForm.revisor.tarjetaProf}" maxlength="240"
							readonly="readonly">
					</div>
				</div>
			</div>
		</div>
	</sf:form>
</div>

