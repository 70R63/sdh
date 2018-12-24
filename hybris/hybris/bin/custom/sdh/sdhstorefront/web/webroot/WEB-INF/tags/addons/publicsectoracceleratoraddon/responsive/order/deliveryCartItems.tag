<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="orderData" required="true" type="de.hybris.platform.commercefacades.order.data.OrderData"%>
<%@ attribute name="showDeliveryAddress" required="true" type="java.lang.Boolean"%>
<%@ attribute name="showPotentialPromotions" required="false" type="java.lang.Boolean"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="custom-format" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/common/"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var="hasShippedItems" value="${orderData.deliveryItemsQuantity > 0}" />
<c:set var="deliveryAddress" value="${orderData.deliveryAddress}" />

<c:forEach items="${orderData.entries}" var="entry">
	<c:if test="${entry.deliveryPointOfService == null && not fn:containsIgnoreCase(entry.product.code, 'none')}">

	<div class="details row">
			<c:choose>
			    <c:when test="${entry.basePrice.value > 0}">
				    <div class="name col-md-7  col-xs-6 application_label">${ycommerce:encodeHTML(entry.product.name)}</div>
					<div class="price col-md-3 col-xs-6 pull-right">
						<custom-format:price priceData="${entry.basePrice}" displayBlankForZero="true" />
					</div>
			    </c:when>
			    
			    <c:otherwise>
				    <div class="name col-md-12 col-sm-12 col-xs-12 application_label">${ycommerce:encodeHTML(entry.product.name)}</div>
			    </c:otherwise>
		    </c:choose>

			<div class="row variants">
				<c:forEach items="${entry.product.baseOptions}" var="option">
					<c:if test="${not empty option.selected and option.selected.url eq entry.product.url}">
						<c:forEach items="${option.selected.variantOptionQualifiers}" var="selectedOption">
							<div class="name col-md-7 col-xs-6 application_label">${ycommerce:encodeHTML(selectedOption.name)}</div>
							<div class="price col-md-3 col-xs-6 pull-right">${ycommerce:encodeHTML(selectedOption.value)}</div>
						</c:forEach>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</c:if>
</c:forEach>

