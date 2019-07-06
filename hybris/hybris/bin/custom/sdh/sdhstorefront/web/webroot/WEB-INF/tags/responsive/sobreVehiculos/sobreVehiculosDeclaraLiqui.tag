<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span><spring:theme
						code="sobre.vehiculo.declaracion.vehiculo.liq.title" /></span>
			</h2>
		</div>
	</div>

	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.valimpcar" /></label><input
						id="" name="numresol" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.proapovol" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30">
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.avalact" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.sancion" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.taract" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.intereses" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.clasdh" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.valsemafo" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.tipvesdh" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.despronpag" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.linhomo" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.totpag" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.apovol" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.valpagar" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.liq.totpagvol" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<button id="" class="btn btn-primary btn-lg btn-block" type="button" style="margin-top: 28px !important">
					<spring:theme
						code="sobre.vehiculo.declaracion.vehiculo.liq.calcular" />
				</button>
			</div>
		</div>
	</form:form>
</div>

