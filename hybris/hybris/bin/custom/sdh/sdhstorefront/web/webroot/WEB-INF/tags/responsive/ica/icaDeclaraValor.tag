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
</div>

	<form:form action="">
		<div class="row" style="margin-top: 18px">
			<div class="col-md-11">
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead style="background-color: rgb(235, 235, 228)!important">
							<tr>
								<td><label class="control-label text-capitalize !important"
									style="width: 100px"><spring:theme
											code="ica.declaracion.valor.angrav" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.tipdoc" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.numide" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.nombre" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.direccion" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.tel" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.municipio" /></label></td>
											<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.taraplicada" /></label></td>
											<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.valor.montoret" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="inputtextnew" type="text" style="width: 100px"/></td>
								<td><select id="" style="width: 100px;">
										<option value=" ">Seleccionar</option>
								</select></td>
								<td><input class="inputtextnew" type="text" style="width: 100px" /></td>
								<td><input class="inputtextnew" type="text" style="" /></td>
								<td><input class="inputtextnew" type="text" style="" /></td>
								<td><input class="inputtextnew" type="text" style="width: 100px"/></td>
								<td><select id="" style="width: 100px;">
										<option value=" ">Seleccionar</option>
								</select></td>
								<td><input class="inputtextnew" type="text" style="width: 100px" /></td>
								<td><input class="inputtextnew" type="text" style="width: 100px" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="col-md-12 text-center">
		<button style="margin-top: 3px;" id=""
							class="btn btn-primary btn-lg" type="button">
							<spring:theme code="ica.declaracion.valor.calcular" />
						</button>
		</div>
		</div>
	</form:form>
