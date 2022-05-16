<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="desfacVA"
	tagdir="/WEB-INF/tags/responsive/descargaFacturaVA"%>
<%@ taglib prefix="desfac"
	tagdir="/WEB-INF/tags/responsive/facturacion"%>
<!-- <div class="loader"></div> -->
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

		<desfacVA:descargaFactura/>
		<desfac:descargaFacturaPagar/>



<a id="downloadHelper" target="_blank"></a>
<div id="dialogMensajes" title="Descarga Factura">
	<div id="dialogMensajesContent"></div>
</div>

<template:sdhJavascriptVariables4/>
		<script type="text/javascript">
window.onload = function() {
   $(".loader").fadeOut("slow");
   
   showTag($("#claveImpuesto")[0]);
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
	var mensajeImpuesto1 = document.getElementById('mensajeImpuesto1');
	var mensajeImpuesto2 = document.getElementById('mensajeImpuesto2');
	var dow = document.getElementById('table-download');
	
	
	ACC.opcionDeclaraciones.establecerEstiloDisplay(label,'none');
	ACC.opcionDeclaraciones.establecerEstiloDisplay(label1,'none');
	ACC.opcionDeclaraciones.establecerEstiloDisplay(label2,'none');
	ACC.opcionDeclaraciones.establecerEstiloDisplay(mensajeImpuesto1,'none');
	ACC.opcionDeclaraciones.establecerEstiloDisplay(mensajeImpuesto2,'none');
	ACC.opcionDeclaraciones.establecerEstiloDisplay(dow,'none');
	if (tag == "00") {
		ACC.opcionDeclaraciones.establecerEstiloDisplay(label,'block');
	}else if (tag == "0001") {
		ACC.opcionDeclaraciones.establecerEstiloDisplay(label1,'block');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(mensajeImpuesto1,'block');
	}else if (tag == "0002") {
		ACC.opcionDeclaraciones.establecerEstiloDisplay(label2,'block');
		ACC.opcionDeclaraciones.establecerEstiloDisplay(mensajeImpuesto2,'block');
	}
	
}

function buscarInfo(){
	ACC.descargaFacturaVA.buscarInfo();
}

function descargaCertificadoPago(){
	debugger;
	ACC.descargaFacturaVA.descargaCertificadoPago();
}

function descargaFactura(){
	ACC.descargaFacturaVA.descargaFactura();
}

function pagarEnLinea(tipoImpuesto,anoGravable,periodo,numObjeto,chip,fechaVenc,numRef,totalPagar,cdu,placa,facilidad,montoFacilidad,pagoVoluntario){
	debugger;
	var numBP = $("#pagarFacturaVABtn").attr("data-numbp");
	var numDoc = $("#numDoc").val();
	var tipoDoc =  $("#tipoDoc").val();
	if (periodo === null || periodo === '' || typeof periodo === 'undefined' ){
		var clavePeriodo = anoGravable.substr(2,2).concat("A1");
	}	  
	else{
		var clavePeriodo = anoGravable.substr(2,2).concat(periodo);
	} 
	var dv = "${customerData.digVer}";
	
	
	$("#pagarEnLinea_tipoImpuesto").val(tipoImpuesto);
	$("#pagarEnLinea_numBP").val(numBP);
	$("#pagarEnLinea_numDoc").val(numDoc);
	$("#pagarEnLinea_tipoDoc").val(tipoDoc);		
	$("#pagarEnLinea_anoGravable").val(anoGravable);
	$("#pagarEnLinea_periodo").val(periodo);
	$("#pagarEnLinea_clavePeriodo").val(clavePeriodo);
	$("#pagarEnLinea_dv").val(dv);
	$("#pagarEnLinea_numObjeto").val(numObjeto);
	$("#pagarEnLinea_chip").val(chip);
	$("#pagarEnLinea_cdu").val(cdu);
	$("#pagarEnLinea_placa").val(placa);
	
	
	if(fechaVenc === '' || fechaVenc.search("/") >= 0 || periodo.search("/") >= 0){
		$("#pagarEnLinea_fechaVenc").val(fechaVenc);
	}else{
		var fechaVencimineto = fechaVenc.substring(6,8).concat("/",fechaVenc.substring(4,6),"/",fechaVenc.substring(0,4));
		$("#pagarEnLinea_fechaVenc").val(fechaVencimineto);
	}
	
	$("#pagarEnLinea_numRef").val(numRef);
    $("#pagarEnLinea_totalPagar").val(totalPagar);
    $("#pagarEnLinea_pagoVoluntario").val(pagoVoluntario);
    
	var form = document.getElementById("infoPreviaPSE");
	if(form!=null){
		form.submit();
	}
	
}


</script>

