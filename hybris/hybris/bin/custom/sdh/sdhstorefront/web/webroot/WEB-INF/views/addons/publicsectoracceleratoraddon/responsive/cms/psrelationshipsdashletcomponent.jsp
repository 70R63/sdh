<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/my-account/relationship/add/" var="setUpPermissionsUrl" />
<spring:url value="/my-account/pending-requests" var="pendingRelationshipsUrl" />
<spring:url value="/my-account/my-relationships" var="seeAllRelationships" />

<spring:htmlEscape defaultHtmlEscape="true" />


<div class="grid-item permission-relationships">
	<h2 class="header">
		<span tabindex="0">${ycommerce:encodeHTML(component.title)}</span>
	</h2>
	<div class="content">
		<div class="row box notification-box">
			<div class="col-xs-12 text-center notification-inner-box">
				<div class="col-md-12">
					<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span>
				    <span class="notification-text" tabindex="0"> <c:set var="pendingRequestElement" value="<span class='gi-2.5x pending-request-number'>${pendingRequestCount}</span>" /> 
				        <spring:theme code="text.account.dashlet.permissionRelationships.pending.request" arguments="${pendingRequestElement}" htmlEscape="false" />
					</span>
				</div>
				<c:if test="${pendingRequestCount > 0}">
					<div class="col-xs-12 col-md-6 col-md-push-3">
						<button type="button" class="btn btn-block btn-grey btn-all-pending-request" onclick="window.location.href='${pendingRelationshipsUrl}'">
							<spring:theme code="text.account.dashlet.permissionRelationships.see.all.pendingRequest"></spring:theme>
						</button>
					</div>
				</c:if>
			</div>
		</div>
		<c:choose> 
		<c:when test="${isSeeAllRelationhipsButtonVisible eq false}">
		<div class="row box">
			<div class="col-xs-12 text-noPermissionRelationship" tabindex="0">
				<div class="text-center"><spring:theme code="text.account.dashlet.permissionRelationships.no.permissionRelationship.setUp" arguments="${activeAndPendingRelationshipsCount}" htmlEscape="false" var="noPermissionRelationshipSetup"/>
				${ycommerce:sanitizeHTML(noPermissionRelationshipSetup)}
				</div>
				<p>
					<strong><spring:theme code="text.account.dashlet.permissionRelationships.what.are.relationships" /></strong>
				</p>
				<spring:theme code="text.account.dashlet.permissionRelationships.what.are.relationships.description" />
			</div>
		</div>
		</c:when> 
		<c:otherwise>
		<div class="row box">
			<div class="col-xs-12 col-md-6 text-relationship">
				<span tabindex="0"><spring:theme code="text.account.dashlet.permissionRelationships.relationships.in.place" arguments="${activeAndPendingRelationshipsCount}" htmlEscape="false" var="relationshipsInPlace"></spring:theme>
				${ycommerce:sanitizeHTML(relationshipsInPlace)}
				</span>
			</div>
			
			  <div class="col-xs-12 col-md-6 text-right">
				 <button type="button" class="btn btn-primary btn-block" onclick="window.location.href='${seeAllRelationships}'">
					<spring:theme code="text.account.dashlet.permissionRelationships.see.all.relationship"></spring:theme>
				 </button>
			  </div>
		</div>
		</c:otherwise>
		</c:choose>
		<div class="row box">
			<div class="col-xs-12 col-md-6 text-relationship">
				<span tabindex="0"><spring:theme code="text.account.dashlet.permissionRelationships.add.new.relationships"></spring:theme></span>
			</div>
			<div class="col-xs-12 col-md-6 text-right">
				<button type="button" class="btn btn-primary btn-block" onclick="window.location.href='${setUpPermissionsUrl}'">
					<spring:theme code="text.relationship.setup.permissions"></spring:theme>
				</button>
			</div>
		</div>
	</div>
</div>