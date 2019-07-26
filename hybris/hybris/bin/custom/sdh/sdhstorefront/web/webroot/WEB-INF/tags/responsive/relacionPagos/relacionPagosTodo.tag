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
						<span><spring:theme code="relacion.inicial.predio.titulo" /></span>
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

		<div id="ica">
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


		<div id="vehiculos">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="relacion.inicial.vehiculo.titulo" /></span>
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
												code="relacion.inicial.vehiculo.placa" /> </label></th>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="relacion.inicial.vehiculo.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.vehiculo.tipdoc" /> </label></th>
									<th><label class="control-label labeltabletd "><spring:theme
												code="relacion.inicial.vehiculo.numrefrec" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.vehiculo.sticker" /> </label></th>
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


		<div id="delurbana">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="relacion.inicial.delineacion.titulo" /></span>
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
												code="relacion.inicial.delineacion.cdu" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.tipo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.modalidad" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="relacion.inicial.delineacion.nurefrec" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.sticker" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.tipdocu" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.fecprese" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.delineacion.totrete" /> </label></th>
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
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div id="delurbana-retenciones">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="relacion.inicial.delineacion.retencion.titulo" /></span>
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

		<div id="gasolina">
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
									<th><label class="control-label labeltabletd"><spring:theme
												code="relacion.inicial.gasolina.nurefrec" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.gasolina.sticker" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.gasolina.tipdoc" /> </label></th>
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


		<div id="publiext">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme
								code="relacion.inicial.publicidad.titulo" /></span>
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
												code="relacion.inicial.publicidad.sticker" /> </label></th>
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
									<td><input class="inputtextnew tabledoobli" disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli" disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli" disabled="disabled"
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
		</div>
	</sf:form>
</div>


