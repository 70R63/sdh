<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<script>
function onChange() {
	var varBanco = document.getElementById("psePaymentForm.banco").value;
	var varTipoDeTarjeta = document.getElementById("psePaymentForm.tipoDeTarjeta").value;
	
	
	document.getElementById("hiddenBanco").value = varBanco;
	document.getElementById("hiddenTipoDeTarjeta").value = varTipoDeTarjeta;
	
	hiddenTipoDeTarjeta
	//alert(varBanco);
	//var divBottonPSE = document.getElementById("bottonPSE");
	//var divBottonBBVA = document.getElementById("bottonBBVA");
	//var divBottonDAVIVIENDA = document.getElementById("bottonDAVIVIENDA");

	//divBottonPSE.style.display = "none";
	//divBottonBBVA.style.display = "none";
	//divBottonDAVIVIENDA.style.display = "none";
	
	//if (tipoDeTarjeta == "02"){ //Tipo De Tarjeta - Credito 
		//divBottonPSE.style.display = "block";
	//}else if(tipoDeTarjeta == "01"){ //Tipo De Tarjeta - Debito
		//if(banco == "01"){ //Banco - Bancolombia
			//divBottonPSE.style.display = "block";
		//}else if(banco == "02"){ //Banco - BBVA
			//divBottonBBVA.style.display = "block";
		//}else if(banco == "03"){ //Banco - DAVIVIENDA
			//divBottonDAVIVIENDA.style.display = "block";
		//}
	//}
	
	
}
</script>

<script>
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
	
	
	downloadPDF('${imprimePagoResponse.stringPDF}');
</script>


<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var = "tipoDeImpuestoSeleccionado" scope = "session" value = "${psePaymentForm.tipoDeImpuesto}"/>
<c:set var = "buttonImagePSE" scope = "session" value = "https://jumpseller.co/images/support/pse/logopse.png"/>
<c:set var = "buttonImageBBVA" scope = "session" value = "https://pbs.twimg.com/profile_images/907185208549572608/Hn65NsHV_400x400.jpg"/>
<c:set var = "buttonImageDAVIVIENDA" scope = "session" value = "https://d31dn7nfpuwjnm.cloudfront.net/images/valoraciones/0029/4616/davivienda.png"/>
<!-- <c:out value="${tipoDeImpuestoSeleccionado}"/> 
<c:out value="${ControllerPseConstants.GASOLINA}"/>/
<c:out value="${disableFields}"/> 

<c:out value="ModeDebuge = ${debugMode}"/> -->

 
<c:choose>
  <c:when test="${disableFields eq 'true'}">
  	<c:set var = "disabled" value = "true"/> 
  </c:when>
  <c:otherwise>
  	<c:set var = "disabled" value = "false"/>    	
  </c:otherwise>
</c:choose>


<c:set var = "disabled" scope = "session" value = "false"/> 
<c:if test="${empty debugMode}">
    <c:set var = "debugMode" value = "true"/> 
</c:if>


<div class="row" >
	<div class="col-md-6 col-md-offset-3">
		<div class="item_container_holder ">
			<div class="forgotten-password item_container ">
				<c:url var="action" value="/register/validateAnswers"/> 
			
				<form:form method="post" commandName="psePaymentForm" action="">
					<fieldset>					
						<input type="hidden" value="" class="text" name="tipoDeImpuesto" id="psePaymentForm.tipoDeImpuesto">
					<c:if test = "${(tipoDeImpuestoSeleccionado eq ControllerPseConstants.GASOLINA || tipoDeImpuestoSeleccionado eq ControllerPseConstants.PUBLICIDAD ) && disabled eq true}">
						<div class="col-xs-4">
							<formElement:formInputBox  idKey="psePaymentForm.numeroDeReferencia" maxlength="240" labelKey="psePaymentForm.numeroDeReferencia" path="numeroDeReferencia"  mandatory="true" tabindex="0" disabled="${debugMode}"/>
						</div>
						<div class="col-xs-4">
							<formElement:formInputBox  idKey="psePaymentForm.trazabilityCode" maxlength="240" labelKey="psePaymentForm.trazabilityCode" path="trazabilityCode"  mandatory="true" tabindex="0" disabled="${debugMode}"/>
						</div>							
						<div class="col-xs-4">
							<formElement:formSelectBox idKey="psePaymentForm.tipoDeImpuesto" labelKey="psePaymentForm.tipoDeImpuesto" path="tipoDeImpuesto" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${tipoDeImpuesto}" selectCSSClass="form-control" disabled="${debugMode}"/>
						</div>	
					</c:if>
					<c:if test = "${tipoDeImpuestoSeleccionado ne ControllerPseConstants.GASOLINA || disabled ne true}">
						<div class="row">
							<div class="col-xs-6">
								<formElement:formInputBox  idKey="psePaymentForm.numeroDeReferencia" maxlength="240" labelKey="psePaymentForm.numeroDeReferencia" path="numeroDeReferencia"  mandatory="true" tabindex="0" disabled="${debugMode}"/>
							</div>
							<div class="col-xs-6">
								<formElement:formSelectBox idKey="psePaymentForm.tipoDeImpuesto" labelKey="psePaymentForm.tipoDeImpuesto" path="tipoDeImpuesto" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${tipoDeImpuesto}" selectCSSClass="form-control" disabled="${debugMode}"/>
							</div>
						</div>					
					</c:if>

						<div class="row">
							<div class="col-xs-6">
								<formElement:formSelectBox idKey="psePaymentForm.anoGravable" labelKey="psePaymentForm.anoGravable" path="anoGravable" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${anoGravable}" selectCSSClass="form-control" disabled="${debugMode}"/>
							</div>
							<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.GASOLINA or tipoDeImpuestoSeleccionado eq ControllerPseConstants.ICA or
											tipoDeImpuestoSeleccionado eq ControllerPseConstants.VEHICULAR or tipoDeImpuestoSeleccionado eq ControllerPseConstants.DELINEACION}">
								<div class="col-xs-6">
									<formElement:formSelectBox idKey="psePaymentForm.periodo" labelKey="psePaymentForm.periodo" path="periodo" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${periodo}" selectCSSClass="form-control" disabled="${debugMode}"/>
								</div>
							</c:if>
						</div>	
						
						<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.PREDIAL}">						
							<formElement:formInputBox  idKey="psePaymentForm.CHIP" maxlength="240" labelKey="psePaymentForm.CHIP" path="CHIP" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
						</c:if>
						<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.DELINEACION}">
							<formElement:formInputBox  idKey="psePaymentForm.CUD" maxlength="240" labelKey="psePaymentForm.CUD" path="CUD" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
						</c:if>
						
						<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.PUBLICIDAD or
						 tipoDeImpuestoSeleccionado eq ControllerPseConstants.GASOLINA or tipoDeImpuestoSeleccionado eq ControllerPseConstants.ICA or
						 tipoDeImpuestoSeleccionado eq ControllerPseConstants.VEHICULAR}">
							<div class="row">
								<div class="col-xs-6">
									<formElement:formInputBox  idKey="psePaymentForm.noIdentificacion" maxlength="240" labelKey="psePaymentForm.noIdentificacion" path="noIdentificacion" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
								</div>
								<div class="col-xs-6">
									<formElement:formInputBox  idKey="psePaymentForm.DV" maxlength="240" labelKey="psePaymentForm.DV" path="DV" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}" />
								</div>
							</div>									
							<!--<formElement:formInputBox  idKey="psePaymentForm.tipoDeIdentificacion" maxlength="240" labelKey="psePaymentForm.tipoDeIdentificacion" path="tipoDeIdentificacion" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>-->
							<formElement:formSelectBox idKey="psePaymentForm.tipoDeIdentificacion" labelKey="psePaymentForm.tipoDeIdentificacion" path="tipoDeIdentificacion" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${tipoDeIdentificacion}" selectCSSClass="form-control" disabled="${debugMode}"/>
						</c:if>
						
						<c:if test = "${tipoDeImpuestoSeleccionado ne ControllerPseConstants.PREDIAL}">
							<formElement:formInputBox  idKey="psePaymentForm.fechaLimiteDePago" maxlength="240" labelKey="psePaymentForm.fechaLimiteDePago" path="fechaLimiteDePago" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
						</c:if>
						
						
						<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.ICA or tipoDeImpuestoSeleccionado eq ControllerPseConstants.PREDIAL}">
							<formElement:formSelectBox idKey="psePaymentForm.pagoAdicional" labelKey="psePaymentForm.pagoAdicional" path="pagoAdicional" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${pagoAdicional}" selectCSSClass="form-control" disabled="${disabled}"/>
						</c:if>
						
						<formElement:formSelectBox idKey="psePaymentForm.banco" labelKey="psePaymentForm.banco" path="banco" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${banco}" selectCSSClass="form-control" onchange="onChange()" disabled="${disabled}"/>
						<formElement:formInputBox  idKey="psePaymentForm.valorAPagar" maxlength="240" labelKey="psePaymentForm.valorAPagar" path="valorAPagar" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
						<formElement:formSelectBox idKey="psePaymentForm.tipoDeTarjeta" labelKey="psePaymentForm.tipoDeTarjeta" path="tipoDeTarjeta" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${tipoDeTarjeta}" selectCSSClass="form-control" onchange="onChange()" disabled="${disabled}"/>
					
					<c:if test = "${(tipoDeImpuestoSeleccionado eq ControllerPseConstants.GASOLINA || tipoDeImpuestoSeleccionado eq ControllerPseConstants.PUBLICIDAD) && !empty psePaymentForm.bankDateResponse }">
   						<formElement:formInputBox  idKey="psePaymentForm.bankDateResponse" maxlength="240" labelKey="psePaymentForm.bankDateResponse" path="bankDateResponse" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
   						<formElement:formInputBox  idKey="psePaymentForm.bankTimeResponse" maxlength="240" labelKey="psePaymentForm.bankDateResponse" path="bankDateResponse" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
					</c:if>
					</fieldset>
				</form:form>
				
				<form:form method="post" commandName="psePaymentForm" action="realizarPago">

					
					<form:hidden path="tipoDeImpuesto" value="${psePaymentForm.tipoDeImpuesto}"/>
					<form:hidden path="trazabilityCode" value="${psePaymentForm.trazabilityCode}"/>
					<form:hidden path="numeroDeReferencia" value="${psePaymentForm.numeroDeReferencia}"/>
					<form:hidden path="impuesto" value="${psePaymentForm.impuesto}"/>
					<form:hidden path="anoGravable" value="${psePaymentForm.anoGravable}"/>
					<form:hidden path="CHIP" value="${psePaymentForm.CHIP}"/>
					<form:hidden path="periodo" value="${psePaymentForm.periodo}"/>
					<form:hidden path="CUD" value="${psePaymentForm.CUD}"/>
					<form:hidden path="noIdentificacion" value="${psePaymentForm.noIdentificacion}"/>
					<form:hidden path="DV" value="${psePaymentForm.DV}"/>
					<form:hidden path="tipoDeIdentificacion" value="${psePaymentForm.tipoDeIdentificacion}"/>
					<form:hidden path="fechaLimiteDePago" value="${psePaymentForm.fechaLimiteDePago}"/>
					<form:hidden path="pagoAdicional" value="${psePaymentForm.pagoAdicional}"/>
					<form:hidden id="hiddenBanco" path="banco" value="${varBanco}"/>
					<form:hidden path="valorAPagar" value="${psePaymentForm.valorAPagar}"/>
					<form:hidden id="hiddenTipoDeTarjeta" path="tipoDeTarjeta" value="${varTipoDeTarjeta}"/>
					<form:hidden path="debugMode" value="${psePaymentForm.debugMode}"/>
					
					
					<form:hidden path="bankDateResponse" value="${psePaymentForm.bankDateResponse}"/>
					<form:hidden path="bankTimeResponse" value="${psePaymentForm.bankTimeResponse}"/>
					
					
					<form:hidden path="objPago" value="${psePaymentForm.objPago}"/>
				
					<div class="text-center">
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<c:if test = "${disabled eq false}">
								<div id="bottonPSE">
									<button class="btn" type="submit">
										<img src="${buttonImagePSE} " width="80" />
									</button>
									<button class="btn btn-secondary btn-lg" type="button" onclick="goBack()">
										<spring:theme code="impuestos.decGasolina.Pago.Regresar"/>
									</button>
									
								</div>
								</c:if>
							</ycommerce:testId>
						</div>
				</form:form>
				
				
				
				<form:form method="post" commandName="psePaymentForm" action="/sdhstorefront/es/impuestos/pagoEnLinea/pseResponse">

					
					<form:hidden path="tipoDeImpuesto" value="${psePaymentForm.tipoDeImpuesto}"/>
					<form:hidden path="trazabilityCode" value="${psePaymentForm.trazabilityCode}"/>
					<form:hidden path="numeroDeReferencia" value="${psePaymentForm.numeroDeReferencia}"/>
					<form:hidden path="impuesto" value="${psePaymentForm.impuesto}"/>
					<form:hidden path="anoGravable" value="${psePaymentForm.anoGravable}"/>
					<form:hidden path="CHIP" value="${psePaymentForm.CHIP}"/>
					<form:hidden path="periodo" value="${psePaymentForm.periodo}"/>
					<form:hidden path="CUD" value="${psePaymentForm.CUD}"/>
					<form:hidden path="noIdentificacion" value="${psePaymentForm.noIdentificacion}"/>
					<form:hidden path="DV" value="${psePaymentForm.DV}"/>
					<form:hidden path="tipoDeIdentificacion" value="${psePaymentForm.tipoDeIdentificacion}"/>
					<form:hidden path="fechaLimiteDePago" value="${psePaymentForm.fechaLimiteDePago}"/>
					<form:hidden path="pagoAdicional" value="${psePaymentForm.pagoAdicional}"/>
					<form:hidden id="hiddenBanco" path="banco" value="${varBanco}"/>
					<form:hidden path="valorAPagar" value="${psePaymentForm.valorAPagar}"/>
					<form:hidden id="hiddenTipoDeTarjeta" path="tipoDeTarjeta" value="${varTipoDeTarjeta}"/>
					<form:hidden path="debugMode" value="${psePaymentForm.debugMode}"/>
					
					
					<form:hidden path="bankDateResponse" value="${psePaymentForm.bankDateResponse}"/>
					<form:hidden path="bankTimeResponse" value="${psePaymentForm.bankTimeResponse}"/>
					
					
					<form:hidden path="objPago" value="${psePaymentForm.objPago}"/>
				
					<div class="text-center">
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<c:if test = "${disabled eq true}">
									<div id="continuar">
										<button class="btn btn-secondary btn-lg" type="submit">
											<spring:theme code="impuestos.Pago.PSE.imprimirComprobante"/>
										</button>
										<button class="btn btn-secondary btn-lg" type="button" onclick="window.location.href ='<c:url value='/' />';">
											<spring:theme code="impuestos.Pago.PSE.continuar"/>
										</button>
									</div>
								</c:if>
							</ycommerce:testId>
						</div>
				</form:form>
				
						
				
			</div>
		</div>
	</div>
</div>
 