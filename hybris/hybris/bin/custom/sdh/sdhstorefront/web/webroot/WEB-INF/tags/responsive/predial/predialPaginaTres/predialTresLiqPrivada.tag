<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<!-- Agregar el valor del acto que venga del form para determinar si se muestran los campos de acto o no -->
<c:set var="idacto" value=""/>

<input type="hidden" value="${predialForm.mostrarAporteVoluntario}"
	id="mostrarAporteVoluntario" />

<c:set var="disabledAporte" value="" />
<c:set var="disabledSiAceptaFactura" value="" />
<c:choose>
<c:when test="${predialFormtres.checkAporte_flag == 1}">
	<c:set var="disabledAporte" value='' />
</c:when>
<c:when test="${predialFormtres.checkAporte_flag == 2}">
<%-- 	<c:set var="disabledAporte" value='disabled="disabled"' /> --%>
</c:when>
</c:choose>
<c:set var="disabledLiquidacionPrivada" value="" />
<c:if test="${predialFormtres.controlCampos.liquidacionPrivada == true}">
	<c:set var="disabledLiquidacionPrivada" value='disabled="disabled"' />
	<c:set var="disabledAporte" value='disabled="disabled"' />
	<c:set var="disabledSiAceptaFactura" value='disabled="disabled"' />
</c:if>
<c:set var="flagProyecto_01" value=false />
<c:if test="${predialFormtres.anioGravable != '2022'}">
<c:set var="flagProyecto_01" value=true />
</c:if>
<spring:htmlEscape defaultHtmlEscape="true" />
<form:form>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="predialtres.liquidacionpriv.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>


		<div class="row">
			<c:if test="${predialFormtres.aporte_activo == 'X'}">
			<div class="col-md-5 col-xs-9">
				<label class="control-label "
					style="font-weight: 400; text-transform: none !important;"><spring:theme
						code="predialuno.liquidacionpriv.aporte" /></label> <input
					class="optradio"
					style="visibility: visible !important; left: 0px !important; display: inline-block !important; min-height: 0px; margin-left: 5px !important;"
					type="radio" name="optradio" id="optionSi" value="1"
					${disabledAporte}> Si <input class="optradio"
					style="visibility: visible !important; left: 0px !important; display: inline-block !important; min-height: 0px; margin-left: 5px !important;"
					type="radio" name="optradio" id="optionNo" value="2"
					${disabledAporte}>No
			</div>
			</c:if>
			<div class="col-md-5">
				<label class="control-label "
					style="font-weight: 400; text-transform: none !important;"><spring:theme
						code="predialuno.liquidacionpriv.aceptaFactura" /> <input
					class="predialNoAceptaFactura"
					style="visibility: visible !important; left: 0px !important; display: inline-block !important; min-height: 0px; margin-left: 5px !important;"
					type="checkbox" name="optionSiAceptaFactura"
					id="predialNoAceptaFactura" value="true" ${disabledSiAceptaFactura}> </label>
			</div>
		</div>
		<c:if test="${predialFormtres.aporte_activo == 'X'}">
		<div class="row">
			<div class="col-md-4" id="proyecto">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialuno.liquidacionpriv.proyecto" /></label> <select
						id="proyectoLiq" name="" class="alto_select alto form-control"
						${disabledAporte}><option value="00">Seleccionar</option>
						<c:if test="${flagProyecto_01}"><option value="01">FORTALECIMIENTO DE LA SEGURIDAD CIUDADANA</option></c:if>
						<option value="02">FINANCIACIÓN DE LA EDUCACIÓN SUPERIOR</option>
						<option value="03">BOGOTÁ SOLIDARIA EN CASA</option>
						</select>
				</div>
			</div>
		</div>
		</c:if>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.valimp" /></label> <input
						id="ValorImpuestoACargo" name="" class="newalto form-control"
						disabled type="text"
						value="${predialFormtres.estrLiquidacionPrivada.valorImpuestoCargo}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.descuento" /></label> <input
						id="DescuentoPorIncrementoDiferencias" name=""
						class="newalto form-control" disabled type="text"
						value="${predialFormtres.estrLiquidacionPrivada.descuentoIncrementoDiferencial}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.impajustado" /></label> <input
						id="ValorImpuestoAjustadoActual" name=""
						class="newalto form-control" disabled type="text"
						value="${predialFormtres.estrLiquidacionPrivada.valorImpuestoAjustadoActual}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.sancion" /></label> <input
						id="Sancion" name="" class="newalto form-control" disabled
						type="text"
						value="${predialFormtres.estrLiquidacionPrivada.sancion}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.saldo" /></label> <input
						id="TotalSaldoACargo" name="" class="newalto form-control"
						disabled type="text"
						value="${predialFormtres.estrLiquidacionPrivada.totalSaldoCargo}"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.valpagar" /></label> <input
						id="ValorAPagar" name="" class="newalto form-control" disabled
						type="text"
						value="${predialFormtres.estrLiquidacionPrivada.valorAPagar}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.desprontopago" /></label> <input
						id="DescuentoPorProntoPago" name="" class="newalto form-control"
						type="text"
						value="${predialFormtres.estrLiquidacionPrivada.descuentoProntoPago}"
						maxlength="240" disabled="disabled"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.descuadicional" /></label> <input
						id="DescuendoAdicional1" name="" class="newalto form-control"
						disabled type="text"
						value="${predialFormtres.estrLiquidacionPrivada.descuentoAdicional}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.intereses" /></label> <input
						id="Intereses" name="" class="newalto form-control" disabled
						type="text"
						value="${predialFormtres.estrLiquidacionPrivada.intereses}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.totpag" /></label> <input
						id="TotalAPagar" name="" class="newalto form-control" disabled
						type="text"
						value="${predialFormtres.estrLiquidacionPrivada.totalPagar}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.valaportevol" /></label> <input
						id="ValorAporteVoluntario" name="" class="newalto form-control"
						disabled type="text"
						value="${predialFormtres.estrLiquidacionPrivada.valorAporteVoluntario}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialtres.liquidacionpriv.totpagvolun" /></label> <input
						id="TotalConPagoVoluntario" name="" class="newalto form-control"
						disabled type="text"
						value="${predialFormtres.estrLiquidacionPrivada.totalPagoVoluntario}"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<c:if
					test="${predialFormtres.controlCampos.liquidacionPrivada != true}">
					<button style="margin-top: 3px;" id=""
						class="btn btn-primary btn-lg" type="button"
						onclick="calculoPred()">
						<spring:theme code="predialtres.liquidacionpriv.calcular" />
					</button>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.mensaje.spac" /></label>
				</div>
			</div>
		</div>
		<c:if test="${idacto != ''}">
		<div class="row">
			<div class="col-md-4">
				<div class="form-check">
					<label class="form-check-label"
						style="text-transform: none !important; font-weight: normal !important"><spring:theme
							code="predial.declaracion.vehiculo.liq.acogerseacto" /> </label> <label
						class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="acogerse" id="acogerseSi"
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important;"
						value="si" onclick=""> Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="acogerse" id="acogerseNo"
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px"
						value="no" onclick="punto()"> No
					</label>
				</div>
			</div>
			</div>
			</c:if>
	</div>
</form:form>

<script type="text/javascript">
	function calculoPred() {
		ACC.predial.calculoPredial();
	}
	function punto(){
		alert("Favor de acudir a punto de contacto para que un funcionario le apoye a generar su declaración");
	}
</script>


