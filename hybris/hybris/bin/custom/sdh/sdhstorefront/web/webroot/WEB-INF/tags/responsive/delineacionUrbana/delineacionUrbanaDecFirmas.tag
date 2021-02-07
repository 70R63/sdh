<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL"
	htmlEscape="false" />

<c:set var="flagPresentarDeclaracion" value="false" />
<c:set var="flagPagarEnLinea" value="false" />
<c:if test="${dataForm.controlCampos.btnPresentarDec == false}">
	<c:set var="flagPresentarDeclaracion" value="true" />
</c:if>
<c:if test="${dataForm.controlCampos.btnPagarDec == false}">
	<c:set var="flagPagarEnLinea" value="true" />
</c:if>
<c:if test="${contribuyente.documentType ne 'NIT' and contribuyente.numBP eq currentUser.numBP }">
	<c:set var="flagPresentarDeclaracion" value="true" />
	<c:set var="flagPagarEnLinea" value="true" />
	<input type="hidden" value="X" id="contribuyenteNoNIT"/>
</c:if>
<br>
<div class="container">
	<div class="row ">
		<input type="hidden" id="numForm" value="${dataForm.infObjetoDelineacion.numForm}">
		<sf:form action="${pagarURL}" method="POST"
			modelAttribute="infoPreviaPSE" id="infoPreviaPSE">

			<div class=" col-md-3">
				<button type="button" class="btn btn-secondary btn-lg"
					id="regresarButton" name="" value="regresar" onclick="goBack4()">
					<spring:theme code="delineacion.urbana.dec.firm.regresar" />
				</button>
			</div>

			<div class=" col-md-3">
				<button type="button" class="btn btn-primary btn-lg" id="" name=""
					value=""
					onclick="window.location.href ='<c:url value='/contribuyentes' />';">
					<spring:theme code="delineacion.urbana.dec.firm.cancelar" />
				</button>
			</div>

			<div class="col-md-3">
				<a id="downloadHelper" target="_blank"></a>
				<c:if test="${flagPresentarDeclaracion eq true}">
				<button id="duGeneraDeclaracionButton" type="button" class="btn btn-primary btn-lg GeneraDeclaracionButton" onclick="pagarlinea()" disabled="disabled">
					<!--<c:out value='${empty dataForm.infObjetoDelineacion.numForm ? "disabled":""}'/>
					class="btn btn-primary btn-lg" onclick="pagarlinea()">  Se comenta linea para habilitar botón 19/12/2019 Maria Torres-->
					<spring:theme code="delineacion.urbana.dec.firm.predec" />
				</button>
				</c:if>
			</div>

			<sf:hidden path="tipoImpuesto" />
			<sf:hidden path="numBP" />
			<sf:hidden path="numDoc" />
			<sf:hidden path="tipoDoc" />
			<sf:hidden path="anoGravable" />
			<sf:hidden path="periodo" />
			<sf:hidden path="clavePeriodo" />
			<sf:hidden path="dv" />
			<sf:hidden path="numObjeto" />
			<sf:hidden path="CDU" />
			<sf:hidden path="anticipo" />
			<sf:hidden path="cdu" />

			<div class="col-md-3">
				<c:if test="${flagPagarEnLinea eq true}">
				<sf:button class="btn btn-primary btn-lg pagarbtn" type="button"
					id="action" name="pagar" value="pagar" disabled="true" onclick="validaBotonPago()">
					<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
				</sf:button>
				</c:if>
			</div>
		</sf:form>
	</div>
</div>


<div id="dialogDU" title="Delineación Urbana">
	<div id="duDialogContent"></div>
</div>

<script>

function validaBotonPago(){
	debugger;
	var totPagar = document.getElementById('totalPagar');
	var negativePos = totPagar.value.search("-");
	if(totPagar.value == '0' || totPagar.value == '0.00' || negativePos >= 0 ){
		alert('El total a pagar debe ser mayor a 0')
	}else{
		var form1 = document.getElementById('infoPreviaPSE');
		form1.submit();		
	}
	
}

function goBack4() {
  window.history.back();
}


function habradio() {
	debugger;
	var hobli = document.getElementById('selectobligado');
	var firmdeclar = document.getElementById('btnfirmardeclarante');
	var btnpredec = document
			.getElementById('duGeneraDeclaracionButton');
	var repre = document.getElementById('representante');
	var rep2 = document.getElementById('newrepresentante');
	var selc = document.getElementById('selectfirmante');
	var selcnom = document.getElementById('selcnombre');

	if (hobli.checked == true) {
		firmdeclar.disabled = false;
		btnpredec.disabled = true;
		repre.style.display = 'block';

	} else if ((rep2 != null)) {

		firmdeclar.disabled = false;
		btnpredec.disabled = false;
		repre.style.display = 'none';
		rep2.style.display = 'none';
		selc.value="Seleccionar";
		selcnom.value="Seleccionar"

	} else {

		firmdeclar.disabled = false;
		btnpredec.disabled = false;
		repre.style.display = 'none';
		selc.value="Seleccionar";
		selcnom.value="Seleccionar"

	}
}

function fnaddFirmanteRep() {
	var rep2 = document.getElementById('newrepresentante');

	var tam = $(".representante").length;

	if ($(".representante").length < 2) {

		var clon = $(".representante:first").clone();
		$(clon).attr('id', 'newrepresentante'); //change cloned element id attribute
		$(clon).insertAfter(".representante:last");

	} else if ($(".representante").length == 2
			&& rep2.style.display == 'none') {

		rep2.style.display = 'block';

	} else {

		alert("No se pueden agregar más firmantes");

	}
}

function delerepre() {

	var i = $(".representante").length;
	var val = i - 1;
	if ($(".representante").length <= 2 && $(".representante").length > 1) {

		$($(".representante")[val]).closest(
				$($(".representante")[val]).remove());

	} else if ($(".representante").length <= 1) {
		alert("No puede eliminar todos los registros");
	}
}
</script>