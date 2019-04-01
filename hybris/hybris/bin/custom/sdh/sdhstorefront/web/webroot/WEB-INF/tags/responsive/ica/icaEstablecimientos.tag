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
							code="ica.inicial.estableci.title" /></span>
				</h2>
			</div>
		</div>
	</div>
</div>


<form:form action="">
	<div class="container">
		<div class="row mt-3">
			<div class="col-md-7">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.inicial.estableci.nomesta" /></label> <input id="" name=""
						class="form-control" disabled type="text" value="" maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-7">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.inicial.estableci.direc" /></label> <input id="" name=""
						class="form-control" disabled type="text" value="" maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-7">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.inicial.estableci.loca" /></label> <input id="" name=""
						class="form-control" disabled type="text" value="" maxlength="240"></input>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table class="table table-bordered datatable">
					<thead>
						<tr>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.matesta" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.fecdesde" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.edomat" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.fechasta" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.valactivo" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.cantperso" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.codpost" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.ciiu" /></label></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" size="10"/></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</form:form>

