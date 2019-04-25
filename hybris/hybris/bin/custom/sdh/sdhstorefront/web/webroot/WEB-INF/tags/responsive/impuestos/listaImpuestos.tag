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
<sf:form action="presentar-declaracion?action=presentarDeclaracion"
	method="POST" modelAttribute="dataForm" id="forma">
	<div class="col-md-10 col-md-offset-2">
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required"><spring:theme
							code="impuestos.presentarDeclaracion.impuesto" /></label>
					<sf:select path="impuesto" id="impuesto" items="${tpImpuesto}"
						referenceData="${dataForm.impuesto}" class="form-control"
						onchange="onChange()">
					</sf:select>
				</div>
			</div>


			<div id="impuestoss" style="display: none;">
				<input value="${dataForm.optionPubliExt}" id="impuestoPE" />
			</div>
			<div id="impuestoss2" style="display: none;">
				<input value="${dataForm.optionGas}" id="impuestoGas" />
			</div>

			<input type="hidden" name="skipReques" value="" />

			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required"><spring:theme
							code="impuestos.presentarDeclaracion.anioGravableConsultar" /></label>

					<sf:select path="anoGravable" id="anoGravable"
						items="${dataForm.catalogosSo.anioGravable}"
						referenceData="${dataForm.catalogosSo.anioGravable}"
						class="form-control" onchange="onChangeAnioGravable()" />
				</div>


			</div>

			<c:if test="${dataForm.impuesto ne '4' and dataForm.impuesto ne '6'}">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label required"><spring:theme
								code="impuestos.presentarDeclaracion.Periodo" /></label>

						<sf:select path="periodo" items="${dataForm.catalogosSo.periodo}"
							referenceData="${dataForm.catalogosSo.periodo}"
							class="form-control" />
					</div>
				</div>
			</c:if>
		</div>


		<c:if
			test="${dataForm.impuesto ne '4' and dataForm.impuesto ne ' ' and dataForm.impuesto ne '6'}">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-9 text-center">
					<sf:button action="${presentarDeclaracionUrl}" type="submit"
						class="btn btn-primary btn-lg" id="action" name="" value=""
						style="width: 187px !important">
						<spring:theme
							code="impuestos.presentarDeclaracion.PresentarDeclaracion" />
					</sf:button>
				</div>
			</div>
		</c:if>
	</div>
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

<c:if test="${not empty delineacionWithRadicadosList}">
	<div class="col-md-9 col-md-offset-1">
		<table class="table">
			<thead>
				<tr>
					<th style="text-align: center">
						<label class="control-label " for="" style="text-transform: capitalize">
							<spring:theme code="impuestos.presentarDeclaracion.deliur.cdu" />
						</label>
					</th>
					<th style="text-align: center"><label class="control-label"
						for="" style="text-transform: capitalize"> <spring:theme
								code="impuestos.presentarDeclaracion.deliur.tipobli" /></label></th>
					<th style="text-align: center"><label class="control-label"
						for="" style="text-transform: capitalize"> <spring:theme
								code="impuestos.presentarDeclaracion.deliur.tiplic" /></label></th>
					<th style="text-align: center"><label class="control-label"
						for="" style="text-transform: capitalize"> <spring:theme
								code="Evento" /></label></th>
				</tr>
			</thead>
		</table>
		<div class="table-resposive">
			<c:forEach var="item" items="${delineacionWithRadicadosList}">
				<div class="row">
					<div class="col-sm-3">
						<input style="width: 100%" class="inputtextnew"
							disabled="disabled" type="text" value="${item.cdu}" />
					</div>
					<div class="col-sm-3">
						<select id="selctipobliga" class="form-control"
							onchange="ShowSelected(this)">
							<option value="0-${item.cdu}">Seleccionar</option>
							<option value="1-${item.cdu}">Declaración</option>
							<option value="2-${item.cdu}">Retención</option>
						</select>
					</div>
					<div class="col-sm-3">
						<select id="selctipobliga" class="form-control"
							onchange="ShowSelected1(this)">
							<option value="0-${item.cdu}">Seleccionar</option>
							<option value="1-${item.cdu}">Declaración</option>
							<option value="2-${item.cdu}">Retención</option>
						</select>
					</div>
					<div class="col-sm-3">Presentar Declaracion</div>
				</div>
				<div class="row" id="${item.cdu}" style="display: none">
					<c:forEach var="radicado" items="${item.radicados}">
						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-3">Radicados:</div>
							<div class="col-sm-3">
								<input style="width: 100%" class="inputtextnew"
									disabled="disabled" type="text" value="${radicado.numRadicado}" />
							</div>
							<div class="col-sm-3">Presentar Retencion</div>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
	</div>
</c:if>










<!-- se agrega control para tablas de delineación -->
<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;
		var selected = value.substring(0, 1);
		var div = value.substring(2, value.length);
		var x = document.getElementById(div);

		if (selected === "2") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>

