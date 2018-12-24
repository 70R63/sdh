<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="account" tagdir="/WEB-INF/tags/addons/relationshipaddon/responsive/account"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${not empty relationshipsAddressData}">
	<account:relationshipAddress relAddresses="${relationshipsAddressData}" />
</c:if>

<!-- if there is no address -->
<c:if test="${empty relationshipsAddressData}">
	<div class="panel-body">
		<div class="account-cards card-select">
			<div class="row">
				<div class="account-section-content col-md-6 col-md-push-3 content-empty">				
					<span tabindex="0"><strong><spring:theme code="text.relations.noaddresse.msg" arguments="${customer.firstName}" /></strong></span>
				</div>
			</div>
		</div>
	</div>
</c:if>
