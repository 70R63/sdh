<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span class="cintillo col-md-10"><spring:theme
					code="delineacion.urbana.basic.title" /></span>
		</h3>
	</div>
</div>

<form:form>

	<div class="row">
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.basic.Liceconstruction" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.basic.fechrexpe" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.basic.numresolurevalida" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.basic.fechrevalida" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>

		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.basic.tipomarca" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.basic.fechfinobra" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>

		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.basic.marca" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>

		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.basic.fechresolprorroga" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.basic.numresoprorroga" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<table class="newtable">
			<thead>
				<tr>
					<th><label class="labeltabla " for=""><spring:theme
								code="delineacion.urbana.basic.numradicado" /></label></th>
					<th><label class="labeltabla " for=""> <spring:theme
								code="delineacion.urbana.basic.fechradicado" /></label></th>
					<th><label class="labeltabla " for=""> <spring:theme
								code="delineacion.urbana.basic.modaLicencia" /></label></th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td><c:out value="Numero de radicado"></c:out></td>
					<td><c:out value="Fecha de radicado"></c:out></td>
					<td><c:out value="Modalidad de licencia"></c:out></td>
				</tr>

			</tbody>

		</table>
	</div>
</form:form>

