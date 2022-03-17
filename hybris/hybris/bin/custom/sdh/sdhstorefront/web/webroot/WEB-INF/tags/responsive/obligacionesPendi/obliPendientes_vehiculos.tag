<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<div class="row" id="div_titulo_vehiculos" style="display:none;">
	<h2><span><spring:theme code="obligacion.sujeto.vehiculos.titulo" /></span></h2>
</div>
<div id="oblipend-vehiculos" class="oblipend-table" style="display: none;">
	<table class="tablesearch table" id="tabla_vehi">
		<thead>
			<tr>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.aniograv" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.placa" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.modelo" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.marca" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.linea" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.edoobli" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.obligacion" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.numForm" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.numRef" /></label></th>
				<th style="text-align: center !important"><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.totPagar" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.obcontra" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.rop" /></label></th>
				<th><label class="control-label labeltabletd" for=""><spring:theme code="obligacion.inicial.vehiculo.pagar" /></label></th>
				<th><label class="control-label labeltabletd"> <spring:theme code="obligacion.inicial.predio.spac" /></label></th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div class="col-md-3 col-md-offset-8">
		<button type="button" class="btn btn-primary btn-lg" id="action"
			name="action" value="Imprimir" style="margin-top: 3px"
			onclick="reporteTrmPdf('03','vehicularReporte.pdf');">
			<spring:theme code="obligacion.inicial.imprimir" />
		</button>
	</div>
</div>
<div id="noCuentaPendientes_vehiculos" style="display:none;">
	<label class="control-label"><spring:theme code="obligaciones.vehiculos.noCuentaPendientes"/></label>
	
	<div class="col-md-3 col-md-offset-8">
        <button type="button" class="btn btn-primary btn-lg" id="action"
            name="action" value="Imprimir" style="margin-top: 3px"
            onclick="reporteTrmPdf('03','vehicularReporte.pdf');">
            <spring:theme code="obligacion.inicial.imprimir" />
        </button>
    </div>
</div>

	
<div class="col-md-8" id="tableSpacVehicular" style="display:none;">
	<input type="hidden" value="" id="anioGravPDFVehicular" class="anioGravPDF"/>
	<input type="hidden" value="" id="objcontPDFVehicular"/>
	<input type="hidden" value="" id="numFormPDFVehicular"/>
	<input type="hidden" value="" id="numBPVehicular"/>
	<table class="table tableSpacPago" id="tableSpacPagoVehicular">
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
		<button type="button" class="btn btn-primary btn-lg btnGenerarSpacPDFVehicular" id="btnGenerarSpacPDFVehicular" name="btnGenerarSpacPDF" value="btnGenerarSpacPDF" style="margin-top: 3px"><spring:theme code="spac.table.descargar" /></button>
	</div>
</div>
