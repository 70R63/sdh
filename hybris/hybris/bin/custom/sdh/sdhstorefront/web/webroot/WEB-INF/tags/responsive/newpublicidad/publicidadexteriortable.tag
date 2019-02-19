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
		<c:if test="${not empty allDetailsMap['Valla Tubular Comercial'] }">
		
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
		</c:if>
		<div>
			<div class="row">
				<c:forEach items="${ allDetailsMap['Valla Tubular Comercial']}" var="eachValla">
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
								<td rowspan="5">
									<input id="action"
									style="visibility: visible !important; margin: 0; min-height: 0;"
									name="action" type="radio" data-tipoValla="Valla Tubular Comercial" data-numRes="${eachValla.numResolu}"
									style=" text-align: center !important; width: 100% !important; padding-left: 1px !important; padding-right: 1px !important">
									<span>${eachValla.numResolu}</span></td>
								<td colspan="5"><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly" 
									value="<c:out value="${ eachValla.direccion}"></c:out>" maxlength="240"
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
									value="${ eachValla.tipoSolicitud}" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${ eachValla.fechResolu}" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${ eachValla.fechNotif}" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew localidad"
									aria-required="true" type="text" readonly="readonly"
									value="${ eachValla.localidad}" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${ eachValla.codPostal}" maxlength="240"
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
									value="${ eachValla.chip}" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${ eachValla.matricula}" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${ eachValla.orientacion}" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${ eachValla.avisoLumino}" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${ eachValla.ubicacion}" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							</tr>
						</tbody>
					</table>
				</c:forEach>
			</div>
		</div>
		<c:if test="${not empty allDetailsMap['Valla Vehículos'] }">
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
		</c:if>
		<div>
			<div class="row">
				<c:forEach items="${ allDetailsMap['Valla Vehículos']}" var="eachValla">
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
									name="action" type="radio" data-tipoValla="Valla Vehículos" data-numRes="${eachValla.numResolu }"
									style=" text-align: center !important; width: 100% !important; padding-left: 1px !important; padding-right: 1px !important">
									<span> ${eachValla.numResolu }</span></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.tipoSolicitud }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.fechResolu }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.fechNotif }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.modelo }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.placa }" maxlength="240"
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
									value="${eachValla.numLicenciaTrans }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.tipoServicio }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.tipoPublici }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.tipoElemento }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.orientacion }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							</tr>
						</tbody>
					</table>
				</c:forEach>
			</div>
		</div>
		<c:if test="${not empty allDetailsMap['Valla Tubular de Obra'] }">
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
		</c:if>
		<div>
			<div class="row">
				<c:forEach items="${ allDetailsMap['Valla Tubular de Obra']}" var="eachValla">
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
									name="action" type="radio" data-tipoValla="Valla Tubular de Obra" data-numRes="${eachValla.numResolu }"
									style=" text-align: center !important; width: 100% !important; padding-left: 1px !important; padding-right: 1px !important">
									<span> ${eachValla.numResolu }</span></td>
								<td colspan="5"><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.direccion }" maxlength="240"
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
									value="${eachValla.tipoSolicitud }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.fechResolu }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.fechNotif }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew localidad"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.localidad }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.codPostal }" maxlength="240"
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
									value="${eachValla.chip }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.matricula }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.ubicacion }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.tipoPublici }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.orientacion }" maxlength="240"
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
									value="${eachValla.contratoObra }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.licenciaConstruc }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.areaTotal }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.periodicidad }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.numCaras }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							</tr>
						</tbody>
					</table>
				</c:forEach>
			</div>
		</div>
		<c:if test="${not empty allDetailsMap['Valla de Obra Convencional'] }">
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
		</c:if>
		<div>
			<div class="row">
				<c:forEach items="${ allDetailsMap['Valla de Obra Convencional']}" var="eachValla">
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
									name="action" type="radio" data-tipoValla="Valla de Obra Convencional" data-numRes="${eachValla.numResolu }"
									style=" text-align: center !important; width: 100% !important; padding-left: 1px !important; padding-right: 1px !important">
									<span> ${eachValla.numResolu}</span></td>
								<td colspan="6"><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.direccion }" maxlength="240"
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
									value="${eachValla.tipoSolicitud }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.fechResolu }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.fechNotif }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew localidad"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.localidad }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.codPostal }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.avisoLumino }" maxlength="240"
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
									value="${eachValla.chip }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.matricula }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.ubicacion }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.tipoPublici }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.orientacion }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.areaTotal }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							</tr>
						</tbody>
					</table>
				</c:forEach>
			</div>
		</div>

		<c:if test="${not empty allDetailsMap['Pantalla LED'] }">
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
		</c:if>
		<div>
			<div class="row">
				<c:forEach items="${ allDetailsMap['Pantalla LED']}" var="eachValla">
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
									name="action" type="radio" data-tipoValla="Pantalla LED" data-numRes="${eachValla.numResolu }"
									style=" text-align: center !important; width: 100% !important; padding-left: 1px !important; padding-right: 1px !important">
									<span>${eachValla.numResolu }</span></td>
								<td colspan="6"><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.direccion }" maxlength="240"
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
									value="${eachValla.chip }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.fechResolu }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.fechNotif }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew localidad"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.localidad }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.codPostal }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.areaTotal }" maxlength="240"
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
									value="${eachValla.chip }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.matricula }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.ubicacion }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.tipoPublici }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="${eachValla.orientacion }" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							</tr>
						</tbody>
					</table>
				</c:forEach>
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
				<select id="anio" class="form-control " name="anio">
					<c:forEach items="${years}" var="eachYear">
						<c:set var="selected" value=""></c:set>
						<c:if test="${eachYear eq selectedYear }">
							<c:set var="selected" value="selected"></c:set>
						</c:if>
						<option value="${eachYear}" ${selected}>${eachYear}</option>
					</c:forEach>
				</select>
			</div>


			<div class="col-md-3">
				<div class="form-group">
					<button type="button" class="btn btn-primary btn-block" id="searchByYearButton"
						name="searchByYearButton" value="buscar">
						<spring:theme code="publicidad.exterior.detail.search" />
					</button>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-3 col-md-offset-5 center">
				<div class="form-group">
					<button type="button" class="btn btn-primary btn-block" id="backButton"
						name="backButton" value="regresar" onclick="window.location.href ='<c:url value='/contribuyentes/sobretasa-gasolina' />';">
						<spring:theme code="publicidad.exterior.detail.return" />
					</button>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<button type="button" class="btn btn-primary btn-block" id="presentarDeclaracionButton"
						name="presentarDeclaracionButton" value="declaracion">
						<spring:theme code="publicidad.exterior.detail.presdecla" />
					</button>
				</div>
			</div>
		</div>

	</div>
</sf:form>
