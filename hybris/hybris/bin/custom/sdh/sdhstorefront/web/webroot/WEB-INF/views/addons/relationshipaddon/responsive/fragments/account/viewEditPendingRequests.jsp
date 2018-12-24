<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/relationshipaddon/responsive/formElement"%>
<%@ taglib prefix="addOnTemplate" tagdir="/WEB-INF/tags/addons/relationshipaddon/responsive/template"%>
<%@ taglib prefix="account" tagdir="/WEB-INF/tags/addons/relationshipaddon/responsive/account"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<addOnTemplate:psJavaScriptVariables />
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url var="editPendingRequstUrl" value="/my-account/pending-request/edit/${ycommerce:encodeHTML(relationData.id)}" />

<c:choose>
	<c:when test="${not empty permissionForm.sourcePermissibleItemTypes}">
		<form:form id="permissionForm" name="permissionForm" class="pending-request-permissions" commandName="permissionForm" method="POST" action="${editPendingRequstUrl}">
			<form:hidden path="permissionType" />
			<form:hidden path="sourcePermissibleItemTypes" />
			<div class="modal-body view-details">
				<c:set var="giverUserName" value="${relationData.givenPermissionsToCurrentUser[0].sourceUser.firstName} ${relationData.givenPermissionsToCurrentUser[0].sourceUser.lastName}" />
				<c:set var="firstName" value="${relationData.givenPermissionsToCurrentUser[0].targetUser.firstName}" />
				<account:relationshipPoa isPoaCase="${isPoaCase}"
				    messageKey="text.account.overlay.pending.given.permissions.accessibility" arguments="${giverUserName}"
				    poaMessageKey="text.account.overlay.pending.given.permissions.accessibility.poa" poaArguments="${giverUserName}, ${firstName}"
				    variableName="pendingGivenPermission" />
				<div class="card-heading" aria-label="${pendingGivenPermission}" tabindex="0">
                    <account:relationshipPoa isPoaCase="${isPoaCase}"
                        messageKey="text.account.overlay.pending.given.permissions" arguments="${giverUserName}"
                        poaMessageKey="text.account.overlay.pending.given.permissions.poa" poaArguments="${giverUserName}, ${firstName}" />
				</div>
				<c:forEach items="${permissionForm.sourcePermissibleItemTypes}" var="permission">
					<c:forEach items="${permissibleItems}" var="permissibleItem">
						<c:if test="${not empty permissibleItem.shareableType and permissibleItem.shareableType eq permission}">
							<div class="row no-margin">
								<div class="card col-sm-12">
									<div class="card-section">
										<div class="card-section-h2">
										  <spring:theme code="text.account.pending.request.access.to" var="givenAriaLabel" />
											<div tabindex="0" aria-label="${givenAriaLabel}&nbsp;${ycommerce:encodeHTML(permissibleItem.displayName)}">
												<span class="card-icon-permissions glyphicon glyphicon-ok" ></span>
												<span class="permissible-item-name">${ycommerce:encodeHTML(permissibleItem.displayName)}</span>
											</div>
										</div>
										<div class="card-section-content">
											<div></div>
											<div></div>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</c:forEach>
				<div class="row no-margin">
				    <account:relationshipPoa isPoaCase="${isPoaCase}"
				        messageKey="text.account.overlay.pending.given.permissions.default.accessibility"
                    	poaMessageKey="text.account.overlay.pending.given.permissions.default.accessibility.poa"
                    	variableName="pendingRequestDefaultPermissionAccessibility" />
                    <div class="col-sm-12 no-space desc-text" aria-label="${pendingRequestDefaultPermissionAccessibility}" tabindex="0">
                        <account:relationshipPoa isPoaCase="${isPoaCase}"
                            messageKey="text.account.overlay.pending.given.permissions.default"
                            poaMessageKey="text.account.overlay.pending.given.permissions.default.poa" />
                    </div>
				</div>
			</div>
			<div class="modal-footer">
				<spring:theme code="text.account.pending.request.given.permission.accept.altext" var="givenAcceptAriaLabel" />
				<spring:theme code="text.account.pending.request.permission.reject.altext" var="givenRejectAriaLabel" />
				<div class="card-button-permissions row">
					<div class="col-xs-12 col-md-6">
						<button id="givenReject" name="requestParam" type="submit" value="Reject" aria-label="${givenRejectAriaLabel}" class="btn btn-grey btn-block">
							<spring:theme code="text.account.pending.request.reject" />
						</button>
					</div>
					<div class="col-xs-12 col-md-6">
						<button id="givenAccept" name="requestParam" type="submit" value="Accept" aria-label="${givenAcceptAriaLabel}" class="btn btn-primary btn-block">
							<spring:theme code="text.account.pending.request.accept" />
						</button>
                        <account:relationshipPoa isPoaCase="${isPoaCase}"
                            messageKey="text.account.pending.request.given.permissions.accept.description.accessibility"
                            poaMessageKey="text.account.pending.request.given.permissions.accept.description.accessibility.poa"
                            variableName="pendingRequestGivenPermissionsAccessibility" poaArguments="${firstName}" />
						<div class="card-button-desc" aria-label="${pendingRequestGivenPermissionsAccessibility}" tabindex="0">
                            <account:relationshipPoa isPoaCase="${isPoaCase}"
                                messageKey="text.account.pending.request.given.permissions.accept.description"
                                poaMessageKey="text.account.pending.request.given.permissions.accept.description.poa" poaArguments="${firstName}" />
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</c:when>
	<c:when test="${not empty permissionForm.targetPermissibleItemTypes}">
		<form:form id="permissionForm" name="permissionForm" class="pending-request-permissions" commandName="permissionForm" method="POST" action="${editPendingRequstUrl}">
			<form:hidden path="permissionType" />
			<div class="modal-body edit-Permission">
				<c:set var="requestedUserName" value="${relationData.requestedPermissionsFromCurrentUser[0].targetUser.firstName} ${relationData.requestedPermissionsFromCurrentUser[0].targetUser.lastName}" />
				<c:set var="firstName" value="${relationData.requestedPermissionsFromCurrentUser[0].sourceUser.firstName}" />
                <account:relationshipPoa isPoaCase="${isPoaCase}"
                    messageKey="text.account.overlay.pending.request.permissions.accessibility" arguments="${requestedUserName}"
                    poaMessageKey="text.account.overlay.pending.request.permissions.accessibility.poa" poaArguments="${requestedUserName}, ${firstName}"
                    variableName="pendingRequestPermissions" />

				<div class="card-heading" aria-label="${pendingRequestPermissions}" tabindex="0">
					<account:relationshipPoa isPoaCase="${isPoaCase}"
					    messageKey="text.account.overlay.pending.request.permissions" arguments="${requestedUserName}"
                        poaMessageKey="text.account.overlay.pending.request.permissions.poa" poaArguments="${requestedUserName}, ${firstName}" />
				</div>
				<c:forEach items="${permissionForm.targetPermissibleItemTypes}" var="permission">
					<c:forEach items="${permissibleItems}" var="permissibleItem">
						<c:if test="${not empty permissibleItem.shareableType and permissibleItem.shareableType eq permission}">
							<div class="row no-margin">
								<div class="card col-sm-12">
									<div class="card-section">
										<div class="card-section-h2">
											<div class="sourcePermission">
												<formElement:formCheckbox path="targetPermissibleItemTypes" idKey="${permissibleItem.displayName}" labelKey="${permissibleItem.displayName}" valueKey="${permissibleItem.shareableType}" tabindex="0" />
											</div>
										</div>
										<div class="card-section-content">
											<div></div>
											<div></div>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</c:forEach>
				<div class="row no-margin">
                    <account:relationshipPoa isPoaCase="${isPoaCase}"
                        messageKey="text.account.pending.request.default.permissions.accessibility"
                        poaMessageKey="text.account.pending.request.default.permissions.accessibility.poa"
                        variableName="pendingRequestDefaultPermissionAccessibility" />

					<div class="col-sm-12 no-space desc-text" aria-label="${pendingRequestDefaultPermissionAccessibility}" tabindex="0">
                        <account:relationshipPoa isPoaCase="${isPoaCase}"
                            messageKey="text.account.pending.request.default.permissions"
                            poaMessageKey="text.account.pending.request.default.permissions.poa" />
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<spring:theme code="text.account.pending.request.permission.accept.altext" var="requestAcceptAriaLabel" />
				<spring:theme code="text.account.pending.request.permission.reject.altext" var="requestRejectAriaLabel" />
				<div class="card-button-permissions row">
					<div class="col-xs-12 col-md-6">
						<button id="requestReject" name="requestParam" type="submit" value="Reject" aria-label="${requestRejectAriaLabel}" class="btn btn-grey btn-block">
							<spring:theme code="text.account.pending.request.reject" />
						</button>
					</div>
					<div class="col-xs-12 col-md-6">
						<button id="requestAccept" name="requestParam" type="submit" value="Accept" aria-label="${requestAcceptAriaLabel}" class="btn btn-primary btn-block">
							<spring:theme code="text.account.pending.request.accept" />
						</button>
                        <account:relationshipPoa isPoaCase="${isPoaCase}"
                            messageKey="text.account.pending.request.permissions.accept.description.accessibility"
                            poaMessageKey="text.account.pending.request.permissions.accept.description.accessibility.poa"
                            variableName="pendingRequestPermissionsAccessibility" />
						<div class="card-button-desc" aria-label="${pendingRequestPermissionsAccessibility}" tabindex="0">
                            <account:relationshipPoa isPoaCase="${isPoaCase}"
                                messageKey="text.account.pending.request.permissions.accept.description" arguments="${firstName}"
                                poaMessageKey="text.account.pending.request.permissions.accept.description.poa" poaArguments="${firstName}" />
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</c:when>
</c:choose>
