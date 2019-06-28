<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new">
	<div class="row">

		<div class="col-md-12">
			<div class="table-responsive">
				<table class="table" id="example">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th style="text-align: center"><label
								class="control-label labeltabletd"><spring:theme
										code="delineacion.urbana.CDU" /> </label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd"><spring:theme
										code="delineacion.urbana.basic.Liceconstruction" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="delineacion.urbana.basic.fechrexpe" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"> <spring:theme
										code="delineacion.urbana.basic.fechaInicioObra" />
							</label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd"><spring:theme
										code="delineacion.urbana.basic.numResolucionRevalidacion" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="delineacion.urbana.basic.fechrevalida" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd"> <spring:theme
										code="delineacion.urbana.basic.totalPresupuesto" />
							</label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd"><spring:theme
										code="delineacion.urbana.basic.valorEjecutado" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd"><spring:theme
										code="delineacion.urbana.basic.tipomarca" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="delineacion.urbana.basic.fechfinobra" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd"> <spring:theme
										code="delineacion.urbana.basic.curaduria" />
							</label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd"> <spring:theme
										code="delineacion.urbana.basic.detalleRadicado" />
							</label></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${dataForm.valCont.delineacion}"
							var="delineacion">
							<c:if test="${delineacion.cdu != ''}">
								<tr>
									<td><input id="CDU" name="" class="inputtextnew tableident"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.cdu}" maxlength="240"
										style="width: 81px !important; padding-left: 1px !important; padding-right: 1px !important;"></td>
									<td><input id="" name="" class="inputtextnew"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.licenConst}" maxlength="240"
										style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
									<td><input id="" name="" class="inputtextnew tablefechas"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.fechaExp}" maxlength="240"></td>
									<td><input id="" name="" class="inputtextnew tablefechas"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.fechaEjecutoria}" maxlength="240"></td>
									<td><input id="" name="" class="inputtextnew"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.nroResolucReva}" maxlength="240"
										style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
									<td><input id="" name="" class="inputtextnew"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.fechaReval}" maxlength="240"
										style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
									<td><input id="" name="" class="inputtextnew"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.totalPresup}" maxlength="240"
										style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
									<td><input id="" name="" class="inputtextnew"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.valorEjecut}" maxlength="240"
										style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
									<td><input id="" name="" class="inputtextnew"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.tipoMarca}" maxlength="240"
										style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
									<td><input id="" name="" class="inputtextnew tablefechas"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.fechFinObra}" maxlength="240"></td>
									<td><input id="" name="" class="inputtextnew"
										aria-required="true" type="text" readonly="readonly"
										value="${delineacion.curaduria}" maxlength="240"
										style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
									<td><label style="color: #0358d8 !important"
										data-cdu="${delineacion.cdu}"
										class="text-capitalize !important label1Ver "><spring:theme
												code="publicidad.exterior.ver" /></label></td>

								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

