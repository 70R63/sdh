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
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.valor.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>


	<form:form action="">
		<div class="row" style="margin-top: 18px">
			<div class="col-md-12">
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead style="background-color: rgb(235, 235, 228)!important">
							<tr>
								<td><label class="control-label text-capitalize !important"
									style="width: 100px"><spring:theme
											code="ica.declaracion.valor.vigencia" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.numide" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.nombre" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.dane" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.pagiva" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.taraplicada" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.montoret" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="inputtextnew" type="text" style="width: 100px"/></td>
								<td><input class="inputtextnew" type="text" /></td>
								<td><input class="inputtextnew" type="text" disabled /></td>
								<td><select class="inputtextnew">
										<option>Seleccionar</option>
								</select></td>
								<td><input class="inputtextnew" type="text" style="width: 100px"/></td>
								<td><input class="inputtextnew" type="text" style="width: 100px" /></td>
								<td><input class="inputtextnew" type="text" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-2" style="margin-top: 25px">
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="ica.declaracion.valor.descargar" />
				</button>
			</div>
			<div class="col-md-6">
				<label class="control-label" style="text-transform: capitalize"><spring:theme
						code="ica.declaracion.valor.ayuda" /></label><input type="file"
					class="form-control" id="exampleFormControlFile1">
			</div>
		</div>
	</form:form>
</div>