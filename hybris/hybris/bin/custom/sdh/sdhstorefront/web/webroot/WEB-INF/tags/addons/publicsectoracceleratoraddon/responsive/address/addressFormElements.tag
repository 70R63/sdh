<%@ attribute name="regions" required="true" type="java.util.List"%>
<%@ attribute name="country" required="false" type="java.lang.String"%>
<%@ attribute name="tabIndex" required="false" type="java.lang.Integer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/formElement" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<input type="hidden" name="primaryAddressCountry" value="${country}" />
<c:choose>
	<c:when test="${country == 'US'}">
		<formElement:formSelectBox idKey="address.title" labelKey="address.title" path="titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="address.title.pleaseSelect" items="${titles}" selectedValue="${addressForm.titleCode}" selectCSSClass="form-control"/>
		<formElement:formInputBox idKey="address.firstName" maxlength="240" labelKey="address.firstName" path="firstName" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.surname" maxlength="240" labelKey="address.surname" path="lastName" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.line1" maxlength="255" labelKey="address.line1" path="line1" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.line2" maxlength="255" labelKey="address.line2" path="line2" inputCSS="form-control" mandatory="false"/>
		<formElement:formInputBox idKey="address.townCity" maxlength="255" labelKey="address.townCity" path="townCity" inputCSS="form-control" mandatory="true" />
		<formElement:formSelectBox idKey="address.region" labelKey="address.state" path="regionIso" mandatory="true" skipBlank="false" skipBlankMessageKey="address.state" items="${regions}" itemValue="${useShortRegionIso ? 'isocodeShort' : 'isocode'}" selectedValue="${addressForm.regionIso}" selectCSSClass="form-control"/>
		<formElement:formInputBox idKey="address.postcode" maxlength="10" labelKey="address.zipcode" path="postcode" inputCSS="form-control" mandatory="true" />
        <formElement:formInputBox idKey="address.phone" maxlength="10" labelKey="address.phone" path="phone" inputCSS="form-control" mandatory="false" />
	</c:when>
	<c:when test="${country == 'CA'}">
		<formElement:formSelectBox idKey="address.title" labelKey="address.title" path="titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="address.title.pleaseSelect" items="${titles}" selectedValue="${addressForm.titleCode}" selectCSSClass="form-control"/>
		<formElement:formInputBox idKey="address.firstName" maxlength="240" labelKey="address.firstName" path="firstName" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.surname" maxlength="240" labelKey="address.surname" path="lastName" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.line1" maxlength="255" labelKey="address.line1" path="line1" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.line2" maxlength="255" labelKey="address.line2" path="line2" inputCSS="form-control" mandatory="false"/>
		<formElement:formInputBox idKey="address.townCity" maxlength="255" labelKey="address.townCity" path="townCity" inputCSS="form-control" mandatory="true" />
		<formElement:formSelectBox idKey="address.region" labelKey="address.province" path="regionIso" mandatory="true" skipBlank="false" skipBlankMessageKey="address.state" items="${regions}" itemValue="${useShortRegionIso ? 'isocodeShort' : 'isocode'}" selectedValue="${addressForm.regionIso}" selectCSSClass="form-control"/>
		<formElement:formInputBox idKey="address.postcode" maxlength="10" labelKey="address.postalcode" path="postcode" inputCSS="form-control" mandatory="true" />
        <formElement:formInputBox idKey="address.phone" maxlength="10" labelKey="address.phone" path="phone" inputCSS="form-control" mandatory="false" />
	</c:when>
	<c:when test="${country == 'CN'}">
		<formElement:formInputBox idKey="address.postcode" maxlength="10" labelKey="address.postalcode" path="postcode" inputCSS="form-control" mandatory="true" />
		<formElement:formSelectBox idKey="address.region" labelKey="address.province" path="regionIso" mandatory="true" skipBlank="false" skipBlankMessageKey="address.selectProvince" items="${regions}" itemValue="${useShortRegionIso ? 'isocodeShort' : 'isocode'}" selectedValue="${addressForm.regionIso}" selectCSSClass="form-control"/>
		<formElement:formInputBox idKey="address.townCity" maxlength="255" labelKey="address.townCity" path="townCity" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.line1" maxlength="255" labelKey="address.street" path="line1" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.line2" maxlength="255" labelKey="address.building" path="line2" inputCSS="form-control" mandatory="false"/>
		<formElement:formInputBox idKey="address.surname" maxlength="240" labelKey="address.surname" path="lastName" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.firstName" maxlength="240" labelKey="address.firstName" path="firstName" inputCSS="form-control" mandatory="true" />
		<formElement:formSelectBox idKey="address.title" labelKey="address.title" path="titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="address.title.pleaseSelect" items="${titles}" selectedValue="${addressForm.titleCode}" selectCSSClass="form-control"/>
        <formElement:formInputBox idKey="address.phone" maxlength="10" labelKey="address.phone" path="phone" inputCSS="form-control" mandatory="false" />
	</c:when>
	<c:when test="${country == 'JP'}">
		<formElement:formSelectBox idKey="address.title" labelKey="address.title" path="titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="address.title.pleaseSelect" items="${titles}" selectedValue="${addressForm.titleCode}" selectCSSClass="form-control"/>
		<formElement:formInputBox idKey="address.surname" maxlength="240" labelKey="address.surname" path="lastName" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.firstName" maxlength="240" labelKey="address.firstName" path="firstName" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.line1" maxlength="255" labelKey="address.furtherSubarea" path="line1" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.line2" maxlength="255" labelKey="address.subarea" path="line2" inputCSS="form-control" mandatory="true"/>
		<formElement:formInputBox idKey="address.townCity" maxlength="255" labelKey="address.townJP" path="townCity" inputCSS="form-control" mandatory="true" />
		<formElement:formSelectBox idKey="address.region" labelKey="address.prefecture" path="regionIso" mandatory="true" skipBlank="false" skipBlankMessageKey="address.selectPrefecture" items="${regions}" itemValue="${useShortRegionIso ? 'isocodeShort' : 'isocode'}" selectedValue="${addressForm.regionIso}" selectCSSClass="form-control"/>
		<formElement:formInputBox idKey="address.postalcode" maxlength="10" labelKey="address.postcode" path="postcode" inputCSS="form-control" mandatory="true" />
        <formElement:formInputBox idKey="address.phone" maxlength="10" labelKey="address.phone" path="phone" inputCSS="form-control" mandatory="false" />
	</c:when>
	<c:otherwise>
		<formElement:formSelectBox idKey="address.title" labelKey="address.title" path="titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="address.title.pleaseSelect" items="${titles}" selectedValue="${addressForm.titleCode}" selectCSSClass="form-control"/>
		<formElement:formInputBox  maxlength="240" idKey="address.firstName" labelKey="address.firstName" path="firstName" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.surname" maxlength="240" labelKey="address.surname" path="lastName" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.line1" maxlength="255" labelKey="address.line1" path="line1" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.line2" maxlength="255" labelKey="address.line2" path="line2" inputCSS="form-control" mandatory="false"/>
		<formElement:formInputBox idKey="address.townCity" maxlength="255" labelKey="address.townCity" path="townCity" inputCSS="form-control" mandatory="true" />
		<formElement:formInputBox idKey="address.postcode" maxlength="10" labelKey="address.postcode" path="postcode" inputCSS="form-control" mandatory="true" />
        <formElement:formInputBox idKey="address.phone" maxlength="10" labelKey="address.phone" path="phone" inputCSS="form-control" mandatory="false" />
	</c:otherwise>
</c:choose>

