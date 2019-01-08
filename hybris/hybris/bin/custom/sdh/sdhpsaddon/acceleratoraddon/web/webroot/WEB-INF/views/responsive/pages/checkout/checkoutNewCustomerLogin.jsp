<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/user"%>

<c:url value="/login/checkout/register" var="registerAndCheckoutActionUrl" />
<c:if test="${registeredCheckout}" >
	<c:url value="/login/registeredcheckout/register" var="registerAndCheckoutActionUrl" />
</c:if>

<user:register actionNameKey="checkout.login.registerAndCheckout" action="${registerAndCheckoutActionUrl}" />
