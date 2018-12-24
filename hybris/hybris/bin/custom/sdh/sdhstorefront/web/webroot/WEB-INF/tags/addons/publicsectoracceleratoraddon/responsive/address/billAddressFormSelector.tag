<%@ attribute name="supportedCountries" required="false" type="java.util.List"%>
<%@ attribute name="regions" required="false" type="java.util.List"%>
<%@ attribute name="country" required="false" type="java.lang.String"%>
<%@ attribute name="cancelUrl" required="false" type="java.lang.String"%>
<%@ attribute name="tabindex" required="false" type="java.lang.Integer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="address" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/address"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:set var="defaultCountryIso" value="${ycommerce:encodeHTML(defaultCountry)}"/>
<div id="billingCountrySelector"  data-address-code="${ycommerce:encodeHTML(cartData.deliveryAddress.id)}" data-country-iso-code="${ycommerce:encodeHTML(cartData.deliveryAddress.country.isocode)}" data-display-title="false" class="clearfix">
	<input type="hidden" value="${ycommerce:encodeHTML(silentOrderPageData.parameters['billTo_email'])}" class="text" name="billTo_email" id="billTo_email">
	<formElement:formSelectBox idKey="address.country"
	                           labelKey="address.country"
	                           path="billTo_country"
	                           mandatory="true"
	                           skipBlank="false"
	                           skipBlankMessageKey="address.selectCountry"
	                           items="${supportedCountries}"
	                           itemValue="isocode"
	                           tabindex="0"
	                           selectCSSClass="form-control"/>
</div>
<input type="hidden" id="addressDefaultCountry" value="${defaultCountryIso}" default-country="${defaultCountryIso}" />
<div id="billingAddressForm" class="billingAddressForm">
	<address:billingAddressFormElements regions="${regions}" country="${country}" tabindex="0" />
</div>

