<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="cartData" required="true" type="de.hybris.platform.commercefacades.order.data.CartData"%>
<%@ attribute name="showDeliveryAddress" required="true" type="java.lang.Boolean"%>
<%@ attribute name="showPaymentInfo" required="false" type="java.lang.Boolean"%>
<%@ attribute name="showTax" required="false" type="java.lang.Boolean"%>
<%@ attribute name="showTaxEstimate" required="false" type="java.lang.Boolean"%>
<%@ attribute name="showApplyButton" required="false" type="java.lang.Boolean"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/checkout/multi"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row no-margin">
	<div class="card col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div class="card-section">
			<div class="card-section-h2">
				<h2><span tabindex="0"><spring:theme code="checkout.multi.application.summary" text="Application Summary" /></span></h2>
			</div>
			<div class="card-section-content checkout-order-summary">
				<div aria-labelledby="applicationSummary" tabindex="0">
				   <div id="applicationSummary">
				     <multi-checkout:deliveryCartItems cartData="${cartData}" showDeliveryAddress="${showDeliveryAddress}" />
				     <multi-checkout:orderTotals cartData="${cartData}" showTaxEstimate="${showTaxEstimate}" showTax="${showTax}" />
				     <multi-checkout:paymentInfo cartData="${cartData}" paymentInfo="${cartData.paymentInfo}" showPaymentInfo="${showPaymentInfo}" />
				   </div>
			    </div>
			<c:if test="${showApplyButton}">
			<p></p>
				<div class="row">
					<button id="applyButton" type="button"
						class="btn btn-primary btn-block">
						${ycommerce:encodeHTML(productAddToCartText)}
						<c:if test="${empty productAddToCartText}">
							<spring:theme code="checkout.summary.applyOnline"
								text="Apply Online" />
						</c:if>
					</button>
				</div>
			</c:if>	
			</div>
		</div>
	</div>
</div>