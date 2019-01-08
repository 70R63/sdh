<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/user"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-account/applications" var="ordersUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<div class="row no-margin global-content-space">
	<div class="back-link border account-order-draft">
		<div class="row">
			<div class="col-md-6">
				<button type="button" class="addressBackBtn" data-back-to-addresses="${ordersUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0"> <c:if test="${isRelationshipData ne true}">
							<spring:theme code="text.account.drafts" />
						</c:if> <c:if test="${isRelationshipData eq true}">
							<spring:theme code="text.account.drafts.relationship" arguments="${userData.firstName} ${userData.lastName}" />
						</c:if>
					</span>
				</h1>
			</div>
		</div>
	</div>

	<c:if test="${empty drafts}">
		<div class="account-section-content	col-md-6 col-md-push-3 content-empty">
			<spring:theme code="text.account.noDrafts" />
		</div>
	</c:if>

	<c:if test="${not empty drafts}">
		<user:drafts drafts="${drafts}" />
	</c:if>
</div>