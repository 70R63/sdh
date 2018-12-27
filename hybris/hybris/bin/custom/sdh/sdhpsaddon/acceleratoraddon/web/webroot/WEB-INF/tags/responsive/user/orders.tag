<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="results" required="true" type="java.util.ArrayList"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/application/" var="orderDetailsUrl" />
<spring:url value="/my-account/my-documents/" var="myDocumentsURL" />

<div class="divOuterTable row no-margin">
	<div class="divTable" role="grid">
		<div class="divTableHeading hidden-xs hidden-sm" role="row">
			<span class="divTableCell col-md-2" role="columnheader"><spring:theme code="text.account.orderHistory.orderNumber" /></span> <span class="divTableCell col-md-2" role="columnheader"><spring:theme code="text.account.orderHistory.orderStatus" /></span> <span class="divTableCell col-md-1" role="columnheader"><spring:theme code="text.account.orderHistory.total" /></span> <span
				class="divTableCell col-md-2" role="columnheader"><spring:theme code="text.account.orderHistory.deliveryMode" /></span> <span class="divTableCell col-md-2" role="columnheader"><spring:theme code="text.account.orderHistory.datePlaced" /></span>
			<c:if test="${isRelationshipData ne true}">
				<span class="divTableCell col-md-2" role="columnheader"><spring:theme code="text.account.orderHistory.submittedBy" /></span>
			</c:if>
		</div>
		<c:forEach items="${searchPageData.results}" var="order">
			<div class="divTableRow" role="row">
				<ycommerce:testId code="orderHistoryItem_orderDetails_link">
					<span class="divTableCell col-xs-12 col-sm-12 col-md-2" role="gridcell"> <a href="${orderDetailsUrl} ${ycommerce:encodeHTML(order.code)}" class="responsive-table-link"> ${order.serviceRequest}<br> <spring:theme code="text.account.orderHistory.RefNo" /> ${ycommerce:encodeHTML(order.code)}
					</a>
					</span>
					<span class="divTableCell col-xs-6 col-sm-6 col-md-2" role="gridcell">
						<div class="hidden-md hidden-lg">
							<spring:theme code="text.account.orderHistory.orderStatus" />
						</div> <spring:theme code="text.account.order.status.display.${order.statusDisplay}" />
					</span>
					<span class="divTableCell col-xs-6 col-sm-6 col-md-1" role="gridcell">
						<div class="hidden-md hidden-lg">
							<spring:theme code="text.account.orderHistory.total" />
						</div> <format:price priceData="${order.total}" />
					</span>
					<span class="divTableCell col-xs-6 col-sm -6 col-md-2" role="gridcell">
						<div class="hidden-md hidden-lg">
							<spring:theme code="text.account.orderHistory.deliveryMode" />
						</div>  ${ycommerce:encodeHTML(order.deliveryMode.name)}<c:if test="${order.hasDocument}">
							<spring:theme code="text.account.history.document" arguments="${myDocumentsURL}" htmlEscape="false" var="historyDocument"/>
							${ycommerce:sanitizeHTML(historyDocument)}
						</c:if>
					</span>
					<span class="divTableCell col-xs-6 col-sm-6 col-md-2" role="gridcell">
						<div class="hidden-md hidden-lg">
							<spring:theme code="text.account.orderHistory.datePlaced" />
						</div> <fmt:formatDate value="${order.placed}" dateStyle="MEDIUM" timeStyle="short" type="date" />
					</span>
					<c:if test="${isRelationshipData ne true}">
						<span class="divTableCell col-xs-6 col-sm-6 col-md-2" role="gridcell">
							<div class="hidden-md hidden-lg">
								<spring:theme code="text.account.orderHistory.submittedBy" />
							</div> <c:if test="${currentUserId eq order.placedBy.uid}">
								<spring:theme code="text.account.orderHistory.you" />
							</c:if> <c:if test="${currentUserId ne order.placedBy.uid}">
										 ${ycommerce:encodeHTML(order.placedBy.name)}
							</c:if>
						</span>
					</c:if>
				</ycommerce:testId>
			</div>
		</c:forEach>
	</div>
</div>