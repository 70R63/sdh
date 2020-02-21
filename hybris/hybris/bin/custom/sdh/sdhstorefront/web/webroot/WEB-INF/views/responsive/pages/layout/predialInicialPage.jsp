

<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="predialIni"
	tagdir="/WEB-INF/tags/responsive/predial/predialInicial"%>
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>
<%@ taglib prefix="obligaciones" tagdir="/WEB-INF/tags/responsive/obligacionesPendi"%>

<div class="loader"></div>

<obligaciones:obliPendientesPagar />
<a id="downloadHelper" target="_blank"></a>
<predialIni:predialInicialTable></predialIni:predialInicialTable>


<div class="InicialDetalle" id="InicialDetalle" style="display: none">
<predialIni:predialInicialJuridicos />
	<predialIni:predialInicialEconomicos />
	<predialIni:predialInicialFisicos />
	<predialIni:predialInicialLiquidacion />
	<predialIni:predialInicialMarcas />
</div>

<script>
	window.onload = function() {

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
	
	function presentarDeclaracion(CHIP,anioGravable){
		ACC.opcionDeclaraciones.predial_presentarDec(CHIP,anioGravable);
		
	}

	function pagarEnLinea(tipoImpuesto,anoGravable,periodo,numObjeto,chip){
		debugger;
		var numBP = "${infoContrib.numBP}";
		var numDoc = "${infoContrib.numDoc}";
		var tipoDoc = "${infoContrib.tipoDoc}";
		var clavePeriodo = anoGravable.substr(2,2).concat("A1");
		var dv = "${infoContrib.adicionales.DIGVERIF}";
		
		
		$("#pagarEnLinea_tipoImpuesto").val(tipoImpuesto);
		$("#pagarEnLinea_numBP").val(numBP);
		$("#pagarEnLinea_numDoc").val(numDoc);
		$("#pagarEnLinea_tipoDoc").val(tipoDoc);		
		$("#pagarEnLinea_anoGravable").val(anoGravable);
		$("#pagarEnLinea_periodo").val(periodo);
		$("#pagarEnLinea_clavePeriodo").val(clavePeriodo);
		$("#pagarEnLinea_dv").val(dv);
		$("#pagarEnLinea_numObjeto").val(numObjeto);
		
		
		form = document.getElementById("infoPreviaPSE");
		if(form!=null){
			form.submit();
		}
		
	}
	

</script>