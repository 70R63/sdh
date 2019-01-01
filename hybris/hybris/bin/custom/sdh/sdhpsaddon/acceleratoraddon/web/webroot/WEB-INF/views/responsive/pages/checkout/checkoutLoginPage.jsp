<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:htmlEscape defaultHtmlEscape="true" />
 
<template:page pageTitle="${pageTitle}">
<h1 class="acc_hidden"><span tabindex="0"><spring:theme code="text.guestsigninregisterpage.label" /></span></h1>
    <div class="checkout-login">
        <div class="row">
            <div class="col-sm-12 col-md-4 visible-md visible-lg">
                <cms:pageSlot position="LeftContentSlot" var="feature">
                    <cms:component component="${feature}"/>
                </cms:pageSlot>
            </div>
            <div class="col-sm-12 col-md-4 visible-md visible-lg">
                <cms:pageSlot position="CenterContentSlot" var="feature" class="checkoutLoginPageCenter">
                    <cms:component component="${feature}"/>
                </cms:pageSlot>
            </div>
            <div class="col-sm-12 col-md-4 visible-xs visible-sm">
                <cms:pageSlot position="CenterContentSlot" var="feature" class="checkoutLoginPageCenter">
                    <cms:component component="${feature}"/>
                </cms:pageSlot>
            </div>
            <div class="col-sm-12 col-md-4 visible-xs visible-sm">
                <cms:pageSlot position="LeftContentSlot" var="feature">
                    <cms:component component="${feature}"/>
                </cms:pageSlot>
            </div>
            <div class="col-sm-12 col-md-4 hidden-xs hidden-sm">
                <cms:pageSlot position="RightContentSlot" var="feature">
                    <cms:component component="${feature}"/>
                </cms:pageSlot>
            </div>
        </div>
    </div>

</template:page>

