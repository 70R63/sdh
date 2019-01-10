<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span tabindex="0"><spring:theme
					code="declaracion.publicidad.infovalla" /></span>
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme code="declaracion.publicidad.OrValla" /></label>
	</div>
	<div class="col-md-3">
		<select id="OrValla" class="form-control">
			<option value="1">Oriente/Occidente</option>
			<option value="2">Occidente/Oriente</option>
			<option value="3">Norte/sur</option>
			<option value="4">Sur/Norte</option>
			<option value="5">Derecha (Solo Vehiculos)</option>
			<option value="6">Izquierda (Solo Vehiculos)</option>
			<option value="7">Ambos Sentidos</option>
		</select>
	</div>
</div>
<div class="row">
	<div class="col-md-2">
		<label><spring:theme code="declaracion.publicidad.luginst" /></label>
	</div>
	<div class="col-md-3">
		<select id="luginst" class="form-control">
			<option value="1">Predio</option>
			<option value="2">Veh&iacuteculo</option>
		</select>
	</div>
</div>
<div class="row">
	<div class="col-md-2">
		<label><spring:theme code="declaracion.publicidad.basegrav" /></label>
	</div>
	<div class="col-md-3">
		<select id="basegrav" class="form-control">
			<option value="1">Vallas de m&aacutes de 8 m2 hasta 24 m2</option>
			<option value="2">Vallas de m&aacutes de 24 m2</option>
			<option value="3">Vallas de propiedad de constructores de
				m&aacutes de 8 m2</option>
			<option value="4">Valla en Veh&iacuteculos automotores con
				dimensi&oacuten superios a 8m2</option>
		</select>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label><spring:theme code="declaracion.publicidad.opuso" /></label>
	</div>
	<div class="col-md-3">
		<select id="opuso" class="form-control">
			<option value="1">Declaraci&oacuten</option>
			<option value="2">Correcci&oacuten</option>
			<option value="3">S&oacutelo Pago</option>
			<option value="4">Acto Oficial</option>
		</select>
	</div>
</div>
