<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="isPoaCase" required="true" type="java.lang.Boolean"%>
<%@ attribute name="messageKey" required="true" type="java.lang.String"%>
<%@ attribute name="poaMessageKey" required="true" type="java.lang.String"%>
<%@ attribute name="arguments" required="false" type="java.lang.String"%>
<%@ attribute name="poaArguments" required="false" type="java.lang.String"%>
<%@ attribute name="variableName" required="false" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:choose>
    <c:when test="${not isPoaCase}">
        <c:choose>
            <c:when test="${not empty variableName}">
                <spring:theme code="${messageKey}" arguments="${arguments}" var="variable" htmlEscape="false"/>
                ${pageContext.request.setAttribute(variableName, variable)}
            </c:when>
            <c:otherwise>
                <spring:theme code="${messageKey}" arguments="${arguments}" htmlEscape="false" var="messageKey"/>
                ${ycommerce:sanitizeHTML(messageKey)}
            </c:otherwise>
	    </c:choose>
	</c:when>
	<c:otherwise>
	    <c:choose>
            <c:when test="${not empty variableName}">
                <spring:theme code="${poaMessageKey}" arguments="${poaArguments}" var="variable" htmlEscape="false"/>
                ${pageContext.request.setAttribute(variableName, variable)}
            </c:when>
            <c:otherwise>
                <spring:theme code="${poaMessageKey}" arguments="${poaArguments}" htmlEscape="false" var="poaMessageKey"/>
                ${ycommerce:sanitizeHTML(poaMessageKey)}
            </c:otherwise>
    	</c:choose>
	</c:otherwise>
</c:choose>
