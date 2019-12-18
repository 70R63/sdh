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
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>

<input type="hidden" id="taxTypeRedirection"
	value="${firmaContribuyenteRedirection}">

<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL"
	htmlEscape="false" />

<div id="dialogFirmas" title="Firmas">
	<div id="firmasDialogContent"></div>
</div>


<c:set var="currentUser_completeName"
	value="${currentUser.completeName}" />
<c:set var="currentUser_documentType"
	value="${currentUser.documentType}" />
<c:set var="currentUser_documentNumber"
	value="${currentUser.documentNumber}" />
<c:set var="currentUser_numBP" value="${currentUser.numBP}" />
<c:set var="mostrarBotonesFirmas" value="false" />
<c:choose>
	<c:when test="${infoPreviaPSE.tipoImpuesto ne 5103}">
		<c:set var="lblDeclarante" value="Declarante" />
		<c:set var="lblBotonFirmarYAgregar" value="Firmar y Agregar" />
		<c:set var="flagMostrarSoloFirmar" value="true" />
		<c:set var="mostrarBotonesFirmas" value="true" />
		<c:if
			test="${contribuyente.documentType eq 'NIT' and contribuyente.numBP eq currentUser.numBP }">
			<c:set var="lblDeclarante" value="" />
			<c:set var="lblBotonFirmarYAgregar" value="Agregar firmantes" />
			<c:set var="flagMostrarSoloFirmar" value="false" />
			<c:set var="showFirmButton" value="false" />
			<c:set var="currentUser_completeName" value="" />
			<c:set var="currentUser_documentType" value="" />
			<c:set var="currentUser_documentNumber" value="" />
			<c:set var="currentUser_numBP" value="" />
			<input value="${contribuyente.documentType}" type="hidden"
				id="firmas_contribuyente_documentType" />
		</c:if>
	</c:when>
</c:choose>
<%-- --${contribuyente.documentType}-- --%>
<div class="container">
	<div class="row mt-3 representante">
		<div class="col-md-12 mt-3">
			<div class="headline">
				<h2>
					<span><spring:theme
							code="publicidad.declaracion.firma.titulo" /></span>
				</h2>
			</div>
			<c:choose>
				<c:when test="${showFirmantes ne true}">
					<!-- 				<div>seccion1inicio</div> -->
					<c:if
						test="${contribuyente.documentNumber eq currentUser.documentNumber}">
						<c:set var="mostrarBotonesFirmas" value="false" />
					</c:if>
					<div class="row mt-3">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="firmas.natural.nota2" /></label>
							</div>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-md-2">
							<div class="form-group">
								<label class="control-label"><spring:theme code="" /></label> <input
									disabled id="firmInterFunct" name="firmInterFunct"
									class="newalto form-control PEFirmInterFunct" disabled
									type="text" value="${lblDeclarante}" maxlength="240"
									placeholder="Declarante" style="margin-top: 4px">
							</div>
						</div>
						<firmas:infoCurrentUser
							user_completeName="${currentUser_completeName}"
							user_documentType="${currentUser_documentType}"
							user_documentNumber="${currentUser_documentNumber}"
							user_numBP="${currentUser_numBP}"
							mostrarBotonesFirmas="${mostrarBotonesFirmas}"
							flagMostrarSoloFirmar="${flagMostrarSoloFirmar}"
							lblBotonFirmarYAgregar="${lblBotonFirmarYAgregar}" />
					</div>
					<!-- 				<div>seccion1fin</div> -->
				</c:when>
				<c:otherwise>
					<firmas:mensajeProceso />
					<!-- 				<div>seccion2inicio</div> -->
					<firmas:firmantesWS mostrarBotonesFirmas="${mostrarBotonesFirmas}" />
					<!-- 				<div>seccion2fin</div> -->
				</c:otherwise>
			</c:choose>
			<c:if test="${showNewFirmRow}">
				<!-- 			<div>seccion3inicio</div> -->
				<div class="row mt-3">
					<firmas:infoCurrentUser
						user_completeName="${currentUser_completeName}"
						user_documentType="${currentUser_documentType}"
						user_documentNumber="${currentUser_documentNumber}"
						user_numBP="${currentUser_numBP}"
						mostrarBotonesFirmas="${mostrarBotonesFirmas}"
						flagMostrarSoloFirmar="${flagMostrarSoloFirmar}"
						lblBotonFirmarYAgregar="${lblBotonFirmarYAgregar}" />
				</div>
				<!-- 			<div>seccion3fin</div> -->

			</c:if>
		</div>
	</div>
</div>


