<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />


<spring:url
	value="/contribuyentes/delineacion-urbana"
	var="duURL" htmlEscape="false" />

<!-- <input type="hidden" value="" id="selectedCDU" /> -->
<!-- <input type="hidden" value="" id="selectedRadicado" /> -->

<!-- <div id="divInfoRadicados"  style="display: none;"> -->
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
				type="radio" name="optradio" onclick="seleccion2(this)" value="1">
			Si <input
				style="visibility: visible !important; left: 0px !important; display: inline-block !important"
				type="radio" name="optradio" onclick="seleccion2(this)" value="2">No
		</div>
	</div>

	<br>
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<table class="table" id="duRadicados">
				<thead style="background-color: #006DCC !important">
					<tr>
						<th style="text-align: center"><label class="control-label "><spring:theme
									code="delineacion.urbana.radicados.radicados" /> </label></th>
						<th style="text-align: center"><label class="control-label"><spring:theme
									code="delineacion.urbana.radicados.fechradicado" /></label></th>
						<th style="text-align: center"><label class="control-label"><spring:theme
									code="delineacion.urbana.radicados.modlicencia" /></label></th>
						<th style="text-align: center"><label class="control-label"><spring:theme
									code="delineacion.urbana.radicados.presupuestoRadicado" /></label></th>			
						<th style="text-align: center"><label class="control-label"><spring:theme
									code="delineacion.urbana.radicados.codigoEstrato" /></label></th>									
						<th style="text-align: center"><label class="control-label"><spring:theme
									code="delineacion.urbana.radicados.seleccionar" /></label></th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
		</div>
	</div>
	<sf:form action="${duURL}" method="POST" modelAttribute="dataForm" id="forma" >
	<sf:hidden path="input.selectedCDU" id="selectedCDU" name="selectedCDU" readonly="true"/>
	<sf:hidden path="input.selectedRadicado" id="selectedRadicado" name="selectedRadicado" readonly="true" />
	<sf:hidden path="input.selectedTipoLicencia" id="selectedTipoLicencia" name="selectedTipoLicencia" readonly="true"/>

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
<!-- 				<button class="btn btn-primary btn-lg" type="button" -->
<!-- 					id="retenciondelibutton" disabled="disabled"> -->
<%-- 					<spring:theme code="delineacion.urbana.radicados.retencion" /> --%>
<!-- 				</button> -->
				<sf:button class="btn btn-primary btn-lg" name="action" id="retenciondelibutton1" value="retencion" disabled="true"><spring:theme code="delineacion.urbana.radicados.retencion" /></sf:button>
			</div>
		</div>
		<div class="col-md-4  ">
			<div class="form-group ">
<!-- 				<button class="btn btn-primary btn-lg" type="button" -->
<!-- 					id="declaradelibutton" disabled="disabled"> -->
<%-- 					<spring:theme code="delineacion.urbana.radicados.declaracion" /> --%>
<!-- 				</button> -->
				<sf:button class="btn btn-primary btn-lg" name="action" id="declaradelibutton1" value="declaracion" disabled="true"><spring:theme code="delineacion.urbana.radicados.declaracion" /></sf:button>
			</div>
		</div>
	</div>
	</sf:form>
	
<!-- </div> -->

<script>
	function goBack() {
		window.history.back();
	}
	function seleccion(selectObject) {
		var x = selectObject.value;
		var seleccionar = document.getElementById('selectRadicado');
		var btndecla = document.getElementById('declaradelibutton');
		var btnreten = document.getElementById('retenciondelibutton');

		if (x == '2') {
			btndecla.disabled = false;
			btnreten.disabled = true;
			seleccionar.checked = true;
		} else if (x == '1') {
			btndecla.disabled = true;
			btnreten.disabled = false;
			seleccionar.checked = false;
		}

	}
	
	function seleccion2(selectObject) {
		
		debugger;
		var x = selectObject.value;
		var seleccionar = document.getElementById('selectRadicado');
		var btndecla = document.getElementById('declaradelibutton1');
		var btnreten = document.getElementById('retenciondelibutton1');

		if (x == '2') {
			btndecla.disabled = false;
			btnreten.disabled = true;
			seleccionar.checked = true;
		} else if (x == '1') {
			btndecla.disabled = true;
			btnreten.disabled = false;
			seleccionar.checked = false;
		}

	}
</script>


