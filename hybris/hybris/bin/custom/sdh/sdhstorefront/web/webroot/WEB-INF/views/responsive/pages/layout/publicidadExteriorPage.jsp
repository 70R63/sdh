<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="publicidadExterior"
	tagdir="/WEB-INF/tags/responsive/publicidadExterior"%>

<style>
#divAvisos { }
#divConvencional { }
#divVehiculos { }
#divTubular { }
</style>

<template:page>

<%-- <sf:form action="${pageContext.request.contextPath}/contribuyentes/publicidadexterior/declaracion" method="POST" modelAttribute="publicidadForm" id="forma"> --%>
<sf:form action="" method="POST" modelAttribute="publicidadForm" id="forma">
	<div class="container">
	
		<publicidadExterior:publicidadExteriorTable />
		<publicidadExterior:publicidadExteriorDetail />
<%-- 		<publicidadExterior:publicidadExteriorAvisos /> --%>
		<publicidadExterior:publicidadExteriorTubularComercial />
		<publicidadExterior:publicidadExteriorVehiculos />
		<publicidadExterior:publicidadExteriorTubularObra />
		<publicidadExterior:publicidadExteriorObraConvencional />
		<publicidadExterior:publicidadExteriorPantallaLed />
	</div>
	</sf:form>
	
</template:page>