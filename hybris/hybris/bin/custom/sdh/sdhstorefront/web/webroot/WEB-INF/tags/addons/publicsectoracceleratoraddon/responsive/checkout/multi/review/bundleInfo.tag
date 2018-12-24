<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="bundleData" required="true" type="java.util.HashMap"%>
 <%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
 
<c:set var="isTitleAdded" value="false" />
<div class="bundle-info">
	<c:forEach items="${bundleData}" var="bundle">
		<c:if test="${isTitleAdded eq false}">
			<div class="bundle-info title">
				<p>${ycommerce:encodeHTML(bundle.value.checkoutStepLabel)}</p>
			</div>
			<c:set var="isTitleAdded" value="true" />
		</c:if>
		<div>
			<p>${ycommerce:sanitizeHTML(bundle.value.headerMessage)}</p>
		</div>
		<div>
			<p> ${ycommerce:sanitizeHTML(bundle.key.description)}</p>
		</div>
	</c:forEach>
</div>
