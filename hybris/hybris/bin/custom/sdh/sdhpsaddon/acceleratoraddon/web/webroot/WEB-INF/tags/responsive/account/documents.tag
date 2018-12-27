<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="documents" required="true" type="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
 
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:theme code="text.account.document" var="documentWord"  />
<spring:url value="/my-account/" var="myAccountUrl" />

<div class="account-list">
	<ul class="account-cards card-select">
		<c:forEach items="${documents}" var="document" varStatus="loop">
			<li class="col-xs-12 col-sm-6 col-md-4">
				<div class="card-350">
					<div class="col-md-12">
						<div class="account-section-subheader"><h3><span tabindex="0">${ycommerce:encodeHTML(document.name)}</span></h3></div>
						<hr />
					</div>
					<div class="col-xs-6">
						<c:if test="${not empty document.encodedThumbnail}">
							<img class="img-responsive" title=" ${ycommerce:sanitizeHTML(document.fileName)}" src="data: ${ycommerce:sanitizeHTML(document.thumbnailMimeType)};base64,${document.encodedThumbnail}" alt=" ${ycommerce:sanitizeHTML(document.name)}  ${ycommerce:sanitizeHTML(documentWord)}" width="150" height="200">
						</c:if>
						<c:if test="${empty document.encodedThumbnail}">
							<span class="no_thumbnail_img"></span>
						</c:if>
					</div>
					<div class="col-xs-6">
						<ul>
							<li>
								<c:if test="${not empty document.issuedOn }">
									<spring:theme code="text.account.myDocuments.issuedOn" text="Issued On " />
									<fmt:formatDate value="${document.issuedOn}" dateStyle="MEDIUM" timeStyle="short" type="date" />
								</c:if>
							</li>
							<li>
								<c:if test="${not empty document.expiresOn }">
									<spring:theme code="text.account.myDocuments.expiresOn" text="Expires On " />
									<fmt:formatDate value="${document.expiresOn}" dateStyle="MEDIUM" timeStyle="short" type="date" />
								</c:if>
							</li>
							<li>
								<c:if test="${not empty document.documentTags }">
									<spring:theme code="text.account.myDocuments.tags" text="Tags" />
									<c:forEach items="${document.documentTags}" var="tags" varStatus="tagsLoop">
					                  	${ycommerce:encodeHTML(tags.tagName)}
	                           			<c:if test="${!tagsLoop.last}">,</c:if>
									</c:forEach>
								</c:if>
							</li>
							<li class="downloadLink">
								<span class="icon-file-pdf gi-1.5x"></span>
								<a href="${myAccountUrl}${document.downloadUrl}">
									<spring:theme code="text.account.myDocuments.downloadSummary" arguments="${document.name}, ${document.fileType}, ${document.fileSize}" />
								</a>
							</li>
						</ul>
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>