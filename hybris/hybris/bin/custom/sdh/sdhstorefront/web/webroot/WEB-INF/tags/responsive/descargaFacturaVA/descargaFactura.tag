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
	
	<c:if test="${false}">
	<c:set var="action" value="validacion"/>
	<sf:form action="${action}" method="get" modelAttribute="loginForm">
		<c:choose>
			<c:when test="${captchaEnabledForCurrentStore eq true }">
				<div
					class="form_field-elements control-group js-recaptcha-captchaaddon"></div>
			</c:when>
			<c:otherwise>
				<formElement:formCheckbox idKey="notARobot"
					labelKey="login.not.a.robot" path="notARobot" />
			</c:otherwise>
		</c:choose>
		
			<ycommerce:testId code="loginAndCheckoutButton">
				<button type="submit" class="btn btn-primary redtam tam_button"
					style="width: 20% !important; border-radius: 20px !important; background-color: #156ab5 !important; color: white !important; height: 48px !important; margin-top: 1%;">
					<spring:theme code="${actionNameKey}" />
				</button>
			</ycommerce:testId>
	</sf:form>
	</c:if>
	
	<sf:form action="" method="POST" modelAttribute="infoVista" id="forma">
		<div class="row">
			<div class="col-md-2 col-xs-12 mb-20 no-marginright col-md-offset-2">
				<div class="form-group">
					<label class="control-label"><spring:theme code="descargaFacturaVA.descarga.campo.impuesto" /></label> 
					<select id="claveImpuesto" class="new_alto form-control " name="claveImpuesto" onchange="showTag(this)">
					<option value="00"><spring:theme code="descargaFacturaVA.descarga.opcionImpuesto0" /></option>
						<c:if test="${ facturacionForm.predial != null }">
							<option value="0001"><spring:theme code="descargaFacturaVA.descarga.opcionImpuesto1" /></option>
						</c:if>
						<c:if test="${ facturacionForm.vehicular != null }">
							<option value="0002"><spring:theme code="descargaFacturaVA.descarga.opcionImpuesto2" /></option>
						</c:if>
					</select>
				</div>
			</div>
			<div class="col-md-2 col-xs-12 mb-20">
				<div class="form-group">
					<label class="control-label"><spring:theme code="descargaFacturaVA.descarga.campo.tipoDocumento" /></label> 
					<sf:select path="tipoDoc"  class="newalto form-control" id="tipoDoc">
						<sf:options items="${documentTypes}" referenceData="${documentTypes}" itemLabel="name" itemValue="code" />
					</sf:select>
				</div>
			</div>
			<div class="col-md-2 col-xs-12 mb-20 no-margincol">
				<div class="form-group">
					<label class="control-label required"><spring:theme code="descargaFacturaVA.descarga.campo.numeroDocumento" /></label> 
					<input class="alto form-control" maxlength="30" size="30" type="text" value="" id="numDoc" onkeyup="valInputText('up',this);" onchange="valInputText('change',this);"/>
					<label class="control-label" id="mensajeNumDoc" style="display: block;"><spring:theme code="descargaFacturaVA.descarga.etiqueta.mensajeNumDoc" /></label>
				</div>
			</div>
			<div class="col-md-2 col-xs-12 mb-20 no-margincol">
				<div class="form-group">
					<label class="control-label" id="chip/placa" style="display: block"><spring:theme code="descargaFacturaVA.descarga.etiqueta.opcionImpuesto0" /></label>
					<label class="control-label" id="chip" style="display: none;"><spring:theme code="descargaFacturaVA.descarga.etiqueta.opcionImpuesto1" /></label>
					<label class="control-label" id="placa" style="display: none;"><spring:theme code="descargaFacturaVA.descarga.etiqueta.opcionImpuesto2" /></label>
					<input class="alto form-control" maxlength="20" size="20" type="text" value="" id="claveObjeto" style="text-transform: uppercase"/>
					<label class="control-label" id="mensajeClaveObjeto" style="display: block;"><spring:theme code="descargaFacturaVA.descarga.etiqueta.mensajeClaveObjeto" /></label>
				</div>
			</div>
		</div>
		
		<div class="alert alert-info" role="alert" id="mensajeImpuesto1" style="display: none;">
			<h4 align="center"><span><spring:theme code="descargaFacturaVA.descarga.subtitulo.opcionImpuesto1" /></span></h4>
		</div>
		<div class="alert alert-info" role="alert" id="mensajeImpuesto2" style="display: none;">
			<h4 align="center"><span><spring:theme code="descargaFacturaVA.descarga.subtitulo.opcionImpuesto2" /></span></h4>
		</div>
		<div class="row">
		    <div class="col-md-2 col-md-offset-4">
                <c:choose>
                    <c:when test="${captchaEnabledForCurrentStore eq true }">
                        <div class="form_field-elements control-group js-recaptcha-captchaaddon"></div>
                    </c:when>
                    <c:otherwise>
                        <formElement:formCheckbox idKey="notARobot"
                            labelKey="login.not.a.robot" path="notARobot" />
                    </c:otherwise>
                </c:choose>
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
		<div class="col-md-7 col-md-offset-1">
			<table id="">
				<thead>
					<tr>
						<th class="col-md-3" style="text-align: center">
							<label class="control-label labeltabletd" for="" ><spring:theme code="Nombre" /></label>
						</th>
						<th id="descargaFacturaHeader" class="col-md-1" style="text-align: center">
							<label class="control-label labeltabletd" for=""> <spring:theme code="Descargar factura" /></label>
						</th>
						<c:if test="${true}">
						<th id="pagarFacturaVABtnHeader" class="col-md-1" style="text-align: center">
							<label class="control-label labeltabletd" for=""> <spring:theme code="Pagar" /></label>
						</th>
						<th class="col-md-1" style="text-align: center">
							<label class="control-label labeltabletd" for=""> <spring:theme code="Certificado" /></label>
						</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input class="alto form-control" maxlength="50" size="30" type="text" value="nombre" id="nombreContribuyente" disabled="disabled"/>
						<input type="hidden" value="numBP" id="numBP" disabled="disabled"/></td>
						<td id="descargaFacturaBtn" ><img src="${themeResourcePath}/images/download_icon.png" onclick="descargaFactura()" data-claveImpuesto="." data-nombreObjeto="." data-anioGrav="" data-numobjeto=""></img></td>
						<c:if test="${true}">
						<td id="pagarFacturaVABtnTd" ><button class="renglonBeneficios" id="pagarFacturaVABtn" type="button" data-impuesto="." data-numbp="." data-aniogravable="." data-numobjeto="." >Pagar</button></td>
						<td><button class="renglonBeneficios" id="certificadoPagoVABtn" type="button"  onclick="descargaCertificadoPago()" data-numbp="." data-numobjeto="." >Imprimir</button></td>
						</c:if>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<spring:url value="/descargaFacturaVA/preparaPagoPSE" var="pagarURL"
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
				<sf:hidden path="pagoVoluntario" id="pagarEnLinea_pagoVoluntario"/>				
			</div>
		</sf:form>
	</div>
</div>
<script>
function valInputText(evento,objeto){
	var newValue="";
	if(realizarValidacion(objeto.value,evento)){
		var allowedCharacters=obtenerCaracteres(objeto.value,evento);	
		objeto.value.split("").forEach(function(char){
			if(in_array(char, allowedCharacters.split(""))) newValue+=char;
		});
	}else{
		newValue = objeto.value;
	}
	objeto.value=newValue;
}


function realizarValidacion(str,evento){
	var completa = "NIT-1234567";
	var realizarVal = true;
	
	switch (evento){
	case "change":
		if(str.toUpperCase() == completa){
			realizarVal = false;
		}
		break;
		
	default:
		realizarVal = true;
	}

	return realizarVal;
}

function obtenerCaracteres(str,evento){
	var inicio = "NIT"
	var allowedCharacters="0123456789azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN";
	
	switch (evento){
	case "up":
		if(str.toUpperCase().startsWith(inicio)){
			allowedCharacters="0123456789azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN-";
		}
		break;
	default:
		realizarVal = true;
		allowedCharacters="0123456789azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN";
	}

	return allowedCharacters;
}

function in_array(elem, array){
	var isIn = false;
	for(var i=0;i<array.length;i++){
		if(elem==array[i]){
			isIn=true;
		}
	}
	return isIn;
}
</script>
