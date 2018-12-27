<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="deliveryMode" required="true" type="de.hybris.platform.commercefacades.order.data.DeliveryModeData"%>
<%@ attribute name="isSelected" required="false" type="java.lang.Boolean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <spring:htmlEscape defaultHtmlEscape="true" />
 
<%-- Delivery Method starts --%>
<c:if test="${not empty deliveryMode}">
	<div class="card-200 col-xs-12 col-sm-12 col-md-12">
		<div class="card-section-h2">
		<h2><span tabindex="0">
			<spring:theme code="checkout.summary.deliveryMethod" text="Shipping Method"></spring:theme></span></h2>
		</div>
		<div class="card-section-content" aria-labelledby="reviewPageDeliveryMethodDetails" role="definition">
		<div id="reviewPageDeliveryMethodDetails" tabindex="0">
			<div>${fn:escapeXml(deliveryMode.name)}&nbsp;-&nbsp;${fn:escapeXml(deliveryMode.description)}&nbsp;-&nbsp;${deliveryMode.deliveryCost.formattedValue}</div>
		</div>
		</div>
	</div>
</c:if>
<%-- Delivery Method ends --%>
