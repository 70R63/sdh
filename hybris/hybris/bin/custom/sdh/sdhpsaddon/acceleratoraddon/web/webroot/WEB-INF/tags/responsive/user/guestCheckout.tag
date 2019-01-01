<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="actionNameKey" required="true" type="java.lang.String"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="headline">
	<h2><span tabindex="0"><spring:theme code="guest.checkout.login" /></span></h2>
</div>

<span class="guest-checkout-heading visible-md visible-lg"><spring:theme code="guest.checkout.continue"/></span>
<c:if test="${!showRegisterBody || showLoginBody}">
		<span class="visible-xs visible-sm"><spring:theme code="guest.checkout.continue.mobile" />&nbsp;<a href="<c:url value="/login?showRegisterBody=true"/>"><spring:theme code="guest.checkout.create.account" /></a></span>
</c:if>

<p class="continuous-text">
	<spring:theme code="form.required" htmlEscape="false" />
</p>

<form:form action="${action}" method="post" commandName="guestForm">
	<div class="form-group">
		<formElement:formInputBox idKey="guest.email" labelKey="guest.email" inputCSS="guestEmail" path="email" mandatory="true" />
	</div>

	<div class="form-group">
		<label class="control-label required" for="guest.confirm.email"> <spring:theme code="guest.confirm.email" /></label> <input class="confirmGuestEmail form-control" id="guest.confirm.email" mandatory="true" />
	</div>

	<ycommerce:testId code="guest_Checkout_button">
		<div class="form-group">
			<button type="submit" disabled="true" class="btn btn-default btn-block guestCheckoutBtn">
				<spring:theme code="${actionNameKey}" />
			</button>
		</div>
	</ycommerce:testId>

</form:form>

