<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new_page">
	<form:form action="">
		<div class="row">
			<div class="col-md-12">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="contribuyente.listadeclaraciones.titulo" /></span>
					</h2>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-8">
				<form:form action="">
					<div class="table-responsive text-center">
						<table class="table table-bordered" id="example">
							<thead>
								<tr>
									<td><label class="control-label labeltabletd tableident"><spring:theme
												code="contribuyente.listadeclaraciones.declarcion" /></label></td>
									<td><label class="control-label labeltabletd "><spring:theme
												code="contribuyente.listadeclaraciones.impuesto" /></label></td>
									<td><label class="control-label labeltabletd tablenumiden"><spring:theme
												code="contribuyente.listadeclaraciones.angrav" /></label></td>
									<td><label class="control-label labeltabletd tablenumiden"><spring:theme
												code="contribuyente.listadeclaraciones.periodo" /></label></td>
									<td><label class="control-label labeltabletd "><spring:theme
												code="contribuyente.listadeclaraciones.estatus" /></label></td>
									<td><label class="control-label labeltabletd tablenumiden"><spring:theme
												code="contribuyente.listadeclaraciones.seleccionar" /></label></td>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty contibForm.declaraciones}">
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
												type="text" size="30"
												value="No tiene declaraciones por firmar" /></td>
											<td
												style="color: #2196f3; text-decoration: underline !important; font-size: 14px;">Ver</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${contibForm.declaraciones}"
											var="eachDeclaracion">
											<c:choose>
												<c:when test="${eachDeclaracion.estadoFirma eq '01'}">
													<c:set var="desc_status" value='Pendiente por firmar'></c:set>
												</c:when>
												<c:when test="${eachDeclaracion.estadoFirma eq '02'}">
													<c:set var="desc_status" value='Pendiente por presentar'></c:set>
												</c:when>
											</c:choose>
											<tr>
												<td><input class="inputtextnew tableident"
													disabled="disabled" type="text" size="30"
													value="${eachDeclaracion.idDeclaracion}" /></td>
												<td><input class="inputtextnew " disabled="disabled"
													type="text" size="30"
													value="<spring:theme code="autorizado.impuestos.${eachDeclaracion.impuesto}" />" /></td>
												<td><input class="inputtextnew tablenumiden"
													disabled="disabled" type="text" size="30"
													value="${eachDeclaracion.anioGravable}" /></td>
												<td><input class="inputtextnew tablenumiden"
													disabled="disabled" type="text" size="30"
													value='<spring:theme code="autorizado.periodo.mes.${eachDeclaracion.periodo}" />' /></td>
												<td><input class="inputtextnew" disabled="disabled"
													type="text" size="30" value="${desc_status}" /></td>
												<td><label
													class="labelVerDetalle text-capitalize !important"
													id="labelVerDetalle" style="color: #0358d8 !important"
													data-relacion1="${eachDeclaracion.relacion}"
													data-tipo1="${eachDeclaracion.tipo_id1}"
													data-num1="${eachDeclaracion.num_id1}"
													data-nom1="${eachDeclaracion.nombre1}"
													data-relacion2="${eachDeclaracion.relacion2}"
													data-tipo2="${eachDeclaracion.tipo_id2}"
													data-num2="${eachDeclaracion.num_id2}"
													data-nom2="${eachDeclaracion.nombre2}"
													data-relacion3="${eachDeclaracion.relacion3}"
													data-tipo3="${eachDeclaracion.tipo_id3}"
													data-num3="${eachDeclaracion.num_id3}"
													data-nom3="${eachDeclaracion.nombre3}"><spring:theme
															code="publicidad.exterior.ver" /></label></td>

												<!-- 												<td><label class="detalleVerCont"  id="detalleVerCont" style="color: #2196f3; text-decoration: underline !important; font-size: 14px;" -->
												<%-- 													data-relacion1="${eachDeclaracion.relacion}" --%>
												<%-- 													data-tipo1="${eachDeclaracion.tipo_id1}" --%>
												<%-- 													data-num1="${eachDeclaracion.num_id1}" --%>
												<%-- 													data-nom1="${eachDeclaracion.nombre1}" --%>
												<%-- 													data-relacion2="${eachDeclaracion.relacion2}" --%>
												<%-- 													data-tipo2="${eachDeclaracion.tipo_id2}" --%>
												<%-- 													data-num2="${eachDeclaracion.num_id2}" --%>
												<%-- 													data-nom2="${eachDeclaracion.nombre2}" --%>
												<%-- 													data-relacion3="${eachDeclaracion.relacion3}" --%>
												<%-- 													data-tipo3="${eachDeclaracion.tipo_id3}" --%>
												<%-- 													data-num3="${eachDeclaracion.num_id3}" --%>
												<%-- 													data-nom3="${eachDeclaracion.nombre3}">Ver</label></td> --%>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.relacion}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.tipo_id1}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.num_id1}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.nombre1}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.relacion2}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.tipo_id2}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.num_id2}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.nombre2}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.relacion3}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.tipo_id3}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.num_id3}" />' /></td>
												<td style="display: none;"><input
													class="inputtextnew tablenumiden" disabled="disabled"
													type="text" size="30"
													value='<spring:theme code="${eachDeclaracion.nombre3}" />' /></td>
											<tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				</form:form>
			</div>
		</div>
	</form:form>
	<div class="row mt-3" id="detalleRelacion">
		<div class="col-md-8">
			<form:form action="">
				<div class="table-responsive text-center">
					<table class="table table-bordered tabRelacion" id="tabRelacion"
						style="display: none">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tableident"><spring:theme
											code="contribuyente.listadeclaraciones.relacion" /></label></td>
								<td><label class="control-label labeltabletd "><spring:theme
											code="contribuyente.listadeclaraciones.tipid" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="contribuyente.listadeclaraciones.numid" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="contribuyente.listadeclaraciones.nombre" /></label></td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
</div>

<script>
	function detalleVer() {
		debugger;
		var tabRel = document.getElementById('tabRelacion');
		tabRel.style.display = 'none';

		var relUno = $.trim($(this).attr("data-relacion1"));
		var tipUno = $.trim($(this).attr("data-tipo1"));
		var numUno = $.trim($(this).attr("data-num1"));
		var nomUno = $.trim($(this).attr("data-nom1"));
		var relDos = $.trim($(this).attr("data-relacion2"));
		var tipDos = $.trim($(this).attr("data-tipo2"));
		var numDos = $.trim($(this).attr("data-num2"));
		var nomDos = $.trim($(this).attr("data-nom2"));
		var relTres = $.trim($(this).attr("data-relacion3"));
		var tipTres = $.trim($(this).attr("data-tipo3"));
		var numTres = $.trim($(this).attr("data-num3"));
		var nomTres = $.trim($(this).attr("data-nom3"));

		if (relUno == "" || relUno == "null" && relDos == ""
				|| relDos == "null" && relTres == "" || relTres == "null") {
			$('#tabRelacion')
					.append(
							"<tr>"
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="No tiene Relaciones" /></td>');
		}

		if (relUno != "" || relUno != "null") {
			$('#tabRelacion')
					.append(
							"<tr>"
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ reluno
									+ '" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ tipUno
									+ '" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ numUno
									+ '" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ nomUno + '" /></td>');
		}

		if (relDos != "" || relDos != "null") {
			$('#tabRelacion')
					.append(
							"<tr>"
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ relDos
									+ '" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ tipDos
									+ '" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ numDos
									+ '" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ nomDos + '" /></td>');
		}

		if (relTres != "" || relTres != "null") {
			$('#tabRelacion')
					.append(
							"<tr>"
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ relTres
									+ '" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ tipTres
									+ '" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ numTres
									+ '" /></td>'
									+ '<td><input style="width: 123px !important" class="inputtextnew tablenumiden" disabled="disabled" type="text" size="40" value="'
									+ nomTres + '" /></td>');
		}
		tabRel.style.display = 'block';

	}
</script>