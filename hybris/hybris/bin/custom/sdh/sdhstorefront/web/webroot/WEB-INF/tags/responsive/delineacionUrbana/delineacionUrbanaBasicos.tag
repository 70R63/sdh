<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6 headline">
		<h2>
			<span><spring:theme code="delineacion.urbana.basic.title" /></span>
		</h2>
	</div>
</div>

<form:form>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.basic.Liceconstruction" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					readonly="readonly" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.basic.fechrexpe" /></label> <input id="" name=""
					class="form-control" aria-required="true" type="text"
					readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.basic.numresolurevalida" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					readonly="readonly" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.basic.fechrevalida" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.basic.tipomarca" /></label> <select id=""
					name="" class="form-control" aria-required="true"
					disabled="disabled"></select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.basic.fechfinobra" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.basic.marca" /></label> <select id="" name=""
					class="form-control" aria-required="true" disabled="disabled"></select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.basic.fechresolprorroga" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.basic.numresoprorroga" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<table class="newtable">
			<thead>
				<tr>
					<th><label class="control-label " for=""><spring:theme
								code="delineacion.urbana.basic.numradicado" /></label></th>
					<th><label class="control-label " for=""> <spring:theme
								code="delineacion.urbana.basic.fechradicado" /></label></th>
					<th><label class="control-label " for=""> <spring:theme
								code="delineacion.urbana.basic.modaLicencia" /></label></th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td><c:out value="Numero de radicado"></c:out></td>
					<td><c:out value="Fecha de radicado"></c:out></td>
					<td><select class="form-control" disabled="disabled"><option>Modalidad</option></select></td>
				</tr>

			</tbody>

		</table>
	</div>
</form:form>

