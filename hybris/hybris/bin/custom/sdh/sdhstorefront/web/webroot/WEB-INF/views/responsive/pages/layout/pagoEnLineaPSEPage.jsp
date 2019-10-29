<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="pagoPSE" tagdir="/WEB-INF/tags/responsive/pagoPSE"%>

<template:page pageTitle="${pageTitle}">
	<div class="container">
		<pagoPSE:pagoEnLinea/>
	</div>	
	
	<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>
</template:page>