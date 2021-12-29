<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<c:set var="flagPresentarDeclaracion" value="false" />
<c:set var="flagPagarEnLinea" value="false" />
<c:set var="flagSPAC" value="false" />
<c:if test="${predialFormcua.controlCampos.btnPresentarDec == false}">
	<c:set var="flagPresentarDeclaracion" value="true" />
</c:if>
<c:if test="${predialFormcua.controlCampos.btnPagarDec == false}">
	<c:set var="flagPagarEnLinea" value="true" />
</c:if>
<c:if test="${contribuyente.documentType ne 'NIT' and contribuyente.numBP eq currentUser.numBP }">
	<c:set var="flagPresentarDeclaracion" value="true" />
	<c:set var="flagPagarEnLinea" value="true" />
	<input type="hidden" value="X" id="contribuyenteNoNIT"/>
</c:if>
<c:if test="${fn:substring(predialFormcua.opcionuso,0,2) == '01' && predialFormcua.indicadorspac == 'X'}">
	<c:set var="flagSPAC" value="true" />
</c:if>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL"
	htmlEscape="false" />


<div class="container">
<!-- Campos para calculo -->
 <input type="hidden" value="${predialFormcua.numBP}" id="NumBP"/>
 <input type="hidden" value="${predialFormcua.CHIP}" id="CHIP"/>
 <input type="hidden" value="${predialFormcua.matrInmobiliaria}" id="MatrInmobiliaria"/>
 <input type="hidden" value="${predialFormcua.anioGravable}" id="AnioGravable"/>
 <input type="hidden" value="${predialFormcua.opcionuso}" id="OpcionUso"/>
   <!--  "DatosLiquidacion":-->
 <input type="hidden" value="${predialFormcua.estrDatosGenerales.tipoDeclaracion}" id="TipoDeclaracion"/>
 <input type="hidden" value="${predialFormcua.datosJuridicos.porcentajePropiedad}" id="PorcentajePropiedad"/>
 <input type="hidden" value="" id="PorcentajeExclusion"/><!-- Estos datos se toman directamente del campo en la declaración -->
 <input type="hidden" value="" id="PorcentajeExencion"/><!-- Estos datos se toman directamente del campo en la declaración -->
 <input type="hidden" value="${predialFormcua.estrLiquidacionPredial.tarifaLiquidacion}" id="TarifaLiquidacion"/>
 <input type="hidden" value="${predialFormcua.estrLiquidacionPredial.destinoHacendario}" id="DestinoHacendario"/>
 <input type="hidden" value="${predialFormcua.estrLiquidacionPredial.baseGravable}" id="BaseGravable"/>
 <input type="hidden" value="${predialFormcua.estrDatosGenerales.canonArrendamiento}" id="CanonArrendamiento"/>
 <input type="hidden" value="" id="NumeroContratoArrendamiento"/><!-- este campo no se encuentra en el servicio -->
 <input type="hidden" value="${predialFormcua.datosJuridicos.calidadSujecion}" id="CalidadSujecion"/>
 <input type="hidden" value="${predialFormcua.estrDatosGenerales.avaluoMatrizMejora}" id="AvaluoMatrizMejora"/>
 <input type="hidden" value="${predialFormcua.estrDatosGenerales.areaTerrenoMejoraContrib}" id="AreaTerrenoMejoraContribuye"/>
 <input type="hidden" value="${predialFormcua.estrDatosGenerales.avaluoProrrateado}" id="AvaluoProrrateado"/>
 <input type="hidden" value="${predialFormcua.estrDatosGenerales.avaluoIndiceEdificabilidad}" id="AvaluoIndiceEdificabilidad"/>
 <input type="hidden" value="${predialFormcua.estrDatosGenerales.exclusionParcial}" id="ExclusionParcial"/>
   <!--  LiquidacionPrivada -->
 <input type="hidden" value="${predialFormcua.estrLiquidacionPrivada.aporteVoluntario}" id="AporteVoluntario"/>
 <input type="hidden" value="${predialFormcua.estrLiquidacionPrivada.proyecto}" id="Proyecto"/>
 <input type="hidden" value="" id="Autoavaluo"/><!-- este campo no se encuentra en el servicio -->
<!-- Fin de campos para calculo -->
	<input type="hidden" id="numForm" value="${predialFormcua.numFrom}"/>
	<div class="row" style="marging-top: 5px">
		<sf:form action="${pagarURL}" method="POST" 
			modelAttribute="infoPreviaPSE" id="infoPreviaPSE">
			<div class="col-md-12 centercol-md-8 text-center">
				<c:if test="${flagPresentarDeclaracion eq true}">
					<button style="margin-top: 3px;" id="predialGeneraDeclaracionButton" class="btn btn-primary btn-lg GeneraDeclaracionButton"
						type="button" disabled="disabled">
						<spring:theme code="predialtres.firma.presendecla" />
					</button>
				</c:if>
				
				
				<sf:hidden path="tipoImpuesto"/>
				<sf:hidden path="numBP"/>
				<sf:hidden path="numDoc"/>
				<sf:hidden path="tipoDoc"/>
				<sf:hidden path="anoGravable"/>
				<sf:hidden path="periodo"/>
				<sf:hidden path="clavePeriodo"/>
				<sf:hidden path="dv"/>
				<sf:hidden path="numObjeto"/>
				<sf:hidden path="chip"/>
				<sf:hidden path="fechaVenc"/>
				<sf:hidden path="numRef"/>
				<sf:hidden path="totalPagar"/>
				
				
				<c:if test="${flagPagarEnLinea eq true}">
					<sf:button class="btn btn-primary btn-lg pagarbtn" type="button" onclick="validaBotonPago()"
						id="pagar" name="pagar" value="pagar" disabled="true">	
						<spring:theme code="predialtres.firma.paglinea" />
					</sf:button>
				</c:if>
				
				<c:if test="${flagSPAC eq true}">
					<button class="btn btn-primary btn-lg btnspac" type="submit"
						id="btnspac" name="pagar" value="pagar" data-numForm="${predialFormcua.numFrom}" data-anio="${predialFormcua.anioGravable}" data-obj="${predialFormcua.objetocontrato}">
						<spring:theme code="predialuno.firma.spac" />
					</button>
				</c:if>


			</div>
			<div class="col-md-6" id="tableSpac" style="visibility:hidden;">
			<br><br>
				<table class="table tableSpacPago" id="tableSpacPago">
					<thead>
						<tr>
							<th><label class="control-label labeltabletd tableident"><spring:theme
										code="spac.table.cuotas" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="spac.table.pagar" /></label></th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</sf:form>	
	</div>
</div>


<script>

function validaBotonPago(){
	
	
	var totPagar = document.getElementById('TotalAPagar');
	var negativePos = totPagar.value.search("-");
	if(totPagar.value == '0' || totPagar.value == '0.00' || negativePos >= 0 ){
		alert('El total a pagar debe ser mayor a 0');
		var btnPagar = document.getElementById("action");
		btnPagar.disabled = true;
	}else{
		var form1 = document.getElementById('infoPreviaPSE');
		form1.submit();		
	}
	
}

</script>
