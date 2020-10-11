<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL" htmlEscape="false" />


<c:set var="flagPresentarDeclaracion" value="false" />
<c:set var="flagPagarEnLinea" value="false" />
<c:if test="${vehiculosFormDeclaracion.controlCampos.btnPresentarDec == false}">
	<c:set var="flagPresentarDeclaracion" value="true" />
</c:if>
<c:if test="${vehiculosFormDeclaracion.controlCampos.btnPagarDec == false}">
	<c:set var="flagPagarEnLinea" value="true" />
</c:if>
<c:if test="${contribuyente.documentType ne 'NIT' and contribuyente.numBP eq currentUser.numBP }">
	<c:set var="flagPresentarDeclaracion" value="true" />
	<c:set var="flagPagarEnLinea" value="true" />
	<input type="hidden" value="X" id="contribuyenteNoNIT"/>
</c:if>
<div class="container">
	

	<div class="row" style="marging-top: 5px">

		<div class="col-md-12 centercol-md-8 text-center">
			

			<sf:form action="${pagarURL}" method="POST" modelAttribute="infoPreviaPSE" id="infoPreviaPSE">
			<div class="col-md-1">
				<button style="margin-top: 3px;" id="regresar"
					class="btn btn-secondary btn-lg" onclick="goBack()" type="button">
					<spring:theme code="vehiculos.declaracion.firma.regresar" />
				</button>
			</div>

				<div class="col-md-3">
					<a id="downloadHelper" target="_blank"></a>
					<c:if test="${flagPresentarDeclaracion eq true}">
					<button id="generaDeclaracionVehiculosButton" type="button" class="btn btn-primary btn-lg" onclick="pagarlinea()">
					<!-- 	<c:out value='${empty vehiculosFormDeclaracion.numForm ? "disabled":""}'/>
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
				<sf:hidden path="placa" />
				
				<div class="col-md-3">
					<c:if test="${flagPagarEnLinea eq true}">
					<sf:button class="btn btn-primary btn-lg pagarbtn" type="button" onclick="validaBotonPago()" id="action"
						name="pagar" value="pagar" disabled="true">
						<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
					</sf:button>
					</c:if>
				</div>
			</sf:form>
			<div class="col-md-1">
				<button class="btn btn-primary btn-lg btnspac" type="button" id="btnspac"
					data-numForm="${vehiculosFormDeclaracion.numForm}" 
					data-anio="${vehiculosFormDeclaracion.anioGravable}" 
					data-obj="${vehiculosFormDeclaracion.objetoCont}" 
					data-reimpresion="">
					<spring:theme code="predialuno.firma.spac" />
				</button>
			</div>	

		</div>
	</div>
	<div class="col-md-6" id="tableSpac" style="visibility:hidden;">
		<br><br>
		<table class="table tableSpacPago" id="tableSpacPago">
			<thead>
				<tr>
					<th><label class="control-label labeltabletd tableident"><spring:theme
						code="spac.table.cuotas" /></label></th>
					<th><label class="control-label labeltabletd"><spring:theme
						code="spac.table.pagar" /></label></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</div>

<script>

	function validaBotonPago(){
		debugger;
		var totPagar = document.getElementById('totpag');
		if(totPagar.value == '0'){
			alert('El total a pagar debe ser mayor a 0');
		var btnPagar = document.getElementById("action");
		btnPagar.disabled = true;
		}else{
			var form1 = document.getElementById('infoPreviaPSE');
			form1.submit();		
		}
		
	}

	function habradio() {
		debugger;
		var hobli = document.getElementById('selectobligado');
		var firmdeclar = document.getElementById('btnfirmardeclarante');
		var btnpredec = document
				.getElementById('icaPresentarDeclaracionButton');
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
