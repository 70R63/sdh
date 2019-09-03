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
				<div class="col-md-3" style="margin-top: 18px">
					<div class="form-check">
						<label class="form-check-label"
							style="text-transform: none; font-size: 14px; font-weight: 400;">
							<input type="checkbox" name="regimen" id="selectobligado"
							class="form-check-input mr-2"
							style="visibility: visible !important; min-height: 4px !important; margin-left: 12px;"
							onclick="habradio()"> <spring:theme
								code="ica.declaracion.firma.obligado" />
						</label>
					</div>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme code="" /></label> <input
							disabled id="" name="" class="form-control PEFirmInterFunct" disabled type="text"
							value="Declarante" maxlength="240" placeholder="Declarante" style="margin-top:4px">
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="publicidad.declaracion.firma.nombre" /></label> <input disabled id=""
																							 name="" class="form-control" disabled type="text" value="${customerData.completeName}"
																							 maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="publicidad.declaracion.firma.tipoiden" /></label> <input disabled id=""
																							   name="" class="form-control DeclaranteDT" disabled type="text" value="${customerData.documentType}"
																							   maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="publicidad.declaracion.firma.numide" /></label> <input disabled id=""
																							 name="" class="form-control DeclaranteDN" disabled type="text" value="${customerData.documentNumber}"
																							 maxlength="240"></input>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="publicidad.declaracion.firma.numtarjeta" /></label> <input disabled
																								 id="" name="" class="form-control" disabled type="text" value="${customerData.numBP}"
																								 maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-1">
					<label class="control-label"><spring:theme code="" /></label>
					<button type="button" onclick="firmButtonDeclaranteClicked(this);" class="btn btn-primary PEFirmButton" id="btnfirmardeclarante" style="margin-top:4px">Firmar</button>
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
				<label class="control-label"><spring:theme code="" /></label> <select
					class="form-control PEFirmInterFunct"
					style="font-size: 13px; padding: 0px; margin-top: 23px"
					onchange="internalFunctionSelected(this)" id="selectfirmante">
				<option value="">Seleccionar</option>
				<c:forEach items="${agentFunctionsMap}" var="eachFunction">

					<option value="${eachFunction.key}">${eachFunction.value}</option>

				</c:forEach>
			</select>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label " style="margin-top: 20px"><spring:theme
						code="publicidad.declaracion.firma.nombre" /></label> <select  id="selcnombre" onchange="nameSelected(this)"
																					   name="" class="form-control PEFirmSelectNombre"><option value="">Seleccionar</option></select>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label textocentrado" style="margin-top: 20px"><spring:theme
						code="publicidad.declaracion.firma.tipoiden" /></label> <input disabled id=""
																					   name="" class="form-control PEFirmTipoId" disabled type="text" value=""
																					   maxlength="240"></input>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label" style="margin-top: 20px"><spring:theme
						code="publicidad.declaracion.firma.numide" /></label> <input disabled id=""
																					 name="" class="form-control PEFirmNumId" disabled type="text" value=""
																					 maxlength="240"></input>
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label" style="margin-top: 20px"><spring:theme
						code="publicidad.declaracion.firma.numtarjeta" /></label> <input disabled id=""
																						 name="" class="form-control PEFirmTarjetaProf" disabled type="text" value=""
																						 maxlength="240"></input>
			</div>
		</div>

		<div class="col-md-1">
			<button type="button" onclick="firmButtonClicked(this);" disabled class="btn btn-primary ajustemargen PEFirmButton">Firmar</button>
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
			</sf:form>
		</div>
	</div>

	<%-- 			</form:form> --%>
</div>





<script>
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

			alert("No se pueden agregar m�s firmantes");

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

	function internalFunctionSelected(element) {
		var internalFunctionSelected = $(element).val();
		var nameSelect = $(element).closest(".representante").find(".PEFirmSelectNombre");
		if (internalFunctionSelected == "") {
			$(nameSelect).find('option').remove();
			var o = new Option("SELECCIONAR", "");
			/// jquerify the DOM object 'o' so we can use the html method
			$(o).html("SELECCIONAR");
			$(nameSelect).append(o);
			$(element).closest(".representante").find(".PEFirmTipoId").val("");
			$(element).closest(".representante").find(".PEFirmNumId").val("");
			$(element).closest(".representante").find(".PEFirmTarjetaProf").val("");
			return;
		} else {

			$.each(ACC.agentesFirmas[internalFunctionSelected], function (key, value) {
				var o = new Option(value.completeName, key);
				/// jquerify the DOM object 'o' so we can use the html method
				$(o).html(value.completeName);
				$(nameSelect).append(o);
			});


		}
	}

	function nameSelected(element){

		var nameSelected = $(element).val();

		if(nameSelected == "")
		{
			$(element).closest(".representante").find(".PEFirmTipoId").val("");
			$(element).closest(".representante").find(".PEFirmNumId").val("");
			$(element).closest(".representante").find(".PEFirmTarjetaProf").val("");
			return;
		}

		var internalFunctionSelected = $(element).closest(".representante").find(".PEFirmInterFunct").val();

		var documentNumber = ACC.agentesFirmas[internalFunctionSelected][nameSelected].documentNumber;

		var documentType = ACC.agentesFirmas[internalFunctionSelected][nameSelected].documentType;

		var tarjetaProf = ACC.agentesFirmas[internalFunctionSelected][nameSelected].bp;

		$(element).closest(".representante").find(".PEFirmTipoId").val(documentType);
		$(element).closest(".representante").find(".PEFirmNumId").val(documentNumber);
		$(element).closest(".representante").find(".PEFirmTarjetaProf").val(tarjetaProf);


	}

	function firmButtonDeclaranteClicked(element) {

		var numForm = $.trim($("#numForm").val());

		if(numForm == ""  )
		{
			$( "#dialogICA" ).dialog( "open" );
			$("#icaDialogContent").html("");
			$("#icaDialogContent").html("Debe realizar el calculo primero");

			return;
		}

		var firmantes =[];

		var declarante = {};

		declarante.tipoIdent = $(".DeclaranteDT").val();
		declarante.numIdentif =  $(".DeclaranteDN").val();
		declarante.firmante = "1";
		declarante.confirmacion = "x";

		firmantes.push(declarante);

		$.each($(".representante"), function( index, value ) {

			var representante = {};

			representante.tipoIdent = $(value).find(".PEFirmTipoId").val();
			representante.numIdentif =  $(value).find(".PEFirmNumId").val();
			representante.firmante = index+2;
			representante.confirmacion = "";

			if(representante.tipoIdent != "" && representante.numIdentif != "")
			{
				firmantes.push(representante);
			}
		});





		var data = {};



		data.numForm=numForm;
		data.firmantes =firmantes;

		$.ajax({
			url: ACC.gasolinaFirmar,
			data: JSON.stringify(data),
			type: "POST",
			dataType: "json",
			contentType: "application/json",
			success: function (data) {
				$( "#dialogICA" ).dialog( "open" );
				$("#icaDialogContent").html("");
				$.each(data.errores,function (index,value) {

					if(value.idmsj != "")
					{
						$("#icaDialogContent").html($("#icaDialogContent").html()+value.txtmsj+"<br>");
					}

				});

			},
			error: function () {
				$( "#dialogICA" ).dialog( "open" );
				$("#icaDialogContent").html("");
				$("#icaDialogContent").html("Hubo un error al intentar firmar la declaración, favor de intentarlo más tarde.")
			}
		});
	}

</script>