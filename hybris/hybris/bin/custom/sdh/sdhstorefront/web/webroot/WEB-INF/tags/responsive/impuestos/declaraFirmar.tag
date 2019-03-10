<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/contribuyentes/presentar-declaracion"
	var="presentarDeclaracionUrl" htmlEscape="false" />



<div class="container">
	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme code="declarafirma.inicial.titulo" /></span>

			</h2>
		</div>
	</div>

	<div class="col-md-10 col-md-offset-2">
		<div class="row">

			<div class="col-md-6 col-md-offset-3">
				<table class="table">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme code="declarafirma.inicial.declara" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="declarafirma.inicial.anigrav" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="declarafirma.inicial.periodo" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="declarafirma.inicial.seleccionar" /></label></th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td><input style="width: 100%" class="inputtextnew"
								maxlength="30" size="30" disabled="disabled" type="text"
								value="<c:out value="# Declaracion"></c:out>" /></td>
							<td><input style="width: 100%" class="inputtextnew"
								maxlength="30" size="30" disabled="disabled" type="text"
								value="<c:out value="Año Gravable"></c:out>" /></td>
							<td><input style="width: 100%" class="inputtextnew"
								maxlength="30" size="30" disabled="disabled" type="text"
								value="<c:out value="Periodo"></c:out>" /></td>
							<td><input class="inputtextnew"
								style="visibility: visible !important; width: 15px" type="radio"
								id="" name="" value=""></td>

						</tr>
					</tbody>
				</table>
			</div>

			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<sf:button action="${presentarDeclaracionUrl}" type="submit"
						class="btn btn-primary btn-lg" id="action" name="action"
						value="presentarDeclaracion" style="width: 187px !important">
						<spring:theme
							code="impuestos.presentarDeclaracion.PresentarDeclaracion" />
					</sf:button>
				</div>
			</div>
		</div>
	</div>
</div>
<br>