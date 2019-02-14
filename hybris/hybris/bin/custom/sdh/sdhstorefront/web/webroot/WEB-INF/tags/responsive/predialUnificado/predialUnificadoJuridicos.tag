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
				<span><spring:theme code="sobre.vehiculo.juridicos.title" /></span>
			</h2>
		</div>
	</div>

	<div class="container">
		<div class="row">
		<div class="col-md-1">
			<label class="control-label"><spring:theme
					code="predial.unificado.juridicos.chip" /></label>
		</div>
		<div class="col-md-2">
			<input id="" name="" class="form-control" aria-required="true"
				type="text" readonly="readonly"
				value="<c:out value="CHIP"></c:out>" maxlength="240">
		</div>
			<div class="col-md-12">
				<br>
				<table class="table">
					<thead>
						<tr>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.juridicos.tipdoc" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.juridicos.numdoc" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.juridicos.nomcomple" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.juridicos.calidad" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.juridicos.propiedad" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.juridicos.fecdesde" /></label></th>
							<th><label class="control-label "><spring:theme
										code="predial.unificado.juridicos.fechasta" /></label></th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Tipo"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="No Documento"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="NomCompleto"></c:out>"
								maxlength="240" style="width: 150px !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="calidad"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="propiedad"></c:out>"
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