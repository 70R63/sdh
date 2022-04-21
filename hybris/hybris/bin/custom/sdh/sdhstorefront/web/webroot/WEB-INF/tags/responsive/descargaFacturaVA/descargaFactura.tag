<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>

<div class="container_new_page">
	<div class="alert alert-success" role="alert">
		<h2 align="center"><span><spring:theme code="descargaFacturaVA.descarga.titulo" /></span></h2>
		<span><spring:theme code="message.download" /> </span>
	</div>
	
	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme code="descargaFacturaVA.descarga.subtitulo" /></span>
			</h2>
		</div>
	</div>
	<br>
	
	<sf:form action="" method="POST" modelAttribute="infoVista" id="forma">
		<div class="row">
			<div class="col-md-2 col-xs-12 mb-20 no-marginright col-md-offset-2">
				<div class="form-group">
					<label class="control-label"><spring:theme code="descargaFacturaVA.descarga.campo.impuesto" /></label> 
					<select id="claveImpuesto" class="new_alto form-control " name="claveImpuesto" onchange="showTag(this)">
					<option value="00"><spring:theme code="descargaFacturaVA.descarga.opcionImpuesto0" /></option>
						<c:if test="${ facturacionForm.predial != null }">
							<option value="01"><spring:theme code="descargaFacturaVA.descarga.opcionImpuesto1" /></option>
						</c:if>
						<c:if test="${ facturacionForm.vehicular != null }">
							<option value="02"><spring:theme code="descargaFacturaVA.descarga.opcionImpuesto2" /></option>
						</c:if>
					</select>
				</div>
			</div>
			<div class="col-md-2 col-xs-12 mb-20">
				<div class="form-group">
					<label class="control-label"><spring:theme code="descargaFacturaVA.descarga.campo.tipoDocumento" /></label> 
					<sf:select path="tipoDoc"  class="newalto form-control" onchange="showField()" id="tipoDoc">
						<sf:options items="${documentTypes}" referenceData="${documentTypes}" itemLabel="name" itemValue="code" />
					</sf:select>
				</div>
			</div>
			<div class="col-md-2 col-xs-12 mb-20 no-margincol">
				<div class="form-group">
					<label class="control-label required"><spring:theme code="descargaFacturaVA.descarga.campo.numeroDocumento" /></label> 
					<input class="alto form-control" maxlength="30" size="30" type="text" value="" id="numDoc"/>
				</div>
			</div>
			<div class="col-md-2 col-xs-12 mb-20 no-margincol">
				<div class="form-group">
					<label class="control-label" id="chip/placa" style="display: block;"><spring:theme code="descargaFacturaVA.descarga.etiqueta.opcionImpuesto0" /></label>
					<label class="control-label" id="chip" style="display: none;"><spring:theme code="descargaFacturaVA.descarga.etiqueta.opcionImpuesto1" /></label>
					<label class="control-label" id="placa" style="display: none;"><spring:theme code="descargaFacturaVA.descarga.etiqueta.opcionImpuesto2" /></label>
					<input class="alto form-control" maxlength="30" size="30" type="text" value="" id="numObjeto"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-4">
				<button style="margin-top: 3px;" id="" class="btn btn-secondary btn-lg" type="button" id="facCancelar">
					<spring:theme code="Cancelar" />
				</button>
			</div>
			<div class="col-md-2">
				<button style="margin-top: 3px;" id="" class="btn btn-primary btn-lg" type="button" id="" onclick="showDownload()">
					<spring:theme code="descarga.factura.inicial.buscar" />
				</button>
			</div>
		</div>
	</sf:form>
	
	
	<br>
	<div id="table-download" style="display: none;">
		<div class="col-md-5 col-md-offset-3">
			<table id="">
				<thead>
					<tr>
						<th class="col-md-1" style="text-align: center">
							<label class="control-label labeltabletd" for="" ><spring:theme code="Nombre" /></label>
						</th>
						<th class="col-md-1" style="text-align: center">
							<label class="control-label labeltabletd" for=""> <spring:theme code="Descargar factura" /></label>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input class="alto form-control" maxlength="50" size="30" type="text" value="nombre" id="nombreContribuyente" disabled="disabled"/>
						<input type="hidden" value="numBP" id="numBP" disabled="disabled"/></td>
						<td><img src="${themeResourcePath}/images/download_icon.png" onclick="descargaFactura(this)" data-claveImpuesto="0001" data-nombreObjeto="objetoPredial" data-anioGrav="" data-numobjeto=""></img></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="container"></div>
