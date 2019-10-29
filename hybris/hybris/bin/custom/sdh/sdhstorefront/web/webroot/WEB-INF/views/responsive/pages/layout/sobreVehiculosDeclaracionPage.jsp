<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sobreVehiculos"
	tagdir="/WEB-INF/tags/responsive/sobreVehiculos"%>
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>



<sobreVehiculos:sobreVehiculosDeclaraInicial />
<sobreVehiculos:sobreVehiculosDeclaraInfo />
<sobreVehiculos:sobreVehiculosDeclaraLiqui />
<%-- <sobreVehiculos:sobreVehiculosDeclaraFirma /> --%>
<c:url value='${redirectURL}' var="taxRedirection"/>
<firmas:generalFirmas firmaContribuyenteRedirection="${taxRedirection}"/>
<sobreVehiculos:sobreVehiculosDeclaraFirmas/>

<div id="dialogVehiculos" title="Vehiculos" >
	<div id="vehiculosDialogContent"></div>
</div>

<script>
	function goBack() {
		window.history.back();
	}
	
	window.onload = function() {
		debugger;
		var cosas = $(":input");
		var tam = cosas.length;
		if (false){
			for (var i = 0; i < tam; i++) {
				if((cosas[i].name != "firmInterFunct")&&(cosas[i].id != "firmCompleteName")&&(cosas[i].id != "lblcontribuyente_documentType")&&(cosas[i].id != "contribuyente_documentNumber")&&(cosas[i].id != "contribuyente_numBP")){
					var valor = cosas[i].value;
					if (valor == "") {
						cosas[i].value = "-";
					}
				}
			}
		}	
		 $(".loader").fadeOut("slow");
	}
	
	function pagarlinea() {

		var btnpaglinea = document.getElementById('action');
		btnpaglinea.disabled = false;

	}
	
	function presdec() {
		var btnpresdec = document.getElementById('duGeneraDeclaracionButton');
		btnpresdec.disabled = false;

	}
</script>


