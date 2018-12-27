<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/checkout/multi"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:url value="/checkout/multi/cancel" var="cancelURL" />

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
				<jsp:body>
				<ycommerce:testId code="checkoutStepTwo">
					<div class="checkout-shipping-address">
						<div class="checkout-indent">
							<p>
									<spring:theme code="checkout.multi.deliveryMethod.message" text="Fields marked * are required <br> Shipping Method* </br>"  htmlEscape="false"/>
							</p>
							<p>
									<spring:theme code="checkout.summary.deliveryMode.selectDeliveryMethodForOrder" text="Shipping Method"></spring:theme>
								<span class="required"></span>
							</p>
							<form id="selectDeliveryMethodForm" action="${request.contextPath}/checkout/multi/delivery-method/select" method="GET">
								<div class="form-group">
									<p>
										<multi-checkout:deliveryMethodSelector deliveryMethods="${deliveryMethods}" selectedDeliveryMethodId="${cartData.deliveryMode.code}" />
									</p>
								</div>
							</form>
						</div>
							
			            <div class="row">
							<div class="col-md-12 col-sm-push-1 col-md-push-2"> 
					            <div class="col-xs-12 col-sm-3 col-md-3 ">
					               	   <button type="button" onclick="window.location='${cancelURL}'" class="btn btn-grey btn-block checkout-cancel">
												<spring:theme code="checkout.multi.cancel" />
											</button>
			            		</div>
					            <div class="col-xs-12 col-sm-5 col-md-4 ">
					                <button id="deliveryMethodSave" type="button" class="btn btn-black btn-block checkout-saveandclose js-saveandclose">
											<spring:theme code="checkout.multi.step.saveAndClose" text="Save And Close" />
									</button>
					            </div>
						        <div class="col-xs-12 col-sm-3 col-md-3 ">
					               <button id="deliveryMethodSubmit" type="button" class="btn btn-primary btn-block checkout-next">
											<spring:theme code="checkout.multi.step.continue" text="Next" />
									</button>
					            </div>
				            </div>
			   			</div>	
   
					</div>
				</ycommerce:testId>
			</jsp:body>
			</multi-checkout:checkoutSteps>
		</div>
     <div class="stickem">
		<div class="col-sm-4 col-md-4 hidden-xs">
			<multi-checkout:relationshipChangeUser user="${cartData.userInContext}" />
			<multi-checkout:checkoutOrderDetails cartData="${cartData}" showDeliveryAddress="true" showPaymentInfo="false" showTaxEstimate="false" showTax="true" />
			<cms:pageSlot position="SideContent" var="feature" element="" class="">
				<cms:component component="${feature}" />
			</cms:pageSlot>
		</div></div>

	</div></div>
	<multi-checkout:saveAndClose />

</template:page>
