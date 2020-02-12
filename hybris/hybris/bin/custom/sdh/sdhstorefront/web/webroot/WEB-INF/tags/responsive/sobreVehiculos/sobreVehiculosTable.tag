<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new_page">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="sobre.vehiculos.table.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="sobre.vehiculos.table.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row mt-3">
		<div class="col-md-12 col-md-offset-4 d-flex align-items-center">
			<div class="table-responsive text-center">
				<table class="table table-bordered" style="width:auto !important">
					<thead>
						<tr>
							<td><label class="control-label labeltabletd tableident"><spring:theme
										code="sobre.vehiculo.table.tipdoc" /></label></td>
							<td><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="sobre.vehiculo.table.numdoc" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.table.nombre" /></label></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${vehiculosForm.tipiden}" /></td>
							<td><c:out value="${vehiculosForm.numide}" /></td>
							<td><c:out value="${vehiculosForm.name}" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<%-- <sf:form> --%>
<br>
<div class="container">
	<%-- <div class="col-md-2">
		<label class="control-label format_label"><spring:theme
				code="sobre.vehiculo.table.anigrav" /></label>
	</div>
	<div class="col-md-2">
		<select id="an" class="form-control an" name=" " onchange=" " disabled>
			<option value="2020">2020</option>
			<option value="2019">2019</option>
			<option value="2018">2018</option>
			<option value="2017">2017</option>
			<option value="2016">2016</option>
		</select>
	</div> --%>
	<input type="hidden" id="an" value="2020"/>



	<div class="row">
		<div class="col-md-10">
			<table class="table" id="example" class="newtd">
				<thead>
					<tr>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.placa" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.marca" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.linea" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.modelo" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.clase" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.carroceria" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.numpuertas" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.blindado" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.cilindraje" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code=" " /></label></th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${vehiculosForm.impvehicular }" var="eachVehiculo">
						<tr>
							<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachVehiculo.placa}"></c:out></td>
							<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme code="vehiculos.detalle.marca.${eachVehiculo.marca}"/></td>
							<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme code="vehiculos.detalle.linea.${eachVehiculo.linea}"/></td>
							<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachVehiculo.modelo}"></c:out></td>
							<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme code="vehiculos.detalle.clase.${eachVehiculo.clase}"/></td>
							<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme code="vehiculos.detalle.carroceria.${eachVehiculo.carroceria}"/></td>
							<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachVehiculo.numPuertas}"></c:out></td>
							<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme code="vehiculos.detalle.blindado.${eachVehiculo.blindado}"/></td>
							<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachVehiculo.cilindraje}"></c:out></td>
							<td><label style="color: #0358d8 !important"
								data-placa="${eachVehiculo.placa}"
								data-numbp="${vehiculosForm.numBP}"
								class="text-capitalize !important labelVerDetVeh "><spring:theme
										code="sobre.vehiculo.table.verdetalle" /></label></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<input name="numBPP" type="hidden" id="numBPP"
		value="${vehiculosForm.numBP}" />
		
		<div class="row">
		<div class="col-md-12"
			style="background: #d2d2d2; margin-top: 20px !important;">
			<label class="control-label "><spring:theme
					code="ica.inicial.representantes.nota1" /></label>
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="ica.inicial.representantes.nota2" /></label>
			</div>
		</div>
	</div>

</div>
<%-- </sf:form> --%>


