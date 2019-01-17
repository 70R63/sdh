<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/sdhbillsaddon/responsive/user"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/sdhbillsaddon/responsive/nav/pagination"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-account/bills/all-bills/" var="showAllBillsUrl"></spring:url>
<spring:url value="/my-account/my-bills/" var="fullBillUrl" />
  <spring:theme code="text.back.icon.accessibility" var="back" />

<div class="global-content-space my-bill all-bills">
	<div class="row no-margin">
		<div class="back-link border">
			<div class="row">
				<div class="col-md-6">
					<button type="button" class="addressBackBtn" data-back-to-addresses="${fullBillUrl}">
						<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
					</button>
					<h1 class="custom-h1">
						<span class="label" tabindex="0"><spring:theme code="text.account.myBills" text="Bills" /></span>
					</h1>
				</div>
			</div>
		</div>
		<div tabindex="0">
			<spring:theme code="text.these.are.your.bills"></spring:theme>
		</div>

		<c:if test="${empty bills}">
			<div class="account-section-content col-md-6 col-md-push-3 content-empty" tabindex="0">
				<spring:theme code="text.bill.no.bills" />
			</div>
		</c:if>
		<c:if test="${not empty bills}">
			<c:set var="filterParam" value="" />
			<c:if test="${filterCode ne 'Unpaid'}">
				<c:set var="filterParam" value="?filterCode=${ycommerce:encodeHTML(filterCode)}" />
			</c:if>
			<nav:billsPagination top="true" msgKey="bill.page" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" numberPagesShown="${numberPagesShown}" searchUrl="/my-account/bills/all-bills${filterParam}" />

			<user:bills results="${bills}" />

			<nav:billsPagination top="false" msgKey="bill.page" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" numberPagesShown="${numberPagesShown}" searchUrl="/my-account/bills/all-bills${filterParam}" />
		</c:if>
	</div>
</div>