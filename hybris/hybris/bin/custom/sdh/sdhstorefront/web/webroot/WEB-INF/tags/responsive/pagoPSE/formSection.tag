<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var = "tipoDeImpuestoSeleccionado" scope = "session" value = "${psePaymentForm.tipoDeImpuesto}"/>
<c:out value="${tipoDeImpuestoSeleccionado}"/>

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
								<formElement:formInputBox  idKey="psePaymentForm.numeroDeReferencia" maxlength="240" labelKey="psePaymentForm.numeroDeReferencia" path="numeroDeReferencia"  mandatory="true" tabindex="0" />
							</div>
							<div class="col-xs-6">
								<formElement:formSelectBox idKey="psePaymentForm.tipoDeImpuesto" labelKey="psePaymentForm.tipoDeImpuesto" path="tipoDeImpuesto" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${tipoDeImpuesto}" selectCSSClass="form-control" disabled="true"/>
							</div>
						</div>					
						<div class="row">
							<div class="col-xs-6">
								<formElement:formSelectBox idKey="psePaymentForm.anoGravable" labelKey="psePaymentForm.anoGravable" path="anoGravable" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${anoGravable}" selectCSSClass="form-control" disabled="true"/>
							</div>
							<c:if test = "${tipoDeImpuestoSeleccionado eq 'GASOLINA' or tipoDeImpuestoSeleccionado eq 'ICA' or
											tipoDeImpuestoSeleccionado eq 'VEHICULAR' or tipoDeImpuestoSeleccionado eq 'DELINEACION'}">
								<div class="col-xs-6">
									<formElement:formSelectBox idKey="psePaymentForm.periodo" labelKey="psePaymentForm.periodo" path="periodo" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${periodo}" selectCSSClass="form-control" disabled="true"/>
								</div>
							</c:if>
						</div>	
						
						<c:if test = "${tipoDeImpuestoSeleccionado eq 'PREDIAL'}">						
							<formElement:formInputBox  idKey="psePaymentForm.CHIP" maxlength="240" labelKey="psePaymentForm.CHIP" path="CHIP" inputCSS="text" mandatory="true" tabindex="0"/>
						</c:if>
						<c:if test = "${tipoDeImpuestoSeleccionado eq 'DELINEACION'}">
							<formElement:formInputBox  idKey="psePaymentForm.CUD" maxlength="240" labelKey="psePaymentForm.CUD" path="CUD" inputCSS="text" mandatory="true" tabindex="0"/>
						</c:if>
						
						<c:if test = "${tipoDeImpuestoSeleccionado eq 'PUBLICIDAD' or
						 tipoDeImpuestoSeleccionado eq 'GASOLINA' or tipoDeImpuestoSeleccionado eq 'ICA' or
						 tipoDeImpuestoSeleccionado eq 'VEHICULAR'}">
							<div class="row">
								<div class="col-xs-6">
									<formElement:formInputBox  idKey="psePaymentForm.noIdentificacion" maxlength="240" labelKey="psePaymentForm.noIdentificacion" path="noIdentificacion" inputCSS="text" mandatory="true" tabindex="0"/>
								</div>
								<div class="col-xs-6">
									<formElement:formInputBox  idKey="psePaymentForm.DV" maxlength="240" labelKey="psePaymentForm.DV" path="DV" inputCSS="text" mandatory="true" tabindex="0"/>
								</div>
							</div>									
							<formElement:formInputBox  idKey="psePaymentForm.tipoDeIdentificacion" maxlength="240" labelKey="psePaymentForm.tipoDeIdentificacion" path="tipoDeIdentificacion" inputCSS="text" mandatory="true" tabindex="0"/>
						</c:if>
						
						<c:if test = "${tipoDeImpuestoSeleccionado ne 'PREDIAL'}">
							<formElement:formInputBox  idKey="psePaymentForm.fechaLimiteDePago" maxlength="240" labelKey="psePaymentForm.fechaLimiteDePago" path="fechaLimiteDePago" inputCSS="text" mandatory="true" tabindex="0"/>
						</c:if>
						
						
						<c:if test = "${tipoDeImpuestoSeleccionado eq 'ICA' or tipoDeImpuestoSeleccionado eq 'PREDIAL'}">
							<formElement:formSelectBox idKey="psePaymentForm.pagoAdicional" labelKey="psePaymentForm.pagoAdicional" path="pagoAdicional" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${pagoAdicional}" selectCSSClass="form-control"/>
						</c:if>
						
						<formElement:formSelectBox idKey="psePaymentForm.banco" labelKey="psePaymentForm.banco" path="banco" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${banco}" selectCSSClass="form-control"/>
						<formElement:formInputBox  idKey="psePaymentForm.valorAPagar" maxlength="240" labelKey="psePaymentForm.valorAPagar" path="valorAPagar" inputCSS="text" mandatory="true" tabindex="0"/>
						<formElement:formSelectBox idKey="psePaymentForm.tipoDeTarjeta" labelKey="psePaymentForm.tipoDeTarjeta" path="tipoDeTarjeta" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${tipoDeTarjeta}" selectCSSClass="form-control"/>
						
						<div class="text-center">
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<button class="btn" type="submit">
									<img src="https://jumpseller.co/images/support/pse/logopse.png" width="80" />
								</button>
								<!--  <button class="btn btn-secondary btn-lg" type="button" onclick="window.location.href = '<c:url value="/" />'">
									<spring:theme code="register.cancel"/>
								</button> -->
							</ycommerce:testId>
						</div>
						
					</fieldset>
				</form:form>
				
						
				
			</div>
		</div>
	</div>
</div>
