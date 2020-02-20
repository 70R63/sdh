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
								code="predialocho.datliquidacion.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.datliquidacion.porcepropiedad" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.datosJuridicos.porcentajePropiedad}"
						maxlength="240" style="display: inline-block !important;"></input><label class="control-label" style="display: inline-block !important;"><spring:theme
							code="%" /></label>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.datliquidacion.porcenexe" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value=""
						maxlength="240" style="display: inline-block !important;"></input><label class="control-label" style="display: inline-block !important;"><spring:theme
							code="%" /></label>
				</div>
			</div>
		</div>
		
		<div class="row">
		<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.datliquidacion.calidad" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.datosJuridicos.calidadSujecion}"
						maxlength="240">
				</div>
			</div>
			
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.datliquidacion.tarliqui" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPredial.tarifaLiquidacion}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.datliquidacion.porceexclu" /></label> <input id="" name=""
						class="newalto form-control" disabled type="text" value=""
						maxlength="240" style="display: inline-block !important;"></input><label class="control-label" style="display: inline-block !important;"><spring:theme
							code="%" /></label>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.datliquidacion.basegrav" /></label> <input id="" name=""
						class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPredial.baseGravable}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.datliquidacion.destino" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPredial.destinoHacendario}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
	</div>
</form:form>


