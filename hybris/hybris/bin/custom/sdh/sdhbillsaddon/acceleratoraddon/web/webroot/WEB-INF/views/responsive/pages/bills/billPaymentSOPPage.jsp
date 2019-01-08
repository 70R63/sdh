<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhbillsaddon/responsive/formElement" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="address" tagdir="/WEB-INF/tags/addons/sdhbillsaddon/responsive/address" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bills" tagdir="/WEB-INF/tags/addons/sdhbillsaddon/responsive/bills" %>
<%@ taglib prefix="addOntemplate" tagdir="/WEB-INF/tags/addons/sdhbillsaddon/responsive/template" %>
<spring:htmlEscape defaultHtmlEscape="true"/>

<addOntemplate:psJavaScriptVariables/>
<template:page pageTitle="${pageTitle}">
    <c:url value="" var="choosePaymentMethodUrl"/>
    <spring:url value="${source}" var="cancelUrl"/>
    <spring:url value="/bills/receipt/pdf" var="billReceiptURL"/>
    <spring:url value="/bills/sop/response" var="customSOPResponseUrl"/>
    <spring:theme code="text.bill.moreInfo.accessibility" var="moreInfoBack"/>
    <input type="hidden" name="customSOPResponseUrl" id="customSOPResponseUrl" value='${customSOPResponseUrl}'/>
    <div class="row no-margin bill-payment content-space">
        <div class="account-section">
            <div class="account-section-content">
                <div class="bill-section-content row">
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
                                            <span class="label" tabindex="0"><spring:theme code="bill.pay.paid.heading"/></span>
                                        </h1>
                                    </div>
                                </div>
                            </div>
                            <p tabindex="0">
                                <span><spring:theme code="bill.pay.paid.text"/></span>
                            </p>

                            <sec:authorize access="!hasRole('ROLE_ANONYMOUS')">
                               <div class="col-xs-12 col-sm-6 row">
                                  <c:forEach items="${bill.transactionInfos}" var="transaction">
                                    <div class="card bill-section col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <span class="icon-file-pdf gi-1.5x"></span> <a
                                                    href="${billReceiptURL}?billCode=${ycommerce:encodeHTML(bill.code)}&receiptId=${ycommerce:encodeHTML(transaction.transactionId)}"
                                                    class="bill-receipt-download-pdf" target="_blank"> <span
                                                    class="download-text"><spring:theme code="text.download.receipt.pdf"/></span>
                                               </a>
                                            </div>
                                        </div>
                                    </div>
                                   </c:forEach>
                                </div>
                            </sec:authorize>
                            <hr>
                            <br>
                            <bills:billInfo/>
                        </c:when>

                        <c:when test="${isPaymentAllowed eq false && isBillOverDue eq true}">
                            <div class="back-link border">
                                <div class="row">
                                    <div class="col-md-6">
                                        <button type="button" class="addressBackBtn" data-back-to-addresses="${cancelUrl}">
                                            <span class="glyphicon glyphicon-chevron-left" aria-label="${moreInfoBack}"></span>
                                        </button>
                                        <h1 class="custom-h1">
                                            <span class="label" tabindex="0"><spring:theme
                                                    code="bill.pay.payment.not.allowed.heading"/></span>
                                        </h1>
                                    </div>
                                </div>
                            </div>
                            <p>
                                <spring:theme code="bill.pay.payment.not.allowed.text" htmlEscape="false" var="billPaymentNotAllowed"/>
                                <span>${ycommerce:sanitizeHTML(billPaymentNotAllowed)}</span>	
                            </p>
                            <hr>
                            <br>
                            <bills:billInfo/>
                        </c:when>

                        <c:when test="${isBillOverDue eq true}">
                            <div class="back-link border">
                                <div class="row">
                                    <div class="col-md-6">
                                        <button type="button" class="addressBackBtn" data-back-to-addresses="${cancelUrl}">
                                            <span class="glyphicon glyphicon-chevron-left" aria-label="${moreInfoBack}"></span>
                                        </button>
                                        <h1 class="custom-h1">
                                            <span class="label" tabindex="0"><spring:theme code="bill.pay.overdue.heading"/></span>
                                        </h1>
                                    </div>
                                </div>
                            </div>
                            <p>
                                <spring:theme code="bill.pay.overdue.text" htmlEscape="false" var="billOverDueText"/>
                                ${ycommerce:sanitizeHTML(billOverDueText)}	
                            </p>
                            <hr>
                            <br>
                            <bills:billInfo/>
                        </c:when>

                        <c:when test="${isPaymentAllowed eq false}">
                            <div class="back-link border">
                                <div class="row">
                                    <div class="col-md-6">
                                        <button type="button" class="addressBackBtn" data-back-to-addresses="${cancelUrl}">
                                            <span class="glyphicon glyphicon-chevron-left" aria-label="${moreInfoBack}"></span>
                                        </button>
                                        <h1 class="custom-h1">
                                            <span class="label" tabindex="0"><spring:theme
                                                    code="bill.pay.payment.not.allowed.heading"/></span>
                                        </h1>
                                    </div>
                                </div>
                            </div>
                            <p>
                                <spring:theme code="bill.pay.payment.not.allowed.text" htmlEscape="false" var="billPaymentNotAllowed"/>
                               <span>${ycommerce:sanitizeHTML(billPaymentNotAllowed)}</span>
                            </p>
                            <hr>
                            <br>
                            <bills:billInfo/>
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
                                                    <spring:theme code="bill.pay.heading"/>
                                                </c:if> <c:if test="${not empty billCustomer}">
                                                    <spring:theme code="bill.pay.heading.customer"
                                                                  arguments="${billCustomer.firstName} ${billCustomer.lastName }"/>
                                                </c:if></span>
                                    </h1>
                                </div>
                            </div>
                        </div>
                        <p>
									<span> <c:if test="${empty billCustomer}">
                                        <spring:theme code="bill.pay.text"/>
                                    </c:if> <c:if test="${not empty billCustomer}">
                                        <spring:theme code="bill.pay.text.customer"
                                                      arguments="${billCustomer.firstName} ${billCustomer.lastName}"/>
                                    </c:if>
									</span>
                        </p>
                        <bills:billInfo/>
                        <hr>
                        <div class="bill-requiredfield">
                            <spring:theme code="bill.pay.fieldsRequired" htmlEscape="false"/>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 no-space">
                        <div class="checkout-step-paymentmethod bills-steps">
                            <div class="checkout-indent">
                                <ycommerce:testId code="paymentDetailsForm">
                                <form:form id="billPaymentForm" name="billPaymentForm" commandName="billPaymentForm"
                                           action="${paymentFormUrl}" method="POST">
                                <input type="hidden" name="source" id="source" value='${source}'/>

                                    <%--check if the bill pay form was set correctly--%>
                                <c:choose>
                                <c:when test="${not empty isPartPaymentAllowed}">

                                <c:if test="${isPartPaymentAllowed eq true}">
                                    <div class="row">
                                        <div class="form-group">
                                            <div class="bill-amount col-md-6 col-sm-6 col-xs-6">
                                                <p>
                                                    <formElement:formInputBox idKey="partial_amount"
                                                                              labelKey="bill.pay.outstandingAmount.text" path="amount"
                                                                              inputCSS="form-control bill-amount-input" mandatory="true"
                                                                              tabindex="0" autocomplete="off"
                                                                              textBoxPrefix="${ycommerce:sanitizeHTML(bill.currency.symbol)}"/>
                                                </p>
                                            </div>
                                            <spring:theme code="bill.help.text" var="billHelpText"/>
                                            <spring:theme code="bill.pay.help.message" var="billHelpMessage"/>
                                            <div class="visible-xs visible-sm col-md-6 col-sm-6 col-xs-6 bill-helpIcon">
                                                <span class="js-billHelp-mobile pull-right glyphicon glyphicon-question-sign"
                                                      aria-label="${billHelpText}" tabindex="0"></span>
                                            </div>
                                            <div class="visible-md visible-lg bill-popover col-md-6 col-sm-6 col-xs-6 bill-helpIcon">
                                                <span class="js-billHelp-desktop pull-right glyphicon glyphicon-question-sign" title='<spring:theme code="bill.pay.help.message" />' tabindex="0">
                                                <span class="acc_hidden"><spring:theme code="bill.pay.help.popup.heading" /></span></span>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${isPartPaymentAllowed eq false}">
                                    <form:hidden path="amount" value="${ycommerce:encodeHTML(bill.outstandingBillAmount)}"/>
                                </c:if>


                                <div class="headline">
                                    <h3>
                                        <span tabindex="0"><strong><spring:theme code="bill.pay.paymentMethod"/></strong></span>
                                    </h3>
                                </div>
                                <br/>
                                <div class="use-Bill-Payment-trigger">
                                    <input type="hidden" name="orderPage_receiptResponseURL"
                                           value="${ycommerce:encodeHTML(silentOrderPageData.parameters['orderPage_receiptResponseURL'])}"/>
                                    <input type="hidden" name="orderPage_declineResponseURL"
                                           value="${ycommerce:encodeHTML(silentOrderPageData.parameters['orderPage_declineResponseURL'])}"/>
                                    <input type="hidden" name="orderPage_cancelResponseURL"
                                           value="${ycommerce:encodeHTML(silentOrderPageData.parameters['orderPage_cancelResponseURL'])}"/>
                                    <c:forEach items="${billPaymentForm.signatureParams}" var="entry" varStatus="status">
                                        <input type="hidden" id="${ycommerce:encodeHTML(entry.key)}"
                                               name="${ycommerce:encodeHTML(entry.key)}" value="${ycommerce:encodeHTML(entry.value)}"/>
                                    </c:forEach>
                                    <c:forEach items="${billPaymentForm.subscriptionSignatureParams}" var="entry" varStatus="status">
                                        <input type="hidden" id="${ycommerce:encodeHTML(entry.key)}"
                                               name="${ycommerce:encodeHTML(entry.key)}" value="${ycommerce:encodeHTML(entry.value)}"/>
                                    </c:forEach>
                                    <input type="hidden" value="${ycommerce:encodeHTML(silentOrderPageData.parameters['billTo_email'])}"
                                           name="billTo_email" id="billTo_email">

                                    <div class="form-group">
                                        <c:if test="${not empty paymentInfos}">
                                            <div class="row">
                                                <div class="col-xs-12 col-sm-6 no-space">
                                                    <button type="button" tabindex="0"
                                                            class="btn btn-default btn-block js-billsaved-payments">
                                                        <spring:theme code="bill.paymentMethod.addPaymentDetails.useSavedCard"/>
                                                    </button>
                                                </div>
                                            </div>
                                        </c:if>
                                    </div>

                                    <div class="row">
                                        <formElement:formSelectBox idKey="card_cardType" labelKey="payment.cardType" path="card_cardType"
                                                                   selectCSSClass="form-control" mandatory="true" skipBlank="false"
                                                                   skipBlankMessageKey="payment.cardType.pleaseSelect"
                                                                   items="${sopCardTypes}" tabindex="0"/>
                                    </div>

                                    <div class="row">
                                        <formElement:formInputBox idKey="card_nameOnCard" labelKey="payment.nameOnCard"
                                                                  path="card_nameOnCard" inputCSS="form-control" tabindex="0"
                                                                  maxlength="255"/>
                                    </div>

                                    <div class="row">
                                        <formElement:formInputBox idKey="card_accountNumber" labelKey="payment.cardNumber"
                                                                  path="card_accountNumber" inputCSS="form-control" mandatory="true"
                                                                  tabindex="0" autocomplete="off"/>
                                    </div>

                                    <div class="row">
                                        <fieldset id="startDate" class="start-date">
                                            <label for="" class="control-label required"><spring:theme code="payment.startDate"/></label>
                                            <div class="row">
                                                <div class="col-xs-6 expiry_month">
                                                    <formElement:formSelectBox idKey="StartMonth" selectCSSClass="form-control"
                                                                               labelKey="payment.month" path="card_startMonth"
                                                                               mandatory="true" skipBlank="false"
                                                                               skipBlankMessageKey="payment.month" items="${months}"
                                                                               tabindex="0"/>
                                                </div>
                                                <div class="col-xs-6 expiry_year">
                                                    <formElement:formSelectBox idKey="StartYear" selectCSSClass="form-control"
                                                                               labelKey="payment.year" path="card_startYear"
                                                                               mandatory="true" skipBlank="false"
                                                                               skipBlankMessageKey="payment.year" items="${startYears}"
                                                                               tabindex="0"/>
                                                </div>
                                            </div>
                                        </fieldset>
                                    </div>

                                    <div class="row">
                                        <fieldset class="card-date">
                                            <label for="" class="control-label bills-expiry-date required"><spring:theme
                                                    code="payment.expiryDate"/></label>
                                            <div class="row">
                                                <div class="col-xs-6 expiry_month">
                                                    <formElement:formSelectBox idKey="ExpiryMonth" selectCSSClass="form-control"
                                                                               labelKey="payment.month" path="card_expirationMonth"
                                                                               mandatory="true" skipBlank="false"
                                                                               skipBlankMessageKey="payment.month" items="${months}"
                                                                               tabindex="0"/>
                                                </div>
                                                <div class="col-xs-6 expiry_year">
                                                    <formElement:formSelectBox idKey="ExpiryYear" selectCSSClass="form-control"
                                                                               labelKey="payment.year" path="card_expirationYear"
                                                                               mandatory="true" skipBlank="false"
                                                                               skipBlankMessageKey="payment.year" items="${expiryYears}"
                                                                               tabindex="0"/>
                                                </div>
                                            </div>
                                        </fieldset>
                                    </div>

                                    <div class="row">
                                        <div>
                                            <formElement:formInputBox idKey="card_cvNumber" labelKey="payment.cvn" path="card_cvNumber"
                                                                      inputCSS="form-control" mandatory="true" tabindex="0" maxlength=""/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <div id="issueNum">
                                                <formElement:formInputBox idKey="card_issueNumber" labelKey="payment.issueNumber"
                                                                          path="card_issueNumber" inputCSS="text" mandatory="false"
                                                                          tabindex="0"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="headline">
                                        <h3>
                                            <span tabindex="0"><strong><spring:theme
                                                    code="bill.paymentMethod.addPaymentDetails.billingAddress"/></strong></span>
                                        </h3>
                                    </div>

                                    <div id="addressDefaultCountry" data-countryIsoCode="${defaultCountry}"></div>
                                    <c:if test="${ not empty primaryAddress }">
                                        <div id="useBillPrimaryAddressData" data-title="${ycommerce:encodeHTML(primaryAddress.title)}"
                                             data-firstname="${ycommerce:encodeHTML(primaryAddress.firstName)}"
                                             data-lastname="${ycommerce:encodeHTML(primaryAddress.lastName)}"
                                             data-line1="${ycommerce:encodeHTML(primaryAddress.line1)}"
                                             data-line2="${ycommerce:encodeHTML(primaryAddress.line2)}"
                                             data-town="${ycommerce:encodeHTML(primaryAddress.town)}"
                                             data-postalcode="${ycommerce:encodeHTML(primaryAddress.postalCode)}"
                                             data-countryisocode="${ycommerce:encodeHTML(primaryAddress.country.isocode)}"
                                             data-regionisocode="${ycommerce:encodeHTML(primaryAddress.region.isocodeShort)}"
                                             data-address-id="${ycommerce:encodeHTML(primaryAddress.id)}"></div>
                                        <formElement:formCheckbox path="usePrimaryAddress" idKey="useBillPrimaryAddress"
                                                                  labelKey="bill.sop.useMyPrimaryAddress" labelCSS="useBillPrimaryAddress"
                                                                  tabindex="0"/>
                                    </c:if>

                                    <input type="hidden" value="${isPaymentAddressAvailable}" name="isPaymentAddressAvailable"
                                           id="isPaymentAddressAvailable">
                                    <form:hidden path="usePaymentInfo"/>
                                    <form:hidden path="billCode" value="${ycommerce:encodeHTML(bill.code)}"/>
                                    <form:hidden path="paymentId" value=""/>
                                    <div id="billaddressbook" class="bill-address-book">
                                        <div id="billaddressbooktitle">
                                            <div class="headline">
                                                <span class="headline-text" tabindex="0"><spring:theme
                                                        code="bill.primaryAddress.savedAddress"/></span>
                                            </div>
                                        </div>
                                        <div id="billaddressbookBody">
                                            <c:forEach items="${deliveryAddresses}" var="deliveryAddress" varStatus="status">
                                                <div class="addressEntry">
                                                    <div aria-labelledby="addressBookDialog" tabindex="0">
                                                        <ul id="addressBookDialog">
                                                            <li>
                                                                <strong>${fn:escapeXml(deliveryAddress.title)}&nbsp; ${fn:escapeXml(deliveryAddress.firstName)}&nbsp; ${fn:escapeXml(deliveryAddress.lastName)}</strong>
                                                                <br> ${fn:escapeXml(deliveryAddress.line1)}&nbsp; ${fn:escapeXml(deliveryAddress.line2)}
                                                                <br> ${fn:escapeXml(deliveryAddress.town)} <c:if
                                                                    test="${not empty deliveryAddress.region.name}">
                                                                &nbsp;${fn:escapeXml(deliveryAddress.region.name)}
                                                            </c:if>
                                                                <br> ${fn:escapeXml(deliveryAddress.country.name)}&nbsp; ${fn:escapeXml(deliveryAddress.postalCode)}
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary btn-block btn-billbilling-address"
                                                            data-addresscode="${deliveryAddress.id}"
                                                            data-countryisocode="${deliveryAddress.country.isocode}">
                                                        <spring:theme code="bill.primaryAddress.useThisAddress" text="Use this Address"/>
                                                    </button>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <c:if test="${not empty deliveryAddresses}">
                                        <div class="row">
                                            <div class="col-xs-12 col-sm-6 no-space">
                                                <button tabindex="0" type="button" class="btn btn-default btn-block js-billaddress-book">
                                                    <spring:theme code="bill.primaryAddress.viewAddressBook" text="Address Book"/>
                                                </button>
                                            </div>
                                        </div>
                                    </c:if>
                                    </br>
                                    <input type="hidden" value="${ycommerce:encodeHTML(silentOrderPageData.parameters['billTo_email'])}"
                                           class="text" name="billTo_email" id="billTo_email">
                                    <address:billAddressFormSelector supportedCountries="${countries}" regions="${regions}" tabindex="0"/>
                                    <sec:authorize access="!hasRole('ROLE_ANONYMOUS')">
                                        <formElement:formCheckbox idKey="saveBillPaymentMethod" labelKey="bill.sop.savePaymentInfo"
                                                                  path="savePaymentInfo" inputCSS="" labelCSS="saveBillPaymentMethod"
                                                                  mandatory="false" tabindex="0"/>
                                        <form:hidden path="emailAddress" value="${ycommerce:encodeHTML(loggedInUserEmailAddress)}"/>
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
                                        <div class="row">
                                            <formElement:formInputBox idKey="emailAddress" labelKey="address.emailAddress"
                                                                      path="emailAddress" inputCSS="form-control" tabindex="0"
                                                                      mandatory="true"/>
                                        </div>
                                    </sec:authorize>
                                </div>
                            </div>
                        </div>

                        <div class="card-section-content bill-card-content bills-steps">
                            <div class="col-xs-12 col-sm-8 col-md-8 bill-card">
                                <div class="row">
                                    <div class="card col-xs-12 col-sm-12 col-md-12">
                                        <div class="saved-payment-entry bill-card-details">

                                            <div class="account-cards-actions pull-right">
                                                <ycommerce:testId code="paymentDetails_deletePayment_button">
                                                    <spring:theme code="bill.page.paymentDetails.removeIcon.accessibility.text"
                                                                  var="removeBillPayment"/>
                                                    <span aria-label="${removeBillPayment}" tabindex="0"><span
                                                            class="glyphicon glyphicon-trash gi-2x action-links removeBillPaymentButton"></span></span>
                                                </ycommerce:testId>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row bills-steps bills-steps-buttons">
                            <div class="col-md-12">
                                <div class="col-xs-12 col-sm-5 col-md-3 ">
                                    <button tabindex="0" type="button" onclick="window.location='${cancelUrl}'"
                                            class="btn btn-grey btn-block checkout-cancel">
                                        <spring:theme code="bill.pay.cancel"/>
                                    </button>
                                </div>
                                <div class="col-xs-12 col-sm-5 col-md-4 ">
                                    <button tabindex="0" type="submit"
                                            class="btn btn-primary btn-block checkout-next submit_billPaymentForm">
                                        <spring:theme code="bill.pay.next"/>
                                    </button>
                                </div>
                            </div>
                        </div>


                        </c:when>
                        <c:otherwise>
                            <spring:theme code="bill.pay.payment.form.error"/>
                        </c:otherwise>
                        </c:choose>


                        </form:form>
                        </ycommerce:testId>
                        </c:otherwise>

                        </c:choose>
                    </div>
                </div>


            </div>
        </div>

        <c:if test="${not empty paymentInfos}">
            <div id="billsavedpayments" class="bill-saved-payments">
                <div id="billsavedpaymentstitle">
                    <div class="headline">
                        <span class="headline-text" tabindex="0"><spring:theme
                                code="bill.paymentMethod.addPaymentDetails.useSavedCard"/></span>
                    </div>
                </div>
                <div id="billsavedpaymentsbody">
                    <c:forEach items="${paymentInfos}" var="paymentInfo" varStatus="status">
                        <div class="saved-payment-entry">
                            <input type="hidden" class="selectedPaymentMethod" name="selectedPaymentMethodId"
                                   value="${ycommerce:encodeHTML(paymentInfo.id)}"/>
                            <div aria-labelledby="savedCarddialog">
                                <ul id="savedCarddialog">
                                    <strong>${fn:escapeXml(paymentInfo.billingAddress.firstName)}&nbsp; ${fn:escapeXml(paymentInfo.billingAddress.lastName)}</strong>
                                    <br/> ${fn:escapeXml(paymentInfo.cardTypeData.name)}
                                    <br/> ${fn:escapeXml(paymentInfo.cardNumber)}
                                    <br/>
                                    <spring:theme code="bill.paymentMethod.paymentDetails.expires"
                                                  arguments="${fn:escapeXml(paymentInfo.expiryMonth)},${fn:escapeXml(paymentInfo.expiryYear)}"/>
                                    <br/> ${fn:escapeXml(paymentInfo.billingAddress.line1)}
                                    <br/> ${fn:escapeXml(paymentInfo.billingAddress.town)}&nbsp; ${fn:escapeXml(paymentInfo.billingAddress.region.isocodeShort)}
                                    <br/> ${fn:escapeXml(paymentInfo.billingAddress.postalCode)}&nbsp; ${fn:escapeXml(paymentInfo.billingAddress.country.isocode)}
                                    <br/>
                                </ul>
                            </div>
                            <button type="button" class="btn btn-primary btn-block use-bill-Payment-Details" tabindex="0">
                                <spring:theme code="bill.paymentMethod.addPaymentDetails.useThesePaymentDetails"/>
                            </button>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:if>
        <div id="savedbillHelp" class="saved-bill-help">
            <div id="savedbillttitle">
                <div class="headline">
                    <span class="headline-text" tabindex="0"><spring:theme code="bill.pay.help.popup.heading"/></span>
                </div>
            </div>
            <div id="savedbillbody">
                <spring:theme code="bill.pay.help.message" var="billHelpMessage"/>
                <div aria-label="${billHelpMessage}" tabindex="0">
                    <spring:theme code="bill.pay.help.message"/>
                </div>
            </div>
        </div>
    </div>
</template:page>
