<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/checkout/multi"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/checkout/multi/form/placeOrder" var="placeOrderUrl" />
<spring:url value="${productPageURL}" var="cancelURL" />

<template:page pageTitle="${pageTitle}">

<div class="row no-margin global-content-space">
  <div class="row stickem-container">
	<div class="col-sm-8 col-md-8">
		<div class="checkout-headline"><h1><span tabindex="0">${ycommerce:encodeHTML(productName)}</span></h1></div>
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
				<div class="col-md-12"> 
		            <div class="col-xs-12 col-sm-5 col-md-4 ">
		               	<button id="cancelBtn" type="button" onclick="window.location='${cancelURL}'" class="btn btn-grey btn-block button right button-space"><spring:theme code="checkout.multi.cancel" text="Cancel" /></button>
            		</div>
		            <div class="col-xs-12 col-sm-5 col-md-4 ">
			        <form:form action="${placeOrderUrl}" id="placeOrderForm1" commandName="placeOrderForm">
						<c:if test="${requestSecurityCode}">
							<form:input type="hidden" class="securityCodeClass" path="securityCode" />
							<button type="submit" class="btn btn-primary btn-block checkout-next positive right pad_right place-order placeOrderWithSecurityCode" id="placeOrderBtn">
								<spring:theme code="checkout.summary.placeOrder" text="Submit" />
							</button>
						</c:if>

						<c:if test="${not requestSecurityCode}">
							<button type="button" id="placeOrderBtn" class="btn btn-primary btn-block checkout-next positive right place-order">
								<spring:theme code="checkout.summary.placeOrder" text="Submit" />
							</button>
						</c:if>
				    </form:form>
		            </div>
	            </div>
	       	</div>	
		</ycommerce:testId>
	</div>
	
<div class="stickem">
	<div class="col-sm-4 col-md-4 hidden-xs">
		<multi-checkout:relationshipChangeUser user="${cartData.userInContext}" />
		<cms:pageSlot position="SideContent" var="feature" element="div" class="">
			<cms:component component="${feature}" />
		</cms:pageSlot>
	</div></div>

</div></div>
	<multi-checkout:saveAndClose />
</template:page>


