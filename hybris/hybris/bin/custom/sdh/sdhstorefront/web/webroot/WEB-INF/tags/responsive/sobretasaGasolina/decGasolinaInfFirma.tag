<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
	<div class="row">
		<div class="col-md-12">
			<h2>
				<span tabindex="0 headline"> <spring:theme
						code="impuestos.decGasolina.InformacionFirma.titulo" />
				</span>
			</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="impuestos.decGasolina.InformacionFirma.tipoId" /></label> <select
					class="form-control" disabled="disabled"></select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="impuestos.decGasolina.InformacionFirma.numeroId" /></label> <input
					value="${revisor.numDoc}" class="form-control" aria-required="true"
					maxlength="30" size="30" disabled="disabled" type="text" />
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="impuestos.decGasolina.InformacionFirma.denominacion" /></label> <input
					value="${revisor.nombre}" class="form-control" aria-required="true"
					maxlength="30" size="30" disabled="disabled" type="text" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group col-md-offset-4">
			<button class="btn btn-primary btn-lg" type="button">
				<spring:theme code="impuestos.decGasolina.InformacionFirma.Firma" />
			</button>
		</div>
	</div>

</sf:form>

