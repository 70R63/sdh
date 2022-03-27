<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="predial"
	tagdir="/WEB-INF/tags/responsive/predial/predialPaginaDos"%>
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>
<%@ taglib prefix="declaracion" tagdir="/WEB-INF/tags/responsive/predial/predialInicial"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<predial:predialDosGenerales />
<predial:predialDosDatPredio/>
<predial:predialDosDatLiq />
<predial:predialDosLiqPrivada />
<c:url value='contribuyentes/predialunificado_2' var="linkRedirection"/>
<firmas:generalFirmas firmaContribuyenteRedirection="${linkRedirection}"/>
<predial:predialDosBotones />
<div id="dialogICA" title="Predial" ><div id="icaDialogContent"></div></div>
<declaracion:predialDeclaracion/>
<script>

function camposAgentes(){
	var representado = "${predialFormdos.representado}";
	
	if(representado != null &&  representado != '' && typeof representado != 'undefined'){
		$("#canonArrendamiento").prop( "disabled", true );		
	}else{
		$("#canonArrendamiento").prop( "disabled", false );
	}
}

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
	
	camposAgentes();
}
</script>