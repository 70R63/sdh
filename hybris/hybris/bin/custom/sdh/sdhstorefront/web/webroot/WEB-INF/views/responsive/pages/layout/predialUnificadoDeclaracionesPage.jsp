<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="predialUnificado" tagdir="/WEB-INF/tags/responsive/predialUnificado"%>

<template:page pageTitle="${pageTitle}">
	<div class="container">
		<div class="row">
			<div class="headline">
				<h3>
					<span tabindex="0"><spring:theme code="predial.unificado.declaraciones" /></span>
				</h3>
			</div>			
		</div>

		<c:choose>
			<c:when test="${ action eq 'initialDeclaration' }">
				<predialUnificado:predialUnificadoInitailDeclaration/>
			</c:when>
			<c:when test="${ action eq 'retention' }">
				<predialUnificado:predialUnificadoRetention/>
			</c:when>
			<c:when test="${ action eq 'correctionDeclaration' }">
				<predialUnificado:predialUnificadoCorrection/>
			</c:when>
			<c:otherwise>
				<predialUnificado:predialUnificadoDeclaracionesForm/>
			</c:otherwise>
		</c:choose>
	</div>	
</template:page>

<script>
  $( function() {
    $( "#tabs" ).tabs();
  } );
  </script>


