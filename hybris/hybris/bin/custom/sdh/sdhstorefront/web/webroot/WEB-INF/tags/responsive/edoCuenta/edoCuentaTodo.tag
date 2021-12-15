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
	<sf:form>
		<div id="impContribuyente" style="display: none;">
			<c:if test="${not empty ctaForm.predial}">
			<div id="predial">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme code="edocuenta.inicial.predio.titulo" /></span>
						</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="table-responsive text-center">
							<table class="table tableedocuenta" id="tabPaginacion0">
								<thead>

									<tr>
										<th><label class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.predio.chip" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.predio.matricula" /> </label></th>
										<!-- <th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.predio.aniograv" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.predio.desthacen" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.predio.estado" /> </label></th>
										<th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="edocuenta.inicial.predio.participa" /> </label></th> -->
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.predio.saldocargo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.predio.saldofavor" /> </label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach varStatus="loop" items="${ctaForm.predial}"
										var="eachPredial">
										<c:if test="${not empty eachPredial.newCHIP || not empty eachPredial.matrInmobiliaria}">
											<tr>
												<td><c:out value="${eachPredial.newCHIP}" /></td>
												<td><c:out value="${eachPredial.matrInmobiliaria}" /></td>
												<td><c:out value="${eachPredial.saldocargo}" /></td>
												<td><c:out value="${eachPredial.saldofavor}" /></td>
											</tr>	
										</c:if>	
										
										<!--<c:forEach varStatus="loop"
											items="${eachPredial.detallePredial}" var="eachPredialDetail">
											<c:if
												test="${not empty eachPredial.newCHIP || not empty eachPredial.matrInmobiliaria}">
												<tr>
													<td><c:out value="${eachPredial.newCHIP}" /></td>
													<td><c:out value="${eachPredial.matrInmobiliaria}" /></td>
													<td><c:out value="${eachPredialDetail.anioGravable}" /></td>
													<td><c:out
															value="${eachPredialDetail.destinohacendario}" /></td>
													<td><c:out value="${eachPredialDetail.estado}" /></td>
													<td><c:out
															value="${eachPredialDetail.porcParticipacion}" /></td>
													<td><c:out value="${eachPredialDetail.saldoCargo}" /></td>
													<td><c:out value="${eachPredialDetail.saldoFavor}" /></td>
												</tr>
											</c:if>
										</c:forEach>-->
									</c:forEach>
								</tbody>
							</table>
						</div>
						

			   		    

<!-- 						INI -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario
						<div class="col-md-offset-6">

							<table class="table tableedocuenta">
								<tbody>
									<tr>
										<td class="td-total" style="width: 264px;"><label
											class="control-label labeltabletd tableangrav labeltabletd"><spring:theme
													code="edocuenta.inicial.predio.total" /> </label></td>
										<td><c:out value="${ctaForm.predialSaldoCargo}" /></td>
										<td><c:out value="${ctaForm.predialSaldoFavor}" /></td>
									</tr>
								</tbody>
							</table>

						
						
						

						</div>
						
			FIN -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario -->
			
			
						<!-- 					<div class="col-md-3 col-md-offset-8"> -->
						<!-- 						<button type="button" class="btn btn-primary btn-lg" id="action" -->
						<!-- 							name="action" value="Imprimir" style="margin-top: 3px" -->
						<!-- 							onclick="ACC.oblipend.bindTrmPdf('01','2','predialReporte.pdf');"> -->
						<%-- 							<spring:theme code="obligacion.inicial.imprimir" /> --%>
						<!-- 						</button> -->
						<!-- 					</div> -->

						<div class="col-md-3 col-md-offset-8">
							<button type="button" class="btn btn-primary btn-lg"
								id="ImprimirPopUp" name="ImprimirPopUp" value="ImprimirPopUp"
								style="margin-top: 3px" data-impuesto="1">
								<!--                             // onclick="ACC.oblipend.bindPopupPDF();" -->
								<spring:theme code="obligacion.inicial.imprimir" />
							</button>
						</div>
					</div>
				</div>
			</div>
			</c:if>



			<c:if test="${not empty ctaForm.tablaVehicular}">
			<div id="vehiculos">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme
									code="edocuenta.inicial.vehiculo.titulo" /></span>
						</h2>
					</div>
				</div>

				<div class="row">
					<div class="col-md-10 text-center">
						<div class="table-responsive">
							<table class="table tableedocuenta" id="tabPaginacion1">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.vehiculo.placa" /> </label></th>
										<!-- <th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="edocuenta.inicial.vehiculo.aniograv" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.vehiculo.estado" /> </label></th> -->
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.vehiculo.saldocargo" /> </label></th>
										<th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="edocuenta.inicial.vehiculo.saldofavor" /> </label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach varStatus="loop" items="${ctaForm.tablaVehicular}"
										var="eachVehicular">
										
										<c:if test="${not empty eachVehicularDetail.anioGravable && not empty eachVehicularDetail.estado}">
											<tr>
												<td><c:out value="${eachVehicular.placa}" /></td>
												<td><c:out value="${eachVehicular.saldocargo}" /></td>
												<td><c:out value="${eachVehicular.saldofavor}" /></td>
										    </tr>
										</c:if>
										
										<!--<c:forEach varStatus="loop"
											items="${eachVehicular.detalleVehicular}"
											var="eachVehicularDetail">
											<c:if
												test="${not empty eachVehicularDetail.anioGravable && not empty eachVehicularDetail.estado}">
												<tr>
													<td><c:out value="${eachVehicular.placa}" /></td>
													<td><c:out value="${eachVehicularDetail.anioGravable}" /></td>
													<td><c:out value="${eachVehicularDetail.estado}" /></td> 
													<td><c:out value="${eachVehicularDetail.saldoCargo}" /></td>
													<td><c:out value="${eachVehicularDetail.saldoFavor}" /></td>
												</tr>
											</c:if>
										</c:forEach>-->
										
									</c:forEach>

								</tbody>
							</table>
						</div>
						
						<!-- 						INI -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario
						<div class="col-md-offset-5">
							<table class="table tableedocuenta">
								<tbody>
									<tr>
										<td colspan="2" class="td-colspann"
											style="border: 0px !important;"></td>
										<td class="td-total" style="width: 264px;"><label
											class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.vehiculo.total" /> </label></td>
										<td><c:out value="${ctaForm.vehicularSaldoCargo}" /></td>
										<td><c:out value="${ctaForm.vehicularSaldoFavor}" /></td>
									</tr>
								</tbody>
							</table>
						</div>
						
		FIN -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario -->

						<!-- 						<button type="button" class="btn btn-primary btn-lg" id="action" -->
						<!-- 							name="action" value="Imprimir" style="margin-top: 3px" -->
						<!-- 							onclick="ACC.oblipend.bindTrmPdf('03','2','vehicularReporte.pdf');"> -->
						<%-- 							<spring:theme code="obligacion.inicial.imprimir" /> --%>
						<!-- 						</button> -->
						<div class="col-md-3 col-md-offset-8">
							<button type="button" class="btn btn-primary btn-lg"
								id="ImprimirPopUp" name="ImprimirPopUp" value="ImprimirPopUp"
								style="margin-top: 3px" data-impuesto="2">
								<spring:theme code="obligacion.inicial.imprimir" />
							</button>
						</div>

					</div>
				</div>
			</div>
			</c:if>
			

			<c:if test="${not empty ctaForm.tablaICA}">
			<div id="ica">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme code="edocuenta.inicial.ica.titulo" /></span>
						</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<div class="table-responsive">
							<table class="table tableedocuenta" id="tabPaginacion2">
								<thead>
									<tr>
									    <th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.tipiden" /> </label></th>
                                        <th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.numiden" /> </label></th>													
										<!-- <th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.ica.aniograv" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.ica.periodo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.ica.estado" /> </label></th> -->
										<th><label class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.ica.saldocargo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.ica.saldofavor" /> </label></th>

									</tr>
								</thead>
								<tbody>
									<c:forEach varStatus="loop" items="${ctaForm.tablaICA}"
										var="eachICA">
										
										<tr>
											<td><c:out value="${ctaForm.tipoDoc}" /></td>
											<td><c:out value="${ctaForm.numDoc}" /></td>
											<td><c:out value="${eachICA.saldocargo}" /></td>
											<td><c:out value="${eachICA.saldofavor}" /></td>
										</tr>	
										
										
										<!--<c:forEach varStatus="loop" items="${eachICA.newDetalleICA}"
											var="eachICADetail">
											<tr>
												<td><c:out value="${ctaForm.tipoDoc}" /></td>
												<td><c:out value="${ctaForm.numDoc}" /></td>
												<td><c:out value="${eachICADetail.anioGravable}" /></td>
												<td><c:out value="${eachICADetail.periodo}" /></td>
												<td><c:out value="${eachICADetail.estado}" /></td> 
												<td><c:out value="${eachICADetail.saldoCargo}" /></td>
												<td><c:out value="${eachICADetail.saldoFavor}" /></td>
											</tr>
										</c:forEach>-->
										
										
									</c:forEach>

								</tbody>
							</table>
						</div>
						
<!-- 						INI -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario
						<div class="col-md-offset-6">
							<table class="table tableedocuenta">
								<tbody>
									<tr>
										<td colspan="2" class="td-colspann"
											style="border: 0px !important;"></td>
										<td class="td-total" style="width: 264px;"><label
											class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.ica.total" /> </label></td>
										<td><c:out value="${ctaForm.iCASaldoCargo}" /></td>
										<td><c:out value="${ctaForm.iCASaldoFavor}" /></td>
									</tr>
								</tbody>
							</table>
						</div>
						
						
		FIN -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario -->
						<!-- 						<div class="col-md-3 col-md-offset-8"> -->
						<!-- 							<button type="button" class="btn btn-primary btn-lg" id="action" -->
						<!-- 								name="action" value="Imprimir" style="margin-top: 3px" -->
						<!-- 								onclick="ACC.oblipend.bindTrmPdf('02','2','icaReporte.pdf');"> -->
						<%-- 								<spring:theme code="obligacion.inicial.imprimir" /> --%>
						<!-- 							</button> -->
						<!-- 						</div> -->
						<div class="col-md-3 col-md-offset-8">
							<button type="button" class="btn btn-primary btn-lg"
								id="ImprimirPopUp" name="ImprimirPopUp" value="ImprimirPopUp"
								style="margin-top: 3px" data-impuesto="3">
								<spring:theme code="obligacion.inicial.imprimir" />
							</button>
						</div>
					</div>
				</div>
			</div>
			</c:if>
			

			<c:if test="${not empty ctaForm.tablaDelineacion}">
			<div id="delurbana">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme
									code="edocuenta.inicial.deliurbana.titulo" /></span>
						</h2>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12 text-center">
						<div class="table-responsive">
							<table class="table tableedocuenta" id="tabPaginacion3">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.deliurbana.cdu" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.deliurbana.licenconst" /> </label></th>			
										<!--<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.deliurbana.radicado" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.deliurbana.aniograv" /> </label></th>
										<th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="edocuenta.inicial.deliurbana.estado" /> </label></th>-->
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.deliurbana.saldocargo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.deliurbana.saldofavor" /> </label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach varStatus="loop" items="${ctaForm.tablaDelineacion}"
										var="eachDeli">
										
										<tr>
											<td><c:out value="${eachDeli.newCDU}" /></td>
											<td><c:out value="${eachDeli.licenciaConstruccion}" /></td>
											<td><c:out value="${eachDeli.saldocargo}" /></td>
											<td><c:out value="${eachDeli.saldofavor}" /></td>
										</tr>	
										
										
										<!--<c:forEach varStatus="loop"
											items="${eachDeli.detalleDelineacion}" var="eachDeliDetail">
											<tr>
												<td><c:out value="${eachDeli.newCDU}" /></td>
												<td><c:out value="${eachDeli.licenciaConstruccion}" /></td>
												<td><c:out value="${eachDeliDetail.radicado}" /></td>
												<td><c:out value="${eachDeliDetail.anioGravable}" /></td>
												<td><c:out value="${eachDeliDetail.estado}" /></td> 
												<td><c:out value="${eachDeliDetail.saldoCargo}" /></td>
												<td><c:out value="${eachDeliDetail.saldoFavor}" /></td>
											</tr>
										</c:forEach>-->
										
										
									</c:forEach>

								</tbody>
							</table>
						</div>
						
						
<!-- 						INI -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario
						<div class="col-md-offset-5">
							<table class="table tableedocuenta">
								<tbody>
									<tr>
										<td colspan="3" class="td-colspann"
											style="border: 0px !important;"></td>
										<td class="td-total" style="width: 264px;">
										<label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.deliurbana.total" /></label></td>
										<td><c:out value="${ctaForm.delineacionSaldoCargo}" /></td>
										<td><c:out value="${ctaForm.delineacionSaldoFavor}" /></td>
									</tr>
								</tbody>
							</table>
						</div>
						
		FIN -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario -->
		
						<!-- 						<div class="col-md-3 col-md-offset-8"> -->
						<!-- 							<button type="button" class="btn btn-primary btn-lg" id="action" -->
						<!-- 								name="action" value="Imprimir" style="margin-top: 3px" -->
						<!-- 								onclick="ACC.oblipend.bindTrmPdf('06','2','delUrbanaReporte.pdf');"> -->
						<%-- 								<spring:theme code="obligacion.inicial.imprimir" /> --%>
						<!-- 							</button> -->
						<!-- 						</div> -->
						<div class="col-md-3 col-md-offset-8">
							<button type="button" class="btn btn-primary btn-lg"
								id="ImprimirPopUp" name="ImprimirPopUp" value="ImprimirPopUp"
								style="margin-top: 3px" data-impuesto="6">
								<spring:theme code="obligacion.inicial.imprimir" />
							</button>
						</div>
					</div>
				</div>
			</div>
			</c:if>


			<c:if test="${not empty ctaForm.tablaGasolina}">
			<div id="gasolina">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme
									code="edocuenta.inicial.gasolina.titulo" /></span>
						</h2>
					</div>
				</div>


				<div class="row">
					<div class="col-md-7">
						<div class="table-responsive">
							<table class="table tableedocuenta" id="tabPaginacion4">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.tipiden" /> </label></th>
                                        <th><label class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.numiden" /> </label></th>
										<!-- <th><label class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.gasolina.anigrav" /> </label></th>																
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.gasolina.periodo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.gasolina.estado" /> </label></th> -->
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.gasolina.saldocargo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.gasolina.saldofavor" /> </label></th>

									</tr>
								</thead>
								<tbody>
									<c:forEach varStatus="loop" items="${ctaForm.tablaGasolina}"
										var="eachGas">
										
										<tr>
											<td><c:out value="${ctaForm.tipoDoc}" /></td>
										    <td><c:out value="${ctaForm.numDoc}" /></td>
											<td><c:out value="${eachGas.saldocargo}" /></td>
											<td><c:out value="${eachGas.saldofavor}" /></td>		
										</tr>	
												
										
										<!--<c:forEach varStatus="loop" items="${eachGas.detalleGasolina}"
											var="eachGasDetail">
											<tr>
												<td><c:out value="${ctaForm.tipoDoc}" /></td>
												<td><c:out value="${ctaForm.numDoc}" /></td>
												<td><c:out value="${eachGasDetail.anioGravable}" /></td>
												<td><c:out value="${eachGasDetail.periodo}" /></td>
												<td><c:out value="${eachGasDetail.estado}" /></td>
												<td><c:out value="${eachGasDetail.saldoCargo}" /></td>
												<td><c:out value="${eachGasDetail.saldoFavor}" /></td>
											</tr>
										</c:forEach>-->
										
										
									</c:forEach>

								</tbody>
							</table>

						</div>
						
						<!-- 						INI -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario
						<div class="col-md-offset-3">
							<table class="table tableedocuenta">
								<tbody>
									<tr>
										<td colspan="2" class="td-colspann"
											style="border: 0px !important;"></td>
										<td class="td-total" style="width: 264px;">
										<label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.gasolina.total" /></label></td>
										<td><c:out value="${ctaForm.gasolinaSaldoCargo}" /></td>
										<td><c:out value="${ctaForm.gasolinaSaldoFavor}" /></td>
									</tr>
								</tbody>
							</table>
						</div>
						
						
		FIN -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario -->
						<!-- 						<div class="col-md-3 col-md-offset-8"> -->
						<!-- 							<button type="button" class="btn btn-primary btn-lg" id="action" -->
						<!-- 								name="action" value="Imprimir" style="margin-top: 3px" -->
						<!-- 								onclick="ACC.oblipend.bindTrmPdf('08','2','sobGasolinaReporte.pdf');"> -->
						<%-- 								<spring:theme code="obligacion.inicial.imprimir" /> --%>
						<!-- 							</button> -->
						<!-- 						</div> -->
						<div class="col-md-3 col-md-offset-8">
							<button type="button" class="btn btn-primary btn-lg"
								id="ImprimirPopUp" name="ImprimirPopUp" value="ImprimirPopUp"
								style="margin-top: 3px" data-impuesto="5">
								<spring:theme code="obligacion.inicial.imprimir" />
							</button>
						</div>
					</div>
				</div>
			</div>
			</c:if>


			<c:if test="${not empty ctaForm.tablaPublicidad}">
			<div id="publiext">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme
									code="edocuenta.inicial.publicidad.titulo" /></span>
						</h2>
					</div>
				</div>


				<div class="row">
					<div class="col-md-12 text-center">
						<div class="table-responsive">
							<table class="table tableedocuenta" id="tabPaginacion5">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.publicidad.numresol" /> </label></th>
										<!-- <th><label class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.publicidad.anigrav" /> </label></th>
										<th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="edocuenta.inicial.publicidad.tipvalla" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.publicidad.estado" /> </label></th> -->
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.publicidad.saldocargo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.publicidad.saldofavor" /> </label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach varStatus="loop" items="${ctaForm.tablaPublicidad}"
										var="eachPubli">
										
										<tr>
											<td><c:out value="${eachPubli.cabecera.noResolucion}" /></td>
											<td><c:out value="${eachPubli.cabecera.saldocargo}" /></td>
											<td><c:out value="${eachPubli.cabecera.saldofavor}" /></td>
										</tr>	
										
										
										<!--<c:forEach varStatus="loop"
											items="${eachPubli.detallePublicidad}" var="eachPubliDetail">
											<tr>
												<td><c:out value="${eachPubli.cabecera.noResolucion}" /></td>
												<td><c:out value="${eachPubliDetail.anioGravable}" /></td>
												<td><c:out value="${eachPubli.cabecera.tipoValla}" /></td>
												<td><c:out value="${eachPubliDetail.estado}" /></td> 
												<td><c:out value="${eachPubliDetail.saldoCargo}" /></td>
												<td><c:out value="${eachPubliDetail.saldoFavor}" /></td>
											</tr>
										</c:forEach>-->
										
										
									</c:forEach>

								</tbody>
							</table>
						</div>
						
						<!-- 						INI -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario
						<div class="col-md-offset-6">
							<table class="table tableedocuenta">
								<tbody>
									<tr>
										<td colspan="3" class="td-colspann"
											style="border: 0px !important;"></td>
										<td class="td-total" style="width: 264px;"><label
											class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.publicidad.total" /> </label></td>
										<td><c:out value="${ctaForm.publicidadSaldoCargo}" /></td>
										<td><c:out value="${ctaForm.publicidadSaldoFavor}" /></td>
									</tr>
								</tbody>
							</table>
						</div>
						
								FIN -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario -->
						<!-- 						<div class="col-md-3 col-md-offset-8"> -->
						<!-- 							<button type="button" class="btn btn-primary btn-lg" id="action" -->
						<!-- 								name="action" value="Imprimir" style="margin-top: 3px" -->
						<!-- 								onclick="ACC.oblipend.bindTrmPdf('54','2','pubExteriorReporte.pdf');"> -->
						<%-- 								<spring:theme code="obligacion.inicial.imprimir" /> --%>
						<!-- 							</button> -->
						<!-- 						</div> -->
						<div class="col-md-3 col-md-offset-8">
							<button type="button" class="btn btn-primary btn-lg"
								id="ImprimirPopUp" name="ImprimirPopUp" value="ImprimirPopUp"
								style="margin-top: 3px" data-impuesto="4">
								<spring:theme code="obligacion.inicial.imprimir" />
							</button>
						</div>
					</div>
				</div>
			</div>
			</c:if>
			
			
			
			
			<c:if test="${not empty ctaForm.obligNoTributaria}">
			<div id="obli-no-tributarias">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme
									code="edocuenta.inicial.obligaciones.titulo" /></span>
						</h2>
					</div>
				</div>


				<div class="row">
					<div class="col-md-12 text-center">
						<div class="table-responsive">
							<table class="table tableedocuenta" id="tabPaginacion6">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.obligaciones.concepto" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.obligaciones.anigrav" /> </label></th>
										<th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="edocuenta.inicial.obligaciones.estado" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.obligaciones.saldocargo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.obligaciones.saldofavor" /> </label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach varStatus="loop"
										items="${ctaForm.obligNoTributaria}" var="eachOblig">
										<tr>
											<td><c:out value="${eachOblig.concepto}" /></td>
											<td><c:out value="${eachOblig.anioGravable}" /></td>
											<td><c:out value="${eachOblig.estado}" /></td>
											<td><c:out value="${eachOblig.saldoCargo}" /></td>
											<td><c:out value="${eachOblig.saldoFavor}" /></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
						<!-- 						INI -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario
						<div class="col-md-offset-6">
							<table class="table tableedocuenta">
								<tbody>
									<tr>
										<td colspan="2" class="td-colspann"
											style="border: 0px !important;"></td>
										<td class="td-total" style="width: 264px;"><label
											class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.obligaciones.total" /> </label></td>
										<td><c:out value="" /></td>
										<td><c:out value="" /></td>
									</tr>
								</tbody>
							</table>
						</div>
								FIN -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario -->
					</div>
				</div>
			</div>
			</c:if>
		</div>

		<c:if test="${not empty ctaForm.reteica && ctaForm.reteica[0] != null && not empty ctaForm.reteica[0].detalleReteica }">
		<div id="impRetenedor" style="display: none;">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme code="edocuenta.inicial.reteica.titulo" /></span>
						</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<div class="table-responsive">
							<table class="table tableedocuenta" id="example">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.ica.aniograv" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.ica.periodo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.ica.estado" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.ica.saldocargo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="edocuenta.inicial.ica.saldofavor" /> </label></th>

									</tr>
								</thead>
								<tbody>
<%-- 									<c:forEach varStatus="loop" items="${ctaForm.reteica}" --%>
<%-- 										var="eachReteIca"> --%>
										<c:forEach varStatus="loop" items="${ctaForm.reteica[0].detalleReteica}"
											var="eachReteIcaDetail">
											<tr>
												<td><c:out value="${eachReteIcaDetail.anioGravable}" /></td>
												<td><c:out value="${eachReteIcaDetail.periodo}" /></td>
												<td><c:out value="${eachReteIcaDetail.estado}" /></td>
												<td><c:out value="${eachReteIcaDetail.saldoCargo}" /></td>
												<td><c:out value="${eachReteIcaDetail.saldoFavor}" /></td>
											</tr>
										</c:forEach>
<%-- 									</c:forEach> --%>

								</tbody>
							</table>
						</div>
						<!-- 						INI -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario
						<div class="col-md-offset-6">
							<table class="table tableedocuenta">
								<tbody>
									<tr>
										<td colspan="2" class="td-colspann"
											style="border: 0px !important;"></td>
										<td class="td-total" style="width: 264px;"><label
											class="control-label labeltabletd"><spring:theme
													code="edocuenta.inicial.ica.total" /> </label></td>
										<td><c:out value="${ctaForm.reteicaSaldoCargo}" /></td>
										<td><c:out value="${ctaForm.reteicaSaldoFavor}" /></td>
									</tr>
								</tbody>
							</table>
						</div>
								FIN -- MTorres, se comentan lineas de total esperando ajuste por  parte de usuario -->
						<div class="col-md-3 col-md-offset-8">
							<button type="button" class="btn btn-primary btn-lg"
								id="ImprimirPopUp" name="ImprimirPopUp" value="ImprimirPopUp"
								style="margin-top: 3px" data-impuesto="8">
								<spring:theme code="obligacion.inicial.imprimir" />
							</button>
						</div>
					</div>
				</div>

			</div>
			</c:if>

	</sf:form>
</div>

