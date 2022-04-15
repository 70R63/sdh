<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="desfac"
	tagdir="/WEB-INF/tags/responsive/descargaFacturaVA"%>
<!-- <div class="loader"></div> -->
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

		<desfac:descargaFactura/>



<a id="downloadHelper" target="_blank"></a>
<div id="dialogMensajes" title="Descarga Factura">
	<div id="dialogMensajesContent"></div>
</div>

<template:sdhJavascriptVariables4/>
		<script type="text/javascript">
window.onload = function() {
   $(".loader").fadeOut("slow");
}
	function goBack() {
		window.history.back();
	}
	
function showDownload(){

	buscarInfo();
	}
	
function showTag(object){
	var tag = object.value;
	var label = document.getElementById('chip/placa');
	var label1 = document.getElementById('chip');
	var label2 = document.getElementById('placa');
	
	ACC.opcionDeclaraciones.establecerEstiloDisplay(label,'none');
	ACC.opcionDeclaraciones.establecerEstiloDisplay(label1,'none');
	ACC.opcionDeclaraciones.establecerEstiloDisplay(label2,'none');
	if (tag == "00") {
		ACC.opcionDeclaraciones.establecerEstiloDisplay(label,'block');
	}else if (tag == "01") {
		ACC.opcionDeclaraciones.establecerEstiloDisplay(label1,'block');
	}else if (tag == "02") {
		ACC.opcionDeclaraciones.establecerEstiloDisplay(label2,'block');
	}
	
}

function buscarInfo(){
	ACC.descargaFacturaVA.buscarInfo();
}

function descargaFactura(){
	ACC.descargaFacturaVA.descargaFactura();
}


</script>

