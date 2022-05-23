<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new_page">
<a id="downloadHelper" target="_blank"></a>
<div id="dialogMensajes" title="Descarga">
	<div id="dialogMensajesContent"></div>
</div>
	<div class="alert alert-success" role="alert">
		<span><spring:theme code="message.download" /> </span>
	</div>
	<div class="row">
		<div class="headline">
			<h2>
				<span><spring:theme
						code="retenciones.practicadas.inicial.titulo" /></span>

			</h2>
		</div>
	</div>


	<sf:form>
		<div class="row">
			<div class="col-md-6"></div>
			<div class="col-md-3" id="idImpuesto">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="retenciones.practicadas.inicial.anio" /></label> <select
						id="anioGrav" class="new_alto form-control " name="anioGrav"
						onchange="Selected(this)">
						<option value="0">Seleccionar</option>
						<c:forEach var="anios"
							items="${retencionesPracticadasForm.anioGravable}">
							<option value="${anios.key}"><spring:theme
									code="${anios.value}" /></option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>



		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<button type="button" class="btn btn-secondary btn-lg" id="back"
						name="action" value="generar" style="margin-top: 3px" onclick="">
						<spring:theme code="Regresar" />
					</button>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<button type="button" class="btn btn-primary btn-lg"
						id="descargaPDF" name="action" value="generar"
						style="margin-top: 3px" onclick="downloadPDF()">
						<spring:theme code="relacion.inicial.descargar" />
					</button>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-check"></div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<button type="button" class="btn btn-primary btn-lg" id="action"
						name="action" value="buscar" style="margin-top: 3px" onclick="populateTable()">
						<spring:theme code="relacion.inicial.buscar"/>
					</button>

				</div>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-secondary btn-lg" id="action"
					name="action" value="cancelar" style="margin-top: 3px"
					onclick="">
					<spring:theme code="relacion.inicial.cancelar" />
				</button>

			</div>
		</div>
	</sf:form>

	<div class="row" id="tableData" style="display: none;">
		<div class="col-md-7 col-md-offset-3">
			<div class="table-responsive text-center" id="">
				<table class="table table-bordered" id="example">
					<thead>
						<tr>
							<th><label class="control-label labeltabletd"><spring:theme
										code="retenciones.practicadas.table.tpDoc" /> </label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="retenciones.practicadas.table.numDoc" /> </label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="retenciones.practicadas.table.nomRete" /> </label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="retenciones.practicadas.table.visualizar" /> </label></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
		<div class="row" id="detailRetenedor" style="display: none;">
		<div class="row">
				<div class="col-md-11">
			<div class="table-responsive text-center" id="">
				<table class="table table-bordered" id="tabPaginacion0">
					<thead>
						<tr>
							<th><label class="control-label labeltabletd tableangrav"><spring:theme
										code="retenciones.practicadas.tableDet.perRepo" /> </label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="retenciones.practicadas.tableDet.retenedor" /> </label></th>
							<th><label class="control-label labeltabletd tableangrav"><spring:theme
										code="retenciones.practicadas.tableDet.tipDoc" /> </label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="retenciones.practicadas.tableDet.idRetenedor" /> </label></th>
							<th><label class="control-label labeltabletd tableangrav"><spring:theme
										code="retenciones.practicadas.tableDet.basRet" /> </label></th>
							<th><label class="control-label labeltabletd tableangrav"><spring:theme
										code="retenciones.practicadas.tableDet.tarApli" /> </label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="retenciones.practicadas.tableDet.valRet" /> </label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input class="inputtextnew tableangrav" disabled="disabled" value=""
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled" value=""
								type="text" /></td>
							<td><input class="inputtextnew tableangrav" disabled="disabled" value=""
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled" value=""
								type="text" /></td>
							<td><input class="inputtextnew tableangrav" disabled="disabled" value=""
								type="text" /></td>
							<td><input class="inputtextnew tableangrav" disabled="disabled" value=""
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled" value=""
								type="text" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		</div>
		<div class="row" style="padding-top: 15px">
		<div class="col-md-5 col-md-offset-6">
			<table class="table table-bordered" id="detailTotalTable">
				<thead>
				</thead>
					<tbody>

										</tbody>
										</table>
		</div>
		</div>
		<div class="row">
		<div class="col-md-2 col-md-offset-9">
		<button type="button" class="btn btn-primary btn-lg"
						id="imReporte" name="action"
						style="margin-top: 3px" onclick="">
						<spring:theme code="retenciones.practicadas.tableDet.impRepo" />
					</button>
		</div>
		</div>
	</div>
</div>

