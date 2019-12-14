<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="user_completeName" required="true"
	type="java.lang.String"%>
<%@ attribute name="user_documentType" required="true"
	type="java.lang.String"%>
<%@ attribute name="user_documentNumber" required="true"
	type="java.lang.String"%>
<%@ attribute name="user_numBP" required="true" type="java.lang.String"%>
<%@ attribute name="mostrarBotonesFirmas" required="true"
	type="java.lang.String"%>
<%@ attribute name="flagMostrarSoloFirmar" required="true"
	type="java.lang.String"%>
<%@ attribute name="lblBotonFirmarYAgregar" required="true"
	type="java.lang.String"%>


<div class="col-md-2">
	<div class="form-group">
		<label class="control-label"> <spring:theme
				code="publicidad.declaracion.firma.nombre" /></label> <input disabled
			id="firmCompleteName" name="firmCompleteName" class="form-control"
			disabled type="text" value="${user_completeName}" maxlength="240"></input>
	</div>
</div>
<div class="col-md-2">
	<div class="form-group">
		<label class="control-label"><spring:theme
				code="publicidad.declaracion.firma.tipoiden" /></label> <input disabled
			class="form-control FirmTipoId" disabled type="text"
			value="${user_documentType}" maxlength="240"
			id="lblcontribuyente_documentType">
	</div>
</div>
<div class="col-md-2">
	<div class="form-group">
		<label class="control-label"><spring:theme
				code="publicidad.declaracion.firma.numide" /></label> <input disabled
			class="form-control FirmNumId" disabled type="text"
			id="contribuyente_documentNumber" value="${user_documentNumber}"
			maxlength="240"></input>
	</div>
</div>

<div class="col-md-2">
	<div class="form-group">
		<label class="control-label"><spring:theme
				code="publicidad.declaracion.firma.numtarjeta" /></label> <input disabled
			class="form-control FirmTarjetaProf" disabled
			id="contribuyente_numBP" type="text" value="${user_numBP}"
			maxlength="240"></input>
	</div>
</div>
<div>
	<c:if test="${mostrarBotonesFirmas eq true}">
		<c:if test="${flagMostrarSoloFirmar eq true}">
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



