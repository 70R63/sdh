<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="orderData" required="true" type="de.hybris.platform.commercefacades.order.data.AbstractOrderData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var="hasShippedItems" value="${orderData.deliveryItemsQuantity > 0}" />
<c:set var="deliveryAddress" value="${orderData.deliveryAddress}" />

<c:if test="${hasShippedItems and not empty deliveryAddress}">
	<div class="card-200 col-xs-12 col-sm-12 col-md-12">
		<div class="card-section-h2">
		<h2><span tabindex="0">
			<spring:theme code="checkout.pickup.items.to.be.shipped" text="Shipping Address" /></span></h2>
		</div>
		<div class="card-section-content" aria-labelledby="reviewPageDeliveryAddress" role="definition">
		<div id="reviewPageDeliveryAddress" tabindex="0">
			<div>${fn:escapeXml(deliveryAddress.title)}&nbsp;${fn:escapeXml(deliveryAddress.firstName)}&nbsp;${fn:escapeXml(deliveryAddress.lastName)}</div>
			<div>
				<c:if test="${ not empty deliveryAddress.line1 }">
						   ${fn:escapeXml(deliveryAddress.line1)}
					   </c:if>
				<c:if test="${ not empty deliveryAddress.line2 }">
						  ,&nbsp;${fn:escapeXml(deliveryAddress.line2)}
					   </c:if>
			</div>
			<div>
				<c:if test="${not empty deliveryAddress.town }">
							${fn:escapeXml(deliveryAddress.town)},&nbsp;
						</c:if>
				<c:if test="${ not empty deliveryAddress.region.name }">
							${fn:escapeXml(deliveryAddress.region.name)},&nbsp;
						</c:if>
				<c:if test="${ not empty deliveryAddress.postalCode }">
							${fn:escapeXml(deliveryAddress.postalCode)}
					  </c:if>
			</div>
			<div>
				<c:if test="${ not empty deliveryAddress.country.name }">
						${fn:escapeXml(deliveryAddress.country.name)}
					</c:if>
			</div>
			<div>
				<c:if test="${ not empty deliveryAddress.phone }">
						${fn:escapeXml(deliveryAddress.phone)}
					</c:if>
			</div>
		</div>
	</div></div>
</c:if>




