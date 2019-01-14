<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="publicidadExterior" tagdir="/WEB-INF/tags/responsive/publicidadExterior"%>

<template:page pageTitle="${pageTitle}">

	<div class="container">
		
		<publicidadExterior:publicidadExteriorTable/>
		<c:if test="${not empty action }"> 
		
			<publicidadExterior:publicidadExteriorDetail/> 
		
		</c:if>	

	</div>
</template:page>