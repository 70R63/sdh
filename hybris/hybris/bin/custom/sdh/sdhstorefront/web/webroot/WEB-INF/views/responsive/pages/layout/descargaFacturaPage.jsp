<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="desfac"
	tagdir="/WEB-INF/tags/responsive/facturacion"%>
<!-- <div class="loader"></div> -->
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<c:choose>
	<c:when test="${ not empty facturacionForm.vehicular || not empty facturacionForm.predial}">
		<desfac:descargaFactura/>
		<desfac:descargaFacturaPagar/>
	</c:when>
	<c:otherwise>
		<desfac:sinDescargaFactura/>
	</c:otherwise>
</c:choose>

<a id="downloadHelper" target="_blank"></a>
<div id="dialogMensajes" title="Descarga Factura">
	<div id="dialogMensajesContent"></div>
</div>

<div class="obtenerBeneficio" style="display: none;">
	<div class="js-beneficio-facet" id="js-beneficio-facet">
		<div class="facet js-facet-ben">
			<div class="facet__name js-facet-name-ben">
				<spring:theme code="" />
				<div class="" id="obtenerBeneficioMensaje">
<!-- 					<p> -->
<%-- 						<b><spring:theme code="descarga.factura.descuento.mensaje1" /></b> --%>
<!-- 					</p> -->
<!-- 					<ul> -->
<%-- 						<li><spring:theme code="descarga.factura.descuento.mensaje2" /></li> --%>
<%-- 						<li><spring:theme code="descarga.factura.descuento.mensaje3" /></li> --%>
<!-- 					</ul> -->
<!-- 					<br> -->
					<p>
						<spring:theme code="descarga.factura.descuento.mensaje4" />
					</p>
					<ul>
						<li><spring:theme code="descarga.factura.descuento.mensaje5" /></li>
						<li><spring:theme code="descarga.factura.descuento.mensaje6" /></li>
						<li><spring:theme code="descarga.factura.descuento.mensaje7" /></li>
					</ul>
				</div>
				<br><br>
				<div class="row">
					<div class="col-md-4">
						<button class="btn btn-primary btn-block btn-lg " type="button"
							id="" onclick="window.location.href ='<c:url value='/contribuyentes/mirit' />';">
							<spring:theme code="Activar" />
						</button>
					</div>
					<div class="col-md-4">
						<button class="btn btn-secondary btn-block btn-lg " type="button"
							id="contObtainBen" onclick="continuarObtainBen(this)">
							<spring:theme code="Continuar" />
							<input id="objetosBene" name="objetosBene" type="hidden">
						</button>
					</div>
					<input type="hidden" value="" id="inputObjetoContinue">
				</div>
			</div>
		</div>
	</div>
</div>
<template:sdhJavascriptVariables4/>
		<script type="text/javascript">
window.onload = function() {
	ACC.vehiculos.cargarDescripciones();
	
// 	ACC.facturacion.establecerCat_aniograv();
   $(".loader").fadeOut("slow");
}
	function goBack() {
		window.history.back();
	}

	function obtainBene(objeto) {

		var numObjeto = $.trim($(objeto).attr("data-numobjeto"));
		
		ACC.facturacion.obtainBeneficio(objeto,numObjeto);
	}
	
	function btnObtainBene(){
		var items = document.getElementsByClassName("checkbox");
		
		ACC.facturacion.btnBeneficio(items);
	}
	
	function continuarObtainBen(objeto){
		ACC.facturacion.solBeneficio(objeto);
	}

	
</script>

