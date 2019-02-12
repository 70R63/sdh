<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="headline">
		<h3>
			<span class="cintillo col-md-10"><spring:theme
					code="delineacion.urbana.detail.title" /></span>
		</h3>
	</div>
</div>

<form:form>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.detail.selectYear" /></label>
		</div>
		<div class="col-md-2">
			<select id="anio" class="inputdropdown" name="anoGravable"
				onchange="">
				<option value="0">Selecciona un año</option>
				<option value="2019">2019</option>
				<option value="2018">2018</option>
				<option value="2017">2017</option>
				<option value="2016">2016</option>

			</select>
		</div>
		<div class="col-md-2">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.detail.selectperiod" /></label>
		</div>
		<div class="col-md-1">
			<select id="period" class="inputdropdown" name="periodo" onchange="">
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
		<div class="col-md-4">
			<button type="submit" class="boton" id="" name=""
				value="Buscar">
				<spring:theme code="delineacion.urbana.detail.search" />
			</button>
		</div>
	</div>
</form:form>

