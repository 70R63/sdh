<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<c:set var="flagPresentarDeclaracion" value="false" />
<c:set var="flagPagarEnLinea" value="false" />
<c:if test="${predialForm.controlCampos.btnPresentarDec == false}">
	<c:set var="flagPresentarDeclaracion" value="true" />
</c:if>
<c:if test="${predialForm.controlCampos.btnPagarDec == false}">
	<c:set var="flagPagarEnLinea" value="true" />
</c:if>
<c:if test="${contribuyente.documentType ne 'NIT' and contribuyente.numBP eq currentUser.numBP }">
	<c:set var="flagPresentarDeclaracion" value="true" />
	<c:set var="flagPagarEnLinea" value="true" />
	<input type="hidden" value="X" id="contribuyenteNoNIT"/>
</c:if>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL"
	htmlEscape="false" />

<div class="container">
<!-- Campos para calculo -->
 <input type="hidden" value="${predialForm.numBP}" id="NumBP"/>
 <input type="hidden" value="${predialForm.CHIP}" id="CHIP"/>
 <input type="hidden" value="${predialForm.matrInmobiliaria}" id="MatrInmobiliaria"/>
 <input type="hidden" value="${predialForm.anioGravable}" id="AnioGravable"/>
 <input type="hidden" value="${predialForm.opcionuso}" id="OpcionUso"/>
   <!--  "DatosLiquidacion":-->
 <input type="hidden" value="${predialForm.estrDatosGenerales.tipoDeclaracion}" id="TipoDeclaracion"/>
 <input type="hidden" value="${predialForm.datosJuridicos.porcentajePropiedad}" id="PorcentajePropiedad"/>
 <input type="hidden" value="" id="PorcentajeExclusion"/><!-- Estos datos se toman directamente del campo en la declaración -->
 <input type="hidden" value="" id="PorcentajeExencion"/><!-- Estos datos se toman directamente del campo en la declaración -->
 <input type="hidden" value="${predialForm.estrLiquidacionPredial.tarifaLiquidacion}" id="TarifaLiquidacion"/>
 <input type="hidden" value="${predialForm.estrLiquidacionPredial.destinoHacendario}" id="DestinoHacendario"/>
 <input type="hidden" value="${predialForm.estrLiquidacionPredial.baseGravable}" id="BaseGravable"/>
 <input type="hidden" value="${predialForm.estrDatosGenerales.canonArrendamiento}" id="CanonArrendamiento"/>
 <input type="hidden" value="" id="NumeroContratoArrendamiento"/><!-- este campo no se encuentra en el servicio -->
 <input type="hidden" value="${predialForm.datosJuridicos.calidadSujecion}" id="CalidadSujecion"/>
 <input type="hidden" value="${predialForm.estrDatosGenerales.avaluoMatrizMejora}" id="AvaluoMatrizMejora"/>
 <input type="hidden" value="${predialForm.estrDatosGenerales.areaTerrenoMejoraContrib}" id="AreaTerrenoMejoraContribuye"/>
 <input type="hidden" value="${predialForm.estrDatosGenerales.avaluoProrrateado}" id="AvaluoProrrateado"/>
 <input type="hidden" value="${predialForm.estrDatosGenerales.avaluoIndiceEdificabilidad}" id="AvaluoIndiceEdificabilidad"/>
 <input type="hidden" value="${predialForm.estrDatosGenerales.exclusionParcial}" id="ExclusionParcial"/>
   <!--  LiquidacionPrivada -->
 <input type="hidden" value="${predialForm.estrLiquidacionPrivada.aporteVoluntario}" id="AporteVoluntario"/>
 <input type="hidden" value="${predialForm.estrLiquidacionPrivada.proyecto}" id="Proyecto"/>
 <input type="hidden" value="" id="Autoavaluo"/><!-- este campo no se encuentra en el servicio -->
<!-- Fin de campos para calculo -->
	<input type="hidden" id="numForm" value="${predialForm.numFrom}"/>

	<div class="row" style="marging-top: 5px">
		<sf:form action="${pagarURL}" method="POST" 
			modelAttribute="infoPreviaPSE" id="infoPreviaPSE">
			
			<div class="col-md-12 centercol-md-8 text-center">
				<c:if test="${flagPresentarDeclaracion eq true}">
					<button style="margin-top: 3px;" id="predialGeneraDeclaracionButton" class="btn btn-primary btn-lg GeneraDeclaracionButton"
						type="button" disabled="disabled">
						<spring:theme code="predialuno.firma.presendecla" />
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
						<spring:theme code="predialuno.firma.paglinea" />
					</sf:button>
					
				</c:if>
				
				
				<button class="btn btn-primary btn-lg" type="submit" id="action"
					name="pagar" value="pagar">
					<spring:theme code="predialuno.firma.spac" />
				</button>
	
			</div>
			
		</sf:form>
	</div>
</div>

<script>

function validaBotonPago(){
	debugger;
	var totPagar = document.getElementById('TotalAPagar');
	if(totPagar.value == '0'){
		alert('El total a pagar debe ser mayor a 0')
	}else{
		var form1 = document.getElementById('infoPreviaPSE');
		form1.submit();		
	}
	
}

</script>

