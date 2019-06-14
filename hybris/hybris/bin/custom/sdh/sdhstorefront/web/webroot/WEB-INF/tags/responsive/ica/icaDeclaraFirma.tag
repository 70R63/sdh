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

			<%-- 			<form:form action=""> --%>
			<div class="row margin-bottom-4" style="margin-top: 18px">
				<div class="col-md-6" style="margin-top: 18px">
					<div class="form-check">
						<label class="form-check-label"
							style="text-transform: none; font-size: 14px; font-weight: 400;">
							<input type="checkbox" name="regimen" id="selectobligado"
							class="form-check-input mr-2"
							style="visibility: visible !important; min-height: 4px !important; margin-left: 12px;"
							onclick="habradio()"> <spring:theme
								code="ica.declaracion.firma.obligado" />
						</label> <label class="form-check-label"
							style="text-transform: none; font-size: 14px; font-weight: 400;">
							<input onclick="show()" type="radio" name="firma"
							id="radiorevisor" class="form-check-input mr-2"
							style="visibility: visible !important; min-height: 4px !important; margin-left: 12px;"
							disabled> <spring:theme
								code="ica.declaracion.firma.revisor" />
						</label> <label class="form-check-label"
							style="text-transform: none; font-size: 14px; font-weight: 400;">
							<input onclick="show2()" type="radio" name="firma"
							id="radiorepresentante" class="form-check-input mr-2"
							style="visibility: visible !important; min-height: 4px !important; margin-left: 12px"
							disabled> <spring:theme
								code="ica.declaracion.firma.replegal" />
						</label>
					</div>
				</div>
				<div class="col-md-4">
					<button id="addFirmante" class="btn btn-primary"
						style="font-size: 14px" disabled onclick="fnaddFirmante()">Agregar
						otro firmante</button>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-md-3">
					<div class="form-group">
						<input disabled id="" name="" class="form-control" disabled
							type="text" value="" maxlength="240" placeholder="Declarante"
							style="margin-top: 26px;">
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="ica.declaracion.firma.tipoiden" /></label> <input disabled id=""
							name="" class="form-control" disabled type="text" value=""
							maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="ica.declaracion.firma.numide" /></label> <input disabled id=""
							name="" class="form-control" disabled type="text" value=""
							maxlength="240"></input>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="ica.declaracion.firma.numtarjeta" /></label> <input disabled
							id="" name="" class="form-control" disabled type="text" value=""
							maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="ica.declaracion.firma.nombre" /></label> <input disabled id=""
							name="" class="form-control" disabled type="text" value=""
							maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-1">
					<button class="btn btn-primary" style="margin-top: 26px">Firmar</button>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div id="representante" class="row mt-3 representante"
		style="display: none">
		<div class="col-md-2">
			<div class="form-group">
				<input disabled id="replegal" name="" class="form-control replegal"
					disabled type="text" value="" maxlength="240"
					placeholder="Representante Legal" style="margin-top: 26px;">
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<label class="control-label"><spring:theme code="" /></label> <select
					class="form-control"
					style="font-size: 13px; padding: 0px; margin-top: 5px;">
					<option>seleccionar</option>
				</select>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="ica.declaracion.firma.tipoiden" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="ica.declaracion.firma.numide" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="ica.declaracion.firma.numtarjeta" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="ica.declaracion.firma.nombre" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-1">
			<button class="btn btn-primary" style="margin-top: 26px;">Firmar</button>
		</div>
	</div>
</div>
<div class="container">
	<div id="revisor" class="row mt-3 revisor" style="display: none">
		<div class="col-md-2">
			<div class="form-group">
				<input disabled id="" name="" class="form-control" disabled
					type="text" value="" maxlength="240" placeholder="Revisor/Contador"
					style="margin-top: 26px;"> </input>
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<label class="control-label"><spring:theme code="" /></label> <select
					class="form-control"
					style="font-size: 13px; padding: 0px; margin-top: 5px;">
					<option>seleccionar</option>
				</select>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="ica.declaracion.firma.tipoiden" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="ica.declaracion.firma.numide" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="ica.declaracion.firma.numtarjeta" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="ica.declaracion.firma.nombre" /></label> <input disabled id=""
					name="" class="form-control" disabled type="text" value=""
					maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-1">
			<button class="btn btn-primary" style="margin-top: 26px;">Firmar</button>
		</div>
	</div>
</div>
<div class="container">
	<input type="hidden" id="numObjeto" name="numObjeto"
		value="${numObjeto}" /> <input type="hidden" id="numForm"
		name="numForm"
		value="${icaInfObjetoFormResp.icaInfObjetoResponse.numForm }" /> <a
		id="downloadHelper" target="_blank"></a>
	<div class="row" style="marging-top: 5px">
		<div class="col-md-12 centercol-md-8 text-center">

			<sf:form action="${pagarURL}" method="POST"
				modelAttribute="infoPreviaPSE" id="infoPreviaPSE">
				<button style="margin-top: 3px;" id="regresar"
					class="btn btn-secondary btn-lg" onclick="goBack()" type="button">
					<spring:theme code="ica.declaracion.firma.regresar" />
				</button>
				<c:choose>
					<c:when
						test="${not empty icaInfObjetoFormResp.icaInfObjetoResponse.numForm }">
						<button style="margin-top: 3px;"
							id="icaPresentarDeclaracionButton" class="btn btn-primary btn-lg"
							type="button">
							<spring:theme code="ica.declaracion.firma.prendecla" />
						</button>
					</c:when>
					<c:otherwise>
						<button style="margin-top: 3px;"
							id="icaPresentarDeclaracionButton" class="btn btn-primary btn-lg"
							type="button">
							<spring:theme code="ica.declaracion.firma.prendecla" />
						</button>
					</c:otherwise>
				</c:choose>

				<sf:hidden path="tipoImpuesto" />
				<sf:hidden path="numBP" />
				<sf:hidden path="numDoc" />
				<sf:hidden path="tipoDoc" />
				<sf:hidden path="anoGravable" />
				<sf:hidden path="periodo" />
				<sf:hidden path="clavePeriodo" />
				<sf:hidden path="dv" />
				<sf:hidden path="numObjeto" />

				<sf:button class="btn btn-primary btn-lg" type="submit" id="action"
					name="pagar" value="pagar">
					<spring:theme code="ica.declaracion.firma.pagliena" />
				</sf:button>


				<!-- 						<button style="margin-top: 3px;" id="" -->
				<!-- 							class="btn btn-primary btn-lg" type="button"> -->
				<%-- 							<spring:theme code="ica.declaracion.firma.pagliena" /> --%>
				<!-- 						</button> -->
			</sf:form>
		</div>
	</div>

	<%-- 			</form:form> --%>
</div>





<script>
	function habradio() {
		debugger;
		var hrep = document.getElementById('radiorepresentante');
		var hrev = document.getElementById('radiorevisor');
		var hobli = document.getElementById('selectobligado');
		var rep = document.getElementById('representante');
		var rev = document.getElementById('revisor');
		var firman = document.getElementById('addFirmante');
		var rep2 = document.getElementById('newrepresentante');
		var rev2 = document.getElementById('newrevisor');
		var btnpredec = document
				.getElementById('icaPresentarDeclaracionButton');

		if (hobli.checked == true) {
			hrep.disabled = false;
			hrev.disabled = false;
			btnpredec.disabled = true;

		} else if ((rep2 == null) && (rev2 == null)) {
			hrep.disabled = true;
			hrev.disabled = true;
			hrep.checked = false;
			hrev.checked = false;
			firman.disabled = true;
			rev.style.display = 'none';
			rep.style.display = 'none';
			btnpredec.disabled = false;
		} else if (rep2 == null) {

			hrep.disabled = true;
			hrev.disabled = true;
			hrep.checked = false;
			hrev.checked = false;
			firman.disabled = true;
			rev.style.display = 'none';
			rep.style.display = 'none';
			rev2.style.display = 'none';
			btnpredec.disabled = false;

		} else if (rev2 == null) {

			hrep.disabled = true;
			hrev.disabled = true;
			hrep.checked = false;
			hrev.checked = false;
			firman.disabled = true;
			rev.style.display = 'none';
			rep.style.display = 'none';
			rep2.style.display = 'none';
			btnpredec.disabled = false;

		} else if ((rep2 != null) && (rev2 != null)) {

			hrep.disabled = true;
			hrev.disabled = true;
			hrep.checked = false;
			hrev.checked = false;
			firman.disabled = true;
			rev.style.display = 'none';
			rep.style.display = 'none';
			rep2.style.display = 'none';
			rev2.style.display = 'none';
			btnpredec.disabled = false;
		}
	}

	function show() {
		var rep = document.getElementById('representante');
		var rev = document.getElementById('revisor');
		var firman = document.getElementById('addFirmante');
		var rep2 = document.getElementById('newrepresentante');
		var rev2 = document.getElementById('newrevisor');

		if (rep2 == null) {
			rep.style.display = 'none';
			rev.style.display = 'block';
			firman.disabled = false;

		} else if (rep2 != null && rev2 != null) {

			rep.style.display = 'none';
			rev.style.display = 'block';
			rep2.style.display = 'none';
			firman.disabled = false;

		} else {

			rep.style.display = 'none';
			rep2.style.display = 'none';
			rev.style.display = 'block';
			firman.disabled = false;

		}

	}

	function show2() {
		var rep = document.getElementById('representante');
		var rev = document.getElementById('revisor');
		var firman = document.getElementById('addFirmante');
		var rep2 = document.getElementById('newrepresentante');
		var rev2 = document.getElementById('newrevisor');

		if (rev2 == null) {
			rep.style.display = 'block';
			rev.style.display = 'none';
			firman.disabled = false;

		} else if (rep2 != null && rev2 != null) {

			rep.style.display = 'block';
			rev.style.display = 'none';
			rev2.style.display = 'none';
			firman.disabled = false;

		} else {

			rep.style.display = 'block';
			rev2.style.display = 'none';
			rev.style.display = 'none';
			firman.disabled = false;

		}
	}

	function fnaddFirmante() {
		var hrep = document.getElementById('radiorepresentante');
		var hrev = document.getElementById('radiorevisor');
		var rep2 = document.getElementById('newrepresentante');
		var rev2 = document.getElementById('newrevisor');

		if (hrep.checked == true) {
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

		if (hrev.checked == true) {
			var tam = $(".revisor").length;
			if ($(".revisor").length < 2) {

				var clon = $(".revisor").clone();
				$(clon).attr('id', 'newrevisor'); //change cloned element id attribute

				$(clon).insertAfter(".revisor:last");

			} else if ($(".revisor").length == 2
					&& rev2.style.display == 'none') {

				rev2.style.display = 'block';

			} else {

				alert("No se pueden agregar más firmantes");

			}
		}

	}
</script>