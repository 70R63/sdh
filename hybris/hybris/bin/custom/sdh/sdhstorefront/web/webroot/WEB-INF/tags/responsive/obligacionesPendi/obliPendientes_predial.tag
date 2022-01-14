<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<div class="row" id="div_titulo_predial" style="display:none;">
	<h2><span><spring:theme code="obligacion.sujeto.predial.titulo" /></span></h2>
</div>
<div id="oblipend-predial" class="oblipend-table" style="display: none;">
	<table class="tablesearch table" id="table-predial1">
		<thead style="cellspacing: 10 !important">
			<tr>
				<th style="text-align: center !important"><label class="control-label labeltabletd"><spring:theme code="obligacion.inicial.predio.aniograv" /></label></th>
				<th><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.chip" /></label></th>
				<th><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.edoobli" /></label></th>
				<th><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.obligacion" /></label></th>
				<th><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.numForm" /></label></th>
				<th style="text-align: center !important"><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.numRef" /></label></th>
				<th style="text-align: center !important"><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.totPagar" /></label></th>
				<th><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.obcontra" /></label></th>
				<th><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.rop" /></label></th>
				<th><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.pagar" /></label></th>
				<th><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.spac" /></label></th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div class="col-md-3 col-md-offset-8">
		<button type="button" class="btn btn-primary btn-lg" id="action"
			name="action" value="Imprimir" style="margin-top: 3px"
			onclick="ACC.oblipend.bindTrmPdf('01','1','predialReporte.pdf');">
			<spring:theme code="obligacion.inicial.imprimir" />
		</button>
	</div>
</div>
<div id="noCuentaPendientes_predial" style="display:none;">
	<label class="control-label"><spring:theme code="obligaciones.predial.noCuentaPendientes"/></label>
</div>
	
	
<div class="col-md-8" id="tableSpac" style="display:none;">
	<input type="hidden" value="" id="anioGravPDF" class="anioGravPDF"/>
	<input type="hidden" value="" id="objcontPDF"/>
	<input type="hidden" value="" id="numFormPDF"/>
	<input type="hidden" value="" id="numBP"/>
	<table class="table tableSpacPago" id="tableSpacPago">
		<thead>
			<tr>
				<th><label class="control-label labeltabletd tableident"><spring:theme code="spac.table.cuotas" /></label></th>
				<th><label class="control-label labeltabletd tablenumiden"><spring:theme code="spac.table.pagar" /></label></th>
				<th><label class="control-label labeltabletd tablenumiden"><spring:theme code="spac.table.monto" /></label></th>
				<th><label class="control-label labeltabletd tablenumiden"><spring:theme code="spac.table.estatus" /></label></th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div class="col-md-3 col-md-offset-8">
		<button type="button" class="btn btn-primary btn-lg btnGenerarSpacPDF" id="btnGenerarSpacPDF" name="btnGenerarSpacPDF" value="btnGenerarSpacPDF" style="margin-top: 3px"><spring:theme code="spac.table.descargar" /></button>
	</div>
</div>
