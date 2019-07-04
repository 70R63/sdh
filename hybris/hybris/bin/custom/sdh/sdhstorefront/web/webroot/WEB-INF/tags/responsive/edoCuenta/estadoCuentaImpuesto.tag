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
						<span><spring:theme code="edocuenta.inicial.predio.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th><label class="control-label labeltabletd"><spring:theme
											code="edocuenta.inicial.predio.chip" /></label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="edocuenta.inicial.predio.matricula" />
								</label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="edocuenta.inicial.predio.direccion" />
								</label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="edocuenta.inicial.predio.visualizar" /></label></th>
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
									id="" onclick="showdetail(this)">Detalle</label></td>

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
								code="edocuenta.inicial.vehiculo.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead>
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="edocuenta.inicial.vehiculo.placa" /></label></th>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="edocuenta.inicial.vehiculo.modelo" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.vehiculo.marca" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.vehiculo.linea" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.vehiculo.visualizar" />
								</label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="PLACA"></c:out>" /></td>
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
									id="" onclick="showdetail(this)">Detalle</label></td>

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
						<span><spring:theme code="edocuenta.inicial.ica.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead>
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="edocuenta.inicial.ica.tipdocu" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.ica.numdocu" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.ica.visualizar" />
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
									id="" onclick="showdetail(this)">Detalle</label></td>

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
								code="edocuenta.inicial.publicidad.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="edocuenta.inicial.publicidad.numresol" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.publicidad.tipvalla" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.publicidad.tipvalla" />
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
									id="" onclick="showdetail(this)">Detalle</label></td>

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
								code="edocuenta.inicial.gasolina.titulo" /></span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="edocuenta.inicial.gasolina.tipdoc" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.gasolina.numdoc" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.gasolina.visualizar" />
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
									id="" onclick="showdetail(this)">Detalle</label></td>

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
								code="edocuenta.inicial.deliurbana.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="edocuenta.inicial.deliurbana.cdu" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.deliurbana.licenconst" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.deliurbana.direccion" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="edocuenta.inicial.deliurbana.visualizar" />
								</label></th>
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
									id="" onclick="showdetail(this)">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div id="table-obli-no-tributarias" style="display: none;">
			<div class="row">
				<div class="col-md-6 text-center">
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.obligaciones.concepto" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.obligaciones.anigrav" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="edocuenta.inicial.obligaciones.estado" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.obligaciones.saldocargo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.obligaciones.saldofavor" /> </label></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="123456" />
									</label></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
								<tr>
									<td colspan="2" class="td-colspann"></td>
									<td class="td-total"><label
										class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.obligaciones.total" /> </label></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!-- 			tablas de detalle -->

		<div id="detalle-predial" style="display: none;">
			<div class="row">
				<div class="col-md-8">
					<div class="table-responsive text-center">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th colspan="4"><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.predio.detalle" /> </label></th>
									<th><label class="control-label labeltabletd tabledomatri"><spring:theme
												code="edocuenta.inicial.predio.resposa" /> </label></th>
									<th colspan="2"><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.predio.saldcuenta" /> </label></th>

								</tr>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.predio.chip" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.predio.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.predio.desthacen" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.predio.estado" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="edocuenta.inicial.predio.participa" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.predio.saldocargo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.predio.saldofavor" /> </label></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="123456" />
									</label></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledomatri"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
								<tr>
									<td colspan="4" class="td-colspann"></td>
									<td class="td-total"><label
										class="control-label labeltabletd tableangrav labeltabletd"><spring:theme
												code="edocuenta.inicial.predio.total" /> </label></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.predial.presendecla" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.predial.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.predial.paglinea" />
						</button>
					</div>
				</div>
			</div>
		</div>


		<div id="detalle-ica" style="display: none;">
			<div class="row">
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"> <spring:theme
								code="edocuenta.inicial.ica.tiporegimen" /></label> <input class="form-cntrol"
										disabled="disabled" value="" type="text" />
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-md-6 text-center">
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th colspan="3"><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.ica.impuesto" /> </label></th>
									<th colspan="2"><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.ica.saldocuenta" /> </label></th>

								</tr>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.ica.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.ica.periodo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.ica.estado" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.ica.saldocargo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.ica.saldofavor" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="123456" />
									</label></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
								<tr>
									<td colspan="2" class="td-colspann"></td>
									<td class="td-total"><label
										class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.ica.total" /> </label></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.ica.presendecla" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.ica.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.ica.paglinea" />
						</button>
					</div>
				</div>
			</div>
		</div>


		<div id="detalle-vehiculos" style="display: none;">
			<div class="row">
				<div class="col-md-6 text-center">
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th colspan="3"><label class="control-label labeltabletd "><spring:theme
												code="edocuenta.inicial.vehiculo.impuesto" /> </label></th>
									<th colspan="2"><label class="control-label labeltabletd "><spring:theme
												code="edocuenta.inicial.vehiculo.soldocuenta" /> </label></th>
								</tr>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.vehiculo.placa" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="edocuenta.inicial.vehiculo.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.vehiculo.estado" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.vehiculo.saldocargo" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="edocuenta.inicial.vehiculo.saldofavor" /> </label></th>
								</tr>

							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label tabledoobli"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="1234" />
									</label></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
								<tr>
									<td colspan="2" class="td-colspann"></td>
									<td class="td-total"><label
										class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.vehiculo.total" /> </label></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.vehiculos.presendecla" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.vehiculos.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.vehiculos.paglinea" />
						</button>
					</div>
				</div>
			</div>
		</div>


		<div id="detalle-delurbana" style="display: none;">
			>
			<div class="row">
				<div class="col-md-11 text-center">
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th colspan="6"><label class="control-label labeltabletd "><spring:theme
												code="edocuenta.inicial.deliurbana.impuesto" /> </label></th>
									<th colspan="2"><label class="control-label labeltabletd "><spring:theme
												code="edocuenta.inicial.deliurbana.saldocuenta" /> </label></th>
								</tr>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.radicado" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.chip" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.direcobre" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="edocuenta.inicial.deliurbana.orientacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.vigencia" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.estado" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.saldocargo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.saldofavor" /> </label></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="123456" />
									</label></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
								<tr>
									<td colspan="5" class="td-colspann"></td>
									<td class="td-total"><label
										class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.total" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.delurbana.presendecla" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.delurbana.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.delurbana.paglinea" />
						</button>
					</div>
				</div>
			</div>
		</div>

		<div id="detalle-gasolina" style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th colspan="3"><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.gasolina.impuesto" /> </label></th>
									<th colspan="2"><label
										class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.gasolina.saldocuenta" /> </label></th>
								</tr>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.gasolina.anigrav" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.gasolina.periodo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.gasolina.estado" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.gasolina.saldocargo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.gasolina.saldofavor" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="123456" />
									</label></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
								<tr>
									<td colspan="2" class="td-colspann"></td>
									<td class="td-total"><label
										class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.gasolina.total" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.gasolina.presendecla" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.gasolina.paglinea" />
						</button>
					</div>
				</div>
			</div>
		</div>


		<div id="detalle-publiext" style="display: none;">
			<div class="row">
				<div class="col-md-10 text-center">
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th colspan="6"><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.publicidad.impuesto" /> </label></th>
									<th colspan="2"><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.publicidad.saldocuenta" /> </label></th>
								</tr>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.publicidad.numresol" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.publicidad.direccion" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.publicidad.orientacion" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.publicidad.anigrav" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="edocuenta.inicial.publicidad.desthacen" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.publicidad.estado" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.publicidad.saldocargo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.publicidad.saldofavor" /> </label></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="123456" />
									</label></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
								<tr>
									<td colspan="5" class="td-colspann"></td>
									<td class="td-total"><label
										class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.publicidad.total" /> </label></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.publiext.presendecla" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.publiext.paglinea" />
						</button>
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

	function showdetail(selectObject) {

		debugger;
		var value = selectObject.value;
		var x = document.getElementById('Idimp').value;

		var todo = document.getElementById('idtodos');
		var detpred = document.getElementById('detalle-predial');
		var detica = document.getElementById('detalle-ica');
		var detvehi = document.getElementById('detalle-vehiculos');
		var detdeli = document.getElementById('detalle-delurbana');
		var detgas = document.getElementById('detalle-gasolina');
		var detplubliext = document.getElementById('detalle-publiext');

		if (x == '1') {

			todo.style.display = 'none';
			detpred.style.display = 'block';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';

		} else if (x == '2') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'block';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';

		} else if (x == '3') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'block';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';

		} else if (x == '4') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'block';

		} else if (x == '5') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'block';
			detplubliext.style.display = 'none';

		} else if (x == '6') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detgas.style.display = 'none';
			detdeli.style.display = 'block';
			detplubliext.style.display = 'none';

		} else {

			todo.style.display = 'block';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
		}

	}
</script>
