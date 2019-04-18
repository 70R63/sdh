<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="impuestos" tagdir="/WEB-INF/tags/responsive/impuestos"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:htmlEscape defaultHtmlEscape="true" />



<div class="container">
	
		<impuestos:listaImpuestos />
	
</div>

<script type="text/javascript">
	window.onload = function data() {

		//debugger;

		//var div = document.getElementById("impuestoGas");
		//var valGas = div.attributes[0].value;
		//var div = document.getElementById("impuestoPE");
		//var valPE = div.attributes[0].value;


		//if (valGas != "" && valPE != "") {
			//var x = document.getElementById("impuesto");

			//var option = document.createElement("option");
			//option.value = "0"
			//option.text = "Seleccionar";
			//x.appendChild(option);
			//var option = document.createElement("option");
			//option.value = "4"
			//option.text = "Publicidad Exterior";
			//x.appendChild(option);
			//var option = document.createElement("option");
			//option.value = "5"
			//option.text = "Sobretasa Gasolina";
			//x.appendChild(option);
		//} else if (valGas != "" && valPE == ""){
			//var x = document.getElementById("impuesto");
			//var option = document.createElement("option");
			//option.value = "0"
			//option.text = "Seleccionar";
			//x.appendChild(option);
			//var option = document.createElement("option");
			//option.value = "5"
			//option.text = "Sobretasa Gasolina";
			//x.appendChild(option);
		//}else if (valGas == "" && valPE != ""){
			//var x = document.getElementById("impuesto");
			//var option = document.createElement("option");
			//option.value = "0"
			//option.text = "Seleccionar";
			//x.appendChild(option);
			//var option = document.createElement("option");
			//option.value = "4"
			//option.text = "Publicidad Exterior";
			//x.appendChild(option);
		//}else{
			//alert("Usted no cuenta con ningun impuesto para declarar");
		///}
			
	};
	
	
	function onChange() {
		
		form = document.getElementById("forma");
		
		input = document.createElement('input');
        input.setAttribute('name', 'skipReques');
        input.setAttribute('value', 'X');
        input.setAttribute('type', 'hidden');        
        form.appendChild(input);		
		
        form.submit();
	}
	
function onChangeAnioGravable() {		
		var impuestoVal = document.getElementById("impuesto").value;
		if(impuestoVal == "4"){
			form = document.getElementById("forma");
			input = document.createElement('input');
	        input.setAttribute('name', 'skipReques');
	        input.setAttribute('value', '');
	        input.setAttribute('type', 'hidden');        
	        form.appendChild(input);
	        form.submit();
		}
	}
</script>