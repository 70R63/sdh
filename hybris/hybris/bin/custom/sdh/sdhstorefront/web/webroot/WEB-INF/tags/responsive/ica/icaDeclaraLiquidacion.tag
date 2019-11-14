<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!-- Total Ingresos ordinarios y extraordinarios de periodo -->

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
							code="ica.declaracion.liquidacion.totinord" /></label> 
						<input
						disabled id="totalingPeriodo" name="totalIngrPeriodo" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.totalIngrPeriodo }" maxlength="240"></input>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totobfuerabogo" /></label> <input
						disabled id="totalingFueraBog" name="totalingFueraBog" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.totalingFueraBog }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.devrebdes" /></label> <input disabled
						id="devolDescuentos" name="devolDescuentos" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.devolDescuentos }" maxlength="240"></input>
				</div>
			</div>
		</div>
			<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinnetos" /></label> <input disabled
						id="totalingNetos" name="totalingNetos" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.totalingNetos }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.impincom" /></label> <input disabled
						id="impIndusComer" name="impIndusComer" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.impIndusComer }" maxlength="240"></input>
				</div>
			</div>
		</div>
		
		<c:choose>
			<c:when test="${empty infoDeclara.valorImpAviso or fn:trim(infoDeclara.valorImpAviso) le '0.00'}">
				<c:set var="impavtableros_checkedSI" value=""/>
				<c:set var="impavtableros_checkedNO" value="checked"/>
			</c:when>
			<c:when test="${not empty infoDeclara.valorImpAviso and fn:trim(infoDeclara.valorImpAviso) gt '0.00'  }">
				<c:set var="impavtableros_checkedSI" value="checked"/>
				<c:set var="impavtableros_checkedNO" value=""/>
			</c:when>
			<c:otherwise>
				<c:set var="impavtableros_checkedSI" value=""/>
				<c:set var="impavtableros_checkedNO" value=""/>
			</c:otherwise>
		</c:choose>
		<div class="row">
			<div class="col-md-5">
				<div class="form-check">
					<label class="form-check-label"
						style="text-transform: none !important; font-weight: normal !important; font-size: 14px !important;"><spring:theme
							code="ica.declaracion.liquidacion.impavtableros" /> </label> <label
						class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="impAviso" id=""
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important;"
						onclick="habilitar()" value="si" ${impavtableros_checkedSI}> Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="impAviso" id="" value="no"
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px" onclick="deshabilitar()" ${impavtableros_checkedNO}>
						No
					</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<input id="valorImpAviso" name="" class="etiqlargas form-control text-right !important" disabled
						type="text" value="${infoDeclara.valorImpAviso}" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valtot" /></label> <input disabled
						id="totalUnidadAdic" name="totalUnidadAdic" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.totalUnidadAdic }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totimpcar" /></label> <input disabled
						id="impuestoCargo" name="impuestoCargo" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.impuestoCargo }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.sanciones" /></label> <input disabled
						id="sanciones" name="sanciones" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.sanciones }" maxlength="240"></input>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totsaldo" /></label> <input disabled
						id="saldoCargo" name="saldoCargo" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.saldoCargo }" maxlength="240"></input>
				</div>
			</div>
		</div>
			<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valpag" /></label> <input id="valorPagar"
						name="valorPagar" class="etiqlargas form-control text-right !important" type="text"
						value="${infoDeclara.valorPagar }" maxlength="240"></input>
				</div>
			</div>
		</div>	

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.intmora" /></label> <input disabled
						id="interesMora" name="interesMora" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.interesMora }" maxlength="240"></input>
				</div>
			</div>
		</div>
	<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totpagvol" /></label> <input disabled
						id="totalAporteVolun" name="totalAporteVolun" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.totalAporteVolun }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valret" /></label> <input disabled
						id="valorReteIndusComer" name="valorReteIndusComer" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.valorReteIndus }" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totpag" /></label> <input disabled
						id="totalPagar" name="totalPagar" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.totalPagar }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<c:set value="" var="aporteSI" />
		<c:set value="" var="aporteNO" />
		
		<c:choose>
			<c:when test="${not empty infoDeclara.checkAporte  }">
				<c:set value="checked" var="aporteSI" />
			</c:when>
			<c:otherwise>
				<c:set value="checked" var="aporteNO" />
			</c:otherwise>
		</c:choose>
		
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
						onclick="disab()" ${aporteSI} value="si"> Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="aporte" id=""
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px" ${aporteNO}
						onclick="disab2()" value="no"> No
					</label>
				</div>
			</div>
		</div>
		<c:set var="selectProjectSelected" value="" />
		
		<c:set var="fortalecimientoOptionSelected" value="" />
		<c:set var="financimientoOptionSelected" value="" />
		
		<c:set var="selectTarifa2OptionSelected" value="" />
		<c:set var="selectTarifa1OptionSelected" value="" />
		
		<c:set var="tarifa2_10OptionSelected" value="" />
		
		<c:set var="tarifa1_3OptionSelected" value="" />
		<c:set var="tarifa1_5OptionSelected" value="" />
		<c:set var="tarifa1_10OptionSelected" value="" />
		
		<c:set var="projectDisable" value="disabled" />
		<c:set var="tarifa2Disable" value="disabled" />
		<c:set var="tarifa1Disable" value="disabled" />
		
		<c:set var="tarifa2Display" value="display: none;" />
		<c:set var="tarifa1Display" value="display: none;" />
		<c:set var="emptyTarifaDisplay" value="display: none;" />
		
		
		<c:choose>
			<c:when test="${not empty infoDeclara.checkAporte}">
				<c:set var="projectDisable" value="" />
				<c:choose>
					<c:when test="${fn:trim(infoDeclara.proyectoAporte) eq '02' or fn:trim(infoDeclara.proyectoAporte) eq '2'}">
						
						<c:set var="financimientoOptionSelected" value="selected" />
						
						<c:set var="tarifa1Display" value="" />
						<c:set var="tarifa1Disable" value="" />
						
						<c:if test="${fn:trim(infoDeclara.tarifaAporte) eq '3.00'}">
							<c:set var="tarifa1_3OptionSelected" value="selected" />
						</c:if>
						<c:if test="${fn:trim(infoDeclara.tarifaAporte) eq '5.00'}">
							<c:set var="tarifa1_5OptionSelected" value="selected" />
						</c:if>
						<c:if test="${fn:trim(infoDeclara.tarifaAporte) eq '10.00'}">
							<c:set var="tarifa1_10OptionSelected" value="selected" />
						</c:if>
					</c:when>
					<c:when test="${fn:trim(infoDeclara.proyectoAporte) eq '01' or fn:trim(infoDeclara.proyectoAporte) eq '1'}">
					
						<c:set var="fortalecimientoOptionSelected" value="selected" />
						<c:set var="tarifa2Disable" value="" />
						<c:set var="tarifa2Display" value="" />
						<c:if test="${fn:trim(infoDeclara.tarifaAporte) eq '10.00'}">
							<c:set var="tarifa2_10OptionSelected" value="selected" />
						</c:if>
					</c:when>
					<c:otherwise>
						<c:set var="projectDisable" value="" />
						<c:set var="tarifa1Display" value="" />
					</c:otherwise>
				</c:choose>
							
			</c:when>
			<c:otherwise>
				<c:set var="emptyTarifaDisplay" value="display: block;" />
			</c:otherwise>
		</c:choose>
		
		<div class="row">
		<div class="col-md-1">
				<div class="form-group">
					
						<span class="">Proyecto</span>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<select  id="idaporte" ${projectDisable } class="sel_etiqlargas form-control" onchange="showtarifa(this)" style="text-transform: none !important; font-weight: normal !important; font-size: 14px; width:80% !important;">
						<option value="0">Seleccionar</option>
						<option value="01" ${fortalecimientoOptionSelected }>Fortalecimiento de la seguridad ciudadana </option>
						<option value="02" ${financimientoOptionSelected }>Financiación de la educación superior</option></select>
				</div>
			</div>
			
		</div>
		
		
		
		
			<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<select id="tarifaAporte2" ${tarifa2Disable} class="sel_etiqlargas form-control" style="${tarifa2Display} text-transform: none !important; font-weight: normal !important; font-size: 14px;">
						<option value="">Seleccionar</option>
						<option value="10.00" ${tarifa2_10OptionSelected }>10.00</option></select>
				</div>
			</div>
			
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<select id="tarifaAporte1" ${tarifa1Disable} class="sel_etiqlargas form-control" style="${tarifa1Display} text-transform: none !important; font-weight: normal !important; font-size: 14px;">
						<option value="">Seleccionar</option>
						<option value="3.00" ${tarifa1_3OptionSelected }>3.00</option>
						<option value="5.00" ${tarifa1_5OptionSelected }>5.00</option>
						<option value="10.00" ${ tarifa1_10OptionSelected}>10.00</option></select>
						
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-1">
						<div class="form-group">
							<span class="">Tarifa</span>
						</div>
					</div>
			<div class="col-md-5">
				<div class="form-group">
					<select id="emptyTarifa" ${tarifa1Disable} class="sel_etiqlargas form-control" style="${emptyTarifaDisplay} text-transform: none !important; font-weight: normal !important; font-size: 14px;"  style="margin-left: -345px;">
						<option value="">Seleccionar</option>
					</select>
				
				</div>
			</div>
			
		</div>
	
		<div class="row mt-3">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinbrut" /></label> <input disabled
						id="totalingBrutos" name="totalingBrutos" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.totalingBrutos }" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.dedexeact" /></label> <input disabled
						id="totalDeduccion" name="totalDeduccion" class="etiqlargas form-control text-right !important" disabled type="text"
						value="${infoDeclara.totalDeduccion }" maxlength="240"></input>
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
		
		cant.value="0";
		tar1.value = "";
		tar2.value = "";
		

	}
	
	function showtarifa(selectObject) {
		var x = selectObject.value;
		var tari1 = document.getElementById('tarifaAporte1');
		var tari2 = document.getElementById('tarifaAporte2');
		var emptyTarifa = document.getElementById('emptyTarifa');
		if (x == '01') {
			tari1.style.display = 'none';
			tari2.style.display = 'block';
			emptyTarifa.style.display = 'none';
			tari1.disabled = true;
			tari2.disabled = false;

		} else if (x == '02') {
			tari1.style.display = 'block';
			tari2.style.display = 'none';
			emptyTarifa.style.display = 'none';
			tari1.disabled = false;
			tari2.disabled = true;
		}else
			{
				tari1.style.display = 'none';
				tari2.style.display = 'none';
				emptyTarifa.style.display = 'block';
			}


	}
	
	function deshabilitar() {
		var imp = document.getElementById('impuest');
// 		imp.disabled = true;


	}
	
	function habilitar() {
		var imp = document.getElementById('impuest');
// 		imp.disabled = false;
	}
</script>

