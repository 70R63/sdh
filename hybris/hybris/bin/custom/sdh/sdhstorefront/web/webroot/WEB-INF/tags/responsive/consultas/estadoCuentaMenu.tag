<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/contribuyentes/presentar-declaracion"
	var="generarEstadoCuentaUrl" htmlEscape="false" />



<br>
<div class="col-md-10">
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="consultas.estadoDeCuenta.tipoConsulta" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<sf:select path="tipoConsulta"
					items="${dataForm.catalogosSo.tipoConsulta}"
					referenceData="${dataForm.catalogosSo.tipoConsulta}"
					class="inputdropdown" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="consultas.estadoDeCuenta.impuesto" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<sf:select path="impuesto" items="${dataForm.catalogosSo.impuesto}"
					referenceData="${dataForm.catalogosSo.impuesto}"
					class="inputdropdown" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="consultas.estadoDeCuenta.anioGravableConsultar" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<sf:select path="anoGravable"
					items="${dataForm.catalogosSo.anioGravable}"
					referenceData="${dataForm.catalogosSo.anioGravable}"
					class="inputdropdown" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="consultas.estadoDeCuenta.Periodo" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<sf:select path="periodo" items="${dataForm.catalogosSo.periodo}"
					referenceData="${dataForm.catalogosSo.periodo}"
					class="inputdropdown" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<sf:button action="" type="submit" class="boton" id="action"
				name="action" value="cancelar">
				<spring:theme code="consultas.estadoDeCuenta.cancelar" />
			</sf:button>
		</div>
		<div class="col-md-2">
			<sf:button action="${generarEstadoCuentaUrl}" type="submit"
				class="boton" id="action" name="action" value="generarEstadoCuenta">
				<spring:theme code="consultas.estadoDeCuenta.generarEstadoCuenta" />
			</sf:button>
		</div>
	</div>
</div>
<br>