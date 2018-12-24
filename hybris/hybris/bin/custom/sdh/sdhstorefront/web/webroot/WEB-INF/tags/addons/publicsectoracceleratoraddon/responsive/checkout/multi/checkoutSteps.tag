<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ attribute name="checkoutSteps" required="true" type="java.util.List"%>
<%@ attribute name="progressBarId" required="true" type="java.lang.String"%>
<%@ attribute name="bundleCheckoutLabel" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ attribute name="cssClass" required="false" type="java.lang.String" %>
<spring:htmlEscape defaultHtmlEscape="true" />

<ycommerce:testId code="checkoutSteps">
	<div class="checkout-steps ${cssClass}">
		<c:forEach items="${checkoutSteps}" var="checkoutStep" varStatus="status">
			<c:url value="${checkoutStep.url}" var="stepUrl" />
			<c:choose>
				<c:when test="${checkoutStep.isDynamic}">
					<c:set var="checkoutStepTitle" value="${checkoutStep.progressBarId}" />
				</c:when>
				<c:otherwise>
					<c:set var="checkoutStepTitle">
						<spring:theme code="checkout.multi.${checkoutStep.progressBarId}" arguments="${bundleCheckoutLabel}" />
					</c:set>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${progressBarId eq checkoutStep.progressBarId}">
					<c:set scope="page" var="activeCheckoutStepNumber" value="${checkoutStep.stepNumber}" />
					<h2><a href="${stepUrl}" class="step-head js-checkout-step active"> <%-- <div class="title"><spring:theme code="checkout.multi.${checkoutStep.progressBarId}"/></div> --%>
						<div class="title">${checkoutStepTitle}</div>
					</a></h2>
					<div class="step-body"><jsp:doBody /></div>
				</c:when>
				<c:when test="${checkoutStep.stepNumber > activeCheckoutStepNumber}">
					<h2><a href="${stepUrl}" class="step-head js-checkout-step not_visited"> <%-- <div class="title"><spring:theme code="checkout.multi.${checkoutStep.progressBarId}"/></div> --%>
						<div class="title">${checkoutStepTitle}</div>
					</a></h2>
				</c:when>
				<c:otherwise>
					<h2><a href="${stepUrl}" class="step-head js-checkout-step "> <%-- <div class="title"><spring:theme code="checkout.multi.${checkoutStep.progressBarId}"/></div> --%>
						<div class="title">${checkoutStepTitle}</div>
						<div class="edit"></div>
					</a></h2>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
</ycommerce:testId>