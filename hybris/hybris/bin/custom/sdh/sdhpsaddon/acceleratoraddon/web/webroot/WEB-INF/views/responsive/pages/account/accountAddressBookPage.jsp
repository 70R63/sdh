<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-account" var="myAccountUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<c:set var="noBorder" value="" />
<c:if test="${not empty addressData}">
	<c:set var="noBorder" value="no-border" />
</c:if>
<div class="row no-margin global-content-space">
	<div class="address-back-button">
		<div class="back-link">
			<div class="row">
				<div class="col-md-6">
					<button type="button" class="addressBackBtn" data-back-to-addresses="${myAccountUrl}">
						<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
					</button>
					<h1 class="custom-h1">
						<span class="label" tabindex="0"><spring:theme code="text.account.addressBook" /></span>
					</h1>
				</div>
			</div>
		</div>

		<div class="account-section-header-add col-xs-12 col-md-3 col-sm-4">
			<spring:theme code="text.account.addressBook.addAddress" var="textAccountAddressBookAddAddress" />
			<button type="button" aria-label="${textAccountAddressBookAddAddress}" class="btn btn-primary btn-block" onclick="window.location='add-address'">
				<spring:theme code="text.account.addressBook.addAddress" />
			</button>
		</div>
	</div>

	<div class="account-section-subheader">
		<ycommerce:testId code="addressBook_addNewAddress_button">
			<div class="account-section-subheader-add pull-left"></div>
		</ycommerce:testId>
	</div>

	<div class="account-addressbook account-list">
		<c:if test="${empty addressData}">
			<div class="row">
				<div tabindex="0" class="account-section-content col-md-6 col-md-push-3 content-empty">
					<spring:theme code="text.account.addressBook.noSavedAddresses" />
				</div>
			</div>
		</c:if>

		<c:if test="${not empty addressData}">
			<div class="account-cards card-select">
				<div class="row">
					<c:forEach items="${addressData}" var="address">
						<div class="col-xs-12 col-sm-5 col-md-4 well">
							<div>
								<div class="card col-xs-12 col-sm-12 col-md-12">
									<br />
									<c:if test="${not address.defaultAddress}">
										<ul>
											<li>${fn:escapeXml(address.title)}&nbsp;${fn:escapeXml(address.firstName)}&nbsp;${fn:escapeXml(address.lastName)}</li>
											<li>${fn:escapeXml(address.line1)}</li>
											<c:if test="${not empty fn:escapeXml(address.line2)}">
												<li>${fn:escapeXml(address.line2)}</li>
											</c:if>
											<li>${fn:escapeXml(address.town)}&nbsp;${fn:escapeXml(address.region.name)}</li>
											<li>${fn:escapeXml(address.country.name)}&nbsp;${fn:escapeXml(address.postalCode)}</li>
											<li>${fn:escapeXml(address.phone)}</li>
										</ul>
									</c:if>
									<c:if test="${address.defaultAddress}">
										<ul>
											<li>${fn:escapeXml(address.title)}&nbsp;${fn:escapeXml(address.firstName)}&nbsp;${fn:escapeXml(address.lastName)}(<spring:theme code="text.default" />)
											</li>
											<li><strong>${fn:escapeXml(address.line1)}</strong></li>
											<c:if test="${not empty fn:escapeXml(address.line2)}">
												<li><strong>${fn:escapeXml(address.line2)}</strong></li>
											</c:if>
											<li><strong>${fn:escapeXml(address.town)}&nbsp;${fn:escapeXml(address.region.name)}</strong></li>
											<li><strong>${fn:escapeXml(address.country.name)}&nbsp;${fn:escapeXml(address.postalCode)}</strong></li>
											<li><strong>${fn:escapeXml(address.phone)}</strong></li>
										</ul>
									</c:if>
									<br />

									<div class="account-cards-actions address-details">
										<ycommerce:testId code="addressBook_editAddress_button">
											<spring:theme code="text.account.edit.address" var="textAccountEditAddress" />
											<a aria-label="${textAccountEditAddress}" class="action-links" href="edit-address/${ycommerce:encodeHTML(address.id)}">
											   <span class="visuallyhidden">${textAccountEditAddress}</span>
											   <span class="glyphicon glyphicon-edit gi-2x"></span>
										    </a>
										</ycommerce:testId>
										<ycommerce:testId code="addressBook_removeAddress_button">
											<spring:theme code="text.account.delete.address" var="textAccountDeleteAddress" />
											<a aria-label="${textAccountDeleteAddress}" href="#" class="action-links removeAddressFromBookButton" data-address-id="${ycommerce:encodeHTML(address.id)}"
												data-popup-title="<spring:theme code="text.address.delete.popup.title" />">
												<span class="visuallyhidden">${textAccountDeleteAddress}</span>
												<span class="glyphicon glyphicon-trash gi-2x"></span>
											</a>
										</ycommerce:testId>
									</div>
									<div class="account-button">
										<c:if test="${not address.defaultAddress}">
											<ycommerce:testId code="addressBook_isDefault_button">
												<spring:theme code="text.account.setPrimary.address" var="textAccountSetPrimaryAddress" />
												<button type="button" aria-label="${textAccountSetPrimaryAddress}" class="account-set-default-addres btn btn-primary" onclick="window.location='set-default-address/${address.id}?CSRFToken=${CSRFToken.token}'">
													<spring:theme code="text.setDefault" />
												</button>
											</ycommerce:testId>
										</c:if>
									</div>
								</div>

								<div id="popup_confirm_address_removal_${ycommerce:encodeHTML(address.id)}" class="account-address-removal-popup">
									<div class="addressItem">
										<spring:theme code="text.address.remove.following" var="deleteAddressText" />
										<div tabindex="0" aria-label="${deleteAddressText}">${deleteAddressText}</div>
										<div class="address" tabindex="0" aria-labelledby="addressDetails">
											<div id=addressDetails>
												<strong> ${fn:escapeXml(address.title)}&nbsp; ${fn:escapeXml(address.firstName)}&nbsp; ${fn:escapeXml(address.lastName)} </strong> 
												<br> ${fn:escapeXml(address.line1)}&nbsp; ${fn:escapeXml(address.line2)} <br> ${fn:escapeXml(address.town)}&nbsp;
												<c:if test="${not empty address.region.name }">
                                                     ${fn:escapeXml(address.region.name)}&nbsp;
                                                </c:if>
												<br> ${fn:escapeXml(address.country.name)}&nbsp; ${fn:escapeXml(address.postalCode)} <br /> ${fn:escapeXml(address.phone)}
											</div>
										</div>

										<div class="modal-actions">
											<div class="col-xs-12 col-sm-6">
												<button type="submit" class="btn btn btn-grey btn-block center-block closeColorBox" data-address-id="${address.id}">
													<spring:theme code="text.button.cancel" />
												</button>
											</div>
											<ycommerce:testId code="addressRemove_delete_button">
												<div class="col-xs-12 col-sm-6">
													<button class="btn btn-primary btn-block" data-address-id="${ycommerce:encodeHTML(address.id)}" onclick="window.location='remove-address/${ycommerce:encodeHTML(address.id)}?CSRFToken=${CSRFToken.token}'">
														<spring:theme code="text.address.delete" />
													</button>
												</div>
											</ycommerce:testId>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:if>
		
		<div class="my-address">
			<div class="account-my-address">
				<div id="accordion" class="custom-accordion">
					<c:forEach items="${allRelationships}" var="currRelationship" varStatus="loop">
							<div class="panel-heading">
								<h2 class="panel-title">
									<a tabindex="0" class="accordion-toggle ui-icon-plus relationAddressesLink" href="#relationAddressesSection_${loop.count}" aria-expanded="false" aria-controls="relationAddressesSection_${loop.count}"> 
									  <span class="accordian-heading"> 
										   <spring:theme code="text.relations.addresses" arguments="${currRelationship.firstName} ${currRelationship.lastName}" />
									  </span> 
									  <input type="hidden" id="loopCount" value="${loop.count}" />
									  <input type="hidden" id="hidden_${loop.count}" value="${ycommerce:encodeHTML(currRelationship.uid)}" />
									</a>
								</h2>
							</div>
							<div id="relationAddressesSection_${loop.count}">
							</div>
					</c:forEach>
				</div>
			</div>
		</div>
		
	</div>
</div>
