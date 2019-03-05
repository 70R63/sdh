<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- 
<script>
function myFunction() {
	var banco = document.getElementById("psePaymentForm.banco").value;
	var tipoDeTarjeta = document.getElementById("psePaymentForm.tipoDeTarjeta").value;
	
	var divBottonPSE = document.getElementById("bottonPSE");
	var divBottonBBVA = document.getElementById("bottonBBVA");
	var divBottonDAVIVIENDA = document.getElementById("bottonDAVIVIENDA");

	divBottonPSE.style.display = "none";
	divBottonBBVA.style.display = "none";
	divBottonDAVIVIENDA.style.display = "none";
	
	if (tipoDeTarjeta == "02"){ //Tipo De Tarjeta - Credito 
		divBottonPSE.style.display = "block";
	}else if(tipoDeTarjeta == "01"){ //Tipo De Tarjeta - Debito
		if(banco == "01"){ //Banco - Bancolombia
			divBottonPSE.style.display = "block";
		}else if(banco == "02"){ //Banco - BBVA
			divBottonBBVA.style.display = "block";
		}else if(banco == "03"){ //Banco - DAVIVIENDA
			divBottonDAVIVIENDA.style.display = "block";
		}
	}
	
}
</script>
 -->

<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var = "tipoDeImpuestoSeleccionado" scope = "session" value = "${psePaymentForm.tipoDeImpuesto}"/>
<c:set var = "buttonImagePSE" scope = "session" value = "https://jumpseller.co/images/support/pse/logopse.png"/>
<c:set var = "buttonImageBBVA" scope = "session" value = "https://pbs.twimg.com/profile_images/907185208549572608/Hn65NsHV_400x400.jpg"/>
<c:set var = "buttonImageDAVIVIENDA" scope = "session" value = "https://d31dn7nfpuwjnm.cloudfront.net/images/valoraciones/0029/4616/davivienda.png"/>
<c:set var = "disabled" scope = "session" value = "false"/>
<c:out value="${tipoDeImpuestoSeleccionado}"/>
<c:out value="${ControllerPseConstants.GASOLINA}"/>

<div class="row" >
	<div class="col-md-6 col-md-offset-3">
		<div class="item_container_holder ">
			<div class="forgotten-password item_container ">
				<c:url var="action" value="/register/validateAnswers"/> 
			
				<form:form method="post" commandName="psePaymentForm" action="realizarPago">
					<fieldset>					
						<input type="hidden" value="" class="text" name="psePaymentForm.tipoDeImpuesto" id="psePaymentForm.tipoDeImpuesto">
						<div class="row">
							<div class="col-xs-6">
<<<<<<< HEAD
								<formElement:formInputBox  idKey="psePaymentForm.numeroDeReferencia" maxlength="240" labelKey="psePaymentForm.numeroDeReferencia" path="numeroDeReferencia"  mandatory="true" tabindex="0" disabled="true"/>
=======
								<formElement:formInputBox  idKey="psePaymentForm.numeroDeReferencia" maxlength="240" labelKey="psePaymentForm.numeroDeReferencia" path="numeroDeReferencia"  mandatory="true" tabindex="0" disabled="${disabled}"/>
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
							</div>
							<div class="col-xs-6">
								<formElement:formSelectBox idKey="psePaymentForm.tipoDeImpuesto" labelKey="psePaymentForm.tipoDeImpuesto" path="tipoDeImpuesto" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${tipoDeImpuesto}" selectCSSClass="form-control" disabled="${disabled}"/>
							</div>
						</div>					
						<div class="row">
							<div class="col-xs-6">
								<formElement:formSelectBox idKey="psePaymentForm.anoGravable" labelKey="psePaymentForm.anoGravable" path="anoGravable" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${anoGravable}" selectCSSClass="form-control" disabled="${disabled}"/>
							</div>
							<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.GASOLINA or tipoDeImpuestoSeleccionado eq ControllerPseConstants.ICA or
											tipoDeImpuestoSeleccionado eq ControllerPseConstants.VEHICULAR or tipoDeImpuestoSeleccionado eq ControllerPseConstants.DELINEACION}">
								<div class="col-xs-6">
									<formElement:formSelectBox idKey="psePaymentForm.periodo" labelKey="psePaymentForm.periodo" path="periodo" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${periodo}" selectCSSClass="form-control" disabled="${disabled}"/>
								</div>
							</c:if>
						</div>	
						
<<<<<<< HEAD
						<c:if test = "${tipoDeImpuestoSeleccionado eq 'PREDIAL'}">						
							<formElement:formInputBox  idKey="psePaymentForm.CHIP" maxlength="240" labelKey="psePaymentForm.CHIP" path="CHIP" inputCSS="text" mandatory="true" tabindex="0" disabled="true"/>
						</c:if>
						<c:if test = "${tipoDeImpuestoSeleccionado eq 'DELINEACION'}">
							<formElement:formInputBox  idKey="psePaymentForm.CUD" maxlength="240" labelKey="psePaymentForm.CUD" path="CUD" inputCSS="text" mandatory="true" tabindex="0" disabled="true"/>
=======
						<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.PREDIAL}">						
							<formElement:formInputBox  idKey="psePaymentForm.CHIP" maxlength="240" labelKey="psePaymentForm.CHIP" path="CHIP" inputCSS="text" mandatory="true" tabindex="0" disabled="${disabled}"/>
						</c:if>
						<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.DELINEACION}">
							<formElement:formInputBox  idKey="psePaymentForm.CUD" maxlength="240" labelKey="psePaymentForm.CUD" path="CUD" inputCSS="text" mandatory="true" tabindex="0" disabled="${disabled}"/>
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
						</c:if>
						
						<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.PUBLICIDAD or
						 tipoDeImpuestoSeleccionado eq ControllerPseConstants.GASOLINA or tipoDeImpuestoSeleccionado eq ControllerPseConstants.ICA or
						 tipoDeImpuestoSeleccionado eq ControllerPseConstants.VEHICULAR}">
							<div class="row">
								<div class="col-xs-6">
<<<<<<< HEAD
									<formElement:formInputBox  idKey="psePaymentForm.noIdentificacion" maxlength="240" labelKey="psePaymentForm.noIdentificacion" path="noIdentificacion" inputCSS="text" mandatory="true" tabindex="0" disabled="true"/>
								</div>
								<div class="col-xs-6">
									<formElement:formInputBox  idKey="psePaymentForm.DV" maxlength="240" labelKey="psePaymentForm.DV" path="DV" inputCSS="text" mandatory="true" tabindex="0" disabled="true" />
								</div>
							</div>									
							<formElement:formInputBox  idKey="psePaymentForm.tipoDeIdentificacion" maxlength="240" labelKey="psePaymentForm.tipoDeIdentificacion" path="tipoDeIdentificacion" inputCSS="text" mandatory="true" tabindex="0" disabled="true"/>
						</c:if>
						
						<c:if test = "${tipoDeImpuestoSeleccionado ne 'PREDIAL'}">
							<formElement:formInputBox  idKey="psePaymentForm.fechaLimiteDePago" maxlength="240" labelKey="psePaymentForm.fechaLimiteDePago" path="fechaLimiteDePago" inputCSS="text" mandatory="true" tabindex="0" disabled="true"/>
=======
									<formElement:formInputBox  idKey="psePaymentForm.noIdentificacion" maxlength="240" labelKey="psePaymentForm.noIdentificacion" path="noIdentificacion" inputCSS="text" mandatory="true" tabindex="0" disabled="${disabled}"/>
								</div>
								<div class="col-xs-6">
									<formElement:formInputBox  idKey="psePaymentForm.DV" maxlength="240" labelKey="psePaymentForm.DV" path="DV" inputCSS="text" mandatory="true" tabindex="0" disabled="${disabled}" />
								</div>
							</div>									
							<formElement:formInputBox  idKey="psePaymentForm.tipoDeIdentificacion" maxlength="240" labelKey="psePaymentForm.tipoDeIdentificacion" path="tipoDeIdentificacion" inputCSS="text" mandatory="true" tabindex="0" disabled="${disabled}"/>
						</c:if>
						
						<c:if test = "${tipoDeImpuestoSeleccionado ne ControllerPseConstants.PREDIAL}">
							<formElement:formInputBox  idKey="psePaymentForm.fechaLimiteDePago" maxlength="240" labelKey="psePaymentForm.fechaLimiteDePago" path="fechaLimiteDePago" inputCSS="text" mandatory="true" tabindex="0" disabled="${disabled}"/>
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
						</c:if>
						
						
						<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.ICA or tipoDeImpuestoSeleccionado eq ControllerPseConstants.PREDIAL}">
							<formElement:formSelectBox idKey="psePaymentForm.pagoAdicional" labelKey="psePaymentForm.pagoAdicional" path="pagoAdicional" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${pagoAdicional}" selectCSSClass="form-control"/>
						</c:if>
						
						<formElement:formSelectBox idKey="psePaymentForm.banco" labelKey="psePaymentForm.banco" path="banco" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${banco}" selectCSSClass="form-control" onchange="myFunction()"/>
<<<<<<< HEAD
						<formElement:formInputBox  idKey="psePaymentForm.valorAPagar" maxlength="240" labelKey="psePaymentForm.valorAPagar" path="valorAPagar" inputCSS="text" mandatory="true" tabindex="0" disabled="true"/>
=======
						<formElement:formInputBox  idKey="psePaymentForm.valorAPagar" maxlength="240" labelKey="psePaymentForm.valorAPagar" path="valorAPagar" inputCSS="text" mandatory="true" tabindex="0" disabled="${disabled}"/>
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
						<formElement:formSelectBox idKey="psePaymentForm.tipoDeTarjeta" labelKey="psePaymentForm.tipoDeTarjeta" path="tipoDeTarjeta" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${tipoDeTarjeta}" selectCSSClass="form-control" onchange="myFunction()"/>

						
						<div class="text-center">
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<div id="bottonPSE">
									<button class="btn" type="submit">
										<img src="${buttonImagePSE} " width="80" />
									</button>
								</div>
								<!-- 
								<div id="bottonPSE" style="display:none;">
									<button class="btn" type="submit">
										<img src="${buttonImagePSE} " width="80" />
									</button>
								</div>
								<div id="bottonBBVA" style="display:none;">
									<button class="btn" type="submit">
										<img src="${buttonImageBBVA} " width="80" />
									</button>
								</div>
								<div id="bottonDAVIVIENDA" style="display:none;">
									<button class="btn" type="submit">
										<img src="${buttonImageDAVIVIENDA} " width="80" />
									</button>
								</div>
								 -->
							</ycommerce:testId>
						</div>
						
					</fieldset>
				</form:form>
				
						
				
			</div>
		</div>
	</div>
</div>
