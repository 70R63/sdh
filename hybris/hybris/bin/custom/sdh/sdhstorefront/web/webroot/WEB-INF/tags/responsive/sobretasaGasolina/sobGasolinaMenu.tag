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

<div class="col-md-9">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr class="avisoheadline p">
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.menu.titulo" /></td>
				</tr>
			</thead>
			<tbody>
				<tr class="avisobody">

					<td><spring:theme
							code="impuestos.sobreTasaGasolina.menu.tituloNota" /><a
						href="http://www.shd.gov.co/shd/" target="_blank"> Mas información</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<br>
<div class="col-md-9">
	<div>
		<div class="col-md-12">
			<table class="table col-md-2 table-bordered">
				<thead>
					<tr>
						<td><label class="control-label text-capitalize !important"><spring:theme
									code="impuestos.sobreTasaGasolina.menu.tipoDocumento" /></label></td>
						<td><label class="control-label text-capitalize !important"><spring:theme
									code="impuestos.sobreTasaGasolina.menu.numeroDocumento" /></label></td>
						<td><label class="control-label text-capitalize !important"><spring:theme
									code="impuestos.sobreTasaGasolina.menu.nombre" /></label></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dataForm.listaDocumentos}" var="item"
						varStatus="loop">
						<tr>
							<td><sf:input
									path="listaDocumentos[${loop.index}].tipoDocumento"
									value="${item.tipoDocumento}" readonly="true"
									class="inputtextnew" aria-required="true" maxlength="30"
									size="30" disabled="disabled" type="text" /></td>
							<td><sf:input
									path="listaDocumentos[${loop.index}].numeroDocumento"
									value="${item.numeroDocumento}" readonly="true"
									class="inputtextnew" aria-required="true" maxlength="30"
									size="30" disabled="disabled" type="text" /></td>
							<td><sf:input path="NAME_ORG1" value="" readonly="true"
									class="inputtextnew" aria-required="true" maxlength="30"
									size="30" disabled="disabled" type="text" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>




