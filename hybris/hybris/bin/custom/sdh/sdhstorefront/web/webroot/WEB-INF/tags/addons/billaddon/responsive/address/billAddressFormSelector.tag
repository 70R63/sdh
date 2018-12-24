<%@ attribute name="supportedCountries" required="false" type="java.util.List"%>
<%@ attribute name="regions" required="false" type="java.util.List"%>
<%@ attribute name="country" required="false" type="java.lang.String"%>
<%@ attribute name="cancelUrl" required="false" type="java.lang.String"%>
<%@ attribute name="tabindex" required="false" type="java.lang.Integer"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/billaddon/responsive/formElement"%>
<%@ taglib prefix="address" tagdir="/WEB-INF/tags/addons/billaddon/responsive/address"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<div id="billCountrySelector"  data-address-code="" data-country-iso-code="" data-display-title="false" class="clearfix row">
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

<div id="billingAddressForm" class="billingAddressForm row">
	<address:billingAddressFormElements regions="${regions}" country="${country}" tabindex="0" />
</div>

