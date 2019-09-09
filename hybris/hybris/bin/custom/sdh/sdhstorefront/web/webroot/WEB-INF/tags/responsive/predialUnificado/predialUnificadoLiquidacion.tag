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
				<span><spring:theme
						code="predial.unificado.liquidacion.title" /></span>
			</h2>
		</div>
	</div>

	<div class="container">
		<div>
			<div class="col-md-6">
				<table class="table">
					<thead>
						<tr>
							<th><label class="control-label labeltabletd"><spring:theme
										code="predial.unificado.liquidacion.basgrav" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="predial.unificado.liquidacion.desthacen" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="predial.unificado.liquidacion.tarif" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="predial.unificado.liquidacion.valimp" /></label></th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="base"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="destino"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="tarifa"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="impuesto"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
						</tr>
					</tbody>
				</table>

			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="predial.unificado.liquidacion.leyenda1" /></label> <label
					class="control-label "><spring:theme
						code="predial.unificado.liquidacion.leyenda2" /></label> <label
					class="control-label "><spring:theme
						code="predial.unificado.liquidacion.leyenda3" /></label>
			</div>
		</div>
	</div>
</sf:form>