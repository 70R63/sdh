<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="account" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/account"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/my-documents" var="myDocumentsUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<div class="row no-margin global-content-space expired-documents">
	<div class="my-documents account-section-subheader">
		<div class="back-link border">
			<div class="row">
				<div class="col-md-6">
					<button type="button" class="addressBackBtn" data-back-to-addresses="${myDocumentsUrl}">
						<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
					</button>
					<h1 class="custom-h1">
						<span class="label" tabindex="0"><c:choose>
								<c:when test="${not empty relationshipCustomer}">
									<spring:theme code="text.document.overview.relationship.myDocuments" arguments="${relationshipCustomer.firstName} " />
								</c:when>
								<c:otherwise>
									<spring:theme code="text.account.documents" text="Documents" />
								</c:otherwise>
							</c:choose></span>
					</h1>
				</div>
			</div>
		</div>

		<c:if test="${not empty documents}">
			<div class="account-section-subheader-add">
				<h2>
					<span tabindex="0"> <c:choose>
							<c:when test="${not empty relationshipCustomer}">
								<spring:theme code="text.document.relationship.expired.documents" arguments="${relationshipCustomer.firstName} " />
							</c:when>
							<c:otherwise>
								<spring:theme code="text.account.expiredDocuments" text="Expired Documents" />
							</c:otherwise>
						</c:choose>
					</span>
				</h2>
			</div>
			<account:documents documents="${documents}" />
		</c:if>

		<c:if test="${empty documents}">
			<div tabindex="0" class="account-section-content col-md-6 col-md-push-3 content-empty">
				<spring:theme code="text.account.myDocuments.NoDocuments" />
			</div>
		</c:if>
	</div>
</div>