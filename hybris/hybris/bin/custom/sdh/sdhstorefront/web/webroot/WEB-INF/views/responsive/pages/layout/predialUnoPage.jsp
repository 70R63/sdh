<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="predial"
	tagdir="/WEB-INF/tags/responsive/predial/predialPaginaUno"%>
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>
<%@ taglib prefix="declaracion" tagdir="/WEB-INF/tags/responsive/predial/predialInicial"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>


<predial:predialUnoGenerales />
<predial:predialUnoDatLiq />
<predial:predialUnoLiqPrivada />
<c:url value='contribuyentes/predialunificado_1' var="linkRedirection"/>
<div class='container'>
	<div class="row">
		<div style='position:relative;'>
			<firmas:generalFirmas firmaContribuyenteRedirection="${linkRedirection}"/>			
		</div>
	</div>	
	<div class="form-group">
		<div  class="col-sm-3 col-sm-push-9 guia_btn" style='z-index: 1;top: -70px;'>			
			<label class="control-label"><spring:theme code="predialuno.firma.seccionFirmas" /></label> 
			<span class="badge badge-primary" >2</span>
		</div>
	</div>
</div>	

<div id="dialogDeclaracionGuia" title="Guia SPAC">
	<div id="dialogDeclaracionGuiaContent"></div>
</div>


<predial:predialUnoBotones />

	<div id="dialogICA" title="Predial" ><div id="icaDialogContent"></div></div>
<declaracion:predialDeclaracion/>
<script>

window.onload = function() {
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
    
    validateFormPredial();
    guia_btn();
}

function validateFormPredial() {
    var idMensaje = "${predialForm.tblErrores[0].idMensaje}";
    
    if( idMensaje != "99" && idMensaje != "09" ){    
    	ACC.predial.establecerMensajeInfoObjeto("");
		return ACC.predial.validateFormPredialDespuesLiquidador();
    }else{
    	var mensaje = "${predialForm.tblErrores[0].descripcionMensajes}";
    	alert(mensaje);
    	window.history.back();
    }	
}


function guia_btn(){
	debugger;
	var opcionUso = "${predialForm.opcionuso}";
	$('.guia_btn').hide();
	
	if (!(opcionUso == '' || opcionUso == null || opcionUso == undefined)){
		var opcionUsoCodigo = opcionUso.substring(0,2);
		if(opcionUsoCodigo == '01'){
			$('.guia_btn').show();
		}
	}
}
</script>

