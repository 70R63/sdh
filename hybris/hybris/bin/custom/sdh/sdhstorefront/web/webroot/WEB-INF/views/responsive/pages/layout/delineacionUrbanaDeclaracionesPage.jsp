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
	modelAttribute="dataForm" id="forma">
	<delineacionUrbana:delineacionUrbanaDecGenerales />
	<delineacionUrbana:delineacionUrbanaRetenAreasUsos />
	<delineacionUrbana:delineacionUrbanaDecAreasUsosFechas />
	<delineacionUrbana:delineacionUrbanaDecLiqPriva />
	</sf:form>
<%-- 	<delineacionUrbana:delineacionUrbanaDecFirma /> --%>
	<delineacionUrbana:delineacionUrbanaDecFirmas />




<script>
	function goBack() {
		var declaracion = '${param.declaracion}';
		
		if(declaracion){
			window.location.href = "/sdhstorefront/es/contribuyentes/presentar-declaracion";
		}else{
			window.history.back();
		}
	}
	
	function nuevos(selectObject){

		var value = selectObject.value;
		var cauex = document.getElementById('cauexen').value;
		var auex = document.getElementById('valorExen');
		
		if(value=='09' && (cauex=='00' || cauex=='')){
			auex.readonly=true;
		}else if(value=='09' && (cauex!='00' || cauex!='')){
			auex.readonly=true;
		}else if(value!='09' && (cauex=='00' || cauex=='' || cauex=="")){
			auex.readonly=true;
		}else{
			auex.readonly=false;
		}
		
}
	window.onload = function data() {
		debugger;

		var value = document.getElementById("selecmodlicen");
		var areaintervenida = document.getElementById('selectareinter');
		var inareainter = document.getElementById('inputareainter');
		var mod = document.getElementById('an').value;
		var cauex = document.getElementById('cauexen').value;
		var auex = document.getElementById('valorExen');
		var tiplin = document.getElementById('tipoDeLicencia');
		
		if(mod=='09' && (cauex=='00' || cauex=='')){
			auex.readonly=true;
		}else if(mod=='09' && (cauex!='00' || cauex!='')){
			auex.readonly=true;
		}else if(mod!='09' && (cauex=='00' || cauex=='' || cauex=="")){
			auex.readonly=true;
		}else{
			auex.readonly=false;
		}
		
		if(cauex=='' || cauex=="00")
			{
			tiplin.readonly=true;
			}
		
		
		if (value == '6'){
			
			areaintervenida.readonly=false;
			inareainter.readonly=false;
			
		}else{
			areaintervenida.readonly=true;
			inareainter.readonly=true;
		}
	}
	
	
	function tipoLicenciaCHANGE(selectObject) {

		//Validacion tipo de licencia = 02
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
		btnpaglinea.disabled=false;
		
		
	}
	
	function presdec() {
		var btnpresdec = document.getElementById('duGeneraDeclaracionButton');
		btnpresdec.disabled=false;
		
		
	}
</script>

