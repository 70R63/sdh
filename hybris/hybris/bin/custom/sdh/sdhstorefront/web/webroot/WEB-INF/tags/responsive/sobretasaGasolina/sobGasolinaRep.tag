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
					code="impuestos.sobreTasaGasolina.representantes.titulo" /></span>
		</h3>
	</div>
</div>

<div class="col-md-12">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.tipoId" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.numId" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.nombre" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.tipoRelacion" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.fechaDesde" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.fechaHasta" /></td>
					<td><spring:theme
							code="impuestos.sobreTasaGasolina.representantes.fuenteDato" /></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dataForm.dataForm.representantes}" var="representante">
					<tr>
						<td>
							<div class="form-group ">
								<input id="tipoDoc" name="tipoDoc"
									class="form-control form-control" aria-required="true"
									type="text"
									value='<c:out value="${representante.tipoDoc}"></c:out>'
									maxlength="240">
								<!-- 								<select id="tipoId" class="form-control"> -->
								<%-- 									<c:forEach items="${representante.tipoId}" var="elemento"> --%>
								<%-- 										<option value="${elemento.key}"><c:out --%>
								<%-- 												value="${elemento.label}" /></option> --%>
								<%-- 									</c:forEach> --%>
								<!-- 								</select> -->
							</div>
						</td>
						<td>
							<div class="form-group ">
								<input id="numDoc" name="numDoc"
									class="form-control form-control" aria-required="true"
									type="text"
									value='<c:out value="${representante.numDoc}"></c:out>'
									maxlength="240">
							</div>
						</td>
						<td>
							<div class="form-group ">
								<input id="nombre" name="nombre"
									class="form-control form-control" aria-required="true"
									type="text"
									value='<c:out value="${representante.nombre}"></c:out>'
									maxlength="240">
							</div>
						</td>
						<td>
							<div class="form-group ">
								<input id="tipoRelacion" name="tipoRelacion"
									class="form-control form-control" aria-required="true"
									type="text"
									value='<c:out value="${representante.tipoRelacion}"></c:out>'
									maxlength="240">
								<!-- 								<select id="tipoRelacion" class="form-control"> -->
								<%-- 									<c:forEach items="${representante.tipoRelacion}" var="elemento"> --%>
								<%-- 										<option value="${elemento.key}"><c:out --%>
								<%-- 												value="${elemento.label}" /></option> --%>
								<%-- 									</c:forEach> --%>
								<!-- 								</select> -->
							</div>
						</td>
						<td>
							<div class="form-group ">
								<input id="fechDesde" name="fechDesde"
									class="form-control form-control" aria-required="true"
									type="text"
									value='<c:out value="${representante.fechDesde}"></c:out>'
									maxlength="240">
							</div>
						</td>
						<td>
							<div class="form-group ">
								<input id="fechHasta" name="fechHasta"
									class="form-control form-control" aria-required="true"
									type="text"
									value='<c:out value="${representante.fechHasta}"></c:out>'
									maxlength="240">
							</div>
						</td>
						<td>
							<div class="form-group ">
								<input id="fuente" name="fuente"
									class="form-control form-control" aria-required="true"
									type="text"
									value='<c:out value="${representante.fuente}"></c:out>'
									maxlength="240">
								<!-- 								<select id="fuenteDato" class="form-control"> -->
								<%-- 									<c:forEach items="${representante.fuenteDato}" var="elemento"> --%>
								<%-- 										<option value="${elemento.key}"><c:out --%>
								<%-- 												value="${elemento.label}" /></option> --%>
								<%-- 									</c:forEach> --%>
								<!-- 								</select> -->
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>




