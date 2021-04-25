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
						<sf:select data-nivel="0" class="  form-control !important tramitestSN" id="selectNivel0" 
							path="valorN0" items="${opcionesN0}" referenceData="${opcionesN0}" >
						</sf:select>
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
			
			<div id="divRol" class="row mt-3" style="display: none;">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.rol" /></label> 
						<select data-nivel="4" class=" form-control !important tramitestSN" id="selectNivel4" >
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
								code="tramites.crear.inicial.nota" /></small><br>
								<small class="form-text text-muted"
							style="text-align: right !important"><spring:theme
								code="tramites.crear.inicial.nota2" /></small>
					</div>
				</div>
			</div>
		</div>
	</div>
		<div class="row documentos"  >
		<div class="col-md-6 text-center"
			style="margin-top: 15px">
			<table class="table table-bordered" id="documentos" style="display:none">
				<thead>
					<tr>
						<th><label class="contorl-label labeltabletd"><spring:theme
									code="tramites.crear.inicial.adjdoc" /></label></th>
						<th><label class="contorl-label labeltabletd required"><spring:theme
									code="tramites.crear.inicial.adj" /></label></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<input style="width:710px; font-size:9px !important" class="inputtextnew" disabled="disabled" 
							type="text" size="30" id="docDescArchivo_0" value="DOCUMENTO DE IDENTIFICACI�N">
						</td>
						<td>
							<input style="width:405px" class="inputtextnew" type="file" size="150" id="docNombreArchivo_0" name="conA0">							
						</td>
					</tr>
				
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



