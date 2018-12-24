<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="searchUrl" required="false"%>
<%@ attribute name="searchPageData" required="true" type="de.hybris.platform.commerceservices.search.pagedata.SearchPageData"%>
<%@ attribute name="top" required="true" type="java.lang.Boolean"%>
<%@ attribute name="showTopTotals" required="false" type="java.lang.Boolean"%>
<%@ attribute name="supportShowAll" required="true" type="java.lang.Boolean"%>
<%@ attribute name="supportShowPaged" required="true" type="java.lang.Boolean"%>
<%@ attribute name="additionalParams" required="false" type="java.util.HashMap"%>
<%@ attribute name="msgKey" required="false"%>
<%@ attribute name="showCurrentPageInfo" required="false" type="java.lang.Boolean"%>
<%@ attribute name="hideRefineButton" required="false" type="java.lang.Boolean"%>
<%@ attribute name="numberPagesShown" required="false" type="java.lang.Integer"%>
<%@ taglib prefix="pagination" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/nav/pagination"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="themeMsgKey" value="${not empty msgKey ? msgKey : 'search.page'}" />
<c:set var="showCurrPage" value="${not empty showCurrentPageInfo ? showCurrentPageInfo : false}" />
<c:set var="hideRefBtn" value="${hideRefineButton ? true : false}" />
<c:set var="showTotals" value="${empty showTopTotals ? true : showTopTotals}" />
<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${searchPageData.pagination.totalNumberOfResults == 0 && top && showTotals}">
	<div class="paginationBar top clearfix">
		<ycommerce:testId code="searchResults_productsFound_label">
			<div class="totalResults">
				<spring:theme code="${themeMsgKey}.totalResults" arguments="${searchPageData.pagination.totalNumberOfResults}" />
			</div>
		</ycommerce:testId>
	</div>
</c:if>

<c:if test="${searchPageData.pagination.totalNumberOfResults > 0}">
	<div class="pagination-bar ${(top)?"top":"bottom"}">
		<div class="pagination-toolbar">
			<c:if test="${not empty searchPageData.sorts}">
				<div class="helper clearfix hidden-md hidden-lg"></div>
				<div class="sort-refine-bar">
					<div class="row">
					
						<div class="col-xs-6 col-sm-4 col-md-4 hidden-lg hidden-md hidden-sm">
							<div class="totalResults ng-binding top" tabindex="0">
							<c:choose>
							<c:when test="${searchPageData.pagination.currentPage == 0}">
								<spring:theme code="bill.page.header.totalBillResults" arguments="${(fn:length(searchPageData.results) * (searchPageData.pagination.currentPage))+1},${fn:length(searchPageData.results) * (searchPageData.pagination.currentPage+1)},${searchPageData.pagination.totalNumberOfResults}" htmlEscape="false" var="totalBillResults"/>
								${ycommerce:sanitizeHTML(totalBillResults)}
								</c:when>
								<c:otherwise>
								<spring:theme code="bill.page.header.totalBillResults" arguments="${searchPageData.pagination.currentPage * searchPageData.pagination.pageSize + 1},${(searchPageData.pagination.currentPage * searchPageData.pagination.pageSize) + (fn:length(searchPageData.results))},${searchPageData.pagination.totalNumberOfResults}" htmlEscape="false" var="totalBillResults"/>
								${ycommerce:sanitizeHTML(totalBillResults)}
								</c:otherwise>
								</c:choose>
							</div>
						</div>
						
						<div class="col-xs-6 col-sm-8 visible-lg visible-md visible-sm ">
							<div class="totalResults ng-binding top col-xs-12 col-sm-5" tabindex="0">
								<span class="total-bill-result">
							<c:choose>
							<c:when test="${searchPageData.pagination.currentPage == 0}">
								<spring:theme code="bill.page.header.totalBillResults" arguments="${(fn:length(searchPageData.results) * (searchPageData.pagination.currentPage))+1},${fn:length(searchPageData.results) * (searchPageData.pagination.currentPage+1)},${searchPageData.pagination.totalNumberOfResults}" htmlEscape="false" var="totalBillResults"/>
								${ycommerce:sanitizeHTML(totalBillResults)}
								</c:when>
								<c:otherwise>
							    <spring:theme code="bill.page.header.totalBillResults" arguments="${searchPageData.pagination.currentPage * searchPageData.pagination.pageSize + 1},${(searchPageData.pagination.currentPage * searchPageData.pagination.pageSize) + (fn:length(searchPageData.results))},${searchPageData.pagination.totalNumberOfResults}" htmlEscape="false" var="totalBillResults"/>
								${ycommerce:sanitizeHTML(totalBillResults)}
								</c:otherwise>
								</c:choose>
								</span>
							</div>
							
							<div class="col-sm-1 bill-seperator"></div>
							<div class="col-sm-6">
							<div class="form-group">
								<form id="billSortForm${top ? '1' : '2'}" name="billSortForm${top ? '1' : '2'}" method="get" action="#">
								<input type="hidden" name="customerPK" value=" ${ycommerce:encodeHTML(billCustomer.customerPK)}" />
								<label class="acc_hidden" for="sortOptions1"><spring:theme code="bill.page.billSortForm.label"></spring:theme></label>
									<select id="sortOptions1" name="filterCode" class="form-control bills-select sortOptions1">
										<c:forEach items="${statuses}" var="status">
											<option value="${status.code}" ${filterCode eq status.code ? 'selected="selected"' : ''}>
												<c:choose>
													<c:when test="${not empty status.name}">
                                                        ${ycommerce:sanitizeHTML(status.name)}
                                                    </c:when>
													<c:otherwise>
														<spring:theme code="${themeMsgKey}.sort.${status.code}" />
													</c:otherwise>
												</c:choose>
											</option>
										</c:forEach>
									</select>
									<c:if test="${supportShowAll}">
										<ycommerce:testId code="searchResults_showAll_link">
											<input type="hidden" name="show" value="Page" />
										</ycommerce:testId>
									</c:if>
									<c:if test="${supportShowPaged}">
										<ycommerce:testId code="searchResults_showPage_link">
											<input type="hidden" name="show" value="All" />
										</ycommerce:testId>
									</c:if>
									<c:if test="${not empty additionalParams}">
										<c:forEach items="${additionalParams}" var="entry">
											<input type="hidden" name="${ycommerce:encodeHTML(entry.key)}" value="${ycommerce:encodeHTML(entry.value)}" />
										</c:forEach>
									</c:if>
								</form>
							</div>
						</div>
						</div>

						<div class="col-xs-6 col-sm-4 col-md-4 pagination-wrap">
							<pagination:relationshipBillsPageSelectionPagination searchUrl="${searchUrl}" searchPageData="${searchPageData}" numberPagesShown="${numberPagesShown}" themeMsgKey="${themeMsgKey}" />
						</div>

						<div class="col-xs-12 hidden-sm hidden-md hidden-lg">
							<div class="form-group">
								<form id="sortForm${top ? '1' : '2'}" name="sortForm${top ? '1' : '2'}" method="get" action="#">
								<input type="hidden" name="customerPK" value=" ${ycommerce:encodeHTML(billCustomer.customerPK)}" />
								<label class="acc_hidden" for="sortOptions2"><spring:theme code="bill.page.billSortForm.label"></spring:theme></label>
									<select id="sortOptions2" name="filterCode" class="form-control bills-select sortOptions2">
										<c:forEach items="${statuses}" var="status">
											<option value="${status.code}" ${filterCode eq status.code ? 'selected="selected"' : ''}>
												<c:choose>
													<c:when test="${not empty status.name}">
                                                         ${ycommerce:sanitizeHTML(status.name)}
                                                    </c:when>
													<c:otherwise>
														<spring:theme code="${themeMsgKey}.sort.${status.code}" />
													</c:otherwise>
												</c:choose>
											</option>
										</c:forEach>
									</select>
									<c:if test="${supportShowAll}">
										<ycommerce:testId code="searchResults_showAll_link">
											<input type="hidden" name="show" value="Page" />
										</ycommerce:testId>
									</c:if>
									<c:if test="${supportShowPaged}">
										<ycommerce:testId code="searchResults_showPage_link">
											<input type="hidden" name="show" value="All" />
										</ycommerce:testId>
									</c:if>
									<c:if test="${not empty additionalParams}">
										<c:forEach items="${additionalParams}" var="entry">
											<input type="hidden" name="${ycommerce:encodeHTML(entry.key)}" value="${ycommerce:encodeHTML(entry.value)}" />
										</c:forEach>
									</c:if>
								</form>
							</div>
						</div>

					</div>
				</div>
			</c:if>
		</div>
		<c:if test="${top && showTotals}">
			<div class="row">
				<div class="col-xs-12">
					<div class="pagination-bar-results">
						<ycommerce:testId code="searchResults_productsFound_label">
							<c:choose>
								<c:when test="${showCurrPage}">
									<c:choose>
										<c:when test="${searchPageData.pagination.totalNumberOfResults == 1}">
											<spring:theme code="${themeMsgKey}.totalResultsSingleOrder" />
										</c:when>
										<c:when test="${searchPageData.pagination.numberOfPages <= 1}">
											<spring:theme code="${themeMsgKey}.totalResultsSinglePage" arguments="${searchPageData.pagination.totalNumberOfResults}" />
										</c:when>
										<c:otherwise>
											<c:set var="currentPageItems" value="${(searchPageData.pagination.currentPage + 1) * searchPageData.pagination.pageSize}" />
											<c:set var="upTo" value="${(currentPageItems > searchPageData.pagination.totalNumberOfResults ? searchPageData.pagination.totalNumberOfResults : currentPageItems)}" />
											<c:set var="currentPage" value="${searchPageData.pagination.currentPage * searchPageData.pagination.pageSize + 1} - ${upTo}" />
											<spring:theme code="${themeMsgKey}.totalResultsCurrPage" arguments="${currentPage},${searchPageData.pagination.totalNumberOfResults}" />
										</c:otherwise>
									</c:choose>
								</c:when>
							</c:choose>
						</ycommerce:testId>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</c:if>