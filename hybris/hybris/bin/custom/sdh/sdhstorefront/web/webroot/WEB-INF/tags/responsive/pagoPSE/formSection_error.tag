<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="controllerPseConstants" class="de.hybris.sdh.core.constants.ControllerPseConstants"/>

<script src="jquery.min.js"></script>

<!-- 
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
	    var n = url.indexOf("impuestos");
	    url = url.substring(0,n);
	    url = url.concat("onlinePaymentMatcher/getBanks")
	    //url = url.replace("impuestos/pagoEnLinea/form", "onlinePaymentMatcher/getBanks");

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
 -->


<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var = "tipoDeImpuestoSeleccionado" scope = "session" value = "${psePaymentForm.tipoDeImpuesto}"/>
<c:set var = "buttonImagePSE" scope = "session" value = "http://blog.achcolombia.com.co/wp-content/themes/ach/img/logo.svg"/>
<c:set var = "buttonImageCRE" scope = "session" value = "https://acis.org.co/portal/sites/default/files/5907822af25d3c0dd184dc45_credibanco.png"/>
<c:set var = "buttonImageCredibanco" scope = "session" value = "https://acis.org.co/portal/sites/default/files/5907822af25d3c0dd184dc45_credibanco.png"/>
<c:set var = "buttonImageBBVA" scope = "session" value = "https://pbs.twimg.com/profile_images/907185208549572608/Hn65NsHV_400x400.jpg"/>
<c:set var = "buttonImageDAVIVIENDA" scope = "session" value = "https://d31dn7nfpuwjnm.cloudfront.net/images/valoraciones/0029/4616/davivienda.png"/>

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
									
				<ycommerce:testId code="login_forgotPasswordSubmit_button">
					<c:choose>
						<c:when test= "${disabled eq false or not empty flagReintetarPago}">
							<div id="PSE" class="text-center">

							    <button id="" class="btn btn-secondary btn-lg" type="button" onclick="location.href='/sdhstorefront/es/contribuyentes/consultas/obligaciones';">
	                                Obligaciones Pendientes 
	                            </button>
	
								<button class="btn btn-secondary btn-lg" type="button" onclick="goBack()">
									<spring:theme code="impuestos.decGasolina.Pago.Regresar"/>
								</button>
							</div>
						</c:when>
						<c:otherwise>
  							<div id="PSE" class="text-center">							   
								<button class="btn btn-secondary btn-lg" type="button" onclick="window.location.href ='<c:url value='/' />';">
									<spring:theme code="impuestos.decGasolina.Pago.Regresar"/>
								</button>
							</div>
  						</c:otherwise>
					</c:choose>	 
					
					<!-- 
					<c:if test = "${disabled eq false or not empty flagReintetarPago}">
						<div id="PSE" class="text-center">

						    <button id="" class="btn btn-secondary btn-lg" type="button" onclick="location.href='/sdhstorefront/es/contribuyentes/consultas/obligaciones';">
                                Obligaciones Pendientes 
                            </button>

							<button class="btn btn-secondary btn-lg" type="button" onclick="goBack()">
								<spring:theme code="impuestos.decGasolina.Pago.Regresar"/>
							</button>
						</div>
					</c:if>
					 -->
				</ycommerce:testId>
			</div>
		</div>
	</div>
</div>

