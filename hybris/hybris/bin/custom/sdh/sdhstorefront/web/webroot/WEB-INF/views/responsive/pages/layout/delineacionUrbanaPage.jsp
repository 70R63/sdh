<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="delineacionUrbana"
	tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>
<%@ taglib prefix="sobreTasaGasolina"
	tagdir="/WEB-INF/tags/responsive/sobretasaGasolina"%>

<<<<<<< Updated upstream

<div class="container">


	<delineacionUrbana:delineacionUrbanaTable />
	<delineacionUrbana:delineacionUrbanaDetail />
	<delineacionUrbana:delineacionUrbanaBasicos />
	<delineacionUrbana:delineacionUrbanaAdicionales />
	<delineacionUrbana:delineacionUrbanaDecGenerales />
	<delineacionUrbana:delineacionUrbanaDecAreasUsos />
	<delineacionUrbana:delineacionUrbanaDecLiqPriva />
	<delineacionUrbana:delineacionUrbanaDecFirma />


</div>
=======
<template:page>
	<div class="container">
		<delineacionUrbana:delineacionUrbanaTable/>
		<delineacionUrbana:delineacionUrbanaDetail/>
		<delineacionUrbana:delineacionUrbanaBasicos/>
		<delineacionUrbana:delineacionUrbanaAdicionales/>
	</div>	
</template:page>
>>>>>>> Stashed changes
