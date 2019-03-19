<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="headline">
			<h2>
				<span class="col-md-10 "><spring:theme
						code="ica.detalle.repesentantes.titulo" /></span>
			</h2>
		</div>
	</div>

<br>

<div class="row">
	<br>
	<div class="row col-md-12">
		<table class="table table-bordered" id="">
			<thead>
				<tr>
					<th><label class="control-label " for=""><spring:theme
								code="ica.detalle.repesentantes.tipiden" /></label></th>
					<th><label class="control-label " for=""> <spring:theme
								code="ica.detalle.repesentantes.numident" /></label></th>
					<th><label class="control-label " for=""> <spring:theme
								code="ica.detalle.repesentantes.nom" /></label></th>
					<th><label class="control-label " for=""> <spring:theme
								code="ica.detalle.repesentantes.tiprelacion" /></label></th>
					<th><label class="control-label " for=""> <spring:theme
								code="ica.detalle.repesentantes.fecdesde" /></label></th>
					<th><label class="control-label " for=""> <spring:theme
								code="ica.detalle.repesentantes.fechasta" /></label></th>
					<th><label class="control-label " for=""> <spring:theme
								code="ica.detalle.repesentantes.fuentdato" /></label></th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td><input id="action"
						style="visibility: visible !important; margin: 0; min-height: 0;"
						name="action" type="text" disabled></td>
					<td><input id="action"
						style=" width: 100%; visibility: visible !important; margin: 0; min-height: 0;"
						name="action" type="text" value='<c:out value=""></c:out>' disabled></td>
					<td><input id="action"
						style="width: 100%; visibility: visible !important; margin: 0; min-height: 0;"
						name="action" type="text" value='<c:out value=""></c:out>' disabled></td>
					<td><input id="action"
						style="width: 100%; visibility: visible !important; margin: 0; min-height: 0;"
						name="action" type="text" value='<c:out value=""></c:out>' disabled></td>
					<td><input id="action"
						style="width: 100%; visibility: visible !important; margin: 0; min-height: 0;"
						name="action" type="text" value='<c:out value=""></c:out>' disabled></td>
					<td><input id="action"
						style="width: 100%; visibility: visible !important; margin: 0; min-height: 0;"
						name="action" type="text" value='<c:out value=""></c:out>' disabled></td>
					<td><input id="action"
						style="width: 100%; visibility: visible !important; margin: 0; min-height: 0;"
						name="action" type="text" value='<c:out value=""></c:out>' disabled></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</div>






