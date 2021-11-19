<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new_page">
	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme code="concesionario.inicial.titulo" /></span>
			</h2>
		</div>
	</div>


	<div class="row">
		<div class="col-md-4 col-xs-12 mb-20 no-marginright">
			<span class="paso--uno pasos color-sr1">1</span>
			<h2 class="titulo-caja--ser-rel color-sr1 ">
				<spring:theme code="concesionario.inicial.fechas" />
			</h2>
			<p class="pasoClase1 metrophobic">Selecciona el periodo que
				deseas consultar.</p>
			<div class="caja--ser-rel color-sr1">
				<label class="control-label"><spring:theme
						code="concesionario.inicial.fecInicio" /></label> <input type="date"  class="newalto form-control">
				<label class="control-label"><spring:theme
						code="concesionario.inicial.fecFin" /></label> <input type="date"  class="newalto form-control">
			</div>
		</div>

		<div class="col-md-4 col-xs-12 mb-20 no-margincol">
			<span class="paso--dos pasos color-sr2">2</span>
			<h2 class="titulo-caja--ser-rel color-sr2 ">
				<span class="paso2"><spring:theme
						code="concesionario.inicial.statusReferencia" /></span>
			</h2>
			<p class="pasoClase2 metrophobic">Selecciona estatus de las
				referencias.</p>
			<div class="caja--ser-rel color-sr2">
				<label><spring:theme
						code="concesionario.inicial.estatusReferencia" /></label> <select
					id="aniograv" class="new_alto form-control " name="aniograv">
					<option value="">Seleccionar</option>
					<c:forEach varStatus="loop" items="${referenceStatus}"
										var="eachStatus">
					<option value="${eachStatus.code}">${eachStatus.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 col-md-offset-3">
			<button style="margin-top: 3px;" id="facBuscar"
				class="btn btn-primary btn-lg facBuscar" type="button">
				<spring:theme code="reexpedicion.factura.inicial.buscar" />
			</button>
		</div>
	</div>
	<br>

	<div id="table-vehiculos" style="display: block;">
		<div class="row" class="table-responsive">
			<div class="col-md-9 col-md-offset-2">
				<table class="table" id="tabPaginacion1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label
								class="control-label labeltabletd " for=""><spring:theme
										code="concesionario.inicial.referencia" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd " for=""> <spring:theme
										code="concesionario.inicial.placa" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd " for=""> <spring:theme
										code="concesionario.inicial.modelo" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd " for=""> <spring:theme
										code="concesionario.inicial.vigencia" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd " for=""> <spring:theme
										code="concesionario.inicial.vencimiento" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd " for=""> <spring:theme
										code="concesionario.inicial.estatusdeReferencia" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd " for=""> <spring:theme
										code="concesionario.inicial.seleccionar" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd " for=""> <spring:theme
										code="concesionario.inicial.impresion" /></label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="" /></td>
							<td><c:out value="" /></td>
							<td><c:out value="" /></td>
							<td><c:out value="" /></td>
							<td><c:out value="" /></td>
							<td><c:out value="" /></td>
							<td><label class="labelVerDetalle text-capitalize !important" id="labelPagar" style="color: #0358d8 !important">
													Pagar</label></td>
							<td><label class="labelVerDetalle text-capitalize !important" id="labelPagar" style="color: #0358d8 !important">
													Descargar</label></td>

						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>



