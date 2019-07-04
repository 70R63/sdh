<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<div class="row" style="margin-top: 50px !important">
		<div class="col-md-7">
			<div class="table-responsive">
				<table class="table" id="example">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="autorizado.consultas.tabla.secuencia" /> </label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="autorizado.consultas.tabla.tiparc" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="autorizado.consultas.tabla.idenvio" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"> <spring:theme
										code="autorizado.consultas.tabla.fecenvio" />
							</label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="autorizado.consultas.tabla.fecnoti" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"> <spring:theme
										code="autorizado.consultas.tabla.resultado" />
							</label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"> <spring:theme
										code="autorizado.consultas.tabla.reporte" />
							</label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input id="" name="" class="inputtextnew tablefechas"
								aria-required="true" type="text" readonly="readonly" value=""
								maxlength="240"></td>
							<td><input id="" name="" class="inputtextnew tablefechas"
								aria-required="true" type="text" readonly="readonly" value=""
								maxlength="240"></td>
							<td><input id="" name="" class="inputtextnew tablefechas"
								aria-required="true" type="text" readonly="readonly" value=""
								maxlength="240"></td>
							<td><input id="" name="" class="inputtextnew tablefechas"
								aria-required="true" type="text" readonly="readonly" value=""
								maxlength="240"></td>
							<td><input id="" name="" class="inputtextnew tablefechas"
								aria-required="true" type="text" readonly="readonly" value=""
								maxlength="240"></td>
							<td><input id="" name="" class="inputtextnew tablefechas"
								aria-required="true" type="text" readonly="readonly" value=""
								maxlength="240"></td>
							<td><label class="control-label labeltabletd tablefechas" style="color:#0000FF !importat; text-decoration: underline;"><spring:theme
										code="" /></label></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

