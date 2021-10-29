<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="icadecla" tagdir="/WEB-INF/tags/responsive/ica"%>
<%@ taglib prefix="delineacionUrbana"
	tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

	<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>
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
	 	var habilitarDia = true;
		<c:if test="${icaInfObjetoFormResp.controlCampos.valorRetenido == true}">
			habilitarDia = false;
			habilitarMes("${status.index}",false);
		</c:if>
	 	establecerCampoDia("${valorRetenidoItem.mes}","${status.index}","${valorRetenidoItem.dia}",habilitarDia);	
	 </c:forEach>
	 
	 habilitarTablaING_general();
	 
	 ACC.ica.original_tablaValorRetenido = new Array();
	 var item_valorRetenido = null;
	 
	 
	<c:forEach items="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara.valorRetenido }" var="eachValor" varStatus="loopStatusInfo" >
 		item_valorRetenido = new Object();
 		item_valorRetenido.keyComparacion = "${fn:trim(eachValor.anio)}"+"${fn:trim(eachValor.mes)}"+
 		"${fn:trim(eachValor.dia)}"+"${fn:trim(eachValor.tipoID)}"+"${fn:trim(eachValor.numID)}"+
 		"${fn:trim(eachValor.razonSocial)}"+"${fn:trim(eachValor.direccion)}"+"${fn:trim(eachValor.telefono)}"+
 		"${fn:trim(eachValor.codMunicipio)}"+"${fn:trim(eachValor.tarifaApl)}"+"${fn:trim(eachValor.montoRetenido)}";
 		ACC.ica.original_tablaValorRetenido.push(item_valorRetenido);
	 </c:forEach>
	 

	 $(".loader").fadeOut("slow");

}
	function banderaHayRegistrosExcel(){
		var mostrarTablaING = false;
		
		if(codigosCIIU != null && cat_habilitar_valorRetenido != null)
		 for (var i = 0; i < codigosCIIU.length; i++) {
			for(var j = 0; j < cat_habilitar_valorRetenido.length; j++){
				 if (codigosCIIU[i].idCodigoCIIU == cat_habilitar_valorRetenido[j].itemId) {
					 if(cat_habilitar_valorRetenido[j].habilitado == "X"){
						mostrarTablaING = true;
						break;
					 }
			 	}
			 }
			if(mostrarTablaING == true){
				break;
			}
		 }
		
		return mostrarTablaING;
	}
	function habilitarTablaING_general(){
		var divTablaINGElemento = document.getElementById("divTablaING");
		divTablaINGElemento.style.display = 'none';
		var mostrarTablaING = banderaHayRegistrosExcel();
		 
		 if(mostrarTablaING == true){			
			divTablaINGElemento.style.display = 'block';		 
		 }
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
	 
	 var codigosCIIU = new Array();
	 var item_codigosCIIU = null;
	 
	 <c:forEach items ="${gravableNetIncomes}" var="itemNetIncomes" varStatus="status">
	 	<c:if test="${not empty itemNetIncomes.ciiu}">
			item_codigosCIIU = new Object();
			item_codigosCIIU.idCodigoCIIU = "${itemNetIncomes.ciiu}";
			codigosCIIU.push(item_codigosCIIU);
		</c:if>
	 </c:forEach>
 
</script>	