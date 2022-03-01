<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/contribuyentes/consultas/certipagos"
	var="certideclaraURL" htmlEscape="false" />


<a id="downloadHelper" target="_blank"></a>
<c:choose>
	<c:when test="${certiFormPost.idimp == '4'}">
		<c:set var="aniGravable" value="${anoGravablePublicidad}" />
	</c:when>
	<c:otherwise>
		<c:set var="aniGravable" value="${anoGravableGasolina}" />
	</c:otherwise>
</c:choose>


<div class="container_new_page">
	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme code="certideclara.inicial.titulo" /></span>
			</h2>
		</div>
	</div>

	<form:form id="form_pdf" action="" method="post" modelAttribute="dataForm">


		<input type="hidden" name="numBP" value="${certiForm.numBP}" />
		<input type="hidden" name="rowFrompublicidadTable" value="" />
		<input type="hidden" name="BanderaAgete" id="BanderaAgete" value="" />

		<div class="row">
			<div class="col-md-4 col-xs-12 mb-20 no-marginright certicontrib"
				id="certicontrib" style="display: none">
				<span class="paso--uno pasos color-sr1">1</span>
				<h2 class="titulo-caja--ser-rel color-sr1 ">CERTIFICAR
					DECLARACI�N</h2>
				<p class="pasoClase1 metrophobic">Selecciona el impuesto que
					deseas consultar.</p>
				<div class="caja--ser-rel color-sr1">
					<sf:select class="new_alto form-control seleccion" id="seleccion"
						onchange="onChange(this)" path="claveImpuesto"
						items="${dataForm.catalogos.impuesto}"
						referenceData="${dataForm.catalogos.impuesto}" />
				</div>
			</div>

			<div class="col-md-4 col-xs-12 mb-20 no-marginright certiagente"
				id="certiagente" style="display: none">
				<span class="paso--uno pasos color-sr1">1</span>
				<h2 class="titulo-caja--ser-rel color-sr1 ">CERTIFICAR
					DECLARACI�N</h2>
				<p class="pasoClase1 metrophobic">El Impuesto a consultar es:</p>
				<div class="caja--ser-rel color-sr1">
					<select class="new_alto form-control seleccion" id="selCerDecImpAR" disabled>
                      <option value="0004">Retenci?n ICA </option>                      
                    </select>
				</div>
			</div>

			<div class="col-md-4 col-xs-12 mb-20 no-margincol">
				<span class="paso--dos pasos color-sr2">2</span>
				<h2 class="titulo-caja--ser-rel color-sr2 ">
					<span class="paso2">A�O GRAVABLE</span>
				</h2>
				<p class="pasoClase2 metrophobic">Selecciona el a�o gravable.</p>
				<div class="caja--ser-rel color-sr2">
					<select id="aniograv" class="new_alto form-control aniograv" name="aniograv"
						onchange="SelectedAnio(this)">
						<option value="00">Seleccionar</option>
					</select>

				</div>
			</div>

			<div class="Periodo1" id="Periodo1" style="display: none">
				<div class="col-md-4 col-xs-12 mb-20 no-marginleft">
					<span class="paso--tres pasos color-sr3 rajdhani">3</span>
					<h2 class="titulo-caja--ser-rel color-sr3 paso3">PERIODO</h2>
					<p class="pasoClase3 metrophobic">Selecciona el periodo.</p>
					<div class="caja--ser-rel color-sr3">
						<select aria-required="true" id="periodoM"
							class="new_alto form-control " name="periodo" required='required'
							onchange="valper(this)">
							<option value="00">Seleccionar</option>
							<option value="01">1-Enero</option>
							<option value="02">2-Febrero</option>
							<option value="03">3-Marzo</option>
							<option value="04">4-Abril</option>
							<option value="05">5-Mayo</option>
							<option value="06">6-Junio</option>
							<option value="07">7-Julio</option>
							<option value="08">8-Agosto</option>
							<option value="09">9-Septiembre</option>
							<option value="10">10-Octubre</option>
							<option value="11">11-Noviembre</option>
							<option value="12">12-Diciembre</option>
						</select>
					</div>
				</div>
			</div>

			<div class="col-md-4 col-xs-12 mb-20 no-marginleft Periodo2"
				id="Periodo2" style="display: none">
				<span class="paso--tres pasos color-sr3 rajdhani">3</span>
				<h2 class="titulo-caja--ser-rel color-sr3 paso3">PERIODO</h2>
				<p class="pasoClase3 metrophobic">Selecciona el periodo.</p>
				<div class="caja--ser-rel color-sr3">
					<select id="periodoB" class="new_alto form-control " name="periodo"
						onchange="vaperiodo(this)">
						<option value="00">Seleccionar</option>
						<option value="01">1 - Ene / Feb</option>
						<option value="02">2 - Mar / Abr</option>
						<option value="03">3 - May / Jun</option>
						<option value="04">4 - Jul / Ago</option>
						<option value="05">5 - Sep / Oct</option>
						<option value="06">6 - Nov / Dic</option>
					</select>
				</div>
			</div>
		</div>

		<br>


		<div class="row" id="table-predial" style="display: none;" class="table-responsive">
			<div class="col-md-6 col-md-offset-3">
				<table class="table tabPaginacion" id="table-predial1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="certideclara.inicial.predio.chip" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.predio.matricula" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.predio.direccion" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.predio.seleccionar" /></label></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row" id="table-vehicular" style="display: none;" class="table-responsive">
			<div class="col-md-6 col-md-offset-3">
				<table class="table tabPaginacion" id="table-vehicular1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="certideclara.inicial.vehiculo.placa" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.vehiculo.marca" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.vehiculo.seleccionar" /></label></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>


		<div class="row" id="table-ica" style="display: none;" class="table-responsive">
			<div class="col-md-6 col-md-offset-3">
				<table class="table tabPaginacion" id="table-ica1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="certideclara.inicial.selcimpuesto" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.aniograv" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.ica.seleccionar" /></label></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>


		<div class="row" id="table-reteica" style="display: none;" class="table-responsive">
			<div class="col-md-6 col-md-offset-3">
				<table class="table tabPaginacion" id="table-reteica1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="certideclara.inicial.reteica.numID" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.reteica.consecutivo" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.reteica.seleccionar" /></label></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>


		<div class="row" id="table-publicidad" style="display: none;" class="table-responsive">
			<div class="col-md-6 col-md-offset-3">
				<table class="table tabPaginacion" id="table-publicidad1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="certideclara.inicial.publicidad.numresol" /></label></th>
							<th style="text-align: center"><label class="control-label">
									<spring:theme code="certideclara.inicial.publicidad.tipvalla" />
							</label></th>
							<th style="text-align: center"><label class="control-label">
									<spring:theme
										code="certideclara.inicial.publicidad.seleccionar" />
							</label></th>

						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>



		<div class="row" id="table-gasolina" style="display: none;" class="table-responsive">
			<div class="col-md-6 col-md-offset-3">
				<table class="table tabPaginacion" id="table-gasolina1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="certideclara.inicial.gasolina.tipdocu" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.numdocu" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.seleccionar" /></label></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row" id="table-delineacion" style="display: none;" class="table-responsive">
			<div class="col-md-6 col-md-offset-3">
				<table class="table tabPaginacion" id="table-delineacion1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="certideclara.inicial.delineacion.cdu" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.delineacion.radicado" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.delineacion.seleccionar" /></label></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>


		<div class="row" id="formButtons">
			<div class="col-md-12 text-center">
				<div class="form-group ">
					<button type="button" class="btn btn-secondary btn-lg"
						id="btnCancelar" name="action" value="cancelar"
						style="margin-top: 3px">
						<spring:theme code="certideclara.inicial.cancelar" />
					</button>

					<button type="submit"
						class="btn btn-primary btn-lg !important declaracionImprime"
						id="imprimirDecButton" name="imprimirDecButton"
						style="margin-top: 3px" onclick="">
						<spring:theme code="certideclara.inicial.generar" />
					</button>
				</div>
			</div>
		</div>

	</form:form>

</div>


<div id="dialog" title="Generar certideclara">
	<div id="certiDialogContent"></div>
</div>


<script type="text/javascript">
	
	document.getElementById("btnCancelar").addEventListener("click", function(){
		location = self.location;
	});
	
	function onChange(selectObject) {
		ACC.opcionDeclaraciones.preparaAnioGravable(ACC.configCatalogos_ambito_certiDeclaracion);
		ACC.opcionDeclaraciones.ocultarTablas();
		ACC.opcionDeclaraciones.reiniciaCertipagos();
		ACC.opcionDeclaraciones.prepararPeriodo();
	}
	
	function SelectedAnio(selectObject) {
		ACC.opcionDeclaraciones.obtenerListaDeclaraciones_porAnio();

	}

	function valper(selectObject) {
		var per = selectObject.value;
		var anio = document.getElementById('aniograv').value;
		var fecha = new Date();
		var anioact = fecha.getFullYear();
		var mesact = fecha.getMonth();

		if (anio < anioact) {

		} else {
			mesact = mesact + 1;
			if (per < mesact) {

			} else {
				alert("Por favor, seleccione un mes anterior");
			}

		}
		ACC.opcionDeclaraciones.obtenerListaDeclaraciones();

	}

	function vaperiodo(selectObject) {

		ACC.opcionDeclaraciones.obtenerListaDeclaraciones();
	}
		
		function downloadPDF(pdf, newfilename) {
			if (pdf){
				const linkSource = 'data:application/pdf;base64,' + pdf;
			    const downloadLink = document.createElement("a");
			    var fileName = newfilename;	
			    downloadLink.href = linkSource;
			    downloadLink.download = fileName;
			    downloadLink.click();
			}    
		}
	
		downloadPDF('${imprimeCertiDeclaraResponse.stringPDF}','Certificaci�n_Declaracion.pdf');
</script>
