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
		$('.loader').hide();
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
		 
		 $('.loader').hide();
		 
		var date = new Date();
		var currentday = date.getDate(); //obteniendo dia
		var currentmes = date.getMonth()+1; //obteniendo mes
		var currentano = date.getFullYear(); //obteniendo anio
		var currentwday = date.getDay(); //obtiene el dia de la semana
		 
		var primerDia = new Date(date.getFullYear(), date.getMonth(), 1);
		var yearday = primerDia.getDay();
		var ultimoDia = new Date(date.getFullYear(), date.getMonth() + 1, 0);
		 
		var proyecto = document.getElementById('proyecto');
		var aportesi = document.getElementById('aporteSi');
		var aporteno = document.getElementById('aporteNo');
		var aniograv = document.getElementById('aniograv').value;
		var desabilitarProyectoAportes = false;
		var currentano_str = (currentano).toString();
		 
		 if(aniograv != currentano_str){
			 desabilitarProyectoAportes = true;
		 }else{
		    if(currentmes == 6){
			  if(currentday == 27 && yearday==0 ){
				 desabilitarProyectoAportes = true;
			  }	  
			  if(currentday == 26 && yearday==1){
				 desabilitarProyectoAportes = true;
			  }
			  if(currentday == 25 && yearday==2){
				 desabilitarProyectoAportes = true;
			  }
			  if(currentday == 24 && yearday==3){
				 desabilitarProyectoAportes = true;
			  }
			  if(currentday == 23 && yearday==4){
				 desabilitarProyectoAportes = true;
			  }
			  if(currentday == 22 && yearday==5){
				 desabilitarProyectoAportes = true;
			  }
			  if(currentday == 28 && yearday==6){
				 desabilitarProyectoAportes = true;
			  }
		    }
		 }
		 
		 if(desabilitarProyectoAportes){
			$("#proyecto").prop("disabled", true );
			$("#aportesi").prop("disabled", true );
			$("#aporteNo").prop("disabled", true );
		 }
		 
		 debugger;
		 var cat_valores_actuales = [
			 "${vehiculosFormDeclaracion.clase}", //0 - clase
			 "${vehiculosFormDeclaracion.cilindraje}", //1 - cilindraje
			 "${vehiculosFormDeclaracion.marca}", //2 - marca
			 "${vehiculosFormDeclaracion.linea}", //3 - linea
			 "${vehiculosFormDeclaracion.modelo}", //4 - modelo
			 "${vehiculosFormDeclaracion.modelo}", //5 - carroceria
			 "${vehiculosFormDeclaracion.avaluo}" //6 - avaluo
			 ];
		
		var datosAdicionales = obtenerOpcionesAdicionales();
		ACC.vehiculos.obtenerCatalogosInicialVehiculos(cat_valores_actuales,datosAdicionales);
		checkPagoRop();
		
	}
	
	function actualizarCampo(objetoActualizado){
		var dataActual = null;
		var catActualizado = $(objetoActualizado).attr('id');
		var campo_catalogo = "";
		
		switch(catActualizado){
			case "linea":
				$("#cilindraje").val("");
				$("#avaluoAct").val("");
				$("#cilindraje").prop("disabled",true);
				dataActual = ACC.vehiculos.determinarInfoParaCatalogo("cilindraje");
				campo_catalogo = "cilindraje";
				break;
			case "cilindraje":
				$("#avaluoAct").val("");
				dataActual = ACC.vehiculos.determinarInfoParaCatalogo("avaluo");
				campo_catalogo = "avaluo";
				break;
			default:
				break;
		}
				
		if(dataActual != null){
			var datosAdicionales = obtenerOpcionesAdicionales();
			ACC.vehiculos.obtenerCatalogosVehiculos(dataActual,campo_catalogo,null,datosAdicionales);	
		}
		
	}
	
	function obtenerOpcionesAdicionales(){
		var data = {};
		
		var opcionUso = "${vehiculosFormDeclaracion.opcionUso}";
		data.homologado = "${vehiculosFormDeclaracion.homologado}";
		data.idServicio = $("#idServiciocal").val();
		
		if(opcionUso != null && opcionUso.length >= 2){
			data.opcionUso = opcionUso.substring(0,2);
		}
		data.bloquearCampos = false;
		if($("#disabledLiquidacion_flag").val() == "X" 
				|| ($("#idServiciocal").val() == "03")
				|| (data.homologado == "X" && data.opcionUso == "01" )
		){
			data.bloquearCampos = true;
		}
		data.ejecucionInicial = "X";
		
		return data;
	}
		
	function pagarlinea() {

		var btnpaglinea = document.getElementById('action');
		btnpaglinea.disabled = false;

	}
	
	function presdec() {
		var btnpresdec = document.getElementById('duGeneraDeclaracionButton');
		btnpresdec.disabled = false;

	}
	
	function checkPagoRop(){
		debugger;
		var chekPagoRop = "${vehiculosFormDeclaracion.checkPagoRop}";
		if (chekPagoRop == 'X'){
			$( "#calcularVehButton" ).prop( "disabled", true );
			$( ".justFirm" ).prop( "disabled", true );
			$( ".firmAndAdd" ).prop( "disabled", true );
			
		}
	}
</script>


