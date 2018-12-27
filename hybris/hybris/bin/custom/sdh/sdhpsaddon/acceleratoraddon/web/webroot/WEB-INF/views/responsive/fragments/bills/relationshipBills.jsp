<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/billaddon/responsive/user"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />
 
<spring:url value="/my-account/all-relationship-bills" var="showAllBillsUrl"></spring:url>
<div class="row no-margin content-space">
	<div class="account-section-content">
		<div class="account-section-subheader"></div>
		<c:if test="${isAccessible}">
			<c:if test="${empty results.results}">
				<div tabindex="0" class="account-section-content col-md-6 col-md-push-3 content-empty">
					<spring:theme code="text.bill.overview.relationship.noBill" arguments="${customer.firstName} ${customer.lastName}" />
				</div>
			</c:if>
			<c:if test="${not empty results.results}">
				<div class="account-billhistory">
					<spring:theme code="text.bill.overview.relationship" arguments="${customer.firstName} ${customer.lastName}" />
				</div>
				<user:bills results="${results.results}"/>
				<hr/>
				<c:if test="${results.pagination.totalNumberOfResults > results.results.size()}">
				<div class="row no-margin">
					<div class="col-md-2 col-md-push-10 divTableCell">
						<button id="show" class="btn btn-primary btn-block" onClick="window.location='${showAllBillsUrl}?customerPK=${ycommerce:encodeHTML(customer.customerPK)}'">
							<spring:theme code="text.see.all.bills" />
						</button>
					</div>
				</div>
			</c:if> 
			</c:if>
		</c:if>
	</div>
</div>