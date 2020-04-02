<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<input type="hidden" value="${predialForm.mostrarAporteVoluntario}" id="mostrarAporteVoluntario"/>

<c:set var="disabledLiquidacionPrivada" value=""/>
<c:if test="${predialForm.controlCampos.liquidacionPrivada == true}">
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
								code="predialuno.liquidacionpriv.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="col-md-4">
				<label class="control-label "
					style="font-weight: 400; text-transform: none !important;"><spring:theme
						code="predialuno.liquidacionpriv.aceptaFactura" />
				<input	class="predialNoAceptaFactura"
					style="visibility: visible !important; left: 0px !important; display: inline-block !important; min-height: 0px; margin-left: 5px !important;"
					type="checkbox" name="optionSiAceptaFactura" id="predialNoAceptaFactura" value="true" >
				</label>			
			</div>
			
		</div>
		
		
		
		<div class="row">
			<div class="col-md-4">
				<label class="control-label "
					style="font-weight: 400; text-transform: none !important;"><spring:theme
						code="predialuno.liquidacionpriv.aporte" /></label> <input
					class="optradio"
					style="visibility: visible !important; left: 0px !important; display: inline-block !important; min-height: 0px; margin-left: 5px !important;"
					type="radio" name="optradio" id="optionSi" value="1" ${disabledLiquidacionPrivada}> Si <input
					class="optradio"
					style="visibility: visible !important; left: 0px !important; display: inline-block !important; min-height: 0px; margin-left: 5px !important;"
					type="radio" name="optradio" id="optionNo" value="2" ${disabledLiquidacionPrivada}>No
			</div>
			<div class="col-md-4" id="proyecto">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.proyecto" /></label> <select id="proyectoLiq"
						name="" class="alto_select alto form-control" ${disabledLiquidacionPrivada}><option value="00" >Seleccionar</option>
						<option value="01">FORTALECIMIENTO DE LA SEGURIDAD CIUDADANA</option>
						<option value="02">FINANCIACIÓN DE LA EDUCACIÓN SUPERIOR</option></select>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.valimp" /></label> <input id="ValorImpuestoACargo" name=""
						class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.valorImpuestoCargo}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.descuento" /></label> <input id="DescuentoPorIncrementoDiferencias"
						name="" class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.descuentoIncrementoDiferencial}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.impajustado" /></label> <input id="ValorImpuestoAjustadoActual"
						name="" class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.valorImpuestoAjustadoActual}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.sancion" /></label> <input id="Sancion"
						name="" class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.sancion}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.saldo" /></label> <input id="TotalSaldoACargo" name=""
						class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.totalSaldoCargo}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.valpagar" /></label> <input id="ValorAPagar"
						name="" class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.valorAPagar}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.desprontopago" /></label> <input id="DescuentoPorProntoPago"
						name="" class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.descuentoProntoPago}"
						maxlength="240" ${disabledLiquidacionPrivada}></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.descuadicional" /></label> <input id="DescuendoAdicional1"
						name="" class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.descuentoAdicional}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.intereses" /></label> <input id="Intereses"
						name="" class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.intereses}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.totpag" /></label> <input id="" name="TotalAPagar"
						class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.totalPagar}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.valaportevol" /></label> <input id="ValorAporteVoluntario"
						name="" class="newalto form-control"  disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.valorAporteVoluntario}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.totpagvolun" /></label> <input id="TotalConPagoVoluntario"
						name="" class="newalto form-control" disabled type="text"
						value="${predialForm.estrLiquidacionPrivada.totalPagoVoluntario}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<c:if test="${predialForm.controlCampos.liquidacionPrivada != true}">
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button"
					onclick="calculoPred()">
					<spring:theme code="predialuno.liquidacionpriv.calcular" />
				</button>
				</c:if>
			</div>
		</div>
	</div>
</form:form>

<script type="text/javascript">
	function calculoPred() {
		ACC.predial.calculoPredial();
	}
</script>
