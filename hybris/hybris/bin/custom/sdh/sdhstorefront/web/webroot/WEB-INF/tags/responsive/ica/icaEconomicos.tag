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
							code="ica.inicial.datecono.title" /></span>
				</h2>
			</div>

			<form:form action="">
				<div class="row">
					<div class="col-md-12">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<td><label
											class="control-label text-capitalize !important"><spring:theme
													code="ica.inicial.datecono.actsoc" /></label></td>
										<td><label
											class="control-label text-capitalize !important"><spring:theme
													code="ica.inicial.datecono.pastot" /></label></td>
										<td><label
											class="control-label text-capitalize !important"><spring:theme
													code="ica.inicial.datecono.patneto" /></label></td>
										<td><label
											class="control-label text-capitalize !important"><spring:theme
													code="ica.inicial.datecono.ingoper" /></label></td>
										<td><label
											class="control-label text-capitalize !important"><spring:theme
													code="ica.inicial.datecono.paspat" /></label></td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input class="inputtextnew" disabled="disabled"
											type="text" style="visibility: visible !important"/></td>
										<td><input class="inputtextnew" disabled="disabled"
											type="text" /></td>
										<td><input class="inputtextnew" disabled="disabled"
											type="text" /></td>
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


