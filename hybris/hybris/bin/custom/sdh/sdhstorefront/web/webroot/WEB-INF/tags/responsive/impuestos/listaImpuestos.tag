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

			<c:if test="${dataForm.impuesto ne '4'}">
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


		<c:if test="${dataForm.impuesto ne '4' and dataForm.impuesto ne ' '}">
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

<c:if test="${dataForm.impuesto eq '4'}">
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

<!-- Se agrega tabla de CDU�s para delineaci�n -->
<!-- cambiar el n�mero 6 por el que corresponda a delineaci�n en caso de no ser este -->
<c:if test="${dataForm.impuesto eq '6'}">
	<div class="row">
		<div class="col-md-9 col-md-offset-1">
			<div class="table-resposive">
				<table class="table">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for="" style="text-transform: capitalize"><spring:theme
										code="impuestos.presentarDeclaracion.deliur.cdu" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for="" style="text-transform: capitalize"> <spring:theme
										code="impuestos.presentarDeclaracion.deliur.tipobli" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for="" style="text-transform: capitalize"> <spring:theme
										code="impuestos.presentarDeclaracion.deliur.tiplic" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for="" style="text-transform: capitalize"> <spring:theme
										code="" /></label></th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td><input style="width: 100%" class="inputtextnew"
								maxlength="30" size="30" disabled="disabled" type="text"
								value="<c:out value="CDU"></c:out>" /></td>
							<td><select id="selctipobliga" class="form-control"
								onchange="ShowSelected(this)">
									<option value="">Seleccionar</option>
									<option value="1">Declaraci�n</option>
									<option value="2">Retenci�n</option>
							</select></td>
							<td><select id="selectiplic" class="form-control"
								onchange="">
									<option value="">Seleccionar</option>
									<option value="1">Licencia</option>
									<option value="2">Reconocimiento</option>
							</select></td>
							<td><label class="control-label" for=""
								style="text-transform: capitalize; color: #0358d8 !important">
									<spring:theme
										code="impuestos.presentarDeclaracion.deliur.prendecla" />
							</label></td>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</c:if>

<!-- tabla de radicados para Delineaci�n -->
<br>
<div class="row" id="idRadicados" style="display: none;">
	<div class="row">
		<div class="col-md-3 col-md-offset-1">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="impuestos.presentarDeclaracion.deliur.cdu" /></label> <input
					style="" class="form-control" disabled="disabled" type="text"
					value="<c:out value="CDU"></c:out>" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5 col-md-offset-3">
			<div class="table-resposive">
				<table class="table">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for="" style="text-transform: capitalize"><spring:theme
										code="impuestos.presentarDeclaracion.deliur.radic" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for="" style="text-transform: capitalize"> <spring:theme
										code="" /></label></th>
						</tr>
					</thead>
					<tbody>

						<tr>

							<td><input style="width: 100%" class="inputtextnew"
								maxlength="30" size="30" disabled="disabled" type="text"
								value="<c:out value="RADICADOS"></c:out>" /></td>
							<td><label class="control-label" for=""
								style="text-transform: capitalize; color: #0358d8 !important">
									<spring:theme
										code="impuestos.presentarDeclaracion.deliur.prereten" />
							</label></td>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- se agrega control para tablas de delineaci�n -->
<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;
		var idLic = document.getElementById('selectiplic');
		var idrad = document.getElementById('idRadicados');
		if (value == '1') {
			idLic.disabled = false;
			idLic.selectedIndex = "";
			idrad.style.display = 'none';
		} else if (value == '2') {
			idLic.disabled = true;
			idLic.selectedIndex = "1";
			idrad.style.display = 'block';
		} else {
			idrad.style.display = 'none';
		}
	}
</script>

