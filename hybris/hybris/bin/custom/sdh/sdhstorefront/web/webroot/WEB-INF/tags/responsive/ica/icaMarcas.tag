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
							code="ica.inicial.marcas.title" /></span>
				</h2>
			</div>
		</div>
	</div>

	<form:form action="">
		<div class="row">
			<div class="col-md-12">
				<div class="table-responsive">
					<table class="table table-bordered" id="example">
						<thead style="background-color: rgb(235, 235, 228) !important">
							<tr>
								<td><label class="control-label" style="text-transform: none !important"><spring:theme
											code="ica.inicial.marcas.descrimarca" /></label></td>
								<td><label class="control-label" style="text-transform: none !important"><spring:theme
											code="ica.inicial.marcas.valexe" /></label></td>
								<td><label class="control-label" style="text-transform: none !important"><spring:theme
											code="ica.inicial.marcas.fecvaldesde" /></label></td>
								<td><label class="control-label" style="text-transform: none !important"><spring:theme
											code="ica.inicial.marcas.fecvalhasta" /></label></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="loop" items="${icaInfObjetoFormResp.icaInfObjetoResponse.marcas}"
									var="eachMarcas">
								<tr>
									<td><input class="inputtextnewmd" disabled="disabled"
										value="${eachMarcas.descripMarca}"
										type="text" style="height: auto !important; width: 380px !important"/></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="${eachMarcas.valorExcencion}"
										type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="${eachMarcas.fechaDesde}"
										type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="${eachMarcas.fechaHasta}"
										type="text" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</form:form>
</div>