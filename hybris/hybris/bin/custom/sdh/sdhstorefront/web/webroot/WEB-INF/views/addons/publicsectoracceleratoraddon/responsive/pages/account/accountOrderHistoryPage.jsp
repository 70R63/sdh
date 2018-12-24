<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/user"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/application/" var="orderDetailsUrl" />
<spring:url value="/my-account/drafts/" var="allUserDraftsUrl" />
<spring:url value="/my-account/allApplications/" var="allUserOrdersUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />
<spring:url value="/my-account" var="myAccountUrl" />

<div class="row no-margin account-order-history global-content-space">
	 <div class="back-link border">
		<div class="row">
			<div class="col-md-6">
				<button type="button" class="addressBackBtn" data-back-to-addresses="${myAccountUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0"><spring:theme code="text.account.application.requests" /></span>
				</h1>
			</div>
		</div>
	</div>
	 <div class="row no-margin">
		<h2>
			<span tabindex="0"><spring:theme code="text.account.history" /></span>
		</h2>
	 </div>

	<c:if test="${empty searchPageData.results}">
		<div class="account-section-content	row content-empty">
			<div tabindex="0" class="col-md-6 col-md-push-3">
				<ycommerce:testId code="orderHistory_noOrders_label">
					<spring:theme code="text.account.orderHistory.noOrders" />
				</ycommerce:testId>
			</div>
		</div>
	</c:if>

	<c:if test="${not empty searchPageData.results}">
		<user:orders results="${searchPageData.results}" />
		<c:if test="${showAllOrdersButton}">
			<div class="account-section-subheader hidden-xs">
				<div class="account-section-subheader-add pull-left"></div>
				<div class="account-section-subheader-add pull-right">
					<button type="button" class="btn btn-primary" onclick="window.location='${allUserOrdersUrl}'">
						<spring:theme code="text.account.orders.all" text="See All History" />
					</button>
				</div>
				<br>
			</div>
			<div class="account-section-subheader-add visible-xs">
				<button type="button" class="btn btn-primary" onclick="window.location='${allUserOrdersUrl}'">
					<spring:theme code="text.account.orders.all" text="See All History" />
				</button>
			</div>
			<br>
		</c:if>
	</c:if>

	<!-- Draft section -->
	<div class="account-section-content row no-margin">
		 <div class="row no-margin">
			<h2>
				<span tabindex="0"><spring:theme code="text.account.drafts" /></span>
			</h2>
		</div>
		<c:choose>
			<c:when test="${empty drafts}">
				<div class="account-section-content	row content-empty">
					<div tabindex="0" class="col-md-6 col-md-push-3">
						<ycommerce:testId code="orderHistory_noOrders_label">
							<spring:theme code="text.account.noDrafts" />
						</ycommerce:testId>
					</div>
				</div>
			</c:when>
				
			<c:otherwise>
				<user:drafts drafts="${drafts}" />
				<c:if test="${showAllDraftsButton}">
					<div class="account-section-subheader hidden-xs">
						<div class="account-section-subheader-add pull-left"></div>
						<div class="account-section-subheader-add pull-right">
							<button type="button" class="btn btn-primary" onclick="window.location='${allUserDraftsUrl}'">
								<spring:theme code="text.account.drafts.all" text="See All Drafts" />
							</button>
						</div>
						<br>
					</div>
					<div class="account-section-subheader-add visible-xs">
						<button type="button" class="btn btn-primary" onclick="window.location='${allUserDraftsUrl}'">
							<spring:theme code="text.account.drafts.all" text="See All Drafts" />
						</button>
					</div>
				</c:if>
			</c:otherwise>	
		</c:choose>
	</div>
</div>

<div class="application-request">
	<div id="accordion" class="custom-accordion">
		<c:forEach var="currRelationshipUser" items="${allRelationshipsUsers}" varStatus="loop">
				<div class="panel-heading">
				   <spring:theme code="text.applications.notexpanded.accessibility" var="notExpanded" arguments="${currRelationshipUser.firstName} ${currRelationshipUser.lastName}" />
					<h2 class="panel-title">
						<a tabindex="0" class="accordion-toggle ui-icon-plus relationApplicationsLink"  href="#relationApplicationsSection_${loop.count}" aria-expanded="false" aria-label="${notExpanded}" aria-controls="relationApplicationsSection_${loop.count}"> 
						    <span class="accordian-heading">
						       <spring:theme code="text.applications.overview.relationship.header" arguments="${currRelationshipUser.firstName} ${currRelationshipUser.lastName}" />
						    </span> 
						       <input type="hidden" id="loopCount" value="${loop.count}" />
						       <input type="hidden" id="hidden_${loop.count}" value="${ycommerce:encodeHTML(currRelationshipUser.customerPK)}" />
						</a>
					</h2>
				</div>
				<div id="relationApplicationsSection_${loop.count}">
				</div>
		</c:forEach>
	</div>
</div>