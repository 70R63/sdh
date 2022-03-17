<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<div class="row" id="div_titulo_delurbana" style="display:none;">
	<h2>
		<span><spring:theme code="obligacion.sujeto.delurbana.titulo" /></span>
	</h2>
</div>
<div id="oblipend-delurbana" class="oblipend-table" style="display: none;">
	<table class="tablesearch table table-bordered" id="table_delurbana">
		<thead>
			<tr>
				<th><label class="control-label labeltabletd tabledoobli"><spring:theme code="obligacion.inicial.delineacion.aniograv" /> </label></th>
				<th><label class="control-label labeltabletd tabledoobli"><spring:theme code="obligacion.inicial.delineacion.cdu" /> </label></th>
				<th><label class="control-label labeltabletd tabledoobli"><spring:theme code="obligacion.inicial.delineacion.chip" /> </label></th>
				<th><label class="control-label labeltabletd"><spring:theme code="obligacion.inicial.delineacion.direccion" /> </label></th>
				<th><label class="control-label labeltabletd tableangrav"><spring:theme code="obligacion.inicial.delineacion.edoobli" /> </label></th>
				<th><label class="control-label labeltabletd"><spring:theme code="obligacion.inicial.delineacion.obligacion" /> </label></th>
				<th><label class="control-label labeltabletd"><spring:theme code="obligacion.inicial.delineacion.numForm" /> </label></th>
				<th><label class="control-label labeltabletd"><spring:theme code="obligacion.inicial.delineacion.numRef" /> </label></th>
				<th style="text-align: center !important"><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.totPagar" /></label></th>
				<th><label class="control-label labeltabletd"><spring:theme code="obligacion.inicial.delineacion.obcontra" /> </label></th>
				<th><label class="control-label labeltabletd "><spring:theme code="obligacion.inicial.delineacion.rop" /> </label></th>
				<th><label class="control-label labeltabletd"><spring:theme code="obligacion.inicial.delineacion.pagar" /> </label></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obligacionesFormuno.headerdeli}" var="eachDeli">
				<c:forEach items="${eachDeli.details}" var="eachDeliDet">
					<c:if test="${not empty eachDeliDet.estadoObligacion || not empty eachDeliDet.obligacion}">
						<tr>
							<td><c:out value="${eachDeli.anioGravable}" /></td>
							<td><c:out value="${eachDeli.cdu}" /></td>
							<td><c:out value="${eachDeli.chip}" /></td>
							<td><c:out value="${eachDeli.direccion}" /></td>
							<td><c:out value="${eachDeliDet.estadoObligacion}" /></td>
							<td><c:out value="${eachDeliDet.obligacion}" /></td>
							<td><c:out value="${eachDeliDet.numFormulario}" /></td>
							<td><c:out value="${eachDeliDet.numReferencia}" /></td>
							
							
							<!--INI  TOTAL A PAGAR -->
							<c:choose>
								<c:when test="${eachDeli.facilidad == '00'}">
									<td><c:out value="${eachDeliDet.obligacion}" /></td>
								</c:when>
								<c:when test="${eachDeli.facilidad == '01'}">
									<td><c:out value="${eachDeli.montoFacilidad}" /></td>
								</c:when>
								<c:when test="${eachDeli.facilidad == '02'}">
									<td><c:out value="${eachDeli.montoFacilidad}" /></td>
								</c:when>
								<c:otherwise>
									<td><c:out value="${eachDeliDet.obligacion}" /></td>
								</c:otherwise>
							</c:choose>												
							<!--FIN TOTAL A PAGAR -->
							
							
							<td><c:out value="${eachDeliDet.objetoContrato}" /></td>
							
							<!--INI ROP -->
							<c:choose>
								<c:when test="${eachDeli.facilidad == '00'}">
									<td>
									<c:set var="clavePeriodo" value=""/>
									<c:if test="${fn:length(eachDeli.anioGravable) >= 4}">
										<c:set var="clavePeriodo" value="${fn:substring(eachDeli.anioGravable, 2, 4)}A1"/>
									</c:if>
									<a href="<c:url value="/contribuyentes/rop?obligacion=${eachDeliDet.obligacion}&totalPagar=${eachDeliDet.obligacion}&objCont=${eachDeliDet.objetoContrato}&clvPer=${clavePeriodo}&tpImp=06" />">Generar ROP</a></td>
								</c:when>
								<c:when test="${eachDeli.facilidad == '01'}">
									<td>
									<c:set var="clavePeriodo" value=""/>
									<c:if test="${fn:length(eachDeli.anioGravable) >= 4}">
										<c:set var="clavePeriodo" value="${fn:substring(eachDeli.anioGravable, 2, 4)}A1"/>
									</c:if>
									<a href="<c:url value="/contribuyentes/rop?obligacion=${eachDeliDet.obligacion}&totalPagar=${eachDeli.montoFacilidad}&objCont=${eachDeliDet.objetoContrato}&clvPer=${clavePeriodo}&tpImp=06" />">Generar ROP</a></td>
								</c:when>
								<c:when test="${eachDeli.facilidad == '02'}">
									<td><label class="control-label labeltabletd"> <spring:theme
									code="obligacion.inicial.sinROP" /></label></td>
								</c:when>
								<c:otherwise>
									<td>
									<c:set var="clavePeriodo" value=""/>
									<c:if test="${fn:length(eachDeli.anioGravable) >= 4}">
										<c:set var="clavePeriodo" value="${fn:substring(eachDeli.anioGravable, 2, 4)}A1"/>
									</c:if>
									<a href="<c:url value="/contribuyentes/rop?obligacion=${eachDeliDet.obligacion}&totalPagar=${eachDeliDet.obligacion}&objCont=${eachDeliDet.objetoContrato}&clvPer=${clavePeriodo}&tpImp=06" />">Generar ROP</a></td>
								</c:otherwise>
							</c:choose>									
							<!--FIN ROP -->
							
							
							<!--INI PAGO VIGENTE -->
							<c:choose>
								<c:when test="${eachDeli.refActiva == '02'}">
									<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="Detalle" onclick="noActivo()">Pagar</label></td>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${eachDeli.facilidad == '00'}">
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('${eachDeliDet.codImpuesto}','${eachDeli.anioGravable}','','${eachDeliDet.objetoContrato}','${eachDeli.chip}', '${eachDeliDet.fechaVencimiento}', '${eachDeliDet.numReferencia}','${eachDeliDet.obligacion}','${eachDeli.cdu}','','${eachDeli.facilidad}','${eachDeli.montoFacilidad}' )">Pagar</label></td>
										</c:when>
										<c:when test="${eachDeli.facilidad == '01'}">
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('${eachDeliDet.codImpuesto}','${eachDeli.anioGravable}','','${eachDeliDet.objetoContrato}','${eachDeli.chip}', '${eachDeliDet.fechaVencimiento}', '${eachDeliDet.numReferencia}','${eachDeli.montoFacilidad}','${eachDeli.cdu}','','${eachDeli.facilidad}','${eachDeli.montoFacilidad}' )">Pagar</label></td>
										</c:when>
										<c:when test="${eachDeli.facilidad == '02'}">
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('${eachDeliDet.codImpuesto}','${eachDeli.anioGravable}','','${eachDeliDet.objetoContrato}','${eachDeli.chip}', '${eachDeliDet.fechaVencimiento}', '${eachDeliDet.numReferencia}','${eachDeli.montoFacilidad}','${eachDeli.cdu}','','${eachDeli.facilidad}','${eachDeli.montoFacilidad}' )">Pagar</label></td>
										</c:when>
										<c:otherwise>
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('${eachDeliDet.codImpuesto}','${eachDeli.anioGravable}','','${eachDeliDet.objetoContrato}','${eachDeli.chip}', '${eachDeliDet.fechaVencimiento}', '${eachDeliDet.numReferencia}','${eachDeliDet.obligacion}','${eachDeli.cdu}','','${eachDeli.facilidad}','${eachDeli.montoFacilidad}' )">Pagar</label></td>
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
			onclick="reporteTrmPdf('06','delUrbanaReporte.pdf');">
			<spring:theme code="obligacion.inicial.imprimir" />
		</button>
	</div>
</div>

<div id="noCuentaPendientes_delurbana" style="display:none;">
	<label class="control-label"><spring:theme code="obligaciones.delineacion.noCuentaPendientes"/></label>
	    <button type="button" class="btn btn-primary btn-lg" id="action"
        name="action" value="Imprimir" style="margin-top: 3px"
        onclick="reporteTrmPdf('06','delUrbanaReporte.pdf');">
        <spring:theme code="obligacion.inicial.imprimir" />
    </button>
</div>