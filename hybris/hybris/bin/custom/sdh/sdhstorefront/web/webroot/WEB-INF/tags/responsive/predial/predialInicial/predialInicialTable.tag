<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new_page">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="predial.inicial.table.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="predial.inicial.table.descripcion" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<form:form>
		<div class="row mt-3">
			<div class="col-md-10 d-flex align-items-center">
				<div class="table-responsive">
					<table class="table" id="example">
						<thead>
							<tr>
								<th><label class="control-label labeltabletd tableident"><spring:theme
											code="predial.inicial.table.chip" /></label></th>
								<th><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="predial.inicial.table.matinmo" /></label></th>
								<th><label class="control-label labeltabletd "><spring:theme
											code="predial.inicial.table.dir" /></label></th>
								<th><label class="control-label labeltabletd "><spring:theme
											code="predial.inicial.table.nocotrato" /></label></th>
								<th><label class="control-label labeltabletd "><spring:theme
											code="predial.inicial.table.detalle" /></label></th>
								<th><label class="control-label labeltabletd "><spring:theme
											code="predial.inicial.table.TotalPagar" /></label></th>
								<th><label class="control-label labeltabletd "><spring:theme
											code="predial.inicial.table.pagarEnLinea" /></label></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${predial.predial}" var="current">
								<c:set var="nombrePresentarDec" value="btnPresentarDec_${current.CHIP}"/>
								<c:set var="nombrePagarEnLinea" value="btnPagarEnLinea_${current.CHIP}"/>
								<c:set var="nombreTotalPagar" value="totalPagar_${current.CHIP}"/>
								<tr>
									<td><c:out value="${current.CHIP}" /></td>
									<td><c:out value="${current.matrInmobiliaria}" /></td>
									<td><c:out value="${current.direccionPredio}" /></td>
									<td><c:out value="${current.contratoArrenda}" /></td>
									<td>
										<button type="button" id="${nombrePresentarDec}"
											name="${nombrePresentarDec}" value="presentarDec" class="btn-primary"
											onclick="presentarDeclaracion('${current.CHIP}','${current.anioGravable}')">
											<spring:theme code="predial.inicial.table.presentarDeclaracion" />
										</button>
									</td>
									<td><label class="text-capitalize !important " id="${nombreTotalPagar}" hidden="true"></label>
									</td>
									<td>
										<button type="button" id="${nombrePagarEnLinea}"
											name="${nombrePagarEnLinea}" value="pagarEnLinea" class="btn-primary" hidden="true"
											onclick="pagarEnLinea('5101','${current.anioGravable}','','${current.numObjeto}','${current.CHIP}')">
											<spring:theme code="predial.inicial.table.pagarEnLinea" />
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</form:form>
</div>

<script>

</script>


