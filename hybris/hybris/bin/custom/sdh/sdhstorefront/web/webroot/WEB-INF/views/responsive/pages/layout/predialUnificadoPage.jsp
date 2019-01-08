<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="predialUnificado" tagdir="/WEB-INF/tags/responsive/predialUnificado"%>

<template:page pageTitle="${pageTitle}">
	<div class="container">
		
		<predialUnificado:predialUnificadoTable/>
		
		<c:if test="${not empty showDetail }">
		
			<predialUnificado:predialUnificadoDetail/>
		
		</c:if>	
	</div>
</template:page>