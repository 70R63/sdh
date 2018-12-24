<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="address" tagdir="/WEB-INF/tags/addons/billaddon/responsive/address"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${not empty country}">
	<form:form commandName="billPaymentForm">
		<address:billingAddressFormElements regions="${regions}" country="${country}" tabindex="0" />
	</form:form>
</c:if>
