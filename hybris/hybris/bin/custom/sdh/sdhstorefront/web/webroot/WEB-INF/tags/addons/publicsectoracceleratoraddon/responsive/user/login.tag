<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="actionNameKey" required="true" type="java.lang.String"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var="hideDescription" value="checkout.login.loginAndCheckout" />

<div class="headline">
	<h2>
		<span tabindex="0"><spring:theme code="login.title" /></span>
	</h2>
</div>

<c:if test="${actionNameKey ne hideDescription}">
	<spring:theme code="login.description" htmlEscape="false" var="loginDescription"/>
	${ycommerce:sanitizeHTML(loginDescription)}
</c:if>

<p class="continuous-text">
	<spring:theme code="form.required" htmlEscape="false" />
</p>

<form:form action="${action}" method="post" commandName="loginForm">
	<fieldset>
		<legend class="visuallyhidden">
			<spring:theme code="login.form" />
		</legend>

		<c:if test="${not empty message}">
			<span class="has-error"> <spring:theme code="${message}" />
			</span>
		</c:if>

		<formElement:formInputBox idKey="j_username" labelKey="login.email" path="j_username" mandatory="true" />
		<formElement:formPasswordBox idKey="j_password" labelKey="login.password" path="j_password" inputCSS="form-control" mandatory="true" />
		<input type="hidden" id="registeredCheckout" name="registeredCheckout" value="${registeredCheckout}" />

		<div class="forgotten-password">
			<ycommerce:testId code="login_forgotPassword_link">
				<a href="<c:url value='/login/pw/request'/>" class="forgot-password-disabled" data-cbox-title="<spring:theme code="forgottenPwd.title"/>"> <spring:theme code="login.link.forgottenPwd" />
				</a>
			</ycommerce:testId>
		</div>
		<ycommerce:testId code="loginAndCheckoutButton">
			<button type="submit" class="btn btn-primary btn-block">
				<spring:theme code="${actionNameKey}" />
			</button>
		</ycommerce:testId>
	</fieldset>

</form:form>

