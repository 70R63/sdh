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
				<div class="col-md-4">
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
								code="obligacion.sujeto.gasolina.titulo" /></span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-8">
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
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.delineacion.licconstr" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.delineacion.direccion" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.delineacion.visualizar" />
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

		<!-- 			tablas de detalle -->

		<div id="detalle-predial" style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-5">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.predial.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.predial.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.predial.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.predial.actooficial" /> </label></th>

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
									<td><input class="inputtextnew " disabled="disabled"
										value="" type="text" /></td>
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
						<button type="button" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px" onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">
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
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.ica.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.ica.periodo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.ica.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.ica.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.ica.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="2019" />
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
						<button type="button" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px" onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">
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
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.vehiculos.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.vehiculos.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.vehiculos.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="RCK502" />
									</label></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
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
						<button type="button" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px" onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">
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
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.inicial.delineacion.numident" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.inicial.delineacion.tipiden" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.delurbana.direccion" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.delurbana.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.actooficial" /> </label></th>

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
						<button type="button" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px" onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">
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
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.gasolina.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.gasolina.periodo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.gasolina.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.gasolina.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.gasolina.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="1234" />
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
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.noresol" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.dirvalla" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.publiext.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.publiext.orvalla" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.publiext.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.publiext.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.publiext.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="form-check-label"> <input
											type="radio" name="aporte" id=""
											class="form-check-input mr-2"
											style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
											<c:out value="1234" />
									</label></td>
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
