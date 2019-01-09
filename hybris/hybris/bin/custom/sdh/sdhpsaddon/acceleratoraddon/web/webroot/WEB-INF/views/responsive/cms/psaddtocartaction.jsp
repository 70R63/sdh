<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
 <spring:htmlEscape defaultHtmlEscape="true" />
 
<c:if test="${not empty serviceProduct.allYFormDefinitionList }">
	<c:url value="${url}" var="addToCartUrl" />
	<form:form method="post" class="add_to_cart_form span-5" action="${addToCartUrl}">
		<input type="hidden" name="qty" class="qty" value="1" />
		<input type="hidden" name="productCodePost" value="${product.code}" />
		<c:set var="showAddToCart" value="${true}" scope="session" />
		<c:if test="${empty showAddToCart ? true : showAddToCart}">
			<c:set var="ariaValueForApplyOnlineButton">
				<spring:theme code="product.grid.applyonline.label" text="" arguments="${product.addToCartLabelText}, ${product.name}" />
			</c:set>
			<button type="submit" aria-label="${ariaValueForApplyOnlineButton}" class="btn btn-primary btn-block js-add-to-cart js-enable-btn button" disabled="disabled"><span class="plp-btn">${ycommerce:encodeHTML(serviceProduct.addToCartLabelText)}</span></button>
		</c:if>
	</form:form>

</c:if>