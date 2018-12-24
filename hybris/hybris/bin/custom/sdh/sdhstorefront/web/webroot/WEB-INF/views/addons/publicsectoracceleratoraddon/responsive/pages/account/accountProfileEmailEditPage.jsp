<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/formElement" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-account/" var="myAccountUrl"/>
<spring:theme code="text.back.icon.accessibility" var="back" />

<div class="row no-margin account-content-space">
	   <div class="back-link border">
		<div class="row">
			<div class="col-md-6">
				<button type="button" class="addressBackBtn" data-back-to-addresses="${myAccountUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0"><spring:theme code="text.account.update.email.address"/></span>
				</h1>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="account-section-content">
				<div class="account-section-form">
					<form:form action="update-email" method="post" commandName="updateEmailForm">
					 <p class="continuous-text"><spring:theme code="form.required" htmlEscape="false"/></p>
						<formElement:formInputBox idKey="profile.email" labelKey="profile.email" path="email" inputCSS="text" mandatory="true"/>
						<formElement:formInputBox idKey="profile.checkEmail"  labelKey="profile.checkEmail" path="chkEmail" inputCSS="text" mandatory="true"/>
						<formElement:formPasswordBox idKey="profile.pwd" labelKey="profile.pwd" path="password" inputCSS="text form-control" mandatory="true"/>
						<input type="hidden" id="recaptchaChallangeAnswered" value="${requestScope.recaptchaChallangeAnswered}"/>
						<div class="form_field-elements control-group js-recaptcha-captchaaddon"></div>
						<div class="form-actions">
							<div class="row">
								<div class="col-sm-6">
									<div class="accountActions">
										<ycommerce:testId code="email_cancelEmail_button">
											<button type="button" class="btn btn-default btn-block" onclick="window.location='${myAccountUrl}'">
												<spring:theme code="text.account.profile.cancel" text="Cancel"/>
											</button>
										</ycommerce:testId>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="accountActions">
										<ycommerce:testId code="email_saveEmail_button">
											<button type="submit" class="btn btn-primary btn-block">
												<spring:theme code="text.account.profile.saveUpdates" text="Save Updates"/>
											</button>
										</ycommerce:testId>
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>