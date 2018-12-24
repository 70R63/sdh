<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/checkout/multi"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/formElement"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="address" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/address"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/checkout/multi/cancel" var="cancelURL" />
<spring:url value="${currentStepUrl}" var="choosePaymentMethodUrl" />

<template:page pageTitle="${pageTitle}">
	<div class="row no-margin global-content-space">
	<div class="row stickem-container">
		<div class="col-sm-8 col-md-8">
			<div class="visible-xs-block">
				<multi-checkout:relationshipChangeUser user="${cartData.userInContext}" />
			</div>
			<div class="checkout-heading checkout-steps">
				<h1><span tabindex="0"><span class="checkout-product-name">${ycommerce:encodeHTML(cartData.entries[0].product.name)}
						&nbsp;</span>
						<span class="checkout-draft-no">&nbsp;<spring:theme code="checkout.multi.DraftNo" />&nbsp;
						${ycommerce:encodeHTML(cartData.code)}</span></span>
					</h1>
			</div>

			<multi-checkout:checkoutSteps checkoutSteps="${checkoutSteps}" progressBarId="${progressBarId}" bundleCheckoutLabel="${bundleCheckoutLabel}">
				<jsp:body>
                <c:if test="${not empty paymentFormUrl}">
                    <div class="checkout-step-paymentmethod">
                        <div class="checkout-indent">
                            <div class="headline">
								<spring:theme code="checkout.multi.paymentMethod" />
							</div>
						    <ycommerce:testId code="paymentDetailsForm">
							<form:form id="silentOrderPostForm" name="silentOrderPostForm" commandName="sopPaymentDetailsForm" action="${paymentFormUrl}" method="POST">
								<input type="hidden" name="orderPage_receiptResponseURL" value="${silentOrderPageData.parameters['orderPage_receiptResponseURL']}" />
								<input type="hidden" name="orderPage_declineResponseURL" value="${silentOrderPageData.parameters['orderPage_declineResponseURL']}" />
								<input type="hidden" name="orderPage_cancelResponseURL" value="${silentOrderPageData.parameters['orderPage_cancelResponseURL']}" />
								<c:forEach items="${sopPaymentDetailsForm.signatureParams}" var="entry" varStatus="status">
									<input type="hidden" id="${entry.key}" name="${entry.key}" value="${entry.value}" />
								</c:forEach>
								<c:forEach items="${sopPaymentDetailsForm.subscriptionSignatureParams}" var="entry" varStatus="status">
									<input type="hidden" id="${entry.key}" name="${entry.key}" value="${entry.value}" />
								</c:forEach>
								<input type="hidden" value="${silentOrderPageData.parameters['billTo_email']}" name="billTo_email" id="billTo_email">
					
								<div class="form-group">
									<c:if test="${not empty paymentInfos}">
								  		<div class="row no-margin">
											<div class="col-xs-12 col-sm-6 no-space">
												<button type="button" tabindex="0" class="btn btn-default btn-block js-saved-payments">
													<spring:theme code="checkout.multi.paymentMethod.addPaymentDetails.useSavedCard" />
												</button>
											</div>
								  		</div>
									</c:if>	
								</div>

								<div class="form-group">
									<formElement:formSelectBox idKey="card_cardType" labelKey="payment.cardType" path="card_cardType" selectCSSClass="form-control" mandatory="true" skipBlank="false" skipBlankMessageKey="payment.cardType.pleaseSelect" items="${sopCardTypes}" tabindex="0" />
                               	</div>

								<div class="form-group">
									<formElement:formInputBox idKey="card_nameOnCard" labelKey="payment.nameOnCard" path="card_nameOnCard" inputCSS="form-control" tabindex="0" maxlength="255" />
								</div>
 
								<div class="form-group">
									<formElement:formInputBox idKey="card_accountNumber" labelKey="payment.cardNumber" path="card_accountNumber" inputCSS="form-control" mandatory="true" tabindex="0" autocomplete="off" />
								</div>

								<fieldset id="startDate" class="start-date">
									<label for="" class="control-label required"><spring:theme code="payment.startDate" /></label>
									<div class="row">
										<div class="col-xs-6">
											<formElement:formSelectBox idKey="StartMonth" selectCSSClass="form-control" labelKey="payment.month" path="card_startMonth" mandatory="true" skipBlank="false" skipBlankMessageKey="payment.month" items="${months}" tabindex="0" />
										</div>
										<div class="col-xs-6">
											<formElement:formSelectBox idKey="StartYear" selectCSSClass="form-control" labelKey="payment.year" path="card_startYear" mandatory="true" skipBlank="false" skipBlankMessageKey="payment.year" items="${startYears}" tabindex="0" />
										</div>
									</div>
								</fieldset>

								<fieldset class="card-date">
									<label for="ExpiryMonth" class="control-label required"><spring:theme code="payment.expiryDate" /></label>
									<div class="row">
										<div class="col-xs-6 expiry_month">
											<formElement:formSelectBox idKey="ExpiryMonth" selectCSSClass="form-control" labelKey="payment.month" path="card_expirationMonth" mandatory="true" skipBlank="false" skipBlankMessageKey="payment.month" items="${months}" tabindex="0" />
										</div>
										<div class="col-xs-6 expiry_year">
											<formElement:formSelectBox idKey="ExpiryYear" selectCSSClass="form-control" labelKey="payment.year" path="card_expirationYear" mandatory="true" skipBlank="false" skipBlankMessageKey="payment.year" items="${expiryYears}" tabindex="0" />
										</div>
									</div>
								</fieldset>
									
								<div class="row no-margin">
									<div>
										<formElement:formInputBox idKey="card_cvNumber" labelKey="payment.cvn" path="card_cvNumber" inputCSS="form-control" mandatory="true" tabindex="0" maxlength=""/>
									</div>
								</div>

								<div class="row no-margin">
									<div class="col-xs-3">
										<div id="issueNum">
											<formElement:formInputBox idKey="card_issueNumber" labelKey="payment.issueNumber" path="card_issueNumber" inputCSS="text" mandatory="false" tabindex="9" />
										</div>
									</div>
								</div>

                                <div class="headline">
                                    <spring:theme code="checkout.multi.paymentMethod.addPaymentDetails.billingAddress" />
                                </div>

                                <c:if test="${not empty cartData.deliveryAddress}">
                                    <div id="useDeliveryAddressData" 
                                    data-title=" ${ycommerce:encodeHTML(deliveryAddress.title)}" 
									data-firstname="${ycommerce:encodeHTML(deliveryAddress.firstName)}"
								    data-lastname="${ycommerce:encodeHTML(deliveryAddress.lastName)}" 
								    data-line1="${ycommerce:encodeHTML(deliveryAddress.line1)}" 
								    data-line2="${ycommerce:encodeHTML(deliveryAddress.line2)}" 
								    data-town="${ycommerce:encodeHTML(deliveryAddress.town)}"
								    data-postalcode="${ycommerce:encodeHTML(deliveryAddress.postalCode)}" 
								    data-countryisocode="${ycommerce:encodeHTML(deliveryAddress.country.isocode)}" 
								    data-regionisocode="${ycommerce:encodeHTML(deliveryAddress.region.isocodeShort)}" 
								    data-address-id="${ycommerce:encodeHTML(deliveryAddress.id)}"></div>
							        <formElement:formCheckbox path="useDeliveryAddress" idKey="useShippingAddress" labelKey="checkout.multi.sop.useMyDeliveryAddress" labelCSS="useShippingAddress" tabindex="0" />
                            
                            		<div id="deliveryAddressData" class="card-section-content" style="display: none">  
                            			<div class="card col-xs-12 col-md-12 address-card">
                                			<ul>
                                				<li><strong>${fn:escapeXml(deliveryAddress.title)}&nbsp;
													${fn:escapeXml(deliveryAddress.firstName)}&nbsp;
													${fn:escapeXml(deliveryAddress.lastName)}</strong> <br>
													${fn:escapeXml(deliveryAddress.line1)}&nbsp;
													${fn:escapeXml(deliveryAddress.line2)} <br>
													${fn:escapeXml(deliveryAddress.town)} 
													<c:if test="${not empty deliveryAddress.region.name}">
														&nbsp;${fn:escapeXml(deliveryAddress.region.name)}
													</c:if> <br>
													${fn:escapeXml(deliveryAddress.country.name)}&nbsp;
													${fn:escapeXml(deliveryAddress.postalCode)}
												</li>
											</ul>
										</div>
									</div>
                                </c:if>
                                    
                                <c:if test="${ not empty primaryAddress }">
						        	<div id="usePrimaryAddressData" 
						        	data-title=" ${ycommerce:encodeHTML(primaryAddress.title)}" 
									data-firstname="${ycommerce:encodeHTML(primaryAddress.firstName)}"
								    data-lastname="${ycommerce:encodeHTML(primaryAddress.lastName)}" 
								    data-line1="${ycommerce:encodeHTML(primaryAddress.line1)}" 
								    data-line2="${ycommerce:encodeHTML(primaryAddress.line2)}" 
								    data-town="${ycommerce:encodeHTML(primaryAddress.town)}"
								    data-postalcode="${ycommerce:encodeHTML(primaryAddress.postalCode)}" 
								    data-countryisocode="${ycommerce:encodeHTML(primaryAddress.country.isocode)}" 
								    data-regionisocode="${ycommerce:encodeHTML(primaryAddress.region.isocodeShort)}" 
								    data-address-id="${ycommerce:encodeHTML(primaryAddress.id)}"></div>
							        <formElement:formCheckbox path="usePrimaryAddress" idKey="usePrimaryAddress" labelKey="checkout.multi.sop.useMyPrimaryAddress" labelCSS="usePrimaryAddress" tabindex="0" />
					             	
					             	<div id="primaryAddressData" class="card-section-content" style="display: none">  
					             		<div class="card col-xs-12 col-md-12 address-card">
						             		<ul>
						             			<li>
						             				<strong>${fn:escapeXml(primaryAddress.title)}&nbsp;
													${fn:escapeXml(primaryAddress.firstName)}&nbsp;
													${fn:escapeXml(primaryAddress.lastName)}</strong> <br>
													${fn:escapeXml(primaryAddress.line1)}&nbsp;
													${fn:escapeXml(primaryAddress.line2)} <br>
													${fn:escapeXml(primaryAddress.town)} 
													<c:if test="${not empty primaryAddress.region.name}">
														&nbsp;${fn:escapeXml(primaryAddress.region.name)}
													</c:if> <br>
													${fn:escapeXml(primaryAddress.country.name)}&nbsp;
													${fn:escapeXml(primaryAddress.postalCode)}
												</li>
											</ul>
										</div>
									</div>
					            </c:if>

								<c:if test="${ not empty savedPaymentAddress }">
									<div id="useSavedPaymentAddressData" data-countryisocode="${savedPaymentAddress.country.isocode}" data-regionisocode="${savedPaymentAddress.region.isocodeShort}"></div>
								</c:if>
								<input type="hidden" value="${isPaymentAddressAvailable}" name="isPaymentAddressAvailable" id="isPaymentAddressAvailable">
                    			<input type="hidden" id="selectedPaymentMethodId" name="selectedPaymentMethodId" />
                    			<div id="addressDefaultCountry" data-countryIsoCode="${defaultCountry}"></div>
                    			<!-- pop up address book -->
								<div id="addressbook">
									<div id="addressbookTitle">
									    <div class="headline hide">
										  <span class="headline-text"><spring:theme code="checkout.multi.paymentMethod.savedAddress" /></span>
									    </div>
							        </div>
									<c:forEach items="${deliveryAddresses}" var="deliveryAddress" varStatus="status">
										<div class="addressEntry">
										<div tabindex="0" aria-labelledby="savedAddress">
										<div id="savedAddress">
											<ul>
												<li>
													<strong>${fn:escapeXml(deliveryAddress.title)}&nbsp;
													${fn:escapeXml(deliveryAddress.firstName)}&nbsp;
													${fn:escapeXml(deliveryAddress.lastName)}</strong> <br>
													${fn:escapeXml(deliveryAddress.line1)}&nbsp;
													${fn:escapeXml(deliveryAddress.line2)} <br>
													${fn:escapeXml(deliveryAddress.town)} 
													<c:if test="${not empty deliveryAddress.region.name}">
														&nbsp;${fn:escapeXml(deliveryAddress.region.name)}
													</c:if> <br>
													${fn:escapeXml(deliveryAddress.country.name)}&nbsp;
													${fn:escapeXml(deliveryAddress.postalCode)}</li>
											</ul>
											</div>
											</div>
											<button type="submit" class="btn btn-primary btn-block btn-billing-address" data-addresscode="${deliveryAddress.id}" data-countryisocode="${deliveryAddress.country.isocode}">
												<spring:theme code="checkout.multi.deliveryAddress.useThisAddress" text="Use this Address" />
											</button>
										</div>
									</c:forEach>
								</div>
								<!-- end pop up address book -->

								<c:if test="${not empty deliveryAddresses}">
									<div class="row no-margin">
										<div class="col-xs-6 no-space">
											<button tabindex="0" type="button" class="btn btn-default btn-block js-address-book">
												<spring:theme code="checkout.checkout.multi.deliveryAddress.viewAddressBook" text="Address Book" />
											</button>
										</div>
									</div>
								</c:if>

								<!-- show when billing addressbookchosen -->
								<div id="billAddressBookSavedContent" class="card-section-content" style="display: none;">
									<input type="hidden" id="primaryAddressCountryCode" value="GB">
									<div class="card col-xs-12 col-md-12 address-card">
										<div class="payment-bill-address-book">
											<div class="account-cards-actions pull-right">
												<a class="action-links js-remove-bill-address-book checkout-address-delete" href="#">
													<span class="glyphicon glyphicon-trash gi-2x "></span> 
												</a>
											</div>	
											
											<div class="addressEntry">
												<ul>
													<!-- content will be prepopulated based on selected payment saved card -->
												</ul>
											</div>
										</div>
									</div>
								</div>
								<!-- end show -->
								
								</br>
				                <input type="hidden" value="${ycommerce:encodeHTML(silentOrderPageData.parameters['billTo_email'])}" class="text" name="billTo_email" id="billTo_email">
			                  	<address:billAddressFormSelector supportedCountries="${countries}" regions="${regions}" tabindex="0" />
						  		<sec:authorize access="!hasAnyRole('ROLE_ANONYMOUS')">
									<formElement:formCheckbox idKey="savePaymentMethod" labelKey="checkout.multi.sop.savePaymentInfo" path="savePaymentInfo" inputCSS="" labelCSS="savePaymentMethod" mandatory="false" tabindex="0" />
								</sec:authorize>
								
							</form:form>
							</ycommerce:testId>
                         </div>
                    </div>
                            
                    <!-- show when saved cards chosen -->
					<div id="billCreditCardSavedContent" class="card-section-content" style="display: none;">
						<input type="hidden" id="primaryAddressCountryCode" value="GB">
						<div class="card col-xs-12 col-md-12 address-card">
							<div class="bill-saved-address-book">
								<div class="account-cards-actions pull-right">
									<a class="action-links js-remove-bill-saved-card payment-billing-delete" href="#">
										<span class="glyphicon glyphicon-trash gi-2x"></span> 
									</a>
								</div>									
								<div class="addressEntry">
									<ul>
										<!-- content will be prepopulated based on selected payment saved card -->
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!-- end show -->

                	<div class="row">
						<div class="col-md-12 col-sm-push-1 col-md-push-2"> 
				            <div class="col-xs-12 col-sm-3 col-md-3 ">
				               	<button tabindex="0" type="button" onclick="window.location='${cancelURL}'" class="btn btn-grey btn-block checkout-cancel">
									<spring:theme code="checkout.multi.cancel" />
								</button>
		            		</div>
				            <div class="col-xs-12 col-sm-5 col-md-4 ">
				               	<button tabindex="0" type="button" id="saveDraft_silentOrderPostForm" class="btn btn-black btn-block checkout-saveandclose js-saveandclose">
									<spring:theme code="checkout.multi.saveandclose" />
								</button>
				            </div>
					        <div class="col-xs-12 col-sm-3 col-md-3 ">
				               <button tabindex="0" type="button" class="btn btn-primary btn-block checkout-next submit_silentOrderPostForm">
									<spring:theme code="checkout.multi.paymentMethod.continue" />
								</button> 
				            </div>
			            </div>
	       			</div>		
						
                </c:if>
                
				<c:if test="${not empty paymentInfos}">
					<div id="savedpayments">
						<div id="savedpaymentstitle">
							<div class="headline">
								<span class="headline-text"><spring:theme code="checkout.multi.paymentMethod.addPaymentDetails.useSavedCard" /></span>
							</div>
						</div>
						<div id="savedpaymentsbody">
							<c:forEach items="${paymentInfos}" var="paymentInfo" varStatus="status">
								<div class="saved-payment-entry">
										<input type="hidden" class="paymentMethodId" value="${fn:escapeXml(paymentInfo.id)}" />
										<div tabindex="0" aria-labelledby="savedCard">
											<div id="savedCard">
												<ul>
													<strong>${fn:escapeXml(paymentInfo.billingAddress.firstName)}&nbsp; ${fn:escapeXml(paymentInfo.billingAddress.lastName)}</strong>
													<br />
													${fn:escapeXml(paymentInfo.cardTypeData.name)}<br />
													${fn:escapeXml(paymentInfo.cardNumber)}<br />
													<spring:theme code="checkout.multi.paymentMethod.paymentDetails.expires" arguments="${fn:escapeXml(paymentInfo.expiryMonth)},${fn:escapeXml(paymentInfo.expiryYear)}" />
													<br />
													${fn:escapeXml(paymentInfo.billingAddress.line1)}<br />
													${fn:escapeXml(paymentInfo.billingAddress.town)}&nbsp; ${fn:escapeXml(paymentInfo.billingAddress.region.isocodeShort)}<br />
													${fn:escapeXml(paymentInfo.billingAddress.postalCode)}&nbsp; ${fn:escapeXml(paymentInfo.billingAddress.country.isocode)}<br />
												</ul>
											</div>
										</div>
										<button type="button" class="btn btn-primary btn-block js-billingSavedCardAddress" tabindex="0">
											<spring:theme code="checkout.multi.paymentMethod.addPaymentDetails.useThesePaymentDetails" />
										</button>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>
			</jsp:body>
			</multi-checkout:checkoutSteps>

		</div>
		
      <div class="stickem">
		<div class="col-sm-4 col-md-4 hidden-xs">
			<multi-checkout:relationshipChangeUser user="${cartData.userInContext}" />
			<multi-checkout:checkoutOrderDetails cartData="${cartData}" showDeliveryAddress="true" showPaymentInfo="false" showTaxEstimate="false" showTax="true" />
			<cms:pageSlot position="SideContent" var="feature" element="">
				<cms:component component="${feature}" />
			</cms:pageSlot>
		</div>
	 </div>

	</div></div>
	<multi-checkout:saveAndClose />
</template:page>