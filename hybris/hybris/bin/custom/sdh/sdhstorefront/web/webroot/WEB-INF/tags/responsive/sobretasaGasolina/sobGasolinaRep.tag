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
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-12">
				<h2>
					<span tabindex="0 headline"><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.titulo" /></span>
				</h2>
			</div>
		</div>
		<div class="row text-center">
			<div class="col-md-10">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tipoId"><spring:theme
											code="impuestos.sobreTasaGasolina.representantes.tipoId" /></label></td>
								<td><label class="control-label labeltabletd tipoId"><spring:theme
											code="impuestos.sobreTasaGasolina.representantes.numId" /></label></td>
								<td><label class="control-label labeltabletd"><spring:theme
											code="impuestos.sobreTasaGasolina.representantes.nombre" /></label></td>
								<td><label class="control-label labeltabletd tipoId"><spring:theme
											code="impuestos.sobreTasaGasolina.representantes.tipoRelacion" /></label></td>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="impuestos.sobreTasaGasolina.representantes.fechaDesde" /></label></td>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="impuestos.sobreTasaGasolina.representantes.fechaHasta" /></label></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${dataForm.dataForm.representantes}"
								var="representante" varStatus="loop">
								<tr>
									<td>
										<div class="form-group ">
											<sf:select
												path="dataForm.representantes[${loop.index}].tipoDoc"
												items="${dataForm.catalogosSo.tipoIdRev}"
												referenceData="${dataForm.catalogosSo.tipoIdRev}"
												class="inputtextnew" maxlength="45" readonly="readonly"
												disabled="true" style="width: 150px !important"  />
										</div>
									</td>
									<td>
										<div class="form-group ">
											<input id="numDoc" name="numDoc"
												class="inputtextnew tableident" aria-required="true"
												type="text"
												value='<c:out value="${representante.numDoc}"></c:out>'
												maxlength="240" readonly="readonly">
										</div>
									</td>
									<td>
										<div class="form-group ">
											<input id="nombre" name="nombre"
												class="inputtextnew tablenombrecorto" aria-required="true"
												type="text"
												value='<c:out value="${representante.nombre}"></c:out>'
												maxlength="240" size="45" readonly="readonly">
										</div>
									</td>
									<td>
										<div class="form-group ">
											<input id="tipoRelacion" name="tipoRelacion"
												class="inputtextnew tabletiprela" aria-required="true"
												type="text"
												value='<c:out value="${representante.tipoRelacion}"></c:out>'
												maxlength="240" size="40" readonly="readonly">
										</div>
									</td>
									<td>
										<div class="form-group ">
											<input id="fechDesde" name="fechDesde"
												class="inputtextnew tablefechas" aria-required="true"
												type="text"
												value='<c:out value="${representante.fechDesde}"></c:out>'
												maxlength="240" readonly="readonly">
										</div>
									</td>
									<td>
										<div class="form-group ">
											<input id="fechHasta" name="fechHasta"
												class="inputtextnew tablefechas" aria-required="true"
												type="text"
												value='<c:out value="${representante.fechHasta}"></c:out>'
												maxlength="240" readonly="readonly">
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<br>
	</div>
</div>

<div class="col-md-8 text-center">
	<%-- 	<sf:button action="" type="submit" class="btn btn-primary btn-lg" --%>
	<%-- 		id="action" name="action" value="regresar"> --%>
	<%-- 		<spring:theme --%>
	<%-- 			code="impuestos.sobreTasaGasolina.representantes.regresar" /> --%>
	<%-- 	</sf:button> --%>

	<button type="button" class="btn btn-secondary btn-lg"
		onclick="goBack()">
		<spring:theme
			code="impuestos.sobreTasaGasolina.representantes.regresar" />
	</button>

	<div class="col-md-1"></div>
	<div class="col-md-1"></div>
	<%-- 	<sf:button action="${buscarUrl}" type="submit" --%>
	<%-- 		class="btn btn-primary btn-lg" id="action" name="action" --%>
	<%-- 		value="declarar"> --%>
	<%-- 		<spring:theme --%>
	<%-- 			code="impuestos.sobreTasaGasolina.menu.presentarDeclaracion" /> --%>
	<%-- 	</sf:button> --%>

	<sf:button action="" type="submit" class="btn btn-primary btn-lg"
		id="action" name="action" value="regresar">
		<spring:theme
			code="impuestos.sobreTasaGasolina.menu.presentarDeclaracion" />
	</sf:button>

	<%-- 	<button type="button" class="btn btn-primary btn-lg" onclick="window.location.href ='<c:url value='/contribuyentes/sobretasa-gasolina/generar?numForm=${ dataForm.dataForm.numForm}' />';">Generar Declaración</button> --%>

</div>
<div class="row">
		<div class="col-md-12"
			style="background: #d2d2d2; margin-top: 20px !important;">
			<label class="control-label "><spring:theme
					code="ica.inicial.representantes.nota1" /></label>
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="ica.inicial.representantes.nota2" /></label>
			</div>
		</div>
	</div>

<div class="row"></div>



