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
							<table class="table table-bordered" id="example">
								<thead style="background-color: rgb(235, 235, 228)!important;text-color:#ffffff !important">
									<tr>
										<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><label
											class="control-label text-capitalize !important" style="text-align: center;color: #1b1464 !important;"><spring:theme
													code="ica.inicial.activecono.actprin" /></label></td>
										<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><label
											class="control-label text-capitalize !important" style="text-align: center;width: 100px !important;color: #1b1464 !important;"><spring:theme
													code="ica.inicial.activecono.ciiu" /></label></td>
										<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><label
											class="control-label" style="text-align: center;text-transform: none !important; color: #1b1464 !important;"><spring:theme
													code="ica.inicial.activecono.denomi" /></label></td>
										<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><label
											class="control-label" style="text-align: center; text-transform: none !important; color: #1b1464 !important;"><spring:theme
													code="ica.inicial.activecono.feciniact" /></label></td>
										<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><label
											class="control-label" style="text-align: center; text-transform: none !important; color: #1b1464 !important;"><spring:theme
													code="ica.inicial.activecono.feciniact" /></label></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach varStatus="loop" items="${icaInfObjetoFormResp.icaInfObjetoResponse.activEconomicas}"
									var="eachActivEconomicas">
										<tr>
											<c:if test='${eachActivEconomicas.activPrincipal == "X"}'>
												<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><label class="control-label "><spring:theme
												code="ica.inicial.activecono.principal" /></label></td>
											</c:if>
											<c:if test='${eachActivEconomicas.activPrincipal != "X"}'>
												<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><label class="control-label "></label></td>
											</c:if>
											<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><input class="inputtextnew" disabled="disabled" 
												value="${eachActivEconomicas.ciiu}"
												type="text" style="width: 100px !important; text-align: center" /></td>
											<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><input class="inputtextnew" disabled="disabled"
												value="${eachActivEconomicas.denominacion}"
												type="text" style="height: auto !important; width: 380px !important; "/></td>
											<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><input class="inputtextnew" disabled="disabled"
												value="${eachActivEconomicas.fechaIniAct}"
												type="text" style="text-align: center"/></td>
											<td style="border-top: solid 1px #000000 !important; border-bottom: solid 1px #000000 !important; border-right: solid 1px #000000 !important; border-left: solid 1px #000000 !important;"><input class="inputtextnew" disabled="disabled"
												value="${eachActivEconomicas.fechaCeseAct}"
												type="text" style="text-align: center"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
