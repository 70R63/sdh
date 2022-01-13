<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sobreVehiculos"
	tagdir="/WEB-INF/tags/responsive/sobreVehiculos"%>
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>
	

<sobreVehiculos:sobreVehiculosDeclaraInicial />
<sobreVehiculos:sobreVehiculosDeclaraInfo />
<sobreVehiculos:sobreVehiculosDeclaraLiqui />
<%-- <sobreVehiculos:sobreVehiculosDeclaraFirma /> --%>
<c:url value='${redirectURL}' var="taxRedirection"/>
<firmas:generalFirmas firmaContribuyenteRedirection="${taxRedirection}"/>
<sobreVehiculos:sobreVehiculosDeclaraFirmas/>

<div id="dialogVehiculos" title="Vehiculos" >
	<div id="vehiculosDialogContent"></div>
</div>
<div id="dialogPublicidadExterior" title="Impuesto de Sobre Vehiculos Automotores" ><div id="publicidadExteriorDialogContent"></div></div>

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
		ACC.vehiculos.cargarDescripciones_val();
		
		var cosas = $(":input");
		var tam = cosas.length;
		if (false){
			for (var i = 0; i < tam; i++) {
				if((cosas[i].name != "firmInterFunct")&&(cosas[i].id != "firmCompleteName")&&(cosas[i].id != "lblcontribuyente_documentType")&&(cosas[i].id != "contribuyente_documentNumber")&&(cosas[i].id != "contribuyente_numBP")){
					var valor = cosas[i].value;
					if (valor == "") {
						cosas[i].value = "-";
					}
				}
			}
		}	
		 $(".loader").fadeOut("slow");
		 
		
		 
		 var date = new Date();
		 var currentday = date.getDate(); //obteniendo dia
		 var currentmes = date.getMonth()+1; //obteniendo mes
		  var currentano = date.getFullYear(); //obteniendo año
		  var currentwday = date.getDay(); //obtiene el dia de la semana
		  
		 var primerDia = new Date(date.getFullYear(), date.getMonth(), 1);
		 var yearday = primerDia.getDay();
		 var ultimoDia = new Date(date.getFullYear(), date.getMonth() + 1, 0);
		 
		 var proyecto = document.getElementById('proyecto');
		 var aportesi = document.getElementById('aporteSi');
		 var aporteno = document.getElementById('aporteNo');
		 var aniograv = document.getElementById('aniograv').value;
		 
		 if(aniograv != currentano){
			 proyecto.disabled = true;
			  aportesi.disabled = true;
			  aporteno.disabled = true;
			 
		 }else{
		 
		    if(currentmes == "6"){
		  
			  if(currentday == "27" && yearday=="0" ){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
				  
			  }	  
			  
			  if(currentday == "26" && yearday=="1"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
		
			  if(currentday == "25" && yearday=="2"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
			  
			  if(currentday == "24" && yearday=="3"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
			  if(currentday == "23" && yearday=="4"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
			  if(currentday == "22" && yearday=="5"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
			  if(currentday == "28" && yearday=="6"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
		    }
		 }
		 
		 var cat_valores_actuales = [
			 "${vehiculosFormDeclaracion.clase}", //0 - clase
			 "${vehiculosFormDeclaracion.cilindraje}", //1 - cilindraje
			 "${vehiculosFormDeclaracion.marca}", //2 - marca
			 "${vehiculosFormDeclaracion.linea}", //3 - linea
			 "${vehiculosFormDeclaracion.modelo}", //4 - modelo
			 "${vehiculosFormDeclaracion.modelo}", //5 - carroceria
			 "${vehiculosFormDeclaracion.avaluo}" //6 - avaluo
			 ];
		
		 var opcionUso = "${vehiculosFormDeclaracion.opcionUso}";
		 var homologado = "${vehiculosFormDeclaracion.homologado}";
		 if(opcionUso != null && opcionUso.length >= 2){
			 opcionUso = opcionUso.substring(0,2);
		 }
		ACC.vehiculos.obtenerCatalogosInicialVehiculos(cat_valores_actuales,homologado,opcionUso);
		
	}
	
	function actualizarCampo(campo_catalogo){
		if(campo_catalogo == "cilindraje"){
			$("#cilindraje").val("");
			var elementoCat = document.getElementById("cilindraje");
			elementoCat.disabled = "disabled";
			$("#avaluoAct").val("");
			var dataActual = ACC.vehiculos.determinarInfoParaCatalogo("cilindraje");
			ACC.vehiculos.obtenerCatalogosVehiculos(dataActual,"cilindraje",null);
		}else if(campo_catalogo == "avaluo"){
			$("#avaluoAct").val("");
			var dataActual = ACC.vehiculos.determinarInfoParaCatalogo("avaluo");
			ACC.vehiculos.obtenerCatalogosVehiculos(dataActual,"avaluo",null);
		}
	}
		
	function pagarlinea() {

		var btnpaglinea = document.getElementById('action');
		btnpaglinea.disabled = false;

	}
	
	function presdec() {
		var btnpresdec = document.getElementById('duGeneraDeclaracionButton');
		btnpresdec.disabled = false;

	}
</script>


