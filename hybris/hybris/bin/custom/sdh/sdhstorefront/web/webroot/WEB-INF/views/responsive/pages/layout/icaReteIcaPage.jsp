<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="icaReteIca" tagdir="/WEB-INF/tags/responsive/icaReteIca"%>

<template:page pageTitle="${pageTitle}">
	<div class="container">
		
		<icaReteIca:icaReteIcaTable/>
		
		<c:if test="${not empty showDetail }">
		
			<icaReteIca:icaReteIcaDetail/>
		
		</c:if>	
	</div>
</template:page>