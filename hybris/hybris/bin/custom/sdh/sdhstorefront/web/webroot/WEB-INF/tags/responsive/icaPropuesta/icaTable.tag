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
						<td><spring:theme code="ica.propuesta.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="ica.propuesta.descripcion1" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información</a> <spring:theme code="ica.propuesta.descripcion2" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-12">
				<div class="table-responsive">
					<table class="table col-md-2 table-bordered">
						<thead>
							<tr>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.propuesta.table.tipdoc" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.propuesta.table.numdoc" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.propuesta.table.nombre" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="inputtextnew" disabled="disabled"
									type="text" size="30" /></td>
								<td><input class="inputtextnew" disabled="disabled"
									type="text" size="30" /></td>
								<td><input class="inputtextnew" disabled="disabled"
									type="text" size="30" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.propuesta.table.angrav" /></label> <input id="" name=""
						class="form-control" disabled type="text" value="" maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.propuesta.table.period" /></label> <input id="" name=""
						class="form-control" disabled type="text" value="" maxlength="240"></input>
				</div>
			</div>
		</div>
	</form:form>
</div>

