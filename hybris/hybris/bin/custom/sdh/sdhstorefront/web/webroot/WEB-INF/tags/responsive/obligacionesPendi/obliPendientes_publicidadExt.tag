<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<div class="row" id="div_titulo_publiext" style="display:none;">
	<h2><span><spring:theme code="obligacion.sujeto.publiext.titulo" /></span></h2>
</div>
<div id="oblipend-publiext" class="oblipend-table" style="display: none;">
	<table class="tablesearch table table-bordered" id="table-publicidad1">
		<thead>
			<tr>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.publicidad.aniograv" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.publicidad.numresol" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.publicidad.orivalla" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.publicidad.edoobli" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.publicidad.obligacion" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.publicidad.numForm" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.publicidad.numRef" /></label></th>
				<th style="text-align: center !important"><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.totPagar" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.publicidad.obcontra" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.publicidad.rop" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.publicidad.pagar" /></label></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obligacionesFormuno.header}" var="eachPubExtTax">
				<c:forEach items="${eachPubExtTax.details}" var="eachPubExtTaxDet">
					<c:if test="${ not empty eachPubExtTaxDet.numReferencia }">
						<tr>
							<td><c:out value="${eachPubExtTax.anioGravable}" /></td>
							<td><c:out value="${eachPubExtTax.numResolucion}" /></td>
							<td><c:out value="${eachPubExtTax.orientacionValla}" /></td>
							<td><c:out value="${eachPubExtTaxDet.estadoObligacion}" /></td>
							<td><c:out value="${eachPubExtTaxDet.obligacion}" /></td>
							<td><c:out value="${eachPubExtTaxDet.numFormulario}" /></td>
							<td><c:out value="${eachPubExtTaxDet.numReferencia}" /></td>
							
							<!--INI  TOTAL A PAGAR -->
							<c:choose>
								<c:when test="${eachPubExtTax.facilidad == '00'}">
									<td><c:out value="${eachPubExtTaxDet.obligacion}" /></td>
								</c:when>
								<c:when test="${eachPubExtTax.facilidad == '01'}">
									<td><c:out value="${eachPubExtTax.montoFacilidad}" /></td>
								</c:when>
								<c:when test="${eachPubExtTax.facilidad == '02'}">
									<td><c:out value="${eachPubExtTax.montoFacilidad}" /></td>
								</c:when>
								<c:otherwise>
									<td><c:out value="${eachPubExtTaxDet.obligacion}" /></td>
								</c:otherwise>
							</c:choose>												
							<!--FIN TOTAL A PAGAR -->
							
							
							<td><c:out value="${eachPubExtTaxDet.objetoContrato}" /></td>
							
							
							<!--INI ROP -->
							<c:choose>
								<c:when test="${eachPubExtTax.facilidad == '00'}">
									<td><a 
									id="consultaROP_A"  
									data-obligacion="${eachPubExtTaxDet.obligacion}" 
									data-totalPagar="${eachPubExtTaxDet.obligacion}" 
									data-objCont="${eachPubExtTaxDet.objetoContrato}"
									data-clvPer="${fn:substring(eachPubExtTax.anioGravable, 2, 4)}A1"
									data-tpImp="54" 
									href="<c:url value="/contribuyentes/rop?obligacion=${eachPubExtTaxDet.obligacion}&totalPagar=${eachPubExtTaxDet.obligacion}&objCont=${eachPubExtTaxDet.objetoContrato}&clvPer=${fn:substring(eachPubExtTax.anioGravable, 2, 4)}A1&tpImp=54" />">Generar ROP</a>
									
									</td>
								</c:when>
								<c:when test="${eachPubExtTax.facilidad == '01'}">
									<td><a 
									id="consultaROP_A"  
									data-obligacion="${eachPubExtTaxDet.obligacion}" 
									data-totalPagar="${eachPubExtTax.montoFacilidad}" 
									data-objCont="${eachPubExtTaxDet.objetoContrato}"
									data-clvPer="${fn:substring(eachPubExtTax.anioGravable, 2, 4)}A1"
									data-tpImp="54" 
									href="<c:url value="/contribuyentes/rop?obligacion=${eachPubExtTaxDet.obligacion}&totalPagar=${eachPubExtTax.montoFacilidad}&objCont=${eachPubExtTaxDet.objetoContrato}&clvPer=${fn:substring(eachPubExtTax.anioGravable, 2, 4)}A1&tpImp=54" />">Generar ROP</a></td>
								</c:when>
								<c:when test="${eachPubExtTax.facilidad == '02'}">
									<td><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.sinROP" /></label></td>
								</c:when>
								<c:otherwise>
									<td><a
									id="consultaROP_A"  
									data-obligacion="${eachPubExtTaxDet.obligacion}" 
									data-totalPagar="${eachPubExtTaxDet.obligacion}" 
									data-objCont="${eachPubExtTaxDet.objetoContrato}"
									data-clvPer="${fn:substring(eachPubExtTax.anioGravable, 2, 4)}A1"
									data-tpImp="54"
									href="<c:url value="/contribuyentes/rop?obligacion=${eachPubExtTaxDet.obligacion}&totalPagar=${eachPubExtTaxDet.obligacion}&objCont=${eachPubExtTaxDet.objetoContrato}&clvPer=${fn:substring(eachPubExtTax.anioGravable, 2, 4)}A1&tpImp=54" />">Generar ROP</a></td>
								</c:otherwise>
							</c:choose>									
							<!--FIN ROP -->
							
							
							<!--INI PAGO VIGENTE -->
							<c:choose>
								<c:when test="${eachPubExtTax.refActiva == '02'}">
									<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="Detalle" onclick="noActivo()">Pagar</label></td>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${eachPubExtTax.facilidad == '00'}">
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('5154','${eachPubExtTax.anioGravable}','','${eachPubExtTaxDet.objetoContrato}','', '${eachPubExtTaxDet.fechaVencimiento}', '${eachPubExtTaxDet.numReferencia}','${eachPubExtTaxDet.obligacion}','','','${eachPubExtTax.facilidad}','${eachPubExtTax.montoFacilidad}' )">Pagar</label></td>
										</c:when>
										<c:when test="${eachPubExtTax.facilidad == '01'}">
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('5154','${eachPubExtTax.anioGravable}','','${eachPubExtTaxDet.objetoContrato}','', '${eachPubExtTaxDet.fechaVencimiento}', '${eachPubExtTaxDet.numReferencia}','${eachPubExtTax.montoFacilidad}','','','${eachPubExtTax.facilidad}','${eachPubExtTax.montoFacilidad}' )">Pagar</label></td>
										</c:when>
										<c:when test="${eachPubExtTax.facilidad == '02'}">
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('5154','${eachPubExtTax.anioGravable}','','${eachPubExtTaxDet.objetoContrato}','', '${eachPubExtTaxDet.fechaVencimiento}', '${eachPubExtTaxDet.numReferencia}','${eachPubExtTax.montoFacilidad}','','','${eachPubExtTax.facilidad}','${eachPubExtTax.montoFacilidad}' )">Pagar</label></td>
										</c:when>
										<c:otherwise>
											<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalle"
											onclick="pagarEnLinea('5154','${eachPubExtTax.anioGravable}','','${eachPubExtTaxDet.objetoContrato}','', '${eachPubExtTaxDet.fechaVencimiento}', '${eachPubExtTaxDet.numReferencia}','${eachPubExtTaxDet.obligacion}','','','${eachPubExtTax.facilidad}','${eachPubExtTax.montoFacilidad}' )">Pagar</label></td>
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
			onclick="reporteTrmPdf('54','pubExteriorReporte.pdf');">
			<spring:theme code="obligacion.inicial.imprimir" />
		</button>
	</div>
</div>

<div id="noCuentaPendientes_publiext" style="display:none;">
	<label class="control-label"><spring:theme code="obligaciones.publicidadExt.noCuentaPendientes"/></label>
	
	<button type="button" class="btn btn-primary btn-lg" id="action"
        name="action" value="Imprimir" style="margin-top: 3px"
        onclick="reporteTrmPdf('54','pubExteriorReporte.pdf');">
        <spring:theme code="obligacion.inicial.imprimir" />
    </button>
</div>
