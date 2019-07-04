<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="sobre.vehiculo.declaracion.vehiculo.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">
						<td><spring:theme
								code="sobre.vehiculo.declaracion.vehiculo.descripcion1" /> <br>
							<spring:theme
								code="sobre.vehiculo.declaracion.vehiculo.descripcion2" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.aniograv" /></label> <select
						id="aniograv" class="form-control" disabled="disabled">
						<option value="">2019</option>
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.placa" /></label> <input
						id="numresol" name="numresol" class="form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.opuso" /></label> <select
						id="aniograv" class="form-control" disabled="disabled">
						<option value="">Declaración</option>
					</select>
				</div>
			</div>
		</div>
	</form:form>
</div>

