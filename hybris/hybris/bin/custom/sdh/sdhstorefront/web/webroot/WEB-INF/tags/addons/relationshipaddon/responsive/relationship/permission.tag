<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ attribute name="activePermissibleItems" required="true" type="java.lang.Object"%>
<%@ attribute name="permissions" required="false" type="java.lang.Object"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="card-permission-white-gray-border">
	<div class="card-content-permissions row">
		<c:forEach items="${activePermissibleItems}" var="permissibleItem">
			<div class="col-xs-12 col-sm-6" tabindex="0">
				<div>
					<spring:theme code="text.account.pending.request.no.access.to" var="givenAriaLabel" />
					<c:set var="isGivenPermissibleClass" value="glyphicon-remove" />
					<c:forEach items="${permissions}" var="permission">
						<c:if test="${permissibleItem.shareableType eq permission.permissibleAreaItem.shareableType }">
							<c:set var="isGivenPermissibleClass" value="glyphicon-ok" />
							<spring:theme code="text.account.pending.request.access.to" var="givenAriaLabel" />
						</c:if>
					</c:forEach>
					<c:if test="${empty permissibleItem.shareableType}">
						<c:set var="isGivenPermissibleClass" value="glyphicon-ok" />
						<spring:theme code="text.account.pending.request.access.to" var="givenAriaLabel" />
					</c:if>
					<span class="card-icon-permissions glyphicon ${isGivenPermissibleClass}" aria-label="${givenAriaLabel}"></span> ${ycommerce:encodeHTML(permissibleItem.id)} ${ycommerce:encodeHTML(permissibleItem.displayName)}
				</div>
			</div>
		</c:forEach>
	</div>
</div>