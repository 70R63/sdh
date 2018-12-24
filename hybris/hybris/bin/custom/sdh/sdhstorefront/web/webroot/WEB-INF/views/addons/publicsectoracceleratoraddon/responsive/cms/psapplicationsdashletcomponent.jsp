<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="account" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/account"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="addOnTemplate" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<%@ taglib prefix="drafts" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/draft"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<addOnTemplate:psJavaScriptVariables />

<spring:url value="/my-account/applications" var="applicationsAndRequestsPageUrl" />

<spring:url value="/my-account/application/" var="orderDetailsUrl" />
<spring:url var="retrieveDraftUrl" value="/checkout/multi/draft" htmlEscape="false">
	<spring:param name="CSRFToken" value="${CSRFToken.token}" />
</spring:url>
<spring:url var="removeDraftUrl" value="/my-account/removeDraft" htmlEscape="false">
	<spring:param name="CSRFToken" value="${CSRFToken.token}" />
</spring:url>

<c:if test="${showApplicationAndRequestDashlet}">
	<div class="grid-item dashlet-application-request">
		<h2 class="header">
			<span tabindex="0">${ycommerce:encodeHTML(component.title)}</span>
		</h2>
		<h3 class="sub-header">
			<span tabindex="0">${ycommerce:encodeHTML(component.draftsSummary)}</span>
		</h3>
		<c:choose>
			<c:when test="${isUserDraftsAvailable}">
				<div class="content">
					<div class="row">
						<ul class="dashlet-list">
							<c:forEach items="${drafts}" var="draft">
								<li class="row dashlet-list-item draft-list">
									<div class="col-xs-8">
										<span class="title"> <c:forEach items="${draft.entries}" var="entry" begin="0" end="0">
												<c:set var="serviceName" value="${ycommerce:encodeHTML(entry.product.name)}" />
												<form class="retrieveQuoteForm" action="${retrieveDraftUrl}" method="POST">
													<input name="draftCode" class="draftCode" value="${ycommerce:encodeHTML(draft.code)}" type="hidden" />
													<input name="customerEmail" class="customerEmail" value="${ycommerce:encodeHTML(draft.savedBy.uid)}" type="hidden" />
													<a href="#" class="retrieveLink responsive-table-link js-edit-draft-service-request">${serviceName}</a>
												</form>
											</c:forEach>
										</span>
										<div aria-labelledby="dashletDraftDetails">
											<div id="dashletDraftDetails">
												<span tabindex="0"><strong><fmt:formatDate value="${draft.saveTime}" dateStyle="MEDIUM" timeStyle="short" type="date" /></strong></span><br />
												<span tabindex="0"><spring:theme code="text.account.orderHistory.savedBy" />:
													<c:choose>
															<c:when test="${user.displayUid eq draft.savedBy.uid}">
																<spring:theme code="text.account.orderHistory.you" />
															</c:when>
															<c:otherwise>
		                                                       ${ycommerce:encodeHTML(draft.savedBy.name)}
		                                                   </c:otherwise>
													</c:choose>
												</span>
											</div>
										</div>
									</div>
									<div class="col-xs-4 text-right no-space">
										<form class="retrieveQuoteForm editIconForm" action="${retrieveDraftUrl}" method="POST">
											<input name="draftCode" class="draftCode" type="hidden" value="${ycommerce:encodeHTML(draft.code)}" />
										 	<input name="customerEmail" class="customerEmail" value="" type="hidden" />
											<spring:theme code="text.account.draft.edit.service.request" var="editServiceRequestDraft" />
											<button type="button" class="draft-edit js-edit-draft-service-request" value="">
												<span class="glyphicon glyphicon-edit gi-2x edit-icon" aria-label="${editServiceRequestDraft}"></span>
											</button>
										</form>
										<form class="retrieveQuoteForm deleteIconForm" action="${retrieveDraftUrl}" method="POST">
											<input name="draftCode" class="draftCode" type="hidden" value="${ycommerce:encodeHTML(draft.code)}" />
											<input name="customerEmail" class="customerEmail" value="" type="hidden" />
											<spring:theme code="text.account.draft.delete.service.request" var="deleteServiceRequestDraft" />
											<button type="submit" aria-label="${deleteServiceRequestDraft}" class="delete-button delete-draft" data-product-name="${serviceName}" data-draft-code="${ycommerce:encodeHTML(draft.code)}" data-customer-email="">
												<span class="glyphicon glyphicon-trash gi-2x delete-icon" aria-label="${deleteServiceRequestDraft}"></span>
											</button>
										</form>
										<div class="hide">
											<div class="headline">
												<span class="headline-text" tabindex="0"><spring:theme code="draft.delete.service.order" text="Delete Service Order Draft" /></span>
											</div>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="content">
					<div class="row notification-box">
						<div class="col-xs-12 text-center notification-inner-box">
							<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span> <span class="notification-text" tabindex="0"><spring:theme code="text.account.dashlet.applications.no.drafts" /></span>
						</div>
					</div>
					<c:if test="${relationshipsHaveDrafts}">
						<div class="row notification-box">
							<div class="col-xs-12 text-center notification-inner-box">
								<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span> <span class="notification-text" tabindex="0"><spring:theme code="text.account.dashlet.applications.relationship.drafts" /></span>
							</div>
						</div>
					</c:if>
				</div>
			</c:otherwise>
		</c:choose>
		<h3 class="sub-header">
			<span tabindex="0">${ycommerce:encodeHTML(component.historySummary)}</span>
		</h3>
		<c:choose>
			<c:when test="${isUserApplicationsAvailable}">
				<div class="content">
					<div class="row">
						<ul class="dashlet-list">
							<c:forEach items="${applications}" var="application">
								<li class="row dashlet-list-item">
									<div class="col-xs-6 col-md-8">
										<span class="title dashlet-service-request">
											<a href="${orderDetailsUrl} ${ycommerce:encodeHTML(application.code)}">${ycommerce:encodeHTML(application.serviceRequest)}</a>
										</span>
									</div>
									<div class="col-xs-6 col-md-4 text-right">
										<span tabindex="0"><strong><spring:theme code="text.account.order.status.display.${application.statusDisplay}" /></strong></span>
									</div>
									<div class="col-xs-12 col-md-4">
										<span tabindex="0"><strong><fmt:formatDate value="${application.placed}" dateStyle="MEDIUM" timeStyle="short" type="date" /></strong></span>
									</div>
									<div class="col-xs-12 col-md-8">
										<span tabindex="0"><spring:theme code="text.account.orderHistory.submittedBy" />:
											<c:choose>
												<c:when test="${user.displayUid eq application.placedBy.uid}">
													<spring:theme code="text.account.orderHistory.you" />
												</c:when>
												<c:otherwise>
	                                               ${ycommerce:encodeHTML(application.placedBy.name)}
	                                           </c:otherwise>
											</c:choose> 
										</span>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="content">
					<div class="row notification-box">
						<div class="col-xs-12 text-center notification-inner-box">
							<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span> <span class="notification-text" tabindex="0"><spring:theme code="text.account.dashlet.applications.no.applications" /></span>
						</div>
					</div>
					<c:if test="${relationshipsHaveApplications}">
						<div class="row notification-box">
							<div class="col-xs-12 text-center notification-inner-box">
								<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span> <span class="notification-text" tabindex="0"><spring:theme code="text.account.dashlet.applications.relationship.applications" /></span>
							</div>
						</div>
					</c:if>
				</div>
			</c:otherwise>
		</c:choose>
		<c:if test="${showSeeAllApplicationsAndRequestsButton}">
			<div class="row">
				<div class="col-xs-12 button-box text-center">
					<form class="dashletAllApplicationsForm" action="${applicationsAndRequestsPageUrl}" method="GET">
						<button type="submit" class="btn btn-grey btn-block">
							<spring:theme code="text.account.dashlet.applications.see.all.applications.and.requests"/>
						</button>
					</form>
				</div>
			</div>
		</c:if>
		<drafts:draftDeleteOverlay />
	</div>
</c:if>