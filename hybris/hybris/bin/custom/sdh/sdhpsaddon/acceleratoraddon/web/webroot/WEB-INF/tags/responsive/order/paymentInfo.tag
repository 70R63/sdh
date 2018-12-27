<%@ attribute name="orderData" required="true" type="de.hybris.platform.commercefacades.order.data.AbstractOrderData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <spring:htmlEscape defaultHtmlEscape="true" />
 
<%-- Payment Method starts --%>
<c:if test="${not empty orderData.paymentInfo}">
	<div class="card-200 col-xs-12 col-sm-12 col-md-12">
		<div class="card-section-h2">
		<h2><span tabindex="0">
			<spring:theme code="checkout.summary.paymentMethod" text="Payment:"></spring:theme></span></h2>
		</div>
		<div class="card-section-content" aria-labelledby="reviewPagePaymentDetails" role="definition">
		<div id="reviewPagePaymentDetails" tabindex="0">
			<div>
				<c:if test="${not empty orderData.paymentInfo.billingAddress}"> ${fn:escapeXml(orderData.paymentInfo.billingAddress.title)}&nbsp;${fn:escapeXml(orderData.paymentInfo.accountHolderName)}</c:if>
			</div>
			<div>${fn:escapeXml(orderData.paymentInfo.cardTypeData.name)}</div>
			<div>${fn:escapeXml(orderData.paymentInfo.cardNumber)}</div>
			<div>${orderData.paymentInfo.expiryMonth}/${orderData.paymentInfo.expiryYear}</div>

			<c:if test="${not empty orderData.paymentInfo.billingAddress}">
				<div>${fn:escapeXml(orderData.paymentInfo.billingAddress.line1)}</div>
				<div>
					<c:if test="${not empty orderData.paymentInfo.billingAddress.line2}">
							${fn:escapeXml(orderData.paymentInfo.billingAddress.line2)} 
					   </c:if>
				</div>
				<div>${fn:escapeXml(orderData.paymentInfo.billingAddress.town)}&nbsp;${fn:escapeXml(orderData.paymentInfo.billingAddress.region.name)}</div>
				<div>${fn:escapeXml(orderData.paymentInfo.billingAddress.postalCode)},${fn:escapeXml(orderData.paymentInfo.billingAddress.country.name)}</div>
			</c:if>
		</div>
	</div></div>
</c:if>
<%-- Payment Method ends --%>



