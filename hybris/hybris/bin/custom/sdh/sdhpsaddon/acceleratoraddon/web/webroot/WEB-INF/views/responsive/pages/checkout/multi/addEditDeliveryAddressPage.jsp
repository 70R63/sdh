<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="address" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/address"%>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/checkout/multi"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

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
					<ycommerce:testId code="checkoutStepOne">
						<div class="checkout-shipping-address">
							<div class="checkout-indent">
								
								<div class="row">
	                             	<div class="col-xs-12 col-sm-12 col-md-12 ">
	            		              	<div class="headline">
											<spring:theme code="checkout.summary.shippingAddress" text="Shipping Address"/>
										</div>
            	              		</div>
                          		</div> 
								<address:addressFormSelector supportedCountries="${countries}" regions="${regions}" cancelUrl="${currentStepUrl}" country="${country}" />
								<div id="addressbook">
									<c:forEach items="${deliveryAddresses}" var="deliveryAddress" varStatus="status">
										<div class="addressEntry">
											<form id="shippingAddressBook" action="${request.contextPath}/checkout/multi/delivery-address/select" method="GET">
												<input type="hidden" name="selectedAddressCode" value="${ycommerce:encodeHTML(deliveryAddress.id)}" />
												<input type="hidden" name="selectedCountryCode" value="${ycommerce:encodeHTML(deliveryAddress.country.isocode)}" />
												<ul>
													<li tabindex="0">
														<strong>${fn:escapeXml(deliveryAddress.title)}&nbsp;
														${fn:escapeXml(deliveryAddress.firstName)}&nbsp;
														${fn:escapeXml(deliveryAddress.lastName)}</strong>
														<br>
														${fn:escapeXml(deliveryAddress.line1)}&nbsp;
														${fn:escapeXml(deliveryAddress.line2)}
														<br>
														${fn:escapeXml(deliveryAddress.town)}
														<c:if test="${not empty deliveryAddress.region.name}">
															&nbsp;${fn:escapeXml(deliveryAddress.region.name)}
														</c:if>
														<br>
														${fn:escapeXml(deliveryAddress.country.name)}&nbsp;
														${fn:escapeXml(deliveryAddress.postalCode)}
													</li>
												</ul>
												<button type="submit" class="btn btn-primary btn-block shipping-useThisAddress">
													<spring:theme code="checkout.multi.deliveryAddress.useThisAddress" text="Use this Address" />
												</button>
											</form>
										</div>
									</c:forEach>
								</div>
								<address:suggestedAddresses selectedAddressUrl="/checkout/multi/delivery-address/select" />
							</div>
							<multi-checkout:pickupGroups cartData="${cartData}" />
						
		                 	<div class="row">
								<div class="col-md-12 col-sm-push-1 col-md-push-2"> 
						            <div class="col-xs-12 col-sm-3 col-md-3 ">
						               	 <button type="button" onclick="window.location='${cancelURL}'" class="btn btn-grey btn-block checkout-cancel">
												<spring:theme code="checkout.multi.cancel" />
											</button>
				            		</div>
						            <div class="col-xs-12 col-sm-5 col-md-4 ">
						               <button id="addressSave" type="button" class="btn btn-black btn-block checkout-saveandclose js-saveandclose">
											<spring:theme code="checkout.multi.saveandclose" text="Save" />
										</button>
						            </div>
							        <div class="col-xs-12 col-sm-3 col-md-3 ">
						               <button id="addressSubmit" type="button" class="btn btn-primary btn-block checkout-next">
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
			<multi-checkout:checkoutOrderDetails cartData="${cartData}" showDeliveryAddress="false" showPaymentInfo="false" showTaxEstimate="false" showTax="true" />
			<cms:pageSlot position="SideContent" var="feature" element="" class="">
				<cms:component component="${feature}" />
			</cms:pageSlot>
		</div></div>
	</div></div>
	<multi-checkout:saveAndClose />
</template:page>