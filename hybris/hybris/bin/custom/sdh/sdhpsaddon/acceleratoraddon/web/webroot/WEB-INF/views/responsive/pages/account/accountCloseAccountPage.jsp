<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true"/>
<spring:url value="/my-account" var="dashboardUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<div class="row no-margin global-content-space account-close-section-header">
<div class="back-link border">
		<div class="row">
			<div class="col-md-6">
				<button tabindex="0" type="button" class="addressBackBtn" data-back-to-addresses="${dashboardUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0"><spring:theme code="text.account.closeAccount.header"/></span>
				</h1>
			</div>
		</div>
	</div>
<div class="row">
    <div class="col-md-6">
        <div class="account-section-content">
            <div class="account-section-form ">
                <div tabindex="0">
                    <spring:theme code="text.account.closeAccount.retention.info" htmlEscape="false" var="accountRetentionInfo"/>
                    ${ycommerce:sanitizeHTML(accountRetentionInfo)}
                </div>
            </div>
            <button type="button" class="btn btn-primary pull-right js-close-account-popup-button" data-popup-title="<spring:theme code="text.account.closeAccount.popup.title"/>">
                <spring:theme code="text.account.closeAccount.button"/>
            </button>

            <div class="display-none">
                <div id="popup_confirm_account_removal" class="js-close-account-popup">

                    <div class="modal-details row" tabindex="0">
                        <spring:theme code="text.account.closeAccount.popup.confirm" />
                    </div>
                    <div class="modal-actions">
                        <div class="row">
                            <div>
                                <button class="btn btn-primary btn-block js-close-account-action">
                                    <spring:theme code="text.account.closeAccount.popup.action" />
                                </button>
                            </div>

                            <div>
                                <button class="btn btn-default btn-block closeColorBox">
                                    <spring:theme code="text.button.cancel" />
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</div>
