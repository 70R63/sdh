<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/checkout/multi"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="multi-checkout-review" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/checkout/multi/review"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/checkout/multi/summary/placeOrder" var="placeOrderUrl" />
<spring:url value="/checkout/multi/termsAndConditions" var="getTermsAndConditionsUrl" />
<spring:url value="${productPageURL}" var="cancelURL" />
<c:set var="hasShippedItems" value="${cartData.deliveryItemsQuantity > 0}" />
<c:set var="deliveryAddress" value="${cartData.deliveryAddress}" />
	
<template:page pageTitle="${pageTitle}">
	<div class="row no-margin global-content-space">
	<div class="row stickem-container">
		<div class="col-sm-8 col-md-8">
			<div class="visible-xs-block">
				<multi-checkout:relationshipChangeUser user="${cartData.userInContext}" />
			</div>
			<div class="checkout-heading checkout-steps">
				<p>
				<h1><span tabindex="0"><span class="checkout-product-name">${ycommerce:encodeHTML(cartData.entries[0].product.name)}
						&nbsp;</span>
						<span class="checkout-draft-no">&nbsp;<spring:theme code="checkout.multi.DraftNo" />&nbsp;
						${ycommerce:encodeHTML(cartData.code)}</span></span>
					</h1>
				</p>
			</div>

			<multi-checkout:checkoutSteps checkoutSteps="${checkoutSteps}" progressBarId="${progressBarId}" bundleCheckoutLabel="${bundleCheckoutLabel}">
				<ycommerce:testId code="checkoutStepFour">
					<div class="card-section card-review-section-nospace">
						<div>
							<div class="row no-margin">
								<div class="col-xs-12 col-sm-12 col-md-12 ">
									<div class="card-section-h1">
										<spring:theme code="checkout.multi.summary.text" text="Summary"/>
									</div>
								</div>
								<c:if test="${not empty bundleInfo}">
									<div class="col-xs-12 col-sm-12 col-md-12 ">
										<div class="card-150 col-xs-12 col-sm-12 col-md-12">
											<div class="card-section-content">
												<multi-checkout-review:bundleInfo bundleData="${bundleInfo}" />
											</div>
										</div>
									</div>
								</c:if>
							</div>
							<div class="row no-margin">
								<div class="col-xs-12 col-sm-12 col-md-12">
									<div class="card-transparent col-xs-12 col-sm-12 col-md-12">
										<div class="card-section-content">
											<c:forEach var="formHtml" items="${embeddedFormHtmlsReview}">
												<div class="formHtml">${formHtml}</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
							<c:if test="${hasShippedItems and not empty deliveryAddress}">
								<div class="row no-margin">
									<div class="col-xs-12 col-sm-6 col-md-6 ">
										<multi-checkout-review:deliveryAddress cartData="${cartData}" />
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6 ">
										<multi-checkout-review:deliveryMethodDetails deliveryMode="${cartData.deliveryMode}" />
									</div>
								</div>
							</c:if>
							<c:if test="${cartData.totalPrice.value > 0}">
								<div class="row no-margin">
									<c:if test="${not empty cartData.paymentInfo}">
										<div class="col-xs-12 col-sm-6 col-md-6 ">
											<multi-checkout-review:paymentInfo cartData="${cartData}" />
										</div>
									</c:if>
									<div class="col-xs-12 col-sm-6 col-md-6 ">
										<multi-checkout:checkoutTotalSummary cartData="${cartData}" showDeliveryAddress="false" showTaxEstimate="false" showTax="true" />
									</div>
								</div>
							</c:if>

							<!-- consent declaration section -->
							<form:form action="${placeOrderUrl}" id="placeOrderForm1" commandName="placeOrderForm">
								<c:if test="${not empty consentDeclarations}">
									<div class="row no-margin">
										<div class="col-xs-12 col-sm-12 col-md-12">
											<div class="card-section-h1">
												<spring:theme code="checkout.summary.consentDeclaration" text="Consent Declaration" />
											</div>
											<div class="card-section-content label-required">
												<spring:theme code="checkout.summary.fieldsRequired" text="Required" htmlEscape="false"/>
											</div>
										</div>
										<div class="col-md-12">
											<div class="card-transparent no-margin">
												<div class="card-section-content">
													<c:forEach items="${consentDeclarations}" var="declaration" varStatus="declarationIndex">
														<div class="checkbox consentDeclaration">
															<label class="control-label consentDeclarations" for="defaultAddress1">
																<div class="final-label">
																	<form:checkbox id="Terms1" value="${declarationIndex.index}" path="consentDeclarations" />
																	 ${ycommerce:sanitizeHTML(declaration.text)}
																</div>
															</label>
														</div>
													</c:forEach>
												</div>
											</div>
										</div>
									</div>
								</c:if>
								<div class="row no-margin">
									<div class="col-md-12 col-md-push-5 col-sm-push-3">
										<div class="col-xs-12 col-sm-3 col-md-3">
											<button tabindex="0" type="button" onclick="window.location='${cancelURL}'" class="btn btn-grey btn-block checkout-cancel">
												<spring:theme code="checkout.multi.cancel" />
											</button>
										</div>
										<div class="col-xs-12 col-sm-5 col-md-3">
											<button id="placeOrder" type="submit" class="btn btn-primary center-block btn-place-order btn-block final-apply-online">
												${ycommerce:encodeHTML(productAddToCartText)}
												<c:if test="${empty productAddToCartText}">
													<spring:theme code="checkout.summary.applyOnline" text="Apply Online" />
												</c:if>
											</button>
										</div>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</ycommerce:testId>
			</multi-checkout:checkoutSteps>
		</div>
      <div class="stickem">
		<div class="col-sm-4 col-md-4 hidden-xs">
			<multi-checkout:relationshipChangeUser user="${cartData.userInContext}" />
			<multi-checkout:checkoutOrderDetails cartData="${cartData}" showDeliveryAddress="true" showPaymentInfo="true" showTaxEstimate="false" showTax="true" showApplyButton="true" />
			<cms:pageSlot position="SideContent" var="feature" element="" class="">
				<cms:component component="${feature}" />
			</cms:pageSlot>
		</div></div>

	</div></div>
	<multi-checkout:saveAndClose />

</template:page>