<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/checkout/multi"%>

<multi-checkout:deliveryCartItems cartData="${cartData}" showDeliveryAddress="false" />
<multi-checkout:orderTotals cartData="${cartData}" showTaxEstimate="true" showTax="true" />
