<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="orderData" required="true" type="de.hybris.platform.commercefacades.order.data.AbstractOrderData"%>
<%@ attribute name="showDeliveryAddress" required="true" type="java.lang.Boolean"%>
<%@ attribute name="showTax" required="false" type="java.lang.Boolean"%>
<%@ attribute name="showTaxEstimate" required="false" type="java.lang.Boolean"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="order" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/order"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="card-200 col-xs-12 col-sm-12 col-md-12">
	<div class="card-section-h2">
	<h2><span tabindex="0">
		<spring:theme code="checkout.multi.application.totals" text="Application Totals" /></span></h2>
	</div>
	<div class="card-section-content">
		<div class="row ">
		  <div id="reviewPageCheckoutSummaryTotal" tabindex="0">
			<order:deliveryCartItems orderData="${orderData}" showDeliveryAddress="${showDeliveryAddress}" />
			<order:orderTotals orderData="${orderData}" showTaxEstimate="${showTaxEstimate}" showTax="${showTax}" />
		  </div>
		</div>
	</div>
</div>
