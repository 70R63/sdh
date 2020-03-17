<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_menu">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="autorizado.listacontib.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>



	<div class="row mt-3">
		<div class="col-md-7">
			<form:form action="">
				<div class="table-responsive text-center">
					<table class="table table-bordered" id="example">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tableident"><spring:theme
											code="autorizado.listacontib.tipdoc" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="autorizado.listacontib.numdoc" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="autorizado.listacontib.idcontrib" /></label></td>
								<td><label class="control-label labeltabletd"><spring:theme
											code="autorizado.listacontib.nombre" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="autorizado.listacontib.seleccionar" /></label></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${currentCustomer.agentList}" var="eachAgent" >
								<c:if test="${eachAgent.agent eq 'X'}" >
									<tr>
										<td><input class="inputtextnew tableident"
											disabled="disabled" type="text" size="30" value="${eachAgent.documentType}" /></td>
										<td><input class="inputtextnew tablenumiden"
											disabled="disabled" type="text" size="30" value="${eachAgent.documentNumber}" /></td>
										<td><input class="inputtextnew tablenumiden"
											disabled="disabled" type="text" size="30" value="${eachAgent.bp}" /></td>
<!-- 										<td><input class="inputtextnew" disabled="disabled" -->
<%-- 											type="text" size="30" value="${eachAgent.completeName}" /></td> --%>
										<td><c:out value="${eachAgent.bp}" /></td>
										<td
											style="color: #2196f3; text-decoration: underline !important; font-size: 14px;"><a href="/sdhstorefront/autorizados/contribuyente/representando?representado=${eachAgent.bp}">Ingresar</a></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>

</div>
