<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="col-md-12">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-12">
				<h3>
					<span tabindex="0" class="col-md-12 cintillo"><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.titulo" /></span>
				</h3>
			</div>
		</div>

		<div class="col-md-9">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<td><label class="col-sm-1 inputlabelnew"><spring:theme
										code="impuestos.sobreTasaGasolina.representantes.tipoId" /></label></td>
							<td><label class="col-sm-0 inputlabelnew"><spring:theme
										code="impuestos.sobreTasaGasolina.representantes.numId" /></label></td>
							<td><label class="col-sm-2 inputlabelnew"><spring:theme
										code="impuestos.sobreTasaGasolina.representantes.nombre" /></label></td>
							<td><label class="col-md-2 inputlabelnew"><spring:theme
										code="impuestos.sobreTasaGasolina.representantes.tipoRelacion" /></label></td>
							<td><label class="col-md-1 inputlabelnew"><spring:theme
										code="impuestos.sobreTasaGasolina.representantes.fechaDesde" /></label></td>
							<td><label class="col-md-1 inputlabelnew"><spring:theme
										code="impuestos.sobreTasaGasolina.representantes.fechaHasta" /></label></td>
							<td><label class="col-md-1 inputlabelnew"><spring:theme
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
											class="inputtextnew" aria-required="true"
											type="text"
											value='<c:out value="${representante.tipoDoc}"></c:out>'
											maxlength="240">
									</div>
								</td>
								<td>
									<div class="form-group ">
										<input id="numDoc" name="numDoc"
											class="inputtextnew" aria-required="true"
											type="text"
											value='<c:out value="${representante.numDoc}"></c:out>'
											maxlength="240">
									</div>
								</td>
								<td>
									<div class="form-group ">
										<input id="nombre" name="nombre"
											class="inputtextnew" aria-required="true"
											type="text"
											value='<c:out value="${representante.nombre}"></c:out>'
											maxlength="240">
									</div>
								</td>
								<td>
									<div class="form-group ">
										<input id="tipoRelacion" name="tipoRelacion"
											class="inputtextnew" aria-required="true"
											type="text"
											value='<c:out value="${representante.tipoRelacion}"></c:out>'
											maxlength="240">
									</div>
								</td>
								<td>
									<div class="form-group ">
										<input id="fechDesde" name="fechDesde"
											class="inputtextnew" aria-required="true"
											type="text"
											value='<c:out value="${representante.fechDesde}"></c:out>'
											maxlength="240">
									</div>
								</td>
								<td>
									<div class="form-group ">
										<input id="fechHasta" name="fechHasta"
											class="inputtextnew" aria-required="true"
											type="text"
											value='<c:out value="${representante.fechHasta}"></c:out>'
											maxlength="240">
									</div>
								</td>
								<td>
									<div class="form-group ">
										<input id="fuente" name="fuente"
											class="inputtextnew" aria-required="true"
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
</div>



