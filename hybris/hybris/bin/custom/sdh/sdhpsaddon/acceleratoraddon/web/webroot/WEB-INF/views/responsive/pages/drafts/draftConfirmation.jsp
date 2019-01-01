<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />
 
<spring:url value="/my-account/applications" var="ordersURL" />
<spring:url value="/drafts/retrieve-draft" var="retrieveDraftURL" />

<div class="checkout-success-headline">
	<h3>
		<span tabindex="0"><spring:theme code="checkout.service.confirmation.draft" arguments="${product.name}" /></span>
	</h3>
</div>

<span class="reference-no">
	<h4>
		<span tabindex="0"><spring:theme code="checkout.multi.saveandclose.draft.confirmation" arguments="${draftCode}" /></span>
	</h4>
</span>

<p>
	<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
		<spring:theme code="checkout.confirmation.saveandclose.draft.guest.confirm" arguments="${product.name}"  htmlEscape="false" var="draftGuestConfirmation"/>
		${ycommerce:sanitizeHTML(draftGuestConfirmation)}
		<p>
			<spring:theme code="checkout.confirmation.saveandclose.draft.guest.retrieve" arguments="${draftCode},${retrieveDraftURL}" htmlEscape="false" var="draftGuestRetrieve"/>
			${ycommerce:sanitizeHTML(draftGuestRetrieve)}
		</p>
	</sec:authorize>

	<sec:authorize access="!hasAnyRole('ROLE_ANONYMOUS')">
		<spring:url var="continueDraftUrl" value="/checkout/multi/draft" htmlEscape="false">
			<spring:param name="CSRFToken" value="${CSRFToken.token}" />
		</spring:url>
		<form class="retrieveDraftForm" action="${continueDraftUrl}" method="POST">
			<input name="draftCode" type="hidden" value="${ycommerce:encodeHTML(draftCode)}" /> <span id="draftConfirmationRegistered"> <c:if test="${isCurrentCustomerSameAsUserInContext}">
					<spring:theme code="checkout.confirmation.saveandclose.draft.registered.confirm" arguments="${product.name},${ordersURL}" htmlEscape="false" var="draftRegisteredConfirmation"/>
					${ycommerce:sanitizeHTML(draftRegisteredConfirmation)}
				</c:if> <c:if test="${!isCurrentCustomerSameAsUserInContext}">
					<spring:theme code="checkout.confirmation.saveandclose.draft.relationship.user" arguments="${product.name}, ${userInContext.firstName}, ${userInContext.lastName}" htmlEscape="false" var="draftRelationshipUser"/>
					${ycommerce:sanitizeHTML(draftRelationshipUser)}
					<br>
					<br>
					<spring:theme code="checkout.confirmation.retrive.draft.relationship.user" arguments=" ${userInContext.firstName}, ${userInContext.lastName}" htmlEscape="false" var="retrieveDraftRelationshipUser"/>
					${ycommerce:sanitizeHTML(retrieveDraftRelationshipUser)}
				</c:if>
			</span>
		</form>
	</sec:authorize>
</p>
