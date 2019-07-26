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
		<div id="oblipend-predial" class="oblipend-table"
			style="display: none;">

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
									onclick="" id="Detalle">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div id="oblipend-vehiculos" class="oblipend-table"
			style="display: none;">
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
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="CHIP"></c:out>" /></td>
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
									id="Detalle">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<c:if test="${not empty customerData.icaTax}">
			<div id="oblipend-ica" class="oblipend-table" style="display: none;">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme code="obligacion.sujeto.ica.titulo" /></span>
						</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
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
									<td><input style="width: 100%"
										class="inputtextnew text-center" maxlength="30" size="30"
										disabled="disabled" type="text"
										value="<c:out value="${customerData.documentType}"></c:out>" /></td>
									<td><input style="width: 100%" class="inputtextnew"
										maxlength="30" size="30" disabled="disabled" type="text"
										value="<c:out value="${customerData.documentNumber}"></c:out>" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="Detalle">Detalle</label></td>

								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</c:if>


		<c:if test="${not empty customerData.exteriorPublicityTaxList }">
			<div id="oblipend-publiext" class="oblipend-table"
				style="display: none;">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme
									code="obligacion.sujeto.publiext.titulo" /></span>
						</h2>
					</div>
				</div>


				<div class="row">
					<div class="col-md-4 text-center">
						<div class="table-responsive">
							<table class="table table-bordered" id="">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd" for=""><spring:theme
													code="obligacion.inicial.publicidad.numresol" /></label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme code="obligacion.inicial.publicidad.tipvalla" />
										</label></th>
										<th><label class="control-label labeltabletd" for="">
												<spring:theme
													code="obligacion.inicial.publicidad.visualizar" />
										</label></th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${customerData.exteriorPublicityTaxList }"
										var="eachPubExtTax">
										<tr>

											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value="${eachPubExtTax.resolutionNumber }"></c:out>" /></td>
											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value="${eachPubExtTax.fenceType }"></c:out>" /></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												id="Detalle" data-anoGravable="${eachPubExtTax.anoGravable}" data-numResolu="${eachPubExtTax.resolutionNumber }" data-tipoValla="${eachPubExtTax.fenceType }">Detalle</label></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</c:if>


		<c:if test="${not empty customerData.gasTaxList }">
			<div id="oblipend-gasolina" class="oblipend-table"
				style="display: none;">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme
									code="obligacion.sujeto.gasolina.titulo" /></span>
						</h2>
					</div>
				</div>


				<div class="row">
					<div class="col-md-5">
						<div class="table-responsive">
							<table class="table table-bordered" id="">
								<thead>
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

									<c:forEach items="${customerData.gasTaxList }" var="eachGasTax">
										<tr>
											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value="${eachGasTax.documentType}"></c:out>" /></td>
											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value="${eachGasTax.documentNumber}"></c:out>" /></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												id="Detalle">Detalle</label></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</c:if>






		<c:if test="${not empty customerData.urbanDelineationsTaxList }">
			<div id="oblipend-delurbana" class="oblipend-table"
				style="display: none;">
				<div class="row">
					<div class="headline">
						<h2>
							<span><spring:theme
									code="obligacion.sujeto.delurbana.titulo" /></span>
						</h2>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6 text-center">
						<div class="table-responsive">
							<table class="table table-bordered" id="">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.inicial.delineacion.cdu" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.inicial.delineacion.licconstr" /> </label></th>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.inicial.delineacion.exp" /> </label></th>
										<th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="obligacion.inicial.delineacion.visualizar" /> </label></th>



									</tr>
								</thead>
								<tbody>
									<c:forEach items="${customerData.urbanDelineationsTaxList }"
										var="eachDelUrbTax">
										<tr>

											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value="${eachDelUrbTax.cdu }"></c:out>" /></td>
											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value="${eachDelUrbTax.licenConst }"></c:out>" /></td>
											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value="${eachDelUrbTax.expDate}"></c:out>" /></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												data-cdu="${eachDelUrbTax.cdu}" id="Detalle">Detalle</label></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</c:if>


		<!-- 			tablas de detalle -->

		<div id="detalle-predial" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" id="fechreporte" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<div class="table-responsive ">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.predial.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.predial.chip" /> </label></th>
									<th><label class="control-label labeltabletd tabledomatri"><spring:theme
												code="obligacion.sujeto.predial.matin" /> </label></th>
									<th><label
										class="control-label labeltabletd tablenombrecorto"><spring:theme
												code="obligacion.sujeto.predial.direccion" /> </label></th>
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
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text"
										value="<c:out value="A�o gravable"></c:out>" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledomatri"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tablenombrecorto"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="" onclick="">Pagar</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
											ROP</label></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="goBack()">
							<spring:theme code="obligacion.sujeto.predial.regresar" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="window.location.href ='<c:url value='/contribuyentes' />';">
							<spring:theme code="obligacion.sujeto.predial.cancelar" />
						</button>
					</div>
				</div>
			</div>
		</div>

		<div id="detalle-ica" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-8">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" id="fechreporte" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-7 text-center">
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
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text"
										value="<c:out value="A�o gravable"></c:out>" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="" onclick="">Pagar</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
											ROP</label></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="goBack()">
							<spring:theme code="obligacion.sujeto.ica.regresar" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="window.location.href ='<c:url value='/contribuyentes' />';">
							<spring:theme code="obligacion.sujeto.ica.cancelar" />
						</button>
					</div>
				</div>
			</div>
		</div>


		<div id="detalle-vehiculos" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" id="fechreporte" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.placa" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.modelo" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.marca" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.vehiculos.linea" /> </label></th>
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
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text"
										value="<c:out value="A�o gravable"></c:out>" /></td>
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
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="" onclick="">Pagar</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
											ROP</label></td>

								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="goBack()">
							<spring:theme code="obligacion.sujeto.vehiculos.regresar" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="window.location.href ='<c:url value='/contribuyentes' />';">
							<spring:theme code="obligacion.sujeto.vehiculos.cancelar" />
						</button>
					</div>
				</div>
			</div>
		</div>


		<div id="detalle-delurbana" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" id="fechreporte" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.cdu" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.delurbana.chip" /> </label></th>
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
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text"
										value="<c:out value="A�o gravable"></c:out>" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli" disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="" onclick="">Pagar</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
											ROP</label></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="goBack()">
							<spring:theme code="obligacion.sujeto.delurbana.regresar" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="window.location.href ='<c:url value='/contribuyentes' />';">
							<spring:theme code="obligacion.sujeto.delurbana.cancelar" />
						</button>
					</div>
				</div>
			</div>
		</div>

		<div id="detalle-gasolina" class="oblipend-tabledetalle"
			style="display: none">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text" id="fechreporte" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
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
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text"
										value="<c:out value="A�o gravable"></c:out>" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="" onclick="">Pagar</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
											ROP</label></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="goBack()">
							<spring:theme code="obligacion.sujeto.gasolina.regresar" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="window.location.href ='<c:url value='/contribuyentes' />';">
							<spring:theme code="obligacion.sujeto.gasolina.cancelar" />
						</button>
					</div>
				</div>
			</div>
		</div>
		<div id="detalle-publiext" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text"  id="fechreporte"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="table-publi-ext-detalle">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.publiext.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.noresol" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.publiext.dirvalla" /> </label></th>
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
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text"
										value="<c:out value="A�o gravable"></c:out>" /></td>
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
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="" onclick="">Pagar</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/contribuyentes/rop?tipoImp=06&numBP=0000000575&numObjeto=60000000000000061&clavePeriodo=1810' />';">Generar
											ROP</label></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="goBack()">
							<spring:theme code="obligacion.sujeto.publiext.regresar" />
						</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="button" class="btn btn-secondary btn-lg" id="action"
							name="action" value="generar" style="margin-top: 3px"
							onclick="window.location.href ='<c:url value='/contribuyentes' />';">
							<spring:theme code="obligacion.sujeto.publiext.cancelar" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</sf:form>
<br>

