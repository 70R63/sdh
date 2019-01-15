<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<template:page pageTitle="${pageTitle}">

 	<cms:pageSlot position="YFormSlot" var="feature">
        <cms:component component="${feature}"  />
    </cms:pageSlot>


<!-- <div class="container"> -->
<!-- 	<div class="row "> -->
<!-- 		<div class="col-xs-12 col-sm-12 col-md-4 plp-card-cell"> -->
<!-- 			<div class="card-section "> -->
<!-- 					<div class="card card-plp col-md-4 plp-custom-padding"> -->
<%-- 						<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="taxpayers.myinfo" /></span></h2></div> --%>
<!-- 						<div class="card-section-content">	 -->
<!-- 							<ul class="list-unstyled"> -->
<%-- 								<c:url value='/contribuyentes/mirit' var="miRitURL"/> --%>
<%-- 							  <li><span class="glyphicon glyphicon-new-window" aria-hidden="true" ></span>&nbsp;<a href="${miRitURL }"><spring:theme code="taxpayers.myRIT" /></a></li> --%>
<%-- 							  <li><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp;<a><spring:theme code="taxpayers.myQueries" /></a></li> --%>
<%-- 							  <li><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>&nbsp;<a><spring:theme code="taxpayers.myInbox" /></a></li> --%>
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		<div class="col-xs-12 col-sm-12 col-md-4 plp-card-cell"> -->
<!-- 			<div class="card-section "> -->
<!-- 				<div class="card card-plp col-md-4 plp-custom-padding"> -->
<%-- 					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="taxpayers.taxes" /></span></h2></div> --%>
<!-- 					<div class="card-section-content">	 -->
<!-- 							<ul class="list-unstyled"> -->
<%-- 							  <c:url value='/contribuyentes2/predialunificado' var="predialUnificadoURL"/> --%>
<%-- 							  <li><span class="glyphicon glyphicon-cog" aria-hidden="true" ></span>&nbsp;<a href="${predialUnificadoURL }"><spring:theme code="taxpayers.taxes.predialUnificado" /></a></li> --%>
<%-- 							  <c:url value='/contribuyentes2/sobrevehiculosautomotores' var="sobreVehiculosAutomotoresURL"/> --%>
<%-- 							  <li><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;<a href="${sobreVehiculosAutomotoresURL }"><spring:theme code="taxpayers.taxes.sobreVehiculos" /></a></li> --%>
<%-- 							  <c:url value='/contribuyentes2/icareteica' var="icaReteIcaURL"/> --%>
<%-- 							  <li><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;<a href="${icaReteIcaURL }"><spring:theme code="taxpayers.taxes.ica" /></a></li> --%>
<%-- 							  <c:url value='/contribuyentes/delineacion-urbana' var="delineacionUrbanaURL"/> --%>
<%-- 							  <li><span class="glyphicon glyphicon-cog" aria-hidden="true" ></span>&nbsp;<a href="${delineacionUrbanaURL }"><spring:theme code="taxpayers.taxes.delineacionUrbana" /></a></li> --%>
<%-- 							  <c:url value='/contribuyentes/sobretasa-gasolina' var="sobretasaGasolinaURL"/> --%>
<%-- 							  <li><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;<a href="${sobretasaGasolinaURL }"><spring:theme code="taxpayers.taxes.sobretasaGasolina" /></a></li> --%>
<%-- 							  <li><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;<a><spring:theme code="taxpayers.taxes.publicidadExterior" /></a></li> --%>
<!-- 							</ul> -->
<!-- 						</div>					 -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="col-xs-12 col-sm-12 col-md-4 plp-card-cell"> -->
<!-- 			<div class="card-section "> -->
<!-- 				<div class="card card-plp col-md-4 plp-custom-padding"> -->
<%-- 					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="taxpayers.formalities" /></span></h2></div> --%>
<!-- 					<div class="card-section-content">	 -->
<!-- 							<ul class="list-unstyled"> -->
<%-- 							  <li><span class="glyphicon glyphicon-edit" aria-hidden="true" ></span>&nbsp;<a class=""><spring:theme code="taxpayers.formalities.newsRIT" /></a></li> --%>
<%-- 							  <li><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>&nbsp;<a><spring:theme code="taxpayers.formalities.verificacionPagos" /></a></li> --%>
<%-- 							  <li><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>&nbsp;<a><spring:theme code="taxpayers.formalities.retiroBoletinMorosos" /></a></li> --%>
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->


</template:page>
