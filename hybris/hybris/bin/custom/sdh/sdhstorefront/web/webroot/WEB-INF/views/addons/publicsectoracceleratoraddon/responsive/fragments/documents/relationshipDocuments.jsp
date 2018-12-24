<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="account" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/account"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:url value="/my-account/relationshipExpiredDocuments" var="relationshipExpiredDocumentUrl" htmlEscape="false">
	<spring:param name="customerPK" value=" ${ycommerce:encodeHTML(customer.customerPK)}" />
</spring:url>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row no-margin">
	<div class="account-section-content">
		<c:if test="${isAccessible}">
			<c:if test="${empty results}">
				<div class="row">
					<div class="account-section-content col-md-6 col-md-push-3 content-empty">
						<span tabindex="0"><spring:theme code="text.document.overview.relationship.noDocument" arguments="${customer.firstName} ${customer.lastName}" /></span>
					</div>
				</div>
				<c:if test="${not empty expiredDocuments}">
					<div class="row">
						<div class="col-xs-12 col-sm-3 pull-right document-empty">
							<button type="button" class="responsive-table-link btn btn-primary pull-right" onClick="window.location='${relationshipExpiredDocumentUrl}'">
								<spring:theme code="text.document.relationship.view.expired.documents" arguments="${customer.firstName} ${customer.lastName}" text="Relationships Expired Documents" />
							</button>
						</div>
					</div>
				</c:if>
			</c:if>
			<c:if test="${not empty results}">
				<div class="account-section-subheader col-md-12">
					<div class="account-section-subheader-add pull-left">
						<span class="document-relationship-heading" tabindex="0"> <spring:theme code="text.document.overview.relationship" arguments="${customer.firstName} ${customer.lastName}" />
						</span>
					</div>
					<c:if test="${not empty expiredDocuments}">
						<div class="account-section-subheader-add pull-right hidden-xs">
							<button type="button" class="responsive-table-link btn btn-primary" onClick="window.location='${relationshipExpiredDocumentUrl}'">
								<spring:theme code="text.document.relationship.view.expired.documents" arguments="${customer.firstName} ${customer.lastName}" text="Relationships Expired Documents" />
							</button>
						</div>
						<account:documents documents="${results}" />
						<div class="account-section-header-add visible-xs">
							<button onClick="window.location='${relationshipExpiredDocumentUrl}'" class="responsive-table-link btn btn-primary">
								<spring:theme code="text.document.relationship.view.expired.documents" arguments="${customer.firstName} ${customer.lastName}" text="Relationships Expired Documents" />
							</button>
						</div>
					</c:if>
					<c:if test="${empty expiredDocuments}">
						<account:documents documents="${results}" />
					</c:if>
				</div>
			</c:if>
		</c:if>
	</div>
</div>