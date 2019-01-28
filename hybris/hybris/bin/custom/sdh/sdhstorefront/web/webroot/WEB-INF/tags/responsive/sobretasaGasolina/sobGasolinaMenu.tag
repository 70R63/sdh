<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
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
<spring:url value="/contribuyentes/sobretasa-gasolina" var="buscarUrl"
	htmlEscape="false" />


<div class="col-md-12">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<td><c:out value="${dataFormRes}"></c:out></td>
				</tr>
			</thead>
		</table>
	</div>
</div>


<div class="col-md-12">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.menu.titulo" /></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.menu.tituloNota" /><a
						href="http://www.shd.gov.co/shd/">Mas información</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>


<div class="col-md-10">
	<div class="table-responsive">
		<sf:form action="" method="POST" modelAttribute="dataForm">
			<table class="table" id="example">
				<thead>
					<tr>
						<td><spring:theme
								code="impuestos.sobreTasaGasolina.menu.tipoDocumento" /></td>
						<td><spring:theme
								code="impuestos.sobreTasaGasolina.menu.numeroDocumento" /></td>
						<td><spring:theme
								code="impuestos.sobreTasaGasolina.menu.seleccionar" /></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dataForm.listaDocumentos}" var="item"
						varStatus="loop">
						<tr>
							<td><sf:input
									path="listaDocumentos[${loop.index}].tipoDocumento"
									value="${item.tipoDocumento}" readonly="true" /></td>
							<td><sf:input
									path="listaDocumentos[${loop.index}].numeroDocumento"
									value="${item.numeroDocumento}" readonly="true" /></td>
							<td><sf:radiobutton
									path="listaDocumentos[${loop.index}].seleccionado"
									style="visibility: visible !important; margin: 0; min-height: 0;"
									value="${loop.index}" /> <sf:radiobutton
									path="listaDocumentos[${loop.index}].seleccionado"
									style="visibility: hidden !important; margin: 0; min-height: 0;"
									value="" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>






			<div class="row">
				<div class="col-md-3">
					<label><spring:theme
							code="impuestos.sobreTasaGasolina.DatosGenerales.anioGravableConsultar" /></label>
				</div>
				<div class="col-md-3">
					<div class="form-group ">
						<sf:select path="anioGravable"
							items="${dataForm.catalogos.anioGravable}"
							referenceData="${dataForm.catalogos.anioGravable}" />

						<%-- 						<sf:select id="anioGravable" class="form-control"> --%>
						<%-- 							<c:forEach items="${dataFormCatalogos.anioGravable}" --%>
						<%-- 								var="elemento" varStatus="loop"> --%>
						<%-- 								<sf:option value="${elemento.key}" path="catalogos[${loop.index}].anioGravable"><c:out --%>
						<%-- 										value="${elemento.label}" /></sf:option> --%>
						<%-- 							</c:forEach> --%>
						<%-- 						</sf:select> --%>
					</div>
				</div>
				<div class="col-md-3">
					<label><spring:theme
							code="impuestos.sobreTasaGasolina.DatosGenerales.Periodo" /></label>
				</div>
				<div class="col-md-3">
					<div class="form-group ">
						<sf:select path="periodo" items="${dataForm.catalogos.periodo}"
							referenceData="${dataForm.catalogos.periodo}" />
						<!-- 						<select id="periodo" class="form-control"> -->
						<%-- 							<c:forEach items="${dataFormCatalogos.periodo}" var="elemento"> --%>
						<%-- 								<option value="${elemento.key}"><c:out --%>
						<%-- 										value="${elemento.label}" /></option> --%>
						<%-- 							</c:forEach> --%>
						<!-- 						</select> -->
					</div>
				</div>
			</div>







			<sf:button id="buscarUrl" type="submit"
				class="btn btn-primary btn-block" action="${buscarUrl}">
				<spring:theme
					code="impuestos.sobreTasaGasolina.DatosGenerales.buscar" />
			</sf:button>
			<br>
		</sf:form>
	</div>
</div>


<%-- <sf:form action="${buscarUrl}" id="documento" modelAttribute="documento" --%>
<!-- 	method="POST"> -->
<!-- 	<div class="col-md-10"> -->
<!-- 		<div class="table-responsive"> -->
<!-- 			<table class="table" id="example"> -->
<!-- 				<thead> -->
<!-- 					<tr> -->
<%-- 						<td><spring:theme --%>
<%-- 								code="impuestos.sobreTasaGasolina.menu.tipoDocumento" /></td> --%>
<%-- 						<td><spring:theme --%>
<%-- 								code="impuestos.sobreTasaGasolina.menu.numeroDocumento" /></td> --%>
<%-- 						<td><spring:theme --%>
<%-- 								code="impuestos.sobreTasaGasolina.menu.seleccionar" /></td> --%>
<!-- 					</tr> -->
<!-- 				</thead> -->
<!-- 				<tbody> -->
<%-- 					<c:forEach items="${dataForm.listaDocumentos}" var="item"> --%>
<!-- 						<tr> -->
<%-- 							<td><c:out value="${item.tipoDocumento}">/></c:out></td> --%>
<%-- 							<td><c:out value="${item.numeroDocumento}"></c:out></td> --%>
<!-- 							<td><input id="seleccionado" -->
<!-- 								style="visibility: visible !important; margin: 0; min-height: 0;" -->
<!-- 								name="seleccionado" type="radio" value="Seleccionado"></td> -->
<!-- 						</tr> -->
<%-- 					</c:forEach> --%>
<!-- 				</tbody> -->
<!-- 			</table> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<button id="buscarUrl" type="submit" class="btn btn-primary btn-block"> -->
<%-- 		<spring:theme code="impuestos.sobreTasaGasolina.DatosGenerales.buscar" /> --%>
<!-- 	</button> -->
<%-- </sf:form> --%>

<div class="col-md-12">
	<div class="form-group ">
		<sf:form action="${presentarDeclaracionUrl}"
			id="presentarDeclaracionUrl1" commandName="presentarDeclaracion"
			method="GET">

			<button id="presentarDeclaracionUrl" type="submit"
				class="btn btn-primary btn-block">
				<spring:theme
					code="impuestos.sobreTasaGasolina.menu.presentarDeclaracion" />
			</button>
		</sf:form>
	</div>
</div>

<div class="col-md-12">
	<div class="form-group ">
		<button class="btn btn-primary btn-block" type="button">
			<spring:theme code="impuestos.sobreTasaGasolina.menu.rop" />
		</button>
	</div>
</div>
<div class="col-md-12">
	<div class="form-group ">
		<button class="btn btn-primary btn-block" type="button">
			<spring:theme code="impuestos.sobreTasaGasolina.menu.pagoEnLinea" />
		</button>
	</div>
</div>
