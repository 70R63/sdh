<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE11"/>


<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<div class="row" >
    <script>
	
	window.onload = function() {
		var cosas = $(":input");
		var tam = cosas.length;
		if (false){
			for (var i = 0; i < tam; i++) {
				var valor = cosas[i].value;
				if (valor == "") {
					cosas[i].value = "-";

				}
			}
		}
		  $(".loader").fadeOut("slow");
	}
		function downloadPDF(pdf) {
			    const linkSource = 'data:application/pdf;base64,' + pdf;
			    const downloadLink = document.createElement("a");
			    const fileName = "Certificación_RIT.pdf";
		
			    downloadLink.href = linkSource;
			    downloadLink.download = fileName;
			    downloadLink.click();
			
		}
		
		
		downloadPDF('${miRitCertificacionForm.rit.stringRIT}');
	</script>
	
	
    
	<div class="container">
	 	<div class="headline">
			<h3>
				<span tabindex="0" ><spring:theme code="mirit.certificacion.titulo" /></span>
				<c:if test="${not empty miRitCertificacionForm.rit.stringRIT}">
				  <iframe width='100%' height='600' width='15' src=' data:application/pdf;/Certificación RIT#zoom=100&view=fitH&;base64,${miRitCertificacionForm.rit.stringRIT}'>	</iframe>
				</c:if>  
			</h3>
		</div>
	</div>
</div>


