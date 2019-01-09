<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${not empty nextBundleTemplate}">
	<div id="bundleTemplateDiv_${ycommerce:encodeHTML(nextBundleTemplate.id)}" data-bundleId="${ycommerce:encodeHTML(nextBundleTemplate.id)}" class="bundleTemplateDiv">
		<form:form id="childBundleTemplateForm_${ycommerce:encodeHTML(nextBundleTemplate.id)}" method="post" commandName="bundleOptionsForm">
			<fieldset>
				<legend>${ycommerce:sanitizeHTML(nextBundleTemplate.headerMessage)}</legend> 
				<c:forEach items="${nextBundleTemplate.products}" var="childBundleAddon">
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
					<c:set var="childBundleAddonCode" value="${ycommerce:encodeHTML(childBundleAddon.code)}"/>
					<c:choose>
						<c:when test="${isProductSelected eq true}">
							<div class="radio" tabindex="0">
								<label class="bundleTemplateLabel checked"
									for="${childBundleAddonCode}"> <form:radiobutton
										path="bundleOption" value="${childBundleAddonCode}"
										cssClass="bundleOption" id="${childBundleAddonCode}"
										checked="checked" /> <span>${ycommerce:sanitizeHTML(childBundleAddon.description)}</span>
								</label>
							</div>
						</c:when>
						<c:otherwise>
						<c:choose>
								<c:when test="${isProductDisabled eq true}">
									<div class="radio" tabindex="0">
										<label class="bundleTemplateLabel"
											for="${childBundleAddonCode}"> <form:radiobutton
												path="bundleOption" value="${childBundleAddonCode}"
												cssClass="bundleOption" id="${childBundleAddonCode}"
												disabled="disabled" /> ${ycommerce:sanitizeHTML(childBundleAddon.description)}
										</label>
									</div>
								</c:when>
								<c:otherwise>
									<div class="radio" tabindex="0">
										<label class="bundleTemplateLabel"
											for="${childBundleAddonCode}"> <form:radiobutton
												path="bundleOption" value="${childBundleAddonCode}"
												cssClass="bundleOption" id="${childBundleAddonCode}" />
											${ycommerce:sanitizeHTML(childBundleAddon.description)}
										</label>
									</div>
								</c:otherwise>
							</c:choose>
					</c:otherwise>
					</c:choose>
				</c:forEach>
			</fieldset>	
		</form:form>
	</div>
</c:if>
