<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account" var="dashboardUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<div class="row no-margin global-content-space">
	<div class="back-link border">
		<div class="row">
			<div class="col-md-6">
				<button type="button" class="addressBackBtn" data-back-to-addresses="${dashboardUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0"><spring:theme code="text.account.consent.consentManagement" /></span>
				</h1>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="account-section-content">
				<div class="account-section-form consent-section-form">
					<div id="consent-management-form" data-consent-management-url="${consentManagementUrl}">
						<c:if test="${not empty consentTemplateDataList}">

							<div class="consent-management-list" aria-live="polite" data-behavior="accordion">
								<c:forEach items="${consentTemplateDataList}" var="consentTemplateData" varStatus="loop">
									<div class="consent-management-list__item">
									<c:set var="consentTemplateId" value="${fn:escapeXml(consentTemplateData.id)}" /> 
									<span  class="consent-management-list__title"> 
									<label tabindex="0" 
											class="col-xs-8 col-sm-6"> ${fn:escapeXml(consentTemplateData.name)} </label>
									</span>
										<div class="toggle-button">
											<c:choose>
												<c:when test="${not empty consentTemplateData.consentData && empty consentTemplateData.consentData.consentWithdrawnDate}">
													<input id="${consentTemplateId}" type="checkbox" class="toggle-button__input" checked>
													<label for="${consentTemplateId}">
														<div role="checkbox" tabindex="0" class="toggle-button__switch is-checked" aria-checked="true"></div>
													</label>
												</c:when>
												<c:otherwise>
													<input id="${consentTemplateId}" type="checkbox" class="toggle-button__input">
													<label for="${consentTemplateId}">
														<div role="checkbox" tabindex="0" class="toggle-button__switch" aria-checked="false"></div>
													</label>
												</c:otherwise>
											</c:choose>

										</div> <spring:url value="/my-account/consents/give/{/consentTemplateId}/{/version}" var="giveConsentUrl" htmlEscape="false">
											<spring:param name="consentTemplateId" value="${consentTemplateData.id}" />
											<spring:param name="version" value="${consentTemplateData.version}" />
										</spring:url> <form:form action="${giveConsentUrl}" method="POST">
											<button hidden type="submit" id="give-consent-button-${consentTemplateId}"></button>
										</form:form> <spring:url value="/my-account/consents/withdraw/{/consentCode}" var="withdrawConsentUrl" htmlEscape="false">
											<spring:param name="consentCode" value="${consentTemplateData.consentData.code}" />
										</spring:url> <form:form action="${withdrawConsentUrl}" method="POST">
											<button hidden type="submit" id="withdraw-consent-button-${consentTemplateId}"></button>
										</form:form></div>
								</c:forEach>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>