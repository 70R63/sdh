<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sobreVehiculos"
	tagdir="/WEB-INF/tags/responsive/sobreVehiculos"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<input type="hidden" id="opcionUso" class="opcionUso" value=""/>
<sobreVehiculos:sobreVehiculosTable />
<div id="detalleVehiculos" style="display: none">
<sobreVehiculos:sobreVehiculosDetail />
<sobreVehiculos:sobreVehiculosJuridicos />
<sobreVehiculos:sobreVehiculosMarcas />
<sobreVehiculos:sobreVehiculosLiquida />
</div>
<a id="downloadHelper" target="_blank"></a>
<div id="dialogMensajes" title="Descarga Factura">
	<div id="dialogMensajesContent"></div>
</div>

<template:sdhJavascriptVariables_linea_vehi/>
<template:sdhJavascriptVariables_linea_vehi2/>
<template:sdhJavascriptVariables_linea_vehi3/>
<template:sdhJavascriptVariables_linea_vehi4/>
<template:sdhJavascriptVariables_linea_vehi5/>
<template:sdhJavascriptVariables_linea_vehi6/>
<template:sdhJavascriptVariables_linea_vehi7/>
<template:sdhJavascriptVariables4/>

<script>
	function goBack() {
		window.history.back();
	}

	window.onload = function() {
		
		ACC.vehiculos.cargarDescripciones();
		
		var cosas = $(":input");
		var tam = cosas.length;
		if (false){
			for (var i = 0; i < tam; i++) {
				var valor = cosas[i].value;
				if (valor == "") {
					cosas[i].value = "-";
				}
			}
		}	
		 $(".loader").fadeOut("slow");
	}
</script>


