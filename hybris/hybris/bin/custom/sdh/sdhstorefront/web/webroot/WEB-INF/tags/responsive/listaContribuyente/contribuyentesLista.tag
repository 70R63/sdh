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
									<c:choose>
										<c:when test="${empty firmas.declaraciones}">
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
														   type="text" size="30" value="No tiene declaraciones por firmar" /></td>
												<td style="color: #2196f3; text-decoration: underline !important; font-size: 14px;">Ver</td>
											</tr>
										</c:when>
										<c:otherwise>
												<c:forEach items="${firmas.declaraciones}" var="eachDeclaracion" >
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
															   disabled="disabled" type="text" size="30" value="${eachDeclaracion.idDeclaracion}" /></td>
													<td><input class="inputtextnew " disabled="disabled"
															   type="text" size="30" value="<spring:theme code="autorizado.impuestos.${eachDeclaracion.impuesto}" />" /></td>
													<td><input class="inputtextnew tablenumiden"
															   disabled="disabled" type="text" size="30" value="${eachDeclaracion.anioGravable}" /></td>
													<td><input class="inputtextnew tablenumiden"
															   disabled="disabled" type="text" size="30" value='<spring:theme code="autorizado.periodo.mes.${eachDeclaracion.periodo}" />' /></td>
													<td><input class="inputtextnew" disabled="disabled"
															   type="text" size="30" value="${desc_status}" /></td>

													<c:choose>
														<c:when test="${eachDeclaracion.impuesto eq '0007'}">
															<td ><a href="<c:url value="/contribuyentes/publicidadexterior/declaracion/show?representado=${representado.infoContrib.numBP}&numForm=${eachDeclaracion.idDeclaracion}" />">Ver</a></td>
														</c:when>
														<c:when test="${eachDeclaracion.impuesto eq '0005'}">
															<td ><a href="<c:url value="/contribuyentes/sobretasa-gasolina/declaracion/show?representado=${representado.infoContrib.numBP}&numForm=${eachDeclaracion.idDeclaracion}" />">Ver</a></td>
														</c:when>
														<c:when test="${eachDeclaracion.impuesto eq '0003'}">
															<td ><a href="<c:url value="/contribuyentes/ica/declaracion/show?representado=${representado.infoContrib.numBP}&numForm=${eachDeclaracion.idDeclaracion}&periodoSeleccionado=${eachDeclaracion.periodo}&anoGravable=${eachDeclaracion.anioGravable}" />">Ver</a></td>
														</c:when>
														<c:otherwise>
															<td style="color: #2196f3; text-decoration: underline !important; font-size: 14px;">Ver</td>
														</c:otherwise>

													</c:choose>


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
</div>