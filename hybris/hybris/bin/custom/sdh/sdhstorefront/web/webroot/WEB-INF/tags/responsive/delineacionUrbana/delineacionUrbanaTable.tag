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
	<div class="row">
		<div class="avisoheadline">
			<h3>
				<span class="p"><spring:theme code="delineacion.urbana.title"
						text="Delineacion Urbana" /></span>
			</h3>
		</div>
		<p class="avisobody">
			<spring:theme code="delineacion.urbana.desciption" />
		</p>
	</div>
</div>


<sf:form>
	<div>
		<br>
		<div class="container">
			<div class="col-md-1">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.anigrav" /></label>
			</div>
			<div class="col-md-2">
				<select id="an" class="form-control " name=" " onchange=" " disabled>
					<option value="2019">2019</option>
					<option value="2018">2018</option>
					<option value="2017">2017</option>
					<option value="2016">2016</option>
				</select>
			</div>

			<div class="col-md-1">

				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.periodo" /></label>
			</div>
			<div class="col-md-2">
				<select id="period" class="form-control" name="periodo" onchange=""
					disabled>
					<option value="Enero">Enero</option>
					<option value="Febrero">Febrero</option>
					<option value="Marzo">Marzo</option>
					<option value="Abril">Abril</option>
					<option value="Mayo">Mayo</option>
					<option value="Junio">Junio</option>
					<option value="Julio">Julio</option>
					<option value="Agosto">Agosto</option>
					<option value="Septiembre">Septiembre</option>
					<option value="Octubre">Octubre</option>
					<option value="Noviembre">Noviembre</option>
					<option value="Diciembre">Diciembre</option>

				</select>
			</div>
		</div>

		<br> <br>
		<div>
			<div class="row">


				<table class="table" id="">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme code="delineacion.urbana.CDU" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="delineacion.urbana.adicionales.chip" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="delineacion.urbana.adicionales.matinmo" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="delineacion.urbana.detail.direc" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="delineacion.urbana.adicionales.codpostal" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="delineacion.urbana.adicionales.localidad" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="delineacion.urbana.adicionales.estrato" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="delineacion.urbana.adicionales.tipunidad" /></label></th>
							<th style="text-align: center"><label class="control-label"><spring:theme
										code="delineacion.urbana.basic.Liceconstruction" /></label></th>
							<th style="text-align: center"><label class="control-label"><spring:theme
										code="delineacion.urbana.basic.numresolurevalida" /></label></th>
							<th style="text-align: center"><label class="control-label"><spring:theme
										code="delineacion.urbana.basic.numresoprorroga" /></label></th>
							<th style="text-align: center"><label class="control-label"><spring:theme
										code="delineacion.urbana.basic.fechrexpe" /></label></th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td rowspan="3"><input id="CDU" name="" class="inputtextnew"
								aria-required="true" type="text" disabled
								value="<c:out value="CDU-11111"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important; height: 144px; padding-top: 6px; border-top-width: -;"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="CHIP-111111"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="matricula"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="Tv 1a 55-73"></c:out>" maxlength="240"
								style="width: 150px !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="CódigoP"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="Localidad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="Estrato"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="UnidadConstruir"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="Licencia"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="revalidacion"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="Prorroga"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="12/09/1990"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
						<tr bgcolor="#f2f2f2">

							<td style="text-align: center"><label class="control-label"><spring:theme
										code="delineacion.urbana.basic.fechfinobra" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="delineacion.urbana.basic.fechresolprorroga" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="delineacion.urbana.adicionales.direcobra" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="delineacion.urbana.basic.fechradicado" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="delineacion.urbana.basic.modaLicencia" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="delineacion.urbana.basic.tipomarca" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="delineacion.urbana.basic.marca" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="delineacion.urbana.basic.numradicado" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="delineacion.urbana.basic.fechrevalida" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="delineacion.urbana.adicionales.cantunida" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="delineacion.urbana.adicionales.areaunidad" /></label></td>

						</tr>

						<tr>

							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="12/09/1990"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="12/09/1990"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="Derecobra"></c:out>" maxlength="240"
								style="width: 150px !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="12/09/1990"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="Modalidad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="tipomarca"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="marca"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="numradicado"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="12/09/1990"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="cant-unidades"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="area-unidad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>

					</tbody>
				</table>

			</div>
			<div class="row">
				<div class="col-md-3 col-md-offset-9 center">
					<div class="form-group">
						<button action="/contribuyentes/delineacionurbana/declaracion"
							type="submit" class="btn btn-primary btn-block" id="" name=""
							value="declarar">
							<spring:theme code="delineacion.urbana.declaration" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</sf:form>
