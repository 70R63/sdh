<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="results" required="true" type="java.util.HashMap"%>
<%@ attribute name="customer" required="true" type="de.hybris.platform.commercefacades.user.data.CustomerData"%>
<%@ attribute name="sessionUser" required="true" type="de.hybris.platform.commercefacades.user.data.CustomerData"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/user"%>
<spring:url value="/my-account/my-relationships/" var="fullBillUrl" />
<spring:url value="/my-account/my-relationships/manage-details/" var="manageDetailsUrl" />
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="divOuterTable row no-margin">
	<div class="divTable" role="grid">
			<div class="divTableHeading hidden-xs" role="row">
				<div class="divTableCell col-xs-12 col-sm-2 col-md-3"
				role="columnheader">
					<spring:theme code="text.relationship.name" />
				</div>
				<div class="divTableCell col-xs-12 col-sm-6 col-md-6"
				role="columnheader">
					<spring:theme code="text.relationship.permissions" />
				</div>
				<div class="divTableCell col-xs-12 col-sm-2 col-md-3"
				role="columnheader">&nbsp;</div>
			</div>
		<%-- Iterating NON POA relationships --%>
		<c:forEach items="${results['non-poa']}" var="relationship">
				<ycommerce:testId code="RelationshipHistoryItem_showRelationships">
						<div class="divTableRow" role="row">
						<div class="divTableCell col-xs-12 col-sm-2 col-md-3"
						role="gridcell">
							<c:choose>
								<c:when test="${relationship.targetUser.uid eq customer.uid}">
									<c:set var="otherUser" value="${relationship.sourceUser}"></c:set>
									<td class="responsive-table-cell bills-table responsive-table-cell-bold"><strong>${ycommerce:encodeHTML(relationship.sourceUser.name)}</strong></td>
								</c:when>
								<c:otherwise>
									<c:set var="otherUser" value="${relationship.targetUser}"></c:set>
									<c:choose>
										<c:when test="${(empty otherUser && relationship.status == 'PENDING')||(not empty otherUser && relationship.status == 'PENDING')}">
											<td class="responsive-table-cell bills-table responsive-table-cell-bold"><strong>${ycommerce:encodeHTML(relationship.firstName)}&nbsp;${ycommerce:encodeHTML(relationship.lastName)}</strong></td>
										</c:when>
										<c:otherwise>
											<td class="responsive-table-cell bills-table responsive-table-cell-bold"><strong>${ycommerce:encodeHTML(relationship.targetUser.name)}</strong></td>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="divTableCell col-xs-12 col-sm-6 col-md-6"
						role="gridcell">
						   <user:relationshipSummaryMessageWithPoa relationship="${relationship}" relationshipType="non-poa" customer="${customer}" sessionUser="${sessionUser}"/>
						</div>
						<div class="divTableCell col-xs-12 col-sm-4 col-md-3"
						role="gridcell">
							<button id="relationshipManageDetails" type="submit" class="btn btn-grey btn-block" onClick="window.location='${manageDetailsUrl}${ycommerce:encodeHTML(relationship.id)}/${ycommerce:encodeHTML(customer.customerPK)}'">
									<spring:theme code="text.relationship.manage.details" />
								</button>
						</div>
					</div>
				</ycommerce:testId>
			</c:forEach>
			
			<%-- Iterating relationships where current user is POA Holder --%>
			<c:forEach items="${results['poa-holder']}" var="relationship">
				<ycommerce:testId code="RelationshipHistoryItem_showRelationships">
					<div class="divTableRow" role="row">
						<div class="divTableCell col-xs-12 col-sm-2 col-md-3"
						role="gridcell">
							<c:choose>
								<c:when test="${relationship.targetUser.uid eq customer.uid}">
									<c:set var="otherPOAUser" value="${relationship.sourceUser}"></c:set>
								</c:when>
								<c:otherwise>
									<c:set var="otherPOAUser" value="${relationship.targetUser}"></c:set>
								</c:otherwise>
							</c:choose>
								<td class="responsive-table-cell bills-table responsive-table-cell-bold"><strong>${ycommerce:encodeHTML(otherPOAUser.name)}</strong></td>
						</div>
						<div class="divTableCell col-xs-12 col-sm-6 col-md-6"
						role="gridcell">
						   <user:relationshipSummaryMessageWithPoa relationship="${relationship}" relationshipType="poa-holder" customer="${customer}" sessionUser="${sessionUser}"/>
						</div>
						<div class="divTableCell col-xs-12 col-sm-4 col-md-3"
						role="gridcell">
							<button id="relationshipManageDetails" type="submit" class="btn btn-grey btn-block" onClick="window.location='${manageDetailsUrl}${ycommerce:encodeHTML(relationship.id)}/${ycommerce:encodeHTML(customer.customerPK)}'">
									<spring:theme code="text.relationship.manage.details" />
								</button>
						</div>
					</div>
				</ycommerce:testId>
			</c:forEach>
			
			<%-- Iterating relationships where current user is POA Receiver --%>
			<c:forEach items="${results['poa-receiver']}" var="relationship">
				<ycommerce:testId code="RelationshipHistoryItem_showRelationships">
					<div class="divTableRow" role="row">
						<div class="divTableCell col-xs-12 col-sm-2 col-md-3"
						role="gridcell">
							<c:choose>
								<c:when test="${relationship.targetUser.uid eq customer.uid}">
									<c:set var="POAHolderUser" value="${relationship.sourceUser}"></c:set>
								</c:when>
								<c:otherwise>
									<c:set var="POAHolderUser" value="${relationship.targetUser}"></c:set>
								</c:otherwise>
							</c:choose>
							
							<c:choose>
								<c:when test="${empty POAHolderUser}">
									<td class="responsive-table-cell bills-table responsive-table-cell-bold"><strong>${ycommerce:encodeHTML(relationship.targetEmail)}</strong></td>
								</c:when>
								<c:otherwise>
									<td class="responsive-table-cell bills-table responsive-table-cell-bold"><strong>${ycommerce:encodeHTML(POAHolderUser.name)}</strong></td>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="divTableCell col-xs-12 col-sm-6 col-md-6"
						role="gridcell">
						   <user:relationshipSummaryMessageWithPoa relationship="${relationship}" relationshipType="poa-receiver" customer="${customer}" sessionUser="${sessionUser}"/>
						</div>
						<div class="divTableCell col-xs-12 col-sm-2 col-md-3"
						role="gridcell">
								<button id="relationshipManageDetails" type="submit" class="btn btn-grey btn-block" onClick="window.location='${manageDetailsUrl}${ycommerce:encodeHTML(relationship.id)}/${ycommerce:encodeHTML(customer.customerPK)}'">
									<spring:theme code="text.relationship.manage.details" />
								</button>
						</div>
					</div>
				</ycommerce:testId>
			</c:forEach>
	</div>
</div>
