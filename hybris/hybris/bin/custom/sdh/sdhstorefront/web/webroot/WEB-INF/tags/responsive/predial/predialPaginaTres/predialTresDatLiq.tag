<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<form:form>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="predialuno.datliquidacion.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.datliquidacion.porcepropiedad" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text"
						value="${predialFormtres.datosJuridicos.porcentajePropiedad}"
						maxlength="240" style="display: inline-block !important;"></input><label
						class="control-label" style="display: inline-block !important;"><spring:theme
							code="%" /></label>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.generales.calidad" /></label> <input id="" name=""
						class="newalto form-control" disabled type="text"
						value="${predialFormtres.desCalidad}" maxlength="240"></input>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.datliquidacion.porcenexe" /></label> <input
						id="porcenexe" name="" class="newalto form-control" disabled
						type="text" value="${predialFormtres.decExencion}" maxlength="240"
						style="display: inline-block !important;"></input><label
						class="control-label" style="display: inline-block !important;"><spring:theme
							code="%" /></label>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.datliquidacion.porceexclu" /></label> <input
						id="porceexclu" name="" class="newalto form-control" disabled
						type="text" value="${predialFormtres.decExclusion}"
						maxlength="240" style="display: inline-block !important;"></input><label
						class="control-label" style="display: inline-block !important;"><spring:theme
							code="%" /></label>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.datliquidacion.tarliqui" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text"
						value="${predialFormtres.estrLiquidacionPredial.tarifaLiquidacion}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.datliquidacion.destino" /></label> <input id="" name=""
						class="alto form-control" disabled type="text"
						value="${predialFormtres.desDestino}" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.datliquidacion.basegrav" /></label> <input
						id="basegrav" name="basegrav" class="newalto form-control"
						disabled type="text"
						value="${predialFormtres.estrLiquidacionPredial.baseGravable}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
	</div>
</form:form>


