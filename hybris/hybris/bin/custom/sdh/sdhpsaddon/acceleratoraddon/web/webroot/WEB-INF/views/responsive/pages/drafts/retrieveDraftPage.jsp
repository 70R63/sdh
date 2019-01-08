<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
 <spring:htmlEscape defaultHtmlEscape="true" />
 
<div class="row no-margin global-content-space">
<h1>
	<span tabindex="0"><spring:theme code="draft.retrieve.heading" text="Retrieve Your Draft" /></span>
</h1>
<spring:url value="/my-account/applications" var="myApplicationsUrl" />
<spring:theme code="draft.retrieve.message" text="Retrieve drafts easily using Draft number & Email address" arguments="${myApplicationsUrl}" htmlEscape="false" var="draftRetrieveMessage" />
${ycommerce:sanitizeHTML(draftRetrieveMessage)}
<p class="continuous-text">
	<spring:theme code="form.required" text="Fields marked * are required" htmlEscape="false" />
</p>
<ycommerce:testId code="retrieveDraftForm">
	<form:form id="retrieveDraftForm" name="retrieveDraftForm" commandName="retrieveDraftForm" method="POST">
		<formElement:formInputBox idKey="draftNo" labelKey="draft.number.text" path="draftNumber" inputCSS="form-control" mandatory="true"  />

		<formElement:formInputBox idKey="email" labelKey="guest.email" path="email" inputCSS="form-control" mandatory="true"  />
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<ycommerce:testId code="retrievePage_retrieveButton">
					<button class="btn btn-primary btn-block" type="submit">
						<spring:theme code="text.button.draft.retrive" text="Retrieve Draft" />
					</button>
				</ycommerce:testId>
			</div>
			<div class="col-md-3"></div>
		</div>
	</form:form>
</ycommerce:testId>
</div>