<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
<c:set value="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara }" var="infoDeclara" />
	<form:form action="">
		<br>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinord" /></label> <input id=""
						name="" class="form-control" type="text" value="" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totobfuerabogo" /></label> <input
						disabled id="" name="" class="form-control" disabled type="text"
						value="${infoDeclara.totalingFueraBog }" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinbrut" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.totalingBrutos }"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.devrebdes" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.devolDescuentos }"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.dedexeact" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.totalDeduccion }"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinnetos" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.totalingNetos }"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.impincom" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.impIndusComer }"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-check">
					<label class="form-check-label"
						style="text-transform: none !important;"><spring:theme
							code="ica.declaracion.liquidacion.impavtableros" /> </label> <label
						class="form-check-label"
						style="text-transform: capitalize !important"> <input
						type="radio" name="aporte" id="" class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important;"
						onclick="show()"> Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important"> <input
						type="radio" name="aporte" id="" class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
						No
					</label>
				</div>

			</div>
			<div class="col-md-4">
				<div class="form-group">
					<input id="" id="" name="" class="form-control" disabled
						type="text" value="${infoDeclara.impuestoAviso }" maxlength="240"></input>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valtot" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.totalUnidadAdic }"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totimpcar" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.impuestoCargo }"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valret" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.valorReteIndus }"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totsaldo" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.saldoCargo }"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valpag" /></label> <input id=""
						name="" class="form-control" type="text" value="${infoDeclara.valorPagar }" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.sanciones" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.sanciones }"
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.intmora" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.interesMora }"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totpag" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.totalPagar }"
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-check">
					<label class="form-check-label"
						style="text-transform: none !important;"><spring:theme
							code="ica.declaracion.liquidacion.aportvol" /> </label> <label
						class="form-check-label"
						style="text-transform: capitalize !important"> <input
						type="radio" name="aporte" id="" class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important;"
						onclick="disab()"> Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important"> <input
						type="radio" name="aporte" id="" class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px"
						onclick="disab2()"> No
					</label>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<select id="idaporte" disabled class="form-control"><option>Seleccionar</option></select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totpagvol" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value="${infoDeclara.totalAporteVolun }"
						maxlength="240"></input>
				</div>
			</div>
		</div>

	</form:form>
</div>

<script>
	function disab() {
		var cant = document.getElementById('idaporte');
		cant.disabled = false;

	}

	function disab2() {
		var cant = document.getElementById('idaporte');
		cant.disabled = true;

	}
</script>

