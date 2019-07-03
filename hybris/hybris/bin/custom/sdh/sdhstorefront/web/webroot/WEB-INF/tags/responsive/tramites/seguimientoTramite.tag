<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="tramites.seguimiento.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">
						<td><spring:theme code="tramites.seguimiento.inicial.descrip" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="tramites.seguimiento.inicial.title" /></span>
				</h2>
			</div>
			<div class="col-md-12">
				<label class="control-label" style="text-transform: none"><spring:theme
						code="tramites.seguimiento.inicial.desc" /></label>
			</div>
			<div class="col-md-12">
				<label class="control-label" style="text-transform: none"><spring:theme
						code="tramites.seguimiento.inicial.des" /></label>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.inicial.numcaso" /></label><input id=""
						name="" class="form-control" type="text" value="" maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.inicial.numrad" /></label><input id=""
						name="" class="form-control" type="text" value="" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-4 text-center">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.inicial.tipdoc" /></label> <select
						class="form-control">
						<option value="Seleccionar">Seleccionar</option>
						<option value="">Creación</option>
						<option value="">Actualización</option>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.inicial.numdoc" /></label><input id=""
						name="" class="form-control" type="text" value="" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-1">
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button" onclick="showtable()">
					<spring:theme code="tramites.seguimiento.inicial.buscar" />
				</button>
			</div>
			<div class="col-md-1">
				<div class="form-group">
					<button style="margin-top: 3px;" id=""
						class="btn btn-secondary btn-lg" type="button" onclick="">
						<spring:theme code="tramites.seguimiento.inicial.cancelar" />
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="row" id="table" style="display: none">
		<div class="col-md-6">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<td><label class="control-label labeltabletd tableident"><spring:theme
										code="tramites.seguimiento.tabla.numtramite" /></label></td>
							<td><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="tramites.seguimiento.tabla.numrad" /></label></td>
							<td><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="tramites.seguimiento.tabla.categ" /></label></td>
							<td><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="tramites.seguimiento.tabla.estado" /></label></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label class="control-label labeltabletd tableident" onclick="showdetalle()"><spring:theme
										code="Ejemplo" /></label></td>
							<td><input class="inputtextnew tablenumiden"
								disabled="disabled" type="text" size="30" value="" /></td>
							<td><input class="inputtextnew tablenumiden"
								disabled="disabled" type="text" size="30" value="" /></td>
							<td><input class="inputtextnew tablenumiden"
								disabled="disabled" type="text" size="30" value="" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div id="detalle" style="display: none">
		<div class="row mt-3">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.numtam" /></label><input id=""
						name="" class="form-control" type="text" value="" maxlength="240"
						disabled></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.tiptramite" /></label><input id=""
						name="" class="form-control" type="text" value="" maxlength="240"
						disabled></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-4 ">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.numrad" /></label> <input id=""
						name="" class="form-control" type="text" value="" maxlength="240"
						disabled></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.subtramite" /></label><input id=""
						name="" class="form-control" type="text" value="" maxlength="240"
						disabled></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.estado" /></label> <input id=""
						name="" class="form-control" type="text" value="" maxlength="240"
						disabled></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.categoria" /></label><input id=""
						name="" class="form-control" type="text" value="" maxlength="240"
						disabled></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.justi" /></label> <input id=""
						name="" class="form-control" type="text" value="" maxlength="240"
						disabled></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.subcategoria" /></label><input id=""
						name="" class="form-control" type="text" value="" maxlength="240"
						disabled></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.texto" /></label>
					<textarea name="mensaje" id="mensaje" class="form-control"
						style="min-height: 120px; max-height: 400px; min-width: 100%; max-width: 100%;"
						disabled></textarea>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-12">
				<label class="control-label"><spring:theme
						code="tramites.seguimiento.detalle.docad" /></label>
				<div
					style="border: 1px solid #000; min-height: 120px; max-height: 400px; min-width: 100%; max-width: 100%; border-radius: 5px"></div>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-12 text-center">
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button" onclick="">
					<spring:theme code="tramites.seguimiento.detalle.menu" />
				</button>
			</div>
		</div>
	</div>
</div>



<script>
	function showtable() {
		var table = document.getElementById('table');
		table.style.display = 'block';
	}
	
	function showdetalle(){
		var deta = document.getElementById('detalle');
		deta.style.display = 'block';
	}
</script>