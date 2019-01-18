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
					code="impuestos.decGasolina.InformacionFirma.titulo" /></span>
		</h3>
	</div>
</div>

<div class="col-md-2">
	<label><spring:theme
			code="impuestos.decGasolina.InformacionFirma.agregarFirmas" /></label>
</div>

<div class="col-md-4">
	<div class="form-group ">
		<button class="btn btn-primary btn-block" type="button">
			<spring:theme code="impuestos.decGasolina.InformacionFirma.Agregar" />
		</button>
	</div>
</div>

<div class="col-md-12">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<td><spring:theme
							code="impuestos.decGasolina.InformacionFirma.tipoId" /></td>
					<td><spring:theme
							code="impuestos.decGasolina.InformacionFirma.numeroId" /></td>
					<td><spring:theme
							code="impuestos.decGasolina.InformacionFirma.denominacion" /></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="form-group ">
							<select id="tipoId" class="form-control">
								<c:forEach items="${dataFormCatalogos.tipoIdDec}" var="elemento">
									<option value="${elemento.key}"><c:out
											value="${elemento.label}" /></option>
								</c:forEach>
							</select>
						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="numeroId" name="gnumeroId"
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
							<button class="btn btn-primary btn-block" type="button">
								<spring:theme
									code="impuestos.decGasolina.InformacionFirma.Firma" />
							</button>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="row"></div>

<div class="row"></div>
