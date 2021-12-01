<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />



<div class="container">
	<div class="row">
		<div class="col-md-6">
			<h2>
				<span><spring:theme code="Total a pagar" /></span>
			</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="Causal" /></label> <input id="impCar"
					name="impCar" class="newalto form-control" aria-required="true"
					 maxlength="30"
					size="30" disabled="disabled">
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="Valor sansión" /></label> <input id="valsan"
					name="valsan" class="newalto form-control" aria-required="true"
					 maxlength="30"
					size="30" disabled="disabled">
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="Total sanción" /></label> <input id="valpag"
					name="valpag" class="newalto form-control" aria-required="true"
					 maxlength="30"
					size="30" disabled="disabled">
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="Valor reducción" /></label> <input id="intmora"
					name="intmora" class="newalto form-control" aria-required="true"
					maxlength="30"
					size="30" disabled="disabled">
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="Total a pagar" /></label> <input id="totpag"
					name="totpag" class="newalto form-control" aria-required="true" value="" maxlength="30"
					size="30" disabled="disabled">
			</div>
		</div>
	</div>

		<div class="row">
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px" onclick="goBack()">
							<spring:theme code="Regresar" />
						</button>
					</div>
				</div>
							<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.predial.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.predial.paglinea" />
						</button>
					</div>
				</div>
	</div>

</div>