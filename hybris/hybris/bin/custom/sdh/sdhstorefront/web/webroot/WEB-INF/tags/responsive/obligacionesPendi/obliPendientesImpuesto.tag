<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<sf:form>
	<div class="container">
		<div id="impuest" style="display: none;">
			<input id="Idimp" value="">
		</div>
		<br>

		<div id="table-predial" style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.predial.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th><label class="control-label labeltabletd"><spring:theme
											code="obligacion.inicial.predio.chip" /></label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="obligacion.inicial.predio.matricula" />
								</label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="obligacion.inicial.predio.direccion" />
								</label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="obligacion.inicial.predio.visualizar" /></label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="CHIP"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="Matricula"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="Direccion"></c:out>" /></td>
								<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: none; color: #0358d8 !important"
									id="">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>


		<div id="table-vehiculos" style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.vehiculos.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead>
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="obligacion.inicial.vehiculo.placa" /></label></th>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="obligacion.inicial.vehiculo.modelo" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.vehiculo.marca" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.vehiculo.linea" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.vehiculo.visualizar" />
								</label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><label class="form-check-label inputtextnew"
									style="text-transform: capitalize !important"> <input
										type="radio" name="placa" id="" class="form-check-input mr-2"
										style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
										<c:out value="placa" />
								</label></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="PLACA"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="MARCA"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="MARCA"></c:out>" /></td>
								<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>


		<div id="table-ica" style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.ica.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead>
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="obligacion.inicial.ica.tipdocu" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.ica.numdocu" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.ica.visualizar" />
								</label></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="TIPO DOCUMENTO"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="NUM DOCUMENTO"></c:out>" /></td>
								<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div id="table-publicidad" style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.publiext.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="obligacion.inicial.publicidad.numresol" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.publicidad.tipvalla" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.publicidad.visualizar" />
								</label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="RESOLUCION"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="TIPO VALLA"></c:out>" /></td>
								<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div id="table-gasolina" style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.gasolina.titulo" /></span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="obligacion.inicial.gasolina.tipiden" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.gasolina.numiden" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.gasolina.visualizar" />
								</label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="identificación"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="numero"></c:out>" /></td>
								<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div id="table-delineacion" style="display: none;">
		<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.delurbana.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="obligacion.inicial.delineacion.cdu" /></label></th>
								<th><label class="control-label labeltabletd" for=""> <spring:theme
											code="obligacion.inicial.delineacion.licconstr" /></label></th>
								<th><label class="control-label labeltabletd" for=""> <spring:theme
											code="obligacion.inicial.delineacion.direccion" /></label></th>
								<th><label class="control-label labeltabletd" for=""> <spring:theme
											code="obligacion.inicial.delineacion.visualizar" /></label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="cdu"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="licencia"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="direccion"></c:out>" /></td>
								<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</sf:form>
