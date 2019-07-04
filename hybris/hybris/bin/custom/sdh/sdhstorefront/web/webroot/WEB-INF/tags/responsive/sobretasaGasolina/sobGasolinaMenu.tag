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

<div class="container">
	<div class="row gasorow">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="impuestos.sobreTasaGasolina.menu.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme
								code="impuestos.sobreTasaGasolina.menu.tituloNota" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>


<div class="row mt-3">
	<div class="col-md-7 col-md-offset-3 d-flex align-items-center">
		<div class="table-responsive text-center">
			<table class="table table-bordered">
				<thead>
					<tr>
						<td><label class="control-label labeltabletd tableident"><spring:theme
									code="impuestos.sobreTasaGasolina.menu.tipoDocumento" /></label></td>
						<td><label class="control-label labeltabletd tablenumiden"><spring:theme
									code="impuestos.sobreTasaGasolina.menu.numeroDocumento" /></label></td>
						<td><label class="control-label labeltabletd tablenombre"><spring:theme
									code="impuestos.sobreTasaGasolina.menu.nombre" /></label></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dataForm.listaDocumentos}" var="item"
						varStatus="loop">
						<tr>
							<td><sf:input
									path="listaDocumentos[${loop.index}].tipoDocumento"
									value="${item.tipoDocumento}"
									class="inputtextnew tableident" aria-required="true"
									maxlength="30" size="30" disabled="disabled" type="text" readonly="true" /></td>
							<td><sf:input
									path="listaDocumentos[${loop.index}].numeroDocumento"
									value="${item.numeroDocumento}" 
									class="inputtextnew tablenumiden" aria-required="true"
									maxlength="30" size="30" disabled="disabled" type="text"  readonly="true"/></td>
							<td><sf:input path="NAME_ORG1" value="" readonly="true"
									class="inputtextnew tablenombre" 
									maxlength="30" size="30" disabled="disabled" type="text" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
