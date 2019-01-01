<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/checkout/multi"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="${nextStepUrl}" var="placeOrderUrl" />
<spring:url value="/checkout/multi/cancel" var="cancelURL" />

<template:page pageTitle="${pageTitle}">
	<input type="hidden" value="${ycommerce:encodeHTML(defaultCountry)}" name="defaultCountry" id="defaultCountry"/>
		
	<div class="row no-margin global-content-space multistepPage">
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
				<ycommerce:testId code="checkoutStepOne">
					<div class="checkout-indent">
						<div class="form">
							<c:forEach var="formHtml" items="${embeddedFormHtmls}">
								<div class="formHtml">${formHtml}</div>
								<br />
							</c:forEach>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-12 col-sm-push-1 col-md-push-2"> 
				            <div class="col-xs-12 col-sm-3 col-md-3 ">
				               	  <a href="${cancelURL}" class="btn btn-grey btn-block checkout-cancel"><spring:theme code="checkout.multi.cancel" /></a>
		            		</div>
				            <div class="col-xs-12 col-sm-5 col-md-4 ">
				               	  <a href="${cancelURL}" id="saveYformButton" class="btn btn-black btn-block checkout-saveandclose js-saveandclose"><spring:theme code="checkout.multi.saveandclose" /></a>
				            </div>
					        <div class="col-xs-12 col-sm-3 col-md-3 ">
				               	 <a id="continueBtn" class="btn btn-primary btn-block checkout-next" href="${placeOrderUrl}"><spring:theme code="checkout.multi.serviceRequestForm.continue" /></a>
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
