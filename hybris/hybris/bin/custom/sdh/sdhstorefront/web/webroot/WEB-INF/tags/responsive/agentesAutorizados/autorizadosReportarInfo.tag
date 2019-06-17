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
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="autorizado.reportar.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme
								code="autorizado.reportar.inicial.descripcion" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="headline text-center">
				<h1>
					<span class="col-md-10 "><spring:theme
							code="autorizado.reportar.reportar.titulo" /></span>
				</h1>
			</div>
		</div>
		<div class="col-md-12 text-center">
			<p>
				<spring:theme code="autorizado.reportar.reportar.nota" />
			</p>

		</div>
	</div>
	<hr
		style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />

	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="autorizado.reportar.info.titulo" /></span>
				</h2>
			</div>
		</div>

	</div>

	<form:form action="">
		<div class="row" style="margin-top: 6px;">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label required"
						style="text-transform: none"><spring:theme
							code="autorizado.reportar.info.tiparch" /></label> <select
						class="form-control">
						<option value="Seleccionar">Seleccionar</option>
						<option value="Formularios">Formularios no generados por
							la administración</option>
						<option value="Pagos con debito">Pagos con débito</option>
						<option value="Pagos con tarjeta de credito">Pagos con
							tarjeta de crédito</option>
						<option value="Declaraciones">Declaraciones</option>
						<option value="Electronicos">Electrónicos</option>
						<option value="Facturas, cupones y ROP's">Facturas,
							cupones y ROP's</option>
						<option value="Reportes de adhesivos">Reportes de
							adhesivos</option>
						<option value="Consignaciones">Consignaciones</option>
						<option value="Publicidad exterior">Publicidad exterior</option>
						<option value="Sobretasa de la gasolina">Sobretasa de la
							gasolina</option>
					</select>

				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label required"
						style="text-transform: capitalize"><spring:theme
							code="autorizado.reportar.info.selarch" /></label><input type="file"
						class="form-control" id="exampleFormControlFile1" accept=".txt">
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 6px;">
			<div class="col-md-12 centercol-md-8 text-center">

				<button style="margin-top: 3px;" id="regresar"
					class="btn btn-secondary btn-lg" onclick="goBack()" type="button">
					<spring:theme code="autorizado.reportar.info.regresar" />
				</button>
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="autorizado.reportar.info.cancelar" />
				</button>
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="autorizado.reportar.info.enviar" />
				</button>
			</div>
		</div>
	</form:form>
</div>
