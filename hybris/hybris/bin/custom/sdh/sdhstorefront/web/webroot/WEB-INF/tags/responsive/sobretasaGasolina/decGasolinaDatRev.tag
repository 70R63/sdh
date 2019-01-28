<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span tabindex="0"><spring:theme
					code="impuestos.decGasolina.DatosRevisor.titulo" /></span>
		</h3>
	</div>
</div>

<div class="col-md-12">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<td><spring:theme
							code="impuestos.decGasolina.DatosRevisor.tipoId" /></td>
					<td><spring:theme
							code="impuestos.decGasolina.DatosRevisor.numeroId" /></td>
					<td><spring:theme
							code="impuestos.decGasolina.DatosRevisor.nombre" /></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="form-group ">
							<sf:select path="dataForm.tipoIdRev"
								items="${dataForm.catalogos.tipoIdRev}"
								 referenceData="${dataForm.catalogos.tipoIdRev}"/>

							<!-- 							<select id="tipoId" class="form-control"> -->
							<%-- 								<c:forEach items="${dataForm.catalogos.tipoIdRev}" var="elemento"> --%>
							<%-- 									<option value="${elemento.key}" --%>
							<%-- 										${elemento.key == infoDeclara.tipoIdRev ? 'selected="selected"' : ''}> --%>
							<%-- 										<c:out value="${elemento.label}" /></option> --%>
							<%-- 								</c:forEach> --%>
							<!-- 							</select> -->
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
				</tr>
			</tbody>
			<thead>
				<tr>
					<td><spring:theme
							code="impuestos.decGasolina.DatosRevisor.numeroTarjetaProf" /></td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="form-group ">
							<input id="numeroTarjetaProf" name="numeroTarjetaProf"
								class="form-control form-control" aria-required="true"
								type="text" value="" maxlength="240">
						</div>
					</td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

