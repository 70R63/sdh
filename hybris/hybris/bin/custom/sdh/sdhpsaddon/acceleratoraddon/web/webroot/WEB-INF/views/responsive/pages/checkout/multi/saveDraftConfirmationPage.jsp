<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<div class="checkout-success">
		<div class="checkout-success-headline">
			<span class="glyphicon glyphicon-lock"></span> Your order has been saved as draft.
			<spring:theme code="text.account.order.orderNumber" text="Order number is {0}" arguments="${orderData.code}" />
		</div>
	</div>
</div>
