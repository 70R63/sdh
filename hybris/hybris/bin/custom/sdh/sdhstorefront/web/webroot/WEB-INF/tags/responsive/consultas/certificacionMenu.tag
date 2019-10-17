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
	var="certificacionURL" htmlEscape="false" />

<script>

	function SelectedAnio(selectObject) {
//		debugger;
	ACC.opcionDeclaraciones.obtenerListaDeclaraciones_certiPagos();

	}
	
	function valper(selectObject) {
		debugger;
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
		ACC.opcionDeclaraciones.obtenerListaDeclaraciones_certiPagos();

	}
	
	function onChange_anterior(anoGravableGasolina,anoGravablePublicidad) {
			form = document.getElementById("form_pdf");

			input = document.createElement('input');
	        input.setAttribute('name', 'rowFrompublicidadTable');
	        input.setAttribute('value', 'X');
	        input.setAttribute('type', 'hidden');
	        
	        form.appendChild(input);
			form.submit();
		
	}
	
	function onChangeAnioGravable() {
		impuesto = document.getElementById("Idimp").value;
		if(impuesto == 4){
			form = document.getElementById("form_pdf");
			form.submit();
		}			
	}
	
	function downloadPDF(pdf) {
		debugger;
		if (pdf){
			const linkSource = 'data:application/pdf;base64,' + pdf;
		    const downloadLink = document.createElement("a");
		    const fileName = "Certificación_Pago.pdf";	
		    downloadLink.href = linkSource;
		    downloadLink.download = fileName;
		    downloadLink.click();
		}    
	}	
// 	downloadPDF('${imprimePagoResponse.stringPDF}');
</script>

<a id="downloadHelper" target="_blank"></a>
<c:choose>
	<c:when test="${certiFormPost.idimp == 4}">
		<c:set var="anioGravable" value="${anoGravablePublicidad}" />
	</c:when>

	<c:when
		test="${certiFormPost.idimp == 5 or certiFormPost.idimp == 3 or certiFormPost.idimp == 7  or certiFormPost.idimp == 6}">
		<c:set var="anioGravable" value="${anoGravableGasolina}" />
	</c:when>


	<c:otherwise>
	</c:otherwise>
</c:choose>


<div class="container_new_page">
	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme code="certificacion.inicial.titulo" /> </span>
			</h2>
		</div>
	</div>

	<form:form id="form_pdf" action="" method="post" commandName="dataForm">

		<input type="hidden" name="numBP" value="${certiForm.numBP}" />
		<input type="hidden" name="rowFrompublicidadTable" value="" />

		<div class="row">
			<div class="col-md-4 col-xs-12 mb-20 no-marginright" id="idImpuesto"
				style="display: block;">
				<span class="paso--uno pasos color-sr1">1</span>
				<h2 class="titulo-caja--ser-rel color-sr1 ">CERTIFICACIÓN DE
					PAGO</h2>
				<p class="pasoClase1 metrophobic">Selecciona el impuesto que
					deseas consultar.</p>
				<div class="caja--ser-rel color-sr1">
					<div class="form-group">
						<sf:select class="new_alto form-control seleccion" id="seleccion"
							onchange="onChange(this)" path="claveImpuesto"
							items="${dataForm.catalogos.impuesto}"
							referenceData="${dataForm.catalogos.impuesto}" />
					</div>
				</div>
			</div>


			<div class="col-md-4 col-xs-12 mb-20 no-margincol">
				<span class="paso--dos pasos color-sr2">2</span>
				<h2 class="titulo-caja--ser-rel color-sr2 ">
					<span class="paso2">AÑO GRAVABLE</span>
				</h2>
				<p class="pasoClase2 metrophobic">Selecciona el año gravable.</p>
				<div class="caja--ser-rel color-sr2">
					<select id="aniograv" class="new_alto form-control" name="aniograv"
						onchange="SelectedAnio(this)">
						<option value="00">Seleccionar</option>
						<option value="2019">2019</option>
						<option value="2018">2018</option>
						<option value="2017">2017</option>
						<option value="2016">2016</option>
					</select>

				</div>
			</div>

			<div class="Periodo1" id="Periodo1" style="display: none">
				<div class="col-md-4 col-xs-12 mb-20 no-marginleft">
					<span class="paso--tres pasos color-sr3 rajdhani">3</span>
					<h2 class="titulo-caja--ser-rel color-sr3 paso3">PERIODO</h2>
					<p class="pasoClase3 metrophobic">Selecciona el periodo.</p>
					<div class="caja--ser-rel color-sr3">
						<select aria-required="true" id="periodo"
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
					<select id="periodo" class="new_alto form-control " name="periodo"
						onchange="vaperiodo(this)">
						<option value="00">Seleccionar</option>
						<option value="B1">1 - Ene / Feb</option>
						<option value="B2">2 - Mar / Abr</option>
						<option value="B3">3 - May / Jun</option>
						<option value="B4">4 - Jul / Ago</option>
						<option value="B5">5 - Sep / Oct</option>
						<option value="B6">6 - Nov / Dic</option>
					</select>
				</div>
			</div>
		</div>


		<br>
		
				<div class="row" id="table-predial" style="display: none;">
			<div class="col-md-6 col-md-offset-3">
				<table class="table" id="table-predial1">
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

<!-- 						<tr> -->
<!-- 							<td><input style="width: 100%" class="inputtextnew" -->
<!-- 								maxlength="30" size="30" disabled="disabled" type="text" -->
<%-- 								value="<c:out value="CHIP"></c:out>" /></td> --%>
<!-- 							<td><input style="width: 100%" class="inputtextnew" -->
<!-- 								maxlength="30" size="30" disabled="disabled" type="text" -->
<%-- 								value="<c:out value="Matricula"></c:out>" /></td> --%>
<!-- 							<td><input style="width: 100%" class="inputtextnew" -->
<!-- 								maxlength="30" size="30" disabled="disabled" type="text" -->
<%-- 								value="<c:out value="Direccion"></c:out>" /></td> --%>
<!-- 							<td><input class="inputtextnew" -->
<!-- 								style="visibility: visible !important; width: 15px" type="radio" -->
<!-- 								id="" name="" value=""></td> -->

<!-- 						</tr> -->
					</tbody>
				</table>
			</div>
		</div>

		<div class="row" id="table-vehiculos" style="display: none;">
			<div class="col-md-6 col-md-offset-3">
				<table class="table" id="table-vehiculos1">
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

<!-- 						<tr> -->
<!-- 							<td><input style="width: 100%" class="inputtextnew" -->
<!-- 								maxlength="30" size="30" disabled="disabled" type="text" -->
<%-- 								value="<c:out value="PLACA"></c:out>" /></td> --%>
<!-- 							<td><input style="width: 100%" class="inputtextnew" -->
<!-- 								maxlength="30" size="30" disabled="disabled" type="text" -->
<%-- 								value="<c:out value="MARCA"></c:out>" /></td> --%>
<!-- 							<td><input class="inputtextnew" -->
<!-- 								style="visibility: visible !important; width: 15px" type="radio" -->
<!-- 								id="" name="" value=""></td> -->

<!-- 						</tr> -->
					</tbody>
				</table>
			</div>
		</div>


		<div class="row" id="table-ica" style="display: none;">
			<div class="col-md-6 col-md-offset-3">
				<table class="table" id="table-ica1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="certideclara.inicial.selcimpuesto" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.desc_clavePeriodo" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.referencia" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.importe" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.moneda" /></label></th>
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
		

		<div class="row" id="table-reteica" style="display: none;">
			<div class="col-md-6 col-md-offset-3">
				<table class="table" id="table-reteica1">
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
										code="certideclara.inicial.gasolina.desc_clavePeriodo" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.referencia" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.importe" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.moneda" /></label></th>
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
		

		<div class="row" id="table-publicidad" style="display: none;">
			<div class="col-md-6 col-md-offset-3">
				<table class="table" id="table-publicidad1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="certideclara.inicial.publicidad.numresol" /></label></th>
							<th style="text-align: center"><label class="control-label">
									<spring:theme code="certideclara.inicial.publicidad.tipvalla" />
							</label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.desc_clavePeriodo" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.referencia" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.importe" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.moneda" /></label></th>
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
		
		
		
		<div class="row" id="table-gasolina" style="display: none;">
			<div class="col-md-6 col-md-offset-3">
				<table class="table" id="table-gasolina1">
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
										code="certideclara.inicial.gasolina.desc_clavePeriodo" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.referencia" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.importe" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.moneda" /></label></th>
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
		
		<div class="row" id="table-delineacion" style="display: none;">
			<div class="col-md-6 col-md-offset-3">
				<table class="table" id="table-delineacion1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="certideclara.inicial.delineacion.cdu" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.desc_clavePeriodo" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.referencia" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.importe" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="certideclara.inicial.gasolina.moneda" /></label></th>
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
		

		<div class="row">
			<div class="col-md-12 text-center">
				<div class="form-group ">
					<button type="button" class="btn btn-primary btn-lg"
						id="btnCancelar" name="action" value="cancelar"
						style="margin-top: 3px">
						<spring:theme code="certificacion.inicial.cancelar" />
					</button>

					<button type="submit" class="btn btn-primary btn-lg !important certiPagosImprime"
						id="certiPagosImprimeButton" name="certiPagosImprimeButton"
						style="margin-top: 3px">
						<spring:theme code="certificacion.inicial.generar" />
					</button>
				</div>
			</div>
		</div>

	</form:form>



	

</div>
<div id="dialog" title="Generar Certificacion">
	<div id="certiDialogContent"></div>
</div>


<script type="text/javascript">
	
 	document.getElementById("btnCancelar").addEventListener("click", function(){
 		location = self.location;
	});
	
	
	function ShowSelected(selectObject) {
		var value = selectObject.value;

		var idImpuesto = document.getElementById('idImpuesto');
		var idAnio = document.getElementById('idAnio');
		var idPeriodo = document.getElementById('idPeriodo');
		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');

		if (value == '1') {
			idImpuesto.style.display = 'block';
			idAnio.style.display = 'none';
			idPeriodo.style.display = 'none';
			document.getElementById("Idper").value = '';
		} else if (value == '2') {
			idImpuesto.style.display = 'none';
			idAnio.style.display = 'block';
			idPeriodo.style.display = 'none';
			
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			document.getElementById("Idimp").value = '';
			document.getElementById("Idper").value = '';
		} else {
			idImpuesto.style.display = 'none';
			idAnio.style.display = 'none';
			idPeriodo.style.display = 'none';
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			document.getElementById("Idper").value = '';
		}
	}
	function Selected(selectObject) {
		var value = selectObject.value;
		document.getElementById("Idimp").value = value;
		var idAnio = document.getElementById('idAnio');
		var idPeriodo = document.getElementById('idPeriodo');
		
		var idPeriodo = document.getElementById('idPeriodo');
		
		if (value == '1' || value == '2' || value == '4') {

			idAnio.style.display = 'block';
			idPeriodo.style.display = 'none';
			;
			document.getElementById("Idper").value = '';

		}else if (value == '5' || value == '6' || value == '3') {
			idAnio.style.display = 'block';
			idPeriodo.style.display = 'block';
		} else {

			idAnio.style.display = 'none';
		

		}
	}

// 	function SelectedAnio(selectObject) {
// 		var value = selectObject.value;
// 		document.getElementById("Idanio").value = value;
// 		var x = document.getElementById('Idimp').value;
// 		var tablepredial = document.getElementById('table-predial');
// 		var tablevehiculos = document.getElementById('table-vehiculos');
// 		var tableica = document.getElementById('table-ica');
// 		var tablepublicidad = document.getElementById('table-publicidad');
// 		if (x == '1') {

// 			tablepredial.style.display = 'block';
// 			tablevehiculos.style.display = 'none';
// 			tableica.style.display = 'none';
// 			tablepublicidad.style.display = 'none';

// 		} else if (x == '2') {

// 			tablepredial.style.display = 'none';
// 			tablevehiculos.style.display = 'block';
// 			tableica.style.display = 'none';
// 			tablepublicidad.style.display = 'none';

// 		} else if (x == '4') {
// 			tablepredial.style.display = 'none';
// 			tablevehiculos.style.display = 'none';
// 			tableica.style.display = 'none';
// 			tablepublicidad.style.display = 'block';

// 		} else {

// 			tablepredial.style.display = 'none';
// 			tablevehiculos.style.display = 'none';
// 			tableica.style.display = 'none';
// 			tablepublicidad.style.display = 'none';
// 		}

// 	}



	function SelectSobreDeli(selectObject) {
		var value = selectObject.value;
		document.getElementById("Idper").value = value;
		var x = document.getElementById('Idimp').value;
		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');
		if (x == '5' || x == '6') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';

		} else if(x == '3'){
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'block';
			tablepublicidad.style.display = 'none';
			
		}	else {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
		}
	}
	
	function reiniciaConsultaPublicidad(){
		debugger;
		impuesto = document.getElementById("Idimp");
		impuesto.value = "";
		
		form = document.getElementById("form_pdf");
		form.submit();
	}
	
	<!-- se agrega control para tablas de delineación -->

	function ShowSelected(selectObject) {
		var value = selectObject.value;
		var idLic = document.getElementById('selectiplic');
		var idrad = document.getElementById('idRadicados');
		if (value == '1') {
			idLic.disabled = false;
			idLic.selectedIndex = "";
			idrad.style.display = 'none';
		} else if (value == '2') {
			idLic.disabled = true;
			idLic.selectedIndex = "1";
			idrad.style.display = 'block';
		} else {
			idrad.style.display = 'none';
		}
	}
	
	function onChange(selectObject) {
// 				debugger;
		var impuesto = selectObject.value;
		var per = document.getElementById('Periodo1');
		var per2 = document.getElementById('Periodo2');

		if (impuesto == '0005') {
			per.style.display = 'block';
			per2.style.display = 'none';
		} else if (impuesto == '0004') {
			per2.style.display = 'block';
			per.style.display = 'none';

		} else {
			per.style.display = 'none';
			per2.style.display = 'none';
		}
		document.getElementById('aniograv').value = '00'; 
		document.getElementById('periodo').value = '00'; 
		ACC.opcionDeclaraciones.ocultarTablas();
	}
	
	

	
</script>

