<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">
<div class="row no-margin global-content-space">
	<div class="col-sm-8 col-md-8">
		<!-- Site Body Content -->
		<div class="item active">
			<cms:pageSlot position="BodyContent" var="feature">
				<cms:component component="${feature}" />
			</cms:pageSlot>
		</div>
	</div>
	<div class="col-sm-4 col-md-4">
		<div data-spy="affix" data-offset-top="160" data-offset-bottom="280">
			<cms:pageSlot position="RightSideContent" var="feature">
				<cms:component component="${feature}" />
			</cms:pageSlot>
		</div>
	</div>
	</div>
</template:page>