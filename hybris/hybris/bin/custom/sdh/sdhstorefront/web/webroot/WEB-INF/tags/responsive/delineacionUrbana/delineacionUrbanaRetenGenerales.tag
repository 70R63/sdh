<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span><spring:theme
						code="delineacion.urbana.dec.generales.title" /></span>
			</h2>
		</div>
	</div>


		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.codigo" /></label>
					<sf:input class="form-control" readonly="true" aria-required="true"
						maxlength="240" path="input.selectedCDU" />
				</div>
			</div>

			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.anigrav" /></label>
					<div class="form-group ">
						<sf:select path="infObjetoDelineacionExtras.anoGravable"
							items="${dataForm.catalogos.anoGravable}"
							referenceData="${dataForm.catalogos.anoGravable}"
							class="form-control" disabled="true" readonly="true"></sf:select>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.radic" /></label>
					<sf:input class="form-control" readonly="true" aria-required="true"
						maxlength="240"
						path="input.selectedRadicado" />
				</div>
			</div>


			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.opuso" /></label>
					<sf:input class="form-control" readonly="true" aria-required="true"
						maxlength="240" path="infObjetoDelineacion.infoDeclara.opcionUso" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.tiplicencia" /></label>
					<div class="form-group ">
						<sf:select path="infObjetoDelineacion.infoDeclara.tipoLicencia"
							items="${dataForm.catalogos.tipoDeLicencia}"
							referenceData="${dataForm.catalogos.tipoDeLicencia}"
							class="form-control"></sf:select>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.modlicencia" /></label>
					<sf:select class="form-control" id="an" onchange="obranueva(this)"
						path="input.selectedTipoLicencia"
						items="${dataForm.catalogos.modalidadLicencia}">
					</sf:select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.areasusos.preobra" /></label>
					<sf:select class="form-control" id="an" onchange="obranueva(this)"
						path="infObjetoDelineacion.infoDeclara.presupuestoObra"
						items="${dataForm.catalogos.presupuestoObra}"></sf:select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.areasusos.cauexen" /></label>
					<sf:select class="form-control" onchange="costoshabil(this)" path="infObjetoDelineacion.infoDeclara.causalExcep"
						items="${dataForm.catalogos.causalExencion}"></sf:select>
				</div>
			</div>
		</div>

</div>

