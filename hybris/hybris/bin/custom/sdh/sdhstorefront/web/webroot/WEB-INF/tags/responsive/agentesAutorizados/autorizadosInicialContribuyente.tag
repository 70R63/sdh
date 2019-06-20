<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />


	<div class="col-md-6 col-md-offset-3" style="  margin-bottom: 5px">
		<label class="control-label"
			style="text-transform: none; font-weight: 600 !important; "><spring:theme
				code="autorizado.inicial.representando" /></label>
	</div>


<div class="row mt-3">
	<div class="col-md-6 col-md-offset-3 d-flex align-items-center">
		<form:form action="">
			<div class="table-responsive text-center">
				<table class="table table-bordered">
					<thead>
						<tr>
							<td><label class="control-label labeltabletd tableident"><spring:theme
										code="ica.inicial.table.tipdoc" /></label></td>
							<td><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="ica.inicial.table.numdoc" /></label></td>
							<td><label class="control-label labeltabletd tablenombre"><spring:theme
										code="ica.inicial.table.nombre" /></label></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input class="inputtextnew tableident"
								disabled="disabled" type="text" size="30" value="" /></td>
							<td><input class="inputtextnew tablenumiden"
								disabled="disabled" type="text" size="30" value="" /></td>
							<td><input class="inputtextnew tablenombre"
								disabled="disabled" type="text" size="30" value="" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form:form>
	</div>
</div>
