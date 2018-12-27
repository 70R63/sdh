<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/responsive/action"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:theme code="text.addToCart" var="addToCartText" />
<c:url value="${product.url}" var="productUrl" />
<c:set value="serviceIcon" var="serviceIcon" />
<c:set value="${ycommerce:productImage(product, serviceIcon)}" var="serviceIconImage" />

<div class="col-xs-12 col-sm-6 col-md-6 plp-card-cell">
	<div class="card card-plp col-md-12 plp-custom-padding">
		<div class="card-section-h2">
			<ycommerce:testId code="product_productName">
				<c:choose>
					<c:when test="${fn:length(product.name) > 40}">
					<c:set var="productName" value="${fn:substring(product.name, 0, 40)}"/>
						<c:if test="${not empty serviceIconImage.url}">
							<img src="${serviceIconImage.url}" alt="${productName}..." title="${productName}..." /> &nbsp;
						</c:if>
				        <h2><span tabindex="0">${ycommerce:encodeHTML(productName)}...	</span></h2>
			        </c:when>
					<c:otherwise>
						<c:if test="${not empty serviceIconImage.url}">
							<img src="${serviceIconImage.url}" alt="${product.name}" title="${product.name}" /> &nbsp;
						</c:if>
				    	<h2><span tabindex="0">${ycommerce:encodeHTML(product.name)}</span></h2>
			       </c:otherwise>
				</c:choose>
			</ycommerce:testId>
		</div>
		<div class="card-section-content">
			<c:choose>
				<c:when test="${fn:length(product.shortDescription) > 120}">
								${fn:substring(product.shortDescription, 0, 120)}...	
							</c:when>
				<c:otherwise>
					<div class="ng-binding"> ${ycommerce:sanitizeHTML(product.shortDescription)}</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="card-section-footer col-xs-12 col-sm-12 col-md-12">
			<div class="product-department card-section-h4">
				<c:if test="${not empty product.departments}">
					<c:forEach items="${product.departments}" var="department" varStatus="departmentStatus">
					          ${ycommerce:encodeHTML(department)} <c:if test="${(fn:length(product.departments)) != (departmentStatus.index+1)}">,&nbsp;</c:if>
					</c:forEach>
				</c:if>
			</div>
			<c:set var="product" value="${product}" scope="request" />
			<c:set var="addToCartText" value="${addToCartText}" scope="request" />
			<c:set var="addToCartUrl" value="${addToCartUrl}" scope="request" />
			<c:set var="isGrid" value="true" scope="request" />
			
			<div class="col-xs-12 col-sm-6 col-md-6 plp-custom-padding plp-button">
				<c:set var="ariaValueForViewDetailsLink">
					<spring:theme code="product.grid.viewdetails.label" text="View Details" arguments="${product.name}" />
				</c:set>
				<a href="${productUrl}" aria-label="${ariaValueForViewDetailsLink}" class="name btn btn-white btn-block"><span class="plp-btn"><spring:theme code="product.grid.details" text="View Details" /> </span></a>
			</div>

			<div class="col-xs-12 col-sm-6 col-md-6 plp-custom-padding plp-button PSProductGridComponent-ServiceListAddToCartAction" data-index="1">
				<action:actions element="div" parentComponent="${component}" />
			</div>
		</div>
	</div>
</div>