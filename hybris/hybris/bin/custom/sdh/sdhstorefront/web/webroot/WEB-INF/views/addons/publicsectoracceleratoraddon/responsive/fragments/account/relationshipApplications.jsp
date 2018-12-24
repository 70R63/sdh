<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/user"%>
<spring:htmlEscape defaultHtmlEscape="true" />
 
<spring:url value="/my-account/relationship/drafts" var="allUserDraftsUrl" />
<spring:url value="/my-account/relationship/applications" var="allUserOrdersUrl" />

<div class="row no-margin content-space">
<div class="account-section-content">
<div class="account-section-subheader"></div>

	<div class="account-section-header">
		<h4><span tabindex="0"><spring:theme code="text.account.history" /></span></h4>
	</div>

	<c:if test="${empty searchPageData.results}">
		<div class="account-section-content	row content-empty">
		<div tabindex="0" class="col-md-6 col-md-push-3">
			<ycommerce:testId code="orderHistory_noOrders_label">
				<spring:theme code="text.relationship.account.orderHistory.noOrders" arguments="${userData.firstName} ${userData.lastName}"/>
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
				<form class="retrieveRelationshipApplicationsForm" action="${allUserOrdersUrl}" method="GET">
						<input name="customerId" value=" ${ycommerce:encodeHTML(userData.customerPK)}" type="hidden" />
						<button type="button" class="btn btn-primary retrieveRelationshipApplicationsLink" onclick="window.location='#'">
						<spring:theme code="text.account.orders.all" text="See All History" /></button>
				</form>
				</div><br>
			</div>
			<div class="account-section-subheader-add visible-xs">
				<form class="retrieveRelationshipApplicationsForm" action="${allUserOrdersUrl}" method="GET">
					<input name="customerId" value="${ycommerce:encodeHTML(userData.customerPK)}" type="hidden" />
					<button type="button" class="btn btn-primary retrieveRelationshipApplicationsLink" onclick="window.location='#'"><spring:theme code="text.account.orders.all" text="See All History" /></button>
				</form>
			</div><br>
		</c:if>
	</c:if>
	
	
	<div class="account-section-content row no-margin">
	<div class="account-section-header">
		<h4><span tabindex="0"><spring:theme code="text.account.drafts" /></span></h2>
	</div>

	<c:if test="${empty drafts}">
		<div class="account-section-content	row content-empty">
		 <div tabindex="0" class="col-md-6 col-md-push-3">
			<ycommerce:testId code="orderHistory_noOrders_label">
				<spring:theme code="text.relationship.account.noDrafts" arguments="${userData.firstName} ${userData.lastName}"/>
			</ycommerce:testId>
		 </div>
		</div>
	</c:if>

	<c:if test="${not empty drafts}">
		<user:drafts drafts="${drafts}" />

		<c:if test="${showAllDraftsButton}">
			<div class="account-section-subheader hidden-xs">
				<div class="account-section-subheader-add pull-left"></div>
				<div class="account-section-subheader-add pull-right">
					<form class="retrieveRelationshipDraftsForm" action="${allUserDraftsUrl}" method="GET">
						<input name="customerId" value="${ycommerce:encodeHTML(userData.customerPK)}" type="hidden" />
						<button type="button" class="btn btn-primary retrieveRelationshipDraftsLink" onclick="window.location='#'"><spring:theme code="text.account.drafts.all" text="See All Drafts" /></button>
					</form>
				</div><br><br>
			</div>
		
		<div class="account-section-subheader-add visible-xs">
			<form class="retrieveRelationshipDraftsForm" action="${allUserDraftsUrl}" method="GET">
				<input name="customerId" value="${ycommerce:encodeHTML(userData.customerPK)}" type="hidden" />
				<button type="button" class="btn btn-primary retrieveRelationshipDraftsLink" onclick="window.location='#'"><spring:theme code="text.account.drafts.all" text="See All Drafts" /></button>
			</form>
		</div><br><br>
</c:if>
	</c:if>
</div>



</div>
</div>
