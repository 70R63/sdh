<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<!-- <c:out value="ModeDebuge = ${debugMode}"/> -->

<div class="row" >
	<div class="col-md-6 col-md-offset-3">
		<div class="item_container_holder ">
			<div class="forgotten-password item_container ">
				<c:url var="action" value="/register/validateAnswers"/> 
			
				<form:form method="post" commandName="psePaymentForm" action="pagoEnLinea/form">
					<fieldset>					
						
						<formElement:formSelectBox idKey="psePaymentForm.tipoDeImpuesto" labelKey="psePaymentForm.tipoDeImpuesto" path="tipoDeImpuesto" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${tipoDeImpuesto}" selectCSSClass="form-control" disabled="false"/>
						<formElement:formSelectBox idKey="psePaymentForm.anoGravable" labelKey="psePaymentForm.anoGravable" path="anoGravable" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${anoGravable}" selectCSSClass="form-control" disabled="false"/>
						<formElement:formSelectBox idKey="psePaymentForm.periodo" labelKey="psePaymentForm.periodo" path="periodo" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${periodo}" selectCSSClass="form-control" disabled="false"/>
						<form:hidden path="debugMode" value="${debugMode}"/>
						
						<formElement:formInputBox idKey="numeroDeReferencia" labelKey="numeroDeReferencia" path="numeroDeReferencia" />
						<formElement:formInputBox idKey="noIdentificacion" labelKey="noIdentificacion" path="noIdentificacion" />
						<formElement:formInputBox idKey="DV" labelKey="DV" path="DV" />
						<formElement:formInputBox idKey="tipoDeIdentificacion" labelKey="tipoDeIdentificacion" path="tipoDeIdentificacion" />
						<formElement:formInputBox idKey="fechaLimiteDePago" labelKey="fechaLimiteDePago" path="fechaLimiteDePago" />
						<formElement:formInputBox idKey="valorAPagar" labelKey="valorAPagar" path="valorAPagar" />
						<formElement:formInputBox idKey="objPago" labelKey="objPago" path="objPago" />

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
