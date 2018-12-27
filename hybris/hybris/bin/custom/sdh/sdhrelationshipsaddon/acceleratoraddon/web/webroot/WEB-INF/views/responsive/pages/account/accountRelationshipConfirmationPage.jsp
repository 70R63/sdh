<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="relations" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/relationship"%>
<%@ taglib prefix="cancelPendingRequest" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/cancelPendingRequest"%>
<%@ taglib prefix="addOntemplate" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/template"%>
<spring:url value="/my-account/my-relationships/cancel-pending-relationship/" var="cancelRelationShipUrl" />
<spring:url value="/my-account/my-relationships" var="permissionAndRelationshipPageUrl" />
<spring:htmlEscape defaultHtmlEscape="true" />

<addOntemplate:psJavaScriptVariables />

<div class="account-section">
	<div class="yCmsContentSlot account-section-content">
		<div class="permission-setup-confirmation">
			<div class="row">
				<h1>
					<span tabindex="0"><spring:theme code="text.confirmation.permission.request.sent" /></span>
				</h1>
			</div>

			<div class="row">
				<div class="col-xs-12 col-md-8">
					<div class="row no-margin">
						<div class="col-md-12" tabindex="0">
							<div>
								<span class="glyphicon glyphicon-ok gi-1.5x"></span> &nbsp;&nbsp;
								<span class="permissions-content-title">
									<c:choose>
										<c:when test="${not empty relationshipCustomer}">
											<strong><spring:message code="permission.setup.request.sent.for.relationship" arguments="${relationshipCustomer.firstName}"/></strong>
										</c:when>
										<c:otherwise>
											<strong><spring:message code="permission.setup.request.sent.you"/></strong>
										</c:otherwise>
									</c:choose>
								</span>
							</div>
						</div>
						<div class="col-md-6" tabindex="0">
							<div class="box-person text-center">
								<c:if test="${isTargetUserExists eq true }">
									<spring:theme code="relationship.user.name" text="{0} {1} {2}" arguments="${relation.targetUser.title} ,${relation.targetUser.firstName}, ${relation.targetUser.lastName}" />
									<c:set var="targetUserFirstName" value="${relation.targetUser.firstName }" />
									<c:set var="confirmationUserDetails" value="${relation.targetUser.title} ${relation.targetUser.firstName} ${relation.targetUser.lastName}" />
								</c:if>
								<c:if test="${isTargetUserExists eq false }">
									<spring:theme code="relationship.user.name" text="{0} {1} {2}" arguments="${relation.title}, ${relation.firstName}, ${relation.lastName}" />
									<c:set var="targetUserFirstName" value="${relation.firstName }" />
									<c:set var="confirmationUserDetails" value="${relation.title} ${relation.firstName} ${relation.lastName}" />
								</c:if>
							</div>
						</div>
						<div class="col-md-12 desc-text" tabindex="0">
							<span>
							<c:if test="${isTargetUserExists eq true }">
								<c:choose>
									<c:when test="${not empty relationshipCustomer}">
										<spring:theme code="relation.permission.customer.basic.view" arguments="${targetUserFirstName},${relationshipCustomer.firstName}" htmlEscape="false" var="basicView"/>
										${ycommerce:sanitizeHTML(basicView)}
									</c:when>
									<c:otherwise>
										<spring:theme code="permission.basic.view" text="As soon as {0} accepts the permission setup request and gives you permissions, you can act on their behalf. You will automatically be able to view each other's:" arguments="${targetUserFirstName}" htmlEscape="false"/>
									</c:otherwise>
								</c:choose>
							</c:if>
							<c:if test="${isTargetUserExists eq false }">
								<c:choose>
									<c:when test="${not empty relationshipCustomer}">
										<spring:theme code="relation.permission.nonregistered.customer.basic.view" arguments="${targetUserFirstName},${relationshipCustomer.firstName}" htmlEscape="false" var="nonRegisteredCustomerBasicView"/>
										${ycommerce:sanitizeHTML(nonRegisteredCustomerBasicView)}
									</c:when>
									<c:otherwise>
										<spring:theme code="permission.nonregistered.basic.view" text="As soon as {0} accepts the permission setup request, you can set up permissions and you will automatically be able to view each other's:" arguments="${targetUserFirstName}" htmlEscape="false" var="nonRegisteredBasicView"/>
									    ${ycommerce:sanitizeHTML(nonRegisteredBasicView)}
									</c:otherwise>
								</c:choose>
							</c:if>
							</span>
							<ul class="dashed">
								<c:forEach items="${activePermissibleItems}" var="permissibleItem">
									<c:if test="${ empty permissibleItem.shareableType}">
										<li>${ycommerce:encodeHTML(permissibleItem.displayName)}</li>
									</c:if>
								</c:forEach>
							</ul>
						</div>

					</div>
					<div class="row">
						<div class="col-md-12 col-sm-5 col-md-5 col-sm-push-3 permission-relation-button desc-text">
							<button class="btn btn-primary btn-block" onclick="window.location.href='${permissionAndRelationshipPageUrl}'">
								<spring:theme code="permission.relationship.page" />
							</button>
						</div>
					</div>
					<hr>
					<c:if test="${isTargetUserExists eq true }">
						<c:if test="${not empty givenPermissionToTargetUser }">
							<div class="row">
								<div class="col-md-12" tabindex="0">
									<div>
										<span class="glyphicon glyphicon-ok gi-1.5x"></span>&nbsp;&nbsp;<span class="permissions-content-title"> <strong><spring:message code="permission.you.requested.permission"/></strong></span>
									</div>
								</div>
								<div class="col-md-12">
									<relations:permission activePermissibleItems="${activePermissibleItems}" permissions="${givenPermissionToTargetUser}" />
									<div class="col-md-12 desc-text no-space" tabindex="0">
										<c:choose>
											<c:when test="${not empty relationshipCustomer}">
												<spring:theme code="relation.permission.request.customer.permissions.description" htmlEscape="false" var="basicView"/>
											   	<span>${ycommerce:sanitizeHTML(basicView)}</span>
												<ul class="dashed">
													<li>
														<spring:theme code="relationship.permission.customer.payment.details" arguments="${targetUserFirstName}" htmlEscape="false" var="customerPaymentDetails" />
														${ycommerce:sanitizeHTML(customerPaymentDetails)}
													</li>
													<li>
														<spring:theme code="relationship.permission.customer.password" arguments="${targetUserFirstName}" htmlEscape="false" var="customerPassword" />
														${ycommerce:sanitizeHTML(customerPassword)}
													</li>
													<li>
														<spring:theme code="relationship.permission.customer.relationships" arguments="${targetUserFirstName}" htmlEscape="false" var="customerRelationships" />
														${ycommerce:sanitizeHTML(customerRelationships)}
													</li>
												</ul>
											</c:when>
											<c:otherwise>
												<spring:theme code="permission.request.permissions.description" htmlEscape="false" var="requestPermissionsDescription"/>
											   	<span>${ycommerce:sanitizeHTML(requestPermissionsDescription)}</span>
												<ul class="dashed">
													<li>
														<spring:theme code="relationship.permission.customer.payment.details" arguments="${targetUserFirstName}" htmlEscape="false" var="customerPaymentDetails" />
														${ycommerce:sanitizeHTML(customerPaymentDetails)}
													</li>
													<li>
														<spring:theme code="relationship.permission.customer.password" arguments="${targetUserFirstName}" htmlEscape="false" var="customerPassword" />
														${ycommerce:sanitizeHTML(customerPassword)}
													</li>
													<li>
														<spring:theme code="relationship.permission.customer.relationships" arguments="${targetUserFirstName}" htmlEscape="false" var="customerRelationships" />
														${ycommerce:sanitizeHTML(customerRelationships)}
													</li>
												</ul>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
							<hr />
						</c:if>
						<c:if test="${not empty requestedPermissionForTargetUser }">
							<div class="row">
								<div class="col-md-12" tabindex="0">
									<div>
										<span class="glyphicon glyphicon-ok gi-1.5x"></span> &nbsp;&nbsp;<span class="permissions-content-title"> <strong><spring:message code="permission.you.given.permission"/></strong></span>
									</div>
								</div>
								<div class="col-md-12">
									<relations:permission activePermissibleItems="${activePermissibleItems}" permissions="${requestedPermissionForTargetUser}" />
									<div class="col-md-12 desc-text no-space" tabindex="0">
										<c:choose>
											<c:when test="${not empty relationshipCustomer}">
												<spring:theme code="relation.permission.given.customer.permissions.description" arguments="${targetUserFirstName}" htmlEscape="false" var="givenCustomerPermissions"/>
											    <span>${ycommerce:sanitizeHTML(givenCustomerPermissions)}</span>
												<ul class="dashed">
													<li>
														<spring:theme code="relationship.permission.customer.payment.details" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="customerPaymentDetails" />
														${ycommerce:sanitizeHTML(customerPaymentDetails)}
													</li>
													<li>
														<spring:theme code="relationship.permission.customer.password" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="customerPassword" />
														${ycommerce:sanitizeHTML(customerPassword)}
													</li>
													<li>
														<spring:theme code="relationship.permission.customer.relationships" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="customerRelationships" />
														${ycommerce:sanitizeHTML(customerRelationships)}
													</li>
												</ul>
											</c:when>
											<c:otherwise>
												<spring:theme code="permission.given.permissions.description" arguments="${targetUserFirstName}" htmlEscape="false" var="givenPermissionsDescription"/>
											    <span>${ycommerce:sanitizeHTML(givenPermissionsDescription)}</span>
												<ul class="dashed">
													<li>
														<spring:theme code="relationship.permission.payment.details" />
													</li>
													<li>
														<spring:theme code="relationship.permission.password" />
													</li>
													<li>
														<spring:theme code="relationship.permission.relationships" />
													</li>
												</ul>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
							<hr />
						</c:if>
					</c:if>
					<div class="row">
						<div class="col-sm-12 cancel-request">
							<div class="box-action confirmation-box-action">
								<div class="text-center heading">
									<c:choose>
										<c:when test="${isTargetUserExists eq true }">
											<span tabindex="0">
												<spring:theme code="permission.cancel.request.text" />
											</span>
											</br>
											</br>
										</c:when>
										<c:otherwise>
											<span tabindex="0">
												<spring:theme code="permission.cancel.request.unregistered.user.text" />
											</span>
											</br>
											</br>
										</c:otherwise>
									</c:choose>
									<div class="col-sm-4 col-md-4 col-sm-push-4">
										<button aria-label="<spring:theme code=" text.cancel.request " />" class="cancel-pending-request btn btn-primary btn-block">
											<spring:theme code="text.cancel.request" />
										</button>
									</div>
								</div>
							</div>
							<div class="hide">
								<div class="headline">
									<span class="headline-text cancel-pending-request-heading"><h1><span tabindex="0"><spring:theme code="text.cancel.pending.request.overlay.heading"/></span></h1></span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<cancelPendingRequest:cancelPendingRequestOverlay sourceUser="${relationshipCustomer.firstName}" userDetails="${confirmationUserDetails}" cancelUrl="${cancelRelationShipUrl}${relation.id}"/>
</div>

