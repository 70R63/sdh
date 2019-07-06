<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row mt-3">
		<div class="col-md-3">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="rop.generar.inicial.impuesto" /></label> <select id="impuesto"
					name="" class="form-control" onchange="habperiodo(this)"><option>Seleccionar</option>
					<option value="1">Predial Unificado</option>
					<option value="2">Vehículos</option>
					<option value="3">ICA</option>
					<option value="4">Publicidad Exterior</option>
					<option value="5">Sobretasa Gasolina</option>
					<option value="6">Delineación Urbana</option></select>
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="rop.generar.inicial.aniograv" /></label> <select id="" name=""
					class="form-control"><option>Seleccionar</option>
					<option value="2019">2019</option>
					<option value="2018">2018</option>
					<option value="2017">2017</option>
					<option value="2016">2016</option>
					<option value="2015">2015</option>
					<option value="2014">2014</option></select>
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="rop.generar.inicial.periodo" /></label> <select id="periodo"
					name="" class="form-control" disabled><option>Seleccionar</option>
				</select>
			</div>
		</div>
		<div class="col-md-3">
			<button style="margin-top: 26px;" id="generarroppredial"
				class="btn btn-primary btn-lg" onclick="habimputable()"
				type="button">
				<spring:theme code="rop.generar.inicial.buscar" />
			</button>
		</div>
	</div>
	<div class="predial" id="predial" style="display: none">
		<div class="row">
			<div class="col-md-6">
				<div class="table-responsive text-center">
					<table class="table table-bordered">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tableident"><spring:theme
											code="rop.generar.pedial.chip" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="rop.generar.pedial.matinmo" /></label></td>
								<td><label class="control-label labeltabletd "><spring:theme
											code="rop.generar.pedial.direc" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="rop.generar.pedial.seleccionar" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="inputtextnew tableident"
									disabled="disabled" type="text" size="30" value="" /></td>
								<td><input class="inputtextnew tablenumiden"
									disabled="disabled" type="text" size="30" value="" /></td>
								<td><input class="inputtextnew " disabled="disabled"
									type="text" size="30" value="" /></td>
								<td><input class="inputtextnew tablenumiden"
									disabled="disabled" type="text" size="30" value="" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 col-md-offset-3">
				<button style="margin-top: 3px;" id="generarroppredial"
					class="btn btn-primary btn-lg" onclick="" type="button">
					<spring:theme code="rop.generar.pedial.rop" />
				</button>
			</div>
		</div>
	</div>


	<div class="ica" id="ica" style="display: none">
		<div class="row">
			<div class="col-md-4">
				<div class="table-responsive text-center">
					<table class="table table-bordered">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tableident"><spring:theme
											code="rop.generar.ica.tipdoc" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="rop.generar.ica.numdoc" /></label></td>
								<td><label
									class="control-label labeltabletd tablenumiden  "><spring:theme
											code="rop.generar.ica.seleccionar" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="inputtextnew tableident"
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
		<div class="row">
			<div class="col-md-12">
				<button style="margin-top: 3px;" id="generarroppredial"
					class="btn btn-primary btn-lg" onclick="" type="button">
					<spring:theme code="rop.generar.ica.rop" />
				</button>
			</div>
		</div>
	</div>


	<div class="publiext" id="publiext" style="display: none">
		<div class="row">
			<div class="col-md-5">
				<div class="table-responsive text-center">
					<table class="table table-bordered">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tableident"><spring:theme
											code="rop.generar.puext.numres" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="rop.generar.puext.tipvalla" /></label></td>
								<td><label
									class="control-label labeltabletd tablenumiden  "><spring:theme
											code="rop.generar.puext.seleccionar" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="inputtextnew tableident"
									disabled="disabled" type="text" size="30" value="" /></td>
								<td><input class="inputtextnew" disabled="disabled"
									type="text" size="30" value="" /></td>
								<td><input class="inputtextnew tablenumiden"
									disabled="disabled" type="text" size="30" value="" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<button style="margin-top: 3px;" id="generarroppredial"
					class="btn btn-primary btn-lg" onclick="" type="button">
					<spring:theme code="rop.generar.puext.rop" />
				</button>
			</div>
		</div>
	</div>
</div>

<script>
	function habperiodo(object) {
		debugger;
		var valor = document.getElementById('impuesto').value;
		var per = document.getElementById('periodo');
		if (valor != 3) {
			per.disabled = true;
		} else {
			per.disabled = false;
		}

	}
	function habimputable() {
		var valor = document.getElementById('impuesto').value;
		var predio = document.getElementById('predial');
		var ica = document.getElementById('ica');
		var publi = document.getElementById('publiext');

		if (valor == 1) {
			predio.style.display = 'block';
			ica.style.display = 'none';
			publi.style.display = 'none';
		} else if (valor == 3) {
			predio.style.display = 'none';
			ica.style.display = 'block';
			publi.style.display = 'none';
		} else if (valor == 4) {
			predio.style.display = 'none';
			publi.style.display = 'block';
			ica.style.display = 'none';
		} else {
			predio.style.display = 'none';
			ica.style.display = 'none';
			publi.style.display = 'none';
		}

	}
</script>

