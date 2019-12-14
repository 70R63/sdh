<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="mostrarBotonesFirmas" required="true"
	type="java.lang.String"%>


<c:forEach items="${firmantes}" var="eachFirmante">
	<c:if test="${!empty eachFirmante.tipoIdent}">
		<div class="row mt-3">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"> <spring:theme
							code="publicidad.declaracion.firma.nombre" /></label> <input disabled
						id="firmCompleteName" name="firmCompleteName" class="form-control"
						disabled type="text" value="${eachFirmante.nombre}"
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.declaracion.firma.tipoiden" /></label> <input disabled
						class="form-control FirmTipoId" disabled type="text"
						value="${eachFirmante.tipoIdent}" maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.declaracion.firma.numide" /></label> <input disabled
						class="form-control FirmNumId" disabled type="text"
						value="${eachFirmante.numIdent}" maxlength="240"></input>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="publicidad.declaracion.firma.numtarjeta" /></label> <input
						disabled class="form-control FirmTarjetaProf" disabled type="text"
						value="${eachFirmante.tarjetaProd}" maxlength="240"></input>
				</div>
			</div>

			<c:if test="${mostrarBotonesFirmas eq true}">
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
			</c:if>
		</div>
	</c:if>
</c:forEach>



