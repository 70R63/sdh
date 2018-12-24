<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/product"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<spring:htmlEscape defaultHtmlEscape="true" />
 
<div class="product__list--wrapper">
	<nav:pagination top="true" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" searchUrl="${searchPageData.currentQuery.url}" numberPagesShown="${numberPagesShown}" showTopTotals="false" />
	<div class="totalResults top">
		<spring:theme code="search.page.header.totalResults"
			arguments="${(fn:length(searchPageData.results) * (searchPageData.pagination.currentPage))+1},${fn:length(searchPageData.results) * (searchPageData.pagination.currentPage+1)},${searchPageData.pagination.totalNumberOfResults},${searchPageData.freeTextSearch}" />
	</div>

	<div class="product__listing product__grid">
		<div class="plp-product-lists card-section">
			<div class="card-list">
				<div class="row">
					<c:forEach items="${searchPageData.results}" var="product" varStatus="status">
						<product:serviceProductListerGridItem product="${product}" />
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<div class="totalResults bottom">
		<spring:theme code="search.page.header.totalResults"
			arguments="${(fn:length(searchPageData.results) * (searchPageData.pagination.currentPage))+1},${fn:length(searchPageData.results) * (searchPageData.pagination.currentPage+1)},${searchPageData.pagination.totalNumberOfResults},${searchPageData.freeTextSearch}" />
	</div>
	<nav:pagination top="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" searchUrl="${searchPageData.currentQuery.url}" numberPagesShown="${numberPagesShown}" />
</div>