<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="cartData" required="true" type="de.hybris.platform.commercefacades.order.data.CartData"%>
<%@ attribute name="showDeliveryAddress" required="true" type="java.lang.Boolean"%>
<%@ attribute name="showTax" required="false" type="java.lang.Boolean"%>
<%@ attribute name="showTaxEstimate" required="false" type="java.lang.Boolean"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/checkout/multi"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="card-200 col-xs-12 col-sm-12 col-md-12">
	<div class="card-section-h2">
	<h2><span tabindex="0">
		<spring:theme code="checkout.multi.application.totals" text="Application Totals" /></span></h2>
	</div>
	<div class="card-section-content" aria-labelledby="reviewPageCheckoutSummaryTotal" role="definition">
		<div class="row ">
			<div id="reviewPageCheckoutSummaryTotal" tabindex="0">
			<multi-checkout:deliveryCartItems cartData="${cartData}" showDeliveryAddress="${showDeliveryAddress}" />
			<multi-checkout:orderTotals cartData="${cartData}" showTaxEstimate="${showTaxEstimate}" showTax="${showTax}" />
			</div>
		</div>
	</div>
</div>
