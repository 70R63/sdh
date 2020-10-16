<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="delineacionUrbana"
	tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>
<input type="hidden" id="hiddenCdu" name="hiddenCdu" value="">
<delineacionUrbana:delineacionUrbanaIDs />
<delineacionUrbana:delineacionUrbanaCDUs />
<delineacionUrbana:delineacionUrbanaRadicados />
<delineacionUrbana:delineacionUrbanaNota/>



<script>
	window.onload = function() {
		debugger;
		var cosas = $(":input");
		var tam = cosas.length;
		if (false) {
			for (var i = 0; i < tam; i++) {
				var valor = cosas[i].value;
				if (valor == "") {
					cosas[i].value = "-";

				}
			}
		}
		$(".loader").fadeOut("slow");
		
		

	}
	function goBack() {
		var declaracion = '${param.declaracion}';

		if (declaracion) {
			window.location.href = "<c:url value='/contribuyentes/presentar-declaracion' />";
		} else {
			window.history.back();
		}
	}

	function nuevos(selectObject) {

		var value = selectObject.value;
		var cauex = document.getElementById('cauexen').value;
		var auex = document.getElementById('valorExen');

		if (value == '09' && (cauex == '00' || cauex == '')) {
			auex.readonly = true;
		} else if (value == '09' && (cauex != '00' || cauex != '')) {
			auex.readonly = true;
		} else if (value != '09'
				&& (cauex == '00' || cauex == '' || cauex == "")) {
			auex.readonly = true;
		} else {
			auex.readonly = false;
		}

	}
	window.onload = function data() {
		$(".loader").fadeOut("slow");
	}

	function tipoLicenciaCHANGE(selectObject) {

		var valorExen = document.getElementById('valorExen');
		var tipoMarca = document.getElementById('tipoMarca');
		var tipoDeLicencia = selectObject.value;

		if ((tipoDeLicencia == "02") && (tipoMarca.value != "")) {
			valorExen.disabled = false;
			valorExen.readonly = false;

		} else {
			valorExen.disabled = true;
			valorExen.readonly = true;
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

	function numberFormat(selectObject) {
		var numero = selectObject.value;
		var idinput = selectObject.id;
		var resultado = "";

		if (numero[0] == "-") {
			nuevoNumero = numero.replace(/\./g, '').substring(1);
		} else {

			nuevoNumero = numero.toString().replace(/\./g, '');
		}

		if (numero.toString().indexOf(",") >= 0)
			nuevoNumero = nuevoNumero.substring(0, nuevoNumero.indexOf(","));

		for (var j, i = nuevoNumero.length - 1, j = 0; i >= 0; i--, j++) {
			resultado = nuevoNumero.charAt(i)
					+ ((j > 0) && (j % 3 == 0) ? "." : "") + resultado;

			if (numero.toString().indexOf(",") >= 0)
				resultado += numero.substring(numero.indexOf(","));

			if (numero[0] == "-") {

				document.getElementById(idinput).value = "-" + resultado;
				return "-" + resultado;
			} else {
				document.getElementById(idinput).value = resultado;
				return resultado;

			}

		}
	}
</script>



