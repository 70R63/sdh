<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
		<c:if test="${not empty miRitForm.representados }">
			<div class="headline">
				<h2>
					<span tabindex="0"><spring:theme code="mirit.myRepresentants.title" text="Mis Representantes"/></span>
				</h2>
			</div>
			<div class="form-group ">
				<label class="control-label " >
					<spring:theme code="mirit.myRepresentants.howRepresentsMe" />
				</label> 
			</div>
			<div class="row">
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.myRepresentants.documentType" />
						</label> 
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.myRepresentants.documentNumber" />
						</label> 
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.myRepresentants.name" />
						</label> 
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.myRepresentants.as" />
						</label> 
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.myRepresentants.refentTo" />
						</label> 
					</div>
				</div>
			</div>
			<c:forEach items="${miRitForm.representados }" var="eachAgent">
				<div class="row">
					<div class="col-md-2">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="<spring:theme code="register.id.types.${eachAgent.tipoDoc}"/>" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="${eachAgent.numDoc}" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="${eachAgent.nomCompleto}" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="${eachAgent.funcionInterl }" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="${eachAgent.impuesto}" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<br>
		</c:if>
		
		





<c:if test="${not empty miRitForm.representantes }">
			<div class="form-group ">
				<label class="control-label " >
					<spring:theme code="mirit.myRepresentants.iRepresentTo" />
				</label> 
			</div>
			<div class="row">
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.myRepresentants.documentType" />
						</label> 
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.myRepresentants.documentNumber" />
						</label> 
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.myRepresentants.name" />
						</label> 
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.myRepresentants.as" />
						</label> 
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.myRepresentants.refentTo" />
						</label> 
					</div>
				</div>
			</div>
			<c:forEach items="${miRitForm.representantes }" var="eachAgent">
				<div class="row">
					<div class="col-md-2">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="<spring:theme code="register.id.types.${eachAgent.tipoDoc}"/>" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="${eachAgent.numDoc}" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="${eachAgent.nomCompleto}" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="${eachAgent.funcionInterl }" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="${eachAgent.impuesto}" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<br>
		</c:if>
		
		
		
		
		
		
<!-- 		<div class="form-group "> -->
<!-- 			<label class="control-label " > -->
<%-- 				<spring:theme code="mirit.myRepresentants.iRepresentTo" /> --%>
<!-- 			</label> -->
<!-- 		</div> -->
<!-- 			<!--  First column of form --> 
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-4"> -->
<!-- 				<div class="form-group "> -->
<!-- 					<label class="control-label required" for="address.surname"> -->
<%-- 						<spring:theme code="mirit.myRepresentants.documentType" /> --%>
<!-- 					</label>  -->
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
<!-- 					<div class="help-block"> -->
<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="col-md-4"> -->
<!-- 				<div class="form-group "> -->
<!-- 					<label class="control-label required" for="address.surname"> -->
<%-- 						<spring:theme code="mirit.myRepresentants.documentNumber" /> --%>
<!-- 					</label>  -->
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
<!-- 					<div class="help-block"> -->
<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-8"> -->
<!-- 				<div class="form-group "> -->
<!-- 					<label class="control-label required" for="address.surname"> -->
<%-- 						<spring:theme code="mirit.myRepresentants.name" /> --%>
<!-- 					</label>  -->
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
<!-- 					<div class="help-block"> -->
<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-4"> -->
<!-- 				<div class="form-group "> -->
<!-- 					<label class="control-label required" for="address.surname"> -->
<%-- 						<spring:theme code="mirit.myRepresentants.as" /> --%>
<!-- 					</label>  -->
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
<!-- 					<div class="help-block"> -->
<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="col-md-4"> -->
<!-- 				<div class="form-group "> -->
<!-- 					<label class="control-label required" for="address.surname"> -->
<%-- 						<spring:theme code="mirit.myRepresentants.refentTo" /> --%>
<!-- 					</label>  -->
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" disabled="disabled" aria-required="true" type="text" value="" maxlength="240"> -->
<!-- 					<div class="help-block"> -->
<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
