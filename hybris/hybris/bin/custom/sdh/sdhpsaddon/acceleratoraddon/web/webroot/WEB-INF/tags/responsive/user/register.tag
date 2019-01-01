<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="actionNameKey" required="true" type="java.lang.String"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<spring:htmlEscape defaultHtmlEscape="true" />
 
<c:set var="hideDescription" value="register.here" />
<spring:url value="/login/register/termsandconditions" var="getTermsAndConditionsUrl"/>

<div class="headline">
	<h2>
		<span tabindex="0"><spring:theme code="register.new.customer" /></span>
	</h2>
</div>
<spring:theme code="register.description" />


<c:if test="${!showRegisterBody || showLoginBody}">
	<p>
		<a href="<c:url value="/login?showRegisterBody=true"/>"><spring:theme code="register.here" /></a>
	</p>

</c:if>
<c:if test="${showRegisterBody || showLoginBody}">
	<p class="continuous-text">
		<spring:theme code="form.required" htmlEscape="false"/>
	</p>

	<form:form method="post" commandName="registerForm" action="${action}">
		<fieldset>
			<legend class="visuallyhidden">
				<spring:theme code="register.form" />
			</legend>
			<formElement:formSelectBox idKey="register.title" labelKey="register.title" selectCSSClass="form-control" path="titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="form.select.empty" items="${titles}" />
			<formElement:formInputBox idKey="register.firstName" maxlength="240" labelKey="register.firstName" path="firstName" inputCSS="form-control" mandatory="true" />
			<formElement:formInputBox idKey="register.lastName" maxlength="240" labelKey="register.lastName" path="lastName" inputCSS="form-control" mandatory="true" />
			<formElement:formInputBox idKey="register.email" labelKey="register.email" path="email" inputCSS="form-control" mandatory="true" />
			<formElement:formPasswordBox idKey="password" labelKey="register.pwd" path="pwd" inputCSS="form-control" mandatory="true" />
			<formElement:formPasswordBox idKey="register.checkPwd" labelKey="register.checkPwd" path="checkPwd" inputCSS="form-control" mandatory="true" />
			<c:if test="${not empty consentTemplateData}">
				<form:hidden path="consentForm.consentTemplateId" value="${ycommerce:encodeHTML(consentTemplateData.id)}" />
				<form:hidden path="consentForm.consentTemplateVersion" value="${consentTemplateData.version}" />
				<div class="form-group form-group-uncased">
					<div class="checkbox" role="checkbox">
						<label tabindex="0" class="control-label uncased"> 
							<form:checkbox path="consentForm.consentGiven" />
							<spring:theme code="registration.consent.link" var="textRegistrationConsent"/>
							<c:set var="consentManagementDescription" value="${ycommerce:encodeHTML(consentTemplateData.description)}  ${textRegistrationConsent}" />
							${consentManagementDescription}
						</label>
					</div>
				</div>
			</c:if>
			<template:errorSpanField path="termsCheck">
				<div class="checkbox">
					<label tabindex="0" class="control-label uncased">
						<form:checkbox id="registerChkTermsConditions" path="termsCheck" disabled="true"/>
						<spring:theme code="register.termsConditions" arguments="${getTermsAndConditionsUrl}" htmlEscape="false"/>
					</label>
				</div>
			</template:errorSpanField>
			
			<input type="hidden" id="recaptchaChallangeAnswered" value="${requestScope.recaptchaChallangeAnswered}" />
			
			<div class="form_field-elements control-group js-recaptcha-captchaaddon"></div>
			<div class="form-actions clearfix">
				<ycommerce:testId code="register_Register_button">
					<button type="submit" class="btn btn-default btn-block">
						<spring:theme code='${actionNameKey}' />
					</button>
				</ycommerce:testId>
			</div>
		</fieldset>
	</form:form>
</c:if>
