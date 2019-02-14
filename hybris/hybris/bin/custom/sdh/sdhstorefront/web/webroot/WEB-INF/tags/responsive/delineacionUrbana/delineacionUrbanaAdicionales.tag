<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6 headline">
		<h2>
			<span><spring:theme
					code="delineacion.urbana.adicionales.title" /></span>
		</h2>
	</div>
</div>

<form:form>
	<div class="row">
		<table class="newtable">
			<thead>
				<tr>
					<th><label class="control-label" for=""><spring:theme
								code="delineacion.urbana.adicionales.numradicado" /></label></th>
					<th><label class="control-label" for=""> <spring:theme
								code="delineacion.urbana.adicionales.chip" /></label></th>
					<th><label class="control-label" for=""> <spring:theme
								code="delineacion.urbana.adicionales.direcobra" /></label></th>
					<th><label class="control-label" for=""> <spring:theme
								code="delineacion.urbana.adicionales.codpostal" /></label></th>
					<th><label class="control-label" for=""> <spring:theme
								code="delineacion.urbana.adicionales.localidad" /></label></th>
						<th><label class="control-label" for=""> <spring:theme
								code="delineacion.urbana.adicionales.matinmo" /></label></th>
					<th><label class="control-label" for=""> <spring:theme
								code="delineacion.urbana.adicionales.estrato" /></label></th>
								<th><label class="control-label" for=""> <spring:theme
								code="delineacion.urbana.adicionales.tipunidad" /></label></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="Numero de radicado"></c:out></td>
					<td><c:out value="Chip"></c:out></td>
					<td><c:out value="Direccion de la obra"></c:out></td>
					<td><select class="form-control" disabled="disabled"><option>Código Postal</option></select></td>
					<td><select class="form-control" disabled="disabled"><option>Localidad</option></select></td>
					<td><c:out value="Matricula inmobiliaria"></c:out></td>
					<td><select class="form-control" disabled="disabled"><option>Estrato</option></select></td>
					<td><select class="form-control" disabled="disabled"><option>Tipo de unidad</option></select></td>
				</tr>

			</tbody>
		</table>
	</div>
	
	<br>
	<div>
	<div class="row">
		<table class="newtable">
			<thead>
				<tr>
					<th><label class="control-label " for=""><spring:theme
								code="delineacion.urbana.adicionales.numradicado" /></label></th>
					<th><label class="control-label " for=""> <spring:theme
								code="delineacion.urbana.adicionales.cantunida" /></label></th>
					<th><label class="control-label " for=""> <spring:theme
								code="delineacion.urbana.adicionales.areaunidad" /></label></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="Numero de radicado"></c:out></td>
					<td><c:out value="Cantidad Unidades"></c:out></td>
					<td><c:out value="Area por unidad"></c:out></td>
				</tr>

			</tbody>

		</table>
	</div>
	</div>
</form:form>

