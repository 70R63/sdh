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
			<div class="col-md-2">
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.sujeto.regresar" />
					</button>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.sujeto.descargar" />
					</button>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="obligacion.sujeto.vigencia" /></label>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<select aria-required="true" id="aniograva" class="form-control "
						name="aniograva" onchange="">
						<option value="">Seleccionar</option>
					</select>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.sujeto.buscar" />
					</button>
				</div>
			</div>
		</div>


		<div id="predial">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.predial.titulo" /></span>
					</h2>
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
												code="obligacion.sujeto.predial.matin" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.predial.direccion" /> </label></th>
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
									<td><c:out value="" /></td>
									<td><c:out value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6 text-right">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.predial.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.predial.paglinea" />
						</button>
					</div>
				</div>
			</div>
		</div>

		<div id="ica">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.ica.titulo" /></span>
					</h2>
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
												code="obligacion.sujeto.ica.numide" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.ica.tipiden" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.ica.aniograv" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.ica.periodo" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.ica.edoobliga" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.ica.obligacion" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.ica.actooficial" /> </label></th>

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
			<div class="row">
				<div class="col-md-6 text-right">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.ica.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.ica.paglinea" />
						</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<div id="vehiculos">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.vehiculos.titulo" /></span>
					</h2>
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
												code="obligacion.sujeto.vehiculos.numide" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.vehiculos.tipiden" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.vehiculos.aniograv" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.vehiculos.periodo" /> </label></th>
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
			<div class="row">
				<div class="col-md-6 text-right">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.vehiculos.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.vehiculos.paglinea" />
						</button>
					</div>
				</div>
			</div>
		</div>
		
		<div id="gasolina">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.gasolina.titulo" /></span>
					</h2>
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
												code="obligacion.sujeto.gasolina.numide" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.gasolina.tipiden" /> </label></th>
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
			<div class="row">
				<div class="col-md-6 text-right">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.gasolina.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.gasolina.paglinea" />
						</button>
					</div>
				</div>
			</div>
		</div>
		
		<div id="delurbana">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.delurbana.titulo" /></span>
					</h2>
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
												code="obligacion.sujeto.delurbana.periodo" /> </label></th>
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
									<td><c:out value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 text-right">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.delurbana.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.delurbana.paglinea" />
						</button>
					</div>
				</div>
			</div>
		</div>
		
		<div id="publiext">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.publiext.titulo" /></span>
					</h2>
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
												code="obligacion.sujeto.publiext.numide" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.publiext.tipiden" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.publiext.aniograv" /> </label></th>
									<th style="text-align: center"><label
										class="control-label "
										style="text-transform: capitalize !important"><spring:theme
												code="obligacion.sujeto.publiext.periodo" /> </label></th>
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
			<div class="row">
				<div class="col-md-6 text-right">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px">
							<spring:theme code="obligacion.sujeto.publiext.genrop" />
						</button>
					</div>
				</div>
				<div class="col-md-6">
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


