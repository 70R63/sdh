<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="order" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/order"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/my-documents" var="myDocumentsURL" />
<spring:url value="/my-account/applications" var="ordersUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<c:set var="hasShippedItems" value="${orderData.deliveryItemsQuantity > 0}" />
<c:set var="deliveryAddress" value="${orderData.deliveryAddress}" />

<template:page pageTitle="${pageTitle}">

	<c:forEach items="${orderData.entries}" var="orderEntry">
		<c:if test="${orderEntry.isServiceRequest}">
			<c:set var="serviceRequest" value="${orderEntry.product}" />
		</c:if>
	</c:forEach>
	<div class="row no-margin global-content-space order-detail-items">
		<div class="back-link border">
			<div class="row">
				<div class="col-md-6">
					<button type="button" class="addressBackBtn" data-back-to-addresses="${ordersUrl}">
						<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
					</button>
					<h1 class="custom-h1">
						<span class="label" tabindex="0"><spring:theme code="text.account.history.details" arguments="${serviceRequest.name}, ${orderData.code}" /></span>
					</h1>
				</div>
			</div>
		</div>

		<div class="col-sm-8 col-md-8">
			<div class="card-section">
				<div class="card-list">

					<div class="row no-margin">
						<div class="order-History-Detail-Summary card-150 col-xs-12 col-sm-12 col-md-12">
							<div class="card-section-content">
								<div>
									<p>
										<b><spring:theme code="text.account.orderHistory.orderStatus" /></b>&nbsp;&nbsp;
										<spring:theme code="text.account.order.status.display.${orderData.statusDisplay}" />
									</p>
								</div>
								<div>
									<p>
										<c:if test="${not empty orderData.deliveryMode}">
										  ${ycommerce:encodeHTML(orderData.deliveryMode.name)}
									    </c:if>
									</p>
								</div>
								<div>
									<p>
										<c:if test="${orderData.hasDocument}">
											<spring:theme code="text.account.history.document" arguments="${myDocumentsURL}" htmlEscape="false" var="historyDocument" />
											${ycommerce:sanitizeHTML(historyDocument)}
										</c:if>
									</p>
								</div>
							</div>
							<c:if test="${hasShippedItems and not empty deliveryAddress}">
								<div class="card-section-content">
									<div>${fn:escapeXml(deliveryAddress.title)}&nbsp;${fn:escapeXml(deliveryAddress.firstName)}&nbsp;${fn:escapeXml(deliveryAddress.lastName)}</div>
									<div>
										<c:if test="${ not empty deliveryAddress.line1 }">
								        ${fn:escapeXml(deliveryAddress.line1)}
							       </c:if>
										<c:if test="${ not empty deliveryAddress.line2 }">
								     ,&nbsp;${fn:escapeXml(deliveryAddress.line2)}
							       </c:if>
									</div>
									<div>
										<c:if test="${not empty deliveryAddress.town }">
								      ${fn:escapeXml(deliveryAddress.town)},&nbsp;
							       </c:if>
									</div>
									<div>
										<c:if test="${ not empty deliveryAddress.region.name }">
								      ${fn:escapeXml(deliveryAddress.region.name)},&nbsp;
							       </c:if>
									</div>
									<div>
										<c:if test="${ not empty deliveryAddress.postalCode }">
								      ${fn:escapeXml(deliveryAddress.postalCode)}
							        </c:if>
									</div>
									<div>
										<c:if test="${ not empty deliveryAddress.country.name }">
								     ${fn:escapeXml(deliveryAddress.country.name)}
							        </c:if>
									</div>
									<div>
										<c:if test="${ not empty deliveryAddress.phone }">
								      ${fn:escapeXml(deliveryAddress.phone)}
							       </c:if>
									</div>
								</div>
							</c:if>
							<div class="card-section-content">
								<p>
									<c:if test="${not empty orderData.created}">
										<fmt:formatDate value="${orderData.created}" type="date" />
									</c:if>
								</p>
							</div>

							<c:if test="${isRelationshipData ne true}">
								<div class="card-section-content">
									<p>
										<spring:theme code="text.account.orderHistory.submittedBy.colon" />
										<c:if test="${currentUserId eq orderData.placedBy or empty orderData.placedBy}">
											<spring:theme code="text.account.orderHistory.you" />
										</c:if>
										<c:if test="${currentUserId ne orderData.placedBy}">
											&nbsp; ${ycommerce:encodeHTML(placedByUser.firstName)}&nbsp; ${ycommerce:encodeHTML(placedByUser.lastName)}
										</c:if>
									</p>
								</div>
							</c:if>

						</div>
					</div>

					<div class="row no-margin">
						<c:if test="${not empty orderData.paymentInfo}">
							<div class="col-xs-12 col-sm-6 col-md-6 ">
								<order:paymentInfo orderData="${orderData}" />
							</div>
						</c:if>
						<c:if test="${orderData.totalPrice.value > 0}">
							<div class="col-xs-12 col-sm-6 col-md-6 ">
								<div class="card-200 col-xs-12 col-sm-12 col-md-12">
									<div class="card-section">
										<div class="card-section-h2">
											<h2>
												<span tabindex="0"><spring:theme code="account.order.application.total" text="Application Total" /></span>
											</h2>
										</div>
										<div class="card-section-content checkout-order-summary">
											<div aria-labelledby="applicationSummary" tabindex="0">
												<div id="applicationSummary">
													<order:deliveryCartItems orderData="${orderData}" showDeliveryAddress="false" />
													<order:orderTotals orderData="${orderData}" showTaxEstimate="true" showTax="true" />
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</div>

					<div class="row no-margin">
						<div class="col-xs-12 col-sm-12 col-md-12 ">
							<div class="card-transparent col-xs-12 col-sm-12 col-md-12">
								<div class="card-section-content">
									<c:forEach var="formHtml" items="${embeddedFormHtmlsReview}">
										<div class="formHtml">${formHtml}</div>

									</c:forEach>
								</div>
							</div>
						</div>
					</div>


					<c:if test="${not empty serviceRequest.consentDeclarations}">
						<div class="row no-margin">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="card-section-h1">
									<spring:theme code="checkout.summary.consentDeclaration" text="Consent Declaration" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-12 ">
								<div class="card-transparent col-xs-12 col-sm-12 col-md-12">
									<div class="card-section-content">
										<c:forEach items="${serviceRequest.consentDeclarations}" var="declaration" varStatus="declarationIndex">
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
	</div>
</template:page>
