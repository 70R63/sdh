<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<sf:form action="" method="POST" modelAttribute="obligacionesForm"
	id="obligacionesForm">

	<sf:input type="hidden" value="" id="varDeli"
		path="${obligacionesForm.variableres}" />


	<c:set var="aa" value="${obligacionesForm.variableres}" />
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
											code="obligacion.inicial.estatus" />
								</label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="obligacion.inicial.predio.visualizar" /></label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="obligacion.inicial.imprimir" />
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
									value="<c:out value="Matricula"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="Direccion"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value=""></c:out>" /></td>
								<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: none; color: #0358d8 !important"
									onclick="" id="Detalle">Detalle</label></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value=""></c:out>" /></td>

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
								<th><label class="control-label labeltabletd"> <spring:theme
											code="obligacion.inicial.estatus" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="obligacion.inicial.vehiculo.visualizar" />
								</label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="obligacion.inicial.imprimir" />
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
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value=""></c:out>" /></td>
								<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="Detalle">Detalle</label></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value=""></c:out>" /></td>

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


		<c:if test="${not empty obligacionesFormuno.header}">
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
					<div class="col-md-6 text-center">
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
									<c:forEach items="${obligacionesFormuno.header }"
										var="eachPubExtTax">
										<tr>

											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value="${eachPubExtTax.numResolucion }"></c:out>" /></td>
											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value=""></c:out>" /></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												id="Detalle"
												data-anoGravable="${eachPubExtTax.anioGravable }"
												data-numResolu="${eachPubExtTax.numResolucion }"
												data-tipoValla="tres" data-dirvalla="cuatro"
												data-orValla="${eachPubExtTax.orientacionValla}"
												data-obligacion="${eachPubExtTax.details.obligacion}"
												data-edoobligacion="${eachPubExtTax.details.estadoObligacion}">Detalle</label><input
												type="hidden" id="data-edoobli"></td>

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






		<c:if test="${not empty obligacionesFormuno.headerdeli}">
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
										<th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="obligacion.inicial.delineacion.direccion" /> </label></th>
										<th><label class="control-label labeltabletd tableangrav"><spring:theme
													code="obligacion.inicial.delineacion.visualizar" /> </label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${obligacionesFormuno.headerdeli}"
										var="eachDeli">
										<tr>

											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value="${eachDeli.cdu}"></c:out>" /></td>
											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value=""></c:out>" /></td>
											<td><input style="width: 100%" class="inputtextnew"
												maxlength="30" size="30" disabled="disabled" type="text"
												value="<c:out value=""></c:out>" /></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												data-cdu="${eachDeli.cdu}"
												data-aniogravDeli="${eachDeli.anioGravable}"
												data-chipDeli="${eachDeli.chip}" data-dirDeli="${eachDeli.direccion}"
												data-edoobliDeli="${eachDeli.details.estadoObligacion}"
												data-obliDeli="${eachDeli.details.obligacion}" id="Detalle">Detalle</label></td>
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
						class="inputtextnew" disabled="disabled" value="" type="text"
						id="fechreportepred" />
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
										id=""
										onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
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

		<c:if test="${not empty obligacionesFormuno.headerica}">
			<div id="detalle-ica" class="oblipend-tabledetalle"
				style="display: none;">
				<div class="row">
					<div class="col-md-8">
						<label class="control-label">Fecha reporte </label> <input
							class="inputtextnew" disabled="disabled" value="" type="text"
							id="fechreporteica" />
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
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.sujeto.ica.obligacion" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.sujeto.ica.informacion" /> </label></th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input style="width: 100%"
											class="inputtextnew tableangrav" maxlength="30" size="30"
											disabled="disabled" type="text"
											value="<c:out value="${obligacionesFormuno.headerica.anioGravable}"></c:out>" /></td>
										<td><input class="inputtextnew tabledoobli"
											disabled="disabled"
											value="${obligacionesFormuno.headerica.periodo}" type="text" /></td>
										<td><input class="inputtextnew tabledoobli"
											disabled="disabled"
											value="${obligacionesFormuno.headerica.details.obligacion}"
											type="text" /></td>
										<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id="Detalledos">Detalle</label></td>
										<td><label class="control-label"
											style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
											id=""
											onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
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
			</div>
		</c:if>

		<div id="detalle-vehiculos" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text"
						id="fechreporteveh" />
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
										id=""
										onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
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
						class="inputtextnew" disabled="disabled" value="" type="text"
						id="fechreportedel" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-11 text-center">
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
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.delurbana.direccion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.informacion" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="angravabDELI" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" id="cduobDELI" /></td>
									<td><input class="inputtextnew"
										disabled="disabled" value="" type="text" id="chipDeli" /></td>
									<td><input class="inputtextnew"
										disabled="disabled" value="" type="text"  id="direcDeli"/></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" id="edoobliDeli" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" id="obliDeli"/></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="Detalledos">Detalle</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
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
		</div>



		<c:if test="${not empty obligacionesFormuno.headergas}">
			<div id="detalle-gasolina" class="oblipend-tabledetalle"
				style="display: none">
				<div class="row">
					<div class="col-md-6">
						<label class="control-label">Fecha reporte </label> <input
							class="inputtextnew" disabled="disabled" value="" type="text"
							id="fechreportegas" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-7">
						<div class="table-responsive">
							<table class="table table-bordered" id="">
								<thead>
									<tr>
										<th><label class="control-label labeltabletd"><spring:theme
													code="obligacion.sujeto.gasolina.aniograv" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.sujeto.gasolina.periodo" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.sujeto.gasolina.obligacion" /> </label></th>
										<th><label class="control-label labeltabletd tabledoobli"><spring:theme
													code="obligacion.sujeto.gasolina.informacion" /> </label></th>

									</tr>
								</thead>
								<c:forEach items="${obligacionesFormuno.headergas }"
									var="eachGasObli">
									<tbody>
										<tr>
											<td><input style="width: 100%"
												class="inputtextnew tableangrav" maxlength="30" size="30"
												disabled="disabled" type="text"
												value="<c:out value="${eachGasObli.anioGravable}"></c:out>" /></td>
											<td><input class="inputtextnew tabledoobli"
												disabled="disabled" value="${eachGasObli.periodo}"
												type="text" /></td>
											<td><input class="inputtextnew tabledoobli"
												disabled="disabled"
												value="${eachGasObli.details.obligacion}" type="text" /></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												id="Detalledos" data-angravgas="${eachGasObli.anioGravable}"
												data-perigas="${eachGasObli.periodo}"
												data-edoobligaciongas="${eachGasObli.details.estadoObligacion}"
												data-obligaciongas="${eachGasObli.details.obligacion}">Detalle</label></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												id=""
												onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
											<td><label class="control-label"
												style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
												id=""
												onclick="window.location.href ='<c:url value='/contribuyentes/rop' />';">Generar
													ROP</label></td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<div id="detalle-publiext" class="oblipend-tabledetalle"
			style="display: none;">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label">Fecha reporte </label> <input
						class="inputtextnew" disabled="disabled" value="" type="text"
						id="fechreportepub" />
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
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.dirvalla" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.orvalla" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.publiext.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.publiext.informacion" /> </label></th>

								</tr>
							</thead>

							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="angravPUB" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" id="numResOB" value="" />
									<td><input class="inputtextnew" disabled="disabled"
										id="direcvalla" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" id="orivalla" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" id="obliga" /></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id="Detalledos">Detalle</label></td>
									<td><label class="control-label"
										style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
										id=""
										onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea' />';">Pagar</label></td>
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
		</div>

		<!-- 			tablas de detalle del detalle-->

		<div id="detalle-dos-publiext" class="oblipend-tabledetalledos"
			style="display: none;">
			<div class="row">
				<div class="col-md-3 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="table-publi-ext-detalle">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.publiext.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.noresol" /> </label></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="angravPUBLICI" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" id="numResPUBLICI" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="table-publi-ext-detalle">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="obligacion.sujeto.publiext.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.obligacion" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.publiext.actooficial" /> </label></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="esdobli" /></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" id="det-obli" /></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" id="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


		<div id="detalle-dos-gasolina" class="oblipend-tabledetalledos"
			style="display: none">
			<div class="row">
				<div class="col-md-3">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.gasolina.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.gasolina.periodo" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="angravGAS" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="periodoGAS" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.gasolina.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.gasolina.oblig" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.gasolina.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="edoobliGAS" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="obliGAS" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div id="detalle-dos-ica" class="oblipend-tabledetalledos"
			style="display: none">
			<div class="row">
				<div class="col-md-3">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.ica.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.ica.periodo" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="angravICA"
										value="${obligacionesFormuno.headerica.anioGravable}" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="periodoICA"
										value="${obligacionesFormuno.headerica.periodo}" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.ica.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.ica.oblig" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.ica.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="edoobliICA"
										value="${obligacionesFormuno.headerica.details.estadoObligacion}" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="obliICA"
										value="${obligacionesFormuno.headerica.details.obligacion}" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div id="detalle-dos-delurbana" class="oblipend-tabledetalledos"
			style="display: none">
			<div class="row">
				<div class="col-md-3">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.delurbana.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.cdu" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="anioselDeli" value="" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="cduselDeli" value="" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="obligacion.sujeto.delurbana.edoobliga" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.oblig" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="obligacion.sujeto.delurbana.actooficial" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="edoobliselDELI" value="" /></td>
									<td><input style="width: 100%"
										class="inputtextnew tableangrav" maxlength="30" size="30"
										disabled="disabled" type="text" id="obliselDELI" value="" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
</sf:form>
<br>

