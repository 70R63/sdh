<%@ attribute name="regions" required="true" type="java.util.List"%>
<%@ attribute name="country" required="false" type="java.lang.String"%>
<%@ attribute name="tabindex" required="false" type="java.lang.Integer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<c:choose>
	<c:when test="${country == 'US'}">
		<div class="col-sm-12 no-space"><formElement:formSelectBox idKey="address.title" labelKey="address.title" path="billTo_titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="address.title.pleaseSelect" items="${titles}" selectedValue="${addressForm.titleCode}" tabindex="${tabindex}" selectCSSClass="form-control"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.firstName" maxlength="240" labelKey="address.firstName" path="billTo_firstName" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.surname" maxlength="240" labelKey="address.surname" path="billTo_lastName" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.line1" maxlength="255" labelKey="address.line1" path="billTo_street1" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.line2" maxlength="255" labelKey="address.line2" path="billTo_street2" inputCSS="text" mandatory="false" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.townCity" maxlength="255" labelKey="address.townCity" path="billTo_city" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formSelectBox idKey="address.region" labelKey="address.state" path="billTo_state" mandatory="true" skipBlank="false" skipBlankMessageKey="address.selectState" items="${regions}" itemValue="isocodeShort" tabindex="${tabindex}" selectCSSClass="form-control"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.postcode" maxlength="10" labelKey="address.postcode" path="billTo_postalCode" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
	</c:when>
	<c:when test="${country == 'CA'}">
		<div class="col-sm-12 no-space"><formElement:formSelectBox idKey="address.title" labelKey="address.title" path="billTo_titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="address.title.pleaseSelect" items="${titles}" selectedValue="${addressForm.titleCode}" tabindex="${tabindex}" selectCSSClass="form-control"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.firstName" maxlength="240" labelKey="address.firstName" path="billTo_firstName" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.surname" maxlength="240" labelKey="address.surname" path="billTo_lastName" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.line1" maxlength="255" labelKey="address.line1" path="billTo_street1" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.line2" maxlength="255" labelKey="address.line2" path="billTo_street2" inputCSS="text" mandatory="false" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.townCity" maxlength="255" labelKey="address.townCity" path="billTo_city" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formSelectBox idKey="address.region" labelKey="address.province" path="billTo_state" mandatory="true" skipBlank="false" skipBlankMessageKey="address.selectProvince" items="${regions}" itemValue="isocodeShort" tabindex="${tabindex}" selectCSSClass="form-control"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.postcode" maxlength="10" labelKey="address.postcode" path="billTo_postalCode" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
	</c:when>
	<c:when test="${country == 'CN'}">
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.postcode" maxlength="10" labelKey="address.postcode" path="billTo_postalCode" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formSelectBox idKey="address.region" labelKey="address.province" path="billTo_state" mandatory="true" skipBlank="false" skipBlankMessageKey="address.selectProvince" items="${regions}" itemValue="isocodeShort" tabindex="${tabindex}" selectCSSClass="form-control"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.townCity" maxlength="255" labelKey="address.townCity" path="billTo_city" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.line2" maxlength="255" labelKey="address.district_and_street" path="billTo_street2" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.line1" maxlength="255" labelKey="address.building_and_room" path="billTo_street1" inputCSS="text" mandatory="false" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.surname" maxlength="240" labelKey="address.surname" path="billTo_lastName" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.firstName" maxlength="240" labelKey="address.firstName" path="billTo_firstName" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formSelectBox idKey="address.title" labelKey="address.title" path="billTo_titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="address.title.pleaseSelect" items="${titles}" selectedValue="${addressForm.titleCode}" tabindex="${tabindex}" selectCSSClass="form-control"/></div>
	</c:when>
	<c:when test="${country == 'JP'}">
		<div class="col-sm-12 no-space"><formElement:formSelectBox idKey="address.title" labelKey="address.title" path="billTo_titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="address.title.pleaseSelect" items="${titles}" selectedValue="${addressForm.titleCode}" tabindex="${tabindex}" selectCSSClass="form-control"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.surname" maxlength="240" labelKey="address.surname" path="billTo_lastName" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.firstName" maxlength="240" labelKey="address.firstName" path="billTo_firstName" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.postcode" maxlength="10" labelKey="address.postcodeJP" path="billTo_postalCode" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formSelectBox idKey="address.region" labelKey="address.prefecture" path="billTo_state" mandatory="true" skipBlank="false" skipBlankMessageKey="address.selectPrefecture" items="${regions}" itemValue="isocodeShort" tabindex="${tabindex}" selectCSSClass="form-control"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.townCity" maxlength="255" labelKey="address.townJP" path="billTo_city" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.line2" maxlength="255" labelKey="address.subarea" path="billTo_street2" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.line1" maxlength="255" labelKey="address.furtherSubarea" path="billTo_street1" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
	</c:when>
	<c:otherwise>
		<div class="col-sm-12 no-space"><formElement:formSelectBox idKey="address.title" labelKey="address.title" path="billTo_titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="address.title.pleaseSelect" items="${titles}" selectedValue="${addressForm.titleCode}" tabindex="${tabindex}" selectCSSClass="form-control"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.firstName" maxlength="240" labelKey="address.firstName" path="billTo_firstName" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.surname" maxlength="240" labelKey="address.surname" path="billTo_lastName" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.line1" maxlength="255" labelKey="address.line1" path="billTo_street1" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.line2" maxlength="255" labelKey="address.line2" path="billTo_street2" inputCSS="text" mandatory="false" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.townCity" maxlength="255" labelKey="address.townCity" path="billTo_city" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
		<div class="col-sm-12 no-space"><formElement:formInputBox idKey="address.postcode" maxlength="10" labelKey="address.postcode" path="billTo_postalCode" inputCSS="text" mandatory="true" tabindex="${tabindex}"/></div>
	</c:otherwise>
</c:choose>

