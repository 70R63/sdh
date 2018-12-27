<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/nav"%>

<template:page pageTitle="${pageTitle}">
	<!-- Jumbotron -->
	<div class="jumbotron no-space ng-scope">
		<div class="row">
			<div class="col-xs-12 no-space">
				<cms:pageSlot position="Section1" var="feature">
					<cms:component component="${feature}" />
				</cms:pageSlot>
			</div>
		</div>
		<!-- Site Search -->
		<div class="row site-search-box">
			<div class="col-xs-12 col-sm-12 col-md-12 no-space">
				<div class="site-search">
					<nav:searchBox></nav:searchBox>
					<ul class="ui-autocomplete ui-front ui-menu ui-widget ui-widget-content" id="ui-id-2" tabindex="0" style="display: none;"></ul>
				</div>
			</div>
		</div>
		<!-- FUS - Frequently Used Service -->
		<div class="fus-features-box row">
			<cms:pageSlot position="Section2A" var="feature">
				<cms:component component="${feature}" element="" class="" />
			</cms:pageSlot>
		</div>
	</div>
	<!-- Hero Images -->
	<div class="heroImages-box ng-scope row">
		<div class="col-xs-12 col-sm-12 col-md-12 no-space">
			<div class="hero-features">
				<cms:pageSlot position="Section2B" var="feature">
					<div class="col-xs-12 col-sm-6 col-md-3 no-space yComponentWrapper">
						<cms:component component="${feature}" />
					</div>
				</cms:pageSlot>
			</div>
		</div>
	</div>

</template:page>