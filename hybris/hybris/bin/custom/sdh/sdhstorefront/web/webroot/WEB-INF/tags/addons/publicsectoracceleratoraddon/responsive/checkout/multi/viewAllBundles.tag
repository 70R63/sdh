<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="childBundleTemplates" required="true" type="java.util.List"%>
<%@ attribute name="disableProducts" required="true" type="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
 <spring:htmlEscape defaultHtmlEscape="true" />
 
<div class="bundleSelectionTemplate">
		<div><spring:theme code="checkout.summary.fieldsRequired" htmlEscape="false"></spring:theme></div>
		<div> ${ycommerce:sanitizeHTML(bundleHeaderMessage)}</div>
		
		<div id="bundleTemplatesDiv">
			<c:forEach items="${childBundleTemplates}" var="childBundleTemplate" varStatus="bundleCounter">
				<c:if test="${bundleCounter.count le fn:length(cartEntryIdList) + 1}">
					<div id="bundleTemplateDiv_${ycommerce:encodeHTML(childBundleTemplate.id)}" data-bundleId="${ycommerce:encodeHTML(childBundleTemplate.id)}" class="bundleTemplateDiv">
						<fieldset>
						<legend>${ycommerce:sanitizeHTML(childBundleTemplate.headerMessage)}</legend> <%--  <span class="question_img"></span> --%>
							<form:form id="childBundleTemplateForm_${ycommerce:encodeHTML(childBundleTemplate.id)}" method="post" commandName="bundleOptionsForm">
								<c:forEach items="${childBundleTemplate.products}" var="childBundleAddon">
									<c:set var="isProductDisabled" value="" />
									<c:set var="isProductSelected" value="" />
									
									<c:forEach items="${disableProducts}" var="disableProductCode">
									
										<c:if test="${disableProductCode eq childBundleAddon.code}">
											<c:set var="isProductDisabled" value="true" />
										</c:if>
									</c:forEach>
									<c:forEach items="${cartEntryIdList}" var="cartEntryId">
										<c:if test="${cartEntryId eq childBundleAddon.code}">
											<c:set var="isProductSelected" value="true" />
										</c:if>
									</c:forEach>
									
									<c:choose>
										<c:when test="${isProductSelected eq true}">
											<div class="radio bundleRadio" role="radio" aria-checked="false" tabindex="0"><label class="bundleTemplateLabel checked" for="${ycommerce:encodeHTML(childBundleAddon.code)}"> <form:radiobutton path="bundleOption" value="${ycommerce:encodeHTML(childBundleAddon.code)}" cssClass="bundleOption" id="${ycommerce:encodeHTML(childBundleAddon.code)}" checked="checked" /> <span>${ycommerce:sanitizeHTML(childBundleAddon.description)}</span>
											</label></div>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${isProductDisabled eq true}">
													<div class="radio bundleRadio" role="radio" aria-checked="false" tabindex="0"><label class="bundleTemplateLabel" for="${ycommerce:encodeHTML(childBundleAddon.code)}"> <form:radiobutton path="bundleOption" value="${ycommerce:encodeHTML(childBundleAddon.code)}" cssClass="bundleOption" id="${ycommerce:encodeHTML(childBundleAddon.code)}" disabled="disabled" /> <span>${ycommerce:sanitizeHTML(childBundleAddon.description)}</span>
													</label></div>
												</c:when>
												<c:otherwise>
													<div class="radio bundleRadio" role="radio" aria-checked="false" tabindex="0"><label class="bundleTemplateLabel" for="${ycommerce:encodeHTML(childBundleAddon.code)}"> <form:radiobutton path="bundleOption" value="${ycommerce:encodeHTML(childBundleAddon.code)}" cssClass="bundleOption" id="${ycommerce:encodeHTML(childBundleAddon.code)}" /> <span>${ycommerce:sanitizeHTML(childBundleAddon.description)}</span>
													</label></div>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:form>
						</fieldset>
					</div>
				</c:if>
			</c:forEach>
		</div>
</div>
