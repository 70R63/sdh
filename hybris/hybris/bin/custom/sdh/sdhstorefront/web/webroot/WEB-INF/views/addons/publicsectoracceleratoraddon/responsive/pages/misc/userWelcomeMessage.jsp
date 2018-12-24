<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<sec:authorize access="!hasAnyRole('ROLE_ANONYMOUS')">
	<c:set var="maxNumberChars" value="25" />
	<c:if test="${fn:length(user.firstName) gt maxNumberChars}">
		<c:set target="${user}" property="firstName"
			value="${fn:substring(user.firstName, 0, maxNumberChars)}..." />
	</c:if>

	<span class="logged_in js-logged_in"><ycommerce:testId
			code="header_LoggedUser">
			<spring:theme code="header.welcome"
				arguments="${user.firstName},${user.lastName}" htmlEscape="true" />
		</ycommerce:testId></span>
</sec:authorize>