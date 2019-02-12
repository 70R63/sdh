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
				<h3>
					<span tabindex="0 headline"><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.titulo" /></span>
				</h3>
			</div>
		</div>
		<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
			<div class="row">
				<div class="col-md-12 table-bordered">
					<div class="table-responsive">
						<table>
							<thead>
								<tr>
									<td><label class="control-label"><spring:theme
												code="impuestos.sobreTasaGasolina.representantes.tipoId" /></label></td>
									<td><label class="control-label"><spring:theme
												code="impuestos.sobreTasaGasolina.representantes.numId" /></label></td>
									<td><label class="control-label"><spring:theme
												code="impuestos.sobreTasaGasolina.representantes.nombre" /></label></td>
									<td><label class="control-label"><spring:theme
												code="impuestos.sobreTasaGasolina.representantes.tipoRelacion" /></label></td>
									<td><label class="control-label"><spring:theme
												code="impuestos.sobreTasaGasolina.representantes.fechaDesde" /></label></td>
									<td><label class="control-label"><spring:theme
												code="impuestos.sobreTasaGasolina.representantes.fechaHasta" /></label></td>
									<td><label class="control-label"><spring:theme
												code="impuestos.sobreTasaGasolina.representantes.fuenteDato" /></label></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dataForm.dataForm.representantes}"
									var="representante">
									<tr>
										<td>
											<div class="form-group ">
												<input id="tipoDoc" name="tipoDoc"
													class="form-control form-control" aria-required="true"
													type="text"
													value='<c:out value="${representante.tipoDoc}"></c:out>'
													maxlength="240">
											</div>
										</td>
										<td>
											<div class="form-group ">
												<input id="numDoc" name="numDoc"
													class="form-control form-control" aria-required="true"
													type="text"
													value='<c:out value="${representante.numDoc}"></c:out>'
													maxlength="240">
											</div>
										</td>
										<td>
											<div class="form-group ">
												<input id="nombre" name="nombre"
													class="form-control form-control" aria-required="true"
													type="text"
													value='<c:out value="${representante.nombre}"></c:out>'
													maxlength="240">
											</div>
										</td>
										<td>
											<div class="form-group ">
												<input id="tipoRelacion" name="tipoRelacion"
													class="form-control form-control" aria-required="true"
													type="text"
													value='<c:out value="${representante.tipoRelacion}"></c:out>'
													maxlength="240">
											</div>
										</td>
										<td>
											<div class="form-group ">
												<input id="fechDesde" name="fechDesde"
													class="form-control form-control" aria-required="true"
													type="text"
													value='<c:out value="${representante.fechDesde}"></c:out>'
													maxlength="240">
											</div>
										</td>
										<td>
											<div class="form-group ">
												<input id="fechHasta" name="fechHasta"
													class="form-control form-control" aria-required="true"
													type="text"
													value='<c:out value="${representante.fechHasta}"></c:out>'
													maxlength="240">
											</div>
										</td>
										<td>
											<div class="form-group ">
												<input id="fuente" name="fuente"
													class="form-control form-control" aria-required="true"
													type="text"
													value='<c:out value="${representante.fuente}"></c:out>'
													maxlength="240">
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
			<div class="row">
				<div class="col-md-8 text-right">
					<sf:button action="" type="submit" class="btn btn-primary btn-lg"
						id="action" name="action" value="regresar">
						<spring:theme
							code="impuestos.sobreTasaGasolina.representantes.regresar" />
					</sf:button>
					<sf:button action="${buscarUrl}" type="submit"
						class="btn btn-primary btn-lg" id="action" name="action"
						value="declarar">
						<spring:theme
							code="impuestos.sobreTasaGasolina.menu.presentarDeclaracion" />
					</sf:button>
				</div>
			</div>
		</sf:form>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<h2>
			<span tabindex="0 headline"> <spring:theme
					code="impuestos.sobreTasaGasolina.representantes.detalleanteriores" />
			</span>
		</h2>
	</div>
</div>

<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="impuestos.decGasolina.DatosGenerales.anioGravableConsultar" /></label>
				<sf:select path="anoGravable"
					items="${dataForm.catalogosSo.anioGravable}"
					referenceData="${dataForm.catalogosSo.anioGravable}"
					class="form-control" />
			</div>
		</div>
	</div>

	<div class="row">
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

	<div class="row">
		<div class="col-md-8  text-right">
			<sf:button action="${buscarUrl}" type="submit"
				class="btn btn-primary btn-lg" id="action" name="action"
				value="buscar">
				<spring:theme
					code="impuestos.sobreTasaGasolina.DatosGenerales.buscar" />
			</sf:button>
		</div>
	</div>
</sf:form>
<div class="row"></div>



