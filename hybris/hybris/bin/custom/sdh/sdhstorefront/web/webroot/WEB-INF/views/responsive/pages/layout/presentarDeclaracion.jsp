<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="impuestos"
	tagdir="/WEB-INF/tags/responsive/impuestos"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="container">
	<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
		<impuestos:listaImpuestos />

	</sf:form>
</div>

<script type="text/javascript">
	window.onload = function data() {

		debugger;

		var div = document.getElementById("impuestoGas");
		var valGas = div.attributes[0].value;
		var div = document.getElementById("impuestoPE");
		var valPE = div.attributes[0].value;

		if (valGas != "" && valPE != "") {
			var x = document.getElementById("impuestonew");

			var option = document.createElement("option");
			option.value = "0"
			option.text = "Seleccionar";
			x.appendChild(option);
			var option = document.createElement("option");
			option.value = "4"
			option.text = "Publicidad Exterior";
			x.appendChild(option);
			var option = document.createElement("option");
			option.value = "5"
			option.text = "Sobretasa Gasolina";
			x.appendChild(option);
		} else if (valGas != "" && valPE == ""){
			var x = document.getElementById("impuestonew");
			var option = document.createElement("option");
			option.value = "0"
			option.text = "Seleccionar";
			x.appendChild(option);
			var option = document.createElement("option");
			option.value = "5"
			option.text = "Sobretasa Gasolina";
			x.appendChild(option);
		}else if (valGas == "" && valPE != ""){
			var x = document.getElementById("impuestonew");
			var option = document.createElement("option");
			option.value = "0"
			option.text = "Seleccionar";
			x.appendChild(option);
			var option = document.createElement("option");
			option.value = "4"
			option.text = "Publicidad Exterior";
			x.appendChild(option);
		}else{
			alert("Usted no cuenta con ningun impuesto para declarar");
		}
			
	};
</script>