<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<c:set var="disabledLiquidacion" value="" />
<c:set var="disabledAporte" value="" />
<c:set var="disabledAll" value='disabled="disabled"' />
<c:set var="flagProyecto_01" value="false" />
<c:set var="flagProyecto_02" value="false" />
<c:if test="${vehiculosFormDeclaracion.anioGravable != '2022'}">
<c:set var="flagProyecto_01" value="true" />
<c:set var="flagProyecto_02" value="true" />
</c:if>

<c:if test="${false}">
<!-- Agregar el valor del acto que venga del form para determinar si se muestran los campos de acto o no -->
	<c:set var="idacto" value="123" />
	<c:choose>
		<c:when test="${idacto != ''}">
		   <c:set var="disabledLiquidacion" value='disabled="disabled"' />
	       <c:set var="disabledAporte" value='disabled="disabled"' />
	       <c:set var="disabledLinea" value='disabled="disabled"' />
	       <c:set var="disabledCilindraje" value='disabled="disabled"' />
	       <c:set var="disabledAvaluo" value='disabled="disabled"' />
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</c:if>

<c:choose>
	<c:when test="${vehiculosFormDeclaracion.checkAporte_flag == 1}">
		<c:set var="disabledAporte" value='' />
	</c:when>
	<c:when test="${vehiculosFormDeclaracion.checkAporte_flag == 2}">
		<c:set var="disabledAporte" value='disabled="disabled"' />
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${vehiculosFormDeclaracion.homologado == 'X'}">
		<c:if test="${fn:substring(vehiculosFormDeclaracion.opcionUso,0,2) == '01'}">
			<c:set var="disabledLinea" value='true' />
			<c:set var="disabledCilindraje" value='disabled="disabled"' />
			<c:set var="disabledAvaluo" value='disabled="disabled"' />
		</c:if>
		<c:if test="${fn:substring(vehiculosFormDeclaracion.opcionUso,0,2) == '02'}">
			<c:set var="disabledLinea" value='' />
			<c:set var="disabledCilindraje" value='' />
			<c:set var="disabledAvaluo" value='' />
		</c:if>
	</c:when>
	<c:when test="${vehiculosFormDeclaracion.homologado != 'X'}">
		<c:set var="disabledLinea" value='' />
		<c:set var="disabledCilindraje" value='' />
		<c:set var="disabledAvaluo" value='' />
	</c:when>
</c:choose>

<c:set var="disabledAporte" value='disabled="disabled"' />
<c:set var="projectDisable" value='disabled="disabled"' />
<c:set var="mostrarSeccionAporte" value="false" />
<c:if test="${vehiculosFormDeclaracion.aporte_activo == 'X'}">
	<c:set var="disabledAporte" value="" />
	<c:set var="projectDisable" value="" />
	<c:set var="mostrarSeccionAporte" value="true" />
</c:if>

<c:if test="${fn:substring(vehiculosFormDeclaracion.opcionUso,0,2) == '02'}">
	<c:set var="mostrarSeccionAporte" value="false" />
</c:if>

<c:set var="flagDisabled_capacidadPas" value='disabled="disabled"' />
<c:set var="flagDisabled_capacidadTon" value='disabled="disabled"' />
<c:choose>
	<c:when test="${vehiculosFormDeclaracion.tipoVeh == 6}">
		<c:set var="flagDisabled_capacidadPas" value='' />
	</c:when>
	<c:when test="${vehiculosFormDeclaracion.tipoVeh == 7}">
		<c:set var="flagDisabled_capacidadTon" value='' />
	</c:when>
</c:choose>
		
<c:set var="flagCalcular" value='true' />
<c:if test="${vehiculosFormDeclaracion.controlCampos.liquidacion == true}">
	<c:set var="disabledLiquidacion" value='disabled="disabled"' />
	<c:set var="disabledAporte" value='disabled="disabled"' />
	<c:set var="projectDisable" value='disabled="disabled"' />
	<c:set var="disabledLinea" value='disabled="disabled"' />
	<c:set var="disabledCilindraje" value='disabled="disabled"' />
	<c:set var="disabledAvaluo" value='disabled="disabled"' />
	<c:set var="flagCalcular" value='false' />
	<input type="hidden" id="disabledLiquidacion_flag" value="X"/>
	<c:set var="flagDisabled_capacidadPas" value='disabled="disabled"' />
	<c:set var="flagDisabled_capacidadTon" value='disabled="disabled"' />
</c:if>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span><spring:theme
						code="sobre.vehiculo.declaracion.vehiculo.liq.title" /></span>
			</h2>
		</div>
	</div>



	<c:set var="avaluoChecked" value=""></c:set>
	<c:set var="noChecked" value="" />
	<c:set var="yesChecked" value="" />
	<%-- 	<c:choose> --%>
	<%-- 		<c:when --%>
	<%--  			test="${vehiculosFormDeclaracion.checkAporte.equalsIgnoreCase('X')}">  --%>
	<%--  			<c:set var="yesChecked" value="checked" />  --%>
	<%--  		</c:when>  --%>
	<%--  		<c:otherwise>  --%>
	<%--  			<c:set var="noChecked" value="checked" />  --%>
	<%--  		</c:otherwise>  --%>
	<%--  	</c:choose>  --%>
	<form:form action="">

		
		
		
		
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.linea" /></label> <select 
						id="linea"   class="alto_select form-control" aria-required="true"
						onchange='actualizarCampo("cilindraje")' ></select>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.captone" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.capacidadTon}" maxlength="30"
						${flagDisabled_capacidadTon}>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.cilindra" /></label> <select
						id="cilindraje" class="alto_select form-control"
						aria-required="true" onchange='actualizarCampo("avaluo")' ${disabledCilindraje} ></select>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.cappasa" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.capacidadPas}" maxlength="30"
						${flagDisabled_capacidadPas}>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.avalact" /></label> <input
						id="avaluoAct" name=""
						class="newalto form-control avaluoAct valFormatoImporte"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.avaluo}" maxlength="30" ${disabledAvaluo} onchange='validaMontoAvaluo("${vehiculosFormDeclaracion.avaluo}")' >
				</div>
			</div>
		</div>

		<div class="row" style="display: none" id="AvaluoMensaje"
			class="AvaluoMensaje">
			<div class="alert alert-warning" role="alert">
				<input disabled id="mensajeAvaluo" name="" type="text" value=""
					style="border: none !important; background-color: transparent !important; max-width: 200% !important; width: 100% !important">
			</div>
		</div>

		<c:if test="${mostrarSeccionAporte == true}">
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-check">
					<label class="form-check-label"
						style="text-transform: none !important; font-weight: normal !important"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.aporte" /> </label> <label
						class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="aporte" id="aporteSi"
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important;"
						value="si" ${yesChecked} onclick="proyecthabi()" ${disabledAporte}>
						Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="aporte" id="aporteNo"
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px"
						value="no" ${noChecked} onclick="proyectdeshabi()"
						${disabledAporte}> No
					</label>
				</div>
			</div>

			<c:set var="option01Selected" value="" />
			<%-- 			<c:choose> --%>
			<%-- 				<c:when test="${vehiculosFormDeclaracion.checkAporte.equalsIgnoreCase('X')}"> --%>
			<%-- 					<c:set var="projectDisable" value="" /> --%>
			<%-- 					<c:choose> --%>
			<%-- 						<c:when test="${fn:trim(vehiculosFormDeclaracion.proyectoAporte) eq '01' or fn:trim(vehiculosFormDeclaracion.proyectoAporte) eq '1'}"> --%>
			<%-- 							<c:set var="option01Selected" value="selected" /> --%>
			<%-- 						</c:when> --%>
			<%-- 					</c:choose> --%>
			<%-- 				</c:when> --%>
			<%-- 			</c:choose> --%>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.proyecto" /></label><select
						id="proyecto" name="proyecto" class="alto_select form-control"
						aria-required="true" ${projectDisable}>
						<option value="00">SELECCIONAR</option>
						<c:if test="${flagProyecto_01}"><option value="01" ${option01Selected}>FORTALECIMIENTO DE LA SEGURIDAD CIUDADANA</option></c:if>
						<c:if test="${flagProyecto_02}"><option value="02">FINANCIACI�N DE LA EDUCACI�N SUPERIOR</option></c:if>
						<option value="03">BOGOT� SOLIDARIA EN CASA</option>
					</select>
				</div>
			</div>
		</div>
		</c:if>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.taract" /></label> <input
						id="taract" name="" class="newalto form-control taract"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.tarifaActual}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.valimpcar" /></label><input
						id="valimpcar" name="numresol"
						class="newalto form-control valimpcar" aria-required="true"
						type="text" value="${vehiculosFormDeclaracion.impuestoCargo}"
						maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.sancion" /></label> <input
						id="sancion" name="" class="newalto form-control sancion"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.sancion}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.valpagar" /></label> <input
						id="valpagar" name="" class="newalto form-control valpagar"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.valorPagar}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.valsemafo" /></label> <input
						id="valsemafo" name="valsemafo" class="newalto form-control"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.valorSemafor}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.descuentoconbustible" /></label> <input
						id="descuentoconbustible" name="descuentoconbustible" class="newalto form-control"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.descuentoconbustible}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.descuentoadicional" /></label> <input
						id="descuentoadicional" name="descuentoadicional" class="newalto form-control"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.descuentoadicional}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.despronpag" /></label> <input
						id="despronpag" name="" class="newalto form-control despronpag"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.descuentoProntop}"
						maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.intereses" /></label> <input
						id="intereses" name="" class="newalto form-control intereses"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.intereses}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.totpag" /></label> <input
						id="totpag" name="" class="newalto form-control totpag"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.totalPagar}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.totpagvol" /></label> <input
						id="totpagvol" name="" class="newalto form-control totpagvol"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.totalPagoVol}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>



		<input type="hidden" value="${vehiculosFormDeclaracion.numBP}"
			id="numBPcal" class="numBPcal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.numForm}"
			id="numForm" class="numForm" />
		<input type="hidden" value="${vehiculosFormDeclaracion.placa}"
			id="placa" class="placa" />
		<input type="hidden" value="${vehiculosFormDeclaracion.anioGravable}"
			id="anioGravablecal" class="anioGravablecal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.opcionUso}"
			id="opcionUsocal" class="opcionUsocal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.clase}"
			id="clasecal" class="clasecal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.idServicio}"
			id="idServiciocal" class="idServiciocal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.cilindraje}"
			id="cilindrajecal" class="cilindrajecal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.marca}"
			id="marcacal" class="marcacal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.linea}"
			id="lineacal" class="lineacal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.modelo}"
			id="modelocal" class="modelocal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.clasicoAntig}"
			id="clasicoAntiguocal" class="clasicoAntiguocal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.blindado}"
			id="blindadocal" class="blindadocal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.capacidadTon}"
			id="capacidadToncal" class="capacidadToncal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.capacidadPas}"
			id="capacidadPascal" class="capacidadPascal" />
		<input type="hidden" id="checkAportecal" class="checkAportecal" />



		<c:if test="${flagCalcular == true}">
			<div class="row">
				<div class="col-md-3">
					<button id="calcularVehButton"
						class="btn btn-primary calcularVehButton" type="button"
						style="margin-top: 28px !important">
						<spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.calcular" />
					</button>
				</div>
			</div>
		</c:if>
		<br>
	</form:form>
</div>


	
<script>
	
	
	
	function proyecthabi() {
		
		var proyec = document.getElementById('proyecto');
		document.getElementById("checkAportecal").value = "X";
		proyec.disabled = false;

	}

	function proyectdeshabi() {
		var proyec = document.getElementById('proyecto');
		document.getElementById("checkAportecal").value = "";
		proyec.disabled = true;
		proyec.value = "00";
	}

	function punto() {
		alert("Favor de acudir a punto de contacto para que un funcionario le apoye a generar su declaraci�n");

	}

	function habavaluo() {
		var avaluo = document.getElementById('avaluoAct');

		if (avaluo.disabled == false) {
			avaluo.disabled = true;
		} else {
			avaluo.disabled = false;
		}

	}
	
	function validaMontoAvaluo(montoOriginalAvaluo) {
		var nuevoAvaluo = $('#avaluoAct').val();
		montoOriginalAvaluo = montoOriginalAvaluo.replace('.',"");
		montoOriginalAvaluo = parseInt(montoOriginalAvaluo);
		nuevoAvaluo = parseInt(nuevoAvaluo);
		if (nuevoAvaluo < montoOriginalAvaluo) {
			alert("El nuevo monto de avaluo debe ser mayor o igual a " + montoOriginalAvaluo);
			$('#avaluoAct').val(montoOriginalAvaluo);
		}
	}
</script>

