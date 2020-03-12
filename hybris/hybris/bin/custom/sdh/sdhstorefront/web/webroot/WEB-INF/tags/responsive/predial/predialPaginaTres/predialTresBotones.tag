<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
<!-- Campos para calculo -->
 <input type="hidden" value="${predialFormtres.numBP}" id="NumBP"/>
 <input type="hidden" value="${predialFormtres.CHIP}" id="CHIP"/>
 <input type="hidden" value="${predialFormtres.matrInmobiliaria}" id="MatrInmobiliaria"/>
 <input type="hidden" value="${predialFormtres.anioGravable}" id="AnioGravable"/>
 <input type="hidden" value="${predialFormtres.opcionuso}" id="OpcionUso"/>
   <!--  "DatosLiquidacion":-->
 <input type="hidden" value="${predialFormtres.estrDatosGenerales.tipoDeclaracion}" id="TipoDeclaracion"/>
 <input type="hidden" value="${predialFormtres.datosJuridicos.porcentajePropiedad}" id="PorcentajePropiedad"/>
 <input type="hidden" value="" id="PorcentajeExclusion"/><!-- Estos datos se toman directamente del campo en la declaración -->
 <input type="hidden" value="" id="PorcentajeExencion"/><!-- Estos datos se toman directamente del campo en la declaración -->
 <input type="hidden" value="${predialFormtres.estrLiquidacionPredial.tarifaLiquidacion}" id="TarifaLiquidacion"/>
 <input type="hidden" value="${predialFormtres.estrLiquidacionPredial.destinoHacendario}" id="DestinoHacendario"/>
 <input type="hidden" value="${predialFormtres.estrLiquidacionPredial.baseGravable}" id="BaseGravable"/>
 <input type="hidden" value="${predialFormtres.estrDatosGenerales.canonArrendamiento}" id="CanonArrendamiento"/>
 <input type="hidden" value="" id="NumeroContratoArrendamiento"/><!-- este campo no se encuentra en el servicio -->
 <input type="hidden" value="${predialFormtres.datosJuridicos.calidadSujecion}" id="CalidadSujecion"/>
 <input type="hidden" value="${predialFormtres.estrDatosGenerales.avaluoMatrizMejora}" id="AvaluoMatrizMejora"/>
 <input type="hidden" value="${predialFormtres.estrDatosGenerales.areaTerrenoMejoraContrib}" id="AreaTerrenoMejoraContribuye"/>
 <input type="hidden" value="${predialFormtres.estrDatosGenerales.avaluoProrrateado}" id="AvaluoProrrateado"/>
 <input type="hidden" value="${predialFormtres.estrDatosGenerales.avaluoIndiceEdificabilidad}" id="AvaluoIndiceEdificabilidad"/>
 <input type="hidden" value="${predialFormtres.estrDatosGenerales.exclusionParcial}" id="ExclusionParcial"/>
   <!--  LiquidacionPrivada -->
 <input type="hidden" value="${predialFormtres.estrLiquidacionPrivada.aporteVoluntario}" id="AporteVoluntario"/>
 <input type="hidden" value="${predialFormtres.estrLiquidacionPrivada.proyecto}" id="Proyecto"/>
 <input type="hidden" value="" id="Autoavaluo"/><!-- este campo no se encuentra en el servicio -->
<!-- Fin de campos para calculo -->
	<div class="row" style="marging-top: 5px">
		<div class="col-md-12 centercol-md-8 text-center">
			<button style="margin-top: 3px;" id="predialGeneraDeclaracionButton" class="btn btn-primary btn-lg GeneraDeclaracionButton"
				type="button" disabled="disabled">
				<spring:theme code="predialtres.firma.presendecla" />
			</button>

			<button class="btn btn-primary btn-lg pagarbtn" type="submit" id="pagar"
				name="pagar" value="pagar" disabled="disabled">
				<spring:theme code="predialtres.firma.paglinea" />
			</button>
			
			
			<button class="btn btn-primary btn-lg" type="submit" id="action"
				name="pagar" value="pagar">
				<spring:theme code="predialtres.firma.spac" />
			</button>

		</div>
	</div>
</div>

