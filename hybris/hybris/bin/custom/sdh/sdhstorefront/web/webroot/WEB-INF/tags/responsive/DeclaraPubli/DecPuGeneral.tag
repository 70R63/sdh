<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new">
	<div class="row">
		<div class="col-md-12 headline">
			<h2>
				<span class="col-md-10"><spring:theme
						code="declaracion.publicidad.titulo" /></span>
			</h2>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span class="col-md-10"><spring:theme
						code="declaracion.publicidad.datgene" /></span>
			</h2>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="declaracion.publicidad.anogravable" /></label> <select id="anograv"
					class="form-control" disabled="disabled">
					<option value="${declaPublicidadForm.anograv}">${declaPublicidadForm.anograv}</option>
				</select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="declaracion.publicidad.opuso" /></label> <select id="opuso"
					class="form-control" disabled="disabled">
					<option value="${declaPublicidadForm.opuso}"><spring:theme
							code="declaracion.publicidad.opuso.d${declaPublicidadForm.opuso}">
						</spring:theme></option>
				</select>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="declaracion.publicidad.numresol" /></label> <input id="numresol"
					name="numresol" class="form-control" aria-required="true"
					type="text" value="${declaPublicidadForm.numresol}" maxlength="30"
					disabled="disabled">
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="declaracion.publicidad.fenoti" /></label> <input id="fechnotif"
					name="fechnotif" class="form-control" aria-required="true"
					value="${declaPublicidadForm.fechnotif}" maxlength="30"
					disabled="disabled">
			</div>
		</div>
	</div>
</div>


