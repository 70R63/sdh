<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" tagdir="/WEB-INF/tags/responsive/template/cms"%>
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic" />
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Alegreya+Sans:400,500,300">
<c:choose>
	<c:when test="${wro4jEnabled}">
<!-- 	<script>alert("con el wro4jactivado");</script> -->
		<link rel="stylesheet" type="text/css" media="all"
			href="${themeResourcePath}/css/style.css" />
		<%--  AddOn Common CSS files --%>
		<c:forEach items="${addOnCommonCssPaths}" var="addOnCommonCss">
			<link rel="stylesheet" type="text/css" media="all"
				href="${addOnCommonCss}" />
		</c:forEach>
	</c:when>
	<c:otherwise>
		<%-- Theme CSS files --%>
		<link rel="stylesheet" type="text/css" media="all"
			href="${themeResourcePath}/css/style.css" />
		<%--  AddOn Common CSS files --%>
		<c:forEach items="${addOnCommonCssPaths}" var="addOnCommonCss">
			<link rel="stylesheet" type="text/css" media="all"
				href="${addOnCommonCss}" />
		</c:forEach>
	</c:otherwise>
</c:choose>

<%--  AddOn Theme CSS files --%>
<c:forEach items="${addOnThemeCssPaths}" var="addOnThemeCss">
	<link rel="stylesheet" type="text/css" media="all"
		href="${addOnThemeCss}" />
</c:forEach>

<cms:previewCSS cmsPageRequestContextData="${cmsPageRequestContextData}" />