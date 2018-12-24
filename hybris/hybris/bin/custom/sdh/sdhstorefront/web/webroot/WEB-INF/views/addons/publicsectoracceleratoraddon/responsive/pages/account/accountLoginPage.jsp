<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<template:page pageTitle="${pageTitle}">
	<div class="row">
		<h1 class="acc_hidden"><span tabindex="0"><spring:theme code="text.signinregisterpage.label" /></span></h1>
		<c:if test="${showRegisterBody || showLoginBody}">
			<div class="col-md-6" >
				<cms:pageSlot position="LeftContentSlot" var="feature" element="div" class="login-left-content-slot">
					<cms:component component="${feature}" element="div" class="login-left-content-component"/>
				</cms:pageSlot>
			</div>
		</c:if>
		<div class="col-md-6">
			<cms:pageSlot position="RightContentSlot" var="feature" element="div" class="login-right-content-slot">
				<cms:component component="${feature}"  element="div" class="login-right-content-component"/>
			</cms:pageSlot>
		</div>
	</div>
</template:page>