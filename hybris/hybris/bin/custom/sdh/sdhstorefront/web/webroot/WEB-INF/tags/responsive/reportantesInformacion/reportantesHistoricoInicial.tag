<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<
<div class="container">

	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme
						code="representantes.info.historico.inicial.titulo" /></span>

			</h2>
		</div>
	</div>
	<hr
		style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />

	<div class="row">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="representantes.info.historico.inicial.obteninfo" /></label>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label required"><spring:theme
						code="representantes.info.historico.inicial.impreportar" /></label> <select
					required="required" required id="impuesto" class="form-control "
					name="impuesto" onchange="ShowSelected(this)">
					<option value="">Seleccionar</option>
					<option value="1">Predial</option>
					<option value="2">Predial - OPAIN</option>
					<option value="3">ICA</option>
					<option value="4">Vehículos</option>
				</select>
			</div>
		</div>

		<div>
			<div id="inrepor" style="display: none">
				<input id="Idinrepor" value="">
			</div>

		</div>

		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label required"><spring:theme
						code="representantes.info.historico.inicial.anigrav" /></label> <select
					aria-required="true" id="aniograva" class="form-control "
					name="aniograva" onchange=" " required='required'>
					<option value="">Seleccionar</option>
					<option value="2019">2019</option>
					<option value="2018">2018</option>
					<option value="2017">2017</option>
					<option value="2016">2016</option>
				</select>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3  col-md-offset-1 centercol-md-8 text-right">
			<div class="form-group">
				<button class="btn btn-primary btn-block" id="" name=""
					value="cancelar">
					<spring:theme code="representantes.info.historico.inicial.cacelar" />
				</button>
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block" id=""
					name="" value="continuar" onclick="myFunction()">
					<spring:theme
						code="representantes.info.historico.inicial.continuar" />
				</button>
			</div>
		</div>
	</div>
</div>

