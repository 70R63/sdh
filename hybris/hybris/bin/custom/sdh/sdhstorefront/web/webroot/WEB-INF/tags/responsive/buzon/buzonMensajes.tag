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
				<div class="col-md-6 col-md-offset-3 center headline">
					<h2>
						<span><spring:theme code="mibuzon.mensajes.nuevos" /></span>
					</h2>
				</div>
			</div>
			<div>
				<div class="row">

					<div class="col-md-7 col-md-offset-3 center">
						<table class="table table-responsive" id="tabPaginacion0">
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
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for="">
											<spring:theme code="mibuzon.mensajes.papelera" />
									</label></th>
								</tr>
							</thead>
							<tbody>



<!-- Este es el bueno -->
<%-- 								<c:if test="${miBuzon.tipoMensaje == '1'}"> --%>
<%-- 									<c:forEach items="${miBuzon.documentos}" var="eachDoc"> --%>
<!-- 																<tr> -->
<%-- 																	<td><c:out value="${miBuzon.idRadicado}" /></td> --%>
<%-- 																	<td><c:out value="${miBuzon.autoridadEmisora}" /></td> --%>
<%-- 																	<td><c:out value="${eachDoc.nombredocumento}" /></td> --%>
<%-- 																	<td><c:out value="${miBuzon.fechaNotificacion}" /></td> --%>
<!-- 																	<td><label class="control-label download" -->
<!-- 																		style="text-transform: capitalize !important" for="" -->
<%-- 																		data-pdfimprimir="${eachDoc.pdf}" data-idRadicado="${miBuzon.idRadicado}" --%>
<%-- 																		data-autoridadEmisora="${miBuzon.autoridadEmisora}" --%>
<%-- 																		data-fechaNotificacion="${miBuzon.fechaNotificacion}" data-asunto="${eachDoc.nombredocumento}" --%>
<!-- 																		id="download"> <span -->
<!-- 																			class="glyphicon glyphicon-download-alt"></span></label></td> -->
<!-- 																	<td><img -->
<%-- 																		src="${themeResourcePath}/images/papeleranuevos.png" --%>
<%-- 																		style="width: 30px" id="papeleraMsg" class="papeleraMsg" onclick="papeleraMsgLeidos(this)" data-pdfimprimir="${eachDoc.pdf}" data-idRadicado="${miBuzon.idRadicado}" --%>
<%-- 																		data-autoridadEmisora="${miBuzon.autoridadEmisora}" --%>
<%-- 																		data-fechaNotificacion="${miBuzon.fechaNotificacion}" data-asunto="${eachDoc.nombredocumento}"></img></td> --%>
<!-- 																</tr> -->
<%-- 									</c:forEach> --%>
<%-- 								</c:if> --%>

																<tr>
																	<td><c:out value="mensaje1" /></td>
																	<td><c:out value="autoridad1" /></td>
																	<td><c:out value="asunto1" /></td>
																	<td><c:out value="fecha1" /></td>
																	<td><label class="control-label download"
																		style="text-transform: capitalize !important" for=""
																		data-pdfimprimir="${eachDoc.pdf}" data-idRadicado="mensaje1"
																		data-autoridadEmisora="autoridad1"
																		data-fechaNotificacion="fecha1" data-asunto="asunto1"
																		id="download"> <span
																			class="glyphicon glyphicon-download-alt"></span></label></td>
																	<td><img
																		src="${themeResourcePath}/images/papeleranuevos.png"
																		style="width: 30px" id="papeleraMsg" class="papeleraMsg" onclick="papeleraMsgLeidos(this)" data-pdfimprimir="${eachDoc.pdf}" data-idRadicado="mensaje1"
																		data-autoridadEmisora="autoridad1"
																		data-fechaNotificacion="fecha1" data-asunto="asunto1"></img></td>
																</tr>
																<tr>
																	<td><c:out value="mensaje2" /></td>
																	<td><c:out value="autoridad2" /></td>
																	<td><c:out value="asunto2" /></td>
																	<td><c:out value="fecha2" /></td>
																	<td><label class="control-label download"
																		style="text-transform: capitalize !important" for=""
																		data-pdfimprimir="${eachDoc.pdf}" data-idRadicado="mensaje2"
																		data-autoridadEmisora="autoridad1"
																		data-fechaNotificacion="fecha2" data-asunto="asunto2"
																		id="download"> <span
																			class="glyphicon glyphicon-download-alt"></span></label></td>
																	<td><img
																		src="${themeResourcePath}/images/papeleranuevos.png"
																		style="width: 30px" id="papeleraMsg" class="papeleraMsg" onclick="papeleraMsgLeidos(this)" data-pdfimprimir="${eachDoc.pdf}" data-idRadicado="mensaje2"
																		data-autoridadEmisora="autoridad2"
																		data-fechaNotificacion="fecha2" data-asunto="asunto2"></img></td>
																</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>



			<div class="row">
				<div class="col-md-6 col-md-offset-3 headline">
					<h2>
						<span><spring:theme code="mibuzon.mensajes.leidos" /></span>
					</h2>
				</div>
			</div>
			<div>
				<div class="row">

					<div class="col-md-7 col-md-offset-3 center">
						<table class="table table-responsive tabPaginacion1"
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
									<th style="text-align: center"><label
										class="control-label"
										style="text-transform: capitalize !important" for="">
											<spring:theme code="mibuzon.mensajes.papelera" />
									</label></th>
									<th style="visibility:hidden;"> </th>
								</tr>
							</thead>
							<tbody>
<%-- 							<c:if test="${miBuzon.tipoMensaje == '2'}"> --%>
<%-- 									<c:forEach items="${miBuzon.documentos}" var="eachDocs"> --%>
<!-- 							<tr> -->
<%-- 							<td><c:out value="${miBuzon.idRadicado}" /></td> --%>
<%-- 							<td><c:out value="${miBuzon.autoridadEmisora}" /></td> --%>
<%-- 							<td><c:out value="${eachDocs.nombredocumento}" /></td> --%>
<%-- 							<td><c:out value="${miBuzon.fechaNotificacion}" /></td>			 --%>
<!-- 						    <td><label class="control-label download2" -->
<!-- 										style="text-transform: capitalize !important" for="" -->
<%-- 										id="download2" onclick="downloaddos(this)" data-pdfimprimir="${eachDocs.pdf}"> <span --%>
<!-- 											class="glyphicon glyphicon-download-alt"></span></label></td> -->
<!-- 							<td><img -->
<%-- 										src="${themeResourcePath}/images/papeleraleidos.png" --%>
<!-- 										style="width: 20px" onclick="eliminarleidos(this)"></img></td> -->
										
<!-- 										<td style="visibility: hidden;"></td> -->
<!-- 								</tr> -->
<%-- 								</c:forEach> --%>
<%-- 								</c:if> --%>

							<tr>
							<td><c:out value="leido1" /></td>
							<td><c:out value="leido1" /></td>
							<td><c:out value="leido1" /></td>
							<td><c:out value="leido1" /></td>			
						    <td><label class="control-label download2"
										style="text-transform: capitalize !important" for=""
										id="download2" onclick="downloaddos(this)" data-pdfimprimir="${eachDocs.pdf}"> <span
											class="glyphicon glyphicon-download-alt"></span></label></td>
							<td><img
										src="${themeResourcePath}/images/papeleraleidos.png"
										style="width: 20px" onclick="eliminarleidos(this)"></img></td>
										
										<td style="visibility: hidden;"></td>
								</tr>


							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</sf:form>
	<div>
		<a id='dwnldLnk' download='nombrecocumento.pdf' style="display: none;" />
	</div>
</div>

<script>
 function downloaddos(obdesc){
	 var objetode = obdesc;
	ACC.mibuzon.bindDescargar2(objetode);
}
 
 function papeleraMsgLeidos(object){
	 var objectf = object;
	 ACC.mibuzon.bindPapeleraNuevos(objectf);
	 objectf.offsetParent.parentNode.remove();

 }

 function eliminarleidos(objectEl){
	 var objecteliminar = objectEl;
	 objectEl.offsetParent.parentNode.remove();
 }
</script>