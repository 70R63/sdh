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

		<div id="table-predial" style="display: none;" class="table-responsive">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="relacion.inicial.predio.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th><label class="control-label labeltabletd"><spring:theme
											code="relacion.inicial.predio.chip" /></label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="relacion.inicial.predio.matricula" />
								</label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="relacion.inicial.predio.direccion" />
								</label></th>
								<th><label class="control-label labeltabletd"> <spring:theme
											code="relacion.inicial.predio.visualizar" /></label></th>
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
						<span><spring:theme code="relacion.inicial.vehiculo.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead>
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="relacion.inicial.vehiculo.placa" /></label></th>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="relacion.inicial.vehiculo.modelo" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="relacion.inicial.vehiculo.marca" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="relacion.inicial.vehiculo.linea" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="relacion.inicial.vehiculo.visualizar" />
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
		</div>

		<div id="table-publicidad" style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="relacion.inicial.publicidad.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th><label class="control-label labeltabletd" for=""><spring:theme
											code="relacion.inicial.publicidad.numresol" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="relacion.inicial.publicidad.tipvalla" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme code="relacion.inicial.publicidad.visualizar" />
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
		</div>

		
		
<!-- 		<div id="table-delineacion" style="display: none;"> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="headline"> -->
<!-- 					<h2> -->
<%-- 						<span><spring:theme --%>
<%-- 								code="obligacion.sujeto.delurbana.titulo" /></span> --%>
<!-- 					</h2> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-6"> -->
<!-- 					<table class="table"> -->
<!-- 						<thead style="cellspacing: 10 !important"> -->
<!-- 							<tr> -->
<%-- 								<th><label class="control-label labeltabletd" for=""><spring:theme --%>
<%-- 											code="relacion.inicial.delineacion.retencion.cdu" /></label></th> --%>
<!-- 								<th><label class="control-label labeltabletd" for=""> -->
<%-- 										<spring:theme --%>
<%-- 											code="relacion.inicial.delineacion.retencion.liccons" /> --%>
<!-- 								</label></th> -->
<!-- 								<th><label class="control-label labeltabletd" for=""> -->
<%-- 										<spring:theme --%>
<%-- 											code="relacion.inicial.delineacion.retencion.direccion" /> --%>
<!-- 								</label></th> -->
<!-- 								<th><label class="control-label labeltabletd" for=""> -->
<%-- 										<spring:theme --%>
<%-- 											code="relacion.inicial.delineacion.retencion.visualizar" /> --%>
<!-- 								</label></th> -->
<!-- 							</tr> -->
<!-- 						</thead> -->
<!-- 						<tbody> -->

<!-- 							<tr> -->
<!-- 								<td><label class="control-label" -->
<!-- 									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important" -->
<!-- 									id="" onclick="showdetail('7')">CDU</label></td> -->
<!-- 								<td><input style="width: 100%" class="inputtextnew" -->
<!-- 									maxlength="30" size="30" disabled="disabled" type="text" -->
<%-- 									value="<c:out value="licencia"></c:out>" /></td> --%>
<!-- 								<td><input style="width: 100%" class="inputtextnew" -->
<!-- 									maxlength="30" size="30" disabled="disabled" type="text" -->
<%-- 									value="<c:out value="direccion"></c:out>" /></td> --%>
<!-- 								<td><label class="control-label" -->
<!-- 									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important" -->
<!-- 									id="" onclick="showdetail(this)">Detalle</label></td> -->

<!-- 							</tr> -->
<!-- 						</tbody> -->
<!-- 					</table> -->
<!-- 					<small class="form-text text-muted" -->
<%-- 							style="text-align: right !important"><spring:theme --%>
<%-- 								code="relacion.inicial.delineacion.retencion.nota1" /></small> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
<!-- 		<div id="table-delineacion-radicados" style="display: none;"> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="headline"> -->
<!-- 					<h2> -->
<%-- 						<span><spring:theme --%>
<%-- 								code="obligacion.sujeto.delurbana.titulo" /></span> --%>
<!-- 					</h2> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-6"> -->
<!-- 					<table class="table"> -->
<!-- 						<thead style="cellspacing: 10 !important"> -->
<!-- 							<tr> -->
<%-- 								<th><label class="control-label labeltabletd" for=""><spring:theme --%>
<%-- 											code="relacion.inicial.delineacion.radicados.cdu" /></label></th> --%>
<!-- 								<th><label class="control-label labeltabletd" for=""> -->
<%-- 										<spring:theme --%>
<%-- 											code="relacion.inicial.delineacion.radicados.radicado" /> --%>
<!-- 								</label></th> -->
<!-- 								<th><label class="control-label labeltabletd" for=""> -->
<%-- 										<spring:theme --%>
<%-- 											code="relacion.inicial.delineacion.radicados.direccion" /> --%>
<!-- 								</label></th> -->
<!-- 								<th><label class="control-label labeltabletd" for=""> -->
<%-- 										<spring:theme --%>
<%-- 											code="relacion.inicial.delineacion.radicados.visualizar" /> --%>
<!-- 								</label></th> -->
<!-- 							</tr> -->
<!-- 						</thead> -->
<!-- 						<tbody> -->

<!-- 							<tr> -->
<!-- 								<td><input style="width: 100%" class="inputtextnew" -->
<!-- 									maxlength="30" size="30" disabled="disabled" type="text" -->
<%-- 									value="<c:out value="licencia"></c:out>" /></td> --%>
<!-- 								<td><input style="width: 100%" class="inputtextnew" -->
<!-- 									maxlength="30" size="30" disabled="disabled" type="text" -->
<%-- 									value="<c:out value="licencia"></c:out>" /></td> --%>
<!-- 								<td><input style="width: 100%" class="inputtextnew" -->
<!-- 									maxlength="30" size="30" disabled="disabled" type="text" -->
<%-- 									value="<c:out value="direccion"></c:out>" /></td> --%>
<!-- 								<td><label class="control-label" -->
<!-- 									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important" -->
<!-- 									id="" onclick="showdetailrad(this)">Detalle</label></td> -->

<!-- 							</tr> -->
<!-- 						</tbody> -->
<!-- 					</table> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

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
											code="relacion.inicial.delineacion.radicados.cdu" /></label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme
											code="relacion.inicial.delineacion.radicados.radicado" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme
											code="relacion.inicial.delineacion.radicados.direccion" />
								</label></th>
								<th><label class="control-label labeltabletd" for="">
										<spring:theme
											code="relacion.inicial.delineacion.radicados.visualizar" />
								</label></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="licencia"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="licencia"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="direccion"></c:out>" /></td>
								<td><label class="control-label"
									style="visibility: visible !important; width: 100%; text-transform: capitalize; color: #0358d8 !important"
									id="" onclick="showdetailrad(this)">Detalle</label></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		

		<!-- 			tablas de detalle -->

		<div id="detalle-predial" style="display: none;" class="table-responsive">
			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.predio.chip" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="relacion.inicial.predio.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.predio.tipdoc" /> </label></th>
									<th><label class="control-label labeltabletd "><spring:theme
												code="relacion.inicial.predio.norefrecaudo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.predio.sticker" /> </label></th>
									<th><label class="control-label labeltabletd tablefechas"><spring:theme
												code="relacion.inicial.predio.fecpreseta" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.predio.totpagado" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.predio.totaporte" /> </label></th>

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
									<td><input class="inputtextnew " disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tablefechas"
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
		</div>


		<div id="detalle-ica" style="display: none;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="relacion.inicial.ica.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="relacion.inicial.ica.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.ica.periodo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.ica.tipdocu" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="relacion.inicial.ica.numrefrec" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.ica.sticker" /> </label></th>
									<th><label class="control-label labeltabletd tablefechas"><spring:theme
												code="relacion.inicial.ica.fecprese" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.ica.totpag" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.ica.totapovol" /> </label></th>

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
									<td><input class="inputtextnew " disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tablefechas"
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
		</div>



		<div id="detalle-vehiculos" style="display: none;">
			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.vehiculo.placa" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="relacion.inicial.vehiculo.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.vehiculo.tipdoc" /> </label></th>
									<th><label class="control-label labeltabletd "><spring:theme
												code="relacion.inicial.vehiculo.numrefrec" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.vehiculo.numform" /> </label></th>
									<th><label class="control-label labeltabletd tablefechas"><spring:theme
												code="relacion.inicial.vehiculo.fecprese" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.vehiculo.totpag" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.vehiculo.totapovol" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew " disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tablefechas"
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


		<div id="detalle-delurbana" style="display: none;">
			<div class="row">
				<div class="col-md-12 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.cdu" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.radi" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.tipo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.modalidad" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.tipdocu" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="relacion.inicial.delineacion.nurefrec" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.numform" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.fecprese" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.totpag" /> </label></th>
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
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" /></td>
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
		</div>
		
		
		<div id="detalle-retenciones" style="display: none;">
			<div class="row">
				<div class="col-md-2">
					<div class="form-check">
						<label class="form-check-label" style="text-transform: capitalize">
							<input type="checkbox" name="regimen" id=""
							class="form-check-input mr-2"
							style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
							<spring:theme code="relacion.inicial.conreserva" />
						</label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-check">
						<label class="form-check-label" style="text-transform: capitalize">
							<input type="checkbox" name="regimen" id=""
							class="form-check-input mr-2"
							style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
							<spring:theme code="relacion.inicial.sinreserva" />
						</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.retencion.cdu" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.retencion.radicados" />
									</label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.retencion.tipo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.retencion.modalidad" />
									</label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="relacion.inicial.delineacion.retencion.nurefrec" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.retencion.sticker" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.retencion.tipdocu" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.retencion.fecprese" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.retencion.totpag" /> </label></th>

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
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" /></td>
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
		</div>
		

		<div id="detalle-gasolina" style="display: none;">
		<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="relacion.inicial.gasolina.titulo" /></span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="relacion.inicial.gasolina.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.gasolina.periodo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.gasolina.tipdoc" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="relacion.inicial.gasolina.nurefrec" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.gasolina.sticker" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.gasolina.fecprese" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.gasolina.totpag" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input class="inputtextnew tableangrav"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew " disabled="disabled"
										value="" type="text" /></td>
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
		</div>


		<div id="detalle-publiext" style="display: none;">
			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd"><spring:theme
												code="relacion.inicial.publicidad.numresol" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="relacion.inicial.publicidad.dirins" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="relacion.inicial.publicidad.orientacion" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.publicidad.regrisol" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="relacion.inicial.publicidad.numrefrec" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.publicidad.numForm" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.publicidad.tipdoc" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.publicidad.fecprese" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.publicidad.totpag" /> </label></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" /></td>
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

<script type="text/javascript">
	function Selected(selectObject) {
		
		var value = selectObject.value;
		document.getElementById("Idimp").value = value;
	}

	function showdetail(selectObject) {
		var values = selectObject.value;
		var value = selectObject;
		var x = document.getElementById('Idimp').value;

		var todo = document.getElementById('idtodos');
		var detpred = document.getElementById('detalle-predial');
		var detica = document.getElementById('detalle-ica');
		var detvehi = document.getElementById('detalle-vehiculos');
		var detdeli = document.getElementById('detalle-delurbana');
		var detgas = document.getElementById('detalle-gasolina');
		var detplubliext = document.getElementById('detalle-publiext');
		var detradic = document.getElementById('detalle-retenciones');
		var tabdel = document.getElementById('table-delineacion');
		var tabrad = document.getElementById('table-delineacion-radicados');

		if (x == '1' && value !='7') {

			todo.style.display = 'none';
			detpred.style.display = 'block';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display = 'none';

		} else if (x == '2' && value !='7') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'block';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display = 'none';

		} else if (x == '3' && value !='7') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'block';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display = 'none';

		} else if (x == '4'&& value !='7') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'block';
			detradic.style.display = 'none';
			tabrad.style.display = 'none';

		} else if (x == '5' && value !='7') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'block';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display = 'none';

		} else if (x == '6' && value !='7') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detgas.style.display = 'none';
			detdeli.style.display = 'block';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display = 'none';

		}  else if (value == '7') {

			todo.style.display = 'none';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detgas.style.display = 'none';
			detdeli.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none'; 
			tabdel.style.display='none';
			tabrad.style.display = 'block';

		} else {

			todo.style.display = 'block';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			detradic.style.display = 'none';
			tabrad.style.display = 'none';
		}

	}
	
	function showdetailrad(selectObject){
		
		
		var values = selectObject.value;
		var value = selectObject;
		var x = document.getElementById('Idimp').value;

		var todo = document.getElementById('idtodos');
		var detpred = document.getElementById('detalle-predial');
		var detica = document.getElementById('detalle-ica');
		var detvehi = document.getElementById('detalle-vehiculos');
		var detdeli = document.getElementById('detalle-delurbana');
		var detgas = document.getElementById('detalle-gasolina');
		var detplubliext = document.getElementById('detalle-publiext');
		var detradic = document.getElementById('detalle-delurbana');
		var tabdel = document.getElementById('table-delineacion');
		var tabrad = document.getElementById('table-delineacion-radicados');
		
		todo.style.display = 'none';
		detpred.style.display = 'none';
		detica.style.display = 'none';
		detvehi.style.display = 'none';
		detgas.style.display = 'none';
		detdeli.style.display = 'none';
		detplubliext.style.display = 'none';
		detradic.style.display = 'block'; //este es el detalle de los radicados
		tabdel.style.display='block';
		
	}
</script>
