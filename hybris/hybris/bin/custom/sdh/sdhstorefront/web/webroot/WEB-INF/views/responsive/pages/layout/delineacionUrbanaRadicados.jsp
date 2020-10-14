<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="delineacionUrbana"
	tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>
<spring:url value="/contribuyentes/delineacionurbana/retencion"
	var="duRetencionURL" htmlEscape="false" />

<sf:form action="${duRetencionURL}" method="POST"
	modelAttribute="dataForm" id="forma"
	onsubmit="return validarAntesCalculo();">
	<delineacionUrbana:delineacionUrbanaRetenGenerales />
	<delineacionUrbana:delineacionUrbanaRetenAreasUsos />
	<delineacionUrbana:delineacionUrbanaRetenLiqPriva />
	<c:url value='/contribuyentes/delineacion-urbana' var="duRedirection"/>
	<firmas:generalFirmas firmaContribuyenteRedirection="${duRedirection}"/>
</sf:form>
<delineacionUrbana:delineacionUrbanaRetenFirma />




<script>

window.onload = function() {
	debugger;
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
// 	function goBack() {
// 		debugger;
// 		var declaracion = '${param.declaracion}';

// 		if (declaracion) {
// 			window.location.href = "/sdhstorefront/es/contribuyentes/presentar-declaracion";
// 		} else {
// 			window.history.back();
// 		}
// 	}

	

	function costoshabil(selectObject) {

		var value = selectObject.value;
		var cosdir = document.getElementById('codstdirec');
		var cosind = document.getElementById('costindirec');
		var metcons = document.getElementById('metconstr');
		var metvent = document.getElementById('metventa');
		var valcons = document.getElementById('valconstr');
		var valapr = document.getElementById('valaprox');

		if (value == '1') {
			cosdir.disabled = true;
			cosind.disabled = true;
			metcons.disabled = true;
			metvent.disabled = true;
			valcons.disabled = true;
			valapr.disabled = true;

		} else {
			cosdir.disabled = false;
			cosind.disabled = false;
			metcons.disabled = false;
			metvent.disabled = false;
			valcons.disabled = false;
			valapr.disabled = false;
		}
	}

	function presupuestoObraCHANGE(selectObject) {

		
		//Validacion presupuesto de obra = 02
		var totalRetencion = document.getElementById('totalRetencion');
		var causalexcencion = document.getElementById('causalexcencion');
		
		var totalRetencionOBLIGATORIO = document
				.getElementById('totalRetencionOBLIGATORIO');
		var presupuestoObra = selectObject.value;
		var valCausalExcencion = causalexcencion.value;

        if (presupuestoObra == "02" &&  valCausalExcencion != "00" ) {

			totalRetencion.disabled = false;
			totalRetencionOBLIGATORIO.value = 'X';
		} else {
			totalRetencion.disabled = true;
		}
		
		
		var incor = selectObject.value;
		var tot= document.getElementById('totalRetencion');
		var pres= document.getElementById('totalpresu');
		
		if(incor=='02'){
			tot.readOnly=false;
			pres.readOnly=false;
		}else{
			tot.readOnly=true;
			pres.readOnly=true;
		}

	}

	function validarAntesCalculo() {
		var totalRetencion = document.getElementById('totalRetencion').value;
		
		var presupuestoObra = document.getElementById('presupuestoObra');
		var valPresupuestoObra = presupuestoObra.value;
		
		var causalexcencion = document.getElementById('causalexcencion');
		var valCausalExcencion = causalexcencion.value;
		
		var totalpresu = document.getElementById('totalpresu');
		var valTotalpresu = totalpresu.value;
		valTotalpresu = valTotalpresu.trimLeft();
		valTotalpresu = valTotalpresu.trimRight();
		var valTotalpresuFLOAT = parseFloat(valTotalpresu);
		
		
		
		totalRetencion = totalRetencion.trimLeft();
		totalRetencion = totalRetencion.trimRight();
		var totalRetencionOBLIGATORIO = document
				.getElementById('totalRetencionOBLIGATORIO').value;
		var totalRetencionFLOAT = parseFloat(totalRetencion);
		
		
		if (valPresupuestoObra == "02" &&  valCausalExcencion != "00"  && !isNaN(valTotalpresuFLOAT) && valTotalpresuFLOAT <= 0 && !isNaN(totalRetencionFLOAT) && totalRetencionFLOAT <= 0) {
		
			alert("Debido al valor en el campo \"Presupuesto de obra\" el campo \"Valor de retención\" será obligatorio (su valor deberá ser mayor o igual a cero)");
			return false;			
		}	
		
		if (valPresupuestoObra == "02" &&  valCausalExcencion == "00" && !isNaN(valTotalpresuFLOAT) && valTotalpresuFLOAT <= 0 ) {
			alert("El valor el campo \"Presupuesto de obra\" debe ser mayor a cero.");
			return false;
		}
		
		document.form.submit();
		return true;

	}
	
	function goBack2() {

		debugger;
		window.history.back();

	}
	
	function pagarlinea(){
		
		var habipag = document.getElementById('action');
		
		habipag.disabled = false;
		
	}
	
	function presdecla(){
		 var habidec = document.getElementById('duGeneraDeclaracionButton');
		 habidec.disabled = false;
	}
	
	window.onload = function data() {
		var incor = document.getElementById('presupuestoObra').value;
		
		var causalexcencion = document.getElementById('causalexcencion');
		var valCausalExcencion = causalexcencion.value;
		
		var tot= document.getElementById('totalRetencion');
		var pres= document.getElementById('totalpresu');
		
		if(incor=='02' && valCausalExcencion != '00'){
			tot.readOnly=false;
			pres.readOnly=false;
		}else if(incor=='02' && valCausalExcencion == '00'){
			tot.readOnly=true;
			pres.readOnly=false;
		} else{	
			tot.readOnly=true;
			pres.readOnly=true;
		}
	    $(".loader").fadeOut("slow");
	}
	
</script>

<script>
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

		for (var j, i = nuevoNumero.length - 1, j = 0; i >= 0; i--, j++)
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
</script>


