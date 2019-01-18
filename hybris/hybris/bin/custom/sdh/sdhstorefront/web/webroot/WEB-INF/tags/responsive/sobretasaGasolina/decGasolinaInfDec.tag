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
				<tr>
					<td>
						<div class="form-group ">
							<select id="claseProducto" class="form-control">
								<c:forEach items="${dataFormCatalogos.claseProducto}"
									var="elemento">
									<option value="${elemento.key}"><c:out
											value="${elemento.label}" /></option>
								</c:forEach>
							</select>
						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="galones" name="galones"
								class="form-control form-control" aria-required="true"
								type="text" value="" maxlength="240">
						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="preciosReferencia" name="preciosReferencia"
								class="form-control form-control" aria-required="true"
								type="text" value="" maxlength="240">
						</div>
					</td>
					<td>
						<div class="form-group ">
							<select id="porcentajeAlc" class="form-control">
								<c:forEach items="${dataFormCatalogos.porcentajeAlc}"
									var="elemento">
									<option value="${elemento.key}"><c:out
											value="${elemento.label}" /></option>
								</c:forEach>
							</select>
						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="baseGraveble" name="baseGraveble"
								class="form-control form-control" aria-required="true"
								type="text" value="" maxlength="240">
						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="valorSobretasa" name="valorSobretasa"
								class="form-control form-control" aria-required="true"
								type="text" value="" maxlength="240">
						</div>
					</td>
					<td>
						<div class="form-group ">
							<button class="btn btn-primary btn-block" type="button">
								<spring:theme
									code="impuestos.decGasolina.InformacionDec.agregarDec" />
							</button>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="row"></div>

<div class="col-md-12">
	<div class="table-responsive">
		<table class="table">
			<tbody>
				<tr>
					<td>valor</td>
					<td>valor</td>
					<td>valor</td>
					<td>valor</td>
					<td>valor</td>
					<td>valor</td>
					<td>valor</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="row"></div>

<div class="row"></div>

<div class="form-group ">
	<button class="btn btn-primary btn-block" type="button">
		<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" />
	</button>
</div>

<div class="row"></div>



