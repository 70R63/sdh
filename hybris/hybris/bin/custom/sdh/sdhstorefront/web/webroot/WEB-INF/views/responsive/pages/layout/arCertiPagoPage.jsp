<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="certificacion"
	tagdir="/WEB-INF/tags/responsive/consultas"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

	<certificacion:arCertificacionMenu />


<script type="text/javascript">

window.onload = function() {
	//Se agrega funcionalidad para agentes Retenedores
	debugger;
	var url = window.parent.location.href;
	var contenido_url = url.includes('contribuyentes');
	
	if(contenido_url == true){
		var contrib_select = document.getElementById('idImpuesto');
		contrib_select.style.display = 'block';
	}else{
		var contrib_select = document.getElementById('idImpuestoAgente');
		contrib_select.style.display = 'block';

		$("#seleccion").val("0004");
		var obj=document.getElementById("seleccion");
		
 		
// 	document.getElementById("BanderaAgete").value = "X";

			ACC.opcionDeclaraciones.ocultarTablas();
			ACC.opcionDeclaraciones.prepararPeriodo();

		}
	 $(".loader").fadeOut("slow");
	}
</script>
