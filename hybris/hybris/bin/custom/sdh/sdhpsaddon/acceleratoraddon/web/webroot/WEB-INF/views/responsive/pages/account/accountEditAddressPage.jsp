<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="address" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/address"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="${source}" var="backButtonUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<div class="row no-margin global-content-space">
	<c:choose>
		<c:when test="${edit eq true }">
			<c:set var="headline">
				<spring:theme code="text.account.addressBook.updateAddress" text="Update Address" />
			</c:set>
		</c:when>
		<c:otherwise>
			<c:set var="headline">
				<spring:theme code="text.account.addressBook.addAddress" text="New Address" />
			</c:set>
		</c:otherwise>
	</c:choose>
	<div class="back-link border">
		<div class="row">
			<div class="col-md-6">
				<button type="button" class="addressBackBtn" data-back-to-addresses="${backButtonUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0">${ycommerce:encodeHTML(headline)}</span>
				</h1>
			</div>
		</div>
	</div>

	<div class="account-section-content	col-md-6">
		<div class="account-section-form">
			<p class="continuous-text">
				<spring:theme code="form.required" htmlEscape="false" />
			</p>
			<address:addressFormSelector supportedCountries="${countries}" regions="${regions}" cancelUrl="${source}" addressBook="true" />
		</div>
	</div>
</div>