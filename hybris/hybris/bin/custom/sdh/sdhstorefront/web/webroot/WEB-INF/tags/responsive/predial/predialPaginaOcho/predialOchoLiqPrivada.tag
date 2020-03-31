<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<input type="hidden" value="${predialForm.mostrarAporteVoluntario}" id="mostrarAporteVoluntario"/>

<c:set var="disabledLiquidacionPrivada" value=""/>
<c:if test="${predialFormocho.controlCampos.liquidacionPrivada == true}">
	<c:set var="disabledLiquidacionPrivada" value='disabled="disabled"'/>
</c:if>
<spring:htmlEscape defaultHtmlEscape="true" />
<form:form>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="predialocho.liquidacionpriv.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.valimp" /></label> <input id="ValorImpuestoACargo"
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPrivada.valorImpuestoCargo}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.descuento" /></label> <input id="DescuentoPorIncrementoDiferencias"
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPrivada.descuentoIncrementoDiferencial}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.impajustado" /></label> <input id="ValorImpuestoAjustadoActual"
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPrivada.valorImpuestoAjustadoActual}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.sancion" /></label> <input id="Sancion"
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPrivada.sancion}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.saldo" /></label> <input id="TotalSaldoACargo" name=""
						class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPrivada.totalSaldoCargo}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.valpagar" /></label> <input id="ValorAPagar"
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPrivada.valorAPagar}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.intereses" /></label> <input id="Intereses"
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPrivada.intereses}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.totpag" /></label> <input id="TotalAPagar"
						name="" class="newalto form-control" disabled type="text" value="${predialFormocho.estrLiquidacionPrivada.totalPagar}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<c:if test="${predialFormocho.controlCampos.liquidacionPrivada != true}">
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button" onclick="calculoPredSinAporte()">
					<spring:theme code="predialocho.liquidacionpriv.calcular" />
				</button>
				</c:if>
			</div>
		</div>
	</div>
</form:form>

<script type="text/javascript">
	function calculoPredSinAporte() {
		ACC.predial.calculoPredialSinAporte();
	}
</script>
