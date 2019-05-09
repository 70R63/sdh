<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.inicial.carga.anio" /></label> <select id="" name=""
						class="form-control" style="width: 200px !important">
						<option>Seleccionar</option>
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.inicial.carga.periodo" /></label> <select id="" name=""
						class="form-control" style="width: 200px !important">
						<option>Seleccionar</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="reteica.inicial.carga.titulo" /></span>
				</h2>
			</div>
		</div>

		<hr
			style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />
		<div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.inicial.carga.descarga" /></label>
				</div>
			</div>

			<div class="col-md-4 text-center">
				<div class="form-group">
					<button class="btn btn-primary text-center" id="" name=""
						value="descargar">
						<spring:theme code="reteica.inicial.carga.descargar" />
					</button>
				</div>
			</div>

			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.inicial.carga.agrega" /></label>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.inicial.carga.guarda" /></label>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.inicial.carga.adjunta" /></label>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.inicial.carga.seleccionar" /></label><input type="file"
						class="form-control" id="" accept=".csv">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-10 text-center">
				<div class="col-md-2">
					<div class="form-group">
						<button class="btn btn-secondary text-left" id="" name=""
							value="regresar">
							<spring:theme code="reteica.inicial.carga.regresar" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button class="btn btn-primary text-left" id="" name=""
							value="cargar">
							<spring:theme code="reteica.inicial.carga.cargar" />
						</button>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<button class="btn btn-primary text-left" id="" name=""
							value="consulta">
							<spring:theme code="reteica.inicial.carga.consultar" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>

