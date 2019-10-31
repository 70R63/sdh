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
					<c:forEach items="${miRitForm.publicidadExt }" var="eachPubExtTax">
						<div class="row">
							<div class="col-md-3">
								<div class="form-group ">
									<label class="control-label " for=""> <spring:theme
											code="mirit.exterior.publicity.numRes" />
									</label> <input id="numResolu" disabled="disabled" name="numResolu"
										class="newalto form-control" aria-required="true"
										type="text" value="${eachPubExtTax.numResolu }"
										maxlength="240">
									<div class="help-block">
										<span id="lastName.errors" class="hidden">Seleccione un
											tipo de documento</span>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group ">
									<label class="control-label " for=""> <spring:theme
											code="mirit.exterior.publicity.tipoValla" />
									</label> <input id="tipoValla" disabled="disabled" name="tipoValla"
										class="newalto form-control" aria-required="true"
										type="text" value="${eachPubExtTax.tipoValla }"
										maxlength="240">
									<div class="help-block">
										<span id="lastName.errors" class="hidden">Seleccione un
											tipo de documento</span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<br>
				</c:if>

				<c:if test="${ not empty miRitForm.gasolina }">
					<div class="form-group ">
						<label class="control-label "> <spring:theme
								code="mirit.gas.tax.title" />
						</label>
					</div>
					<c:forEach items="${miRitForm.gasolina }" var="eachGasTax"
						varStatus="status">
						<div class="row">
							<div class="col-md-3">
								<div class="form-group ">
									<label class="control-label " for=""> <spring:theme
											code="mirit.gas.tax.tipoDoc" />
									</label> <input id="gasolina[${status.index }].tipoDoc"
										disabled="disabled" name="gasolina[${status.index }].tipoDoc"
										class="newalto_dir form-control" aria-required="true"
										type="text"
										value="<spring:theme code="register.id.types.${eachGasTax.tipoDoc }" />"
										maxlength="240">
									<div class="help-block">
										<span id="lastName.errors" class="hidden">Seleccione un
											tipo de documento</span>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group ">
									<label class="control-label " for=""> <spring:theme
											code="mirit.gas.tax.numDoc" />
									</label> <input id="gasolina[${status.index }].numDoc"
										disabled="gasolina[${status.index }].numDoc" name="lastName"
										class="newalto form-control" aria-required="true"
										type="text" value="${eachGasTax.numDoc }" maxlength="240">
									<div class="help-block">
										<span id="lastName.errors" class="hidden">Seleccione un
											tipo de documento</span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<br>

				</c:if>




						<c:if test="${not empty  miRitForm.impuestoICA}">
						<div class="form-group ">
							<label class="control-label " >
										<spring:theme code="mirit.ica"/>
							</label>
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="form-group ">
									<label class="control-label required" for="address.surname">
										<spring:theme code="mirit.gas.tax.numDoc" />
									</label> 
									<input id="address.surname" disabled="disabled" name="lastName" class="newalto form-control form-control" aria-required="true" type="text" value="<spring:theme  code='register.id.types.${miRitForm.tipoDoc}' />" maxlength="240">
									<div class="help-block">
										<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
									</div>
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group ">
									<label class="control-label required" for="address.surname">
										<spring:theme code="mirit.gas.tax.numDoc" />
									</label> 
									<input id="address.surname" disabled="disabled" name="lastName" class=" newalto form-control form-control" aria-required="true" type="text" value="${miRitForm.numDoc }" maxlength="240">
									<div class="help-block">
										<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
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
										<spring:theme code="mirit.ica"/>
							</label>
						</div>
						<c:forEach items="${miRitForm.delineacion }" var="eachDelineacion">
						<div class="row">
							
							<div class="col-md-3">
								<div class="form-group ">
									<label class="control-label required" for="address.surname">
										CDU
									</label> 
									<input id="address.surname" disabled="disabled" name="lastName" class="newalto form-control form-control" aria-required="true" type="text" value="${eachDelineacion.cdu }" maxlength="240">
								</div>
							</div>
							
						</div>
						</c:forEach>
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

