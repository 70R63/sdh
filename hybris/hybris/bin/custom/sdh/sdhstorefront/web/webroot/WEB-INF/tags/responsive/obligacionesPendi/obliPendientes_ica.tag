<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<div class="row" id="div_titulo_ica" style="display:none;">
	<h2><span><span><spring:theme code="obligacion.sujeto.ica.titulo" /></span></span></h2>
</div>
<div id="oblipend-ica" class="oblipend-table" style="display: none;">
	<table class="tablesearch table" id="tabPaginacion2">
		<thead>
			<tr>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.ica.aniograv" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.ica.periodo" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.ica.edoobli" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.ica.obligacion" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.ica.numForm" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.ica.numRef" /></label></th>
				<th style="text-align: center !important"><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.totPagar" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.ica.obcontra" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.ica.rop" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.ica.pagar" /></label></th>
			</tr>
		</thead>
		<tbody>
			<jsp:useBean id="peridoDesc" class="java.util.HashMap" scope="request" />
			<c:set target="${peridoDesc}" property="01" value="Enero - Febrero" />
			<c:set target="${peridoDesc}" property="02" value="Marzo - Abril" />
			<c:set target="${peridoDesc}" property="03" value="Mayo - Junio" />
			<c:set target="${peridoDesc}" property="04" value="Julio - Agosto" />
			<c:set target="${peridoDesc}" property="05" value="Septiembre - Octubre" />
			<c:set target="${peridoDesc}" property="06" value="Noviembre - Diciembre" />

			<c:forEach items="${obligacionesFormuno.headerica }"
				var="eachObIca">
				<c:forEach items="${eachObIca.details }" var="eachObIcaDet">
					<c:if test="${not empty eachObIcaDet.numReferencia }">
						<c:set var="clavePeriodo" value="----"/>
						<tr>
							<td><c:out value="${eachObIca.anioGravable}" /></td>
							<c:choose>
								<c:when test="${eachObIca.periodo == '01' || eachObIca.periodo == '02' || eachObIca.periodo == '03' || eachObIca.periodo == '04' || eachObIca.periodo == '05' || eachObIca.periodo == '06' }">
									<td><c:out value="${peridoDesc[eachObIca.periodo]}" /></td>
									<c:if test="${fn:length(eachObIca.anioGravable) >= 4}">
										<c:set var="clavePeriodo" value="${fn:substring(eachObIca.anioGravable, 2, 4)}B${fn:substring(eachObIca.periodo,1, 2)}"/>
									</c:if>
								</c:when>
								<c:otherwise>
									<td><c:out value="${eachObIca.periodo}" /></td>
									<c:set var="clavePeriodo" value="${eachObIca.periodo}"/>
								</c:otherwise>
							</c:choose>
							<td><c:out value="${eachObIcaDet.estadoObligacion}" /></td>
							<td><c:out value="${eachObIcaDet.obligacion}" /></td>
							<td><c:out value="${eachObIcaDet.numFormulario}" /></td>
							<td><c:out value="${eachObIcaDet.numReferencia}" /></td>
							
							<!--INI  TOTAL A PAGAR -->
							<c:choose>
								<c:when test="${eachObIca.facilidad == '00'}">
									<td><c:out value="${eachObIcaDet.obligacion}" /></td>
								</c:when>
								<c:when test="${eachObIca.facilidad == '01'}">
									<td><c:out value="${eachObIca.montoFacilidad}" /></td>
								</c:when>
								<c:when test="${eachObIca.facilidad == '02'}">
									<td><c:out value="${eachObIca.montoFacilidad}" /></td>
								</c:when>
								<c:otherwise>
									<td><c:out value="${eachObIcaDet.obligacion}" /></td>
								</c:otherwise>
							</c:choose>												
							<!--FIN TOTAL A PAGAR -->
							
							
							
							<td><c:out value="${eachObIcaDet.objetoContrato}" /></td>
							
							<!--INI ROP -->
							<c:choose>
								<c:when test="${eachObIca.facilidad == '00'}">
									<td><a
								href="<c:url value="/contribuyentes/rop?obligacion=${eachObIcaDet.obligacion}&totalPagar=${eachObIcaDet.obligacion}&tpImp=02&objCont=${eachObIcaDet.objetoContrato}&clvPer=${clavePeriodo}" />">Generar
									ROP</a></td>
								</c:when>
								<c:when test="${eachObIca.facilidad == '01'}">
									<td><a
								href="<c:url value="/contribuyentes/rop?obligacion=${eachObIcaDet.obligacion}&totalPagar=${eachObIca.montoFacilidad}&tpImp=02&objCont=${eachObIcaDet.objetoContrato}&clvPer=${clavePeriodo}" />">Generar
									ROP</a></td>
								</c:when>
								<c:when test="${eachObIca.facilidad == '02'}">
									<td><label class="control-label labeltabletd"> <spring:theme
									code="obligacion.inicial.sinROP" /></label></td>
								</c:when>
								<c:otherwise>
									<td><a
								href="<c:url value="/contribuyentes/rop?obligacion=${eachObIcaDet.obligacion}&totalPagar=${eachObIcaDet.obligacion}&tpImp=02&objCont=${eachObIcaDet.objetoContrato}&clvPer=${clavePeriodo}" />">Generar
									ROP</a></td>
								</c:otherwise>
							</c:choose>									
							<!--FIN ROP -->
							
							
							
							<!--INI PAGO VIGENTE -->
							<c:choose>
								<c:when test="${eachObIca.refActiva == '02'}">
									<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="Detalle" onclick="noActivo()">Pagar</label></td>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${eachObIca.facilidad == '00'}">
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('5102','${eachObIca.anioGravable}','${eachObIca.periodo}','${eachObIcaDet.objetoContrato}','', '${eachObIcaDet.fechaVencimiento}', '${eachObIcaDet.numReferencia}','${eachObIcaDet.obligacion}','','', '${eachObIca.facilidad}', '${eachObIca.montoFacilidad}' )">Pagar</label></td>
										</c:when>
										<c:when test="${eachObIca.facilidad == '01'}">
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('5102','${eachObIca.anioGravable}','${eachObIca.periodo}','${eachObIcaDet.objetoContrato}','', '${eachObIcaDet.fechaVencimiento}', '${eachObIcaDet.numReferencia}','${eachObIca.montoFacilidad}','','', '${eachObIca.facilidad}', '${eachObIca.montoFacilidad}' )">Pagar</label></td>
										</c:when>
										<c:when test="${eachObIca.facilidad == '02'}">
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('5102','${eachObIca.anioGravable}','${eachObIca.periodo}','${eachObIcaDet.objetoContrato}','', '${eachObIcaDet.fechaVencimiento}', '${eachObIcaDet.numReferencia}','${eachObIca.montoFacilidad}','','', '${eachObIca.facilidad}', '${eachObIca.montoFacilidad}' )">Pagar</label></td>
										</c:when>
										<c:otherwise>
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('5102','${eachObIca.anioGravable}','${eachObIca.periodo}','${eachObIcaDet.objetoContrato}','', '${eachObIcaDet.fechaVencimiento}', '${eachObIcaDet.numReferencia}','${eachObIcaDet.obligacion}','','', '${eachObIca.facilidad}', '${eachObIca.montoFacilidad}' )">Pagar</label></td>
										</c:otherwise>
									</c:choose>												
								</c:otherwise>
							</c:choose>												
							<!--FIN PAGO VIGENTE -->	
							
							
						</tr>
					</c:if>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table>
	<div class="col-md-3 col-md-offset-8">
		<button type="button" class="btn btn-primary btn-lg" id="action"
			name="action" value="Imprimir" style="margin-top: 3px"
			onclick="ACC.oblipend.bindTrmPdf('02','1','icaReporte.pdf');">
			<spring:theme code="obligacion.inicial.imprimir" />
		</button>
	</div>
</div>



<div id="noCuentaPendientes_ica" style="display:none;">
	<label class="control-label"><spring:theme code="obligaciones.ica.noCuentaPendientes"/></label>
</div>
