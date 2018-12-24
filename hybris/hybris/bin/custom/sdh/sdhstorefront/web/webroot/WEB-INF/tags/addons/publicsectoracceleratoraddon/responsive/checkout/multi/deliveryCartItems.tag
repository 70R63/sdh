<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="cartData" required="true" type="de.hybris.platform.commercefacades.order.data.CartData"%>
<%@ attribute name="showDeliveryAddress" required="true" type="java.lang.Boolean"%>
<%@ attribute name="showPotentialPromotions" required="false" type="java.lang.Boolean"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="custom-format" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/shared/format"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var="hasShippedItems" value="${cartData.deliveryItemsQuantity > 0}" />
<c:set var="deliveryAddress" value="${cartData.deliveryAddress}" />

<c:forEach items="${cartData.entries}" var="entry">
	<c:if test="${entry.deliveryPointOfService == null  && not fn:containsIgnoreCase(entry.product.code, 'none')}">

		<div class="row">
		    <c:choose>
			    <c:when test="${entry.basePrice.value > 0}">
				    <div class="col-md-7 col-xs-6 application_label">${ycommerce:encodeHTML(entry.product.name)}</div>
					<div class="col-md-5 col-xs-6 pull-right">
						<custom-format:price priceData="${entry.basePrice}" displayBlankForZero="true" />
					</div>
			    </c:when>
			    <c:otherwise>
				    <div class="col-md-12 col-sm-12 col-xs-12 application_label">${ycommerce:encodeHTML(entry.product.name)}</div>
			    </c:otherwise>
		    </c:choose>
			
		</div>
		<div class="row">
			<c:forEach items="${entry.product.baseOptions}" var="option">
				<c:if test="${not empty option.selected and option.selected.url eq entry.product.url}">
					<c:forEach items="${option.selected.variantOptionQualifiers}" var="selectedOption">
						<div class="col-md-7 col-xs-6 application_label">${ycommerce:encodeHTML(selectedOption.name)}:</div>
						<div class="col-md-5 col-xs-6 pull-right">${ycommerce:encodeHTML(selectedOption.value)}</div>
					</c:forEach>
				</c:if>
			</c:forEach>
		</div>
		<div class="row">
		<p>
			<c:if test="${ycommerce:doesPotentialPromotionExistForOrderEntry(cartData, entry.entryNumber) && showPotentialPromotions}">
				<c:forEach items="${cartData.potentialProductPromotions}" var="promotion">
					<c:set var="displayed" value="false" />
					<c:forEach items="${promotion.consumedEntries}" var="consumedEntry">
						<c:if test="${not displayed && consumedEntry.orderEntryNumber == entry.entryNumber}">
							<c:set var="displayed" value="true" />
							<div class="col-md-12">${ycommerce:sanitizeHTML(promotion.description)}</div>
						</c:if>
					</c:forEach>
				</c:forEach>
			</c:if>
			</p>
		</div> 
		<div class="row">
		<c:if test="${ycommerce:doesAppliedPromotionExistForOrderEntry(cartData, entry.entryNumber)}">
						<p>
							<c:forEach items="${cartData.appliedProductPromotions}" var="promotion">
								<c:set var="displayed" value="false" />
								<c:forEach items="${promotion.consumedEntries}" var="consumedEntry">
									<c:if test="${not displayed && consumedEntry.orderEntryNumber == entry.entryNumber}">
										<c:set var="displayed" value="true" />
										<div class="col-md-12">${ycommerce:sanitizeHTML(promotion.description)}</div>
									</c:if>
								</c:forEach>
							</c:forEach>
						</p>
					</c:if>
		</div>
	</c:if>
</c:forEach>
