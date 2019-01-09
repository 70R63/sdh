<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="idKey" required="true" type="java.lang.String"%>
<%@ attribute name="labelKey" required="true" type="java.lang.String"%>
<%@ attribute name="path" required="true" type="java.lang.String"%>
<%@ attribute name="mandatory" required="false" type="java.lang.Boolean"%>
<%@ attribute name="labelCSS" required="false" type="java.lang.String"%>
<%@ attribute name="inputCSS" required="false" type="java.lang.String"%>
<%@ attribute name="errorPath" required="false" type="java.lang.String"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<template:errorSpanField path="${path}" errorPath="${errorPath}">
	<ycommerce:testId code="LoginPage_Item_${idKey}">
	<c:if test="${mandatory != null && mandatory == true}">
			<c:set var="requiredClass" value="required"/>
		</c:if>
		<label class="control-label ${labelCSS} ${requiredClass}" for="${idKey}">
			<spring:theme code="${labelKey}" htmlEscape="false"/>
			<c:if test="${mandatory != null && mandatory == false}">
				<spring:theme code="login.optional" />
			</c:if>
		</label>
		<form:password aria-required="${mandatory}" cssClass="${inputCSS}" id="${idKey}" path="${path}" autocomplete="off"/>
	</ycommerce:testId>
</template:errorSpanField>
