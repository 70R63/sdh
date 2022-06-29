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
	<div class="row" id="idmensajes">
		<div class="col-md-6 col-md-offset-1 headline">
			<h2>
				<span><spring:theme code="mibuzon.mensajes.mensajes" /></span>
			</h2>
		</div>
	</div>
	<sf:form>
		<div style="aling-items: center; justify-content: center">
			<div class="row">
				<div class="col-md-8 headline">
					<h2>
						<span><spring:theme code="mibuzon.mensajes.nuevos" /></span>
					</h2>
				</div>
			</div>
			<div>
				<div class="row table-responsive">
					<div class="col-md-11 center">
						<table class="table" id="tabPaginacion0">
							<thead>
								<tr>
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for=""><spring:theme
												code="mibuzon.mensajes.identi" /></label></th>
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for="">
											<spring:theme code="mibuzon.mensajes.autoridad" />
									</label></th>
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for="">
											<spring:theme code="mibuzon.mensajes.asunto" />
									</label></th>
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for="">
											<spring:theme code="mibuzon.mensajes.fecnoti" />
									</label></th>
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for="">
											<spring:theme code="mibuzon.notificaciones.anexos" />
									</label></th>
<!-- 									<th style="text-align: center"><label -->
<!-- 										class="control-label" -->
<!-- 										style="text-transform: capitalize !important" for=""> -->
<%-- 											<spring:theme code="mibuzon.mensajes.papelera" /> --%>
<!-- 									</label></th> -->
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${miBuzon.mensajesMsg}" var="eachDoc">
									<c:if
										test="${eachDoc.tipoMensaje == '2' && eachDoc.checkLectura != 'X'}">
											<tr>
											<td><input class="tableBuzon" disabled="disabled" type="text" value="${eachDoc.id_radicado}"></td>
											<td><c:out value="${eachDoc.autoridadEmisora}" /></td>
											<td><c:out value="${eachDoc.asunto}" /></td>
											<td><c:out value="${eachDoc.fechaNotificacion}" /></td>
											<td></td>
										</tr>
										
										
											<c:set var="count" value="0" scope="page" />
											<c:forEach items="${eachDoc.documentos}" var="echDocumentos">
											<c:if test="${echDocumentos.nombreDocumento != ''}">
											<tr>
												<c:set var="count" value="${count + 1}" scope="page"/>
													<td><input class="tableBuzon" disabled="disabled" type="text" value="Anexo ${count}"></td>
													<td><c:out value="${echDocumentos.nombreDocumento}"/></td>
													<td></td>
													<td>${eachDoc.fechaNotificacion}</td>
													<td><label class="control-label download"
														style="text-transform: capitalize !important" for=""
														data-name="Anexo ${countNot}"
														data-numBP="${miBuzon.numBP}"
														data-idDocumento="${echDocumentos.idDocumento}"
														data-idRadicado="${eachDoc.id_radicado}" onclick="descargarNoti(this)"> <span
															class="glyphicon glyphicon-download-alt"></span></label></td>
												</tr>
												</c:if>
											</c:forEach>
										
										</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>



			<div class="row">
				<div class="col-md-8 col-md-offset-2 headline">
					<h2>
						<span><spring:theme code="mibuzon.mensajes.leidos" /></span>
					</h2>
				</div>
			</div>
			<div>
				<div class="row table-responsive">

					<div class="col-md-11  center">
						<table class="table table-responsive"
							id="tabPaginacion1">
							<thead>
								<tr>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important" for=""><spring:theme
												code="mibuzon.mensajes.identi" /></label></th>
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for="">
											<spring:theme code="mibuzon.mensajes.autoridad" />
									</label></th>
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for="">
											<spring:theme code="mibuzon.mensajes.asunto" />
									</label></th>
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for="">
											<spring:theme code="mibuzon.mensajes.fecnoti" />
									</label></th>
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for="">
											<spring:theme code="mibuzon.notificaciones.anexos" />
									</label></th>
<!-- 									<th style="text-align: center"><label -->
<!-- 										class="control-label" -->
<!-- 										style="text-transform: capitalize !important" for=""> -->
<%-- 											<spring:theme code="mibuzon.mensajes.papelera" /> --%>
<!--								</label></th> Se comenta linea por cambios MTorres 21.06.2022 -->
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${miBuzon.mensajesMsg}" var="eachDoc">
									<c:if
										test="${eachDoc.tipoMensaje == '2' && eachDoc.checkLectura == 'X'}">
										<tr>
											<td><input class="tableBuzon" disabled="disabled" type="text" value="${eachDoc.id_radicado}"></td>
											<td><c:out value="${eachDoc.autoridadEmisora}" /></td>
											<td><c:out value="${eachDoc.asunto}" /></td>
											<td><c:out value="${eachDoc.fechaNotificacion}" /></td>
											<td></td>
										</tr>
										
											<c:set var="count" value="0" scope="page" />
											<c:forEach items="${eachDoc.documentos}" var="echDocumentos">
											<c:if test="${echDocumentos.nombreDocumento != ''}">
											<tr>
												
												<c:set var="count" value="${count + 1}" scope="page"/>
													<td><input class="tableBuzon " disabled="disabled" type="text" value="Anexo ${count}"></td>
													<td><c:out value="${echDocumentos.nombreDocumento}"/></td>
													<td></td>
													<td>${eachDoc.fechaNotificacion}</td>
													<td><label class="control-label download"
														style="text-transform: capitalize !important" for=""
														data-name="Anexo ${countNot}"
														data-numBP="${miBuzon.numBP}"
														data-idDocumento="${echDocumentos.idDocumento}"
														data-idRadicado="${eachDoc.id_radicado}" onclick="descargarNoti(this)"> <span
															class="glyphicon glyphicon-download-alt"></span></label></td>
											
													</tr>
														</c:if>
											</c:forEach>
									

									</c:if>

								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<a id='dwnldLnk' download='nombredocumento.pdf'
				style="display: none;" />
		</div>
	</sf:form>


</div>

<script>
	function descargarNoti(obdesca) {
		var objetodeN = obdesca;
		ACC.mibuzon.bindDescargar(objetodeN);
		objetodeN.offsetParent.parentNode.remove();
	}

	function downloaddos(obdesc) {
		var objetode = obdesc;
		ACC.mibuzon.bindDescargar2(objetode);
	}

	function papeleraMsgLeidos(object) {
		var objectf = object;
		ACC.mibuzon.bindPapeleraNuevos(objectf);
		objectf.offsetParent.parentNode.remove();

	}

	function eliminarleidos(objectEl) {
		var objecteliminar = objectEl;
		objectEl.offsetParent.parentNode.remove();
	}
</script>