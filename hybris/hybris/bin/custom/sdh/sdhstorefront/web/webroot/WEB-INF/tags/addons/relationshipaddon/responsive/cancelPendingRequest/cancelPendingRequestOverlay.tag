<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="addOntemplate" tagdir="/WEB-INF/tags/addons/relationshipaddon/responsive/template"%>
<%@ attribute name="userDetails"%>
<%@ attribute name="cancelUrl"%>
<%@ attribute name="sourceUser" required="false"%>
<addOntemplate:psJavaScriptVariables />
<spring:htmlEscape defaultHtmlEscape="true" />

<div id="cancelPendingRequest" class="cancel-Pending-Request-content">
	<div class="row">
		<c:if test="${not empty sourceUser}">
			<c:choose>
				<c:when test="${relationshipData.status == 'PENDING'}">
					<spring:theme code="text.cancel.pending.request.relationship.overlay" arguments="${relationshipData.title}&nbsp;${relationshipData.firstName}&nbsp;${relationshipData.lastName}, ${sourceUser}" var="cancelPendingRequestTest" htmlEscape="false"/>
					<spring:theme code="text.cancel.pending.request.relationship.overlay.accessibility" var="cancelPendingRequestContent" arguments="${relationshipData.title}&nbsp;${relationshipData.firstName}&nbsp;${relationshipData.lastName}, ${sourceUser}" htmlEscape="false"/>
				</c:when>
				<c:otherwise>
					<spring:theme code="text.cancel.pending.request.relationship.overlay" arguments="${userDetails}, ${sourceUser}" var="cancelPendingRequestTest" htmlEscape="false"/>
					<spring:theme code="text.cancel.pending.request.relationship.overlay.accessibility" var="cancelPendingRequestContent" arguments="${userDetails}, ${sourceUser}" htmlEscape="false"/>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="${empty sourceUser}">
			<c:choose>
				<c:when test="${relationshipData.status == 'PENDING'}">
					<spring:theme code="text.cancel.pending.request.overlay" arguments="${relationshipData.title}&nbsp;${relationshipData.firstName}&nbsp;${relationshipData.lastName}" var="cancelPendingRequestTest" htmlEscape="false"/>
					<spring:theme code="text.cancel.pending.request.overlay.accessibility" var="cancelPendingRequestContent" arguments="${relationshipData.title}&nbsp;${relationshipData.firstName}&nbsp;${relationshipData.lastName}" htmlEscape="false"/>
				</c:when>
				<c:otherwise>
					<spring:theme code="text.cancel.pending.request.overlay" arguments="${userDetails}" var="cancelPendingRequestTest" htmlEscape="false"/>
					<spring:theme code="text.cancel.pending.request.overlay.accessibility" var="cancelPendingRequestContent" arguments="${userDetails}" htmlEscape="false"/>
				</c:otherwise>
			</c:choose>
		</c:if>
		<div class="col-xs-12 col-sm-12 col-md-12" tabindex="0" aria-label="${cancelPendingRequestContent}">
			<c:if test="${not empty sourceUser}">
				${cancelPendingRequestTest}
			</c:if>
			<c:if test="${empty sourceUser}">
				${cancelPendingRequestTest}
			</c:if>
		</div>

		<div class="col-xs-12 col-sm-12 col-md-12 cancel-pending-request-button">
			<div class="col-xs-12 col-sm-6 ">
				 <button type="button" class="btn btn-block btn-grey center-block pending-request-cancel"><spring:theme code="text.cancel.pending.request.overlay.dontCancel.button" /></button>
			</div>

			<div class="col-xs-12 col-sm-6 btn-space">
				 <button type="submit" onClick="window.location='${cancelUrl}'" class="center-block btn-place-order btn-block btn btn-primary"><spring:theme code="text.cancel.pending.request.overlay.yesCancel.button" /></button>
			</div>
		</div>
	</div>
</div>