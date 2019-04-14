<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<br>
	<div class="row">
		<div class="col-md-12" style="background:#d2d2d2;">
			<label class="control-label "><spring:theme
					code="delineacion.urbana.radicados.nota.importante" /></label>
			<div class="form-group">
			<label class="control-label "><spring:theme
					code="delineacion.urbana.radicados.nota.demas" /></label>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-3">
			<label class="control-label "><spring:theme
					code="delineacion.urbana.radicados.question1" /></label> <input
				style="visibility: visible !important; left: 0px !important; display: inline-block !important"
				type="radio" name="optradio" onclick="seleccion(this)" value="1">
			Si <input
				style="visibility: visible !important; left: 0px !important; display: inline-block !important"
				type="radio" name="optradio" onclick="seleccion(this)" value="2">No
		</div>
	</div>

	<br>
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<table class="table" id="">
				<thead style="background-color: #006DCC !important">
					<tr>
						<th style="text-align: center"><label class="control-label "><spring:theme
									code="delineacion.urbana.radicados.radicados" /> </label></th>
						<th style="text-align: center"><label class="control-label"><spring:theme
									code="delineacion.urbana.radicados.fechradicado" /></label></th>
						<th style="text-align: center"><label class="control-label"><spring:theme
									code="delineacion.urbana.radicados.modlicencia" /></label></th>
						<th style="text-align: center"><label class="control-label"><spring:theme
									code="delineacion.urbana.radicados.seleccionar" /></label></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input id="CDU" name="" class="inputtextnew"
							aria-required="true" type="text" readonly="readonly"
							value="${docNumber}" maxlength="240"
							style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;"></td>
						<td><input id="" name="" class="inputtextnew"
							aria-required="true" type="text" readonly="readonly"
							value="${docNumber}" maxlength="240"
							style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						<td><input id="" name="" class="inputtextnew"
							aria-required="true" type="text" readonly="readonly"
							value="${docNumber}" maxlength="240"
							style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						<td><input class="inputtextnew"
							style="visibility: visible !important; width: 20% !important"
							type="checkbox" id="selec"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4  ">
			<div class="form-group ">
				<button class="btn btn-primary btn-lg " type="button"
					id="regresarButton" onclick="goBack()">
					<spring:theme code="delineacion.urbana.radicados.regresar" />
				</button>
			</div>
		</div>
		<div class="col-md-4  ">
			<div class="form-group">
				<button class="btn btn-primary btn-lg" type="button"
					id="retenciondelibutton" disabled="disabled">
					<spring:theme code="delineacion.urbana.radicados.retencion" />
				</button>
			</div>
		</div>
		<div class="col-md-4  ">
			<div class="form-group ">
				<button class="btn btn-primary btn-lg" type="button"
					id="declaradelibutton" disabled="disabled">
					<spring:theme code="delineacion.urbana.radicados.declaracion" />
				</button>
			</div>
		</div>
	</div>
</div>

<script>
	function goBack() {
		window.history.back();
	}
	function seleccion(selectObject) {
		var x = selectObject.value;
		var seleccionar = document.getElementById('selec');
		var btndecla = document.getElementById('declaradelibutton');
		var btnreten = document.getElementById('retenciondelibutton');

		if (x == '2') {
			seleccionar.checked = true;
			btndecla.disabled = false;
			btnreten.disabled = true;
		} else if (x == '1') {
			seleccionar.checked = false;
			btndecla.disabled = true;
			btnreten.disabled = false;
		}

	}
</script>


