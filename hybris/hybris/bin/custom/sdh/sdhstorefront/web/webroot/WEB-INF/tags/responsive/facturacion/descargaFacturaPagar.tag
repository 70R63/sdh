<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ attribute name="mostrarBotonCertiRit" required="false" type="java.lang.Boolean"%>


<c:set var="flagCertiRit" value="" />
<c:if test="${mostrarBotonCertiRit == true}">
	<c:set var="flagCertiRit" value="true" />
</c:if>


<spring:htmlEscape defaultHtmlEscape="true" />


<div class="impuestoPopUp" style="display: none;">
	<div class="js-0001-facet" id="js-0001-facet">
		<div class="facet js-facet-0001">
			<div class="facet__name js-facet-name-0001">
				<table class="table pagarImpuesto">
					<thead>
						<tr>
							<th><label class="control-label labeltabletd "><spring:theme code="Concepto" /></label></th>
							<th><label class="control-label labeltabletd "><spring:theme code="Número de referencia" /></label></th>
							<th><label class="control-label labeltabletd "><spring:theme code="Monto" /></label></th>
							<th><label class="control-label labeltabletd "><spring:theme code="Pagar" /></label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label class="control-label labeltabletd "><spring:theme code="Información no disponible" /></label></td>
							<td><label class="control-label labeltabletd "><spring:theme code="Información no disponible" /></label></td>
							<td><label class="control-label labeltabletd "><spring:theme code="Información no disponible" /></label></td>
							<td><label class="control-label labeltabletd "><spring:theme code="Información no disponible" /></label></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>











