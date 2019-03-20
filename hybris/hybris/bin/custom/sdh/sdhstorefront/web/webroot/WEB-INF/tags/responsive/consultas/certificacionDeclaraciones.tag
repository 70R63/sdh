<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/contribuyentes/consultas/certipagos"
	var="certideclaraURL" htmlEscape="false" />
	
	
<script>
	function onChange() {
		impuesto = document.getElementById("tipoimp").value;
		if(impuesto == '4'){
			document.getElementById('periodo').style.display = 'none';	
		}else{
			document.getElementById('periodo').style.display = '';
		}
	
		
	
	}

	function downloadPDF(pdf) {
		debugger;
		if (pdf){
			const linkSource = 'data:application/pdf;base64,' + pdf;
		    const downloadLink = document.createElement("a");
		    const fileName = "Certificación_Declaracion.pdf";
	
		    downloadLink.href = linkSource;
		    downloadLink.download = fileName;
		    downloadLink.click();
		}    
	}
	
	
	downloadPDF('${imprimeCertiDeclaraResponse.stringPDF}');
</script>	
	

<div>
	<div class="container">
		<div class="row">
			<div class="headline">
				<h2 align="center">
					<span><spring:theme code="certideclara.inicial.titulo" /></span>  

				</h2>
			</div>
		</div>
		
		<form:form id="form_pdf" action="/sdhstorefront/es/contribuyentes/consultas/certideclaraciones" method="post" commandName="certiFormPost" >
			
			<input type="hidden" name="numBP" value="${certiForm.numBP}"/>
			
			<div class="row">
				<div class="col-md-3" id="idImpuesto" style="display: block;">
					<div class="form-group">
						<label class="control-label required">
							<spring:theme code="certideclara.inicial.selcimpuesto" />
						</label> 
						<select	required="required" required id="tipoimp" class="form-control "
							name="Idimp" onchange="onChange()">
							<option value="">Seleccionar</option>
							<!--  <option value="1">Predial Unificado</option>-->
							<!--<option value="2">Vehículos</option>-->
							<!--<option value="3">ICA</option>-->
							<option value="4">Publicidad Exterior</option>
							<option value="5">Sobretasa Gasolina</option>
							<!--<option value="6">Delineación Urbana</option>-->
						</select>
					</div>
				</div>

				<div class="col-md-3" id="idAnio" style="display: block;">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="certideclara.inicial.aniograv" /></label> <select
							aria-required="true" id="aniograv" class="form-control "
							name="aniograv" 
							required='required'>
							<option value="">Seleccionar</option>
							<option value="2019">2019</option>
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
							<option value="2016">2015</option>
							<option value="2016">2014</option>
						</select>
					</div>
				</div>
				
				
				<div class="col-md-3" id="idPeriodo" style="display: block;">
					<div class="form-group">
						<label class="control-label required">
							<spring:theme code="certideclara.inicial.periodo" />
						</label> 
						<select	aria-required="true" id="periodo" class="form-control "
							name="periodo" 	required='required'>
							<option value="">Seleccionar</option>
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
	
							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="CHIP"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="Matricula"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="Direccion"></c:out>" /></td>
								<td><input class="inputtextnew"
									style="visibility: visible !important; width: 15px" type="radio"
									id="" name="" value=""></td>
	
							</tr>
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
	
							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="PLACA"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="MARCA"></c:out>" /></td>
								<td><input class="inputtextnew"
									style="visibility: visible !important; width: 15px" type="radio"
									id="" name="" value=""></td>
	
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
			
			<div class="row" id="table-ica" style="display: none;">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
						<thead style="cellspacing: 10 !important">
							<tr>
								<th style="text-align: center"><label class="control-label "
									for=""><spring:theme
											code="certideclara.inicial.ica.tipdocu" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="certideclara.inicial.ica.numdocu" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme
											code="certideclara.inicial.ica.seleccionar" /></label></th>
							</tr>
						</thead>
						<tbody>
	
							<tr>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="TIPO DOCUMENTO"></c:out>" /></td>
								<td><input style="width: 100%" class="inputtextnew"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="NUM DOCUMENTO"></c:out>" /></td>
								<td><input class="inputtextnew"
									style="visibility: visible !important; width: 15px" type="radio"
									id="" name="" value=""></td>
	
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="row" id="table-publicidad" style="display: none;">
				<div class="col-md-6 col-md-offset-3">
					<table class="table">
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
							<c:forEach varStatus="loop" items="${certiForm.publicidadExt}"
								var="eachPubExtTax">
								<tr>
									<td><c:out value="${eachPubExtTax.numResolu}"></c:out></td>
									<td><c:out value="${eachPubExtTax.tipoValla}"></c:out></td>
									<%--<td><label style="color: #0358d8 !important"
										data-numRes="${eachPubExtTax.numResolu}"
										data-tipoValla="${eachPubExtTax.tipoVallaCode}"
										class="text-capitalize !important labelVer "><spring:theme
												code="publicidad.exterior.ver" /></label></td> --%>
	
									<td><input id="action"
									style="visibility: visible !important; margin: 0; min-height: 0;"
									name="action" type="radio"
									value="${eachPubExtTax.numResolu}, ${eachPubExtTax.tipoValla},${eachPuExtTax.numObjeto}"
									data-numRes="${eachPubExtTax.numResolu}"
									data-tipoValla="${eachPubExtTax.tipoValla}" data-numObjeto="${eachPuExtTax.numObjeto}"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 col-md-offset-5">
					<div class="form-group ">
						<button type="button" class="btn btn-primary btn-lg" id="action"
							name="action" value="cancelar">
							<spring:theme code="certideclara.inicial.cancelar" />
						</button>
	
						<button type="submit" class="btn btn-primary btn-lg"
							id="generarPDFButton" name="generarPDFButton">
							<spring:theme code="certideclara.inicial.generar" />
						</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>		
</div>
<div id="dialog" title="Generar certideclara">
	<div id="certiDialogContent"></div>
</div>


<script type="text/javascript">
	
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

	function SelectedAnio(selectObject) {
		var value = selectObject.value;
		document.getElementById("Idanio").value = value;
		var x = document.getElementById('Idimp').value;
		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');
		if (x == '1') {

			tablepredial.style.display = 'block';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';

		} else if (x == '2') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'block';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';

		} else if (x == '4') {
			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'block';

		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
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
</script>

