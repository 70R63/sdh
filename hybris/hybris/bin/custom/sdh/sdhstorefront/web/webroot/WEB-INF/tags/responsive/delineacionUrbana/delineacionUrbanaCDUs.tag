<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />


<div>
	<br>
	<div class="col-md-4">
		<div class="col-md-6">
			<spring:theme code="delineacion.urbana.dec.generales.anigrav" />
			<c:out value="${docNumber}" />
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<table class="table" id="example">
			<thead style="background-color: #006DCC !important">
				<tr>
					<th style="text-align: center"><label class="control-label "><spring:theme
								code="delineacion.urbana.CDU" /> </label></th>
					<th style="text-align: center"><label class="control-label"><spring:theme
								code="delineacion.urbana.basic.Liceconstruction" /></label></th>
					<th style="text-align: center"><label class="control-label"><spring:theme
								code="delineacion.urbana.basic.fechrexpe" /></label></th>
					<th style="text-align: center"><label class="control-label"><spring:theme
								code="delineacion.urbana.basic.numResolucionRevalidacion" /></label></th>
					<th style="text-align: center"><label class="control-label"><spring:theme
								code="delineacion.urbana.basic.fechrevalida" /></label></th>
					<th style="text-align: center"><label class="control-label">
							<spring:theme code="delineacion.urbana.basic.totalPresupuesto" />
					</label></th>
					<th style="text-align: center"><label class="control-label"><spring:theme
								code="delineacion.urbana.basic.valorEjecutado" /></label></th>
					<th style="text-align: center"><label class="control-label"><spring:theme
								code="delineacion.urbana.basic.tipomarca" /></label></th>
					<th style="text-align: center"><label class="control-label">
							<spring:theme code="delineacion.urbana.basic.fechaInicioObra" />
					</label></th>
					<th style="text-align: center"><label class="control-label"><spring:theme
								code="delineacion.urbana.basic.fechfinobra" /></label></th>
					<th style="text-align: center"><label class="control-label">
							<spring:theme code="delineacion.urbana.basic.curaduria" />
					</label></th>
					<th style="text-align: center"><label class="control-label">
							<spring:theme code="delineacion.urbana.basic.codigoEstrato" />
					</label></th>
					<th style="text-align: center"><label class="control-label">
							<spring:theme code="delineacion.urbana.basic.detalleRadicado" />
					</label></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input id="CDU" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important;"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 150px !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><input id="" name="" class="inputtextnew"
						aria-required="true" type="text" readonly="readonly"
						value="${docNumber}" maxlength="240"
						style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
					<td><a onclick="show()" href="">Ver</a></td>

				</tr>
			</tbody>
		</table>
	</div>
</div>


