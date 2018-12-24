<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData" %>
<%@ attribute name="format" required="true" type="java.lang.String" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<c:set value="${ycommerce:productImage(product, format)}" var="primaryImage"/>

<c:set value="${fn:escapeXml(product.name)}" var="productName" />

<c:choose>
	<c:when test="${not empty primaryImage}">
		<c:url value="${primaryImage.url}" var="primaryImageUrl" context="${originalContextPath}"/>
		<c:choose>
			<c:when test="${not empty primaryImage.altText}">
				<c:set value="${fn:escapeXml(primaryImage.altText)}" var="altText" />
				<img src="${fn:escapeXml(primaryImageUrl)}" alt="${altText}" title="${altText}"/>
			</c:when>
			<c:otherwise>
                <img src="${fn:escapeXml(primaryImageUrl)}" alt="${productName}" title="${productName}"/>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<theme:image code="img.missingProductImage.responsive.${format}" alt="${productName}" title="${productName}"/>
	</c:otherwise>
</c:choose>
