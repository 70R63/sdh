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
						href="http://www.shd.gov.co/shd/">Mas información</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<br>
<div class="col-md-10">
	<div>
		<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
			<div class="col-md-3 col-md-offset-3 centered">
				<table class="table col-md-2 table-bordered" id="example">
					<thead>
						<tr>
							<td><label><spring:theme
										code="impuestos.sobreTasaGasolina.menu.tipoDocumento" /></label></td>
							<td><label><spring:theme
										code="impuestos.sobreTasaGasolina.menu.numeroDocumento" /></label></td>
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
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>



			<br>
			<div class="row col-md-10 centered">
				<div class="col-md-10 col-md-offset-5 centered">
					<sf:button action="${buscarUrl}" type="submit"
						class="boton col-md-3" id="action" name="action" value="declarar">
						<spring:theme
							code="impuestos.sobreTasaGasolina.menu.presentarDeclaracion" />
					</sf:button>
				</div>
			</div>
			<br>
			<div class="row col-md-10 centered">
				<div class="col-md-10 col-md-offset-5">
					<sf:button class="boton col-md-3" type="button">
						<spring:theme code="impuestos.sobreTasaGasolina.menu.rop" />
					</sf:button>
				</div>
			</div>
			<br>
			<div class="row col-md-10 centered">
				<div class="col-md-10 col-md-offset-5 centered">
					<sf:button class="boton col-md-3" type="button">
						<spring:theme code="impuestos.sobreTasaGasolina.menu.pagoEnLinea" />
					</sf:button>
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-md-12">
					<h3>
						<span tabindex="0" class="col-md-12 cintillo"> <spring:theme
								code="impuestos.sobreTasaGasolina.DatosGenerales.titulo" />
						</span>
					</h3>
				</div>
			</div>


			<div class="row">
				<div class="col-md-3">
					<label class="inputlabelnew"><spring:theme
							code="impuestos.sobreTasaGasolina.DatosGenerales.anioGravableConsultar" /></label>
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<sf:select path="anoGravable"
							items="${dataForm.catalogosSo.anioGravable}"
							referenceData="${dataForm.catalogosSo.anioGravable}"
							class="inputdropdown" />
					</div>
				</div>
				<div class="col-md-3">
					<label class="inputlabelnew"><spring:theme
							code="impuestos.sobreTasaGasolina.DatosGenerales.Periodo" /></label>
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<sf:select path="periodo" items="${dataForm.catalogosSo.periodo}"
							referenceData="${dataForm.catalogosSo.periodo}"
							class="inputdropdown" />
					</div>
				</div>
				<div class="col-md-2">
					<sf:button action="${buscarUrl}" type="submit" class="boton"
						id="action" name="action" value="buscar">
						<spring:theme
							code="impuestos.sobreTasaGasolina.DatosGenerales.buscar" />
					</sf:button>
				</div>
				<%-- 				<sf:input type="hidden" id="action" name="action" path="action" /> --%>
			</div>
			<br>
		</sf:form>
	</div>
</div>



