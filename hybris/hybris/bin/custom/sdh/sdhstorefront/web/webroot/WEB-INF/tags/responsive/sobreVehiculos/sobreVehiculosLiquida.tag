<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<sf:form>
	<div class="container">
		<div class="row">
			<div class="col-md-6 headline">
				<h2>
					<span><spring:theme code="sobre.vehiculo.liqui.title" /></span>
				</h2>
			</div>
		</div>


		<div class="row">
			<div class="col-md-3">
				<br>
				<table class="table">
					<thead>
						<tr>
						<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.liqui.anio" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.liqui.avaactual" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.liqui.tarfiactual" /></label></th>
						</tr>
					</thead>

					<tbody>
						<tr>
						<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Año"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Avalúo"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="" name="" class="inputtextnew" type="text"
								readonly="readonly" value="<c:out value="Tarifa"></c:out>"
								maxlength="240" style="width: 100% !important;"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<button  type="button" class="btn btn-secondary "
					id="" name="" value="regresar" onclick="goBack()">
					<spring:theme code="sobre.vehiculo.liqui.regresar" />
				</button>
			</div>
			<div class="col-md-4">
				<button  type="submit" class="btn btn-primary "
					id="" name="" value="regresar">
					<spring:theme code="sobre.vehiculo.liqui.descfactura" />
				</button>
			</div>
			<div class="col-md-4">

				<button type="submit" class="btn btn-primary "
					id="" name="" value="regresar">
					<spring:theme code="sobre.vehiculo.liqui.presdecla" />
				</button>
			</div>
		</div>

	</div>
</sf:form>