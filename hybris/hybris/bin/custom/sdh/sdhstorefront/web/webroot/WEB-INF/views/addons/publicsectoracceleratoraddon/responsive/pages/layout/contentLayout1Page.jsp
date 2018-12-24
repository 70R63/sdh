<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template"
	tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">
	<cms:pageSlot position="Section1" var="feature">
		<cms:component component="${feature}" element="div" class="" />
	</cms:pageSlot>
</template:page>