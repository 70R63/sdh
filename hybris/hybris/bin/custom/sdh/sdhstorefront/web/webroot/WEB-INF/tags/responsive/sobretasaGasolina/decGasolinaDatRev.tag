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
			<span tabindex="0" class="col-md-12 cintillo"><spring:theme
					code="impuestos.decGasolina.DatosRevisor.titulo" /></span>
		</h3>
	</div>
</div>

<div class="col-md-10">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<td><label class="inputlabelnew"><spring:theme
								code="impuestos.decGasolina.DatosRevisor.tipoId" /></label></td>
					<td><label class="inputlabelnew"><spring:theme
								code="impuestos.decGasolina.DatosRevisor.numeroId" /></label></td>
					<td><label class="inputlabelnew"><spring:theme
								code="impuestos.decGasolina.DatosRevisor.nombre" /></label></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="form-group ">
							<sf:select path="dataForm.tipoIdDec"
								items="${dataForm.catalogosSo.tipoIdDec}"
								referenceData="${dataForm.catalogosSo.tipoIdDec}"
								class="inputdropdown" />

							<%-- 							<sf:select path="dataForm.tipoIdRev" --%>
							<%-- 								items="${dataForm.catalogosDe.tipoIdRev}" --%>
							<%-- 								 referenceData="${dataForm.catalogosDe.tipoIdRev}"/> --%>

						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="numeroId" name="gnumeroId" class="inputtextnew"
								aria-required="true" type="text"
								value="${dataForm.revisor.numDoc}" maxlength="240"
								readonly="readonly">
						</div>
					</td>
					<td>
						<div class="form-group ">
							<input id="nombre" name="nombre" class="inputtextnew"
								aria-required="true" type="text"
								value="${dataForm.revisor.nombres}" maxlength="240"
								readonly="readonly">
						</div>
					</td>
				</tr>
			</tbody>
			<thead>
				<tr>
					<td><label class="inputlabelnew"><spring:theme
								code="impuestos.decGasolina.DatosRevisor.numeroTarjetaProf" /></label></td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="form-group ">
							<input id="numeroTarjetaProf" name="numeroTarjetaProf"
								class="inputtextnew" aria-required="true" type="text"
								value="${dataForm.revisor.tarjetaProf}" maxlength="240"
								readonly="readonly">
						</div>
					</td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

