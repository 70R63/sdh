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
<script>
	function SelectedAnio(selectObject) {
// 		debugger;
		ACC.opcionDeclaraciones.obtenerListaDeclaraciones();

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
		ACC.opcionDeclaraciones.obtenerListaDeclaraciones();

	}

	function vaperiodo(selectObject) {
		debugger;
		var per = selectObject.value;
		var anio = document.getElementById('aniograv').value;
		var fecha = new Date();
		var anioact = fecha.getFullYear();
		var mesact = fecha.getMonth();
		var peract = '0';
		var valor = '0';
		var perselect = '0';

		if (anio < anioact) {

		} else {
			if (per == 'B1') {
				perselect = '1';
			} else if (per == 'B2') {
				perselect = '2';
			} else if (per == 'B3') {
				perselect = '3';
			} else if (per == 'B4') {
				perselect = '4';
			} else if (per == 'B5') {
				perselect = '5';
			} else if(per == 'B6')
			{
				perselect = '6';
			}

			mesact = mesact + 1;
			if (mesact == '1' || mesact == '2') {
				peract = 'B1';
				valor = '1';
			} else if (mesact == '3' || mesact == '4') {
				peract = 'B2';
				valor = '2';
			} else if (mesact == '5' || mesact == '6') {
				peract = 'B3';
				valor = '3';
			} else if (mesact == '7' || mesact == '8') {
				peract = 'B4';
				valor = '4';
			} else if (mesact == '9' || mesact == '10') {
				peract = 'B5';
				valor = '5';
			} else if (mesact == '11' || mesact == '12') {
				peract = 'B6';
				valor = '6';
			}
			
			if(perselect < valor){
				
			}else{
				alert("Seleccione un periodo anterior");
			}

		}

	}
</script>

<a id="downloadHelper" target="_blank"></a>
<div class="container_new_page">
	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme code="declaracion.inicial.titulo" /></span>
			</h2>
		</div>
	</div>

	<form:form id="" action="" method="post" commandName="dataForm">

		<div class="row">
			<div class="col-md-4 col-xs-12 mb-20 no-marginright">
				<span class="paso--uno pasos color-sr1">1</span>
				<h2 class="titulo-caja--ser-rel color-sr1 ">IMPRIMIR
					DECLARACIÓN</h2>
				<p class="pasoClase1 metrophobic">Selecciona el impuesto que
					deseas consultar.</p>
				<div class="caja--ser-rel color-sr1">
<!-- 					<select class="new_alto form-control seleccion" id="seleccion" -->
<!-- 						onchange="onChange(this)"> -->
<!-- 						<option>Seleccionar</option> -->
<!-- 						<option value="0001">Predial</option> -->
<!-- 						<option value="0002">Vehículos</option> -->
<!-- 						<option value="0003">Industria y Comercio</option> -->
<!-- 						<option value="0004">Reteica</option> -->
<!-- 						<option value="0005">Sobretasa Motor</option> -->
<!-- 						<option value="0006">Delineación Urbana</option> -->
<!-- 						<option value="0007">Publicidad Exterior Visual</option> -->
<!-- 						<option value="0008">Fondo Unif. Pobres, Azar y Esp</option> -->
<!-- 					</select> -->
					<sf:select class="new_alto form-control seleccion" id="seleccion" 
						onchange="onChange(this)"
						path="claveImpuesto" 
						items="${dataForm.catalogos.impuesto}"
						referenceData="${dataForm.catalogos.impuesto}" />
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
				<table class="table">
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
				<table class="table">
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
										code="certideclara.inicial.gasolina.seleccionar" /></label></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>


		<div class="col-md-9 col-md-offset-1 boder_section_cdu CDU" id="CDU"
			style="display: none">
			<br> <br>
			<div class="row">
				<div class="col-md-3">
					<label class="control-label" for="" style="text-transform: none">
						<spring:theme code="impuestos.presentarDeclaracion.deliur.cdu" />
					</label>
				</div>
				<div class="col-md-3">
					<label class="control-label" for="" style="text-transform: none">
						<spring:theme code="impuestos.presentarDeclaracion.deliur.tipobli" />
					</label>
				</div>
				<div class="col-md-3">
					<label class="control-label" for="" style="text-transform: none">
						<spring:theme code="impuestos.presentarDeclaracion.deliur.tiplic" />
					</label>
				</div>
				<div class="col-md-3">
					<label class="control-label" for="" style="text-transform: none">
						<spring:theme code="Evento" />
					</label>
				</div>
			</div>
			<div class="table-resposive" id="CDU1">
				<div class="row">
					<div class="col-sm-3">
						<input class="new_alto form-control" disabled="disabled"
							type="text" value="" style="margin-bottom: 9px !important" />
					</div>
					<div class="col-sm-3">
						<select id="selctipobliga" class="new_alto form-control"
							onchange="ShowSelected(this)">
							<option value="0">Seleccionar</option>
							<option value="1">Declaración</option>
							<option value="2">Retención</option>
						</select>
					</div>
					<div class="col-sm-3">
						<select id="" class="new_alto form-control">
							<option value="00">Seleccionar</option>
							<option value="01">Licencia</option>
							<option value="02">Reconocimiento</option>
						</select>
					</div>
					<div class="col-sm-3">
						<button type="button" class="btn-link" onClick="">
							<spring:theme code="delineacion.urbana.radicados.declaracion.pdf" />
						</button>
						<br> <br> <br>
					</div>
				</div>
				<br> <br>
				<div class="row" id="" style="display: none">

					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-4 text-right">Radicados:</div>
						<div class="col-sm-3">
							<input style="margin-bottom: 5px !important"
								class="new_alto form-control" disabled="disabled" type="text"
								value="" />
						</div>
						<div class="col-sm-3">
							<button type="button" class="btn-link" id="" onClick="">
								<spring:theme
									code="delineacion.urbana.radicados.declaracion.pdf" />
							</button>
						</div>
					</div>
				</div>

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
						class="btn btn-primary btn-lg !important consultaDecPDF"
						id="generarPDFButton" name="generarPDFButton"
						style="margin-top: 3px" onclick="">
						<spring:theme code="certideclara.inicial.generar" />
					</button>
				</div>
			</div>
		</div>


	</form:form>

	<br> <br>

	<!-- 	<button type="button" class="btn btn-primary btn-lg" id="regresar" -->
	<!-- 		onclick="reiniciaCertificaPublicidad()"> -->
	<%-- 		<spring:theme code="certificacion.inicial.regresar" /> --%>
	<!-- 	</button> -->




	<!--  
		<c:if test="${not empty consultaPagoDelineacionList}">
			<table id="myTable">
				<tr>
					<th>CDU</th>
					<th>FECHA DE EXPEDICION</th>
					<th>IMPRIMIR</th>
				</tr>
				<c:forEach var="item" items="${consultaPagoDelineacionList}">
					<tr>
						<td><c:out value="${item.cdu}" /></td>
						<td><c:out value="${item.fechaExp}" /></td>
						<td><form:form id="form_pdf"
								action="/sdhstorefront/es/contribuyentes/consultas/certideclaraciones"
								method="post" commandName="certiFormPost">
								<input type="hidden" name="tipoImp" value="1" />
								<input type="hidden" name="Idimp" value="6" />
								<input type="hidden" name="rowFrompublicidadTable" value="X" />
								<input type="hidden" name="numObjeto" value="${item.numObjeto}" />
								<input type="hidden" name="aniograv" value="${item.fechaExp}" />
							
								<button type="submit" class="btn btn-primary btn-lg"
									id="generarPDFButton" name="generarPDFButton">
									<spring:theme code="certificacion.inicial.generar" />
								</button>
							</form:form></td>
					</tr>
				</c:forEach>
			</table>

			<br>
			<br>

			<button type="button" class="btn btn-primary btn-lg" id="regresar"
				onclick="reiniciaCertificaPublicidad()">
				<spring:theme code="certificacion.inicial.regresar" />
			</button>

		</c:if>-->



</div>
<br>
<br>
<br>




<script type="text/javascript">
	document.getElementById("btnCancelar").addEventListener("click",
			function() {
				location = self.location;
			});

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

		} else if (value == '5' || value == '6' || value == '3') {
			idAnio.style.display = 'block';
			idPeriodo.style.display = 'block';
		} else {

			idAnio.style.display = 'none';

		}
	}

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

		} else if (x == '3') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'block';
			tablepublicidad.style.display = 'none';

		} else {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
		}
	}

	function reiniciaCertificaPublicidad() {
		debugger;
		impuesto = document.getElementById("tipoimp");
		impuesto.value = "";

		form = document.getElementById("form_pdf");
		form.submit();
	}

	// 	<!-- se agrega control para tablas de delineación

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
</script>

<!-- se agrega control para tablas de delineación -->
<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;
		var selected = value.substring(0, 1);
		var div = value.substring(2, value.length);
		var x = document.getElementById(div);
		var tipoLicencia = document.getElementById("btnTpLic_" + div);
		var btnDeclaracion = document.getElementById("btn_" + div);

		if (selected === "2") {
			x.style.display = "block";
			tipoLicencia.selectedIndex = "1"
			tipoLicencia.disabled = true;
			btnDeclaracion.disabled = true;
		} else {
			x.style.display = "none";
			tipoLicencia.selectedIndex = "0"
			tipoLicencia.disabled = false;
			btnDeclaracion.disabled = false;
		}
	}
</script>


<script type="text/javascript">
	function cargaInputDelineacion(cdu_retencion) {

		debugger;

		var valores = cdu_retencion.split('_');
		var selectedCDU = document
				.querySelector('#inputDelineacion\\.selectedCDU');
		var selectedRadicado = document
				.querySelector('#inputDelineacion\\.selectedRadicado');
		var selectedTipoLicencia = document
				.querySelector('#inputDelineacion\\.selectedTipoLicencia');

		form = document.getElementById("form_pdf");

		selectedCDU.value = valores[0];

		if (valores[1].length != 0) {
			selectedRadicado.value = valores[1];
			selectedTipoLicencia.value = "retencion"
		} else {
			selectedRadicado.value = "";
			selectedTipoLicencia.value = "declaracion"
		}

		form.submit();
	}

	function onChange(selectObject) {
		// 		debugger;
		var impuesto = selectObject.value;
		var per = document.getElementById('Periodo1');
		var per2 = document.getElementById('Periodo2');
		//var publicidadExt = document.getElementById('table-publicidad');

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
		//publicidadExt.style.display = 'none';
		document.getElementById('aniograv').value = '00'; 
		document.getElementById('periodo').value = '00'; 
		ACC.opcionDeclaraciones.ocultarTablas();
	}
</script>
