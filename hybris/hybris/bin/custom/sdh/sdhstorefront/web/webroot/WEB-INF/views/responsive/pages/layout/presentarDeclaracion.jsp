<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="impuestos"
	tagdir="/WEB-INF/tags/responsive/impuestos"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="loader"></div>

<template:sdhJavascriptVariables2/>
<template:sdhJavascriptVariables3/>
<template:sdhJavascriptVariables4/>
<impuestos:listaImpuestos />
<div id="dialogMensajes" title="Predial">
	<div id="dialogMensajesContent"></div>
</div>

<script type="text/javascript">
	window.onload = function() {

		$(".loader").fadeOut("slow");
		var tipoImpuesto = document.getElementById("impuesto").value;
		var anio = document.getElementById("anoGravable").value;
		var nota2 = document.getElementById("notaVehPre");
		var notaotros = document.getElementById("notaOtros");
		if (tipoImpuesto == '6') {
			var nota = document.getElementById("notas_deli");
			nota.style.display = 'block'
		}
		debugger;
		if (anio != "") {
			if (tipoImpuesto == '2' || tipoImpuesto == '1') { //vehicular predial
				nota2.style.display = 'block';
				notaotros.style.display = 'none';
			} else {
				nota2.style.display = 'none';
				notaotros.style.display = 'block';
			}
		}
		ACC.opcionDeclaraciones.preparaAnioGravable_presentarDec(tipoImpuesto);
		document.getElementById("anoGravable").value = anio;
	}

	function onChange() {
		var tipoImpuesto = document.getElementById("impuesto").value;
		debugger;
		if (tipoImpuesto == '2' || tipoImpuesto == '1') { //vehicular y predial
			ACC.opcionDeclaraciones.prepararImpuesto_presentarDec(tipoImpuesto);
		} else { //otros impuestos
			document.getElementById("anoGravable").value = "";
			form = document.getElementById("forma");

			input = document.createElement('input');
			input.setAttribute('name', 'skipReques');
			input.setAttribute('value', 'X');
			input.setAttribute('type', 'hidden');
			var skipRequesElemento = document.getElementById("skipReques");
			if (skipRequesElemento == null) {
				form.appendChild(input);
			} else {
				skipRequesElemento.value = "X";
			}

			form.submit();

		}
	}

	function onChangeAnioGravable() {
		debugger;

		var impuestoVal = document.getElementById("impuesto").value;
		var nota = document.getElementById("notaVehPre");
		var notaotros = document.getElementById("notaOtros");

		if (impuestoVal == '2' || impuestoVal == '1') { //vehicular predial
			nota.style.display = 'block';
			notaotros.style.display = 'none';
		} else {
			nota.style.display = 'none';
			notaotros.style.display = 'block';
		}
		if (impuestoVal == '2' || impuestoVal == '1') { //vehicular
			ACC.opcionDeclaraciones
					.obtenerListaDeclaraciones_presentarDec(impuestoVal);
		} else { //otros impuestos
			if (impuestoVal == "4" || impuestoVal == "6" || impuestoVal == "3") {
				form = document.getElementById("forma");
				input = document.createElement('input');
				input.setAttribute('name', 'skipReques');
				input.setAttribute('value', '');
				input.setAttribute('type', 'hidden');
				var skipRequesElemento = document.getElementById("skipReques");
				if (skipRequesElemento == null) {
					form.appendChild(input);
				} else {
					skipRequesElemento.value = "";
				}
				form.submit();
			}

			ajustaPeriodo();
		}

//SE comenta funcionalidad por petición de usuario.
//Maria Torres 11/05/2020
// 	if (impuestoVal == "3") {
// 			//Ingresamos un mensaje a mostrar
// 			var mensaje = confirm("Si tienes más de 20 registros a declarar necesitas pasar a ayuda ICA ");
// 			//Detectamos si el usuario acepto el mensaje
// 			var currentUrl = window.location.href;
// 			var targetUrl = "/contribuyentes/registroretenciones";
// 			if (mensaje) {

// 				if (currentUrl.indexOf('#') != "-1") {

// 				} else {

// 					currentUrl_tmp = currentUrl.replace(
// 							"/contribuyentes/presentar-declaracion", targetUrl);
// 				}

// 				window.location.href = currentUrl_tmp;

// 			}
// 			//Detectamos si el usuario denegó el mensaje
// 			else {

// 			}
// 		}
	}

	function ajustaPeriodo() {
		debugger;
		var dt = new Date();
		var year = dt.getFullYear();

		var sizePeriodo = document.getElementById("periodo").options.length;

		if (sizePeriodo == 12
				&& document.getElementById("anoGravable").value == year) {
			var mon = dt.getMonth();
			for (monPop = mon; monPop <= 11; monPop++) {
				document.getElementById("periodo").options[monPop].disabled = true;
			}
		} else if (sizePeriodo == 7
				&& document.getElementById("anoGravable").value == year) {
			var mon = parseInt((dt.getMonth()) / 2) + 2;
			mon = mon - 1;
			for (monPop = mon; monPop < 7; monPop++) {
				document.getElementById("periodo").options[monPop].disabled = true;
			}
		} else {
			for (monPop = 0; monPop < document.getElementById("periodo").length; monPop++) {
				document.getElementById("periodo").options[monPop].disabled = false;
			}
		}

	}

	function obtenerURLBase() {
		debugger;
		return '<c:url value="/" />';
	}
</script>