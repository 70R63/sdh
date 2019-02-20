<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="idKey" required="true" type="java.lang.String" %>
<%@ attribute name="labelKey" required="true" type="java.lang.String" %>
<%@ attribute name="path" required="true" type="java.lang.String" %>
<%@ attribute name="items" required="true" type="java.util.Collection" %>
<%@ attribute name="itemValue" required="false" type="java.lang.String" %>
<%@ attribute name="itemLabel" required="false" type="java.lang.String" %>
<%@ attribute name="mandatory" required="false" type="java.lang.Boolean" %>
<%@ attribute name="labelCSS" required="false" type="java.lang.String" %>
<%@ attribute name="selectCSSClass" required="false" type="java.lang.String" %>
<%@ attribute name="skipBlank" required="false" type="java.lang.Boolean" %>
<%@ attribute name="skipBlankMessageKey" required="false" type="java.lang.String" %>
<%@ attribute name="selectedValue" required="false" type="java.lang.String" %>
<%@ attribute name="tabindex" required="false" rtexprvalue="true" %>
<%@ attribute name="disabled" required="false" type="java.lang.Boolean" %>
<%@ attribute name="onchange" required="false" type="java.lang.String" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var="escapedPath" value="${ycommerce:encodeHTML(path)}"/>
<c:set var="escapedIdKey" value="${ycommerce:encodeHTML(idKey)}"/>

<template:errorSpanField path="${escapedPath}">
	<ycommerce:testId code="LoginPage_Item_${escapedIdKey}">
	<c:if test="${mandatory != null && mandatory == true}">
			<c:set var="requiredClass" value="required"/>
		</c:if>
			<label class="control-label ${labelCSS} ${requiredClass}" for="${escapedIdKey}">
				<spring:theme code="${labelKey}"/>
				<c:if test="${mandatory != null && mandatory == true}">
					<span class="mandatory">
						<spring:theme code="login.required" var="loginRequiredText" htmlEscape="false"/>
					</span>
				</c:if>
					<span class="skip">
						<form:errors path="${path}"/>
					</span>
			</label>
			<div class="control">
				<form:select aria-required="${mandatory}" id="${escapedIdKey}" path="${escapedPath}" cssClass="${selectCSSClass}" tabindex="${tabindex}" disabled="${disabled}" onchange="${onchange}">
					<c:if test="${skipBlank == null || skipBlank == false}">
						<option value="" disabled="disabled" ${empty selectedValue ? 'selected="selected"' : ''}>
							<spring:theme code='${skipBlankMessageKey}'/>
						</option>
					</c:if>
					<form:options items="${items}" itemValue="${not empty itemValue ? itemValue :'code'}" itemLabel="${not empty itemLabel ? itemLabel :'name'}"/>
				</form:select>
			</div>
	</ycommerce:testId>
</template:errorSpanField>
