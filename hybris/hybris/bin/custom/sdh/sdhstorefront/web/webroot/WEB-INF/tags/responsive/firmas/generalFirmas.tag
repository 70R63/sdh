<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ attribute name="firmaContribuyenteRedirection" required="false"
	type="java.lang.String"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<input type="hidden" id="taxTypeRedirection"
	value="${firmaContribuyenteRedirection}">

<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL"
	htmlEscape="false" />

<div id="dialogFirmas" title="Firmas">
	<div id="firmasDialogContent"></div>
</div>


<c:choose>
	<c:when test="${contribuyente.documentType ne 'NIT'}">
		<c:set var="lblDeclarante" value="Declarante" />
		<c:set var="lblBotonFirmarYAgregar" value="Firmar y Agregar" />
		<c:set var="contribuyente_completeName"
			value="${contribuyente.completeName}" />
		<c:set var="contribuyente_documentType"
			value="${contribuyente.documentType}" />
		<c:set var="contribuyente_documentNumber"
			value="${contribuyente.documentNumber}" />
		<c:set var="contribuyente_numBP" value="${contribuyente.numBP}" />
		<c:set var="flagMostrarSoloFirmar" value="true" />
	</c:when>
	<c:otherwise>
		<c:set var="lblDeclarante" value="" />
		<c:set var="lblBotonFirmarYAgregar" value="Agregar firmantes" />
		<c:set var="contribuyente_completeName" value="" />
		<c:set var="contribuyente_documentType" value="" />
		<c:set var="contribuyente_documentNumber" value="" />
		<c:set var="contribuyente_numBP" value="" />
		<c:set var="flagMostrarSoloFirmar" value="false" />
		<c:set var="showFirmButton" value="false" />
	</c:otherwise>
</c:choose>
<input value="${contribuyente.documentType}" type="hidden" id="firmas_contribuyente_documentType"/>
<%-- --${contribuyente.documentType}-- --%>
<div class="row mt-3 representante">
	<div class="col-md-12 mt-3">
		<div class="headline" style="margin-left: 140px !important">
			<h2>
				<span><spring:theme
						code="publicidad.declaracion.firma.titulo" /></span>
			</h2>
		</div>
		<c:choose>
			<c:when test="${showFirmantes ne true}">
<!-- <div>aqui1inicio</div> -->
				<div class="row mt-3">
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme code="" /></label> <input
								disabled id="firmInterFunct" name="firmInterFunct"
								class="form-control PEFirmInterFunct" disabled type="text"
								value="${lblDeclarante}" maxlength="240"
								placeholder="Declarante" style="margin-top: 4px">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"> <spring:theme
									code="publicidad.declaracion.firma.nombre" /></label> <input disabled
								id="firmCompleteName" name="firmCompleteName"
								class="form-control" disabled type="text"
								value="${contribuyente_completeName}" maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="publicidad.declaracion.firma.tipoiden" /></label> <input
								disabled class="form-control FirmTipoId" disabled type="text"
								value="${contribuyente_documentType}" maxlength="240" id="lblcontribuyente_documentType"></input> <input
								type="hidden" value="${contribuyente.documentType}"
								id="contribuyente_documentType" />
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="publicidad.declaracion.firma.numide" /></label> <input disabled
								class="form-control FirmNumId" disabled type="text" id= "contribuyente_documentNumber"
								value="${contribuyente_documentNumber}" maxlength="240"></input>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="publicidad.declaracion.firma.numtarjeta" /></label> <input
								disabled class="form-control FirmTarjetaProf" disabled id="contribuyente_numBP"
								type="text" value="${contribuyente_numBP}" maxlength="240"></input>
						</div>
					</div>
					<c:if
						test="${contribuyente.documentNumber eq currentUser.documentNumber}">
						<c:if test="${flagMostrarSoloFirmar == true}">
							<div class="col-md-1">
								<label class="control-label"><spring:theme code="" /></label>
								<button type="button" class="btn btn-primary justFirm"
									style="margin-top: 4px">Solo Firmar</button>
							</div>
						</c:if>
						<c:if test="${showFirmAndAddButton eq true }">
							<div class="col-md-1">
								<label class="control-label"><spring:theme code="" /></label>
								<button type="button" class="btn btn-primary firmAndAdd"
									style="margin-top: 4px">${lblBotonFirmarYAgregar}</button>
							</div>
						</c:if>
					</c:if>
				</div>
<!-- <div>aqui1fin</div> -->
			</c:when>

			<c:otherwise>
<!-- <div>aqui2inicio</div> -->
				<c:forEach items="${firmantes}" var="eachFirmante">
					<c:if test="${!empty eachFirmante.tipoIdent}">
						<div class="row mt-3">
							<div class="col-md-2">
								<div class="form-group">
									<label class="control-label"> <spring:theme
											code="publicidad.declaracion.firma.nombre" /></label> <input
										disabled id="firmCompleteName" name="firmCompleteName"
										class="form-control" disabled type="text"
										value="${eachFirmante.nombre}" maxlength="240"></input>
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label class="control-label"><spring:theme
											code="publicidad.declaracion.firma.tipoiden" /></label> <input
										disabled class="form-control FirmTipoId" disabled type="text"
										value="${eachFirmante.tipoIdent}" maxlength="240"></input>
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label class="control-label"><spring:theme
											code="publicidad.declaracion.firma.numide" /></label> <input
										disabled class="form-control FirmNumId" disabled type="text"
										value="${eachFirmante.numIdent}" maxlength="240"></input>
								</div>
							</div>

							<div class="col-md-2">
								<div class="form-group">
									<label class="control-label"><spring:theme
											code="publicidad.declaracion.firma.numtarjeta" /></label> <input
										disabled class="form-control FirmTarjetaProf" disabled
										type="text" value="${eachFirmante.tarjetaProd}"
										maxlength="240"></input>
								</div>
							</div>

							<c:if
								test="${showFirmButton eq true && currentUserData.documentNumber eq eachFirmante.numIdent}">
								<div class="col-md-1">
									<label class="control-label"><spring:theme code="" /></label>
									<button type="button" class="btn btn-primary justFirm"
										style="margin-top: 4px">Solo Firmar</button>
								</div>
							</c:if>
							<c:if
								test="${showFirmAndAddButton eq true && currentUserData.documentNumber eq eachFirmante.numIdent}">
								<div class="col-md-1">
									<label class="control-label"><spring:theme code="" /></label>
									<button type="button" class="btn btn-primary firmAndAdd"
										style="margin-top: 4px">Firmar y Agregar</button>
								</div>
							</c:if>
						</div>
					</c:if>
				</c:forEach>
<!-- <div>aqui2fin</div> -->
			</c:otherwise>
		</c:choose>
		<c:if test="${showNewFirmRow}">
<!-- <div>aqui3inicio</div> -->
			<div class="row mt-3">
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"> <spring:theme
								code="publicidad.declaracion.firma.nombre" /></label> <input disabled
							id="firmCompleteName" name="firmCompleteName"
							class="form-control" disabled type="text"
							value="${contribuyente_completeName}" maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="publicidad.declaracion.firma.tipoiden" /></label> <input disabled
							class="form-control FirmTipoId" disabled type="text"
							value="${contribuyente_documentType}" maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="publicidad.declaracion.firma.numide" /></label> <input disabled
							class="form-control FirmNumId" disabled type="text"
							value="${contribuyente_documentNumber}" maxlength="240"></input>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="publicidad.declaracion.firma.numtarjeta" /></label> <input
							disabled class="form-control FirmTarjetaProf" disabled
							type="text" value="${contribuyente_numBP}" maxlength="240"></input>
					</div>
				</div>

				<c:if test="${showFirmButton eq true }">
					<div class="col-md-1">
						<label class="control-label"><spring:theme code="" /></label>
						<button type="button" class="btn btn-primary justFirm"
							style="margin-top: 4px">Solo Firmar</button>
					</div>
				</c:if>
				<c:if test="${showFirmAndAddButton eq true }">
					<div class="col-md-1">
						<label class="control-label"><spring:theme code="" /></label>
						<button type="button" class="btn btn-primary firmAndAdd"
							style="margin-top: 4px">${lblBotonFirmarYAgregar}</button>
					</div>
				</c:if>

			</div>
<!-- <div>aqui3fin</div> -->
			
		</c:if>
	</div>
</div>


