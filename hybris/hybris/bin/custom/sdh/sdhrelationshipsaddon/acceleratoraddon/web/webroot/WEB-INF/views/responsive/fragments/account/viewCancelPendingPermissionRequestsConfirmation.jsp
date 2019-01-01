<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="addOnTemplate" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/template"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<addOnTemplate:psJavaScriptVariables />
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url var="cancelPendingPermissionRequestUrl" value="/my-account/my-relationships/cancelPermissionRequests" />
<c:set var="sourceUserName" value="${sourceUserName}" />

	    <form:form action="${cancelPendingPermissionRequestUrl}" method="GET" class="pending-request-permissions">
	        <input type="hidden" id="sourceUserPK" name="sourceUserPK" value="${ycommerce:encodeHTML(sourceUserPK)}" />
	        <input type="hidden" id="targetUserPK" name="targetUserPK" value="${ycommerce:encodeHTML(targetUserPK)}" />
	        <input type="hidden" id="relationId" name="relationId" value="${ycommerce:encodeHTML(relationId)}" />
	        <input type="hidden" id="isGiven" name="isGiven" value="${isGiven}" />
	        <input type="hidden" id="isSourceUserLoggedIn" name="isSourceUserLoggedIn" value="${isSourceUserLoggedIn}" />

			<div class="modal-body view-details">
			    <c:choose>
                    <c:when test="${not isGiven}">
                        <spring:theme code="text.overlay.cancel.pending.permission.request" var="message" />
                        <c:choose>
                            <c:when test="${isSourceUserLoggedIn}">
                                <spring:theme code="text.overlay.cancel.pending.permission.request.from.accessibility" arguments="${sourceUserName}" var="accessibility" htmlEscape="false"/>
                                <spring:theme code="text.overlay.cancel.pending.permission.request.from" arguments="${sourceUserName}" var="message1" htmlEscape="false"/>
                            </c:when>
                            <c:otherwise>
                                <spring:theme code="text.overlay.cancel.pending.permission.request.from.accessibility.poa" arguments="${targetUserName}, ${sourceUserName}" var="accessibility" />
                                <spring:theme code="text.overlay.cancel.pending.permission.request.from.poa" arguments="${targetUserName}, ${sourceUserName}" var="message1" htmlEscape="false"/>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <spring:theme code="text.overlay.cancel.pending.permission.offer" var="message" />
                        <c:choose>
                            <c:when test="${isSourceUserLoggedIn}">
                                <spring:theme code="text.overlay.cancel.pending.permission.offer.to.accessibility" arguments="${targetUserName}" var="accessibility" />
                                <spring:theme code="text.overlay.cancel.pending.permission.offer.to" arguments="${targetUserName}" var="message1" htmlEscape="false"/>
                            </c:when>
                            <c:otherwise>
                                <spring:theme code="text.overlay.cancel.pending.permission.offer.to.accessibility.poa" arguments="${sourceUserName}, ${targetUserName}" var="accessibility" />
                                <spring:theme code="text.overlay.cancel.pending.permission.offer.to.poa" arguments="${sourceUserName}, ${targetUserName}" var="message1" htmlEscape="false"/>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
				<div class="card-heading" aria-label="${message}" tabindex="0">
                	${ycommerce:sanitizeHTML(message)}
                </div>

				<div class="card-heading" aria-label="${accessibility}" tabindex="0">
                    ${ycommerce:sanitizeHTML(message1)}
				</div>
				<c:forEach items="${permissions}" var="permission">
                    <div class="row no-margin">
					    <div class="card col-sm-12">
						    <div class="card-section">
							    <div class="card-section-h2">
								    <spring:theme code="text.account.pending.request.access.to" var="givenAriaLabel" />
									<div tabindex="0" aria-label="${givenAriaLabel}&nbsp;${ycommerce:encodeHTML(permission.permissibleAreaItem.displayName)}">
									    <span class="card-icon-permissions glyphicon glyphicon-ok" ></span>
										<span class="permissible-item-name">${ycommerce:encodeHTML(permission.permissibleAreaItem.displayName)}</span>
										<span class="new-tag"><spring:theme code="text.account.pending.request.new" /></span>
									</div>
								</div>
								<div class="card-section-content">
								    <div></div>
									<div></div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="modal-footer">
				<spring:theme code="text.overlay.pending.request.permission.nocancel" var="no" />
				<spring:theme code="text.overlay.pending.request.permission.yescancel" var="yes" />
				<div class="card-button-permissions row">
					<div class="col-xs-12 col-md-6">
						<button id="noCancel" name="noCancel" type="button" aria-label="${no}" class="btn btn-grey btn-block btn-no-cancel">
							${no}
						</button>
					</div>
					<div class="col-xs-12 col-md-6">
						<button id="yesCancel" name="yesCancel" type="submit" aria-label="${yes}" class="btn btn-primary btn-block">
							${yes}
						</button>
					</div>
				</div>
			</div>
		</form:form>
