<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="jquery.min.js"></script>

<spring:htmlEscape defaultHtmlEscape="true" />

<%-- --disabled:${disabled}-- --%>
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

<%-- --debugMode:${debugMode}-- --%>
<%-- --disabled:${disabled}-- --%>
<div class="row" >
	<div class="col-md-6 col-md-offset-3">
		<div class="item_container_holder ">
			<div class="forgotten-password item_container ">
				
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
										<button class="btn btn-secondary btn-lg" type="button" onclick="msgImpresion('<c:url value='/' />')">
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

<script>
	function msgImpresion(url){
		alert("La impresion de certificado se realiza con usuario del contribuyente o usuario NIT usando el menu CONSULTAS opcion CERTIFICACION PAGO");
		window.location = url;		
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

	downloadPDF('${imprimePagoResponse.stringPDF}');
</script>