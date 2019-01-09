<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="address" tagdir="/WEB-INF/tags/responsive/address"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<c:url value="${currentStepUrl}" var="choosePaymentMethodUrl" />
<template:page pageTitle="${pageTitle}">
	<div class="col-sm-8 col-md-8">
		
		<div class="row">
					<div class="checkout-indent">
						<div class="checkout-paymentmethod">
							<div class="headline">
									<spring:theme code="checkout.multi.paymentMethod" />
								</div>
							<c:if test="${not empty paymentFormUrl}">
								<ycommerce:testId code="paymentDetailsForm">

									<form:form id="silentOrderPostForm" name="silentOrderPostForm" commandName="sopPaymentDetailsForm" action="${paymentFormUrl}" method="POST">
										<input type="hidden" name="orderPage_receiptResponseURL" value="${ycommerce:encodeHTML(silentOrderPageData.parameters['orderPage_receiptResponseURL'])}" />
										<input type="hidden" name="orderPage_declineResponseURL" value="${ycommerce:encodeHTML(silentOrderPageData.parameters['orderPage_declineResponseURL'])}" />
										<input type="hidden" name="orderPage_cancelResponseURL" value="${ycommerce:encodeHTML(silentOrderPageData.parameters['orderPage_cancelResponseURL'])}" />
										<c:forEach items="${sopPaymentDetailsForm.signatureParams}" var="entry" varStatus="status">
											<input type="hidden" id="${ycommerce:encodeHTML(entry.key)}" name="${ycommerce:encodeHTML(entry.key)}" value="${ycommerce:encodeHTML(entry.value)}" />
										</c:forEach>
										<c:forEach items="${sopPaymentDetailsForm.subscriptionSignatureParams}" var="entry" varStatus="status">
											<input type="hidden" id="${ycommerce:encodeHTML(entry.key)}" name="${ycommerce:encodeHTML(entry.key)}" value="${ycommerce:encodeHTML(entry.value)}" />
										</c:forEach>
										<input type="hidden" value="${ycommerce:encodeHTML(silentOrderPageData.parameters['billTo_email'])}" name="billTo_email" id="billTo_email">



										<div class="form-group">
											<c:if test="${not empty paymentInfos}">
												<button type="button" class="btn btn-default btn-block js-saved-payments">
														<spring:theme code="checkout.multi.paymentMethod.addPaymentDetails.useSavedCard" />
													</button>
											</c:if>
										</div>

										<div class="form-group">
											<formElement:formSelectBox idKey="card_cardType" labelKey="payment.cardType" path="card_cardType" selectCSSClass="form-control" mandatory="true" skipBlank="false" skipBlankMessageKey="payment.cardType.pleaseSelect" items="${sopCardTypes}" tabindex="1" />
										</div>


										<div class="form-group">
											<formElement:formInputBox idKey="card_nameOnCard" labelKey="payment.nameOnCard" path="card_nameOnCard" inputCSS="form-control" tabindex="2" />

										</div>

										<div class="form-group">
											<formElement:formInputBox idKey="card_accountNumber" labelKey="payment.cardNumber" path="card_accountNumber" inputCSS="form-control" mandatory="true" tabindex="3" autocomplete="off" />
										</div>


										<fieldset id="startDate" class="start-date">
											<label for="" class="control-label required"><spring:theme code="payment.startDate" /></label>
											<div class="row">
												<div class="col-xs-6">
													<formElement:formSelectBox idKey="StartMonth" selectCSSClass="form-control" labelKey="payment.month" path="card_startMonth" mandatory="true" skipBlank="false" skipBlankMessageKey="payment.month" items="${months}" tabindex="4" />
												</div>
												<div class="col-xs-6">
													<formElement:formSelectBox idKey="StartYear" selectCSSClass="form-control" labelKey="payment.year" path="card_startYear" mandatory="true" skipBlank="false" skipBlankMessageKey="payment.year" items="${startYears}" tabindex="7" />
												</div>
											</div>
										</fieldset>


										<fieldset class="card-date">
											<label for="" class="control-label required"><spring:theme code="payment.expiryDate" /></label>
											<div class="row">
												<div class="col-xs-6">
													<formElement:formSelectBox idKey="ExpiryMonth" selectCSSClass="form-control" labelKey="payment.month" path="card_expirationMonth" mandatory="true" skipBlank="false" skipBlankMessageKey="payment.month" items="${months}" tabindex="6" />
												</div>
												<div class="col-xs-6">
													<formElement:formSelectBox idKey="ExpiryYear" selectCSSClass="form-control" labelKey="payment.year" path="card_expirationYear" mandatory="true" skipBlank="false" skipBlankMessageKey="payment.year" items="${expiryYears}" tabindex="7" />
												</div>
											</div>
										</fieldset>

										<div class="row">
											<div class="form-group col-xs-6">
												<formElement:formInputBox idKey="card_cvNumber" labelKey="payment.cvn" path="card_cvNumber" inputCSS="form-control" mandatory="true" tabindex="8" />
											</div>
										</div>

										<div class="row">
											<div class="form-group col-xs-6">
												<div id="issueNum">
													<formElement:formInputBox idKey="card_issueNumber" labelKey="payment.issueNumber" path="card_issueNumber" inputCSS="text" mandatory="false" tabindex="9" />
												</div>
											</div>
										</div>
										<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
											<formElement:formCheckbox idKey="savePaymentMethod" labelKey="checkout.multi.sop.savePaymentInfo" path="savePaymentInfo" inputCSS="" labelCSS="" mandatory="false" tabindex="10" />
										</sec:authorize>
						<hr />
						<div class="headline">
						<spring:theme code="checkout.multi.paymentMethod.addPaymentDetails.billingAddress" />
					</div>
					<c:if test="${cartData.deliveryItemsQuantity > 0}">

						<div id="useDeliveryAddressData" data-title="${ycommerce:encodeHTML(deliveryAddress.title)}" data-firstname="${ycommerce:encodeHTML(deliveryAddress.firstName)}" data-lastname="${ycommerce:encodeHTML(deliveryAddress.lastName)}" data-line1="${deliveryAddress.line1}" data-line2="${ycommerce:encodeHTML(deliveryAddress.line2)}" data-town="${ycommerce:encodeHTML(deliveryAddress.town)}"
													data-postalcode="${ycommerce:encodeHTML(deliveryAddress.postalCode)}" data-countryisocode="${ycommerce:encodeHTML(deliveryAddress.country.isocode)}" data-regionisocode="${ycommerce:encodeHTML(deliveryAddress.region.isocodeShort)}" data-address-id="${ycommerce:encodeHTML(deliveryAddress.id)}"></div>
						<formElement:formCheckbox path="useDeliveryAddress" idKey="useDeliveryAddress" labelKey="checkout.multi.sop.useMyDeliveryAddress" tabindex="11" />

					</c:if>

					<input type="hidden" value="${ycommerce:encodeHTML(silentOrderPageData.parameters['billTo_email'])}" class="text" name="billTo_email" id="billTo_email">
					<address:billAddressFormSelector supportedCountries="${countries}" regions="${regions}" tabindex="12" />

										<p>
												<spring:theme code="checkout.multi.paymentMethod.seeOrderSummaryForMoreInformation" />
											</p>
										<button type="button" class="btn btn-primary btn-block submit_silentOrderPostForm checkout-next">
												<spring:theme code="checkout.multi.paymentMethod.continue" text="Next" />
											</button>

									</form:form>
								</ycommerce:testId>
							</c:if>
						</div>
					</div>

					<c:if test="${not empty paymentInfos}">
						<div id="savedpayments">
							<div id="savedpaymentstitle">
								<div class="headline">
									<span class="headline-text"><spring:theme code="checkout.multi.paymentMethod.addPaymentDetails.useSavedCard" /></span>
								</div>
							</div>
							<div id="savedpaymentsbody">
								<c:forEach items="${paymentInfos}" var="paymentInfo" varStatus="status">
									<form action="${request.contextPath}/checkout/multi/payment-method/choose" method="GET">
										<input type="hidden" name="selectedPaymentMethodId" value="${ycommerce:encodeHTML(paymentInfo.id)}" />
												<strong>${fn:escapeXml(paymentInfo.billingAddress.firstName)}&nbsp; ${fn:escapeXml(paymentInfo.billingAddress.lastName)}</strong><br />
												${fn:escapeXml(paymentInfo.cardType)}<br />
												${fn:escapeXml(paymentInfo.accountHolderName)}<br />
												${fn:escapeXml(paymentInfo.cardNumber)}<br />
												<spring:theme code="checkout.multi.paymentMethod.paymentDetails.expires" arguments="${fn:escapeXml(paymentInfo.expiryMonth)},${fn:escapeXml(paymentInfo.expiryYear)}" />
											<br />
												${fn:escapeXml(paymentInfo.billingAddress.line1)}<br />
												${fn:escapeXml(paymentInfo.billingAddress.town)}&nbsp; ${fn:escapeXml(paymentInfo.billingAddress.region.isocodeShort)}<br />
												${fn:escapeXml(paymentInfo.billingAddress.postalCode)}&nbsp; ${fn:escapeXml(paymentInfo.billingAddress.country.isocode)}<br />
											<button type="submit" class="btn btn-primary btn-block" tabindex="${(status.count * 2) - 1}">
												<spring:theme code="checkout.multi.paymentMethod.addPaymentDetails.useThesePaymentDetails" />
											</button>
									</form>
								</c:forEach>
							</div>
						</div>
					</c:if>

		</div>
	</div>



	<div class="col-sm-4 col-md-4 hidden-xs">
		<div data-spy="affix" data-offset-top="160" data-offset-bottom="280">
			<multi-checkout:checkoutOrderDetails cartData="${cartData}" showDeliveryAddress="true" showPaymentInfo="false" showTaxEstimate="false" showTax="true" />
			<cms:pageSlot position="SideContent" var="feature" element="div" class="">
				<cms:component component="${feature}" />
			</cms:pageSlot>
		</div>
	</div>
	<multi-checkout:saveAndClose />

</template:page>
