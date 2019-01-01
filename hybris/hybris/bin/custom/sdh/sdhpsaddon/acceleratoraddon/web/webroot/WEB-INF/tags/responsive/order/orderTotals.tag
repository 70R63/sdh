<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="orderData" required="true" type="de.hybris.platform.commercefacades.order.data.OrderData"%>
<%@ attribute name="showTax" required="false" type="java.lang.Boolean"%>
<%@ attribute name="showTaxEstimate" required="false" type="java.lang.Boolean"%>
<%@ attribute name="subtotalsCssClasses" required="false" type="java.lang.String"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="custom-format" tagdir="/WEB-INF/tags/addons/sdhpsaddon/shared/format"%>
 <spring:htmlEscape defaultHtmlEscape="true" />
 
<c:set var="showDeliveryModeAsTBA" value="false" />
<c:set var="showSubtotalAsTBA" value="false" />

<div class="subtotals_ ${subtotalsCssClasses}">
	<div class="row">
		<div class="subtotal_">
			<div class="col-md-7 col-xs-6 application_label">
				<spring:theme code="basket.page.totals.subtotal" />
			</div>
			<ycommerce:testId code="Order_Totals_Subtotal">
				<c:choose>
					<c:when test="${showSubtotalAsTBA or showDeliveryModeAsTBA}">
						<div class="col-md-3 col-xs-6 pull-right">
							<spring:theme code="basket.page.totals.TBA" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-md-3 col-xs-6 pull-right">
							<format:price priceData="${orderData.subTotal}" />
						</div>
					</c:otherwise>
				</c:choose>
			</ycommerce:testId>
		</div>
	</div>
	<c:if test="${not empty orderData.deliveryMode}">
		<div class="row">
			<div class="shipping">
				<div class="col-md-7 col-xs-6 application_label">
					<spring:theme code="basket.page.totals.delivery" />
				</div>
				<ycommerce:testId code="Order_Totals_Delivery">
					<c:choose>
						<c:when test="${showDeliveryModeAsTBA}">
							<div class="col-md-3 col-xs-6 pull-right">
								<spring:theme code="basket.page.totals.TBA" />
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-md-3 col-xs-6 pull-right">
								<format:price priceData="${orderData.deliveryCost}" displayFreeForZero="TRUE" />
							</div>
						</c:otherwise>
					</c:choose>
				</ycommerce:testId>
			</div>
		</div>
	</c:if>
	<c:if test="${orderData.net && orderData.totalTax.value > 0 && showTax}">
		<div class="row">
			<div class="tax">
				<div class="col-md-7 col-xs-6 application_label">
					<spring:theme code="basket.page.totals.netTax" />
				</div>
				<c:choose>
					<c:when test="${showSubtotalAsTBA or showDeliveryModeAsTBA}">
						<div class="col-md-3 col-xs-6 pull-right">
							<spring:theme code="basket.page.totals.TBA" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-md-3 col-xs-6 pull-right">
							<format:price priceData="${orderData.totalTax}" />
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:if>
	<div class="row totals">
		<div class="col-md-7 col-xs-6 application_label">
			<spring:theme code="basket.page.totals.total" />
		</div>
		<ycommerce:testId code="cart_totalPrice_label">
			<c:choose>
				<c:when test="${showSubtotalAsTBA or showDeliveryModeAsTBA}">
					<div class="col-md-3 col-xs-6 pull-right">
						<spring:theme code="basket.page.totals.TBA" />
					</div>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${showTax}">
							<div class="col-md-3 col-xs-6 pull-right">
								<format:price priceData="${orderData.totalPriceWithTax}" />
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-md-3 col-xs-6 pull-right">
								<format:price priceData="${orderData.totalPrice}" />
							</div>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</ycommerce:testId>
	</div>
	<div class="row extra-info">
		<c:if test="${not orderData.net}">
			<div class="realTotals">
				<ycommerce:testId code="cart_taxes_label">
					<div class="col-md-12">
						<spring:theme code="basket.page.totals.grossTax" arguments="${orderData.totalTax.formattedValue}" argumentSeparator="!!!!" />
					</div>
				</ycommerce:testId>
			</div>
		</c:if>
		<c:if test="${orderData.net && not showTax }">
			<div class="realTotals">
				<ycommerce:testId code="cart_taxes_label">
					<div class="col-md-12">
						<spring:theme code="basket.page.totals.noNetTax" />
					</div>
				</ycommerce:testId>
			</div>
		</c:if>
	</div>
</div>
