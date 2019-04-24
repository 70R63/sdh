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
							code="ica.inicial.activecono.title" /></span>
				</h2>
			</div>

			<form:form action="">
				<div class="row">
					<div class="col-md-12">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead style="background-color: rgb(235, 235, 228)!important">
									<tr>
										<td><label
											class="control-label text-capitalize !important"><spring:theme
													code="ica.inicial.activecono.actprin" /></label></td>
										<td><label
											class="control-label text-capitalize !important"><spring:theme
													code="ica.inicial.activecono.ciiu" /></label></td>
										<td><label
											class="control-label text-capitalize !important"><spring:theme
													code="ica.inicial.activecono.denomi" /></label></td>
										<td><label
											class="control-label text-capitalize !important"><spring:theme
													code="ica.inicial.activecono.feciniact" /></label></td>
										<td><label
											class="control-label text-capitalize !important"><spring:theme
													code="ica.inicial.activecono.feciniact" /></label></td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><label class="control-label "><spring:theme
										code="ica.inicial.activecono.principal" /></label></td>
										<td><input class="inputtextnew" disabled="disabled"
											type="text" /></td>
										<td><input class="inputtextnew" disabled="disabled"
											type="text" style="height: auto !important;"/></td>
										<td><input class="inputtextnew" disabled="disabled"
											type="text" /></td>
										<td><input class="inputtextnew" disabled="disabled"
											type="text" /></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
