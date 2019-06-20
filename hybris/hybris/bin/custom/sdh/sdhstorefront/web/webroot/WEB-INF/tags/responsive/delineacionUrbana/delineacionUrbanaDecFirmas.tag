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

<div class="container">
	<div class="row mt-3">
		<div class="col-md-12 mt-3">
			<div class="headline">
				<h2>
					<span><spring:theme code="ica.declaracion.firma.titulo" /></span>
				</h2>
			</div>
			<c:set var="tipoDescripcionID"
				value='${dataForm.valCont.infoContrib.tipoDoc}' />
			<c:set var="nombreCompleto"
				value='${dataForm.valCont.infoContrib.primNom} ${dataForm.valCont.infoContrib.primApe}' />

			<div class="row margin-bottom-4" style="margin-top: 18px">
				<div class="col-md-3" style="margin-top: 18px">
					<div class="form-check">
						<label class="form-check-label"
							style="text-transform: none; font-size: 14px; font-weight: 400;">
							<input type="checkbox" name="regimen" id="selectobligado"
							class="form-check-input mr-2"
							style="visibility: visible !important; min-height: 4px !important; margin-left: 12px;"
							onclick="habradio()"> <spring:theme
								code="delineacion.declaracion.firma.obligado" />
						</label>
					</div>
				</div>
				<div class="col-md-3">
					<select class="form-control selectfirmante"
						style="margin-top: 15px" disabled id="selectfirmante"
						onchange="habfirmante(this)"><option>Seleccionar</option>
						<option>Revisor</option>
						<option>Contador</option>
						<option>Representante</option></select>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-md-3">
					<div class="form-group">
						<input disabled id="" name="" class="form-control ajustemargen"
							disabled type="text" value="" maxlength="240"
							placeholder="Declarante">
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<label class="control-label textocentrado"><spring:theme
								code="delineacion.declaracion.firma.tipoiden" /></label> <input disabled id=""
							name="" class="form-control" disabled type="text"
							value="${tipoDescripcionID}" maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label margen20"><spring:theme
								code="delineacion.declaracion.firma.numide" /></label> <input disabled id=""
							name="" class="form-control" disabled type="text"
							value="${dataForm.valCont.infoContrib.numDoc}" maxlength="240"></input>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label  margen20"><spring:theme
								code="delineacion.declaracion.firma.numtarjeta" /></label> <input disabled
							id="" name="" class="form-control" disabled type="text" value=""
							maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label margen20"><spring:theme
								code="delineacion.declaracion.firma.nombre" /></label> <input disabled id=""
							name="" class="form-control" disabled type="text"
							value="${nombreCompleto}" maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-1">
					<button class="btn btn-primary ajustemargen"
						id="btnfirmardeclarante" disabled>Firmar</button>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container" id="repre">
	<div id="representante" class="row mt-3 representante"
		style="display: none">
		<div class="col-md-2">
			<div class="form-group">
				<input disabled id="replegal" name=""
					class="form-control replegal ajustemargen" disabled type="text"
					value="" maxlength="240" placeholder="Representante Legal">
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<label class="control-label"><spring:theme code="" /></label> <select
					class="form-control"
					style="font-size: 13px; padding: 0px; margin-top: 23px">
					<option>seleccionar</option>
				</select>
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<label class="control-label textocentrado"><spring:theme
						code="delineacion.declaracion.firma.tipoiden" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label" style="margin-top: 20px"><spring:theme
						code="delineacion.declaracion.firma.numide" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label" style="margin-top: 20px"><spring:theme
						code="delineacion.declaracion.firma.numtarjeta" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label " style="margin-top: 20px"><spring:theme
						code="delineacion.declaracion.firma.nombre" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-1">
			<button class="btn btn-primary ajustemargen">Firmar</button>
		</div>
		<div class="col-md-1">
			<div class="form-group ">
				<img onclick="fnaddFirmanteRep()"
					src="${themeResourcePath}/images/adddelineacion.png"
					style="width: 25px; margin-top: 55px;"></img> <img
					onclick="delerepre()"
					src="${themeResourcePath}/images/deledelineacion.png"
					style="width: 25px; margin-top: 55px;"></img>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div id="revisor" class="row mt-3 revisor" style="display: none">
		<div class="col-md-2">
			<div class="form-group">
				<input disabled id="" name="" class="form-control ajustemargen"
					disabled type="text" value="" maxlength="240" placeholder="Revisor">
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<label class="control-label"><spring:theme code="" /></label> <select
					class="form-control"
					style="font-size: 13px; padding: 0px; margin-top: 23px;">
					<option>seleccionar</option>
				</select>
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="delineacion.declaracion.firma.tipoiden" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label" style="margin-top: 20px"><spring:theme
						code="delineacion.declaracion.firma.numide" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label" style="margin-top: 20px"><spring:theme
						code="delineacion.declaracion.firma.numtarjeta" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label" style="margin-top: 20px"><spring:theme
						code="delineacion.declaracion.firma.nombre" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-1">
			<button class="btn btn-primary ajustemargen">Firmar</button>
		</div>
		<div class="col-md-1">
			<div class="form-group ">
				<img onclick="fnaddFirmanteRev()"
					src="${themeResourcePath}/images/adddelineacion.png"
					style="width: 25px; margin-top: 55px;"></img> <img
					onclick="delerevisor()"
					src="${themeResourcePath}/images/deledelineacion.png"
					style="width: 25px; margin-top: 55px;"></img>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div id="contador" class="row mt-3 contador" style="display: none">
		<div class="col-md-2">
			<div class="form-group">
				<input disabled id="" name="" class="form-control ajustemargen"
					disabled type="text" value="" maxlength="240"
					placeholder="Contador">
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<label class="control-label"><spring:theme code="" /></label> <select
					class="form-control"
					style="font-size: 13px; padding: 0px; margin-top: 23px;">
					<option>seleccionar</option>
				</select>
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="delineacion.declaracion.firma.tipoiden" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label" style="margin-top: 20px"><spring:theme
						code="delineacion.declaracion.firma.numide" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label" style="margin-top: 20px"><spring:theme
						code="delineacion.declaracion.firma.numtarjeta" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label" style="margin-top: 20px"><spring:theme
						code="delineacion.declaracion.firma.nombre" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-1">
			<button class="btn btn-primary ajustemargen">Firmar</button>
		</div>
		<div class="col-md-1">
			<div class="form-group ">
				<img onclick="fnaddFirmanteCont()"
					src="${themeResourcePath}/images/adddelineacion.png"
					style="width: 25px; margin-top: 55px;"></img> <img
					onclick="delecontador()"
					src="${themeResourcePath}/images/deledelineacion.png"
					style="width: 25px; margin-top: 55px;"></img>
			</div>
		</div>
	</div>
</div>



<br>
<div class="container">
	<div class="row ">
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
				<button id="duGeneraDeclaracionButton" type="button"
					<c:out value='${empty dataForm.infObjetoDelineacion.numForm ? "disabled":""}'/>
					class="btn btn-primary btn-lg" onclick="pagarlinea()">
					<spring:theme code="delineacion.urbana.dec.firm.predec" />
				</button>
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
			<div class="col-md-3">
				<sf:button class="btn btn-primary btn-lg" type="submit" id="action"
					name="pagar" value="pagar" disabled="true">
					<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
				</sf:button>
			</div>
		</sf:form>
	</div>
</div>


<div id="dialogDU" title="Delineación Urbana">
	<div id="duDialogContent"></div>
</div>

<script>
function goBack4() {
  window.history.back();
}
</script>




<script>
	function habradio() {
		var hobli = document.getElementById('selectobligado');
		var firmante = document.getElementById('selectfirmante');
		var firmdeclar = document.getElementById('btnfirmardeclarante');
		var btnpredec = document
				.getElementById('duGeneraDeclaracionButton');
		var repre = document.getElementById('representante');
		var rev = document.getElementById('revisor');
		var conta = document.getElementById('contador');
		var rep2 = document.getElementById('newrepresentante');
		var rev2 = document.getElementById('newrevisor');
		var conta2 = document.getElementById('newcontador');

		if (hobli.checked == true) {
			firmante.disabled = false;
			firmdeclar.disabled = false;
			btnpredec.disabled = true;

		} else if (conta2 != null && rep2 != null && rev2 != null) {
			firmante.disabled = true;
			firmdeclar.disabled = true;
			btnpredec.disabled = false;
			firmante.value = 'Seleccionar';
			rev.style.display = 'none';
			repre.style.display = 'none';
			conta.style.display = 'none';
			conta2.style.display = 'none';
			rep2.style.display = 'none';
			rev2.style.display = 'none';
		} else if (conta2 != null && rep2 != null) {
			firmante.disabled = true;
			firmdeclar.disabled = true;
			btnpredec.disabled = false;
			firmante.value = 'Seleccionar';
			rev.style.display = 'none';
			repre.style.display = 'none';
			conta.style.display = 'none';
			conta2.style.display = 'none';
			rep2.style.display = 'none';
		} else if (conta2 != null && rev2 != null) {
			firmante.disabled = true;
			firmdeclar.disabled = true;
			btnpredec.disabled = false;
			firmante.value = 'Seleccionar';
			rev.style.display = 'none';
			repre.style.display = 'none';
			conta.style.display = 'none';
			conta2.style.display = 'none';
			rev2.style.display = 'none';
		} else if (rev2 != null && rep2 != null) {
			firmante.disabled = true;
			firmdeclar.disabled = true;
			btnpredec.disabled = false;
			firmante.value = 'Seleccionar';
			rev.style.display = 'none';
			repre.style.display = 'none';
			conta.style.display = 'none';
			rep2.style.display = 'none';
			rev2.style.display = 'none';
		} else if ((rev2 != null)) {
			
			firmante.disabled = true;
			firmdeclar.disabled = true;
			btnpredec.disabled = false;
			firmante.value = 'Seleccionar';
			rev.style.display = 'none';
			repre.style.display = 'none';
			conta.style.display = 'none';
			rev2.style.display = 'none';
			

		} else if ((rep2 != null)) {
			firmante.disabled = true;
			firmdeclar.disabled = true;
			btnpredec.disabled = false;
			rev.style.display = 'none';
			repre.style.display = 'none';
			conta.style.display = 'none';
			rep2.style.display = 'none';
			firmante.value = 'Seleccionar';

		} else if ((conta2 != null)) {
			firmante.disabled = true;
			firmdeclar.disabled = true;
			btnpredec.disabled = false;
			rev.style.display = 'none';
			repre.style.display = 'none';
			conta.style.display = 'none';
			conta2.style.display = 'none';
			firmante.value = 'Seleccionar';

		} else {

			firmante.disabled = true;
			firmdeclar.disabled = true;
			btnpredec.disabled = false;
			rev.style.display = 'none';
			repre.style.display = 'none';
			conta.style.display = 'none';
			firmante.value = 'Seleccionar';

		}
	}

	function habfirmante(selectobject) {
		debugger;
		var valor = document.getElementById('selectfirmante').value;
		var firmante = document.getElementById('selectfirmante');
		var repre = document.getElementById('representante');
		var rev = document.getElementById('revisor');
		var conta = document.getElementById('contador');
		var rep2 = document.getElementById('newrepresentante');
		var rev2 = document.getElementById('newrevisor');
		var conta2 = document.getElementById('newcontador');

		if (valor == 'Representante') {
			if (conta2 != null && rep2 != null && rev2 != null) {
				rev.style.display = 'none';
				repre.style.display = 'block';
				conta.style.display = 'none';
				conta2.style.display = 'none';
				rep2.style.display = 'none';
				rev2.style.display = 'none';
			} else if (conta2 != null && rep2 != null) {
				rev.style.display = 'none';
				repre.style.display = 'block';
				conta.style.display = 'none';
				conta2.style.display = 'none';
				rep2.style.display = 'none';
			} else if (conta2 != null && rev2 != null) {
				rev.style.display = 'none';
				repre.style.display = 'block';
				conta.style.display = 'none';
				conta2.style.display = 'none';
				rev2.style.display = 'none';
			} else if (rev2 != null && rep2 != null) {
				rev.style.display = 'none';
				repre.style.display = 'block';
				conta.style.display = 'none';
				rep2.style.display = 'none';
				rev2.style.display = 'none';
			} else if (conta2 != null) {
				repre.style.display = 'block';
				rev.style.display = 'none';
				conta.style.display = 'none';
				conta2.style.display = 'none';
			} else if (rev2 != null) {
				repre.style.display = 'block';
				rev.style.display = 'none';
				conta.style.display = 'none';
				rev2.style.display = 'none';
			} else if (rep2 != null) {
				repre.style.display = 'block';
				rev.style.display = 'none';
				conta.style.display = 'none';
				rep2.style.display = 'none';
			} else {
				rev.style.display = 'none';
				repre.style.display = 'block';
				conta.style.display = 'none';
			}
		} else if (valor == 'Revisor') {
			if (conta2 != null && rep2 != null && rev2 != null) {
				rev.style.display = 'block';
				repre.style.display = 'none';
				conta.style.display = 'none';
				conta2.style.display = 'none';
				rep2.style.display = 'none';
				rev2.style.display = 'none';
			} else if (conta2 != null && rep2 != null) {
				rev.style.display = 'block';
				repre.style.display = 'none';
				conta.style.display = 'none';
				conta2.style.display = 'none';
				rep2.style.display = 'none';
			} else if (conta2 != null && rev2 != null) {
				rev.style.display = 'block';
				repre.style.display = 'none';
				conta.style.display = 'none';
				conta2.style.display = 'none';
				rev2.style.display = 'none';
			} else if (rev2 != null && rep2 != null) {
				rev.style.display = 'block';
				repre.style.display = 'none';
				conta.style.display = 'none';
				rep2.style.display = 'none';
				rev2.style.display = 'none';
			} else if (conta2 != null) {
				rev.style.display = 'block';
				repre.style.display = 'none';
				conta.style.display = 'none';
				conta2.style.display = 'none';
			} else if (rep2 != null) {
				rev.style.display = 'block';
				repre.style.display = 'none';
				conta.style.display = 'none';
				rep2.style.display = 'none';
			} else if (rev2 != null) {
				rev.style.display = 'block';
				repre.style.display = 'none';
				conta.style.display = 'none';
				rev2.style.display = 'none';
			} else {
				rev.style.display = 'block';
				repre.style.display = 'none';
				conta.style.display = 'none';
			}
		} else if (valor == 'Contador') {
			if (conta2 != null && rep2 != null && rev2 != null) {
				rev.style.display = 'none';
				repre.style.display = 'none';
				conta.style.display = 'block';
				conta2.style.display = 'none';
				rep2.style.display = 'none';
				rev2.style.display = 'none';
			} else if (conta2 != null && rep2 != null) {
				rev.style.display = 'none';
				repre.style.display = 'none';
				conta.style.display = 'block';
				conta2.style.display = 'none';
				rep2.style.display = 'none';
			} else if (conta2 != null && rev2 != null) {
				rev.style.display = 'none';
				repre.style.display = 'none';
				conta.style.display = 'block';
				conta2.style.display = 'none';
				rev2.style.display = 'none';
			} else if (rev2 != null && rep2 != null) {
				rev.style.display = 'none';
				repre.style.display = 'none';
				conta.style.display = 'block';
				rep2.style.display = 'none';
				rev2.style.display = 'none';
			} else if (conta2 != null) {

				rev.style.display = 'none';
				repre.style.display = 'none';
				conta.style.display = 'block';
				conta2.style.display = 'none';

			} else if (rep2 != null) {
				rev.style.display = 'none';
				repre.style.display = 'none';
				conta.style.display = 'block';
				rep2.style.display = 'none';

			} else if (rev2 != null) {
				rev.style.display = 'none';
				repre.style.display = 'none';
				conta.style.display = 'block';
				rev2.style.display = 'none';
			} else {
				rev.style.display = 'none';
				repre.style.display = 'none';
				conta.style.display = 'block';
			}

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

	function fnaddFirmanteRev() {
		var rev2 = document.getElementById('newrevisor');
		var tam = $(".revisor").length;
		if ($(".revisor").length < 2) {

			var clon = $(".revisor").clone();
			$(clon).attr('id', 'newrevisor'); //change cloned element id attribute

			$(clon).insertAfter(".revisor:last");

		} else if ($(".revisor").length == 2 && rev2.style.display == 'none') {

			rev2.style.display = 'block';

		} else {

			alert("No se pueden agregar más firmantes");

		}
	}

	function fnaddFirmanteCont() {
		var conta = document.getElementById('newcontador');

		var tam = $(".contador").length;
		if ($(".contador").length < 2) {

			var clon = $(".contador").clone();
			$(clon).attr('id', 'newcontador'); //change cloned element id attribute

			$(clon).insertAfter(".contador:last");

		} else if ($(".contador").length == 2 && conta.style.display == 'none') {

			conta.style.display = 'block';

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

	function delerevisor() {

		var i = $(".revisor").length;
		var val = i - 1;
		if ($(".revisor").length <= 2 && $(".revisor").length > 1) {

			$($(".revisor")[val]).closest($($(".revisor")[val]).remove());

		} else if ($(".representante").length <= 1) {
			alert("No puede eliminar todos los registros");
		}
	}

	function delecontador() {

		var i = $(".contador").length;
		var val = i - 1;
		if ($(".contador").length <= 2 && $(".contador").length > 1) {

			$($(".contador")[val]).closest($($(".contador")[val]).remove());

		} else if ($(".contador").length <= 1) {
			alert("No puede eliminar todos los registros");
		}
	}
</script>