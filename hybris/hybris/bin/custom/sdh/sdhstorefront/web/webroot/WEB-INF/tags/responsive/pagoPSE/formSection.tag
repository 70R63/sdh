<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var = "tipoDeImpuesto" scope = "session" value = "${param.tipoDeImpuesto}"/>
<c:out value="${tipoDeImpuesto}"/><br>

<div class="row" >
	<div class="col-md-6 col-md-offset-3">
		<div class="item_container_holder ">
			<div class="forgotten-password item_container ">
				<c:url var="action" value="/register/validateAnswers"/> 
			
				<form:form method="post" commandName="psePaymentForm" action="https://www.google.com">
					<fieldset>					
						<input type="hidden" value="" class="text" name="psePaymentForm.tipoDeImpuesto" id="psePaymentForm.tipoDeImpuesto">
						<div class="row">
							<div class="col-xs-6">
								<formElement:formInputBox  idKey="psePaymentForm.numeroDeReferencia" maxlength="240" labelKey="psePaymentForm.numeroDeReferencia" path="numeroDeReferencia" inputCSS="text" mandatory="true" tabindex="0"/>
							</div>
							<div class="col-xs-6">
								<formElement:formInputBox  idKey="psePaymentForm.impuesto" maxlength="240" labelKey="psePaymentForm.impuesto" path="impuesto" inputCSS="text" mandatory="true" tabindex="0"/>
							</div>
						</div>					
						<div class="row">
							<div class="col-xs-6">
								<formElement:formSelectBox idKey="psePaymentForm.anoGravable" labelKey="psePaymentForm.anoGravable" path="anoGravable" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${anoGravable}" selectCSSClass="form-control"/>
							</div>
							<c:if test = "${tipoDeImpuesto eq 'GASOLINA' or tipoDeImpuesto eq 'ICA' or
											tipoDeImpuesto eq 'VEHICULAR' or tipoDeImpuesto eq 'DELINEACION'}">
								<div class="col-xs-6">
									<formElement:formSelectBox idKey="psePaymentForm.periodo" labelKey="psePaymentForm.periodo" path="periodo" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${periodo}" selectCSSClass="form-control"/>
								</div>
							</c:if>
						</div>	
						
						<c:if test = "${tipoDeImpuesto eq 'PREDIAL'}">						
							<formElement:formInputBox  idKey="psePaymentForm.CHIP" maxlength="240" labelKey="psePaymentForm.CHIP" path="CHIP" inputCSS="text" mandatory="true" tabindex="0"/>
						</c:if>
						<c:if test = "${tipoDeImpuesto eq 'DELINEACION'}">
							<formElement:formInputBox  idKey="psePaymentForm.CUD" maxlength="240" labelKey="psePaymentForm.CUD" path="CUD" inputCSS="text" mandatory="true" tabindex="0"/>
						</c:if>
						
						<c:if test = "${tipoDeImpuesto eq 'PUBLICIDAD' or
						 tipoDeImpuesto eq 'GASOLINA' or tipoDeImpuesto eq 'ICA' or
						 tipoDeImpuesto eq 'VEHICULAR'}">
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
						
						<c:if test = "${tipoDeImpuesto ne 'PREDIAL'}">
							<formElement:formInputBox  idKey="psePaymentForm.fechaLimiteDePago" maxlength="240" labelKey="psePaymentForm.fechaLimiteDePago" path="fechaLimiteDePago" inputCSS="text" mandatory="true" tabindex="0"/>
						</c:if>
						
						
						<c:if test = "${tipoDeImpuesto eq 'ICA' or tipoDeImpuesto eq 'PREDIAL'}">
							<formElement:formSelectBox idKey="psePaymentForm.pagoAdicional" labelKey="psePaymentForm.pagoAdicional" path="pagoAdicional" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${pagoAdicional}" selectCSSClass="form-control"/>
						</c:if>
						
						<formElement:formSelectBox idKey="psePaymentForm.banco" labelKey="psePaymentForm.banco" path="banco" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${banco}" selectCSSClass="form-control"/>
						<formElement:formInputBox  idKey="psePaymentForm.valorAPagar" maxlength="240" labelKey="psePaymentForm.valorAPagar" path="valorAPagar" inputCSS="text" mandatory="true" tabindex="0"/>
						<formElement:formSelectBox idKey="psePaymentForm.tipoDeTarjeta" labelKey="psePaymentForm.tipoDeTarjeta" path="tipoDeTarjeta" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${tipoDeTarjeta}" selectCSSClass="form-control"/>
						
						<div class="text-right">
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<button class="btn btn-primary btn-lg" type="submit">
									<spring:theme code="register.send"/>
								</button>
								<button class="btn btn-secondary btn-lg" type="button" onclick="window.location.href = '<c:url value="/" />'">
									<spring:theme code="register.cancel"/>
								</button>
							</ycommerce:testId>
						</div>
						
					</fieldset>
				</form:form>
				
						
				
			</div>
		</div>
	</div>
</div>
