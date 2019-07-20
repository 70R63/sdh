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


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/contribuyentes/presentar-declaracion"
	var="presentarDeclaracionUrl" htmlEscape="false" />

<br>


<div class="container_new_page">
	<sf:form action="presentar-declaracion?action=presentarDeclaracion"
		method="POST" modelAttribute="dataForm" id="forma">

		<div class="row">
			<div class="col-md-4 col-xs-12 mb-20 no-marginright">
				<span class="paso--uno pasos color-sr1">1</span>
				<h2 class="titulo-caja--ser-rel color-sr1 label-control">PRESENTAR
					DECLARACIÓN</h2>
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

			<input type="hidden" name="skipReques" value="" />

			<c:if test="${dataForm.impuesto != '3'}">
				<div class="col-md-4 col-xs-12 mb-20 no-margincol">
					<span class="paso--dos pasos color-sr2">2</span>
					<h2 class="titulo-caja--ser-rel color-sr2 ">
						<span class="paso2">AÑO GRAVABLE</span>
					</h2>
					<p class="pasoClase2 metrophobic">Selecciona el año gravable.</p>
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
						<span class="paso2">AÑO GRAVABLE</span>
					</h2>
					<p class="pasoClase2 metrophobic">Selecciona el año gravable.</p>
					<div class="caja--ser-rel color-sr2">
						<div class="form-group ">
							<label class="control-label required"><spring:theme
									code="impuestos.presentarDeclaracion.anioGravableConsultar" /></label>

							<sf:select path="anoGravable" items="${icaAnioGravable}"
								referenceData="${icaAnioGravable}" class="newalto form-control" onchange="onChangeAnioGravable()"/>
						</div>
					</div>
				</div>
			</c:if>

			<c:if
				test="${dataForm.impuesto ne '3' and dataForm.impuesto ne '4' and dataForm.impuesto ne '6'}">
				<div class="col-md-4 col-xs-12 mb-20 no-marginleft">
					<span class="paso--tres pasos color-sr3 rajdhani">3</span>
					<h2 class="titulo-caja--ser-rel color-sr3 paso3">PERIODO</h2>
					<p class="pasoClase3 metrophobic">Selecciona el periodo.</p>
					<div class="caja--ser-rel color-sr3">
						<div class="form-group ">
							<label class="control-label required"><spring:theme
									code="impuestos.presentarDeclaracion.Periodo" /></label>

							<sf:select path="periodo" items="${dataForm.catalogosSo.periodo}"
								referenceData="${dataForm.catalogosSo.periodo}"
								class="newalto form-control" />
						</div>
					</div>
				</div>
				<sf:select id="periodobk" path="periodo" items="${dataForm.catalogosSo.periodo}"
								referenceData="${dataForm.catalogosSo.periodo}"
								class="newalto form-control" style="visibility:hidden"/>
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

							<sf:select path="periodo" items="${icaPeriodo}"
								referenceData="${icaPeriodo}" class="new_alto form-control" />
						</div>
					</div>
				</div>
			</c:if>
			<sf:select id="periodobk" path="periodo" items="${icaPeriodo}"
			referenceData="${icaPeriodo}" class="new_alto form-control" style="visibility:hidden"/>
		</div>


		<c:if
			test="${dataForm.impuesto ne '4' and dataForm.impuesto ne ' ' and dataForm.impuesto ne '6'}">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-9 text-center">
					<sf:button action="${presentarDeclaracionUrl}" type="submit"
						class="btn btn-primary btn-lg" id="action" name="" value=""
						style="margin-top: 15px">
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
								<option value="1-${item.cdu}">Declaración</option>
								<option value="2-${item.cdu}">Retención</option>
							</select>
						</div>
						<div class="col-sm-3">
							<select id="btnTpLic_${item.cdu}" class="newalto form-control">
								<option value="00">Seleccionar</option>
								<option value="01">Licencia</option>
								<option value="02">Reconocimiento</option>
							</select>
						</div>
						<div class="col-sm-3">
							<form:form method="post" commandName="inputDelineacion"
								action="/sdhstorefront/es/contribuyentes/delineacion-urbana/declaracion">
								<form:hidden path="selectedCDU" value="${item.cdu}" />
								<form:hidden path="selectedRadicado" value="" />
								<form:hidden path="selectedTipoLicencia" value="" />
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

<!-- se agrega control para tablas de delineación -->
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
</script>

