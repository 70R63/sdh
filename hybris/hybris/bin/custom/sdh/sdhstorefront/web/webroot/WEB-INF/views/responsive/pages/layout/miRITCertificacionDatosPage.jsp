<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="edoCuenta"
	tagdir="/WEB-INF/tags/responsive/edoCuenta"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<template:sdhJavascriptVariables4/>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>
<style>
#myDIV {
	
}

input[type=radio] {
	border: 0px;
	width: 15pt;
	height: 15pt;
	vertical-align: -15pt;
}
</style>



<script>

window.onload = function() {

	var cosas = $(":input");
	var tam = cosas.length;
	if (false){
		for (var i = 0; i < tam; i++) {
			var valor = cosas[i].value;
			if (valor == "") {
				cosas[i].value = "-";

			}
		}
	}
	$(".loader").fadeOut("slow");
}
	function downloadPDF(pdf) {
// 		
		if (pdf) {
			const linkSource = 'data:application/pdf;base64,' + pdf;
			const downloadLink = document.createElement("a");
			const fileName = "Certificación_RIT.pdf";

			downloadLink.href = linkSource;
			downloadLink.download = fileName;
			downloadLink.click();
		}
	}

	downloadPDF('${miRitCertificacionFormResp.rit.stringRIT}');
</script>

<script>
	function Hide(val) {
		var x = document.getElementById("myDIV");
		if (val == "1") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>


<div class="container">
	<div class="row">
	<div class="col">
		<div class=" headline">
			<h2>
				<span tabindex="0"><spring:theme
						code="mirit.certificacion.titulo" /></span>
			</h2>
		</div>
	</div>
	</div>

	<c:url var="post_url" value="/contribuyentes/mirit/certificacion-datos" />
	<form:form id="form_pdf"
		action="${post_url}"
		method="post" modelAttribute="miRitCertificacionForm">
		<form:hidden path="numObjeto" id="numObjeto" />

		<br>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group ">
					<label class="control-label" for="tipoCert"><spring:theme
							code="mirit.certificacion.textImp" /></label>
					<form:select id="tipoCert" path="tipoCert"
						onchange="Hide(this.value);" cssClass="new_alto form-control">
						<form:option value="0">
							<spring:theme code="mirit.certificacion.opSeleccionar" />
						</form:option>
						<form:option value="1">
							<spring:theme code="mirit.certificacion.opImpuesto" />
						</form:option>
<%-- 						<form:option value="2"> --%>
<%-- 							<spring:theme code="mirit.certificacion.opSujeto" /> --%>
<%-- 						</form:option> --%>
					</form:select>
				</div>
			</div>
			</div>
			<div class="row">

			<div class="col-md-2">
				<button class="btn btn-primary btn-block" type="submit" id="botonGenerar">
					<spring:theme code="mirit.certificacion.btnGenerar" />
				</button>
			</div>
		</div>

		<br>


		<div class="row">
			<div id="myDIV" style="display: none">

				<div class="headline">
					<h2>
						<span tabindex="0"><spring:theme
								code="mirit.certificacion.tituloImpuesto" /></span>
					</h2>
				</div>

				<br>

				<div class=" col-md-4">
<%-- 					<c:if test="${uiMenuForm.bPredial == 'X'}"> --%>
<!-- 						<input type="radio" name="tipoImp" id="tipoImp" value="01" -->
<!-- 							style="visibility: visible" onclick="mostrarTabla('1')"> -->
<%-- 						<spring:theme code="mirit.certificacion.opPredial" /> --%>
<!-- 						<br> -->
<%-- 					</c:if> --%>

<%-- 					<c:if test="${uiMenuForm.bVehicular == 'X'}"> --%>
<!-- 						<input type="radio" name="tipoImp" id="tipoImp" value="02" -->
<!-- 							style="visibility: visible" onclick="mostrarTabla('2')"> -->
<%-- 						<spring:theme code="mirit.certificacion.opVehicular" /> --%>
<!-- 						<br> -->
<%-- 					</c:if> --%>

<%-- 					<c:if test="${uiMenuForm.bIca == 'X'}"> --%>
<!-- 						<input type="radio" name="tipoImp" id="tipoImp" value="03" -->
<!-- 							style="visibility: visible" onclick="mostrarTabla('3')"> -->
<%-- 						<spring:theme code="mirit.certificacion.opICA" /> --%>
<!-- 						<br> -->
<%-- 					</c:if> --%>

					<c:if test="${uiMenuForm.bPublicidadExt == 'X'}">
						<input type="radio" name="tipoImp" id="tipoImp" value="07"
							style="visibility: visible" onclick="mostrarTabla('7')">
						<spring:theme code="mirit.certificacion.opPublicidadExterior" />
						<br>
					</c:if>

					<c:if test="${uiMenuForm.bSobreGasolina == 'X'}">
						<input type="radio" name="tipoImp" id="tipoImp" value="05"
							style="visibility: visible" onclick="mostrarTabla('5')">
						<spring:theme code="mirit.certificacion.opSobretasaGasolina" />
						<br>
					</c:if>

<%-- 					<c:if test="${uiMenuForm.bDelineacionUrbana == 'X'}"> --%>
<!-- 						<input type="radio" name="tipoImp" id="tipoImp" value="06" -->
<!-- 							style="visibility: visible" onclick="mostrarTabla('6')"> -->
<%-- 						<spring:theme code="mirit.certificacion.opDelineaciónUrbana" /> --%>
<!-- 						<br> -->
<%-- 					</c:if> --%>
				</div>
			</div>
		</div>
	</form:form>
</div>

<div style="display: none;">
<button type="button" class="btn btn-primary btn-lg"
	id="ImprimirPopUp" name="ImprimirPopUp" value="ImprimirPopUp"
	style="margin-top: 3px" data-impuesto="" >
	<spring:theme code="obligacion.inicial.imprimir" />
</button>
</div>

<edoCuenta:edoCuentaImprimir mostrarBotonCertiRit="true" />


<script type="text/javascript">
function mostrarTabla(claveImpuesto){
	
	ACC.oblipend.llenarTablas_CertificacionDatos(claveImpuesto);
	
}

function generarCertiRit(numObjeto){

	$("#numObjeto").val(numObjeto);
	$("#botonGenerar").click();
	
}
</script>
