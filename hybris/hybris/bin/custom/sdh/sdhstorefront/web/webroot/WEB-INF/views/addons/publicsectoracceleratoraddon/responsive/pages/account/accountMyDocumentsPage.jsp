<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="account" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/account"%>
<%@ taglib prefix="addOnTemplate" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account" var="backButtonUrl" />
<spring:url value="/my-account/my-expired-documents" var="myExpiredDocumentsUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<addOnTemplate:psJavaScriptVariables />
<div class="row no-margin content-space">
	<div class="account-section-content my-documents account-documents">
		<div class="back-link border">
			<div class="row">
				<div class="col-md-6">
					<button type="button" class="addressBackBtn" data-back-to-addresses="${backButtonUrl}">
						<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
					</button>
					<h1 class="custom-h1">
						<span class="label" tabindex="0"><spring:theme code="text.account.documents" text="Documents" /></span>
					</h1>
				</div>
			</div>
		</div>

		<c:if test="${empty documents}">
			<div class="row">
				<div class="account-section-content col-md-6 col-md-push-3 document-empty">
					<span tabindex="0"><strong><spring:theme code="text.account.myDocuments.NoDocuments" /></strong></span>
				</div>
			</div>
			<c:if test="${not empty expiredDocuments}">
				<div class="row">
					<div class="col-xs-12 col-sm-3 pull-right document-empty">
						<button type="button" class="responsive-table-link btn btn-primary pull-right" onClick="window.location='${myExpiredDocumentsUrl}'">
							<spring:theme code="text.account.viewExpiredDocuments" text="Expired Documents" />
						</button>
					</div>
				</div>
			</c:if>
		</c:if>

		<c:if test="${not empty documents}">
			<div class="account-section-subheader col-md-12">
				<div class="account-section-subheader-add pull-left">
					<h2>
						<span tabindex="0"><spring:theme code="text.account.currentDocuments" text="Current Documents" /></span>
					</h2>
				</div>
				<c:if test="${not empty expiredDocuments}">
					<div class="account-section-subheader-add pull-right hidden-xs">
						<button type="button" class="responsive-table-link btn btn-primary" onClick="window.location='${myExpiredDocumentsUrl}'">
							<spring:theme code="text.account.viewExpiredDocuments" text="Expired Documents" />
						</button>
					</div>
					<account:documents documents="${documents}" />
					<div class="account-section-header-add visible-xs">
						<button onClick="window.location='${myExpiredDocumentsUrl}'" class="responsive-table-link btn btn-primary">
							<spring:theme code="text.account.viewExpiredDocuments" text="Expired Documents" />
						</button>
					</div>
				</c:if>
				<c:if test="${empty expiredDocuments}">
					<account:documents documents="${documents}" />
				</c:if>
			</div>

		</c:if>
	</div>

	 <div class="my-documents">
		<div id="accordion" class="custom-accordion">
			 <c:forEach items="${allRelationships}" var="currRelationship" varStatus="loop">
					<div class="panel-heading">
					 <spring:theme code="text.document.notexpanded.accessibility" var="notExpanded" arguments="${currRelationship.firstName} ${currRelationship.lastName}" htmlEscape="false"/>
						<h2 class="panel-title">
							<a tabindex="0" class="accordion-toggle ui-icon-plus relationDocumentsLink" aria-expanded="false" aria-label="${notExpanded}" href="#relationdocumentsSection_${loop.count}" aria-controls="relationdocumentsSection_${loop.count}"> 
								 <span class="accordian-heading">
									<spring:theme code="text.document.overview.relationship.header" arguments="${currRelationship.firstName} ${currRelationship.lastName}" />
								</span>
								<input type="hidden" id="loopCount" value="${loop.count}" />
								<input type="hidden" id="hidden_${loop.count}" value="${ycommerce:encodeHTML(currRelationship.uid)}" />
							</a>
						</h2>
					 </div> 
					<div id="relationdocumentsSection_${loop.count}">
						<!-- Content Here -->
					</div>
			</c:forEach>
		</div>
	</div> 
</div>