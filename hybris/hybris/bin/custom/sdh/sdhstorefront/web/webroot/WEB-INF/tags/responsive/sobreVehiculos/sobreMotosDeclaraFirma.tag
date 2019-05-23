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
						code="sobre.vehiculo.declaracion.moto.firma.title" /></span>
			</h2>
		</div>
	</div>

	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.moto.firma.tipiden" /></label><input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.moto.firma.numiden" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled>
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.moto.firma.nom" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" value="" maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<button id="" class="btn btn-secondary" type="button" onclick="goBack()">
						<spring:theme
							code="sobre.vehiculo.declaracion.moto.firma.regresar" />
					</button>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<button id="" class="btn btn-primary" type="button">
						<spring:theme
							code="sobre.vehiculo.declaracion.moto.firma.prendeclar" />
					</button>
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group">
					<button id="" class="btn btn-primary" type="button">
						<spring:theme
							code="sobre.vehiculo.declaracion.moto.firma.paglinea" />
					</button>
				</div>
			</div>

		</div>



	</form:form>
</div>

