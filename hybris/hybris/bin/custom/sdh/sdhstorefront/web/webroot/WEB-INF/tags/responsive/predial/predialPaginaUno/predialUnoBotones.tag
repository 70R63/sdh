<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
<!-- Campos para calculo -->
 <input type="text" value="${predialForm.numBP}" id="NumBP"/>
 <input type="text" value="${predialForm.CHIP}" id="CHIP"/>
 <input type="text" value="${predialForm.matrInmobiliaria}" id="MatrInmobiliaria"/>
 <input type="text" value="${predialForm.anioGravable}" id="AnioGravable"/>
 <input type="text" value="${predialForm.opcionuso}" id="OpcionUso"/>
   <!--  "DatosLiquidacion":-->
 <input type="text" value="${predialForm.estrDatosGenerales.tipoDeclaracion}" id="TipoDeclaracion"/>
 <input type="text" value="${predialForm.datosJuridicos.porcentajePropiedad}" id="PorcentajePropiedad"/>
 <input type="text" value="" id="PorcentajeExclusion"/><!-- Estos datos se toman directamente del campo en la declaración -->
 <input type="text" value="" id="PorcentajeExencion"/><!-- Estos datos se toman directamente del campo en la declaración -->
 <input type="text" value="${predialForm.estrLiquidacionPredial.tarifaLiquidacion}" id="TarifaLiquidacion"/>
 <input type="text" value="${predialForm.estrLiquidacionPredial.destinoHacendario}" id="DestinoHacendario"/>
 <input type="text" value="${predialForm.estrLiquidacionPredial.baseGravable}" id="BaseGravable"/>
 <input type="text" value="${predialForm.estrDatosGenerales.canonArrendamiento}" id="CanonArrendamiento"/>
 <input type="text" value="" id="NumeroContratoArrendamiento"/><!-- este campo no se encuentra en el servicio -->
 <input type="text" value="${predialForm.datosJuridicos.calidadSujecion}" id="CalidadSujecion"/>
 <input type="text" value="${predialForm.estrDatosGenerales.avaluoMatrizMejora}" id="AvaluoMatrizMejora"/>
 <input type="text" value="${predialForm.estrDatosGenerales.areaTerrenoMejoraContrib}" id="AreaTerrenoMejoraContribuye"/>
 <input type="text" value="${predialForm.estrDatosGenerales.avaluoProrrateado}" id="AvaluoProrrateado"/>
 <input type="text" value="${predialForm.estrDatosGenerales.avaluoIndiceEdificabilidad}" id="AvaluoIndiceEdificabilidad"/>
 <input type="text" value="${predialForm.estrDatosGenerales.exclusionParcial}" id="ExclusionParcial"/>
   <!--  LiquidacionPrivada -->
 <input type="text" value="${predialForm.estrLiquidacionPrivada.aporteVoluntario}" id="AporteVoluntario"/>
 <input type="text" value="${predialForm.estrLiquidacionPrivada.proyecto}" id="Proyecto"/>
 <input type="text" value="" id="Autoavaluo"/><!-- este campo no se encuentra en el servicio -->
<!-- Fin de campos para caluclo -->

	<div class="row" style="marging-top: 5px">
		<div class="col-md-12 centercol-md-8 text-center">
			<button style="margin-top: 3px;" id="" class="btn btn-primary btn-lg"
				type="button">
				<spring:theme code="predialuno.firma.presendecla" />
			</button>

			<button class="btn btn-primary btn-lg" type="submit" id="action"
				name="pagar" value="pagar">
				<spring:theme code="predialuno.firma.paglinea" />
			</button>
			
			
			<button class="btn btn-primary btn-lg" type="submit" id="action"
				name="pagar" value="pagar">
				<spring:theme code="predialuno.firma.spac" />
			</button>

		</div>
	</div>
</div>

