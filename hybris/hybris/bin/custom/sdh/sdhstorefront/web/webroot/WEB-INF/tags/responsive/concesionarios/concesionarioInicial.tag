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
	
	
	
<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL"
	htmlEscape="false" />

<div class="container">
	<div class="row">
		<sf:form action="${pagarURL}" method="POST" modelAttribute="infoPreviaPSE" id="infoPreviaPSE">
			<div class="col-md-2">
				<sf:hidden path="tipoImpuesto" id="pagarEnLinea_tipoImpuesto"/>
				<sf:hidden path="numBP" id="pagarEnLinea_numBP"/>
				<sf:hidden path="numDoc" id="pagarEnLinea_numDoc"/>
				<sf:hidden path="tipoDoc" id="pagarEnLinea_tipoDoc"/>
				<sf:hidden path="anoGravable" id="pagarEnLinea_anoGravable"/>
				<sf:hidden path="periodo" id="pagarEnLinea_periodo"/>
				<sf:hidden path="clavePeriodo" id="pagarEnLinea_clavePeriodo"/>
				<sf:hidden path="dv" id="pagarEnLinea_dv"/>
				<sf:hidden path="numObjeto" id="pagarEnLinea_numObjeto"/>
				<sf:hidden path="chip" id="pagarEnLinea_chip"/>
				<sf:hidden path="fechaVenc" id="pagarEnLinea_fechaVenc"/>
				<sf:hidden path="numRef" id="pagarEnLinea_numRef"/>
				<sf:hidden path="totalPagar" id="pagarEnLinea_totalPagar"/>
				<sf:hidden path="cdu" id="pagarEnLinea_cdu"/>
				<sf:hidden path="placa" id="pagarEnLinea_placa"/>
			</div>
		</sf:form>
	</div>
</div>	

<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/concesionarios" var="conURL"
	htmlEscape="false" />
<div class="container_new_page">
	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme code="concesionario.inicial.titulo" /></span>
			</h2>
		</div>
	</div>

<form  action="${conURL}" method="POST" target="dataForm">
	<div class="row">
		<div class="col-md-4 col-xs-12 mb-20 no-marginright">
			<span class="paso--uno pasos color-sr1">1</span>
			<h2 class="titulo-caja--ser-rel color-sr1 ">
				<spring:theme code="concesionario.inicial.fechas" />
			</h2>
			<p class="pasoClase1 metrophobic">Selecciona el periodo que deseas consultar.</p>
			<div class="caja--ser-rel color-sr1">
				<label class="control-label"><spring:theme code="concesionario.inicial.fecInicio" /></label> 
				<form:input type="date" class="newalto form-control" name="fecInio" id="fecInio" path="fecInio" value="${concesionarios.fecInio}" />
			</div>
		</div>

		<div class="col-md-4 col-xs-12 mb-20 no-margincol">
			<span class="paso--dos pasos color-sr2">2</span>
			<h2 class="titulo-caja--ser-rel color-sr2 ">
				<span class="paso2"><spring:theme code="concesionario.inicial.statusReferencia" /></span>
			</h2>
			<p class="pasoClase2 metrophobic">Selecciona estatus de las referencias.</p>
			<div class="caja--ser-rel color-sr2">
				<label><spring:theme code="concesionario.inicial.estatusReferencia" /></label> 
				<form:select id="referenceStatus" class="new_alto form-control " name="referenceStatus" path="referenceStatus">
					<option value="">Seleccionar</option>
					<c:forEach varStatus="loop" items="${referenceStatus}" var="eachStatus">
						<c:choose>
							<c:when test="${eachStatus.code == concesionarios.referenceStatus}">
								<form:option value="${eachStatus.code}" id="${eachStatus.code}" selected="selected">${eachStatus.name}</form:option>
									<c:set var = "statusDescription" scope = "session" value = "${eachStatus.name}"/>
							</c:when>
							<c:otherwise>
								<form:option value="${eachStatus.code}" id="${eachStatus.code}">${eachStatus.name}</form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 col-md-offset-3">
			<button style="margin-top: 3px;" id="concesionarioBuscar" class="btn btn-primary btn-lg concesionarioBuscar" type="button" onclick="buscar();">
				<spring:theme code="reexpedicion.factura.inicial.buscar" />
			</button>
		</div>
	</div>
	</form>
	<br>

	<div id="table-concesionarios" style="display: none;">
		<div class="row" class="table-responsive">
			<div class="col-md-12">
				<table class="table tabPaginacion" id="concesionarios1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center" class="col-md-1"><label class="control-label labeltabletd " for=""><spring:theme code="concesionario.inicial.referencia" /></label></th>
							<th style="text-align: center" class="col-md-1"><label class="control-label labeltabletd " for=""> <spring:theme code="concesionario.inicial.placa" /></label></th>
							<th style="text-align: center" class="col-md-1"><label class="control-label labeltabletd " for=""> <spring:theme code="concesionario.inicial.vigencia" /></label></th>
							<th style="text-align: center" class="col-md-1"><label class="control-label labeltabletd " for=""> <spring:theme code="concesionario.inicial.vencimiento" /></label></th>
							<th style="text-align: center" class="col-md-1"><label class="control-label labeltabletd " for=""> <spring:theme code="concesionario.inicial.estatusdeReferencia" /></label></th>
							<th style="text-align: center" class="col-md-1"><label class="control-label labeltabletd " for=""> <spring:theme code="concesionario.inicial.valRef" /></label></th>
							<!--<th style="text-align: center" class="col-md-1"><label class="control-label labeltabletd " for=""> <spring:theme code="concesionario.inicial.impresion" /></label></th> -->
							<th style="text-align: center" class="col-md-1"><label class="control-label labeltabletd " for=""> <spring:theme code="concesionario.inicial.pagar" /></label></th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>






<script type="text/javascript">

function buscar(){
	ACC.concesionarios.buscar();
	
}


function pagarEnLinea(tipoImpuesto,anoGravable,periodo,numObjeto,chip,fechaVenc,numRef,totalPagar,cdu,placa,facilidad,montoFacilidad){
	
	debugger;
	
	var numBP = "${customerData.numBP}";
	var numDoc = "${customerData.documentNumber}";
	var tipoDoc = "${customerData.documentType}";
	if (periodo === null || periodo === '' || typeof periodo === 'undefined' ){
		var clavePeriodo = anoGravable.substr(2,2).concat("A1");
	}	  
	else{
		var clavePeriodo = anoGravable.substr(2,2).concat(periodo);
	} 
	var dv = "${customerData.digVer}";
	
	
	$("#pagarEnLinea_tipoImpuesto").val(tipoImpuesto);
	$("#pagarEnLinea_numBP").val(numBP);
	$("#pagarEnLinea_numDoc").val(numDoc);
	$("#pagarEnLinea_tipoDoc").val(tipoDoc);		
	$("#pagarEnLinea_anoGravable").val(anoGravable);
	$("#pagarEnLinea_periodo").val(periodo);
	$("#pagarEnLinea_clavePeriodo").val(clavePeriodo);
	$("#pagarEnLinea_dv").val(dv);
	$("#pagarEnLinea_numObjeto").val(numObjeto);
	$("#pagarEnLinea_chip").val(chip);
	$("#pagarEnLinea_cdu").val(cdu);
	$("#pagarEnLinea_placa").val(placa);
	
	
	if(fechaVenc === '' || fechaVenc.search("/") >= 0 || periodo.search("/") >= 0){
		$("#pagarEnLinea_fechaVenc").val(fechaVenc);
	}else{
		var fechaVencimineto = fechaVenc.substring(6,8).concat("/",fechaVenc.substring(4,6),"/",fechaVenc.substring(0,4));
		$("#pagarEnLinea_fechaVenc").val(fechaVencimineto);
	}
	
	$("#pagarEnLinea_numRef").val(numRef);
    $("#pagarEnLinea_totalPagar").val(totalPagar);
	
	
	var form = document.getElementById("infoPreviaPSE");
	if(form!=null){
		form.submit();
	}
	
}

</script>
