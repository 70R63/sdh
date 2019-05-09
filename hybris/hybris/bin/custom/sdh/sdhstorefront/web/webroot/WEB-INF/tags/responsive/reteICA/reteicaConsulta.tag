<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-12">
		<table class="table">
			<thead>
				<tr class="avisoheadline p">
					<td style="text-align: center"><spring:theme
							code="reteica.consulta.inicial.titulo" /></td>
				</tr>
			</thead>
			<tbody>
				<tr class="avisobody">

					<td><spring:theme code="reteica.consulta.inicial.descripcion" /><a
						href="http://www.shd.gov.co/shd/" target="_blank"> Mas
							información</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="container">
	<form:form action="">
		<div class="row">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="reteica.consulta.estado.titulo" /></span>
				</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.consulta.estado.descripcion1" /></label>
				</div>
			</div>
			
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.consulta.estado.descipcion2" /></label>
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

