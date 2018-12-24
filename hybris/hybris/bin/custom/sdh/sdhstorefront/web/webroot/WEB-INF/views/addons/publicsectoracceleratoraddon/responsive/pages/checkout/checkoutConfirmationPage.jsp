<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common"%>
<%@ taglib prefix="multi" tagdir="/WEB-INF/tags/responsive/checkout/multi"%>
<%@ taglib prefix="order" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/order"%>
 <%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
 <spring:htmlEscape defaultHtmlEscape="true" />
  
<spring:url value="/my-account/application/${ycommerce:encodeHTML(orderData.code)}" var="orderDetailsUrl" />
<spring:url value="/my-account/applications" var="applicationUrl" />

<template:page pageTitle="${pageTitle}">

	<cms:pageSlot position="TopContent" var="feature" element="div">
		<cms:component component="${feature}" />
	</cms:pageSlot>
	
<div class="row no-margin global-content-space checkout-confirmation">
<div class="row stickem-container">
	<div class="col-sm-8 col-md-8">
		<div class="card-section no-space">
			<div class="card-list">

				<div class="row no-margin">
					<div class="col-md-12">
						<div class="card-section-h1">
							<h1><span tabindex="0"><spring:theme code="checkout.service.confirmation" arguments="${serviceProduct.name}" /></span></h1>
						</div>
					</div>
					<div class="col-md-12 ">
						<div class="card-150 col-md-12 checkout-confirmation">
							<div class="card-section-content summary">
								<div>
									<p class="reference-no">
										<spring:theme code="checkout.sevice.confirmation.refNumber" text="Ref number is {0}" arguments="${orderData.code}" />
									</p>
								</div>
								<div>
									<p class="confirmation-content">
										<spring:theme code="checkout.orderConfirmation.copySentTo.${userType}" arguments="${email},${orderDetailsUrl}${order.code},${applicationUrl}" htmlEscape="false" var="orderConfirmation"/>
									    ${ycommerce:sanitizeHTML(orderConfirmation)}
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row no-margin">
					<div class="col-md-12 ">
						<div class="card-section-h1">
							<spring:theme code="checkout.multi.summary.text" text="Summary" />
						</div>
					</div>
					<c:if test="${orderData.totalPrice.value > 0}">
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6 ">
								<order:paymentInfo orderData="${orderData}" />
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6 ">
								<order:checkoutTotalSummary orderData="${orderData}" showDeliveryAddress="false" showTaxEstimate="false" showTax="true" />
							</div>
						</div>
					</c:if>
					<c:if test="${not empty bundleInfo}">
						<div class="col-md-12 ">
							<div class="card-150 col-md-12">
								<div class="card-section-content">
									<order:bundleInfo bundleData="${bundleInfo}" />
								</div>
							</div>
						</div>
					</c:if>
				</div>

				<div class="row no-margin">
					<div class="col-md-12">
						<div class="card-transparent col-md-12">
							<div class="card-section-content">
								<c:forEach var="formHtml" items="${embeddedFormHtmlsReview}">
									<div class="formHtml">${formHtml}</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>

				<div class="row no-margin">
					<div class="col-xs-12 col-sm-6 col-md-6 ">
						<order:deliveryAddress orderData="${orderData}" />
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6 ">
						<order:deliveryMethodDetails deliveryMode="${orderData.deliveryMode}" />
					</div>
				</div>

				<c:if test="${not empty consentDeclarations}">
					<div class="row no-margin">
						<div class="col-md-12">
							<div class="card-section-h1">
								<spring:theme code="checkout.summary.consentDeclaration" text="Consent Declaration" />
							</div>
						</div>
						<div class="col-md-12">
							<div class="card-transparent col-md-12">
								<div class="card-section-content">
									<c:forEach items="${consentDeclarations}" var="declaration" varStatus="declarationIndex">
										<div class="consentDeclaration">
											<label class="control-label consentDeclarations checked" for="defaultAddress1" disabled="disabled">
												<div class="row col-md-12 final-label">
													<div>${ycommerce:sanitizeHTML(declaration.text)}</div>
												</div>
											</label>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>

<div class="stickem">
	<div class="col-sm-4 col-md-4 hidden-xs">
		<cms:pageSlot position="SideContent" var="feature" element="div">
			<cms:component component="${feature}" />
		</cms:pageSlot>
	</div></div>

</div></div>

</template:page>






