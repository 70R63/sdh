<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="relationship" required="true" type="de.hybris.platform.relationship.data.PSRelationshipData"%>
<%@ attribute name="relationshipType" required="true" type="java.lang.String"%>
<%@ attribute name="customer" required="true" type="de.hybris.platform.commercefacades.user.data.CustomerData"%>
<%@ attribute name="sessionUser" required="true" type="de.hybris.platform.commercefacades.user.data.CustomerData"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:url value="/my-account/my-relationships/" var="fullBillUrl" />
<spring:url value="/my-account/my-relationships/manage-details/" var="manageDetailsUrl" />
<spring:htmlEscape defaultHtmlEscape="true" />
		
		<%-- Iterating NON POA relationships --%>
		<c:if test="${relationshipType eq 'non-poa'}">
				<ycommerce:testId code="RelationshipHistoryItem_showRelationships">
							<c:choose>
								<c:when test="${relationship.targetUser.uid eq customer.uid}">
									<c:set var="otherUser" value="${relationship.sourceUser}"></c:set>
									<td class="responsive-table-cell bills-table responsive-table-cell-bold"></td>
								</c:when>
								<c:otherwise>
									<c:set var="otherUser" value="${relationship.targetUser}"></c:set>
								</c:otherwise>
							</c:choose>
							<%-- <hr align="left" width="50%" /> --%>
									<c:if test="${(relationship.permissionsGivenOnRequestActiveCount > 0 || relationship.permissionsGivenOnOwnActiveCount > 0) 
														&& (relationship.permissionsReceivedOnRequestActiveCount > 0 || relationship.permissionsReceivedOnOwnActiveCount > 0)}">
										<spring:theme code="text.permission.both.user" />
									</c:if>
									
									<c:if test="${relationship.status eq 'ACTIVE' && relationship.permissionsGivenOnRequestActiveCount eq 0 && relationship.permissionsGivenOnOwnActiveCount eq 0 
														&& relationship.permissionsReceivedOnRequestActiveCount eq 0 && relationship.permissionsReceivedOnOwnActiveCount eq 0}">
										<spring:theme code="text.permission.poa.receiver.other" arguments="${otherUser.firstName}, ${customer.firstName}" htmlEscape="false" var="permissionPoaReceiverOther"/>
										${ycommerce:sanitizeHTML(permissionPoaReceiverOther)}
									</c:if>
									
									<c:if test="${(relationship.permissionsGivenOnRequestActiveCount > 0 || relationship.permissionsGivenOnOwnActiveCount > 0) 
														&& relationship.permissionsReceivedOnRequestActiveCount <= 0 && relationship.permissionsReceivedOnOwnActiveCount <= 0}">
										<spring:theme code="text.permission.other.user" arguments="${otherUser.firstName}" htmlEscape="false" var="permissionOtherUser"/>
										${ycommerce:sanitizeHTML(permissionOtherUser)}
									</c:if>
									
									<c:if test="${relationship.permissionsGivenOnRequestActiveCount <= 0 && relationship.permissionsGivenOnOwnActiveCount <= 0 
														&& (relationship.permissionsReceivedOnRequestActiveCount > 0 || relationship.permissionsReceivedOnOwnActiveCount > 0)}">
										<spring:theme code="text.permission.current.user" arguments="${otherUser.firstName}" htmlEscape="false" var="permissionCurrentUser"/>
										${ycommerce:sanitizeHTML(permissionCurrentUser)}
									</c:if>
									
									<c:choose>
									<c:when test="${relationship.status eq 'ACTIVE' && relationship.permissionsReceivedOnOwnPendingCount > 0 && relationship.permissionsGivenOnRequestPendingCount > 0}">
										<spring:theme code="text.permission.other.both.pending" arguments="${otherUser.firstName}" htmlEscape="false" var="permissionOtherBothPending"/>
										${ycommerce:sanitizeHTML(permissionOtherBothPending)}
									</c:when>
									<c:otherwise>
									<c:if test="${relationship.status eq 'ACTIVE' && relationship.permissionsReceivedOnOwnPendingCount > 0}">
										<spring:theme code="text.permission.other.req.pending" arguments="${otherUser.firstName}" htmlEscape="false" var="permissionOtherReqPending"/>
									    ${ycommerce:sanitizeHTML(permissionOtherReqPending)}
									</c:if>
									<c:if test="${relationship.status eq 'ACTIVE' && relationship.permissionsGivenOnRequestPendingCount > 0}">
										<spring:theme code="text.permission.poa.holder.req.pending" arguments="${customer.firstName}, ${otherUser.firstName}" htmlEscape="false" var="permissionPoaHolderReqPending"/>
										${ycommerce:sanitizeHTML(permissionPoaHolderReqPending)}
									</c:if>
									</c:otherwise>
									</c:choose>
									
									<c:choose>
									<c:when test="${relationship.status eq 'ACTIVE' && relationship.permissionsGivenOnOwnPendingCount > 0 && relationship.permissionsReceivedOnRequestPendingCount > 0}">
										<spring:theme code="text.permission.current.both.pending" arguments="${otherUser.firstName}" htmlEscape="false" var="permissionCurrentBothPending"/>
								        ${ycommerce:sanitizeHTML(permissionCurrentBothPending)}
								    </c:when>
									<c:otherwise>
									<c:if test="${relationship.status eq 'ACTIVE' && relationship.permissionsGivenOnOwnPendingCount > 0}">
										<spring:theme code="text.permission.poa.holder.add.pending" arguments="${otherUser.firstName},${customer.firstName}" htmlEscape="false" var="permissionPoaHolderAddPending"/>
									    ${ycommerce:sanitizeHTML(permissionPoaHolderAddPending)}
									</c:if>
									
									<c:if test="${relationship.status eq 'ACTIVE' && relationship.permissionsReceivedOnRequestPendingCount > 0}">
										<spring:theme code="text.permission.current.req.pending" arguments="${otherUser.firstName}" htmlEscape="false" var="permissionCurrentReqPending"/>
										${ycommerce:sanitizeHTML(permissionCurrentReqPending)}
									</c:if>
									</c:otherwise>
									</c:choose>
									
									<c:if test="${relationship.status eq 'PENDING' && relationship.sourceUser.uid eq customer.uid && empty relationship.targetUser}">
										<c:choose>
											<c:when test="${customer.uid eq sessionUser.uid}">
												<spring:theme code="text.permission.current.initiate.nonuser" arguments="${relationship.firstName}" htmlEscape="false" var="permissionCurrentInitiateNonUser"/>
											    ${ycommerce:sanitizeHTML(permissionCurrentInitiateNonUser)}
											</c:when>
											<c:otherwise>
												<spring:theme code="text.permission.current.initiate.nonuser.receiver.other" arguments="${relationship.firstName}, ${customer.firstName}" htmlEscape="false" var="permissionCurrentInitiateNonUserReceiver"/>
											    ${ycommerce:sanitizeHTML(permissionCurrentInitiateNonUserReceiver)}
											</c:otherwise>
										</c:choose>
									</c:if>
									
									<c:if test="${relationship.status eq 'PENDING' && relationship.sourceUser.uid eq customer.uid && not empty relationship.targetUser}">
										<c:choose>
											<c:when test="${customer.uid eq sessionUser.uid}">
												<spring:theme code="text.permission.current.initiate.user" arguments="${relationship.firstName}" htmlEscape="false" var="permissionCurrentInitiateUser"/>
											    ${ycommerce:sanitizeHTML(permissionCurrentInitiateUser)}
											</c:when>
											<c:otherwise>
												<spring:theme code="text.permission.current.initiate.user.receiver.other" arguments="${relationship.firstName}, ${customer.firstName}" htmlEscape="false" var="permissionCurrentInitiateUserReceiverOther"/>
											    ${ycommerce:sanitizeHTML(permissionCurrentInitiateUserReceiverOther)}
											</c:otherwise>
										</c:choose>
									</c:if>
				</ycommerce:testId>
			</c:if>
			
			<%-- Iterating relationships where current user is POA Holder --%>
			<c:if test="${relationshipType eq 'poa-holder'}">
				<ycommerce:testId code="RelationshipHistoryItem_showRelationships">
							<c:choose>
								<c:when test="${relationship.targetUser.uid eq customer.uid}">
									<c:set var="otherPOAUser" value="${relationship.sourceUser}"></c:set>
								</c:when>
								<c:otherwise>
									<c:set var="otherPOAUser" value="${relationship.targetUser}"></c:set>
								</c:otherwise>
							</c:choose>
							<spring:theme code="text.permission.userhaspoa" arguments="${otherPOAUser.firstName}" htmlEscape="false" var="permissionUserHasPoa"/>
							${ycommerce:sanitizeHTML(permissionUserHasPoa)}
				</ycommerce:testId>
			</c:if>
			
			<%-- Iterating relationships where current user is POA Receiver --%>
			<c:if test="${relationshipType eq 'poa-receiver'}">
				<ycommerce:testId code="RelationshipHistoryItem_showRelationships">
							<c:choose>
								<c:when test="${relationship.targetUser.uid eq customer.uid}">
									<c:set var="POAHolderUser" value="${relationship.sourceUser}"></c:set>
								</c:when>
								<c:otherwise>
									<c:set var="POAHolderUser" value="${relationship.targetUser}"></c:set>
								</c:otherwise>
							</c:choose>
						<%-- <hr align="left" width="50%" /> --%>
						<c:choose>
							<c:when test="${sessionUser.uid eq POAHolderUser.uid}">
								<spring:theme code="text.permission.other.user.receiver" arguments="${POAHolderUser.firstName}, ${customer.firstName}" htmlEscape="false" var="permissionOtherUserReceiver"/>
							    ${ycommerce:sanitizeHTML(permissionOtherUserReceiver)}
							</c:when>
							
							<c:when test="${sessionUser.uid eq customer.uid && empty POAHolderUser && relationship.status eq 'PENDING'}">
								<spring:theme code="text.permission.current.initiate.nonuser.receiver" arguments="${relationship.firstName}" htmlEscape="false" var="permissionCurrentInitiateNonUserReceiver"/>
							    ${ycommerce:sanitizeHTML(permissionCurrentInitiateNonUserReceiver)}
							</c:when>
							
							<c:when test="${sessionUser.uid eq customer.uid && customer.uid ne POAHolderUser.uid && relationship.status eq 'PENDING'}">
								<spring:theme code="text.permission.current.initiate.user.receiver" arguments="${POAHolderUser.firstName}" htmlEscape="false" var="permissionCurrentInitiateUserReceiver"/>
							    ${ycommerce:sanitizeHTML(permissionCurrentInitiateUserReceiver)}
							</c:when>
							
							<c:when test="${sessionUser.uid eq customer.uid && customer.uid ne POAHolderUser.uid}">
								<spring:theme code="text.permission.user.poa.receiver" arguments="${POAHolderUser.firstName}" htmlEscape="false" var="permissionUserPoaReceiver"/>
							    ${ycommerce:sanitizeHTML(permissionUserPoaReceiver)}
							</c:when>
							
							<c:when test="${sessionUser.uid ne customer.uid && sessionUser.uid ne POAHolderUser.uid && relationship.status eq 'ACTIVE'}">
								<spring:theme code="text.permission.poa.receiver.other" arguments="${POAHolderUser.firstName}, ${customer.firstName}" htmlEscape="false" var="permissionPoaReceiverOther"/>
							    ${ycommerce:sanitizeHTML(permissionPoaReceiverOther)}
							</c:when>
							
							<c:when test="${sessionUser.uid ne customer.uid && sessionUser.uid ne POAHolderUser.uid && relationship.status eq 'PENDING'}">
								<spring:theme code="text.permission.current.initiate.user.receiver.other" arguments="${POAHolderUser.firstName}, ${customer.uid}" htmlEscape="false" var="permissionCurrentInitiateUserReceiverOther"/>
								${ycommerce:sanitizeHTML(permissionCurrentInitiateUserReceiverOther)}
							</c:when>
						</c:choose>
				</ycommerce:testId>
			</c:if>
