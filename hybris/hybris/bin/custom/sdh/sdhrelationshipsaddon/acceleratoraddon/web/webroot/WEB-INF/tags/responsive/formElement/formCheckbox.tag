<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="idKey" required="true" type="java.lang.String"%>
<%@ attribute name="labelKey" required="true" type="java.lang.String"%>
<%@ attribute name="path" required="true" type="java.lang.String"%>
<%@ attribute name="mandatory" required="false" type="java.lang.Boolean"%>
<%@ attribute name="labelCSS" required="false" type="java.lang.String"%>
<%@ attribute name="inputCSS" required="false" type="java.lang.String"%>
<%@ attribute name="tabindex" required="false" type="java.lang.String"%>
<%@ attribute name="valueKey" required="false" type="java.lang.String"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<template:errorSpanField path="${path}">
	<spring:theme code="${idKey}" var="themeIdKey" htmlEscape="false"/>

	   	<div class="checkbox" tabindex="${tabindex}" role="checkbox" aria-checked="false">
	   		
	   		<label class="control-label checkbox-label ${labelCSS}" for="${themeIdKey}">
	   			<form:checkbox cssClass="${inputCSS}" id="${themeIdKey}" value="${valueKey}" path="${path}" tabindex="${tabindex}"/>
	   			<spring:theme code="${labelKey}" htmlEscape="false"/>
	   			<c:if test="${mandatory != null && mandatory == true}">
	   				<span class="mandatory">
	   					<spring:theme code="login.required" var="loginrequiredText" />
	   				</span>
	   			</c:if>
	   			<span class="skip"><form:errors path="${path}"/></span>
	   		</label>
	   	</div>

</template:errorSpanField>
