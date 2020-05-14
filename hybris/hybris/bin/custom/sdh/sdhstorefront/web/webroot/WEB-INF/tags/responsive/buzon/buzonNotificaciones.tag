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
			<div class="col-md-4 col-md-offset-3 center headline">
				<h2>
					<span><spring:theme code="mibuzon.notificaciones.nuevos" /></span>
				</h2>
			</div>
		</div>
		<div>
			<div class="row">

				<div class="col-md-7 col-md-offset-3 center">
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
<%-- 						<c:if test="${miBuzon.tipoMensaje == '1'}"> --%>
<%-- 									<c:forEach items="${miBuzon.documentos}" var="eachDocs"> --%>
<!-- 							<tr> -->
<%-- 								<td><c:out value="${miBuzon.idRadicado}" /></td> --%>
<%-- 						    	<td><c:out value="${miBuzon.autoridadEmisora}" /></td> --%>
<%-- 								<td><c:out value="${eachDocs.nombredocumento}" /></td> --%>
<%-- 								<td><c:out value="${miBuzon.fechaNotificacion}" /></td> --%>
<!-- 							    <td><label class="control-label downloadNoti" -->
<%-- 									style="text-transform: capitalize !important" id="downloadNoti" data-pdfimprimir="${eachDocs.pdf}" data-identifi="${miBuzon.idRadicado}" data-autoridad="${miBuzon.autoridadEmisora}" --%>
<%-- 																		data-asunto="${eachDocs.nombredocumento}" --%>
<%-- 																		data-fechaNotificacion="${miBuzon.fechaNotificacion}" onclick="downloadNoti1(this)"> <span --%>
<!-- 										class="glyphicon glyphicon-download-alt"></span></label></td> -->
<!-- 							</tr> -->
<%-- 							</c:forEach> --%>
<%-- 							</c:if> --%>
								<tr>
								<td><c:out value="idRadicado1" /></td>
						    	<td><c:out value="autoridadEmisora1" /></td>
								<td><c:out value="nombredocumento1" /></td>
								<td><c:out value="fechaNotificacion1" /></td>
							    <td><label class="control-label downloadNoti"
									style="text-transform: capitalize !important" id="downloadNoti" data-pdfimprimir="${eachDocs.pdf}" data-idRadicado="idRadicado1" data-autoridadEmisora="autoridadEmisora1"
																		data-asunto="nombredocumento1"
																		data-fechaNotificacion="fechaNotificacion1" onclick="downloadNoti1(this)"> <span
										class="glyphicon glyphicon-download-alt"></span></label></td>
							</tr>
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

				<div class="col-md-7 col-md-offset-3 center">
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
							<tr>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="<c:out value="identifi"></c:out>" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
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
									<td><label class="control-label downloadNotileidos"
									style="text-transform: capitalize !important" id="downloadNotiLeidos" data-pdfimprimir="${eachDocs.pdf}" data-identifi="${eachDoc.pdf}" data-autoridad="mil"
																		data-asunto="perro2"
																		data-fechaNotificacion="mensaje" data-documento="cacahuate5" onclick="downloaddosNoti(this)"> <span
										class="glyphicon glyphicon-download-alt"></span></label></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</sf:form>
</div>

<script>
 function downloadNoti1(objectnoti1){
	ACC.mibuzon.descargarNoti(objectnoti1);
	objectnoti1.offsetParent.parentNode.remove();
}
 
 function downloaddosNoti(objectnoti2){
	 ACC.mibuzon.descargarNoti2(objectnoti2);
 }
 </script>
