<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new_page">
	<div class="row mt-3">
		<div class="col-md-12 text-center">
			<label class="control-label" style="text-transform: none"><spring:theme
					code="tramites.crear.inicial.descrip" /></label>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.tiptramite" /></label> 
						<select data-nivel="0"
							class="  form-control !important tramitestSN" id="selectNivel0">
							<option value="00">Seleccionar</option>
							<option value="01">RIT</option>
							<option value="02">Novedades de registro</option>
							<option value="03">Facturación</option>
							<option value="04">Analisis de la cuenta</option>
							<option value="05">Boletín de deudores Morosos del Estado</option>
							<option value="06">Verificación de pagos</option>
							<option value="07">Corrección de la información causada contablemente</option>
							<option value="08">Declaración</option>
							<option value="09">Agente Autorizado</option>
						</select>
					</div>
				</div>
			</div>
			<div id="divSubtramite" class="row mt-3" style="display: none;">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.subtramite" /></label> 
						<select data-nivel="1" class=" form-control !important tramitestSN" id="selectNivel1">
						</select>
					</div>
				</div>
			</div>
			<div id="divCategoria" class="row mt-3" style="display: none;">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.categoria" /></label> 
						<select data-nivel="2" class=" form-control !important tramitestSN" id="selectNivel2">
						</select>
					</div>
				</div>
			</div>
			<div id="divSubCategoria" class="row mt-3" style="display: none;">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.subcategoria" /></label> 
						<select data-nivel="3" class=" form-control !important tramitestSN" id="selectNivel3" >
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row mt-3">
				<div class="col-md-12 ">
					<div class="form-group">
						<label class="control-label"
							style="text-align: center !important;"><spring:theme
								code="tramites.crear.inicial.mensaje" /></label>
						<textarea name="mensaje" id="mensaje" class="form-control"
							style="min-height: 220px; max-height: 600px; min-width: 100%; max-width: 100%;" maxlength="1000"></textarea>
						<small class="form-text text-muted"
							style="text-align: right !important"><spring:theme
								code="tramites.crear.inicial.nota" /></small>
					</div>
				</div>
			</div>
		</div>
	</div>
		<div class="row documentos"  >
		<div class="col-md-6 text-center col-md-offset-3"
			style="margin-top: 15px">
			<table class="table table-bordered" id="documentos" style="display:none">
				<thead>
					<tr>
						<th><label class="contorl-label labeltabletd"><spring:theme
									code="tramites.crear.inicial.adjdoc" /></label></th>
						<th><label class="contorl-label labeltabletd"><spring:theme
									code="tramites.crear.inicial.adj" /></label></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>

	<div class="row mt-3">
		<div class="col-md-7 text-right">
			<sf:button class="btn btn-primary btn-lg !important tramitesEnviar" type="submit" id="btnEnviar"
				name="btnEnviar" value="enviar" disabled="false">
				<spring:theme code="tramites.crear.inicial.enviar" />
			</sf:button>
		</div>
		<div class="col-md-1">
			<button style="margin-top: 3px;" id=""
				class="btn btn-secondary btn-lg" type="button" 
				onclick="btnCancelar()">
				<spring:theme code="tramites.crear.inicial.cancelar" />
			</button>
		</div>
	</div>
</div>



<script>
function tabdoc(){
	var doc=document.getElementById('documentos');
	doc.style.display='block';
}

function tabdococul(){
	var doc=document.getElementById('documentos');
	doc.style.display='none';
}

function btnCancelar(){
	window.location.href = '<c:url value="/contibuyentes/tramites" />';
}

function redireccionar(urlAccion){
	debugger;
	window.location = '<c:url value="/" />'+urlAccion;
}


</script>




