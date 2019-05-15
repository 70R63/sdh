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
		<div class="row">
			<div class="col-md-3" id="idImpuesto">
				<div class="form-group">
					<label class="control-label required"><spring:theme
							code="obligacion.inicial.selcimpuesto" /></label> <select
						required="required" required id="impuesto" class="form-control "
						name="impuesto" onchange="Selected(this)">
						<option value="">Seleccionar</option>
						<option value="1">Predial Unificado</option>
						<option value="2">Vehículos</option>
						<option value="3">ICA</option>
						<option value="4">Publicidad Exterior</option>
						<option value="5">Sobretasa Gasolina</option>
						<option value="6">Delineación Urbana</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 text-center">
				<div class="form-group ">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="cancelar" style="margin-top: 3px">
						<spring:theme code="obligacion.inicial.cancelar" />
					</button>

					<button type="button" class="btn btn-primary btn-lg" id="action"
						name="action" value="buscar" style="margin-top: 3px"
						onclick=" Selectedver(this)">
						<spring:theme code="obligacion.inicial.buscar" />
					</button>
				</div>
			</div>
		</div>

		<div id="impuest" style="display: none;">
			<input id="Idimp" value="">
		</div>
		<br>

		<div id="table-predial" style="display: none;">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th style="text-align: center"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.predio.chip" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.predio.matricula" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.predio.direccion" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
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
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 text-center">

					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.inicial.predio.pdf" />
					</button>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.predio.aniograv" /></label> <select
							aria-required="true" id="aniograva" class="form-control "
							name="aniograva" onchange="">
							<option value="">Seleccionar</option>
							<option value="2019">2019</option>
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
						</select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.predio.fecreporte" /></label> <input
							type="text" class="form-control ">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead style="background-color: #006DCC !important">
								<tr>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.predial.chip" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.predial.aniograv" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.predial.edoobliga" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.predial.obligacion" /> </label></th>

									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.predial.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"
										style="text-transform: capitalize !important"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="1234" />
									</label></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


		<div id="table-vehiculos" style="display: none;">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead>
							<tr>
								<th style="text-align: center; width: 116px !important"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.vehiculo.placa" /></label></th>
								<th style="text-align: center"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.vehiculo.modelo" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.vehiculo.marca" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.vehiculo.linea" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.vehiculo.visualizar" /></label></th>
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
			<div class="row">
				<div class="col-md-12 text-center">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.inicial.vehiculo.pdf" />
					</button>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.vehiculo.aniograv" /></label> <select
							aria-required="true" id="aniograva" class="form-control "
							name="aniograva" onchange="">
							<option value="">Seleccionar</option>
							<option value="2019">2019</option>
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
						</select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.vehiculo.fecreporte" /></label> <input
							type="text" class="form-control ">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead style="background-color: #006DCC !important">
								<tr>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.vehiculos.aniograv" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.vehiculos.edoobliga" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.vehiculos.obligacion" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.vehiculos.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


		<div id="table-ica" style="display: none;">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead>
							<tr>
								<th style="text-align: center"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.ica.tipdocu" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.ica.numdocu" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.ica.visualizar" /></label></th>
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
			<div class="row">
				<div class="col-md-12 text-center">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.inicial.ica.pdf" />
					</button>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.ica.aniograv" /></label> <select
							aria-required="true" id="aniograva" class="form-control "
							name="aniograva" onchange="">
							<option value="">Seleccionar</option>
							<option value="2019">2019</option>
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
						</select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.ica.fecreporte" /></label> <input type="text"
							class="form-control ">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead style="background-color: #006DCC !important">
								<tr>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.aniograv" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.periodo" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.edoobliga" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.obligacion" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div id="table-publicidad" style="display: none;">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th style="text-align: center"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.publicidad.numresol" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.publicidad.tipvalla" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.publicidad.visualizar" /></label></th>
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
			<div class="row">
				<div class="col-md-12 text-center">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.inicial.publicidad.pdf" />
					</button>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.publicidad.aniograv" /></label> <select
							aria-required="true" id="aniograva" class="form-control "
							name="aniograva" onchange="">
							<option value="">Seleccionar</option>
							<option value="2019">2019</option>
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
						</select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.publicidad.fecreporte" /></label> <input
							type="text" class="form-control ">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead style="background-color: #006DCC !important">
								<tr>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.publiext.noresol" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.publiext.dirvalla" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.publiext.orvalla" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.publiext.aniograv" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.publiext.edoobliga" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.publiext.obligacion" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.publiext.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"
										style="text-transform: capitalize !important"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="1234" />
									</label></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div id="table-gasolina" style="display: none;">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th style="text-align: center"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.gasolina.tipiden" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.gasolina.numiden" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.gasolina.visualizar" /></label></th>
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
			<div class="row">
				<div class="col-md-12 text-center">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.inicial.gasolina.pdf" />
					</button>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.gasolina.aniograv" /></label> <select
							aria-required="true" id="gasolina" class="form-control "
							name="aniograva" onchange="">
							<option value="">Seleccionar</option>
							<option value="2019">2019</option>
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
						</select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.gasolina.fecreporte" /></label> <input
							type="text" class="form-control ">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead style="background-color: #006DCC !important">
								<tr>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.aniograv" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.periodo" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.edoobliga" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.obligacion" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div id="table-delineacion" style="display: none;">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th style="text-align: center"><label
									class="control-label " for=""><spring:theme
											code="obligacion.inicial.delineacion.cdu" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.delineacion.licconstr" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="obligacion.inicial.delineacion.direccion" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
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
			<div class="row">
				<div class="col-md-12 text-center">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.inicial.gasolina.pdf" />
					</button>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.gasolina.aniograv" /></label> <select
							aria-required="true" id="gasolina" class="form-control "
							name="aniograva" onchange="">
							<option value="">Seleccionar</option>
							<option value="2019">2019</option>
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
						</select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="obligacion.inicial.gasolina.fecreporte" /></label> <input
							type="text" class="form-control ">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead style="background-color: #006DCC !important">
								<tr>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.delurbana.numide" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.delurbana.tipiden" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.delurbana.aniograv" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.delurbana.edoobliga" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.delurbana.obligacion" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.delurbana.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"
										style="text-transform: capitalize !important"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="1234" />
									</label></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>






	</div>
</sf:form>

<script type="text/javascript">
	function Selected(selectObject) {
		var value = selectObject.value;
		document.getElementById("Idimp").value = value;
	}

	function Selectedver(selectObject) {
		var value = selectObject.value;
		var x = document.getElementById('Idimp').value;
		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');
		var tabledeli = document.getElementById('table-delineacion');
		var tablegas = document.getElementById('table-gasolina');
		
		if (x == '1') {

			tablepredial.style.display = 'block';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';

		} else if (x == '2') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'block';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';

		} else if (x == '3') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'block';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';

		} else if (x == '4') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'block';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';

		} else if (x == '5') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'block';

		}else if (x == '6') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'block';
			tablegas.style.display = 'none';
		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tablegas.style.display = 'none';
			tabledeli.style.display = 'none';
		}

	}
</script>

