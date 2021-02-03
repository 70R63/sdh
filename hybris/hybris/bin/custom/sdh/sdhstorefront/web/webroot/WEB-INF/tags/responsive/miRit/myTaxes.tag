<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>



<spring:htmlEscape defaultHtmlEscape="true" />




<div id="acordeon" class="container">
	<div class="card cardmirit ">
		<div class="card-header" id="head6">
			<h5 class="mb-0 cardtitle">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse6" aria-expanded="true"
					aria-controls="collapse6">
					<h4>
						<span tabindex="0"><spring:theme
								code="mirit.taxesData.title" text="Mis Impuestos" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse6" class="collapse" aria-ladelledby="head6"
			data-parent="#acordeon">
			<div class="card-body">
				<c:if test="${ not empty miRitForm.publicidadExt }">
					<div class="form-group ">
						<label class="control-label "> <spring:theme
								code="mirit.exterior.publicity.title" />
						</label>
					</div>
					<div class="row">
						<div class="col-md-10">
							<table class="table" id="tabPaginacion0" class="newtd">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.exterior.publicity.numRes" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.exterior.publicity.tipoValla" /></label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${miRitForm.publicidadExt }" var="eachItem">
										<tr>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.numResolu}"></c:out></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.tipoValla}"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<br>
				</c:if>

				<c:if test="${ not empty miRitForm.gasolina }">
					<div class="form-group ">
						<label class="control-label "> <spring:theme
								code="mirit.gas.tax.title" />
						</label>
					</div>
					<div class="row">
						<div class="col-md-10">
							<table class="table" id="tabPaginacion1" class="newtd">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.gas.tax.tipoDoc" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.gas.tax.numDoc" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.gas.tax.numObjeto" /></label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${miRitForm.gasolina }" var="eachItem">
										<tr>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.tipoDoc}"></c:out></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.numDoc}"/></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.numObjeto}"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<br>
				</c:if>




	<c:if test="${not empty  miRitForm.impuestoICA}">
		<div class="form-group ">
			<label class="control-label " ><spring:theme code="mirit.ica"/></label>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="table">
					<table class="col-md-12 table" id="tabPaginacion5">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="ica.inicial.activecono.actprin" /></label></td>
								<td><label class="control-label labeltabletd "><spring:theme
											code="ica.inicial.activecono.ciiu" /></label></td>
								<td style="width:150%"><label class="control-label labeltabletd"><spring:theme
											code="ica.inicial.activecono.denomi" /></label></td>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="ica.inicial.activecono.feciniact" /></label></td>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="ica.inicial.activecono.fecceseact" /></label></td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${miRitForm.activEconomicas}" var="actEconomicas" varStatus="loopVar">
								<c:set var="checkAEP" value=""/>
								<c:if test="${not empty actEconomicas.activPrincipal}">
									<c:set var="checkAEP" value="checked"/>
								</c:if>
								<c:set var="idRow" value="myRow_${loopVar.index}"/>
								<c:set var="inputCIIU_clickB" value="verLista_click(event,'block')"/>
								<c:set var="inputCIIU_clickN" value="verLista_click(event,'none')"/>
								<tr id="${idRow}">
									<td><input type="checkbox" name="actPrincipal"
										class="form-check-input mr-2 actividad actPrincipal"
										style="visibility: visible !important; min-height: 4px !important; width: 20px;"
										size="10" ${checkAEP} id="${idAEP_principal}">
									</td>
									<td>
										<div>
											<input class="inputtextnew inputcodciuu" id="${idInputCIIU}" value="${actEconomicas.ciiu}" 
											size="50" min="40" type="text" width="200" placeholder="Código CIIU" name="codciiu"
											onkeyup="${inputCIIU_clickB}"
											onclick="${inputCIIU_clickB}"
											onblur="${inputCIIU_clickN}"
											>
											<br>
											<ul class="list-group filtroCIIU" id="${idListaOpcionesCIIU}" style="display:none"></ul>
										</div>
									</td>
									<td>
										<input class="inputtextnew deno" value="${actEconomicas.denominacion}" size="50" min="40" type="text" width="200" disabled="disabled" name="deno" id="${idLabelDeno}">
									</td>
									<td>
										<input class="inputtextnew fechaI" value="${actEconomicas.fechaIniAct}" size="50" min="40" type="text" width="200" name="fechaIniAct">
									</td>
									<td>
										<input class="inputtextnew fechaC" value="${actEconomicas.fechaCeseAct}" size="50" min="40" type="text" width="200" name="fechaCeseAct">
									</td>
									<td>
										<img onclick="agregarActEco()" src="${themeResourcePath}/images/adddelineacion.png" style="width: 25px"></img> 
										<img onclick="borrarActEco()" src="${themeResourcePath}/images/deledelineacion.png" style="width: 25px"></img>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="row">
				<div class="col-12 col-md-2">
					<div>
						<button
							class="btn btn-primary btn-lg btn-block addressHelperField"
							type="button"
							style="margin-bottom: 10px;" id="btnActualizarInfoActEco">
							<spring:theme code="mirit.taxesData.actualizarInfo" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>




						<br>
						<br>
						<c:if test="${not empty  miRitForm.delineacion}">
						<div class="form-group ">
							<label class="control-label " >
										<spring:theme code="mirit.delineacionurbana.tax.title"/>
							</label>
						</div>
						<div class="row">
							<div class="col-md-10">
								<table class="table" id="tabPaginacion2" class="newtd">
									<thead>
										<tr>
											<th><label class="control-label labeltabletd"><spring:theme
														code="delineacion.urbana.CDU" /></label></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${miRitForm.delineacion }" var="eachItem">
											<tr>
												<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.cdu}"></c:out></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<br>
						</c:if>


				<c:if test="${ not empty miRitForm.vehicular }">
				
					<div class="form-group ">
						<label class="control-label " >
							<spring:theme code="mirit.sobrevehiculo.tax.title"/>
						</label>
					</div>
					<div class="row table-responsive">
						<div class="col-md-10 table-responsive">
							<table class="table" id="tabPaginacion3" class="newtd">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd"><spring:theme
													code="sobre.vehiculo.table.placa" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="sobre.vehiculo.table.marca" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="sobre.vehiculo.table.linea" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="sobre.vehiculo.table.modelo" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="sobre.vehiculo.table.clase" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="sobre.vehiculo.table.carroceria" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="sobre.vehiculo.table.numpuertas" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="sobre.vehiculo.table.blindado" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="sobre.vehiculo.table.cilindraje" /></label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${miRitForm.vehicular }" var="eachItem">
										<tr>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.placa}"></c:out></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme code="vehiculos.detalle.marca.${eachItem.marca}"/></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme code="vehiculos.detalle.linea.${eachItem.linea}"/></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.modelo}"></c:out></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme code="vehiculos.detalle.clase.${eachItem.clase}"/></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme code="vehiculos.detalle.carroceria.${eachItem.carroceria}"/></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.numPuertas}"></c:out></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><spring:theme code="vehiculos.detalle.blindado.${eachItem.blindado}"/></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.cilindraje}"></c:out></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				
				</c:if>



				<c:if test="${ not empty miRitForm.predial }">
				
					<div class="form-group ">
						<label class="control-label " >
							<spring:theme code="mirit.impuestos.predial.titulo"/>
						</label>
					</div>
					<div class="row table-responsive">
						<div class="col-md-10">
							<table class="table" id="tabPaginacion4" class="newtd">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.impuestos.predial.CHIP" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.impuestos.predial.matrInmobiliaria" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.impuestos.predial.direccionPredio" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.impuestos.predial.contratoArrenda" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.impuestos.predial.anioGravable" /></label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="mirit.impuestos.predial.numObjeto" /></label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${miRitForm.predial}" var="eachItem">
										<tr>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.CHIP}"></c:out></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.matrInmobiliaria}"/></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.direccionPredio}"/></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.contratoArrenda}"></c:out></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.anioGravable}"/></td>
											<td style="font-family: 'Helvetica Normal', 'Helvetica'; font-size: 12px !important; font-weight: 400; font-style: normal; text-transform: none !important;"><c:out value="${eachItem.numObjeto}"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				
				</c:if>

				<!-- 		<div class="form-group "> -->
				<!-- 			<label class="control-label " > -->
				<%-- 				<spring:theme code="mirit.taxesData.unifiedPropertyTax"/> --%>
				<!-- 			</label> -->
				<!-- 		</div>		  -->
				<!-- 		<div class="row"> -->
				<!-- 			<div class="col-md-1"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.chip"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname"  disabled="disabled"  name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-1"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.propertyLicence"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname"  disabled="disabled" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-3"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.propertyAddress"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-2"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.propertyRelation"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 				<div class="col-md-2"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.propertyReponsabilityPercentage"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 		</div> -->
				<!-- 		<div class="row"> -->
				<!-- 			<div class="col-md-1"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.chip"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-1"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.propertyLicence"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-3"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.propertyAddress"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-2"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.propertyRelation"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 				<div class="col-md-2"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.propertyReponsabilityPercentage"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 		</div> -->
				<!-- 		<br> -->
				<!-- 		<br> -->
				<!-- 		<div class="form-group "> -->
				<!-- 			<label class="control-label " > -->
				<%-- 				<spring:theme code="mirit.taxesData.VehiclesTax"/> --%>
				<!-- 			</label>  -->
				<!-- 		</div> -->
				<!-- 		<div class="row"> -->
				<!-- 			<div class="col-md-1"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.vehicleLicense"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-1"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.vehicleModel"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-3"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.vehicleDescription"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-2"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.vehicleRelation"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 				<div class="col-md-2"> -->
				<!-- 					<div class="form-group "> -->
				<!-- 						<label class="control-label required" for="address.surname"> -->
				<%-- 							<spring:theme code="mirit.taxesData.vehicleResponsabilityPercetage"/> --%>
				<!-- 						</label>  -->
				<!-- 						<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 						<div class="help-block"> -->
				<!-- 							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 				<div class="col-md-1"> -->
				<!-- 					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> -->
				<!-- 				</div> -->
				<!-- 		</div> -->
				<!-- 		<div class="row"> -->
				<!-- 			<div class="col-md-1"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.vehicleLicense"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-1"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.vehicleModel"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-3"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.vehicleDescription"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			<div class="col-md-2"> -->
				<!-- 				<div class="form-group "> -->
				<!-- 					<label class="control-label required" for="address.surname"> -->
				<%-- 						<spring:theme code="mirit.taxesData.vehicleRelation"/> --%>
				<!-- 					</label>  -->
				<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 					<div class="help-block"> -->
				<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 				<div class="col-md-2"> -->
				<!-- 					<div class="form-group "> -->
				<!-- 						<label class="control-label required" for="address.surname"> -->
				<%-- 							<spring:theme code="mirit.taxesData.vehicleResponsabilityPercetage"/> --%>
				<!-- 						</label>  -->
				<!-- 						<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
				<!-- 						<div class="help-block"> -->
				<!-- 							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 				<div class="col-md-1"> -->
				<!-- 					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> -->
				<!-- 				</div> -->
				<!-- 		</div> -->
			</div>
		</div>
	</div>
</div>



<script>

function verLista_click(event,flagVisualizacion){
    
	if(flagVisualizacion == "block"){
	    var rowID = $(event.target).parent().parent().parent()[0].id;
	    var value = event.target.value.toLowerCase().trim();
	    
		$("#"+rowID).children().find(".filtroCIIU").empty();
		llenarLista(rowID);
		filtrarLista_3(rowID,value);
		$("#"+rowID).children().find(".filtroCIIU").show();	    
	}else{
		$("#tabPaginacion5 tbody tr").each( function(indexRows){
			$(this).children().find(".filtroCIIU").each( function(){
				debugger;
				var elemento = $(this);
				$(this).hide();
			});
		});
	}

}


function filtrarLista_3(rowID,value){
	
	$($("#"+rowID).children().find(".filtroCIIU")[0]).children().filter(function() {
		var itemLista = $(this)[0];
		$(itemLista).toggle($(itemLista).text().toLowerCase().indexOf(value) > -1);
    });
	

}

function filtrarLista_4(rowID,value){
	
	$($("#"+rowID).children().find(".filtroCIIU")[0]).children().filter(function() {
		var itemLista = $(this)[0];
		var codigoRenglon = $(itemLista).text().toLowerCase().split(" - ")[0];
		$(itemLista).toggle(codigoRenglon == value);
    });
	
}

function llenarLista(rowID){
	
	for(var i = 0;i<codigos_ciiu.length;i++){
		$("#"+rowID).children().find(".filtroCIIU").append('<li onmousedown="seleccionarValor(event)">'+codigos_ciiu[i].id_ciiu + ' - ' + codigos_ciiu[i].item_ciiu + '</li>');
	}

}


function seleccionarValor(event){
	
	var rowID = $(event.target).parent().parent().parent().parent()[0].id;
	if(rowID != null){
		var indiceSeparador = $(event.target).text().indexOf(" - ");
		var newInputVal = "";
		var newDenoVal = "";
		
		if(indiceSeparador >= 0){
			var newInputVal = $(event.target).text().substring(0,indiceSeparador);
			var newDenoVal = $(event.target).text().substring(indiceSeparador+3, $(event.target).text().length);
		}
		$($("#"+rowID).children().find(".inputcodciuu")[0]).val(newInputVal);
		$($("#"+rowID).children().find(".deno")[0]).val(newDenoVal);
		filtrarLista_3(rowID,newInputVal);
	}
	
}


function filtrarLista(event,objeto){

	var value = $(objeto).val().toLowerCase();
    $(".filtroCIIU li").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
    
}


function agregarActEco() {

	debugger;
	var numeradorUltimoId = $($("#tabPaginacion5 tbody tr")[0]).parent().children().last().attr("id").split("_")[1];
	numeradorUltimoId++;
	
	var tam = $("#tabPaginacion5 tbody").length;
	$($("#tabPaginacion5 tbody")).parent().append($($("#tabPaginacion5 tbody tr")[0]).clone());
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".actPrincipal").prop("checked", false);
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".inputcodciuu").val("");
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".deno").val("");
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".fechaI").val("");
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".fechaC").val("");
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".filtroCIIU").hide();
	
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".actPrincipal").prop("disabled", false);
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".inputcodciuu").prop("disabled", false);
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".deno").prop("disabled", false);
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".fechaI").prop("disabled", false);
	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().find(".fechaC").prop("disabled", false);

	$($("#tabPaginacion5 tbody tr")[0]).parent().children().last().prop("id", "myRow_"+numeradorUltimoId);

}

function borrarActEco(selectObject) {
	;
	var result = confirm("¿Desea borrar el registro?");
	if (result == true) {
		var elem = document.getElementsByTagName("img");
		var ElementosClick = new Array();
		var HaHechoClick;
	
		HaHechoClick = event.srcElement;
		ElementosClick.push(HaHechoClick);
		var cual2 = ElementosClick[0];
	
		for (var i = 0; i < elem.length; i++) {
			var cual = elem[i];
	
			if (cual == cual2) {
				var h = $("#tabPaginacion5 tbody tr").length;
				var contador_actPrincipal = 0;
				
				$("#tabPaginacion5 tbody tr").each( function(){
					var actPrincipal = $(this).children().find(".actPrincipal");
					if($(actPrincipal).prop("disabled") == false){
					contador_actPrincipal++;
				}
				});
				
				if(contador_actPrincipal > 1){
					var d = new Date();
					var fechaActual = d.getDate() + "/" + (d.getMonth()+1) + "/" + d.getFullYear();
					$(cual).parent().parent().children().find(".actPrincipal").prop("checked", false);
					$(cual).parent().parent().children().find(".actPrincipal").prop("disabled", true);
					$(cual).parent().parent().children().find(".inputcodciuu").prop("disabled", true);
					$(cual).parent().parent().children().find(".deno").prop("disabled", true);
					$(cual).parent().parent().children().find(".fechaI").prop("disabled", true);
					$(cual).parent().parent().children().find(".fechaC").val(fechaActual);
					$(cual).parent().parent().children().find(".fechaC").prop("disabled", true);
					
					var flagActividadEstablecida = false;
					$("#tabPaginacion5 tbody tr").each( function(){
						var actPrincipal = $(this).children().find(".actPrincipal");
						
						if($(actPrincipal).prop("disabled") == false && flagActividadEstablecida == false){
							$(actPrincipal).prop("checked", true);
							flagActividadEstablecida = true;
					}
					});
				}else{
					alert("No puede eliminar todos los registros");
				}
// 				if ($("#tabPaginacion5 tbody tr").length <= 100 && $("#tabPaginacion5 tbody tr").length > 1) {
// 					for (var j = 0; j < $("#tabPaginacion5 tbody tr").length; j++) {
// 						eliminar.remove();
// 					}
// 				} else if ($("#tabPaginacion5 tbody tr").length <= 1) {
// 					alert("No puede eliminar todos los registros");
// 				}

				break;
			} else {
			}
		}
	}
}

</script>
