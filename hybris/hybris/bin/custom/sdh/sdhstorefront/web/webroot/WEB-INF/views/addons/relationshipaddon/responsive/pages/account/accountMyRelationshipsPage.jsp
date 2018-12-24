<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/relationshipaddon/responsive/user"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:url value="/my-account/pending-requests" var="pendingRelationshipsUrl" />
<spring:url value="/my-account/relationship/add/" var="setUpPermissionsUrl" />
<spring:url value="/my-account/relationship/poa/add/" var="setUpPermissionsUrlForRelationshipUser" />
<spring:url value="/my-account" var="backButtonUrl" />
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:theme code="text.back.icon.accessibility" var="back" />


<div class="row no-margin account-content-space">
	<div class="back-link border">
		<div class="row">
			<div class="col-md-6">
				<button type="button" class="addressBackBtn" data-back-to-addresses="${backButtonUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0"><spring:theme code="text.account.myRelationships" text="Permissions and Relationships" /></span>
				</h1>
			</div>
		</div>
	</div>

	<div class="account-section-subheader-relationship row">
		<div class="col-xs-12 col-sm-4 col-md-3 no-space">
			<button class="btn btn-primary btn-block" onclick="window.location.href='${setUpPermissionsUrl}'">
				<spring:theme code="text.relationship.setup.permissions"></spring:theme>
			</button>
		</div>
		<div class="col-xs-12 col-sm-8 col-md-9">
			<div class="pending-request-header">
				<a href="${pendingRelationshipsUrl}"><spring:theme code="text.relationship.pending.requests" arguments="${allUserPendingRequestCount[customer.uid]}" /></a>
			</div>
		</div>
	</div>

	<div class="account-section-subheader-relationship row">
		<div class="col-xs-7 col-sm-8 col-md-8">
			<h2>
				<span tabindex="0"><spring:theme code="text.youRelationships"></spring:theme></span>
			</h2>
		</div>
	</div>
	<c:if test="${not empty currUserRelationships['non-poa'] || not empty currUserRelationships['poa-holder'] || not empty currUserRelationships['poa-receiver']}">
		<div class="account-section-content">
			<user:relationships results="${currUserRelationships}" customer="${customer}" sessionUser="${customer}" />
		</div>
		<div id="accordion" class="custom-accordion" aria-multiselectable="true">
			<c:forEach var="relationship" items="${userPOARelationships}" varStatus="loop">
					<div class="panel-heading">
						<spring:theme code="text.relationship.expanded.accessibility" var="expandToSeeMore" arguments="${relationship.key.name}" />
						<h2 class="panel-title">
							<a tabindex="0" class="accordion-toggle ui-icon-plus" href="#collapseOne_${loop.count}" aria-expanded="false" aria-label="${expandToSeeMore} " aria-controls="collapseOne_${loop.count}"> 
							  <span class="accordian-heading">
							    <spring:theme code="text.poa.relationship" arguments="${relationship.key.name}" />
							  </span>
							</a>
						</h2>
					</div>
					<div id="collapseOne_${loop.count}" class="panel-collapse collapse">
						<div class="panel-body">
							<!-- starting content -->
							<div class="account-section-subheader-relationship row">
								<div class="col-xs-12 col-sm-4 no-space">
										<button class="btn btn-grey btn-block" type="button" onclick="window.location='${setUpPermissionsUrlForRelationshipUser}?relationCustomerPK=${ycommerce:encodeHTML(relationship.key.customerPK)}'">
											<spring:theme code="text.relationship.setup.permissions" />
										</button>
								</div>
								<div class="col-xs-12 col-sm-8">
									<div class="pending-request-header">
										<a href="${pendingRelationshipsUrl}/${ycommerce:encodeHTML(relationship.key.customerPK)}"> <spring:theme code="text.relationship.pending.requests" arguments="${allUserPendingRequestCount[relationship.key.uid]}" />
										</a>
									</div>
								</div>
							</div>
							<div class="account-section-content">
								<user:relationshipsWithPoa results="${relationship.value}" customer="${relationship.key}" sessionUser="${customer}" />
							</div>
						</div>
					</div>
			</c:forEach>
			<br>
		</div>
	</c:if>
	<c:if test="${empty currUserRelationships['non-poa'] && empty currUserRelationships['poa-holder'] && empty currUserRelationships['poa-receiver']}">
		<div class="empty-permissions-relationships account-section-content row content-empty">
			<div class="col-md-6">
				<spring:theme code="text.relationship.no.relationships" text="You currently don't have any relationships and permissions set up." htmlEscape="false" var= "noRelationships"/>
			   ${ycommerce:sanitizeHTML(noRelationships)}
			</div>
		</div>
	</c:if>
</div>
