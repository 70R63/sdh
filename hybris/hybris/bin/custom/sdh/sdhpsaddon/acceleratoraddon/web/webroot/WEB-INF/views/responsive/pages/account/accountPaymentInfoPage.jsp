<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-account/" var="myAccountUrl"/>
<spring:theme code="text.back.icon.accessibility" var="back" />

<c:set var="noBorder" value="" />
<c:if test="${not empty paymentInfoData}">
	<c:set var="noBorder" value="no-border" />
</c:if>

<div class="row no-margin account-content-space">
	 <div class="back-link border">
		<div class="row">
			<div class="col-md-6">
				<button type="button" class="addressBackBtn" data-back-to-addresses="${myAccountUrl}">
					<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
				</button>
				<h1 class="custom-h1">
					<span class="label" tabindex="0"><spring:theme code="text.account.paymentDetails" /></span>
				</h1>
			</div>
		</div>
	</div>
	<div class="account-section-subheader">
		<div class="account-section-subheader-add pull-left">
			<spring:theme code="text.account.paymentInfo" />
		</div>
	</div>
	<c:choose>
		<c:when test="${not empty paymentInfoData}">
			<div class="account-paymentdetails account-list">
				<div class="account-cards card-select">
					<div class="row">
						<c:forEach items="${paymentInfoData}" var="paymentInfo">
					<c:set var="paymentInfoId" value="${ycommerce:encodeHTML(paymentInfo.id)}" />
							<div class="col-xs-12 col-sm-5 col-md-4 well">
								<div class="">
									<div class="card col-xs-12 col-sm-12 col-md-12">
										<ul>
											<li><c:if test="${paymentInfo.defaultPaymentInfo}">
													<strong>
												</c:if> ${fn:escapeXml(paymentInfo.accountHolderName)}<c:if test="${paymentInfo.defaultPaymentInfo}">&nbsp;(<spring:theme code="text.default" />)</c:if> <c:if test="${paymentInfo.defaultPaymentInfo}">

												</c:if></li>
											<li>${fn:escapeXml(paymentInfo.cardTypeData.name)}</li>
											<li><ycommerce:testId code="paymentDetails_item_cardNumber_text">${fn:escapeXml(paymentInfo.cardNumber)}</ycommerce:testId></li>
											<li><c:if test="${paymentInfo.expiryMonth lt 10}">0</c:if> ${fn:escapeXml(paymentInfo.expiryMonth)}&nbsp;/&nbsp;${fn:escapeXml(paymentInfo.expiryYear)}</li>
											<c:if test="${paymentInfo.billingAddress ne null}">
												<li>${fn:escapeXml(paymentInfo.billingAddress.line1)}</li>
												<li>${fn:escapeXml(paymentInfo.billingAddress.town)}&nbsp;${fn:escapeXml(paymentInfo.billingAddress.region.isocodeShort)}</li>
												<li>${fn:escapeXml(paymentInfo.billingAddress.country.name)}&nbsp;${fn:escapeXml(paymentInfo.billingAddress.postalCode)}</li>
											</c:if>
											</strong>
										</ul>
										<div class="account-cards-actions payment-details">
											<ycommerce:testId code="paymentDetails_deletePayment_button">
											<a class="action-links removePaymentDetailsButton" href="#" data-payment-id="${paymentInfoId}" data-popup-title="<spring:theme code="text.account.paymentDetails.delete.popup.title"/>"> <span class="glyphicon glyphicon-trash gi-2x"></span>
												</a>
											</ycommerce:testId>
										</div>
										<div>
											<p>
												<c:if test="${not paymentInfo.defaultPaymentInfo}">
													<c:url value="/my-account/set-default-payment-details" var="setDefaultPaymentActionUrl" />
											<form:form id="setDefaultPaymentDetails${paymentInfoId}" action="${setDefaultPaymentActionUrl}" method="post" cssClass="set-primary-button">
												<input type="hidden" name="paymentInfoId" value="${paymentInfoId}" />
														<ycommerce:testId code="paymentDetails_setAsDefault_button">
															<button type="submit" class="account-set-default-addres btn btn-primary">
																<spring:theme code="text.setDefault" text="Set as Default" />
															</button>
														</ycommerce:testId>
													</form:form>
												</c:if>
											</p>
										</div>
									</div>
									<div class="payment-removal-popup">
									<div id="popup_confirm_payment_removal_${paymentInfoId}" class="account-address-removal-popup">
											<spring:theme code="text.account.paymentDetails.delete.following" var="deletePaymentText" />
											<div tabindex="0" aria-label="${deletePaymentText}">${deletePaymentText}</div>
											<div class="address" tabindex="0" aria-labelledby="paymentDetails">
												<div id="paymentDetails">
													<strong> ${fn:escapeXml(paymentInfo.accountHolderName)} </strong> <br>${fn:escapeXml(paymentInfo.cardTypeData.name)} <br>${fn:escapeXml(paymentInfo.cardNumber)} ${fn:escapeXml(paymentInfo.expiryMonth)}<br>
													<c:if test="${paymentInfo.expiryMonth lt 10}">0</c:if>
													${fn:escapeXml(paymentInfo.expiryMonth)}&nbsp;/&nbsp;${fn:escapeXml(paymentInfo.expiryYear)}
													<c:if test="${paymentInfo.billingAddress ne null}">
														<br>${fn:escapeXml(paymentInfo.billingAddress.line1)}
                                                    <br>${fn:escapeXml(paymentInfo.billingAddress.town)}&nbsp;
                                                    ${fn:escapeXml(paymentInfo.billingAddress.region.isocodeShort)}
                                                   <br>${fn:escapeXml(paymentInfo.billingAddress.country.name)}&nbsp;
                                                    ${fn:escapeXml(paymentInfo.billingAddress.postalCode)}
                                                </c:if>
												</div>
											</div>
											<c:url value="/my-account/remove-payment-method" var="removePaymentActionUrl" />
										
											<br />
											<div class="modal-actions">
												<div class="col-xs-12 col-sm-6">
													<button type="submit" class="btn btn-grey btn-block closeColorBox btn-block" data-payment-id="${paymentInfoId}">
														<spring:theme code="text.button.cancel" />
													</button>
												</div>
												<form:form id="removePaymentDetails${paymentInfoId}" action="${removePaymentActionUrl}" method="post">
										                  <input type="hidden" name="paymentInfoId" value="${paymentInfoId}" />
													<ycommerce:testId code="paymentDetailsDelete_delete_button">
														<div class="col-xs-12 col-sm-6">
															<button type="submit" class="btn btn-default btn-primary btn-block paymentsDeleteBtn">
																<spring:theme code="text.account.paymentDetails.delete" />
															</button>
														</div>
													</ycommerce:testId>
						
											</div>
											</form:form>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="account-section-content	col-md-6 col-md-pull-1 content-empty">
					<br> <span tabindex="0"><strong><spring:theme code="text.account.paymentDetails.noPaymentInformation" /></strong></span>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>