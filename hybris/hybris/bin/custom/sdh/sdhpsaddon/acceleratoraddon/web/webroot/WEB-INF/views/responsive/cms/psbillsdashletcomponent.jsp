<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<spring:url value="/bills/receipt/pdf" var="billReceiptURL" />
<spring:url value="/my-account/bills/my-bills/" var="fullBillUrl" />
<spring:url value="/my-account/all-bills" var="seeAllBills" />

<c:if test="${showBillsDashlet}">
	<div class="grid-item">
		<h2 class="header">
			<span tabindex="0">${ycommerce:encodeHTML(component.title)}</span>
		</h2>
		<c:if test="${userBillsAvailable}">
			<h3 class="sub-header">
				<span tabindex="0">${ycommerce:encodeHTML(component.summary)}</span>
			</h3>
		</c:if>
		<div class="content">
		    <div class="row">
                <ul class="dashlet-list">
                    <c:forEach items="${bills}" var="bill">
                        <li class="row dashlet-list-item">
							<div class="row no-margin">
								<div class="col-xs-12">
									<span class="title"><span tabindex="0">${ycommerce:encodeHTML(bill.billDescription)}</span></span>
								</div>
								<div class="col-xs-12 col-sm-6 hidden-xs">
									<span tabindex="0"><strong><spring:theme code="text.bill.due.date" />: <fmt:formatDate value="${bill.billDueDate}" dateStyle="MEDIUM" timeStyle="short" type="date" /></strong></span>
								</div>
								<div class="col-xs-12 col-sm-6 text-right hidden-xs">
									<span tabindex="0"><strong><spring:theme code="text.amount.due" />: ${ycommerce:sanitizeHTML(bill.currency.symbol)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bill.outstandingBillAmount}" /></strong></span>
								</div>
								<div class="col-xs-12 col-sm-6 visible-xs">
									<span tabindex="0"><strong><spring:theme code="text.amount.due" />: ${ycommerce:sanitizeHTML(bill.currency.symbol)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bill.outstandingBillAmount}" /></strong></span>
								</div>
								<div class="col-xs-12 col-sm-6 visible-xs">
									<span tabindex="0"><strong><spring:theme code="text.bill.due.date" />: <fmt:formatDate value="${bill.billDueDate}" dateStyle="MEDIUM" timeStyle="short" type="date" /></strong></span>
								</div>
							</div>
							<div class="row no-margin">
								<div class="col-xs-12 col-sm-6 dashlet-bills-pdf">
									<span class="icon-file-pdf gi-2.5x"></span> <a href="${bill.fullBillUrl}"><spring:theme code="text.download.bill.as.pdf" /></a>
								</div>
								<div class="col-xs-12 col-sm-6 text-right btn-padding">
									<spring:url value="/bills/payment" var="billOverviewPageUrl">
										<spring:param name="billCode" value="${ycommerce:encodeHTML(bill.code)}" />
									</spring:url>
									<c:choose>
										<c:when test="${bill.billPaymentStatus != 'PAID' && bill.billType.isPaymentAllowed == true
										&& (bill.billOverDue == false || bill.billType.isOverduePaymentAllowed == true)}">
											<button type="button" class="btn btn-primary bill-pay-btn" onClick="window.location='${billOverviewPageUrl}'">
												<spring:theme code="text.pay.this.bill" />
											</button>
										</c:when>

										<c:when test="${bill.billType.isPaymentAllowed == false && bill.billPaymentStatus != 'PAID' && bill.billOverDue == true && bill.billType.isOverduePaymentAllowed == false}">
											<div> class="dashlet-billtype-message">
											    <c:forEach items="${bill.billType.messages}" var="messages">
												    <c:if test="${messages.messageCondition == 'PAYMENT_NOT_ALLOWED' }">
													    <span tabindex="0">${ycommerce:sanitizeHTML(messages.shortMessage)}</span>
												    </c:if>
												</c:forEach>
											</div>
                                            <button type="button" class="btn btn-primary bill-more-info-btn" onClick="window.location='${billOverviewPageUrl}'">
                                                <spring:theme code="text.bill.more.info" />
                                            </button>
										</c:when>

										<c:when test="${bill.billPaymentStatus != 'PAID' && bill.billOverDue == true && bill.billType.isOverduePaymentAllowed == false}">
											<div class="dashlet-billtype-message">
											    <c:forEach items="${bill.billType.messages}" var="messages">
													<c:if test="${messages.messageCondition == 'LATE_PAYMENT_NOT_ALLOWED' }">
														<span tabindex="0">${ycommerce:sanitizeHTML(messages.shortMessage)}</span>
													</c:if>
												</c:forEach>
											</div>
                                            <button type="button" class="btn btn-primary bill-more-info-btn" onClick="window.location='${billOverviewPageUrl}'">
                                                <spring:theme code="text.bill.more.info" />
                                            </button>
										</c:when>

										<c:when test="${bill.billType.isPaymentAllowed == false && bill.billPaymentStatus != 'PAID'}">
											<div class="dashlet-billtype-message">
											    <c:forEach items="${bill.billType.messages}" var="messages">
													<c:if test="${messages.messageCondition == 'PAYMENT_NOT_ALLOWED' }">
														<span tabindex="0">${ycommerce:sanitizeHTML(messages.shortMessage)} </span>
													</c:if>
												</c:forEach>
											</div>
                                            <button type="button" class="btn btn-primary bill-more-info-btn" onClick="window.location='${billOverviewPageUrl}'">
                                                <spring:theme code="text.bill.more.info" />
                                            </button>

										</c:when>
									</c:choose>
									<c:if test="${(bill.billPaymentStatus == 'PAID' || bill.billPaymentStatus == 'PARTPAID') && fn:length(bill.transactionInfos) > 0}">
										<div class="dashlet-bills-pdf">
											<span class="icon-file-pdf gi-2.5x"></span> <a href="${billReceiptURL}?billCode=${ycommerce:encodeUrl(bill.code)}&receiptId=${ycommerce:encodeUrl(bill.transactionInfos[fn:length(bill.transactionInfos) - 1].transactionId)}" class="bill-receipt-download-pdf" target="_blank"> <span class="download-text"><spring:theme code="text.download.receipt.as.pdf" htmlEscape="false" var="downlaodReceiptAsPdf"/>
											${ycommerce:sanitizeHTML(downlaodReceiptAsPdf)}
											</span> <fmt:formatDate value="${bill.transactionInfos[fn:length(bill.transactionInfos) - 1].paidDate}" dateStyle="MEDIUM" timeStyle="short" type="date" />
											</a>
										</div>
									</c:if>
								</div>
							</div>
					    </li>
			        </c:forEach>
                </ul>
            </div>
            <c:if test="${userBillsAvailable eq false}">
            	<div class="row notification-box">
					<div class="col-xs-12 text-center notification-inner-box">
						<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span>
						<span class="notification-text" tabindex="0">
							<spring:theme code="text.account.dashlet.bills.you.dont.have.bills" />
						</span>
					</div>
				</div>
				 <c:if test="${userRelationshipsBillsAvailable eq true && userRelationshipsUnpaidBillsAvailable eq false}"> 
					<div class="row notification-box">
						<div class="col-xs-12 text-center notification-inner-box">
							<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span>
							<span class="notification-text" tabindex="0">
								<spring:theme code="text.account.dashlet.bills.relationships.have.bills" />
							</span>
						</div>
					</div>
				 </c:if> 
			</c:if>
            <c:if test="${userRelationshipsUnpaidBillsAvailable}">
				<div class="row notification-box">
					<div class="col-xs-12 text-center notification-inner-box">
						<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span>
						<span class="notification-text" tabindex="0">
							<spring:theme code="text.account.dashlet.bills.relationships.have.unpaid.bills" />
						</span>
					</div>
				</div>
			</c:if> 
			<c:if test="${isSeeAllBillsButtonVisible}">
				<div class="row">
					<div class="col-xs-12 button-box text-center">
						<button type="button" class="btn btn-grey btn-block" onClick="window.location='${seeAllBills}'">
							<spring:theme code="text.account.dashlet.bills.see.all.bills" />
						</button>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</c:if>