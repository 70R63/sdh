<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ attribute name="mostrarBotonCertiRit" required="false" type="java.lang.Boolean"%>


<c:set var="flagCertiRit" value="" />
<c:if test="${mostrarBotonCertiRit == true}">
	<c:set var="flagCertiRit" value="true" />
</c:if>


<spring:htmlEscape defaultHtmlEscape="true" />


<!-- Impresion PRedial -->
<div class="newPredialImp" style="display: none;">
	<div class="js-impuesto-facet" id="js-impuesto-facet">
		<div class="facet js-facet-imp">
			<div class="facet__name js-facet-name-imp">
				<spring:theme code="" />

				<table class="table ImprimirPredial">
					<thead>
						<tr>
							<th><label class="control-label labeltabletd tableident"><spring:theme
										code="predial.inicial.table.chip" /></label></th>
							<th><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="predial.inicial.table.matinmo" /></label></th>
							<th><label class="control-label labeltabletd "><spring:theme
										code="predial.inicial.table.dir" /></label></th>
							<th><label class="control-label labeltabletd "><spring:theme
										code="Imprimir" /></label></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${predial.predial}" var="current">
							<c:choose>
								<c:when
									test="${current.CHIP != '' && current.matrInmobiliaria != ''}">
									<tr>
										<td><c:out value="${current.CHIP}" /></td>
										<td><c:out value="${current.matrInmobiliaria}" /></td>
										<td><c:out value="${current.direccionPredio}" /></td>
										<!-- 											<td><label style="color: #0358d8 !important" -->
										<%-- 												data-anioGravable="${current.anioGravable}" --%>
										<%-- 												data-CHIP="${current.CHIP}" --%>
										<%-- 												data-matrInmobiliaria="${current.matrInmobiliaria}" --%>
										<!-- 												class="text-capitalize !important showDetailPredio" -->
										<!-- 												id="showDetailPredio" -->
										<%-- 												onclick="showDetailPredio('${current.anioGravable}','${current.CHIP}','${current.matrInmobiliaria}')"> --%>
										<%-- 													<spring:theme code="predial.inicial.table.ver" /> --%>
										<!-- 											</label></td> -->
										<c:choose>
										<c:when test="${flagCertiRit == true }">
											<td><label onclick="generarCertiRit()"><span class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>										
										</c:when>
										<c:otherwise>
											<td><label data-objeto="${current.numObjeto}"
												onclick="ACC.oblipend.bindTrmPdf('${current.numObjeto}','2','predialReporte.pdf');"><span
													class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>										
										</c:otherwise>
										</c:choose>
									</tr>
								</c:when>
								<c:when
									test="${current.CHIP != '' && current.matrInmobiliaria == ''}">
									<tr>
										<td><c:out value="${current.CHIP}" /></td>
										<td><c:out value="${current.matrInmobiliaria}" /></td>
										<td><c:out value="${current.direccionPredio}" /></td>
										<!-- 											<td><label style="color: #0358d8 !important" -->
										<%-- 												data-anioGravable="${current.anioGravable}" --%>
										<%-- 												data-CHIP="${current.CHIP}" --%>
										<%-- 												data-matrInmobiliaria="${current.matrInmobiliaria}" --%>
										<!-- 												class="text-capitalize !important showDetailPredio" -->
										<!-- 												id="showDetailPredio" -->
										<%-- 												onclick="showDetailPredio('${current.anioGravable}','${current.CHIP}','${current.matrInmobiliaria}')"> --%>
										<%-- 													<spring:theme code="predial.inicial.table.ver" /> --%>
										<!-- 											</label></td> -->
										<c:choose>
											<c:when test="${flagCertiRit == true }">
												<td><label onclick="generarCertiRit()"><span class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>										
											</c:when>
											<c:otherwise>									
												<td><label data-objeto="${current.numObjeto}"
												onclick="ACC.oblipend.bindTrmPdf('${current.numObjeto}','2','predialReporte.pdf');"><span
													class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:when>
								<c:when
									test="${current.CHIP == '' && current.matrInmobiliaria != ''}">
									<tr>
										<td><c:out value="${current.CHIP}" /></td>
										<td><c:out value="${current.matrInmobiliaria}" /></td>
										<td><c:out value="${current.direccionPredio}" /></td>
										<!-- 											<td><label style="color: #0358d8 !important" -->
										<%-- 												data-anioGravable="${current.anioGravable}" --%>
										<%-- 												data-CHIP="${current.CHIP}" --%>
										<%-- 												data-matrInmobiliaria="${current.matrInmobiliaria}" --%>
										<!-- 												class="text-capitalize !important showDetailPredio" -->
										<!-- 												id="showDetailPredio" -->
										<%-- 												onclick="showDetailPredio('${current.anioGravable}','${current.CHIP}','${current.matrInmobiliaria}')"> --%>
										<%-- 													<spring:theme code="predial.inicial.table.ver" /> --%>
										<!-- 											</label></td> -->
										<c:choose>
											<c:when test="${flagCertiRit == true }">
												<td><label onclick="generarCertiRit()"><span class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>										
											</c:when>
											<c:otherwise>									
												<td><label data-objeto="${current.numObjeto}"
												onclick="ACC.oblipend.bindTrmPdf('${current.numObjeto}','2','predialReporte.pdf');"><span
													class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:when>
								<c:otherwise>

								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tbody>
				</table>
				
				<c:if test="${flagCertiRit == true}">
					<br>
					<button class="btn btn-primary btn-block" type="button" onclick="generarCertiRit()">
						<spring:theme code="mirit.certificacion.btnGenerar" />
					</button>
					<br>
					<br>
					<br>
				</c:if>
			</div>
		</div>
	</div>
</div>

<!-- 		Impresion vehicular -->
<div class="newVehicularImp" style="display: none;">
	<div class="js-vehicular-facet" id="js-vehicular-facet">
		<div class="facet js-facet-veh">
			<div class="facet__name js-facet-name-veh">
				<spring:theme code="" />
				<table class="table ImprimirVehicular">
					<thead>
						<tr>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.table.placa" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.table.marca" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code=" Imprimir" /></label></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${vehiculosForm.impvehicular }"
							var="eachVehiculo">
							<tr>
								<td
									style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out
										value="${eachVehiculo.placa}"></c:out></td>
								<td
									style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme
										code="vehiculos.detalle.marca.${eachVehiculo.marca}" /></td>
								<!-- 							<td><label style="color: #0358d8 !important" -->
								<%-- 								data-placa="${eachVehiculo.placa}" --%>
								<%-- 								data-numbp="${vehiculosForm.numBP}" --%>
								<%-- 								class="text-capitalize !important labelVerDetVeh "><spring:theme --%>
								<%-- 										code="sobre.vehiculo.table.verdetalle" /></label></td> --%>
								<c:choose>
									<c:when test="${flagCertiRit == true }">
										<td><label onclick="generarCertiRit()"><span class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>										
									</c:when>
									<c:otherwise>								
									<td><label data-objeto="${eachVehiculo.numObjeto}"
										onclick="ACC.oblipend.bindTrmPdf('${eachVehiculo.numObjeto}','2','vehicularReporte.pdf');"><span
											class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<c:if test="${flagCertiRit == true}">
					<br>
					<button class="btn btn-primary btn-block" type="button" onclick="generarCertiRit()">
						<spring:theme code="mirit.certificacion.btnGenerar" />
					</button>
					<br>
					<br>
					<br>
				</c:if>
			</div>
		</div>
	</div>
</div>

<!-- 		Impresion ICA-->
<div class="newDelineacionImp" style="display: none;">
	<div class="js-ica-facet" id="js-ica-facet">
		<div class="facet js-facet-ica">
			<div class="facet__name js-facet-name-ica">
				<spring:theme code="" />
				<table class="table ImprimirIca">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th><label class="control-label labeltabletd"><spring:theme
										code="mirit.gas.tax.tipoDoc" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="mirit.gas.tax.numDoc" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd"> <spring:theme
										code="Imprimir" />
							</label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${ctaForm.tipoDoc}" /></td>
							<td><c:out value="${ctaForm.numDoc}" /></td>
							<!-- 									<td><label style="color: #0358d8 !important" -->
							<%-- 										data-cdu="${delineacion.cdu}" --%>
							<%-- 										class="text-capitalize !important label1Ver "><spring:theme --%>
							<%-- 												code="publicidad.exterior.ver" /></label></td> --%>
							<c:choose>
								<c:when test="${flagCertiRit == true }">
									<td><label onclick="generarCertiRit()"><span class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>										
								</c:when>
								<c:otherwise>
									<td><label
										onclick="ACC.oblipend.bindTrmPdf('${dataForm.impuestoICA.numObjeto}','2','icaReporte.pdf');"><span
											class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>
								</c:otherwise>
							</c:choose>

						</tr>
					</tbody>
				</table>


				<c:if test="${flagCertiRit == true}">
					<br>
					<button class="btn btn-primary btn-block" type="button" onclick="generarCertiRit()">
						<spring:theme code="mirit.certificacion.btnGenerar" />
					</button>
					<br>
					<br>
					<br>
				</c:if>
			</div>
		</div>
	</div>
</div>

<!-- 		Impresion Delineacion urbana -->
<div class="newDelineacionImp" style="display: none;">
	<div class="js-delineacion-facet" id="js-delineacion-facet">
		<div class="facet js-facet-del">
			<div class="facet__name js-facet-name-del">
				<spring:theme code="" />
				<table class="table ImprimirDelineacion">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th style="text-align: center"><label
								class="control-label labeltabletd"><spring:theme
										code="delineacion.urbana.CDU" /> </label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd"> <spring:theme
										code="Imprimir" />
							</label></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${dataForm.delineacion}" var="delineacion">
							<c:if test="${delineacion.cdu != ''}">
								<tr>
									<td><c:out value="${delineacion.cdu}" /></td>
									<!-- 									<td><label style="color: #0358d8 !important" -->
									<%-- 										data-cdu="${delineacion.cdu}" --%>
									<%-- 										class="text-capitalize !important label1Ver "><spring:theme --%>
									<%-- 												code="publicidad.exterior.ver" /></label></td> --%>
									<c:choose>
										<c:when test="${flagCertiRit == true }">
											<td><label onclick="generarCertiRit()"><span class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>										
										</c:when>
										<c:otherwise>
											<td><label
												onclick="ACC.oblipend.bindTrmPdf('${delineacion.numObjeto}','2','delUrbanaReporte.pdf');"><span
													class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>
										</c:otherwise>
									</c:choose>

								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>

				<c:if test="${flagCertiRit == true}">
					<br>
					<button class="btn btn-primary btn-block" type="button" onclick="generarCertiRit()">
						<spring:theme code="mirit.certificacion.btnGenerar" />
					</button>
					<br>
					<br>
					<br>
				</c:if>
			</div>
		</div>
	</div>
</div>
<!--Gasolina -->
<div class="newGasolinaImp" style="display: none;">
	<div class="js-gasolina-facet" id="js-gasolina-facet">
		<div class="facet js-facet-gas">
			<div class="facet__name js-facet-name-gas">
				<spring:theme code="" />

				<table class="table ImprimirGasolina">
					<thead>
						<tr>
							<th><label class="control-label labeltabletd"><spring:theme
										code="mirit.gas.tax.tipoDoc" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="mirit.gas.tax.numDoc" /></label></th>
							<%-- 							<th><label class="control-label labeltabletd"><spring:theme --%>
							<%-- 										code="mirit.gas.tax.numObjeto" /></label></th> --%>
							<th><label class="control-label labeltabletd" for="">
									<spring:theme code="Imprimir" />
							</label></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${dataForm.gasolina}" var="eachgas">
							<tr>
								<td><c:out value="${eachgas.tipoDoc}"></c:out></td>
								<td><c:out value="${eachgas.numDoc}" /></td>
								<%-- 								<td><c:out value="${eachgas.numObjeto}" /></td> --%>
								<c:choose>
									<c:when test="${flagCertiRit == true }">
										<td><label onclick="generarCertiRit()"><span class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>										
									</c:when>
									<c:otherwise>
										<td><label
											onclick="ACC.oblipend.bindTrmPdf('${eachgas.numObjeto}','2','sobGasolinaReporte.pdf');"><span
												class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>

					</tbody>
				</table>

				<c:if test="${flagCertiRit == true}">
					<br>
					<button class="btn btn-primary btn-block" type="button" onclick="generarCertiRit()">
						<spring:theme code="mirit.certificacion.btnGenerar" />
					</button>
					<br>
					<br>
					<br>
				</c:if>
			</div>
		</div>
	</div>
</div>


<!-- 					Publicidad Exterior -->
<div class="newPublicidadImp" style="display: none;">
	<div class="js-publicidad-facet" id="js-publicidad-facet">
		<div class="facet js-facet-pub">
			<div class="facet__name js-facet-name-pub">
				<spring:theme code="" />

				<table class="table ImprimirPublicidad">
					<thead>
						<tr>
							<th><label class="control-label " for=""><spring:theme
										code="publicidad.exterior.resolutionnumber" /></label></th>
							<th><label class="control-label " for=""> <spring:theme
										code="publicidad.exterior.typefence" /></label></th>
							<th><label class="control-label " for=""> <spring:theme
										code="Imprimir" /></label></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach varStatus="loop"
							items="${publicidadForm.publicidadExt}" var="eachPubExtTax">
							<tr>
								<td><c:out value="${eachPubExtTax.numResolu}"></c:out></td>
								<td><c:out value="${eachPubExtTax.tipoValla}"></c:out></td>
								<!-- 							<td><label style="color: #0358d8 !important" -->
								<%-- 								data-numRes="${eachPubExtTax.numResolu}" --%>
								<%-- 								data-anoGravable="${eachPubExtTax.anoGravable}" --%>
								<%-- 								data-tipoValla="${eachPubExtTax.tipoVallaCode}" --%>
								<%-- 								class="text-capitalize !important labelVer "><spring:theme --%>
								<%-- 										code="publicidad.exterior.ver" /></label></td> --%>

								<c:choose>
									<c:when test="${flagCertiRit == true }">
										<td><label onclick="generarCertiRit()"><span class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>										
									</c:when>
									<c:otherwise>
										<td><label
											onclick="ACC.oblipend.bindTrmPdf('${eachPubExtTax.numObjeto}','2','pubExteriorReporte.pdf');"><span
												class="glyphicon glyphicon-save" aria-hidden="true"></span></label></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<c:if test="${flagCertiRit == true}">
					<br>
					<button class="btn btn-primary btn-block" type="button" onclick="generarCertiRit()">
						<spring:theme code="mirit.certificacion.btnGenerar" />
					</button>
					<br>
					<br>
					<br>
				</c:if>
			</div>
		</div>
	</div>
</div>
