<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="user_completeName" required="true" type="java.lang.String"%>
<%@ attribute name="user_documentType" required="true" type="java.lang.String"%>
<%@ attribute name="user_documentNumber" required="true" type="java.lang.String"%>
<%@ attribute name="user_numBP" required="true" type="java.lang.String"%>
<%@ attribute name="mostrarBotonesFirmas" required="true" type="java.lang.String"%>
<%@ attribute name="flagMostrarSoloFirmar" required="true" type="java.lang.String"%>
<%@ attribute name="lblBotonFirmarYAgregar" required="true" type="java.lang.String"%>



<div class="row">
	<div class="col-md-9">
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"> <spring:theme code="publicidad.declaracion.firma.nombre" /></label> 
		</div>
	</div>
	<div class="col-md-2">
		<div class="form-group">
			<label class="control-label"><spring:theme code="publicidad.declaracion.firma.tipoiden" /></label> 
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label class="control-label"><spring:theme code="publicidad.declaracion.firma.numide" /></label> 
		</div>
	</div>
	
	<div class="col-md-3">
		<div class="form-group">
			<label class="control-label"><spring:theme code="publicidad.declaracion.firma.numtarjeta" /></label> 
		</div>
	</div>
	</div>
	
</div>

<div class="row">
	<div class="col-md-9">
	<div class="col-md-4">
		<div class="form-group">
			<input disabled id="firmCompleteName" name="firmCompleteName" class="newaltobtn form-control" type="text" value="${user_completeName}" maxlength="340"/>
		</div>
	</div>
	<div class="col-md-2">
		<div class="form-group">
			<input disabled id="lblcontribuyente_documentType" class="newaltobtn form-control FirmTipoId" type="text" value="${user_documentType}" maxlength="240"/>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<input disabled id="contribuyente_documentNumber" class="newaltobtn form-control FirmNumId" type="text" value="${user_documentNumber}" maxlength="240"/>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<input disabled id="contribuyente_numBP" class="newaltobtn form-control FirmTarjetaProf" type="text" value="${user_numBP}" maxlength="240"/>
		</div>
	</div>
	</div>
	<div class="col-md-3">
	<c:if test="${mostrarBotonesFirmas eq true}">
		<c:if test="${flagMostrarSoloFirmar eq true}">
			<div class="col-md-6">
				<button type="button" class="newaltobtn btn btn-primary justFirm"><spring:theme code="publicidad.declaracion.firma.soloFirmar" /></button>
			</div>
		</c:if>
		<c:if test="${showFirmAndAddButton eq true }">
			<div class="col-md-6">
				<button type="button" class="newaltobtn btn btn-primary firmAndAdd">${lblBotonFirmarYAgregar}</button>
			</div>
		</c:if>
	</c:if>
	</div>
</div>



<style>
.button {
    position: absolute;
}
</style>


