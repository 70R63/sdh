<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="icadecla" tagdir="/WEB-INF/tags/responsive/ica"%>
<%@ taglib prefix="delineacionUrbana"
	tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>

	<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>

<div class="loader"></div>
	<icadecla:icaDeclaraInicial/>
	<icadecla:icaDeclaraGenerales/>
	<icadecla:icaDeclaraActFuera/>
	<icadecla:icaDeclaraDeduccion/>
	<icadecla:icaDeclaraTotal/>
	<icadecla:icaDeclaraValor/>
	<icadecla:icaDeclaraLiquidacion/>

	<c:url value='${redirectURL}' var="taxRedirection"/>
	<firmas:generalFirmas firmaContribuyenteRedirection="${taxRedirection}"/>

	<icadecla:icaDeclaraButtons />

	<div id="dialogICA" title="ICA" ><div id="icaDialogContent"></div></div>
	

<script>	

window.onload = function() {

	ACC.ica.validacion_valorRetenido = null;
	var cosas = $(":input");
	var tam = cosas.length;
	if (false){ //EMP-codigo comentado por observaciones en pruebas realizadas el 04 de octubre 2019
		for (var i = 0; i < tam; i++) {
			var valor = cosas[i].value;
			if (valor == "") {
				cosas[i].value = "-";

			}
		}
	}
	
	 <c:forEach items ="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara.valorRetenido}" var="valorRetenidoItem" varStatus="status">
	     establecerCampoDia("${valorRetenidoItem.mes}","${status.index}","${valorRetenidoItem.dia}");	
	 </c:forEach>
	 
	 var codigosCIIU = new Array();
	 var item_codigosCIIU = null;
	 
	 <c:forEach items ="${gravableNetIncomes}" var="itemNetIncomes" varStatus="status">
	 	<c:if test="${not empty itemNetIncomes.ciiu}">
			item_codigosCIIU = new Object();
			item_codigosCIIU.idCodigoCIIU = "${itemNetIncomes.ciiu}";
			codigosCIIU.push(item_codigosCIIU);
		</c:if>
	 </c:forEach>
	 var mostrarValoresRetenidos = false;
	 for (var i = 0; i < codigosCIIU.length; i++) {
		for(var j = 0; j < cat_habilitar_valorRetenido.length; j++){
			 if (codigosCIIU[i].idCodigoCIIU == cat_habilitar_valorRetenido[j].itemId) {
				 if(cat_habilitar_valorRetenido[j].habilitado == "X"){
					mostrarValoresRetenidos = true;
					break;
				 }
		 	}
		 }
		if(mostrarValoresRetenidos == true){
			break;
		}
	 }
	 
	 if(mostrarValoresRetenidos == true){
		var divValoresRetenidosElemento = document.getElementById("divValoresRetenidos");
		divValoresRetenidosElemento.style.display = 'block';
		 
	 }
	 
	 

	 $(".loader").fadeOut("slow");

}
	function goBack() {
		window.history.back();
	}
	
	
	
	 var mesesInfo = new Array();
	 var mesDetalles = null;
	 
	 <c:forEach items ="${icaInfObjetoFormResp.catalogos.valor_retenido_dias}" var="diasDelMes" varStatus="status">
	     mesDetalles = new Object();
	     mesDetalles.mes = "${diasDelMes.key}";
	     mesDetalles.diasEnMes = "${diasDelMes.label}";
	     mesesInfo.push(mesDetalles);
	 </c:forEach>
	 
	 
 
</script>	