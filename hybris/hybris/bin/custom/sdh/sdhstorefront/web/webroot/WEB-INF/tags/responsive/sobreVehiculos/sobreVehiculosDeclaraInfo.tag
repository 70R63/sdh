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
						code="sobre.vehiculo.declaracion.vehiculo.info.title" /></span>
			</h2>
		</div>
	</div>



	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.objcontra" /></label><input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.captone" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.clase" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.carroceria" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.marca" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.cilindra" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.linea" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.tipvehi" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.modelo" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.avaluo" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.blindado" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.clasant" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.cappasa" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.idservicio" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.fecfactura" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.watts" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>
	</form:form>
</div>

