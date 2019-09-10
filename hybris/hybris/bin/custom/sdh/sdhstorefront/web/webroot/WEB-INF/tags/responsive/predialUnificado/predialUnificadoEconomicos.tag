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
				<span><spring:theme code="predial.unificado.economicos.title" /></span>
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
							<th><label class="control-label labeltabletd"><spring:theme
										code="predial.unificado.economicos.avexclu" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="predial.unificado.economicos.avcontra" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="predial.unificado.economicos.avindi" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="predial.unificado.economicos.avmejora" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="predial.unificado.economicos.avresinocupa" /></label></th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Exclusión Parcial"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Arriendo"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Edificabilidad"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Mejora"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Ocupación"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</sf:form>