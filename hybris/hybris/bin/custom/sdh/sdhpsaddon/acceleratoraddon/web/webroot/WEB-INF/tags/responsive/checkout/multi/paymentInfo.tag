<%@ attribute name="cartData" required="true" type="de.hybris.platform.commercefacades.order.data.CartData"%>
<%@ attribute name="paymentInfo" required="true" type="de.hybris.platform.commercefacades.order.data.CCPaymentInfoData"%>
<%@ attribute name="showPaymentInfo" required="false" type="java.lang.Boolean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<br />
<br />
<c:if test="${not empty paymentInfo && showPaymentInfo}">
	<div class="card-section-h4">
		<h2><span tabindex="0">
		<spring:theme code="checkout.multi.payment" text="Payment:"></spring:theme></span></h2>
	</div>
	<div class="card-section-content" aria-labelledby="reviewPagePaymentDetails" role="definition">
	<div id="reviewPagePaymentDetails" tabindex="0">
		<div class="row ">
			<c:if test="${not empty paymentInfo.billingAddress}">
				<div>${fn:escapeXml(paymentInfo.billingAddress.title)}&nbsp; ${fn:escapeXml(paymentInfo.accountHolderName)}</div>
			</c:if>
			<div>${fn:escapeXml(paymentInfo.cardTypeData.name)}</div>
			<div>${fn:escapeXml(paymentInfo.cardNumber)}</div>
			<div>${paymentInfo.expiryMonth}/${paymentInfo.expiryYear}</div>
			<c:if test="${not empty paymentInfo.billingAddress}">
				<div>${fn:escapeXml(paymentInfo.billingAddress.line1)}</div>
				<c:if test="${not empty paymentInfo.billingAddress.line2}">
					<div>${fn:escapeXml(paymentInfo.billingAddress.line2)}</div>
				</c:if>
				<div>${fn:escapeXml(paymentInfo.billingAddress.town)},${fn:escapeXml(paymentInfo.billingAddress.region.name)}</div>
				<div>${fn:escapeXml(paymentInfo.billingAddress.postalCode)},${fn:escapeXml(paymentInfo.billingAddress.country.name)}</div>
			</c:if>
		</div>
	</div></div>
</c:if>


