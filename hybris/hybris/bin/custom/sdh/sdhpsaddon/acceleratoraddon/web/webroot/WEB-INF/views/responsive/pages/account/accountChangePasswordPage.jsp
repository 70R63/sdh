<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-account/" var="myAccountUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<div class="row no-margin account-content-space">
	<div class="back-link border">
		<div class="row">
			<div class="col-md-6">
				<button type="button" class="addressBackBtn" data-back-to-addresses="${myAccountUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0"><spring:theme code="text.account.profile.updatePasswordForm" /></span>
				</h1>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="account-section-content">
				<div class="account-section-form">
					<form:form action="${action}" method="post" commandName="updatePasswordForm">
						<p class="continuous-text">
							<spring:theme code="form.required" htmlEscape="false" />
						</p>
						<formElement:formPasswordBox idKey="currentPassword" labelKey="profile.currentPassword" path="currentPassword" inputCSS="form-control" mandatory="true" />
						<formElement:formPasswordBox idKey="newPassword" labelKey="profile.newPassword" path="newPassword" inputCSS="form-control" mandatory="true" />
						<formElement:formPasswordBox idKey="checkNewPassword" labelKey="profile.checkNewPassword" path="checkNewPassword" inputCSS="form-control" mandatory="true" />
						<div class="row">
							<div class="col-sm-6">
								<div class="accountActions">
									<button type="button" class="btn btn-default btn-block" onclick="window.location='${myAccountUrl}'">
										<spring:theme code="text.button.cancel" text="Cancel" />
									</button>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="accountActions">
									<button type="submit" class="btn btn-primary btn-block">
										<spring:theme code="updatePwd.submit" text="Update Password" />
									</button>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>