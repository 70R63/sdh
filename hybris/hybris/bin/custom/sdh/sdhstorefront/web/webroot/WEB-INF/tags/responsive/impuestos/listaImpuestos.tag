<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="jquery.min.js"></script>

<spring:htmlEscape defaultHtmlEscape="true" />
<c:url value="/contribuyentes/presentar-declaracion"
	var="presentarDeclaracionUrl"/>
<br>

<div class="container_new_page">
	<sf:form action="${presentarDeclaracionUrl}"
		method="POST" id="forma" commandName="dataForm">
		<c:if test="${mensajeDelinea != null}">
			<div class="row">
				<div class="col-12 notas_deli">
					<div class="alert alert-danger mt-3">
						<spring:theme code="${mensajeDelinea}" />
					</div>
				</div>
			</div>
		</c:if>

		<div class="row" id="notaVehPre" style="display: none">
			<div class="col-md-12"
				style="background: #d2d2d2; margin-top: 20px !important;">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.presentarDeclaracion.notaPredial" /></label>
				</div>
			</div>
		</div>
		<div class="row" id="notaOtros" style="display: none">
			<div class="col-md-12"
				style="background: #d2d2d2; margin-top: 20px !important;">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.presentarDeclaracion.notaOtros" /></label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-12 mb-20 no-marginright">
				<span class="paso--uno pasos color-sr1">1</span>
				<h2 class="titulo-caja--ser-rel color-sr1 label-control ">
					<spring:theme
						code="impuestos.presentarDeclaracion.PresentarDeclaracionUpper" />
				</h2>
				<p class="pasoClase1 metrophobic">Selecciona el impuesto que
					deseas consultar.</p>
				<div class="caja--ser-rel color-sr1">
					<div class="form-group ">
						<label class="control-label required"><spring:theme
								code="impuestos.presentarDeclaracion.impuesto" /></label>
						<sf:select path="impuesto" id="impuesto" items="${tpImpuesto}"
							referenceData="${dataForm.impuesto}"
							class="new_alto form-control" onchange="onChange()">
						</sf:select>
					</div>
				</div>
			</div>


			<div id="impuestoss" style="display: none;">
				<input value="${dataForm.optionPubliExt}" id="impuestoPE" />
			</div>
			<div id="impuestoss2" style="display: none;">
				<input value="${dataForm.optionGas}" id="impuestoGas" />
			</div>

			<input type="hidden" name="skipReques" value="" id="skipReques"/>
			<sf:hidden path="periodicidadImpuesto"/>

			<c:if test="${dataForm.impuesto != '3'}">
				<div class="col-md-4 col-xs-12 mb-20 no-margincol">
					<span class="paso--dos pasos color-sr2">2</span>
					<h2 class="titulo-caja--ser-rel color-sr2 ">
						<span class="paso2"><spring:theme
								code="impuestos.presentarDeclaracion.anioGravableConsultarUpper" /></span>
					</h2>
					<p class="pasoClase2 metrophobic">
						<spring:theme code="impuestos.presentarDeclaracion.seleccionaAnio" />
					</p>
					<div class="caja--ser-rel color-sr2">
						<div class="form-group ">
							<label class="control-label required"><spring:theme
									code="impuestos.presentarDeclaracion.anioGravableConsultar" /></label>

							<sf:select path="anoGravable" id="anoGravable"
								items="${dataForm.catalogosSo.anioGravable}"
								referenceData="${dataForm.catalogosSo.anioGravable}"
								class="newalto form-control" onchange="onChangeAnioGravable()" />
						</div>
					</div>
				</div>
			</c:if>

			<c:if test="${dataForm.impuesto == '3'}">
				<div class="col-md-4 col-xs-12 mb-20 no-margincol">
					<span class="paso--dos pasos color-sr2">2</span>
					<h2 class="titulo-caja--ser-rel color-sr2 ">
						<span class="paso2"><spring:theme
								code="impuestos.presentarDeclaracion.anioGravableConsultarUpper" /></span>
					</h2>
					<p class="pasoClase2 metrophobic">
						<spring:theme code="impuestos.presentarDeclaracion.seleccionaAnio" />
					</p>
					<div class="caja--ser-rel color-sr2">
						<div class="form-group ">
							<label class="control-label required"><spring:theme
									code="impuestos.presentarDeclaracion.anioGravableConsultar" /></label>


							<sf:select path="anoGravable" id="anoGravable"
								items="${icaAnioGravable}" referenceData="${icaAnioGravable}"
								class="newalto form-control" onchange="onChangeAnioGravable()" />
						</div>
					</div>
				</div>
			</c:if>

			<c:if
				test="${dataForm.impuesto ne '3' and dataForm.impuesto ne '4' and dataForm.impuesto ne '6' and dataForm.impuesto ne '2'}">

				<div class="col-md-4 col-xs-12 mb-20 no-marginleft"
					id="seccionPeriodo2">
					<span class="paso--tres pasos color-sr3 rajdhani">3</span>
					<h2 class="titulo-caja--ser-rel color-sr3 paso3">PERIODO</h2>
					<p class="pasoClase3 metrophobic">Selecciona el periodo.</p>
					<div class="caja--ser-rel color-sr3">
						<div class="form-group ">
							<label class="control-label required"><spring:theme
									code="impuestos.presentarDeclaracion.Periodo" /></label>



							<sf:select id="periodo" path="periodo"
								items="${dataForm.catalogosSo.periodo}"
								referenceData="${dataForm.catalogosSo.periodo}"
								class="newalto form-control" />
						</div>
					</div>
				</div>


			</c:if>

			<c:if test="${dataForm.impuesto == '3' and  isPeriodoAnual == false}">
				<div class="col-md-4 col-xs-12 mb-20 no-marginleft">
					<span class="paso--tres pasos color-sr3 rajdhani">3</span>
					<h2 class="titulo-caja--ser-rel color-sr3 paso3">PERIODO</h2>
					<p class="pasoClase3 metrophobic">Selecciona el periodo.</p>
					<div class="caja--ser-rel color-sr3">
						<div class="form-group ">
							<label class="control-label required"><spring:theme
									code="impuestos.presentarDeclaracion.Periodo" /></label>

							<sf:select id="periodo" path="periodo" items="${icaPeriodo}"
								referenceData="${icaPeriodo}" class="new_alto form-control" />
						</div>
					</div>
				</div>

			</c:if>
		</div>

		<!-- Jair Roa -New modification - opcionUso validation -->
		<c:if
			test="${dataForm.impuesto ne '4' and dataForm.impuesto ne ' ' and dataForm.impuesto ne '6'}">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-9 text-center">
					<sf:button type="submit"
						class="btn btn-primary btn-lg" id="action" name="action"
						onClick="validateForm();"
						value="presentarDeclaracion"
						style="margin-top: 15px">
						<spring:theme
							code="impuestos.presentarDeclaracion.PresentarDeclaracion" />
					</sf:button>

					<sf:button type="submit"
                        class="btn btn-primary btn-lg" id="actionHidden" name="action"
                    	value="presentarDeclaracion"
                    	style="display:none;">
                    	<spring:theme
                    	    code="impuestos.presentarDeclaracion.PresentarDeclaracion" />
                    	</sf:button>
				</div>
			</div>
		</c:if>

	</sf:form>
	<br>

	<c:if test="${not empty publicidadExtList}">
		<table id="myTable">
			<tr>
				<th>NUMERO DE RESOLUCION</th>
				<th>TIPO DE VALLA</th>
				<th>ACTION</th>
			</tr>
			<c:forEach var="item" items="${publicidadExtList}">
				<tr>
					<td><c:out value="${item.numResolu}" /></td>
					<td><c:out value="${item.tipoValla}" /></td>
					<td><c:set var="href"
							value="location.href = 'publicidadexterior/declaracion?numResolu=${item.numResolu}&anoGravable=${item.anoGravable}&tipoValla=${item.tipoVallaCode}';" />
						<button onclick="${href}" id="myButton"
							class="float-left submit-button">Generar</button></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<div class="col-12 notas_deli" id="notas_deli" style="display: none">
		<div class="alert alert-success mt-3">
			<strong><spring:theme code="impuestos.presentarDeclaracion.deliur.tituloNota1" /></strong>
			<spring:theme code="impuestos.presentarDeclaracion.deliur.nota1" />
		</div>
		<div class="alert alert-info mt-3">
			<strong><spring:theme code="impuestos.presentarDeclaracion.deliur.tituloNota2" /></strong>
			<spring:theme code="impuestos.presentarDeclaracion.deliur.nota2" />
		</div>
	</div>


	<c:out value="${dataFormDelineacion.valCont}" />

	<c:if test="${not empty delineacionWithRadicadosList}">
		<div class="col-md-9 col-md-offset-1">
			<br> <br>
			<div class="row">
				<div class="col-md-2">
					<label class="control-label" for="" style="text-transform: none">
						<spring:theme code="impuestos.presentarDeclaracion.deliur.cdu" />
					</label>
				</div>
				<div class="col-md-3">
					<label class="control-label" for="" style="text-transform: none">
						<spring:theme code="impuestos.presentarDeclaracion.deliur.tipobli" />
					</label>
				</div>
				<div class="col-md-3">
					<label class="control-label" for="" style="text-transform: none">
						<spring:theme code="impuestos.presentarDeclaracion.deliur.tiplic" />
					</label>
				</div>
				<div class="col-md-3">
					<label class="control-label" for="" style="text-transform: none">
						<spring:theme code="Evento" />
					</label>
				</div>
			</div>
			<div class="table-resposive">
				<c:forEach var="item" items="${delineacionWithRadicadosList}">
					<div class="row">
						<div class="col-sm-2">
							<input class="new_alto form-control" disabled="disabled"
								type="text" value="${item.cdu}"
								style="height: 32px !important; margin-bottom: 9px !important" />
						</div>
						<div class="col-sm-3">
							<select id="selctipobliga" class="newalto form-control"
								onchange="ShowSelected(this)">
								<option value="0-${item.cdu}">Seleccionar</option>
								<option value="1-${item.cdu}">Declaraci�n</option>
								<option value="2-${item.cdu}">Retenci�n</option>
							</select>
						</div>
						<div class="col-sm-3">
							<select id="btnTpLic_${item.cdu}" class="newalto form-control"
								onchange="establecerTipoLicencia(this)">
								<option value="00">Seleccionar</option>
								<option value="01">Licencia</option>
								<option value="02">Reconocimiento</option>
							</select>
						</div>
						<div class="col-sm-3">
							<form:form method="post" commandName="inputDelineacion"
								action="/sdhstorefront/es/contribuyentes/delineacion-urbana/declaracion">
								<c:set var="idCampoTipoLicencia"
									value='tipoLicenciaSeleccionada_${item.cdu}' />
								<form:hidden path="selectedCDU" value="${item.cdu}" />
								<form:hidden path="selectedRadicado" value="" />
								<form:hidden path="selectedTipoLicencia" value=""
									id="${idCampoTipoLicencia}" />
								<form:hidden path="selectedAnoPresDeclaracion" value="" />

								<button type="submit" class="btn-link" id="btn_${item.cdu}"
									name="action" value="declaracion">
									<spring:theme code="delineacion.urbana.radicados.declara" />
								</button>
							</form:form>
						</div>
					</div>
					<div class="row" id="${item.cdu}" style="display: none">
						<c:forEach var="radicado" items="${item.radicados}">
							<div class="row">
								<div class="col-sm-2"></div>
								<div class="col-sm-3 text-right">Radicados:</div>
								<div class="col-sm-3">
									<input style="margin-bottom: 5px !important"
										class="newalto form-control" disabled="disabled" type="text"
										value="${radicado.numRadicado}" />
								</div>
								<div class="col-sm-3">
									<form:form method="post" commandName="inputDelineacion"
										action="/sdhstorefront/es/contribuyentes/delineacion-urbana/declaracion">
										<form:hidden path="selectedCDU" value="${item.cdu}" />
										<form:hidden path="selectedRadicado"
											value="${radicado.numRadicado}" />
										<form:hidden path="selectedTipoLicencia" value="" />
										<form:hidden path="selectedAnoPresDeclaracion" value="" />

										<button type="submit" class="btn-link"
											id="retenciondelibutton1" name="action" value="retencion">
											<spring:theme
												code="delineacion.urbana.radicados.retencion.generar" />
										</button>
									</form:form>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
		</div>
	</c:if>

	<div class="row" id="table-vehicular" style="display: none;">
		<div class="col-md-6 col-md-offset-2">
			<table class="table" id="table-vehicular1">
				<thead style="cellspacing: 10 !important">
					<tr>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.placa" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.marca" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.linea" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.modelo" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.clase" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.carroceria" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.numpuertas" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.blindado" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.cilindraje" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.presndecla" /></label></th>
						<!-- 						<th style="text-align: center"><label class="control-label" -->
						<%-- 							for=""> <spring:theme --%>
						<%-- 									code="impuestos.presentarDeclaracion.PresentarDeclaracion" /></label></th> --%>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>

</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<!-- se agrega control para tablas de delineaci�n -->
<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;
		var selected = value.substring(0, 1);
		var div = value.substring(2, value.length);
		var x = document.getElementById(div);
		var tipoLicencia = document.getElementById("btnTpLic_" + div);
		var btnDeclaracion = document.getElementById("btn_" + div);

		if (selected === "2") {
			x.style.display = "block";
			tipoLicencia.selectedIndex = "1"
			tipoLicencia.disabled = true;
			btnDeclaracion.disabled = true;
		} else {
			x.style.display = "none";
			tipoLicencia.selectedIndex = "0"
			tipoLicencia.disabled = false;
			btnDeclaracion.disabled = false;
		}
	}

	function establecerTipoLicencia(selectObject) {
		var value = selectObject.value;
		var selected = selectObject.id;
		var div = selected.substring(9);
		div = "tipoLicenciaSeleccionada_" + div;
		var tipoLicencia = document.getElementById(div);
		tipoLicencia.value = value;

	}

	function validateForm() {
	    var anioGravable = document.getElementById("anoGravable").value;
	    var impuesto = document.getElementById("impuesto");
	    var periodo = "00";

        impuesto = impuesto.options[impuesto.selectedIndex].value;

        //Si - Sobretasa a la gasolina - obtener periodo
        if(impuesto == "5"){
            periodo = document.getElementById("periodo").value;
        }

        var currentUrl = window.location.href;
        var targetUrl = "infoObject/getUseOption?anioGravable="	+
        		    anioGravable + "&periodo=" +
        		    periodo + "&taxType=" + impuesto;
        currentUrl = currentUrl.replace("contribuyentes/presentar-declaracion",targetUrl);

        $.ajax({
            url : currentUrl,
        	type : "GET",
        	success : function(data) {
        	    var opcUso = data;
                if (impuesto == '5' && opcUso == '02') {//Sobretasa a la gasolina
                    promtConfirmation();
        		}else if(impuesto == '3' && opcUso == '02'){//ICA
        		    promtConfirmation();
        		} else {
                    return true;
                }
        	},
        	error : function() {
        	    alert("Error");
        	}
        });
	}

    function promtConfirmation(){
        var r = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
        if (r == true) {
            document.getElementById("actionHidden").click();
        } else {
            window.location.href = "presentar-declaracion";
        }
    }
</script>

