<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
 <%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
 
<c:if test="${not empty featuredLinks and not empty featuredLinks.title}">
	<h2 class="featuredLinks-heading"><span tabindex="0">${ycommerce:encodeHTML(featuredLinks.title)}</span></h2>
	<ul>
		<c:forEach items="${featuredLinks.links}" var="childlink">
			<cms:component component="${childlink}" evaluateRestriction="true" element="li" class="fus-features" />
		</c:forEach>
	</ul>
</c:if>

