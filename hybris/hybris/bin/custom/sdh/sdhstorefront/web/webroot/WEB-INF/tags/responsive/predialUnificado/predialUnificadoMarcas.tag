<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<sf:form>
	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span><spring:theme code="predial.unificado.marcas.title" /></span>
			</h2>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<br>
				<table class="table">
					<thead>
						<tr>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.marcas.marca" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.marcas.tipmarca" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.marcas.pormarcaa" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.marcas.mutfis" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.marcas.valexcencion" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.marcas.conshistori" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.marcas.fecdesde" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.marcas.fechasta" /></label></th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="marca"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="tipo"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="porcentaje"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Mutación"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Excención"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="conservación"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="fechdesde"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="fechasta"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</sf:form>