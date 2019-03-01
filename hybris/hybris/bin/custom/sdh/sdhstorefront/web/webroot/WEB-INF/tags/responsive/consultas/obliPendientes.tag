<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<sf:form>
	<div>
		<div class="container">
			<div class="row">
				<div class="headline">
					<h2 align="center">
						<span><spring:theme code="obligacion.inicial.titulo" /></span>

					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="obligacion.inicial.tipo" /></label><select required="required"
							required id="impuesto" class="form-control " name="impuesto"
							onchange="ShowSelected(this)">
							<option value="">Seleccionar</option>
							<option value="1">Impuesto</option>
							<option value="2">Sujeto</option>

						</select>
					</div>
				</div>
				<div class="col-md-3" id="idImpuesto" style="display: none;">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="obligacion.inicial.selcimpuesto" /></label> <select
							required="required" required id="impuesto" class="form-control "
							name="impuesto" onchange="Selected(this)">
							<option value="">Seleccionar</option>
							<option value="1">Predial Unificado</option>
							<option value="2">Vehículos</option>
							<option value="3">ICA</option>
							<option value="4">Publicidad Exterior</option>
							<option value="5">Sobretasa Gasolina</option>
							<option value="6">Delineación Urbana</option>
						</select>
					</div>
				</div>

				<div class="col-md-3" id="idAnio" style="display: none;">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="obligacion.inicial.aniograv" /></label> <select
							aria-required="true" id="aniograva" class="form-control "
							name="aniograva" onchange="SelectedAnio(this) "
							required='required'>
							<option value="">Seleccionar</option>
							<option value="2019">2019</option>
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
						</select>
					</div>
				</div>

				<div class="col-md-3" id="idPeriodo" style="display: none;">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="obligacion.inicial.periodo" /></label> <select
							aria-required="true" id="periodo" class="form-control "
							name="aniograva" onchange="SelectSobreDeli(this)"
							required='required'>
							<option value="">Seleccionar</option>
							<option value="1">Enero</option>
							<option value="2">Febrero</option>
							<option value="3">Marzo</option>
							<option value="4">Abril</option>
							<option value="5">Mayo</option>
							<option value="6">Junio</option>
							<option value="7">Julio</option>
							<option value="8">Agosto</option>
							<option value="9">Septiembre</option>
							<option value="10">Octubre</option>
							<option value="11">Noviembre</option>
							<option value="12">Diciembre</option>
						</select>
					</div>
				</div>

				<div class="col-md-3" id="idPeriodoICA" style="display: none;">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="obligacion.inicial.periodo" /></label> <select
							aria-required="true" id="periodoICA" class="form-control "
							name="aniograva" onchange="SelectedPerIca(this)"
							required='required'>
							<option value="">Seleccionar</option>
							<option value="1">1-Enero / Febrero</option>
							<option value="2">2-Marzo / Abril</option>
							<option value="3">3-Mayo / Junio</option>
							<option value="4">4-Julio / Agosto</option>
							<option value="5">5-Septiembre / Octubre</option>
							<option value="6">6-Noviembre / Diciembre</option>
						</select>
					</div>
				</div>
			</div>
			<div id="impuest" style="display: none;">
				<input id="Idimp" value="">
			</div>
			<br>
			<div class="row" id="table-predial" style="display: none;">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th style="text-align: center"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.predio.chip" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.predio.matricula" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.predio.direccion" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.predio.seleccionar" /></label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="CHIP"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="Matricula"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="Direccion"></c:out>" /></td>
								<td><input class="inputtextnew"
									style="visibility: visible !important; width: 15px"
									type="radio" id="" name="" value=""></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="row" id="table-vehiculos" style="display: none;">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th style="text-align: center"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.vehiculo.placa" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.vehiculo.marca" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.vehiculo.seleccionar" /></label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="PLACA"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="MARCA"></c:out>" /></td>
								<td><input class="inputtextnew"
									style="visibility: visible !important; width: 15px"
									type="radio" id="" name="" value=""></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row" id="table-ica" style="display: none;">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th style="text-align: center"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.ica.tipdocu" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.ica.numdocu" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.ica.seleccionar" /></label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="TIPO DOCUMENTO"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="NUM DOCUMENTO"></c:out>" /></td>
								<td><input class="inputtextnew"
									style="visibility: visible !important; width: 15px"
									type="radio" id="" name="" value=""></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="row" id="table-publicidad" style="display: none;">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th style="text-align: center"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.publicidad.numresol" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.publicidad.tipvalla" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.publicidad.seleccionar" /></label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="RESOLUCION"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="TIPO VALLA"></c:out>" /></td>
								<td><input class="inputtextnew"
									style="visibility: visible !important; width: 15px"
									type="radio" id="" name="" value=""></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 col-md-offset-5">
					<div class="form-group ">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="cancelar">
							<spring:theme code="obligacion.inicial.cancelar" />
						</button>
				
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar">
							<spring:theme code="obligacion.inicial.generar" />
						</button>
					</div>
				</div>
			</div>

		</div>
	</div>
</sf:form>

<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;

		var idImpuesto = document.getElementById('idImpuesto');
		var idAnio = document.getElementById('idAnio');
		var idPeriodo = document.getElementById('idPeriodo');
		var idPeriodoICA = document.getElementById('idPeriodoICA');
		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');
		
		if (value == '1') {
			idImpuesto.style.display = 'block';
			idAnio.style.display = 'none';
			idPeriodo.style.display = 'none';
			idPeriodoICA.style.display = 'none';
		} else if (value == '2') {
			idImpuesto.style.display = 'none';
			idAnio.style.display = 'block';
			idPeriodo.style.display = 'none';
			idPeriodoICA.style.display = 'none';
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			document.getElementById("Idimp").value = '';
		} else {
			idImpuesto.style.display = 'none';
			idAnio.style.display = 'none';
			idPeriodo.style.display = 'none';
			idPeriodoICA.style.display = 'none';
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
		}
	}
	function Selected(selectObject) {
		var value = selectObject.value;
		document.getElementById("Idimp").value = value;
		var idAnio = document.getElementById('idAnio');
		var idPeriodo = document.getElementById('idPeriodo');
		var idPeriodoICA = document.getElementById('idPeriodoICA');
		if (value == '1' || value == '2' || value == '4') {

			idAnio.style.display = 'block';
			idPeriodo.style.display = 'none';
			idPeriodoICA.style.display = 'none';
		} else if (value == '3') {

			idAnio.style.display = 'block';
			idPeriodo.style.display = 'none';
			idPeriodoICA.style.display = 'block';

		} else if (value == '5' || value == '6') {
			idAnio.style.display = 'block';
			idPeriodo.style.display = 'block';
			idPeriodoICA.style.display = 'none';
		} else {

			idAnio.style.display = 'none';
			idPeriodoICA.style.display = 'none';
			
		}
	}

	function SelectedAnio(selectObject) {
		var value = selectObject.value;
		var x = document.getElementById('Idimp').value;
debugger;
		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');
		if (x == '1') {

			tablepredial.style.display = 'block';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			
		} else if (x == '2') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'block';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
		

		} else if (x == '4') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'block';
			

		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
		}
		
	}

	function SelectedPerIca(selectObject) {
		var value = selectObject.value;

		var x = document.getElementById('Idimp').value;

		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');
		if (x == '3') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'block';
			tablepublicidad.style.display = 'none';
			
		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
		}
	}

	function SelectSobreDeli(selectObject) {
		var value = selectObject.value;

		var x = document.getElementById('Idimp').value;

		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');
		if (x == '5' || x == '6') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
		}
	}
</script>

