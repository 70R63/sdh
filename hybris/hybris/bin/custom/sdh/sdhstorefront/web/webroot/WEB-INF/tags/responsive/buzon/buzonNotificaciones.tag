<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row" id="idnotificaciones">
		<div class="col-md-6 col-md-offset-1 headline">
			<h2>
				<span><spring:theme code="mibuzon.notificaciones.notifica" /></span>
			</h2>
		</div>
	</div>
	<sf:form>
		<div class="row">
			<div class="col-md-6 col-md-offset-3 headline">
				<h2>
					<span><spring:theme code="mibuzon.notificaciones.nuevos" /></span>
				</h2>
			</div>
		</div>
		<div>
			<div class="row table-responsive">

				<div class="col-md-8 col-md-offset-2 center">
					<table class="table table-responsive" id="tabPaginacion2">
						<thead>
							<tr>
								<th style="text-align: center;"><label
									class="control-label"
									style="text-transform: capitalize !important" for=""><spring:theme
											code="mibuzon.notificaciones.identi" /></label></th>
								<th style="text-align: center"><label class="control-label"
									style="text-transform: capitalize !important" for=""> <spring:theme
											code="mibuzon.notificaciones.autoridad" /></label></th>
								<th style="text-align: center"><label class="control-label"
									style="text-transform: capitalize !important" for=""> <spring:theme
											code="mibuzon.notificaciones.asunto" /></label></th>
								<th style="text-align: center"><label class="control-label"
									style="text-transform: capitalize !important" for=""> <spring:theme
											code="mibuzon.notificaciones.fecnoti" /></label></th>
								<th style="text-align: center"><label class="control-label"
									style="text-transform: capitalize !important" for=""> <spring:theme
											code="mibuzon.notificaciones.anexos" /></label></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${miBuzon.mensajesMsg}" var="eachDocs">
								<c:set var="mensajeError" value=""/>
								<c:if test="${eachDocs.tipoMensaje == '1' && eachDocs.checkLectura != 'X'}">
									<c:forEach items="${eachDocs.errores}" var="eachError">
										<c:choose>
											<c:when test="${eachError.txt_msj != '' && eachError.id_msj == '4'}">
												<c:set var="mensajeError" value="${mensajeError} ${eachError.txt_msj}"/>
											</c:when>
										</c:choose>
									</c:forEach>

									<tr>
										<td><c:out value="${eachDocs.id_radicado}" /></td>
										<td><c:out value="${eachDocs.autoridadEmisora}" /></td>
										<td><c:out value="${eachDocs.asunto}" /></td>
										<td><c:out value="${eachDocs.fechaNotificacion}" /></td>

										<c:choose>
											<c:when test="${not empty mensajeError}">
												<td>
													<c:forEach items="${eachDocs.errores}" var="eachError">
														<c:choose>
															<c:when test="${eachError.txt_msj != '' && eachError.id_msj == '4'}">
																<c:out value="${eachError.txt_msj}"/><br>
															</c:when>
														</c:choose>
													</c:forEach>
												</td>
											</c:when>
											<c:otherwise>
												<c:forEach items="${eachDocs.documentos}" var="echDocumentosNot">
													<c:if test="${echDocumentosNot.pdf != ''}">
														<td><label class="control-label downloadNoti"
															style="text-transform: capitalize !important"
															id="downloadNoti"
															data-pdfimprimir="${echDocumentosNot.pdf}"
															data-idRadicado="${eachDocs.id_radicado}"
															data-autoridadEmisora="${eachDocs.autoridadEmisora}"
															data-asunto="${eachDocs.asunto}"
															data-fechaNotificacion="${eachDocs.fechaNotificacion}"
															onclick="downloadNoti(this)"> <span
																class="glyphicon glyphicon-download-alt"></span></label></td>
													</c:if>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</tr>

								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-6 col-md-offset-3 headline">
				<h2>
					<span><spring:theme code="mibuzon.notificaciones.leidos" /></span>
				</h2>
			</div>
		</div>
		<div>
			<div class="row">

				<div class="col-md-8 col-md-offset-2 center">
					<table class="table table-responsive" id="tabPaginacion3">
						<thead>
							<tr>
								<th style="text-align: center"><label
									class="control-label "
									style="text-transform: capitalize !important" for=""><spring:theme
											code="mibuzon.notificaciones.identi" /></label></th>
								<th style="text-align: center"><label class="control-label"
									style="text-transform: capitalize !important" for=""> <spring:theme
											code="mibuzon.notificaciones.autoridad" /></label></th>
								<th style="text-align: center"><label class="control-label"
									style="text-transform: capitalize !important" for=""> <spring:theme
											code="mibuzon.notificaciones.asunto" /></label></th>
								<th style="text-align: center"><label class="control-label"
									style="text-transform: capitalize !important" for=""> <spring:theme
											code="mibuzon.notificaciones.fecnoti" /></label></th>
								<th style="text-align: center"><label class="control-label"
									style="text-transform: capitalize !important" for=""> <spring:theme
											code="mibuzon.notificaciones.anexos" /></label></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${miBuzon.mensajesMsg}" var="eachDocs">
								<c:set var="mensajeError" value=""/>
								<c:if test="${eachDocs.tipoMensaje == '1' && eachDocs.checkLectura == 'X'}">
									<c:forEach items="${eachDocs.errores}" var="eachError">
										<c:choose>
											<c:when test="${eachError.txt_msj != '' && eachError.id_msj == '4'}">
												<c:set var="mensajeError" value="${mensajeError} ${eachError.txt_msj}"/>
											</c:when>
										</c:choose>
									</c:forEach>
									
									<tr>
										<td><c:out value="${eachDocs.id_radicado}" /></td>
										<td><c:out value="${eachDocs.autoridadEmisora}" /></td>
										<td><c:out value="${eachDocs.asunto}" /></td>
										<td><c:out value="${eachDocs.fechaNotificacion}" /></td>
										<c:choose>
											<c:when test="${not empty mensajeError}">
												<td>
													<c:forEach items="${eachDocs.errores}" var="eachError">
														<c:choose>
															<c:when test="${eachError.txt_msj != '' && eachError.id_msj == '4'}">
																<c:out value="${eachError.txt_msj}"/><br>
															</c:when>
														</c:choose>
													</c:forEach>
												</td>
											</c:when>
											<c:otherwise>
												<c:forEach items="${eachDocs.documentos}" var="echDocumentosNot">
													<c:if test="${echDocumentosNot.pdf != ''}">
														<td><label class="control-label downloadNoti"
															style="text-transform: capitalize !important"
															id="downloadNoti"
															data-pdfimprimir="${echDocumentosNot.pdf}"
															data-idRadicado="${eachDocs.id_radicado}"
															data-autoridadEmisora="${eachDocs.autoridadEmisora}"
															data-asunto="${eachDocs.asunto}"
															data-fechaNotificacion="${eachDocs.fechaNotificacion}"
															onclick="downloaddosNoti(this)"> <span
																class="glyphicon glyphicon-download-alt"></span></label></td>
													</c:if>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</tr>

								</c:if>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>

	</sf:form>

</div>

<script>
	function downloadNoti(objectnoti) {
		ACC.mibuzon.descargarNoti1_v2(objectnoti);
	}

	function downloaddosNoti(objectnoti2) {
		ACC.mibuzon.descargarNoti2(objectnoti2);
	}
</script>
