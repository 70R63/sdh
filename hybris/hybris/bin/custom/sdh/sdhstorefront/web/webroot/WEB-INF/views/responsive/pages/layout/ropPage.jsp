
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />


	<div id="dialogRop" title="Generar ROP">
	<div id="ropDialogContent"></div>
	</div>


<div class="container_new_page">
	<form:form id="form_pdf" action="/sdhstorefront/es/contribuyentes/rop"
		method="post" commandName="ropForm">
		<input type="hidden" id="tipoImp" name="tipoImp" value="${ropFormRequest.tipoImp}" />
		<input type="hidden" id="numObjeto" name="numObjeto" value="${ropFormRequest.numObjeto}" />
		<input type="hidden" id="numBP" name="numBP" value="${ropFormRequest.numBP}" />
		<input type="hidden" id="clavePeriodo" name="clavePeriodo" value="${ropFormRequest.clavePeriodo}" />
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"> <spring:theme
							code="rop.generar.valobli" />
					</label> <input class="form-control new_alto" disabled="disabled"
						type="text" size="30" value="" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="rop.generar.totalpagar" /></label>
					<form:input class="form-control new_alto" disabled="true"
						type="text" size="30" value="" path="" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="rop.generar.parcial" /></label>
					<form:input class="form-control new_alto" type="text" size="30"
						value="" path="importeusuario" onkeyup="numberFormat(this)"
						onclick="numberFormat(this)" id="importeusuario" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<button style="margin-top: 26px; margin-bottom: 15px;" id=""
					class="btn btn-secondary btn-lg" onclick="goBack()" type="button">
					<spring:theme code="rop.generar.regresar" />
				</button>


			</div>
			<div class="col-md-2">
				<button style="margin-top: 26px; margin-bottom: 15px;" id="generaROPButton"
					class="btn btn-primary btn-lg"  type="button">
					<spring:theme code="rop.generar.genrop" />
				</button>
				<a id="downloadROPHelper" target="_blank"></a>
			</div>

			<div class="col-md-2">
				<button style="margin-top: 26px; margin-bottom: 15px;" id=""
					class="btn btn-primary btn-lg"
					onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea/form'/>';"
					type="button">
					<spring:theme code="rop.generar.pagolinea" />
				</button>
			</div>
		</div>

	</form:form>
</div>
<script>
	function goBack() {
		window.history.back();
	}
	
	function numberFormat(selectObject) {
		var numero = selectObject.value;
		var idinput = selectObject.id;
		var resultado = "";

		if (numero[0] == "-") {
			nuevoNumero = numero.replace(/\./g, '').substring(1);
		} else {

			nuevoNumero = numero.toString().replace(/\./g, '');
		}

		if (numero.toString().indexOf(",") >= 0)
			nuevoNumero = nuevoNumero.substring(0, nuevoNumero.indexOf(","));

		for (var j, i = nuevoNumero.length - 1, j = 0; i >= 0; i--, j++)
			resultado = nuevoNumero.charAt(i)
					+ ((j > 0) && (j % 3 == 0) ? "." : "") + resultado;

		if (numero.toString().indexOf(",") >= 0)
			resultado += numero.substring(numero.indexOf(","));

		if (numero[0] == "-") {

			document.getElementById(idinput).value = "-" + resultado;
			return "-" + resultado;
		} else {
			document.getElementById(idinput).value = resultado;
			return resultado;

		}

	}
</script>

