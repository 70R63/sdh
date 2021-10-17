<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
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
						<select data-nivel="0" class="  form-control !important tramitestSNRol" id="selectNivel0" >
							<option value="01">RIT</option>
						</select>
					</div>
				</div>
			</div>
			<div id="divSubtramite" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.subtramite" /></label> 
						<select data-nivel="1" class=" form-control !important tramitestSNRol" id="selectNivel1">
						<option value="01">Creación</option>
						</select>
					</div>
				</div>
			</div>
			<div id="divCategoria" class="row mt-3" >
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.categoria" /></label> 
						<select data-nivel="2" class=" form-control !important tramitestSNRol" id="selectNivel2">
						<option value="01">Registro / rol tributario</option>
						</select>
					</div>
				</div>
			</div>
			<div id="divSubCategoria" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.subcategoria" /></label> 
						<select data-nivel="3" class=" form-control !important tramitestSNRol" id="selectNivel3" >
						</select>
					</div>
				</div>
			</div>
			
			<div id="divRol" class="row mt-3" style="display: none;">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.rol" /></label> 
						<select data-nivel="4" class=" form-control !important tramitestSNRol" id="selectNivel4" >
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
	<form>
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
							type="text" size="30" id="docDescArchivo_0" value="DOCUMENTO DE IDENTIFICACIÓN">
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
			<button class="btn btn-primary btn-lg !important tramitesEnviarRol" type="submit" id="btnEnviar"
				name="btnEnviar" value="enviar">
				<spring:theme code="tramites.crear.inicial.enviar" />
			</button>
		</div>
		<div class="col-md-1">
			<button style="margin-top: 3px;" id="btnCancelar"
				class="btn btn-secondary btn-lg" type="button" 
				onclick="btnCancelar()">
				<spring:theme code="tramites.crear.inicial.cancelar" />
			</button>
		</div>
	</div>
	</form>
</div>




<script>
function btnCancelar(){
	window.location.href = '<c:url value="/" />';
}

function redireccionar(urlAccion){
	debugger;
	window.location = '<c:url value="/" />'+urlAccion;
}

</script>


