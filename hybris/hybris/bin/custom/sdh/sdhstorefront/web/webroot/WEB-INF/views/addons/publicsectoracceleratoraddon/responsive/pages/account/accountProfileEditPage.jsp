<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<span class="label" tabindex="0"><spring:theme code="text.account.profile.updatePersonalDetails"/></span>
				</h1>
			</div>
		</div>
	</div>
    <div class="row">
        <div class="col-md-6">
            <div class="account-section-content">
                <div class="account-section-form">
                    <form:form action="update-profile" method="post" commandName="updateProfileForm">
                        <p class="continuous-text"><spring:theme code="form.required" htmlEscape="false"/></p>
                        <formElement:formSelectBox idKey="profile.title" labelKey="profile.title" path="titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="form.select.empty" items="${titleData}" selectCSSClass="form-control"/>
                        <formElement:formInputBox idKey="profile.firstName" maxlength="240" labelKey="profile.firstName" path="firstName" inputCSS="text" mandatory="true"/>
                        <formElement:formInputBox idKey="profile.lastName" maxlength="240" labelKey="profile.lastName" path="lastName" inputCSS="text" mandatory="true"/>

                        <div class="row">
                            <div class="col-sm-6">
                                <div class="accountActions">
                                    <ycommerce:testId code="personalDetails_cancelPersonalDetails_button">
                                        <button type="button" class="btn btn-default btn-block" onclick="window.location='${myAccountUrl}'">
                                            <spring:theme code="text.account.profile.cancel" text="Cancel"/>
                                        </button>
                                    </ycommerce:testId>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="accountActions">
                                    <ycommerce:testId code="personalDetails_savePersonalDetails_button">
                                        <button type="submit" class="btn btn-primary btn-block">
                                            <spring:theme code="text.account.profile.saveUpdates" text="Save Updates"/>
                                        </button>
                                    </ycommerce:testId>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>