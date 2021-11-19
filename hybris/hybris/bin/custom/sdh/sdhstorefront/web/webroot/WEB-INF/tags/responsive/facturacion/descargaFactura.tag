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

<div class="container_new_page">
	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme code="Facturación" /></span>
			</h2>
		</div>
	</div>


	<div class="row">
		<div class="col-md-4 col-xs-12 mb-20 no-marginright">
			<span class="paso--uno pasos color-sr1">1</span>
			<h2 class="titulo-caja--ser-rel color-sr1 ">DESCARGA DE FACTURA</h2>
			<p class="pasoClase1 metrophobic">Selecciona el impuesto que
				deseas consultar.</p>
			<div class="caja--ser-rel color-sr1">
				<select class="new_alto form-control !important" id="impuesto">
					<option value="00">Seleccionar</option>
					<c:if test="${ not empty facturacionForm.predial}">
						<option value="0001">Predial Unificado</option>
					</c:if>
					<c:if test="${ not empty facturacionForm.vehicular}">
						<option value="0002">Impuesto sobre Vehículos Automotores</option>
					</c:if>
				</select>
			</div>
		</div>




		<div class="col-md-4 col-xs-12 mb-20 no-margincol">
			<span class="paso--dos pasos color-sr2">2</span>
			<h2 class="titulo-caja--ser-rel color-sr2 ">
				<span class="paso2">AÑO GRAVABLE</span>
			</h2>
			<p class="pasoClase2 metrophobic">Selecciona el año gravable.</p>
			<div class="caja--ser-rel color-sr2">
				<select id="aniograv" class="new_alto form-control " name="aniograv">
						<option value="2020">2020</option>
				</select>

			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 col-md-offset-3">
			<button style="margin-top: 3px;" id=""
				class="btn btn-primary btn-lg facBuscar" type="button"
				id="facBuscar">
				<!-- 				 onclick="showtable()"> -->
				<spring:theme code="descarga.factura.inicial.buscar" />
			</button>
		</div>
	</div>
	<br>
	<div id="table-predial" style="display: none;" class="table-responsive">
		<div class="row">
			<div class="col-md-12">
				<table class="table" id="tabPaginacion0">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center" hidden="hidden"><label
								class="control-label " for="">Año Gravable</label></th>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="descarga.factura.predial.chip" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="descarga.factura.predial.matinm" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="descarga.factura.predial.dirpred" /></label></th>
							<!-- 							<th style="text-align: center"><label class="control-label" -->
							<%-- 								for=""> <spring:theme --%>
							<%-- 										code="descarga.factura.predial.selec" /></label></th> --%>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Pago voluntario" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Total a pagar" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Total con pago voluntario" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Reexpedicion de factura" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Descargar factura" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Pagar con aporte" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Pagar sin aporte" /></label></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${facturacionForm.predial }" var="eachPredial">
							<c:if
								test="${not empty eachPredial.matrInmobiliaria || not empty eachPredial.CHIP}">
								<c:if
									test="${not empty eachPredial.anioGravable || not empty eachPredial.direccionPredio}">
									<tr>
										<td hidden="hidden"><c:out
												value="${eachPredial.anioGravable}" /></td>
										<td><c:out value="${eachPredial.CHIP}" /></td>
										<td><c:out value="${eachPredial.matrInmobiliaria}" /></td>
										<td><c:out value="${eachPredial.direccionPredio}" /></td>
										<!-- 								<td><input class="inputtextnew" -->
										<!-- 									style="visibility: visible !important; width: 15px" -->
										<%-- 									type="radio" id="" name="objetoPredial" value="${eachPredial.numObjeto}"></td> --%>
										<td></td>
										<td></td>
										<td></td>
										<td><label class="control-label"
											style="text-transform: capitalize !important"
											id="downloadFac" data-claveImpuesto="0001"
											data-nombreObjeto="objetoPredial"
											data-anioGrav="${eachPredial.anioGravable}" data-numObjeto="${eachPredial.numObjeto}"
											onclick="reexpedicion(this)"> <span class="">Reexpedir factura</span></label></td>
										<td><label class="control-label"
											style="text-transform: capitalize !important"
											id="downloadFac" data-claveImpuesto="0001"
											data-nombreObjeto="objetoPredial"
											data-anioGrav="${eachPredial.anioGravable}" data-numObjeto="${eachPredial.numObjeto}"
											onclick="descargaFactura(this)"> <span class="">Descargar factura</span></label></td>
										<td></td>
										<td></td>

									</tr>
								</c:if>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-3 col-md-offset-5"> -->
<!-- 				<button style="margin-top: 3px;" id="" -->
<!-- 					class="btn btn-primary btn-lg" type="button" -->
<!-- 					onclick="descargaFactura()"> -->
<%-- 					<spring:theme code="descarga.factura.predial.desfact" /> --%>
<!-- 				</button> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</div>

	<div id="table-vehiculos" style="display: none;">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-responsive" id="tabPaginacion1">
					<thead style="cellspacing: 10 !important">
						<tr>
							<th style="text-align: center" hidden="hidden"><label
								class="control-label " for="">año gravable</label></th>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme
										code="descarga.factura.vehiculo.placa" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme
										code="descarga.factura.vehiculo.marca" /></label></th>
							<!-- 							<th style="text-align: center"><label class="control-label" -->
							<%-- 								for=""> <spring:theme --%>
							<%-- 										code="descarga.factura.vehiculo.selec" /></label></th> --%>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Pago voluntario" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Total a pagar" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Total con pago voluntario" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Reexpedicion de factura" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Descargar factura" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Pagar con aporte" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="Pagar sin aporte" /></label></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${facturacionForm.vehicular }"
							var="eachVehiculo">
							<c:if test="${not empty eachVehiculo.anioGravable}">
								<c:if
									test="${not empty eachVehiculo.placa || not empty eachVehiculo.marca}">
									<tr>
										<td hidden="hidden"><c:out
												value="${eachVehiculo.anioGravable}" /></td>
										<td><c:out value="${eachVehiculo.placa}" /></td>
										<td><label class="labelVerDetVeh "><spring:theme
													code="vehiculos.detalle.marca.${eachVehiculo.marca}" /></label></td>
<!-- 										<td><input class="inputtextnew" -->
<!-- 											style="visibility: visible !important; width: 15px" -->
<!-- 											type="radio" id="" name="objetoVehicular" -->
<%-- 											value="${eachVehiculo.numObjeto}"></td> --%>
<!-- 														<td></td> -->
										<td></td>
										<td></td>
										<td><label class="control-label"
											style="text-transform: capitalize !important"
											id="downloadFac" data-claveImpuesto="0002"
											data-nombreObjeto="objetoVehicular"
											data-anioGrav="${eachVehiculo.anioGravable}" data-numObjeto="${eachVehiculo.numObjeto}"
											onclick="reexpedicion(this)"> <span class="">Reexpedir Factura</span></label></td>
										<td><label class="control-label"
											style="text-transform: capitalize !important"
											id="downloadFac" data-claveImpuesto="0002"
											data-nombreObjeto="objetoVehicular"
											data-anioGrav="${eachVehiculo.anioGravable}" data-numObjeto="${eachVehiculo.numObjeto}"
											onclick="descargaFactura(this)"> <span class="">Descargar factura</span></label></td>
										<td></td>
										<td></td>
										<td></td>

									</tr>
								</c:if>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-3 col-md-offset-5"> -->
<!-- 				<button style="margin-top: 3px;" id="" -->
<!-- 					class="btn btn-primary btn-lg" type="button" -->
<!-- 					onclick="descargaFactura()"> -->
<%-- 					<spring:theme code="descarga.factura.vehiculo.desfac" /> --%>
<!-- 				</button> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</div>


<div class="container">
	<spring:url value="/contribuyentes/reexpedicionfacturaAct" var="reexpedicionURL" htmlEscape="false" />
	<sf:form action="${reexpedicionURL}" method="GET"
 		modelAttribute="descargaFacturaForm" id="reexpedicionFacturaAct"> 
 		<sf:hidden path="anoGravable" id="anoGravable"/> 
 		<sf:hidden path="numObjeto" id="numObjeto"/> 
 	</sf:form> 
</div>
</div>

<script>
	function showtable() {
		

		var imp = document.getElementById('impuesto').value;
		var tabpred = document.getElementById('table-predial');
		var tabveh = document.getElementById('table-vehiculos');

		if (imp == '0001') {
			tabpred.style.display = 'block';
			tabveh.style.display = 'none';

		} else if (imp == '0002') {
			tabpred.style.display = 'none';
			tabveh.style.display = 'block';
		} else {
			tabpred.style.display = 'none';
			tabveh.style.display = 'none';
		}

	}
	function descargaFactura(descargaFactura1) {
debugger;
var objeto = this;
		
		var anoGravable = $("#aniograv").val();
		var claveImpuesto = $("#impuesto").val();
		var nombreObjeto = "";
		
		switch (claveImpuesto){
		case "0001":
			nombreObjeto = "objetoPredial";
			break;
		case "0002":
			nombreObjeto = "objetoVehicular";
			break;
		}
		var numObjeto = $("input[name='"+nombreObjeto+"']:checked"). val();
	
		
		ACC.facturacion.descargaFactura(anoGravable,numObjeto,1,descargaFactura1);
	}
	
		
	function reexpedicion(reexpedicionFactura){
		debugger;
		$("#anoGravable").val($("#aniograv").val());
		var claveImpuesto = $("#impuesto").val();
		var nombreObjeto = "";
		
		switch (claveImpuesto){
		case "0001":
			nombreObjeto = "objetoPredial";
			break;
		case "0002":
			nombreObjeto = "objetoVehicular";
			break;
		}
// 		var numObjeto = $("input[name='"+nombreObjeto+"']:checked"). val();
// 		$("#numObjeto").val(numObjeto);
		var numObjeto = $.trim($(reexpedicionFactura).attr("data-numObjeto"));
		var form = document.getElementById('reexpedicionFacturaAct');
		if(form!=null && numObjeto!= null && numObjeto!=""){
			form.submit();
		}
		
	}
</script>

