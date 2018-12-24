<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="results" required="true" type="java.util.ArrayList"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:url value="/my-account/bills/my-bills/" var="fullBillUrl" />
<spring:url value="/bills/receipt/pdf" var="billReceiptURL" />
<spring:url value="/my-account/bills/all-bills/" var="showAllBillsUrl"></spring:url>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${not empty results}">
	<div class="divOuterTable row no-margin my-bill">
		<div class="divTable billhistory-list-table" role="grid">
			<div class="divTableHeading hidden-xs hidden-sm" role="row">
				<span class="divTableCell col-md-2" role="columnheader"><spring:theme code="text.bill.type" /></span> <span class="divTableCell col-md-1" role="columnheader"><spring:theme code="text.bill.due.date" /></span> <span class="divTableCell col-md-1" role="columnheader"><spring:theme code="text.amount.due" /></span> <span class="divTableCell col-md-1" role="columnheader"><spring:theme
						code="text.bill.total" /></span> <span class="divTableCell col-md-1" role="columnheader"><spring:theme code="text.issue.date" /></span> <span class="divTableCell col-md-1" role="columnheader"><spring:theme code="text.bill.id" /></span> <span class="divTableCell col-md-1" role="columnheader"><spring:theme code="text.status" /></span> <span class="divTableCell col-md-2" role="columnheader"><span class="acc_hidden" ><spring:theme code="text.downloadBillPdf"/></span></span>
				<span class="divTableCell col-md-2" role="columnheader"><span class="acc_hidden" ><spring:theme code="text.billOptions"/></span></span>
			</div>
			<c:forEach items="${results}" var="bill">
				<div class="divTableRow" role="row">
					<ycommerce:testId code="billsHistoryItem_showBills">
						<span class="divTableCell col-xs-12 col-sm-12 col-md-2" role="gridcell"> <strong>${ycommerce:encodeHTML(bill.billDescription)}</strong>
						</span>
						<span class="divTableCell col-xs-6 col-sm-6 col-md-1 same-line" role="gridcell">
							<div class="hidden-md hidden-lg">
								<strong><spring:theme code="text.bill.due.date" /></strong>
							</div> <fmt:formatDate value="${bill.billDueDate}" dateStyle="MEDIUM" timeStyle="short" type="date" />
						</span>
						<span class="divTableCell col-xs-6 col-sm-6 col-md-1 bill-amount-due" role="gridcell">
							<div class="hidden-md hidden-lg">
								<strong><spring:theme code="text.amount.due" /></strong>
							</div> ${ycommerce:sanitizeHTML(bill.currency.symbol)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bill.outstandingBillAmount}" />
						</span>
						<span class="divTableCell col-xs-6 col-sm -6 col-md-1 bill-total" role="gridcell">
							<div class="hidden-md hidden-lg">
								<spring:theme code="text.bill.total" />
							</div> ${ycommerce:sanitizeHTML(bill.currency.symbol)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bill.totalBillAmount}" />
						</span>
						<span class="divTableCell col-xs-6 col-sm-6 col-md-1 same-line" role="gridcell">
							<div class="hidden-md hidden-lg">
								<spring:theme code="text.issue.date" />
							</div> <fmt:formatDate value="${bill.billDate}" dateStyle="MEDIUM" timeStyle="short" type="date" />
						</span>
						<span class="divTableCell col-xs-6 col-sm-6 col-md-1 same-line" role="gridcell">
							<div class="hidden-md hidden-lg">
								<spring:theme code="text.bill.id" />
							</div> ${ycommerce:encodeHTML(bill.billId)}
						</span>
						<span class="divTableCell col-xs-6 col-sm-6 col-md-1" role="gridcell">
							<div class="hidden-md hidden-lg">
								<spring:theme code="text.status" />
							</div> <c:choose>
								<c:when test="${bill.billPaymentStatus =='UNPAID' }">
									<spring:theme code="text.bills.unpaid" />
								</c:when>
								<c:when test="${bill.billPaymentStatus =='PAID' }">
									<spring:theme code="text.bills.paid" />
								</c:when>
								<c:when test="${bill.billPaymentStatus =='PARTPAID' }">
									<spring:theme code="text.bills.part.paid" />
								</c:when>
							</c:choose>
						</span>
						<span class="divTableCell col-xs-5 col-sm-6 col-md-2" role="gridcell">
							<div class="col-md-12 no-space">
								<span class="icon-file-pdf gi-1.5x"></span> <a href="${bill.fullBillUrl}" class="bill-download-pdf"> <spring:theme code="text.download.bill.as.pdf" /></a>
							</div>
						</span>
						<spring:url value="/bills/payment" var="billOverviewPageUrl">
							<spring:param name="billCode" value="${ycommerce:encodeHTML(bill.code)}" />
						</spring:url>
						<span class="divTableCell billType-message col-xs-7 col-sm-6 col-md-2" role="gridcell"> <c:choose>
								<c:when test="${bill.billPaymentStatus != 'PAID' && bill.billType.isPaymentAllowed == true
										&& (bill.billOverDue == false || bill.billType.isOverduePaymentAllowed == true)}">
									<div class="col-md-12 no-space bill-more-info">
										<button type="button" class="btn btn-primary btn-block " onClick="window.location='${billOverviewPageUrl}'">
											<spring:theme code="text.pay.this.bill" />
										</button>
									</div>
								</c:when>
								
									<c:when test="${bill.billType.isPaymentAllowed == false && bill.billPaymentStatus != 'PAID' && bill.billOverDue == true && bill.billType.isOverduePaymentAllowed == false}">
									<c:forEach items="${bill.billType.messages}" var="messages">
										<c:if test="${messages.messageCondition == 'PAYMENT_NOT_ALLOWED' }">
							       ${ycommerce:sanitizeHTML(messages.shortMessage)}
							        </c:if>
									</c:forEach>


									<div class="col-md-12 no-space bill-more-info">
										<button type="button" class="btn btn-primary btn-block " onClick="window.location='${billOverviewPageUrl}'">
											<spring:theme code="text.bill.more.info" />
										</button>
									</div>
									</c:when>
								
								<c:when test="${bill.billPaymentStatus != 'PAID' && bill.billOverDue == true && bill.billType.isOverduePaymentAllowed == false}">
									<c:forEach items="${bill.billType.messages}" var="messages">
										<c:if test="${messages.messageCondition == 'LATE_PAYMENT_NOT_ALLOWED' }">
							        ${ycommerce:sanitizeHTML(messages.shortMessage)}	
							        </c:if>
									</c:forEach>

									<div class="col-md-12 no-space bill-more-info">
										<button type="button" class="btn btn-primary btn-block " onClick="window.location='${billOverviewPageUrl}'">
										<spring:theme code="text.bill.more.info" />
										</button>
									</div>

								</c:when>

								<c:when test="${bill.billType.isPaymentAllowed == false && bill.billPaymentStatus != 'PAID'}">
									<c:forEach items="${bill.billType.messages}" var="messages">
										<c:if test="${messages.messageCondition == 'PAYMENT_NOT_ALLOWED' }">
							         ${ycommerce:sanitizeHTML(messages.shortMessage)}	
							        </c:if>
									</c:forEach>


									<div class="col-md-12 no-space bill-more-info">
										<button type="button" class="btn btn-primary btn-block " onClick="window.location='${billOverviewPageUrl}'">
											<spring:theme code="text.bill.more.info" />
										</button>
									</div>
									</c:when>
							</c:choose> <c:if test="${bill.billPaymentStatus == 'PAID' || bill.billPaymentStatus == 'PARTPAID'}">
								<c:forEach items="${bill.transactionInfos}" var="transaction">
									<div class="col-md-12 download-receipt no-space">
										<span class="icon-file-pdf gi-1.5x"></span> <a href="${billReceiptURL}?billCode=${ycommerce:encodeUrl(bill.code)}&receiptId=${ycommerce:encodeUrl(transaction.transactionId)}" class="bill-receipt-download-pdf" target="_blank"> <span class="download-text"><spring:theme code="text.download.receipt.as.pdf" htmlEscape="false"/></span>
										<fmt:formatDate value="${transaction.paidDate}" dateStyle="MEDIUM" timeStyle="short" type="date" />
										</a>
									</div>
								</c:forEach>
							</c:if>
						</span>
					</ycommerce:testId>
				</div>
			</c:forEach>
		</div>
	</div>
</c:if>