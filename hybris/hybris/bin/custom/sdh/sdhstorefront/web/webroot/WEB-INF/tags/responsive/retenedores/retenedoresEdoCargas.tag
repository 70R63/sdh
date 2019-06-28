<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_agentes_inicial">
	<div class="row">

		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="reteica.consulta.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="reteica.consulta.inicial.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


	<div class="row">
		<div class="headline">
			<h2>
				<span class="col-md-10 "><spring:theme
						code="reteica.consulta.estado.titulo" /></span>
			</h2>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="reteica.consulta.estado.descripcion1" /></label>
			</div>
		</div>

		<div class="col-md-12">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="reteica.consulta.estado.descipcion2" /></label>
			</div>
		</div>
	</div>
	<c:url value="/retenedores/estadocargas" var="edoCargasAction" />
	<form:form commandName="form" action="${edoCargasAction}"
		id="edoCargasForm" name="edoCargasForm">
		<div class="row">
			<div class="col-md-12 col-md-offset-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.consulta.estado.anio" /></label> <select id="reteICAEDOAnoGravable"
						name="anoGravable" class="form-control"
						style="width: 200px !important">
						<option>Seleccionar</option>
						<c:forEach items="${ years}" var="eachYear">
							<c:set var="selected" value="" />
							<c:if test="${ eachYear eq form.anoGravable}">
								<c:set var="selected" value="selected" />
							</c:if>
							<option value="${ eachYear}" ${selected }>${eachYear }</option>
						</c:forEach>
					</select>
				</div>
			</div>

		</div>
	</form:form>
	<div class="row">
		<div class="col-md-12 tableamplia">
			<div class="table-responsive">
				<table class="table table-bordered" id="example">
					<thead>
						<tr>
							<td><label class="control-label labeltabletd tablefechas"><spring:theme
										code="reteica.consulta.estado.fechcarga" /></label></td>
							<td><label class="control-label labeltabletd tablenombre"><spring:theme
										code="reteica.consulta.estado.nomdoc" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="reteica.consulta.estado.perrepor" /></label></td>
							<td><label class="control-label labeltabletd tabledomatri"><spring:theme
										code="reteica.consulta.estado.estado" /></label></td>
							<td><label class="control-label labeltabletd "><spring:theme
										code="reteica.consulta.estado.detalle" /></label></td>
							<td><label class="control-label labeltabletd "><spring:theme
										code="reteica.consulta.estado.deseacargar" /></label></td>
							
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty archivosTRM }">
								<tr>
									<td><input class="inputtextnew tablefechas"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tablenombre"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew " disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew tabledomatri"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" /></td>
									
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${archivosTRM }" var="eachArchivo">
									<tr>
										<td><input class="inputtextnew tablefechas" id="fechaCarga"
											disabled="disabled" value="${eachArchivo.fechaCarga }"
											type="text" /></td>
										<td><input class="inputtextnew tablenombre"
											disabled="disabled" value="${eachArchivo.nomArchivo }"
											type="text" /></td>
										<td><input class="inputtextnew " disabled="disabled" id="perRepor" 
											value="${eachArchivo.perRepor }" type="text" /></td>
										<c:choose>
											<c:when test='${(eachArchivo.estado == "01")}'>
												<td>Proceso iniciado</td>
											</c:when>
											<c:when test='${(eachArchivo.estado == "02")}'>
												<td>Rechazado</td>
											</c:when>
											<c:when test='${(eachArchivo.estado == "03")}'>
												<c:url value="/retenedores/declaracion" var="urlPresentar" />
												<td><a href="${urlPresentar}?numForm=${eachArchivo.numForm }">Generar declaración</a></td>
											</c:when>
											<c:when test='${(eachArchivo.estado == "04")}'>
												<td>Procesado</td>
											</c:when>
											<c:when test='${(eachArchivo.estado == "05")}'>
												<td>Obsoleto</td>
											</c:when>
											<c:otherwise>
												<td></td>
											</c:otherwise>
										</c:choose>
										<td>
											<c:if test="${eachArchivo.estado ne  '02' }">
												<c:url value="/retenedores/download/log" var="urlDownload" />
												<a href="${urlDownload}?nomArchivo=${eachArchivo.nomArchivo}">Ver log</a>
											</c:if>
										</td>
										<c:choose>
											<c:when test='${(eachArchivo.bandera == "X")}'>
											<c:url value="/retenedores/registroretenciones" var="registroRetencionesURL" />
												<td><a href="${registroRetencionesURL }" class="reteICARecargar" data-estado="${eachArchivo.estado}">Desea volver a cargar</a></td>
											</c:when>
											<c:otherwise>
												<td>Desea volver a cargar</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-10">
			<div class="form-group">
				<button class="btn btn-secondary text-center" id="" name=""
					value="regresar" type="button" onclick="goBack()">
					<spring:theme code="reteica.consulta.estado.regresar" />
				</button>
			</div>
		</div>
	</div>

</div>

<script>
   
    
	function goBack() {
		window.history.back();

	}
	
	
</script>


<script type="text/javascript">
    
    function formatoPerRepor(element, index, array){
		var periodo =element.value.substring(2);  
		if (periodo == 'B1'){
			element.value = 'Enero-Febrero';
		}
		if (periodo == 'B2'){
			element.value = 'Marzo-Abril';
		}
		if (periodo == 'B3'){
			element.value = 'Mayo-Junio';
		}
		if (periodo == 'B4'){
			element.value = 'Julio-Agosto';
		}
		if (periodo == 'B5'){
			element.value = 'Septiembre-Octubre';
		}
		if (periodo == 'B6'){
			element.value = 'Noviembre-Diciembre';
		}
	}
    
        
    function formato(){
    	
    	var inputList = document.getElementsByTagName("input");
    	var arrayPerRepor = Array.prototype.slice.call(inputList);
    	
    	arrayPerRepor.forEach( formatoPerRepor );
    	
    }
        
	
	formato();
</script>