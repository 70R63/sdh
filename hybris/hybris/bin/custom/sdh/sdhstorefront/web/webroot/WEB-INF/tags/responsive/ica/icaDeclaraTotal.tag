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
							code="ica.declaracion.total.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>
</div>

<form:form action="">
	<div class="container">
		<div class="row" style="margin-top: 18px">
			<div class="col-md-7">
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead style="background-color: rgb(235, 235, 228) !important">
							<tr>
								<td style="width: 65px;"><label
									class="control-label text-capitalize !important"
									style="width: 65px;"><spring:theme
											code="ica.declaracion.total.actprinci" /></label></td>
								<td><label class="control-label text-capitalize !important"
									style="width: 250px;"><spring:theme
											code="ica.declaracion.total.denomi" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.total.ingnet" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" name="regimen" id=""
									class="form-check-input mr-2"
									style="visibility: visible !important; min-height: 4px !important; width: 20px;"
									disabled size="10"></td>
								<td><input class="inputtextnew" type="text" disabled
									style="width: 250px;" /></td>
								<td><input class="inputtextnew" type="text" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="row" style="margin-top: 18px">
		<div class="col-md-12">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead style="background-color: rgb(235, 235, 228) !important">
						<tr>
							<td><label class="control-label text-capitalize !important"
								style="width: 70px;"><spring:theme
										code="ica.declaracion.total.angrava" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.tipdoc" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.numide" /></label></td>
							<td><label class="control-label text-capitalize !important"
								style="width: 100px;"><spring:theme
										code="ica.declaracion.total.vigencia" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.nombre" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.direc" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.tel" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.denomi" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.valtotaliva" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.valtotaldev" /></label></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input class="inputtextnew" type="text"
								style="width: 70px;" /></td>
							<td><select id="">
									<option value=" ">Seleccionar</option>
							</select></td>
							<td><input class="inputtextnew" type="text"
								style="width: 100px;" /></td>
							<td><input class="inputtextnew" type="text"
								style="width: 100px;" /></td>
							<td><input class="inputtextnew" type="text" /></td>
							<td><input class="inputtextnew" type="text" /></td>
							<td><input class="inputtextnew" type="text"
								style="width: 100px;" /></td>
							<td><select id="" style="width: 150px;">
									<option value=" ">Seleccionar</option>
							</select></td>
							<td><input class="inputtextnew" type="text" style="width: 100px;" /></td>
							<td><input class="inputtextnew" type="text" style="width: 100px;" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</form:form>
</div>