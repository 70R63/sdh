<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="bills" tagdir="/WEB-INF/tags/addons/sdhbillsaddon/responsive/bills"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhbillsaddon/responsive/formElement"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="addOntemplate" tagdir="/WEB-INF/tags/addons/sdhbillsaddon/responsive/template"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<addOntemplate:psJavaScriptVariables />
<spring:url value="${source}" var="cancelUrl" />
<spring:url value="/bills/receipt/pdf" var="billReceiptURL" />
<spring:theme code="text.bill.moreInfo.accessibility" var="moreInfoBack" />
<template:page pageTitle="${pageTitle}">
	<c:url value="/bills/hop-mock" var="customMockHopURL" />
	<input type="hidden" id="hopDebugMode" data-hop-debug-mode="${hopDebugMode}" />

	<spring:url value="/_ui/common/images/spinner.gif" var="spinnerUrl" />
	<div class="row no-margin bill-payment content-space">
		<div id="item_container_holder">
			<div class="account-section">
				<div class="account-section-content">
					<div class="bill-section-content row no-margin">
						<div class="col-xs-12 col-sm-10 col-md-10 no-space">
							<div class="bills-steps">
								<c:choose>
									<c:when test="${isBillPaid eq true}">
										<div class="back-link border">
											<div class="row">
												<div class="col-md-6">
													<button type="button" class="addressBackBtn" data-back-to-addresses="${cancelUrl}">
														<span class="glyphicon glyphicon-chevron-left" aria-label="${moreInfoBack}"></span>
													</button>
													<h1 class="custom-h1">
														<span class="label" tabindex="0"><spring:theme code="bill.pay.paid.heading" /></span>
													</h1>
												</div>
											</div>
										</div>
										<p tabindex="0">
											<span><spring:theme code="bill.pay.paid.text" /></span>
										</p>

										<sec:authorize access="!hasRole('ROLE_ANONYMOUS')">
										<div class="col-xs-12 col-sm-6 row">
											<c:forEach items="${bill.transactionInfos}" var="transaction">
												<div class="card bill-section col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<div class="row">
														<div class="col-xs-12">
															<span class="icon-file-pdf gi-1.5x"></span> <a href="${billReceiptURL}?billCode=${ycommerce:encodeHTML(bill.code)}&receiptId=${ycommerce:encodeHTML(transaction.transactionId)}" class="bill-receipt-download-pdf" target="_blank"> <span class="download-text"><spring:theme code="text.download.receipt.pdf" /></span>
															</a>
														</div>
													</div>
												</div>
											</c:forEach>
										 </div>
										</sec:authorize>
										<br>
										<hr>
										<br>

										<bills:billInfo />

										<c:when test="${isPaymentAllowed eq false && isBillOverDue eq true}">
											<div class="back-link border">
												<div class="row">
													<div class="col-md-6">
														<button type="button" class="addressBackBtn" data-back-to-addresses="${cancelUrl}">
															<span class="glyphicon glyphicon-chevron-left" aria-label="${moreInfoBack}"></span>
														</button>
														<h1 class="custom-h1">
															<span class="label" tabindex="0"><spring:theme code="bill.pay.payment.not.allowed.heading" /></span>
														</h1>
													</div>
												</div>
											</div>
											<p>
												<span><spring:theme code="bill.pay.payment.not.allowed.text" htmlEscape="false" var="billPaymentNotAllowed" />
												${ycommerce:sanitizeHTML(billPaymentNotAllowed)}	
												</span>
											</p>
											<hr>
											<br>
											<bills:billInfo />
										</c:when>

									</c:when>
									<c:when test="${isBillOverDue eq true}">
										<div class="back-link border">
											<div class="row">
												<div class="col-md-6">
													<button type="button" class="addressBackBtn" data-back-to-addresses="${cancelUrl}">
														<span class="glyphicon glyphicon-chevron-left" aria-label="${moreInfoBack}"></span>
													</button>
													<h1 class="custom-h1">
														<span class="label" tabindex="0"><spring:theme code="bill.pay.overdue.heading" /></span>
													</h1>
												</div>
											</div>
										</div>

										<p>
											<span><spring:theme code="bill.pay.overdue.text" htmlEscape="false" var="billOverDueText"/>
											${ycommerce:sanitizeHTML(billOverDueText)}
											</span>
										</p>
										<hr>
										<br>
										<bills:billInfo />
									</c:when>


									<c:when test="${isPaymentAllowed eq false}">
										<div class="back-link border">
											<div class="row">
												<div class="col-md-6">
													<button type="button" class="addressBackBtn" data-back-to-addresses="${cancelUrl}">
														<span class="glyphicon glyphicon-chevron-left" aria-label="${moreInfoBack}"></span>
													</button>
													<h1 class="custom-h1">
														<span class="label" tabindex="0"><spring:theme code="bill.pay.payment.not.allowed.heading" /></span>
													</h1>
												</div>
											</div>
										</div>
										<p>
											<span><spring:theme code="bill.pay.payment.not.allowed.text" htmlEscape="false" var="billPaymentNotAllowed"/>
											${ycommerce:sanitizeHTML(billPaymentNotAllowed)}	
											</span>
										</p>
										<hr>
										<br>
										<bills:billInfo />
									</c:when>

									<c:otherwise>
										<div class="back-link border">
											<div class="row">
												<div class="col-md-6">
													<button type="button" class="addressBackBtn" data-back-to-addresses="${cancelUrl}">
														<span class="glyphicon glyphicon-chevron-left" aria-label="${moreInfoBack}"></span>
													</button>
													<h1 class="custom-h1">
														<span class="label" tabindex="0"><c:if test="${empty billCustomer}">
																<spring:theme code="bill.pay.heading" />
															</c:if> <c:if test="${not empty billCustomer}">
																<spring:theme code="bill.pay.heading.customer" arguments="${billCustomer.firstName} ${billCustomer.lastName }" />
															</c:if></span>
													</h1>
												</div>
											</div>
										</div>
										<p>
											<span> <c:if test="${empty billCustomer}">
													<spring:theme code="bill.pay.text" />
												</c:if> <c:if test="${not empty billCustomer}">
													<spring:theme code="bill.pay.text.customer" arguments="${billCustomer.firstName} ${billCustomer.lastName }" />
												</c:if>
											</span>
										</p>

										<bills:billInfo />

										<hr>


										<!-- 	<div class="item_container"> -->

										<form:form id="customHostedOrderPagePostForm" name="customHostedOrderPagePostForm" commandName="billPaymentForm" action="${customMockHopURL}" method="POST">
											<input type="hidden" name="source" id="source" value='${source}' />
											<input type="hidden" id="billCode" name="billCode" value="${ycommerce:encodeHTML(bill.code)}" />
											<c:if test="${isPartPaymentAllowed eq true}">
												<div class="row">
													<div class="form-group">
														<div class="bill-amount bill-hop col-md-6 col-sm-6 col-xs-6">
															<p>
																<formElement:formInputBox idKey="partial_amount" labelKey="bill.pay.outstandingAmount.text" path="amount" inputCSS="form-control bill-amount-input" mandatory="true" tabindex="0" autocomplete="off" textBoxPrefix="${ycommerce:sanitizeHTML(bill.currency.symbol)}" />
																<br />
															</p>
														</div>
														<spring:theme code="bill.help.text" var="billHelpText" />
														<spring:theme code="bill.pay.help.message" var="billHelpMessage" />
														<div class="visible-xs visible-sm col-md-6 col-sm-6 col-xs-6">
															<span class="js-billHelp-mobile pull-right glyphicon glyphicon-question-sign" aria-label="${billHelpText}" tabindex="0"></span>
														</div>
														<div class="visible-md visible-lg bill-popover col-md-6 col-sm-6 col-xs-6">
																<span class="js-billHelp-desktop pull-right glyphicon glyphicon-question-sign" title="<spring:theme code="bill.pay.help.message" />" tabindex="0">
																<span class="acc_hidden"><spring:theme code="bill.pay.help.popup.heading" /></span></span>
														</div>
													</div>
												</div>
											</c:if>
											<c:if test="${isPartPaymentAllowed eq false}">
												<input type="hidden" id="amount" name="amount" value="${bill.outstandingBillAmount}" />
											</c:if>
											<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
												<div class="form-group">
													<formElement:formInputBox idKey="emailAddress" labelKey="address.emailAddress" path="emailAddress" inputCSS="form-control" tabindex="0" mandatory="true" />
												</div>
											</sec:authorize>

											<div class="row bills-buttons">
												<div class="col-md-12">
													<div class="col-xs-12 col-sm-5 col-md-3 ">
														<button tabindex="22" type="button" onclick="window.location='${cancelUrl}'" class="btn btn-grey btn-block checkout-cancel">
															<spring:theme code="bill.pay.cancel" />
														</button>
													</div>
													<div class="col-xs-12 col-sm-5 col-md-4 ">
														<button tabindex="23" type="submit" class="btn btn-primary btn-block checkout-next submit_billPaymentForm">
															<spring:theme code="bill.pay.next" />
														</button>
													</div>
												</div>
											</div>


										</form:form>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="savedbillHelp">
			<div id="savedbillttitle">
				<div class="headline">
					<span class="headline-text" tabindex="0"><spring:theme code="bill.pay.help.popup.heading" /></span>
				</div>
			</div>
			<div id="savedbillbody">
				<spring:theme code="bill.pay.help.message" var="billHelpMessage" />
				<div aria-label="${billHelpMessage}" tabindex="0">
					<spring:theme code="bill.pay.help.message" />
				</div>
			</div>
		</div>
	</div>
</template:page>
