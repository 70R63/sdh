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
		</div>
	</div>

	<br>
	<form:form action="">
		<div class="row">
			<div class="col-md-8 text-center">
				<div class="table-responsive">
					<table class="table table-bordered" id="example">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="ica.inicial.activecono.actprin" /></label></td>
								<td><label class="control-label labeltabletd inputcodciuu"><spring:theme
											code="ica.inicial.activecono.ciiu" /></label></td>
								<td style="width:150%"><label class="control-label labeltabletd"><spring:theme
											code="ica.inicial.activecono.denomi" /></label></td>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="ica.inicial.activecono.feciniact" /></label></td>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="ica.inicial.activecono.feciniact" /></label></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="loop"
								items="${icaInfObjetoFormResp.icaInfObjetoResponse.activEconomicas}"
								var="eachActivEconomicas">
								<tr>
									<c:if test='${eachActivEconomicas.activPrincipal == "X"}'>
										<td><label class="control-label tablefechas "><spring:theme
													code="ica.inicial.activecono.principal" /></label></td>
									</c:if>
									<c:if test='${eachActivEconomicas.activPrincipal != "X"}'>
										<td><label class="control-label "></label></td>
									</c:if>
									<td><input class="inputtextnew inputcodciuu"
										disabled="disabled" value="${eachActivEconomicas.ciiu}"
										type="text" /></td>
									<td><input class="inputtextnew"
										disabled="disabled"
										value="${eachActivEconomicas.denominacion}" type="text"  style="width: 100%" /></td>
									<td><input class="inputtextnew tablefechas"
										disabled="disabled" value="${eachActivEconomicas.fechaIniAct}"
										type="text" /></td>
									<td><input class="inputtextnew tablefechas"
										disabled="disabled"
										value="${eachActivEconomicas.fechaCeseAct}" type="text" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</form:form>
</div>
