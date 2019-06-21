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
								code="tramites.crear.inicial.tiptramite" /></label> <select
							class="form-control">
							<option value="Seleccionar">Seleccionar</option>
							<option value="">RIT</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.subtramite" /></label> <select
							class="form-control">
							<option value="Seleccionar">Seleccionar</option>
							<option value="">Creación</option>
							<option value="">Actualización</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.categoria" /></label> <select
							class="form-control">
							<option value="Seleccionar">Seleccionar</option>
							<option value="">Registro/Rol tributario</option>
							<option value="">Creación de calidad de sujeción pasiva</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.subcategoria" /></label> <select
							class="form-control">
							<option value="Seleccionar">Seleccionar</option>
							<option value="">Persona Natural</option>
							<option value="">PersonaJurídica</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row mt-3">
				<div class="col-md-12 ">
					<div class="form-group">
						<label class="control-label required"
							style="text-align: center !important;"><spring:theme
								code="tramites.crear.inicial.mensaje" /></label>
						<textarea name="mensaje" id="mensaje" class="form-control"
							style="min-height: 120px; max-height: 400px; min-width: 100%; max-width: 100%;"></textarea>
						<small class="form-text text-muted"
							style="text-align: right !important"><spring:theme
								code="tramites.crear.inicial.nota" /></small>
					</div>
				</div>
			</div>
			<div class="row mt-3" style="display: none" id="adjuntar">
				<div class="col-md-12">
					<div class="form-group">
						<label class="control-label" style="text-transform: none"><spring:theme
								code="tramites.crear.inicial.selarch" /></label><input type="file"
							class="form-control" id="exampleFormControlFile1" accept=".txt">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row mt-3">
		<div class="col-md-7 text-right">
			<button style="margin-top: 3px;" id="" class="btn btn-primary btn-lg"
				type="button" onclick="adjuntar()">
				<spring:theme code="tramites.crear.inicial.adjuntar" />
			</button>
		</div>
		<div class="col-md-1">
			<button style="margin-top: 3px;" id="" class="btn btn-primary btn-lg"
				type="button">
				<spring:theme code="tramites.crear.inicial.enviar" />
			</button>
		</div>
		<div class="col-md-1">
			<button style="margin-top: 3px;" id=""
				class="btn btn-secondary btn-lg" type="button">
				<spring:theme code="tramites.crear.inicial.cancelar" />
			</button>
		</div>
	</div>
</div>

<script>
	function adjuntar() {
		var show = document.getElementById('adjuntar');
		show.style.display = 'block';
	}
</script>



