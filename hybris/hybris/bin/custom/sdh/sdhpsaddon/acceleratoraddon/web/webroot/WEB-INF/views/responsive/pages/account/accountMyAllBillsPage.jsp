<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/billaddon/responsive/user"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/billaddon/responsive/nav/pagination"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-account/bills/all-bills/" var="showAllBillsUrl"></spring:url>
<spring:url value="/my-account" var="backUrl" />
<spring:theme code="text.back.icon.accessibility" var="myBillsBack" />

<div class="global-content-space my-bill all-bills">
	<div class="row no-margin">
		<div class="back-link border">
			<div class="row">
				<div class="col-md-6">
					<button type="button" class="addressBackBtn" data-back-to-addresses="${backUrl}">
						<span class="glyphicon glyphicon-chevron-left" aria-label="${myBillsBack}"></span>
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
		<br />
		<c:if test="${not empty allRelationships}">
			<div class="">
				<span tabindex="0"><spring:theme code="text.bill.overview.relationship.bill.below" /></span>
			</div>
		</c:if>

		<c:set var="filterParam" value="" />
		<c:if test="${filterCode ne 'Unpaid'}">
			<c:set var="filterParam" value="?filterCode=${ycommerce:encodeHTML(filterCode)}" />
		</c:if>

		<nav:billsPagination top="true" msgKey="bill.page" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" numberPagesShown="${numberPagesShown}" searchUrl="/my-account/all-bills${filterParam}" />
		<c:if test="${empty bills}">
			<div class="account-section-content col-md-6 col-md-push-3 content-empty" tabindex="0">
				<c:if test="${filterCode eq 'Unpaid'}">
					<spring:theme code="text.bill.no.Unpaid.bills" />
				</c:if>
				<c:if test="${filterCode eq 'All'}">
					<spring:theme code="text.bill.no.bills" />
				</c:if>
				<c:if test="${filterCode eq 'Paid'}">
					<spring:theme code="text.bill.no.Paid.bills" />
				</c:if>
			</div>
		</c:if>
		<c:if test="${not empty bills}">
			<user:bills results="${bills}" />
		</c:if>
		<nav:billsPagination top="false" msgKey="bill.page" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" numberPagesShown="${numberPagesShown}" searchUrl="/my-account/all-bills${filterParam}" />

	</div>

	<div class="my-bill">
		<div id="accordion" class="custom-accordion">
			<c:forEach var="currRelationship" items="${allRelationships}" varStatus="loop">
					<div class="panel-heading">
					    <spring:theme code="text.bill.notexpanded.accessibility" var="notExpanded" arguments="${currRelationship.firstName} ${currRelationship.lastName}" />
						<h2 class="panel-title">
							<a tabindex="0" class="accordion-toggle ui-icon-plus relationbillsLink" href="#relationbillsSection_${loop.count}" aria-expanded="false" aria-label="${notExpanded}" aria-controls="relationbillsSection_${loop.count}"> 
								<span class="accordian-heading">
								   <spring:theme code="text.bill.overview.relationship.header" arguments="${currRelationship.firstName} ${currRelationship.lastName}" />
								</span> 
							<input type="hidden" id="loopCount" value="${loop.count}" />
							<input type="hidden" id="hidden_${loop.count}" value="${ycommerce:encodeHTML(currRelationship.uid)}" />
							</a>
						</h2>
					</div>
					<div id="relationbillsSection_${loop.count}">
						<!-- Content Here -->
					</div>
			</c:forEach>
			<br>
		</div>
	</div>
</div>