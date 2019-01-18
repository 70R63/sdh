<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span tabindex="0"><spring:theme
					code="impuestos.sobreTasaGasolina.representantes.titulo" /></span>
		</h3>
	</div>
</div>

<div class="col-md-12">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.tipoId" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.numId" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.nombre" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.tipoRelacion" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.fechaDesde" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.fechaHasta" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.fuenteDato" /></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="form-group ">
							<select id="tipoId" class="form-control">
								<c:forEach items="${dataFormCatalogos.tipoId}"
									var="elemento">
									<option value="${elemento.key}"><c:out
											value="${elemento.label}" /></option>
								</c:forEach>
							</select>
						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="numId" name="numId"
								class="form-control form-control" aria-required="true"
								type="text" value="" maxlength="240">
						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="nombre" name="nombre"
								class="form-control form-control" aria-required="true"
								type="text" value="" maxlength="240">
						</div>
					</td>
					<td>
						<div class="form-group ">
							<select id="tipoRelacion" class="form-control">
								<c:forEach items="${dataFormCatalogos.tipoRelacion}"
									var="elemento">
									<option value="${elemento.key}"><c:out
											value="${elemento.label}" /></option>
								</c:forEach>
							</select>
						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="fechaDesde" name="fechaDesde"
								class="form-control form-control" aria-required="true"
								type="text" value="" maxlength="240">
						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="fechaHasta" name="fechaHasta"
								class="form-control form-control" aria-required="true"
								type="text" value="" maxlength="240">
						</div>
					</td>
					<td>
						<div class="form-group ">
							<select id="fuenteDato" class="form-control">
								<c:forEach items="${dataFormCatalogos.fuenteDato}"
									var="elemento">
									<option value="${elemento.key}"><c:out
											value="${elemento.label}" /></option>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>




