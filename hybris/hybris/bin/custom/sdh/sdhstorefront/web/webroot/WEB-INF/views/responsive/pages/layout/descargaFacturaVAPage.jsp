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
	var dow = document.getElementById('table-download');
	dow.style.display = 'block';
	}
	
function showTag(object){
	debugger;
	var tag = object.value;
	var label = document.getElementById('chip/placa');
	var label1 = document.getElementById('chip');
	var label2 = document.getElementById('placa');
	if (tag == "00") {
		label.style.display = 'block';
		label1.style.display = 'none';
		label2.style.display = 'none';
	}else if (tag == "01") {
		label.style.display = 'none';
		label1.style.display = 'block';
		label2.style.display = 'none';
	}else if (tag == "02") {
		label.style.display = 'none';
		label1.style.display = 'none';
		label2.style.display = 'block';
	}
	
	}

</script>

