<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="account" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/account"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="addOnTemplate" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<spring:url value="/my-account/my-documents" var="seeAllDocuments" />
<spring:htmlEscape defaultHtmlEscape="true" />
<addOnTemplate:psJavaScriptVariables />

<c:if test="${showDocumentDashlet}">
	<div class="grid-item">
		<h2 class="header">
			<span tabindex="0">${ycommerce:encodeHTML(component.title)}</span>
		</h2>
		<c:choose>
			<c:when test="${userDocumentsAvailable}">
				<h3 class="sub-header">
					<span tabindex="0">${ycommerce:encodeHTML(component.summary)}</span>
				</h3>
				<div class="content">
					<div class="row">
						<ul class="dashlet-list">
							<c:forEach items="${documents}" var="document" varStatus="loop">
								<li class="row dashlet-list-item">
									<div class="col-xs-12">
										<span class="title"><span tabindex="0">${ycommerce:encodeHTML(document.name)}</span></span>
									</div>
									<div class="col-xs-4 col-md-3">
										<c:if test="${not empty document.encodedThumbnail}">
											<img class="img-responsive" title=" ${ycommerce:sanitizeHTML(document.fileName)}" src="data: ${ycommerce:sanitizeHTML(document.thumbnailMimeType)};base64,${document.encodedThumbnail}" alt=" ${ycommerce:sanitizeHTML(document.name)}  ${ycommerce:sanitizeHTML(documentWord)}" width="150" height="200">
										</c:if>
										<c:if test="${empty document.encodedThumbnail}">
											<span class="no_thumbnail_img"></span>
										</c:if>
									</div>
									<div class="col-xs-8 col-md-5 col-lg-4" tabindex="0">
										<div>
											<c:if test="${not empty document.issuedOn}">
												<div class="col-xs-6 col-md-5 no-space">
													<spring:theme code="text.account.myDocuments.issuedOn" text="Issued On " />
												</div>
												<div class="col-xs-6 col-md-7 no-space">
													<fmt:formatDate value="${document.issuedOn}" dateStyle="MEDIUM" timeStyle="short" type="date" />
												</div>
											</c:if>
										</div>
										<div>
											<c:if test="${not empty document.expiresOn}">
												<div class="col-xs-6 col-md-5 no-space">
													<spring:theme code="text.account.myDocuments.expiresOn" text="Expires On " />
												</div>
												<div class="col-xs-6 col-md-7 no-space">
													<fmt:formatDate value="${document.expiresOn}" dateStyle="MEDIUM" timeStyle="short" type="date" />
												</div>
											</c:if>
										</div>
										<div>
											<c:if test="${not empty document.documentTags}">
												<div class="col-xs-6 col-md-5 no-space">
													<spring:theme code="text.account.myDocuments.tags" text="Tags" />
												</div>
												<div class="col-xs-6 col-md-7 no-space">
													<c:forEach items="${document.documentTags}" var="tags" varStatus="tagsLoop">
		                                                       ${ycommerce:encodeHTML(tags.tagName)}
		                                                        <c:if test="${!tagsLoop.last}">,</c:if>
													</c:forEach>
												</div>
											</c:if>
										</div>
										<div class="hidden-md hidden-lg dashlet-document-pdf">
											<span class="icon-file-pdf gi-2.5x"></span> <a href="my-account/${document.downloadUrl}"> <spring:theme code="text.account.dashlet.documents.downloadSummary" arguments="${document.name}, ${document.fileType}" /></a>
										</div>
									</div>
									<div class="col-md-4 col-lg-5 hidden-xs hidden-sm dashlet-document-pdf">
										<span class="icon-file-pdf gi-2.5x"></span> <a href="my-account/${document.downloadUrl}"> <spring:theme code="text.account.dashlet.documents.downloadSummary" arguments="${document.name}, ${document.fileType}" /></a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="content">
					<div class="row">
						<div class="col-xs-12">
							<c:choose>
								<c:when test="${userExpiredDocumentsAvailable}">
									<div class="row notification-box">
										<div class="col-xs-12 text-center notification-inner-box">
											<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span> <span class="notification-text" tabindex="0"><spring:theme code="text.account.dashlet.documents.expired.documents.available" /></span>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="row notification-box">
										<div class="col-xs-12 text-center notification-inner-box">
											<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span> <span class="notification-text" tabindex="0"><spring:theme code="text.account.dashlet.documents.no.user.documents" /></span>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
							<c:if test="${relationshipDocumentsAvailable}">
								<div class="row  notification-box">
									<div class="col-xs-12 text-center notification-inner-box">
										<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span> <span class="notification-text" tabindex="0"><spring:theme code="text.account.dashlet.documents.relationships.have.documents" /></span>
									</div>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		<c:if test="${isSeeAllDocsButtonVisible}">
			<div class="content">
				<div class="row">
					<div class="col-xs-12 button-box text-center">
						<button type="button" class="btn btn-grey btn-block" onClick="window.location='${seeAllDocuments}'">
							<spring:theme code="text.account.dashlet.documents.button" text="See All Documents" />
						</button>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</c:if>
