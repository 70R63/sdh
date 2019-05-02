<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

	<div class="row">
		<div class="col-md-10 col-md-offset-1 d-flex align-items-center">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme code="ica.inicial.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="ica.inicial.descripcion1" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información</a> <spring:theme code="ica.inicial.descripcion2" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="row mt-3">
		<div class="col-md-7 col-md-offset-3 d-flex align-items-center">
			<form:form action="">
				<div class="table-responsive">
					<table class="table col-md-2 table-bordered">
						<thead>
							<tr >
								<td style="border-color: solid 1px #00ccff !important;border-top: solid 1px #0486e0 !important; border-bottom: solid 1px #0486e0 !important; border-right: solid 1px #0486e0 !important; border-left: solid 1px #0486e0 !important;"><label class="control-label"  style="text-transform: none !important; width: 150px"><spring:theme
											code="ica.inicial.table.tipdoc" /></label></td>
								<td style="border-color: solid 1px #0486e0 !important;border-top: solid 1px #0486e0 !important; border-bottom: solid 1px #0486e0 !important; border-right: solid 1px #0486e0 !important; border-left: solid 1px #0486e0 !important;"><label class="control-label"  style="text-transform: none !important; width: 150px"><spring:theme
											code="ica.inicial.table.numdoc" /></label></td>
								<td style="border-color: solid 1px #0486e0 !important;border-top: solid 1px #0486e0 !important; border-bottom: solid 1px #0486e0 !important; border-right: solid 1px #0486e0 !important; border-left: solid 1px #0486e0 !important;"><label class="control-label"  style="text-transform: none !important; width: 250px"><spring:theme
											code="ica.inicial.table.nombre" /></label></td>
							</tr>
						</thead>
						<tbody>
						 <tr>
								<td style="border-color: solid 1px #0486e0 !important;border-top: solid 1px #0486e0 !important; border-bottom: solid 1px #0486e0 !important; border-right: solid 1px #0486e0 !important; border-left: solid 1px #0486e0 !important;"><input class="inputtextnew" disabled="disabled" type="text" size="30" style="width: 150px;" value="${icaInfObjetoFormResp.documentType}"/></td>
								<td style="border-color: solid 1px #0486e0 !important;border-top: solid 1px #0486e0 !important; border-bottom: solid 1px #0486e0 !important; border-right: solid 1px #0486e0 !important; border-left: solid 1px #0486e0 !important;"><input class="inputtextnew" disabled="disabled" type="text" size="30" style="width: 150px;" value="${icaInfObjetoFormResp.documentNumber}"/></td>
								<td style="border-color: solid 1px #0486e0 !important;border-top: solid 1px #0486e0 !important; border-bottom: solid 1px #0486e0 !important; border-right: solid 1px #0486e0 !important; border-left: solid 1px #0486e0 !important;"><input class="inputtextnew" disabled="disabled" type="text" size="30" style="width: 250px;" value="${icaInfObjetoFormResp.completeName}"/></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>

