<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template"
	tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">

	<div class="row no-margin global-content-space">
		<!-- Site Body Content -->
		<div class="col-md-5">
			<section class="content-wrapper">
				<div class="item active">
					<cms:pageSlot position="BodyContent" var="feature">
						<cms:component component="${feature}" />
					</cms:pageSlot>
				</div>
			</section>
		</div>
		<div class="col-md-2"></div>
		<div class="col-md-4">
			<!-- CMS Blocks -->
			<article class="module">
				<cms:pageSlot position="RightSideContent" var="feature">
					<cms:component component="${feature}" />
				</cms:pageSlot>
			</article>
		</div>
	</div>
</template:page>