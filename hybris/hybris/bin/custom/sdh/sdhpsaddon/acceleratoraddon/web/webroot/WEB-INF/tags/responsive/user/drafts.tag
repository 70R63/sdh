<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="drafts" required="true" type="java.util.ArrayList"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="drafts" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/draft"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="divOuterTable row no-margin">
	<div class="divTable myDraftsList" role="grid">
		<div class="divTableHeading hidden-xs hidden-sm" role="row">
			<span class="divTableCell col-md-5" role="columnheader"><spring:theme code="text.account.draft.name" /></span>
			<span class="divTableCell col-md-2" role="columnheader"><spring:theme code="text.account.draft.lastSaved" /></span>
			<c:if test="${isRelationshipData ne true}">
				<span class="divTableCell col-md-2" role="columnheader"><spring:theme code="text.account.orderHistory.savedBy" /></span>
			</c:if>
			<span class="divTableCell options-edit-delete col-md-3" role="columnheader"><spring:theme code="text.account.draft.options" /></span>
		</div>
		<c:if test="${isRelationshipData ne true}">
			<spring:url var="retrieveDraftUrl" value="/checkout/multi/draft" htmlEscape="false">
				<spring:param name="CSRFToken" value="${CSRFToken.token}" />
			</spring:url>
		</c:if>
		<c:if test="${isRelationshipData eq true}">
			<spring:url var="retrieveDraftUrl" value="/checkout/multi/relationship/draft" htmlEscape="false">
				<spring:param name="CSRFToken" value="${CSRFToken.token}" />
			</spring:url>
		</c:if>
		<spring:url var="removeDraftUrl" value="/my-account/removeDraft" htmlEscape="false">
			<spring:param name="CSRFToken" value="${CSRFToken.token}" />
		</spring:url>
		<c:forEach items="${drafts}" var="draft">
			<div class="divTableRow" role="row">
				<ycommerce:testId code="orderHistoryItem_orderDetails_link">
					<span class="divTableCell col-xs-12 col-sm-12 col-md-5" role="gridcell">
						<c:forEach items="${draft.entries}" var="entry" begin="0" end="0">
							<c:set var="serviceName" value="${ycommerce:encodeHTML(entry.product.name)}" />
							<form class="retrieveQuoteForm" action="${retrieveDraftUrl}" method="POST">
								<input name="draftCode" class="draftCode" value="${ycommerce:encodeHTML(draft.code)}" type="hidden" />
								<input name="customerEmail" class="customerEmail" value="${isRelationshipData eq true ? userData.uid : ''}" type="hidden" />
								<a href="#" class="retrieveLink responsive-table-link js-edit-draft-service-request"> ${serviceName} <br /> <spring:theme code="text.account.draft.draftNo" />&nbsp;${ycommerce:encodeHTML(draft.code)}</a>
							</form>
						</c:forEach>
					</span>
					<span class="divTableCell col-xs-6 col-sm-6 col-md-2" role="gridcell">
						<div class="hidden-md hidden-lg">
							<spring:theme code="text.account.draft.lastSaved" />
						</div> <fmt:formatDate value="${draft.lastAccessTime}" dateStyle="MEDIUM" timeStyle="short" type="date" />
					</span>
					<c:if test="${isRelationshipData ne true}">
						<span class="divTableCell col-xs-6 col-sm-6 col-md-2" role="gridcell">
							<div class="hidden-md hidden-lg">
								<spring:theme code="text.account.orderHistory.savedBy" />
							</div>
							<c:if test="${currentUserId eq draft.savedBy.uid}">
								<spring:theme code="text.account.orderHistory.you" />
							</c:if>
							<c:if test="${currentUserId ne draft.savedBy.uid}">
								${ycommerce:encodeHTML(draft.savedBy.name)}
							</c:if>
						</span>
					</c:if>
					<span class="divTableCell col-xs-6 col-sm -6 col-md-3 draft-buttons-heading" role="gridcell">
						<div class="hidden-md hidden-lg">
							<spring:theme code="text.account.draft.options" />
						</div>
						<form class="retrieveQuoteForm" action="${retrieveDraftUrl}" method="POST">
							<input name="draftCode" class="draftCode" type="hidden" value="${ycommerce:encodeHTML(draft.code)}" />
							<input name="customerEmail" class="customerEmail" value="${isRelationshipData eq true ? userData.uid : ""}" type="hidden" />
							<spring:theme code="text.account.draft.edit.service.request" var="editServiceRequestDraft" />
							<button type="button" aria-label="${editServiceRequestDraft}" class="glyphicon glyphicon-edit gi-2x draftEdit action-links js-edit-draft-service-request" value=""></button>
						</form>
						<span>
							<c:if test="${isRelationshipData eq true}">
								<c:set var="customerEmail" value="${ycommerce:encodeHTML(userData.customerPK)}" />
							</c:if>
							<spring:theme code="text.account.draft.delete.service.request" var="deleteServiceRequestDraft" />
							<form class="retrieveQuoteForm" action="${retrieveDraftUrl}" method="POST">
								<input name="draftCode" class="draftCode" type="hidden" value="${ycommerce:encodeHTML(draft.code)}" />
								<input name="customerEmail" class="customerEmail" value="${isRelationshipData eq true ? userData.uid : ""}" type="hidden" />								<spring:theme code="text.account.draft.edit.service.request" var="editServiceRequestDraft" />
								
								<button type="submit" aria-label="${deleteServiceRequestDraft}" class="delete-button delete-draft action-links removeAddressFromBookButton_" data-product-name="${serviceName}" data-draft-code="${draft.code}" data-customer-email="${customerEmail}">
									<span class="visuallyhidden">${deleteServiceRequestDraft}</span>
									<span class="glyphicon glyphicon-trash gi-2x"></span>
								</button>
							</form>
							<div class="hide">
								<div class="headline">
									<span class="headline-text" tabindex="0"><spring:theme code="draft.delete.service.order" text="Delete Service Order Draft" /></span>
								</div>
							</div>
						</span>
					</span>
				</ycommerce:testId>
			</div>
		</c:forEach>
	</div>
	<drafts:draftDeleteOverlay />
</div>