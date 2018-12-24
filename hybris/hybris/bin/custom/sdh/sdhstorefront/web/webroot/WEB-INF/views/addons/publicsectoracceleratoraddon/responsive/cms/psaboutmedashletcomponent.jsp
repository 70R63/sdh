<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/update-profile" var="updateProfile" />
<spring:url value="/my-account/update-email" var="updateEmail" />
<spring:url value="/my-account/update-password" var="updatePassword" />
<spring:url value="/my-account/payment-details" var="paymentDetails" />
<spring:url value="/my-account/consents" var="consentManagement" />
<spring:url value="/my-account/my-assets" var="assetOverviewUrl" />
<spring:url value="/my-account/close-account" var="closeAccount"/>


<div class="grid-item dashlet-aboutMe">
	<h2 class="header">
		<span tabindex="0">${ycommerce:encodeHTML(component.title)}</span>
	</h2>
	<div class="content">
		<div class="row box">
			<div class="col-xs-9 col-md-9 vertical-center">
				<span tabindex="0"><strong>${ycommerce:encodeHTML(customerData.title)}&nbsp;${ycommerce:encodeHTML(customerData.firstName)}&nbsp;${ycommerce:encodeHTML(customerData.lastName)}</strong></span>
			</div>
			<div class="col-xs-3 col-md-3 text-right about-me-redirect-btn">
				<spring:theme code="text.account.dashlet.aboutMe.accessibility.updateYourPersonalDetails" var="updateYourPersonalDetails" />
				<button type="button" class="profile-edit" onclick="window.location='${updateProfile}'">
					 <span class="glyphicon glyphicon-edit gi-2x edit-aboutMe-icon" aria-label="${updateYourPersonalDetails}"></span>
			    </button>
			</div>
		</div>
		<div class="row box">
			<div class="col-xs-9 col-md-9 email-id">
				<span tabindex="0"><strong>${ycommerce:encodeHTML(customerData.uid)}</strong></span>
			</div>
			<div class="col-xs-3 col-md-3 text-right about-me-redirect-btn">
				<spring:theme code="text.account.dashlet.aboutMe.accessibility.updateYourEmailAddress" var="updateYourEmailAddress" />
				<button type="button" class="email-edit" onclick="window.location='${updateEmail}'">
					 <span class="glyphicon glyphicon-edit gi-2x edit-aboutMe-icon" aria-label="${updateYourEmailAddress}"></span>
			    </button>
			</div>
		</div>
		<div class="row box">
		<spring:theme code="text.account.dashlet.aboutMe.accessibility.changeYourPassword" var="changeYourPassword" />
			<div class="col-xs-12 change-password">
				<a href="${updatePassword}" aria-label="${changeYourPassword}"><spring:theme code="text.account.dashlet.aboutMe.change.password" /></a>
			</div>
		</div>
		
		<c:if test="${assetsExist}">
			<div class="row box">
				<spring:theme code="text.account.dashlet.aboutMe.view.asset" var="viewYourAsset" />
				<div class="col-xs-12 change-password">
					<a href="${assetOverviewUrl}" aria-label="${viewYourAsset}"><spring:theme code="text.account.dashlet.aboutMe.view.asset" /></a>
				</div>
			</div>
		</c:if>
		
		<div class="row box">
			<spring:theme code="text.account.dashlet.aboutme.accessibility.closeAccount" var="yourAccountClose"/>
			<div class="col-xs-12 close-account">
				<a href="${closeAccount}" aria-label="${yourAccountClose }"><spring:theme code="text.account.dashlet.aboutme.account.close"/></a>
			</div>
		</div>
		
		<div class="row box">
			<spring:theme code="text.account.dashlet.aboutMe.accessibility.consentManagement" var="yourConsentManagement" />
			<div class="col-xs-12 change-password">
				<a href="${consentManagement}" aria-label="${yourConsentManagement}"><spring:theme code="text.account.dashlet.aboutMe.consent.management" /></a>
			</div>
		</div>
		<c:choose>
			<c:when test="${ not empty paymentInfoData}">
			<spring:theme code="text.account.dashlet.aboutMe.accessibility.yourPaymentDetails" var="yourPaymentDetails" />
				<div class="row box">
					<div class="col-xs-12 payment-details">
						 <a href="${paymentDetails}" aria-label="${yourPaymentDetails}"><spring:theme code="text.account.dashlet.aboutMe.payment.details" /></a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row box notification-box">
					<div class="col-xs-12 text-center notification-inner-box">
						<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span> 
						<span class="notification-text" tabindex="0"><spring:theme code="text.account.dashlet.aboutMe.no.saved.payment" /></span>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>