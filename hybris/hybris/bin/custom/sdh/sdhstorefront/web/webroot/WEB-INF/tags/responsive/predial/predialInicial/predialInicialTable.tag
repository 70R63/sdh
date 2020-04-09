<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new_page">
	<c:if test="${Error != null}">
		<div class="row">
			<div class="col-12 notas_deli">
				<div class="alert alert-danger mt-3">
					<spring:theme code="${Error}" />
				</div>
			</div>
		</div>
	</c:if>
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
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${predial.predial}" var="current">
								<c:choose>
									<c:when
										test="${current.CHIP != '' && current.matrInmobiliaria != ''}">
										<tr>
											<td><c:out value="${current.CHIP}" /></td>
											<td><c:out value="${current.matrInmobiliaria}" /></td>
											<td><c:out value="${current.direccionPredio}" /></td>
											<td><c:out value="${current.contratoArrenda}" /></td>
											<td><label style="color: #0358d8 !important"
												data-anioGravable="${current.anioGravable}"
												data-CHIP="${current.CHIP}"
												data-matrInmobiliaria="${current.matrInmobiliaria}"
												class="text-capitalize !important showDetailPredio"
												id="showDetailPredio"
												onclick="showDetailPredio('${current.anioGravable}','${current.CHIP}','${current.matrInmobiliaria}')">
													<spring:theme code="predial.inicial.table.ver" />
											</label></td>
										</tr>
									</c:when>
									<c:when
										test="${current.CHIP != '' && current.matrInmobiliaria == ''}">
										<tr>
											<td><c:out value="${current.CHIP}" /></td>
											<td><c:out value="${current.matrInmobiliaria}" /></td>
											<td><c:out value="${current.direccionPredio}" /></td>
											<td><c:out value="${current.contratoArrenda}" /></td>
											<td><label style="color: #0358d8 !important"
												data-anioGravable="${current.anioGravable}"
												data-CHIP="${current.CHIP}"
												data-matrInmobiliaria="${current.matrInmobiliaria}"
												class="text-capitalize !important showDetailPredio"
												id="showDetailPredio"
												onclick="showDetailPredio('${current.anioGravable}','${current.CHIP}','${current.matrInmobiliaria}')">
													<spring:theme code="predial.inicial.table.ver" />
											</label></td>
										</tr>
									</c:when>
									<c:when
										test="${current.CHIP == '' && current.matrInmobiliaria != ''}">
										<tr>
											<td><c:out value="${current.CHIP}" /></td>
											<td><c:out value="${current.matrInmobiliaria}" /></td>
											<td><c:out value="${current.direccionPredio}" /></td>
											<td><c:out value="${current.contratoArrenda}" /></td>
											<td><label style="color: #0358d8 !important"
												data-anioGravable="${current.anioGravable}"
												data-CHIP="${current.CHIP}"
												data-matrInmobiliaria="${current.matrInmobiliaria}"
												class="text-capitalize !important showDetailPredio"
												id="showDetailPredio"
												onclick="showDetailPredio('${current.anioGravable}','${current.CHIP}','${current.matrInmobiliaria}')">
													<spring:theme code="predial.inicial.table.ver" />
											</label></td>
										</tr>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
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


