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
	<sf:form>
		<div id="predial">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.predial.titulo" /></span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-8">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.predial.chip" /> </label></th>
									<th><label class="control-label labeltabletd tabledomatri"><spring:theme
												code="obligacion.sujeto.predial.matin" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.predial.direccion" /> </label></th>
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
									<td><input class="inputtextnew tabledomatri"
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

		<div id="ica">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="obligacion.sujeto.ica.titulo" /></span>
					</h2>
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


		<div id="vehiculos">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.vehiculos.titulo" /></span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.vehiculos.placa" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.modelo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.vehiculos.marca" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.vehiculos.linea" /> </label></th>
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
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="2011" type="text" /></td>
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


		<div id="delurbana">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.delurbana.titulo" /></span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.cdu" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.chip" /> </label></th>
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

		<div id="gasolina">
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


		<div id="publiext">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="obligacion.sujeto.publiext.titulo" /></span>
					</h2>
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
	</sf:form>
</div>


