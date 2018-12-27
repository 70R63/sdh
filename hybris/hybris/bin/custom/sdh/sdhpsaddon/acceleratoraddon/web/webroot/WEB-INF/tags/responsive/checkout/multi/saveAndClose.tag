<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
	<c:if test="${not empty cartData.code}">
		<div id="savedpayments">
			<div id="saveddrafttitle">
				<div class="headline">
					<span class="headline-text"><spring:theme code="checkout.multi.saveandclose.draft.popup" /></span>
				</div>
			</div>
			<div id="saveddraftbody" class="save-draft-body">
				<div tabindex="0" aria-labelledby="savedDraftNumber">
					<div id="savedDraftNumber">
						<spring:theme code="checkout.multi.saveandclose.draft.popup.heading" htmlEscape="false" var="draftPopupHeading"/>
						${ycommerce:sanitizeHTML(draftPopupHeading)}
						<p>
							<span class="gi-1.5x draft-no"><strong>${ycommerce:encodeHTML(cartData.code)}</strong></span>
						</p>
						<p>
							<spring:theme code="checkout.multi.saveandclose.draft.popup.information" htmlEscape="false" var="draftPopupInformation"/>
							${ycommerce:sanitizeHTML(draftPopupInformation)}
						</p>
					</div>
				</div>
				<div class="col-md-6 pull-right">
					<button type="button" id="draftPopupBtn" class="btn btn-primary btn-block col-md-6">
					   <spring:theme code="checkout.multi.saveandclose.draft.popup.button" />
					</button>
				</div>
			</div>
		</div>
	</c:if>
</sec:authorize>