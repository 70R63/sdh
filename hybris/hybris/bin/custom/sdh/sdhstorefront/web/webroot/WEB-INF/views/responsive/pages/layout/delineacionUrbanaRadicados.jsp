<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="delineacionUrbana"
	tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:url value="/contribuyentes/delineacionurbana/retencion"
	var="duRetencionURL" htmlEscape="false" />

<sf:form action="${duRetencionURL}" method="POST"
	modelAttribute="dataForm" id="forma"
	onsubmit="return validarAntesCalculo();">
	<delineacionUrbana:delineacionUrbanaRetenGenerales />
	<delineacionUrbana:delineacionUrbanaRetenAreasUsos />
	<delineacionUrbana:delineacionUrbanaRetenLiqPriva />
</sf:form>
<delineacionUrbana:delineacionUrbanaRetenFirma />




<script>
	function goBack() {
		var declaracion = '${param.declaracion}';

		if (declaracion) {
			window.location.href = "/sdhstorefront/es/contribuyentes/presentar-declaracion";
		} else {
			window.history.back();
		}
	}

	

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
		var totalRetencionOBLIGATORIO = document
				.getElementById('totalRetencionOBLIGATORIO');
		var presupuestoObra = selectObject.value;

		if (presupuestoObra == "02") {
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
		var totalRetencionOBLIGATORIO = document
				.getElementById('totalRetencionOBLIGATORIO').value;

		if (totalRetencionOBLIGATORIO == "X") {
			if (totalRetencion <= 0) {
				alert("Debido al valor en el campo \"Presupuesto de obra\" el campo \"Valor de retención\" será obligatorio (su valor deberá ser mayor o igual a cero)");
				return false;
			} else {
				document.form.submit();
				return true;
			}
		} else {
			document.form.submit();
			return true;
		}

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
	
</script>


