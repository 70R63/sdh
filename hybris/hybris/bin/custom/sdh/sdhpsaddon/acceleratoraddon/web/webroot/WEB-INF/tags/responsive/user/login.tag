<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="actionNameKey" required="true" type="java.lang.String"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var="hideDescription" value="checkout.login.loginAndCheckout" />

<div class="headline" style="text-align: center !important">

		<span tabindex="0" class="new_title" style="font-size: 150% !important;align-items: center !important;text-align: center !important;"><spring:theme code="login.title" /></span>

</div>

<form:form action="${action}" method="post" modelAttribute="loginForm">
	<fieldset>
		<legend class="visuallyhidden">
			<spring:theme code="login.form" />
		</legend>

		<c:if test="${not empty message}">
			<span class="has-error"> <spring:theme code="${message}" />
			</span>
		</c:if>

<%-- 		<formElement:formInputBox idKey="j_username"labelKey="" path="j_username" mandatory="true" inputCSS="tamnewtwo form-control redtam tamnew"/> --%>
<%-- 		<formElement:formPasswordBox idKey="j_password"   labelKey="" inputCSS="tamnewtwo form-control redtam tamnew" mandatory="true"/> --%>
<input type="text"  id=j_username placeholder="Ingresar usuario*"  path="j_username"  value="" class="tamnewtwo form-control"/>
		<input type="text"  id="j_password" placeholder="Ingresar contraseña*"  path="j_password" value="" class="tamnewtwo form-control" style="margin-top: 5% !important"/>
		<input type="hidden" id="registeredCheckout" name="registeredCheckout" value="${registeredCheckout}" />

		<c:choose>
			<c:when test="${captchaEnabledForCurrentStore eq true }">
				<div class="form_field-elements control-group js-recaptcha-captchaaddon"></div>
			</c:when>
			<c:otherwise>
				<formElement:formCheckbox idKey="notARobot" labelKey="login.not.a.robot" path="notARobot"/>	
			</c:otherwise>
		</c:choose>

		<div class="forgotten-password" style="margin-bottom: 1px !important; text-align: center !important;">
			<ycommerce:testId code="login_forgotPassword_link">
				<a href="<c:url value='/login/pw/request/external'/>" class="pssword" data-cbox-title="<spring:theme code="forgottenPwd.title"/>"> <spring:theme code="login.link.forgottenPwd" />
				</a>
			</ycommerce:testId>
		</div>
		
		<div class="forgotten-password" style="margin-bottom: 1px !important; text-align: center !important;">
			<ycommerce:testId code="login_forgotPassword_link">
				<c:url value='/register' var="registerURL" />
				<spring:theme code="login.link.getPassword" htmlEscape="false" arguments="${registerURL }" />
			</ycommerce:testId>
		</div>
		<ycommerce:testId code="loginAndCheckoutButton">
			<button type="submit" class="btn btn-primary redtam tam_button" style="width: 100% !important; border-radius: 20px !important; background-color: #156ab5 !important; color: white !important;height: 48px !important; margin-top:10%;">
				<spring:theme code="${actionNameKey}" />
			</button>
		</ycommerce:testId>
	</fieldset>

</form:form>


