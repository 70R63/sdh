<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<spring:htmlEscape defaultHtmlEscape="true" />

<template:page pageTitle="${pageTitle}">
	<div class="row">
		<div class="col-xs-12 col-md-12 plp_heading">
			<h1><span tabindex="0">${ycommerce:encodeHTML(searchPageData.categoryName)}</span></h1>
		</div>
		<h2 class="acc_hidden">
			<span tabindex="0"><spring:theme code="text.productlistpage.label" /></span>
		</h2>
	</div>

	<div class="row">
		<cms:pageSlot position="Section1" var="feature" element="div" class="product-grid-section1-slot">
			<cms:component component="${feature}" element="div" class="yComponentWrapper map product-grid-section1-component"/>
		</cms:pageSlot>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="col-xs-4 hidden-xs hidden-sm">
				<cms:pageSlot position="ProductLeftRefinements" var="feature" element="div" class="product-grid-left-refinements-slot">
					<cms:component component="${feature}" element="div" class="yComponentWrapper product-grid-left-refinements-component"/>
				</cms:pageSlot>
			</div>
			<div class="col-sm-12 col-md-8">
				<cms:pageSlot position="ProductGridSlot" var="feature" element="div" class="product-grid-right-result-slot">
					<cms:component component="${feature}" element="div" class="product__list--wrapper yComponentWrapper product-grid-right-result-component"/>
				</cms:pageSlot>
			</div>
		</div>
	</div>
</template:page>