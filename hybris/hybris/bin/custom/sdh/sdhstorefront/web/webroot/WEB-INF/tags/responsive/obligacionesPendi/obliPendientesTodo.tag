<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<sf:form action="" method="POST" modelAttribute="obligacionesForm"
	id="obligacionesForm">

	<sf:input type="hidden" value="" id="varDeli"
		path="${obligacionesForm.variableres}" />


	<c:set var="aa" value="${obligacionesForm.variableres}" />
	<div class="container">
		<div id="impuest" style="display: none;">
			<input id="Idimp" value="">
		</div>
		<br>
	</div>
	<div class="container">
		<div id="oblipend-predial" class="oblipend-table"
			style="display: none;">

			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.predial.titulo" /></span>
					</h2>
				</div>
			</div>

			<c:if test="${not empty obligacionesFormuno.headerPred}">
				<div class="row">
					<div class="col-md-12">
						<table class="tablesearch table" id="tabPaginacion0">
							<thead style="cellspacing: 10 !important">
								<tr>
									<th style="text-align: center !important"><label
										class="control-label labeltabletd"><spring:theme
												code="obligacion.inicial.predio.aniograv" /></label></th>
									<th><label class="control-label labeltabletd"> <spring:theme
												code="obligacion.inicial.predio.chip" />
									</label></th>
									<th><label class="control-label labeltabletd"> <spring:theme
												code="obligacion.inicial.predio.edoobli" />
									</label></th>
									<th><label class="control-label labeltabletd"> <spring:theme
												code="obligacion.inicial.predio.obligacion" />
									</label></th>
									<th><label class="control-label labeltabletd"> <spring:theme
												code="obligacion.inicial.predio.numForm" /></label></th>
									<th style="text-align: center !important"><label
										class="control-label labeltabletd"> <spring:theme
												code="obligacion.inicial.predio.numRef" />
									</label></th>
									<th><label class="control-label labeltabletd"> <spring:theme
												code="obligacion.inicial.predio.obcontra" />
									</label></th>
									<th><label class="control-label labeltabletd"> <spring:theme
												code="obligacion.inicial.predio.rop" />
									</label></th>
									<th><label class="control-label labeltabletd"> <spring:theme
												code="obligacion.inicial.predio.pagar" />
									</label></th>
									<th><label class="control-label labeltabletd"> <spring:theme
												code="obligacion.inicial.predio.spac" />
									</label></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${obligacionesFormuno.headerPred }"
									var="eachObPred">

									<c:forEach items="${eachObPred.details }" var="eachObPredDet">
										<c:if test="${not empty eachObPredDet.numReferencia }">
											<tr>
												<td><c:out value="${eachObPred.anioGravable}" /></td>
												<td><c:out value="${eachObPred.objetoContrato}" /></td>
												<td><c:out value="${eachObPredDet.estadoObligacion}" /></td>
												<td><c:out value="${eachObPredDet.obligacion}" /></td>
												<td><c:out value="${eachObPredDet.numFormulario}" /></td>
												<td><c:out value="${eachObPredDet.numReferencia}" /></td>
												<td><c:out value="${eachObPredDet.objetoContrato}" /></td>
												<td><a
													href="<c:url value="/contribuyentes/rop?obligacion=${eachObPredDet.obligacion}&totalPagar=${eachObPredDet.obligacion}&objCont=${eachObPredDet.objetoContrato}&clvPer=${fn:substring(eachObPred.anioGravable, 2, 4)}A1&tpImp=01" />">Generar
														ROP</a></td>
												<td><label class="control-label"
													style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
													id="Detalle"
													onclick="pagarEnLinea('5101','${eachObPred.anioGravable}','','${eachObPredDet.objetoContrato}','${current.CHIP}', '${eachObPredDet.fechaVencimiento}', '${eachObPredDet.numReferencia}','${eachObPredDet.obligacion}' )">Pagar</label></td>
													<td><label class="control-label btnGenerarSPACObli"
													style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
													id="btnGenerarSPACObli" data-numForm="${eachObPredDet.numFormulario}" data-anio="${eachObPred.anioGravable}" data-obj="${eachObPredDet.objetoContrato}" data-reimpresion="X">Generar SPAC</label></td>
											</tr>
										</c:if>
									</c:forEach>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-md-3 col-md-offset-8">
							<button type="button" class="btn btn-primary btn-lg" id="action"
								name="action" value="Imprimir" style="margin-top: 3px"
								onclick="ACC.oblipend.bindTrmPdf('01','1','predialReporte.pdf');">
								<spring:theme code="obligacion.inicial.imprimir" />
							</button>
						</div>
					</div>
				</div>
			</c:if>
		
		</div>
	<div class="col-md-8" id="tableSpac" style="visibility:hidden;">
	<br>
	<input type="hidden" value="" id="anioGravPDF" class="anioGravPDF"/>
	<input type="hidden" value="" id="objcontPDF"/>
	<input type="hidden" value="" id="numFormPDF"/>
	<input type="hidden" value="" id="numBP"/>
				<table class="table tableSpacPago" id="tableSpacPago">
						<thead>
							<tr>
								<th><label class="control-label labeltabletd tableident"><spring:theme
											code="spac.table.cuotas" /></label></th>
								<th><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="spac.table.pagar" /></label></th>
														<th><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="spac.table.monto" /></label></th>
														<th><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="spac.table.estatus" /></label></th>
							</tr>
						</thead>
						<tbody>
							
						</tbody>
					</table>
					
					<div class="col-md-3 col-md-offset-8">
							<button type="button" class="btn btn-primary btn-lg btnGenerarSpacPDF" id="btnGenerarSpacPDF"
								name="btnGenerarSpacPDF" value="btnGenerarSpacPDF" style="margin-top: 3px">
								<spring:theme code="spac.table.descargar" />
							</button>
						</div>
	</div>
	</div>

	<div class="container">	
		<div id="oblipend-vehiculos" class="oblipend-table"
			style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.vehiculos.titulo" /></span>
					</h2>
				</div>
			</div>
			<c:if test="${not empty obligacionesFormuno.headerVehiculos}">
				<div class="row">
					<div class="col-md-12">
						<table class="tablesearch table" id="tabPaginacion1">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd" for=""><spring:theme
												code="obligacion.inicial.vehiculo.aniograv" /></label></th>
									<th><label class="control-label labeltabletd" for=""><spring:theme
												code="obligacion.inicial.vehiculo.placa" /></label></th>
									<th><label class="control-label labeltabletd" for=""><spring:theme
												code="obligacion.inicial.vehiculo.modelo" /></label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.vehiculo.marca" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.vehiculo.linea" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.vehiculo.edoobli" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.vehiculo.obligacion" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.vehiculo.numForm" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.vehiculo.numRef" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.vehiculo.obcontra" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.vehiculo.rop" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.vehiculo.pagar" />
									</label></th>
									<th><label class="control-label labeltabletd"> <spring:theme
											code="obligacion.inicial.predio.spac" />
									</label></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${obligacionesFormuno.headerVehiculos }"
									var="eachObVehi">

									<c:forEach items="${eachObVehi.details }" var="eachObVehiDet">
										<c:if test="${ not empty eachObVehiDet.numReferencia}">
											<tr>
												<td><c:out value="${eachObVehi.anioGravable}" /></td>
												<td><c:out value="${eachObVehi.placa}" /></td>
												<td><c:out value="${eachObVehi.modelo}" /></td>
												<td><spring:theme
														code="vehiculos.detalle.marca.${eachObVehi.marca}" /></td>
												<td><spring:theme
														code="vehiculos.detalle.linea.${eachObVehi.linea}" /></td>
												<td><c:out value="${eachObVehiDet.estadoObligacion}" /></td>
												<td><c:out value="${eachObVehiDet.obligacion}" /></td>
												<td><c:out value="${eachObVehiDet.numFormulario}" /></td>
												<td><c:out value="${eachObVehiDet.numReferencia}" /></td>
												<td><c:out value="${eachObVehiDet.objetoContrato}" /></td>
												<td><a
													href="<c:url value="/contribuyentes/rop?obligacion=${eachObVehiDet.obligacion}&totalPagar=${eachObVehiDet.obligacion}&objCont=${eachObVehiDet.objetoContrato}&clvPer=${fn:substring(eachObVehi.anioGravable, 2, 4)}A1&tpImp=03" />">Generar
														ROP</a></td>
												<td><label class="control-label"
													style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
													id="Detalle"
													onclick="pagarEnLinea('5103','${eachObVehi.anioGravable}','','${eachObVehiDet.objetoContrato}','', '${eachObVehiDet.fechaVencimiento}', '${eachObVehiDet.numReferencia}','${eachObVehiDet.obligacion}' )">Pagar</label></td>
												<td><label class="control-label btnGenerarSPACObliVehicular"
													style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
													id="btnGenerarSPACObliVehicular" data-numForm="${eachObVehiDet.numFormulario}" data-anio="${eachObVehi.anioGravable}" data-obj="${eachObVehiDet.objetoContrato}" data-reimpresion="X">Generar SPAC</label></td>
											</tr>
										</c:if>
									</c:forEach>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-md-3 col-md-offset-8">
							<button type="button" class="btn btn-primary btn-lg" id="action"
								name="action" value="Imprimir" style="margin-top: 3px"
								onclick="ACC.oblipend.bindTrmPdf('03','1','vehicularReporte.pdf');">
								<spring:theme code="obligacion.inicial.imprimir" />
							</button>
						</div>
					</div>
				</div>
			</c:if>
		</div>
		
	<div class="col-md-8" id="tableSpacVehicular" style="visibility:hidden;">
	<br>
		<input type="hidden" value="" id="anioGravPDFVehicular" class="anioGravPDF"/>
		<input type="hidden" value="" id="objcontPDFVehicular"/>
		<input type="hidden" value="" id="numFormPDFVehicular"/>
		<input type="hidden" value="" id="numBPVehicular"/>
		<table class="table tableSpacPago" id="tableSpacPagoVehicular">
			<thead>
				<tr>
					<th><label class="control-label labeltabletd tableident"><spring:theme
								code="spac.table.cuotas" /></label></th>
					<th><label class="control-label labeltabletd tablenumiden"><spring:theme
								code="spac.table.pagar" /></label></th>
					<th><label class="control-label labeltabletd tablenumiden"><spring:theme
								code="spac.table.monto" /></label></th>
					<th><label class="control-label labeltabletd tablenumiden"><spring:theme
								code="spac.table.estatus" /></label></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
					
		<div class="col-md-3 col-md-offset-8">
			<button type="button" class="btn btn-primary btn-lg btnGenerarSpacPDFVehicular" id="btnGenerarSpacPDFVehicular"
				name="btnGenerarSpacPDF" value="btnGenerarSpacPDF" style="margin-top: 3px">
				<spring:theme code="spac.table.descargar" />
			</button>
		</div>
	</div>
</div>

	<div class="container">
		<div id="oblipend-ica" class="oblipend-table" style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.ica.titulo" /></span>
					</h2>
				</div>
			</div>
			<c:if test="${not empty obligacionesFormuno.headerica}">
				<div class="row">
					<div class="col-md-12">
						<table class="tablesearch table" id="tabPaginacion2">
							<thead>
								<tr>

									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.ica.aniograv" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.ica.periodo" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.ica.edoobli" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.ica.obligacion" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.ica.numForm" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.ica.numRef" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.ica.obcontra" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.ica.rop" />
									</label></th>
									<th><label class="control-label labeltabletd" for="">
											<spring:theme code="obligacion.inicial.ica.pagar" />
									</label></th>
								</tr>
							</thead>
							<tbody>
								<jsp:useBean id="peridoDesc" class="java.util.HashMap"
									scope="request" />
								<c:set target="${peridoDesc}" property="01"
									value="Enero - Febrero" />
								<c:set target="${peridoDesc}" property="02"
									value="Marzo - Abril" />
								<c:set target="${peridoDesc}" property="03" value="Mayo - Junio" />
								<c:set target="${peridoDesc}" property="04"
									value="Julio - Agosto" />
								<c:set target="${peridoDesc}" property="05"
									value="Septiembre - Octubre" />
								<c:set target="${peridoDesc}" property="06"
									value="Noviembre - Diciembre" />

								<c:forEach items="${obligacionesFormuno.headerica }"
									var="eachObIca">
									<c:forEach items="${eachObIca.details }" var="eachObIcaDet">
										<c:if test="${not empty eachObIcaDet.numReferencia }">
											<c:set var="clavePeriodo" value="----"/>
											<tr>
												<%-- 												<td><c:out value="${eachObIca.tipoIdentificacion}" /></td> --%>
												<%-- 												<td><c:out value="${eachObIca.noIdentificacion}" /></td> --%>

												<%-- 												<td><c:out value="${eachObIca.periodo}" /></td> --%>
												<td><c:out value="${eachObIca.anioGravable}" /></td>
												<c:choose>
													<c:when
														test="${eachObIca.periodo == '01' || eachObIca.periodo == '02' || eachObIca.periodo == '03' || eachObIca.periodo == '04' || eachObIca.periodo == '05' || eachObIca.periodo == '06' }">
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
												<td><c:out value="${eachObIcaDet.objetoContrato}" /></td>
												<td><a
													href="<c:url value="/contribuyentes/rop?obligacion=${eachObIcaDet.obligacion}&totalPagar=${eachObIcaDet.obligacion}&tpImp=02&objCont=${eachObIcaDet.objetoContrato}&clvPer=${clavePeriodo}" />">Generar
														ROP</a></td>
												<td><label class="control-label"
													style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
													id="Detalle"
													onclick="pagarEnLinea('5102','${eachObIca.anioGravable}','${eachObIca.periodo}','${eachObIcaDet.objetoContrato}','', '${eachObIcaDet.fechaVencimiento}', '${eachObIcaDet.numReferencia}','${eachObIcaDet.obligacion}' )">Pagar</label></td>
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
				</div>
				<div class="row">
					<!--<div class="col-md-3 col-md-offset-8">
						<button type="button" class="btn btn-primary btn-lg" id="action"
							name="action" value="Imprimir" style="margin-top: 3px"
							onclick="window.location.href ='<c:url value='#' />';">
							<spring:theme code="obligacion.inicial.imprimir" />
						</button>
					</div>-->
				</div>
			</c:if>
		</div>
</div>

	<div class="container">
		<div id="oblipend-publiext" class="oblipend-table"
			style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.publiext.titulo" /></span>
					</h2>
				</div>
			</div>

			<c:if test="${not empty obligacionesFormuno.header}">
				<div class="row">
					<div class="col-md-12 text-center">
						<div class="table-responsive">
							<table class="tablesearch table table-bordered"
								id="tabPaginacion3">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd" for=""><spring:theme
													code="obligacion.inicial.publicidad.aniograv" /></label></th>
										<th><label class="control-label labeltabletd" for=""><spring:theme
													code="obligacion.inicial.publicidad.numresol" /></label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.publicidad.orivalla" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.publicidad.edoobli" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme
													code="obligacion.inicial.publicidad.obligacion" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.publicidad.numForm" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.publicidad.numRef" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.publicidad.obcontra" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.publicidad.rop" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.publicidad.pagar" />
										</label></th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${obligacionesFormuno.header}"
										var="eachPubExtTax">
										<c:forEach items="${eachPubExtTax.details}"
											var="eachPubExtTaxDet">
											<c:if test="${ not empty eachPubExtTaxDet.numReferencia }">
												<tr>
													<td><c:out value="${eachPubExtTax.anioGravable}" /></td>
													<td><c:out value="${eachPubExtTax.numResolucion}" /></td>
													<td><c:out value="${eachPubExtTax.orientacionValla}" /></td>
													<td><c:out
															value="${eachPubExtTaxDet.estadoObligacion}" /></td>
													<td><c:out value="${eachPubExtTaxDet.obligacion}" /></td>
													<td><c:out value="${eachPubExtTaxDet.numFormulario}" /></td>
													<td><c:out value="${eachPubExtTaxDet.numReferencia}" /></td>
													<td><c:out value="${eachPubExtTaxDet.objetoContrato}" /></td>
													<td><a
														href="<c:url value="/contribuyentes/rop?obligacion=${eachPubExtTaxDet.obligacion}&totalPagar=${eachPubExtTaxDet.obligacion}&objCont=${eachPubExtTaxDet.objetoContrato}&clvPer=${fn:substring(eachPubExtTax.anioGravable, 2, 4)}A1&tpImp=54" />">Generar
															ROP</a></td>
													<td><label class="control-label"
														style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
														id="Detalle"
														onclick="pagarEnLinea('5154','${eachPubExtTax.anioGravable}','','${eachPubExtTaxDet.objetoContrato}','', '${eachPubExtTaxDet.fechaVencimiento}', '${eachPubExtTaxDet.numReferencia}','${eachPubExtTaxDet.obligacion}' )">Pagar</label></td>
												</tr>
											</c:if>
										</c:forEach>
									</c:forEach>
								</tbody>
							</table>
							<div class="col-md-3 col-md-offset-8">
								<button type="button" class="btn btn-primary btn-lg" id="action"
									name="action" value="Imprimir" style="margin-top: 3px"
									onclick="ACC.oblipend.bindTrmPdf('54','1','pubExteriorReporte.pdf');">
									<spring:theme code="obligacion.inicial.imprimir" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>
</div>


	<div class="container">
		<div id="oblipend-gasolina" class="oblipend-table"
			style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.gasolina.titulo" /></span>
					</h2>
				</div>
			</div>

			<c:if test="${not empty obligacionesFormuno.headergas}">
				<div class="row">
					<div class="col-md-12">
						<div class="table-responsive">
							<table class="tablesearch table table-bordered"
								id="tabPaginacion4">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd" for=""><spring:theme
													code="obligacion.inicial.gasolina.aniograv" /></label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.gasolina.periodo" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.gasolina.edoobli" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.gasolina.obligacion" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.gasolina.numForm" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.gasolina.numRef" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.gasolina.obcontra" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.gasolina.rop" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.gasolina.pagar" />
										</label></th>
									</tr>
								</thead>
								<tbody>
									<jsp:useBean id="peridoMtnDesc" class="java.util.HashMap"
										scope="request" />
									<c:set target="${peridoMtnDesc}" property="01" value="Enero" />
									<c:set target="${peridoMtnDesc}" property="02" value="Febrero" />
									<c:set target="${peridoMtnDesc}" property="03" value="Marzo" />
									<c:set target="${peridoMtnDesc}" property="04" value="Abril" />
									<c:set target="${peridoMtnDesc}" property="05" value="Mayo" />
									<c:set target="${peridoMtnDesc}" property="06" value="Junio" />
									<c:set target="${peridoMtnDesc}" property="07" value="Julio" />
									<c:set target="${peridoMtnDesc}" property="08" value="Agosto" />
									<c:set target="${peridoMtnDesc}" property="09"
										value="Septiembre" />
									<c:set target="${peridoMtnDesc}" property="10" value="Octubre" />
									<c:set target="${peridoMtnDesc}" property="11"
										value="Noviembre" />
									<c:set target="${peridoMtnDesc}" property="12"
										value="Diciembre " />

									<c:forEach items="${obligacionesFormuno.headergas}"
										var="eachObGas">
										<c:forEach items="${eachObGas.details}" var="eachObGasDet">
											<c:if test="${not empty eachObGasDet.numReferencia}">
												<tr>
													<td><c:out value="${eachObGas.anioGravable}" /></td>
													<!-- <td><c:out value="${eachObGas.periodo}" /></td> -->
													<td><c:out value="${peridoMtnDesc[eachObGas.periodo]}" /></td>
													<td><c:out value="${eachObGasDet.estadoObligacion}" /></td>
													<td><c:out value="${eachObGasDet.obligacion}" /></td>
													<td><c:out value="${eachObGasDet.numFormulario}" /></td>
													<td><c:out value="${eachObGasDet.numReferencia}" /></td>
													<td><c:out value="${eachObGasDet.objetoContrato}" /></td>
													<td><a
														href="<c:url value="/contribuyentes/rop?obligacion=${eachObGasDet.obligacion}&totalPagar=${eachObGasDet.obligacion}&objCont=${eachObGasDet.objetoContrato}&clvPer=${fn:substring(eachObGas.anioGravable, 2, 4)}${eachObGas.periodo}&tpImp=08" />">Generar
															ROP</a></td>
													<td><label class="control-label"
														style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
														id="Detalle"
														onclick="pagarEnLinea('0108','${eachObGas.anioGravable}','${eachObGas.periodo}','${eachObGasDet.objetoContrato}','','${eachObGasDet.fechaVencimiento}', '${eachObGasDet.numReferencia}', '${eachObGasDet.obligacion}')">Pagar</label></td>
												</tr>
											</c:if>
										</c:forEach>
									</c:forEach>

								</tbody>
							</table>
							<div class="col-md-3 col-md-offset-8">
								<button type="button" class="btn btn-primary btn-lg" id="action"
									name="action" value="Imprimir" style="margin-top: 3px"
									onclick="ACC.oblipend.bindTrmPdf('08','1','sobGasolinaReporte.pdf');">
									<spring:theme code="obligacion.inicial.imprimir" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>
</div>

	<div class="container">
		<div id="oblipend-delurbana" class="oblipend-table"
			style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.delurbana.titulo" /></span>
					</h2>
				</div>
			</div>
			<c:if test="${not empty obligacionesFormuno.headerdeli}">
				<div class="row">
					<div class="col-md-12 text-center">
						<div class="table-responsive">
							<table class="tablesearch table table-bordered"
								id="tabPaginacion5">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.inicial.delineacion.aniograv" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.inicial.delineacion.cdu" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.inicial.delineacion.chip" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.direccion" /> </label></th>
										<th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="obligacion.inicial.delineacion.edoobli" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.obligacion" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.numForm" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.numRef" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.obcontra" /> </label></th>
										<th><label class="control-label labeltabletd "><spring:theme
													code="obligacion.inicial.delineacion.rop" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.pagar" /> </label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${obligacionesFormuno.headerdeli}"
										var="eachDeli">
										<c:forEach items="${eachDeli.details}" var="eachDeliDet">
											<c:if test="${not empty eachDeliDet.numReferencia}">
												<tr>
													<td><c:out value="${eachDeli.anioGravable}" /></td>
													<td><c:out value="${eachDeli.cdu}" /></td>
													<td><c:out value="${eachDeli.chip}" /></td>
													<td><c:out value="${eachDeli.direccion}" /></td>
													<td><c:out value="${eachDeliDet.estadoObligacion}" /></td>
													<td><c:out value="${eachDeliDet.obligacion}" /></td>
													<td><c:out value="${eachDeliDet.numFormulario}" /></td>
													<td><c:out value="${eachDeliDet.numReferencia}" /></td>
													<td><c:out value="${eachDeliDet.objetoContrato}" /></td>
													<td>
													<c:set var="clavePeriodo" value=""/>
													<c:if test="${fn:length(eachDeli.anioGravable) >= 4}">
														<c:set var="clavePeriodo" value="${fn:substring(eachDeli.anioGravable, 2, 4)}A1"/>
													</c:if>
													<a href="<c:url value="/contribuyentes/rop?obligacion=${eachDeliDet.obligacion}&totalPagar=${eachDeliDet.obligacion}&objCont=${eachDeliDet.objetoContrato}&clvPer=${clavePeriodo}&tpImp=06" />">Generar
															ROP</a></td>
													<td><label class="control-label"
														style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
														id="Detalle"
														onclick="pagarEnLinea('5132','${eachDeli.anioGravable}','','${eachDeliDet.objetoContrato}','${eachDeli.chip}', '${eachDeliDet.fechaVencimiento}', '${eachDeliDet.numReferencia}','${eachDeliDet.obligacion}' )">Pagar</label></td>
												</tr>
											</c:if>
										</c:forEach>
									</c:forEach>
								</tbody>
							</table>
							<div class="col-md-3 col-md-offset-8">
								<button type="button" class="btn btn-primary btn-lg" id="action"
									name="action" value="Imprimir" style="margin-top: 3px"
									onclick="ACC.oblipend.bindTrmPdf('06','1','delUrbanaReporte.pdf');">
									<spring:theme code="obligacion.inicial.imprimir" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${empty obligacionesFormuno.headerdeli}">
				<label class="control-label">No cuenta con obligaciones
					pendientes de Delineaci&oacuten Urbana</label>

			</c:if>
		</div>
</div>

	<div class="container" style="margin-top: -20px!important;">
		<div id="oblipend-reteica" class="oblipend-table"
			style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.reteica.titulo" /></span>
					</h2>
				</div>
			</div>
			<c:if test="${not empty obligacionesFormuno.headerdeli}">
				<div class="row">
					<div class="col-md-12 text-center">
						<div class="table-responsive">
							<table class="tablesearch table table-bordered"
								id="tabPaginacion5">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.inicial.delineacion.aniograv" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.inicial.delineacion.cdu" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.inicial.delineacion.chip" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.direccion" /> </label></th>
										<th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="obligacion.inicial.delineacion.edoobli" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.obligacion" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.numForm" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.numRef" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.obcontra" /> </label></th>
										<th><label class="control-label labeltabletd "><spring:theme
													code="obligacion.inicial.delineacion.rop" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.pagar" /> </label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${obligacionesFormuno.headerdeli}"
										var="eachDeli">
										<c:forEach items="${eachDeli.details}" var="eachDeliDet">
											<c:if test="${not empty eachDeliDet.numReferencia}">
												<tr>
													<td><c:out value="${eachDeli.anioGravable}" /></td>
													<td><c:out value="${eachDeli.cdu}" /></td>
													<td><c:out value="${eachDeli.chip}" /></td>
													<td><c:out value="${eachDeli.direccion}" /></td>
													<td><c:out value="${eachDeliDet.estadoObligacion}" /></td>
													<td><c:out value="${eachDeliDet.obligacion}" /></td>
													<td><c:out value="${eachDeliDet.numFormulario}" /></td>
													<td><c:out value="${eachDeliDet.numReferencia}" /></td>
													<td><c:out value="${eachDeliDet.objetoContrato}" /></td>
													<td><a
														href="<c:url value="/contribuyentes/rop?obligacion=${eachDeliDet.obligacion}&totalPagar=${eachDeliDet.obligacion}&objCont=${eachDeliDet.objetoContrato}&clvPer=${eachDeli.anioGravable}&tpImp=06" />">Generar
															ROP</a></td>
													<td><label class="control-label"
														style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
														id="Detalle"
														onclick="pagarEnLinea('5132','${eachDeli.anioGravable}','','${eachDeliDet.objetoContrato}','${eachDeli.chip}', '${eachDeliDet.fechaVencimiento}', '${eachDeliDet.numReferencia}','${eachDeliDet.obligacion}' )">Pagar</label></td>
												</tr>
											</c:if>
										</c:forEach>
									</c:forEach>
								</tbody>
							</table>
							<div class="col-md-3 col-md-offset-8">
								<button type="button" class="btn btn-primary btn-lg" id="action"
									name="action" value="Imprimir" style="margin-top: 3px"
									onclick="ACC.oblipend.bindTrmPdf('06','1','delUrbanaReporte.pdf');">
									<spring:theme code="obligacion.inicial.imprimir" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${empty obligacionesFormuno.headerdeli}">
				<label class="control-label">No cuenta con obligaciones
					pendientes de RETEICA</label>

			</c:if>
		</div>
</div>


		<!-- 			tablas de detalle -->

		<div id="detalle-predial" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text"
						id="fechreportepred" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<div class="table-responsive ">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.predial.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.predial.chip" /> </label></th>
									<th><label class="control-label labeltabletd tabledomatri"><spring:theme
												code="obligacion.sujeto.predial.matin" /> </label></th>
									<th><label
										class="control-label labeltabletd tablenombrecorto"><spring:theme
												code="obligacion.sujeto.predial.direccion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.predial.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.predial.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.predial.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text"
										value="<c:out value="A�o gravable"></c:out>" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledomatri"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tablenombrecorto"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
											ROP</label></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="goBack()">
							<spring:theme code="obligacion.sujeto.predial.regresar" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="window.location.href ='<c:url value='/contribuyentes' />';">
							<spring:theme code="obligacion.sujeto.predial.cancelar" />
						</button>
					</div>
				</div>
			</div>
		</div>

		<c:if test="">
			<div id="detalle-ica" class="oblipend-tabledetalle"
				style="display: none;">
				<div class="row">
					<div class="col-md-8">
						<label class="control-label">Fecha reporte </label> <input
							class="inputtextnew" disabled="disabled" value="" type="text"
							id="fechreporteica" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-7 text-center">
						<div class="table-responsive">
							<table class="table table-bordered" id="">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.sujeto.ica.aniograv" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.sujeto.ica.periodo" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.sujeto.ica.obligacion" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.sujeto.ica.informacion" /> </label></th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input style="width: 100%"
											class="inputtextnew tableangrav" maxlength="30" size="30"
											disabled="disabled" type="text"
											value="<c:out value=""></c:out>" /></td>
										<td><input class="inputtextnew tabledoobli"
											disabled="disabled" value="" type="text" /></td>
										<td><input class="inputtextnew tabledoobli"
											disabled="disabled" value="" type="text" /></td>
										<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalledos">Detalle</label></td>
										<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id=""
											onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
										<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id=""
											onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
												ROP</label></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</c:if>

		<div id="detalle-vehiculos" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text"
						id="fechreporteveh" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.placa" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.modelo" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.marca" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.linea" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.vehiculos.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.vehiculos.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.vehiculos.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text"
										value="<c:out value="A�o gravable"></c:out>" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
											ROP</label></td>

								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="goBack()">
							<spring:theme code="obligacion.sujeto.vehiculos.regresar" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="window.location.href ='<c:url value='/contribuyentes' />';">
							<spring:theme code="obligacion.sujeto.vehiculos.cancelar" />
						</button>
					</div>
				</div>
			</div>
		</div>


		<div id="detalle-delurbana" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text"
						id="fechreportedel" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-11 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.cdu" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.delurbana.chip" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.delurbana.direccion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.informacion" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="angravabDELI" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" id="cduobDELI" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" id="chipDeli" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" id="direcDeli" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" id="edoobliDeli" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" id="obliDeli" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="Detalledos">Detalle</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
											ROP</label></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>



		<c:if test="">
			<div id="detalle-gasolina" class="oblipend-tabledetalle"
				style="display: none">
				<div class="row">
					<div class="col-md-6">
						<label class="control-label">Fecha reporte </label> <input
							class="inputtextnew" disabled="disabled" value="" type="text"
							id="fechreportegas" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-7">
						<div class="table-responsive">
							<table class="table table-bordered" id="">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.sujeto.gasolina.aniograv" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.sujeto.gasolina.periodo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.sujeto.gasolina.obligacion" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.sujeto.gasolina.informacion" /> </label></th>

									</tr>
								</thead>
								<c:forEach items="${obligacionesFormuno.headergas }"
									var="eachGasObli">
									<tbody>
										<tr>
											<td><input style="width: 100%"
												class="inputtextnew tableangrav" maxlength="30" size="30"
												disabled="disabled" type="text"
												value="<c:out value=""></c:out>" /></td>
											<td><input class="inputtextnew tabledoobli"
												disabled="disabled" value="${eachGasObli.periodo}"
												type="text" /></td>
											<td><input class="inputtextnew tabledoobli"
												disabled="disabled"
												value="${eachGasObli.details.obligacion}" type="text" /></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												id="Detalledos" data-angravgas=""
												data-perigas="${eachGasObli.periodo}"
												data-edoobligaciongas="${eachGasObli.details.estadoObligacion}"
												data-obligaciongas="${eachGasObli.details.obligacion}">Detalle</label></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												id=""
												onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												id=""
												onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
													ROP</label></td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<div id="detalle-publiext" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text"
						id="fechreportepub" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="table-publi-ext-detalle">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.publiext.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.noresol" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.dirvalla" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.orvalla" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.publiext.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.publiext.informacion" /> </label></th>

								</tr>
							</thead>

							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="angravPUB" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" id="numResOB" value="" />
									<td><input class="inputtextnew" disabled="disabled"
										id="direcvalla" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" id="orivalla" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" id="obliga" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="Detalledos">Detalle</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/contribuyentes/rop?tipoImp=06&numBP=0000000575&numObjeto=60000000000000061&clavePeriodo=1810' />';">Generar
											ROP</label></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!-- 			tablas de detalle del detalle-->

		<div id="detalle-dos-publiext" class="oblipend-tabledetalledos"
			style="display: none;">
			<div class="row">
				<div class="col-md-3 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="table-publi-ext-detalle">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.publiext.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.noresol" /> </label></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="angravPUBLICI" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" id="numResPUBLICI" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="table-publi-ext-detalle">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.publiext.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.actooficial" /> </label></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="esdobli" /></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" id="det-obli" /></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" id="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


		<div id="detalle-dos-gasolina" class="oblipend-tabledetalledos"
			style="display: none">
			<div class="row">
				<div class="col-md-3">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.gasolina.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.gasolina.periodo" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="angravGAS" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="periodoGAS" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.gasolina.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.gasolina.oblig" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.gasolina.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="edoobliGAS" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="obliGAS" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div id="detalle-dos-ica" class="oblipend-tabledetalledos"
			style="display: none">
			<div class="row">
				<div class="col-md-3">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.ica.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.ica.periodo" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="angravICA" value="" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="periodoICA" value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.ica.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.ica.oblig" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.ica.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="edoobliICA" value="" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="obliICA" value="" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div id="detalle-dos-delurbana" class="oblipend-tabledetalledos"
			style="display: none">
			<div class="row">
				<div class="col-md-3">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.delurbana.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.cdu" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="anioselDeli" value="" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="cduselDeli" value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.delurbana.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.oblig" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="edoobliselDELI" value="" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="obliselDELI" value="" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	<div class="row">
			<a id='dwnldLnk' download='SPAC.pdf'
				style="display: none;" />
		</div>
</sf:form>
<br>

