<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/billaddon/responsive/user"%>
<spring:url value="/my-account/bills/all-bills/" var="showAllBillsUrl"></spring:url>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row no-margin content-space">
	<div class="account-section-content">
		<div class="account-section-header">
			<h1>
				<span tabindex="0"> <spring:theme code="text.account.myBills" text="Bills" />
				</span>
			</h1>
		</div>
		<div class="account-section-subheader"></div>
		<c:if test="${empty bills}">
			<div class="account-section-content col-md-6 col-md-push-3 content-empty">
				<spring:theme code="text.bill.no.bills" />
			</div>
		</c:if>
		<c:if test="${not empty bills}">
			<user:bills results="${bills.results}" />
			<c:if test="${bills.pagination.totalNumberOfResults > bills.result.size()}">
				<div class="row no-margin">
					<div class="col-md-2 col-md-push-10 divTableCell">
						<button id="show" class="btn btn-primary btn-block" onClick="window.location='${showAllBillsUrl}'">
							<spring:theme code="text.see.all.bills" />
						</button>
					</div>
				</div>
			</c:if>
		</c:if>
	</div>
</div>