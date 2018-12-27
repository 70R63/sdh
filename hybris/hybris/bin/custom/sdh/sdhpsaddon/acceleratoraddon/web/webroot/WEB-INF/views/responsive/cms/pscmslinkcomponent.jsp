<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
 
<c:url value="${url}" var="linkUrl" />
<c:set var="title" value="${component.title}" />
<c:if test="${empty title}">
	<c:set var="title" value="${ycommerce:encodeHTML(component.linkName)}" />
</c:if>

<c:choose>
	<c:when test="${not empty component.linkName && empty url}">
		<span class="empty-nav-item">  ${ycommerce:encodeHTML(component.linkName)}</span>
	</c:when>
	<c:otherwise>
		<a href="${linkUrl}" ${component.styleAttributes} ${target}">  ${ycommerce:encodeHTML(component.linkName)} </a>
	</c:otherwise>
</c:choose>
