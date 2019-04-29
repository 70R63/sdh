<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<c:set
		value="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara }"
		var="infoDeclara" />
	<form:form action="">
		<br>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinord" /></label> <input id="totalIngrPeriodo"
						name="totalIngrPeriodo" class="form-control" type="text" value="${infoDeclara.totalIngrPeriodo }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totobfuerabogo" /></label> <input
						disabled id="totalingFueraBog" name="totalingFueraBog" class="form-control" disabled type="text"
						value="${infoDeclara.totalingFueraBog }" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinbrut" /></label> <input disabled
						id="totalingBrutos" name="totalingBrutos" class="form-control" disabled type="text"
						value="${infoDeclara.totalingBrutos }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.devrebdes" /></label> <input disabled
						id="devolDescuentos" name="devolDescuentos" class="form-control" disabled type="text"
						value="${infoDeclara.devolDescuentos }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.dedexeact" /></label> <input disabled
						id="totalDeduccion" name="totalDeduccion" class="form-control" disabled type="text"
						value="${infoDeclara.totalDeduccion }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinnetos" /></label> <input disabled
						id="totalingNetos" name="totalingNetos" class="form-control" disabled type="text"
						value="${infoDeclara.totalingNetos }" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.impincom" /></label> <input disabled
						id="impIndusComer" name="impIndusComer" class="form-control" disabled type="text"
						value="${infoDeclara.impIndusComer }" maxlength="240"></input>
				</div>
			</div>
		</div>
		
		<c:choose>
			<c:when test="${not empty icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara.impuestoAviso }">
				<div class="row">
					<div class="col-md-5">
						<div class="form-check">
							<label class="form-check-label"
								style="text-transform: none !important; font-weight: normal !important; font-size: 14px !important;"><spring:theme
									code="ica.declaracion.liquidacion.impavtableros" /> </label> <label
								class="form-check-label"
								style="text-transform: capitalize !important; font-weight: normal !important">
								<input type="radio" name="aporte" id=""
								class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important;"
								onclick="habilitar()" checked="checked"> Si
							</label> <label class="form-check-label"
								style="text-transform: capitalize !important; font-weight: normal !important">
								<input type="radio" name="aporte" id=""
								class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important; margin-left: 12px" onclick="deshabilitar()">
								No
							</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							<input id="impuest" name="" class="form-control" disabled
								type="text" value="${infoDeclara.impuestoAviso }" maxlength="240"></input>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row">
			<div class="col-md-5">
				<div class="form-check">
					<label class="form-check-label"
						style="text-transform: none !important; font-weight: normal !important; font-size: 14px !important;"><spring:theme
							code="ica.declaracion.liquidacion.impavtableros" /> </label> <label
						class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="aporte" id=""
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important;"
						onclick="habilitar()"> Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="aporte" id=""
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px" onclick="deshabilitar()" checked="checked">
						No
					</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<input id="impuest" name="" class="form-control" disabled
						type="text" value="${infoDeclara.valorImpAviso }" maxlength="240"></input>
				</div>
			</div>
		</div>
			</c:otherwise>
		</c:choose>
		

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valtot" /></label> <input disabled
						id="totalUnidadAdic" name="totalUnidadAdic" class="form-control" disabled type="text"
						value="${infoDeclara.totalUnidadAdic }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totimpcar" /></label> <input disabled
						id="impuestoCargo" name="impuestoCargo" class="form-control" disabled type="text"
						value="${infoDeclara.impuestoCargo }" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valret" /></label> <input disabled
						id="valorReteIndusComer" name="valorReteIndusComer" class="form-control" disabled type="text"
						value="${infoDeclara.valorReteIndus }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totsaldo" /></label> <input disabled
						id="saldoCargo" name="saldoCargo" class="form-control" disabled type="text"
						value="${infoDeclara.saldoCargo }" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valpag" /></label> <input id="valorPagar"
						name="valorPagar" class="form-control" type="text"
						value="${infoDeclara.valorPagar }" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.sanciones" /></label> <input disabled
						id="sanciones" name="sanciones" class="form-control" disabled type="text"
						value="${infoDeclara.sanciones }" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.intmora" /></label> <input disabled
						id="interesMora" name="interesMora" class="form-control" disabled type="text"
						value="${infoDeclara.interesMora }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totpag" /></label> <input disabled
						id="totalPagar" name="totalPagar" class="form-control" disabled type="text"
						value="${infoDeclara.totalPagar }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-check">
					<label class="form-check-label"
						style="text-transform: none !important; font-weight: normal !important; font-size: 14px;"><spring:theme
							code="ica.declaracion.liquidacion.aportvol" /> </label> <label
						class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="aporte" id=""
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important;"
						onclick="disab()"> Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="aporte" id=""
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px"
						onclick="disab2()"> No
					</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<select  id="idaporte" disabled class="form-control" onchange="showtarifa(this)" style="text-transform: none !important; font-weight: normal !important; font-size: 14px;">
						<option value=0>Seleccionar</option>
						<option value=1>Fortalecimiento de la seguridad ciudadana </option>
						<option value=2>Financiación de la educación superior</option></select>
				</div>
			</div>
		</div>
			<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<select id="tarifaAporte2" disabled class="form-control" style="text-transform: none !important; font-weight: normal !important; font-size: 14px;">
						<option value=0>Seleccionar</option>
						<option value=1>10.00</option></select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<select id="tarifaAporte1"  class="form-control" style="display: none; text-transform: none !important; font-weight: normal !important; font-size: 14px;">
						<option value=0>Seleccionar</option>
						<option value=1>3.00</option>
						<option value=2>5.00</option>
						<option value=3>10.00</option></select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totpagvol" /></label> <input disabled
						id="totalAporteVolun" name="totalAporteVolun" class="form-control" disabled type="text"
						value="${infoDeclara.totalAporteVolun }" maxlength="240"></input>
				</div>
			</div>
		</div>

	</form:form>
</div>

<script>
	function disab() {
		var cant = document.getElementById('idaporte');
		var tar1 = document.getElementById('tarifaAporte1');
		var tar2 = document.getElementById('tarifaAporte2');
		cant.disabled = false;
		tar1.disabled = false;
		tar2.disabled = false;

	}

	function disab2() {
		var cant = document.getElementById('idaporte');
		var tar1 = document.getElementById('tarifaAporte1');
		var tar2 = document.getElementById('tarifaAporte2');
		cant.disabled = true;
		tar1.disabled = true;
		tar2.disabled = true;

	}
	
	function showtarifa(selectObject) {
		var x = selectObject.value;
		var tari1 = document.getElementById('tarifaAporte1');
		var tari2 = document.getElementById('tarifaAporte2');

		if (x == '1') {
			tari1.style.display = 'none';
			tari2.style.display = 'block';

		} else if (x == '2') {
			tari1.style.display = 'block';
			tari2.style.display = 'none';
		}


	}
	
	function deshabilitar() {
		var imp = document.getElementById('impuest');
		imp.disabled = true;


	}
	
	function habilitar() {
		var imp = document.getElementById('impuest');
		imp.disabled = false;
	}
</script>

