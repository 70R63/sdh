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
								<c:if test="${miBuzon.tipoMensaje == '2'}">
									<c:forEach items="${miBuzon.documentos}" var="eachDoc">
										<tr>
											<td><c:out value="${miBuzon.idRadicado}" /></td>
											<td><c:out value="${miBuzon.autoridadEmisora}" /></td>
											<td><c:out value="${eachDoc.nombredocumento}" /></td>
											<td><c:out value="${miBuzon.fechaNotificacion}" /></td>
											<td><label class="control-label download"
												style="text-transform: capitalize !important" for=""
												data-pdfimprimir="${eachDoc.pdf}" id="download"> <span
													class="glyphicon glyphicon-download-alt"></span></label></td>
											<td><img
												src="${themeResourcePath}/images/papeleranuevos.png"
												style="width: 30px"></img></td>
										</tr>
									</c:forEach>
								</c:if>
								<!-- 								<tr> -->
								<%-- 									<td><c:out value="perro1" /></td> --%>
								<%-- 									<td><c:out value="cacahuate" /></td> --%>
								<%-- 									<td><c:out value="miramar" /></td> --%>
								<%-- 									<td><c:out value="osoapalstado" /></td> --%>
								<!-- 									<td><label class="control-label download" -->
								<!-- 										style="text-transform: capitalize !important" for="" -->
								<%-- 										data-pdfimprimir="${eachDoc.pdf}" data-idRadicado="mil" --%>
								<!-- 										data-autoridadEmisora="perro2" -->
								<!-- 										data-fechaNotificacion="mensaje" data-asunto="cacahuate3" -->
								<!-- 										data-checkBoxLectura="cacahuate4" data-documentos="cacahuate5" -->
								<!-- 										id="download"> <span -->
								<!-- 											class="glyphicon glyphicon-download-alt"></span></label></td> -->
								<!-- 									<td><img -->
								<%-- 										src="${themeResourcePath}/images/papeleranuevos.png" --%>
								<!-- 										style="width: 30px"></img></td> -->
								<!-- 								</tr> -->
								<!-- 								<tr> -->
								<%-- 									<td><c:out value="perro2" /></td> --%>
								<%-- 									<td><c:out value="cacahuate" /></td> --%>
								<%-- 									<td><c:out value="miramar" /></td> --%>
								<%-- 									<td><c:out value="osoapalstado" /></td> --%>
								<!-- 									<td><label class="control-label download" -->
								<!-- 										style="text-transform: capitalize !important" for="" -->
								<%-- 										data-pdfimprimir="${eachDoc.pdf}" id="download"> <span --%>
								<!-- 											class="glyphicon glyphicon-download-alt"></span></label></td> -->
								<!-- 									<td><img -->
								<%-- 										src="${themeResourcePath}/images/papeleranuevos.png" --%>
								<!-- 										style="width: 30px"></img></td> -->
								<!-- 								</tr> -->
								<!-- 								<tr> -->
								<%-- 									<td><c:out value="perro3" /></td> --%>
								<%-- 									<td><c:out value="cacahuate" /></td> --%>
								<%-- 									<td><c:out value="miramar" /></td> --%>
								<%-- 									<td><c:out value="osoapalstado" /></td> --%>
								<!-- 									<td><label class="control-label download" -->
								<!-- 										style="text-transform: capitalize !important" for="" -->
								<%-- 										data-pdfimprimir="${eachDoc.pdf}" id="download"> <span --%>
								<!-- 											class="glyphicon glyphicon-download-alt"></span></label></td> -->
								<!-- 									<td><img -->
								<%-- 										src="${themeResourcePath}/images/papeleranuevos.png" --%>
								<!-- 										style="width: 30px"></img></td> -->
								<!-- 								</tr> -->
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
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><c:out value="" /></td>
									<td><input id="" name="" class="inputtextnew"
										aria-required="true" type="text" readonly="readonly"
										value="<c:out value="autoridad"></c:out>" maxlength="240"
										style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
									<td><input id="" name="" class="inputtextnew"
										aria-required="true" type="text" readonly="readonly"
										value="<c:out value="asunto"></c:out>" maxlength="240"
										style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
									<td><input id="" name="" class="inputtextnew"
										aria-required="true" type="text" readonly="readonly"
										value="<c:out value="fechanotificacion"></c:out>"
										maxlength="240"
										style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
									<td><label class="control-label download2"
										style="text-transform: capitalize !important" for=""
										id="download2"> <span
											class="glyphicon glyphicon-download-alt"></span></label></td>

									<td><img
										src="${themeResourcePath}/images/papeleraleidos.png"
										style="width: 20px"></img></td>
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
