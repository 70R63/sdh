<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="account" tagdir="/WEB-INF/tags/addons/relationshipaddon/responsive/account"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url var="updatePendingRequstUrl" value="/my-account/update-pending-request">
	<spring:param name="CSRFToken" value="${CSRFToken.token}" />
</spring:url>
<spring:url value="${source}" var="backButtonUrl" />
<spring:theme code="text.back.icon.accessibility" var="pendingRequestBack" />

<div class="pending-request-permissions">
	<div class="pending-request">
		<div class="row no-margin">
			<div class="back-link border">
				<div class="row">
					<div class="col-md-6">
						<button type="button" class="addressBackBtn" data-back-to-addresses="${backButtonUrl}">
							<span class="glyphicon glyphicon-chevron-left" aria-label="${pendingRequestBack}"></span>
						</button>
						<h1 class="custom-h1">
							<span class="label" tabindex="0"><spring:theme code="text.account.myPendingRequests" text="Pending Requests" /></span>
						</h1>
					</div>
				</div>
			</div>
			<br />
			<c:if test="${empty relations}">
				<div class="account-section-content col-md-6 col-md-push-3 content-empty">
					<account:relationshipPoa isPoaCase="${isPoaCase}" messageKey="text.account.no.pendingRequests" poaMessageKey="text.account.no.pendingRequests.poa" poaArguments="${poaProvider.firstName}" />
				</div>
			</c:if>
		</div>
		<div class="row">
			<c:forEach items="${relations}" var="relation">
				<c:if test="${(relation.status eq 'PENDING' || relation.status eq 'ACTIVE') and relation.pendingGivenPermissionsToCurrentUser}">
					<div class="col-xs-12 col-md-6">
						<div class="card-permission-blue">
							<c:set var="giverUserName" value="${relation.givenPermissionsToCurrentUser[0].sourceUser.firstName} ${relation.givenPermissionsToCurrentUser[0].sourceUser.lastName}" />
							<div class="card-heading" tabindex="0">
								<account:relationshipPoa isPoaCase="${isPoaCase}" messageKey="text.account.pending.given.permissions" arguments="${giverUserName}" poaMessageKey="text.account.pending.given.permissions.poa" poaArguments="${giverUserName}, ${poaProvider.firstName}" />
							</div>
							<div class="card-content">
								<div class="card-content-subtitle" tabindex="0">
									<account:relationshipPoa isPoaCase="${isPoaCase}" messageKey="text.account.pending.request.given.permissions.description" arguments="${giverUserName}" poaMessageKey="text.account.pending.request.given.permissions.description.poa" poaArguments="${giverUserName}, ${poaProvider.firstName}" />
								</div>
								<div class="card-content-permissions row">
									<c:forEach items="${permissibleItems}" var="permissibleItem">
										<div class="col-xs-12 col-sm-6 col-md-6" tabindex="0">
											<div class="permissible-Items">
												<spring:theme code="text.account.pending.request.no.access.to" var="givenAriaLabel" />
												<c:set var="isGivenPermissibleClass" value="glyphicon-remove" />
												<c:set var="isGivenNew" value="false" />
												<c:forEach items="${relation.givenPermissionsToCurrentUser}" var="permission">
													<c:if test="${relation.status eq 'ACTIVE' and permissibleItem.shareableType eq permission.permissibleAreaItem.shareableType and permission.status eq 'PENDING'}">
														<c:set var="isGivenNew" value="true" />
													</c:if>
													<c:if test="${permissibleItem.shareableType eq permission.permissibleAreaItem.shareableType and (permission.status eq 'PENDING' or permission.status eq 'ACTIVE')}">
														<c:set var="isGivenPermissibleClass" value="glyphicon-ok" />
														<spring:theme code="text.account.pending.request.access.to" var="givenAriaLabel" />
													</c:if>
												</c:forEach>
												<c:if test="${empty permissibleItem.shareableType}">
													<c:set var="isGivenPermissibleClass" value="glyphicon-ok" />
													<spring:theme code="text.account.pending.request.access.to" var="givenAriaLabel" />
												</c:if>
												<span class="card-icon-permissions glyphicon ${isGivenPermissibleClass}" aria-label="${givenAriaLabel}"></span> ${ycommerce:encodeHTML(permissibleItem.id)} ${ycommerce:encodeHTML(permissibleItem.displayName)}
												<c:if test="${isGivenNew}">
													<span class="new-tag"> <spring:theme code="text.account.pending.request.new" /></span>
												</c:if>
											</div>
										</div>
									</c:forEach>
								</div>
								<div tabindex="0">
									<account:relationshipPoa isPoaCase="${isPoaCase}" messageKey="text.account.pending.request.default.permissions" poaMessageKey="text.account.pending.request.default.permissions.poa" />
								</div>
								<div class="card-link-permissions row">
									<div class="col-xs-12 col-sm-12 no-space">
										<spring:theme code="text.account.overlay.title.view.details" var="viewDetailsTitle" />
										<a href="#" class="viewPendingRequest" data-relationid="${relation.id}" data-isgiven="true" data-title="${viewDetailsTitle}"> <span class="glyphicon glyphicon-eye-open view-icon"></span> <span><spring:theme code="text.account.pending.request.view.details" /></span>
										</a>
									</div>
								</div>
								<form class="givenPendingRequestForm_${ycommerce:encodeHTML(relation.id)}" action="${updatePendingRequstUrl}" method="POST">
									<input name="relationId" value="${ycommerce:encodeHTML(relation.id)}" type="hidden" />
									<input name="isGiven" value="true" type="hidden" />
									<input name="url" value="${backButtonUrl}" type="hidden" />
									<spring:theme code="text.account.pending.request.given.permission.accept.altext" var="givenAcceptAriaLabel" />
									<spring:theme code="text.account.pending.request.permission.reject.altext" var="givenRejectAriaLabel" />
									<div class="card-button-permissions row">
										<div class="col-xs-12 col-sm-6">
											<button id="givenReject" name="requestParam" type="submit" value="Reject" aria-label="${givenRejectAriaLabel}" class="btn btn-grey btn-block">
												<spring:theme code="text.account.pending.request.reject" />
											</button>
										</div>
										<div class="col-xs-12 col-sm-6">
											<button id="givenAccept" name="requestParam" type="submit" value="Accept" aria-label="${givenAcceptAriaLabel}" class="btn btn-primary btn-block">
												<spring:theme code="text.account.pending.request.accept" />
											</button>
											<div class="card-button-desc" tabindex="0">
												<account:relationshipPoa isPoaCase="${isPoaCase}" messageKey="text.account.pending.request.given.permissions.accept.description" poaMessageKey="text.account.pending.request.given.permissions.accept.description.poa" poaArguments="${poaProvider.firstName}" />
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${(relation.status eq 'PENDING' || relation.status eq 'ACTIVE') and relation.pendingRequestedPermissionsFromCurrentUser}">
					<div class="col-xs-12 col-md-6">
						<div class="card-permission-yellow">
							<c:set var="requestedUserName" value="${relation.requestedPermissionsFromCurrentUser[0].targetUser.firstName} ${relation.requestedPermissionsFromCurrentUser[0].targetUser.lastName}" />
							<div class="card-heading" tabindex="0">
								<account:relationshipPoa isPoaCase="${isPoaCase}" messageKey="text.account.pending.request.permissions" arguments="${requestedUserName}" poaMessageKey="text.account.pending.request.permissions.poa" poaArguments="${requestedUserName}, ${poaProvider.firstName}" />
							</div>
							<div class="card-content">
								<div class="card-content-subtitle" tabindex="0">
									<account:relationshipPoa isPoaCase="${isPoaCase}" messageKey="text.account.pending.request.permissions.description" arguments="${requestedUserName}" poaMessageKey="text.account.pending.request.permissions.description.poa" poaArguments="${requestedUserName}, ${poaProvider.firstName}" />
								</div>
								<div class="card-content-permissions row">
									<c:forEach items="${permissibleItems}" var="permissibleItem">
										<div class="col-xs-12 col-sm-6 cold-md-6" tabindex="0">
											<div class="permissible-Items">
												<spring:theme code="text.account.pending.request.no.access.to" var="requestAriaLabel" />
												<c:set var="isRequestPermissibleClass" value="glyphicon-remove" />
												<c:set var="isRequestNew" value="false" />
												<c:forEach items="${relation.requestedPermissionsFromCurrentUser}" var="permission">
													<c:if test="${relation.status eq 'ACTIVE' and permissibleItem.shareableType eq permission.permissibleAreaItem.shareableType and permission.status eq 'PENDING'}">
														<c:set var="isRequestNew" value="true" />
													</c:if>
													<c:if test="${permissibleItem.shareableType eq permission.permissibleAreaItem.shareableType and (permission.status eq 'PENDING' or  permission.status eq 'ACTIVE')}">
														<c:set var="isRequestPermissibleClass" value="glyphicon-ok" />
														<spring:theme code="text.account.pending.request.access.to" var="requestAriaLabel" />
													</c:if>
												</c:forEach>
												<c:if test="${empty permissibleItem.shareableType}">
													<c:set var="isRequestPermissibleClass" value="glyphicon-ok" />
													<spring:theme code="text.account.pending.request.access.to" var="requestAriaLabel" />
												</c:if>
												<span class="card-icon-permissions glyphicon ${isRequestPermissibleClass}" aria-label="${requestAriaLabel}"></span> ${ycommerce:encodeHTML(permissibleItem.id)} ${ycommerce:encodeHTML(permissibleItem.displayName)}
												<c:if test="${isRequestNew}">
													<span class="new-tag"> <spring:theme code="text.account.pending.request.new" />
													</span>
												</c:if>
											</div>
										</div>
									</c:forEach>
								</div>
								<div tabindex="0">
									<account:relationshipPoa isPoaCase="${isPoaCase}" messageKey="text.account.pending.request.default.permissions" poaMessageKey="text.account.pending.request.default.permissions.poa" />
								</div>
								<div class="card-link-permissions row">
									<div class="col-xs-12 col-sm-12 no-space">
										<spring:theme code="text.account.overlay.title.edit.permissions" var="editPermissionsTitle" />
										<a href="#" class="editPendingRequest" data-relationid="${ycommerce:encodeHTML(relation.id)}" data-isgiven="false" data-title="${editPermissionsTitle}"> <span class="glyphicon glyphicon-eye-open view-icon"></span> <span class="glyphicon glyphicon-edit edit-icon"></span> <span><spring:theme code="text.account.pending.request.view.and.edit.permissions" /></span>
										</a>
									</div>
								</div>
								<form class="requestedPendingRequestForm_${ycommerce:encodeHTML(relation.id)}" action="${updatePendingRequstUrl}" method="POST">
									<input name="relationId" value="${ycommerce:encodeHTML(relation.id)}" type="hidden" />
									<input name="isGiven" value="false" type="hidden" />
									<input name="url" value="${backButtonUrl}" type="hidden" />
									<spring:theme code="text.account.pending.request.permission.accept.altext" var="requestAcceptAriaLabel" />
									<spring:theme code="text.account.pending.request.permission.reject.altext" var="requestRejectAriaLabel" />
									<div class="card-button-permissions row">
										<div class="col-xs-12 col-sm-6">
											<button id="requestReject" name="requestParam" type="submit" value="Reject" aria-label="${requestRejectAriaLabel}" class="btn btn-grey btn-block">
												<spring:theme code="text.account.pending.request.reject" />
											</button>
										</div>
										<div class="col-xs-12 col-sm-6">
											<button id="requestAccept" name="requestParam" type="submit" value="Accept" aria-label="${requestAcceptAriaLabel}" class="btn btn-primary btn-block">
												<spring:theme code="text.account.pending.request.accept" />
											</button>
											<div class="card-button-desc" tabindex="0">
												<account:relationshipPoa isPoaCase="${isPoaCase}" messageKey="text.account.pending.request.permissions.accept.description" arguments="${requestedUserName}" poaMessageKey="text.account.pending.request.permissions.accept.description.poa" poaArguments="${poaProvider.firstName}" />
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${relation.status eq 'PENDING' and not relation.pendingGivenPermissionsToCurrentUser and not relation.pendingRequestedPermissionsFromCurrentUser}">
					<div class="col-xs-12 col-md-6">
						<div class="card-permission-yellow">
							<c:set var="requestedUserName" value="${relation.sourceUser.firstName} ${relation.sourceUser.lastName}" />
							<div class="card-heading" tabindex="0">
								<spring:theme code="text.account.pending.request.permissions" arguments="${requestedUserName}" />
							</div>
							<div class="card-content">
								<div class="card-content-subtitle" tabindex="0">
									<spring:theme code="text.account.pending.request.permissions.description" arguments="${requestedUserName}" htmlEscape="false" var="pendingRequestPermissions" />
								    ${ycommerce:sanitizeHTML(pendingRequestPermissions)}
								</div>
								<div class="card-content-permissions row">
									<c:forEach items="${permissibleItems}" var="permissibleItem">
										<div class="col-xs-12 col-sm-6 cold-md-6" tabindex="0">
											<div>
												<spring:theme code="text.account.pending.request.no.access.to" var="requestAriaLabel" />
												<c:set var="isRequestPermissibleClass" value="glyphicon-remove" />
												<c:if test="${empty permissibleItem.shareableType}">
													<c:set var="isRequestPermissibleClass" value="glyphicon-ok" />
													<spring:theme code="text.account.pending.request.access.to" var="requestAriaLabel" />
												</c:if>
												<span class="card-icon-permissions glyphicon ${isRequestPermissibleClass}" aria-label="${requestAriaLabel}"></span> ${ycommerce:encodeHTML(permissibleItem.id)} ${ycommerce:encodeHTML(permissibleItem.displayName)}
											</div>
										</div>
									</c:forEach>
								</div>
								<div tabindex="0">
									<spring:theme code="text.account.pending.request.default.permissions" htmlEscape="false" var="defaultPermissions"/>
									${ycommerce:sanitizeHTML(defaultPermissions)}
								</div>
								<form class="requestedPendingRequestForm_${ycommerce:encodeHTML(relation.id)}" action="${updatePendingRequstUrl}" method="POST">
									<input name="relationId" value="${ycommerce:encodeHTML(relation.id)}" type="hidden" /> 
									<input name="isGiven" value="false" type="hidden" />
									<input name="url" value="${backButtonUrl}" type="hidden" />
									<spring:theme code="text.account.pending.request.permission.accept.altext" var="requestAcceptAriaLabel" />
									<spring:theme code="text.account.pending.request.permission.reject.altext" var="requestRejectAriaLabel" />
									<div class="card-button-permissions row">
										<div class="col-xs-12 col-sm-6">
											<button id="requestReject" name="requestParam" type="submit" value="Reject" aria-label="${requestRejectAriaLabel}" class="btn btn-grey btn-block">
												<spring:theme code="text.account.pending.request.reject" />
											</button>
										</div>
										<div class="col-xs-12 col-sm-6">
											<button id="requestAccept" name="requestParam" type="submit" value="Accept" aria-label="${requestAcceptAriaLabel}" class="btn btn-primary btn-block">
												<spring:theme code="text.account.pending.request.accept" />
											</button>
											<div class="card-button-desc" tabindex="0">
												<spring:theme code="text.account.pending.request.permissions.accept.description" htmlEscape="false" var="permissionsAcceptDescription"/>
												${ycommerce:sanitizeHTML(permissionsAcceptDescription)}
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>