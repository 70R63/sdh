<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new">
	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.areasusos.fechultabo" /></label> <input
					id="fecultimabono" name="" class="form-control" aria-required="true" type="text"
					value="${dataForm.infObjetoDelineacion.infoDeclara.fechaUltAbono}"
					maxlength="240" disabled>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.areasusos.fecfinalobra" /></label> <input
					id="fecfinalobra" name="" class="form-control" aria-required="true" type="text"
					value="${dataForm.infObjetoDelineacion.infoDeclara.fechaFinalObra}"
					maxlength="240" disabled>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.areasusos.fechejec" /></label> <input id="fechejec"
					name="" class="form-control" aria-required="true" type="text"
					value="${dataForm.infObjetoDelineacion.infoDeclara.fechaEjecutaria}"
					maxlength="240" disabled>
			</div>
		</div>

	</div>
</div>



