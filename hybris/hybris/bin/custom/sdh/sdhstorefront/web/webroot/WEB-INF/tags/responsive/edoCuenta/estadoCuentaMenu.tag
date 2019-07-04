<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />


<div class="container_new">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="edocuenta.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="edocuenta.inicial.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información.</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="headline">
			<h2>
				<span><spring:theme code="edocuenta.inicial.titulo" /></span>

			</h2>
		</div>
	</div>


	<sf:form>
		<div class="row mt-md-3">


			<div class="col-md-6">
				<div class="card cardsinfondo">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.tipiden" /></label> <input
									class="form-control" maxlength="30" size="30"
									disabled="disabled" type="text"
									value="<c:out value=""></c:out>" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.numiden" /></label> <input
									class="form-control" maxlength="30" size="30"
									disabled="disabled" type="text"
									value="<c:out value=""></c:out>" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.nom" /></label> <input class="form-control"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value=""></c:out>" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.fecgen" /></label> <input
									class="form-control" maxlength="30" size="30"
									disabled="disabled" type="text"
									value="<c:out value=""></c:out>" />
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.tasint" /></label> <input
									class="form-control" maxlength="30" size="30"
									disabled="disabled" type="text"
									value="<c:out value=""></c:out>" />
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="col-md-4">
				<div class="card cardsinfondo">
					<div class="row">
						<div class="col-md-10" id="idImpuesto">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.selcimpuesto" /></label> <select
									id="impuesto" class="form-control " name="impuesto"
									onchange="Selected(this)">
									<option value="0">Seleccionar</option>
									<option value="1">Predial Unificado</option>
									<option value="2">Vehículos</option>
									<option value="3">ICA</option>
									<option value="4">Publicidad Exterior</option>
									<option value="5">Sobretasa Gasolina</option>
									<option value="6">Delineación Urbana</option>
									<option value="7">Obligaciones no tributarias</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-10">
							<div class="form-group">
								<label class="control-label text-right"><spring:theme
										code="edocuenta.inicial.aniograv" /></label> <select
									aria-required="true" id="aniograva" class="form-control "
									name="aniograva" onchange="" required>
									<option value="">Seleccionar</option>
									<option value="1">2019</option>
								</select>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<button type="submit" class="btn btn-secondary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.sujeto.regresar" />
					</button>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="obligacion.sujeto.descargar" />
					</button>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group ">
					<button type="button" class="btn btn-primary btn-lg" id="action"
						name="action" value="buscar" style="margin-top: 3px"
						onclick=" Selectedver(this)">
						<spring:theme code="obligacion.inicial.buscar" />
					</button>

				</div>
			</div>
			<div class="col-md-3">
				<button type="button" class="btn btn-secondary btn-lg" id="action"
					name="action" value="cancelar" style="margin-top: 3px"
					onclick="cancelfun(this)">
					<spring:theme code="obligacion.inicial.cancelar" />
				</button>

			</div>
		</div>
	</sf:form>
</div>


