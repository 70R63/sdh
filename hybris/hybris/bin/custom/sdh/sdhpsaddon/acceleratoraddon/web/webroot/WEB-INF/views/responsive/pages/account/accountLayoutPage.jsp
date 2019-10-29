<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">
		<cms:pageSlot position="SideContent" var="feature" class="accountPageSideContent">
			<cms:component component="${feature}" />
		</cms:pageSlot>
        <cms:pageSlot position="TopContent" var="feature" element="div" class="accountPageTopContent">
            <cms:component component="${feature}" />
        </cms:pageSlot>
        <div class="account-section">
            <cms:pageSlot position="BodyContent" var="feature" element="div" class="account-section-content">
                <cms:component component="${feature}" />
            </cms:pageSlot>
        </div>
        <cms:pageSlot position="BottomContent" var="feature" element="div" class="accountPageBottomContent">
            <cms:component component="${feature}" />
        </cms:pageSlot>
<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>
</template:page>