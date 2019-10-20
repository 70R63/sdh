<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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

	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-check">
					<label class="form-check-label"
						style="text-transform: none !important; font-weight: normal !important"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.aporte" /> </label> <label
						class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="aporte" id=""
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important;"
						value="si" onclick="proyecthabi()"> Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important; font-weight: normal !important">
						<input type="radio" name="aporte" id=""
						class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px"
						value="no" onclick="proyectdeshabi()"> No
					</label>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.proyecto" /></label><select
						id="proyecto" name="proyecto" class="alto_select form-control"
						aria-required="true" disabled="disabled">
						<option value="00">SELECCIONAR</option>
						<option value="01"> FORTALECIMIENTO DE LA SEGURIDAD CIUDADANA</option></select>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.valimpcar" /></label><input
						id="valimpcar" name="numresol" class="newalto form-control valimpcar"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.valsemafo" /></label> <input
						id="valsemafo" name="valsemafo" class="newalto form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.avalact" /></label> <input
						id="" name="" class="newalto form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.despronpag" /></label> <input
						id="despronpag" name="" class="newalto form-control despronpag" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.taract" /></label> <input
						id="taract" name="" class="newalto form-control taract" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.totpag" /></label> <input
						id="totpag" name="" class="newalto form-control totpag" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.sancion" /></label> <input
						id="sancion" name="" class="newalto form-control sancion" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.valpagar" /></label> <input
						id="valpagar" name="" class="newalto form-control valpagar" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.intereses" /></label> <input
						id="intereses" name="" class="newalto form-control intereses" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.totpagvol" /></label> <input
						id="totpagvol" name="" class="newalto form-control totpagvol" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>

		<input type="hidden" value="${vehiculosFormDeclaracion.numBP}"
			id="numBPcal" class="numBPcal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.numForm}" id="numForm" class="numForm" />
		<input type="hidden" value="${vehiculosFormDeclaracion.anioGravable}" id="anioGravablecal" class="anioGravablecal"/>
		<input type="hidden" value="${vehiculosFormDeclaracion.opcionUso}" id="opcionUsocal" class="opcionUsocal"/>
		<input type="hidden" value="${vehiculosFormDeclaracion.clase}" id="clasecal" class="clasecal"/>
		<input type="hidden" value="${vehiculosFormDeclaracion.idServicio}" id="idServiciocal" class="idServiciocal"/>
		<input type="hidden" value="${vehiculosFormDeclaracion.cilindraje}" id="cilindrajecal" class="cilindrajecal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.marca}" id="marcacal" class="marcacal" />
		<input type="hidden" value="${vehiculosFormDeclaracion.linea}" id="lineacal" class="lineacal"/>
		<input type="hidden" value="${vehiculosFormDeclaracion.modelo}" id="modelocal" class="modelocal"/>
		<input type="hidden" value="${vehiculosFormDeclaracion.clasicoAntig}" id="clasicoAntiguocal" class="clasicoAntiguocal"/>
		<input type="hidden" value="${vehiculosFormDeclaracion.blindado}" id="blindadocal" class="blindadocal"/>
		<input type="hidden" value="${vehiculosFormDeclaracion.capacidadTon}" id="capacidadToncal" class="capacidadToncal"/>
		<input type="hidden" value="${vehiculosFormDeclaracion.capacidadPas}" id="capacidadPascal" class="capacidadPascal"/>
		<input type="hidden" id="checkAportecal" class="checkAportecal"/>
		
		

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
	</form:form>
</div>

<script>
	function proyecthabi() {
		debugger;
		var proyec = document.getElementById('proyecto');
		document.getElementById("checkAportecal").value = "X";
		proyec.disabled = false;

	}

	function proyectdeshabi() {
		var proyec = document.getElementById('proyecto');
		document.getElementById("checkAportecal").value = "";
		proyec.disabled = true;
	}
</script>

