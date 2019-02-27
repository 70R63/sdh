<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />


<div class="container">

	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme
						code="representantes.info.vehiculos.titulo" /></span>

			</h2>
		</div>
	</div>
	<hr
		style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />

	<div class="row">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="representantes.info.vehiculos.archivo" /></label>
		</div>
	</div>

	<div class="row">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="representantes.info.vehiculos.pasos" /></label>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<table class="table border">
				<thead style="cellspacing: 10 !important">
					<tr>
						<th style="text-align: center"><label class="control-label "
							for=""><spring:theme
									code="representantes.info.vehiculos.numero" /></label></th>
						<th style="text-align: center"><label class="control-label"
							for=""> <spring:theme
									code="representantes.info.vehiculos.descripcion" /></label></th>
						<th style="text-align: center"><label class="control-label"
							for=""> <spring:theme
									code="representantes.info.vehiculos.detalle" /></label></th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td style="text-align: center !important">1</td>
						<td style="text-align: center !important"><span><spring:theme
									code="representantes.info.vehiculos.resolucion" /></span>
							<p>
								<spring:theme code="representantes.info.vehiculos.articulo14" /></td>
						<td style="width: 416px !important;"><label
							class="control-label required"><spring:theme
									code="representantes.info.vehiculos.seleccionar" /></label><input
							type="file" class="form-control" id="exampleFormControlFile1"></td>
					</tr>
					<tr>
						<td style="text-align: center !important">2</td>
						<td style="text-align: center !important"><span><spring:theme
									code="representantes.info.vehiculos.resolucion" /></span>
							<p>
								<spring:theme code="representantes.info.vehiculos.articulo16" /></td>
						<td style="width: 416px !important;"><label
							class="control-label required"><spring:theme
									code="representantes.info.vehiculos.seleccionar" /></label><input
							type="file" class="form-control" id="exampleFormControlFile1"></td>
					</tr>
					<tr>
						<td style="text-align: center !important">3</td>
						<td style="text-align: center !important"><span><spring:theme
									code="representantes.info.vehiculos.resolucion" /></span>
							<p>
								<spring:theme code="representantes.info.vehiculos.articulo27" /></td>
						<td style="width: 416px !important;"><label
							class="control-label required"><spring:theme
									code="representantes.info.vehiculos.seleccionar" /></label><input
							type="file" class="form-control" id="exampleFormControlFile1"></td>
					</tr>
					<tr>
						<td style="text-align: center !important">4</td>
						<td style="text-align: center !important"><span><spring:theme
									code="representantes.info.vehiculos.resolucion" /></span>
							<p>
								<spring:theme code="representantes.info.vehiculos.articulo31" /></td>
						<td style="width: 416px !important;"><label
							class="control-label required"><spring:theme
									code="representantes.info.vehiculos.seleccionar" /></label><input
							type="file" class="form-control" id="exampleFormControlFile1"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 col-md-offset-3">
			<button type="submit" class="btn btn-primary btn-lg" id="" name=""
				value="regresar">
				<spring:theme code="representantes.info.vehiculos.regresar" />
			</button>
		</div>
		<div class="col-md-2">
			<button type="submit" class="btn btn-primary btn-lg" id="" name=""
				value="cancelar">
				<spring:theme code="representantes.info.vehiculos.cancelar" />
			</button>
		</div>
		<div class="col-md-2">
			<button type="submit" class="btn btn-primary btn-lg" id="" name=""
				value="enviar">
				<spring:theme code="representantes.info.vehiculos.enviar" />
			</button>
		</div>
	</div>
</div>

