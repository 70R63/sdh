<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/contribuyentes/consultas/certipagos"
	var="certideclaraURL" htmlEscape="false" />
	
	
<script>
	function onChange() {		
		form = document.getElementById("form_pdf");

		input = document.createElement('input');
        input.setAttribute('name', 'rowFrompublicidadTable');
        input.setAttribute('value', 'X');
        input.setAttribute('type', 'hidden');
        
        form.appendChild(input);
		form.submit();
	}
	
	function onChangeAnioGravable() {
		impuesto = document.getElementById("tipoimp").value;	
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
		    const fileName = "Certificación_Declaracion.pdf";	
		    downloadLink.href = linkSource;
		    downloadLink.download = fileName;
		    downloadLink.click();
		}    
	}
	
	
	downloadPDF('${imprimeCertiDeclaraResponse.stringPDF}');
</script>	



<c:choose>
    <c:when test="${certiFormPost.idimp == '4'}">
        <c:set var = "aniGravable" value = "${anoGravablePublicidad}"/>
    </c:when>
    <c:otherwise>
        <c:set var = "aniGravable" value = "${anoGravableGasolina}"/>
    </c:otherwise>
</c:choose>

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
			<input type="hidden" name="rowFrompublicidadTable" value=""/>
			
			<div class="row">
				
				<div class="col-md-3" id="idImpuesto" style="display: block;">
					<div class="form-group">
						<formElement:formSelectBox idKey="tipoimp" 
							labelKey="certideclara.inicial.selcimpuesto" 
							path="Idimp" mandatory="true" 
							skipBlank="false" skipBlankMessageKey="SELECCIONAR"  
							items="${tipoDeImpuesto}" selectCSSClass="form-control" onchange="onChange()"/>
					</div>
				</div>
				
				<div class="col-md-3" id="idAnio" style="display: block;">
					<div class="form-group">
						<formElement:formSelectBox idKey="aniograv" 
							labelKey="certideclara.inicial.aniograv" 
							path="aniograv" mandatory="true" 
							skipBlank="false" skipBlankMessageKey="SELECCIONAR"  
							items="${aniGravable}" selectCSSClass="form-control" onchange="onChangeAnioGravable()"/>
					</div>
				</div>
				
				<c:if test="${certiFormPost.idimp ne '4'}">
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
				</c:if>	
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

			<c:if test="${certiFormPost.idimp ne '4'}">
			<div class="row" id="formButtons">
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
			</c:if>

		</form:form>
		
		<c:if test="${not empty consultaPagoList}">
	 <table id="myTable"> 
	 	<tr>
    		<th>NUMERO DE RESOLUCION</th>
    		<th>TIPO DE VALLA</th> 
    		<th>IMPRIMIR</th>
		 </tr>
		<c:forEach var="item" items="${consultaPagoList}">
	 		<tr>
    			<td><c:out value="${item.numResolu}" /></td>
	    		<td><c:out value="${item.tipoValla}" /></td>
	    		<td>
	    			<form:form id="form_pdf" action="/sdhstorefront/es/contribuyentes/consultas/certideclaraciones" method="post" commandName="certiFormPost" >					
						<input type="hidden" name="tipoImp" value="1"/>
						<input type="hidden" name="Idimp" value="4"/>
						<input type="hidden" name="rowFrompublicidadTable" value="X"/>						
						<input type="hidden" name="numBP" value="${item.numBP}"/>
						<input type="hidden" name="aniograv" value="${item.clavePeriodo}"/>
						<input type="hidden" name="ctaContrato" value="${item.ctaContrato}"/>
						<input type="hidden" name="numObjeto" value="${item.numObjeto}"/>
						<input type="hidden" name="clavePeriodo" value="${item.clavePeriodo}"/>
						<input type="hidden" name="referencia" value="${item.referencia}"/>
						<input type="hidden" name="fechaCompensa" value="${item.fechaCompensa}"/>
						<input type="hidden" name="importe" value="${item.importe}"/>
						<input type="hidden" name="moneda" value="${item.moneda}"/>
						<input type="hidden" name="numfactForm" value="${item.numfactForm}"/>
						<input type="hidden" name="numDocPago" value="${item.numDocPago}"/>
						<input type="hidden" name="numResolu" value="${item.numResolu}"/>
						<input type="hidden" name="tipoValla" value="${item.tipoValla}"/>					
						
    					<button type="submit" class="btn btn-primary btn-lg" id="generarPDFButton" name="generarPDFButton">
							<spring:theme code="certificacion.inicial.generar" />
						</button>
    				</form:form>
    			</td>
	  		</tr>
  		</c:forEach>  		
  	</table>
  	</c:if>
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

