<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<div class="row" id="div_titulo_reteica" style="display:none;">
	<h2><span><spring:theme code="obligacion.sujeto.reteica.titulo" /></span></h2>
</div>

<!-- <div class="container" style="margin-top: -400px!important;"> -->
<!-- 		<div id="oblipend-reteica" class="oblipend-table" -->
<!-- 			style="display: none;"> -->
<%-- 			<c:if test="${not empty obligacionesFormuno.headerreteica}"> --%>
		
<!-- 				<div class="row"> -->
<!-- 					<div class="col-md-12 text-center" style="margin-top: -300px!important;"> -->
<!-- 						<div class="table-responsive"> -->
<!-- 							<table class="tablesearch table table-bordered" -->
<!-- 								id="tabPaginacion5"> -->
<!-- 								<thead> -->
<!-- 									<tr> -->
<%-- 										<th><label class="control-label labeltabletd tabledoobli"><spring:theme --%>
<%-- 													code="obligacion.inicial.delineacion.aniograv" /> </label></th> --%>
<%-- 													<th><label class="control-label labeltabletd tabledoobli"><spring:theme --%>
<%-- 													code="obligacion.sujeto.reteica.periodo" /> </label></th> --%>
<%-- 										<th><label class="control-label labeltabletd tableangrav"><spring:theme --%>
<%-- 													code="obligacion.inicial.delineacion.edoobli" /> </label></th> --%>
<%-- 										<th><label class="control-label labeltabletd"><spring:theme --%>
<%-- 													code="obligacion.inicial.delineacion.obligacion" /> </label></th> --%>
<%-- 										<th><label class="control-label labeltabletd"><spring:theme --%>
<%-- 													code="obligacion.inicial.delineacion.numForm" /> </label></th> --%>
<%-- 										<th><label class="control-label labeltabletd"><spring:theme --%>
<%-- 													code="obligacion.inicial.delineacion.numRef" /> </label></th> --%>
													
<!-- 										<th style="text-align: center !important"><label -->
<%-- 										class="control-label labeltabletd"> <spring:theme --%>
<%-- 												code="obligacion.inicial.predio.totPagar" /> --%>
<!-- 										</label></th> -->
										
<%-- 										<th><label class="control-label labeltabletd"><spring:theme --%>
<%-- 													code="obligacion.inicial.delineacion.obcontra" /> </label></th> --%>
<%-- 										<th><label class="control-label labeltabletd "><spring:theme --%>
<%-- 													code="obligacion.inicial.delineacion.rop" /> </label></th> --%>
<%-- 										<th><label class="control-label labeltabletd"><spring:theme --%>
<%-- 													code="obligacion.inicial.delineacion.pagar" /> </label></th> --%>
<!-- 									</tr> -->
<!-- 								</thead> -->
<!-- 								<tbody> -->
<%-- 									<c:forEach items="${obligacionesFormuno.headerreteica}" --%>
<%-- 										var="eachReteIca"> --%>
<%-- 										<c:set var="clavePeriodo" value="${fn:substring(eachReteIca.anioGravable, 2, 5)}A1"/> --%>
<%-- 										<c:if test="${not empty eachReteIca.periodo}"> --%>
<%-- 											<c:set var="clavePeriodo" value="${fn:substring(eachReteIca.anioGravable, 2, 5)}B${fn:substring(eachReteIca.periodo, 1, 2)}"/> --%>
<%-- 										</c:if> --%>
<%-- 										<c:forEach items="${eachReteIca.details}" var="eachReteIcaDet"> --%>
<%-- 											<c:if test="${not empty eachReteIcaDet.numReferencia}"> --%>
<!-- 												<tr> -->
<%-- 													<td><c:out value="${eachReteIca.anioGravable}" /></td> --%>
<%-- 													<td><c:out value="${eachReteIca.periodo}" /></td> --%>
<%-- 													<td><c:out value="${eachReteIcaDet.estadoObligacion}" /></td> --%>
<%-- 													<td><c:out value="${eachReteIcaDet.obligacion}" /></td> --%>
<%-- 													<td><c:out value="${eachReteIcaDet.numFormulario}" /></td> --%>
<%-- 													<td><c:out value="${eachReteIcaDet.numReferencia}" /></td> --%>
													
													
<!-- 													INI  TOTAL A PAGAR -->
<%-- 													<c:choose> --%>
<%-- 														<c:when test="${eachReteIca.facilidad == '00'}"> --%>
<%-- 															<td><c:out value="${eachReteIcaDet.obligacion}" /></td> --%>
<%-- 														</c:when> --%>
<%-- 														<c:when test="${eachReteIca.facilidad == '01'}"> --%>
<%-- 															<td><c:out value="${eachReteIca.montoFacilidad}" /></td> --%>
<%-- 														</c:when> --%>
<%-- 														<c:when test="${eachReteIca.facilidad == '02'}"> --%>
<%-- 															<td><c:out value="${eachReteIca.montoFacilidad}" /></td> --%>
<%-- 														</c:when> --%>
<%-- 														<c:otherwise> --%>
<%-- 															<td><c:out value="${eachReteIcaDet.obligacion}" /></td> --%>
<%-- 														</c:otherwise> --%>
<%-- 													</c:choose>												 --%>
<!-- 													FIN TOTAL A PAGAR -->
													
													
<%-- 													<td><c:out value="${eachReteIcaDet.objetoContrato}" /></td> --%>
													
<!-- 													INI ROP -->
<%-- 													<c:choose> --%>
<%-- 														<c:when test="${eachReteIca.facilidad == '00'}"> --%>
<!-- 															<td><a -->
<%-- 															href="<c:url value="/contribuyentes/rop?obligacion=${eachReteIcaDet.obligacion}&totalPagar=${eachReteIcaDet.obligacion}&tpImp=31&objCont=${eachReteIcaDet.objetoContrato}&clvPer=${clavePeriodo}" />">Generar --%>
<!-- 																ROP</a></td> -->
<%-- 														</c:when> --%>
<%-- 														<c:when test="${eachReteIca.facilidad == '01'}"> --%>
<!-- 															<td><a -->
<%-- 															href="<c:url value="/contribuyentes/rop?obligacion=${eachReteIcaDet.obligacion}&totalPagar=${eachReteIca.montoFacilidad}&tpImp=31&objCont=${eachReteIcaDet.objetoContrato}&clvPer=${clavePeriodo}" />">Generar --%>
<!-- 																ROP</a></td> -->
<%-- 														</c:when> --%>
<%-- 														<c:when test="${eachReteIca.facilidad == '02'}"> --%>
<%-- 															<td><label class="control-label labeltabletd"> <spring:theme --%>
<%-- 															code="obligacion.inicial.sinROP" /></label></td> --%>
<%-- 														</c:when> --%>
<%-- 														<c:otherwise> --%>
<!-- 															<td><a -->
<%-- 															href="<c:url value="/contribuyentes/rop?obligacion=${eachReteIcaDet.obligacion}&totalPagar=${eachReteIcaDet.obligacion}&tpImp=31&objCont=${eachReteIcaDet.objetoContrato}&clvPer=${clavePeriodo}" />">Generar --%>
<!-- 																ROP</a></td> -->
<%-- 														</c:otherwise> --%>
<%-- 													</c:choose>									 --%>
<!-- 													FIN ROP -->
													
													
<!-- 													INI PAGO VIGENTE -->
<%-- 													<c:choose> --%>
<%-- 														<c:when test="${eachReteIca.refActiva == '02'}"> --%>
<!-- 															<td><label class="control-label" -->
<!-- 															style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important" -->
<!-- 															id="Detalle" onclick="noActivo()">Pagar</label></td> -->
<%-- 														</c:when> --%>
<%-- 														<c:otherwise> --%>
<%-- 															<c:choose> --%>
<%-- 																<c:when test="${eachReteIca.facilidad == '00'}"> --%>
<!-- 																	<td><label class="control-label" -->
<!-- 																	style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important" -->
<!-- 																	id="Detalle" -->
<%-- 																	onclick="pagarEnLinea('5102','${eachReteIca.anioGravable}','${eachReteIca.periodo}','${eachReteIcaDet.objetoContrato}','', '${eachReteIcaDet.fechaVencimiento}', '${eachReteIcaDet.numReferencia}','${eachReteIcaDet.obligacion}','','','${eachReteIca.facilidad}','${eachReteIca.montoFacilidad}' )">Pagar</label></td> --%>
<%-- 																</c:when> --%>
<%-- 																<c:when test="${eachReteIca.facilidad == '01'}"> --%>
<!-- 																	<td><label class="control-label" -->
<!-- 																	style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important" -->
<!-- 																	id="Detalle" -->
<%-- 																	onclick="pagarEnLinea('5102','${eachReteIca.anioGravable}','${eachReteIca.periodo}','${eachReteIcaDet.objetoContrato}','', '${eachReteIcaDet.fechaVencimiento}', '${eachReteIcaDet.numReferencia}','${eachReteIca.montoFacilidad}','','','${eachReteIca.facilidad}','${eachReteIca.montoFacilidad}' )">Pagar</label></td> --%>
<%-- 																</c:when> --%>
<%-- 																<c:when test="${eachReteIca.facilidad == '02'}"> --%>
<!-- 																	<td><label class="control-label" -->
<!-- 																	style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important" -->
<!-- 																	id="Detalle" -->
<%-- 																	onclick="pagarEnLinea('5102','${eachReteIca.anioGravable}','${eachReteIca.periodo}','${eachReteIcaDet.objetoContrato}','', '${eachReteIcaDet.fechaVencimiento}', '${eachReteIcaDet.numReferencia}','${eachReteIca.montoFacilidad}','','','${eachReteIca.facilidad}','${eachReteIca.montoFacilidad}' )">Pagar</label></td> --%>
<%-- 																</c:when> --%>
<%-- 																<c:otherwise> --%>
<!-- 																	<td><label class="control-label" -->
<!-- 																	style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important" -->
<!-- 																	id="Detalle" -->
<%-- 																	onclick="pagarEnLinea('5102','${eachReteIca.anioGravable}','${eachReteIca.periodo}','${eachReteIcaDet.objetoContrato}','', '${eachReteIcaDet.fechaVencimiento}', '${eachReteIcaDet.numReferencia}','${eachReteIcaDet.obligacion}','','','${eachReteIca.facilidad}','${eachReteIca.montoFacilidad}' )">Pagar</label></td> --%>
<%-- 																</c:otherwise> --%>
<%-- 															</c:choose>												 --%>
<%-- 														</c:otherwise> --%>
<%-- 													</c:choose>												 --%>
<!-- 													FIN PAGO VIGENTE -->
													
												
<!-- 											</tr> -->
<%-- 											</c:if> --%>
<%-- 										</c:forEach> --%>
<%-- 									</c:forEach> --%>
<!-- 								</tbody> -->
<!-- 							</table> -->
<!-- <!-- 							<div class="col-md-3 col-md-offset-8"> --> -->
<!-- <!-- 								<button type="button" class="btn btn-primary btn-lg" id="action" --> -->
<!-- <!-- 									name="action" value="Imprimir" style="margin-top: 3px" --> -->
<!-- <!-- 									onclick="ACC.oblipend.bindTrmPdf('08','1','reteicaReporte.pdf');"> --> -->
<%-- <%-- 									<spring:theme code="obligacion.inicial.imprimir" /> --%> --%>
<!-- <!-- 								</button> --> -->
<!-- <!-- 							</div> --> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${empty obligacionesFormuno.headerreteica}"> --%>
<!-- 				<div class="row" style="margin-top: -1200px"> -->
<!-- 					<div class="col-md-12" style="margin-top: -300px !important;"> -->
<%-- 						<label class="control-label" style="text-transform: none;"><spring:theme --%>
<%-- 								code="obligaciones.mensaje.reteica" /></label> --%>
<!-- 					</div> -->
<!-- 				</div> -->

<%-- 			</c:if> --%>
<!-- 			<div class="col-md-3 col-md-offset-8"> -->
<!-- 				<button type="button" class="btn btn-primary btn-lg" id="action" -->
<!-- 					name="action" value="Imprimir" style="margin-top: 3px" -->
<!-- 					onclick="ACC.oblipend.bindTrmPdf('08','1','reteicaReporte.pdf');"> -->
<%-- 					<spring:theme code="obligacion.inicial.imprimir" /> --%>
<!-- 				</button> -->
<!-- 			</div> -->
<!--  		</div> -->
<!-- </div> -->
