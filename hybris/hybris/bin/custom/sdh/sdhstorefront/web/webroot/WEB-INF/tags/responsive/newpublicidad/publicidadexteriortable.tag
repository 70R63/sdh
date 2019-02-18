<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/calculo" var="CalculodeclaracionUrl"
	htmlEscape="false" />


<div class="row">
	<div class="avisoheadline">
		<h2>
			<span class="p"><spring:theme code="publicidad.exterior.title"
					text="Publicidad Exterior" /></span>
		</h2>
	</div>
	<p class="avisobody">
		<spring:theme code="publicidad.exterior.description" />
	</p>
</div>

<br>

<sf:form>
	<div>
		<br>
		<div class="container">
			<div class="col-md-2">
				<label class="control-label "><spring:theme
						code="publicidad.exterior.typefence" /></label>
			</div>
			<div class="col-md-3">
				<input id="" name="" class="form-control form-control"
					aria-required="true" type="text" value="Valla tubular comercial"
					maxlength="240">
			</div>
		</div>

		<br>
		<div>
			<div class="row">
				<table class="table" id="example">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="publicidad.exterior.resolutionnumber" /></label></th>
							<th colspan="5" style="text-align: center"><label
								class="control-label" for=""> <spring:theme
										code="publicidad.exterior.tubular.address" /></label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td rowspan="5"><input id="action"
								style="visibility: visible !important; margin: 0; min-height: 0;"
								name="action" type="radio"
								style=" text-align: center !important; width: 100% !important; padding-left: 1px !important; padding-right: 1px !important">
								<span> Número de resolución</span></td>
							<td colspan="5"><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="direccion"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
						<tr bgcolor="#f2f2f2">
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.type" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.dateresolution" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.detail.Datenotification" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.detail.location" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.detail.postalcode" /></label></td>
						</tr>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="tipo solicitud"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="fecreolu"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="fecnotifi"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="localidad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="codpostal"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
						<tr bgcolor="#f2f2f2">
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.chip" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.propertyreg" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.conventional.visualorientation" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.detail.luminousnotices" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.conventional.elementlocation" /></label></td>
						</tr>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="CHIP"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="mat inmobiliaria"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="orientación"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="avisoluminoso"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="ubicación"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<br>
		<div class="container">
			<div class="col-md-2">
				<label class="control-label "><spring:theme
						code="publicidad.exterior.typefence" /></label>
			</div>
			<div class="col-md-3">
				<input id="" name="" class="form-control form-control"
					aria-required="true" type="text" value="Valla Vehículos"
					maxlength="240">
			</div>
		</div>

		<br>
		<div>
			<div class="row">
				<table class="table" id="">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="publicidad.exterior.resolutionnumber" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.detail.type" /></label></th>
							<th style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.dateresolution" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.detail.Datenotification" /></label></th>
							<th style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.vehicles.model" /></label></th>
							<th style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.vehicles.plate" /></label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td rowspan="5"><input id="action"
								style="visibility: visible !important; margin: 0; min-height: 0;"
								name="action" type="radio"
								style=" text-align: center !important; width: 100% !important; padding-left: 1px !important; padding-right: 1px !important">
								<span> Número de resolución</span></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="tipo solicitud"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="fecresolu"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="fecnotifi"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="modelo"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="placa"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
						<tr bgcolor="#f2f2f2">
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.vehicles.licensenumber" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.vehicles.typeservice" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.vehicles.typeadvertising" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.vehicles.typevehicle" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.conventional.visualorientation" /></label></td>
						</tr>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="num licencia"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="servicio"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="publicidad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="vehículo"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="orientación"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
					</tbody>
				</table>

			</div>
		</div>

		<br>
		<div class="container">
			<div class="col-md-2">
				<label class="control-label "><spring:theme
						code="publicidad.exterior.typefence" /></label>
			</div>
			<div class="col-md-3">
				<input id="" name="" class="form-control form-control"
					aria-required="true" type="text" value="Valla Tubular de obra"
					maxlength="240">
			</div>
		</div>

		<br>
		<div>
			<div class="row">
				<table class="table" id="">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="publicidad.exterior.resolutionnumber" /></label></th>
							<th colspan="5" style="text-align: center"><label
								class="control-label" for=""> <spring:theme
										code="publicidad.exterior.tubular.address" /></label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td rowspan="7"><input id="action"
								style="visibility: visible !important; margin: 0; min-height: 0;"
								name="action" type="radio"
								style=" text-align: center !important; width: 100% !important; padding-left: 1px !important; padding-right: 1px !important">
								<span> Número de resolución</span></td>
							<td colspan="5"><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="direccion"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
						<tr bgcolor="#f2f2f2">
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.type" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.dateresolution" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.detail.Datenotification" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.detail.location" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.detail.postalcode" /></label></td>
						</tr>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="tipo solicitud"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="fecreolu"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="fecnotifi"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="localidad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="codpostal"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
						<tr bgcolor="#f2f2f2">
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.chip" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.propertyreg" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.tubular.elementlocation" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.conventional.typeadvertising" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.tubular.visualorientation" /></label></td>
						</tr>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="CHIP"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="mat inmobiliaria"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="ubicación"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="tippublicidad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="orientacion"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
						<tr bgcolor="#f2f2f2">
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.conventional.workcontract" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.tubular.buildingpermit" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.conventional.totalarea" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.conventional.Periodicity" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.tubular.numberfaces" /></label></td>
						</tr>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="contrato"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="licencia"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="área"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="periodicidad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="numcaras"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<br>
		<div class="container">
			<div class="col-md-2">
				<label class="control-label "><spring:theme
						code="publicidad.exterior.typefence" /></label>
			</div>
			<div class="col-md-3">
				<input id="" name="" class="form-control form-control"
					aria-required="true" type="text" value="Valla de obra convencional"
					maxlength="240">
			</div>

		</div>

		<br>
		<div>
			<div class="row">
				<table class="table" id="">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="publicidad.exterior.resolutionnumber" /></label></th>
							<th colspan="6" style="text-align: center"><label
								class="control-label" for=""> <spring:theme
										code="publicidad.exterior.detail.locationaddress" /></label></th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td rowspan="5"><input id="action"
								style="visibility: visible !important; margin: 0; min-height: 0;"
								name="action" type="radio"
								style=" text-align: center !important; width: 100% !important; padding-left: 1px !important; padding-right: 1px !important">
								<span> Número de resolución</span></td>
							<td colspan="6"><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="direccion"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>

						</tr>
						<tr bgcolor="#f2f2f2">

							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.type" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.detail.dateresolution" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.detail.Datenotification" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.detail.location" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.detail.postalcode" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.conventional.iluminado" /></label></td>
						</tr>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="CHIP"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="mat inmobiliaria"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="ubicación"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="tippublicidad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="orientacion"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="iluminado"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
						<tr bgcolor="#f2f2f2">
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.conventional.CHIP" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.conventional.propertyregistration" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.conventional.elementlocation" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.conventional.typeadvertising" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.conventional.visualorientation" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.conventional.totalarea" /></label></td>
						</tr>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="chip"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="matricula"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="ubicación"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="tipo"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="orientación"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="área"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
					</tbody>
				</table>

			</div>
		</div>


		<br>
		<div class="container">
			<div class="col-md-2">
				<label class="control-label "><spring:theme
						code="publicidad.exterior.typefence" /></label>
			</div>
			<div class="col-md-3">
				<input id="" name="" class="form-control form-control"
					aria-required="true" type="text" value="Pantalla LED"
					maxlength="240">
			</div>
		</div>

		<br>
		<div>
			<div class="row">
				<table class="table" id="">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="publicidad.exterior.led.numresolución" /></label></th>
							<th colspan="6" style="text-align: center"><label
								class="control-label" for=""> <spring:theme
										code="publicidad.exterior.led.direccion" /></label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td rowspan="5"><input id="action"
								style="visibility: visible !important; margin: 0; min-height: 0;"
								name="action" type="radio"
								style=" text-align: center !important; width: 100% !important; padding-left: 1px !important; padding-right: 1px !important">
								<span> Número de resolución</span></td>
							<td colspan="6"><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="direccion"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
						<tr bgcolor="#f2f2f2">

							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.led.tipsolicitud" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.led.fecresol" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.led.fecnotifica" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme code="publicidad.exterior.led.loc" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.led.codpostal" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.led.area" /></label></td>
						</tr>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="CHIP"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="mat inmobiliaria"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="ubicación"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="tippublicidad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="orientacion"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="área"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
						<tr bgcolor="#f2f2f2">
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.led.chip" /></label></td>
							<td style="text-align: center"><label class="control-label"><spring:theme
										code="publicidad.exterior.led.matinmobi" /></label></td>
							<td style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="publicidad.exterior.led.ubica" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.led.tippubli" /></label></td>
							<td style="text-align: center"><label class="control-label "
								for=""> <spring:theme
										code="publicidad.exterior.led.orvisual" /></label></td>
						</tr>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="chip"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="matricula"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="ubicación"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="tipo"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="orientación"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<br>
		<div class="row">
			<div class="col-md-6 headline">
				<h2>
					<span><spring:theme
							code="publicidad.exterior.detail.outdooradvertising" /></span>
				</h2>
			</div>
		</div>

		<br>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="publicidad.exterior.detail.selectYear" /></label>
				</div>
			</div>
			<div class="col-md-2">
				<select id="an" class="form-control " name=" " onchange=" ">
					<option value="2019">2019</option>
					<option value="2018">2018</option>
					<option value="2017">2017</option>
					<option value="2016">2016</option>
				</select>
			</div>


			<div class="col-md-3">
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block" id=""
						name="" value="buscar">
						<spring:theme code="publicidad.exterior.detail.search" />
					</button>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-3 col-md-offset-5 center">
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block" id=""
						name="" value="regresar">
						<spring:theme code="publicidad.exterior.detail.return" />
					</button>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block" id=""
						name="" value="declaracion">
						<spring:theme code="publicidad.exterior.detail.presdecla" />
					</button>
				</div>
			</div>
		</div>

	</div>
</sf:form>
