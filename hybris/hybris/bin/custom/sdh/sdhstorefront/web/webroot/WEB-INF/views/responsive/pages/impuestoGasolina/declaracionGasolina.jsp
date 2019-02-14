<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sobreTasaGasolina"
	tagdir="/WEB-INF/tags/responsive/sobretasaGasolina"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="container">
	<sf:form action="${presentarDeclaracionUrl}"
		id="presentarDeclaracionUrl1" commandName="dataForm"
		method="POST">
		<sobreTasaGasolina:decGasolinaGen />
		<%-- 	<sobreTasaGasolina:decGasolinaInfDec /> --%>
		<sobreTasaGasolina:decGasolinaTotales />
		<sobreTasaGasolina:decGasolinaPagos />
		<sobreTasaGasolina:decGasolinaDatRev />
		<sobreTasaGasolina:decGasolinaInfFirma />
		<sobreTasaGasolina:decGasolinaPago />
	</sf:form>
</div>

<script>
	function borrarMenu(bPredial, bVehicular, bIca, bPublicidadExt, bSobreGasolina, bDelineacionUrbana) {
		debugger;
		var li_array = document.getElementsByTagName('li');
		var borrar_index;
		var submenu_index;
		var li_index;
		var a_index;
		var itext;
		
	    
		for( submenu_index = 1; submenu_index <= 6; submenu_index++ ) {
	    	for( li_index = 7; li_index <= 19; li_index++ ) {
	    		
	    		a_array = li_array[li_index].getElementsByTagName('a');
		    	
	    		for( a_index = 0; a_index < a_array.length; a_index++ ) {
		    		itext = a_array[a_index].getAttribute('href');
		    		
		    		if( ( (bDelineacionUrbana != "X") && (itext.includes("delineacion-urbana"))  ) ||
		    			( (bIca != "X") && (itext.includes("icareteica"))                        ) ||
		    			( (bPredial != "X") && (itext.includes("predialunificado"))              ) ||
		    			( (bPublicidadExt != "X") && (itext.includes("publicidadexterior"))      ) ||
		    			( (bVehicular != "X") && (itext.includes("sobrevehiculosautomotores"))   ) ||
		    		    ( (bSobreGasolina != "X") && (itext.includes("sobretasa-gasolina"))      )
		    		  )			
		    		{
		    			borrar_index = true;
		    			break;
		    		}
		    		else{
		    			borrar_index = false;
		    			break;
		    		}
			    }
	    		
	    		if(borrar_index){
	    			li_array[li_index].remove();
	    		}
	    	}
		}	
	}	
	
	borrarMenu("${dataForm.bPredial}", "${dataForm.bVehicular}", "${dataForm.bIca}", "${dataForm.bPublicidadExt}", "${dataForm.bSobreGasolina}", "${dataForm.bDelineacionUrbana}");	
</script>