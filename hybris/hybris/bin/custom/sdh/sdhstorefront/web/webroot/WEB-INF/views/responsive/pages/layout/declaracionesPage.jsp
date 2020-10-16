<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="declara"
	tagdir="/WEB-INF/tags/responsive/declaraciones"%>

<div class="loader"></div>
<!-- <div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div> -->

<declara:declaraciones/>


<script>

window.onload = function() {

	var url = window.parent.location.href;
	var contenido_url = url.includes('contribuyentes');
	
	if(contenido_url == true){
		var contrib_select = document.getElementById('imprimirCont');
		contrib_select.style.display = 'block';
	}else{
		var contrib_select = document.getElementById('imprimirAR');
		contrib_select.style.display = 'block';

		$("#seleccion").val("0004");
		var obj=document.getElementById("seleccion");
		
 		document.getElementById("BanderaAgete").value= "X";
		
 		ACC.opcionDeclaraciones.preparaAnioGravable();
 		ACC.opcionDeclaraciones.ocultarTablas();
		ACC.opcionDeclaraciones.prepararPeriodo();
		
	}
	
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
</script>