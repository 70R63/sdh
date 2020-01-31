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
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="loader"></div>


<impuestos:listaImpuestos />



<script type="text/javascript">
	
		window.onload = function() {
			
		    $(".loader").fadeOut("slow");
		    var tipoImpuesto = document.getElementById("impuesto").value;
		    var anio = document.getElementById("anoGravable").value;
		    var nota2 = document.getElementById("notaVehPre");
			var notaotros = document.getElementById("notaOtros");
		    if(tipoImpuesto == '6'){
				var nota = document.getElementById("notas_deli");
				nota.style.display='block'
			}
		    debugger;
		    if(anio != "" ){
		    if(tipoImpuesto == '2' || tipoImpuesto == '7'){ //vehicular y predial
	 			nota2.style.display='block';
	 				notaotros.style.display='none';
			}else{
				nota2.style.display='none';
				notaotros.style.display='block';
			}}
		}
		
		



	function onChange() {
		var tipoImpuesto = document.getElementById("impuesto").value;
		if(tipoImpuesto == '2'){ //vehicular
			ACC.opcionDeclaraciones.prepararVehicular_presentarDec(tipoImpuesto);
		}else{ //otros impuestos
			
			form = document.getElementById("forma");
	
			input = document.createElement('input');
			input.setAttribute('name', 'skipReques');
			input.setAttribute('value', 'X');
			input.setAttribute('type', 'hidden');
			var skipRequesElemento = document.getElementById("skipReques");
			if(skipRequesElemento==null){
				form.appendChild(input);
			}else{
				skipRequesElemento.value = "X";
			}
	
			form.submit();
			
		}
	}

	function onChangeAnioGravable() {
		
		var impuestoVal = document.getElementById("impuesto").value;
		var nota = document.getElementById("notaVehPre");
		var notaotros = document.getElementById("notaOtros");
 	
 		if(impuestoVal == '2' || impuestoVal == '7'){ //vehicular y predial
 			nota.style.display='block';
 				notaotros.style.display='none';
		}else{
			nota.style.display='none';
			notaotros.style.display='block';
		}
		if(impuestoVal == '2'){ //vehicular
			ACC.opcionDeclaraciones.obtenerListaDeclaraciones_presentarDec(impuestoVal);
		}else{ //otros impuestos
			if (impuestoVal == "4" || impuestoVal == "6" || impuestoVal == "3") {
				form = document.getElementById("forma");
				input = document.createElement('input');
				input.setAttribute('name', 'skipReques');
				input.setAttribute('value', '');
				input.setAttribute('type', 'hidden');
				var skipRequesElemento = document.getElementById("skipReques");
				if(skipRequesElemento==null){
					form.appendChild(input);
				}else{
					skipRequesElemento.value = "";
				}
				form.submit();
			}
	
			ajustaPeriodo();
		}
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
	
	function obtenerURLBase(){
		debugger;
		return '<c:url value="/" />';
	}
</script>