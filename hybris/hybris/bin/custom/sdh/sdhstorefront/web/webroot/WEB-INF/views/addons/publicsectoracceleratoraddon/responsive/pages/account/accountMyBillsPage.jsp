<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/addons/billaddon/responsive/user"%>
<%@ taglib prefix="addOnTemplate" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/bills/all-bills" var="showAllBillsUrl"/>

<addOnTemplate:psJavaScriptVariables />

<div class="row no-margin content-space">
	<div class="account-section-content my-bill">
		<div class="account-section-header">
			<h1>
				<span tabindex="0"><spring:theme code="text.account.myBills" text="Bills" /></span>
			</h1>
		</div>
		<div class="account-section-subheader"></div>
		<c:if test="${empty bills.results}">
		     <div class="account-section-content col-md-6 col-md-push-3 content-empty">
				<span tabindex="0"><spring:theme code="text.bill.no.bills" /></span>
			</div>
			<c:if test="${not empty allRelationships}">
				<div class="row bills-relationship-text"><span tabindex="0"><spring:theme code="text.bill.overview.relationship.bill.below" /></span></div>
			</c:if>
		</c:if>
		<c:if test="${not empty bills.results}">
			<div class="account-billhistory">
				<strong><spring:theme code="text.bill.overview" /></strong>
				<c:if test="${not empty allRelationships}">
					<br />
					<br />
					<spring:theme code="text.bill.overview.relationship.bill.below" />
					<br />
				</c:if>
			</div>
			<user:bills results="${bills.results}" />
			<hr/>
			<c:if test="${bills.pagination.totalNumberOfResults > bills.results.size() }">
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

	<div class="my-bill">
		<div id="accordion" class="custom-accordion">
			<c:forEach var="currRelationship" items="${allRelationships}"  varStatus="loop">
					<div class="panel-heading">
					   <spring:theme code="text.bill.notexpanded.accessibility"  var="notExpanded" arguments="${currRelationship.firstName} ${currRelationship.lastName}" />
						<h2 class="panel-title">
							<a tabindex="0" class="accordion-toggle ui-icon-plus relationbillsLink" href="#relationbillsSection_${loop.count}" aria-expanded="false"  aria-label="${notExpanded}"aria-controls="relationbillsSection_${loop.count}"> 
							 <span class="accordian-heading">
							   <spring:theme code="text.bill.overview.relationship.header" arguments="${currRelationship.firstName} ${currRelationship.lastName}" />
							 </span>
								<input type="hidden" id="loopCount" value="${loop.count}" />
								<input type="hidden" id="hidden_${loop.count}" value="${ycommerce:encodeHTML(currRelationship.uid)}" />
							</a>
						</h2>
					</div>
					<div id="relationbillsSection_${loop.count}">
					</div>
			</c:forEach>
		</div>
	</div>
</div>