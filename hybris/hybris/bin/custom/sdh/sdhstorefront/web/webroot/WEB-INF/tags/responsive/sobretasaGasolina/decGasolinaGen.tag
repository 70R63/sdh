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
			<h2>
				<span tabindex="0"> <spring:theme
						code="impuestos.decGasolina.DatosGenerales.titulo" />
				</span>
			</h2>
		</div>
	</div>
</div>

<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="impuestos.decGasolina.DatosGenerales.anioGravableConsultar" /></label>
				<sf:select path="anoGravable"
					items="${dataForm.catalogosSo.anioGravable}"
					referenceData="${dataForm.catalogosSo.anioGravable}"
					class="form-control" />
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="impuestos.decGasolina.DatosGenerales.Periodo" /></label>
				<sf:select path="periodo" items="${dataForm.catalogosSo.periodo}"
					referenceData="${dataForm.catalogosSo.periodo}"
					class="form-control" />
			</div>
		</div>
	</div>
	<br>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="impuestos.decGasolina.DatosGenerales.numeroIdentificacion" /></label>
				<sf:input path="numDoc" value="${dataForm.numDoc}"
					class="form-control form-control" maxlength="30" size="20"
					readonly="true" />
				<!-- 				<input id="numeroId" name="numeroId" class="form-control form-control" -->
				<!-- 					aria-required="true" type="text" value="" maxlength="240"> -->
			</div>
		</div>

		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="impuestos.decGasolina.DatosGenerales.OpcionesUso" /></label>
				<div class="form-group ">
					<sf:select path="opcionUso"
					items="${dataForm.catalogosSo.opcionesUso}"
					referenceData="${dataForm.catalogosSo.opcionesUso}"
					class="form-control" />
				</div>
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
						<td><div class="col-md-12">
								<sf:select path="dataForm.infoDeclara[${loop.index}].claseProd"
									items="${dataForm.catalogosSo.claseProd}"
									referenceData="${dataForm.catalogosSo.claseProd}"
									class="form-control" />
							</div></td>
						<td><div class="col-md-12">
								<sf:input path="dataForm.infoDeclara[${loop.index}].galonesGra"
									value="${info.galonesGra}" class="form-control form-control"
									maxlength="30" size="20" />
							</div></td>
						<td><div class="col-md-12">
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
						<td><div class="col-md-12">
								<sf:input
									path="dataForm.infoDeclara[${loop.index}].baseGravable"
									value="${info.baseGravable}" class="form-control form-control"
									maxlength="30" size="20" readonly="true" />
							</div></td>
						<td><div class="col-md-12">
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

	

		<!-- 		<button id="presentarDeclaracionUrl" type="submit" -->
		<!-- 			class="btn btn-primary btn-block"> -->
		<%-- 			<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" /> --%>
		<!-- 		</button> -->


		<!-- 	<button class="btn btn-primary btn-block" type="button"> -->
		<%-- 		<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" /> --%>
		<!-- 	</button> -->
	
<br >
	<br >
<div class="row">
<div class="col-md-12 col-md-offset-4">
	<div class="form-group ">
		<sf:button action="${presentarDeclaracionUrl}" type="submit"
			class="btn btn-primary btn-lg" id="action" name="action"
			value="calcular">
			<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" />
		</sf:button>
		</div>
		</div>
		</div>


</sf:form>

