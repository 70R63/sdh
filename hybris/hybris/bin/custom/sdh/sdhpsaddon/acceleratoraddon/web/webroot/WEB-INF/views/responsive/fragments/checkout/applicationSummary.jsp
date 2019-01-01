<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/checkout/multi"%>

<multi-checkout:deliveryCartItems cartData="${cartData}" showDeliveryAddress="false" />
<multi-checkout:orderTotals cartData="${cartData}" showTaxEstimate="true" showTax="true" />
