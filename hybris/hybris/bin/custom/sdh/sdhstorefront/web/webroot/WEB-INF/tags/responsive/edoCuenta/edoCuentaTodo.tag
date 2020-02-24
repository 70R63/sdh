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
						<span><spring:theme code="edocuenta.inicial.predio.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<div class="table-responsive text-center">
						<table class="table tableedocuenta" id="tabPaginacion0">
							<thead>
								<tr>
									<th colspan="4"><label
										class="control-label labeltabletd tabledoobli"><spring:theme
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
								<c:forEach varStatus="loop" items="${ctaForm.predial}"
									var="eachPredial">
									<tr>
										<td><c:out value="${eachPredial.CHIP}" /></td>
										<c:forEach varStatus="loop" items="${eachPredial.detallePredial}"
											var="eachPredialDetail">
											<td><c:out
													value="${eachPredial.eachPredialDetail.anioGravable}" /></td>
											<td><c:out
													value="${eachPredial.eachPredialDetail.destinohacendario}" /></td>
											<td><c:out value="${eachPredial.eachPredialDetail.estado}" /></td>
											<td><c:out
													value="${eachPredial.eachPredialDetail.porcParticipacion}" /></td>
											<td><c:out
													value="${eachPredial.eachPredialDetail.saldoCargo}" /></td>
											<td><c:out
													value="${eachPredial.eachPredialDetail.saldoFavor}" /></td>
										</c:forEach>
									</tr>
									<tr>
										<td colspan="4" class="td-colspann"
											style="border: 0px !important;"></td>
										<td class="td-total"><label
											class="control-label labeltabletd tableangrav labeltabletd"><spring:theme
													code="edocuenta.inicial.predio.total" /> </label></td>
										<td><input class="inputtextnew tabledoobli"
											disabled="disabled" value="" type="text" /></td>
										<td><input class="inputtextnew tableangrav"
											disabled="disabled" value="" type="text" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


		<div id="vehiculos">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="edocuenta.inicial.vehiculo.titulo" /></span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6 text-center">
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
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
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
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
									<td colspan="2" class="td-colspann"
										style="border: 0px !important;"></td>
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
		</div>

		<div id="ica">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="edocuenta.inicial.ica.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"> <spring:theme
								code="edocuenta.inicial.ica.tiporegimen" /></label> <input
							class="form-cntrol" disabled="disabled" value="" type="text" />
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-md-6 text-center">
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
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
									<td colspan="2" class="td-colspann"
										style="border: 0px !important;"></td>
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
		</div>


		<div id="delurbana">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="edocuenta.inicial.deliurbana.titulo" /></span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-7 text-center">
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.cdu" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.radicado" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="edocuenta.inicial.deliurbana.estado" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.saldocargo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="edocuenta.inicial.deliurbana.saldofavor" /> </label></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
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
									<td colspan="3" class="td-colspann"
										style="border: 0px !important;"></td>
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
		</div>

		<div id="gasolina">
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
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
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
									<td colspan="2" class="td-colspann"
										style="border: 0px !important;"></td>
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
		</div>


		<div id="publiext">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="edocuenta.inicial.publicidad.titulo" /></span>
					</h2>
				</div>
			</div>


			<div class="row">
				<div class="col-md-7 text-center">
					<div class="table-responsive">
						<table class="table tableedocuenta" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="edocuenta.inicial.publicidad.numresol" /> </label></th>
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
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
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
								<tr>
									<td colspan="3" class="td-colspann"
										style="border: 0px !important;"></td>
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

		</div>

		<div id="obli-no-tributarias">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="edocuenta.inicial.obligaciones.titulo" /></span>
					</h2>
				</div>
			</div>


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
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
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
									<td colspan="2" class="td-colspann"
										style="border: 0px !important;"></td>
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
	</sf:form>
</div>


