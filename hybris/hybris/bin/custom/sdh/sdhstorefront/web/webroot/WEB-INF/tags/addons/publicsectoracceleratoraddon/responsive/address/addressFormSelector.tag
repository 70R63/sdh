<%@ attribute name="supportedCountries" required="true" type="java.util.List"%>
<%@ attribute name="regions" required="true" type="java.util.List"%>
<%@ attribute name="country" required="false" type="java.lang.String"%>
<%@ attribute name="cancelUrl" required="false" type="java.lang.String"%>
<%@ attribute name="addressBook" required="false" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="address" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/address"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${empty addressFormEnabled or addressFormEnabled}">
<c:set var="defaultCountryIso" value="${ycommerce:encodeHTML(defaultCountry)}"/>
	<form:form method="post" commandName="addressForm">
		<form:hidden path="addressId" class="add_edit_delivery_address_id" status="${not empty suggestedAddresses ? 'hasSuggestedAddresses' : ''}" value="" />
		<input type="hidden" name="bill_state" id="address.billstate" />
		<input type="hidden" id="addressDefaultCountry" value="${defaultCountryIso}" default-country="${defaultCountryIso}" />
		<input type="hidden" name="url" value="${redirectUrl}" />

		<sec:authorize access="!hasAnyRole('ROLE_ANONYMOUS')">
			<div class="checkbox usePrimaryAddressShip-checkbox">
				<c:set var="displayPrimaryAddressClass" value="show" />
				<c:if test="${showUsePrimaryAddress}">
					<c:set var="displayPrimaryAddressClass" value="hideContent" />
					<formElement:formCheckbox idKey="usePrimaryAddressShip" labelKey="checkout.multi.sop.useMyPrimaryAddress" path="usePrimaryAddress" inputCSS="add-address-left-input" labelCSS="add-address-left-label usePrimaryAddressShip" mandatory="true" tabindex="0" />
				</c:if>
			</div>
		</sec:authorize>

		<c:if test="${not empty deliveryAddresses}">
		<div class="col-sm-6 col-xs-12 no-space display-primary-address ${displayPrimaryAddressClass}">
			<button type="button" class="btn btn-default btn-block js-address-book ${displayPrimaryAddressClass}">
				<spring:theme code="checkout.checkout.multi.deliveryAddress.viewAddressBook" text="Address Book" />
			</button></div>
		</c:if>

		<%-- Start Div for Primary address --%>
		<div class="card-section-content shipping-address-content primary-address">
			<input type="hidden" id="primaryAddressCountryCode" value="${ycommerce:encodeHTML(primaryAddress.country.isocode)}" />
			<div class="col-xs-12 col-sm-12 col-md-6 address-card">
				<div class="row no margin">
					<div class="card col-xs-12 col-sm-12 col-md-6">
						<div class="shippingAddressbook">
							<div class="addressEntry">
								<ul>
									<li tabindex="0"><strong>${fn:escapeXml(primaryAddress.title)}&nbsp; ${fn:escapeXml(primaryAddress.firstName)}&nbsp; ${fn:escapeXml(primaryAddress.lastName)}</strong> <br> ${fn:escapeXml(primaryAddress.line1)}&nbsp; ${fn:escapeXml(primaryAddress.line2)} <br> ${fn:escapeXml(primaryAddress.town)} <c:if test="${not empty primaryAddress.region.name}">
															&nbsp;${fn:escapeXml(primaryAddress.region.name)}
														</c:if> <br> ${fn:escapeXml(primaryAddress.country.name)}&nbsp; ${fn:escapeXml(primaryAddress.postalCode)}</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%-- End Div for Primary address --%>

		<%-- Start Div for Address book selected Primary address --%>
		<div class="card-section-content shipping-address-content addressBook-primary-address hideContent">
			<div class="col-xs-12 col-sm-12 col-md-6 address-card">
				<div class="row">
					<div class="card col-xs-12 col-sm-12 col-md-6">
						<div class="shippingAddressbook">
							<div class="addressEntry">
								<ul>

								</ul>
							</div>
						</div>
						<div class="account-cards-actions shipping-primary-address-delete pull-right">
							<ycommerce:testId code="addressBook_removeAddress_button">
								<spring:theme code="text.checkout.delete.address" var="textCheckoutDeleteAddress" />
								<a aria-label="${textCheckoutDeleteAddress}" href="#" class="action-links removeShippingAddressButton shipping-address-delete"> <span class="visuallyhidden">${textCheckoutDeleteAddress}</span> <span class="glyphicon glyphicon-trash gi-2x"></span>
								</a>
							</ycommerce:testId>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%-- End Div for Address book selected Primary address --%>

		<br>
		<div id="countrySelector" data-address-code="${addressData.id}" data-country-iso-code="${addressData.country.isocode}" class="form-group ${displayPrimaryAddressClass} countrySelector">
			<formElement:formSelectBox idKey="address.country" labelKey="address.country" path="countryIso" mandatory="true" skipBlank="false" skipBlankMessageKey="address.country" items="${supportedCountries}" itemValue="isocode" selectedValue="${addressForm.countryIso}" selectCSSClass="form-control" />
		</div>

		<div id="i18nAddressForm" class="i18nAddressForm ${displayPrimaryAddressClass}">
			<c:if test="${not empty addressForm.countryIso}">
				<address:addressFormElements regions="${regions}" country="${addressForm.countryIso}" />
			</c:if>
		</div>
		<sec:authorize access="!hasAnyRole('ROLE_ANONYMOUS')">
			<div class="checkbox saveAddress-inMy-AddressBook ${displayPrimaryAddressClass}">
				<c:choose>
					<c:when test="${showSaveToAddressBook}">
						<formElement:formCheckbox idKey="saveAddressInMyAddressBook" labelKey="checkout.summary.deliveryAddress.saveAddressInMyAddressBook" path="saveInAddressBook" inputCSS="add-address-left-input" labelCSS="add-address-left-label saveAddressInMyAddressBook" mandatory="true" tabindex="0" />
					</c:when>
					<c:when test="${not addressBookEmpty && not isDefaultAddress}">
						<ycommerce:testId code="editAddress_defaultAddress_box">
							<formElement:formCheckbox idKey="defaultAddress" labelKey="address.default" path="defaultAddress" inputCSS="add-address-left-input" labelCSS="add-address-left-label defaultAddress" mandatory="true" tabindex="0" />
						</ycommerce:testId>
					</c:when>
				</c:choose>
			</div>
		</sec:authorize>

		<c:if test="${not empty savedDeliveryAddress }">
			<div id="selectedDeliveryAddress" data-addresscode="${savedDeliveryAddress.id}" data-countryisocode="${savedDeliveryAddress.country.isocode}" data-regionisocode="${savedDeliveryAddress.region.isocodeShort}"></div>
		</c:if>
		<input type="hidden" value="${showSelectedDeliveryAddress}" name="showSelectedDeliveryAddress" id="showSelectedDeliveryAddress">

		<div id="addressform_button_panel" class="form-actions">
			<c:choose>
				<c:when test="${edit eq true && not addressBook}">
					<ycommerce:testId code="multicheckout_saveAddress_button">
						<button class="positive right change_address_button show_processing_message" type="submit">
							<spring:theme code="checkout.multi.saveAddress" text="Save address" />
						</button>
					</ycommerce:testId>
				</c:when>
				<c:when test="${addressBook eq true}">
					<div class="accountActions clearfix">
						<div class="col-sm-6 accountButtons">
							<ycommerce:testId code="editAddress_cancelAddress_button">
								<c:url value="${cancelUrl}" var="cancel" />
							<button type="button" class="btn btn-block btn-default" onclick="window.location='${cancel}'"> <spring:theme code="text.button.cancel" text="Cancel" />
								</button>
							</ycommerce:testId>
						</div>
						<div class="col-sm-6 accountButtons">
							<ycommerce:testId code="editAddress_saveAddress_button">
								<button class="btn btn-primary btn-block change_address_button show_processing_message" type="submit">
									<spring:theme code="text.button.save" text="Save" />
								</button>
							</ycommerce:testId>
						</div>
					</div>
				</c:when>
			</c:choose>
		</div>
	</form:form>
</c:if>