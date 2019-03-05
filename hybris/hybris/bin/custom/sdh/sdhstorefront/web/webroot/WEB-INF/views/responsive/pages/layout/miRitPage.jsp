<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="miRit" tagdir="/WEB-INF/tags/responsive/miRit"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<template:page pageTitle="${pageTitle}">
	<div class="container">
		<p><spring:theme code="mirit.description" /></p>
			<c:choose>
				<c:when test="${ PJUR eq true}">
					<miRit:personalDataPJ/>
				</c:when>
				<c:otherwise>
					<miRit:personalData/>
		
					<miRit:generalData/>
				</c:otherwise>
			</c:choose>		
		
		
		<miRit:contactData/>
		
		<miRit:changeEmail/>
		
		<miRit:changePasword/>
		
		<miRit:consentsData/>
		
		<miRit:myTaxes/>
		
		<miRit:myRepresentantsData/>
		
		<miRit:myTributaryRols/>
		
		<miRit:miRitButtons/>
		
	</div>


</template:page>



