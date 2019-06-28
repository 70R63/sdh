<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<c:set value="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara }" var="infoDeclara" />

<div class="container_new">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.generales.titulo" /></span>
				</h2>
			</div>

			<form:form action="">
				<div class="row mt-3">
					<div class="col-md-5">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.generales.aniograv" /></label> <input disabled
								id="anoGravable" name="anoGravable" class="form-control" disabled type="text" value="${anoGravable }"
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-5">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.generales.regitribut" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value="${icaInfObjetoFormResp.icaInfObjetoResponse.regimen }"
								maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.generales.periodo" /></label> <input disabled
								id="periodo" name="periodo" class="form-control" disabled type="text" value="${icaInfObjetoFormResp.icaInfObjetoResponse.periodo }"
								maxlength="240"></input>
						</div>
					</div>
			
					<div class="col-md-5">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.generales.opcuso" /></label> <input disabled
								id="opcionUso" name="opcionUso" class="form-control" disabled type="text" value="${icaInfObjetoFormResp.icaInfObjetoResponse.opcionUso }"
								maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="form-check">
							<c:set var="noChecked" value="" />
							<c:set var="yesChecked" value="" />
							<c:set var="inputDisabled" value="" />
							<c:choose>
								<c:when test="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara.entFinanciera eq 'x'}">
									<c:set var="yesChecked" value="checked" />
								</c:when>
								<c:otherwise>
									<c:set var="noChecked" value="checked" />
									<c:set var="inputDisabled" value="disabled" />
								</c:otherwise>
							</c:choose>
							<label class="form-check-label"
								 style="text-transform: none !important; font-weight: normal !important"><spring:theme
									code="ica.declaracion.generales.entfinan" /> </label> <label
								class="form-check-label"
								style="text-transform: capitalize !important; font-weight: normal !important"> <input
								type="radio" name="entidadFinanciera" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important;" onclick="disa()" ${yesChecked} value="si">
								Si
							</label> <label class="form-check-label"
								style="text-transform: capitalize !important; font-weight: normal !important"> <input
								type="radio" name="entidadFinanciera" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important; margin-left: 12px" onclick="disa2()" ${noChecked } value="no">
								No
							</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.generales.cantesta" /></label> <input 
								id="cantEstablec" name="cantEstablec" class="form-control" type="text" value="${infoDeclara.cantEstablec }"
								maxlength="240" ${inputDisabled }></input>
						</div>
					</div>
				</div>
						<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinord" /></label> <input id="totalIngrPeriodo"
						name="totalIngrPeriodo" class="form-control text-right !important" type="text" value="${infoDeclara.totalIngrPeriodo }" maxlength="240"></input>
				</div>
			</div>
		</div>
			</form:form>
		</div>
	</div>
</div>

<script>

function disa() {
	var cant = document.getElementById('cantEstablec');
	cant.disabled = false;

	}
	
function disa2() {
	var cant = document.getElementById('cantEstablec');
	cant.disabled = true;


	}
</script>

