<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/bills/receipt/pdf" var="billReceiptURL" />
<spring:url value="/my-account/my-assets" var="myAssetsUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<div class="row no-margin  global-content-space">
			<div class="account-section-content">
				<div class="back-link border">
					<div class="row">
						<div class="col-md-6">
							<button type="button" class="addressBackBtn" data-back-to-addresses="${myAssetsUrl}">
								<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
							</button>
							<h1 class="custom-h1">
									<span class="label" tabindex="0">${asset.assetName}</span>
							</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 asset-detail">
					<c:if test="${not empty fn:trim(assetAttributes)}">
						<div class="row oddrow no-margin">
							<div class="col-md-12">
									<img class="asset-logo" src="${asset.assetType.iconMediaURL}" alt="${asset.assetType.name}" title="${asset.assetType.name}"/>
									<h2><span tabindex="0"><spring:theme code="text.account.assetsDetails.attributes.heading" arguments="${asset.assetType.name}" /></span></h2>
							</div>
							${assetAttributes}
						</div>
					</c:if>

                     <c:if test="${not empty asset.assetBills}">
						<div class="row evenrow">
							<div class="col-md-12">
								<h2 tabindex="0">
									<!-- <img class="asset-logo" src="/images/bills.png" alt="" title="">  --><spring:theme code="text.account.myBills" />
								</h2>
							</div>
							<ul class="bill-list">
								<c:forEach items="${asset.assetBills}" var="bill">
									<li class="col-sm-12 col-md-6 bill-listing-card-cell">
										<div class="bill-listing-card">
										<div class="row no-margin">
											<div class="col-md-12 ">
												<span class="bill-title" tabindex="0">${ycommerce:encodeHTML(bill.billDescription)}</span>
											</div>
											<div class="col-sm-6 hidden-xs">
												<div tabindex="0">
													<Strong><spring:theme code="text.bill.due.date" />: <fmt:formatDate value="${bill.billDueDate}" dateStyle="MEDIUM" timeStyle="short" type="date" /></Strong>
												</div>
											</div>
											<div class="col-sm-6 text-right hidden-xs">
												<div tabindex="0">
													<Strong><spring:theme code="text.amount.due" />: ${ycommerce:sanitizeHTML(bill.currency.symbol)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bill.outstandingBillAmount}" /></Strong>
												</div>
											</div>
											<div class="col-sm-6 visible-xs">
												<div tabindex="0">
													<Strong><spring:theme code="text.amount.due" />: ${ycommerce:sanitizeHTML(bill.currency.symbol)}<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bill.outstandingBillAmount}" /></Strong>
												</div>
											</div>
											<div class="col-sm-6 visible-xs">
												<div tabindex="0">
													<Strong><spring:theme code="text.bill.due.date" />: <fmt:formatDate value="${bill.billDueDate}" dateStyle="MEDIUM" timeStyle="short" type="date" /></Strong>
												</div>
											</div>
											</div>
											<div class="row bills-asset-details">
											<div class="col-sm-6 download-pdf">
												<span class="icon-file-pdf gi-2.5x"></span><a href="${bill.fullBillUrl}"><spring:theme code="text.download.bill.as.pdf" /></a>
											</div>
											<div class="col-sm-6 text-right paynow-btn">
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
														<div class="asset-billtype-message">
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
														<div class="asset-billtype-message">
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
														<div class="asset-billtype-message">
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
													<div class="asset-bills-pdf">
														<span class="icon-file-pdf gi-2.5x"></span> <a href="${billReceiptURL}?billCode=${ycommerce:encodeUrl(bill.code)}&receiptId=${ycommerce:encodeUrl(bill.transactionInfos[fn:length(bill.transactionInfos) - 1].transactionId)}" class="bill-receipt-download-pdf" target="_blank"> <span class="download-text"><spring:theme code="text.download.receipt.as.pdf" htmlEscape="false" var="downloadReceiptAsPdf"/>
														${ycommerce:sanitizeHTML(downloadReceiptAsPdf)}
														</span>
															<fmt:formatDate value="${bill.transactionInfos[fn:length(bill.transactionInfos) - 1].paidDate}" dateStyle="MEDIUM" timeStyle="short" type="date" />
														</a>
													</div>
												</c:if>
											</div>
											</div>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>