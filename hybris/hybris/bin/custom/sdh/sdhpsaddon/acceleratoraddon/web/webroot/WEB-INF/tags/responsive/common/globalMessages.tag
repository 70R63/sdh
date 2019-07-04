<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>

<div class="container_new">
<c:if test="${(not empty accConfMsgs) || (not empty accInfoMsgs) || (not empty accErrorMsgs)}">
	<div class="global-alerts">
		<spring:theme code="text.global.alerts.accessibility" var="textGlobalAlerts" />
		<%-- Information (confirmation) messages --%>
		<c:if test="${not empty accConfMsgs}">
			<c:forEach items="${accConfMsgs}" var="msg">
			   <button class="global-alert close" aria-label="${textGlobalAlerts}" data-dismiss="alert" type="button"><span aria-label="Close">&times;</span></button>
				<div class="alert alert-info alert-dismissable">
					<span tabindex="0"><spring:theme code="${msg.code}" arguments="${msg.attributes}"/></span>
				</div>
			</c:forEach>
		</c:if>

		<%-- Warning messages --%>
		<c:if test="${not empty accInfoMsgs}">
			<c:forEach items="${accInfoMsgs}" var="msg">
			    <button class="global-alert close" aria-label="${textGlobalAlerts}" data-dismiss="alert" type="button">&times;</button>
				<div class="alert alert-warning alert-dismissable">
					<span tabindex="0"><spring:theme code="${msg.code}" arguments="${msg.attributes}"/></span>
				</div>
			</c:forEach>
		</c:if>

		<%-- Error messages (includes spring validation messages)--%>
		<c:if test="${not empty accErrorMsgs}">
			<c:forEach items="${accErrorMsgs}" var="msg">
			    <button class="global-alert close" aria-label="${textGlobalAlerts}" data-dismiss="alert" type="button"><span aria-label="Close">&times;</span></button>
				<div class="alert alert-danger alert-dismissable">
					<span tabindex="0"><spring:theme code="${msg.code}" arguments="${msg.attributes}"/></span>
				</div>
			</c:forEach>
		</c:if>

	</div>
</c:if>
</div>