<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<div class="row" id="div_titulo_gasolina" style="display:none;">
	<h2><span><spring:theme code="obligacion.sujeto.gasolina.titulo" /></span></h2>
</div>
<div id="oblipend-gasolina" class="oblipend-table" style="display: none;">
	<table class="tablesearch table table-bordered" id="tabla-gasolina">
		<thead>
			<tr>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.gasolina.aniograv" /></label></th>
				<th><label class="control-label labeltabletd" for=""> <spring:theme code="obligacion.inicial.gasolina.periodo" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.gasolina.edoobli" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.gasolina.obligacion" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.gasolina.numForm" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.gasolina.numRef" /></label></th>
				<th style="text-align: center !important"><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.totPagar" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.gasolina.obcontra" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.gasolina.rop" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.gasolina.pagar" /></label></th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div class="col-md-3 col-md-offset-8">
		<button type="button" class="btn btn-primary btn-lg" id="action"
			name="action" value="Imprimir" style="margin-top: 3px"
			onclick="ACC.oblipend.bindTrmPdf('08','1','sobGasolinaReporte.pdf');">
			<spring:theme code="obligacion.inicial.imprimir" />
		</button>
	</div>
</div>
<div id="noCuentaPendientes_gasolina" style="display:none;">
	<label class="control-label"><spring:theme code="obligaciones.gasolina.noCuentaPendientes"/></label>
</div>
