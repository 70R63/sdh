<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span class="col-md-10"><spring:theme
					code="declaracion.publicidad.FirmaDeclarante" /></span>
		</h3>
	</div>
</div>

<div class="row" style="margin-top: 5px">
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="declaracion.publicidad.tipoiden" /></label> <select id="tipiden"
				class="form-control" disabled="disabled">
				<option value="CC"><spring:theme
						code="register.id.types.${declaPublicidadForm.idType}" /></option>
			</select>
		</div>
	</div>
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="declaracion.publicidad.numidenti" /></label> <input id="numide"
				name="numide" class="form-control" aria-required="true" type="text"
				value="${declaPublicidadForm.idNumber}" maxlength="30" size="30"
				disabled="disabled">
		</div>
	</div>
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="declaracion.publicidad.nombreyrazon" /></label> <input id="name"
				name="name" class="form-control" aria-required="true" type="text"
				value="${declaPublicidadForm.name}" maxlength="30" size="30"
				disabled="disabled">
		</div>
	</div>
</div>


