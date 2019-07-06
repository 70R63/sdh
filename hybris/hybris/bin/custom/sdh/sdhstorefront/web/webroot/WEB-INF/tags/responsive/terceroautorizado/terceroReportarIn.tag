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
			<div class="avisoheadline " style="width: auto; height: 35px;">
				<h2>
					<span class="p"><spring:theme
							code="tercero.reportar.inicial.titulo" /></span>
				</h2>
			</div>
			<p class="avisobody" style="width: auto; height: auto;">
				<spring:theme code="tercero.reportar.inicial.descripcion" />
			</p>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="headline text-center">
				<h1>
					<span class="col-md-10 "><spring:theme
							code="tercero.reportar.reportar.titulo" /></span>
				</h1>
			</div>
		</div>
		<div class="col-md-12 text-center">
			<p>
				<spring:theme code="tercero.reportar.reportar.nota" />
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
							code="tercero.reportar.info.titulo" /></span>
				</h2>
			</div>
		</div>

	</div>

	<form:form action="">
		<div class="row" style="margin-top: 6px;">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label required"
						style="text-transform: capitalize"><spring:theme
							code="tercero.reportar.info.tiparch" /></label> <select
						class="new_alto form-control">
						<option value="Seleccionar">Seleccionar</option>
						<option value="Declaraciones">Declaraciones</option>
						<option value="PSE - Sobretasa a la gasolina">PSE -
							Sobretasa a la gasolina</option>
						<option value="Formularios no generados por la Administración">Formularios
							no generados por la Administración</option>
						<option value="Reporte de adhesivos">Reporte de adhesivos</option>
						<option value="Informe semanal de recaudo">Informe
							semanal de recaudo</option>
						<option value="Consignaciones">Consignaciones</option>
						<option value="Electrónicos">Electrónicos</option>
						<option value="Pagos PSE">Pagos PSE</option>
						<option value="Consignaciones-Conciliación recaudo">Consignaciones-Conciliación
							recaudo</option>
						<option value="Facturas, cupones y ROPs">Facturas,
							cupones y ROPs</option>
					</select>

				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label required"
						style="text-transform: capitalize"><spring:theme
							code="tercero.reportar.info.selarch" /></label><input type="file"
						class="new_alto form-control" id="exampleFormControlFile1" accept=".txt">
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 6px;">
			<div class="col-md-12 centercol-md-8 text-center">

				<button style="margin-top: 3px;" id="regresar"
					class="btn btn-primary btn-lg" onclick="goBack()" type="button">
					<spring:theme code="tercero.reportar.info.regresar" />
				</button>
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="tercero.reportar.info.cancelar" />
				</button>
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="tercero.reportar.info.enviar" />
				</button>
			</div>
		</div>
	</form:form>
</div>
