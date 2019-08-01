<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<div class="col-md-6 col-md-offset-3" style="margin-bottom: 5px">
		<label class="control-label"
			style="text-transform: none; font-weight: 600 !important;"><spring:theme
				code="autorizado.inicial.representando" /></label>
	</div>

	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-6 col-md-offset-3 d-flex align-items-center">

				<div class="table-responsive text-center">
					<table class="table table-bordered">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tableident"><spring:theme
											code="ica.inicial.table.tipdoc" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="ica.inicial.table.numdoc" /></label></td>
								<td><label class="control-label labeltabletd tablenombre"><spring:theme
											code="ica.inicial.table.nombre" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="inputtextnew tableident"
									disabled="disabled" type="text" size="30"
									value="${representado.documentType}" /></td>
								<td><input class="inputtextnew tablenumiden"
									disabled="disabled" type="text" size="30"
									value="${representado.documentNumber}" /></td>
								<c:choose>
									<c:when test="${empty representado}">
										<td><input class="inputtextnew tablenombre"
											disabled="disabled" type="text" size="30"
											value="Contribuyente no encontrado" /></td>
									</c:when>
									<c:otherwise>
										<td><input class="inputtextnew tablenombre"
											disabled="disabled" type="text" size="30"
											value="${representado.completeName}" /></td>
									</c:otherwise>
								</c:choose>

							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="autorizado.listadeclaraciones.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-8">
				<form:form action="">
					<div class="table-responsive text-center">
						<table class="table table-bordered">
							<thead>
								<tr>
									<td><label class="control-label labeltabletd tableident"><spring:theme
												code="autorizado.listadeclaraciones.declarcion" /></label></td>
									<td><label class="control-label labeltabletd "><spring:theme
												code="autorizado.listadeclaraciones.impuesto" /></label></td>
									<td><label class="control-label labeltabletd tablenumiden"><spring:theme
												code="autorizado.listadeclaraciones.angrav" /></label></td>
									<td><label class="control-label labeltabletd tablenumiden"><spring:theme
												code="autorizado.listadeclaraciones.periodo" /></label></td>
									<td><label class="control-label labeltabletd "><spring:theme
												code="autorizado.listadeclaraciones.estatus" /></label></td>
									<td><label class="control-label labeltabletd tablenumiden"><spring:theme
												code="autorizado.listadeclaraciones.seleccionar" /></label></td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input class="inputtextnew tableident"
										disabled="disabled" type="text" size="30" value="" /></td>
									<td><input class="inputtextnew " disabled="disabled"
										type="text" size="30" value="" /></td>
									<td><input class="inputtextnew tablenumiden"
										disabled="disabled" type="text" size="30" value="" /></td>
									<td><input class="inputtextnew tablenumiden"
										disabled="disabled" type="text" size="30" value="" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										type="text" size="30" value="" /></td>
									<td
										style="color: #2196f3; text-decoration: underline !important; font-size: 14px;">Ver</td>
								</tr>
							</tbody>
						</table>
					</div>
				</form:form>
			</div>
		</div>
	</form:form>
</div>