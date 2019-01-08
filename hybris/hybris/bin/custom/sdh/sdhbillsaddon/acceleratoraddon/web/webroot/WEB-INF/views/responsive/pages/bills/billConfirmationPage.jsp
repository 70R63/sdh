<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<spring:url value="/bills/receipt/pdf" var="billReceiptURL" />
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/all-bills" var="myBillsUrl" />

<template:page pageTitle="${pageTitle}">
	<div class="row no-margin global-content-space bill-confirmation">
		<div class="col-sm-8 col-md-8">
			<div class="card-section no-space">
				<div class="card-list">
					<div class="row no-margin">
						<div class="col-xs-12 col-sm-12 col-md-12 ">
							<div class="card-section-h1">
								<h1><span tabindex="0">
									<spring:theme code="confirmation.page.bill.paid" />
								</span></h1>
							</div>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-12 ">
							<div class="col-xs-12 col-sm-12 col-md-12 checkout-confirmation bill-content ">
								<div>
									<p tabindex="0">
										<strong><spring:theme code="confirmation.page.bill.id" /> &nbsp; ${ycommerce:encodeHTML(billData.bill.billId)}</strong>
									</p>
								</div>
								<div>
									<p tabindex="0">
										<spring:theme code="confirmation.page.thankyou.for.paying.this.bill" />
										&nbsp;${ycommerce:encodeHTML(paidByEmail)}
										<c:if test="${billData.receiptInfo.outstandingAmount > 0 }">
											<br>
											<spring:theme code="confirmation.page.part.paid.message" />&nbsp;${ycommerce:encodeHTML(billData.receiptInfo.currency)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${billData.receiptInfo.outstandingAmount}" />
										</c:if>
										<c:if test="${unidentifiedUserFlag eq false }">
											<br>
											<spring:theme code="confirmation.page.you.can.view.all.your.bill.receipts" text="<br> You can view all your bill receipts in My Account - <a href='{0}'" arguments="${myBillsUrl}" var= "confirmationAllBillReceipts" htmlEscape="false"/>
											${ycommerce:sanitizeHTML(confirmationAllBillReceipts)}
										</c:if>
										<br>
										<c:if test="${billData.receiptInfo.overPaidAmount > 0 }">
											<br>
											<spring:theme code="confirmation.page.over.paid.message1" />${ycommerce:encodeHTML(billData.receiptInfo.currency)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${billData.receiptInfo.overPaidAmount}" />
											<spring:theme code="confirmation.page.over.paid.message2" />

										</c:if>
									</p>
								</div>
							</div>
						</div>
					</div>

					<div class="row no-margin">
						<div class="col-xs-12 col-sm-12 col-md-12 ">
							<div class="card-section-h1 bill-summary">
								<h2>
									<span tabindex="0"><spring:theme code="confirmation.page.summary" /></span>
								</h2>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6 ">
								<!-- Payment Method starts -->
								<div class="card-200 col-xs-12 col-sm-12 col-md-12">
									<div class="card-section-h2">
										<h2><span tabindex="0"><spring:theme code="confirmation.page.payment" />
										&amp;
										<spring:theme code="confirmation.page.billing.address" /></span></h2>
									</div>
									<div class="card-section-content" tabindex="0">
										<div>${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.billingAddress.title)}&nbsp;${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.billingAddress.firstName)}&nbsp;${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.billingAddress.lastName)}</div>
										<div>${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.cardType)}</div>
										<div>${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.cardNumber)}</div>
										<div>${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.expiryMonth)}/${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.expiryYear)}</div>
										<div>${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.billingAddress.line1)}</div>
										<div></div>
										<div>${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.billingAddress.town)}&nbsp;</div>
										<div>${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.billingAddress.postalCode)}&nbsp;${ycommerce:encodeHTML(billData.receiptInfo.paymentInfo.billingAddress.country.isocode)}</div>
									</div>
								</div>
								<!-- Payment Method ends -->

							</div>
							<div class="col-xs-12 col-sm-6 col-md-6 ">
								<!-- Bill Details starts -->
								<div class="card-200 col-xs-12 col-sm-12 col-md-12">
									<div class="card-section-h2">
										<h2><span tabindex="0"><spring:theme code="confirmation.page.bill.details" /></span></h2>
									</div>
									<div class="card-section-content" tabindex="0">
										<div>
											<strong>${ycommerce:encodeHTML(billData.bill.billType.name)}</strong>
										</div>
										<div>
											<strong><spring:theme code="confirmation.page.amount.paid" /> ${ycommerce:encodeHTML(billData.receiptInfo.currency)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${billData.receiptInfo.paidAmount}" /></strong>
										</div>
										<c:choose>
											<c:when test="${billData.receiptInfo.overPaidAmount > 0 }">
												<div>
													<strong><spring:theme code="confirmation.page.amount.due" /> ${ycommerce:encodeHTML(billData.receiptInfo.currency)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${billData.receiptInfo.outstandingAmount}" /></strong>
												</div>
											</c:when>
											<c:otherwise>
												<div>
													<strong><spring:theme code="confirmation.page.amount.due" /> ${ycommerce:encodeHTML(billData.receiptInfo.currency)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${billData.receiptInfo.outstandingAmount}" /></strong>
												</div>
											</c:otherwise>
										</c:choose>
										<c:if test="${billData.receiptInfo.overPaidAmount > 0 }">
											<div>
												<strong><spring:theme code="confirmation.page.over.paid.amount" /> ${ycommerce:encodeHTML(billData.receiptInfo.currency)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${billData.receiptInfo.overPaidAmount}" /></strong>
											</div>
										</c:if>
										<div>
											<spring:theme code="confirmation.page.bill.total" />
											${ycommerce:encodeHTML(billData.receiptInfo.currency)}
											<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${billData.bill.totalBillAmount}" />
										</div>
										<div>
											<spring:theme code="confirmation.page.date.paid" />
											&nbsp;
											<fmt:formatDate value="${billData.receiptInfo.paidDate}" type="date" />
										</div>
										<c:if test="${billData.receiptInfo.outstandingAmount > 0 }">
											<div>
												<spring:theme code="confirmation.page.bill.due.date" />
												&nbsp;
												<fmt:formatDate value="${billData.bill.billDueDate}" type="date" />
											</div>
										</c:if>
									</div>
								</div>
								<!-- Bill Details ends -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-md-4 download-bill-pdf">
			<div class="card-50 col-xs-12 col-sm-12 col-md-12">
				<div class="card-section-content">
					<p>
						<span class="icon-file-pdf gi-2.5x"></span> <a href="${billReceiptURL}?billCode=${ycommerce:encodeUrl(billData.bill.code)}&receiptId=${ycommerce:encodeUrl(billData.receiptInfo.transactionId)}" class="bill-receipt-download-pdf" target="_blank"> <spring:theme code="text.download.receipt.pdf" />&nbsp;&nbsp;<span class="glyphicon glyphicon-download-alt"></span></a>
					</p>
				</div>
			</div>
			<div data-spy="affix" data-offset-top="160" data-offset-bottom="500" class="affix"></div>
		</div>
	</div>
</template:page>