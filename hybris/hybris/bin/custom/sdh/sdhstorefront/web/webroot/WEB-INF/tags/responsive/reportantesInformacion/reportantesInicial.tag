<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url
	value="/contribuyentes/sobretasa-gasolina/declaracion-gasolina"
	var="presentarDeclaracionUrl" htmlEscape="false" />
<spring:url value="/contribuyentes/sobretasa-gasolina" var="buscarUrl"
	htmlEscape="false" />

<div class="col-md-9">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr class="avisoheadline p">
					<td><spring:theme code="" /></td>
				</tr>
			</thead>
			<tbody>
				<tr class="avisobody">

					<td><spring:theme code="representantes.info.inicial.leyenda" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="container center">

	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span><spring:theme code="representantes.info.inicial.titulo" /></span>
			</h2>
		</div>
	</div>

	<div class="row">
		<div class="form-group center text-align: center;"
			style="text-align: center; margin: 1rem; padding: 1rem;">
			<label class="control-label"><spring:theme
					code="representantes.info.inicial.bienvenido" /></label>
		</div>
	</div>

	<div class="row">
		<div class="form-group" style="text-align: center; margin: 1rem; padding: 1rem;">
			<label class="control-label"><spring:theme
					code="representantes.info.inicial.seleccion" /></label>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4" style="text-align: center; margin: 1rem; padding: 1rem;">
			<div class="form-group" style="text-align: center; margin: 1rem; padding: 1rem;">
				<label class="control-label required"><spring:theme
						code="representantes.info.inicial.impreportar" /></label> <select
					id="impuesto" class="form-control " name="impuesto" onchange=" ">
					<option value="0">Seleccionar</option>
					<option value="1">Predial</option>
					<option value="2">Predial - OPAIN</option>
					<option value="3">ICA</option>
					<option value="4">Vehículos</option>
				</select>
			</div>
		</div>

		<div class="col-md-4" style="text-align: center; margin: 1rem; padding: 1rem;">
			<div class="form-group" style="text-align: center; margin: 1rem; padding: 1rem;">
				<label class="control-label required"><spring:theme
						code="representantes.info.inicial.anigrav" /></label> <select
					id="aniograva" class="form-control " name="aniograva" onchange=" ">
					<option value="0">Seleccionar</option>
					<option value="2019">2019</option>
					<option value="2018">2018</option>
					<option value="2017">2017</option>
					<option value="2016">2016</option>
				</select>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3" style="text-align: center; margin: 1rem; padding: 1rem;">
			<div class="form-group" style="text-align: center; margin: 1rem; padding: 1rem;">
				<button type="submit" class="btn btn-primary btn-block" id=""
					name="" value="cancelar">
					<spring:theme code="representantes.info.inicial.cacelar" />
				</button>
			</div>
		</div>
		<div class="col-md-3" style="text-align: center; margin: 1rem; padding: 1rem;">
			<div class="form-group" style="text-align: center; margin: 1rem; padding: 1rem;">
				<button type="submit" class="btn btn-primary btn-block" id=""
					name="" value="continuar">
					<spring:theme code="representantes.info.inicial.continuar" />
				</button>
			</div>
		</div>
	</div>
</div>

