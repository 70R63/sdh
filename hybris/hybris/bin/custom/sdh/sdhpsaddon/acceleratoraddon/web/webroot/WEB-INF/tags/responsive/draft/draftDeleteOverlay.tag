<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/remove-draft/" var="deleteDraftUrl"></spring:url>
<spring:url value="/my-account/removeRelationshipDraft/" var="deleteRelationshipDraftUrl"></spring:url>
<div id="delete-draft-overlay" class="delete-draft-overlay">
	<div>

		<spring:theme code="draft.delete.service.order.message" var="deleteDraftOverlayText" text="The following service order draft will be deleted from your drafts:" htmlEscape="false" />
		<span aria-label="${deleteDraftOverlayText}" tabindex="0">${ycommerce:sanitizeHTML(deleteDraftOverlayText)}</span> <br>
		<br> <b><span tabindex="0" id="productname"></span></b>

		<p>
			<span tabindex="0" class="draft-no"><spring:theme code="text.account.draft.draftNo" text="Draft No." /> </span><span id="draftNumber"></span>

		</p>

		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<div class="col-xs-6">
					<a href="#" class="btn btn-grey center-block delete-cancel"><spring:theme code="checkout.multi.cancel" /></a>
				</div>

				<div class="col-xs-6">
					<a href="#" id="delete-draft-submit" class="center-block btn-place-order btn-block btn btn-primary" data-url="${deleteDraftUrl}" data-relationship-url="${deleteRelationshipDraftUrl}"> <spring:theme code="text.account.draft.delete" text="Delete" />
					</a>
				</div>
			</div>
		</div>
	</div>
</div>