<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/billaddon/responsive/user"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/nav/pagination"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-account/bills/all-bills/" var="showAllBillsUrl" />
<spring:url value="/my-account/all-bills/" var="fullBillUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<div class="row no-margin content-space my-bill all-bills">
	<div class="back-link border">
		<div class="row">
			<div class="col-md-6">
				<button type="button" class="addressBackBtn" data-back-to-addresses="${fullBillUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0"><spring:theme code="text.account.relationshipBills" text="Bills" arguments="${billCustomer.firstName} ${billCustomer.lastName}" /></span>
				</h1>
			</div>
		</div>
	</div>

	<div tabindex="0">
		<spring:theme code="text.these.are.relationship.bills" arguments="${billCustomer.firstName} ${billCustomer.lastName}"></spring:theme>
	</div>

	<c:if test="${empty bills}">
		<div class="account-section-content col-md-6 col-md-push-3 content-empty" tabindex="0">
			<c:choose>
				<c:when test="${filterCode eq 'Unpaid'}">
					<c:set var="relationshipNoBillsMessage" value="text.bill.relationship.no.unpaid.bills" />
				</c:when>
				<c:when test="${filterCode eq 'Paid'}">
					<c:set var="relationshipNoBillsMessage" value="text.bill.relationship.no.paid.bills" />
				</c:when>
				<c:when test="${filterCode eq 'All'}">
				    <c:set var="relationshipNoBillsMessage" value="text.bill.relationship.no.bills" />
				</c:when>    
			</c:choose>
			<spring:theme code="${relationshipNoBillsMessage}" arguments="${billCustomer.firstName} ${billCustomer.lastName}"></spring:theme>
		</div>
	</c:if>
	<c:if test="${not empty bills}">
		<c:set var="filterParam" value="" />
		<c:if test="${filterCode ne 'Unpaid'}">
			<c:set var="filterParam" value="&filterCode=${ycommerce:encodeHTML(filterCode)}" />
		</c:if>
		<nav:relationshipBillsPagination top="true" msgKey="bill.page" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" numberPagesShown="${numberPagesShown}" searchUrl="/my-account/all-relationship-bills?customerPK=${ycommerce:encodeHTML(billCustomer.customerPK)}${filterParam}" />

		<user:bills results="${bills}" />

		<nav:relationshipBillsPagination msgKey="bill.page" top="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" numberPagesShown="${numberPagesShown}" searchUrl="/my-account/all-relationship-bills?customerPK=${ycommerce:encodeHTML(billCustomer.customerPK)}${filterParam}" />
	</c:if>
</div>
