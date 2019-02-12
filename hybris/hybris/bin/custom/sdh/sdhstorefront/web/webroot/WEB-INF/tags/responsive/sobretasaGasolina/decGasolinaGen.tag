<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<div class="headline">
			<h3>
				<span tabindex="0"> <spring:theme
						code="impuestos.decGasolina.DatosGenerales.titulo" />
				</span>
			</h3>
		</div>
	</div>
</div>

<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
	<div class="row">
		<div class="col-md-2">
			<label class="control-label"><spring:theme
					code="impuestos.decGasolina.DatosGenerales.anioGravableConsultar" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<select class="form-control"></select>
			</div>
		</div>
		<div class="col-md-2">
			<label class="control-label"><spring:theme
					code="impuestos.decGasolina.DatosGenerales.Periodo" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<select class="form-control"></select>
			</div>
		</div>
	</div>
	<br>

	<div class="row">
		<div class="col-md-2">
			<label class="control-label"><spring:theme
					code="impuestos.decGasolina.DatosGenerales.numeroIdentificacion" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input value="${dataForm.numDoc}"
					class="form-control form-control" maxlength="30" size="20" disabled="disabled"></input>
				<!-- 				<input id="numeroId" name="numeroId" class="form-control form-control" -->
				<!-- 					aria-required="true" type="text" value="" maxlength="240"> -->
			</div>
		</div>
		<div class="col-md-2">
			<label class="control-label"><spring:theme
					code="impuestos.decGasolina.DatosGenerales.OpcionesUso" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<select class="form-control"></select>
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-md-6">
			<div class="hieadline">
				<h2>
					<span tabindex="0"><spring:theme
							code="impuestos.decGasolina.InformacionDec.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>

	<div class="col-md-10">
		<table class="table col-md-12">
			<thead>
				<tr>
					<td><label class="col-md-2 control-label"><spring:theme
								code="impuestos.decGasolina.InformacionDec.claseProducto" /></label></td>
					<td><label class="col-md-2 col-md-offset-1 control-label"><spring:theme
								code="impuestos.decGasolina.InformacionDec.galones" /></label></td>
					<td><label class="col-md-3  control-label"><spring:theme
								code="impuestos.decGasolina.InformacionDec.preciosReferencia" /></label></td>
					<td><label class="col-md-2 control-label"><spring:theme
								code="impuestos.decGasolina.InformacionDec.porcentajeAlcohol" /></label></td>
					<td><label class="col-md-3 control-label"><spring:theme
								code="impuestos.decGasolina.InformacionDec.baseGravable" /></label></td>
					<td><label class="col-md-2 control-label"><spring:theme
								code="impuestos.decGasolina.InformacionDec.valorSobretasa" /></label></td>
				</tr>
				<tr></tr>
			</thead>
			<tbody>
				<c:forEach items="${dataForm.dataForm.infoDeclara}" var="info"
					varStatus="loop">
					<tr>
						<td><div class="col-md-1">
								<sf:select path="dataForm.infoDeclara[${loop.index}].claseProd"
									items="${dataForm.catalogosSo.claseProd}"
									referenceData="${dataForm.catalogosSo.claseProd}"
									class="form-control" />
							</div></td>
						<td><div class="col-md-1 col-md-offset-8">
								<sf:input path="dataForm.infoDeclara[${loop.index}].galonesGra"
									value="${info.galonesGra}" class="form-control form-control"
									maxlength="30" size="20" />
							</div></td>
						<td><div class="col-md-1 col-md-offset-4">
								<sf:input path="dataForm.infoDeclara[${loop.index}].precioRef"
									value="${info.precioRef}" class="form-control form-control"
									maxlength="30" size="20" readonly="true" />
							</div></td>
						<td><div class="col-sm-12">
								<sf:select
									path="dataForm.infoDeclara[${loop.index}].alcoholCarbu"
									items="${dataForm.catalogosSo.alcoholCarbu}"
									referenceData="${dataForm.catalogosSo.alcoholCarbu}"
									class="form-control" />
							</div></td>
						<td><div class="col-md-1 col-md-offset-2">
								<sf:input
									path="dataForm.infoDeclara[${loop.index}].baseGravable"
									value="${info.baseGravable}" class="form-control form-control"
									maxlength="30" size="20" readonly="true" />
							</div></td>
						<td><div class="col-md-1">
								<sf:input
									path="dataForm.infoDeclara[${loop.index}].vlrSobretasa"
									value="${info.vlrSobretasa}" class="form-control form-control"
									maxlength="30" size="20" readonly="true" />
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<br />
	<br />

	<div class="form-group ">
		<sf:button action="${presentarDeclaracionUrl}" type="submit"
			class="btn btn-primary btn-lg" id="action"
			name="action" value="calcular">
			<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" />
		</sf:button>

		<!-- 		<button id="presentarDeclaracionUrl" type="submit" -->
		<!-- 			class="btn btn-primary btn-block"> -->
		<%-- 			<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" /> --%>
		<!-- 		</button> -->


		<!-- 	<button class="btn btn-primary btn-block" type="button"> -->
		<%-- 		<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" /> --%>
		<!-- 	</button> -->
	</div>



</sf:form>

