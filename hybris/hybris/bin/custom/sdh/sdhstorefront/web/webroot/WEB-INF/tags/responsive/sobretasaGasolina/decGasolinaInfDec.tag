<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url
	value="/contribuyentes/sobretasa-gasolina/declaracion-gasolina"
	var="presentarDeclaracionUrl" htmlEscape="false" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span tabindex="0"><spring:theme
					code="impuestos.decGasolina.InformacionDec.titulo" /></span>
		</h3>
	</div>
</div>

<div class="col-md-12">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<td><spring:theme
							code="impuestos.decGasolina.InformacionDec.claseProducto" /></td>
					<td><spring:theme
							code="impuestos.decGasolina.InformacionDec.galones" /></td>
					<td><spring:theme
							code="impuestos.decGasolina.InformacionDec.preciosReferencia" /></td>
					<td><spring:theme
							code="impuestos.decGasolina.InformacionDec.porcentajeAlcohol" /></td>
					<td><spring:theme
							code="impuestos.decGasolina.InformacionDec.baseGravable" /></td>
					<td><spring:theme
							code="impuestos.decGasolina.InformacionDec.valorSobretasa" /></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dataForm.infoDeclara}" var="infoDeclara"
					varStatus="loop">
					<tr>
						<td>
							<div class="form-group ">
								<sf:select path="dataForm.infoDeclara[${loop.index}].claseProd"
									items="${dataForm.catalogos.claseProd}"
									referenceData="${dataForm.catalogos.claseProd}" />
							</div>
						</td>
						<td>
							<div class="form-group ">
								<sf:input path="dataForm.infoDeclara[${loop.index}].galonesGra"
									value="${infoDeclara.galonesGra}" />
							</div>
						</td>
						<td>
							<div class="form-group ">
								<sf:input path="dataForm.infoDeclara[${loop.index}].precioRef"
									value="${infoDeclara.precioRef}" />
							</div>
						</td>
						<td>
							<div class="form-group ">
								<sf:select
									path="dataForm.infoDeclara[${loop.index}].alcoholCarbu"
									items="${dataForm.catalogos.alcoholCarbu}"
									referenceData="${dataForm.catalogos.alcoholCarbu}" />
							</div>
						</td>
						<td>
							<div class="form-group ">
								<sf:input
									path="dataForm.infoDeclara[${loop.index}].baseGravable"
									value="${infoDeclara.baseGravable}" />
							</div>
						</td>
						<td>
							<div class="form-group ">
								<sf:input
									path="dataForm.infoDeclara[${loop.index}].vlrSobretasa"
									value="${infoDeclara.vlrSobretasa}" />
							</div>
						</td>
					</tr>
				</c:forEach>



			</tbody>
		</table>
	</div>
</div>

<br />
<br />

<div class="form-group ">
	<sf:form action="${presentarDeclaracionUrl}"
		id="presentarDeclaracionUrl1" commandName="presentarDeclaracion"
		method="POST">

		<button id="presentarDeclaracionUrl" type="submit"
			class="btn btn-primary btn-block">
			<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" />
		</button>
	</sf:form>

	<!-- 	<button class="btn btn-primary btn-block" type="button"> -->
	<%-- 		<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" /> --%>
	<!-- 	</button> -->
</div>


<div class="row"></div>



