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
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.codigo" /></label>
				<sf:input class="newalto form-control" readonly="true"
					aria-required="true" maxlength="240" path="input.selectedCDU" />
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.radic" /></label>
				<sf:input class="newalto form-control" readonly="true"
					aria-required="true" maxlength="240" path="input.selectedRadicado" />
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.anigrav" /></label>
				<div class="form-group ">
<%-- 					<sf:select path="infObjetoDelineacionExtras.anoGravable" --%>
<%-- 						items="${dataForm.catalogos.anoGravable}" --%>
<%-- 						referenceData="${dataForm.catalogos.anoGravable}" --%>
<%-- 						class="newalto form-control" disabled="true" readonly="true"></sf:select> --%>
						
						<sf:input class="newalto form-control" readonly="true"
					aria-required="true" maxlength="240" path="infObjetoDelineacionExtras.anoGravable" value="${dataForm.infObjetoDelineacionExtras.anoGravable}" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.Objetolicencia" /></label>
				<div class="form-group ">
					<sf:select path="infObjetoDelineacion.infoDeclara.objetoLicen"
						items="${dataForm.catalogos.objetoLicencia}"
						referenceData="${dataForm.catalogos.objetoLicencia}"
						class="new_alto form-control"></sf:select>
				</div>
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.modlicencia" /></label>
				<sf:select class="new_alto form-control" id="an"
					onchange="obranueva(this)"
					path="infObjetoDelineacion.infoDeclara.modalidad"
					items="${dataForm.catalogos.modalidadLicencia}">
				</sf:select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.areasusos.preobra" /></label>
				<sf:select class="new_alto form-control" name="presupuestoObra"
					id="presupuestoObra" onchange="presupuestoObraCHANGE(this)"
					path="infObjetoDelineacion.infoDeclara.presupuestoObra"
					items="${dataForm.catalogos.presupuestoObra}"></sf:select>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-8">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.areasusos.cauexen" /></label>
				<sf:select id="causalexcencion" class="new_alto form-control"
					onchange="costoshabil(this)"
					path="infObjetoDelineacion.infoDeclara.causalExcep"
					items="${dataForm.catalogos.causalExencion}" disabled="true" ></sf:select>
			</div>
		</div>
	</div>

</div>


<script>
	function presupuestoObraCHANGE(selectObject) {

		debugger;

		var x = selectObject.value;
		//Validacion presupuesto de obra = 02
		var totalRetencion = document.getElementById('totalRetencion');
		var causalexcencion = document.getElementById('causalexcencion');

		var totalRetencionOBLIGATORIO = document
				.getElementById('totalRetencionOBLIGATORIO');
		var presupuestoObra = selectObject.value;
		var valCausalExcencion = causalexcencion.value;

		if (presupuestoObra == "02" && valCausalExcencion != "00") {

			totalRetencion.disabled = false;
			totalRetencionOBLIGATORIO.value = 'X';
			caus.value = '02';

		} else {
			totalRetencion.disabled = true;
		}

	}

	function presupuestoObraLOAD() {

		debugger;

		var totalRetencion = document.getElementById('totalRetencion');

		var causalexcencion = document.getElementById('causalexcencion');
		var valCausalExcencion = causalexcencion.value;

		var presupuestoObra = document.getElementById('presupuestoObra');
		var valPresupuestoObra = presupuestoObra.value;

		if (valPresupuestoObra == "02" && valCausalExcencion != "00") {

			totalRetencion.disabled = false;
			totalRetencionOBLIGATORIO.value = 'X';
			caus.value = '02';

		} else {
			totalRetencion.disabled = true;
		}

	}

	function presupuestoObraLOAD();
</script>
