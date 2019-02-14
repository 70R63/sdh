<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<div class="row">
		<div class="avisoheadline">
			<h3>
				<span class="p"><spring:theme
						code="sobre.vehiculos.table.title" text="Mis Vehiculos" /></span>
			</h3>
		</div>
		<p class="avisobody">
			<spring:theme code="sobre.vehiculos.table.descripcion" />
		</p>
	</div>
</div>

<sf:form>
	<br>
	<div class="container">
		<div class="col-md-1">
			<label class="control-label "><spring:theme
					code="sobre.vehiculo.table.anigrav" /></label>
		</div>
		<div class="col-md-2">
			<select id="an" class="form-control " name=" " onchange=" " disabled>
				<option value="2019">2019</option>
				<option value="2018">2018</option>
				<option value="2017">2017</option>
				<option value="2016">2016</option>
			</select>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th><label class="control-label "><spring:theme
									code="sobre.vehiculo.table.placa" /></label></th>
						<th><label class="control-label "><spring:theme
									code="sobre.vehiculo.table.marca" /></label></th>
						<th><label class="control-label "><spring:theme
									code="sobre.vehiculo.table.factura" /></label></th>
						<th><label class="control-label "><spring:theme
									code="sobre.vehiculo.table.linea" /></label></th>
						<th><label class="control-label "><spring:theme
									code="sobre.vehiculo.table.modelo" /></label></th>
						<th><label class="control-label "><spring:theme
									code="sobre.vehiculo.table.clase" /></label></th>
						<th><label class="control-label "><spring:theme
									code="sobre.vehiculo.table.numpuertas" /></label></th>
						<th><label class="control-label "><spring:theme
									code="sobre.vehiculo.table.blindado" /></label></th>
						<th><label class="control-label "><spring:theme
									code="sobre.vehiculo.table.cilindraje" /></label></th>
						<th><label class="control-label "><spring:theme
									code="sobre.vehiculo.table.avaluo" /></label></th>
						<th><label class="control-label "><spring:theme
									code=" " /></label></th>

					</tr>
				</thead>

				<tbody>
					<tr>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="placa"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="marca"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="factura"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="linea"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="modelo"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="clase"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="Puertas"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="blindado"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="cilin"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="avaluo"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="submit"
							value="<c:out value="Ver detalle"></c:out>" maxlength="240"
							style="width: 100% !important;"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</sf:form>


