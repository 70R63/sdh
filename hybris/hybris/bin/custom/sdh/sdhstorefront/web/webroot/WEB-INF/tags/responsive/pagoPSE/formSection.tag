<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="controllerPseConstants" class="de.hybris.sdh.core.constants.ControllerPseConstants"/>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
<script src="jquery.min.js"></script>
<script>
	function onChange() {
		var varBanco = document.getElementById("psePaymentForm.banco").value;
		var varTipoDeTarjeta = document.getElementById("psePaymentForm.tipoDeTarjeta").value;

		document.getElementById("hiddenBanco").value = varBanco;
		document.getElementById("hiddenTipoDeTarjeta").value = varTipoDeTarjeta;

	}

	function formSubmition(buttonType){	
		//document.getElementById("hiddenOnlinePaymentProvider").value = buttonType;
		var form = document.getElementById("psePaymentFormSubmition");
		var paymentMethodSelect = document.getElementById("psePaymentForm.tipoDeTarjeta").value;
		var bankSelect = document.getElementById("psePaymentForm.banco").value;

		if(paymentMethodSelect == "0" || bankSelect == "0"){
		    alert("Seleccione banco o metodo de pago");
		}else{
		    form.submit();
		}
	}
	
	function downloadPDF(pdf) {
		debugger;
		if (pdf){
			const linkSource = 'data:application/pdf;base64,' + pdf;
		    const downloadLink = document.createElement("a");
		    const fileName = "Certificaci�n_Pago.pdf";
	
		    downloadLink.href = linkSource;
		    downloadLink.download = fileName;
		    downloadLink.click();
		}    
	}

	function sdhOnChange(selectPaymentMethod){
	    var url = window.location.href;
	    url = url.replace("impuestos/pagoEnLinea/form", "onlinePaymentMatcher/getBanks");

	    var paymentMethod = document.getElementById("psePaymentForm.tipoDeTarjeta").value;
	    var tax = document.getElementById("psePaymentForm.tipoDeImpuesto").value;

        var bankSelect = document.getElementById("psePaymentForm.banco");
        while (bankSelect.hasChildNodes()) {
          bankSelect.removeChild(bankSelect.firstChild);
        }

        var option = document.createElement('option');
        option.value = 00;
        option.text = "------ Seleccionar ------";
        option.innerHTML = "------ Seleccionar ------";
        bankSelect.appendChild(option);

        $.ajax({
            url     : url + '?tax='+tax+'&paymentMethod='+paymentMethod,
            method  : 'GET',
            success : function(resultText){
                $.each(resultText,function(i,v){
                    var option = document.createElement('option');
                    option.value = v.code;
                    option.text = v.description;
                    option.innerHTML = v.description;
                    bankSelect.appendChild(option);
                 });
            },
            error : function(jqXHR, exception){
                console.log('Error occured!!');
            }
        });
    }

	downloadPDF('${imprimePagoResponse.stringPDF}');
</script>



<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var = "tipoDeImpuestoSeleccionado" scope = "session" value = "${psePaymentForm.tipoDeImpuesto}"/>
<%-- <c:set var = "buttonImagePSE" scope = "session" value = "https://jumpseller.co/images/support/pse/logopse.png"/> --%>
<c:set var = "buttonImagePSE" scope = "session" value = "http://blog.achcolombia.com.co/wp-content/themes/ach/img/logo.svg"/>
<c:set var = "buttonImageCRE" scope = "session" value = "https://acis.org.co/portal/sites/default/files/5907822af25d3c0dd184dc45_credibanco.png"/>
<c:set var = "buttonImageCredibanco" scope = "session" value = "https://acis.org.co/portal/sites/default/files/5907822af25d3c0dd184dc45_credibanco.png"/>
<c:set var = "buttonImageBBVA" scope = "session" value = "https://pbs.twimg.com/profile_images/907185208549572608/Hn65NsHV_400x400.jpg"/>
<c:set var = "buttonImageDAVIVIENDA" scope = "session" value = "https://d31dn7nfpuwjnm.cloudfront.net/images/valoraciones/0029/4616/davivienda.png"/>

--disableFields:${disableFields}--
--disabled:${disabled}--
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

--flagReintetarPago:${flagReintetarPago}--
--disableFields:${disableFields}--
--disabled:${disabled}--
--debugMode:${debugMode}--
--flagSuccessView:${flagSuccessView}--
<div class="row" >
	<div class="col-md-6 col-md-offset-3">
		<div class="item_container_holder ">
			<div class="forgotten-password item_container ">
				<c:url var="action" value="/register/validateAnswers"/> 
			
				<form:form method="post" commandName="psePaymentForm" action="">
				<div class="row" >
				--psePaymentForm.numeroDeReferencia:${psePaymentForm.numeroDeReferencia}--
				</div>
					<fieldset>					
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
											tipoDeImpuestoSeleccionado eq ControllerPseConstants.VEHICULAR}">
								<div class="col-xs-6">
									<formElement:formSelectBox idKey="psePaymentForm.periodo" labelKey="psePaymentForm.periodo" path="periodo" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${periodo}" selectCSSClass="form-control" disabled="${debugMode}"/>
								</div>
							</c:if>
						</div>	
						
						<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.PREDIAL}">						
							<formElement:formInputBox  idKey="psePaymentForm.CHIP" maxlength="240" labelKey="psePaymentForm.CHIP" path="CHIP" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
						</c:if>
						<c:if test = "${tipoDeImpuestoSeleccionado eq ControllerPseConstants.DELINEACION}">
							<formElement:formInputBox  idKey="psePaymentForm.CUD" maxlength="240" labelKey="psePaymentForm.CDU" path="CUD" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
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
						
						<formElement:formInputBox  idKey="psePaymentForm.valorAPagar" maxlength="240" labelKey="psePaymentForm.valorAPagar" path="valorAPagar" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
						<formElement:sdhFormSelectBox idKey="psePaymentForm.tipoDeTarjeta" labelKey="psePaymentForm.tipoDeTarjeta" path="tipoDeTarjeta" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${paymentMethodList}" selectCSSClass="form-control" onchange="sdhOnChange(this)"/>
						<formElement:formSelectBox idKey="psePaymentForm.banco" labelKey="psePaymentForm.banco" path="banco" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${banco}" selectCSSClass="form-control" onchange="onChange()"/>


					<c:if test = "${(tipoDeImpuestoSeleccionado eq ControllerPseConstants.GASOLINA || tipoDeImpuestoSeleccionado eq ControllerPseConstants.PUBLICIDAD) && !empty psePaymentForm.bankDateResponse }">
   						<formElement:formInputBox  idKey="psePaymentForm.bankDateResponse" maxlength="240" labelKey="psePaymentForm.bankDateResponse" path="bankDateResponse" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
   						<formElement:formInputBox  idKey="psePaymentForm.bankTimeResponse" maxlength="240" labelKey="psePaymentForm.bankDateResponse" path="bankDateResponse" inputCSS="text" mandatory="true" tabindex="0" disabled="${debugMode}"/>
					</c:if>
					</fieldset>
				</form:form>

				<form:form id="psePaymentFormSubmition" method="post" commandName="psePaymentForm" action="realizarPago">					
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
					<form:hidden id="hiddenOnlinePaymentProvider" path="onlinePaymentProvider" value=""/>				
					<form:hidden path="objPago" value="${psePaymentForm.objPago}"/>			
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<c:if test = "${disabled eq false or not empty flagReintetarPago}">
									<div id="PSE" class="text-center">

									    <c:choose>
                                            <c:when test="${empty psePaymentForm.numeroDeReferencia}">
                                                <button id="buttonPSE" class="btn btn-secondary btn-lg" type="button" onclick="formSubmition()" disabled>
                                                    Pagar
                                                </button>
                                            </c:when>
                                            <c:otherwise>
                                                <button id="buttonPSE" class="btn btn-secondary btn-lg" type="button" onclick="formSubmition()" >
                                                    Pagar
                                                </button>
                                            </c:otherwise>
                                        </c:choose>


										<button class="btn btn-secondary btn-lg" type="button" onclick="goBack()">
											<spring:theme code="impuestos.decGasolina.Pago.Regresar"/>
										</button>
									</div>
								</c:if>
							</ycommerce:testId>
						
				</form:form>
				
				

<%-- 				<form:form method="post" commandName="psePaymentForm" action="/sdhstorefront/es/impuestos/pagoEnLinea/pseResponse">		 --%>
<%-- 					<form:hidden path="tipoDeImpuesto" value="${psePaymentForm.tipoDeImpuesto}"/> --%>
<%-- 					<form:hidden path="trazabilityCode" value="${psePaymentForm.trazabilityCode}"/> --%>
<%-- 					<form:hidden path="numeroDeReferencia" value="${psePaymentForm.numeroDeReferencia}"/> --%>
<%-- 					<form:hidden path="impuesto" value="${psePaymentForm.impuesto}"/> --%>
<%-- 					<form:hidden path="anoGravable" value="${psePaymentForm.anoGravable}"/> --%>
<%-- 					<form:hidden path="CHIP" value="${psePaymentForm.CHIP}"/> --%>
<%-- 					<form:hidden path="periodo" value="${psePaymentForm.periodo}"/> --%>
<%-- 					<form:hidden path="CUD" value="${psePaymentForm.CUD}"/> --%>
<%-- 					<form:hidden path="noIdentificacion" value="${psePaymentForm.noIdentificacion}"/> --%>
<%-- 					<form:hidden path="DV" value="${psePaymentForm.DV}"/> --%>
<%-- 					<form:hidden path="tipoDeIdentificacion" value="${psePaymentForm.tipoDeIdentificacion}"/> --%>
<%-- 					<form:hidden path="fechaLimiteDePago" value="${psePaymentForm.fechaLimiteDePago}"/> --%>
<%-- 					<form:hidden path="pagoAdicional" value="${psePaymentForm.pagoAdicional}"/> --%>
<%-- 					<form:hidden id="hiddenBanco" path="banco" value="${varBanco}"/> --%>
<%-- 					<form:hidden path="valorAPagar" value="${psePaymentForm.valorAPagar}"/> --%>
<%-- 					<form:hidden id="hiddenTipoDeTarjeta" path="tipoDeTarjeta" value="${varTipoDeTarjeta}"/> --%>
<%-- 					<form:hidden path="debugMode" value="${psePaymentForm.debugMode}"/>		 --%>
<%-- 					<form:hidden path="bankDateResponse" value="${psePaymentForm.bankDateResponse}"/> --%>
<%-- 					<form:hidden path="bankTimeResponse" value="${psePaymentForm.bankTimeResponse}"/>			 --%>
<%-- 					<form:hidden path="objPago" value="${psePaymentForm.objPago}"/> --%>
				
<!-- 					<div class="text-center"> -->
<%-- 							<ycommerce:testId code="login_forgotPasswordSubmit_button"> --%>
<%-- 								<c:if test = "${disabled eq true}"> --%>
<!-- 									<div id="continuar">										 -->
<!-- 										<button class="btn btn-secondary btn-lg" type="submit"> -->
<%-- 											<spring:theme code="impuestos.Pago.PSE.imprimirComprobante"/> --%>
<!-- 										</button> -->
<%-- 										<button class="btn btn-secondary btn-lg" type="button" onclick="window.location.href ='<c:url value='/' />';"> --%>
<%-- 											<spring:theme code="impuestos.Pago.PSE.continuar"/> --%>
<!-- 										</button> -->
<!-- 									</div> -->
<%-- 								</c:if> --%>
<%-- 							</ycommerce:testId> --%>
<!-- 						</div> -->
<%-- 				</form:form> --%>
				
						
				
			</div>
		</div>
	</div>
</div>

