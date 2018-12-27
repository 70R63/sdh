<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/user"%>
<%@ taglib prefix="cancelPendingRequest" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/cancelPendingRequest"%>
<%@ taglib prefix="addOntemplate" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/template"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<spring:url value="/my-account/my-relationships" var="myRelationshipUrl" />
<spring:url value="/my-account/permissions/requestMore/" var="requestMorePermissionsUrl" />
<spring:url value="/my-account/permissions/change/" var="changePermissionsUrl" />
<spring:url value="/my-account/my-relationships/cancel-pending-relationship/" var="cancelRelationShipUrl" />
<spring:htmlEscape defaultHtmlEscape="true" />
<addOntemplate:psJavaScriptVariables />

<c:if test="${not empty message}">
	<spring:theme code="${message}" />
</c:if>
<spring:theme code="text.back.icon.accessibility" var="manageRelationshipDetailsBack" />
<spring:theme code="text.permissions.notCollapsed.accessibility" var="expandToSeeMore" />

<div class="row no-margin global-content-space relationship-details">
	<div class="back-link border">
		<div class="row">
			<div class="col-md-6">
				<button type="button" class="addressBackBtn" data-back-to-addresses="${myRelationshipUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${manageRelationshipDetailsBack}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0"><spring:theme code="text.manage.relationship.details" /></span>
				</h1>
			</div>
		</div>
	</div>
	<br />
	<div class="row no-margin">
		<div class="col-xs-12 col-md-8">
			<div class="row notification-section">
				<div class="col-xs-2 col-md-1 col-sm-2">
					<span class="glyphicon glyphicon glyphicon-user gi-2.5x"></span>
				</div>
				<div class="col-xs-10 col-md-11 col-sm-10">
					<c:choose>
						<c:when test="${relationshipData.status eq 'ACTIVE'}">
							<span>
								<h2>
									<span tabindex="0">${ycommerce:encodeHTML(targetUserTitle)}&nbsp;${ycommerce:encodeHTML(targetUserName)}</span>
								</h2> <a href="mailto:${ycommerce:encodeHTML(targetUserEmail)}?Subject=Hello%20John" target="_top">${ycommerce:encodeHTML(targetUserEmail)}</a>
							</span>
						</c:when>
						<c:otherwise>
							<span>
								<h2>
									<span tabindex="0">${ycommerce:encodeHTML(relationshipData.title)}&nbsp;${ycommerce:encodeHTML(relationshipData.firstName)}&nbsp;${ycommerce:encodeHTML(relationshipData.lastName)}</span>
								</h2> <a href="mailto:${ycommerce:encodeHTML(targetUserEmail)}?Subject=Hello%20John" target="_top">${ycommerce:encodeHTML(targetUserEmail)}</a>
							</span>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<div class="card row notification-section ">
				<div class="col-xs-2 col-md-1 col-sm-1">
					<span class="glyphicon glyphicon-info-sign gi-2.5x"></span>
				</div>
				<div class="col-xs-10 col-md-11 col-sm-11" tabindex="0">
					<div class="notification-section-title">
						<c:if test="${not empty currUserRelationship}">
							<c:if test="${user.uid eq relationshipFor.uid}">
								<user:relationshipSummaryMessage relationship="${currUserRelationship}" relationshipType="${relationshipType}" customer="${user}" sessionUser="${user}" />
							</c:if>
							<c:if test="${user.uid ne relationshipFor.uid}">
								<c:set var="relationshipCustomer" value="${relationshipFor}" />
								<user:relationshipSummaryMessageWithPoa relationship="${currUserRelationship}" relationshipType="${relationshipType}" customer="${relationshipFor}" sessionUser="${user}" />
							</c:if>
						</c:if>
					</div>
				</div>
			</div>

			<!-- collapse -->
			<div class="custom-accordion panel-default manage-relationDetail-accordion" id="accordion">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a tabindex="0" class="accordion-toggle ui-icon-plus" href="#collapseOne" aria-expanded="false" aria-label="${expandToSeeMore}"><span class="accordian-heading"> 
							      <c:choose>
										<c:when test="${isSourceUserLoggedIn}">
											<spring:theme code="text.manage.details.basic.permissions" />
										</c:when>
										<c:otherwise>
											<spring:theme code="text.manage.details..their.basic.permissions.for.eachother" />
										</c:otherwise>
									</c:choose></span> </a>
						</h3>
					</div>
					<div id="collapseOne">
						<div class="panel-body">
							<!-- starting content -->
							<div class="row permissions-content">
								<div class="col-xs-12" tabindex="0">
									<span class="glyphicon glyphicon-ok gi-1.5x"></span> <span class="permissions-content-title"><c:choose>
											<c:when test="${isSourceUserLoggedIn}">
												<spring:theme code="text.manage.details.both.have.access.to" />
											</c:when>
											<c:otherwise>
												<spring:theme code="text.manage.details.both.of.them.have.access.to" />
											</c:otherwise>
										</c:choose> </span>
								</div>
							</div>

							<div class="row permissions-content">
								<c:forEach items="${permissibleItems}" var="permissibleItem">
									<c:if test="${empty permissibleItem.shareableType}">
										<c:if test="${permissibleItem.visibleByUser eq true}">
											<div class="card">
												<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
													<strong>${ycommerce:encodeHTML(permissibleItem.displayName)}</strong>
												</div>

												<div class="col-xs-12 col-sm-8 col-md-8"></div>
											</div>
										</c:if>
									</c:if>
								</c:forEach>
								<hr />
							</div>

							<div class="row permissions-content">
								<div class="col-xs-12" tabindex="0">
									<span class="glyphicon glyphicon-remove gi-1.5x"></span> <span class="permissions-content-title"> <c:choose>
											<c:when test="${isSourceUserLoggedIn}">
												<spring:theme code="text.manage.details.Neither.have.access.to" />
											</c:when>
											<c:otherwise>
												<spring:theme code="text.manage.details.neither.of.them.have.access.to" />
											</c:otherwise>
										</c:choose>
									</span>

								</div>
							</div>
							<div class="row permissions-content">
								<div class="col-xs-12 col-sm-12" tabindex="0">
									<strong><spring:theme code="text.account.manage.details.payment.details" /></strong>
								</div>
								<div class="col-xs-12 col-sm-12" tabindex="0">
									<strong><spring:theme code="text.account.manage.details.password" /></strong>
								</div>
								<c:if test="${isTargetPoaHolder eq false  && isSourcePoaHolder eq false}">
									<c:forEach items="${permissibleItemsForNotVisibleByUser}" var="permissibleItem">
										<c:if test="${empty permissibleItem.shareableType}">

											<div class="col-xs-12 col-sm-12" tabindex="0">
												<strong>${ycommerce:encodeHTML(permissibleItem.displayName)}</strong>
											</div>
										</c:if>
									</c:forEach>
								</c:if>
							</div>
							<!-- end content -->
						</div>
					</div>

				<!-- tab 2 -->
					<div class="panel-heading">
						<h3 class="panel-title">
							<a tabindex="0" class="accordion-toggle ui-icon-plus" href="#collapseTwo" aria-expanded="false" aria-label="${expandToSeeMore}"><span class="accordian-heading"> 
							      <c:choose>
										<c:when test="${isSourceUserLoggedIn}">
											<c:choose>
												<c:when test="${relationshipData.status eq 'PENDING'}">
													<spring:theme code="text.account.manage.details.user.permissions.for" arguments="${relationshipData.firstName}" htmlEscape="false" var="userPermissionsFor"/>
												    ${ycommerce:sanitizeHTML(userPermissionsFor)}
												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when test="${isTargetPoaHolder eq false }">
															<spring:theme code="text.account.manage.details.user.permissions.for" arguments="${targetUserFirstName}" htmlEscape="false" var="userPermissionsFor"/>
				                                             ${ycommerce:sanitizeHTML(userPermissionsFor)}										
														</c:when>
														<c:otherwise>
															<spring:theme code="text.account.manage.details.your.permissions.for" arguments="${targetUserFirstName}" />
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${isTargetPoaHolder eq false  && isSourcePoaHolder eq false}">
													<c:choose>
														<c:when test="${relationshipData.status eq 'PENDING'}">
															<spring:theme code="text.account.manage.details.poa.receivers.permissions.for" arguments="${sourceUserFirstName} , ${relationshipData.firstName}" htmlEscape="false" var="poaReceiversPermissionsFor"/>
														     ${ycommerce:sanitizeHTML(poaReceiversPermissionsFor)}
														</c:when>
														<c:otherwise>
															<spring:theme code="text.account.manage.details.poa.receivers.permissions.for" arguments="${sourceUserFirstName} , ${targetUserFirstName}" htmlEscape="false" var="poaReceiversPermissionsFor"/>
														     ${ycommerce:sanitizeHTML(poaReceiversPermissionsFor)}
														</c:otherwise>
													</c:choose>
												</c:when>

												<c:otherwise>
													<c:choose>
														<c:when test="${relationshipData.status eq 'PENDING'}">
															<spring:theme code="text.account.manage.details.poa.receivers.permissions.for" arguments="${relationshipData.sourceUser.firstName} , ${relationshipData.firstName}" htmlEscape="false" var="poaReceiversPermissionsFor" />
														    ${ycommerce:sanitizeHTML(poaReceiversPermissionsFor)}
														</c:when>
														<c:otherwise>
															<spring:theme code="text.account.manage.details.poa.receivers.permissions.for" arguments="${sourceUserFirstName}, ${targetUserFirstName}" htmlEscape="false" var="poaReceiversPermissionsFor" />
														    ${ycommerce:sanitizeHTML(poaReceiversPermissionsFor)}
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose></span> </a>
						</h3>
					</div>

					<div id="collapseTwo">
						<div class="panel-body">
							<!-- starting content -->

							<!-- Pending Request Section -->
							<c:if test="${not empty pendingRequestedPermissionsForSourceUser && relationshipData.status eq 'ACTIVE'}">
								<div class="">
									<div class="col-md-12">
										<div class="card-permission-transparent">
											<div class="card-heading" tabindex="0">
												<c:choose>
													<c:when test="${isSourceUserLoggedIn}">
														<spring:theme code="text.manage.details.you.request.permission" />
													</c:when>
													<c:otherwise>
														<spring:theme code="text.manage.details.poa.request.permission" arguments="${sourceUserFirstName}" />
													</c:otherwise>
												</c:choose>
											</div>
											<div class="card-content">
												<div class="card-content-subtitle" tabindex="0">
													<c:choose>
														<c:when test="${isSourceUserLoggedIn}">
															<spring:theme code="text.manage.details.when.accept.request.permission" arguments="${targetUserFirstName}" />
														</c:when>
														<c:otherwise>
															<spring:theme code="text.manage.details.when.accept.request.permission.poa" arguments="${targetUserFirstName}, ${sourceUserFirstName}" htmlEscape="false" var="acceptRequestPermissionPoa"/>
															${ycommerce:sanitizeHTML(acceptRequestPermissionPoa)}
														</c:otherwise>
													</c:choose>

												</div>

												<div class="card-content-permissions row">
													<c:forEach items="${pendingRequestedPermissionsForSourceUser}" var="permission">
														<div class="row permissions-content">
															<div class="card">
																<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
																	<span class="card-icon-permissions glyphicon glyphicon-ok" aria-label="access to"></span><strong>${ycommerce:encodeHTML(permission.permissibleAreaItem.displayName)}</strong> <span class="new-tag"><spring:theme code="text.account.pending.request.new" /></span>
																</div>
																<div class="col-xs-12 col-sm-8 col-md-8"></div>
															</div>
														</div>

													</c:forEach>
												</div>

												<div class="card-button-permissions row">
													<div class="col-xs-12 cancel-request">
														<div class="box-action">
															<div class="text-center heading">
																<p tabindex="0">
																	<spring:theme code="permission.cancel.request.text" />
																</p>
															</div>
															<div class="col-sm-4 col-md-4 col-sm-push-4 manage-details-buttons">
																<button class="btn btn-grey btn-block btn-cancel-pending-permission-request" 
																		aria-label="<spring:theme code="permission.cancel.button.accessibility" />" 
																		data-title="<spring:theme code="text.cancel.pending.request.overlay.heading"/>" 
																		data-relationId="${ycommerce:encodeHTML(relationId)}" 
																		data-targetUserPK="${ycommerce:encodeHTML(targetUserPK)}"
																		data-sourceUserPK="${ycommerce:encodeHTML(sourceUser.customerPK)}" 
																		data-isGiven="false" 
																		data-isSourceUserLoggedIn="${isSourceUserLoggedIn}">
																	<spring:theme code="permission.cancel.button.text" />
																</button>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>

							<!-- End of Pending Request Section -->
							<!-- POA Section Between POA Holder and Receiver -->
							<!--   when poa holder is logged in  -->
							<c:choose>
								<c:when test="${isSourcePoaHolder}">
									<div class="row permissions-content">
										<div class="col-xs-12" tabindex="0">
											<span class="glyphicon glyphicon-ok gi-1.5x"></span> <span class="permissions-content-title"> <spring:theme code="text.account.manage.details.access" />
											</span>
										</div>
									</div>
									<div class="row permissions-content">
										<c:forEach items="${permissibleItems}" var="permission">
											<c:if test="${not empty permission.shareableType}">
												<div class="card">
													<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
														<strong>${ycommerce:encodeHTML(permission.displayName)}</strong>
													</div>
													<div class="col-xs-12 col-sm-8 col-md-8"></div>
												</div>
											</c:if>
										</c:forEach>
										<c:forEach items="${permissibleItemsForNotVisibleByUser}" var="permissibleItem">
											<c:if test="${empty permissibleItem.shareableType}">
												<div class="card">
													<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
														<strong>${ycommerce:encodeHTML(permissibleItem.displayName)}</strong></strong>
													</div>
													<div class="col-xs-12 col-sm-8 col-md-8"></div>
												</div>
											</c:if>
										</c:forEach>
										<hr />
									</div>
								</c:when>

								<c:when test="${isTargetPoaHolder}">
									<div class="row permissions-content">
										<div class="col-xs-12" tabindex="0">
											<span class="glyphicon glyphicon-ok gi-1.5x"></span> <span class="permissions-content-title"> <spring:theme code="text.manage.details.permissions.has.access.to" arguments="${targetUserFirstName}" />
											</span>
										</div>
									</div>

									<div class="row permissions-content">
										<c:forEach items="${permissibleItems}" var="permission">
											<c:if test="${not empty permission.shareableType}">
												<div class="card">
													<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
														<strong>${ycommerce:encodeHTML(permission.displayName)}</strong>
													</div>
													<div class="col-xs-12 col-sm-8 col-md-8"></div>
												</div>
											</c:if>
										</c:forEach>
										<c:forEach items="${permissibleItemsForNotVisibleByUser}" var="permissibleItem">
											<c:if test="${empty permissibleItem.shareableType}">
												<div class="card">
													<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
														<strong>${ycommerce:encodeHTML(permissibleItem.displayName)}</strong>
													</div>
													<div class="col-xs-12 col-sm-8 col-md-8"></div>
												</div>
											</c:if>
										</c:forEach>
										<hr />
									</div>
								</c:when>

								<c:when test="${relationshipData.status eq 'ACTIVE'}">
									<div class="row permissions-content">
										<div class="col-xs-12" tabindex="0">
											<c:choose>
												<c:when test="${isSourceUserLoggedIn}">
													<c:if test="${not empty activePermissionsForSourceUser}">
														<span class="glyphicon glyphicon-ok gi-1.5x"></span>
														<span class="permissions-content-title"></span>
														<spring:theme code="text.account.manage.details.access" arguments="${targetUserFirstName}" />
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${not empty activePermissionsForTargetUser}">
														<span class="glyphicon glyphicon-ok gi-1.5x"></span>
														<span class="permissions-content-title"></span>
														<spring:theme code="text.manage.details.permissions.has.access.to" arguments="${targetUserFirstName}" />
													</c:if>
												</c:otherwise>
											</c:choose>

										</div>
									</div>

									<c:choose>
										<c:when test="${isSourceUserLoggedIn}">
											<div class="row permissions-content">
												<c:forEach items="${activePermissionsForSourceUser}" var="permission">
													<div class="card">
														<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
															<strong>${ycommerce:encodeHTML(permission.permissibleAreaItem.displayName)}</strong>
														</div>
														<div class="col-xs-12 col-sm-8 col-md-8"></div>
													</div>
												</c:forEach>
												<hr />
											</div>
										</c:when>
										<c:otherwise>
											<div class="row permissions-content">
												<c:forEach items="${activePermissionsForTargetUser}" var="permission">
													<div class="card">
														<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
															<strong>${ycommerce:encodeHTML(permission.permissibleAreaItem.displayName)}</strong>
														</div>
														<div class="col-xs-12 col-sm-8 col-md-8"></div>
													</div>
												</c:forEach>
												<hr />
											</div>
										</c:otherwise>
									</c:choose>

									<div class="row permissions-content">
										<div class="col-xs-12" tabindex="0">

											<c:choose>
												<c:when test="${isSourceUserLoggedIn}">
													<c:if test="${not empty inactivePermissionsForSourceUser}">
														<span class="glyphicon glyphicon-remove gi-1.5x"></span>
														<span class="permissions-content-title"></span>
														<spring:theme code="text.account.manage.details.no.access" />
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${not empty inactivePermissionsForTargetUser}">
														<spring:theme code="text.manage.details.permissions.dont.have.access.to" arguments="${targetUserFirstName}" />
													</c:if>
												</c:otherwise>
											</c:choose>
										</div>
									</div>

									<c:choose>
										<c:when test="${isSourceUserLoggedIn}">
											<div class="row permissions-content">
												<c:forEach items="${inactivePermissionsForSourceUser}" var="permission">
													<div class="card">
														<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
															<strong>${ycommerce:encodeHTML(permission.displayName)}</strong>
														</div>
														<div class="col-xs-12 col-sm-8 col-md-8"></div>
													</div>
												</c:forEach>
											</div>
										</c:when>
										<c:otherwise>
											<div class="row permissions-content">
												<c:forEach items="${inactivePermissionsForTargetUser}" var="permission">
													<div class="card">
														<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
															<strong>${ycommerce:encodeHTML(permission.displayName)}</strong>
														</div>
														<div class="col-xs-12 col-sm-8 col-md-8"></div>
													</div>
												</c:forEach>
											</div>
										</c:otherwise>
									</c:choose>

									<c:if test="${not empty inactivePermissionsForSourceUser && empty pendingRequestedPermissionsForSourceUser && empty pendingNotRequestedPermissionsForSourceUser && isSourceUserLoggedIn}">
										<div class="row permissions-content">
											<div class="card">
												<div class="col-xs-12">
													<p tabindex="0" class="text-center">
														<spring:theme code="text.manage.details.more.permissions.request" />
													</p>
													<spring:theme code="text.manage.details.more.permissions.request.button.accessibility" var="morePermissionsRequest" />
													<div class="col-sm-4 col-md-4 col-sm-push-4 manage-details-buttons">
														<button aria-label="${morePermissionsRequest}" class="btn btn-primary btn-block" onClick="window.location='${requestMorePermissionsUrl}${ycommerce:encodeHTML(relationshipData.id)}'">
															<spring:theme code="text.manage.details.more.permissions.request.button" />
														</button>
													</div>
												</div>
											</div>
										</div>
									</c:if>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${relationshipData.status eq 'PENDING'}">
											<c:choose>
												<c:when test="${empty relationshipData.targetUser}">
													<div class="no-accordian" tabindex="0" aria-describedby="pendingRelationshipOne">
														<span id="pendingRelationshipOne"><spring:theme code="text.account.manage.details.pending.relationship" arguments="${relationshipData.firstName}" />
													</span></div>
												</c:when>
												<c:otherwise>
													<div class="row notification-section ">
														<div class="col-xs-2 col-md-1 col-sm-1">
															<span class="glyphicon glyphicon-exclamation-sign gi-2.5x"></span>
														</div>
														<div class="col-xs-10 col-md-11 col-sm-11" tabindex="0">
															<div class="notification-section-title">
																<spring:theme code="text.manage.details.you.request.permission" />
															</div>
														</div>
													</div>
													<br>
													<spring:theme code="text.manage.details.when.accept.requested.permission" arguments="${relationshipData.firstName}" />
													<br>

													<div class="row permissions-content">
														<c:forEach items="${pendingRequestedPermissionsForSourceUser}" var="requestedPermissions">
															<div class="card">
																<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
																	<strong>${ycommerce:encodeHTML(requestedPermissions.permissibleAreaItem.displayName)}</strong>
																</div>
																<div class="col-xs-12 col-sm-8 col-md-8"></div>
															</div>
														</c:forEach>
													</div>

												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<div class="no-accordian" tabindex="0" aria-describedby="pendingRelationshipTwo">
												<span id="pendingRelationshipTwo"><spring:theme code="text.account.manage.details.pending.relationship" arguments="${targetUserFirstName}" /></span>
											</div>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							<!-- end content -->
						</div>
					</div>

				<!-- tab 3 -->
					<div class="panel-heading">
						<h3 class="panel-title">
							<a tabindex="0" class="accordion-toggle ui-icon-plus" href="#collapseThree" aria-expanded="false" aria-label="${expandToSeeMore}">
							  <span class="accordian-heading"> <c:choose>
										<c:when test="${isSourceUserLoggedIn}">
											<c:choose>
												<c:when test="${relationshipData.status eq 'PENDING'}">
													<spring:theme code="text.account.manage.details.your.permissions.for" arguments="${relationshipData.firstName}" />
												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when test="${isTargetPoaHolder eq false }">
															<c:choose>
																<c:when test="${permissionStatus eq 'PENDING'}">
																	<spring:theme code="text.account.manage.details.user.permissions.for" arguments="${targetUserFirstName}" htmlEscape="false" var="userPermissionsFor"/>
																    ${ycommerce:sanitizeHTML(userPermissionsFor)}	
																</c:when>
																<c:otherwise>
																	<spring:theme code="text.account.manage.details.your.permissions.for" arguments="${targetUserFirstName}" />
																</c:otherwise>
															</c:choose>

														</c:when>
														<c:otherwise>
															<spring:theme code="text.account.manage.details.user.permissions.for" arguments="${targetUserFirstName}" htmlEscape="false" var="userPermissionsFor"/>
														    ${ycommerce:sanitizeHTML(userPermissionsFor)}	
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${isTargetPoaHolder eq false  && isSourcePoaHolder eq false}">
													<c:choose>
														<c:when test="${relationshipData.status eq 'PENDING'}">
															<spring:theme code="text.account.manage.details.poa.receivers.permissions.for" arguments="${relationshipData.firstName} , ${relationshipData.sourceUser.firstName}" htmlEscape="false" var="poaReceiversPermissionsFor"/>
														    ${ycommerce:sanitizeHTML(poaReceiversPermissionsFor)}
														</c:when>
														<c:otherwise>
															<spring:theme code="text.account.manage.details.poa.receivers.permissions.for" arguments="${targetUserFirstName} , ${sourceUserFirstName}" htmlEscape="false" var="poaReceiversPermissionsFor"/>
														    ${ycommerce:sanitizeHTML(poaReceiversPermissionsFor)}
														</c:otherwise>
													</c:choose>
												</c:when>

												<c:otherwise>
													<c:choose>
														<c:when test="${relationshipData.status eq 'PENDING'}">
															<spring:theme code="text.account.manage.details.poa.receivers.permissions.for" arguments="${relationshipData.firstName} , ${relationshipData.sourceUser.firstName}" htmlEscape="false" var="poaReceiversPermissionsFor"/>
														    ${ycommerce:sanitizeHTML(poaReceiversPermissionsFor)}
														</c:when>
														<c:otherwise>
															<spring:theme code="text.account.manage.details.poa.receivers.permissions.for" arguments="${targetUserFirstName}, ${sourceUserFirstName}" htmlEscape="false" var="poaReceiversPermissionsFor"/>
														   ${ycommerce:sanitizeHTML(poaReceiversPermissionsFor)}
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose></span> </a>
						</h3>
					</div>
					<div id="collapseThree">
						<div class="panel-body">
							<!-- starting content -->
							<c:choose>
								<c:when test="${isSourcePoaHolder}">
									<div class="no-accordian" tabindex="0" aria-describedby="pendingRelationshipThree">
										<span id="pendingRelationshipThree"><spring:theme code="text.account.manage.details.poa.relationship" arguments="${targetUserFirstName}" /></span>
									</div>
								</c:when>
								<c:when test="${isSourceUserLoggedIn and isTargetPoaHolder}">
									<div class="no-accordian" tabindex="0" aria-describedby="pendingRelationshipFour">
										<span id="pendingRelationshipFour"><spring:theme code="text.account.manage.details.poa.relationship.you.dont.have" /></span>
									</div>
								</c:when>
								<c:when test="${isTargetPoaHolder}">
									<div class="no-accordian" tabindex="0" aria-describedby="pendingRelationshipFive">
										<span id="pendingRelationshipFive"><spring:theme code="text.account.manage.details.poa.relationship" arguments="${sourceUserFirstName}" /></span>
									</div>
								</c:when>
								<c:when test="${empty isSourceUserLoggedIn}">
									<spring:theme code="text.account.manage.details.poa.relationship" arguments="${targetUserFirstName}" />
								</c:when>
								<c:when test="${relationshipData.status eq 'ACTIVE'}">
									<c:if test="${not empty pendingNotRequestedPermissionsForTargetUser}">
										<div class="">
											<div class="col-md-12">
												<div class="card-permission-transparent">
													<div class="card-heading" tabindex="0">
														<c:choose>
															<c:when test="${isSourceUserLoggedIn}">
																<spring:theme code="text.manage.details.you.offer.permission" />
															</c:when>
															<c:otherwise>
																<spring:theme code="text.manage.details.poa.offer.permission" arguments="${sourceUserFirstName}" />
															</c:otherwise>
														</c:choose>
													</div>
													<div class="card-content">
														<div class="card-content-subtitle" tabindex="0">
															<c:choose>
																<c:when test="${isSourceUserLoggedIn}">
																	<spring:theme code="text.manage.details.when.accept.offer.permission" arguments="${targetUserFirstName}" />
																</c:when>
																<c:otherwise>
																	<spring:theme code="text.manage.details.when.accept.offer.permission.poa" arguments="${targetUserFirstName}, ${sourceUserFirstName}" htmlEscape="false" var="acceptOfferPermissionPoa" />
	                                                                ${ycommerce:sanitizeHTML(acceptOfferPermissionPoa)}															
																</c:otherwise>
															</c:choose>
														</div>

														<div class="card-content-permissions row">
															<c:forEach items="${pendingNotRequestedPermissionsForTargetUser}" var="permission">
																<div class="row permissions-content">
																	<div class="card">
																		<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
																			<span class="card-icon-permissions glyphicon glyphicon-ok" aria-label="access to"></span><strong>${ycommerce:encodeHTML(permission.permissibleAreaItem.displayName)}</strong> <span class="new-tag"><spring:theme code="text.account.pending.request.new" /></span>
																		</div>
																		<div class="col-xs-12 col-sm-8 col-md-8"></div>
																	</div>
																</div>
															</c:forEach>
														</div>

														<div class="card-button-permissions row">
															<div class="col-xs-12 cancel-request">
																<div class="box-action">
																	<div class="text-center heading">
																		<p tabindex="0">
																			<spring:theme code="permission.cancel.request.text" />
																		</p>
																	</div>
																	<div class="col-sm-4 col-md-4 col-sm-push-4 manage-details-buttons">
																		<button class="btn btn-grey btn-block btn-cancel-pending-permission-request" 
																				aria-label="<spring:theme code="permission.cancel.button.accessibility" />" 
																				data-title="<spring:theme code="text.overlay.cancel.pending.permission.request.title"/>" 
																				data-relationId="${ycommerce:encodeHTML(relationId)}" 
																				data-targetUserPK="${ycommerce:encodeHTML(targetUserPK)}"
																				data-sourceUserPK="${ycommerce:encodeHTML(sourceUser.customerPK)}" 
																				data-isGiven="true" 
																				data-isSourceUserLoggedIn="${isSourceUserLoggedIn}">
																			<spring:theme code="permission.cancel.button.text" />
																		</button>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:if>

									<div class="row permissions-content">
										<div class="col-xs-12" tabindex="0">
											<c:choose>
												<c:when test="${isSourceUserLoggedIn}">
													<c:if test="${not empty activePermissionsForTargetUser}">
														<span class="glyphicon glyphicon-ok gi-1.5x"></span>
														<span class="permissions-content-title"> <spring:theme code="text.manage.details.permissions.have.access.to" arguments="${targetUserFirstName}" />
														</span>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${not empty activePermissionsForSourceUser}">
														<span class="glyphicon glyphicon-ok gi-1.5x"></span>
														<span class="permissions-content-title"> <spring:theme code="text.manage.details.permissions.have.access.to" arguments="${sourceUserFirstName}" />
														</span>
													</c:if>
												</c:otherwise>
											</c:choose>
										</div>
									</div>

									<c:choose>
										<c:when test="${isSourceUserLoggedIn}">
											<div class="row permissions-content">
												<c:forEach items="${activePermissionsForTargetUser}" var="permission">
													<div class="card">
														<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
															<strong>${ycommerce:encodeHTML(permission.permissibleAreaItem.displayName)}</strong>
														</div>
														<div class="col-xs-12 col-sm-8 col-md-8"></div>
													</div>
												</c:forEach>
												<hr />
											</div>
										</c:when>
										<c:otherwise>
											<div class="row permissions-content">
												<c:forEach items="${activePermissionsForSourceUser}" var="permission">
													<div class="card">
														<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
															<strong>${ycommerce:encodeHTML(permission.permissibleAreaItem.displayName)}</strong>
														</div>
														<div class="col-xs-12 col-sm-8 col-md-8"></div>
													</div>
												</c:forEach>
												<hr />
											</div>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${isSourceUserLoggedIn}">
											<c:if test="${not empty inactivePermissionsForTargetUser }">
												<div class="row permissions-content">
													<div class="col-xs-12" tabindex="0">
														<span class="glyphicon glyphicon-remove gi-1.5x"></span> <span class="permissions-content-title"> <spring:theme code="text.manage.details.permissions.dont.have.access.to" arguments="${targetUserFirstName}" />
														</span>
													</div>
												</div>
											</c:if>
										</c:when>
										<c:otherwise>
											<c:if test="${not empty inactivePermissionsForSourceUser }">
												<div class="row permissions-content">
													<div class="col-xs-12" tabindex="0">
														<span class="glyphicon glyphicon-remove gi-1.5x"></span> <span class="permissions-content-title"> <spring:theme code="text.manage.details.permissions.dont.have.access.to" arguments="${sourceUserFirstName}" />
														</span>
													</div>
												</div>
											</c:if>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${isSourceUserLoggedIn}">
											<c:forEach items="${inactivePermissionsForTargetUser}" var="permission">
												<div class="row permissions-content">
													<div class="card">
														<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
															<strong>${ycommerce:encodeHTML(permission.displayName)}</strong>
														</div>
														<div class="col-xs-12 col-sm-8 col-md-8"></div>
													</div>
												</div>
											</c:forEach>
										</c:when>

										<c:otherwise>
											<c:forEach items="${inactivePermissionsForSourceUser}" var="permission">
												<div class="row permissions-content">
													<div class="card">
														<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
															<strong>${ycommerce:encodeHTML(permission.displayName)}</strong>
														</div>
														<div class="col-xs-12 col-sm-8 col-md-8"></div>
													</div>
												</div>
											</c:forEach>
										</c:otherwise>
									</c:choose>

									<c:if test="${empty pendingNotRequestedPermissionsForTargetUser and empty pendingRequestedPermissionsForTargetUser and isSourceUserLoggedIn}">
										<div class="row permissions-content">
											<div class="card">
												<div class="col-xs-12">
													<p tabindex="0" class="text-center">
														<spring:theme code="text.manage.details.change.permissions.relationships" />
													</p>
													<spring:theme code="text.manage.details.change.permissions.relationships.button" var="changePermissionsRelations" />
													<div class="col-sm-4 col-md-4 col-sm-push-4 manage-details-buttons">
														<button aria-label="${changePermissionsRelations}" class="btn btn-primary btn-block" onClick="window.location='${changePermissionsUrl}${ycommerce:encodeHTML(relationshipData.id)}'">
															<spring:theme code="text.manage.details.change.permissions.relationships.button" />
														</button>
													</div>
												</div>
											</div>
										</div>
									</c:if>
								</c:when>
								<c:otherwise>

									<c:choose>
										<c:when test="${relationshipData.status eq 'PENDING'}">
											<c:choose>
												<c:when test="${empty relationshipData.targetUser}">
													<div class="no-accordian" tabindex="0" aria-describedby="pendingRelationshipSix">
														<span id="pendingRelationshipSix"><spring:theme code="text.account.manage.details.pending.relationship" arguments="${relationshipData.firstName}" /></span>
													</div>
												</c:when>
												<c:otherwise>
													<div class="row notification-section ">
														<div class="col-xs-2 col-md-1 col-sm-1">
															<span class="glyphicon glyphicon-exclamation-sign gi-2.5x"></span>
														</div>
														<div class="col-xs-10 col-md-11 col-sm-11" tabindex="0">
															<div class="notification-section-title">
																<spring:theme code="permission.you.given.permission" />
															</div>
														</div>
													</div>
													<br>
													<spring:theme code="text.manage.details.when.accept.given.permission" arguments="${relationshipData.firstName}" />
													<br>

													<div class="row permissions-content">
														<c:forEach items="${pendingNotRequestedPermissionsForTargetUser}" var="givenPermissions">
															<div class="card">
																<div class="col-xs-12 col-sm-4 col-md-4" tabindex="0">
																	<strong>${ycommerce:encodeHTML(givenPermissions.permissibleAreaItem.displayName)}</strong>
																</div>
																<div class="col-xs-12 col-sm-8 col-md-8"></div>
															</div>
														</c:forEach>
													</div>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<div class="no-accordian" tabindex="0" aria-describedby="pendingRelationshipSeven">
												<span id="pendingRelationshipSeven"><spring:theme code="text.account.manage.details.pending.relationship" arguments="${targetUserFirstName}" /></span>
											</div>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							<!-- end content -->
						</div>
					</div>
				<!-- end tab 3-->

				<c:choose>
					<c:when test="${isSourcePoaHolder}">
						<br>
						<hr>
						<br>
						<div class="col-xs-12" tabindex="0">
							<spring:theme code="text.manage.details.poa.no.button.source" arguments="${targetUserFirstName}" />
						</div>
					</c:when>
					<c:when test="${isTargetPoaHolder}">
						<br>
						<hr>
						<br>
						<div class="col-xs-12" tabindex="0">
							<spring:theme code="text.manage.details.poa.no.button.target" arguments="${targetUserFirstName}" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="card row notification-section cancel-request">
							<c:choose>
								<c:when test="${relationshipData.status eq 'PENDING'}">
									<div class="col-xs-12">
										<p tabindex="0" class="text-center">
											<spring:theme code="text.manage.details.not.the.right.set.of.permissions" />
										</p>
										<spring:theme code="text.manage.details.cancel.relationship.request" var="CancelRelationship" />
										<div class="col-sm-5 col-md-5 col-sm-push-4">
											<button aria-label="${CancelRelationship}" class="cancel-pending-request btn btn-primary btn-block">
												<spring:theme code="text.manage.details.cancel.relationship.request" />
											</button>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="col-xs-12">
										<p tabindex="0" class="text-center">
											<spring:theme code="text.manage.details.remove.permissions" arguments="${targetUserFirstName}" />
										</p>
										<spring:theme code="text.manage.details.remove.permissions.button.accessibility" var="removeRelationship" />
										<div class="col-sm-4 col-md-4 col-sm-push-4">
											<button aria-label="${removeRelationship}" class="btn btn-primary btn-block">
												<spring:theme code="text.manage.details.remove.permissions.button" />
											</button>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
							<div class="hide">
								<div class="headline">
									<span class="headline-text cancel-pending-request-heading"><h1>
											<span tabindex="0"> <spring:theme code="text.cancel.pending.request.overlay.heading" /></span>
										</h1></span>
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			
			
			
		</div>
	</div>
	<cancelPendingRequest:cancelPendingRequestOverlay sourceUser="${relationshipCustomer.firstName}" userDetails="${targetUserTitle}&nbsp;${targetUserName}" cancelUrl="${cancelRelationShipUrl}${ycommerce:encodeHTML(relationshipData.id)}" />
</div>
