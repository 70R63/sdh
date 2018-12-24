<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="storepickup" tagdir="/WEB-INF/tags/responsive/storepickup"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="custom-nav" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/nav"%>
 <spring:htmlEscape defaultHtmlEscape="true" />
 
<template:page pageTitle="${pageTitle}">
	<div class="row">
		<div class="col-xs-12 col-md-12 plp_heading">
			<h1>
				<span tabindex="0"><spring:theme code="search.page.searchText" arguments="${searchPageData.freeTextSearch}" htmlEscape="false" /></span>
			</h1>
			<custom-nav:searchSpellingSuggestion spellingSuggestion="${searchPageData.spellingSuggestion}" />
		</div>
		<h2 class="acc_hidden">
			<span tabindex="0"><spring:theme code="text.productlistpage.label" /></span>
		</h2>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<div class="col-xs-4 hidden-xs hidden-sm">
				<cms:pageSlot position="ProductLeftRefinements" var="feature" element="div" class="product-grid-left-refinements-slot">
					<cms:component component="${feature}" element="div" class="yComponentWrapper product-grid-left-refinements-component"/>
				</cms:pageSlot>
			</div>
			<div class="col-sm-12 col-md-8">
				<cms:pageSlot position="SearchResultsGridSlot" var="feature" element="div" class="search-grid-page-result-grid-slot">
					<cms:component component="${feature}" element="div" class="search-grid-page-result-grid-component"/>
				</cms:pageSlot>
			</div>
		</div>
	</div>
	<storepickup:pickupStorePopup />
</template:page>