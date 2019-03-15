<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-12">
				<h2>
					<span tabindex="0 headline"> <spring:theme
							code="delineacion.urbana.detail.title" />
					</span>
				</h2>
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.detail.selectYear" /></label> <select id="anio"
					class="form-control" name="anoGravable" onchange="">
					<option value="2019">2019</option>
					<option value="2018">2018</option>
					<option value="2017">2017</option>
					<option value="2016">2016</option>

				</select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.detail.selectperiod" /></label> <select
					id="period" class="form-control" name="periodo" onchange="">
					<option value="Enero">Enero</option>
					<option value="Febrero">Febrero</option>
					<option value="Marzo">Marzo</option>
					<option value="Abril">Abril</option>
					<option value="Mayo">Mayo</option>
					<option value="Junio">Junio</option>
					<option value="Julio">Julio</option>
					<option value="Agosto">Agosto</option>
					<option value="Septiembre">Septiembre</option>
					<option value="Octubre">Octubre</option>
					<option value="Noviembre">Noviembre</option>
					<option value="Diciembre">Diciembre</option>

				</select>
			</div>
		</div>

		<div class="col-md-4">
			<button type="submit" class="btn btn-primary btn-lg" id="" name=""
				value="Buscar">
				<spring:theme code="delineacion.urbana.detail.search" />
			</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4 col-md-offset-4 center">
			<button class="btn btn-primary btn-lg backToHome" id="" name=""
				value="Regresar">
				<spring:theme code="delineacion.urbana.detail.regresar" />
			</button>
		</div>
	</div>
</div>